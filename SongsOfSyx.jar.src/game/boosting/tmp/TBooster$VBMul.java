/*     */ package game.boosting.tmp;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
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
/*     */ class VBMul
/*     */   implements BValue
/*     */ {
/*     */   private final Boostable target;
/*     */   
/*     */   VBMul(Boostable target) {
/* 116 */     this.target = target;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 121 */     return (GAME.BOOST()).factions.mul(f, this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 126 */     return (GAME.BOOST()).factions.mul(f, this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE t) {
/* 131 */     if (t.cl == null || t.cl.player) {
/* 132 */       return (GAME.BOOST()).popcl.mul(t, this.target) * (GAME.BOOST()).factions.mul(FACTIONS.player(), this.target);
/*     */     }
/* 134 */     return (GAME.BOOST()).popcl.mul(t, this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 139 */     Faction f = div.faction();
/* 140 */     if (f == FACTIONS.player())
/* 141 */       return (GAME.BOOST()).popcl.mul(HCLASS_RACE.clP(div.info.race()), this.target); 
/* 142 */     if (f != null)
/* 143 */       return (GAME.BOOST()).factions.mul(f, this.target); 
/* 144 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 149 */     return (GAME.BOOST()).popcl.mul(indu.popCL(), this.target) * (GAME.BOOST()).factions.mul(FACTIONS.player(), this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 154 */     if (reg.faction() != null)
/* 155 */       return (GAME.BOOST()).regions.mul(reg, this.target) * (GAME.BOOST()).factions.mul(reg.faction(), this.target); 
/* 156 */     return (GAME.BOOST()).regions.mul(reg, this.target);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TBooster$VBMul.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */