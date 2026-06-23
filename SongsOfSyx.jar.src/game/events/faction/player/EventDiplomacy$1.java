/*    */ package game.events.faction.player;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Faction.FactionActivityListener
/*    */ {
/*    */   public void remove(FactionNPC f) {}
/*    */   
/*    */   public void add(FactionNPC f) {
/* 47 */     EventDiplomacy.this.datas[f.index()].clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\EventDiplomacy$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */