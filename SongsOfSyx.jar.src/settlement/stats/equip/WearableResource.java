/*    */ package settlement.stats.equip;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.stats.Induvidual;
/*    */ 
/*    */ public interface WearableResource
/*    */ {
/*    */   RESOURCE resource(Induvidual paramInduvidual);
/*    */   
/*    */   void wearOut(Induvidual paramInduvidual);
/*    */   
/*    */   int max(Induvidual paramInduvidual);
/*    */   
/*    */   int target(Induvidual paramInduvidual);
/*    */   
/*    */   default void inc(Induvidual i, int am) {
/* 17 */     set(i, get(i) + am);
/*    */   }
/*    */   
/*    */   double wearPerYear(Induvidual paramInduvidual);
/*    */   
/*    */   void set(Induvidual paramInduvidual, int paramInt);
/*    */   
/*    */   int get(Induvidual paramInduvidual);
/*    */   
/*    */   int needed(Induvidual paramInduvidual);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\WearableResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */