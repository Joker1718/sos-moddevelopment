/*     */ package settlement.room.water;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class PumpInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER {
/*     */   private JobIterator jobs;
/*     */   private static final long serialVersionUID = -3170637142258642320L;
/*     */   private int workersHas;
/*     */   private int workersNeed;
/*     */   public short value;
/*     */   private int dw;
/*  26 */   private static int maxWorkAm = 8;
/*  27 */   public double valueMax = 100.0D;
/*     */   private final short ox;
/*     */   private final short oy;
/*     */   
/*     */   PumpInstance(ROOM_PUMP b, TmpArea area, RoomInit init) {
/*  32 */     super(b, area, init);
/*     */     
/*  34 */     this.jobs = new Jobs(this);
/*  35 */     int px = 0;
/*  36 */     int py = 0;
/*  37 */     for (COORDINATE c : body()) {
/*  38 */       if (is(c) && (SETT.ROOMS()).fData.tile.get(c) == (blueprintI()).constructor.ou) {
/*  39 */         px = c.x();
/*  40 */         py = c.y();
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/*  47 */     this.ox = (short)px;
/*  48 */     this.oy = (short)py;
/*     */     
/*  50 */     setEmployees();
/*  51 */     employees().neededSet(employees().max());
/*     */     
/*  53 */     this.valueMax = (int)Math.ceil((25 * employees().max()));
/*     */     
/*  55 */     this.dw = maxWorkAm - 2;
/*  56 */     this.value = 64;
/*  57 */     this.workersHas = 1;
/*  58 */     this.workersNeed = 1;
/*  59 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  64 */     it.lit();
/*  65 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  70 */     (SETT.ROOMS()).WATER.updater.reportChange(this.ox, this.oy, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  75 */     (SETT.ROOMS()).WATER.updater.reportChange(this.ox, this.oy, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  81 */     if (!active())
/*     */       return; 
/*  83 */     this.workersHas += employees().employed();
/*  84 */     this.workersNeed += employees().max();
/*  85 */     this.dw++;
/*  86 */     if (this.dw >= maxWorkAm) {
/*  87 */       short nv = (short)(int)Math.ceil((1.0D - 0.8D * getDegrade()) * this.valueMax * this.workersHas / this.workersNeed);
/*  88 */       this.workersHas = 0;
/*  89 */       this.workersNeed = 0;
/*  90 */       this.dw = 0;
/*  91 */       if (nv != this.value) {
/*  92 */         this.value = nv;
/*     */         
/*  94 */         (SETT.ROOMS()).WATER.updater.reportChange(this.ox, this.oy, 0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 106 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_PUMP blueprintI() {
/* 112 */     return (ROOM_PUMP)blueprint();
/*     */   }
/*     */   
/*     */   private void setEmployees() {
/* 116 */     int am = 0;
/* 117 */     for (COORDINATE c : body()) {
/* 118 */       if (is(c) && (blueprintI()).job.init(c.x(), c.y(), this) != null) {
/* 119 */         am++;
/*     */       }
/*     */     } 
/* 122 */     employees().maxSet(am);
/* 123 */     if (am > employees().max())
/* 124 */       employees().neededSet(employees().max()); 
/* 125 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Jobs
/*     */     extends JobIterator
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     public Jobs(PumpInstance ins) {
/* 138 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB init(int tx, int ty) {
/* 143 */       PumpInstance ins = (PumpInstance)(SETT.ROOMS()).WATER.pump.get(tx, ty);
/* 144 */       if (ins != null)
/* 145 */         return (SETT.ROOMS()).WATER.pump.job.init(tx, ty, ins); 
/* 146 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public int ox() {
/* 151 */     return this.ox;
/*     */   }
/*     */   
/*     */   public int oy() {
/* 155 */     return this.oy;
/*     */   }
/*     */   
/*     */   public int output() {
/* 159 */     if (!active())
/* 160 */       return 0; 
/* 161 */     return this.value;
/*     */   }
/*     */   
/*     */   public double aniSpeed() {
/* 165 */     return employees().employed() / employees().max();
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int upgrade) {
/* 170 */     super.upgradeSet(upgrade);
/* 171 */     setEmployees();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\PumpInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */