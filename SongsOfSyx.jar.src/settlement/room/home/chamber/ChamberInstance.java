/*     */ package settlement.room.home.chamber;
/*     */ 
/*     */ import init.type.HCLASSES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class ChamberInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, HOME {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final JobIterator jobs;
/*     */   final COORDINATE serviceCoo;
/*     */   final byte sleepDir;
/*     */   private int occupant;
/*     */   boolean fetching;
/*     */   private boolean workingWarn;
/*     */   private boolean working;
/*     */   
/*     */   protected ChamberInstance(ROOM_CHAMBER b, TmpArea area, RoomInit init) {
/*  37 */     super(b, area, init); Coo coo; this.occupant = 0; this.workingWarn = false;
/*  38 */     this.jobs = new JobIterator(this)
/*     */       {
/*     */         private static final long serialVersionUID = 1L;
/*     */ 
/*     */         
/*     */         protected SETT_JOB init(int tx, int ty) {
/*  44 */           return (ChamberInstance.this.blueprintI()).work.get(tx, ty);
/*     */         }
/*     */       };
/*     */     
/*  48 */     this.jobs.setAlwaysNewJob();
/*     */     
/*  50 */     COORDINATE s = null;
/*     */     
/*  52 */     for (COORDINATE c : body()) {
/*  53 */       if (is(c) && (SETT.ROOMS()).fData.tile.get(c) == (blueprintI()).constructor.bb) {
/*  54 */         coo = new Coo(c);
/*     */       }
/*     */     } 
/*     */     
/*  58 */     if (coo == null) {
/*  59 */       throw new RuntimeException();
/*     */     }
/*  61 */     this.serviceCoo = (COORDINATE)coo;
/*     */     
/*  63 */     this.sleepDir = (byte)DIR.S.next(2 * ((FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)coo)).rotation).id();
/*     */     
/*  65 */     employees().maxSet(4);
/*  66 */     employees().neededSet(4);
/*  67 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  73 */     if (this.occupant != 0)
/*  74 */       it.lit(); 
/*  75 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  90 */     boolean warn = this.workingWarn;
/*  91 */     this.workingWarn = (employees().employed() < 4);
/*     */     
/*  93 */     if (this.working && warn && this.workingWarn) {
/*     */       
/*  95 */       if (occupant() != null) {
/*  96 */         (STATS.HOME()).GETTER.set(occupant(), null);
/*     */       }
/*  98 */       remove();
/*  99 */       this.working = false;
/* 100 */       add();
/* 101 */     } else if (!this.working) {
/* 102 */       remove();
/* 103 */       this.working = true;
/* 104 */       add();
/*     */     } 
/*     */     
/* 107 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 112 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 117 */     remove();
/* 118 */     if (occupant() != null) {
/* 119 */       STATS.HOME().dump(occupant());
/* 120 */       (STATS.HOME()).GETTER.set(occupant(), null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_CHAMBER blueprintI() {
/* 126 */     return (ROOM_CHAMBER)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public HOME vacate(Humanoid h) {
/* 131 */     remove();
/* 132 */     this.occupant = 0;
/* 133 */     add();
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HOME occupy(Humanoid h) {
/* 139 */     remove();
/* 140 */     this.occupant = h.id();
/* 141 */     add();
/* 142 */     return this;
/*     */   }
/*     */   
/*     */   public Humanoid occupant() {
/* 146 */     if (this.occupant != 0)
/* 147 */       return (Humanoid)SETT.ENTITIES().getByID(this.occupant); 
/* 148 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid occupant(int oi) {
/* 153 */     if (oi == 0)
/* 154 */       return occupant(); 
/* 155 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int occupants() {
/* 160 */     return (occupant() != null) ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serviceX() {
/* 166 */     return this.serviceCoo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int serviceY() {
/* 171 */     return this.serviceCoo.y();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 183 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDegrade() {
/* 188 */     if (this.working)
/* 189 */       return 0.0D; 
/* 190 */     return 0.5D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void remove() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void add() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int occupantsMax() {
/* 207 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resourceAm(int ri) {
/* 212 */     if (occupant() == null)
/* 213 */       return 0; 
/* 214 */     return STATS.HOME().current(occupant(), ri);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double isolation() {
/* 220 */     return isolation(mX(), mY());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canOccupy(Humanoid h) {
/* 225 */     return (h.indu().clas() == HCLASSES.NOBLE() && occupant() == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence typeName(int tx, int ty) {
/* 230 */     return (blueprintI()).info.name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\chamber\ChamberInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */