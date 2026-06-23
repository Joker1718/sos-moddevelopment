/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.room.main.Room;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements SFINDER
/*     */ {
/*     */   public boolean isInComponent(SComponent c, double distance) {
/*  91 */     return SFinderResourceStorage.this.s().has(c, (RBIT)SFinderResourceStorage.this.mask);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTile(int tx, int ty, int tileNr) {
/*  96 */     Room res = (SETT.ROOMS()).map.get(tx, ty);
/*  97 */     if (res != null) {
/*  98 */       TILE_STORAGE s = res.storage(tx, ty);
/*  99 */       if (s != null && s.storageIsFindable() && s.resource() != null && s.storageReservable() > 0 && SFinderResourceStorage.this.mask.has(s.resource())) {
/* 100 */         SFinderResourceStorage.this.result = s.resource();
/* 101 */         return true;
/*     */       } 
/*     */     } 
/* 104 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResourceStorage$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */