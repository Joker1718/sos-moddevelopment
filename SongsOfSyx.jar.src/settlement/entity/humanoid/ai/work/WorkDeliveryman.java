/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.infra.logistics.MoveJob;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class WorkDeliveryman
/*     */   extends PlanBlueprint
/*     */ {
/*     */   private final boolean standAround;
/*  29 */   private static CharSequence ¤¤storing = "Storing Goods";
/*  30 */   private static CharSequence ¤¤waiting = "Waiting for orders"; private final AIPlanResourceMany fetch;
/*     */   
/*     */   static {
/*  33 */     D.ts(WorkDeliveryman.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer return_resource; private final AIPLAN.PLANRES.Resumer standing;
/*     */   protected WorkDeliveryman(AIModule_Work module, PlanBlueprint[] map, RoomBlueprintIns<?> b, boolean standAround) {
/*  37 */     super("work_delivery_" + b.key, module, b, map);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.fetch = new AIPlanResourceMany(this, 48)
/*     */       {
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*     */         {
/* 113 */           d.planByte2 = resource(a, d).bIndex();
/* 114 */           return WorkDeliveryman.this.return_resource.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void cancel(Humanoid a, AIManager d) {
/* 119 */           STATS.WORK().fetchProximityEnd(a);
/* 120 */           WorkDeliveryman.this.unreserve(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     this.return_resource = new AIPLAN.PLANRES.Resumer(this, ¤¤storing)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 143 */           if (!con(a, d)) {
/* 144 */             can(a, d);
/* 145 */             return WorkDeliveryman.this.WAIT_AND_EXIT.set(a, d);
/*     */           } 
/* 147 */           return (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 153 */           if (!con(a, d)) {
/* 154 */             can(a, d);
/* 155 */             return WorkDeliveryman.this.WAIT_AND_EXIT.set(a, d);
/*     */           } 
/* 157 */           TILE_STORAGE c = WorkDeliveryman.this.targetStorage(a, d);
/* 158 */           int am = d.resourceA();
/* 159 */           am = CLAMP.i(am, 0, c.storageReserved());
/* 160 */           c.storageDeposit(am);
/*     */           
/* 162 */           int res = d.planByte1 - am;
/* 163 */           if (res > 0) {
/* 164 */             c.storageUnreserve(res);
/*     */           }
/* 166 */           if (d.resourceCarried() != null)
/* 167 */             d.resourceAInc(-am); 
/* 168 */           d.resourceDrop(a);
/*     */           
/* 170 */           int i = d.resourceA() - am;
/* 171 */           if (i > 0)
/* 172 */             d.resourceDrop(a); 
/* 173 */           d.resourceCarriedSet(null);
/* 174 */           STATS.WORK().fetchProximityEnd(a);
/* 175 */           return WorkDeliveryman.this.WAIT_AND_EXIT.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 181 */           if (WorkDeliveryman.work(a) != null) {
/* 182 */             TILE_STORAGE c = WorkDeliveryman.this.targetStorage(a, d);
/*     */             
/* 184 */             if (c != null && c.storageReserved() > 0 && c.resource() != null && c.resource().bIndex() == d.planByte2) {
/* 185 */               return true;
/*     */             }
/*     */           } 
/* 188 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 193 */           WorkDeliveryman.this.unreserve(a, d);
/* 194 */           STATS.WORK().fetchProximityEnd(a);
/* 195 */           d.resourceDrop(a);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 201 */     this.standing = new AIPLAN.PLANRES.Resumer(this, ¤¤waiting)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 205 */           if (WorkDeliveryman.work(a).is(a.tc()))
/* 206 */             return (AI.SUBS()).STAND.activateRndDir(a, d, 5); 
/* 207 */           return (AI.SUBS()).walkTo.room(a, d, WorkDeliveryman.work(a));
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 212 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 217 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e)
/*     */         {
/* 227 */           if (e.type == HPoll.WORKING)
/* 228 */             return 0.0D; 
/* 229 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     this.standAround = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 237 */     if (e.type == HPoll.WORKING) {
/* 238 */       return ((getResumer(d) == this.standing) ? false : true);
/*     */     }
/* 240 */     return super.poll(a, d, e);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     RoomInstance i = work(a);
/*     */     MoveJob.ROOM_MOVEJOBBER jobber = (MoveJob.ROOM_MOVEJOBBER)i;
/*     */     MoveJob j = jobber.moveJob(a);
/*     */     if (j == null) {
/*     */       if (this.standAround)
/*     */         return this.standing.set(a, d); 
/*     */       return null;
/*     */     } 
/*     */     if (!d.path.request(a.tc(), (COORDINATE)j.source)) {
/*     */       LOG.ln("NAY " + String.valueOf(a.tc()) + " " + String.valueOf(j.source));
/*     */       return null;
/*     */     } 
/*     */     Room room = (Room)(SETT.ROOMS()).map.get((COORDINATE)j.dest);
/*     */     if (room == null)
/*     */       fuckup(j, a); 
/*     */     TILE_STORAGE st = room.storage(j.dest.x(), j.dest.y());
/*     */     if (st == null)
/*     */       fuckup(j, a); 
/*     */     if (st.resource() != j.res) {
/*     */       System.err.println(String.valueOf(st.resource()) + " " + String.valueOf(st.resource()));
/*     */       fuckup(j, a);
/*     */     } 
/*     */     if (j.maxAm <= 0)
/*     */       fuckup(j, a); 
/*     */     if (st.storageReservable() < j.maxAm)
/*     */       fuckup(j, a); 
/*     */     j.maxAm = CLAMP.i(j.maxAm, 0, 63);
/*     */     st.storageReserve(j.maxAm);
/*     */     if (RESOURCE_TILE.GETTER.reserve(j.stored, j.prio, j.res, j.source.x(), j.source.y(), 1) == 0)
/*     */       fuckup(j, a); 
/*     */     d.planByte1 = (byte)j.maxAm;
/*     */     d.planTile.set(j.dest.x(), j.dest.y());
/*     */     AISUB.AISubActivation s = this.fetch.activateFound(a, d, j.res, d.planByte1, j.stored, j.prio);
/*     */     if (s == null)
/*     */       unreserve(a, d); 
/*     */     STATS.WORK().fetchProximityStart(a);
/*     */     return s;
/*     */   }
/*     */   
/*     */   private void fuckup(MoveJob j, Humanoid a) {
/*     */     System.err.println(j.res);
/*     */     System.err.println(j.source);
/*     */     System.err.println(j.dest);
/*     */     System.err.println(j.maxAm);
/*     */     throw new RuntimeException(String.valueOf(work(a)));
/*     */   }
/*     */   
/*     */   private void unreserve(Humanoid a, AIManager d) {
/*     */     TILE_STORAGE c = targetStorage(a, d);
/*     */     if (c != null) {
/*     */       int i = CLAMP.i(d.planByte1, 0, c.storageReserved());
/*     */       c.storageUnreserve(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   private TILE_STORAGE targetStorage(Humanoid a, AIManager d) {
/*     */     Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)d.planTile);
/*     */     if (r != null)
/*     */       return r.storage(d.planTile.x(), d.planTile.y()); 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkDeliveryman.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */