/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 103 */     GFORMAT.f(text, TradeManager.toll((FactionNPC)f.get()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 108 */     b.title(Dic.¤¤Toll);
/* 109 */     b.text(Dic.¤¤TollD);
/* 110 */     b.sep();
/*     */     
/* 112 */     b.textLL(Dic.¤¤Distance);
/* 113 */     b.tab(6);
/* 114 */     b.add((SPRITE)GFORMAT.i(b.text(), RD.DIST().distance((Faction)f.get())));
/* 115 */     b.NL();
/*     */     
/* 117 */     b.textLL(Goods.¤¤TollTile);
/* 118 */     b.tab(6);
/* 119 */     b.add((SPRITE)GFORMAT.f(b.text(), TradeManager.tollPerTile));
/* 120 */     b.NL();
/*     */     
/* 122 */     (RD.DIST()).bProximityToll.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */     
/* 124 */     b.sep();
/* 125 */     b.textLL(Dic.¤¤Total);
/* 126 */     b.tab(6);
/* 127 */     b.add((SPRITE)GFORMAT.f(b.text(), TradeManager.toll((FactionNPC)f.get())));
/* 128 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Goods$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */