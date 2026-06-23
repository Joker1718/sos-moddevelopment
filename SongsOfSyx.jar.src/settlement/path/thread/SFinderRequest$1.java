/*    */ package settlement.path.thread;
/*    */ 
/*    */ import snake2d.PathTile;
/*    */ import snake2d.PathUtilOnline;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements FinderThread.ThreadPathJob
/*    */ {
/*    */   public boolean doJob(PathUtilOnline p, SPathFinderThread fin, FinderThread.ThreadPath pp) {
/* 26 */     PathTile t = SFinderRequest.this.find(pp.sx, pp.sy, p);
/* 27 */     if (t != null) {
/*    */       
/* 29 */       pp.path.set(t);
/* 30 */       pp.destX = (short)t.x();
/* 31 */       pp.destY = (short)t.y();
/* 32 */       return true;
/*    */     } 
/* 34 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\thread\SFinderRequest$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */