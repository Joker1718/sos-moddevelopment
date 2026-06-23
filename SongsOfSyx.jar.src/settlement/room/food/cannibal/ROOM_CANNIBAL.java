/*     */ package settlement.room.food.cannibal;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public class ROOM_CANNIBAL
/*     */   extends RoomBlueprintIns<CannibalInstance> implements PUNISHMENT_SERVICE {
/*  37 */   private static CharSequence ¤¤eat = "Slaughter";
/*  38 */   private static CharSequence ¤¤eatD = "Prisoners convicted to be executed can be put to good use in the Cannibal.";
/*     */   
/*     */   static {
/*  41 */     D.ts(ROOM_CANNIBAL.class);
/*     */   }
/*     */   
/*     */   final Job job;
/*  45 */   final int[] produced = Alloc.ii(RESOURCES.ALL().size());
/*  46 */   private int year = -1;
/*  47 */   private final double[] cannibalism = new double[RACES.all().size()];
/*     */   
/*     */   final Constructor constructor;
/*  50 */   private Cage cage = new Cage(this);
/*     */   
/*     */   private RESOURCE[] resources;
/*     */   
/*     */   int prisoners;
/*  55 */   private final BOOLEANO.BooleanOEImp<Race> permission = new BOOLEANO.BooleanOEImp(RACES.all().size(), true);
/*     */   
/*     */   public ROOM_CANNIBAL(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  58 */     super(0, init, "_CANNIBAL", cat);
/*     */     
/*  60 */     this.constructor = new Constructor(this, init);
/*  61 */     this.job = new Job(this);
/*     */ 
/*     */     
/*  64 */     this.permission.info = new INFO(¤¤eat, ¤¤eatD);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   RESOURCE[] resources() {
/*  71 */     RBIT.RBITImp m = new RBIT.RBITImp();
/*     */     
/*  73 */     if (this.resources == null) {
/*  74 */       int am = 0;
/*  75 */       for (Race race : RACES.all()) {
/*  76 */         for (RES_AMOUNT r : race.resources()) {
/*  77 */           if (!m.has(r.resource())) {
/*  78 */             am++;
/*  79 */             m.or(r.resource());
/*     */           } 
/*     */         } 
/*     */       } 
/*  83 */       RESOURCE[] res = new RESOURCE[am];
/*  84 */       m.clear();
/*  85 */       am = 0;
/*  86 */       for (Race race : RACES.all()) {
/*  87 */         for (RES_AMOUNT r : race.resources()) {
/*  88 */           if (!m.has(r.resource())) {
/*  89 */             res[am++] = r.resource();
/*  90 */             m.or(r.resource());
/*     */           } 
/*     */         } 
/*     */       } 
/*  94 */       this.resources = res;
/*     */     } 
/*     */     
/*  97 */     return this.resources;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 102 */     if (this.year != TIME.years().bitsSinceStart()) {
/* 103 */       Arrays.fill(this.produced, 0);
/* 104 */       this.year = TIME.years().bitsSinceStart();
/*     */     } 
/*     */     
/* 107 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/*     */       
/* 109 */       double d = this.cannibalism[ri];
/* 110 */       if (d < 1.0D) {
/* 111 */         d = 1.0D;
/*     */       }
/* 113 */       this.cannibalism[ri] = this.cannibalism[ri] - d * ds / TIME.years().bitSeconds() * 2.0D * this.cannibalism.length;
/* 114 */       this.cannibalism[ri] = CLAMP.d(this.cannibalism[ri], 0.0D, 1.5D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter f) {
/* 127 */     f.isE(this.produced);
/* 128 */     f.i(this.year);
/* 129 */     f.dsE(this.cannibalism);
/* 130 */     f.i(this.prisoners);
/* 131 */     this.permission.save(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {
/* 136 */     f.isE(this.produced);
/* 137 */     this.year = f.i();
/* 138 */     f.dsE(this.cannibalism);
/* 139 */     this.prisoners = f.i();
/* 140 */     this.permission.load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 145 */     this.year = -1;
/* 146 */     Arrays.fill(this.produced, 0);
/* 147 */     Arrays.fill(this.cannibalism, 0.0D);
/* 148 */     this.permission.clear();
/* 149 */     this.prisoners = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 154 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ 
/*     */   
/*     */   public void reportCannibal(Race race) {
/* 163 */     this.cannibalism[race.index] = this.cannibalism[race.index] + 100.0D / (STATS.POP()).POP.data().get(null);
/*     */   }
/*     */   
/*     */   public double cannibalism(Race race) {
/* 167 */     return CLAMP.d(this.cannibalism[race.index], 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public BOOLEANO.BOOLEAN_OE<Race> punishEnabled() {
/* 172 */     return (BOOLEANO.BOOLEAN_OE<Race>)this.permission;
/*     */   }
/*     */   
/*     */   public void setRace(int tx, int ty, Race race) {
/* 176 */     CannibalInstance ins = (CannibalInstance)get(tx, ty);
/* 177 */     if (ins != null) {
/* 178 */       int d = (SETT.ROOMS()).data.get(tx, ty);
/* 179 */       d = Job.race.set(d, race.index());
/* 180 */       (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, d);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int punishTotal() {
/* 187 */     return employment().employedMax();
/*     */   }
/*     */ 
/*     */   
/*     */   public int punishUsed() {
/* 192 */     return this.prisoners;
/*     */   }
/*     */   
/*     */   public Cage getPrisonerCage() {
/* 196 */     if (this.prisoners >= punishTotal()) {
/* 197 */       return null;
/*     */     }
/*     */     
/* 200 */     if (instancesSize() == 0) {
/* 201 */       return null;
/*     */     }
/* 203 */     int ri = RND.rInt(instancesSize());
/*     */     
/* 205 */     for (int i = 0; i < instancesSize(); i++) {
/* 206 */       CannibalInstance ins = (CannibalInstance)getInstance((i + ri) % instancesSize());
/* 207 */       if (ins.prisoners < ins.employees().max()) {
/* 208 */         for (int ci = 0; ci < ins.cages.size(); ci++) {
/* 209 */           Cage ca = cage(ins.cages.get().x(), ins.cages.get().y());
/* 210 */           if (ca.available())
/* 211 */             return ca; 
/* 212 */           ins.cages.inc();
/*     */         } 
/* 214 */         LOG.err("nono");
/* 215 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     LOG.err("nono2");
/* 220 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Cage getWorkCage(RoomInstance work) {
/* 226 */     CannibalInstance ins = (CannibalInstance)work;
/*     */     
/* 228 */     if (ins.reservable <= 0) {
/* 229 */       return null;
/*     */     }
/* 231 */     for (int ci = 0; ci < ins.cages.size(); ci++) {
/* 232 */       Cage ca = cage(ins.cages.get().x(), ins.cages.get().y());
/* 233 */       if (ca.canGrab())
/* 234 */         return ca; 
/* 235 */       ins.cages.inc();
/*     */     } 
/* 237 */     LOG.err("nono");
/* 238 */     return null;
/*     */   }
/*     */   
/*     */   public Cage cage(int tx, int ty) {
/* 242 */     return this.cage.get(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\cannibal\ROOM_CANNIBAL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */