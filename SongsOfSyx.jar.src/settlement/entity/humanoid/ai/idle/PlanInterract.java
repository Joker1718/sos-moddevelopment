/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.save.PROP;
/*     */ import game.time.TIME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ 
/*     */ 
/*     */ class PlanInterract
/*     */ {
/*  32 */   private static CharSequence ¤¤name = "¤Hanging out with {0}";
/*  33 */   private static CharSequence ¤¤nameMeet = "¤Meeting up with {0}";
/*  34 */   private static CharSequence ¤¤fighting = "¤Fighting {0}";
/*  35 */   private static CharSequence ¤¤knockedOut = "¤Knocked out";
/*  36 */   private static CharSequence ¤¤hanging = "¤Hanging out";
/*     */   
/*  38 */   private static CharSequence ¤¤brawling = "¤Brawling!";
/*  39 */   private static CharSequence ¤¤brawlingD = "¤Two of your subjects have started a brawl! In this world, some species have an instinctual dislike for one another. As their ruler, it's up to you to prevent them from starting fighting each other in brawls, often leading to deaths. A subject has their personal sanctuary in the vicinity of their homes. This sanctuary should not be intruded upon by species that they dislike. Make sure the homes you place down are a bit secluded, away from trafficked areas, and have some personal space by the entrances, where no other type of subjects but the residents themselves have any business visiting. 10 tiles from the house opening is a safe bet.";
/*     */ 
/*     */   
/*     */   static {
/*  43 */     D.ts(PlanInterract.class);
/*     */   }
/*     */   
/*  46 */   private final PROP.PropGame prop = PROP.game("FIRST_BRAWL");
/*     */   AIPLAN plan() {
/*  48 */     return this.lookForFriend;
/*     */   }
/*     */   
/*  51 */   final AIPLAN lookForFriend = (AIPLAN)new AIPLAN.PLANRES("idleInterract")
/*     */     {
/*     */       protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */       {
/*  55 */         AISUB.AISubActivation s = this.first.set(a, d);
/*  56 */         if (s != null)
/*  57 */           return s; 
/*  58 */         return this.wait.set(a, d);
/*     */       }
/*     */       
/*  61 */       private final AIPLAN.PLANRES.Resumer wait = new AIPLAN.PLANRES.Resumer(this, PlanInterract.¤¤hanging)
/*     */         {
/*     */           
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/*  66 */             d.planByte1 = (byte)(10 + RND.rInt(10));
/*     */             
/*  68 */             if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/*  69 */               (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/*  70 */               return PlanInterract.null.this.walking.set(a, d);
/*     */             } 
/*     */             
/*  73 */             return res(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  78 */             d.planByte1 = (byte)(d.planByte1 - 1); if (AIModules.current(d).moduleCanContinue(a, d) && d.planByte1 > 0) {
/*  79 */               (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*  81 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/*  86 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*  96 */             if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/*  97 */               return 1.0D; 
/*  98 */             return super.poll(a, d, e);
/*     */           }
/*     */         };
/*     */       
/* 102 */       private final AIPLAN.PLANRES.Resumer walking = new AIPLAN.PLANRES.Resumer(this, PlanInterract.¤¤hanging)
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 106 */             return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 111 */             d.planByte1 = (byte)(d.planByte1 - 1); if (AIModules.current(d).moduleCanContinue(a, d) && d.planByte1 > 0) {
/* 112 */               (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/* 114 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 119 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 129 */             if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 130 */               return 1.0D; 
/* 131 */             return super.poll(a, d, e);
/*     */           }
/*     */         };
/*     */       
/* 135 */       private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, "")
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 139 */             d.otherEntitySet(null);
/* 140 */             Humanoid o = PlanInterract.null.this.findAndSet(a);
/* 141 */             if (o == null)
/* 142 */               return null; 
/* 143 */             if (!d.path.request(a.tc(), o.tc().x(), o.tc().y())) {
/* 144 */               return null;
/*     */             }
/* 146 */             d.otherEntitySet(o);
/* 147 */             return (AI.SUBS()).walkTo.path(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 152 */             if (PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d) != null && a.tc().tileDistanceTo(PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d).tc()) < 3.0D)
/* 153 */               return d.resumeOtherPlan(a, (PlanInterract.null.access$0(PlanInterract.null.this)).interract); 
/* 154 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 159 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */           
/*     */           protected void name(Humanoid a, AIManager d, Str string) {
/* 169 */             Humanoid o = d.otherEntity();
/* 170 */             if (o == null) {
/* 171 */               string.add(PlanInterract.¤¤hanging);
/*     */             } else {
/* 173 */               string.add(PlanInterract.¤¤nameMeet).insert(0, STATS.APPEARANCE().name(o.indu()));
/*     */             } 
/*     */           }
/*     */         };
/*     */       private Humanoid findAndSet(Humanoid a) {
/* 178 */         SComponent c = (SETT.PATH().finders()).otherHumanoid.findComp(a, 20);
/* 179 */         if (c == null) {
/* 180 */           return null;
/*     */         }
/* 182 */         int dim = c.level().size() + 2;
/* 183 */         int x1 = (c.centreX() & (c.level().size() - 1 ^ 0xFFFFFFFF)) - 1;
/* 184 */         int y1 = (c.centreY() & (c.level().size() - 1 ^ 0xFFFFFFFF)) - 1;
/* 185 */         int x2 = x1 + dim;
/* 186 */         int y2 = y1 + dim;
/*     */         
/* 188 */         int rx = x1 + RND.rInt(dim);
/* 189 */         int ry = y1 + RND.rInt(dim);
/* 190 */         Humanoid backup = null;
/*     */ 
/*     */ 
/*     */         
/* 194 */         for (int y = 0; y < dim; y++) {
/* 195 */           for (int x = 0; x < dim; x++) {
/*     */             
/* 197 */             for (ENTITY e : SETT.ENTITIES().getAtTile(rx, ry)) {
/* 198 */               if (e != a && e instanceof Humanoid) {
/* 199 */                 Humanoid o = (Humanoid)e;
/*     */                 
/* 201 */                 if (HEvent.Handler.interract(o, a)) {
/* 202 */                   if (o.race() == a.race())
/* 203 */                     return o; 
/* 204 */                   if (backup == null) {
/* 205 */                     backup = o;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/* 210 */             rx++;
/* 211 */             if (rx >= x2) {
/* 212 */               rx = x1;
/* 213 */               ry++;
/* 214 */               if (ry >= y2) {
/* 215 */                 ry = y1;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 222 */         if (backup != null && 
/* 223 */           PlanInterract.this.shouldFight(a, backup)) {
/* 224 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 229 */         return backup;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 234 */   final AIPLAN waitForFriend = (AIPLAN)new AIPLAN.PLANRES("idleHang")
/*     */     {
/*     */       protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */       {
/* 238 */         return this.start.set(a, d);
/*     */       }
/*     */       
/* 241 */       private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, PlanInterract.¤¤hanging)
/*     */         {
/*     */           
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 246 */             d.planByte1 = (byte)(10 + RND.rInt(10));
/*     */             
/* 248 */             if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/* 249 */               (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/* 250 */               return PlanInterract.null.this.walking.set(a, d);
/*     */             } 
/*     */             
/* 253 */             return res(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 258 */             d.planByte1 = (byte)(d.planByte1 - 1); if (AIModules.current(d).moduleCanContinue(a, d) && d.planByte1 > 0) {
/* 259 */               (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/* 261 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 266 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 276 */             if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 277 */               return 1.0D; 
/* 278 */             return super.poll(a, d, e);
/*     */           }
/*     */         };
/*     */       
/* 282 */       private final AIPLAN.PLANRES.Resumer walking = new AIPLAN.PLANRES.Resumer(this, PlanInterract.¤¤hanging)
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 286 */             return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 291 */             d.planByte1 = (byte)(d.planByte1 - 1); if (AIModules.current(d).moduleCanContinue(a, d) && d.planByte1 > 0) {
/* 292 */               (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/* 294 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 299 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 309 */             if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 310 */               return 1.0D; 
/* 311 */             return super.poll(a, d, e);
/*     */           }
/*     */         };
/*     */     };
/*     */ 
/*     */   
/* 317 */   final AIPLAN interract = (AIPLAN)new AIPLAN.PLANRES("idleInterract2")
/*     */     {
/*     */       protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */       {
/* 321 */         return this.first.set(a, d);
/*     */       }
/*     */       
/* 324 */       private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, "")
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 328 */             d.planByte1 = 0;
/* 329 */             return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 335 */             if (!PlanInterract.null.access$0(PlanInterract.null.this).conn(a, d)) {
/* 336 */               return null;
/*     */             }
/* 338 */             Humanoid o = PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d);
/*     */             
/* 340 */             if (((AIManager)o.ai()).plan() == (PlanInterract.null.access$0(PlanInterract.null.this)).lookForFriend) {
/* 341 */               d.planByte1 = (byte)(d.planByte1 + 1);
/* 342 */               if (d.planByte1 > 100)
/* 343 */                 return null; 
/* 344 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             } 
/*     */             
/* 347 */             if (PlanInterract.null.access$0(PlanInterract.null.this).shouldFight(a, o))
/* 348 */               return PlanInterract.null.this.fight.set(a, d); 
/* 349 */             return PlanInterract.null.this.social.set(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 354 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */       
/* 363 */       private final AIPLAN.PLANRES.Resumer fight = new AIPLAN.PLANRES.Resumer(this, "")
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 367 */             d.planByte1 = (byte)(15 + RND.rInt(30));
/* 368 */             (STATS.POP()).FRIEND.set(a.indu(), PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d));
/* 369 */             if ((PlanInterract.null.access$0(PlanInterract.null.this)).prop.i(PlanInterract.null.this.key, 0) == 0) {
/* 370 */               (new MessageText(PlanInterract.¤¤brawling, PlanInterract.¤¤brawlingD)).send();
/* 371 */               (PlanInterract.null.access$0(PlanInterract.null.this)).prop.setI(PlanInterract.null.this.key, 1);
/*     */             } 
/*     */             
/* 374 */             return res(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 379 */             d.planByte1 = (byte)(d.planByte1 - 1);
/* 380 */             if (d.planByte1 < 0)
/* 381 */               return null; 
/* 382 */             if (!PlanInterract.null.access$0(PlanInterract.null.this).conn(a, d))
/* 383 */               return null; 
/* 384 */             if ((STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) > 0.25D) {
/* 385 */               return d.resumeOtherPlan(a, (PlanInterract.null.access$0(PlanInterract.null.this)).out);
/*     */             }
/* 387 */             Humanoid o = PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d);
/* 388 */             if (RND.rBoolean()) {
/* 389 */               a.speed.turn2(a.body(), o.body());
/* 390 */               return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(2));
/*     */             } 
/* 392 */             double dam = RND.rFloat() * 0.25D * (BOOSTABLES.BATTLE()).BLUNT_ATTACK.get((BOOSTABLE_O)a.indu()) / (BOOSTABLES.BATTLE()).BLUNT_DEFENCE.get((BOOSTABLE_O)o.indu());
/* 393 */             if (dam > 0.4D)
/* 394 */               dam = 0.4D; 
/* 395 */             o.inflictDamage(dam, CAUSE_LEAVES.BRAWL());
/* 396 */             return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).anima.box.activate(a, d, 1.0D));
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 401 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */       
/* 410 */       private final AIPLAN.PLANRES.Resumer social = new AIPLAN.PLANRES.Resumer(this, "")
/*     */         {
/* 412 */           private final AISTATES.Animation[] ani = new AISTATES.Animation[] {
/* 413 */               (AI.STATES()).anima.carry, 
/* 414 */               (AI.STATES()).anima.fist, 
/* 415 */               (AI.STATES()).anima.grab, 
/* 416 */               (AI.STATES()).anima.fistRight, 
/* 417 */               (AI.STATES()).anima.fistRight, 
/* 418 */               (AI.STATES()).anima.fistRight
/*     */             };
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 423 */             d.planByte1 = (byte)(15 + RND.rInt(30));
/* 424 */             if ((STATS.POP()).FRIEND.get(a.indu()) == null || RND.oneIn(10)) {
/* 425 */               (STATS.POP()).FRIEND.set(a.indu(), PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d));
/*     */             }
/* 427 */             return res(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 432 */             d.planByte1 = (byte)(d.planByte1 - 1);
/* 433 */             if (d.planByte1 < 0)
/* 434 */               return null; 
/* 435 */             if (!PlanInterract.null.access$0(PlanInterract.null.this).conn(a, d))
/* 436 */               return null; 
/* 437 */             Humanoid o = PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d);
/* 438 */             if (RND.rBoolean()) {
/* 439 */               a.speed.turn2(a.body(), o.body());
/* 440 */               return (AI.SUBS()).STAND.activateRndDir(a, d, RND.rInt(5));
/*     */             } 
/* 442 */             return (AI.SUBS()).DUMMY.activate(a, d, this.ani[RND.rInt(this.ani.length)].activate(a, d, RND.rFloat(3.0D)));
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 447 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*     */       protected void name(Humanoid a, AIManager d, Str string) {
/* 458 */         Humanoid o = PlanInterract.this.friend(a, d);
/* 459 */         if (o == null) {
/* 460 */           string.add(PlanInterract.¤¤hanging);
/* 461 */         } else if (((AIManager)o.ai()).plan() == PlanInterract.this.lookForFriend) {
/* 462 */           string.add(PlanInterract.¤¤nameMeet).insert(0, STATS.APPEARANCE().name(o.indu()));
/* 463 */         } else if (PlanInterract.this.shouldFight(a, o)) {
/* 464 */           string.add(PlanInterract.¤¤fighting).insert(0, STATS.APPEARANCE().name(o.indu()));
/*     */         } else {
/* 466 */           string.add(PlanInterract.¤¤name).insert(0, STATS.APPEARANCE().name(o.indu()));
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/* 471 */   private final AIPLAN out = (AIPLAN)new AIPLAN.PLANRES("idleOut")
/*     */     {
/*     */       protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */       {
/* 475 */         return this.next.set(a, d);
/*     */       }
/*     */       
/* 478 */       private final AIPLAN.PLANRES.Resumer next = new AIPLAN.PLANRES.Resumer(this, PlanInterract.¤¤knockedOut)
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 482 */             return (AI.SUBS()).LAY.activateTime(a, d, 10 + RND.rInt(10));
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 487 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 492 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */     };
/*     */ 
/*     */   
/*     */   private Humanoid friend(Humanoid a, AIManager d) {
/* 503 */     Humanoid h = d.otherEntity();
/* 504 */     if (h != null && (((AIManager)h.ai()).plan() == this.interract || ((AIManager)h.ai()).plan() == this.lookForFriend))
/* 505 */       return h; 
/* 506 */     return null;
/*     */   }
/*     */   
/* 509 */   private static double CHA = 5.960464832810452E-8D;
/*     */ 
/*     */   
/*     */   public boolean shouldFight(Humanoid a, Humanoid b) {
/* 513 */     if ((GAME.events()).riot.shouldBrawl(a, b)) {
/* 514 */       return true;
/*     */     }
/* 516 */     if (a.indu().clas() != b.indu().clas()) {
/* 517 */       return false;
/*     */     }
/* 519 */     if (a.race() == b.race()) {
/* 520 */       return false;
/*     */     }
/*     */     
/* 523 */     COORDINATE h = (STATS.HOME()).GETTER.hCoo(a);
/* 524 */     if (h == null) {
/* 525 */       return false;
/*     */     }
/* 527 */     if (a.tc().tileDistanceTo(h) > 48.0D) {
/* 528 */       return false;
/*     */     }
/* 530 */     h = (STATS.HOME()).GETTER.hCoo(b);
/* 531 */     if (h == null) {
/* 532 */       return false;
/*     */     }
/*     */     
/* 535 */     if (b.tc().tileDistanceTo(h) > 10.0D) {
/* 536 */       return false;
/*     */     }
/*     */     
/* 539 */     double c = 1.0D - a.race().pref().race(b.indu().race());
/*     */     
/* 541 */     long ran = (STATS.RAN().get(a.indu(), 0) + STATS.RAN().get(b.indu(), 0) + TIME.days().bitsSinceStart());
/* 542 */     double d = CHA * (ran & 0xFFFFFFL);
/* 543 */     return (c > d);
/*     */   }
/*     */   
/*     */   public boolean conn(Humanoid a, AIManager d) {
/* 547 */     return (friend(a, d) != null && AIModules.nextPrio(d) < 5);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\PlanInterract.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */