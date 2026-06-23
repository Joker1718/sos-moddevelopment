/*     */ package world.map.landmark;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GeneratorLandmark
/*     */ {
/*  25 */   private final Polymap polly = new Polymap(WORLD.TWIDTH(), WORLD.THEIGHT(), (int)(40.0D * WORLD.TWIDTH() / 250.0D), 1.0D);
/*  26 */   private final WorldLandmark rubbish = WORLD.LANDMARKS().getByIndex(0);
/*     */   
/*  28 */   private final Json json = new Json(PATHS.NAMES().gets("WorldLandmarks"));
/*     */   
/*  30 */   private final Type[] types = new Type[] {
/*  31 */       new Type(this.json, "MOUNTAIN", 40, 1000)
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/*  35 */           return ((WORLD.MOUNTAIN()).heighter.get(tx, ty) > 0 && !(WORLD.WATER()).has.is(tx, ty));
/*     */         }
/*     */       },
/*  38 */       new Type(this.json, "LAKE", 20, 10000)
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/*  42 */           return (WORLD.WATER()).LAKE.is.is(tx, ty);
/*     */         }
/*     */       },
/*  45 */       new Type(this.json, "RIVER", 25, 100)
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/*  49 */           return (WORLD.WATER()).isRivery.is(tx, ty);
/*     */         }
/*     */       },
/*  52 */       new Type(this.json, "OCEAN", 50, 5000)
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/*  56 */           return (WORLD.WATER()).OCEAN.is.is(tx, ty);
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public GeneratorLandmark(ACTION loadprint) {
/*  63 */     loadprint.exe();
/*     */     
/*  65 */     WORLD.LANDMARKS().saver().clear();
/*     */     
/*  67 */     int nr = 1;
/*     */     
/*  69 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  70 */       if (nr >= 255)
/*     */         break; 
/*  72 */       if (assignTerrain(c.x(), c.y(), WORLD.LANDMARKS().getByIndex(nr))) {
/*  73 */         nr++;
/*     */       }
/*     */     } 
/*     */     
/*  77 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  78 */       if ((WORLD.LANDMARKS()).setter.get(c) == this.rubbish) {
/*  79 */         (WORLD.LANDMARKS()).setter.set(c, null);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  84 */     loadprint.exe();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     loadprint.exe();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean assignTerrain(int tx, int ty, WorldLandmark ass) {
/*  95 */     if ((WORLD.LANDMARKS()).setter.get(tx, ty) != null) {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     Type type = type(tx, ty);
/* 100 */     if (type == null) {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     this.polly.checkInit();
/* 105 */     this.polly.checker.set(tx, ty, true);
/*     */ 
/*     */ 
/*     */     
/* 109 */     int minSize = type.minSize;
/* 110 */     int maxSize = type.maxSize;
/*     */ 
/*     */     
/* 113 */     GUTIL.flooder().init(this);
/* 114 */     GUTIL.flooder().pushSloppy(tx, ty, 0.0D);
/* 115 */     int area = 0;
/*     */     
/* 117 */     WorldLandmark neigh = null;
/*     */     
/* 119 */     while (GUTIL.flooder().hasMore()) {
/* 120 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/* 122 */       (WORLD.LANDMARKS()).setter.set((COORDINATE)t, ass);
/*     */ 
/*     */ 
/*     */       
/* 126 */       area++;
/*     */       
/* 128 */       if (area > maxSize) {
/*     */         break;
/*     */       }
/*     */       
/* 132 */       for (DIR d : DIR.ORTHO) {
/* 133 */         int dx = t.x() + d.x();
/* 134 */         int dy = t.y() + d.y();
/* 135 */         if (!WORLD.TBOUNDS().holdsPoint(dx, dy) || 
/* 136 */           !type.is(dx, dy)) {
/*     */           continue;
/*     */         }
/* 139 */         WorldLandmark kuk = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(dx, dy);
/* 140 */         if (kuk != null) {
/* 141 */           if (kuk != this.rubbish && kuk != ass) {
/* 142 */             neigh = kuk;
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 147 */         double q = t.getValue() + d.tileDistance();
/* 148 */         double dd = this.polly.checker.is((COORDINATE)t, d) ? q : (q + 100.0D);
/* 149 */         this.polly.checker.set((COORDINATE)t, true);
/* 150 */         GUTIL.flooder().pushSmaller((COORDINATE)t, d, dd);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 156 */     GUTIL.flooder().done();
/*     */     
/* 158 */     if (area < minSize) {
/* 159 */       if (neigh != null) {
/* 160 */         assign(tx, ty, ass, neigh);
/*     */       } else {
/* 162 */         assign(tx, ty, ass, this.rubbish);
/*     */       } 
/* 164 */       return false;
/*     */     } 
/*     */     
/* 167 */     type.init(ass);
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void assign(int tx, int ty, WorldLandmark old, WorldLandmark newa) {
/* 174 */     GUTIL.flooder().init(this);
/*     */     
/* 176 */     GUTIL.flooder().pushSloppy(tx, ty, 0.0D);
/*     */ 
/*     */     
/* 179 */     while (GUTIL.flooder().hasMore()) {
/* 180 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 181 */       if ((WORLD.LANDMARKS()).setter.get((COORDINATE)t) != old)
/*     */         continue; 
/* 183 */       (WORLD.LANDMARKS()).setter.set((COORDINATE)t, newa);
/* 184 */       for (DIR d : DIR.ORTHO) {
/* 185 */         if (WORLD.TBOUNDS().holdsPoint((COORDINATE)t, d)) {
/* 186 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 191 */     GUTIL.flooder().done(); } public Type type(int tx, int ty) {
/*     */     byte b;
/*     */     int i;
/*     */     Type[] arrayOfType;
/* 195 */     for (i = (arrayOfType = this.types).length, b = 0; b < i; ) { Type t = arrayOfType[b];
/* 196 */       if (t.is(tx, ty))
/* 197 */         return t;  b++; }
/* 198 */      return null;
/*     */   }
/*     */   
/*     */   private static abstract class Type
/*     */     implements MAP_BOOLEAN
/*     */   {
/*     */     private final String[] names;
/*     */     private final String[] addons;
/* 206 */     private int nameI = 0;
/*     */     private final Json[] specials;
/* 208 */     private int sI = 0;
/*     */     private int minSize;
/*     */     private int maxSize;
/*     */     
/*     */     Type(Json json, String key, int min, int max) {
/* 213 */       json = json.json(key);
/* 214 */       this.minSize = min;
/* 215 */       this.maxSize = max;
/* 216 */       this.names = json.texts("NAMES"); int i;
/* 217 */       for (i = 0; i < this.names.length; i++) {
/* 218 */         int k = RND.rInt(this.names.length);
/* 219 */         String o = this.names[i];
/* 220 */         this.names[i] = this.names[k];
/* 221 */         this.names[k] = o;
/*     */       } 
/* 223 */       this.addons = json.texts("ADDONS");
/* 224 */       this.specials = json.jsons("SPECIAL");
/*     */       
/* 226 */       for (i = 0; i < this.specials.length; i++) {
/* 227 */         int k = RND.rInt(this.specials.length);
/* 228 */         Json o = this.specials[i];
/* 229 */         this.specials[i] = this.specials[k];
/* 230 */         this.specials[k] = o;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tile) {
/* 236 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void init(WorldLandmark l) {
/* 242 */       if (this.sI < this.specials.length) {
/* 243 */         l.name.clear().add(this.specials[this.sI].text("NAME"));
/* 244 */         l.description.clear().add(this.specials[this.sI].text("LORE"));
/* 245 */         if (l.description.length() > 1024)
/* 246 */           this.specials[this.sI].error("Lore is too long...", "LORE"); 
/* 247 */         this.sI++;
/*     */       }
/* 249 */       else if (this.names.length == 0) {
/* 250 */         l.name.clear().add(l.index);
/*     */       } else {
/* 252 */         if (this.addons.length > 0) {
/* 253 */           l.name.clear().add(this.addons[RND.rInt(this.addons.length)]);
/* 254 */           l.name.insert(0, this.names[this.nameI++]);
/*     */         } else {
/* 256 */           l.name.clear().add(this.names[this.nameI++]);
/* 257 */         }  if (this.nameI >= this.names.length)
/* 258 */           this.nameI = 0; 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\GeneratorLandmark.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */