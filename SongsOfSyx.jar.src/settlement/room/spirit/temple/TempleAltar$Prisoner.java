/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Prisoner
/*     */   extends TempleAltar
/*     */ {
/* 127 */   protected final RoomBits needs = new RoomBits((COORDINATE)this.coo, 1);
/* 128 */   protected final RoomBits reserved = new RoomBits((COORDINATE)this.coo, 2);
/* 129 */   protected final RoomBits ready = new RoomBits((COORDINATE)this.coo, 4);
/* 130 */   protected final RoomBits kills = new RoomBits((COORDINATE)this.coo, 112);
/* 131 */   protected final RoomBits race = new RoomBits((COORDINATE)this.coo, 16773120);
/*     */   
/*     */   Prisoner(ROOM_TEMPLE blue) {
/* 134 */     super(blue);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 139 */     long ran = it.bigRan();
/* 140 */     int a = this.kills.get();
/* 141 */     COLOR col = (((Race)RACES.all().get(this.race.get())).appearance()).colors.blood;
/* 142 */     col.bind();
/* 143 */     if (a > 0) {
/* 144 */       int cx = it.x() + 32;
/* 145 */       int cy = it.y() + 32;
/* 146 */       for (int i = 0; i < a; i++) {
/* 147 */         int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/* 148 */         ran >>= 3L;
/* 149 */         int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/* 150 */         ran >>= 3L;
/* 151 */         (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/* 152 */         ran >>= 4L;
/*     */       } 
/*     */     } 
/* 155 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   boolean shouldKill() {
/* 166 */     return (this.ready.get() == 1 && this.kills.get() < this.kills.max());
/*     */   }
/*     */ 
/*     */   
/*     */   void kill() {
/* 171 */     if (!shouldKill())
/*     */       return; 
/* 173 */     (SETT.THINGS()).gore.gore(this.coo.x() * 64 + 32, this.coo.y() * 64 + 32, (((Race)RACES.all().get(this.race.get())).appearance()).colors.blood);
/* 174 */     this.kills.inc((ROOMA)this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   void updateDay(int am) {
/* 179 */     am = CLAMP.i(am, 0, 1);
/* 180 */     if (am == 0)
/*     */       return; 
/* 182 */     if (this.reserved.get() == 1) {
/*     */       return;
/*     */     }
/*     */     
/* 186 */     if (this.needs.get() == 1) {
/* 187 */       this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + am);
/*     */     } else {
/* 189 */       this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired + 1);
/* 190 */     }  this.needs.set((ROOMA)this.ins, 1);
/*     */   }
/*     */   
/*     */   public void sacrificeReserve(Race r) {
/* 194 */     if (this.reserved.get() == 0) {
/* 195 */       this.reserved.set((ROOMA)this.ins, 1);
/* 196 */       this.race.set((ROOMA)this.ins, r.index());
/* 197 */       this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired - 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sacrificeUnreserve() {
/* 202 */     if (this.reserved.get() == 1) {
/* 203 */       this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired + 1);
/*     */     }
/* 205 */     this.reserved.set((ROOMA)this.ins, 0);
/* 206 */     if (this.ready.get() == 1) {
/* 207 */       this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + 1);
/* 208 */       this.ins.sacrifices = (short)(this.ins.sacrifices + 1);
/* 209 */       this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired - 1);
/* 210 */       this.ins.consumed++;
/* 211 */       this.blue.consumed++;
/* 212 */       this.needs.set((ROOMA)this.ins, 0);
/* 213 */       this.reserved.set((ROOMA)this.ins, 0);
/* 214 */       this.ready.set((ROOMA)this.ins, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean sacrificeReservable() {
/* 220 */     return (this.needs.get() == 1 && this.reserved.get() == 0);
/*     */   }
/*     */   
/*     */   public boolean sacrificeReserved() {
/* 224 */     return (this.reserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void sacrificeReady() {
/* 229 */     if (this.reserved.get() == 1) {
/* 230 */       this.ready.set((ROOMA)this.ins, 1);
/* 231 */       this.kills.set((ROOMA)this.ins, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public double sacrificeKillAmount() {
/* 236 */     return this.kills.getD();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleAltar$Prisoner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */