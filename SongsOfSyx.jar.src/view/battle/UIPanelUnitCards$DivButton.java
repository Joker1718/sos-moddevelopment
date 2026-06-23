/*     */ package view.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GBox;
/*     */ import view.keyboard.KEYS;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class DivButton
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final Div div;
/*     */   private final DivSelection selection;
/*     */   
/*     */   DivButton(Div div, DivSelection selection) {
/* 126 */     this.body.setDim((DIMENSION)(VIEW.UI()).div.battle);
/* 127 */     this.div = div;
/* 128 */     this.selection = selection;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 134 */     isSelected = this.selection.selected(this.div);
/* 135 */     isHovered |= this.selection.hovered(this.div);
/* 136 */     (VIEW.UI()).div.battle.render(this.div, body().x1(), body().y1(), 1, r, isActive, isSelected, isHovered);
/*     */     
/* 138 */     if (UIPanelUnitCards.this.dragging && isHovered && UIPanelUnitCards.this.clicked != null && UIPanelUnitCards.this.clicked != this && !(KEYS.MAIN()).UNDO.isPressed() && !(KEYS.MAIN()).MOD.isPressed()) {
/*     */       
/* 140 */       COLOR.GREEN100.render(r, body().x1() - 2, body().x1() + 2, body().y1(), body().y2());
/* 141 */       if (!MButt.LEFT.isDown()) {
/*     */         
/* 143 */         UIPanelUnitCards.this.army.setDivAtOrderedIndex(this.div, UIPanelUnitCards.this.clicked.div);
/* 144 */         this.selection.deSelect(UIPanelUnitCards.this.clicked.div);
/* 145 */         this.selection.select(this.div);
/* 146 */         UIPanelUnitCards.this.clicked = this;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 154 */     if ((KEYS.MAIN()).UNDO.isPressed() && UIPanelUnitCards.this.clicked != null) {
/* 155 */       int ci = UIPanelUnitCards.this.current.indexOf(this);
/* 156 */       int di = UIPanelUnitCards.this.current.indexOf(UIPanelUnitCards.this.clicked);
/* 157 */       int f = Math.min(ci, di);
/* 158 */       int t = Math.max(ci, di);
/*     */       
/* 160 */       for (int i = 0; i < UIPanelUnitCards.this.current.size(); i++) {
/* 161 */         if (i >= f && i <= t) {
/* 162 */           this.selection.select(((DivButton)UIPanelUnitCards.this.current.get(i)).div);
/*     */         } else {
/* 164 */           this.selection.deSelect(((DivButton)UIPanelUnitCards.this.current.get(i)).div);
/*     */         }
/*     */       
/*     */       } 
/* 168 */     } else if ((KEYS.MAIN()).MOD.isPressed()) {
/* 169 */       this.selection.sToggle(this.div);
/*     */     } else {
/* 171 */       for (int i = 0; i < UIPanelUnitCards.this.current.size(); i++) {
/* 172 */         this.selection.deSelect(((DivButton)UIPanelUnitCards.this.current.get(i)).div);
/*     */       }
/* 174 */       this.selection.select(this.div);
/* 175 */       UIPanelUnitCards.this.clicked = this;
/* 176 */       UIPanelUnitCards.this.dragging = true;
/* 177 */       if (MButt.LEFT.isDouble() && this.div.menNrOf() > 0) {
/* 178 */         ((VIEW.s()).battle.getWindow()).centerer.set(this.div.reporter.body().cX(), this.div.reporter.body().cY());
/* 179 */         (VIEW.b().getWindow()).centerer.set(this.div.reporter.body().cX(), this.div.reporter.body().cY());
/* 180 */         (VIEW.inters()).popup.show((RENDEROBJ)(VIEW.UI()).div.battle.hovBox(this.div), (CLICKABLE)this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 195 */     if ((VIEW.inters()).popup.showing())
/*     */       return; 
/* 197 */     this.div.hoverInfo((GBox)text);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 202 */     if (super.hover(mCoo)) {
/* 203 */       this.selection.hover(this.div);
/* 204 */       return true;
/*     */     } 
/* 206 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIPanelUnitCards$DivButton.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */