/*     */ package world.map.regions;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.paths.PATHS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ import world.map.terrain.WorldGround;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GenName
/*     */ {
/*  19 */   private final Json jland = new Json(PATHS.NAMES().gets("WorldAreas"));
/*  20 */   private final LandCounter cMisc = new LandCounter(this, this.jland.texts("MISC"), 0.2D)
/*     */     {
/*     */       boolean count(int tx, int ty) {
/*  23 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  28 */   private final CharSequence[] sIslands = (CharSequence[])this.jland.texts("ISLAND_ADDONS");
/*     */   
/*  30 */   private final LandCounter[] counts = new LandCounter[] {
/*  31 */       new LandCounter(this, this.jland.texts("MOUNTAIN"), 0.2D)
/*     */       {
/*     */         boolean count(int tx, int ty) {
/*  34 */           return WORLD.MOUNTAIN().is(tx, ty);
/*     */         }
/*     */       },
/*  37 */       new LandCounter(this, this.jland.texts("FOREST"), 0.4D)
/*     */       {
/*     */         boolean count(int tx, int ty) {
/*  40 */           return (WORLD.FOREST()).is.is(tx, ty);
/*     */         }
/*     */       },
/*  43 */       new LandCounter(this, this.jland.texts("RIVER"), 0.1D)
/*     */       {
/*     */         boolean count(int tx, int ty) {
/*  46 */           return (WORLD.WATER()).isRivery.is(tx, ty);
/*     */         }
/*     */       },
/*  49 */       new LandCounter(this, this.jland.texts("OCEAN"), 0.15D)
/*     */       {
/*     */         boolean count(int tx, int ty) {
/*  52 */           return (WORLD.WATER()).OCEAN.normal.is(tx, ty);
/*     */         }
/*     */       },
/*  55 */       new LandCounter(this, this.jland.texts("LAKE"), 0.15D)
/*     */       {
/*     */         boolean count(int tx, int ty) {
/*  58 */           return (WORLD.WATER()).LAKE.normal.is(tx, ty);
/*     */         }
/*     */       },
/*  61 */       new LandCounter(this, this.jland.texts("STEPPE"), 0.6D)
/*     */       {
/*     */         boolean count(int tx, int ty) {
/*  64 */           return (ty < WORLD.THEIGHT() / 2 && ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(tx, ty)).moisture() < 0.2D);
/*     */         }
/*     */       },
/*  67 */       new LandCounter(this, this.jland.texts("DESERT"), 0.6D)
/*     */       {
/*     */         boolean count(int tx, int ty) {
/*  70 */           return (ty > WORLD.THEIGHT() / 2 && ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(tx, ty)).moisture() < 0.2D);
/*     */         }
/*     */       }
/*     */     };
/*     */   
/*     */   public GenName() {
/*  76 */     for (int ri = 1; ri < 1023; ri++) {
/*  77 */       Region reg = WORLD.REGIONS().getByIndex(ri);
/*  78 */       init(reg);
/*     */     } 
/*  80 */     (WORLD.REGIONS()).player.info.name().clear().add((CharSequence)(FACTIONS.player()).name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init(Region r) {
/*  86 */     if (r == null || r.info.area() == 0)
/*     */       return;  byte b; int i;
/*     */     LandCounter[] arrayOfLandCounter1;
/*  89 */     for (i = (arrayOfLandCounter1 = this.counts).length, b = 0; b < i; ) { LandCounter c = arrayOfLandCounter1[b];
/*  90 */       c.count = 0;
/*  91 */       c.value = 0.0D;
/*     */       b++; }
/*     */     
/*  94 */     for (COORDINATE coo : r.info.bounds()) {
/*  95 */       if (!(WORLD.REGIONS()).map.is(coo, r))
/*     */         continue;  byte b1; int k; LandCounter[] arrayOfLandCounter;
/*  97 */       for (k = (arrayOfLandCounter = this.counts).length, b1 = 0; b1 < k; ) { LandCounter c = arrayOfLandCounter[b1];
/*  98 */         if (c.count(coo.x(), coo.y()))
/*  99 */           c.count++; 
/*     */         b1++; }
/*     */     
/*     */     } 
/* 103 */     LandCounter bestFit = this.cMisc;
/*     */     LandCounter[] arrayOfLandCounter2;
/* 105 */     for (int j = (arrayOfLandCounter2 = this.counts).length; i < j; ) { LandCounter c = arrayOfLandCounter2[i];
/* 106 */       c.value = c.count / r.info.area();
/* 107 */       c.value /= c.treshold;
/* 108 */       if (c.value > 1.0D && c.value > bestFit.value)
/* 109 */         bestFit = c; 
/*     */       i++; }
/*     */     
/* 112 */     if (isIsland(r)) {
/* 113 */       r.info.name().clear().add(this.sIslands[RND.rInt(this.sIslands.length)]);
/* 114 */       r.info.name().insert(0, bestFit.getName());
/*     */     } else {
/* 116 */       r.info.name().clear().add(bestFit.getName());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isIsland(Region r) {
/* 122 */     for (COORDINATE c : r.info.bounds()) {
/* 123 */       if (!(WORLD.REGIONS()).map.is(c, r))
/*     */         continue; 
/* 125 */       for (DIR d : DIR.ORTHO) {
/* 126 */         if (!(WORLD.REGIONS()).map.is(c, d, r) && !(WORLD.WATER()).has.is(c))
/* 127 */           return false; 
/*     */       } 
/*     */     } 
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   abstract class LandCounter
/*     */   {
/*     */     private final String[] names;
/* 136 */     private int nameI = 0; private double treshold;
/*     */     private double value;
/*     */     int count;
/*     */     
/*     */     LandCounter(String[] names, double treshold) {
/* 141 */       for (int i = 0; i < names.length; i++) {
/* 142 */         String old = names[i];
/* 143 */         int k = RND.rInt(names.length);
/* 144 */         names[i] = names[k];
/* 145 */         names[k] = old;
/*     */       } 
/*     */       
/* 148 */       this.names = names;
/* 149 */       this.treshold = treshold;
/*     */     }
/*     */     
/*     */     String getName() {
/* 153 */       int i = this.nameI;
/* 154 */       this.nameI++;
/* 155 */       if (this.nameI >= this.names.length)
/* 156 */         this.nameI = 0; 
/* 157 */       return this.names[i];
/*     */     }
/*     */     
/*     */     abstract boolean count(int param1Int1, int param1Int2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenName.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */