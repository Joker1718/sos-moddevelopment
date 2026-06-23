/*     */ package view.world.ui.camps;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.entity.haven.WHaven;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Button
/*     */   extends GuiSection
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   Button(final GETTER<Integer> ier) {
/* 147 */     this.ier = ier;
/*     */     
/* 149 */     add((SPRITE)new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 153 */             WHaven f = (WHaven)UICampList.Button.access$0(UICampList.Button.this).all().get(((Integer)ier.get()).intValue());
/* 154 */             ((f.type()).race.appearance()).icon.render(r, X1, X2, Y1, Y2);
/*     */           }
/* 156 */         }0, 0);
/*     */     
/* 158 */     addRightC(4, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 162 */             WHaven f = (WHaven)UICampList.Button.access$0(UICampList.Button.this).all().get(((Integer)ier.get()).intValue());
/* 163 */             text.setMaxWidth(232);
/* 164 */             text.setMultipleLines(false);
/* 165 */             text.lablify().add((CharSequence)f.name);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 170 */     body().setWidth(276.0D);
/*     */     
/* 172 */     pad(4, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 181 */     WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 182 */     (VIEW.world()).window.centererTile.set(f.ctx(), f.cty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 192 */     GButt.ButtPanel.renderBG(r, true, false, hoveredIs(), (RECTANGLE)body());
/* 193 */     super.render(r, ds);
/* 194 */     WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 195 */     if (f.faction() != FACTIONS.player()) {
/* 196 */       OPACITY.O66.bind();
/* 197 */       COLOR.BLACK.render(r, (RECTANGLE)body(), -2);
/* 198 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 206 */     if (super.hover(mCoo)) {
/* 207 */       WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 208 */       UICampList.this.hBody.moveC((f.ctx() * 64 + 32), (f.cty() * 64 + 32));
/* 209 */       (WORLD.OVERLAY()).things.hover((RECTANGLE)UICampList.this.hBody, GCOLOR.MAP().get(f.faction()), false, 0);
/* 210 */       return true;
/*     */     } 
/*     */     
/* 213 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 218 */     WHaven f = (WHaven)UICampList.this.all().get(((Integer)this.ier.get()).intValue());
/* 219 */     CampInfo.hover(text, f);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\camps\UICampList$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */