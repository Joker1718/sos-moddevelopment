/*     */ package game.boosting.superb;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BHoverer;
/*     */ import game.boosting.BUtil;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.save.Savable;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SuperBoostable<T extends SuperBoostableObj>
/*     */ {
/*     */   private int[] saveOrder;
/*  27 */   final KeyMap<SuperSpec.SuperSpecImp<T>> map = new KeyMap();
/*  28 */   final ArrayListGrower<SuperSpec.SuperSpecImp<T>> ups = new ArrayListGrower();
/*  29 */   final ArrayListGrower<SuperSpec<T>> all = new ArrayListGrower();
/*     */   public final Boostable bo;
/*     */   
/*     */   public SuperBoostable(final Boostable bo) {
/*  33 */     this.bo = bo;
/*     */     
/*  35 */     GAME.saver().addSpecialSaver(new Savable("BOOST_" + bo.key)
/*     */         {
/*     */           protected void save(FilePutter file)
/*     */           {
/*  39 */             file.i(SuperBoostable.this.ups.size());
/*  40 */             for (SuperSpec.SuperSpecImp<T> s : (Iterable<SuperSpec.SuperSpecImp<T>>)SuperBoostable.this.ups) {
/*  41 */               file.chars(s.key);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/*  47 */             int am = file.i();
/*  48 */             SuperBoostable.this.saveOrder = Alloc.ii(am); int i;
/*  49 */             for (i = 0; i < SuperBoostable.this.saveOrder.length; i++)
/*  50 */               SuperBoostable.this.saveOrder[i] = -1; 
/*  51 */             for (i = 0; i < am; i++) {
/*  52 */               String k = file.chars();
/*  53 */               if (SuperBoostable.this.map.containsKey(k)) {
/*  54 */                 SuperBoostable.this.saveOrder[i] = ((SuperSpec.SuperSpecImp)SuperBoostable.this.map.get(k)).index;
/*     */               }
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  61 */     GAME.addOnViewInit(new ACTION() {
/*  62 */           SuperBoostable<T> self = SuperBoostable.this;
/*     */           
/*     */           public void exe() {
/*  65 */             for (Booster b : bo.all());
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SuperData makeData() {
/*  78 */     return new SuperData(this);
/*     */   }
/*     */   
/*     */   int[] saveOrder() {
/*  82 */     if (this.saveOrder == null) {
/*  83 */       this.saveOrder = Alloc.ii(this.ups.size());
/*  84 */       for (int i = 0; i < this.saveOrder.length; i++)
/*  85 */         this.saveOrder[i] = i; 
/*     */     } 
/*  87 */     return this.saveOrder;
/*     */   }
/*     */   
/*     */   public void update(T t, double ds) {
/*  91 */     for (int i = 0; i < this.ups.size(); i++) {
/*  92 */       SuperSpec.SuperSpecImp<T> spec = (SuperSpec.SuperSpecImp<T>)this.ups.get(i);
/*  93 */       spec.update(t, ds);
/*     */     } 
/*     */   }
/*     */   
/*     */   public LIST<SuperSpec<T>> all() {
/*  98 */     return (LIST<SuperSpec<T>>)this.all;
/*     */   }
/*     */   
/*     */   public LIST<SuperSpec.SuperSpecImp<T>> imps() {
/* 102 */     return (LIST<SuperSpec.SuperSpecImp<T>>)this.ups;
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, T roy) {
/* 106 */     BHoverer.hover(box, (LIST)this.all, roy, Dic.¤¤Boosts, this.bo.baseValue, false);
/*     */   }
/*     */   
/*     */   public void hoverDetailed(GUI_BOX box, T roy) {
/* 110 */     BHoverer.hoverDetailed(box, (LIST)this.all, roy, Dic.¤¤Boosts, this.bo.baseValue, false);
/*     */   }
/*     */   
/*     */   public double get(T bo) {
/* 114 */     return BUtil.value((LIST)this.all, bo, this.bo.baseValue, 1.0D, -100.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperBoostable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */