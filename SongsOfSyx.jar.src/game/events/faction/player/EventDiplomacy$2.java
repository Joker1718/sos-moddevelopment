/*    */ package game.events.faction.player;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.diplomacy.DipStance;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends DIP.DipActivityListener
/*    */ {
/*    */   public void change(Faction faction, Faction other, DipStance old, DipStance nn) {
/* 55 */     boolean w = (EventDiplomacy.this.datas[faction.index()]).welcomed;
/* 56 */     EventDiplomacy.this.datas[faction.index()].clear();
/* 57 */     (EventDiplomacy.this.datas[faction.index()]).welcomed = w;
/* 58 */     w = (EventDiplomacy.this.datas[other.index()]).welcomed;
/* 59 */     EventDiplomacy.this.datas[other.index()].clear();
/* 60 */     (EventDiplomacy.this.datas[other.index()]).welcomed = w;
/* 61 */     (EventDiplomacy.this.datas[other.index()]).stanceMess = false;
/* 62 */     (EventDiplomacy.this.datas[faction.index()]).stanceMess = false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\EventDiplomacy$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */