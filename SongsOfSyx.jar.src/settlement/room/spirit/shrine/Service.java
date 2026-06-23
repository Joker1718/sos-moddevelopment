/*     */ package settlement.room.spirit.shrine;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Service
/*     */   implements FSERVICE {
/*     */   private static final int AVAILABLE = 1;
/*  13 */   private final Coo coo = new Coo(); private static final int RESERVED = 2;
/*     */   private int data;
/*     */   private ShrineInstance ins;
/*     */   private final ROOM_SHRINE blue;
/*     */   
/*     */   Service(ROOM_SHRINE blue) {
/*  19 */     this.blue = blue;
/*     */   }
/*     */   
/*     */   Service get(int tx, int ty) {
/*  23 */     if (this.blue.is(tx, ty) && 
/*  24 */       ((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty)).availability.player > 0.0D) {
/*  25 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  26 */       this.coo.set(tx, ty);
/*  27 */       this.ins = (ShrineInstance)this.blue.get(tx, ty);
/*  28 */       return this;
/*     */     } 
/*     */     
/*  31 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void save() {
/*  37 */     int old = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*     */     
/*  39 */     if (old != this.data) {
/*  40 */       int current = this.data;
/*  41 */       this.data = old;
/*  42 */       if (findableReservedCanBe())
/*  43 */         this.ins.service().report(this, (this.ins.blueprintI()).data, -1); 
/*  44 */       this.data = current;
/*  45 */       if (findableReservedCanBe())
/*  46 */         this.ins.service().report(this, (this.ins.blueprintI()).data, 1); 
/*  47 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
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
/*  64 */     if (state() != 2)
/*  65 */       throw new RuntimeException(); 
/*  66 */     stateSet(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startUsing() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int x() {
/*  76 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  81 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  86 */     return (state() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  91 */     if (state() == 1) {
/*  92 */       stateSet(2);
/*     */     } else {
/*     */       
/*  95 */       throw new RuntimeException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 102 */     return (state() == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 107 */     if (state() == 2) {
/* 108 */       stateSet(1);
/*     */     }
/*     */   }
/*     */   
/*     */   void dispose() {
/* 113 */     stateSet(2);
/*     */   }
/*     */   
/*     */   void init() {
/* 117 */     stateSet(1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\shrine\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */