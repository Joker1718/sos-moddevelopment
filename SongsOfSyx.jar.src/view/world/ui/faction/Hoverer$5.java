/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 85 */     if (!RD.DIST().reachable((Faction)Hoverer.this.f)) {
/* 86 */       if (RD.DIST().factionCanAttackPlayerAllies((Faction)Hoverer.this.f)) {
/* 87 */         text.add(Dic.¤¤FactionBorder);
/*    */       } else {
/* 89 */         text.add(Dic.¤¤Distant);
/*    */       } 
/*    */     } else {
/*    */       
/* 93 */       text.add((DIP.get(Hoverer.this.f)).name);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Hoverer$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */