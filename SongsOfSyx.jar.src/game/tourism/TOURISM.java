/*     */ package game.tourism;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.service.StatService;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.wiki.WIKI;
/*     */ 
/*     */ public final class TOURISM
/*     */   extends GAME.GameResource
/*     */ {
/*  47 */   static final double CREDITS = (Config.sett()).TOURIST_CRETIDS;
/*     */   static final int MIN_EMPLOYEES = 100;
/*     */   static final double MAX_EMPLOYEES = 1000.0D;
/*  50 */   public static final int AMOUNT = (Config.sett()).TOURIST_PER_YEAR_MAX;
/*     */ 
/*     */   
/*     */   static TOURISM self;
/*     */   
/*  55 */   private final Review[] reviews = new Review[32];
/*  56 */   private final ArrayList<Review> list = new ArrayList(32);
/*     */   private final LIST<Race> tourists;
/*  58 */   final HistoryInt history = new HistoryInt(24, (TIMECYCLE)TIME.seasons(), false);
/*     */   private final Updater updater;
/*  60 */   private final Bitmap1D permit = new Bitmap1D(RACES.all().size(), false);
/*  61 */   private double score = 0.0D;
/*     */   
/*     */   private final ACTION wiki;
/*  64 */   private final double[] races = new double[RACES.all().size()];
/*     */ 
/*     */   
/*     */   public TOURISM() {
/*  68 */     super("TOURISTS", false);
/*  69 */     self = this;
/*  70 */     for (int i = 0; i < this.reviews.length; i++) {
/*  71 */       this.reviews[i] = new Review();
/*     */     }
/*     */     
/*  74 */     LinkedList<Race> li = new LinkedList();
/*  75 */     for (Race r : RACES.all()) {
/*  76 */       if ((r.tourism()).occurence > 0.0D) {
/*  77 */         li.add(r);
/*     */       }
/*     */     } 
/*  80 */     this.tourists = (LIST<Race>)new ArrayList((Iterable)li);
/*  81 */     this.updater = new Updater();
/*  82 */     this.permit.setAll(true);
/*  83 */     this.wiki = WIKI.add(new Json((PATHS.RACE()).text.getFolder("tourist").gets("_WIKI")));
/*     */     
/*  85 */     IDebugPanelSett.add("TOURIST_REVIEW", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  89 */             Induvidual i = new Induvidual(HTYPES.TOURIST(), (Race)RACES.playable().rnd());
/*  90 */             TOURISM.service(i).cheatSetTotal(i, RND.rFloat());
/*  91 */             RoomInstance ii = ((SETT.ROOMS()).INN.instancesSize() > 0) ? (SETT.ROOMS()).INN.getInstance(RND.rInt((SETT.ROOMS()).INN.instancesSize())) : null;
/*  92 */             TOURISM.touristFinish(i, (ii != null) ? (COORDINATE)new Coo(ii.mX(), ii.mY()) : (COORDINATE)new Coo(-1.0D, -1.0D));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*     */     byte b;
/*     */     int i;
/*     */     Review[] arrayOfReview;
/* 103 */     for (i = (arrayOfReview = this.reviews).length, b = 0; b < i; ) { Review r = arrayOfReview[b];
/* 104 */       r.save(file); b++; }
/* 105 */      this.history.save(file);
/* 106 */     this.updater.save(file);
/* 107 */     this.permit.save(file);
/* 108 */     file.d(this.score);
/* 109 */     RACES.map().saver().save(this.races, file);
/*     */   }
/*     */   protected void load(FileGetter file) throws IOException {
/*     */     byte b;
/*     */     int i;
/*     */     Review[] arrayOfReview;
/* 115 */     for (i = (arrayOfReview = this.reviews).length, b = 0; b < i; ) { Review r = arrayOfReview[b];
/* 116 */       r.load(file); b++; }
/* 117 */      this.history.load(file);
/* 118 */     this.updater.load(file);
/* 119 */     this.permit.load(file);
/* 120 */     this.score = file.d();
/* 121 */     RACES.map().loader().load(this.races, file, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 126 */     prof.logStart(TOURISM.class);
/* 127 */     this.updater.update(ds);
/* 128 */     prof.logEnd(TOURISM.class);
/*     */   }
/*     */   
/*     */   public static RoomBlueprintIns<?> attraction(Induvidual indu) {
/* 132 */     return Updater.attraction(indu);
/*     */   }
/*     */   
/*     */   public static int perYear() {
/* 136 */     return (int)Math.ceil(self.updater.chance() * AMOUNT);
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatService service(Induvidual i) {
/* 141 */     NEED n = need(i);
/* 142 */     if (n == null) {
/* 143 */       GAME.Notify("here");
/*     */     }
/* 145 */     return (AI.modules()).needs.service(i, n, STATS.RAN().getD(i, 15));
/*     */   }
/*     */ 
/*     */   
/*     */   public static AIPLAN.AiPlanActivation servicePlan(Humanoid a, AIManager d) {
/* 150 */     NEED n = need(a.indu());
/* 151 */     return (AI.modules()).needs.plan(a, d, n, STATS.RAN().getD(a.indu(), 15));
/*     */   }
/*     */ 
/*     */   
/*     */   private static NEED need(Induvidual a) {
/* 156 */     long max = 0L;
/* 157 */     for (NEED n : NEEDS.ALLSIMPLE()) {
/* 158 */       if (n != (NEEDS.TYPES()).SHRINE && n != (NEEDS.TYPES()).TEMPLE && n != (NEEDS.TYPES()).SKINNYDIP) {
/* 159 */         max += (long)(1000.0D * a.race().bvalue(n.rate));
/*     */       }
/*     */     } 
/* 162 */     max = (long)(max * STATS.RAN().getD(a, 21));
/* 163 */     for (NEED n : NEEDS.ALLSIMPLE()) {
/* 164 */       if (n != (NEEDS.TYPES()).SHRINE && n != (NEEDS.TYPES()).TEMPLE && n != (NEEDS.TYPES()).SKINNYDIP) {
/* 165 */         max -= (long)(1000.0D * a.race().bvalue(n.rate));
/* 166 */         if (max <= 0L) {
/* 167 */           return n;
/*     */         }
/*     */       } 
/*     */     } 
/* 171 */     return (NEED)NEEDS.ALLSIMPLE().get(0);
/*     */   }
/*     */   
/*     */   public static int credits(Race race) {
/* 175 */     return (int)((race.tourism()).credits * CREDITS);
/*     */   }
/*     */   
/*     */   public static LIST<Race> races() {
/* 179 */     return self.tourists;
/*     */   }
/*     */   
/*     */   public static HISTORY_INT history() {
/* 183 */     return (HISTORY_INT)self.history;
/*     */   }
/*     */   
/*     */   public static boolean permit(Race race) {
/* 187 */     return self.permit.get(race.index());
/*     */   }
/*     */   
/*     */   public static void permit(Race race, boolean perm) {
/* 191 */     self.permit.set(race.index(), perm);
/*     */   }
/*     */   
/*     */   public static double score() {
/* 195 */     return self.score;
/*     */   }
/*     */   
/*     */   public static void touristFinish(Induvidual tourist, COORDINATE inn) {
/* 199 */     if (SETT.ENTRY().beseiged()) {
/*     */       return;
/*     */     }
/*     */     
/* 203 */     Review v = self.reviews[self.reviews.length - 1]; int i;
/* 204 */     for (i = self.reviews.length - 1; i > 0; i--) {
/* 205 */       self.reviews[i] = self.reviews[i - 1];
/*     */     }
/* 207 */     self.reviews[0] = v;
/* 208 */     v.make(tourist, inn);
/*     */     
/* 210 */     self.score = (15.0D * self.score + v.score) / 16.0D;
/* 211 */     self.score = CLAMP.d(self.score, 0.0D, 1.0D);
/*     */     
/* 213 */     if ((SETT.ROOMS()).INN.is(inn))
/* 214 */       (SETT.ROOMS()).INN.setReview(inn.x(), inn.y(), v); 
/* 215 */     FACTIONS.player().credits().inc(v.credits, FCredits.CTYPE.TOURISM);
/*     */     
/* 217 */     self.races[tourist.race().index()] = self.races[tourist.race().index()] + 1.0D;
/* 218 */     for (i = 0; i < self.races.length; i++) {
/* 219 */       self.races[i] = self.races[i] / 2.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<Review> reviews() {
/* 225 */     self.list.clear();
/* 226 */     for (int i = 0; i < self.reviews.length && 
/* 227 */       self.reviews[i].has(); i++) {
/* 228 */       self.list.add(self.reviews[i]);
/*     */     }
/*     */ 
/*     */     
/* 232 */     return (LIST<Review>)self.list;
/*     */   }
/*     */   
/*     */   public static ACTION wiki() {
/* 236 */     return self.wiki;
/*     */   }
/*     */   
/*     */   public static double race(Race race) {
/* 240 */     return self.races[race.index()];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\TOURISM.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */