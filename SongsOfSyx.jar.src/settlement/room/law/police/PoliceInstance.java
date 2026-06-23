/*     */ package settlement.room.law.police;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class PoliceInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*  21 */   int prisoners = 0;
/*     */   
/*     */   protected PoliceInstance(ROOM_POLICE b, TmpArea area, RoomInit init) {
/*  24 */     super(b, area, init);
/*     */     
/*  26 */     int spots = 0;
/*     */     
/*  28 */     for (COORDINATE c : body()) {
/*  29 */       if (!is(c))
/*     */         continue; 
/*  31 */       if (((SETT.ROOMS()).fData.tileData.get(c) & 0x3) == 3) {
/*  32 */         spots++;
/*     */       }
/*     */     } 
/*     */     
/*  36 */     this.jobs = new Jobs(this);
/*     */     
/*  38 */     employees().maxSet(spots * 3);
/*  39 */     employees().neededSet(spots);
/*  40 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   public int prisonersMax() {
/*  45 */     return (int)Math.ceil(employees().employed() / 3.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  50 */     it.lit();
/*  51 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  61 */     for (COORDINATE c : body()) {
/*  62 */       if (is(c) && (blueprintI()).work.job(c.x(), c.y()) != null) {
/*  63 */         (blueprintI()).work.dispose(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/*  70 */     (blueprintI()).work.update(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_POLICE blueprintI() {
/*  75 */     return (ROOM_POLICE)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<PoliceInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(PoliceInstance ins) {
/*  86 */       super(ins);
/*  87 */       setAlwaysNew();
/*  88 */       randomize();
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/*  93 */       return (((PoliceInstance)this.ins).blueprintI()).work.job(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/*  98 */       return ((((PoliceInstance)this.ins).blueprintI()).work.job(tx, ty) != null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 112 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\PoliceInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */