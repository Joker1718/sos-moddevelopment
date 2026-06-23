/*    */ package settlement.recipe;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.boosting.Boostable;
/*    */ import game.boosting.BoosterImp;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.player.Player;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ class FBoost extends BoosterImp {
/*    */   static final double AIBonus = 6.0D;
/* 18 */   public double mul = 1.0D;
/*    */   
/*    */   private final Boostable bb;
/*    */ 
/*    */   
/*    */   FBoost(Boostable bo) {
/* 24 */     super(new BSourceInfo(Recipes.¤¤faction, (SPRITE)(UI.icons()).s.world), 0.0D, 6.0D, false);
/* 25 */     this.bb = bo;
/* 26 */     add(bo);
/* 27 */     randomize();
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Region reg) {
/* 32 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Induvidual indu) {
/* 37 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Div div) {
/* 42 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(HCLASS_RACE t) {
/* 47 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Player f) {
/* 52 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(FactionNPC f) {
/* 57 */     return f.bonus.getD(this.bb) * 6.0D * this.mul;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getValue(double input) {
/* 62 */     return input;
/*    */   }
/*    */   
/*    */   public void randomize() {
/* 66 */     this.mul = 0.65D + RND.rFloat(0.35D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\FBoost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */