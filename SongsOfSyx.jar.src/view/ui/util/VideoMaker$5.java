/*     */ package view.ui.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.VIDEO_MAKER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import util.gui.misc.GButt;
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 131 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 135 */     VideoMaker.this.start.rec.moveX1Y1(VideoMaker.this.start.x1.get(), VideoMaker.this.start.y1.get()).setDim(VideoMaker.this.start.w.get(), VideoMaker.this.start.h.get());
/* 136 */     VideoMaker.this.end.rec.moveX1Y1(VideoMaker.this.end.x1.get(), VideoMaker.this.end.y1.get()).setDim(VideoMaker.this.end.w.get(), VideoMaker.this.end.h.get());
/*     */     
/* 138 */     String f = String.valueOf((PATHS.local()).VIDEO.get().toAbsolutePath()) + String.valueOf((PATHS.local()).VIDEO.get().toAbsolutePath()) + "frame";
/* 139 */     SPRITES.loader().init();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\VideoMaker$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */