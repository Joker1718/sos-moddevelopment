/*     */ package settlement.room.service.stage;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ class null
/*     */   extends ROOM_SPECTATOR
/*     */ {
/*  96 */   private Coo coo = new Coo();
/*     */   
/*  98 */   private final byte[] acts = Alloc.bb(64);
/*     */ 
/*     */ 
/*     */   
/*     */   null() {
/* 103 */     for (int i = 0; i < 10; i++) {
/* 104 */       this.acts[RND.rInt(this.acts.length)] = (byte)(1 + RND.rInt(2));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 110 */     return (RoomServiceAccess)ROOM_STAGE.this.service();
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE lookAt(int sx, int sy) {
/* 115 */     this.coo.set((sx * 64 + 32), (sy * 64 + 32));
/* 116 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int sx, int sy) {
/* 121 */     StageInstance ins = (StageInstance)ROOM_STAGE.this.getter.get(sx, sy);
/* 122 */     return (ins != null);
/*     */   }
/*     */   
/*     */   private int activity(int sx, int sy) {
/* 126 */     StageInstance ins = (StageInstance)ROOM_STAGE.this.getter.get(sx, sy);
/* 127 */     if (ins == null)
/* 128 */       return 0; 
/* 129 */     int s = ins.off;
/*     */     
/* 131 */     s += (int)(this.acts.length * TIME.currentSecond() / TIME.secondsPerDay());
/* 132 */     s %= this.acts.length;
/* 133 */     return this.acts[s];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldCheer(int sx, int sy) {
/* 138 */     return (activity(sx, sy) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldBoo(int sx, int sy) {
/* 143 */     return (activity(sx, sy) == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive(int sx, int sy) {
/* 148 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\stage\ROOM_STAGE$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */