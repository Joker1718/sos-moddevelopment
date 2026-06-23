/*     */ package game;
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
/*     */ class null
/*     */   extends Savable
/*     */ {
/*     */   null(String $anonymous0) {
/*  92 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  97 */     file.bool(GAME.game.achieving);
/*  98 */     GAME.SPEED.save(file);
/*  99 */     file.i(GAME.updateI());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 106 */     GAME.this.achieving = file.bool();
/*     */ 
/*     */     
/* 109 */     GAME.SPEED.load(file);
/*     */     
/* 111 */     GAME.this.updateI = file.i();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\GAME$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */