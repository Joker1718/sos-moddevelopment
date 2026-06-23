/*     */ package init.type;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TERRAINS
/*     */ {
/*     */   private static TERRAINS self;
/*     */   private final TERRAIN OCEAN;
/*     */   private final TERRAIN WET;
/*     */   private final TERRAIN MOUNTAIN;
/*     */   private final TERRAIN FOREST;
/*     */   private final TERRAIN NONE;
/*     */   private final INFO info;
/*     */   private final LIST<TERRAIN> all;
/*     */   private final RMAP<TERRAIN> map;
/*     */   
/*     */   TERRAINS() {
/*  37 */     self = this;
/*  38 */     D.t(TERRAINS.class);
/*  39 */     ArrayList<TERRAIN> ts = new ArrayList(40);
/*  40 */     String key = "TERRAIN";
/*  41 */     Json json = new Json((PATHS.CONFIG()).init.gets(key));
/*  42 */     this.info = new INFO(D.g("Terrain"), "");
/*     */     
/*  44 */     this.OCEAN = new TERRAIN(ts, "OCEAN", json, 
/*  45 */         D.g("Ocean"), 
/*  46 */         D.g("OceanD", "Salt water such as oceans. Fish is plentiful."), true)
/*     */       {
/*     */         public SPRITE icon()
/*     */         {
/*  50 */           return (WORLD.WATER()).OCEAN.icon;
/*     */         }
/*     */ 
/*     */         
/*     */         public double value(int wx, int wy) {
/*  55 */           double res = 0.0D;
/*  56 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  57 */             if ((WORLD.WATER()).OCEAN.is.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/*  58 */               res += 0.25D; 
/*     */           } 
/*  60 */           return CLAMP.d(res, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  66 */     this.WET = new TERRAIN(ts, "WET", json, 
/*  67 */         D.g("Sweet", "Fresh water"), 
/*  68 */         D.g("SweetD", "Fresh water such as river beds or lakes. Offers natural irrigation, clay deposits and some fish."), true)
/*     */       {
/*     */         public SPRITE icon()
/*     */         {
/*  72 */           return (WORLD.WATER()).LAKE.icon;
/*     */         }
/*     */ 
/*     */         
/*     */         public double value(int wx, int wy) {
/*  77 */           double res = 0.0D;
/*  78 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  79 */             if ((WORLD.WATER()).RIVER_SMALL.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/*  80 */               res += 0.2D; 
/*  81 */             if ((WORLD.WATER()).LAKE.is.is(wx, wy, (DIR)DIR.ORTHO.get(di)) || (WORLD.WATER()).isRivery.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/*  82 */               res += 0.25D; 
/*     */           } 
/*  84 */           return CLAMP.d(res, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     
/*  88 */     this.MOUNTAIN = new TERRAIN(ts, "MOUNTAIN", json, 
/*  89 */         D.g("Mountain"), 
/*  90 */         D.g("MountainD", "Rich in caverns and mineral deposits."), true)
/*     */       {
/*     */         public SPRITE icon()
/*     */         {
/*  94 */           return (SETT.TERRAIN()).MOUNTAIN.getIcon();
/*     */         }
/*     */ 
/*     */         
/*     */         public double value(int wx, int wy) {
/*  99 */           double res = 0.0D;
/* 100 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 101 */             if ((WORLD.MOUNTAIN()).haser.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/* 102 */               res += 0.25D; 
/*     */           } 
/* 104 */           return CLAMP.d(res, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     
/* 108 */     this.FOREST = new TERRAIN(ts, "FOREST", json, 
/* 109 */         D.g("Forest"), 
/* 110 */         D.g("ForestD", "Forested areas. Good for lumber."), true)
/*     */       {
/*     */         public SPRITE icon()
/*     */         {
/* 114 */           return (WORLD.FOREST()).icon;
/*     */         }
/*     */ 
/*     */         
/*     */         public double value(int wx, int wy) {
/* 119 */           double res = 0.0D;
/* 120 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 121 */             if ((WORLD.MOUNTAIN()).haser.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/* 122 */               res += 0.25D * (WORLD.FOREST()).amount.get(wx, wy); 
/*     */           } 
/* 124 */           return res;
/*     */         }
/*     */       };
/*     */     
/* 128 */     this.NONE = new TERRAIN(ts, "NONE", json, 
/* 129 */         D.g("OpenLand", "Open Land"), 
/* 130 */         D.g("Open Land", "Open land to roam about on."), true)
/*     */       {
/*     */         public SPRITE icon()
/*     */         {
/* 134 */           return (WORLD.GROUND()).icon;
/*     */         }
/*     */ 
/*     */         
/*     */         public double value(int wx, int wy) {
/* 139 */           double res = 1.0D;
/* 140 */           for (int ti = 0; ti < TERRAINS.ALL().size(); ti++) {
/* 141 */             if (ti != index())
/*     */             {
/* 143 */               res -= ((TERRAIN)TERRAINS.ALL().get(ti)).value(wx, wy);
/*     */             }
/*     */           } 
/* 146 */           return CLAMP.d(res, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     
/* 150 */     this.all = (LIST<TERRAIN>)new ArrayList((Iterable)ts);
/* 151 */     KeyMap<TERRAIN> m = new KeyMap();
/* 152 */     for (TERRAIN t : this.all)
/* 153 */       m.put(t.key, t); 
/* 154 */     this.map = new RMAP(key, this.all);
/*     */   }
/*     */   
/* 157 */   public static final MAP_OBJECT<TERRAIN> sett = new MAP_OBJECT<TERRAIN>()
/*     */     {
/*     */       public TERRAIN get(int tile)
/*     */       {
/* 161 */         throw new RuntimeException();
/*     */       }
/*     */ 
/*     */       
/*     */       public TERRAIN get(int tx, int ty) {
/* 166 */         if (!SETT.IN_BOUNDS(tx, ty))
/* 167 */           return TERRAINS.NONE(); 
/* 168 */         if ((SETT.TERRAIN()).TREES.isTree(tx, ty))
/* 169 */           return TERRAINS.FOREST(); 
/* 170 */         if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty))
/* 171 */           return TERRAINS.MOUNTAIN(); 
/* 172 */         if ((SETT.TERRAIN()).WATER.SHALLOW.is(tx, ty) && (SETT.GROUND()).types.SAND.is(tx, ty))
/* 173 */           return TERRAINS.OCEAN(); 
/* 174 */         if ((SETT.TERRAIN()).WATER.SHALLOW.is(tx, ty))
/* 175 */           return TERRAINS.WET(); 
/* 176 */         return TERRAINS.NONE();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 181 */   public static final MAP_OBJECT<TERRAIN> world = new MAP_OBJECT<TERRAIN>()
/*     */     {
/*     */       public TERRAIN get(int tile)
/*     */       {
/* 185 */         throw new RuntimeException();
/*     */       }
/*     */ 
/*     */       
/*     */       public TERRAIN get(int tx, int ty) {
/* 190 */         if (!WORLD.IN_BOUNDS(tx, ty))
/* 191 */           return TERRAINS.NONE(); 
/* 192 */         if (WORLD.MOUNTAIN().is(tx, ty))
/* 193 */           return TERRAINS.MOUNTAIN(); 
/* 194 */         if ((WORLD.WATER()).OCEAN.is.is(tx, ty))
/* 195 */           return TERRAINS.OCEAN(); 
/* 196 */         if ((WORLD.WATER()).fertile.is(tx, ty))
/* 197 */           return TERRAINS.WET(); 
/* 198 */         if ((WORLD.FOREST()).is.is(tx, ty))
/* 199 */           return TERRAINS.FOREST(); 
/* 200 */         return TERRAINS.NONE();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public static LIST<TERRAIN> ALL() {
/* 206 */     return self.all;
/*     */   }
/*     */   
/*     */   public static RMAP<TERRAIN> MAP() {
/* 210 */     return self.map;
/*     */   }
/*     */   
/*     */   public static TERRAIN OCEAN() {
/* 214 */     return self.OCEAN;
/*     */   }
/*     */   
/*     */   public static TERRAIN WET() {
/* 218 */     return self.WET;
/*     */   }
/*     */   public static TERRAIN MOUNTAIN() {
/* 221 */     return self.MOUNTAIN;
/*     */   }
/*     */   public static TERRAIN FOREST() {
/* 224 */     return self.FOREST;
/*     */   }
/*     */   public static TERRAIN NONE() {
/* 227 */     return self.NONE;
/*     */   }
/*     */   
/*     */   public static INFO INFO() {
/* 231 */     return self.info;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TERRAINS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */