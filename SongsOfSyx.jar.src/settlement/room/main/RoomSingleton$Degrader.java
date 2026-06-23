/*     */ package settlement.room.main;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Degrader
/*     */   extends ROOM_DEGRADER
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public int resSize() {
/* 195 */     return RoomSingleton.this.item.group.blueprint.resources();
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount(int i) {
/* 200 */     return (int)Math.ceil(RoomSingleton.this.item.cost2(i, RoomSingleton.this.upgrade(RoomSingleton.this.degA.mX(), RoomSingleton.this.degA.mY())));
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE res(int i) {
/* 205 */     return RoomSingleton.this.item.group.blueprint.resource(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public double degRate() {
/* 210 */     return RoomSingleton.this.degradeResNeeded();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getData() {
/* 215 */     return RoomSingleton.this.data;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setData(int v, boolean realDegradeChange) {
/* 220 */     double old = get();
/* 221 */     RoomSingleton.this.data = v;
/*     */     
/* 223 */     (SETT.ROOMS()).data.set(RoomSingleton.this.degA, RoomSingleton.this.dataTile, RoomSingleton.this.data);
/* 224 */     if (old != get()) {
/* 225 */       RoomSingleton.this.degradeChange(RoomSingleton.this.dataCoo.x(), RoomSingleton.this.dataCoo.y(), old, get(), realDegradeChange);
/*     */     }
/*     */   }
/*     */   
/*     */   public int roomArea() {
/* 230 */     return RoomSingleton.this.item.width() * RoomSingleton.this.item.height();
/*     */   }
/*     */ 
/*     */   
/*     */   public double base() {
/* 235 */     return RoomSingleton.this.blueprintI().degradeRate();
/*     */   }
/*     */ 
/*     */   
/*     */   public double expenseRate() {
/* 240 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double rate(double bonus) {
/* 245 */     double am = 0.0D;
/* 246 */     for (int ri = 0; ri < resSize(); ri++) {
/* 247 */       am += resAmount(ri);
/*     */     }
/* 249 */     return rate(bonus, base(), RoomSingleton.this.isolation(RoomSingleton.this.dataCoo.x(), RoomSingleton.this.dataCoo.y()), am, RoomSingleton.this.area(RoomSingleton.this.dataCoo.x(), RoomSingleton.this.dataCoo.y()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomSingleton$Degrader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */