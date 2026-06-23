/*    */ package game.events.citizen;
/*    */ 
/*    */ import init.race.Race;
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
/*    */ class null
/*    */   extends StrInserter<Race>
/*    */ {
/*    */   null(String $anonymous0) {
/* 27 */     super($anonymous0);
/*    */   }
/*    */   public void set(Race t, Str str) {
/* 30 */     str.add(t.info.names);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenEmmigrate$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */