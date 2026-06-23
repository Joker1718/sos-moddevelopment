/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSingle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Placer
/*     */   extends PlacableSingle
/*     */ {
/*     */   private Room hov;
/*     */   private int hx;
/*     */   private int hy;
/*     */   private int ii;
/*     */   
/*     */   public Placer() {
/* 291 */     super(MoveOrderPushUI.¤¤name);
/*     */   }
/*     */   
/*     */   public void activate(int ii) {
/* 295 */     this.ii = ii;
/* 296 */     (VIEW.s()).tools.place((PLACABLE)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeFirst(int tx, int ty) {
/* 301 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 302 */     (VIEW.s()).tools.place(null);
/*     */ 
/*     */     
/* 305 */     if (((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[this.ii] == null) {
/* 306 */       ((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[this.ii] = new MoveOrderPush((RoomInstance)r);
/*     */     } else {
/* 308 */       ((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[this.ii].destSet((RoomInstance)r);
/* 309 */     }  (VIEW.s()).ui.rooms.open((RoomInstance)MoveOrderPushUI.this.room.get());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 315 */     if (tx == VIEW.s().getWindow().tile().x() && ty == VIEW.s().getWindow().tile().y()) {
/* 316 */       SCompFinder.SCompPath pp = (SETT.PATH()).comps.pather.findDest(((RoomInstance)MoveOrderPushUI.this.room.get()).mX(), ((RoomInstance)MoveOrderPushUI.this.room.get()).mY(), tx, ty);
/* 317 */       if (pp == null) {
/* 318 */         return Dic.¤¤Unreachable;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 323 */     return pp(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   private CharSequence pp(int tx, int ty) {
/* 328 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 329 */     this.hov = null;
/* 330 */     if (r != null && r != MoveOrderPushUI.this.source.get() && r instanceof MoveJob.ROOM_MOVE_DEST) {
/* 331 */       this.hov = r;
/* 332 */       this.hx = tx;
/* 333 */       this.hy = ty;
/* 334 */       return null;
/*     */     } 
/* 336 */     return MoveOrderPushUI.¤¤Choose;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int tiles) {
/* 341 */     if (this.hov != null) {
/* 342 */       (VIEW.s()).ui.rooms.hover(b, this.hov, this.hx, this.hy);
/* 343 */       this.hov = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 349 */     return (SPRITE)(UI.icons()).m.crossair;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 354 */     if (pp(fromX, fromY) == null && (SETT.ROOMS()).map.get(fromX, fromY) == (SETT.ROOMS()).map.get(toX, toY))
/* 355 */       return true; 
/* 356 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPushUI$Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */