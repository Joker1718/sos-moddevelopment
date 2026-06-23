/*    */ package game.events.faction;
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
/*    */ class null
/*    */   extends DIP.DipActivityListener
/*    */ {
/*    */   public void change(Faction a, Faction b, DipStance old, DipStance nn) {
/* 30 */     if (nn == DIP.WAR()) {
/* 31 */       EventFactionPeace.this.secondWhenWarEnds[b.index()] = EventFactionPeace.this.peaceTime();
/* 32 */       EventFactionPeace.this.secondWhenWarEnds[a.index()] = EventFactionPeace.this.peaceTime();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\EventFactionPeace$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */