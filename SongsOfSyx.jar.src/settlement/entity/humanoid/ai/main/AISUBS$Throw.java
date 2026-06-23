/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Throw
/*     */   extends AISUB.Simple
/*     */ {
/*     */   public Throw(String key) {
/* 102 */     super(key);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 108 */     if (!a.speed.isZero())
/* 109 */       return (AI.STATES()).STOP.activate(a, d); 
/* 110 */     d.subByte = (byte)(d.subByte + 1);
/* 111 */     if (d.subByte == 1) {
/* 112 */       return (AI.STATES()).anima.throww.activate(a, d);
/*     */     }
/* 114 */     if (d.subByte == 2) {
/* 115 */       DIR dd = a.speed.dir();
/* 116 */       int sx = a.body().cX();
/* 117 */       int sy = a.body().cY();
/* 118 */       dd = dd.next(1);
/* 119 */       sx += dd.x() * 32 / 2;
/* 120 */       sy += dd.y() * 32 / 2;
/*     */       
/* 122 */       (SETT.THINGS()).rubbish.throww(sx, sy, destX(a, d), destY(a, d));
/* 123 */       return (AI.STATES()).anima.fistRight.activate(a, d, 2.0D);
/*     */     } 
/* 125 */     if (d.subByte == 3) {
/* 126 */       return (AI.STATES()).anima.stand.activate(a, d, 4.0D);
/*     */     }
/*     */     
/* 129 */     return null;
/*     */   }
/*     */   
/*     */   public abstract int destX(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   public abstract int destY(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUBS$Throw.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */