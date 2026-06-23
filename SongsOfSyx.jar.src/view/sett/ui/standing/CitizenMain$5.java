/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.Race;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.standing.StandingCitizen;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GuiSection
/*     */ {
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 139 */     super.hoverInfoGet(text);
/* 140 */     if (!text.emptyIs()) {
/*     */       return;
/*     */     }
/* 143 */     GBox b = (GBox)text;
/* 144 */     b.title((h.loyalty.info()).name);
/* 145 */     b.text((h.loyalty.info()).desc);
/* 146 */     b.NL(8);
/*     */     
/* 148 */     b.textLL(Dic.¤¤Current);
/* 149 */     b.add((SPRITE)GFORMAT.perc(b.text(), h.loyalty.getD((Race)race.get())));
/* 150 */     b.add((SPRITE)(SPRITES.icons()).s.arrow_right);
/*     */     
/* 152 */     b.textLL(Dic.¤¤Target);
/* 153 */     b.tab(6);
/* 154 */     b.add((SPRITE)GFORMAT.perc(b.text(), h.loyaltyTarget.getD((Race)race.get())));
/* 155 */     b.NL(8);
/*     */     
/* 157 */     b.NL(8);
/*     */     
/* 159 */     h.loyaltyTarget.bo.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), Dic.¤¤Boosts, (S.get()).developer);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CitizenMain$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */