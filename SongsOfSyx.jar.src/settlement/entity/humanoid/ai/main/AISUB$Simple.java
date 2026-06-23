/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Simple
/*     */   extends AISUB
/*     */ {
/*     */   private final CharSequence name;
/*     */   
/*     */   protected Simple(String key) {
/* 112 */     super(key);
/* 113 */     this.name = getClass().getSimpleName();
/*     */   }
/*     */   
/*     */   protected Simple(String key, CharSequence name) {
/* 117 */     super(key);
/* 118 */     this.name = name;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 123 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 128 */     d.subByte = 0;
/* 129 */     AISTATE s = resume(a, d);
/* 130 */     return AISUB.AISubActivation.make(this, s);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d, AISTATE s) {
/* 134 */     d.subByte = 0;
/* 135 */     return AISUB.AISubActivation.make(this, s);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isSuccessful(Humanoid a, AIManager d) {
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract AISTATE resume(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {}
/*     */ 
/*     */   
/*     */   protected CharSequence name(Humanoid a, AIManager d) {
/* 153 */     return this.name;
/*     */   }
/*     */   
/*     */   protected boolean isBattleReady() {
/* 157 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUB$Simple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */