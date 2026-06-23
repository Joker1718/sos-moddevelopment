/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.service.StatServiceImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StatRowService
/*     */   extends GuiSection
/*     */ {
/*     */   private final HCLASS cl;
/*     */   private final GETTER<Race> race;
/*     */   
/*     */   StatRowService(StatServiceImp g, HCLASS cl, GETTER<Race> race) {
/*  77 */     this.race = race;
/*  78 */     this.cl = cl;
/*     */     
/*  80 */     add(service(g), 20, 0);
/*  81 */     pad(2, 5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  86 */     super.render(r, ds);
/*  87 */     GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  92 */     if (isHoveringAHoverElement()) {
/*  93 */       super.hoverInfoGet(text);
/*     */       return;
/*     */     } 
/*  96 */     super.hoverInfoGet(text);
/*     */   }
/*     */   
/*     */   private RENDEROBJ service(final StatServiceImp ss) {
/* 100 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 103 */           if (!isHoveringAHoverElement()) {
/* 104 */             ss.total().hover(text, CatServices.StatRowService.this.cl, (Race)CatServices.StatRowService.this.race.get());
/*     */           }
/* 106 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 112 */     s.add((RENDEROBJ)new StatRow.Arrow(ss.total(), this.cl, this.race));
/*     */     
/* 114 */     s.addRightC(4, (RENDEROBJ)new GButt.Checkbox()
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 118 */             ss.permission().toggle(CatServices.StatRowService.this.cl.get((Race)CatServices.StatRowService.this.race.get()));
/* 119 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 124 */             selectedSet(ss.permission().is(CatServices.StatRowService.this.cl.get((Race)CatServices.StatRowService.this.race.get())));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 129 */             GBox b = (GBox)text;
/* 130 */             b.title((ss.permission().info()).name);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 135 */     s.addRightC(4, ss.icon);
/* 136 */     s.addRightC(4, (SPRITE)(new GText((UI.FONT()).S, ss.name)).lablifySub());
/* 137 */     s.addCentredY((SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 141 */             text.setFont((UI.FONT()).S);
/* 142 */             StatRow.format(text, ss.total(), ss.total().data(CatServices.StatRowService.this.cl).getD(CatServices.StatRowService.this.race.get()), CatServices.StatRowService.this.cl, (Race)CatServices.StatRowService.this.race.get());
/*     */           }
/* 144 */         }248);
/*     */ 
/*     */     
/* 147 */     s.addCentredY((RENDEROBJ)new RENDEROBJ.RenderImp(200, 12)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 151 */             double max = ss.total().standing().max(CatServices.StatRowService.this.cl, (Race)CatServices.StatRowService.this.race.get());
/* 152 */             double now = ss.total().standing().get(CatServices.StatRowService.this.cl, (Race)CatServices.StatRowService.this.race.get());
/* 153 */             double nor = ss.total().standing().normalized(CatServices.StatRowService.this.cl, (Race)CatServices.StatRowService.this.race.get());
/* 154 */             GMeter.render(r, GMeter.C_REDGREEN, now / max, this.body.x1(), (int)(body().x1() + body().width() * nor), body().y1(), body().y2());
/*     */           }
/* 156 */         }308);
/*     */ 
/*     */     
/* 159 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatServices$StatRowService.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */