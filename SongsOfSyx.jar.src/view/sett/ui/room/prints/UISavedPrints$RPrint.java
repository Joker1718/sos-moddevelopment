/*     */ package view.sett.ui.room.prints;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RPrint
/*     */   extends GuiSection
/*     */   implements STRING_RECIEVER
/*     */ {
/*     */   Entry e;
/*     */   
/*     */   public RPrint() {
/* 241 */     body().setDim(16.0D, 40.0D);
/* 242 */     addRightC(4, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 246 */             if (UISavedPrints.RPrint.this.e.isLocked) {
/* 247 */               text.errorify();
/*     */             } else {
/* 249 */               text.normalify();
/* 250 */             }  text.setMaxWidth(150);
/* 251 */             text.setMultipleLines(false);
/* 252 */             text.add(UISavedPrints.RPrint.this.e.print.name);
/*     */           }
/*     */         });
/* 255 */     addRightCAbs(180, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 259 */             text.add(UISavedPrints.RPrint.this.e.print.width).add('x').add(UISavedPrints.RPrint.this.e.print.height);
/*     */           }
/*     */         });
/*     */     
/* 263 */     addRightC(96, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.admin)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 267 */             (VIEW.inters()).input.requestInput(UISavedPrints.RPrint.this, Dic.¤¤rename);
/*     */           }
/* 270 */         }).hoverInfoSet(Dic.¤¤rename));
/* 271 */     addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.cancel)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 275 */             (SETT.ROOMS()).copy.prints.remove(UISavedPrints.RPrint.this.e.print);
/*     */           }
/* 278 */         }).hoverInfoSet(Dic.¤¤remove));
/* 279 */     body().setWidth(380.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 284 */     boolean isActive = !this.e.isLocked;
/* 285 */     boolean isHovered = hoveredIs();
/* 286 */     boolean isSelected = (UISavedPrints.this.placing == this.e.print);
/* 287 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)body());
/* 288 */     super.render(r, ds);
/* 289 */     if (UISavedPrints.this.flashed == this.e.print && UISavedPrints.this.flashUntil > VIEW.renderSecond()) {
/* 290 */       OPACITY.O0To25.bind();
/* 291 */       (GCOLOR.UI()).GOOD.hovered.render(r, (RECTANGLE)body());
/* 292 */       OPACITY.unbind();
/*     */     } 
/*     */     
/* 295 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */   }
/*     */ 
/*     */   
/*     */   public void acceptString(CharSequence string) {
/* 300 */     if (this.e != null && string != null && string.length() > 0) {
/* 301 */       this.e.print.name = String.valueOf(string);
/* 302 */       (SETT.ROOMS()).copy.prints.save();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 308 */     if (this.e.isLocked) {
/* 309 */       text.text(Dic.¤¤Locked);
/*     */     }
/* 311 */     text.text(this.e.print.name);
/* 312 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 317 */     for (RoomBlueprintImp b : this.e.cat.prints) {
/* 318 */       if (b.reqs.passes(FACTIONS.player())) {
/* 319 */         (SETT.ROOMS()).copy.savedPlacer.place(this.e.print);
/* 320 */         (VIEW.s()).panels.add(UISavedPrints.this, true);
/* 321 */         UISavedPrints.this.flashUntil = 0.0D;
/* 322 */         UISavedPrints.this.placing = this.e.print;
/*     */         return;
/*     */       } 
/*     */     } 
/* 326 */     super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\UISavedPrints$RPrint.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */