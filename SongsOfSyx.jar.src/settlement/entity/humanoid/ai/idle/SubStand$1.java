/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*     */ 
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
/*     */   null(String $anonymous0, CharSequence $anonymous1) {
/*  91 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/*  95 */     d.subByte = (byte)(d.subByte + 1);
/*  96 */     switch (d.subByte) { case 1:
/*  97 */         return (AI.STATES()).STOP.instant(a, d);
/*  98 */       case 2: return (AI.STATES()).WALK2.cTile(a, d);
/*  99 */       case 3: return (AI.STATES()).STAND.activate(a, d, 0.5D);
/*     */       case 4:
/* 101 */         if (d.subPathByte >= DIR.ALL.size() || d.subPathByte < 0)
/* 102 */           return (AI.STATES()).STOP.activate(a, d); 
/* 103 */         a.speed.setDirCurrent((DIR)DIR.ALL.get(d.subPathByte));
/* 104 */         return (AI.STATES()).WALK2.dirTile(a, d, a.speed.dir());
/* 105 */       case 5: a.speed.magnitudeInit(0.0D); return (AI.STATES()).STOP.activate(a, d);
/* 106 */       case 6: return (AI.STATES()).STAND.activate(a, d, (15.0F + RND.rFloat(5.0D)));
/* 107 */       case 7: return (AI.STATES()).STOP.instant(a, d);
/* 108 */       case 8: return null; }
/*     */     
/* 110 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\SubStand$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */