/*     */ package world.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends WORLD.WorldResourceManager
/*     */ {
/*     */   public void save(FilePutter file) {
/*  65 */     for (WEntityConstructor<?> c : WEntities.this.constructors)
/*  66 */       c.save(file); 
/*  67 */     file.d(WEntities.this.slowUp);
/*  68 */     file.i(WEntities.this.fast.size() + WEntities.this.slow.size());
/*  69 */     for (WEntity e : WEntities.this.fast) {
/*  70 */       file.i((e.constructor()).index);
/*  71 */       e.save(file);
/*  72 */       e.hitBox.save(file);
/*     */     } 
/*  74 */     for (WEntity e : WEntities.this.slow) {
/*  75 */       file.i((e.constructor()).index);
/*  76 */       e.save(file);
/*  77 */       e.hitBox.save(file);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  83 */     for (WEntityConstructor<?> c : WEntities.this.constructors)
/*  84 */       c.load(file); 
/*  85 */     WEntities.this.fast.clear();
/*  86 */     WEntities.this.slow.clear();
/*  87 */     WEntities.this.map.clear();
/*  88 */     WEntities.this.slowUp = file.d();
/*  89 */     int am = file.i();
/*     */     
/*  91 */     for (int i = 0; i < am; i++) {
/*  92 */       WEntityConstructor<?> c = (WEntityConstructor)WEntities.this.constructors.get(file.i());
/*  93 */       WEntity e = (WEntity)c.create();
/*  94 */       e = e.load(file);
/*  95 */       e.hitBox.load(file);
/*  96 */       WEntities.this.clear(e);
/*  97 */       e.index = c.fast ? WEntities.this.fast.add(e) : WEntities.this.slow.add(e);
/*  98 */       e.renderNext = null;
/*  99 */       e.regionNext = null;
/* 100 */       e.regionI = -1;
/* 101 */       WEntities.this.map.add(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 107 */     for (WEntityConstructor<?> c : WEntities.this.constructors)
/* 108 */       c.clear(); 
/* 109 */     WEntities.this.fast.clear();
/* 110 */     WEntities.this.slow.clear();
/* 111 */     WEntities.this.map.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void generate(ACTION loadPrint) {
/* 116 */     clear();
/* 117 */     loadPrint.exe();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 123 */     ArrayListGrower<PLACABLE> res = new ArrayListGrower();
/* 124 */     res.add((Iterable)new Placers(WEntities.this.havens.types));
/* 125 */     return (LIST<PLACABLE>)res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\WEntities$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */