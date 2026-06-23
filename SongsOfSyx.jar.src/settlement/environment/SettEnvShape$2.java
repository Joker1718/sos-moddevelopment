/*    */ package settlement.environment;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends SettEnvShape.Type
/*    */ {
/*    */   null(String $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 39 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isBase(int tx, int ty, DIR dd) {
/* 44 */     if (dd.isOrtho())
/* 45 */       return false; 
/* 46 */     DIR d = dd.next(2);
/* 47 */     DIR t = SettEnvShape.this.getWallDIR(tx + d.x(), ty + d.y());
/* 48 */     if (t != null && !t.isOrtho())
/* 49 */       return true; 
/* 50 */     d = dd.next(-2);
/* 51 */     t = SettEnvShape.this.getWallDIR(tx + d.x(), ty + d.y());
/* 52 */     if (t != null && !t.isOrtho())
/* 53 */       return true; 
/* 54 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvShape$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */