/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import util.gui.misc.GButt;
/*    */ import world.region.RD;
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
/*    */   extends GButt.Checkbox
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 56 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 60 */     selectedSet((RD.REALM(PlayDebug.this.reg) == RD.REALM((Faction)FACTIONS.player())));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 65 */     if (PlayDebug.this.reg.capitol()) {
/* 66 */       FACTIONS.remove((FactionNPC)PlayDebug.this.reg.faction(), true);
/*    */     }
/*    */     
/* 69 */     RD.setFaction(PlayDebug.this.reg, selectedIs() ? null : (Faction)FACTIONS.player(), true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayDebug$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */