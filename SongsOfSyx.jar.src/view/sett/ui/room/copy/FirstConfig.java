/*     */ package view.sett.ui.room.copy;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ final class FirstConfig implements ToolConfig {
/*  27 */   private final GuiSection section = new GuiSection();
/*     */   private final ON_TOP_RENDERABLE top;
/*  29 */   private final GPanel p = new GPanel();
/*     */   private final CLICKABLE butt;
/*     */   private final SecondConfig sConfig;
/*     */   
/*  33 */   final ACTION exit = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  37 */         (VIEW.s()).tools.placer.deactivate();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   FirstConfig(final Source source, final Second second, First first) {
/*  43 */     this.sConfig = new SecondConfig(source, first, this);
/*  44 */     this.butt = (CLICKABLE)new GButt.Panel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */       {
/*     */         protected void clickA() {
/*  47 */           (VIEW.s()).tools.place((PLACABLE)second, FirstConfig.this.sConfig);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  52 */           activeSet(false);
/*  53 */           for (COORDINATE c : source.area()) {
/*  54 */             if (source.is(c)) {
/*  55 */               activeSet(true);
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  64 */     this.top = new ON_TOP_RENDERABLE()
/*     */       {
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */         {
/*  68 */           RenderData.RenderIterator it = data.onScreenTiles();
/*  69 */           while (it.has()) {
/*  70 */             if (source.is(it.tile())) {
/*  71 */               int m = 0;
/*  72 */               for (DIR d : DIR.ORTHO) {
/*  73 */                 if (source.is(it.tx(), it.ty(), d))
/*  74 */                   m |= d.mask(); 
/*     */               } 
/*  76 */               (GCOLOR.MAP()).BEST_DARK.bind();
/*  77 */               (SPRITES.cons()).BIG.dashed.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/*     */             } 
/*  79 */             it.next();
/*     */           } 
/*  81 */           FirstConfig.this.top.remove();
/*  82 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void addUI(LISTE<RENDEROBJ> uis) {
/*  89 */     this.section.clear();
/*     */     
/*  91 */     (VIEW.s()).tools.placer.stealButtons(this.section);
/*     */     
/*  93 */     this.section.pad(20, 0);
/*     */     
/*  95 */     this.section.addRelBody(4, DIR.S, (RENDEROBJ)this.butt);
/*     */     
/*  97 */     this.section.body().centerX(C.DIM());
/*     */ 
/*     */ 
/*     */     
/* 101 */     this.p.setButt();
/* 102 */     this.p.inner().set((BODY_HOLDER)this.section);
/*     */ 
/*     */     
/* 105 */     this.p.setCloseAction(this.exit);
/* 106 */     this.p.setTitle(Dic.¤¤Copy);
/* 107 */     this.section.add((RENDEROBJ)this.p);
/* 108 */     this.section.moveLastToBack();
/* 109 */     this.section.body().moveY1(75.0D);
/* 110 */     this.section.body().centerX(C.DIM());
/*     */     
/* 112 */     uis.add(this.section);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(boolean UIHovered) {
/* 117 */     this.top.add();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\FirstConfig.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */