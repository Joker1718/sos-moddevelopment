/*     */ package view.interrupter;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Panel
/*     */   extends GuiSection
/*     */ {
/*     */   boolean pinned;
/* 213 */   private GText title = (new GText((UI.FONT()).H2, 20)).lablify();
/*     */   
/* 215 */   private final CLICKABLE close = (CLICKABLE)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.exit)
/*     */     {
/*     */       protected void clickA() {
/* 218 */         ISidePanels.Panel.access$0(ISidePanels.Panel.this).remove(ISidePanels.Panel.this.panel);
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/* 223 */         text.title(Dic.¤¤Close);
/* 224 */         text.add((SPRITE)text.text().add('(').add(Dic.¤¤RightClick).add(')'));
/*     */       }
/*     */     };
/*     */   private ISidePanel panel;
/*     */   
/*     */   void set(ISidePanel panel) {
/* 230 */     clear();
/* 231 */     GuiSection guiSection = panel.section();
/* 232 */     body().setHeight((C.HEIGHT() - 51));
/* 233 */     body().setWidth((guiSection.body().width() + 16));
/* 234 */     body().moveY1(51.0D);
/* 235 */     guiSection.body().centerIn((BODY_HOLDER)this);
/* 236 */     guiSection.body().moveY1(99.0D);
/* 237 */     add((RENDEROBJ)guiSection);
/* 238 */     this.close.body().moveC((body().x2() - this.close.body().width() / 2 + 8), 71.0D);
/* 239 */     add((RENDEROBJ)this.close);
/* 240 */     this.panel = panel;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 245 */     if (this.panel.title != null) {
/* 246 */       this.title.clear().add(this.panel.title).adjustWidth();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     COLOR.WHITE10.render(r, body().x1(), body().x2(), 51, C.HEIGHT());
/* 253 */     (UI.PANEL()).butt.render(r, body().x1(), body().x2() - 3, 51 + (UI.PANEL()).butt.margin, 91 - (UI.PANEL()).butt.margin, 0, DIR.N.mask() | DIR.S.mask());
/*     */     
/* 255 */     GCOLOR.UI().border(r, body().x1(), body().x1() + 3, 51, C.HEIGHT());
/* 256 */     GCOLOR.UI().border(r, body().x2() - 3, body().x2(), 51, C.HEIGHT());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     if (this.title.length() != 0) {
/* 265 */       this.title.adjustWidth();
/* 266 */       int x = body().x1() + (this.close.body().x1() - body().x1()) / 2;
/* 267 */       int y = this.close.body().cY();
/* 268 */       this.title.renderC(r, x, y);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 305 */     super.render(r, ds);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\ISidePanels$Panel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */