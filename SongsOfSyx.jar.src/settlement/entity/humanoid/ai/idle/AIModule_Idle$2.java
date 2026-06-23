/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   
/*     */   null(String $anonymous0) {
/* 167 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     this.walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Idle.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 203 */           d.planByte1 = 16;
/* 204 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 209 */           if ((SETT.ROOMS()).BENCH.finder.getReserved(d.planTile.x(), d.planTile.y()) == null) {
/* 210 */             return null;
/*     */           }
/* 212 */           (STATS.SERVICE()).bench.access.indu().set(a.indu(), 1);
/* 213 */           Room bb = (SETT.ROOMS()).BENCH.get(d.planTile.x(), d.planTile.y());
/* 214 */           (STATS.SERVICE()).bench.setAccess(a.indu(), true, 1.0D - bb.getDegrade(d.planTile.x(), d.planTile.y()), bb.upgrade(d.planTile.x(), d.planTile.y()));
/* 215 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0 || !AIModule_Idle.null.access$0(AIModule_Idle.null.this).moduleCanContinue(a, d)) {
/* 216 */             can(a, d);
/* 217 */             return null;
/*     */           } 
/*     */           
/* 220 */           DIR dir = (SETT.ROOMS()).BENCH.benchDir(d.planTile.x(), d.planTile.y(), a.speed.dir());
/* 221 */           if (RND.oneIn(4))
/* 222 */             dir = dir.next((int)RND.rSign()); 
/* 223 */           a.speed.setDirCurrent(dir);
/* 224 */           return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(10));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 229 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 234 */           FINDABLE s = (SETT.ROOMS()).BENCH.finder.getReserved(d.planTile.x(), d.planTile.y());
/* 235 */           if (s != null) {
/* 236 */             s.findableReserveCancel();
/*     */           }
/*     */         }
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 241 */           if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 242 */             return 1.0D; 
/* 243 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     int r = STATS.RAN().get(a.indu(), 39) + TIME.hours().bitsSinceStart();
/*     */     r &= 0xFF;
/*     */     if (r > 127) {
/*     */       FINDABLE ff = (SETT.ROOMS()).BENCH.finder.getReservable(a.tc().x(), a.tc().y());
/*     */       if (ff != null) {
/*     */         d.planTile.set((COORDINATE)ff);
/*     */         ff.findableReserve();
/*     */         this.walk.set(a, d);
/*     */         return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */       } 
/*     */       AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.ROOMS()).BENCH.finder, (SETT.ROOMS()).BENCH.radius());
/*     */       if (s != null) {
/*     */         d.planTile.set(d.path.destX(), d.path.destY());
/*     */         this.walk.set(a, d);
/*     */         return s;
/*     */       } 
/*     */       if (!(SETT.ROOMS()).map.is(a.tc()) && (SETT.FLOOR()).getter.is(a.tc()))
/*     */         (STATS.SERVICE()).bench.clearAccess(a.indu()); 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\AIModule_Idle$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */