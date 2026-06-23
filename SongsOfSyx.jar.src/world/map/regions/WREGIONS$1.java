/*     */ package world.map.regions;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
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
/*  72 */     WREGIONS.this.pmap.save(file);
/*  73 */     for (Region a : WREGIONS.this.areas) {
/*  74 */       a.save(file);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  81 */     WREGIONS.this.pmap.load(file);
/*  82 */     for (Region a : WREGIONS.this.areas) {
/*  83 */       a.load(file);
/*     */     }
/*  85 */     WREGIONS.this.dirty = true;
/*  86 */     WREGIONS.this.init();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  91 */     WREGIONS.this.pmap.clear();
/*  92 */     for (Region r : WORLD.REGIONS().all()) {
/*  93 */       r.clear();
/*     */     }
/*  95 */     WREGIONS.this.active.clearSloppy();
/*  96 */     WREGIONS.this.active.add((Iterable)WREGIONS.this.areas);
/*  97 */     WORLD.MINIMAP().repaint();
/*  98 */     WREGIONS.this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 103 */     return (LIST<PLACABLE>)new Placer();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(ACTION loadPrint) {
/* 109 */     validateInit(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validateInit(WORLD.WorldError error) {
/* 115 */     WREGIONS.this.init();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\WREGIONS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */