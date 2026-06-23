/*     */ package world.map.landmark;
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
/*  88 */   private final PlacerOverlay overlay = new PlacerOverlay();
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  92 */     for (WorldLandmark a : WorldLandmarks.this.areas) {
/*  93 */       if (a != null)
/*  94 */         a.save(file); 
/*  95 */     }  WorldLandmarks.this.mapID.save(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 101 */     for (WorldLandmark a : WorldLandmarks.this.areas) {
/* 102 */       if (a != null)
/* 103 */         a.load(file); 
/* 104 */     }  WorldLandmarks.this.mapID.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 109 */     WorldLandmarks.this.mapID.setAll(0);
/* 110 */     for (WorldLandmark a : WorldLandmarks.this.areas) {
/* 111 */       if (a != null) {
/* 112 */         a.clear();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(ACTION loadPrint) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void validateInit(WORLD.WorldError error) {}
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 127 */     return (LIST<PLACABLE>)new Placers(WorldLandmarks.this, this.overlay);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addDebugView() {
/* 132 */     this.overlay.add();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\WorldLandmarks$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */