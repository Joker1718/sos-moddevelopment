/*     */ package settlement.room.service.hygine.bath;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ public class Bath
/*     */   implements FSERVICE
/*     */ {
/*     */   static final int BIT = 49152;
/*  15 */   private static final Bath self = new Bath();
/*     */   
/*     */   private int data;
/*  18 */   private final Coo coo = new Coo();
/*     */   private BathInstance ins;
/*     */   
/*     */   static Bath init(int tx, int ty, ROOM_BATH b) {
/*  22 */     if (!b.is(tx, ty))
/*  23 */       return null; 
/*  24 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/*  25 */     if ((data & 0xE000) != 49152)
/*  26 */       return null; 
/*  27 */     self.data = data;
/*  28 */     self.coo.set(tx, ty);
/*  29 */     self.ins = (BathInstance)b.get(tx, ty);
/*  30 */     return self;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int x() {
/*  39 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  44 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  49 */     return (reserved() < available());
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  54 */     if (reserved() >= available())
/*  55 */       throw new RuntimeException(); 
/*  56 */     reservedSet(reserved() + 1);
/*  57 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/*  62 */     return (reserved() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/*  67 */     if (reserved() > 0) {
/*  68 */       reservedSet(reserved() - 1);
/*  69 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/*  75 */     if (!findableReservedIs())
/*  76 */       throw new RuntimeException(); 
/*  77 */     reservedSet(reserved() - 1);
/*  78 */     availableSet(available() - 1);
/*  79 */     save();
/*     */   }
/*     */   
/*     */   int total() {
/*  83 */     return this.data >> 8 & 0xF;
/*     */   }
/*     */   
/*     */   int available() {
/*  87 */     return this.data >> 4 & 0xF;
/*     */   }
/*     */   
/*     */   private void availableSet(int a) {
/*  91 */     this.data &= 0xFF0F;
/*  92 */     this.data |= a << 4;
/*     */   }
/*     */   
/*     */   void availabilityInc() {
/*  96 */     availableSet(available() + 1);
/*  97 */     save();
/*     */   }
/*     */   
/*     */   boolean availbilityNeeds() {
/* 101 */     return (available() < total());
/*     */   }
/*     */   
/*     */   private int reserved() {
/* 105 */     return this.data & 0xF;
/*     */   }
/*     */   
/*     */   private void reservedSet(int r) {
/* 109 */     this.data &= 0xFFF0;
/* 110 */     this.data |= r;
/*     */   }
/*     */ 
/*     */   
/*     */   private void save() {
/* 115 */     int old = this.data;
/* 116 */     this.data = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/* 117 */     if (old == this.data) {
/*     */       return;
/*     */     }
/* 120 */     this.ins.service().report(this, (RoomService)(this.ins.blueprintI()).data, -(available() - reserved()));
/* 121 */     int a = available();
/* 122 */     this.data = old;
/* 123 */     this.ins.service().report(this, (RoomService)(this.ins.blueprintI()).data, available() - reserved());
/*     */     
/* 125 */     if (available() == 0 && a > 0) {
/* 126 */       blip(this.coo.x(), this.coo.y(), 57344);
/* 127 */     } else if (available() > 0 && a == 0) {
/* 128 */       blip(this.coo.x(), this.coo.y(), 57345);
/*     */     } 
/* 130 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   private void blip(int tx, int ty, int data) {
/* 135 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 136 */     COORDINATE coo = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, Coo.TMP);
/* 137 */     int sx = coo.x();
/* 138 */     int sy = coo.y();
/*     */     
/* 140 */     for (int y = 0; y < it.height(); y++) {
/* 141 */       for (int x = 0; x < it.width(); x++) {
/* 142 */         int dx = sx + x;
/* 143 */         int dy = sy + y;
/* 144 */         if (isPool(dx, dy, this.ins)) {
/* 145 */           (SETT.ROOMS()).data.set((ROOMA)this.ins, dx, dy, data);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static int initService(int tx, int ty, BathInstance ins) {
/* 154 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*     */     
/* 156 */     COORDINATE coo = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, Coo.TMP);
/* 157 */     int sx = coo.x();
/* 158 */     int sy = coo.y();
/*     */     
/* 160 */     int size = 0;
/* 161 */     for (int y = 0; y < it.height(); y++) {
/* 162 */       for (int x = 0; x < it.width(); x++) {
/* 163 */         int dx = sx + x;
/* 164 */         int dy = sy + y;
/* 165 */         if (isPool(dx, dy, ins)) {
/* 166 */           size++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 171 */     size /= 2;
/* 172 */     if (size <= 0 || size > 15) {
/* 173 */       throw new RuntimeException("" + tx + " " + tx + " " + ty + " " + sx + " " + sy);
/*     */     }
/* 175 */     int data = size << 8;
/* 176 */     data |= 0xC000;
/* 177 */     (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, data);
/* 178 */     return size;
/*     */   }
/*     */   
/*     */   private static boolean isPool(int tx, int ty, BathInstance ins) {
/* 182 */     return (ins.is(tx, ty) && ((SETT.ROOMS()).data.get(tx, ty) & 0xE000) == 57344);
/*     */   }
/*     */   
/*     */   void dispose() {
/* 186 */     reservedSet(0);
/* 187 */     availableSet(0);
/* 188 */     blip(this.coo.x(), this.coo.y(), 57344);
/* 189 */     save();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\Bath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */