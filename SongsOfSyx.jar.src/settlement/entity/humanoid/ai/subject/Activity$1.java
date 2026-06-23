/*    */ package settlement.entity.humanoid.ai.subject;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends Activity.R
/*    */ {
/*    */   null(Activity paramActivity2) {}
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 49 */     COORDINATE c = Activity.this.s.finder().reserve(a.tc(), 400);
/* 50 */     if (c == null)
/* 51 */       return null; 
/* 52 */     d.planTile.set(c);
/* 53 */     c = Activity.this.s.getDestination(c);
/* 54 */     AISUB.AISubActivation sub = (AI.SUBS()).walkTo.cooFull(a, d, c);
/* 55 */     if (sub == null) {
/* 56 */       can(a, d);
/* 57 */       return null;
/*    */     } 
/* 59 */     return sub;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 64 */     d.planByte1 = (byte)(8 + RND.rInt(8));
/* 65 */     return Activity.this.move.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\Activity$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */