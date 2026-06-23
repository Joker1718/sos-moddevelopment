/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import game.save.Savable;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
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
/*     */   extends Savable
/*     */ {
/*     */   null(String $anonymous0) {
/*  97 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/* 101 */     UIMinimapSettConfigExt.this.showAnimals.save(file);
/* 102 */     UIMinimapSettConfigExt.this.showGrowable.save(file);
/* 103 */     UIMinimapSettConfigExt.this.showMinerals.save(file);
/* 104 */     UIMinimapSettConfigExt.this.showDiv.save(file);
/* 105 */     UIMinimapSettConfigExt.this.bitsHType.save(file);
/* 106 */     UIMinimapSettConfigExt.this.bitsRooms.save(file);
/* 107 */     UIMinimapSettConfigExt.this.bitsEmployed.save(file);
/* 108 */     UIMinimapSettConfigExt.this.bRaces.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 113 */     UIMinimapSettConfigExt.this.showAnimals.load(file);
/* 114 */     UIMinimapSettConfigExt.this.showGrowable.load(file);
/* 115 */     UIMinimapSettConfigExt.this.showMinerals.load(file);
/* 116 */     UIMinimapSettConfigExt.this.showDiv.load(file);
/* 117 */     UIMinimapSettConfigExt.this.bitsHType.load(file);
/* 118 */     UIMinimapSettConfigExt.this.bitsRooms.load(file);
/* 119 */     UIMinimapSettConfigExt.this.bitsEmployed.load(file);
/* 120 */     UIMinimapSettConfigExt.this.bRaces.load(file);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapSettConfigExt$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */