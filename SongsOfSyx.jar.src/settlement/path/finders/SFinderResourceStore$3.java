/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.misc.util.TILE_STORAGE;
/*    */ import settlement.path.path.SPath;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends TestPath
/*    */ {
/*    */   null(CharSequence $anonymous0, SFINDER $anonymous1) {
/* 24 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   protected void place(int sx, int sy, SPath p) {
/* 27 */     TILE_STORAGE j = SFinderResourceStore.this.findAny(sx, sy, 2147483647);
/* 28 */     if (j != null) {
/* 29 */       LOG.ln("" + j.x() + " " + j.x());
/* 30 */       p.request(sx, sy, (COORDINATE)j);
/*    */     } else {
/* 32 */       LOG.ln("Nay");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResourceStore$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */