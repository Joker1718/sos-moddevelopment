/*     */ package view.battle.editor;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RDiv
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private DIV_SPEC div;
/*     */   private boolean exitHovered;
/*     */   
/*     */   RDiv() {
/* 117 */     this.body.setDim((VIEW.UI()).div.normal.width(), (VIEW.UI()).div.normal.height());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 122 */     (VIEW.UI()).div.normal.render(r, this.body.x1(), this.body.y1(), 1, this.div, isActive, isSelected, isHovered);
/* 123 */     if (isHovered) {
/* 124 */       if (!this.exitHovered)
/* 125 */         OPACITY.O66.bind(); 
/* 126 */       (UI.icons()).s.cancel.render(r, this.body.x2() - 16, this.body.y1());
/* 127 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 133 */     if (this.exitHovered) {
/* 134 */       ((ArmySide)ArmyDivs.this.current.get()).divs.removeOrdered(this.div);
/*     */     } else {
/* 136 */       ArmyDivs.this.editor.div().copyFrom(this.div);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 141 */     if (this.exitHovered) {
/* 142 */       text.title(Dic.¤¤remove);
/* 143 */       text.text(Dic.¤¤RightClick);
/*     */     } else {
/* 145 */       (VIEW.UI()).div.normal.hover(this.div, text);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 150 */     this.exitHovered = false;
/* 151 */     if (super.hover(mCoo)) {
/* 152 */       if (mCoo.isWithin(this.body.x2() - 16, this.body.x2(), this.body.y1(), this.body.y1() + 16))
/* 153 */         this.exitHovered = true; 
/* 154 */       if (MButt.RIGHT.consumeClick())
/* 155 */         ((ArmySide)ArmyDivs.this.current.get()).divs.removeOrdered(this.div); 
/* 156 */       return true;
/*     */     } 
/* 158 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmyDivs$RDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */