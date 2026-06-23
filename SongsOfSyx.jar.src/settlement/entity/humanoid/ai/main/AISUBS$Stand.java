/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
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
/*     */ public class Stand
/*     */   extends AISUB.Simple
/*     */ {
/*     */   public Stand() {
/* 187 */     super("subsstanding");
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 192 */     return activateTime(a, d, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activateRndDir(Humanoid a, AIManager d) {
/* 197 */     if (a.speed.isZero()) {
/* 198 */       a.speed.setRaw(a.speed.dir().next(1 * (RND.rBoolean() ? 1 : -1)), 0.0D);
/*     */     }
/* 200 */     activateTime(a, d, 4 + RND.rInt(4));
/* 201 */     return super.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activateRndDir(Humanoid a, AIManager d, int seconds) {
/* 206 */     if (a.speed.isZero()) {
/* 207 */       a.speed.setRaw(a.speed.dir().next(1 * (RND.rBoolean() ? 1 : -1)), 0.0D);
/*     */     }
/* 209 */     activateTime(a, d, seconds);
/* 210 */     return super.activate(a, d);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation activateTime(Humanoid a, AIManager d, int seconds) {
/* 214 */     d.subPathByte2 = (byte)seconds;
/* 215 */     return super.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE resume(Humanoid a, AIManager d) {
/* 220 */     d.subByte = (byte)(d.subByte + 1);
/* 221 */     if (!a.speed.isZero())
/* 222 */       return (AI.STATES()).STOP.activate(a, d); 
/* 223 */     if (d.subByte == 1) {
/* 224 */       return (AI.STATES()).STAND.activate(a, d, d.subPathByte2);
/*     */     }
/* 226 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUBS$Stand.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */