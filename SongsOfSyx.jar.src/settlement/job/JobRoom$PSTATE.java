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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ enum PSTATE
/*    */ {
/* 44 */   CLEAR_TERRAIN(JobRoom.¤¤clearTerrain), CLEAR_VEG(JobRoom.¤¤clearVegetation), REMOVING(JobRoom.¤¤removing), FETCHING(
/* 45 */     JobRoom.¤¤getting), DOING(JobRoom.¤¤constructing);
/*    */   
/*    */   final CharSequence name;
/*    */   
/*    */   PSTATE(CharSequence name) {
/* 50 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobRoom$PSTATE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */