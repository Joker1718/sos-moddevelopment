/*    */ package snake2d.util.color;
/*    */ 
/*    */ import snake2d.CORE;
/*    */ 
/*    */ 
/*    */ public interface OPACITY
/*    */ {
/*  8 */   public static final OPACITY O100 = new OpacityImp(255);
/*  9 */   public static final OPACITY O50 = new OpacityImp(128);
/* 10 */   public static final OPACITY O35 = new OpacityImp(85);
/* 11 */   public static final OPACITY O25 = new OpacityImp(64);
/* 12 */   public static final OPACITY O018 = new OpacityImp(45);
/* 13 */   public static final OPACITY O012 = new OpacityImp(32);
/* 14 */   public static final OPACITY O005 = new OpacityImp(16);
/* 15 */   public static final OPACITY O66 = new OpacityImp(170);
/* 16 */   public static final OPACITY O75 = new OpacityImp(191);
/* 17 */   public static final OPACITY O85 = new OpacityImp(216);
/* 18 */   public static final OPACITY O99 = new OpacityImp(254);
/* 19 */   public static final OPACITY O0 = new OpacityImp(0);
/*    */   
/* 21 */   public static final OPACITY O25TO100 = new OpaPuls(63, 254);
/* 22 */   public static final OPACITY O75TO100 = new OpaPuls(191, 254);
/* 23 */   public static final OPACITY O12To25 = new OpaPuls(31, 63);
/* 24 */   public static final OPACITY O0To25 = new OpaPuls(0, 63);
/* 25 */   public static final OPACITY O25To50 = new OpaPuls(63, 127);
/*    */   
/*    */   byte get();
/*    */   
/*    */   default void bind() {
/* 30 */     CORE.renderer().setOpacity(this);
/*    */   }
/*    */   
/*    */   static void unbind() {
/* 34 */     CORE.renderer().setNormalOpacity();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\color\OPACITY.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */