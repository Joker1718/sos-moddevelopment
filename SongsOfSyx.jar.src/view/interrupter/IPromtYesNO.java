/*     */ package view.interrupter;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ public class IPromtYesNO
/*     */   extends Interrupter
/*     */ {
/*  28 */   private final GTextR text = new GTextR((UI.FONT()).M, 1000, DIR.C);
/*  29 */   private final GuiSection section = new GuiSection();
/*  30 */   private final GPanel box = (new GPanel()).setDim(800, 400);
/*     */   
/*  32 */   private final ACTION close = new ACTION()
/*     */     {
/*     */       public void exe() {
/*  35 */         IPromtYesNO.this.deactivate();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  40 */   private final GButt.ButtPanel yes = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.ok)
/*     */     {
/*     */       protected void clickA() {
/*  43 */         IPromtYesNO.this.hide();
/*     */       }
/*     */     };
/*  46 */   private final GButt.ButtPanel no = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel)
/*     */     {
/*     */       protected void clickA() {
/*  49 */         IPromtYesNO.this.hide();
/*     */       }
/*     */     };
/*     */   private boolean dismissable;
/*     */   private final InterManager m;
/*     */   
/*     */   public IPromtYesNO(InterManager manager) {
/*  56 */     this.m = manager;
/*  57 */     this.text.text().lablify();
/*  58 */     this.section.add((RENDEROBJ)this.box);
/*  59 */     this.section.body().centerIn(C.DIM());
/*  60 */     this.box.setBig();
/*     */     
/*  62 */     this.yes.body.setWidth(100.0D);
/*  63 */     this.no.body.setWidth(100.0D);
/*  64 */     this.yes.hoverInfoSet(Dic.¤¤Yes);
/*  65 */     this.no.hoverInfoSet(Dic.¤¤No);
/*     */     
/*  67 */     GuiSection butts = new GuiSection();
/*     */     
/*  69 */     butts.add((RENDEROBJ)this.yes).addRight(0, (RENDEROBJ)this.no);
/*     */     
/*  71 */     butts.body().centerX((BODY_HOLDER)this.section);
/*  72 */     butts.body().moveY2((this.section.body().y2() - 16));
/*  73 */     this.section.add((RENDEROBJ)butts);
/*     */     
/*  75 */     this.text.text().setMaxWidth(800);
/*     */     
/*  77 */     this.section.add((RENDEROBJ)this.text);
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean tmp = false;
/*     */   
/*     */   public void activate(CharSequence message, ACTION yesAction, ACTION noAction, boolean dismissable) {
/*  84 */     show(this.m);
/*     */     
/*  86 */     this.dismissable = dismissable;
/*     */     
/*  88 */     this.section.clear();
/*  89 */     this.text.text().set(message);
/*  90 */     this.text.adjust();
/*  91 */     if (this.text.body().width() < 600)
/*  92 */       this.section.body().setDim(600.0D, 1.0D); 
/*  93 */     this.section.addDownC(0, (RENDEROBJ)this.text);
/*  94 */     this.yes.clickActionSet(yesAction);
/*     */     
/*  96 */     if (noAction != null) {
/*  97 */       int cx = this.section.body().cX();
/*  98 */       this.no.clickActionSet(noAction);
/*  99 */       this.section.add((RENDEROBJ)this.yes, cx - this.yes.body.width(), this.section.getLastY2() + 16);
/* 100 */       this.section.add((RENDEROBJ)this.no, cx, this.section.getLastY1());
/*     */     } else {
/* 102 */       this.section.addDownC(16, (RENDEROBJ)this.yes);
/*     */     } 
/*     */     
/* 105 */     this.section.body().centerIn(C.DIM());
/*     */     
/* 107 */     this.box.setCloseAction(dismissable ? this.close : null);
/* 108 */     this.box.inner().set((RECTANGLE)this.section.body());
/* 109 */     this.section.add((RENDEROBJ)this.box);
/* 110 */     this.section.moveLastToBack();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deactivate() {
/* 121 */     hide();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 126 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 131 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 137 */     if (button == MButt.LEFT) {
/* 138 */       this.section.click();
/* 139 */     } else if (this.dismissable && button == MButt.RIGHT) {
/* 140 */       deactivate();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 145 */     this.section.hover(mCoo);
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 151 */     if ((KEYS.MAIN()).ESCAPE.consumeClick()) {
/* 152 */       deactivate();
/* 153 */       return true;
/*     */     } 
/* 155 */     KEYS.clear();
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSave() {
/* 161 */     return this.dismissable;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IPromtYesNO.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */