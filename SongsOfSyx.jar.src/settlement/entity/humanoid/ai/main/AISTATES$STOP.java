/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class STOP
/*     */ {
/*     */   public final AISTATE state;
/*     */   
/*     */   public STOP(String key, final HSprite s) {
/* 156 */     this.state = new AISTATE(key, "stopping")
/*     */       {
/*     */         public HSprite sprite(Humanoid a)
/*     */         {
/* 160 */           return (a.speed.magnitude() >= a.speed.magintudeMax()) ? HSprites.LAY : s;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 166 */           if (a.speed.isZero()) {
/* 167 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 168 */             return (d.stateTimer > 0.0F);
/*     */           } 
/* 170 */           a.speed.brake(ds);
/* 171 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE activate(Humanoid a, AIManager d) {
/* 178 */     d.stateTimer = 0.1F;
/* 179 */     a.speed.magnitudeTargetSet(0.0D);
/*     */     
/* 181 */     return this.state;
/*     */   }
/*     */   
/*     */   public AISTATE instant(Humanoid a, AIManager d) {
/* 185 */     a.speed.magnitudeInit(0.0D);
/* 186 */     a.speed.magnitudeTargetSet(0.0D);
/*     */     
/* 188 */     d.stateTimer = 0.1F;
/* 189 */     return this.state;
/*     */   }
/*     */   
/*     */   public AISTATE aDirRND(Humanoid a, AIManager d, float time) {
/* 193 */     a.speed.turnRandom();
/* 194 */     d.stateTimer = time;
/* 195 */     a.speed.magnitudeTargetSet(0.0D);
/*     */     
/* 197 */     return this.state;
/*     */   }
/*     */   
/*     */   public AISTATE activate(Humanoid a, AIManager d, double time) {
/* 201 */     d.stateTimer = (float)time;
/* 202 */     a.speed.magnitudeTargetSet(0.0D);
/*     */     
/* 204 */     return this.state;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES$STOP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */