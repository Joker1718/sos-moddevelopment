/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements FINDABLE
/*     */ {
/*     */   public int x() {
/*  80 */     return TIndoors.this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  85 */     return TIndoors.this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  90 */     return TIndoors.this.reservable.is(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  95 */     if (!findableReservedCanBe()) {
/*  96 */       throw new RuntimeException();
/*     */     }
/*     */     
/*  99 */     (SETT.PATH()).finders.indoor.report(this, -1);
/* 100 */     TIndoors.this.reservable.set(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 105 */     return !TIndoors.this.reservable.is(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 110 */     if (findableReservedIs()) {
/* 111 */       TIndoors.this.reservable.set(TIndoors.this.x + TIndoors.this.y * SETT.TWIDTH, true);
/* 112 */       (SETT.PATH()).finders.indoor.report(this, 1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TIndoors$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */