/*    */ package settlement.room.military.training.barracks;
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
/*    */ final class BarracksInstance extends RoomInstance implements JOBMANAGER_HASER {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final JobIterator jobs;
/*    */   
/*    */   BarracksInstance(ROOM_BARRACKS b, TmpArea area, RoomInit init) {
/* 21 */     super((RoomBlueprintIns)b, area, init);
/* 22 */     int am = 0;
/* 23 */     for (COORDINATE c : body()) {
/* 24 */       if (is(c)) {
/* 25 */         BarracksThing t = b.thing.init(c.x(), c.y());
/* 26 */         if (t != null) {
/* 27 */           am++;
/*    */         }
/*    */       } 
/*    */     } 
/* 31 */     employees().maxSet(am);
/* 32 */     employees().neededSet(am);
/*    */     
/* 34 */     this.jobs = new Jobs(this);
/*    */ 
/*    */ 
/*    */     
/* 38 */     activate();
/*    */   }
/*    */   
/*    */   private static class Jobs extends JobIterator {
/*    */     public Jobs(RoomInstance ins) {
/* 43 */       super(ins);
/*    */     }
/*    */ 
/*    */     
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */     
/*    */     protected SETT_JOB init(int tx, int ty) {
/* 51 */       return ((ROOM_BARRACKS)ins().blueprintI()).thing.init(tx, ty);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public ROOM_BARRACKS blueprintI() {
/* 57 */     return (ROOM_BARRACKS)blueprint();
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
/* 72 */     this.jobs.searchAgain();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void dispose() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 82 */     i.lit();
/* 83 */     return super.render(r, shadowBatch, i);
/*    */   }
/*    */ 
/*    */   
/*    */   public JOB_MANAGER getWork() {
/* 88 */     return (JOB_MANAGER)this.jobs;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\barracks\BarracksInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */