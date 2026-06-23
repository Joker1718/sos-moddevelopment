/*     */ package settlement.room.military.artillery;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderSoldierManning;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Service
/*     */ {
/*     */   private final ROOM_ARTILLERY blue;
/*     */   private int x;
/*     */   private int y;
/*     */   private ArtilleryInstance ins;
/*     */   private final SFinderSoldierManning.FINDABLE_MANNING ser;
/*     */   
/*     */   Service(ROOM_ARTILLERY blue) {
/*  48 */     this.ser = new SFinderSoldierManning.FINDABLE_MANNING()
/*     */       {
/*     */         public int y()
/*     */         {
/*  52 */           return Service.this.y;
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/*  57 */           return Service.this.x;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/*  62 */           return ((SETT.ROOMS()).data.get(Service.this.x, Service.this.y) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/*  67 */           return !findableReservedIs();
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/*  72 */           if (findableReservedIs()) {
/*  73 */             Service.this.blue.service(Service.this.x, Service.this.y).report(Service.this.x, Service.this.y, 1);
/*  74 */             (SETT.ROOMS()).data.set((ROOMA)Service.this.ins, Service.this.x, Service.this.y, 0);
/*  75 */             Service.this.ins.men = (byte)(Service.this.ins.men - 1);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/*  82 */           if (!findableReservedIs()) {
/*  83 */             Service.this.blue.service(Service.this.x, Service.this.y).report(Service.this.x, Service.this.y, -1);
/*  84 */             (SETT.ROOMS()).data.set((ROOMA)Service.this.ins, Service.this.x, Service.this.y, 1);
/*  85 */             Service.this.ins.men = (byte)(Service.this.ins.men + 1);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public DIR faceDIR() {
/*  92 */           return DIR.get((Service.this.x << 6) + 32, (Service.this.y << 6) + 32, Service.this.ins.centre());
/*     */         }
/*     */ 
/*     */         
/*     */         public void work(double time, Humanoid a) {
/*  97 */           Service.this.ins.work(time, a);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean needsWork() {
/* 103 */           return Service.this.ins.needsWork();
/*     */         }
/*     */ 
/*     */         
/*     */         public Army army() {
/* 108 */           return Service.this.ins.army();
/*     */         }
/*     */       };
/*     */     this.blue = blue;
/*     */   }
/*     */   
/*     */   public SFinderSoldierManning.FINDABLE_MANNING get(int tx, int ty) {
/*     */     this.ins = (ArtilleryInstance)this.blue.get(tx, ty);
/*     */     if (this.ins != null && this.ins.mustered() && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*     */       this.x = tx;
/*     */       this.y = ty;
/*     */       return this.ser;
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public void activate(int tx, int ty) {
/*     */     if (get(tx, ty) != null) {
/*     */       (SETT.ROOMS()).data.set((ROOMA)this.ins, this.x, this.y, 0);
/*     */       this.blue.service(tx, ty).report(tx, ty, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deactivate(int tx, int ty) {
/*     */     if (get(tx, ty) != null) {
/*     */       if (get(tx, ty).findableReservedCanBe())
/*     */         this.blue.service(tx, ty).report(tx, ty, -1); 
/*     */       (SETT.ROOMS()).data.set((ROOMA)this.ins, this.x, this.y, 0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */