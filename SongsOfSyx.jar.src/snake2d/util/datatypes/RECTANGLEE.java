/*    */ package snake2d.util.datatypes;public interface RECTANGLEE extends RECTANGLE { RECTANGLEE incr(double paramDouble1, double paramDouble2);
/*    */   RECTANGLEE incrX(double paramDouble);
/*    */   
/*    */   RECTANGLEE incrY(double paramDouble);
/*    */   
/*    */   RECTANGLEE incr(COORDINATE paramCOORDINATE);
/*    */   
/*    */   RECTANGLEE incr(COORDINATE paramCOORDINATE, double paramDouble);
/*    */   
/*    */   RECTANGLEE moveX1Y1(double paramDouble1, double paramDouble2);
/*    */   
/*    */   RECTANGLEE moveX1Y1(COORDINATE paramCOORDINATE);
/*    */   
/*    */   default RECTANGLEE moveX1Y1(RECTANGLE other) {
/* 15 */     moveX1Y1(other.x1(), other.y1());
/* 16 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   RECTANGLEE moveX1(double paramDouble);
/*    */   
/*    */   RECTANGLEE moveX2(double paramDouble);
/*    */   
/*    */   RECTANGLEE moveY1(double paramDouble);
/*    */   
/*    */   RECTANGLEE moveY2(double paramDouble);
/*    */   
/*    */   default RECTANGLEE centerIn(BODY_HOLDER b) {
/* 29 */     return centerIn(b.body());
/*    */   } RECTANGLEE moveC(COORDINATE paramCOORDINATE); RECTANGLEE moveC(double paramDouble1, double paramDouble2); RECTANGLEE moveCX(double paramDouble); RECTANGLEE moveCY(double paramDouble);
/*    */   RECTANGLEE centerIn(RECTANGLE paramRECTANGLE);
/*    */   RECTANGLEE centerIn(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
/*    */   RECTANGLEE centerX(double paramDouble1, double paramDouble2);
/*    */   default RECTANGLEE centerX(BODY_HOLDER b) {
/* 35 */     return centerX(b.body());
/*    */   }
/*    */   RECTANGLEE centerX(RECTANGLE paramRECTANGLE);
/*    */   RECTANGLEE centerY(double paramDouble1, double paramDouble2);
/*    */   default RECTANGLEE centerY(BODY_HOLDER b) {
/* 40 */     return centerY(b.body());
/*    */   }
/*    */   RECTANGLEE centerY(RECTANGLE paramRECTANGLE);
/*    */   
/*    */   default RECTANGLEE fitIn(RECTANGLE other) {
/* 45 */     if (x1() < other.x1())
/* 46 */       moveX1(other.x1()); 
/* 47 */     if (y1() < other.y1())
/* 48 */       moveY1(other.y1()); 
/* 49 */     if (x2() > other.x2())
/* 50 */       moveX2(other.x2()); 
/* 51 */     if (y2() > other.y2())
/* 52 */       moveY2(other.y2()); 
/* 53 */     return this;
/*    */   } }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\RECTANGLEE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */