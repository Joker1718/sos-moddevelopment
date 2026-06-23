/*    */ package game.events.killer;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */   extends Messenger.Insert
/*    */ {
/*    */   null(String $anonymous0) {
/* 44 */     super($anonymous0);
/*    */   }
/*    */   public void set(Messenger.Data t, Str str) {
/* 47 */     str.add(STATS.APPEARANCE().name(t.victim.indu()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\Messenger$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */