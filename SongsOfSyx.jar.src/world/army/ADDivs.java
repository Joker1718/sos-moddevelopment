/*     */ package world.army;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.bit.BitsLong;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.Dic;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ public final class ADDivs
/*     */   implements SAVABLE
/*     */ {
/*  17 */   private final long[] divs = new long[(Config.battle()).DIVISIONS_PER_ARMY];
/*     */   final long[] data;
/*     */   private int divI;
/*  20 */   public final Str name = new Str(24);
/*     */   
/*     */   private final WArmy aa;
/*  23 */   static final BitsLong BType = new BitsLong(-72057594037927936L);
/*     */ 
/*     */   
/*     */   public ADDivs(WArmy e) {
/*  27 */     this.data = new long[(AD.iinit()).dataA.longCount()];
/*  28 */     this.aa = e;
/*  29 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  35 */     file.ls(this.divs);
/*  36 */     file.i(this.divI);
/*  37 */     (AD.iinit()).dataA.saver().save(this.aa, file);
/*  38 */     this.name.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  43 */     file.ls(this.divs);
/*  44 */     this.divI = file.i();
/*  45 */     (AD.iinit()).dataA.loader().load(this.aa, file);
/*  46 */     this.name.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  51 */     this.divI = 0;
/*  52 */     this.name.clear().add(Dic.¤¤Army);
/*  53 */     Arrays.fill(this.data, 0L);
/*     */   }
/*     */   
/*     */   public boolean canAdd() {
/*  57 */     return (this.divI < this.divs.length);
/*     */   }
/*     */   
/*     */   public int size() {
/*  61 */     return this.divI;
/*     */   }
/*     */   
/*     */   public ADDiv get(int i) {
/*  65 */     if (i < 0 || i >= size()) {
/*  66 */       return null;
/*     */     }
/*     */     
/*  69 */     switch (BType.get(this.divs[i])) { case 0:
/*  70 */         return AD.regional().get((int)this.divs[i] & 0xFFFFFFFF);
/*  71 */       case 1: return AD.cityDivs().get(this.divs[i]);
/*  72 */       case 2: return AD.mercenaries().get(this.divs[i]); }
/*  73 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void insert(int after, int insert) {
/*  78 */     if (after < 0 || after >= size() || insert < 0 || insert >= size())
/*  79 */       throw new RuntimeException("" + after + " " + after); 
/*  80 */     if (after == insert)
/*     */       return; 
/*  82 */     long di = this.divs[insert]; int i;
/*  83 */     for (i = insert; i < size() - 1; i++) {
/*  84 */       this.divs[i] = this.divs[i + 1];
/*     */     }
/*  86 */     if (after > insert) {
/*  87 */       after--;
/*     */     }
/*  89 */     for (i = size() - 1; i > after; i--) {
/*  90 */       this.divs[i] = this.divs[i - 1];
/*     */     }
/*  92 */     this.divs[after] = di;
/*     */   }
/*     */   
/*     */   void add(ADDiv div) {
/*  96 */     int i = this.divI;
/*  97 */     long d = BType.set(0L, div.type());
/*  98 */     d |= div.index;
/*  99 */     this.divs[i] = d;
/* 100 */     this.divI++;
/*     */   }
/*     */   
/*     */   void remove(ADDiv div) {
/* 104 */     for (int di = 0; di < this.divI; di++) {
/* 105 */       if (get(di) == div) {
/* 106 */         for (int ii = di; ii < this.divI - 1; ii++)
/* 107 */           this.divs[ii] = this.divs[ii + 1]; 
/* 108 */         this.divI--;
/*     */         return;
/*     */       } 
/*     */     } 
/* 112 */     throw new RuntimeException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADDivs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */