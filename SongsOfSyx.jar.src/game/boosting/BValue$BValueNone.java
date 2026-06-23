/*    */ package game.boosting;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.player.Player;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BValueNone
/*    */   implements BValue
/*    */ {
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
/*    */   public double vGet(Faction f) {
/* 60 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(HCLASS_RACE reg) {
/* 65 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Player f) {
/* 70 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(FactionNPC f) {
/* 75 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BValue$BValueNone.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */