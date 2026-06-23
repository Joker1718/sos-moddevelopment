/*    */ package init.type;
/*    */ 
/*    */ import game.boosting.BoostableCat;
/*    */ import init.paths.PATHS;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsNeeds;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ public class NEED_E
/*    */   extends NEED {
/*    */   private final int indexE;
/*    */   
/*    */   NEED_E(String key, PATHS.ResFolder f, LISTE<NEED> all, LISTE<NEED_E> alle, BoostableCat cat) {
/* 14 */     super(key, f, all, cat, null, true);
/* 15 */     this.indexE = alle.add(this);
/*    */   }
/*    */   
/*    */   public StatsNeeds.StatNeedNormal stat() {
/* 19 */     return (StatsNeeds.StatNeedNormal)(STATS.NEEDS()).SNEEDS.get(this.indexE);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\NEED_E.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */