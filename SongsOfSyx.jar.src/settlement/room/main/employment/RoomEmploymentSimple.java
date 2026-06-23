/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.WGROUP;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class RoomEmploymentSimple
/*     */ {
/*     */   private boolean countInput = false;
/*     */   private final RoomBlueprintIns<?> p;
/*  37 */   protected int workersNeeded = 0;
/*  38 */   private int employedTot = 0;
/*  39 */   private int[] employed = Alloc.ii(HTYPES.ALL().size() * RACES.all().size());
/*     */   
/*  41 */   private int employedMax = 0;
/*  42 */   private int[] workersNeededPreferred = Alloc.ii(WGROUP.all().size());
/*     */   
/*     */   public final CharSequence title;
/*     */   public final CharSequence verb;
/*     */   private double hourStart;
/*     */   private final SoundRace sound;
/*     */   private boolean shift;
/*     */   public final double accidentsPerYear;
/*     */   public final double defaultFullfillment;
/*     */   public final double healthFactor;
/*  52 */   private double fill = 1.0D;
/*     */   private final int eindex;
/*     */   public final int largeWorkforce;
/*  55 */   private int efficiency = 0;
/*  56 */   private int proximity = 0;
/*  57 */   private int fetch = 0;
/*     */ 
/*     */   
/*  60 */   static ArrayListResize<RoomEmploymentSimple> WORK_ALL = new ArrayListResize(10, 512);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomEmploymentSimple(String key, RoomBlueprintIns<?> p, RoomInitData init) {
/*  71 */     this.p = p;
/*  72 */     Json data = init.data().json(key);
/*  73 */     Json text = init.text().json(key);
/*  74 */     this.title = text.text("TITLE");
/*  75 */     this.verb = text.text("VERB");
/*  76 */     this.hourStart = data.d("SHIFT_OFFSET", 0.0D, 0.99D);
/*  77 */     this.shift = (data.has("NIGHT_SHIFT") && data.bool("NIGHT_SHIFT"));
/*  78 */     this.sound = AUDIO.race("ROOM_WORK_" + p.key);
/*  79 */     if (data.has("FULFILLMENT")) {
/*  80 */       this.defaultFullfillment = data.d("FULFILLMENT", -100000.0D, 100000.0D);
/*     */     } else {
/*  82 */       this.defaultFullfillment = 0.5D;
/*  83 */     }  this.accidentsPerYear = data.dTry("ACCIDENTS_PER_YEAR", 0.0D, 10000.0D, 0.0D) / 2.0D;
/*  84 */     this.healthFactor = data.dTry("HEALTH_FACTOR", 0.0D, 1.0D, 1.0D);
/*  85 */     this.largeWorkforce = data.i("LARGE_WORKFORCE", 10, 10000, 1000);
/*  86 */     this.eindex = WORK_ALL.add(this);
/*     */     
/*  88 */     GVALUES.FACTION.push("EMPLOYED_" + p.key(), String.valueOf(Dic.¤¤Employees) + ": " + String.valueOf(Dic.¤¤Employees), (SPRITE)p.iconBig(), new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  92 */             return RoomEmploymentSimple.this.employed();
/*     */           }
/*     */         }, 
/*  95 */         false);
/*     */   }
/*     */   
/*     */   public void countInputSet() {
/*  99 */     this.countInput = true;
/*     */   }
/*     */   
/*     */   public boolean countInput() {
/* 103 */     return this.countInput;
/*     */   }
/*     */   
/*     */   public int eindex() {
/* 107 */     return this.eindex;
/*     */   }
/*     */   
/*     */   public int employed() {
/* 111 */     return this.employedTot;
/*     */   }
/*     */   
/*     */   public int employed(WGROUP g) {
/* 115 */     if (g == null)
/* 116 */       return this.employedTot; 
/* 117 */     return employed(g.type, g.race);
/*     */   }
/*     */   
/*     */   public int employed(HTYPE t, Race r) {
/* 121 */     return this.employed[r.index() * HTYPES.ALL().size() + t.index()];
/*     */   }
/*     */   
/*     */   public int employedMax() {
/* 125 */     return this.employedMax;
/*     */   }
/*     */   
/*     */   public final int neededWorkers() {
/* 129 */     return this.workersNeeded;
/*     */   }
/*     */   
/*     */   public final int neededWorkers(WGROUP t) {
/* 133 */     return this.workersNeededPreferred[t.index];
/*     */   }
/*     */   
/*     */   public SoundRace sound() {
/* 137 */     return this.sound;
/*     */   }
/*     */   
/*     */   void register(RoomEmploymentIns ins, int delta) {
/* 141 */     this.workersNeeded += delta * ins.hardTarget();
/* 142 */     for (int hi = 0; hi < WGROUP.all().size(); hi++) {
/* 143 */       WGROUP g = (WGROUP)WGROUP.all().get(hi);
/* 144 */       this.workersNeededPreferred[g.index] = this.workersNeededPreferred[g.index] + (ins.preffered().is(g) ? (delta * ins.hardTarget()) : 0);
/*     */     } 
/*     */     
/* 147 */     this.efficiency = (int)(this.efficiency + delta * ins.efficiency() * 100.0D * ins.hardTarget());
/* 148 */     this.efficiency = Math.max(0, this.efficiency);
/* 149 */     this.proximity = (int)(this.proximity + delta * ins.proximity() * 100.0D * ins.hardTarget());
/* 150 */     this.proximity = Math.max(0, this.proximity);
/* 151 */     this.fetch = (int)(this.fetch + delta * ins.fetchProximity() * 100.0D * ins.hardTarget());
/* 152 */     this.fetch = Math.max(0, this.fetch);
/* 153 */     this.employedMax += delta * ins.max();
/* 154 */     for (RoomEquip t : tools()) {
/* 155 */       t.count(this, delta * ins.tools(t));
/*     */     }
/*     */     
/* 158 */     if (delta > 0 && this.workersNeeded < 0) {
/* 159 */       throw new RuntimeException(String.valueOf((blueprint()).info.name) + " " + String.valueOf((blueprint()).info.name) + " " + this.workersNeeded);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void employ(Humanoid h, int delta) {
/* 168 */     this.employedTot += delta;
/* 169 */     this.employed[h.race().index() * HTYPES.ALL().size() + h.indu().hType().index()] = this.employed[h.race().index() * HTYPES.ALL().size() + h.indu().hType().index()] + delta;
/*     */   }
/*     */   
/*     */   void loadadd(RoomEmploymentIns ins) {
/* 173 */     ins.add();
/* 174 */     this.employedTot += ins.employed();
/*     */   }
/*     */   
/*     */   public double getFill() {
/* 178 */     return this.fill;
/*     */   }
/*     */   
/*     */   public LIST<RoomEquip> tools() {
/* 182 */     return (SETT.ROOMS()).employment.equip.get(this);
/*     */   }
/*     */   
/*     */   public double efficiency() {
/* 186 */     if (this.p.instancesSize() == 0)
/* 187 */       return 1.0D; 
/* 188 */     return this.efficiency / 100.0D * this.workersNeeded;
/*     */   }
/*     */   
/*     */   public double proximity() {
/* 192 */     if (this.p.instancesSize() == 0 || this.workersNeeded <= 0)
/* 193 */       return 1.0D; 
/* 194 */     return this.proximity / 100.0D * this.workersNeeded;
/*     */   }
/*     */   
/*     */   public double fetch() {
/* 198 */     if (this.p.instancesSize() == 0 || this.workersNeeded <= 0)
/* 199 */       return 1.0D; 
/* 200 */     return this.fetch / 100.0D * this.workersNeeded;
/*     */   }
/*     */   
/*     */   public double totEff() {
/* 204 */     return efficiency() * proximity() * fetch();
/*     */   }
/*     */   
/*     */   public RoomBlueprintIns<?> blueprint() {
/* 208 */     return this.p;
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 212 */     file.isE(this.employed);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 216 */     file.isE(this.employed);
/*     */   }
/*     */   
/*     */   void clear() {
/* 220 */     Arrays.fill(this.employed, 0);
/* 221 */     this.employedTot = 0;
/* 222 */     this.employedMax = 0;
/* 223 */     this.workersNeeded = 0;
/* 224 */     this.efficiency = 0;
/* 225 */     this.proximity = 0;
/* 226 */     this.fetch = 0;
/* 227 */     Arrays.fill(this.workersNeededPreferred, 0);
/*     */   }
/*     */   
/*     */   public double getShiftStart() {
/* 231 */     return this.hourStart;
/*     */   }
/*     */   
/*     */   public void setShiftStart(double start, boolean nights) {
/* 235 */     this.hourStart = start;
/* 236 */     this.shift = nights;
/*     */   }
/*     */   
/*     */   public boolean worksNights() {
/* 240 */     return this.shift;
/*     */   }
/*     */   
/*     */   public static class EmployerSimple
/*     */   {
/*     */     private final RoomEmploymentSimple si;
/*     */     
/*     */     public EmployerSimple(RoomEmploymentSimple si) {
/* 248 */       this.si = si;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean employ(Humanoid h) {
/* 253 */       RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(h);
/* 254 */       if (ins != null && ins.blueprintI() == this.si.blueprint()) {
/* 255 */         if (ins.blueprintI() == this.si.blueprint())
/* 256 */         { if (ins.employees().isOverstaffed()) {
/* 257 */             (STATS.WORK()).EMPLOYED.set(h, null);
/* 258 */             ins = null;
/*     */           } else {
/* 260 */             return true;
/*     */           }  }
/* 262 */         else { (STATS.WORK()).EMPLOYED.set(h, null); }
/*     */       
/*     */       }
/*     */       
/* 266 */       if (this.si.neededWorkers() > this.si.employed()) {
/* 267 */         if (this.si.blueprint().instancesSize() <= 0)
/* 268 */           throw new RuntimeException((this.si.blueprint()).key + " " + (this.si.blueprint()).key + " " + this.si.neededWorkers()); 
/* 269 */         int i = RND.rInt(this.si.blueprint().instancesSize()); int k;
/* 270 */         for (k = 0; k < this.si.blueprint().instancesSize(); k++) {
/* 271 */           RoomInstance in = this.si.blueprint().getInstance((i + k) % this.si.blueprint().instancesSize());
/* 272 */           if (in.active() && in.employees().employed() < in.employees().target()) {
/* 273 */             (STATS.WORK()).EMPLOYED.set(h, in);
/* 274 */             return true;
/*     */           } 
/*     */         } 
/* 277 */         LOG.err("no! " + this.si.neededWorkers() + " " + this.si.employed() + " " + this.si.blueprint().instancesSize());
/* 278 */         for (k = 0; k < this.si.blueprint().instancesSize(); k++) {
/* 279 */           RoomInstance in = this.si.blueprint().getInstance((i + k) % this.si.blueprint().instancesSize());
/* 280 */           LOG.err("" + k + " " + k + " " + in.active() + " " + in.employees().employed() + " " + in.employees().target() + " " + in.employees().hardTarget() + " " + this.si.getFill());
/*     */         } 
/*     */       } 
/*     */       
/* 284 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int employable() {
/* 289 */       return this.si.neededWorkers() - this.si.employed();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmploymentSimple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */