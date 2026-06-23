/*     */ package view.sett.ui.bottom;
/*     */ 
/*     */ import init.constant.C;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ class UIConstuctConfig implements ToolConfig {
/*     */   protected CharSequence name;
/*  22 */   protected GuiSection section = new GuiSection();
/*  23 */   private final GPanel panel = new GPanel();
/*  24 */   private GuiSection full = new GuiSection();
/*  25 */   ACTION exit = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  29 */         (VIEW.s()).tools.placer.deactivate();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   PLACABLE placer;
/*     */   
/*     */   protected UIConstuctConfig(CharSequence name) {
/*  37 */     this.name = name;
/*  38 */     this.panel.setButt();
/*  39 */     this.panel.setTitle(name);
/*     */   }
/*     */   
/*     */   public void activate() {
/*  43 */     (VIEW.s()).tools.place(this.placer, this);
/*     */   }
/*     */   
/*     */   public boolean isActive() {
/*  47 */     return ((VIEW.s()).tools.configCurrent() == this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addUI(LISTE<RENDEROBJ> uis) {
/*  53 */     this.full.clear();
/*     */     
/*  55 */     (VIEW.s()).tools.placer.stealButtons(this.full);
/*  56 */     if (this.placer.getAdditionalButt() != null)
/*  57 */       for (CLICKABLE p : this.placer.getAdditionalButt())
/*  58 */         this.full.addRightC(0, (RENDEROBJ)p);  
/*  59 */     this.full.body().centerX(C.DIM());
/*  60 */     this.full.addRelBody(8, DIR.N, (RENDEROBJ)this.section);
/*     */     
/*  62 */     this.panel.setButt();
/*  63 */     this.panel.inner().set((BODY_HOLDER)this.full);
/*  64 */     this.panel.clickActionSet(this.exit);
/*  65 */     this.full.add((RENDEROBJ)this.panel);
/*  66 */     this.full.moveLastToBack();
/*  67 */     this.full.body().moveY1(75.0D);
/*  68 */     uis.add(this.full);
/*     */   }
/*     */   
/*     */   protected class Butt
/*     */     extends GButt.Panel {
/*     */     private final PLACABLE p;
/*     */     
/*     */     Butt(PLACABLE p) {
/*  76 */       super(p.getIcon());
/*  77 */       this.p = p;
/*  78 */       if (UIConstuctConfig.this.placer == null)
/*  79 */         UIConstuctConfig.this.placer = p; 
/*     */     }
/*     */     
/*     */     Butt(PLACABLE p, SPRITE icon) {
/*  83 */       super(icon);
/*  84 */       this.p = p;
/*  85 */       if (UIConstuctConfig.this.placer == null) {
/*  86 */         UIConstuctConfig.this.placer = p;
/*     */       }
/*     */     }
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/*  91 */       this.p.hoverDesc((GBox)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/*  96 */       UIConstuctConfig.this.placer = this.p;
/*  97 */       UIConstuctConfig.this.activate();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 102 */       selectedSet((this.p == UIConstuctConfig.this.placer));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\UIConstuctConfig.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */