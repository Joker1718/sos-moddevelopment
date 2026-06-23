/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ 
/*     */ public class TempleInstance
/*     */   extends RoomInstance
/*     */   implements ROOM_SERVICER
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final RoomServiceInstance service;
/*     */   final ArrayCooShort jobs;
/*  20 */   int consumed = 0;
/*  21 */   byte year = (byte)TIME.years().bitsSinceStart();
/*     */   short sacrificesTotal;
/*     */   short sacrifices;
/*  24 */   short sacrificesRequired = 0;
/*     */   boolean resHas = true;
/*     */   final int altars;
/*     */   
/*     */   protected TempleInstance(ROOM_TEMPLE blueprint, TmpArea area, RoomInit init) {
/*  29 */     super(blueprint, area, init);
/*     */     
/*  31 */     int s = 0;
/*  32 */     int j = 0;
/*  33 */     int a = 0;
/*  34 */     for (COORDINATE c : body()) {
/*  35 */       if (!is(c))
/*     */         continue; 
/*  37 */       if (blueprint.serviceTile.get(c.x(), c.y()) != null)
/*  38 */         s++; 
/*  39 */       if (blueprint.job.get(c.x(), c.y()) != null)
/*  40 */         j++; 
/*  41 */       if (blueprint.altar.get(c.x(), c.y()) != null) {
/*  42 */         a++;
/*     */       }
/*     */     } 
/*     */     
/*  46 */     this.altars = a;
/*  47 */     this.jobs = new ArrayCooShort(j);
/*  48 */     for (COORDINATE c : body()) {
/*  49 */       if (!is(c))
/*     */         continue; 
/*  51 */       if (blueprint.job.get(c.x(), c.y()) != null) {
/*  52 */         this.jobs.get().set(c);
/*  53 */         this.jobs.inc();
/*     */       } 
/*     */     } 
/*     */     
/*  57 */     this.service = new RoomServiceInstance(s, blueprint.service);
/*     */     
/*  59 */     for (COORDINATE c : body()) {
/*  60 */       if (!is(c))
/*     */         continue; 
/*  62 */       blueprint.serviceTile.init(c.x(), c.y());
/*     */     } 
/*     */ 
/*     */     
/*  66 */     employees().maxSet(this.jobs.size());
/*  67 */     employees().neededSet(this.jobs.size());
/*     */     
/*  69 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_TEMPLE blueprintI() {
/*  75 */     return (ROOM_TEMPLE)blueprint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  92 */     this.resHas = true;
/*  93 */     if (day) {
/*  94 */       if ((byte)TIME.years().bitsSinceStart() != this.year) {
/*  95 */         this.consumed = 0;
/*  96 */         this.year = (byte)TIME.years().bitsSinceStart();
/*     */       } 
/*  98 */       this.service.updateDay();
/*     */ 
/*     */       
/* 101 */       this.sacrifices = (short)(int)Math.ceil(this.sacrifices / 2.0D);
/* 102 */       this.sacrificesTotal = (short)(int)Math.ceil(this.sacrificesTotal / 2.0D);
/*     */     } 
/*     */   }
/*     */   
/*     */   public double sacrificeValue() {
/* 107 */     if (this.sacrificesTotal == 0)
/* 108 */       return 0.0D; 
/* 109 */     return this.sacrifices / this.sacrificesTotal;
/*     */   }
/*     */   
/*     */   public double respect() {
/* 113 */     double d = 0.25D;
/* 114 */     d += 0.25D * (blueprintI()).constructor.grandure.get(this);
/* 115 */     d += 0.25D * (blueprintI()).constructor.space.get(this);
/* 116 */     d += 0.25D * (blueprintI()).constructor.decor.get(this);
/* 117 */     d *= employees().employed() / employees().target();
/* 118 */     d *= sacrificeValue();
/* 119 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   public int sacrifices() {
/* 124 */     return (int)(this.jobs.size() * (blueprintI()).STIME * 0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/* 129 */     (blueprintI()).altar.updateday(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 134 */     for (COORDINATE c : body()) {
/* 135 */       if (!is(c))
/*     */         continue; 
/* 137 */       (blueprintI()).serviceTile.dispose(c.x(), c.y());
/* 138 */       (blueprintI()).altar.dispose(c.x(), c.y());
/*     */     } 
/*     */     
/* 141 */     this.service.dispose((blueprintI()).service);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 146 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 151 */     double base = (upgrade() + 1.0D) / (blueprintI().upgrades().max() + 1.0D);
/* 152 */     return ROOM_SERVICER.defQuality(this, base * respect());
/*     */   }
/*     */   
/*     */   public TempleJob jobReservable(int tx, int ty) {
/* 156 */     if (is(tx, ty) && (blueprintI()).job.get(tx, ty) != null && !(blueprintI()).job.jobReservedIs())
/* 157 */       return (blueprintI()).job; 
/* 158 */     for (int i = 0; i < this.jobs.size(); i++) {
/* 159 */       TempleJob j = (blueprintI()).job.get(this.jobs.get().x(), this.jobs.get().y());
/* 160 */       this.jobs.inc();
/* 161 */       if (!j.jobReservedIs())
/* 162 */         return j; 
/*     */     } 
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   public TempleJob job(int tx, int ty) {
/* 168 */     if (is(tx, ty) && (blueprintI()).job.get(tx, ty) != null)
/* 169 */       return (blueprintI()).job; 
/* 170 */     return null;
/*     */   }
/*     */   
/*     */   public void reportMissing() {
/* 174 */     this.resHas = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */