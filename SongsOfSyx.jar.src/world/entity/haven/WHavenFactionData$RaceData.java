/*    */ package world.entity.haven;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class RaceData
/*    */ {
/*    */   int camps;
/*    */   int pop;
/*    */   double replenish;
/*    */   
/*    */   public void clear() {
/* 46 */     this.camps = 0;
/* 47 */     this.pop = 0;
/* 48 */     this.replenish = 0.0D;
/*    */   }
/*    */   public void add(WHaven ii) {
/* 51 */     this.camps++;
/* 52 */     this.pop += ii.pop();
/* 53 */     this.replenish += ii.replenish();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\WHavenFactionData$RaceData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */