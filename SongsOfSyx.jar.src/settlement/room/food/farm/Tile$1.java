/*     */ package settlement.room.food.farm;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.ROOMA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Tile.Cycle
/*     */ {
/*     */   null(Tile paramTile2, CharSequence $anonymous0) {
/* 175 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   boolean is() {
/* 179 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public double size() {
/* 184 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double ripeness() {
/* 189 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double growth() {
/* 194 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double fruit() {
/* 199 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double ripenessFruit() {
/* 204 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 214 */     Tile.this.bWorked.inc((ROOMA)Tile.this.ins, 1);
/*     */     
/* 216 */     Tile.this.ins.tData.increase(skill, Tile.this.coo.x(), Tile.this.coo.y());
/* 217 */     if (Tile.this.bHasExtraWork.get() > 0 && is()) {
/* 218 */       Tile.this.bHasExtraWork.inc((ROOMA)Tile.this.ins, -1);
/* 219 */       jobReserveCancel((RESOURCE)null);
/*     */     } 
/* 221 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile() {
/* 226 */     int i = Tile.this.bWorked.get();
/* 227 */     int n = i / 2;
/* 228 */     Tile.this.bWorked.set((ROOMA)Tile.this.ins, n);
/* 229 */     Tile.this.ins.tData.decrease(i - n);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Tile$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */