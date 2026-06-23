/*    */ package settlement.job;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.floor.Floors;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ public final class JobBuildRoads
/*    */ {
/*    */   public final LIST<JobBuildRoad> all;
/*    */   private final JobComboPlacer pla;
/*    */   private boolean convert = false;
/*    */   
/*    */   JobBuildRoads() {
/* 62 */     ArrayList<JobBuildRoad> all = new ArrayList((SETT.FLOOR()).roads.size());
/* 63 */     for (Floors.Floor f : (SETT.FLOOR()).roads) {
/* 64 */       all.add(new JobBuildRoad(f));
/*    */     }
/* 66 */     this.all = (LIST<JobBuildRoad>)all;
/* 67 */     this.pla = new JobComboPlacer((LIST)this.all, "ROAD_TYPE");
/*    */   }
/*    */   
/*    */   public Job getPlacable() {
/* 71 */     return this.pla.current();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildRoad$JobBuildRoads.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */