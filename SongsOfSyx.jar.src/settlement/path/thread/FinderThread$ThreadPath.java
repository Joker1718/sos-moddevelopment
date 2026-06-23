/*     */ package settlement.path.thread;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathGame;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThreadPath
/*     */ {
/*     */   private volatile byte status;
/* 164 */   public final PathGame.PathFancy path = new PathGame.PathFancy(256);
/*     */   
/*     */   short sx;
/*     */   
/*     */   short sy;
/*     */   short dx;
/*     */   
/*     */   public boolean isProcessed(int sx, int sy, int dx, int dy) {
/* 172 */     if (this.sx == sx && this.sy == sy && this.dx == dx && this.dy == dy)
/* 173 */       return (this.status > 1); 
/* 174 */     return false;
/*     */   }
/*     */   short dy; boolean full; public volatile short destX; public volatile short destY;
/*     */   public boolean isBeingProcessed() {
/* 178 */     return (this.status >= 1);
/*     */   }
/*     */   
/*     */   public boolean isSuccess() {
/* 182 */     return (this.status == 3);
/*     */   }
/*     */   
/*     */   public void debug(int sx, int sy, int dx, int dy) {
/* 186 */     if (this.status > 1)
/* 187 */       LOG.ln("" + this.status + " " + this.status + " " + this.sx - sx + " " + this.sy - sy + " " + this.dx - dx); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\thread\FinderThread$ThreadPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */