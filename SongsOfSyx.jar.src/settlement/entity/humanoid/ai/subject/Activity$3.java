/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.util.FINDABLE;
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
/*     */ class null
/*     */   extends Activity.R
/*     */ {
/*     */   null(Activity paramActivity2) {}
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 114 */     if (!Activity.this.s.is(d.planTile.x(), d.planTile.y())) {
/* 115 */       return null;
/*     */     }
/* 117 */     if (d.planByte1 <= 0) {
/* 118 */       if (!AIModules.current(d).moduleCanContinue(a, d) || RND.oneIn(5)) {
/* 119 */         can(a, d);
/* 120 */         return null;
/*     */       } 
/*     */     } else {
/*     */       
/* 124 */       FINDABLE f = Activity.this.s.finder().getReserved(d.planTile.x(), d.planTile.y());
/* 125 */       if (f == null) {
/* 126 */         f = Activity.this.s.finder().getReservable(d.planTile.x(), d.planTile.y());
/* 127 */         if (f == null) {
/* 128 */           d.planByte1 = (byte)(d.planByte1 - 3);
/*     */         } else {
/* 130 */           f.findableReserve();
/*     */         } 
/*     */       } 
/* 133 */       d.planByte1 = (byte)(d.planByte1 - 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     DIR dd = DIR.get(a.body().cX(), a.body().cY(), Activity.this.s.lookAt(d.planTile.x(), d.planTile.y()));
/* 140 */     if (RND.oneIn(5))
/* 141 */       dd = dd.next(RND.rInt0(1)); 
/* 142 */     a.speed.setDirCurrent(dd);
/*     */     
/* 144 */     if (Activity.this.s.shouldCheer(d.planTile.x(), d.planTile.y())) {
/* 145 */       return Activity.this.cheer.set(a, d);
/*     */     }
/*     */     
/* 148 */     if (Activity.this.s.shouldBoo(d.planTile.x(), d.planTile.y())) {
/* 149 */       return Activity.this.boo.set(a, d);
/*     */     }
/*     */ 
/*     */     
/* 153 */     return (AI.SUBS()).STAND.activateTime(a, d, 10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 159 */     return Activity.this.move.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\Activity$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */