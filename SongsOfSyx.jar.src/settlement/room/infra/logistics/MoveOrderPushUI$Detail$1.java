/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   final GText t;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/* 143 */     super($anonymous0, $anonymous1);
/*     */     
/* 145 */     this.t = new GText((UI.FONT()).S, 24);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 149 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 150 */     this.t.setMaxWidth(180);
/* 151 */     this.t.setMultipleLines(false);
/* 152 */     this.t.clear();
/* 153 */     this.t.normalify();
/* 154 */     if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 155 */       this.t.add(MoveOrderPushUI.¤¤notSet);
/* 156 */       this.t.errorify();
/*     */     } else {
/* 158 */       this.t.add((CharSequence)MoveOrderPushUI.Detail.this.o.destI().name());
/*     */     } 
/* 160 */     this.t.adjustWidth();
/* 161 */     this.t.renderC(r, (RECTANGLE)this.body);
/* 162 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 167 */     text.title(placer.name());
/* 168 */     if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 169 */       text.text(MoveOrderPushUI.¤¤notSetC);
/*     */     } else {
/* 171 */       text.text(MoveOrderPushUI.¤¤setC);
/*     */     } 
/* 173 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 178 */     if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 179 */       placer.activate(MoveOrderPushUI.Detail.this.oi);
/*     */     } else {
/* 181 */       (VIEW.s().getWindow()).centererTile.set(MoveOrderPushUI.Detail.this.o.destI().body().cX(), MoveOrderPushUI.Detail.this.o.destI().body().cY());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPushUI$Detail$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */