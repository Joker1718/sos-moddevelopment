/*     */ package settlement.room.main.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public abstract class RoomResDeposit
/*     */   implements SETT_JOB
/*     */ {
/*  30 */   private static final Bits[] AMOUNTS = new Bits[] {
/*  31 */       new Bits(31), 
/*  32 */       new Bits(992), 
/*  33 */       new Bits(31744), 
/*  34 */       new Bits(1015808)
/*     */     };
/*     */   
/*  37 */   private static final Bit[] RESERVED = new Bit[] {
/*  38 */       new Bit(1048576), 
/*  39 */       new Bit(2097152), 
/*  40 */       new Bit(4194304), 
/*  41 */       new Bit(8388608)
/*     */     };
/*     */   
/*  44 */   private static Bit WRESERVED = new Bit(16777216);
/*  45 */   private static Bit WUSED = new Bit(33554432);
/*     */   private static final int ww = 45;
/*  47 */   protected Coo coo = new Coo();
/*     */   
/*     */   protected int data;
/*     */   
/*     */   protected static final String name = "Gettings raw materials";
/*     */   
/*     */   private ROOM_PRODUCER_INSTANCE ins;
/*     */   
/*     */   private RoomInstance insi;
/*     */   private final RoomBlueprintImp blue;
/*     */   private final RBIT.RBITImp bits;
/*     */   
/*     */   public RoomResDeposit get(int tx, int ty, RoomInstance i) {
/*  60 */     if (i != null && i.is(tx, ty) && i instanceof ROOM_PRODUCER_INSTANCE && is(tx, ty)) {
/*  61 */       this.coo.set(tx, ty);
/*  62 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  63 */       this.insi = i;
/*  64 */       this.ins = (ROOM_PRODUCER_INSTANCE)i;
/*  65 */       return this;
/*     */     } 
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int amount(int res) {
/*  75 */     return AMOUNTS[res].get(this.data);
/*     */   }
/*     */   
/*     */   public boolean hasOneOfEach() {
/*  79 */     for (int i = 0; i < resAm(); i++) {
/*  80 */       if (amount(i) <= 0)
/*  81 */         return false; 
/*     */     } 
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void amountSet(int a, int res) {
/* 107 */     this.data = AMOUNTS[res].set(this.data, a);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 112 */     if (!WRESERVED.is(this.data) && regularJobCanBeReserved((COORDINATE)this.coo) && hasOneOfEach())
/* 113 */       return true; 
/* 114 */     return (jobResourceBitToFetch() != null);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch shadowBatch, int x, int y, int ran) {
/* 118 */     shadowBatch.setHeight(1).setDistance2Ground(0.0D);
/* 119 */     for (int i = 0; i < resAm(); i++) {
/* 120 */       if (amount(i) > 0) {
/* 121 */         res(i).renderLaying((SPRITE_RENDERER)shadowBatch, x, y, ran, amount(i));
/* 122 */         res(i).renderLaying(r, x, y, ran, amount(i));
/* 123 */         ran >>= 3;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderDebug(SPRITE_RENDERER r, int x, int y) {
/* 144 */     if (!WRESERVED.is(this.data) && regularJobCanBeReserved((COORDINATE)this.coo) && hasOneOfEach()) {
/* 145 */       COLOR.BLUE100.render(r, x, y);
/* 146 */     } else if (WRESERVED.is(this.data)) {
/* 147 */       COLOR.RED100.render(r, x, y);
/*     */     } else {
/* 149 */       COLOR.ORANGE100.render(r, x, y);
/*     */     } 
/*     */     
/* 152 */     COLOR.RED100.render(r, x + 32, y);
/* 153 */     if (jobResourceBitToFetch() != null) {
/* 154 */       COLOR.BLUE100.render(r, x + 32, y);
/*     */     }
/*     */     
/* 157 */     for (int i = 0; i < resAm(); i++) {
/* 158 */       if (RESERVED[i].is(this.data)) {
/* 159 */         COLOR.ORANGE100.render(r, x + 32, y);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 164 */     if (jobReserveCanBe()) {
/* 165 */       COLOR.GREEN100.render(r, x, y + 32);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderNeighs(RoomInstance ins, SPRITE_RENDERER r, ShadowBatch shadowBatch, int x, int y, int ran) {
/* 177 */     int tx = this.coo.x();
/* 178 */     int ty = this.coo.y();
/* 179 */     shadowBatch.setHeight(1).setDistance2Ground(0.0D);
/* 180 */     for (int i = 0; i < resAm(); i++) {
/* 181 */       int aa = get(tx, ty, ins).amount(i);
/* 182 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 183 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 184 */         if (get(tx + d.x(), ty + d.y(), ins) != null) {
/* 185 */           aa += amount(i);
/*     */         }
/*     */       } 
/*     */       
/* 189 */       if (aa > 0) {
/* 190 */         aa = (int)Math.ceil(aa / 3.0D);
/* 191 */         res(i).renderLaying((SPRITE_RENDERER)shadowBatch, x, y, ran, aa);
/* 192 */         res(i).renderLaying(r, x, y, ran, aa);
/* 193 */         ran >>= 3;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean withDraw(int ri, int amount) {
/* 200 */     amountSet(amount(ri) - amount, ri);
/* 201 */     save();
/* 202 */     return (amount(ri) > 0);
/*     */   }
/*     */   protected RoomResDeposit(RoomBlueprintImp blue) {
/* 205 */     this.bits = new RBIT.RBITImp();
/*     */     this.blue = blue;
/*     */   }
/*     */   public RBIT jobResourceBitToFetch() {
/* 209 */     this.bits.clear();
/* 210 */     for (int i = 0; i < resAm(); i++) {
/* 211 */       if (!RESERVED[i].is(this.data) && 
/* 212 */         amount(i) < 1) {
/* 213 */         this.bits.or(res(i));
/*     */       }
/*     */     } 
/*     */     
/* 217 */     return this.bits.isClear() ? null : (RBIT)this.bits;
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/* 222 */     return 15;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 227 */     return 45.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/* 232 */     this.data = WUSED.set(this.data, true);
/* 233 */     save();
/*     */   }
/*     */   
/*     */   public boolean working(int data) {
/* 237 */     return WUSED.is(data);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 242 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/*     */     int j;
/* 250 */     if (res == null) {
/*     */       
/* 252 */       this.data = WRESERVED.set(this.data, false);
/* 253 */       this.data = WUSED.set(this.data, false);
/* 254 */       save();
/*     */       
/* 256 */       if (!regularJobCanBeReserved((COORDINATE)this.coo)) {
/* 257 */         return null;
/*     */       }
/* 259 */       j = 0;
/* 260 */       double w = this.insi.employees().fetchBonus(45);
/*     */       
/* 262 */       for (IndustryResource r : this.ins.industry().ins()) {
/* 263 */         int a = r.work(skill, (ROOM_IDATA_INSTANCE)this.ins, w);
/* 264 */         if (a > 0) {
/* 265 */           int max = amount(j);
/* 266 */           a = (SETT.ROOMS()).resourceUnderflow.withdraw(r.resource, a, max);
/* 267 */           withDraw(j, a);
/*     */         } 
/* 269 */         j++;
/*     */       } 
/*     */       
/* 272 */       int am = ((IndustryResource)this.ins.industry().outs().get(0)).work(skill, (ROOM_IDATA_INSTANCE)this.ins, w);
/* 273 */       if (am > 0) {
/* 274 */         regularJobStore((COORDINATE)this.coo, am);
/*     */       }
/* 276 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 281 */     boolean has = true;
/*     */     
/* 283 */     for (int i = 0; i < resAm(); i++) {
/* 284 */       if (res(i) == res) {
/*     */         
/* 286 */         this.data = RESERVED[i].clear(this.data);
/* 287 */         ram = (SETT.ROOMS()).resourceUnderflow.deposit(res, ram);
/* 288 */         if (ram > 0) {
/* 289 */           ram = CLAMP.i(ram, 0, jobResourcesNeeded(skill));
/* 290 */           amountSet(amount(i) + ram, i);
/*     */         } 
/*     */       } 
/* 293 */       j = has & ((amount(i) > 0) ? 1 : 0);
/*     */     } 
/*     */     
/* 296 */     save();
/* 297 */     if (j != 0)
/* 298 */       hasCallback(); 
/* 299 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 306 */     if (r != null) {
/* 307 */       for (int i = 0; i < resAm(); i++) {
/* 308 */         if (res(i) == r) {
/* 309 */           this.data = RESERVED[i].set(this.data);
/* 310 */           save();
/*     */           return;
/*     */         } 
/*     */       } 
/* 314 */     } else if (!WRESERVED.is(this.data)) {
/* 315 */       this.data = WRESERVED.set(this.data);
/* 316 */       save();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 321 */     throw new RuntimeException(String.valueOf(r));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 326 */     if (r == null) {
/* 327 */       return WRESERVED.is(this.data);
/*     */     }
/*     */     
/* 330 */     for (int i = 0; i < resAm(); i++) {
/* 331 */       if (res(i) == r) {
/* 332 */         return RESERVED[i].is(this.data);
/*     */       }
/*     */     } 
/*     */     
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 341 */     if (r == null) {
/* 342 */       this.data = WRESERVED.set(this.data, false);
/* 343 */       this.data = WUSED.set(this.data, false);
/* 344 */       save();
/*     */       return;
/*     */     } 
/* 347 */     for (int i = 0; i < resAm(); i++) {
/* 348 */       if (res(i) == r) {
/* 349 */         if (RESERVED[i].is(this.data)) {
/* 350 */           this.data = RESERVED[i].clear(this.data);
/* 351 */           save();
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 358 */     GAME.Notify(String.valueOf(r));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void save() {
/* 365 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 370 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 375 */     return WRESERVED.is(this.data) ? (this.blue.employment()).verb : "Gettings raw materials";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 380 */     return false;
/*     */   }
/*     */   
/*     */   public final RESOURCE res(int index) {
/* 384 */     return ((IndustryResource)this.ins.industry().ins().get(index)).resource;
/*     */   }
/*     */   
/*     */   public final int resAm() {
/* 388 */     return this.ins.industry().ins().size();
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 392 */     for (int i = 0; i < resAm(); i++) {
/* 393 */       if (amount(i) > 0) {
/* 394 */         boolean unload = false;
/* 395 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 396 */           int dx = this.coo.x() + ((DIR)DIR.ALL.get(di)).x();
/* 397 */           int dy = this.coo.y() + ((DIR)DIR.ALL.get(di)).y();
/* 398 */           if ((SETT.PATH()).connectivity.is(dx, dy)) {
/* 399 */             unload = true;
/* 400 */             (SETT.THINGS()).resources.create(dx, dy, res(i), amount(i));
/*     */             break;
/*     */           } 
/*     */         } 
/* 404 */         if (!unload) {
/* 405 */           (SETT.THINGS()).resources.create((COORDINATE)this.coo, res(i), amount(i));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 410 */     this.data = 0;
/* 411 */     save();
/*     */   }
/*     */   
/*     */   protected abstract boolean is(int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract boolean regularJobCanBeReserved(COORDINATE paramCOORDINATE);
/*     */   
/*     */   protected abstract void regularJobStore(COORDINATE paramCOORDINATE, int paramInt);
/*     */   
/*     */   protected abstract void hasCallback();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\RoomResDeposit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */