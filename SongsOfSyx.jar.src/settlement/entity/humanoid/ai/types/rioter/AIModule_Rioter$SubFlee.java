/*     */ package settlement.entity.humanoid.ai.types.rioter;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.battle.InterBattle;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
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
/*     */ final class SubFlee
/*     */   extends AISUB.Simple
/*     */ {
/*     */   public SubFlee() {
/* 196 */     super("riot_Flee");
/*     */   }
/*     */   
/*     */   AISUB.AISubActivation activate(Humanoid a, AIManager d, ENTITY other) {
/* 200 */     a.speed.turn2(other.body(), a.body());
/* 201 */     return activate(a, d);
/*     */   }
/*     */   
/*     */   AISUB.AISubActivation activate(Humanoid a, AIManager d, int iterations) {
/* 205 */     d.subPathByte = (byte)(iterations + 1);
/* 206 */     return activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 211 */     d.subPathByte = (byte)(2 + RND.rInt(5));
/* 212 */     d.subPathByte2 = (byte)(2 + RND.rInt(15));
/* 213 */     return super.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 218 */     a.speed.turnWithAngel(RND.rFloat0(90.0D));
/* 219 */     d.subPathByte = (short)(d.subPathByte - 1);
/* 220 */     if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc())) {
/* 221 */       d.subPathByte2 = (byte)(d.subPathByte2 - 1);
/* 222 */       if (d.subPathByte2 <= 0) {
/* 223 */         Humanoid.HumanoidResource.dead = CAUSE_LEAVES.DROWNED();
/*     */       }
/*     */     } 
/*     */     
/* 227 */     if (d.subPathByte > 0) {
/* 228 */       if (RND.oneIn(3))
/* 229 */         return (AI.STATES()).jogCrazy.activate(a, d, (2.0F + RND.rFloat() * 3.0F)); 
/* 230 */       return (AI.STATES()).jog.activate(a, d, (2.0F + RND.rFloat() * 3.0F));
/*     */     } 
/*     */     
/* 233 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 238 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 243 */     return InterBattle.pollReady(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 248 */     if (e.event == HEvent.CHECK_MORALE)
/* 249 */       return false; 
/* 250 */     return InterBattle.listener.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\rioter\AIModule_Rioter$SubFlee.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */