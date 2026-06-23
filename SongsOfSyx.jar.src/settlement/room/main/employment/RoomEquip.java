/*     */ package settlement.room.main.employment;
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.info.INFO;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
/*     */ 
/*     */ public class RoomEquip implements INDEXED {
/*  48 */   private final ArrayListGrower<RoomEmploymentSimple> rooms = new ArrayListGrower();
/*     */   final ArrayList<Target> targets;
/*     */   private final int[] currents;
/*     */   private int total;
/*     */   private final int index;
/*     */   public final double degradePerDay;
/*     */   private final int defaultTarget;
/*     */   public final RESOURCE resource;
/*     */   public final BoostSpecs boosts;
/*     */   public final int maxAm;
/*  58 */   private static CharSequence ¤¤equipment = "Equipment";
/*  59 */   private static CharSequence ¤¤equipmentD = "Equipment boosts the efficiency of rooms. When equipped, each {0} degrades with a rate of {1} % per day.";
/*     */   
/*     */   private BoostSpec[] boostMap;
/*     */   
/*     */   public final INFO info;
/*     */   
/*     */   static {
/*  66 */     D.ts(RoomEquip.class);
/*     */   }
/*     */   
/*  69 */   final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       public void save(FilePutter file)
/*     */       {
/*  73 */         file.i(RoomEquip.this.targets.size());
/*  74 */         for (int i = 0; i < RoomEquip.this.targets.size(); i++) {
/*  75 */           file.i(((RoomEquip.Target)RoomEquip.this.targets.get(i)).get());
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/*  81 */         clear();
/*  82 */         int am = file.i();
/*     */         
/*  84 */         if (am != RoomEquip.this.targets.size()) {
/*  85 */           for (int i = 0; i < am; i++) {
/*  86 */             file.i();
/*     */           }
/*  88 */           clear();
/*     */         } else {
/*  90 */           for (int i = 0; i < RoomEquip.this.targets.size(); i++) {
/*  91 */             ((RoomEquip.Target)RoomEquip.this.targets.get(i)).set(file.i());
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void clear() {
/* 100 */         RoomEquip.this.total = 0;
/* 101 */         for (int i = 0; i < RoomEquip.this.targets.size(); i++) {
/* 102 */           ((RoomEquip.Target)RoomEquip.this.targets.get(i)).set(RoomEquip.this.defaultTarget);
/* 103 */           RoomEquip.this.currents[i] = 0;
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   RoomEquip(String kkey, LISTE<RoomEquip> all, RoomEmployments emps, Json data, ROOMS rOOMS, BoostableCat cat) {
/* 109 */     this.targets = new ArrayList(emps.ALLS().size());
/* 110 */     while (this.targets.hasRoom())
/* 111 */       this.targets.add(new Target()); 
/* 112 */     this.currents = Alloc.ii(emps.ALLS().size());
/* 113 */     this.boostMap = new BoostSpec[emps.ALLS().size()];
/*     */ 
/*     */     
/* 116 */     this.index = all.add(this);
/* 117 */     this.resource = (RESOURCE)RESOURCES.map().read(data);
/* 118 */     this.degradePerDay = data.d("WEAR_PER_DAY", 0.0D, 1.0D);
/* 119 */     this.defaultTarget = data.i("DEFAULT_TARGET");
/* 120 */     this.info = new INFO(String.valueOf(¤¤equipment) + ": " + String.valueOf(¤¤equipment), String.valueOf(Str.TMP.clear().add(¤¤equipmentD).insert(0, this.resource.name).insert(1, this.degradePerDay * 100.0D, 2)));
/* 121 */     this.boosts = new BoostSpecs(this.resource.names, (SPRITE)this.resource.icon(), true);
/* 122 */     double add = data.d("BOOST_MAX_VALUE");
/*     */     
/* 124 */     int[] ams = Alloc.ii(emps.ALLS().size());
/* 125 */     rOOMS.collection.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     for (RoomEmploymentSimple e : emps.ALLS()) {
/* 153 */       int am = ams[e.eindex()];
/* 154 */       if (am > 0) {
/* 155 */         this.rooms.add(e);
/*     */         
/* 157 */         ((Target)this.targets.get(e.eindex())).init(kkey, am, (RoomBlueprintImp)e.blueprint(), this.resource, cat);
/*     */         
/* 159 */         ((Target)this.targets.get(e.eindex())).max = am;
/* 160 */         ((Target)this.targets.get(e.eindex())).set(this.defaultTarget);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 166 */     int m = 0;
/*     */     
/* 168 */     for (RoomEmploymentSimple e : this.rooms) {
/* 169 */       m = Math.max(m, ((Target)this.targets.get(e.eindex())).max);
/*     */     }
/*     */     
/* 172 */     this.maxAm = m;
/*     */     
/* 174 */     boolean mul = data.bool("BOOST_MUL", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     for (RoomEmploymentSimple e : this.rooms) {
/* 184 */       m = ((Target)this.targets.get(e.eindex())).max;
/* 185 */       double to = Math.ceil(add * 100.0D * ((Target)this.targets.get(e.eindex())).max) / this.maxAm * 100.0D;
/* 186 */       BoosterImp bo = new BoosterImp(new BSourceInfo(this.resource.names, (SPRITE)this.resource.icon()), to, mul)
/*     */         {
/*     */           public double vGet(Faction f)
/*     */           {
/* 190 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Player f) {
/* 195 */             return RoomEquip.this.value(e);
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(FactionNPC f) {
/* 200 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(HCLASS_RACE popTime) {
/* 205 */             return RoomEquip.this.value(e);
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Induvidual indu) {
/* 210 */             RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(indu);
/* 211 */             if (ins == null || ins.blueprint() != e.blueprint()) {
/* 212 */               return 0.0D;
/*     */             }
/* 214 */             double t = ins.employees().toolsTargetMax(RoomEquip.this);
/* 215 */             if (t == 0.0D)
/* 216 */               return 0.0D; 
/* 217 */             double tt = ins.employees().tools(RoomEquip.this);
/* 218 */             tt = CLAMP.d(tt, 0.0D, ins.employees().toolsTarget(RoomEquip.this));
/* 219 */             return CLAMP.d(tt / t, 0.0D, 1.0D);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 224 */       BoostSpec s = this.boosts.push((Booster)bo, e.blueprint().bonus());
/* 225 */       this.boostMap[e.eindex()] = s;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Target target(RoomEmploymentSimple e) {
/* 230 */     return (Target)this.targets.get(e.eindex());
/*     */   }
/*     */   
/*     */   public int targetI(RoomEmploymentSimple e) {
/* 234 */     return ((Target)this.targets.get(e.eindex())).get() * e.employed();
/*     */   }
/*     */   
/*     */   public int current(RoomEmploymentSimple e) {
/* 238 */     return this.currents[e.eindex()];
/*     */   }
/*     */   
/*     */   public double value(RoomEmploymentSimple e) {
/* 242 */     double tt = targetI(e);
/* 243 */     if (tt == 0.0D)
/* 244 */       return 0.0D; 
/* 245 */     double c = this.currents[e.eindex()] / tt;
/* 246 */     c = CLAMP.d(c, 0.0D, ((Target)this.targets.get(e.eindex())).getD());
/*     */     
/* 248 */     return c;
/*     */   }
/*     */   
/*     */   public int currentTotal() {
/* 252 */     return this.total;
/*     */   }
/*     */   
/*     */   public int neededTotal() {
/* 256 */     int am = 0;
/* 257 */     for (int i = 0; i < this.rooms.size(); i++) {
/* 258 */       am += targetI((RoomEmploymentSimple)this.rooms.get(i));
/*     */     }
/* 260 */     return am;
/*     */   }
/*     */   
/*     */   public LIST<RoomEmploymentSimple> rooms() {
/* 264 */     return (LIST<RoomEmploymentSimple>)this.rooms;
/*     */   }
/*     */   
/*     */   public BoostSpec boost(RoomEmploymentSimple e) {
/* 268 */     return this.boostMap[e.eindex()];
/*     */   }
/*     */   
/*     */   public boolean has(RoomEmploymentSimple e) {
/* 272 */     return (((Target)this.targets.get(e.eindex())).max() > 0);
/*     */   }
/*     */   
/*     */   void count(RoomEmploymentSimple e, int am) {
/* 276 */     this.currents[e.eindex()] = this.currents[e.eindex()] + am;
/* 277 */     this.total += am;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 282 */     return this.index;
/*     */   }
/*     */   
/*     */   public static class Target
/*     */     implements INT.INTE {
/*     */     private Boostable maxLevel;
/*     */     int max;
/*     */     int i;
/*     */     public RoomBlueprintImp blue;
/* 291 */     static final ArrayListGrower<Target> boos = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void init(String kkey, int am, final RoomBlueprintImp bp, final RESOURCE resource, BoostableCat cat) {
/* 307 */       this.max = am;
/* 308 */       this.blue = bp;
/* 309 */       String key = "LEVEL_" + kkey + "_" + bp.key;
/* 310 */       String name = String.valueOf(resource.names) + "(" + String.valueOf(resource.names) + ")";
/* 311 */       SPRITE.Imp imp = new SPRITE.Imp(32, 16)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 316 */             int dim = Y2 - Y1;
/* 317 */             if (dim <= 16) {
/* 318 */               bp.icon.render(r, X1, X2, Y1, Y2);
/*     */             } else {
/* 320 */               bp.icon.render(r, X1, X1 + dim, Y1, Y2);
/* 321 */               resource.icon().render(r, X1 + dim, X1 + dim + dim, Y1, Y2);
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 327 */       this.maxLevel = BOOSTING.push(key, 0.0D, name, name, (SPRITE)imp, cat);
/* 328 */       boos.add(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int get() {
/* 336 */       return CLAMP.i(this.i, 0, availableMax());
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/* 341 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max() {
/* 346 */       return this.max;
/*     */     }
/*     */     
/*     */     public int availableMax() {
/* 350 */       return (int)((this.maxLevel == null) ? 0.0D : this.maxLevel.get((BOOSTABLE_O)FACTIONS.player()));
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/* 355 */       this.i = t;
/*     */     }
/*     */     
/*     */     public Boostable boost() {
/* 359 */       return this.maxLevel;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEquip.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */