/*    */ package settlement.room.knowledge.school;
/*    */ 
/*    */ import settlement.room.industry.module.RoomBoost;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import util.info.INFO;
/*    */ import util.text.Dic;
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
/*    */   implements RoomBoost
/*    */ {
/* 68 */   INFO info = new INFO(Dic.¤¤Degrade, Dic.¤¤DegradeDesc);
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 72 */     return this.info;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(RoomInstance r) {
/* 77 */     return 1.0D - r.getDegrade();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\RoomEducationHelper$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */