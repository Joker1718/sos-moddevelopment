/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class IButt
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   private final State state;
/*     */   
/*     */   IButt(State state, GETTER<Integer> ier) {
/* 159 */     super((SPRITE)new GStat(state, ier)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 163 */             text.lablify().add(((FurnisherItemGroup)state.b.constructor().groups().get(((Integer)ier.get()).intValue())).name());
/*     */           }
/*     */         });
/* 166 */     this.state = state;
/* 167 */     this.ier = ier;
/* 168 */     setDim(190, 24);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 173 */     selectedSet(((VIEW.s()).tools.placer.getCurrent() == this.state.placement.placer.itemPlacerCurrent() && this.state.item() == ((Integer)this.ier.get()).intValue()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 178 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 179 */     if (this.state.problemGroup == this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue()) && this.state.problemTimer > VIEW.renderSecond()) {
/* 180 */       COLOR.RED100.renderFrame(r, (RECTANGLE)this.body, 2, 3);
/* 181 */       OPACITY.O25To50.bind();
/* 182 */       COLOR.RED100.render(r, (RECTANGLE)this.body);
/* 183 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 189 */     if (this.state.placement.placer.item(((Integer)this.ier.get()).intValue()) == null) {
/*     */       return;
/*     */     }
/* 192 */     this.state.setItem(((Integer)this.ier.get()).intValue());
/* 193 */     (VIEW.s()).tools.place((PLACABLE)this.state.placement.placer.item(((Integer)this.ier.get()).intValue()), this.state.config);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 198 */     text.title(((FurnisherItemGroup)this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue())).name());
/* 199 */     text.text(((FurnisherItemGroup)this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue())).desc());
/*     */     
/* 201 */     GBox b = (GBox)text;
/* 202 */     b.NL(8);
/* 203 */     for (FurnisherStat s : this.state.b.constructor().stats()) {
/* 204 */       double d = ((FurnisherItemGroup)this.state.b.constructor().groups().get(((Integer)this.ier.get()).intValue())).stat(s.index());
/* 205 */       if (d < 0.0D) {
/* 206 */         b.error(s.name());
/* 207 */         b.tab(6);
/* 208 */         b.add((SPRITE)(SPRITES.icons()).m.minus);
/* 209 */       } else if (d > 0.0D) {
/* 210 */         b.text(s.name());
/* 211 */         b.tab(6);
/* 212 */         b.add((SPRITE)(SPRITES.icons()).m.plus);
/*     */       } 
/* 214 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SItems$IButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */