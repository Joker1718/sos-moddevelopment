/*    */ package snake2d;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public enum MButt {
/*    */   static double delta;
/*    */   static float wheelDy;
/*  8 */   LEFT, RIGHT, WHEEL,
/*    */   
/* 10 */   WHEEL_SPIN;
/*    */   boolean isDown;
/*    */   
/*    */   MButt() {
/* 14 */     this.isDown = false;
/* 15 */     this.nanoNow = -1L;
/*    */   }
/*    */   static {
/* 18 */     ALL = (LIST<MButt>)new ArrayList((Object[])values());
/*    */   }
/*    */   
/*    */   long nanoNow;
/*    */   boolean isDouble;
/*    */   
/*    */   public static float clearWheelSpin() {
/* 25 */     float f = wheelDy;
/* 26 */     wheelDy = 0.0F;
/* 27 */     return f;
/*    */   }
/*    */   public int clicks; public static LIST<MButt> ALL;
/*    */   public static float peekWheel() {
/* 31 */     return wheelDy;
/*    */   }
/*    */   
/*    */   public boolean isDown() {
/* 35 */     return this.isDown;
/*    */   }
/*    */   
/*    */   public boolean consumeClick() {
/* 39 */     if (this.clicks > 0) {
/* 40 */       this.clicks--;
/* 41 */       return true;
/*    */     } 
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public boolean consumeAllClick() {
/* 47 */     if (this.clicks > 0) {
/* 48 */       this.clicks = 0;
/* 49 */       return true;
/*    */     } 
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isDouble() {
/* 55 */     return this.isDouble;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\MButt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */