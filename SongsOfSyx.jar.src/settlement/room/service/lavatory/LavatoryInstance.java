/*     */ package settlement.room.service.lavatory;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class LavatoryInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*     */   private final ArrayCooShort extras;
/*     */   private int extraI;
/*     */   final RoomServiceInstance service;
/*     */   boolean auto = true;
/*     */   
/*     */   protected LavatoryInstance(ROOM_LAVATORY blueprint, TmpArea area, RoomInit init) {
/*  33 */     super(blueprint, area, init);
/*  34 */     this.jobs = new Jobs(this);
/*     */     
/*  36 */     this.service = new RoomServiceInstance(this.jobs.size(), (RoomService)(blueprintI()).data);
/*     */     
/*  38 */     employees().maxSet(this.jobs.size());
/*  39 */     employees().neededSet((int)Math.ceil(blueprint.constructor.workers.get(this)));
/*     */     
/*  41 */     int e = 0;
/*  42 */     for (COORDINATE c : body()) {
/*  43 */       if (!is(c))
/*     */         continue; 
/*  45 */       Lavatory ll = Lavatory.get(c.x(), c.y());
/*  46 */       if (ll != null)
/*  47 */         ll.init(this.service); 
/*  48 */       FurnisherItemTile it = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c);
/*  49 */       if (it != null) {
/*  50 */         int d = it.data();
/*  51 */         if ((d & 0x4000) == 16384)
/*  52 */           e++; 
/*     */       } 
/*     */     } 
/*  55 */     this.extras = new ArrayCooShort(e);
/*  56 */     e = 0;
/*  57 */     for (COORDINATE c : body()) {
/*  58 */       if (!is(c)) {
/*     */         continue;
/*     */       }
/*  61 */       FurnisherItemTile it = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c);
/*  62 */       if (it != null) {
/*  63 */         int d = it.data();
/*  64 */         if ((d & 0x4000) == 16384) {
/*  65 */           this.extras.set(e++).set(c);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  70 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  75 */     i.lit();
/*  76 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  81 */     if (day)
/*  82 */       this.service.updateDay(); 
/*  83 */     this.jobs.searchAgain();
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
/*     */   public JOB_MANAGER getWork() {
/*  98 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 103 */     this.service.dispose((RoomService)(blueprintI()).data);
/* 104 */     for (int i = 0; i < this.jobs.size(); i++) {
/* 105 */       COORDINATE c = this.jobs.get(i);
/* 106 */       Lavatory.get(c.x(), c.y()).dispose();
/*     */     } 
/*     */   }
/*     */   
/*     */   public COORDINATE getExtra() {
/* 111 */     if (this.extraI == this.extras.size())
/* 112 */       return null; 
/* 113 */     return (COORDINATE)this.extras.set(this.extraI++);
/*     */   }
/*     */   
/*     */   public void returnExtra(int tx, int ty) {
/* 117 */     if (!is(tx, ty))
/*     */       return; 
/* 119 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/* 120 */     if ((data & 0x4000) != 16384)
/*     */       return; 
/* 122 */     if (this.extraI == 0) {
/* 123 */       GAME.Notify("WEIRDNESS!");
/*     */     } else {
/* 125 */       this.extraI--;
/* 126 */       this.extras.set(this.extraI).set(tx, ty);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_LAVATORY blueprintI() {
/* 134 */     return (ROOM_LAVATORY)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 139 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 144 */     return ROOM_SERVICER.defQuality(this, 0.5D + 0.5D * (blueprintI()).constructor.basins.get(this));
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<LavatoryInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(LavatoryInstance ins) {
/* 152 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 157 */       Lavatory t = Lavatory.get(tx, ty);
/* 158 */       if (t == null)
/* 159 */         return null; 
/* 160 */       return t.job;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 165 */       FurnisherItemTile it = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 166 */       if (it != null) {
/* 167 */         int d = it.data();
/* 168 */         (SETT.ROOMS()).data.set((ROOMA)this.ins, tx, ty, d);
/* 169 */         if (d == 32768)
/*     */         {
/* 171 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 175 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\lavatory\LavatoryInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */