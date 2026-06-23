/*    */ package settlement.room.knowledge.university;
/*    */ 
/*    */ import settlement.misc.job.JOBMANAGER_HASER;
/*    */ import settlement.misc.job.JOB_MANAGER;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.job.JobPositions;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ final class UniversityInstance extends RoomInstance implements JOBMANAGER_HASER {
/*    */   private static final long serialVersionUID = 1L;
/*    */   final Jobs jobs;
/*    */   
/*    */   protected UniversityInstance(ROOM_UNIVERSITY blueprint, TmpArea area, RoomInit init) {
/* 21 */     super(blueprint, area, init);
/* 22 */     this.jobs = new Jobs(this);
/*    */     
/* 24 */     employees().neededSet(this.jobs.size());
/* 25 */     employees().maxSet(this.jobs.size());
/* 26 */     this.jobs.randomize();
/* 27 */     activate();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 33 */     i.lit();
/* 34 */     return super.render(r, shadowBatch, i);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void updateAction(double updateInterval, boolean day) {
/* 39 */     this.jobs.searchAgain();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void activateAction() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void deactivateAction() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public JOB_MANAGER getWork() {
/* 54 */     return (JOB_MANAGER)this.jobs;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void dispose() {
/* 59 */     for (COORDINATE c : body()) {
/* 60 */       is(c);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ROOM_UNIVERSITY blueprintI() {
/* 68 */     return (ROOM_UNIVERSITY)blueprint();
/*    */   }
/*    */ 
/*    */   
/*    */   static class Jobs
/*    */     extends JobPositions<UniversityInstance>
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */     
/*    */     public Jobs(UniversityInstance ins) {
/* 79 */       super(ins);
/*    */     }
/*    */ 
/*    */     
/*    */     protected SETT_JOB get(int tx, int ty) {
/* 84 */       return (((UniversityInstance)this.ins).blueprintI()).job.get(tx, ty);
/*    */     }
/*    */ 
/*    */     
/*    */     protected boolean isAndInit(int tx, int ty) {
/* 89 */       return ((((UniversityInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledg\\university\UniversityInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */