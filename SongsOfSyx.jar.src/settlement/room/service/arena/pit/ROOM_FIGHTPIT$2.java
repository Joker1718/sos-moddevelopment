/*     */ package settlement.room.service.arena.pit;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.arena.RoomArenaWork;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements RoomArenaWork
/*     */ {
/*     */   public void unreserveDeath(int tx, int ty) {
/* 260 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(tx, ty);
/* 261 */     if (ins != null) {
/* 262 */       ins.reserveGladiator(-1);
/*     */     }
/*     */   }
/*     */   
/*     */   public RoomInstance reserveDeath(COORDINATE coo) {
/* 267 */     if (ROOM_FIGHTPIT.this.gladiatorMax == 0 || ROOM_FIGHTPIT.this.gladiators >= ROOM_FIGHTPIT.this.gladiatorMax) {
/* 268 */       return null;
/*     */     }
/*     */     
/* 271 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(coo);
/* 272 */     if (ins != null && ins.gladiatorsNeeded() > 0) {
/* 273 */       ins.reserveGladiator(1);
/* 274 */       return ins;
/*     */     } 
/*     */ 
/*     */     
/* 278 */     int ri = RND.rInt(ROOM_FIGHTPIT.this.instancesSize());
/*     */     
/* 280 */     for (int i = 0; i < ROOM_FIGHTPIT.this.instancesSize(); i++) {
/* 281 */       ArenaInstance arenaInstance = (ArenaInstance)ROOM_FIGHTPIT.this.getInstance((i + ri) % ROOM_FIGHTPIT.this.instancesSize());
/* 282 */       if (arenaInstance.gladiatorsNeeded() > 0) {
/* 283 */         arenaInstance.reserveGladiator(1);
/* 284 */         return arenaInstance;
/*     */       } 
/*     */     } 
/* 287 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean gladiatorInArena(int tx, int ty) {
/* 292 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(tx, ty);
/* 293 */     return (ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE gladiatorGetSpot(RoomInstance i) {
/* 298 */     ArenaInstance ins = (ArenaInstance)i;
/* 299 */     int w = ins.body().width() - ins.ax * 2;
/* 300 */     int h = ins.body().height() - ins.ay * 2;
/* 301 */     ROOM_FIGHTPIT.this.coo.set((ins.body().x1() + ins.ax + RND.rInt(w)), (ins.body().y1() + ins.ay + RND.rInt(h)));
/* 302 */     if (!gladiatorInArena(ROOM_FIGHTPIT.this.coo.x(), ROOM_FIGHTPIT.this.coo.y()))
/* 303 */       throw new RuntimeException(String.valueOf(ROOM_FIGHTPIT.this.coo)); 
/* 304 */     return (COORDINATE)ROOM_FIGHTPIT.this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public void gladiatorDrawMakeSheer(COORDINATE coo) {
/* 309 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(coo);
/* 310 */     if (ins != null) {
/* 311 */       ins.cheerTime = (int)TIME.currentSecond();
/* 312 */       ins.cheer = !RND.oneIn(6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RECTANGLE gladiatorArea(int tx, int ty) {
/* 319 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(tx, ty);
/* 320 */     if (ins == null)
/* 321 */       return null; 
/* 322 */     ROOM_FIGHTPIT.this.aArea.setDim((ins.body().width() - ins.ax * 2), (ins.body().height() - ins.ay * 2));
/* 323 */     ROOM_FIGHTPIT.this.aArea.moveX1Y1((ins.body().x1() + ins.ax), (ins.body().y1() + ins.ay));
/* 324 */     return (RECTANGLE)ROOM_FIGHTPIT.this.aArea;
/*     */   }
/*     */ 
/*     */   
/*     */   public int executions(RoomInstance ins) {
/* 329 */     if (ins instanceof ArenaInstance) {
/* 330 */       ArenaInstance i = (ArenaInstance)ins;
/* 331 */       return i.gladiators;
/*     */     } 
/* 333 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int executionsMax(RoomInstance ins) {
/* 338 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int executions() {
/* 343 */     return ROOM_FIGHTPIT.this.gladiators;
/*     */   }
/*     */ 
/*     */   
/*     */   public int executionsMax() {
/* 348 */     return ROOM_FIGHTPIT.this.gladiatorMax;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\pit\ROOM_FIGHTPIT$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */