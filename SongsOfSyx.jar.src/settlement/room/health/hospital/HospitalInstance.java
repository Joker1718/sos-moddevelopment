/*     */ package settlement.room.health.hospital;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.value.Lockable;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class HospitalInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE, ROOM_SERVICER
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   private long[] pData;
/*     */   private final RoomServiceInstance service;
/*     */   boolean[] fetch;
/*     */   
/*     */   protected HospitalInstance(ROOM_HOSPITAL blue, TmpArea area, RoomInit init) {
/*  35 */     super(blue, area, init);
/*  36 */     this.jobs = new Jobs(this);
/*     */     
/*  38 */     int j = 0;
/*  39 */     for (COORDINATE c : body()) {
/*  40 */       if (is(c) && Bed.job(c.x(), c.y()) != null) {
/*  41 */         j++;
/*     */       }
/*     */     } 
/*  44 */     this.fetch = new boolean[blue.resLocks.size()];
/*  45 */     this.service = new RoomServiceInstance(j, blue.service());
/*     */ 
/*     */     
/*  48 */     employees().maxSet((int)Math.ceil(blue.constructor.workers.get(this)));
/*  49 */     employees().neededSet((int)Math.ceil(blue.constructor.workers.get(this)));
/*  50 */     this.pData = blue.consumtion.makeData();
/*     */     
/*  52 */     int ii = 0;
/*  53 */     for (Lockable<Faction> l : blue.resLocks) {
/*  54 */       this.fetch[ii++] = l.passes(FACTIONS.player());
/*     */     }
/*  56 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  61 */     this.pData = (blueprintI()).consumtion.makeDataFix(this.pData);
/*  62 */     if (this.fetch == null || this.fetch.length != (blueprintI()).resLocks.size()) {
/*  63 */       this.fetch = new boolean[(blueprintI()).resLocks.size()];
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  68 */     it.lit();
/*  69 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  74 */     if (day) {
/*  75 */       this.service.updateDay();
/*  76 */       this.jobs.searchAgain();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/*  82 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  87 */     for (COORDINATE c : body()) {
/*  88 */       if (is(c) && Bed.service(c.x(), c.y()) != null)
/*  89 */         Bed.service(c.x(), c.y()).findableReserve(); 
/*     */     } 
/*  91 */     this.service.dispose((blueprintI()).service);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_HOSPITAL blueprintI() {
/*  96 */     return (ROOM_HOSPITAL)blueprint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 115 */     return this.pData;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 120 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 125 */     return 0;
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobIterator {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(HospitalInstance ins) {
/* 133 */       super(ins);
/* 134 */       setAlwaysNewJob();
/* 135 */       randomize();
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB init(int tx, int ty) {
/* 140 */       return Bed.job(tx, ty);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 146 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double quality() {
/* 152 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 157 */     return (RoomState)new State(this);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class State
/*     */     extends RoomState.RoomStateInstance
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private boolean[] opium;
/*     */     
/*     */     public State(HospitalInstance ins) {
/* 169 */       super(ins);
/* 170 */       this.opium = ins.fetch;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void applyIns(RoomInstance ins) {
/* 175 */       if (ins instanceof HospitalInstance) {
/* 176 */         ((HospitalInstance)ins).fetch = this.opium;
/*     */       }
/* 178 */       super.applyIns(ins);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\HospitalInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */