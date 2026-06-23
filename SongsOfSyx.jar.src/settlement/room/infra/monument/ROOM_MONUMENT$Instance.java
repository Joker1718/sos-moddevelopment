/*     */ package settlement.room.infra.monument;
/*     */ 
/*     */ import settlement.main.SETT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 214 */     super(m, p);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 219 */     return (blueprintI()).instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_MONUMENT blueprintI() {
/* 224 */     return (ROOM_MONUMENT)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addAction(ROOMA ins) {
/* 229 */     (blueprintI()).area += ins.area();
/* 230 */     (blueprintI()).area = CLAMP.i((blueprintI()).area, 0, SETT.TAREA);
/* 231 */     (blueprintI()).degrade = (int)((blueprintI()).degrade + ins.area() * getDegrade(ins.mX(), ins.mY()));
/* 232 */     (blueprintI()).upgrade += ins.area() * upgrade(ins.mX(), ins.mY());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction(ROOMA ins) {
/* 238 */     (blueprintI()).area -= ins.area();
/* 239 */     (blueprintI()).area = CLAMP.i((blueprintI()).area, 0, SETT.TAREA);
/* 240 */     (blueprintI()).degrade = (int)((blueprintI()).degrade - ins.area() * getDegrade(ins.mX(), ins.mY()));
/* 241 */     (blueprintI()).upgrade -= ins.area() * upgrade(ins.mX(), ins.mY());
/* 242 */     super.removeAction(ins);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void degradeChange(int mx, int my, double oldD, double newD, boolean realDegradeChange) {
/* 247 */     (blueprintI()).degrade = (int)((blueprintI()).degrade - area(mx, my) * oldD);
/* 248 */     super.degradeChange(mx, my, oldD, newD, realDegradeChange);
/* 249 */     (blueprintI()).degrade = (int)((blueprintI()).degrade + area(mx, my) * oldD);
/* 250 */     if (realDegradeChange) {
/* 251 */       (SETT.ENV()).map.MONUMENT.changeDegrade(mx, my);
/*     */     }
/*     */   }
/*     */   
/*     */   public int upgrade(int tx, int ty) {
/* 256 */     return CLAMP.i((SETT.ROOMS()).extraBit.get(mX(tx, ty), mY(tx, ty)), 0, blueprintI().upgrades().max());
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int tx, int ty, int upgrade) {
/* 261 */     if (upgrade == upgrade(tx, ty))
/*     */       return; 
/* 263 */     (blueprintI()).upgrade -= area(tx, ty) * upgrade(tx, ty);
/* 264 */     int up = CLAMP.i(upgrade, 0, blueprintI().upgrades().max());
/* 265 */     (SETT.ROOMS()).extraBit.set(tx, ty, up);
/* 266 */     (blueprintI()).upgrade += area(tx, ty) * upgrade(tx, ty);
/* 267 */     ROOMA a = (ROOMA)(SETT.ROOMS()).map.rooma.get(tx, ty);
/* 268 */     for (COORDINATE c : a.body()) {
/* 269 */       if (a.is(c))
/* 270 */         SETT.MAINTENANCE().setChanged(c.x(), c.y()); 
/*     */     } 
/* 272 */     (SETT.ENV()).map.MONUMENT.changeUpgrade(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\ROOM_MONUMENT$Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */