/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import settlement.job.Job;
/*    */ import settlement.main.SETT;
/*    */ 
/*    */ 
/*    */ final class Jobs
/*    */ {
/*    */   static Job get(int tx, int ty) {
/* 10 */     Job j = (Job)(SETT.JOBS()).jobGetter.get(tx, ty);
/* 11 */     if (j != null && j.isConstruction())
/* 12 */       return j; 
/* 13 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */