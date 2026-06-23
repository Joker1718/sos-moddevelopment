/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.diplomacy.deal.DealBool;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ class Bool
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final DealBool bool;
/*     */   
/*     */   public Bool(DealBool bool) {
/*  88 */     super(bool.info.name);
/*  89 */     this.bool = bool;
/*  90 */     icon(bool.icon);
/*  91 */     body().setDim(UIDealConfig.BW, UIDealConfig.BH);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  97 */     isActive = (this.bool.problem() == null);
/*  98 */     isSelected = this.bool.is();
/*  99 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 104 */     if (this.bool.problem() == null)
/* 105 */       this.bool.toggle(); 
/* 106 */     super.clickA();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 111 */     GBox b = (GBox)text;
/* 112 */     this.bool.hover(b);
/*     */     
/* 114 */     CharSequence p = this.bool.problem();
/* 115 */     if (p != null)
/* 116 */       b.error(p); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealConfig$Bool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */