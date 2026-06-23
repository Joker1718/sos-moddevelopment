/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import world.region.RDOutputs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResButt
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final RDOutputs.RDOutput bu;
/* 194 */   private final GText tt = new GText((UI.FONT()).S, 8);
/*     */   
/*     */   ResButt(RDOutputs.RDOutput b) {
/* 197 */     this.body.setDim(paramPlayOutput.width, 30.0D);
/* 198 */     this.bu = b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 204 */     GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/* 205 */     GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -1);
/*     */     
/* 207 */     this.bu.boost.icon.medium.renderC(r, this.body.x1() + 16, this.body.cY());
/*     */     
/* 209 */     this.tt.clear();
/* 210 */     GFORMAT.i(this.tt, (long)(this.bu.boost.get((BOOSTABLE_O)PlayOutput.this.g.get()) + this.bu.boostYearlyPart.get((BOOSTABLE_O)PlayOutput.this.g.get())));
/*     */     
/* 212 */     this.tt.renderC(r, this.body.x1() + 32, this.body.cY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 225 */     if (this.bu.boostYearlyPart.get((BOOSTABLE_O)PlayOutput.this.g.get()) > 0.0D) {
/* 226 */       this.bu.boostYearlyPart.hover(text, (BOOSTABLE_O)PlayOutput.this.g.get(), true);
/* 227 */       GBox b = (GBox)text;
/* 228 */       b.sep();
/* 229 */       GText t = b.text();
/* 230 */       t.add(PlayOutput.¤¤ship);
/* 231 */       t.insert(0, this.bu.daysUntilDailydelivery());
/* 232 */       t.insert(1, this.bu.yearlyAccumilation.get(PlayOutput.this.g.get()));
/* 233 */       b.add((SPRITE)t);
/* 234 */       b.sep();
/*     */       
/* 236 */       if (this.bu.boost.get((BOOSTABLE_O)PlayOutput.this.g.get()) > 0.0D) {
/* 237 */         this.bu.boost.hover(text, (BOOSTABLE_O)PlayOutput.this.g.get(), true);
/*     */       }
/*     */     } else {
/*     */       
/* 241 */       this.bu.boost.hover(text, (BOOSTABLE_O)PlayOutput.this.g.get(), true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayOutput$ResButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */