/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public abstract class TempleAltar
/*     */ {
/*     */   protected final ROOM_TEMPLE blue;
/*     */   protected TempleInstance ins;
/*  25 */   protected Coo coo = new Coo();
/*     */   
/*  27 */   protected final RoomBits resources = new RoomBits((COORDINATE)this.coo, 255);
/*     */ 
/*     */   
/*     */   private TempleAltar(ROOM_TEMPLE blue) {
/*  31 */     this.blue = blue;
/*     */   }
/*     */   
/*     */   TempleAltar get(int tx, int ty) {
/*  35 */     this.ins = (TempleInstance)this.blue.get(tx, ty);
/*  36 */     if (this.ins != null && 
/*  37 */       (SETT.ROOMS()).fData.tile.is(tx, ty, this.blue.constructor.es)) {
/*  38 */       this.coo.set(tx, ty);
/*  39 */       return this;
/*     */     } 
/*     */     
/*  42 */     return null;
/*     */   }
/*     */   
/*     */   void updateday(int tx, int ty) {
/*  46 */     if (get(tx, ty) == null)
/*     */       return; 
/*  48 */     double d = this.blue.STIME;
/*  49 */     int am = (int)d;
/*  50 */     if (RND.rFloat() < d - am) {
/*  51 */       am++;
/*     */     }
/*  53 */     updateDay(am);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void updateDay(int paramInt);
/*     */ 
/*     */   
/*     */   public void resourceInc(int am) {
/*  62 */     this.resources.inc((ROOMA)this.ins, am);
/*     */   } abstract void dispose(int paramInt1, int paramInt2);
/*     */   protected abstract void render(SPRITE_RENDERER paramSPRITE_RENDERER, ShadowBatch paramShadowBatch, RenderData.RenderIterator paramRenderIterator);
/*     */   public boolean resourceNeeds() {
/*  66 */     return (this.ins.resHas && this.resources.get() < CLAMP.i((int)Math.ceil(this.blue.STIME * 3.0D), 0, 10));
/*     */   }
/*     */   
/*     */   public COORDINATE coo() {
/*  70 */     return (COORDINATE)this.coo;
/*     */   }
/*     */   
/*     */   abstract boolean shouldKill();
/*     */   
/*     */   abstract void kill();
/*     */   
/*     */   static final class Resource
/*     */     extends TempleAltar {
/*     */     private final RESOURCE res;
/*     */     
/*     */     Resource(ROOM_TEMPLE blue, RESOURCE resources) {
/*  82 */       super(blue);
/*  83 */       this.res = resources;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*  88 */       int am = this.resources.get();
/*     */       
/*  90 */       if (am > 0) {
/*  91 */         this.res.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */     
/*     */     void updateDay(int am) {
/* 103 */       this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + am);
/* 104 */       int rr = this.resources.get();
/* 105 */       am = CLAMP.i(am, 0, rr);
/* 106 */       this.resources.inc((ROOMA)this.ins, -am);
/* 107 */       this.ins.sacrifices = (short)(this.ins.sacrifices + am);
/* 108 */       this.ins.consumed += am;
/* 109 */       this.blue.consumed += am;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean shouldKill() {
/* 114 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void kill() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class Prisoner
/*     */     extends TempleAltar
/*     */   {
/* 127 */     protected final RoomBits needs = new RoomBits((COORDINATE)this.coo, 1);
/* 128 */     protected final RoomBits reserved = new RoomBits((COORDINATE)this.coo, 2);
/* 129 */     protected final RoomBits ready = new RoomBits((COORDINATE)this.coo, 4);
/* 130 */     protected final RoomBits kills = new RoomBits((COORDINATE)this.coo, 112);
/* 131 */     protected final RoomBits race = new RoomBits((COORDINATE)this.coo, 16773120);
/*     */     
/*     */     Prisoner(ROOM_TEMPLE blue) {
/* 134 */       super(blue);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 139 */       long ran = it.bigRan();
/* 140 */       int a = this.kills.get();
/* 141 */       COLOR col = (((Race)RACES.all().get(this.race.get())).appearance()).colors.blood;
/* 142 */       col.bind();
/* 143 */       if (a > 0) {
/* 144 */         int cx = it.x() + 32;
/* 145 */         int cy = it.y() + 32;
/* 146 */         for (int i = 0; i < a; i++) {
/* 147 */           int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/* 148 */           ran >>= 3L;
/* 149 */           int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/* 150 */           ran >>= 3L;
/* 151 */           (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/* 152 */           ran >>= 4L;
/*     */         } 
/*     */       } 
/* 155 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */     
/*     */     boolean shouldKill() {
/* 166 */       return (this.ready.get() == 1 && this.kills.get() < this.kills.max());
/*     */     }
/*     */ 
/*     */     
/*     */     void kill() {
/* 171 */       if (!shouldKill())
/*     */         return; 
/* 173 */       (SETT.THINGS()).gore.gore(this.coo.x() * 64 + 32, this.coo.y() * 64 + 32, (((Race)RACES.all().get(this.race.get())).appearance()).colors.blood);
/* 174 */       this.kills.inc((ROOMA)this.ins, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     void updateDay(int am) {
/* 179 */       am = CLAMP.i(am, 0, 1);
/* 180 */       if (am == 0)
/*     */         return; 
/* 182 */       if (this.reserved.get() == 1) {
/*     */         return;
/*     */       }
/*     */       
/* 186 */       if (this.needs.get() == 1) {
/* 187 */         this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + am);
/*     */       } else {
/* 189 */         this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired + 1);
/* 190 */       }  this.needs.set((ROOMA)this.ins, 1);
/*     */     }
/*     */     
/*     */     public void sacrificeReserve(Race r) {
/* 194 */       if (this.reserved.get() == 0) {
/* 195 */         this.reserved.set((ROOMA)this.ins, 1);
/* 196 */         this.race.set((ROOMA)this.ins, r.index());
/* 197 */         this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired - 1);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void sacrificeUnreserve() {
/* 202 */       if (this.reserved.get() == 1) {
/* 203 */         this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired + 1);
/*     */       }
/* 205 */       this.reserved.set((ROOMA)this.ins, 0);
/* 206 */       if (this.ready.get() == 1) {
/* 207 */         this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + 1);
/* 208 */         this.ins.sacrifices = (short)(this.ins.sacrifices + 1);
/* 209 */         this.ins.sacrificesRequired = (short)(this.ins.sacrificesRequired - 1);
/* 210 */         this.ins.consumed++;
/* 211 */         this.blue.consumed++;
/* 212 */         this.needs.set((ROOMA)this.ins, 0);
/* 213 */         this.reserved.set((ROOMA)this.ins, 0);
/* 214 */         this.ready.set((ROOMA)this.ins, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean sacrificeReservable() {
/* 220 */       return (this.needs.get() == 1 && this.reserved.get() == 0);
/*     */     }
/*     */     
/*     */     public boolean sacrificeReserved() {
/* 224 */       return (this.reserved.get() == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void sacrificeReady() {
/* 229 */       if (this.reserved.get() == 1) {
/* 230 */         this.ready.set((ROOMA)this.ins, 1);
/* 231 */         this.kills.set((ROOMA)this.ins, 0);
/*     */       } 
/*     */     }
/*     */     
/*     */     public double sacrificeKillAmount() {
/* 236 */       return this.kills.getD();
/*     */     }
/*     */   }
/*     */   
/*     */   static final class Animal
/*     */     extends TempleAltar
/*     */   {
/* 243 */     protected final RoomBits hasSacrifice = new RoomBits((COORDINATE)this.coo, 256);
/* 244 */     protected final RoomBits kills = new RoomBits((COORDINATE)this.coo, 3584);
/*     */     
/*     */     Animal(ROOM_TEMPLE blue) {
/* 247 */       super(blue);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 252 */       long ran = it.bigRan();
/* 253 */       int a = this.kills.get();
/* 254 */       if (a > 0) {
/* 255 */         int cx = it.x() + 32;
/* 256 */         int cy = it.y() + 32;
/* 257 */         for (int i = 0; i < a; i++) {
/* 258 */           int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/* 259 */           ran >>= 3L;
/* 260 */           int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/* 261 */           ran >>= 3L;
/* 262 */           (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/* 263 */           ran >>= 4L;
/*     */         } 
/*     */       } else {
/* 266 */         int am = this.resources.get();
/*     */         
/* 268 */         if (am > 0) {
/* 269 */           this.blue.resource.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean shouldKill() {
/* 284 */       if (this.hasSacrifice.get() == 1 && this.kills.get() < this.kills.max()) {
/* 285 */         cadaver();
/* 286 */         return true;
/*     */       } 
/* 288 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void kill() {
/* 293 */       if (!shouldKill()) {
/*     */         return;
/*     */       }
/* 296 */       this.kills.inc((ROOMA)this.ins, 1);
/* 297 */       ThingsCadavers.Cadaver c = cadaver();
/* 298 */       if (c == null)
/*     */         return; 
/* 300 */       (SETT.THINGS()).gore.gore(c.body().cX(), c.body().cY(), (c.spec()).blood);
/* 301 */       c.setInjuries(this.kills.getD());
/*     */     }
/*     */ 
/*     */     
/*     */     void updateDay(int am) {
/* 306 */       am = CLAMP.i(am, 0, 1);
/* 307 */       this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + am);
/* 308 */       int rr = this.resources.get();
/* 309 */       am = CLAMP.i(am, 0, rr);
/* 310 */       this.resources.inc((ROOMA)this.ins, -am);
/* 311 */       this.ins.sacrifices = (short)(this.ins.sacrifices + am);
/*     */       
/* 313 */       this.hasSacrifice.set((ROOMA)this.ins, am);
/*     */       
/* 315 */       this.ins.consumed += am;
/* 316 */       this.blue.consumed += am;
/*     */       
/* 318 */       this.kills.set((ROOMA)this.ins, 0);
/* 319 */       THINGS.Thing t = SETT.THINGS().getFirst(this.coo.x(), this.coo.y());
/* 320 */       while (t != null) {
/* 321 */         t.remove();
/* 322 */         t = SETT.THINGS().getFirst(this.coo.x(), this.coo.y());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ThingsCadavers.Cadaver cadaver() {
/* 330 */       ThingsCadavers.Cadaver c = (ThingsCadavers.Cadaver)(SETT.THINGS()).cadavers.tGet.get((COORDINATE)this.coo);
/* 331 */       if (c == null) {
/* 332 */         AnimalSpecies s = (AnimalSpecies)SETT.ANIMALS().sett().get(RND.rInt(SETT.ANIMALS().sett().size()));
/* 333 */         c = (SETT.THINGS()).cadavers.normal(this.coo.x() * 64 + 32, this.coo.y() * 64 + 32, 0.0D, 0.0F, s, 0);
/*     */       } 
/* 335 */       return c;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleAltar.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */