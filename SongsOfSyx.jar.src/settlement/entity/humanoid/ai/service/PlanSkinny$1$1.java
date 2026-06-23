/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends AISUB.Simple
/*     */ {
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/*  83 */     d.subByte = (byte)(d.subByte + 1);
/*     */     
/*  85 */     if (!a.speed.isZero()) {
/*  86 */       a.speed.magnitudeInit(0.0D);
/*     */     }
/*  88 */     if (d.subByte > 1) {
/*  89 */       (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/*  90 */       (STATS.NEEDS()).DIRTINESS.set(a.indu(), 0);
/*     */     } 
/*     */     
/*  93 */     if (d.subByte > 20) {
/*  94 */       return null;
/*     */     }
/*  96 */     if (RND.oneIn(5)) {
/*     */       
/*  98 */       DIR dir = (DIR)DIR.ALL.get(RND.rInt(DIR.ALL.size()));
/*     */       
/* 100 */       for (int i = 0; i < 8; i++) {
/* 101 */         int x = a.physics.tileC().x() + dir.x();
/* 102 */         int y = a.physics.tileC().y() + dir.y();
/* 103 */         if ((SETT.PATH()).coster.player.getCost(a.tc().x(), a.tc().y(), x, y) > 0.0D && (SETT.PATH()).finders.water.get(x, y) != null) {
/* 104 */           return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */         }
/* 106 */         dir = dir.next(1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 111 */     if (RND.oneIn(3))
/* 112 */       return (AI.STATES()).STAND.aDirRND(a, d, 1.0F + RND.rFloat(2.0D)); 
/* 113 */     return (AI.STATES()).LAY.activate(a, d, (1.0F + RND.rFloat(5.0D)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\PlanSkinny$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */