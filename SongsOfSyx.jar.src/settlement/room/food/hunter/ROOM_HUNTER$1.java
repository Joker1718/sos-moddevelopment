/*    */ package settlement.room.food.hunter;
/*    */ 
/*    */ import settlement.room.industry.module.RoomBoost;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */ class null
/*    */   implements RoomBoost
/*    */ {
/*    */   INFO info;
/*    */   
/*    */   null() {
/* 68 */     this.info = new INFO(Dic.¤¤Employees, String.valueOf(Str.TMP.clear().add(ROOM_HUNTER.¤¤emp).insert(0, paramROOM_HUNTER.MAX_EMPLOYED)));
/*    */   }
/*    */   
/*    */   public INFO info() {
/* 72 */     return this.info;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(RoomInstance r) {
/* 77 */     return ROOM_HUNTER.this.eBonus(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\ROOM_HUNTER$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */