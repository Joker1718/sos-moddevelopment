/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.tilemap.TileMap;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
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
/*     */ public final class TGrowth
/*     */   extends TileMap.Resource
/*     */ {
/*  44 */   private final byte[] data = Alloc.bb(SETT.TAREA);
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
/*     */   public final LIST<Grower> all;
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
/*     */   public final LIST<Grower> growable;
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
/*     */   public final Grower nothing;
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
/*     */   public final Grower tree;
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
/*     */   public final Grower flower;
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
/*     */   public final Grower bush;
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
/*     */   public final Grower mushroom;
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
/*     */   private boolean growing = false;
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
/*     */   private final MAP_INTE type;
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
/*     */   public final MAP_DOUBLEE max_amount;
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
/*     */   public boolean tear(int tx, int ty) {
/* 257 */     Grower g = current(tx, ty);
/* 258 */     if (g != null && g != this.tree) {
/* 259 */       g.grow(tx, ty, -1.0D);
/* 260 */     } else if ((SETT.GRASS()).currentI.get(tx, ty) > 0) {
/* 261 */       (SETT.GRASS()).currentI.increment(tx, ty, -1);
/* 262 */       return true;
/*     */     } 
/* 264 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double growMaxAmount(int tx, int ty, Grower g) {
/* 269 */     double f = ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).vegitation;
/*     */     
/* 271 */     if (g == this.tree && (SETT.GROUND()).types.FOREST.is(tx, ty)) {
/* 272 */       f *= 0.65D + 0.35D * (SETT.GROUND()).MOISTURE_CURRENT.get(tx, ty);
/*     */     } else {
/* 274 */       f *= (SETT.GROUND()).MOISTURE_CURRENT.get(tx, ty);
/* 275 */     }  f = CLAMP.d(f, 0.0D, 1.0D);
/*     */     
/* 277 */     double am = this.max_amount.get(tx, ty);
/* 278 */     am -= 1.0D - f;
/*     */     
/* 280 */     return CLAMP.d(am, -1.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public void updateTileDay(int tx, int ty, int now) {
/* 284 */     SETT.GROUND().adjust(now, tx, ty);
/*     */ 
/*     */     
/* 287 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 288 */     if (room != null) {
/* 289 */       if (!(SETT.ROOMS()).construction.isser.is(tx, ty) && room.constructor() != null && room.constructor().growsGrass(tx, ty)) {
/* 290 */         SETT.GRASS().grow(tx, ty, now);
/*     */       }
/*     */       return;
/*     */     } 
/* 294 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 295 */     if (t.clearing().isStructure() && !t.roofIs() && !(SETT.TERRAIN().get(tx, ty) instanceof settlement.tilemap.terrain.TFence.TFenceTile))
/*     */       return; 
/* 297 */     if ((SETT.JOBS()).getter.is(tx, ty) && ((Job)(SETT.JOBS()).getter.get(tx, ty)).jobReservedIs(((Job)(SETT.JOBS()).getter.get(tx, ty)).resourceCurrentlyNeeded()))
/*     */       return; 
/* 299 */     if ((SETT.FLOOR()).getter.is(tx, ty)) {
/*     */       return;
/*     */     }
/*     */     
/* 303 */     SETT.GRASS().grow(tx, ty);
/*     */ 
/*     */     
/* 306 */     if (!this.growing) {
/*     */       return;
/*     */     }
/* 309 */     Grower g = (Grower)this.all.get(this.type.get(now));
/* 310 */     if (g == this.nothing) {
/*     */       return;
/*     */     }
/* 313 */     double m = growMaxAmount(tx, ty, g);
/*     */     
/* 315 */     g.grow(tx, ty, m);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/* 320 */     this.growing = ((SETT.WEATHER()).growth.getD() * (SETT.WEATHER()).moisture.getD() * 4.0D > 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 325 */     saveFile.bs(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/* 330 */     saveFile.bs(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearAll() {
/* 335 */     Arrays.fill(this.data, (byte)0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double currentAmount(int tx, int ty) {
/* 344 */     double am = this.max_amount.get(tx, ty);
/* 345 */     am *= (SETT.GROUND()).MOISTURE_CURRENT.get(tx, ty);
/* 346 */     am *= ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).vegitation;
/*     */     
/* 348 */     am *= 2.0D;
/* 349 */     am -= (GUTIL.ran2().get(tx, ty) & 0xFFFF) / 65535.0D;
/*     */     
/* 351 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public Grower current(int tx, int ty) {
/* 356 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 357 */     if (t instanceof TGrowable)
/* 358 */       return (Grower)this.growable.get(((TGrowable)t).growable.index()); 
/* 359 */     if (t instanceof settlement.tilemap.terrain.TForest.Tree)
/* 360 */       return this.tree; 
/* 361 */     if (t instanceof settlement.tilemap.terrain.TBush)
/* 362 */       return this.bush; 
/* 363 */     if (t instanceof settlement.tilemap.terrain.TFlower)
/* 364 */       return this.flower; 
/* 365 */     if (t instanceof settlement.tilemap.terrain.TMushroom) {
/* 366 */       return this.mushroom;
/*     */     }
/* 368 */     return this.nothing;
/*     */   }
/*     */   
/*     */   public Grower type(int tx, int ty) {
/* 372 */     return (Grower)this.all.get(this.type.get(tx, ty));
/*     */   }
/*     */   
/* 375 */   public TGrowth(Terrain topology) { this.type = (MAP_INTE)new MAP_INTE.INT_MAPEImp(SETT.TWIDTH, SETT.THEIGHT)
/*     */       {
/* 377 */         private final Bits bits = new Bits(31);
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 381 */           return this.bits.get(TGrowth.this.data[tile]);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 386 */           TGrowth.this.data[tile] = (byte)this.bits.set(TGrowth.this.data[tile], value);
/* 387 */           return (MAP_INTE)this;
/*     */         }
/*     */       };
/*     */     
/* 391 */     this.max_amount = new MAP_DOUBLEE()
/*     */       {
/* 393 */         private final double di = 0.125D;
/* 394 */         private final Bits bits = new Bits(224);
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 398 */           return (1 + this.bits.get(TGrowth.this.data[tile])) * 0.125D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tx, int ty) {
/* 403 */           return get(tx + ty * SETT.TWIDTH);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 408 */           int i = (int)Math.round(value * 8.0D);
/* 409 */           i--;
/* 410 */           i = CLAMP.i(i, 0, 7);
/* 411 */           TGrowth.this.data[tile] = (byte)this.bits.set(TGrowth.this.data[tile], i);
/* 412 */           return this; } void grow(int tx, int ty, double max) {} public double currentAmount(int tx, int ty) { return 0.0D; } public void setRoots(int tx, int ty, double amount) {}
/*     */       }; this.tree = new Grower((LISTE)all) { public void setRoots(int tx, int ty, double am) { if (am > 0.2D) { (SETT.TERRAIN()).TREES.SMALL.placeRaw(tx, ty); (SETT.TERRAIN()).TREES.amount.DM.set(tx, ty, am); } else if (am > 0.0D) { (SETT.TERRAIN()).BUSH.placeFixed(tx, ty); }  } public double currentAmount(int tx, int ty) { return 0.8D + RND.rFloat() * 0.2D; } void grow(int tx, int ty, double max) { if (max <= 0.0D) { if ((SETT.TERRAIN()).TREES.isTree(tx, ty)) { (SETT.TERRAIN()).TREES.amount.increment(tx, ty, -1); if ((SETT.TERRAIN()).NADA.is(tx, ty)) (SETT.TERRAIN()).BUSH.placeFixed(tx, ty);  } else if ((SETT.TERRAIN()).BUSH.is(tx, ty) && RND.oneIn(4)) { if (RND.oneIn(8)) { (SETT.TERRAIN()).DECOR_WOOD.placeFixed(tx, ty); } else { (SETT.TERRAIN()).NADA.placeFixed(tx, ty); }  }  } else if ((SETT.TERRAIN()).TREES.isTree(tx, ty)) { if (RND.oneIn(16)) (SETT.TERRAIN()).TREES.amount.increment(tx, ty, 1);  } else if ((SETT.TERRAIN()).BUSH.is(tx, ty)) { if (max > 0.2D && RND.oneIn(48)) { (SETT.TERRAIN()).TREES.SMALL.placeFixed(tx, ty); (SETT.TERRAIN()).TREES.amount.set(tx, ty, 1); }  } else if (SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) { (SETT.TERRAIN()).BUSH.placeFixed(tx, ty); }  } }
/*     */       ; this.flower = new Grower((LISTE)all) {
/*     */         public void setRoots(int tx, int ty, double am) { if (am <= 0.0D) { (SETT.TERRAIN()).NADA.placeRaw(tx, ty); } else { (SETT.TERRAIN()).FLOWER.placeRaw(tx, ty); (SETT.TERRAIN()).FLOWER.amount.set(tx, ty, 1 + (int)(am * ((SETT.TERRAIN()).FLOWER.amount.max - 1))); }  } public double currentAmount(int tx, int ty) { return (SETT.TERRAIN()).FLOWER.amount.DM.get(tx, ty); } void grow(int tx, int ty, double max) { double d = (SETT.TERRAIN()).FLOWER.amount.DM.get(tx, ty); if (max < d) { if ((SETT.TERRAIN()).FLOWER.is(tx, ty)) (SETT.TERRAIN()).FLOWER.amount.increment(tx, ty, -1);  } else if (max > d) { if ((SETT.TERRAIN()).NADA.is(tx, ty)) { if (RND.oneIn(12)) (SETT.TERRAIN()).FLOWER.amount.increment(tx, ty, 1);  } else if (SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) { (SETT.TERRAIN()).FLOWER.amount.increment(tx, ty, 1); }  }  }
/*     */       }; LinkedList<Grower> all = new LinkedList(); this.nothing = new Grower((LISTE)all) {
/* 417 */         public MAP_DOUBLEE set(int tx, int ty, double value) { return set(tx + ty * SETT.TWIDTH, value); }
/*     */       }; this.bush = new Grower((LISTE)all) {
/*     */         public void setRoots(int tx, int ty, double am) { if (am > 0.0D) (SETT.TERRAIN()).BUSH.placeRaw(tx, ty);  } public double currentAmount(int tx, int ty) { return 0.8D + RND.rFloat() * 0.2D; } void grow(int tx, int ty, double max) { if (max < 0.0D && (SETT.TERRAIN()).BUSH.is(tx, ty) && RND.oneIn(4)) { (SETT.TERRAIN()).NADA.placeFixed(tx, ty); } else if (max > 0.0D && SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared() && RND.oneIn(8)) { (SETT.TERRAIN()).BUSH.placeFixed(tx, ty); }  }
/*     */       }; this.mushroom = new Grower((LISTE)all) {
/*     */         public void setRoots(int tx, int ty, double am) { if (am > 0.0D) (SETT.TERRAIN()).MUSHROOM.placeRaw(tx, ty);  } public double currentAmount(int tx, int ty) { return 0.8D + RND.rFloat() * 0.2D; } void grow(int tx, int ty, double max) { if (max < 0.0D && (SETT.TERRAIN()).MUSHROOM.is(tx, ty)) { (SETT.TERRAIN()).NADA.placeFixed(tx, ty); } else if (max > 0.0D && SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared() && RND.oneIn(4)) { (SETT.TERRAIN()).MUSHROOM.placeFixed(tx, ty); }  }
/*     */       }; LinkedList<Grower> gg = new LinkedList(); for (TGrowable g : topology.GROWABLES) { gg.add(new Grower((LISTE)all) {
/*     */             void grow(int tx, int ty, double max) { if (max <= 0.0D) return;  if ((SETT.TERRAIN()).NADA.is(tx, ty) && RND.oneIn(16)) { g.placeFixed(tx, ty); } else if (g.is(tx, ty) && RND.oneIn(2)) { int s = g.size.get(tx, ty); if (TGrowth.this.max_amount.get(tx, ty) > s) g.size.increment(tx, ty, 1);  if (!(SETT.WEATHER()).growthRipe.cropsAreRipe()) { int am = g.resource.get(tx, ty); if (am < s) { am += 1 + (RND.oneIn(s) ? 0 : 1); g.resource.set(tx, ty, am); }  }  }  } public double currentAmount(int tx, int ty) { return g.size.DM.get(tx, ty); } public void setRoots(int tx, int ty, double amount) { int am = CLAMP.i((int)(g.size.max * amount), 1, g.size.max); g.placeRaw(tx, ty); g.size.set(tx, ty, am); }
/*     */           }); }  this.growable = (LIST<Grower>)new ArrayList((Iterable)gg); this.all = (LIST<Grower>)new ArrayList((Iterable)all); } public static abstract class Grower
/*     */   {
/* 426 */     Grower(LISTE<Grower> all) { this.index = all.add(this); }
/*     */     
/*     */     protected final int index;
/*     */     
/*     */     abstract void grow(int param1Int1, int param1Int2, double param1Double);
/*     */     
/*     */     public abstract double currentAmount(int param1Int1, int param1Int2);
/*     */     
/*     */     public abstract void setRoots(int param1Int1, int param1Int2, double param1Double);
/*     */     
/*     */     public final void set(int tx, int ty, double maxAm) {
/* 437 */       (SETT.TILE_MAP()).growth.type.set(tx, ty, this.index);
/* 438 */       (SETT.TILE_MAP()).growth.max_amount.set(tx, ty, maxAm);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\TGrowth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */