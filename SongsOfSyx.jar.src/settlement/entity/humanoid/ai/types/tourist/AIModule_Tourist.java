/*     */ package settlement.entity.humanoid.ai.types.tourist;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import game.tourism.TOURISM;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPE;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanWalkPath;
/*     */ import settlement.entity.humanoid.ai.util.AIUtilMoveH;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.infra.inn.InnInstance;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AIModule_Tourist
/*     */   extends AIModule
/*     */ {
/*  38 */   private static final int time = 1 * TIME.hoursPerDay();
/*     */   
/*     */   static final int shasCheckedIn = 1;
/*     */   static final int shasCheckedOut = 2;
/*     */   static final int shasReview = 4;
/*     */   static final int shasSight = 8;
/*     */   static final int shasService = 16;
/*  45 */   private static CharSequence ¤¤name = "¤Sight Seeing";
/*  46 */   private static CharSequence ¤¤checkin = "¤checking in";
/*  47 */   private static CharSequence ¤¤checkout = "¤checking out";
/*  48 */   private static CharSequence ¤¤sight = "¤sightseeing";
/*  49 */   private static CharSequence ¤¤leaving = "¤leaving"; AIPlanWalkPath checkIn; AIPlanWalkPath checkout; AIPlanWalkPath leaving; AIPLAN see;
/*     */   
/*     */   static {
/*  52 */     D.ts(AIModule_Tourist.class);
/*     */   }
/*     */   
/*     */   public AIModule_Tourist() {
/*  56 */     super((SPRITE)(UI.icons()).s.crossheir, ¤¤name, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     this.checkIn = new AIPlanWalkPath("touristCheckin", ¤¤checkin) {
/* 152 */         final AIPLAN.PLANRES.Resumer res = new AIPLAN.PLANRES.Resumer((AIPLAN.PLANRES)this)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 156 */               return (AI.SUBS()).STAND.activateRndDir(a, d, 2);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 162 */               AIModule_Tourist.service(d).startUsing();
/* 163 */               (AIModules.data()).byte1.orSet(d, 1);
/*     */               
/* 165 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 170 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d) {
/* 181 */           return this.res.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 186 */           return (AIModule_Tourist.service(d) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void cancel(Humanoid a, AIManager d) {
/* 191 */           AIModule_Tourist.consume(d);
/* 192 */           super.cancel(a, d);
/*     */         }
/*     */       };
/*     */     
/* 196 */     this.checkout = new AIPlanWalkPath("studentCheckout", ¤¤checkout) {
/* 197 */         final AIPLAN.PLANRES.Resumer res = new AIPLAN.PLANRES.Resumer((AIPLAN.PLANRES)this)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 201 */               d.planByte1 = 0;
/* 202 */               DIR dir = (SETT.ROOMS()).INN.sleepDir((AIModules.data()).x.get(d), (AIModules.data()).y.get(d));
/* 203 */               AIUtilMoveH.moveToTile(a, (AIModules.data()).x.get(d), (AIModules.data()).y.get(d), dir);
/* 204 */               return (AI.SUBS()).subSleep.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 209 */               d.planByte1 = (byte)(d.planByte1 + 1);
/* 210 */               if (d.planByte1 > 24) {
/* 211 */                 AIUtilMoveH.unfuck(a);
/* 212 */                 (AIModules.data()).byte1.orSet(d, 2);
/* 213 */                 return null;
/*     */               } 
/* 215 */               return (AI.SUBS()).subSleep.activate(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 222 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d) {
/* 233 */           return this.res.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 238 */           return (AIModule_Tourist.service(d) != null);
/*     */         }
/*     */       };
/*     */     
/* 242 */     this.leaving = new AIPlanWalkPath("TouristLeave", ¤¤leaving, true)
/*     */       {
/*     */         public AIPLAN.AiPlanActivation activate(Humanoid a, AIManager d)
/*     */         {
/* 246 */           if (((AIModules.data()).byte1.get(d) & 0x4) == 0) {
/* 247 */             TOURISM.touristFinish(a.indu(), (COORDINATE)AIModules.data().coo(d));
/*     */           }
/* 249 */           (AIModules.data()).byte1.orSet(d, 4);
/* 250 */           AIModule_Tourist.consume(d);
/*     */           
/* 252 */           if ((SETT.PATH()).finders.entryPoints.find(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/* 253 */             return super.activate(a, d);
/*     */           }
/* 255 */           Humanoid.HumanoidResource.dead = CAUSE_LEAVES.OTHER();
/* 256 */           return (AI.plans()).NOP.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d) {
/* 261 */           cancel(a, d);
/* 262 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 267 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void cancel(Humanoid a, AIManager d) {
/* 272 */           Humanoid.HumanoidResource.dead = CAUSE_LEAVES.OTHER();
/* 273 */           super.cancel(a, d);
/*     */         }
/*     */       };
/*     */     
/* 277 */     this.see = (AIPLAN)new AIPLAN.PLANRES("touristSee")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 282 */           d.planByte2 = 4;
/* 283 */           RoomBlueprintIns<?> b = TOURISM.attraction(a.indu());
/* 284 */           if (b.instancesSize() > 0) {
/*     */             
/* 286 */             int ii = RND.rInt(b.instancesSize());
/* 287 */             for (int k = 0; k < b.instancesSize(); k++) {
/* 288 */               RoomInstance ins = b.getInstance((ii + k) % b.instancesSize());
/* 289 */               if (ins.reachable())
/*     */               {
/* 291 */                 if (ins.employees().employed() > 0 && ins.reachable()) {
/* 292 */                   AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, ins);
/* 293 */                   if (s != null) {
/* 294 */                     this.inspect.set(a, d);
/* 295 */                     return s;
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 302 */           this.inspect.set(a, d);
/* 303 */           if ((SETT.PATH()).finders.randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64)) {
/* 304 */             return (AI.SUBS()).walkTo.path(a, d);
/*     */           }
/* 306 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */         
/* 309 */         private final AIPLAN.PLANRES.Resumer inspect = new AIPLAN.PLANRES.Resumer(this, "Inspecting")
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 313 */               d.planByte1 = 24;
/* 314 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 319 */               d.planByte1 = (byte)(d.planByte1 - 1);
/* 320 */               if (d.planByte1 <= 0) {
/* 321 */                 (AIModules.data()).byte1.orSet(d, 8);
/* 322 */                 return null;
/*     */               } 
/* 324 */               RoomInstance r = (RoomInstance)(SETT.ROOMS()).map.instance.get(a.tc());
/* 325 */               if (r != null && RND.oneIn(5)) {
/* 326 */                 return (AI.SUBS()).walkTo.room(a, d, r);
/*     */               }
/* 328 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 333 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 338 */               if (e.event == HEvent.INTERRACT) {
/* 339 */                 (AIModules.data()).byte1.orSet(d, 8);
/*     */               }
/* 341 */               return super.event(a, d, e);
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 346 */               if (e.type == HPoll.CAN_INTERRACT)
/* 347 */                 return 1.0D; 
/* 348 */               return super.poll(a, d, e);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 360 */           string.add(AIModule_Tourist.¤¤sight); }
/*     */       };
/*     */   } public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) { if (SETT.ENTRY().beseiged()) return this.leaving.activate(a, d);  if (((AIModules.data()).byte1.get(d) & 0x1) == 0 && ((SETT.ROOMS()).INN.service()).finder.reserve(a.tc(), d.path, 2147483647)) { AIModules.data().coo(d).set(d.path.destX(), d.path.destY()); return this.checkIn.activate(a, d); }  if (((AIModules.data()).byte1.get(d) & 0x8) == 0) { (AIModules.data()).byte1.set(d, (AIModules.data()).byte1.get(d) | 0x8); return this.see.activate(a, d); }  if (((AIModules.data()).byte1.get(d) & 0x10) == 0) { (AIModules.data()).byte1.set(d, (AIModules.data()).byte1.get(d) | 0x10); return TOURISM.servicePlan(a, d); }  if (Bits.getDistance((AIModules.data()).byte2.get(d), TIME.hours().bitsSinceStart(), 255) > time) { if (((AIModules.data()).byte1.get(d) & 0x2) == 0) { if (service(d) == null) { if (((SETT.ROOMS()).INN.service()).finder.reserve(a.tc(), d.path, 2147483647)) { AIModules.data().coo(d).set(d.path.destX(), d.path.destY()); return this.checkout.activate(a, d); }  return this.leaving.activate(a, d); }  if (d.path.request(a.tc(), (AIModules.data()).x.get(d), (AIModules.data()).y.get(d))) return this.checkout.activate(a, d);  }  return this.leaving.activate(a, d); }  return null; } protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {} public int getPriority(Humanoid a, AIManager d) { if (SETT.ENTRY().beseiged()) return 10;  int s = (AIModules.data()).byte1.get(d); if ((s & 0x1) == 0)
/*     */       return 9;  if ((s & 0x4) == 1)
/*     */       return 9;  if ((s & 0x8) == 0)
/*     */       return 1;  if ((s & 0x10) == 0)
/*     */       return 1;  if (Bits.getDistance((AIModules.data()).byte2.get(d), TIME.hours().bitsSinceStart(), 255) > time)
/* 367 */       return 5;  return 0; } protected void cancel(Humanoid a, AIManager d) { if (service(d) != null)
/* 368 */       service(d).consume();  }
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) { (AIModules.data()).byte1.set(d, 0); (AIModules.data()).byte2.set(d, TIME.hours().bitsSinceStart() & 0xFF); AIModules.data().coo(d).set(-1.0D, -1.0D); }
/*     */   public static boolean isTouristIn(Humanoid a, RoomInstance ins) { return ins.is((COORDINATE)AIModules.data().coo((AIManager)a.ai())); }
/*     */   public static InnInstance inn(Humanoid a) { if (service((AIManager)a.ai()) != null)
/*     */       return (InnInstance)(SETT.ROOMS()).INN.getter.get((COORDINATE)AIModules.data().coo((AIManager)a.ai())); 
/* 373 */     return null; } static void consume(AIManager d) { if (service(d) != null)
/* 374 */       service(d).consume(); 
/* 375 */     AIModules.data().coo(d).set(-1.0D, -1.0D); }
/*     */ 
/*     */   
/*     */   static FSERVICE service(AIManager d) {
/* 379 */     FSERVICE s = (SETT.ROOMS()).INN.service().service((AIModules.data()).x.get(d), (AIModules.data()).y.get(d));
/* 380 */     if (s != null && !s.findableReservedIs())
/* 381 */       GAME.Notify(AIModules.data().coo(d)); 
/* 382 */     if (s != null && s.findableReservedIs())
/* 383 */       return s; 
/* 384 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\tourist\AIModule_Tourist.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */