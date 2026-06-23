/*     */ package game.boosting;
/*     */ 
/*     */ import game.battle.div.Div;
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
/*     */ public class BValueSome
/*     */   implements BValue
/*     */ {
/*     */   private final double v;
/*     */   
/*     */   public BValueSome(double v) {
/*  84 */     this.v = v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/*  89 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/*  94 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/*  99 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Faction f) {
/* 104 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE reg) {
/* 109 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 114 */     return this.v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 119 */     return this.v;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BValue$BValueSome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */