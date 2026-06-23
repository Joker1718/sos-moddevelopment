/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.room.spirit.temple.TempleInstance;
/*     */ import settlement.room.spirit.temple.TempleJob;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WorkTemple.Res
/*     */ {
/*     */   null(WorkTemple paramWorkTemple2) {}
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 171 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.stab, 10.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 177 */     TempleInstance ins = (TempleInstance)WorkTemple.work(a);
/* 178 */     TempleJob j = ins.job(d.planTile.x(), d.planTile.y());
/*     */     
/* 180 */     if (j.shouldKill()) {
/* 181 */       j.kill();
/*     */       
/* 183 */       if (j.shouldKill()) {
/* 184 */         return setAction(a, d);
/*     */       }
/* 186 */       WorkTemple.this.temple.employment().sound().rnd(a);
/* 187 */       return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, 4.0D);
/*     */     } 
/*     */     
/* 190 */     WorkTemple.this.unreserve(a, d);
/* 191 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 196 */     return WorkTemple.this.reserved(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 201 */     WorkTemple.this.unreserve(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkTemple$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */