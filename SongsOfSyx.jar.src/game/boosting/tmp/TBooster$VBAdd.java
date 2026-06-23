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
/*     */ class VBAdd
/*     */   implements BValue
/*     */ {
/*     */   private final Boostable target;
/*     */   
/*     */   VBAdd(Boostable target) {
/*  66 */     this.target = target;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/*  71 */     return (GAME.BOOST()).factions.add(f, this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/*  76 */     return (GAME.BOOST()).factions.add(f, this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE t) {
/*  81 */     if (t.cl == null || t.cl.player) {
/*  82 */       return (GAME.BOOST()).popcl.add(t, this.target) + (GAME.BOOST()).factions.add(FACTIONS.player(), this.target);
/*     */     }
/*  84 */     return (GAME.BOOST()).popcl.add(t, this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/*  89 */     Faction f = div.faction();
/*  90 */     if (f == FACTIONS.player())
/*  91 */       return (GAME.BOOST()).popcl.add(HCLASS_RACE.clP(div.info.race()), this.target); 
/*  92 */     if (f != null)
/*  93 */       return (GAME.BOOST()).factions.add(f, this.target); 
/*  94 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/*  99 */     return (GAME.BOOST()).popcl.add(indu.popCL(), this.target) + (GAME.BOOST()).factions.add(FACTIONS.player(), this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 104 */     if (reg.faction() != null)
/* 105 */       return (GAME.BOOST()).regions.add(reg, this.target) + (GAME.BOOST()).factions.add(reg.faction(), this.target); 
/* 106 */     return (GAME.BOOST()).regions.add(reg, this.target);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TBooster$VBAdd.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */