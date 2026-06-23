/*    */ package settlement.job;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.TFortification;
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
/*    */ public class JobBuildForts
/*    */ {
/*    */   public final LIST<Job> all;
/*    */   final JobComboPlacer pla;
/* 51 */   public final Job build_stairs = new JobBuildFort.Stairs();
/*    */   
/*    */   JobBuildForts() {
/* 54 */     ArrayList<Job> all = new ArrayList((SETT.TERRAIN()).FORTIFICATIONS.all().size());
/* 55 */     for (TFortification s : (SETT.TERRAIN()).FORTIFICATIONS.all()) {
/* 56 */       all.add(new JobBuildFort(s));
/*    */     }
/* 58 */     this.all = (LIST<Job>)all;
/* 59 */     this.pla = new JobComboPlacer(all.join((Object[])new Job[] { this.build_stairs }, ), "FORTIFICATIONS");
/*    */   }
/*    */   
/*    */   public Job getPlacable() {
/* 63 */     return this.pla.current();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildFort$JobBuildForts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */