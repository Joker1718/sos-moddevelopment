/*     */ package view.world.generator;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.world.panel.UIMinimapW;
/*     */ 
/*     */ class IMinimap extends Interrupter {
/*  22 */   private final GuiSection buttons = new GuiSection(); private final UIMinimapW map;
/*     */   private final WorldViewGenerator v;
/*     */   
/*     */   public IMinimap(final WorldViewGenerator v) {
/*  26 */     this.v = v;
/*  27 */     this.map = new UIMinimapW(v.window);
/*  28 */     pin();
/*     */ 
/*     */     
/*  31 */     CLICKABLE b = (new GButt.Panel((SPRITE)(SPRITES.icons()).m.citizen)
/*     */       {
/*     */         protected void clickA() {
/*  34 */           v.reset();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  40 */           activeSet(v.canSelectRace);
/*     */         }
/*  42 */       }).hoverInfoSet(StagePickRace.¤¤title);
/*  43 */     this.buttons.addRight(0, (RENDEROBJ)b);
/*     */     
/*  45 */     b = (new GButt.Panel((SPRITE)(SPRITES.icons()).m.city)
/*     */       {
/*     */         protected void clickA() {
/*  48 */           v.reset();
/*     */         }
/*  51 */       }).hoverInfoSet(StageVisuals.¤¤title);
/*  52 */     this.buttons.addRight(8, (RENDEROBJ)b);
/*     */     
/*  54 */     b = (new GButt.Panel((SPRITE)(SPRITES.icons()).m.arrow_up)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  58 */           v.reset();
/*     */         }
/*  61 */       }).hoverInfoSet(StagePickTitles.¤¤title);
/*  62 */     this.buttons.addRightC(8, (RENDEROBJ)b);
/*     */     
/*  64 */     b = (new GButt.Panel((SPRITE)(SPRITES.icons()).m.terrain)
/*     */       {
/*     */ 
/*     */         
/*     */         protected void clickA() {}
/*  69 */       }).hoverInfoSet(StageTerrain.¤¤title);
/*  70 */     this.buttons.addRightC(8, (RENDEROBJ)b);
/*     */     
/*  72 */     GButt.Panel panel = new GButt.Panel((SPRITE)(SPRITES.icons()).m.plus)
/*     */       {
/*     */         protected void clickA() {
/*  75 */           if (v.window.zoomout() > 0) {
/*  76 */             v.window.setZoomout(v.window.zoomout() - 1);
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  81 */           activeSet((v.window.zoomout() > 0));
/*     */         }
/*     */       };
/*  84 */     this.buttons.addRightC(32, (RENDEROBJ)panel);
/*     */     
/*  86 */     panel = new GButt.Panel((SPRITE)(SPRITES.icons()).m.minus)
/*     */       {
/*     */         protected void clickA() {
/*  89 */           if (v.window.zoomout() < 3) {
/*  90 */             v.window.setZoomout(v.window.zoomout() + 1);
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  95 */           activeSet((v.window.zoomout() < 3));
/*     */         }
/*     */       };
/*  98 */     this.buttons.addRightC(0, (RENDEROBJ)panel);
/*     */     
/* 100 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(this.map.body().width(), 32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 104 */           (UI.PANEL()).butt.render(r, (RECTANGLE)this.body, 0, DIR.S, DIR.W);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     this.buttons.body().moveX2((C.WIDTH() - 4));
/* 114 */     this.buttons.body().moveY1(0.0D);
/* 115 */     renderImp.body().moveX2(C.WIDTH());
/* 116 */     this.buttons.add((RENDEROBJ)renderImp);
/* 117 */     this.buttons.moveLastToBack();
/*     */ 
/*     */     
/* 120 */     this.map.body().moveY1(this.buttons.body().y2());
/* 121 */     this.map.body().moveX2(C.DIM().width());
/* 122 */     show(v.uiManager);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 127 */     return this.buttons.hover(mCoo) | this.map.hover(mCoo) | mCoo.isWithinRec((RECTANGLE)this.map.body());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 132 */     if (button != MButt.LEFT)
/*     */       return; 
/* 134 */     if (this.buttons.click()) {
/*     */       return;
/*     */     }
/* 137 */     this.map.click();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 143 */     this.buttons.render((SPRITE_RENDERER)r, 0.0F);
/* 144 */     this.map.render((SPRITE_RENDERER)r, 0.0F);
/*     */     
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 157 */     this.buttons.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hide() {
/* 162 */     super.hide();
/*     */   }
/*     */   
/*     */   public void show() {
/* 166 */     show(this.v.uiManager);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\IMinimap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */