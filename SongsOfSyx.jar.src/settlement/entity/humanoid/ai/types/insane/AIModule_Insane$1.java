/*     */ package settlement.entity.humanoid.ai.types.insane;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.health.asylum.ROOM_ASYLUM;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final ROOM_ASYLUM A;
/*     */   private final AIPLAN.PLANRES.Resumer init;
/*     */   private final AIPLAN.PLANRES.Resumer walkToDoor;
/*     */   private final AIPLAN.PLANRES.Resumer unfuck;
/*     */   private final AIPLAN.PLANRES.Resumer changeSpot;
/*     */   
/*     */   null(String $anonymous0) {
/*  82 */     super($anonymous0);
/*     */     
/*  84 */     this.A = (SETT.ROOMS()).ASYLUM;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.init = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 120 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 126 */           if (!AIModule_Insane.null.this.A.isreserved((COORDINATE)AI.modules().coo(d))) {
/* 127 */             return null;
/*     */           }
/* 129 */           if (d.planByte1 <= 0) {
/* 130 */             if (!(SETT.PATH()).connectivity.is(a.tc())) {
/* 131 */               return AIModule_Insane.null.this.unfuck.set(a, d);
/*     */             }
/* 133 */             AIModule_Insane.null.this.cancel(a, d);
/* 134 */             return null;
/*     */           } 
/*     */           
/* 137 */           if (!AIModule_Insane.null.this.A.isWithinCell(a.tc().x(), a.tc().y(), (COORDINATE)AI.modules().coo(d)))
/*     */           {
/* 139 */             return AIModule_Insane.null.this.walkToDoor.set(a, d);
/*     */           }
/*     */           
/* 142 */           if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0 && 
/* 143 */             AIModule_Insane.null.this.A.eatFood((COORDINATE)AI.modules().coo(d))) {
/* 144 */             (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/*     */           }
/*     */ 
/*     */           
/* 148 */           if (TIME.light().nightIs()) {
/* 149 */             return (AI.SUBS()).subSleep.activate(a, d);
/*     */           }
/*     */ 
/*     */           
/* 153 */           if (RND.oneIn(5)) {
/* 154 */             AISUB.AISubActivation s = AIModule_Insane.null.this.changeSpot.set(a, d);
/* 155 */             if (s != null)
/* 156 */               return s; 
/*     */           } 
/* 158 */           return (AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubsA[RND.rInt((AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubsA.length)].activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 163 */           return AIModule_Insane.null.this.A.isreserved((COORDINATE)AI.modules().coo(d));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 173 */     this.walkToDoor = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 177 */           return (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)AI.modules().coo(d));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 182 */           return AIModule_Insane.null.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 187 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 197 */     this.unfuck = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */       {
/* 199 */         final AISUB untrapp = (AISUB)new AISUB.Simple("insanetrapped")
/*     */           {
/*     */             public AISTATE resume(Humanoid a, AIManager d)
/*     */             {
/* 203 */               d.subByte = (byte)(d.subByte + 1);
/* 204 */               if (d.subByte != 1)
/* 205 */                 return null; 
/* 206 */               for (int di = 0; di < DIR.ALL.size(); di++) {
/* 207 */                 DIR dir = (DIR)DIR.ALL.get(di);
/* 208 */                 if ((SETT.PATH()).connectivity.is(a.tc(), dir) && 
/* 209 */                   (SETT.ROOMS()).ASYLUM.isWithinCell(a.tc().x() + dir.x(), a.tc().y() + dir.y(), (COORDINATE)AI.modules().coo(d)))
/*     */                 {
/* 211 */                   return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */                 }
/*     */               } 
/* 214 */               return (AI.STATES()).STAND.activate(a, d, 1.0D);
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 221 */           return this.untrapp.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 226 */           return AIModule_Insane.null.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 231 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 241 */     this.changeSpot = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 245 */           DIR dir = (DIR)DIR.ORTHO.rnd();
/* 246 */           int dx = a.tc().x() + dir.x();
/* 247 */           int dy = a.tc().y() + dir.y();
/* 248 */           if (AIModule_Insane.null.this.A.isWithinCell(dx, dy, (COORDINATE)AI.modules().coo(d)) && 
/* 249 */             !SETT.ENTITIES().hasAtTile(dx, dy)) {
/* 250 */             return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */           }
/* 252 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 257 */           return AIModule_Insane.null.this.init.set(a, d);
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 262 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 274 */     if (e.event == HEvent.ROOM_REMOVED && e.room.is((COORDINATE)AI.modules().coo(d))) {
/* 275 */       (SETT.ROOMS()).ASYLUM.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/* 276 */       AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */     } 
/* 278 */     return super.event(a, d, e);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */     COORDINATE c = this.A.registerPrisoner(a);
/*     */     if (c != null) {
/*     */       AI.modules().coo(d).set(c);
/*     */       d.planByte1 = 8;
/*     */       return this.init.set(a, d);
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation resume(Humanoid a, AIManager d) {
/*     */     AISUB.AISubActivation s = super.resume(a, d);
/*     */     if (s == null) {
/*     */       (SETT.ROOMS()).ASYLUM.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/*     */       AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */     } 
/*     */     return s;
/*     */   }
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/*     */     (SETT.ROOMS()).ASYLUM.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/*     */     AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */     super.cancel(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\insane\AIModule_Insane$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */