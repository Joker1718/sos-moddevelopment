/*     */ package settlement.room.main.job;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoomResStorage
/*     */   implements RESOURCE_TILE
/*     */ {
/*     */   private final Bits amount;
/*     */   private final Bits reserved;
/*     */   private final int max;
/*     */   protected int x;
/*     */   protected int y;
/*     */   protected int data;
/*     */   protected ROOMA ins;
/*     */   
/*     */   protected RoomResStorage(int max) {
/*  27 */     this.max = max;
/*  28 */     int s = 0;
/*  29 */     int mask = 0;
/*  30 */     while (max != 0) {
/*  31 */       max /= 2;
/*  32 */       s++;
/*  33 */       mask <<= 1;
/*  34 */       mask |= 0x1;
/*     */     } 
/*  36 */     if (mask > 65535)
/*  37 */       throw new RuntimeException("too big " + max + " " + (max & mask)); 
/*  38 */     this.amount = new Bits(mask);
/*  39 */     this.reserved = new Bits(mask << s);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStorage() {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrio() {
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   public RoomResStorage get(int tx, int ty, ROOMA i) {
/*  53 */     this.ins = i;
/*  54 */     if (i.is(tx, ty) && is(tx, ty)) {
/*  55 */       this.x = tx;
/*  56 */       this.y = ty;
/*  57 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  58 */       return this;
/*     */     } 
/*  60 */     return null;
/*     */   }
/*     */   
/*     */   protected abstract boolean is(int paramInt1, int paramInt2);
/*     */   
/*     */   protected void set(int tx, int ty) {
/*  66 */     this.x = tx;
/*  67 */     this.y = ty;
/*  68 */     this.data = (SETT.ROOMS()).data.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   private void save() {
/*  73 */     int old = this.data;
/*  74 */     this.data = (SETT.ROOMS()).data.get(this.x, this.y);
/*  75 */     if (findableReservedCanBe()) {
/*  76 */       (SETT.PATH()).finders.resource.reportAbsence(this);
/*     */     }
/*  78 */     this.data = old;
/*  79 */     (SETT.ROOMS()).data.set(this.ins, this.x, this.y, this.data);
/*  80 */     if (findableReservedCanBe()) {
/*  81 */       (SETT.PATH()).finders.resource.reportPresence(this);
/*     */     }
/*  83 */     changed(this.x, this.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void changed(int tx, int ty) {}
/*     */ 
/*     */   
/*     */   public boolean hasRoom() {
/*  92 */     return (this.amount.get(this.data) < this.max);
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  97 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 102 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 107 */     if (this.reserved.get(this.data) >= this.amount.get(this.data))
/* 108 */       throw new RuntimeException(); 
/* 109 */     this.data = this.reserved.inc(this.data, 1);
/* 110 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public int reservable() {
/* 115 */     return this.amount.get(this.data) - this.reserved.get(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 120 */     if (this.reserved.get(this.data) > 0) {
/* 121 */       this.data = this.reserved.inc(this.data, -1);
/* 122 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 129 */     return (this.reserved.get(this.data) > 0 && this.amount.get(this.data) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 134 */     return (this.reserved.get(this.data) < this.amount.get(this.data));
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourcePickup() {
/* 139 */     if (findableReservedIs()) {
/* 140 */       this.data = this.amount.inc(this.data, -1);
/* 141 */       this.data = this.reserved.inc(this.data, -1);
/* 142 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void deposit() {
/* 148 */     if (!hasRoom())
/* 149 */       throw new RuntimeException(); 
/* 150 */     this.data = this.amount.inc(this.data, 1);
/* 151 */     save();
/*     */   }
/*     */   
/*     */   public int deposit(int am) {
/* 155 */     int a = this.max - amount();
/* 156 */     a = Math.min(am, a);
/* 157 */     this.data = this.amount.inc(this.data, a);
/* 158 */     save();
/* 159 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 164 */     if (this.amount.get(this.data) > 0 && resource() != null) {
/* 165 */       boolean unload = false;
/* 166 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 167 */         int dx = x() + ((DIR)DIR.ALL.get(di)).x();
/* 168 */         int dy = y() + ((DIR)DIR.ALL.get(di)).y();
/* 169 */         if ((SETT.PATH()).connectivity.is(dx, dy)) {
/* 170 */           unload = true;
/* 171 */           (SETT.THINGS()).resources.create(dx, dy, resource(), this.amount.get(this.data));
/*     */           break;
/*     */         } 
/*     */       } 
/* 175 */       if (!unload) {
/* 176 */         (SETT.THINGS()).resources.create((COORDINATE)this, resource(), this.amount.get(this.data));
/*     */       }
/*     */     } 
/*     */     
/* 180 */     this.data = 0;
/* 181 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch shadowBatch, int tx, int ty, int x, int y, int ran) {
/* 186 */     if (get(tx, ty, (ROOMA)(SETT.ROOMS()).map.rooma.get(tx, ty)) == null) {
/*     */       return;
/*     */     }
/* 189 */     int a = this.amount.get(this.data);
/* 190 */     if (a > 0) {
/* 191 */       a = (int)Math.ceil(a / 2.0D);
/* 192 */       shadowBatch.setHeight(1).setDistance2Ground(0.0D);
/* 193 */       resource().renderLaying((SPRITE_RENDERER)shadowBatch, x, y, ran, a);
/* 194 */       resource().renderLaying(r, x, y, ran, a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int amount() {
/* 200 */     return this.amount.get(this.data);
/*     */   }
/*     */   
/*     */   public int max() {
/* 204 */     return this.max;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\RoomResStorage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */