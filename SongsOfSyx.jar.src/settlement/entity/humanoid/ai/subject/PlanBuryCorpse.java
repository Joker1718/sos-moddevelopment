/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.type.HCLASS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.spirit.dump.ROOM_DUMP;
/*     */ import settlement.room.spirit.grave.GRAVE_JOB;
/*     */ import settlement.room.spirit.grave.GraveData;
/*     */ import settlement.room.spirit.grave.ROOM_GRAVEYARD;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class PlanBuryCorpse
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*  27 */   private static CharSequence ¤¤verb = "burying corpse";
/*     */   
/*  29 */   private int timeout = -1; private final AIPLAN.PLANRES.Resumer dumpStart; private final AIPLAN.PLANRES.Resumer dumpRet;
/*     */   
/*     */   static {
/*  32 */     D.ts(PlanBuryCorpse.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer fetchCorpse; private final AIPLAN.PLANRES.Resumer returnCorpse; private final AIPLAN.PLANRES.Resumer work;
/*     */   PlanBuryCorpse() {
/*  36 */     super("SUBJECT_GRAVE");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     this.dumpStart = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/* 119 */         private ROOM_DUMP dump = (SETT.ROOMS()).DUMP;
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 123 */           COORDINATE coo = (this.dump.service()).finder.reserve(a.tc(), 2147483647);
/* 124 */           if (coo != null) {
/* 125 */             d.planTile.set(coo);
/* 126 */             ThingsCorpses.Corpse corpse = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 127 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)corpse);
/* 128 */             if (s != null) {
/* 129 */               return s;
/*     */             }
/* 131 */             can(a, d);
/*     */           } 
/* 133 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 134 */           if (c != null)
/* 135 */             c.findableReserveCancel(); 
/* 136 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 142 */           return PlanBuryCorpse.this.dumpRet.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 147 */           return ((SETT.THINGS()).corpses.getByIndex((short)d.planObject) != null && (SETT.THINGS()).corpses.getByIndex((short)d.planObject).canBeDragged());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 152 */           FSERVICE s = this.dump.service().service(d.planTile.x(), d.planTile.y());
/* 153 */           if (s != null)
/* 154 */             s.findableReserveCancel(); 
/* 155 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 156 */           if (c != null) {
/* 157 */             c.findableReserveCancel();
/*     */           }
/*     */         }
/*     */       };
/* 161 */     this.dumpRet = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/* 163 */         private ROOM_DUMP dump = (SETT.ROOMS()).DUMP;
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 167 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 168 */           return (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).corpses.draggable, c.index(), (COORDINATE)d.planTile);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 173 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 174 */           if (c != null) {
/* 175 */             this.dump.burry(c, d.planTile.x(), d.planTile.y());
/* 176 */             HCLASS cl = c.indu().hType().parentClass();
/* 177 */             for (StatsBurial.StatGrave g : (c.indu().race().service()).GRAVES.get(cl.index())) {
/* 178 */               if (g.grave().permission().get(cl, c.indu().race())) {
/* 179 */                 g.grave().get(cl).fail(c, 1);
/*     */               }
/*     */             } 
/* 182 */             c.remove();
/*     */           } else {
/* 184 */             can(a, d);
/*     */           } 
/* 186 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 191 */           return (this.dump.service().service(d.planTile.x(), d.planTile.y()) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 196 */           FSERVICE s = this.dump.service().service(d.planTile.x(), d.planTile.y());
/* 197 */           if (s != null)
/* 198 */             s.findableReserveCancel(); 
/* 199 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 200 */           if (c != null) {
/* 201 */             c.findableReserveCancel();
/*     */           }
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
/* 214 */     this.fetchCorpse = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 218 */           return (AI.SUBS()).walkTo.path(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 223 */           return PlanBuryCorpse.this.returnCorpse.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 228 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 229 */           if (c == null || !c.canBeDragged())
/* 230 */             return false; 
/* 231 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 232 */           return (job != null && job.jobReservedIs(null));
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 237 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 238 */           if (job != null)
/* 239 */             job.jobReserveCancel(null); 
/* 240 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 241 */           if (c != null) {
/* 242 */             c.findableReserveCancel();
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 248 */     this.returnCorpse = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 253 */           ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/*     */           
/* 255 */           RoomBlueprintImp gg = (RoomBlueprintImp)(SETT.ROOMS()).map.blueprintImp.get((COORDINATE)d.planTile);
/* 256 */           if (gg instanceof ROOM_GRAVEYARD) {
/* 257 */             ROOM_GRAVEYARD g = (ROOM_GRAVEYARD)gg;
/* 258 */             for (DIR dir : DIR.ORTHO) {
/* 259 */               if (g.isGraveHead(d.planTile.x() + dir.x(), d.planTile.y() + dir.y())) {
/* 260 */                 AISUB.AISubActivation aISubActivation = (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).corpses.draggable, c.index(), d.planTile.x() + dir.x(), d.planTile.y() + dir.y());
/* 261 */                 if (aISubActivation != null) {
/* 262 */                   return aISubActivation;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/* 267 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).corpses.draggable, c.index(), (COORDINATE)d.planTile);
/* 268 */           if (s == null) {
/* 269 */             can(a, d);
/* 270 */             c.findableReserveCancel();
/*     */           } 
/* 272 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 277 */           return PlanBuryCorpse.this.work.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 282 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 283 */           return (job != null && job.jobReservedIs(null));
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 288 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 289 */           if (job != null) {
/* 290 */             job.jobReserveCancel(null);
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 295 */     this.work = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 299 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 300 */           job.buryAndPerform((SETT.THINGS()).corpses.getByIndex((short)d.planObject));
/* 301 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 306 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 307 */           return (job != null && job.jobReservedIs(null));
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 312 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 313 */           if (job != null) {
/* 314 */             job.jobReserveCancel(null);
/*     */           }
/*     */         }
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 319 */           GRAVE_JOB job = PlanBuryCorpse.this.job(d);
/* 320 */           job.jobStartPerforming();
/* 321 */           return (AI.SUBS()).WORK.activate(a, d, 25.0D);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public boolean shouldBury(Humanoid a, AIManager d) {
/*     */     if (this.timeout == TIME.hours().bitsSinceStart())
/*     */       return false; 
/*     */     if (GAME.ARMIES().enemy().men() > 0)
/*     */       return false; 
/*     */     if (!(SETT.PATH()).availability.is(a.tc()))
/*     */       return false; 
/*     */     if (!(SETT.PATH()).reachability.is(a.tc()))
/*     */       return false; 
/*     */     return true;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if (GAME.ARMIES().enemy().men() > 0)
/*     */       return null; 
/*     */     if (!(SETT.PATH()).reachability.is(a.tc()))
/*     */       return null; 
/*     */     boolean has = false;
/*     */     if (!((SETT.ROOMS()).DUMP.service()).finder.has(a.tc())) {
/*     */       for (GraveData.GRAVE_DATA_HOLDER b : (SETT.ROOMS()).GRAVES) {
/*     */         if ((b.graveData()).available.get(null) > 0) {
/*     */           has = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       has = true;
/*     */     } 
/*     */     if (!has) {
/*     */       this.timeout = TIME.hours().bitsSinceStart();
/*     */       return null;
/*     */     } 
/*     */     if (!(SETT.PATH()).finders.corpses.reserve(a.tc(), d.path, 2147483647)) {
/*     */       this.timeout = TIME.hours().bitsSinceStart();
/*     */       return null;
/*     */     } 
/*     */     ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)(SETT.PATH()).finders.corpses.getResult();
/*     */     d.planObject = c.index();
/*     */     HCLASS cl = c.indu().hType().parentClass();
/*     */     for (StatsBurial.StatGrave g : (c.indu().race().service()).GRAVES.get(cl.index())) {
/*     */       if (g.grave().permission().get(cl, c.indu().race())) {
/*     */         GRAVE_JOB grave = g.grave().requestAccessTile();
/*     */         if (grave != null) {
/*     */           d.planTile.set(grave.jobCoo());
/*     */           grave.jobReserve(null);
/*     */           return this.fetchCorpse.set(a, d);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     AISUB.AISubActivation s = this.dumpStart.set(a, d);
/*     */     if (s == null) {
/*     */       c.findableReserveCancel();
/*     */       this.timeout = TIME.hours().bitsSinceStart();
/*     */     } 
/*     */     return s;
/*     */   }
/*     */   
/*     */   private GRAVE_JOB job(AIManager d) {
/*     */     RoomBlueprintImp b = (RoomBlueprintImp)(SETT.ROOMS()).map.blueprintImp.get((COORDINATE)d.planTile);
/*     */     if (b != null && b instanceof GraveData.GRAVE_DATA_HOLDER)
/*     */       return ((GraveData.GRAVE_DATA_HOLDER)b).graveData().work(d.planTile.x(), d.planTile.y()); 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\PlanBuryCorpse.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */