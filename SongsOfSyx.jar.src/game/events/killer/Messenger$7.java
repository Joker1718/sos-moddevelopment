/*    */ package game.events.killer;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.text.Str;
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
/* 80 */     super($anonymous0);
/*    */   }
/*    */   public void set(Messenger.Data t, Str str) {
/* 83 */     CharSequence s = (t.suspect != null) ? STATS.APPEARANCE().name(t.suspect.indu()) : Dic.empty;
/* 84 */     str.add(s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\Messenger$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */