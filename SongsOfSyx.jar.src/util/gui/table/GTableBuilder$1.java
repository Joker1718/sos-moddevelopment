/*     */ package util.gui.table;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.Scrollable;
/*     */ import util.data.GETTER;
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
/*     */   extends Scrollable.ScrollRow.ScrollRowImp
/*     */ {
/* 114 */   float clickT = 0.0F;
/*     */ 
/*     */   
/*     */   public void init(int index) {
/* 118 */     in.set(Integer.valueOf(index));
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 123 */     if (decorate) {
/* 124 */       boolean isHovered = hoveredIs();
/* 125 */       boolean isSelected = GTableBuilder.this.selectedIs(((Integer)in.get()).intValue());
/* 126 */       GButt.BSection.renderBG(r, (RECTANGLE)body(), true, isHovered, isSelected);
/*     */     } 
/* 128 */     if (this.clickT >= 0.0F)
/* 129 */       this.clickT -= ds; 
/* 130 */     super.render(r, ds);
/* 131 */     if (!GTableBuilder.this.activeIs(((Integer)in.get()).intValue())) {
/* 132 */       OPACITY.O50.bind();
/* 133 */       COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 134 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 141 */     if (super.hover(mCoo)) {
/* 142 */       GTableBuilder.this.hover(((Integer)in.get()).intValue());
/* 143 */       return true;
/*     */     } 
/* 145 */     GTableBuilder.this.hover(-1);
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 151 */     super.hoverInfoGet(text);
/* 152 */     GTableBuilder.this.hoverInfo(((Integer)in.get()).intValue(), (GBox)text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 158 */     if (!super.click()) {
/* 159 */       if (this.clickT > 0.0F) {
/* 160 */         GTableBuilder.this.doubleClick(((Integer)in.get()).intValue());
/* 161 */         this.clickT = 0.0F;
/*     */       } else {
/* 163 */         this.clickT = 0.3F;
/*     */       } 
/*     */       
/* 166 */       return true;
/*     */     } 
/* 168 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GTableBuilder$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */