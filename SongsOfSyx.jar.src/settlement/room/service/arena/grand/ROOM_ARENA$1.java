/*     */ package settlement.room.service.arena.grand;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ROOM_SPECTATOR
/*     */ {
/* 134 */   private Coo coo = new Coo();
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 138 */     return (RoomServiceAccess)ROOM_ARENA.this.service();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE lookAt(int sx, int sy) {
/* 145 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(sx, sy);
/* 146 */     if (ins == null) {
/* 147 */       this.coo.set(sx, sy);
/*     */     } else {
/* 149 */       this.coo.set(sx, sy);
/* 150 */       RECTANGLE rec = ROOM_ARENA.this.work.gladiatorArea(sx, sy);
/* 151 */       int w = Math.min(4, rec.width());
/* 152 */       int h = Math.min(4, rec.height());
/* 153 */       int a = w * h;
/* 154 */       int i = (sx + sy) % a;
/* 155 */       this.coo.set((rec.cX() - w / 2 + i % w), (rec.cY() - h / 2 + i / h));
/*     */     } 
/* 157 */     this.coo.set((this.coo.x() * 64 + 32), (this.coo.y() * 64 + 32));
/* 158 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int sx, int sy) {
/* 163 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(sx, sy);
/* 164 */     return (ins != null);
/*     */   }
/*     */   
/*     */   private int activity(int sx, int sy) {
/* 168 */     ArenaInstance ins = (ArenaInstance)ROOM_ARENA.this.getter.get(sx, sy);
/* 169 */     if (ins == null) {
/* 170 */       return 0;
/*     */     }
/* 172 */     int d = (int)TIME.currentSecond() - ins.cheerTime;
/*     */     
/* 174 */     if (d > ArenaInstance.CHEER_TIME * 8) {
/* 175 */       ins.cheerTime = (int)TIME.currentSecond();
/* 176 */       ins.cheer = false;
/* 177 */       d = 0;
/*     */     } 
/*     */     
/* 180 */     if (d <= ArenaInstance.CHEER_TIME) {
/* 181 */       if (ins.cheer)
/* 182 */         return 1; 
/* 183 */       return 2;
/*     */     } 
/*     */     
/* 186 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive(int sx, int sy) {
/* 191 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldCheer(int sx, int sy) {
/* 196 */     return (activity(sx, sy) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldBoo(int sx, int sy) {
/* 201 */     return (activity(sx, sy) == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE getDestination(COORDINATE roomT) {
/* 206 */     this.coo.set(roomT.x(), roomT.y());
/* 207 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSpot(int tx, int ty) {
/* 212 */     if (ROOM_ARENA.this.ser.init(tx, ty))
/* 213 */       return true; 
/* 214 */     return super.isSpot(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpenNow() {
/* 219 */     return !(TIME.hours().bitCurrent() <= 11 && TIME.hours().bitCurrent() >= 6);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\ROOM_ARENA$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */