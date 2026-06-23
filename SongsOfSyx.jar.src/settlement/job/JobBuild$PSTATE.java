/*    */ package settlement.job;
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
/*    */ enum PSTATE
/*    */ {
/* 40 */   CLEAR_TERRAIN(JobBuild.¤¤clearTerrain),
/* 41 */   CLEAR_VEG(JobBuild.¤¤clearVegetation),
/* 42 */   REMOVING(JobBuild.¤¤removing),
/* 43 */   FETCHING(JobBuild.¤¤getting),
/* 44 */   CONSTRUCTING(JobBuild.¤¤constructing);
/*    */   
/*    */   final CharSequence name;
/*    */   
/*    */   PSTATE(CharSequence name) {
/* 49 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuild$PSTATE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */