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
/*    */   private final DIR[] dir;
/*    */   
/*    */   null(String $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 62 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */     
/* 64 */     this.dir = new DIR[] { DIR.N, DIR.E };
/*    */   } protected boolean isBase(int tx, int ty, DIR dd) {
/*    */     byte b;
/*    */     int i;
/*    */     DIR[] arrayOfDIR;
/* 69 */     for (i = (arrayOfDIR = this.dir).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 70 */       if (test(tx, ty, d, dd) && test(tx, ty, d.perpendicular(), dd))
/* 71 */         return true; 
/*    */       b++; }
/*    */     
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   private boolean test(int tx, int ty, DIR d, DIR dd) {
/* 78 */     for (int i = 1; i < 3; i++) {
/* 79 */       if (SettEnvShape.this.getWallDIR(tx + d.x() * i, ty + d.y() * i) != dd)
/* 80 */         return false; 
/*    */     } 
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvShape$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */