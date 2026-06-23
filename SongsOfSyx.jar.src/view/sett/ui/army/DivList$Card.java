/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
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
/*     */ 
/*     */ class Card
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final int di;
/*     */   
/*     */   Card(int di) {
/* 123 */     super((VIEW.UI()).div.settCivic.width() * DivList.scale, (VIEW.UI()).div.settCivic.height() * DivList.scale);
/* 124 */     this.di = di;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 129 */     Div div = div();
/* 130 */     (VIEW.UI()).div.settCivic.render(r, this.body.x1(), this.body.y1(), DivList.scale, div, isActive, isSelected, isHovered);
/*     */ 
/*     */ 
/*     */     
/* 134 */     if (DivList.this.dragging && isHovered && DivList.this.clicked != null && DivList.this.clicked != this && !(KEYS.MAIN()).UNDO.isPressed() && !(KEYS.MAIN()).MOD.isPressed()) {
/*     */       
/* 136 */       COLOR.GREEN100.render(r, body().x1() - 2, body().x1() + 2, body().y1(), body().y2());
/* 137 */       if (!MButt.LEFT.isDown()) {
/*     */         
/* 139 */         GAME.ARMIES().player().setDivAtOrderedIndex(div(), DivList.this.clicked.div());
/* 140 */         DivList.this.clicked.selectedSet(false);
/* 141 */         selectedSet(true);
/* 142 */         DivList.this.clicked = this;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 152 */     if ((KEYS.MAIN()).UNDO.isPressed() && DivList.this.clicked != null) {
/* 153 */       int ci = DivList.this.current.indexOf(this);
/* 154 */       int di = DivList.this.current.indexOf(DivList.this.clicked);
/* 155 */       int f = Math.min(ci, di);
/* 156 */       int t = Math.max(ci, di);
/*     */       
/* 158 */       for (int i = 0; i < DivList.this.current.size(); i++) {
/* 159 */         ((Card)DivList.this.current.get(i)).selectedSet((i >= f && i <= t));
/*     */       
/*     */       }
/*     */     }
/* 163 */     else if ((KEYS.MAIN()).MOD.isPressed()) {
/* 164 */       selectedSet(!selectedIs());
/*     */     } else {
/* 166 */       for (int i = 0; i < DivList.this.current.size(); i++) {
/* 167 */         ((Card)DivList.this.current.get(i)).selectedSet(false);
/*     */       }
/* 169 */       selectedSet(true);
/* 170 */       DivList.this.clicked = this;
/* 171 */       DivList.this.dragging = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 178 */     (VIEW.UI()).div.settCivic.hover(text, div());
/*     */   }
/*     */   
/*     */   private Div div() {
/* 182 */     return (Div)GAME.ARMIES().player().ordered().get(this.di);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\DivList$Card.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */