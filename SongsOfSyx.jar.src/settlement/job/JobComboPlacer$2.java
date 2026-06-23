/*     */ package settlement.job;
/*     */ 
/*     */ import game.save.PROP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  78 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/*  82 */     if (j.lockText() == null) {
/*  83 */       JobComboPlacer.this.place = j;
/*  84 */       PROP.propISet(JobComboPlacer.this.selectKey, inn);
/*  85 */       (VIEW.s()).tools.place((PLACABLE)j.placer(), JobComboPlacer.this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  91 */     GBox b = (GBox)text;
/*  92 */     j.placer().hoverDesc(b);
/*  93 */     if (j.lockText() != null) {
/*  94 */       b.NL(8);
/*  95 */       b.error(j.lockText());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 102 */     selectedSet(((VIEW.s()).tools.placer.getCurrent() == j.placer()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 108 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 109 */     if (j.lockText() != null) {
/* 110 */       OPACITY.O50.bind();
/* 111 */       COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 112 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobComboPlacer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */