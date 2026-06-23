/*    */ package game.faction.diplomacy;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 50 */     DipWarPlayer.this.upI = -120;
/*    */     
/* 52 */     if (nn == DIP.WAR() && 
/* 53 */       DIP.WAR().all((Faction)FACTIONS.player()).size() == 1)
/*    */     {
/* 55 */       if (faction == FACTIONS.player()) {
/* 56 */         DipWarPlayer.this.warName.clear().add((CharSequence)(other.race().kingMessage()).WAR_CAUSE_AGRESSION.rnd()).insert(0, (CharSequence)other.name);
/* 57 */         DipWarPlayer.this.teamName.clear().add((CharSequence)(other.race().kingMessage()).COALITION_NAME.rnd());
/* 58 */       } else if (other == FACTIONS.player()) {
/* 59 */         DipWarPlayer.this.teamName.clear().add((CharSequence)(other.race().kingMessage()).COALITION_NAME.rnd());
/* 60 */         DipWarPlayer.this.warName.clear().add((CharSequence)(other.race().kingMessage()).WAR_CAUSE_DEFEND.rnd()).insert(0, (CharSequence)other.name);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\DipWarPlayer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */