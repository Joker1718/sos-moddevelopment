/*    */ package world.region;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.boosting.BoosterImp;
/*    */ import game.faction.Faction;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public abstract class RBooster
/*    */   extends BoosterImp
/*    */ {
/*    */   public RBooster(BSourceInfo info, double from, double to, boolean isMul) {
/* 12 */     super(info, from, to, isMul);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Faction f) {
/* 17 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract double get(Region paramRegion);
/*    */ 
/*    */   
/*    */   public double vGet(Region reg) {
/* 25 */     return get(reg);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RBooster.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */