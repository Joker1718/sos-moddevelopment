/*     */ package settlement.entity.humanoid.ai.types.child;
/*     */ 
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AIModule_Child.Plan
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer stand;
/*     */   
/*     */   null(AIModule_Child paramAIModule_Child2, String $anonymous0) {
/* 265 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 273 */     this.stand = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤play)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 278 */           if (!RND.oneIn(4)) {
/* 279 */             Humanoid f = AIModule_Child.null.access$0(AIModule_Child.null.this).friend(a, d);
/* 280 */             if (f == null) {
/* 281 */               f = AIModule_Child.null.access$0(AIModule_Child.null.this).parent(a, d);
/* 282 */             } else if (AIModule_Child.null.access$0(AIModule_Child.null.this).parent(a, d) != null && RND.oneIn(4)) {
/* 283 */               f = AIModule_Child.null.access$0(AIModule_Child.null.this).parent(a, d);
/*     */             } 
/* 285 */             if (f != null && 
/* 286 */               d.path.request(a.tc(), f.tc())) {
/* 287 */               return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */             }
/*     */           } 
/*     */           
/* 291 */           if ((SETT.PATH()).finders.randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64)) {
/* 292 */             return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */           }
/* 294 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 299 */           if (!AIModule_Child.null.access$0(AIModule_Child.null.this).moduleCanContinue(a, d) || RND.oneIn(8))
/* 300 */             return null; 
/* 301 */           if (RND.oneIn(4))
/* 302 */             return (AI.SUBS()).LAY.activateRndDir(a, d); 
/* 303 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 308 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     d.planByte1 = 0;
/*     */     return this.stand.set(a, d);
/*     */   }
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 321 */     if (e.event == HEvent.COLLISION_SOFT || e.event == HEvent.COLLISION_HARD)
/* 322 */       d.planByte1 = (byte)CLAMP.i(d.planByte1 + 1, 0, 3); 
/* 323 */     if (e.event == HEvent.COLLISION_UNREACHABLE) {
/* 324 */       DIR dd = a.speed.dir();
/* 325 */       if (!dd.isOrtho())
/* 326 */         dd = dd.next(1); 
/* 327 */       for (int i = 0; i < 4 && 
/* 328 */         !(SETT.PATH()).connectivity.is(a.tc(), dd); i++)
/*     */       {
/*     */         
/* 331 */         dd = dd.next(2);
/*     */       }
/*     */       
/* 334 */       if ((SETT.PATH()).connectivity.is(a.tc(), dd)) {
/* 335 */         a.speed.setRaw(dd, 0.5D);
/*     */       } else {
/* 337 */         a.speed.magnitudeTargetSet(0.0D);
/*     */       } 
/*     */     } 
/* 340 */     return super.event(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 345 */     if (d.planByte1 < 3 && e.type == HPoll.WILL_COLLIDE_WITH && e.other instanceof Humanoid && ((Humanoid)e.other).indu().hType() != HTYPES.CHILD() && RND.oneIn(8))
/* 346 */       return 1.0D; 
/* 347 */     return super.poll(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\child\AIModule_Child$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */