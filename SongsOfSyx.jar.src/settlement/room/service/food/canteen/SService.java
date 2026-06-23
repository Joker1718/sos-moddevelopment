/*     */ package settlement.room.service.food.canteen;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ 
/*     */ class SService implements FSERVICE {
/*     */   public static final int I = 2;
/*  17 */   private final Coo coo = new Coo(); public static final int MAX = 3;
/*     */   private final ROOM_CANTEEN e;
/*     */   private CanteenInstance ins;
/*     */   private int data;
/*  21 */   private final INT.INTE reserved = new INT.INTE()
/*     */     {
/*  23 */       private final Bits bits = new Bits(15);
/*     */ 
/*     */       
/*     */       public int min() {
/*  27 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max() {
/*  32 */         return CLAMP.i(3, 0, RESOURCES.EDI().all().size());
/*     */       }
/*     */ 
/*     */       
/*     */       public int get() {
/*  37 */         return this.bits.get(SService.this.data);
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(int t) {
/*  42 */         SService.this.data = this.bits.set(SService.this.data, t);
/*     */       }
/*     */     };
/*     */   
/*  46 */   private final INT.INTE available = new INT.INTE()
/*     */     {
/*  48 */       private final Bits bits = new Bits(240);
/*     */ 
/*     */       
/*     */       public int min() {
/*  52 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max() {
/*  57 */         return CLAMP.i(3, 0, RESOURCES.EDI().all().size());
/*     */       }
/*     */ 
/*     */       
/*     */       public int get() {
/*  62 */         return this.bits.get(SService.this.data);
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(int t) {
/*  67 */         SService.this.data = this.bits.set(SService.this.data, t);
/*     */       }
/*     */     };
/*     */   
/*     */   private int total() {
/*  72 */     return this.reserved.get() + this.available.get();
/*     */   }
/*     */   
/*     */   SService(ROOM_CANTEEN e) {
/*  76 */     this.e = e;
/*     */   }
/*     */ 
/*     */   
/*     */   SService get(int tx, int ty) {
/*  81 */     if (this.e.is(tx, ty) && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 2) {
/*  82 */       this.ins = (CanteenInstance)this.e.getter.get(tx, ty);
/*  83 */       this.coo.set(tx, ty);
/*  84 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  85 */       return this;
/*     */     } 
/*  87 */     return null;
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
/*     */   void check() {
/* 107 */     if (this.ins.amountTotal() > this.ins.serviceReserved() && total() < 3) {
/* 108 */       this.available.inc(1);
/*     */     }
/*     */     
/* 111 */     if (this.ins.amountTotal() <= 0 || this.ins.amountTotal() < this.ins.serviceReserved())
/* 112 */       if (this.available.get() > 0) {
/* 113 */         this.available.inc(-1);
/* 114 */       } else if (this.reserved.get() > 0) {
/* 115 */         this.reserved.inc(-1);
/*     */       }  
/* 117 */     save();
/*     */   }
/*     */   
/*     */   private void save() {
/* 121 */     int tmp = this.data;
/* 122 */     this.data = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/* 123 */     if (tmp == this.data)
/*     */       return; 
/* 125 */     this.ins.serviceTally(-this.available.get());
/* 126 */     this.ins.service.report(this, (RoomService)this.e.service, -1, this.available.get() - this.reserved.get(), this.reserved.get());
/*     */     
/* 128 */     this.data = tmp;
/* 129 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */     
/* 131 */     this.ins.service.report(this, (RoomService)this.e.service, 1, this.available.get() - this.reserved.get(), this.reserved.get());
/* 132 */     this.ins.serviceTally(this.available.get());
/*     */   }
/*     */   
/*     */   void dispose(int tx, int ty) {
/* 136 */     if (get(tx, ty) != null) {
/* 137 */       this.available.set(0);
/* 138 */       this.reserved.set(0);
/* 139 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 146 */     return (this.available.get() > this.reserved.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 151 */     this.reserved.inc(1);
/* 152 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 157 */     return (this.reserved.get() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 162 */     this.reserved.inc(-1);
/* 163 */     save();
/* 164 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 169 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 174 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 179 */     findableReserveCancel();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\SService.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */