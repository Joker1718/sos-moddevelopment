/*     */ package settlement.entity.humanoid.ai.types.retired;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES) {
/* 167 */     super(paramPLANRES);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 171 */     d.planByte2 = (byte)(10 + RND.rInt(20));
/* 172 */     AIModule_Retired.Plan.this.job(a, d).jobStartPerforming();
/* 173 */     return res(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 179 */     if (!AIModule_Retired.Plan.this.conn(a, d)) {
/* 180 */       AIModule_Retired.Plan.this.cancel(a, d);
/* 181 */       return null;
/*     */     } 
/*     */     
/* 184 */     d.planByte2 = (byte)(d.planByte2 - 1);
/* 185 */     if (d.planByte2 <= 0) {
/* 186 */       AIModule_Retired.Plan.this.cancel(a, d);
/* 187 */       return AIModule_Retired.Plan.this.walk.set(a, d);
/*     */     } 
/*     */     
/* 190 */     if (AIModule_Retired.Plan.this.blue(d).cards((COORDINATE)d.planTile)) {
/* 191 */       if (RND.oneIn(8))
/* 192 */         return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).anima.fist.activate(a, d, (1.0F + RND.rFloat() * 2.0F))); 
/* 193 */       return (AI.SUBS()).STAND.activateTime(a, d, 6 + RND.rInt(3));
/* 194 */     }  if (AIModule_Retired.Plan.this.blue(d).dance((COORDINATE)d.planTile)) {
/* 195 */       if (RND.oneIn(5))
/* 196 */         return (AI.SUBS()).STAND.activateRndDir(a, d, 5 + RND.rInt(3)); 
/* 197 */       a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/* 198 */       return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).animaArr.dance().activate(a, d, (1.0F + RND.rFloat() * 10.0F)));
/* 199 */     }  if (AIModule_Retired.Plan.this.blue(d).sitDir((COORDINATE)d.planTile) != null) {
/* 200 */       a.speed.setDirCurrent(AIModule_Retired.Plan.this.blue(d).sitDir((COORDINATE)d.planTile));
/* 201 */       if (RND.oneIn(5)) {
/* 202 */         return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).animaArr.speak().activate(a, d, (2.0F + RND.rFloat() * 5.0F)));
/*     */       }
/*     */       
/* 205 */       return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 210 */     int dx = a.tc().x() + a.speed.dir().x();
/* 211 */     int dy = a.tc().y() + a.speed.dir().y();
/* 212 */     if (SETT.ENTITIES().hasAtTile(dx, dy)) {
/* 213 */       if (RND.rBoolean())
/* 214 */         return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).animaArr.speak().activate(a, d, (2.0F + RND.rFloat() * 5.0F))); 
/* 215 */       return (AI.SUBS()).STAND.activateTime(a, d, 5);
/* 216 */     }  if (RND.rBoolean()) {
/* 217 */       a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/*     */     }
/* 219 */     return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 226 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\retired\AIModule_Retired$Plan$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */