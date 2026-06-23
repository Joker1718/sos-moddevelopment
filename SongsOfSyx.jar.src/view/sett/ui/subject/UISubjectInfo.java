/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GFrame;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class UISubjectInfo
/*     */   extends GuiSection
/*     */ {
/*     */   public static final int width = 560;
/*     */   
/*     */   UISubjectInfo(final AInfo a, int height, HTYPE t) {
/*  29 */     HOVERABLE.HoverableAbs hoverableAbs = new HOVERABLE.HoverableAbs(176, 272)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/*  33 */           (a.a.indu().hType()).color.render(r, (RECTANGLE)body());
/*  34 */           GFrame.render(r, body().x1(), body().x2(), body().y1(), body().y2());
/*     */           
/*  36 */           STATS.APPEARANCE().portraitRender(r, a.a.indu(), this.body.x1() + 8, body().y1() + 8, 4);
/*     */ 
/*     */           
/*  39 */           OPACITY.O25TO100.bind();
/*  40 */           if (SProblem.problem(a.a) != null) {
/*  41 */             (GCOLOR.UI()).BAD.hovered.bind();
/*  42 */             (UI.icons()).s.flag.renderScaled(r, body().x1() + 8, body().y1() + 8, 2);
/*     */           }
/*  44 */           else if (SProblem.warning(a.a) != null) {
/*  45 */             (GCOLOR.UI()).SOSO.hovered.bind();
/*  46 */             (UI.icons()).s.flag.renderScaled(r, body().x1() + 8, body().y1() + 8, 2);
/*     */           } 
/*  48 */           OPACITY.unbind();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  53 */           GBox b = (GBox)text;
/*  54 */           if (SProblem.problem(a.a) != null) {
/*  55 */             b.add((SPRITE)b.text().errorify().add(SProblem.problem(a.a)));
/*     */           
/*     */           }
/*  58 */           else if (SProblem.warning(a.a) != null) {
/*  59 */             b.add((SPRITE)b.text().warnify().add(SProblem.warning(a.a)));
/*     */           } 
/*  61 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/*  65 */     UISubjectEquip uISubjectEquip = new UISubjectEquip(a, t);
/*  66 */     UISubjectActions uISubjectActions = new UISubjectActions(a, t);
/*     */     
/*  68 */     int w = Math.max(uISubjectEquip.body().width(), uISubjectActions.body().width()) + 16;
/*  69 */     body().setWidth((w * 2 + hoverableAbs.body().width()));
/*  70 */     addC((RENDEROBJ)hoverableAbs, body().cX(), 0);
/*     */     
/*  72 */     uISubjectEquip.body().moveCY(body().cY());
/*  73 */     uISubjectEquip.body().moveCX((body().x1() + w / 2));
/*  74 */     add((RENDEROBJ)uISubjectEquip);
/*     */     
/*  76 */     uISubjectActions.body().moveCY(body().cY());
/*  77 */     uISubjectActions.body().moveCX((body().x2() - w / 2));
/*  78 */     add((RENDEROBJ)uISubjectActions);
/*  79 */     addRelBody(8, DIR.S, (RENDEROBJ)top(a));
/*     */     
/*  81 */     addRelBody(4, DIR.S, (RENDEROBJ)new SInfoDesc(a, height - body().height()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static GuiSection top(final AInfo a) {
/*  87 */     GuiSection s = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/*  91 */     s.addRelBody(2, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(500, (UI.FONT()).H2.height())
/*     */         {
/*  93 */           final GText name = new GText((UI.FONT()).H2, 24);
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/*  96 */             (GCOLOR.T()).H2.bind();
/*  97 */             this.name.clear();
/*  98 */             this.name.add(STATS.APPEARANCE().name(a.a.indu()));
/*  99 */             this.name.setMaxWidth(550);
/* 100 */             this.name.setMultipleLines(false);
/* 101 */             this.name.lablify();
/* 102 */             this.name.adjustWidth();
/* 103 */             this.name.renderC(r, body().cX(), body().cY());
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 109 */     s.addRelBody(2, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(400, (UI.FONT()).S.height())
/*     */         {
/* 111 */           GText text = new GText((UI.FONT()).S, 36);
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 115 */             this.text.clear();
/* 116 */             a.a.ai().getOccupation(a.a, (Str)this.text);
/* 117 */             this.text.normalify();
/* 118 */             this.text.adjustWidth();
/* 119 */             this.text.renderC(r, body().cX(), body().cY());
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 125 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */