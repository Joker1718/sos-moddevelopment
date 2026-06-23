/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
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
/*     */ class Card
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   int kills;
/*     */   private final Div div;
/*     */   
/*     */   Card(Div div) {
/* 115 */     this.body.setDim((VIEW.UI()).div.normal.width(), ((VIEW.UI()).div.normal.height() + 8));
/* 116 */     this.div = div;
/* 117 */     this.kills = (GAME.ARMIES()).factors.kills(div);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 122 */     GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*     */     
/* 124 */     (VIEW.UI()).div.renderBasics(r, this.body.x1(), this.body.y1(), 1, (DIV_SPEC)this.div.info);
/*     */     
/* 126 */     double menTot = this.div.info.men();
/* 127 */     double menNow = this.div.menNrOf();
/*     */     
/* 129 */     GMeter.renderDelta(r, 1.0D, menNow / menTot, this.body.x1(), this.body.x2(), this.body.y2() - 12, this.body.y2());
/*     */     
/* 131 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 136 */     GBox b = (GBox)text;
/* 137 */     int menTot = this.div.info.men();
/* 138 */     int menNow = this.div.menNrOf();
/*     */     
/* 140 */     b.title((CharSequence)this.div.info.name());
/* 141 */     b.textLL(UIBattleResult.¤¤casulties);
/* 142 */     b.tab(6);
/* 143 */     b.add((SPRITE)GFORMAT.iofk(b.text(), (menTot - menNow), menTot));
/* 144 */     b.NL();
/* 145 */     b.textLL(UIBattleResult.¤¤kills);
/* 146 */     b.tab(6);
/* 147 */     b.add((SPRITE)GFORMAT.i(b.text(), this.kills));
/*     */     
/* 149 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIBattleResult$Card.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */