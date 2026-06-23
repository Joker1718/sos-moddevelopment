/*     */ package settlement.room.spirit.grave;
/*     */ 
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.spirit.dump.ROOM_DUMP;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class GraveInstance
/*     */   extends RoomInstance
/*     */ {
/*  18 */   private int available = 0;
/*     */   
/*     */   private final int total;
/*     */   
/*     */   static final double WORKER_PER_GRAVE = 0.1D;
/*     */   
/*     */   final Jobs jobs;
/*     */   
/*     */   final long[] datas;
/*     */   
/*     */   final int[] names;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   protected GraveInstance(RoomBlueprintIns<GraveInstance> blueprint, TmpArea area, RoomInit init) {
/*  32 */     super(blueprint, area, init);
/*     */     
/*  34 */     int i = 0;
/*  35 */     for (COORDINATE c : body()) {
/*     */       
/*  37 */       if (is(c) && data().grave(c.x(), c.y()) != null) {
/*  38 */         data().grave(c.x(), c.y()).init(c.x(), c.y(), i);
/*  39 */         i++;
/*     */       } 
/*     */     } 
/*     */     
/*  43 */     this.datas = new long[i];
/*  44 */     this.names = Alloc.ii(i);
/*  45 */     this.jobs = new Jobs(this);
/*  46 */     int w = (int)Math.ceil(0.1D * this.jobs.size());
/*  47 */     employees().maxSet(w);
/*  48 */     employees().neededSet(w);
/*  49 */     this.available = this.jobs.size();
/*  50 */     this.total = this.jobs.size();
/*  51 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintIns<? extends RoomInstance> blueprintI() {
/*  58 */     return (RoomBlueprintIns<? extends RoomInstance>)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  63 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  68 */     data().activate(this, this.available, this.total);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  73 */     data().deactivate(this, this.available, this.total);
/*  74 */     data().deactivate(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/*  79 */     Grave g = data().grave(tx, ty);
/*  80 */     if (g != null)
/*  81 */       g.updateDay2(); 
/*     */   }
/*     */   
/*     */   private GraveData data() {
/*  85 */     return ((GraveData.GRAVE_DATA_HOLDER)blueprint()).graveData();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  90 */     data().dispose(this, this.available, this.total);
/*     */   }
/*     */   
/*     */   void count(int a) {
/*  94 */     if (active())
/*  95 */       data().deactivate(this, this.available, this.total); 
/*  96 */     this.available += a;
/*  97 */     if (active())
/*  98 */       data().activate(this, this.available, this.total); 
/*     */   }
/*     */   
/*     */   public int total() {
/* 102 */     return this.total;
/*     */   }
/*     */   
/*     */   public int available() {
/* 106 */     return this.available;
/*     */   }
/*     */   
/*     */   private boolean prompt() {
/* 110 */     int time = 0;
/* 111 */     int am = 0;
/* 112 */     for (COORDINATE c : body()) {
/* 113 */       if (is(c)) {
/* 114 */         Grave g = data().grave(c.x(), c.y());
/* 115 */         if (g != null) {
/* 116 */           int t = g.daysTillDecompose(c.x(), c.y());
/* 117 */           if (t > 0) {
/* 118 */             am++;
/* 119 */             if (t > time) {
/* 120 */               time = t;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     if (am > 0) {
/* 128 */       Str.TMP.clear();
/* 129 */       Str.TMP.add(ROOM_DUMP.¤¤RemoveProblem);
/* 130 */       Str.TMP.insert(0, am);
/* 131 */       Str.TMP.insert(1, time);
/* 132 */       (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP, null, null, false);
/* 133 */       return true;
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canRemoveAndRemoveAction(int tx, int ty, boolean scatter, Object obj, boolean force) {
/* 140 */     if (force || !prompt())
/* 141 */       return true; 
/* 142 */     return false;
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<GraveInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(GraveInstance ins) {
/* 150 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 155 */       return (((GraveInstance)this.ins).data().grave(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 160 */       if (((GraveInstance)this.ins).data().grave(tx, ty) != null)
/* 161 */         return ((GraveInstance)this.ins).data().grave(tx, ty).job(tx, ty); 
/* 162 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\GraveInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */