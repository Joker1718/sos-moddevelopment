/*     */ package view.sett.ui.room.copy;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ final class SecondConfig implements ToolConfig {
/*  27 */   private final GuiSection section = new GuiSection();
/*     */   private final ON_TOP_RENDERABLE top;
/*  29 */   private final GPanel p = new GPanel(); private final RENDEROBJ butts;
/*     */   private final CLICKABLE butt;
/*     */   private final First first;
/*     */   private final FirstConfig fConfig;
/*     */   
/*  34 */   ACTION exit = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  38 */         (VIEW.s()).tools.placer.deactivate();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   SecondConfig(final Source source, final First first, final FirstConfig fConfig) {
/*  45 */     this.first = first;
/*  46 */     this.fConfig = fConfig;
/*  47 */     this.butt = (CLICKABLE)new GButt.Panel((SPRITE)(SPRITES.icons()).m.arrow_left)
/*     */       {
/*     */         protected void clickA() {
/*  50 */           (VIEW.s()).tools.place((PLACABLE)first, fConfig);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  55 */           activeSet(false);
/*  56 */           for (COORDINATE c : source.area()) {
/*  57 */             if (source.is(c)) {
/*  58 */               activeSet(true);
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*  65 */     this.butts = (RENDEROBJ)new RENDEROBJ.RenderImp(32, 32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  69 */           (UI.PANEL()).butt.render(r, (RECTANGLE)this.body, 0);
/*     */         }
/*     */       };
/*     */     
/*  73 */     this.top = new ON_TOP_RENDERABLE()
/*     */       {
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */         {
/*  77 */           RenderData.RenderIterator it = data.onScreenTiles();
/*  78 */           while (it.has()) {
/*  79 */             if (source.is(it.tile())) {
/*  80 */               int m = 0;
/*  81 */               for (DIR d : DIR.ORTHO) {
/*  82 */                 if (source.is(it.tx(), it.ty(), d))
/*  83 */                   m |= d.mask(); 
/*     */               } 
/*  85 */               (SPRITES.cons()).BIG.dashed.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/*     */             } 
/*  87 */             it.next();
/*     */           } 
/*  89 */           SecondConfig.this.top.remove();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addUI(LISTE<RENDEROBJ> uis) {
/*  97 */     this.section.clear();
/*     */     
/*  99 */     (VIEW.s()).tools.placer.stealButtons(this.section);
/*     */     
/* 101 */     this.section.pad(20, 0);
/*     */     
/* 103 */     this.section.addRelBody(4, DIR.S, this.butts);
/* 104 */     this.butt.body().centerIn((BODY_HOLDER)this.butts);
/* 105 */     this.section.add((RENDEROBJ)this.butt);
/*     */     
/* 107 */     this.section.body().centerX(C.DIM());
/*     */ 
/*     */ 
/*     */     
/* 111 */     this.p.setButt();
/* 112 */     this.p.inner().set((BODY_HOLDER)this.section);
/*     */ 
/*     */ 
/*     */     
/* 116 */     this.p.setCloseAction(this.exit);
/* 117 */     this.p.setTitle(Dic.¤¤Copy);
/* 118 */     this.section.add((RENDEROBJ)this.p);
/* 119 */     this.section.moveLastToBack();
/* 120 */     this.section.body().moveY1(100.0D);
/* 121 */     this.section.body().centerX(C.DIM());
/*     */     
/* 123 */     uis.add(this.section);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(boolean UIHovered) {
/* 128 */     this.top.add();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean back() {
/* 133 */     (VIEW.s()).tools.place((PLACABLE)this.first, this.fConfig);
/* 134 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\SecondConfig.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */