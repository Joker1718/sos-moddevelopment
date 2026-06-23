/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 164 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 168 */     Humanoid v = WorkPolice.this.victim(d);
/* 169 */     if (v == null || !WorkPolice.this.reserved(d)) {
/* 170 */       can(a, d);
/* 171 */       return null;
/*     */     } 
/* 173 */     WorkPolice.this.victim(d).knockOut();
/* 174 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.drag(a, d, (SETT.HUMANOIDS()).draggable, v.id(), (COORDINATE)d.planTile);
/* 175 */     if (s != null)
/* 176 */       return s; 
/* 177 */     WorkPolice.this.victim(d).interrupt();
/* 178 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 183 */     SETT_JOB j = WorkPolice.this.work(d);
/*     */     
/* 185 */     if (!WorkPolice.this.reserved(d)) {
/* 186 */       can(a, d);
/* 187 */       return null;
/*     */     } 
/* 189 */     j.jobPerform(a, null, 0);
/* 190 */     Humanoid v = WorkPolice.this.victim(d);
/* 191 */     if (v == null) {
/* 192 */       can(a, d);
/* 193 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 198 */     v.physics.body().moveC((j.jobCoo().x() * 64 + 32), (j.jobCoo().y() * 64 + 32));
/*     */     
/* 200 */     AIManager d2 = (AIManager)v.ai();
/* 201 */     d2.overwrite(v, (AIPLAN)WorkPolice.this.plan);
/*     */     
/* 203 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 209 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 214 */     SETT_JOB j = WorkPolice.this.work(d);
/* 215 */     if (j != null && j.jobReservedIs(null))
/* 216 */       j.jobReserveCancel(null); 
/* 217 */     if (WorkPolice.this.victim(d) != null)
/* 218 */       WorkPolice.this.victim(d).interrupt(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkPolice$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */