/*     */ package settlement.recipe;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Arrays;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RegBoost
/*     */   extends BoosterImp
/*     */ {
/*     */   boolean changeAll;
/* 190 */   int[] lastSecond = Alloc.ii(FACTIONS.MAX());
/* 191 */   double[] cache = new double[FACTIONS.MAX()];
/*     */   private final IndustryRegion ireg;
/*     */   
/*     */   RegBoost(Boostable bo, IndustryRegion reg) {
/* 195 */     super(new BSourceInfo(Recipes.¤¤realm, (SPRITE)(UI.icons()).s.world), 0.0D, 2.0D, true);
/* 196 */     this.ireg = reg;
/* 197 */     add(bo);
/* 198 */     Arrays.fill(this.lastSecond, -2147483648);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 211 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 216 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 221 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE t) {
/* 226 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 231 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 236 */     if (this.changeAll) {
/* 237 */       Arrays.fill(this.lastSecond, -2147483648);
/* 238 */       this.changeAll = false;
/*     */     } 
/*     */ 
/*     */     
/* 242 */     if (TIME.currentSecond() - this.lastSecond[f.index()] > TIME.secondsPerDay()) {
/* 243 */       this.lastSecond[f.index()] = TIME.secondsPerDay();
/* 244 */       double b = 0.0D;
/* 245 */       for (int i = 0; i < f.realm().regions(); i++) {
/* 246 */         Region reg = f.realm().region(i);
/* 247 */         b += RD.PROSPECT().getAi(this.ireg, reg);
/*     */       } 
/* 249 */       b /= f.realm().regions();
/*     */ 
/*     */       
/* 252 */       this.cache[f.index()] = b;
/*     */     } 
/*     */     
/* 255 */     return this.cache[f.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/* 260 */     return input;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\Creator$RegBoost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */