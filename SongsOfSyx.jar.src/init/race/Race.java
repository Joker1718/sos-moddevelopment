/*     */ package init.race;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.tourism.TourismRace;
/*     */ import init.race.appearence.RAppearence;
/*     */ import init.race.bio.Bio;
/*     */ import init.race.home.RaceHome;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.Equip;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ public class Race
/*     */   implements MAPPED
/*     */ {
/*     */   public final BoostSpecs boosts;
/*  31 */   private KeyMap<LinkedList<BoostSpec>> bmap = null;
/*     */   
/*     */   private RacePreferrence pref;
/*     */   
/*     */   public final RaceInfo info;
/*     */   
/*     */   public final Physics physics;
/*     */   
/*     */   public final int index;
/*     */   
/*     */   public final boolean playable;
/*     */   public final String key;
/*     */   private KingMessages kmess;
/*     */   private RaceStats data;
/*     */   private RaceServiceSorter service;
/*     */   private RacePopulation population;
/*     */   private RaceHome home;
/*     */   private Bio bio;
/*     */   TourismRace tourism;
/*     */   private RAppearence appearance;
/*  51 */   private static final LIST<RES_AMOUNT> rNo = (LIST<RES_AMOUNT>)new ArrayList(0);
/*     */   
/*  53 */   private LIST<RES_AMOUNT> resources = rNo;
/*  54 */   private LIST<RES_AMOUNT> resourceGroom = rNo;
/*     */ 
/*     */ 
/*     */   
/*     */   public Race(String key, Json data, Json text, ArrayList<Race> list) {
/*  59 */     this.key = key;
/*  60 */     this.index = list.add(this);
/*     */     
/*  62 */     this.info = new RaceInfo(data, text);
/*  63 */     this.playable = data.bool("PLAYABLE");
/*  64 */     this.physics = new Physics(data);
/*     */     
/*  66 */     this.boosts = new BoostSpecs(this.info.names, (SPRITE)new SPRITE.Imp(16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  70 */             Race.this.appearance.iconBig.render(r, X1, X2, Y1, Y2);
/*     */           }
/*  73 */         }false);
/*     */     
/*  75 */     this.boosts.read(data, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void expand(ExpandInit init) throws IOException {
/*  82 */     Json data = new Json(init.p.gets(this.key));
/*  83 */     this.population = new RacePopulation(data);
/*     */     
/*  85 */     this.appearance = new RAppearence(this, data, init, this.physics.hitBoxsize());
/*  86 */     this.pref = new RacePreferrence(data, this);
/*     */     
/*  88 */     this.kmess = KingMessages.make(data, init);
/*     */     
/*  90 */     this.data = new RaceStats(this, data);
/*  91 */     this.service = new RaceServiceSorter(this);
/*     */     
/*  93 */     double[] ds = RESOURCES.map().readFill(data, 100000.0D);
/*  94 */     ArrayList<RES_AMOUNT> resources = new ArrayList(ds.length);
/*  95 */     for (RESOURCE r : RESOURCES.ALL()) {
/*  96 */       if (ds[r.index()] > 0.0D) {
/*  97 */         resources.add(new RES_AMOUNT.Imp(r, (int)ds[r.index()]));
/*     */       }
/*     */     } 
/* 100 */     this.resources = (LIST<RES_AMOUNT>)resources;
/*     */     
/* 102 */     if (data.has("RESOURCE_GROOMING"))
/* 103 */       this.resourceGroom = RES_AMOUNT.make(data.json("RESOURCE_GROOMING")); 
/* 104 */     this.home = new RaceHome(data.value("HOME"));
/* 105 */     this.bio = new Bio(data, this);
/* 106 */     this.tourism = new TourismRace(data, this);
/*     */     
/* 108 */     if (data.has("EQUIPMENT_NOT_ENABLED"))
/*     */     {
/* 110 */       for (Equip b : (STATS.EQUIP()).collAll.readMany("EQUIPMENT_NOT_ENABLED", data)) {
/* 111 */         b.setAllowed(this, false);
/*     */       }
/*     */     }
/*     */     
/* 115 */     if (data.has("EQUIPMENT_ENABLED"))
/*     */     {
/* 117 */       for (Equip b : (STATS.EQUIP()).collAll.readMany("EQUIPMENT_ENABLED", data)) {
/* 118 */         b.setAllowed(this, true);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RAppearence appearance() {
/* 125 */     return this.appearance;
/*     */   }
/*     */   
/*     */   public RacePreferrence pref() {
/* 129 */     return this.pref;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaceStats stats() {
/* 137 */     return this.data;
/*     */   }
/*     */   
/*     */   public RaceServiceSorter service() {
/* 141 */     return this.service;
/*     */   }
/*     */   
/*     */   public RacePopulation population() {
/* 145 */     return this.population;
/*     */   }
/*     */   
/*     */   public RaceHome home() {
/* 149 */     return this.home;
/*     */   }
/*     */   
/*     */   public Bio bio() {
/* 153 */     return this.bio;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 158 */     return String.valueOf(this.info.name) + "#" + String.valueOf(this.info.name);
/*     */   }
/*     */   
/*     */   public LIST<RES_AMOUNT> resources() {
/* 162 */     return this.resources;
/*     */   }
/*     */   
/*     */   public LIST<RES_AMOUNT> resourcesGroom() {
/* 166 */     return this.resourceGroom;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 171 */     return this.index;
/*     */   }
/*     */   
/*     */   public TourismRace tourism() {
/* 175 */     return this.tourism;
/*     */   }
/*     */   
/*     */   public KingMessages kingMessage() {
/* 179 */     return this.kmess;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 184 */     return this.key;
/*     */   }
/*     */   
/* 187 */   private static ArrayList<BoostSpec> dummy = new ArrayList(0);
/*     */   
/*     */   public LIST<BoostSpec> all(Boostable bo) {
/* 190 */     if (this.bmap == null) {
/* 191 */       this.bmap = new KeyMap();
/* 192 */       for (BoostSpec boost : this.boosts.all()) {
/* 193 */         if (!this.bmap.containsKey(boost.boostable.key))
/* 194 */           this.bmap.put(boost.boostable.key, new LinkedList()); 
/* 195 */         ((LinkedList)this.bmap.get(boost.boostable.key)).add(boost);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 200 */     if (this.bmap.containsKey(bo.key))
/* 201 */       return (LIST<BoostSpec>)this.bmap.get(bo.key); 
/* 202 */     return (LIST<BoostSpec>)dummy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double bvalue(Boostable bo, double input, double add, double mul) {
/* 208 */     double padd = (add > 0.0D) ? add : 0.0D;
/* 209 */     double sub = (add < 0.0D) ? add : 0.0D;
/* 210 */     for (BoostSpec s : all(bo)) {
/* 211 */       if (s.booster.isMul) {
/* 212 */         mul *= s.booster.getValue(input); continue;
/*     */       } 
/* 214 */       double a = s.booster.getValue(input);
/* 215 */       if (a < 0.0D) {
/* 216 */         sub += a; continue;
/*     */       } 
/* 218 */       padd += a;
/*     */     } 
/*     */     
/* 221 */     return CLAMP.d(padd * mul + sub, bo.minValue, Double.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public double bvalue(Boostable bo) {
/* 225 */     return bvalue(bo, 1.0D, bo.baseValue, 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\Race.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */