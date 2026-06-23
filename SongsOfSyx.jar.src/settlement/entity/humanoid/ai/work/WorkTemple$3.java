/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.room.spirit.temple.TempleInstance;
/*     */ import settlement.room.spirit.temple.TempleJob;
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
/*     */ class null
/*     */   extends WorkTemple.Res
/*     */ {
/*     */   null(WorkTemple paramWorkTemple2) {}
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 126 */     TempleInstance ins = (TempleInstance)WorkTemple.work(a);
/* 127 */     TempleJob j = ins.job(d.planTile.x(), d.planTile.y());
/*     */     
/* 129 */     if (d.resourceCarried() != null) {
/* 130 */       j.jobPerform(a, d.resourceA());
/* 131 */       d.resourceCarriedSet(null);
/* 132 */       return null;
/* 133 */     }  if (j.shouldKill()) {
/* 134 */       return WorkTemple.this.sacrifice.set(a, d);
/*     */     }
/* 136 */     d.planByte1 = 10;
/* 137 */     return res(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 143 */     d.planByte1 = (byte)(d.planByte1 - 1);
/* 144 */     if (d.planByte1 <= 0) {
/* 145 */       WorkTemple.this.unreserve(a, d);
/* 146 */       return null;
/*     */     } 
/* 148 */     if (RND.oneIn(5))
/* 149 */       WorkTemple.this.temple.employment().sound().rnd(a); 
/* 150 */     a.speed.setDirCurrent(a.speed.dir().next(RND.rInt0(1)));
/* 151 */     return (AI.SUBS()).single.activate(a, d, WorkTemple.this.preach[RND.rInt(WorkTemple.this.preach.length)], (2.0F + RND.rFloat(4.0D)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 157 */     return WorkTemple.this.reserved(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 162 */     WorkTemple.this.unreserve(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkTemple$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */