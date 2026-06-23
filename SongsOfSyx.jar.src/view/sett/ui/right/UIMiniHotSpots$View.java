/*     */ package view.sett.ui.right;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.SettMarks;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
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
/*     */ class View
/*     */   extends GuiSection
/*     */ {
/* 149 */   private final GuiSection section = new GuiSection();
/*     */   private final CLICKABLE toggle;
/* 151 */   private int bi = 0;
/*     */   private final UIMiniHotSpots.Button[] buttons;
/*     */   
/*     */   View(int y1) {
/* 155 */     (SETT.TILE_MAP()).marks.getClass(); this.buttons = new UIMiniHotSpots.Button[32];
/* 156 */     int i = 0; (SETT.TILE_MAP()).marks.getClass(); for (; i < 32; i++) {
/* 157 */       this.buttons[i] = new UIMiniHotSpots.Button(paramUIMiniHotSpots, i);
/*     */     }
/* 159 */     body().setWidth(42.0D).setHeight((C.HEIGHT() - y1));
/* 160 */     body().moveX2(C.WIDTH());
/* 161 */     body().moveY1(y1);
/*     */ 
/*     */     
/* 164 */     this.section.merge(this.section);
/*     */     
/* 166 */     this.toggle = (new GButt.Panel((SPRITE)(SPRITES.icons()).m.crossair)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 170 */           (SETT.TILE_MAP()).marks.getClass(); if ((SETT.TILE_MAP()).marks.active().size() < 32) {
/* 171 */             (VIEW.s()).tools.place((PLACABLE)(UIMiniHotSpots.View.access$0(UIMiniHotSpots.View.this)).placer);
/*     */             return;
/*     */           } 
/*     */         }
/* 175 */       }).hoverInfoSet(UIMiniHotSpots.¤¤setLong);
/*     */     
/* 177 */     this.toggle.body().moveY1((body().y1() + 10));
/* 178 */     this.toggle.body().centerX((BODY_HOLDER)this);
/* 179 */     add((RENDEROBJ)this.toggle);
/* 180 */     this.section.body().moveY1(this.toggle.body().y1());
/* 181 */     this.section.body().centerX((RECTANGLE)body());
/* 182 */     add((RENDEROBJ)this.section);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 187 */     if (this.bi != (SETT.TILE_MAP()).marks.state()) {
/* 188 */       this.section.clear();
/* 189 */       int i = 0;
/* 190 */       for (SettMarks.SettMark b : (SETT.TILE_MAP()).marks.active()) {
/* 191 */         if (b.active) {
/* 192 */           this.buttons[i].set(b);
/* 193 */           this.section.addDownC(0, (RENDEROBJ)this.buttons[i]);
/* 194 */           i++;
/*     */         } 
/*     */       } 
/* 197 */       this.section.body().centerX((BODY_HOLDER)this.toggle);
/* 198 */       this.section.body().moveY1((this.toggle.body().y2() + 8));
/* 199 */       this.bi = (SETT.TILE_MAP()).marks.state();
/*     */     } 
/* 201 */     if (visableIs()) {
/* 202 */       (GCOLOR.UI()).panBG.render(r, (RECTANGLE)body());
/* 203 */       super.render(r, ds);
/* 204 */       GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniHotSpots$View.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */