/*    */ package init.race.bio;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.MATH;
/*    */ import util.data.GETTER_TRANS;
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
/*    */   implements GETTER_TRANS<Humanoid, Humanoid>
/*    */ {
/*    */   public Humanoid get(Humanoid a) {
/* 30 */     ENTITY b = (ENTITY)(STATS.POP()).FRIEND.get(a.indu());
/* 31 */     if (b instanceof Humanoid) {
/* 32 */       return (Humanoid)b;
/*    */     }
/* 34 */     int ri = STATS.RAN().get(a.indu(), 1);
/* 35 */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*    */     
/* 37 */     if (es.length == 0) {
/* 38 */       return a;
/*    */     }
/* 40 */     for (int i = 0; i < es.length; i++) {
/* 41 */       ENTITY e = es[MATH.mod(i + ri, es.length)];
/* 42 */       if (e != a && e instanceof Humanoid) {
/* 43 */         return (Humanoid)e;
/*    */       }
/*    */     } 
/*    */     
/* 47 */     return a;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\BioLine$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */