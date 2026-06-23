/*     */ package settlement.entity.humanoid.ai.work;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.food.farm.ROOM_FARM;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ final class WorkFarmer extends WorkAbs {
/*  17 */   private static CharSequence ¤¤storing = "Storing Harvest"; private final ROOM_FARM farm;
/*     */   
/*     */   static {
/*  20 */     D.ts(WorkFarmer.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer start;
/*     */   private final AIPLAN.PLANRES.Resumer go;
/*     */   
/*     */   protected WorkFarmer(AIModule_Work module, ROOM_FARM farm, PlanBlueprint[] map, WorkAbs.Works w) {
/*  26 */     super(module, (RoomBlueprintIns<?>)farm, map, w);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     this.start = new AIPLAN.PLANRES.Resumer(this, ¤¤storing)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  91 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  97 */           RESOURCE_TILE res = RESOURCE_TILE.GETTER.reserved(WorkFarmer.this.ress(d), d.path.destX(), d.path.destY());
/*  98 */           if (res == null) {
/*  99 */             can(a, d);
/* 100 */             return null;
/*     */           } 
/*     */           
/* 103 */           for (int i = 0; i < WorkFarmer.this.amount(d) && 
/* 104 */             res.findableReservedIs(); i++) {
/*     */             
/* 106 */             res.resourcePickup();
/* 107 */             d.resourceCarriedSet(WorkFarmer.this.ress(d));
/*     */           } 
/*     */           
/* 110 */           return WorkFarmer.this.go.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 115 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 121 */           RESOURCE_TILE res = RESOURCE_TILE.GETTER.reserved(WorkFarmer.this.ress(d), d.path.destX(), d.path.destY());
/* 122 */           for (int i = 0; i < WorkFarmer.this.amount(d) && 
/* 123 */             res.findableReservedIs(); i++)
/*     */           {
/* 125 */             res.findableReserveCancel();
/*     */           }
/* 127 */           WorkFarmer.this.go.can(a, d);
/*     */         }
/*     */       };
/*     */     
/* 131 */     this.go = new AIPLAN.PLANRES.Resumer(this, ¤¤storing)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 136 */           TILE_STORAGE st = WorkFarmer.this.storage(d);
/* 137 */           if (st == null) {
/* 138 */             return null;
/*     */           }
/* 140 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*     */           
/* 142 */           if (s == null) {
/* 143 */             can(a, d);
/* 144 */             return null;
/*     */           } 
/* 146 */           return s;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 152 */           TILE_STORAGE st = WorkFarmer.this.storage(d);
/* 153 */           if (st == null) {
/* 154 */             return null;
/*     */           }
/* 156 */           int am = WorkFarmer.this.amount(d);
/* 157 */           am = Math.min(am, st.storageReserved());
/* 158 */           st.storageDeposit(am);
/* 159 */           d.resourceCarriedSet(null);
/* 160 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 165 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 170 */           TILE_STORAGE st = WorkFarmer.this.storage(d);
/* 171 */           if (st == null)
/*     */             return; 
/* 173 */           int am = WorkFarmer.this.amount(d);
/* 174 */           am = Math.min(am, st.storageReserved());
/* 175 */           st.storageUnreserve(am);
/* 176 */           d.resourceDrop(a);
/*     */         }
/*     */       };
/*     */     this.farm = farm;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     AISUB.AISubActivation s = super.init(a, d);
/*     */     if (s != null)
/*     */       return s; 
/*     */     RESOURCE_TILE res = this.farm.toStore(work(a).mX(), work(a).mY());
/*     */     if (res == null)
/*     */       return null; 
/*     */     int resX = res.x();
/*     */     int resY = res.y();
/*     */     int reservable = res.reservable();
/*     */     TILE_STORAGE st = this.farm.toStoreTo(work(a).mX(), work(a).mY());
/*     */     if (st == null)
/*     */       return null; 
/*     */     d.planTile.set(st.x(), st.y());
/*     */     int am = Math.min(reservable, WorkAbs.maxCarry);
/*     */     am = Math.min(am, st.storageReservable());
/*     */     d.planByte1 = (byte)am;
/*     */     d.planByte2 = st.resource().bIndex();
/*     */     s = (AI.SUBS()).walkTo.coo(a, d, resX, resY);
/*     */     if (s == null)
/*     */       return null; 
/*     */     res = RESOURCE_TILE.GETTER.reservable(ress(d), false, false, resX, resY);
/*     */     for (int i = 0; i < am; i++)
/*     */       res.findableReserve(); 
/*     */     st = this.farm.toStoreTo(work(a).mX(), work(a).mY());
/*     */     st.storageReserve(am);
/*     */     this.start.set(a, d);
/*     */     return s;
/*     */   }
/*     */   
/*     */   private RESOURCE ress(AIManager d) {
/*     */     return (RESOURCE)RESOURCES.ALL().get(d.planByte2);
/*     */   }
/*     */   
/*     */   private int amount(AIManager d) {
/*     */     return d.planByte1;
/*     */   }
/*     */   
/*     */   private TILE_STORAGE storage(AIManager d) {
/*     */     return (TILE_STORAGE)(SETT.PATH()).finders.storage.getter.get((COORDINATE)d.planTile);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkFarmer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */