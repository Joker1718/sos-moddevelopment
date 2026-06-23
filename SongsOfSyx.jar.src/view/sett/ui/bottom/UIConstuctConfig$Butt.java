/*     */ package view.sett.ui.bottom;
/*     */ 
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.tool.PLACABLE;
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
/*     */ public class Butt
/*     */   extends GButt.Panel
/*     */ {
/*     */   private final PLACABLE p;
/*     */   
/*     */   Butt(PLACABLE p) {
/*  76 */     super(p.getIcon());
/*  77 */     this.p = p;
/*  78 */     if (paramUIConstuctConfig.placer == null)
/*  79 */       paramUIConstuctConfig.placer = p; 
/*     */   }
/*     */   
/*     */   Butt(PLACABLE p, SPRITE icon) {
/*  83 */     super(icon);
/*  84 */     this.p = p;
/*  85 */     if (paramUIConstuctConfig.placer == null) {
/*  86 */       paramUIConstuctConfig.placer = p;
/*     */     }
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  91 */     this.p.hoverDesc((GBox)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/*  96 */     UIConstuctConfig.this.placer = this.p;
/*  97 */     UIConstuctConfig.this.activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 102 */     selectedSet((this.p == UIConstuctConfig.this.placer));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\UIConstuctConfig$Butt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */