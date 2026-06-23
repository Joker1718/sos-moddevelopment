/*     */ package view.interrupter;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.panel.GPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Inter
/*     */   extends Interrupter
/*     */ {
/*     */   private boolean hidden = true;
/*     */   private final GPanel box;
/*     */   
/* 133 */   ACTION exit = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/* 137 */         if (IPopup.Inter.this.hidden)
/*     */           return; 
/* 139 */         IPopup.Inter.this.hide();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   Inter(GuiSection s) {
/* 145 */     this.box = new GPanel();
/* 146 */     this.box.setButt();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 151 */     IPopup.this.s.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 156 */     if (button == MButt.RIGHT) {
/* 157 */       hide();
/* 158 */     } else if (button == MButt.LEFT && 
/* 159 */       !IPopup.this.s.click()) {
/* 160 */       this.box.click();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 166 */     if (IPopup.this.old != null) {
/* 167 */       IPopup.this.show(IPopup.this.old, IPopup.this.oldC);
/*     */     } else {
/* 169 */       super.hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean otherClick(MButt butt) {
/* 175 */     hide();
/* 176 */     if (butt == MButt.RIGHT)
/* 177 */       return true; 
/* 178 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void otherAdd(Interrupter other) {
/* 183 */     hide();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 188 */     return !(!IPopup.this.s.hover(mCoo) && !this.box.hover(mCoo));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 193 */     this.hidden = false;
/* 194 */     this.box.inner().set((BODY_HOLDER)IPopup.this.s);
/* 195 */     this.box.clickActionSet(this.exit);
/* 196 */     this.box.render((SPRITE_RENDERER)r, ds);
/*     */     
/* 198 */     IPopup.this.s.render((SPRITE_RENDERER)r, ds);
/* 199 */     if (IPopup.this.trigger != null) {
/* 200 */       IPopup.this.trigger.selectTmp();
/*     */     }
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 210 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IPopup$Inter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */