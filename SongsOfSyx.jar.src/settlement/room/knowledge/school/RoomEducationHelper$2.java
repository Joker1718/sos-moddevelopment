/*    */ package settlement.room.knowledge.school;
/*    */ 
/*    */ import game.boosting.Boostable;
/*    */ import settlement.room.industry.module.IndustryRate;
/*    */ import settlement.room.industry.module.RoomBoost;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
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
/*    */   implements IndustryRate
/*    */ {
/*    */   private final LIST<RoomBoost> boos;
/*    */   
/*    */   null(RoomBoost[] paramArrayOfRoomBoost, RoomBoost paramRoomBoost) {
/* 83 */     this.boos = (new ArrayList((Object[])paramArrayOfRoomBoost)).join((Object[])new RoomBoost[] { paramRoomBoost });
/*    */   }
/*    */   
/*    */   public LIST<RoomBoost> boosts() {
/* 87 */     return this.boos;
/*    */   }
/*    */ 
/*    */   
/*    */   public Boostable bonus() {
/* 92 */     return RoomEducationHelper.this.bonus;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\RoomEducationHelper$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */