/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PlacerUIButt
/*     */   extends GuiSection
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   private final int off;
/*     */   
/*     */   public PlacerUIButt(GETTER<Integer> ier, int off) {
/* 492 */     this.ier = ier;
/* 493 */     this.off = off;
/* 494 */     body().setWidth(100.0D).setHeight(24.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 499 */     int i = ((Integer)this.ier.get()).intValue() * 4 + this.off;
/* 500 */     if (i < 0 || i >= MoveOrderPullUI.prooms.size())
/*     */       return; 
/* 502 */     MoveJob.ROOM_MOVE_SOURCE s = (MoveJob.ROOM_MOVE_SOURCE)MoveOrderPullUI.prooms.get(i);
/*     */     
/* 504 */     boolean sel = s.moveCapacity().has(((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrderPullAccepted());
/*     */ 
/*     */     
/* 507 */     GButt.ButtPanel.renderBG(r, sel, false, hoveredIs(), (RECTANGLE)body());
/* 508 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */ 
/*     */ 
/*     */     
/* 512 */     if (s instanceof RoomInstance) {
/* 513 */       RoomInstance ins = (RoomInstance)s;
/* 514 */       (ins.blueprintI()).icon.small.render(r, body().x1() + 4, body().y1() + 4);
/* 515 */       if (hoveredIs() && (KEYS.MAIN()).MOD.isPressed()) {
/* 516 */         (VIEW.s().getWindow()).centererTile.set(ins.body().cX(), ins.body().cY());
/*     */       }
/*     */       
/* 519 */       SETT.OVERLAY().add(ins.mX(), ins.mY());
/*     */     } 
/*     */     
/* 522 */     int x1 = body().x1() + 32;
/*     */     
/* 524 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 525 */       if (s.moveCapacity().has(res) && ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrderPullAccepted().has(res)) {
/* 526 */         (res.icon()).small.render(r, x1, body().y1() + 4);
/* 527 */         x1 += 16;
/* 528 */         if (x1 + 16 > body().x2()) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 534 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 539 */     int i = ((Integer)this.ier.get()).intValue() * 4 + this.off;
/* 540 */     if (i < 0 || i >= MoveOrderPullUI.prooms.size()) {
/*     */       return;
/*     */     }
/* 543 */     GBox b = (GBox)text;
/*     */     
/* 545 */     GText t = b.text();
/* 546 */     t.add(MoveOrderPullUI.¤¤hold);
/* 547 */     t.insert(0, (KEYS.MAIN()).MOD.repr());
/* 548 */     t.warnify();
/* 549 */     b.add((SPRITE)t);
/* 550 */     b.sep();
/*     */ 
/*     */     
/* 553 */     MoveJob.ROOM_MOVE_SOURCE s = (MoveJob.ROOM_MOVE_SOURCE)MoveOrderPullUI.prooms.get(i);
/* 554 */     if (s instanceof RoomInstance) {
/* 555 */       RoomInstance ins = (RoomInstance)s;
/* 556 */       (VIEW.s()).ui.rooms.hover(b, (Room)ins, ins.mX(), ins.mY());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 561 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 566 */     int i = ((Integer)this.ier.get()).intValue() * 4 + this.off;
/* 567 */     if (i < 0 || i >= MoveOrderPullUI.prooms.size())
/*     */       return; 
/* 569 */     MoveJob.ROOM_MOVE_SOURCE s = (MoveJob.ROOM_MOVE_SOURCE)MoveOrderPullUI.prooms.get(i);
/* 570 */     if (((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII] == null) {
/* 571 */       ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII] = new MoveOrderPull((RoomInstance)s, ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrderPullAccepted());
/*     */     } else {
/* 573 */       ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII].destSet((RoomInstance)s);
/* 574 */     }  (VIEW.s()).tools.place(null);
/* 575 */     (VIEW.s()).ui.rooms.open((RoomInstance)MoveOrderPullUI.this.room.get());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 580 */     super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullUI$PlacerUIButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */