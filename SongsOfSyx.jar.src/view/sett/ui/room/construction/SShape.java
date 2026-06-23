/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ final class SShape
/*     */ {
/*  23 */   private static CharSequence ¤¤Expand = "Expand room. Items can only be placed on the designated room area.";
/*  24 */   private static CharSequence ¤¤ExpandOver = "Expand room over existing structures";
/*  25 */   private static CharSequence ¤¤Overlay = "Toggle overlay";
/*  26 */   private static CharSequence ¤¤Shrink = "Shrink Room";
/*     */   
/*     */   static {
/*  29 */     D.ts(SShape.class);
/*     */   }
/*     */   
/*  32 */   private final GuiSection ss = new GuiSection()
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds)
/*     */       {
/*  36 */         super.render(r, ds);
/*  37 */         boolean b = !((VIEW.s()).tools.placer.getCurrent() != SShape.this.s.placement.placer.area() && (VIEW.s()).tools.placer.getCurrent() != SShape.this.s.placement.placer.area().getUndo());
/*  38 */         if (b)
/*  39 */           (SETT.ROOMS()).placement.placer.renderExpense(); 
/*     */       }
/*     */     };
/*     */   
/*  43 */   private final GuiSection pButts = new GuiSection(); private final State s;
/*  44 */   private final GuiSection butts = new GuiSection();
/*     */   
/*  46 */   private final GHeader title = (new GHeader(Dic.¤¤Shape)).subify();
/*     */ 
/*     */ 
/*     */   
/*  50 */   private final CLICKABLE buttExpand = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.expand)
/*     */     {
/*     */       protected void clickA()
/*     */       {
/*  54 */         SShape.this.s.placement.placer.buildOnWalls.set(false);
/*  55 */         (VIEW.s()).tools.place(SShape.this.s.placement.placer.area(), SShape.this.s.config);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/*  60 */         selectedSet(((VIEW.s()).tools.placer.getCurrent() == SShape.this.s.placement.placer.area() && !SShape.this.s.placement.placer.buildOnWalls.is()));
/*     */       }
/*  62 */     }).hoverInfoSet(¤¤Expand);
/*     */   
/*  64 */   final CLICKABLE buttExpandWalls = (new GButt.ButtPanel((SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.expand, (SPRITE)(SPRITES.icons()).m.plus))
/*     */     {
/*     */       protected void clickA()
/*     */       {
/*  68 */         SShape.this.s.placement.placer.buildOnWalls.set(true);
/*  69 */         (VIEW.s()).tools.place(SShape.this.s.placement.placer.area(), SShape.this.s.config);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/*  74 */         selectedSet(((VIEW.s()).tools.placer.getCurrent() == SShape.this.s.placement.placer.area() && SShape.this.s.placement.placer.buildOnWalls.is()));
/*     */       }
/*  76 */     }).hoverInfoSet(¤¤ExpandOver);
/*     */   
/*  78 */   final CLICKABLE buttOverlay = (CLICKABLE)new GButt.ButtPanel((UI.icons()).s.eye.sized(24))
/*     */     {
/*     */       protected void clickA()
/*     */       {
/*  82 */         SShape.this.s.placement.placer.showOverlay.toggle();
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/*  87 */         selectedSet(SShape.this.s.placement.placer.showOverlay.is());
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/*  92 */         text.title(SShape.¤¤Overlay);
/*  93 */         if (SShape.this.s.placement.placer.blueprint().constructor().overlay() != null && (SShape.this.s.placement.placer.blueprint().constructor().overlay()).desc != null) {
/*  94 */           text.text((SShape.this.s.placement.placer.blueprint().constructor().overlay()).desc);
/*     */         }
/*     */       }
/*     */     };
/*     */   
/*  99 */   private final CLICKABLE buttShrink = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.shrink)
/*     */     {
/*     */       protected void clickA()
/*     */       {
/* 103 */         (VIEW.s()).tools.place(SShape.this.s.placement.placer.area().getUndo(), SShape.this.s.config);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/* 108 */         bg((GCOLOR.UI()).BAD.normal);
/* 109 */         selectedSet(((VIEW.s()).tools.placer.getCurrent() == SShape.this.s.placement.placer.area().getUndo()));
/*     */       }
/* 112 */     }).hoverInfoSet(¤¤Shrink);
/*     */ 
/*     */   
/*     */   SShape(State s) {
/* 116 */     this.s = s;
/*     */   }
/*     */   
/*     */   GuiSection get() {
/* 120 */     this.ss.clear();
/*     */     
/* 122 */     this.ss.add((RENDEROBJ)this.title);
/*     */     
/* 124 */     this.butts.clear();
/* 125 */     this.butts.add((RENDEROBJ)this.buttExpand, 0, 0);
/* 126 */     this.butts.addRightC(2, (RENDEROBJ)this.buttExpandWalls);
/* 127 */     if ((SETT.ROOMS()).placement.placer.blueprint().constructor().overlay() != null)
/* 128 */       this.butts.addRightC(2, (RENDEROBJ)this.buttOverlay); 
/* 129 */     this.butts.addRightC(2, (RENDEROBJ)this.buttShrink);
/*     */     
/* 131 */     this.butts.body().incrW((this.buttExpand.body().width() + 10));
/*     */     
/* 133 */     this.ss.addRelBody(4, DIR.S, (RENDEROBJ)this.butts);
/*     */ 
/*     */     
/* 136 */     this.pButts.clear();
/* 137 */     this.pButts.body().setDim(1.0D, 32.0D);
/* 138 */     if ((VIEW.s()).tools.placer.getCurrent() == this.s.placement.placer.area() || (VIEW.s()).tools.placer.getCurrent() == this.s.placement.placer.area().getUndo())
/* 139 */       (VIEW.s()).tools.placer.stealButtons(this.pButts, true); 
/* 140 */     this.ss.addRelBody(0, DIR.S, (RENDEROBJ)this.pButts);
/*     */ 
/*     */     
/* 143 */     return this.ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SShape.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */