/*    */ package game.boosting;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.player.Player;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public class BoosterImp
/*    */   extends Booster implements BValue {
/*    */   private final double from;
/*    */   private final double to;
/*    */   
/*    */   public BoosterImp(BSourceInfo info, double from, double to, boolean isMul) {
/* 17 */     super(info, isMul);
/* 18 */     this.from = from;
/* 19 */     this.to = to;
/*    */   }
/*    */   
/*    */   public BoosterImp(BSourceInfo info, double to, boolean isMul) {
/* 23 */     super(info, isMul);
/* 24 */     this.to = to;
/*    */     
/* 26 */     if (isMul) {
/* 27 */       this.from = 1.0D;
/*    */     } else {
/* 29 */       this.from = 0.0D;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public double from() {
/* 35 */     return this.from;
/*    */   }
/*    */ 
/*    */   
/*    */   public double to() {
/* 40 */     return this.to;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Region reg) {
/* 45 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Induvidual indu) {
/* 50 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Div div) {
/* 55 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(HCLASS_RACE popTime) {
/* 60 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Player f) {
/* 65 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(FactionNPC f) {
/* 70 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getValue(double input) {
/* 75 */     input = CLAMP.d(input, 0.0D, 1.0D);
/* 76 */     return from() + input * (to() - from());
/*    */   }
/*    */   
/*    */   public double vNOPInput() {
/* 80 */     if (this.isMul) {
/* 81 */       return (1.0D - from()) / (to() - from());
/*    */     }
/* 83 */     return from() / (to() - from());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected double pget(BOOSTABLE_O o) {
/* 89 */     return o.boostableValue(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoosterImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */