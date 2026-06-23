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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public int y() {
/* 207 */     return TWater.null.this.sy;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 212 */     return TWater.null.this.sx;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 217 */     return (((TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) & 0x100) == 256);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 222 */     return (((TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) & 0x100) != 256);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 227 */     if (findableReservedIs()) {
/* 228 */       (SETT.PATH()).finders.water.report(TWater.null.this.sx, TWater.null.this.sy, 1);
/*     */     }
/*     */     
/* 231 */     (TWater.null.access$2(TWater.null.this)).shared.data.set(TWater.null.this.sx, TWater.null.this.sy, (TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) & 0xFFFFFEFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 236 */     if (findableReservedCanBe()) {
/* 237 */       (SETT.PATH()).finders.water.report(TWater.null.this.sx, TWater.null.this.sy, -1);
/*     */     }
/*     */     
/* 240 */     (TWater.null.access$2(TWater.null.this)).shared.data.set(TWater.null.this.sx, TWater.null.this.sy, (TWater.null.access$2(TWater.null.this)).shared.data.get(TWater.null.this.sx, TWater.null.this.sy) | 0x100);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TWater$2$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */