/*     */ package game.raiding;
/*     */ 
/*     */ import game.faction.Faction;
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
/*     */ class null
/*     */   extends BattleListener
/*     */ {
/*     */   public void siege(Faction attacker, Region reg) {
/*  93 */     RaidingMap.this.AUp = -100.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void siege(WArmy attacker, Region reg) {
/*  99 */     RaidingMap.this.AUp = -100.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void battle(WArmy a, boolean victory, int losses, int kills, Faction against) {
/* 105 */     RaidingMap.this.AUp = -100.0D;
/*     */   }
/*     */   
/*     */   public void battle(Faction a, boolean victory, int losses, int kills, Faction against) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaidingMap$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */