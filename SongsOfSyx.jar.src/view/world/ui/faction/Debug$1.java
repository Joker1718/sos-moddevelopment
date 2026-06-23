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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 25 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 28 */     for (FactionNPC f : FACTIONS.NPCs()) {
/* 29 */       if (f.isActive() && f != g.get() && !DIP.WAR().is((Faction)f, (Faction)g.get())) {
/* 30 */         DIP.WAR().set((Faction)f, (Faction)g.get());
/*    */         return;
/*    */       } 
/*    */     } 
/* 34 */     super.clickA();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Debug$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */