/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Animal
/*     */   extends TempleAltar
/*     */ {
/* 243 */   protected final RoomBits hasSacrifice = new RoomBits((COORDINATE)this.coo, 256);
/* 244 */   protected final RoomBits kills = new RoomBits((COORDINATE)this.coo, 3584);
/*     */   
/*     */   Animal(ROOM_TEMPLE blue) {
/* 247 */     super(blue);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 252 */     long ran = it.bigRan();
/* 253 */     int a = this.kills.get();
/* 254 */     if (a > 0) {
/* 255 */       int cx = it.x() + 32;
/* 256 */       int cy = it.y() + 32;
/* 257 */       for (int i = 0; i < a; i++) {
/* 258 */         int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/* 259 */         ran >>= 3L;
/* 260 */         int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/* 261 */         ran >>= 3L;
/* 262 */         (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/* 263 */         ran >>= 4L;
/*     */       } 
/*     */     } else {
/* 266 */       int am = this.resources.get();
/*     */       
/* 268 */       if (am > 0) {
/* 269 */         this.blue.resource.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean shouldKill() {
/* 284 */     if (this.hasSacrifice.get() == 1 && this.kills.get() < this.kills.max()) {
/* 285 */       cadaver();
/* 286 */       return true;
/*     */     } 
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void kill() {
/* 293 */     if (!shouldKill()) {
/*     */       return;
/*     */     }
/* 296 */     this.kills.inc((ROOMA)this.ins, 1);
/* 297 */     ThingsCadavers.Cadaver c = cadaver();
/* 298 */     if (c == null)
/*     */       return; 
/* 300 */     (SETT.THINGS()).gore.gore(c.body().cX(), c.body().cY(), (c.spec()).blood);
/* 301 */     c.setInjuries(this.kills.getD());
/*     */   }
/*     */ 
/*     */   
/*     */   void updateDay(int am) {
/* 306 */     am = CLAMP.i(am, 0, 1);
/* 307 */     this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + am);
/* 308 */     int rr = this.resources.get();
/* 309 */     am = CLAMP.i(am, 0, rr);
/* 310 */     this.resources.inc((ROOMA)this.ins, -am);
/* 311 */     this.ins.sacrifices = (short)(this.ins.sacrifices + am);
/*     */     
/* 313 */     this.hasSacrifice.set((ROOMA)this.ins, am);
/*     */     
/* 315 */     this.ins.consumed += am;
/* 316 */     this.blue.consumed += am;
/*     */     
/* 318 */     this.kills.set((ROOMA)this.ins, 0);
/* 319 */     THINGS.Thing t = SETT.THINGS().getFirst(this.coo.x(), this.coo.y());
/* 320 */     while (t != null) {
/* 321 */       t.remove();
/* 322 */       t = SETT.THINGS().getFirst(this.coo.x(), this.coo.y());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ThingsCadavers.Cadaver cadaver() {
/* 330 */     ThingsCadavers.Cadaver c = (ThingsCadavers.Cadaver)(SETT.THINGS()).cadavers.tGet.get((COORDINATE)this.coo);
/* 331 */     if (c == null) {
/* 332 */       AnimalSpecies s = (AnimalSpecies)SETT.ANIMALS().sett().get(RND.rInt(SETT.ANIMALS().sett().size()));
/* 333 */       c = (SETT.THINGS()).cadavers.normal(this.coo.x() * 64 + 32, this.coo.y() * 64 + 32, 0.0D, 0.0F, s, 0);
/*     */     } 
/* 335 */     return c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleAltar$Animal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */