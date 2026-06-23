/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.faction.player.PLevels;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.Lock;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class TRow
/*     */   extends GuiSection
/*     */ {
/*     */   PLevels.Level l;
/*     */   
/*     */   TRow(PLevels.Level l) {
/* 146 */     this.l = l;
/*     */     
/* 148 */     int w = 500;
/*     */     
/* 150 */     add((RENDEROBJ)new GHeader(l.name()));
/*     */     
/* 152 */     body().setWidth(w);
/*     */     
/* 154 */     GuiSection s = new GuiSection();
/*     */     
/* 156 */     for (BoostSpec b : l.boosters.all()) {
/* 157 */       s.addRightC(2, (SPRITE)b.boostable.icon);
/* 158 */       if (s.body().width() + s.getLast().width() >= w - body().width())
/*     */         break; 
/*     */     } 
/* 161 */     s.body().moveX2(w);
/* 162 */     s.body().moveCY(body().cY());
/* 163 */     absorb(s);
/*     */ 
/*     */     
/* 166 */     s = new GuiSection();
/* 167 */     s.body().setHeight(32.0D);
/* 168 */     for (Lock<?> b : (Iterable<Lock<?>>)l.lockers.all()) {
/* 169 */       s.addRightC(8, b.lockable.icon);
/* 170 */       if (s.body().width() + s.getLast().width() >= w) {
/*     */         break;
/*     */       }
/*     */     } 
/* 174 */     boolean f = true;
/* 175 */     for (BoostSpec b : l.boosters.all()) {
/* 176 */       s.addRightC(f ? 8 : 64, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 180 */               b.booster.format(text, b.booster.to());
/*     */             }
/* 182 */           }).hh(b.boostable.icon.big));
/* 183 */       f = false;
/* 184 */       if (s.body().width() + s.getLast().width() >= w) {
/*     */         break;
/*     */       }
/*     */     } 
/* 188 */     s.body().moveX1(body().x1());
/* 189 */     s.body().moveY1((body().y2() + 8));
/* 190 */     absorb(s);
/*     */     
/* 192 */     GText gText = new GText((UI.FONT()).H2, (CharSequence)GFORMAT.toNumeral(l.index() + 1));
/* 193 */     add((SPRITE)gText, -64, 0);
/*     */     
/* 195 */     pad(8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 200 */     GCOLOR.UI().border().render(r, (RECTANGLE)body());
/* 201 */     GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -1);
/* 202 */     super.render(r, ds);
/* 203 */     if (this.l.index() > GAME.player().level().current().index()) {
/* 204 */       OPACITY.O50.bind();
/* 205 */       COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 206 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 213 */     this.l.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\Level$TRow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */