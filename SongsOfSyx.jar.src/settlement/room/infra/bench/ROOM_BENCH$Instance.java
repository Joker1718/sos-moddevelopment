/*     */ package settlement.room.infra.bench;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomSingleton;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Instance
/*     */   extends RoomSingleton
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   Instance(ROOMS m, RoomBlueprint p) {
/* 177 */     super(m, p);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 182 */     return (blueprintI()).instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_BENCH blueprintI() {
/* 187 */     return (ROOM_BENCH)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addAction(ROOMA ins) {
/* 192 */     for (COORDINATE c : ins.body()) {
/* 193 */       if (ins.is(c)) {
/* 194 */         (SETT.ROOMS()).fData.spriteData2.set(c.x(), c.y(), 0);
/* 195 */         (blueprintI()).finder.report((FINDABLE)(blueprintI()).finder.get(c), 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeAction(ROOMA ins) {
/* 202 */     for (COORDINATE c : ins.body()) {
/* 203 */       if (ins.is(c) && (SETT.ROOMS()).fData.spriteData2.get(c) == 0) {
/* 204 */         (blueprintI()).finder.report((FINDABLE)(blueprintI()).finder.get(c), -1);
/*     */       }
/*     */     } 
/* 207 */     super.removeAction(ins);
/*     */   }
/*     */ 
/*     */   
/*     */   public int upgrade(int tx, int ty) {
/* 212 */     return CLAMP.i((SETT.ROOMS()).extraBit.get(mX(tx, ty), mY(tx, ty)), 0, blueprintI().upgrades().max());
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int tx, int ty, int upgrade) {
/* 217 */     int up = CLAMP.i(upgrade, 0, blueprintI().upgrades().max());
/* 218 */     (SETT.ROOMS()).extraBit.set(tx, ty, up);
/* 219 */     ROOMA a = (ROOMA)(SETT.ROOMS()).map.rooma.get(tx, ty);
/* 220 */     for (COORDINATE c : a.body()) {
/* 221 */       if (a.is(c))
/* 222 */         SETT.MAINTENANCE().setChanged(c.x(), c.y()); 
/* 223 */       constructor().floor(up).placeFixed(c.x(), c.y());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\bench\ROOM_BENCH$Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */