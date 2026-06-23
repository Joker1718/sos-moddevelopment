/*    */ package settlement.room.military.training.archery;
/*    */ 
/*    */ import settlement.misc.job.JOBMANAGER_HASER;
/*    */ import settlement.misc.job.JOB_MANAGER;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.job.JobIterator;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ final class ArcheryInstance extends RoomInstance implements JOBMANAGER_HASER {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final JobIterator jobs;
/*    */   
/*    */   ArcheryInstance(ROOM_ARCHERY b, TmpArea area, RoomInit init) {
/* 21 */     super((RoomBlueprintIns)b, area, init);
/* 22 */     int am = 0;
/* 23 */     for (COORDINATE c : body()) {
/* 24 */       if (is(c)) {
/* 25 */         ArcheryThing t = b.thing.init(c.x(), c.y());
/*    */         
/* 27 */         if (t != null) {
/* 28 */           am++;
/*    */         }
/*    */       } 
/*    */     } 
/* 32 */     this.jobs = new Jobs(this);
/* 33 */     employees().maxSet(am);
/* 34 */     employees().neededSet(am);
/*    */     
/* 36 */     activate();
/*    */   }
/*    */   
/*    */   private static class Jobs extends JobIterator {
/*    */     public Jobs(RoomInstance ins) {
/* 41 */       super(ins);
/*    */     }
/*    */ 
/*    */     
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */     
/*    */     protected SETT_JOB init(int tx, int ty) {
/* 49 */       return ((ROOM_ARCHERY)ins().blueprintI()).thing.init(tx, ty);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public ROOM_ARCHERY blueprintI() {
/* 55 */     return (ROOM_ARCHERY)blueprint();
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
/*    */   protected void updateAction(double updateInterval, boolean day) {
/* 70 */     this.jobs.searchAgain();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void dispose() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 80 */     i.lit();
/* 81 */     return super.render(r, shadowBatch, i);
/*    */   }
/*    */ 
/*    */   
/*    */   public JOB_MANAGER getWork() {
/* 86 */     return (JOB_MANAGER)this.jobs;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\archery\ArcheryInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */