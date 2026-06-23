/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Booster;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.standing.StandingCitizen;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStaples
/*     */ {
/*     */   null(int $anonymous0) {
/* 184 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 189 */     isHovered = true;
/* 190 */     setHovered(hov.get());
/* 191 */     super.render(r, ds, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 196 */     box.title((h.info()).name);
/* 197 */     int fromZero = 32 - stapleI - 1;
/* 198 */     box.add((SPRITE)box.text().lablify().add(-fromZero).s().add(TIME.days().cycleName()));
/* 199 */     box.NL();
/*     */     
/* 201 */     box.textLL(Dic.¤¤Current);
/* 202 */     box.add((SPRITE)GFORMAT.perc(box.text(), h.loyalty.getD((Race)race.get(), fromZero)));
/* 203 */     box.add((SPRITE)(SPRITES.icons()).s.arrow_right);
/* 204 */     box.textLL(Dic.¤¤Target);
/* 205 */     box.tab(6);
/* 206 */     box.add((SPRITE)GFORMAT.perc(box.text(), h.loyaltyTarget.getD((Race)race.get(), fromZero)));
/* 207 */     box.NL(8);
/*     */     
/* 209 */     box.sep();
/*     */     
/* 211 */     for (int i = 0; i < h.loyaltyTarget.bo.all().size(); i++) {
/* 212 */       Booster b = (Booster)h.loyaltyTarget.bo.all().get(i);
/* 213 */       double n = h.loyaltyTarget.factor((Race)race.get(), i, fromZero);
/* 214 */       double p = h.loyaltyTarget.factor((Race)race.get(), i, fromZero + 1);
/* 215 */       box.add(b.info.icon);
/* 216 */       box.textLL(b.info.name);
/* 217 */       box.tab(7);
/*     */       
/* 219 */       if (b.isMul) {
/* 220 */         box.add((SPRITE)GFORMAT.percInc(box.text(), n - p));
/*     */       } else {
/* 222 */         box.add((SPRITE)GFORMAT.f0(box.text(), n - p));
/* 223 */       }  box.NL();
/*     */     } 
/*     */ 
/*     */     
/* 227 */     box.NL();
/*     */     
/* 229 */     h.loyaltyTarget.bo.hoverDetailed((GUI_BOX)box, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), Dic.¤¤Boosts, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 235 */     if (super.hover(mCoo)) {
/* 236 */       hov.set(hoverI());
/* 237 */       return true;
/*     */     } 
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 244 */     int fromZero = 32 - stapleI - 1;
/* 245 */     return h.loyalty.getD((Race)race.get(), fromZero);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 250 */     c.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD2.hovered, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CitizenMain$8.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */