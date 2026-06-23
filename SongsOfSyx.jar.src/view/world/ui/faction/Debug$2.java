/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 38 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 41 */     for (FactionNPC f : FACTIONS.NPCs()) {
/* 42 */       if (f.isActive() && f != g.get() && DIP.WAR().is((Faction)f, (Faction)g.get())) {
/* 43 */         DIP.NEUTRAL().set((Faction)f, (Faction)g.get());
/*    */         return;
/*    */       } 
/*    */     } 
/* 47 */     super.clickA();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Debug$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */