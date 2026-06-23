/*     */ package settlement.room.service.speaker;
/*     */ 
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class SpeakerInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*  20 */   final byte off = (byte)RND.rInt(64); final RoomServiceInstance service;
/*  21 */   byte workers = 0;
/*  22 */   private short services = 0;
/*     */   
/*     */   protected SpeakerInstance(ROOM_SPEAKER b, TmpArea area, RoomInit init) {
/*  25 */     super(b, area, init);
/*     */     
/*  27 */     this.service = new RoomServiceInstance((int)b.constructor.spectators.get(this), (RoomService)(blueprintI()).data);
/*     */     
/*  29 */     employees().maxSet(1);
/*  30 */     employees().neededSet(1);
/*  31 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  37 */     it.lit();
/*  38 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  44 */     if (this.workers > 0) {
/*  45 */       setServices(this.service.total());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  52 */     setServices(0);
/*  53 */     this.workers = 0;
/*     */   }
/*     */   
/*     */   void incServices(int s) {
/*  57 */     if (this.workers > 0)
/*  58 */       setServices(this.services + s); 
/*     */   }
/*     */   
/*     */   boolean hasService() {
/*  62 */     return (this.workers > 0);
/*     */   }
/*     */   
/*     */   private void setServices(int s) {
/*  66 */     this.service.report((blueprintI()).work.service(body().cX(), body().cY()), (RoomService)(blueprintI()).data, -this.services, false);
/*  67 */     this.services = (short)CLAMP.i(s, 0, this.service.total());
/*  68 */     this.service.report((blueprintI()).work.service(body().cX(), body().cY()), (RoomService)(blueprintI()).data, this.services, true);
/*     */   }
/*     */   
/*     */   int services() {
/*  72 */     return this.services;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  77 */     if (active()) {
/*  78 */       if (employees().employed() == 0) {
/*  79 */         if (this.workers > 0) {
/*  80 */           this.workers = (byte)(this.workers - 1);
/*  81 */           if (this.workers == 0) {
/*  82 */             setServices(0);
/*     */           }
/*     */         }
/*     */       
/*  86 */       } else if (this.workers < 10) {
/*  87 */         this.workers = 10;
/*  88 */         setServices(this.service.total());
/*     */       } 
/*     */     }
/*     */     
/*  92 */     if (day) {
/*  93 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  98 */     return (blueprintI()).work.manager(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 103 */     this.service.dispose((RoomService)(blueprintI()).data);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_SPEAKER blueprintI() {
/* 108 */     return (ROOM_SPEAKER)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 113 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 118 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\speaker\SpeakerInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */