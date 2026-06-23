/*     */ package settlement.room.spirit.grave;
/*     */ 
/*     */ import settlement.misc.util.FSERVICE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements FSERVICE
/*     */ {
/*     */   public int x() {
/* 140 */     return Grave.this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 145 */     return Grave.this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 150 */     return (Grave.state.get(Grave.this.data) == 3 && !Grave.reserved.is(Grave.this.data));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 155 */     if (!findableReservedCanBe())
/* 156 */       throw new RuntimeException(); 
/* 157 */     Grave.this.data = Grave.reserved.set(Grave.this.data);
/* 158 */     Grave.this.save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 163 */     return Grave.reserved.is(Grave.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 168 */     Grave.this.data = Grave.reserved.clear(Grave.this.data);
/* 169 */     Grave.this.data = Grave.state.set(Grave.this.data, 3);
/* 170 */     Grave.this.save();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 175 */     Grave.this.data = Grave.reserved.clear(Grave.this.data);
/* 176 */     Grave.this.save();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\Grave$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */