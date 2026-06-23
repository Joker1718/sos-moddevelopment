/*    */ package init.resources;
/*    */ 
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Meal
/*    */ {
/*    */   public static int make(ResG e, int amount, double pref) {
/* 12 */     return e.index() << 16 | amount << 8 | CLAMP.i((int)(255.0D * pref), 0, 255);
/*    */   }
/*    */   
/*    */   public static ResG get(int data) {
/* 16 */     return (ResG)RESOURCES.EDI().all().get(data >> 16 & 0xFF);
/*    */   }
/*    */   
/*    */   public static int amount(int data) {
/* 20 */     return data >> 8 & 0xFF;
/*    */   }
/*    */   
/*    */   public static double pref(int data) {
/* 24 */     return (data & 0xFF) / 255.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\Meal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */