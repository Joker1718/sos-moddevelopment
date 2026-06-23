/*    */ package settlement.entity.humanoid.ai.crime;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FResources;
/*    */ import init.resources.RBIT;
/*    */ import init.type.CRIMES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 39 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 43 */     return (AI.SUBS()).walkTo.resource(a, d, RBIT.ALL, 100);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 48 */     Theft.this.m.commitCrime(a, d, false, (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu()));
/* 49 */     GAME.player().res().inc(d.resourceCarried(), FResources.RTYPE.THEFT, -1);
/* 50 */     int x = d.path.destX();
/* 51 */     int y = d.path.destY();
/* 52 */     int e = (SETT.PATH()).finders.resource.normal.reserveExtra(d.resourceCarried(), x, y, 4 + RND.rInt(10));
/* 53 */     (SETT.PATH()).finders.resource.pickup(d.resourceCarried(), x, y, e);
/* 54 */     GAME.player().res().inc(d.resourceCarried(), FResources.RTYPE.THEFT, -e);
/* 55 */     d.resourceCarriedSet(null);
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Theft$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */