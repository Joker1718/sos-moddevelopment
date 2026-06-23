/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */   extends CLICKABLE.Pair
/*     */ {
/*     */   null(RENDEROBJ $anonymous0, RENDEROBJ $anonymous1, DIR $anonymous2, int $anonymous3) {
/* 129 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 132 */     GBox b = (GBox)text;
/* 133 */     b.title((e.stat().info()).name);
/* 134 */     b.text((e.stat().info()).desc);
/* 135 */     b.NL(4);
/* 136 */     int needs = 0;
/* 137 */     int has = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(e.resource());
/* 138 */     for (Div d : GAME.ARMIES().player().divisions()) {
/*     */       
/* 140 */       has += e.stat().div().get(d);
/* 141 */       needs += d.info.men() * e.target(d);
/*     */     } 
/* 143 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), has, needs));
/* 144 */     b.NL(4);
/* 145 */     b.textLL(Dic.¤¤Boosts);
/* 146 */     b.NL(4);
/* 147 */     (e.stat()).boosters.hover(text, 1.0D, -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Info$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */