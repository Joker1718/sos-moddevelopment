/*     */ package settlement.room.service.arena.grand;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.arena.RoomArenaWork;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
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
/*     */ class null
/*     */   implements RoomArenaWork
/*     */ {
/* 232 */   private Coo coo = new Coo();
/*     */ 
/*     */   
/*     */   public boolean gladiatorInArena(int tx, int ty) {
/* 236 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(tx, ty);
/* 237 */     if (ins != null) {
/* 238 */       return ins.arena.holdsPoint(tx, ty);
/*     */     }
/* 240 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE gladiatorGetSpot(RoomInstance ins) {
/* 245 */     ArenaInstance a = (ArenaInstance)ins;
/* 246 */     int w = a.arena.width();
/* 247 */     int h = a.arena.height();
/* 248 */     this.coo.set((a.arena.x1() + RND.rInt(w)), (a.arena.y1() + RND.rInt(h)));
/* 249 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void gladiatorDrawMakeSheer(COORDINATE coo) {
/* 255 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(coo);
/* 256 */     if (ins != null) {
/* 257 */       ins.cheerTime = (int)TIME.currentSecond();
/* 258 */       ins.cheer = !RND.oneIn(6);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE gladiatorArea(int tx, int ty) {
/* 264 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(tx, ty);
/* 265 */     if (ins != null) {
/* 266 */       return ins.arena;
/*     */     }
/* 268 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomInstance reserveDeath(COORDINATE coo) {
/* 273 */     if (ROOM_ARENA.this.executions >= ROOM_ARENA.this.executionsMax || ROOM_ARENA.this.instancesSize() <= 0) {
/* 274 */       return null;
/*     */     }
/*     */     
/* 277 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(coo);
/* 278 */     if (ins != null && ins.executions < 4) {
/* 279 */       ins.executions = (byte)(ins.executions + 1);
/* 280 */       ROOM_ARENA.this.executions++;
/* 281 */       return ins;
/*     */     } 
/*     */     
/* 284 */     int ri = RND.rInt(ROOM_ARENA.this.instancesSize());
/*     */     
/* 286 */     for (int i = 0; i < ROOM_ARENA.this.instancesSize(); i++) {
/* 287 */       ArenaInstance arenaInstance = (ArenaInstance)ROOM_ARENA.this.getInstance((i + ri) % ROOM_ARENA.this.instancesSize());
/* 288 */       if (arenaInstance.active() && arenaInstance.employees().employed() > 0 && arenaInstance.executions < 4) {
/* 289 */         arenaInstance.executions = (byte)(arenaInstance.executions + 1);
/* 290 */         ROOM_ARENA.this.executions++;
/* 291 */         return arenaInstance;
/*     */       } 
/*     */     } 
/* 294 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void unreserveDeath(int tx, int ty) {
/* 299 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(tx, ty);
/* 300 */     if (ins != null) {
/* 301 */       ins.executions = (byte)(ins.executions - 1);
/* 302 */       ins.executions = (byte)Math.max(ins.executions, 0);
/* 303 */       if (ins.active() && ins.employees().employed() > 0) {
/* 304 */         ROOM_ARENA.this.executions--;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int executions() {
/* 311 */     return ROOM_ARENA.this.executions;
/*     */   }
/*     */ 
/*     */   
/*     */   public int executionsMax() {
/* 316 */     return ROOM_ARENA.this.executionsMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public int executions(RoomInstance ins) {
/* 321 */     if (ins instanceof ArenaInstance) {
/* 322 */       ArenaInstance i = (ArenaInstance)ins;
/* 323 */       return i.executions;
/*     */     } 
/* 325 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int executionsMax(RoomInstance ins) {
/* 330 */     return 4;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\ROOM_ARENA$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */