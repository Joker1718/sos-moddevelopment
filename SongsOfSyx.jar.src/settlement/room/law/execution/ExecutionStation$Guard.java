/*     */ package settlement.room.law.execution;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Guard
/*     */ {
/*     */   public boolean active() {
/* 216 */     if (ExecutionStation.this.bState.get() >= 1 && ExecutionStation.this.bState.get() < 5)
/* 217 */       return true; 
/* 218 */     return false;
/*     */   }
/*     */   
/*     */   public boolean shouldExecute() {
/* 222 */     return (ExecutionStation.this.bState.get() == 3);
/*     */   }
/*     */   
/*     */   public boolean workExecute() {
/* 226 */     if (ExecutionStation.this.bState.get() == 3) {
/* 227 */       ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 4);
/*     */       
/* 229 */       if (ExecutionStation.this.type(ExecutionStation.this.coo.x(), ExecutionStation.this.coo.y()) == 1) {
/* 230 */         for (ENTITY e : SETT.ENTITIES().getAtTile(ExecutionStation.this.coo.x(), ExecutionStation.this.coo.y())) {
/* 231 */           if (e instanceof Humanoid) {
/* 232 */             Humanoid a = (Humanoid)e;
/* 233 */             (STATS.NEEDS()).INJURIES.COUNT.indu().incD(a.indu(), 0.2D + RND.rFloat());
/* 234 */             (SETT.THINGS()).gore.cloud((ENTITY)a, (a.race().appearance()).colors.blood);
/* 235 */             (SETT.THINGS()).gore.flesh((ENTITY)a, (a.race().appearance()).colors.blood);
/* 236 */             if ((STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) > 0.75D) {
/* 237 */               (GAME.count()).EXECUTIONS.inc(1);
/* 238 */               (STATS.NEEDS()).INJURIES.COUNT.indu().setD(a.indu(), 1.0D);
/* 239 */               a.kill(false, CAUSE_LEAVES.EXECUTED());
/* 240 */               ExecutionStation.this.client.clientCancel();
/*     */             } 
/* 242 */             return true;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 249 */     return false;
/*     */   }
/*     */   
/*     */   public COORDINATE coo() {
/* 253 */     return (COORDINATE)ExecutionStation.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\ExecutionStation$Guard.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */