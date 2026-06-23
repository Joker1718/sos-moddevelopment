/*     */ package settlement.room.law.stocks;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ final class Tile {
/*  10 */   private final Bits stage = new Bits(15);
/*  11 */   private final Bits available = new Bits(240);
/*     */   
/*     */   private final ROOM_STOCKS b;
/*     */   
/*     */   private int x;
/*     */   private int y;
/*     */   private Instance ins;
/*     */   private final STATE[] states;
/*     */   public final FSERVICE service;
/*     */   
/*     */   public Tile get(int tx, int ty) {
/*  22 */     if (this.b.constructor.service(tx, ty)) {
/*  23 */       this.x = tx;
/*  24 */       this.y = ty;
/*  25 */       this.ins = (Instance)this.b.get(tx, ty);
/*  26 */       return this;
/*     */     } 
/*  28 */     return null;
/*     */   }
/*     */   
/*     */   public enum STATE
/*     */   {
/*  33 */     none, available, reserved, used;
/*     */   }
/*     */   
/*     */   Tile(ROOM_STOCKS b) {
/*  37 */     this.states = STATE.values();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     this.service = new FSERVICE()
/*     */       {
/*     */         public int y()
/*     */         {
/*  81 */           return Tile.this.y;
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/*  86 */           return Tile.this.x;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/*  91 */           return (Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y)) < 8);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/*  96 */           return (Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y)) > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 101 */           Tile.this.availableSet(Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y) + 1));
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 106 */           Tile.this.availableSet(Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y) - 1));
/*     */         }
/*     */ 
/*     */         
/*     */         public void consume() {
/* 111 */           findableReserveCancel();
/*     */         }
/*     */         
/*     */         public void startUsing() {}
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */   
/*     */   public STATE state() {
/*     */     return this.states[this.stage.get((SETT.ROOMS()).data.get(this.x, this.y))];
/*     */   }
/*     */   
/*     */   public boolean used() {
/*     */     return !(state() != STATE.reserved && state() != STATE.used);
/*     */   }
/*     */   
/*     */   public void init() {
/*     */     stateSet(STATE.available);
/*     */     availableSet(8);
/*     */   }
/*     */   
/*     */   public void stateSet(STATE state) {
/*     */     if (state() == STATE.none && state != STATE.none)
/*     */       this.b.total++; 
/*     */     if (state() == STATE.reserved || state() == STATE.used) {
/*     */       this.b.used--;
/*     */       this.ins.available = (byte)(this.ins.available - 1);
/*     */     } 
/*     */     int d = this.stage.set((SETT.ROOMS()).data.get(this.x, this.y), state.ordinal());
/*     */     (SETT.ROOMS()).data.set((ROOMA)this.ins, this.x, this.y, d);
/*     */     if (state == STATE.reserved || state == STATE.used) {
/*     */       this.b.used++;
/*     */       this.ins.available = (byte)(this.ins.available + 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void availableSet(int am) {
/*     */     am = CLAMP.i(am, 0, 8);
/*     */     this.ins.service.report(this.service, (RoomService)this.b.data, -1, true);
/*     */     int d = this.available.set((SETT.ROOMS()).data.get(this.x, this.y), am);
/*     */     (SETT.ROOMS()).data.set((ROOMA)this.ins, this.x, this.y, d);
/*     */     this.ins.service.report(this.service, (RoomService)this.b.data, 1, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */