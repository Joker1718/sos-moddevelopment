/*     */ package settlement.room.service.hygine.well;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Wash
/*     */   implements FSERVICE {
/*     */   private static final int AVAILABLE = 0;
/*     */   private static final int RESERVED = 1;
/*     */   private static final int USED = 2;
/*     */   private int data;
/*  16 */   private final Coo coo = new Coo();
/*     */   
/*     */   private WellInstance ins;
/*     */   private final ROOM_WELL blue;
/*     */   
/*     */   Wash(ROOM_WELL blue) {
/*  22 */     this.blue = blue;
/*     */   }
/*     */   
/*     */   Wash get(int tx, int ty) {
/*  26 */     if (this.blue.is(tx, ty) && 
/*  27 */       (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  28 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  29 */       this.coo.set(tx, ty);
/*  30 */       this.ins = (WellInstance)this.blue.get(tx, ty);
/*  31 */       return this;
/*     */     } 
/*     */     
/*  34 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void save() {
/*  39 */     int old = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*     */     
/*  41 */     if (old != this.data) {
/*  42 */       int current = this.data;
/*  43 */       this.data = old;
/*  44 */       this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, -1);
/*  45 */       this.data = current;
/*  46 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*  47 */       this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int state() {
/*  53 */     return this.data & 0xF;
/*     */   }
/*     */   
/*     */   private void stateSet(int state) {
/*  57 */     this.data &= 0xFFFFFFF0;
/*  58 */     this.data |= state;
/*  59 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/*  64 */     stateSet(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startUsing() {
/*  69 */     stateSet(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  74 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  79 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  84 */     return (state() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  89 */     if (state() != 0)
/*  90 */       throw new RuntimeException(); 
/*  91 */     stateSet(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/*  97 */     return !(state() != 1 && state() != 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 102 */     if (state() == 1 || state() == 2) {
/* 103 */       stateSet(0);
/*     */     }
/*     */   }
/*     */   
/*     */   void dispose() {
/* 108 */     if (findableReservedCanBe())
/* 109 */       findableReserve(); 
/*     */   }
/*     */   
/*     */   void init(int tx, int ty) {
/* 113 */     if (get(tx, ty) != null)
/* 114 */       this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, 1); 
/*     */   }
/*     */   
/*     */   public boolean isUsed(int tile) {
/* 118 */     this.data = (SETT.ROOMS()).data.get(tile);
/* 119 */     return (state() == 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\well\Wash.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */