/*     */ package settlement.room.service.speaker;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.entity.humanoid.Humanoid;
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
/*     */ class null
/*     */   extends ROOM_SPECTATOR
/*     */ {
/*  92 */   private Coo coo = new Coo();
/*     */   
/*  94 */   private final byte[] acts = Alloc.bb(64);
/*     */ 
/*     */ 
/*     */   
/*     */   null() {
/*  99 */     for (int i = 0; i < 10; i++) {
/* 100 */       this.acts[RND.rInt(this.acts.length)] = (byte)(1 + RND.rInt(2));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 106 */     return (RoomServiceAccess)ROOM_SPEAKER.this.service();
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE lookAt(int sx, int sy) {
/* 111 */     SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 112 */     if (ins == null) {
/* 113 */       this.coo.set(sx, sy);
/*     */     } else {
/* 115 */       this.coo.set(ins.body().cX(), ins.body().cY());
/*     */     } 
/* 117 */     this.coo.set((this.coo.x() * 64 + 32), (this.coo.y() * 64 + 32));
/* 118 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int sx, int sy) {
/* 123 */     SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 124 */     return (ins != null);
/*     */   }
/*     */   
/*     */   private int activity(int sx, int sy) {
/* 128 */     SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 129 */     if (ins == null)
/* 130 */       return 0; 
/* 131 */     if (!ROOM_SPEAKER.this.work.job(sx, sy).jobReservedIs(null))
/* 132 */       return 0; 
/* 133 */     int s = ins.off;
/*     */     
/* 135 */     s += (int)(this.acts.length * TIME.currentSecond() / TIME.secondsPerDay());
/* 136 */     s %= this.acts.length;
/* 137 */     return this.acts[s];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldCheer(int sx, int sy) {
/* 142 */     return (activity(sx, sy) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldBoo(int sx, int sy) {
/* 147 */     return (activity(sx, sy) == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doSomeThingExtraWhenAccess(Humanoid a) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isActive(int sx, int sy) {
/* 158 */     SpeakerInstance ins = (SpeakerInstance)ROOM_SPEAKER.this.getter.get(sx, sy);
/* 159 */     if (ins == null)
/* 160 */       return false; 
/* 161 */     if (!ROOM_SPEAKER.this.work.job(sx, sy).jobReservedIs(null))
/* 162 */       return false; 
/* 163 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\speaker\ROOM_SPEAKER$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */