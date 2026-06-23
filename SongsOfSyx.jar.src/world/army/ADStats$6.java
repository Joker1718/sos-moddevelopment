/*     */ package world.army;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.battle.BattleListener;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BattleListener
/*     */ {
/*     */   public void siege(Faction attacker, Region reg) {
/* 172 */     ADStats.this.siegeWon.f.inc(attacker, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void siege(WArmy attacker, Region reg) {
/* 177 */     ADStats.this.siegeWon.a.inc(attacker, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void battle(WArmy a, boolean victory, int losses, int kills, Faction againsts) {
/* 182 */     ADStats.this.kills.a.inc(a, kills);
/* 183 */     ADStats.this.losses.a.inc(a, losses);
/* 184 */     if (victory) {
/* 185 */       double d = 0.25D * kills / (AD.men(null).get(a) + 1);
/* 186 */       double s = ADStats.this.scoreA.getD(a);
/* 187 */       s += d;
/* 188 */       s = CLAMP.d(s, 0.0D, 1.0D);
/* 189 */       ADStats.this.scoreA.setD(a, s);
/* 190 */       if (kills > 0)
/* 191 */         ADStats.this.wins.a.inc(a, 1); 
/*     */     } else {
/* 193 */       double d = losses / (AD.men(null).get(a) + 1);
/* 194 */       double s = ADStats.this.scoreA.getD(a);
/* 195 */       s -= d;
/* 196 */       s = CLAMP.d(s, 0.0D, 1.0D);
/* 197 */       ADStats.this.scoreA.setD(a, s);
/* 198 */       ADStats.this.defeats.a.inc(a, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void battle(Faction a, boolean victory, int losses, int kills, Faction againsts) {
/* 204 */     ADStats.this.report(a, victory, losses, kills);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADStats$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */