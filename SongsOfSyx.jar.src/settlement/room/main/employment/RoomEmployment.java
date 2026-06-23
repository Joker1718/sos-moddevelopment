/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.type.WGROUP;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ 
/*     */ public final class RoomEmployment
/*     */   extends RoomEmploymentSimple
/*     */   implements INDEXED {
/*  29 */   static ArrayListResize<RoomEmployment> WORK = new ArrayListResize(10, 512);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private final int index = WORK.add(this);
/*  40 */   private final HistoryInt history = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/*  41 */   public final Target target = new Target(this);
/*  42 */   public final Priority priority = new Priority(this);
/*  43 */   public final GRoupInt priorities = new GRoupInt(0, 5)
/*     */     {
/*     */       public void set(WGROUP t, int i)
/*     */       {
/*  47 */         int o = get(t);
/*  48 */         super.set(t, i);
/*  49 */         if (o != get(t))
/*  50 */           (SETT.ROOMS()).employment.employer.updateAll(); 
/*     */       }
/*     */     };
/*     */   
/*     */   public RoomEmployment(RoomBlueprintIns<?> p, RoomInitData init) {
/*  55 */     super("WORK", p, init);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HISTORY_INT history() {
/*  61 */     return (HISTORY_INT)this.history;
/*     */   }
/*     */ 
/*     */   
/*     */   void employ(Humanoid h, int delta) {
/*  66 */     (SETT.ROOMS()).employment.history.inc(-employed());
/*  67 */     super.employ(h, delta);
/*  68 */     (SETT.ROOMS()).employment.changeCurrent(delta, WGROUP.get(h.indu()));
/*  69 */     (SETT.ROOMS()).employment.history.inc(employed());
/*  70 */     this.history.set(employed());
/*     */   }
/*     */ 
/*     */   
/*     */   void register(RoomEmploymentIns ins, int delta) {
/*  75 */     (SETT.ROOMS()).employment.changeNeeded(blueprint(), -this.workersNeeded);
/*  76 */     super.register(ins, delta);
/*  77 */     (SETT.ROOMS()).employment.changeNeeded(blueprint(), this.workersNeeded);
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
/*     */   void save(FilePutter file) {
/*  89 */     super.save(file);
/*  90 */     this.target.save(file);
/*  91 */     this.priority.save(file);
/*  92 */     this.priorities.save(file);
/*  93 */     this.history.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/*  98 */     super.load(file);
/*  99 */     this.target.load(file);
/* 100 */     this.priority.load(file);
/* 101 */     this.priorities.load(file);
/* 102 */     this.history.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/* 107 */     super.clear();
/* 108 */     this.target.clear();
/* 109 */     this.priority.clear();
/* 110 */     this.priorities.clear();
/* 111 */     this.history.clear();
/* 112 */     setPrioOnSkill();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrioOnSkill() {
/* 117 */     for (WGROUP g : WGROUP.all()) {
/* 118 */       setPrioOnSkill(g);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setPrioOnFullfillment() {
/* 123 */     for (WGROUP g : WGROUP.all()) {
/* 124 */       setPrioOnFullfillment(g);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setPrioOnSkill(WGROUP g) {
/* 129 */     int p = CLAMP.i((int)Math.round(RACES.boosts().getNorSkill(g.race, this) * this.priorities.max), 1, this.priorities.max);
/* 130 */     this.priorities.set(g, p);
/*     */   }
/*     */   
/*     */   public void setPrioOnFullfillment(WGROUP g) {
/* 134 */     int p = CLAMP.i((int)Math.round(g.race.pref().getWork(this) * this.priorities.max), 1, this.priorities.max);
/* 135 */     this.priorities.set(g, p);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 140 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double efficiency() {
/* 146 */     return super.efficiency();
/*     */   }
/*     */   
/*     */   public static class Priority
/*     */     implements INT.INTE {
/*     */     final RoomEmployment p;
/* 152 */     private int prio = 10;
/*     */     
/*     */     public Priority(RoomEmployment p) {
/* 155 */       this.p = p;
/*     */     }
/*     */     
/*     */     void save(FilePutter file) {
/* 159 */       file.i(this.prio);
/*     */     }
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 163 */       this.prio = file.i();
/*     */     }
/*     */     
/*     */     void clear() {
/* 167 */       this.prio = 10;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max() {
/* 172 */       return 30;
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/* 177 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get() {
/* 182 */       return this.prio;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int i) {
/* 187 */       i = CLAMP.i(i, min(), max());
/* 188 */       if (this.prio != i) {
/* 189 */         this.prio = i;
/* 190 */         (SETT.ROOMS()).employment.employer.updateAll();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class GRoupInt
/*     */     implements INT_O.INT_OE<WGROUP>
/*     */   {
/*     */     private int total;
/* 199 */     private final int[] racePrio = Alloc.ii(WGROUP.all().size());
/*     */     private final int min;
/*     */     private final int max;
/*     */     
/*     */     public GRoupInt(int min, int max) {
/* 204 */       this.min = min;
/* 205 */       this.max = max;
/*     */     }
/*     */     
/*     */     void save(FilePutter file) {
/* 209 */       file.is(this.racePrio);
/* 210 */       file.i(this.total);
/*     */     }
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 214 */       file.is(this.racePrio);
/* 215 */       this.total = file.i();
/*     */     }
/*     */     
/*     */     void clear() {
/* 219 */       Arrays.fill(this.racePrio, 0);
/* 220 */       this.total = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(WGROUP t) {
/* 225 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(WGROUP t) {
/* 230 */       return this.min;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(WGROUP t) {
/* 235 */       if (t == null)
/* 236 */         return this.total; 
/* 237 */       return this.racePrio[t.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(WGROUP t, int i) {
/* 242 */       i = CLAMP.i(i, min(t), max(t));
/* 243 */       if (this.racePrio[t.index()] != i) {
/*     */         
/* 245 */         this.total -= this.racePrio[t.index()];
/* 246 */         this.racePrio[t.index()] = i;
/* 247 */         this.total += this.racePrio[t.index()];
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Target
/*     */   {
/*     */     private int target;
/*     */     
/* 257 */     private final int[] perGroup = Alloc.ii(WGROUP.all().size());
/*     */ 
/*     */ 
/*     */     
/*     */     public Target(RoomEmployment p) {}
/*     */ 
/*     */     
/*     */     public int get() {
/* 265 */       return this.target;
/*     */     }
/*     */     
/*     */     public int group(WGROUP g) {
/* 269 */       return this.perGroup[g.index()];
/*     */     }
/*     */     
/*     */     void clear() {
/* 273 */       this.target = 0;
/* 274 */       for (WGROUP e : WGROUP.all()) {
/* 275 */         (SETT.ROOMS()).employment.changeTarget(-this.perGroup[e.index()], e);
/* 276 */         this.perGroup[e.index()] = 0;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void add(WGROUP g, int amount) {
/* 282 */       (SETT.ROOMS()).employment.changeTarget(amount, g);
/* 283 */       this.target += amount;
/* 284 */       this.perGroup[g.index()] = this.perGroup[g.index()] + amount;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void save(FilePutter file) {
/* 290 */       file.i(this.target);
/* 291 */       file.is(this.perGroup);
/*     */     }
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 295 */       this.target = file.i();
/* 296 */       file.is(this.perGroup);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmployment.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */