/*    */ package world.army.ai;
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
/*    */ class null
/*    */   extends DIP.DipActivityListener
/*    */ {
/*    */   public void change(Faction faction, Faction other, DipStance old, DipStance nn) {
/* 27 */     if (nn == DIP.WAR() || old == nn) {
/* 28 */       if (!WArmyAI.this.fas.contains(faction))
/* 29 */         WArmyAI.this.fas.add(faction); 
/* 30 */       if (!WArmyAI.this.fas.contains(other))
/* 31 */         WArmyAI.this.fas.add(other); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\WArmyAI$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */