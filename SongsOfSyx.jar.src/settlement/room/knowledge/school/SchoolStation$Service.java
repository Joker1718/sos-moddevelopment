/*     */ package settlement.room.knowledge.school;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Service
/*     */   implements FSERVICE
/*     */ {
/*     */   int x;
/*     */   int y;
/*     */   int data;
/* 232 */   private final Bit reserved = new Bit(1);
/* 233 */   private final Bit reservable = new Bit(2);
/* 234 */   private final Bit used = new Bit(4);
/*     */   
/*     */   public int y() {
/* 237 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 242 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 247 */     return this.reserved.is(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 252 */     return (!this.reserved.is(this.data) && this.reservable.is(this.data));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 257 */     this.data = this.reserved.clear(this.data);
/* 258 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 263 */     if (findableReservedCanBe()) {
/* 264 */       this.data = this.reserved.set(this.data);
/* 265 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void startUsing() {
/* 271 */     if (findableReservedIs()) {
/* 272 */       this.data = this.used.set(this.data);
/* 273 */       save();
/* 274 */       SchoolStation.this.work.consume(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 280 */     this.data = 0;
/* 281 */     SchoolStation.this.work.consume(true);
/* 282 */     if (SchoolStation.this.work.dones.get(SchoolStation.this.work.data) > 0) {
/* 283 */       this.data = this.reservable.set(this.data);
/*     */     }
/* 285 */     save();
/*     */   }
/*     */   
/*     */   void setReserveable() {
/* 289 */     this.data = this.reservable.set(this.data);
/* 290 */     save();
/*     */   }
/*     */   
/*     */   private void save() {
/* 294 */     int c = this.data;
/* 295 */     this.data = (SETT.ROOMS()).data.get((COORDINATE)this);
/* 296 */     SchoolStation.this.ins.service().report(this, SchoolStation.this.ins.blueprintI().service(), -1);
/* 297 */     this.data = c;
/* 298 */     SchoolStation.this.ins.service().report(this, SchoolStation.this.ins.blueprintI().service(), 1);
/* 299 */     (SETT.ROOMS()).data.set((ROOMA)SchoolStation.this.ins, this.x, this.y, this.data);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\SchoolStation$Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */