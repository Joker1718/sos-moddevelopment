/*     */ package settlement.room.service.arena.pit;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends ROOM_SPECTATOR
/*     */ {
/* 137 */   private Coo coo = new Coo();
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 141 */     return (RoomServiceAccess)ROOM_FIGHTPIT.this.service();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE lookAt(int sx, int sy) {
/* 148 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 149 */     if (ins == null) {
/* 150 */       this.coo.set(sx, sy);
/*     */     } else {
/* 152 */       this.coo.set(sx, sy);
/* 153 */       RECTANGLE rec = ROOM_FIGHTPIT.this.work.gladiatorArea(sx, sy);
/* 154 */       int w = Math.min(4, rec.width());
/* 155 */       int h = Math.min(4, rec.height());
/* 156 */       int a = w * h;
/* 157 */       int i = (sx + sy) % a;
/* 158 */       this.coo.set((rec.cX() - w / 2 + i % w), (rec.cY() - h / 2 + i / h));
/*     */     } 
/* 160 */     this.coo.set((this.coo.x() * 64 + 32), (this.coo.y() * 64 + 32));
/* 161 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int sx, int sy) {
/* 166 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 167 */     return (ins != null);
/*     */   }
/*     */   
/*     */   private int activity(int sx, int sy) {
/* 171 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 172 */     if (ins == null) {
/* 173 */       return 0;
/*     */     }
/* 175 */     int d = (int)TIME.currentSecond() - ins.cheerTime;
/*     */     
/* 177 */     if (d > ArenaInstance.CHEER_TIME * 8) {
/* 178 */       ins.cheerTime = (int)TIME.currentSecond();
/* 179 */       ins.cheer = false;
/* 180 */       d = 0;
/*     */     } 
/*     */     
/* 183 */     if (d <= ArenaInstance.CHEER_TIME) {
/* 184 */       if (ins.cheer)
/* 185 */         return 1; 
/* 186 */       return 2;
/*     */     } 
/*     */     
/* 189 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldCheer(int sx, int sy) {
/* 194 */     return (activity(sx, sy) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldBoo(int sx, int sy) {
/* 199 */     return (activity(sx, sy) == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE getDestination(COORDINATE roomT) {
/* 204 */     this.coo.set(roomT.x(), roomT.y());
/* 205 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSpot(int tx, int ty) {
/* 210 */     if (ROOM_FIGHTPIT.this.ser.init(tx, ty))
/* 211 */       return true; 
/* 212 */     return super.isSpot(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpenNow() {
/* 217 */     return !(TIME.hours().bitCurrent() <= 11 && TIME.hours().bitCurrent() >= 6);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive(int sx, int sy) {
/* 222 */     ArenaInstance ins = (ArenaInstance)ROOM_FIGHTPIT.this.getter.get(sx, sy);
/* 223 */     return (ins != null && ins.employees().employed() > 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\pit\ROOM_FIGHTPIT$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */