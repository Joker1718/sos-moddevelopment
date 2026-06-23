/*     */ package view.interrupter;
/*     */ import init.constant.C;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.panel.GPanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class IPopCurrent extends Interrupter {
/*  17 */   public final GuiSection expansion = new GuiSection();
/*     */   private CLICKABLE trigger;
/*  19 */   private final GPanel panel = new GPanel();
/*     */ 
/*     */   
/*     */   public IPopCurrent() {
/*  23 */     this.panel.setCloseAction(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  27 */             IPopCurrent.this.hide();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  34 */     return this.panel.hover(mCoo) | this.expansion.hover(mCoo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  41 */     if (button == MButt.LEFT) {
/*  42 */       this.expansion.click();
/*  43 */       this.panel.click();
/*     */     } 
/*  45 */     if (this.panel.hoveredIs()) {
/*  46 */       MButt.clearWheelSpin();
/*  47 */     } else if (button == MButt.RIGHT) {
/*  48 */       hide();
/*     */     } 
/*     */   }
/*     */   public void show(CLICKABLE trigger) {
/*  52 */     if (isActivated()) {
/*  53 */       hide();
/*     */     }
/*  55 */     this.panel.inner().set((BODY_HOLDER)this.expansion);
/*     */     
/*  57 */     this.panel.body().moveC(trigger.body().cX(), 0.0D);
/*  58 */     this.panel.body().moveY1(trigger.body().y2());
/*  59 */     if (this.panel.body().y2() > C.HEIGHT())
/*  60 */       this.panel.body().moveY2(trigger.body().y2()); 
/*  61 */     if (this.panel.body.x2() > C.WIDTH() - 32)
/*  62 */       this.panel.body.moveX2((C.WIDTH() - 32)); 
/*  63 */     if (this.panel.body.x1() < 32) {
/*  64 */       this.panel.body.moveX1(32.0D);
/*     */     }
/*  66 */     this.expansion.body().centerIn((RECTANGLE)this.panel.inner());
/*  67 */     show((VIEW.current()).uiManager);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean otherClick(MButt button) {
/*  73 */     hide();
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/*  79 */     super.hide();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/*  84 */     this.expansion.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/*  89 */     this.panel.inner().set((BODY_HOLDER)this.expansion);
/*  90 */     this.panel.body.centerIn((BODY_HOLDER)this.expansion);
/*  91 */     this.panel.render((SPRITE_RENDERER)r, ds);
/*  92 */     this.expansion.render((SPRITE_RENDERER)r, ds);
/*  93 */     if (this.trigger != null)
/*  94 */       this.trigger.selectTmp(); 
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 100 */     if (KEYS.anyDown())
/* 101 */       hide(); 
/* 102 */     if (this.panel.hoveredIs())
/* 103 */       MButt.clearWheelSpin(); 
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void otherAdd(Interrupter other) {
/* 109 */     hide();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IPopCurrent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */