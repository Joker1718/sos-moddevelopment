/*     */ package world.army;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ADInit.Updater
/*     */ {
/*     */   public void update(Faction f, double ds) {
/* 143 */     double d = ADStats.this.scoreF.getD(f);
/* 144 */     if (d < 0.0D) {
/* 145 */       d += ds / TIME.secondsPerDay() * 10.0D;
/* 146 */       d = CLAMP.d(d, d, 0.0D);
/* 147 */     } else if (d > 1.0D) {
/* 148 */       d -= ds / (TIME.secondsPerDay() * 20);
/* 149 */       d = CLAMP.d(d, 0.0D, d);
/*     */     } 
/* 151 */     ADStats.this.scoreF.setD(f, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(WArmy a, double ds) {
/* 156 */     double d = ADStats.this.scoreA.getD(a);
/* 157 */     if (d < 0.0D) {
/* 158 */       d += ds / TIME.secondsPerDay() * 5.0D;
/* 159 */       d = CLAMP.d(d, d, 0.0D);
/* 160 */     } else if (d > 1.0D) {
/* 161 */       d -= ds / (TIME.secondsPerDay() * 10);
/* 162 */       d = CLAMP.d(d, 0.0D, d);
/*     */     } 
/* 164 */     ADStats.this.scoreA.setD(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADStats$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */