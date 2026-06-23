/*     */ package view.sett;
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
/*     */ class null
/*     */   extends Savable
/*     */ {
/*     */   null(String $anonymous0) {
/*  93 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/*  97 */     SettView.this.window.saver.save(file);
/*  98 */     SettView.this.right.save(file);
/*  99 */     file.bool(SettView.this.hasPlaced);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 104 */     SettView.this.window.saver.load(file);
/* 105 */     SettView.this.right.load(file);
/* 106 */     SettView.this.uiManager.clear();
/* 107 */     SettView.this.hasPlaced = file.bool();
/* 108 */     if (!SettView.this.hasPlaced)
/* 109 */       SettView.this.start.activate(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\SettView$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */