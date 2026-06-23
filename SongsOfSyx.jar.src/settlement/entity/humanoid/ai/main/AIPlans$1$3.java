/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public AISTATE resume(Humanoid a, AIManager d) {
/* 135 */     d.subByte = (byte)(d.subByte + 1);
/* 136 */     if (d.subByte != 1)
/* 137 */       return null; 
/* 138 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 139 */       DIR dir = (DIR)DIR.ALL.get(di);
/* 140 */       if ((SETT.PATH()).connectivity.is(a.tc(), dir)) {
/* 141 */         if (!dir.isOrtho() && 
/* 142 */           !((SETT.PATH()).availability.get(a.tc().x() + dir.x(), a.tc().y())).tileCollide && 
/* 143 */           !((SETT.PATH()).availability.get(a.tc().x(), a.tc().y() + dir.y())).tileCollide)
/* 144 */           return (AI.STATES()).WALK2.dirTile(a, d, dir); 
/* 145 */         if (dir.isOrtho() && !((SETT.PATH()).availability.get(a.tc().x() + dir.x(), a.tc().y() + dir.y())).tileCollide) {
/* 146 */           return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     switch (RND.rInt(3)) { case 0:
/* 152 */         return (AI.STATES()).STAND.activate(a, d, (0.5F + RND.rFloat(5.0D)));
/* 153 */       case 1: return (AI.STATES()).anima.wave.activate(a, d, (0.5F + RND.rFloat(5.0D))); }
/*     */     
/* 155 */     if (a.division() != null) {
/* 156 */       a.setDivision(null);
/*     */     }
/*     */     
/* 159 */     if (a.indu().hType().isHostile())
/* 160 */       (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1); 
/* 161 */     return (AI.STATES()).anima.box.activate(a, d, (0.5F + RND.rFloat(5.0D)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPlans$1$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */