/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 116 */     int ss = 0;
/* 117 */     for (TECH t : TECHS.ALL()) {
/* 118 */       for (BoostSpec s : t.boosters.all()) {
/* 119 */         ss = Math.max(s.boostable.index(), ss);
/*     */       }
/*     */     } 
/* 122 */     ss++;
/* 123 */     double[] totMul = new double[ss];
/* 124 */     double[] totAdd = new double[ss];
/* 125 */     double[] mul = new double[ss];
/* 126 */     double[] add = new double[ss];
/* 127 */     Arrays.fill(totMul, 1.0D);
/* 128 */     Arrays.fill(mul, 1.0D);
/*     */     
/* 130 */     for (TECH t : TECHS.ALL()) {
/* 131 */       for (BoostSpec s : t.boosters.all()) {
/* 132 */         if (s.booster.isMul && s.booster.to() > 1.0D) {
/* 133 */           totMul[s.boostable.index()] = totMul[s.boostable.index()] * s.booster.to() * t.levelMax;
/* 134 */           mul[s.boostable.index()] = mul[s.boostable.index()] * s.booster.to() * t.AIAmount * t.levelMax; continue;
/* 135 */         }  if (!s.booster.isMul && s.booster.to() > 0.0D) {
/* 136 */           totAdd[s.boostable.index()] = totAdd[s.boostable.index()] + s.booster.to() * t.levelMax;
/* 137 */           add[s.boostable.index()] = add[s.boostable.index()] + s.booster.to() * t.AIAmount * t.levelMax;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     PTech.this.npcAmount = new double[ss];
/*     */     
/* 144 */     for (int i = 0; i < ss; i++) {
/* 145 */       double tot = totMul[i] * totAdd[i];
/* 146 */       double t = mul[i] * add[i];
/* 147 */       PTech.this.npcAmount[i] = CLAMP.d(t / tot, 0.0D, 1.0D);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTech$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */