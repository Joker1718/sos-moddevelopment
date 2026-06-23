/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 238 */     super($anonymous0, $anonymous1);
/*     */     
/* 240 */     this.t = new GText((UI.FONT()).S, 24);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 244 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 245 */     this.t.setMaxWidth(180);
/* 246 */     this.t.setMultipleLines(false);
/* 247 */     this.t.clear();
/* 248 */     this.t.normalify();
/* 249 */     if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 250 */       this.t.add(MoveOrderPullUI.¤¤notSet);
/* 251 */       this.t.errorify();
/*     */     } else {
/* 253 */       this.t.add((CharSequence)MoveOrderPullUI.Detail.this.o.sourceI().name());
/*     */     } 
/* 255 */     this.t.adjustWidth();
/* 256 */     this.t.renderC(r, (RECTANGLE)this.body);
/* 257 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/* 258 */     if ((((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()).length >= MoveOrderPullUI.Detail.this.oi)
/*     */       return; 
/* 260 */     if (isHovered && ((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi].source() != null) {
/* 261 */       RoomInstance ins = (RoomInstance)((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi].source();
/* 262 */       SETT.OVERLAY().add(ins.mX(), ins.mY());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 268 */     text.title(placer.name());
/* 269 */     if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 270 */       text.text(MoveOrderPullUI.¤¤notSetC);
/*     */     } else {
/* 272 */       text.text(MoveOrderPullUI.¤¤setC);
/*     */     } 
/* 274 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 279 */     if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 280 */       placer.activate(MoveOrderPullUI.Detail.this.oi);
/*     */     } else {
/* 282 */       (VIEW.s().getWindow()).centererTile.set(MoveOrderPullUI.Detail.this.o.sourceI().body().cX(), MoveOrderPullUI.Detail.this.o.sourceI().body().cY());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullUI$Detail$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */