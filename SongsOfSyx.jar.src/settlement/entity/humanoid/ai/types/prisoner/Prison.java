/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.law.prison.ROOM_PRISON;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ class Prison
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*  32 */   private final ROOM_PRISON b = (SETT.ROOMS()).PRISON; private final AIPLAN.PLANRES.Resumer init; private final AIPLAN.PLANRES.Resumer walkToDoor; private final AIPLAN.PLANRES.Resumer unfuck; private final AIPLAN.PLANRES.Resumer sleep; private final AIPLAN.PLANRES.Resumer poop; private final AIPLAN.PLANRES.Resumer eat; private final AIPLAN.PLANRES.Resumer eat2; private final AIPLAN.PLANRES.Resumer changeSpot;
/*     */   AIPLAN.PLANRES.Resumer free;
/*     */   
/*  35 */   public Prison() { super("prisPrison");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     this.init = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  70 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  76 */           if (d.planByte1 <= 0) {
/*  77 */             if (!(SETT.PATH()).connectivity.is(a.tc())) {
/*  78 */               return Prison.this.unfuck.set(a, d);
/*     */             }
/*  80 */             if ((AIModule_Prisoner.DATA()).prisonTimeLeft.get(d) == 0) {
/*  81 */               return Prison.this.free.set(a, d);
/*     */             }
/*     */             
/*  84 */             return null;
/*     */           } 
/*  86 */           d.planByte1 = (byte)(d.planByte1 - 1);
/*     */           
/*  88 */           if (!Prison.this.b.isWithinCell(a.tc().x(), a.tc().y(), (COORDINATE)AI.modules().coo(d))) {
/*  89 */             return Prison.this.walkToDoor.set(a, d);
/*     */           }
/*     */           
/*  92 */           if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0) {
/*  93 */             AISUB.AISubActivation s = unfuck(Prison.this.eat, a, d);
/*  94 */             if (s != null) {
/*  95 */               return s;
/*     */             }
/*     */           } 
/*  98 */           if (TIME.light().nightIs()) {
/*     */             
/* 100 */             AISUB.AISubActivation s = Prison.this.sleep.set(a, d);
/* 101 */             if (s != null) {
/* 102 */               return s;
/*     */             }
/*     */           } 
/*     */           
/* 106 */           if (RND.oneIn(5))
/*     */           {
/* 108 */             if (RND.oneIn(8)) {
/* 109 */               AISUB.AISubActivation s = unfuck(Prison.this.poop, a, d);
/* 110 */               if (s != null)
/* 111 */                 return s; 
/*     */             } else {
/* 113 */               AISUB.AISubActivation s = Prison.this.changeSpot.set(a, d);
/* 114 */               if (s != null) {
/* 115 */                 return s;
/*     */               }
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/* 121 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 126 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         private AISUB.AISubActivation unfuck(AIPLAN.PLANRES.Resumer res, Humanoid a, AIManager d) {
/* 136 */           if (!(SETT.PATH()).connectivity.is(a.tc())) {
/* 137 */             return Prison.this.unfuck.set(a, d);
/*     */           }
/* 139 */           return res.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 143 */     this.walkToDoor = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 147 */           return (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)AI.modules().coo(d));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 152 */           return Prison.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 157 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 171 */     this.unfuck = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/* 173 */         final AISUB untrapp = (AISUB)new AISUB.Simple("prisontrapped")
/*     */           {
/*     */             public AISTATE resume(Humanoid a, AIManager d)
/*     */             {
/* 177 */               d.subByte = (byte)(d.subByte + 1);
/* 178 */               if (d.subByte != 1)
/* 179 */                 return null; 
/* 180 */               for (int di = 0; di < DIR.ALL.size(); di++) {
/* 181 */                 DIR dir = (DIR)DIR.ALL.get(di);
/* 182 */                 if ((SETT.PATH()).connectivity.is(a.tc(), dir) && 
/* 183 */                   (Prison.null.access$0(Prison.null.this)).b.isWithinCell(a.tc().x() + dir.x(), a.tc().y() + dir.y(), (COORDINATE)AI.modules().coo(d)))
/*     */                 {
/* 185 */                   return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */                 }
/*     */               } 
/* 188 */               return (AI.STATES()).STAND.activate(a, d, 1.0D);
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 195 */           return this.untrapp.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 200 */           return Prison.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 205 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 215 */     this.sleep = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 219 */           return (AI.SUBS()).subSleep.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 225 */           return Prison.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 230 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 240 */     this.poop = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 244 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 250 */           FSERVICE c = Prison.this.b.getLatrine((COORDINATE)AI.modules().coo(d));
/* 251 */           if (c == null || !c.findableReservedCanBe())
/* 252 */             return null; 
/* 253 */           c.findableReserve();
/* 254 */           c.consume();
/* 255 */           return Prison.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 260 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 270 */     this.eat = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 274 */           FSERVICE c = Prison.this.b.getFood((COORDINATE)AI.modules().coo(d));
/* 275 */           if (c == null || !c.findableReservedCanBe())
/* 276 */             return null; 
/* 277 */           c.findableReserve();
/* 278 */           return (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)c);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 283 */           FSERVICE c = Prison.this.b.getFood((COORDINATE)AI.modules().coo(d));
/* 284 */           if (c != null)
/* 285 */             c.consume(); 
/* 286 */           return Prison.this.eat2.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 291 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 296 */           FSERVICE c = Prison.this.b.getFood((COORDINATE)AI.modules().coo(d));
/* 297 */           if (c != null) {
/* 298 */             c.consume();
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 303 */     this.eat2 = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 307 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.grab, 3.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 312 */           STATS.FOOD().eat(a, 0, 0.0D);
/* 313 */           (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/* 314 */           return Prison.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 319 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 329 */     this.changeSpot = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.PRISON()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 333 */           DIR dir = (DIR)DIR.ORTHO.rnd();
/* 334 */           int dx = a.tc().x() + dir.x();
/* 335 */           int dy = a.tc().y() + dir.y();
/* 336 */           if (Prison.this.b.isWithinCell(dx, dy, (COORDINATE)AI.modules().coo(d)) && 
/* 337 */             !SETT.ENTITIES().hasAtTile(dx, dy)) {
/* 338 */             return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */           }
/* 340 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 345 */           return Prison.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 350 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 360 */     this.free = new AIPLAN.PLANRES.Resumer(this, Dic.¤¤Free)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 364 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 369 */           HTYPE t = (((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu())).cl == HCLASSES.SLAVE()) ? HTYPES.SLAVE() : HTYPES.SUBJECT();
/*     */           
/* 371 */           a.HTypeSet(t, null, CAUSE_ARRIVES.PAROLE());
/* 372 */           (STATS.LAW()).EX_CON.indu().setD(a.indu(), 1.0D);
/* 373 */           return null;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */         
/* 378 */         public boolean con(Humanoid a, AIManager d) { return true; }
/*     */       
/*     */       }; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 390 */     if (e.event == HEvent.ROOM_REMOVED && e.room.blueprintI() == this.b && e.room.is((COORDINATE)AI.modules().coo(d))) {
/* 391 */       d.overwrite(a, (AI.plans()).NOP);
/* 392 */       AI.modules().coo(d).set(-1.0D, -1.0D);
/* 393 */       return true;
/*     */     } 
/* 395 */     return false;
/*     */   }
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) { if (setCell(a, d)) { if (PrisonerData.self.prisonReported.get(d) == 0) { PrisonerData.self.prisonReported.set(d, 1); PrisonerData.self.punish(a, d, CRIME_PUNISHMENTS.PRISON()); }  (STATS.NEEDS()).EXPOSURE.fix(a.indu()); d.planByte1 = 8; AISUB.AISubActivation s = this.init.set(a, d); if (s != null)
/*     */         return s;  cancel(a, d); }
/*     */      return null; } private boolean setCell(Humanoid a, AIManager d) { COORDINATE c = this.b.registerPrisoner((COORDINATE)AI.modules().coo(d), a.tc()); if (c == null)
/* 400 */       return false;  AI.modules().coo(d).set(c); return true; } protected void cancel(Humanoid a, AIManager d) { this.b.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/* 401 */     AI.modules().coo(d).set(-1.0D, -1.0D);
/* 402 */     super.cancel(a, d); }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation resume(Humanoid a, AIManager d) {
/* 407 */     AISUB.AISubActivation s = super.resume(a, d);
/* 408 */     if (s == null) {
/* 409 */       this.b.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/* 410 */       AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */     } 
/* 412 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\Prison.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */