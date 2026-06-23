/*     */ package settlement.entity.humanoid.ai.home;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.home.chamber.ChamberInstance;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final AIPLAN.PLANRES.Resumer first;
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer bed;
/*     */   
/*     */   null(String $anonymous0) {
/* 229 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 243 */     this.first = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 247 */           return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 252 */           if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 253 */             if (RND.oneIn(6))
/* 254 */               return AIModule_Home.null.this.walk.set(a, d); 
/* 255 */             return AIModule_Home.null.this.bed.set(a, d);
/*     */           } 
/*     */           
/* 258 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 264 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 274 */     this.walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 279 */           if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 280 */             return (AI.SUBS()).walkTo.room(a, d, (RoomInstance)AIModule_Home.null.this.get(a));
/*     */           }
/* 282 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 287 */           if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 288 */             if (RND.oneIn(8)) {
/* 289 */               if (RND.oneIn(3))
/* 290 */                 return AIModule_Home.null.this.bed.set(a, d); 
/* 291 */               return (AI.SUBS()).walkTo.room(a, d, (RoomInstance)AIModule_Home.null.this.get(a));
/*     */             } 
/* 293 */             return (AI.SUBS()).STAND.activateRndDir(a, d, 4);
/*     */           } 
/*     */ 
/*     */           
/* 297 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 302 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 312 */     this.bed = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 316 */           d.planByte1 = 8;
/* 317 */           ChamberInstance chamberInstance = AIModule_Home.null.this.get(a);
/* 318 */           int sx = chamberInstance.serviceX();
/* 319 */           int sy = chamberInstance.serviceY();
/* 320 */           return (AI.SUBS()).walkTo.cooFull(a, d, sx, sy);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 325 */           if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 326 */             d.planByte1 = (byte)(d.planByte1 - 1);
/* 327 */             if (d.planByte1 <= 0)
/* 328 */               return AIModule_Home.null.this.walk.set(a, d); 
/* 329 */             return AIModule_Home.null.this.sleepBed(a, d);
/*     */           } 
/*     */           
/* 332 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 338 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private AISUB.AISubActivation sleepBed(Humanoid a, AIManager d) {
/* 349 */     d.planTile.set(d.path.destX(), d.path.destY());
/* 350 */     int tx = d.planTile.x();
/* 351 */     int ty = d.planTile.y();
/* 352 */     int cx = (SETT.ROOMS()).CHAMBER.getSleepPixelX(tx, ty);
/* 353 */     int cy = (SETT.ROOMS()).CHAMBER.getSleepPixelY(tx, ty);
/* 354 */     a.physics.body().moveC(cx, cy);
/* 355 */     a.speed.setRaw((SETT.ROOMS()).CHAMBER.getSleepDir(tx, ty), 0.0D);
/* 356 */     return (AI.SUBS()).subSleep.activate(a, d);
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { HOME h = (STATS.HOME()).GETTER.get(a, this); if (h.is(a.tc().x(), a.tc().y())) {
/*     */       if (RND.oneIn(6))
/*     */         return this.walk.set(a, d);  return this.bed.set(a, d);
/*     */     } 
/* 361 */     return this.first.set(a, d); } private boolean isHome(Humanoid a, AIManager d) { ChamberInstance h = get(a);
/* 362 */     return (h != null && h.is(a.tc())); }
/*     */ 
/*     */   
/*     */   private ChamberInstance get(Humanoid a) {
/* 366 */     HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 367 */     if (h != null && 
/* 368 */       h instanceof ChamberInstance) {
/* 369 */       return (ChamberInstance)h;
/*     */     }
/* 371 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 376 */     if (STATS.LAW().getCurfew().is()) {
/* 377 */       string.add(AIModule_Home.¤¤curfew);
/*     */     } else {
/* 379 */       string.add(AIModule_Home.¤¤name);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\home\AIModule_Home$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */