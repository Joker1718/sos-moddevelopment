/*     */ package settlement.room.service.hearth;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Hearth
/*     */   implements FSERVICE {
/*     */   private static final int AVAILABLE = 1;
/*     */   private static final int RESERVED = 2;
/*  14 */   private final Coo coo = new Coo(); private static final int USED = 3;
/*     */   private int data;
/*     */   private HearthInstance ins;
/*     */   private final ROOM_HEARTH blue;
/*     */   
/*     */   Hearth(ROOM_HEARTH blue) {
/*  20 */     this.blue = blue;
/*     */   }
/*     */   
/*     */   Hearth get(int tx, int ty) {
/*  24 */     if (this.blue.is(tx, ty) && 
/*  25 */       (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  26 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  27 */       this.coo.set(tx, ty);
/*  28 */       this.ins = (HearthInstance)this.blue.get(tx, ty);
/*  29 */       return this;
/*     */     } 
/*     */     
/*  32 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void save() {
/*  39 */     int old = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*     */     
/*  41 */     if (old != this.data) {
/*  42 */       int current = this.data;
/*  43 */       this.data = old;
/*  44 */       if (state() == 3)
/*  45 */         this.ins.used = (short)(this.ins.used - 1); 
/*  46 */       if (findableReservedCanBe())
/*  47 */         this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, -1); 
/*  48 */       this.data = current;
/*  49 */       if (state() == 3)
/*  50 */         this.ins.used = (short)(this.ins.used + 1); 
/*  51 */       if (findableReservedCanBe())
/*  52 */         this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, 1); 
/*  53 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int state() {
/*  59 */     return this.data & 0xF;
/*     */   }
/*     */   
/*     */   private void stateSet(int state) {
/*  63 */     this.data &= 0xFFFFFFF0;
/*  64 */     this.data |= state;
/*  65 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/*  70 */     if (state() != 3)
/*  71 */       throw new RuntimeException(); 
/*  72 */     stateSet(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startUsing() {
/*  77 */     stateSet(3);
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  82 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  87 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  92 */     return (state() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  97 */     if (state() != 1)
/*  98 */       throw new RuntimeException(); 
/*  99 */     stateSet(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 105 */     return !(state() != 2 && state() != 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 110 */     if (state() == 2 || state() == 3) {
/* 111 */       stateSet(1);
/*     */     }
/*     */   }
/*     */   
/*     */   void dispose() {
/* 116 */     stateSet(2);
/*     */   }
/*     */   
/*     */   void init() {
/* 120 */     stateSet(1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hearth\Hearth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */