/*    */ package game.events.citizen;
/*    */ 
/*    */ import settlement.room.main.employment.RoomEmployment;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import snake2d.util.sprite.text.StrInserter;
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
/*    */   extends StrInserter<RoomEmployment>
/*    */ {
/*    */   null(String $anonymous0) {
/* 40 */     super($anonymous0);
/*    */   }
/*    */   public void set(RoomEmployment t, Str str) {
/* 43 */     str.add((t.blueprint()).info.names);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenStrike$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */