/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.Dic;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 46 */     if (!RD.DIST().reachable((Faction)f.get())) {
/* 47 */       if (RD.DIST().factionCanAttackPlayerAllies((Faction)f.get())) {
/* 48 */         text.add(Dic.¤¤FactionBorder);
/*    */       } else {
/* 50 */         text.add(Dic.¤¤Distant);
/*    */       } 
/*    */     } else {
/* 53 */       text.add((DIP.get((FactionNPC)f.get())).name);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 59 */     DIP.get((FactionNPC)f.get()).hover((GUI_BOX)b);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Banner$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */