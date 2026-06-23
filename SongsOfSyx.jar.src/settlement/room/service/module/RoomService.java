/*     */ package settlement.room.service.module;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ public abstract class RoomService
/*     */ {
/*  27 */   private int available = 0;
/*  28 */   private int total = 0;
/*     */   
/*     */   private double load;
/*     */   
/*     */   private double loadLast;
/*     */   private int day;
/*     */   public final int radius;
/*     */   final RoomBlueprintImp room;
/*     */   public final SFinderRoomService finder;
/*     */   public final NEED need;
/*     */   public SoundRace usageSound;
/*  39 */   public double usage = 1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSequence verb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomService(RoomBlueprintImp b, RoomInitData data, NEED need) {
/*  65 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  69 */           file.i(RoomService.this.available);
/*  70 */           file.i(RoomService.this.total);
/*  71 */           file.d(RoomService.this.load);
/*  72 */           file.d(RoomService.this.loadLast);
/*     */         }
/*     */         
/*     */         public FSERVICE get(int tx, int ty) {
/*     */           return RoomService.this.service(tx, ty);
/*     */         }
/*  78 */         public void load(FileGetter file) throws IOException { RoomService.this.available = file.i();
/*  79 */           RoomService.this.total = file.i();
/*  80 */           RoomService.this.load = file.d();
/*  81 */           RoomService.this.loadLast = file.d(); } }; this.verb = data.text().json("SERVICE").text("VERB"); this.need = need;
/*     */     Json jd = data.data().json("SERVICE");
/*     */     this.usageSound = AUDIO.race("ROOM_SERVICE_" + b.key);
/*     */     this.room = b;
/*     */     this.radius = jd.has("RADIUS") ? jd.i("RADIUS", 0, 50000) : 150;
/*  86 */     this.finder = new SFinderRoomService(b.info.name) { public void clear() { RoomService.this.available = 0;
/*  87 */           RoomService.this.total = 0;
/*  88 */           RoomService.this.load = 0.0D;
/*  89 */           RoomService.this.loadLast = 0.0D; }
/*     */          }
/*     */       ;
/*     */     this.day = -1;
/*     */   } public double load() {
/*  94 */     if (this.total == 0)
/*  95 */       return 1.0D; 
/*  96 */     if (this.day != TIME.days().bitsSinceStart()) {
/*  97 */       this.loadLast = this.load;
/*  98 */       this.load = 0.0D;
/*  99 */       this.day = TIME.days().bitsSinceStart();
/*     */     } 
/* 101 */     return this.loadLast;
/*     */   }
/*     */   
/*     */   public void loadFix(RoomBlueprintIns<?> blue) {
/* 105 */     this.total = 0;
/* 106 */     this.available = 0;
/*     */     
/* 108 */     for (int i = 0; i < blue.instancesSize(); i++) {
/*     */       
/* 110 */       RoomInstance ins = blue.getInstance(i);
/* 111 */       ROOM_SERVICER ss = (ROOM_SERVICER)ins;
/*     */       
/* 113 */       this.available += ss.service().available();
/* 114 */       this.total += ss.service().total();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 122 */     return this.available;
/*     */   }
/*     */   
/*     */   public int total() {
/* 126 */     return this.total;
/*     */   }
/*     */ 
/*     */   
/*     */   void increServices(int total, int available) {
/* 131 */     if (this.total == 0) {
/* 132 */       this.load = 1.0D;
/* 133 */       this.loadLast = 1.0D;
/*     */     } else {
/* 135 */       double d = 1.0D - this.available / this.total;
/* 136 */       if (d > this.load)
/* 137 */         this.load = d; 
/* 138 */       if (d > this.loadLast) {
/* 139 */         this.loadLast = d;
/*     */       }
/*     */     } 
/*     */     
/* 143 */     this.available += available;
/* 144 */     this.total += total;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp room() {
/* 149 */     return this.room;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double totalMultiplier() {
/* 155 */     if (this.need != null) {
/*     */       
/* 157 */       double ne = this.usage / STATS.SERVICE().needTot(this.need);
/*     */       
/* 159 */       if (this.need instanceof init.type.NEED_E) {
/* 160 */         return 1.0D / ne * this.need.rate.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null));
/*     */       }
/* 162 */       double tot = 0.0D;
/* 163 */       for (int ni = 0; ni < NEEDS.ALLSIMPLE().size(); ni++) {
/* 164 */         NEED o = (NEED)NEEDS.ALLSIMPLE().get(ni);
/* 165 */         tot += o.rate.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null));
/*     */       } 
/* 167 */       if (STATS.SERVICE().needTot(this.need) == 0.0D)
/* 168 */         ne = this.usage; 
/* 169 */       return 1.0D / ne * TIME.servicePerDay() * 0.5D * this.need.rate.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null)) / tot;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 174 */     return 1.0D;
/*     */   }
/*     */   public abstract FSERVICE service(int paramInt1, int paramInt2);
/*     */   
/*     */   public static interface ROOM_SERVICE_HASER extends RoomFinderHaser { RoomService service();
/*     */     
/*     */     default SFinderFindable finder() {
/* 181 */       return (SFinderFindable)(service()).finder;
/*     */     }
/*     */ 
/*     */     
/*     */     default int radius() {
/* 186 */       return (service()).radius;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderFindable finder() {
/* 193 */     return (SFinderFindable)this.finder;
/*     */   }
/*     */   
/*     */   public int radius() {
/* 197 */     return this.radius;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\RoomService.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */