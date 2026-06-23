/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   null(int $anonymous0) {
/* 415 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 419 */     p.icon.huge.render(r, (RECTANGLE)this.body);
/*     */ 
/*     */ 
/*     */     
/* 423 */     UIRoom.errorPrep(); byte b; int i; UIRoomModule[] arrayOfUIRoomModule;
/* 424 */     for (i = (arrayOfUIRoomModule = appliers).length, b = 0; b < i; ) { UIRoomModule a = arrayOfUIRoomModule[b];
/* 425 */       a.problem(UIRoom.free, (LISTE<CharSequence>)UIRoom.errors, (LISTE<CharSequence>)UIRoom.warnings, (Room)UIRoom.Detail.this.room, UIRoom.Detail.this.room.mX(), UIRoom.Detail.this.room.mY()); b++; }
/*     */     
/* 427 */     if (!UIRoom.errors.isEmpty() || !UIRoom.warnings.isEmpty()) {
/*     */ 
/*     */       
/* 430 */       OPACITY.O25TO100.bind();
/* 431 */       if (UIRoom.warnings.isEmpty()) {
/* 432 */         (GCOLOR.MAP()).SOSO.bind();
/*     */       } else {
/* 434 */         (GCOLOR.MAP()).BAD.bind();
/* 435 */       }  (SPRITES.icons()).m.flag.render(r, this.body.x1(), this.body.x1() + 48, this.body.y1(), this.body.y1() + 48);
/* 436 */       OPACITY.unbind();
/*     */     } 
/*     */     
/* 439 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 444 */     GBox box = (GBox)text;
/* 445 */     UIRoom.errorPrep(); byte b; int i; UIRoomModule[] arrayOfUIRoomModule;
/* 446 */     for (i = (arrayOfUIRoomModule = appliers).length, b = 0; b < i; ) { UIRoomModule a = arrayOfUIRoomModule[b];
/* 447 */       a.problem(UIRoom.free, (LISTE<CharSequence>)UIRoom.errors, (LISTE<CharSequence>)UIRoom.warnings, (Room)UIRoom.Detail.this.room, UIRoom.Detail.this.room.mX(), UIRoom.Detail.this.room.mY());
/*     */       b++; }
/*     */     
/* 450 */     for (CharSequence e : UIRoom.errors) {
/* 451 */       box.add((SPRITE)(UI.icons()).s.flag, (GCOLOR.MAP()).BAD);
/* 452 */       box.error(e);
/* 453 */       box.NL();
/*     */     } 
/* 455 */     for (CharSequence e : UIRoom.warnings) {
/* 456 */       box.add((SPRITE)(UI.icons()).s.alert, (GCOLOR.MAP()).SOSO);
/* 457 */       box.add((SPRITE)box.text().warnify().add(e));
/* 458 */       box.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoom$Detail$11.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */