/*     */ package settlement.room.law.stockade;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.placement.UtilWallPlacability;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher {
/*  38 */   private static CharSequence ¤¤Problem = "Must be facing the edge of the room.";
/*  39 */   private static CharSequence ¤¤Problem3 = "Will be blocked by walls."; private ROOM_STOCKADE blue;
/*     */   static {
/*  41 */     D.ts(Constructor.class);
/*     */   }
/*     */ 
/*     */   
/*  45 */   final FurnisherStat workers = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  49 */         return 0.1D * Constructor.this.prisoners.get(area, fromItems);
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  54 */         return GFORMAT.f(t, value, 1);
/*     */       }
/*     */     };
/*     */   
/*  58 */   final FurnisherStat prisoners = new FurnisherStat(this, 1.0D)
/*     */     {
/*     */       
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  63 */         double f = 0.0D;
/*  64 */         for (COORDINATE c : area.body()) {
/*  65 */           DIR d; if (!area.is(c))
/*     */             continue; 
/*  67 */           Iterator<DIR> iterator = DIR.ALL.iterator(); do { if (!iterator.hasNext())
/*     */             
/*     */             { 
/*     */ 
/*     */               
/*  72 */               f++; break; }  d = iterator.next(); }
/*     */           while (area.is(c, d));
/*  74 */         }  return f * 0.25D;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  79 */         return GFORMAT.f(t, value, 1);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private final FurnisherItemTile oo;
/*     */   
/*     */   private final RoomSprite fence;
/*     */   
/*     */   private final RoomSprite fenceDia;
/*     */   
/*     */   private final RoomSprite sFood;
/*     */   private final RoomSprite sShit;
/*     */   private final RoomSprite sStand;
/*     */   
/*     */   protected Constructor(final ROOM_STOCKADE blue, RoomInitData init) throws IOException {
/*  95 */     super(init, 1, 2);
/*  96 */     this.blue = blue;
/*     */     
/*  98 */     Json js = init.data().json("SPRITES");
/*     */     
/* 100 */     this.fence = (RoomSprite)new RoomSprite1x1(js, "WALL_1X1");
/* 101 */     this.fenceDia = (RoomSprite)new RoomSprite1x1(js, "WALL_CORNER_1X1");
/*     */     
/* 103 */     RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(js, "OPENING_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 107 */           tx -= d.x();
/* 108 */           ty -= d.y();
/* 109 */           ROOMA aa = (ROOMA)(SETT.ROOMS()).map.rooma.get(tx, ty);
/* 110 */           return (aa != null && !aa.is(tx, ty, d));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 116 */           DIR d = rot(data);
/* 117 */           d = d.perpendicular();
/* 118 */           it.setOff(12 * d.x(), 12 * d.y());
/* 119 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 124 */     this.oo = new FurnisherItemTile(this, (RoomSprite)roomSprite1x1, AVAILABILITY.ROOM, false)
/*     */       {
/*     */         public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry)
/*     */         {
/* 128 */           if ((SETT.ROOMS()).placement.embryo.is(tx, ty) && 
/* 129 */             (SETT.ROOMS()).placement.placer.autoWalls.is()) {
/* 130 */             for (DIR d : DIR.ORTHO) {
/* 131 */               if (it.get(rx, ry, d) == null && UtilWallPlacability.wallCanBe.is(tx, ty, d) && (SETT.ROOMS()).placement.placer.placerDoor.isPlacable(tx + d.x(), ty + d.y(), null, null) == null) {
/* 132 */                 return Constructor.¤¤Problem3;
/*     */               }
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 139 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 140 */             DIR dd = (DIR)DIR.ORTHO.get(di);
/* 141 */             if (!roomIs.is(tx, ty, dd) && !(SETT.PATH()).solidity.is(tx, ty, dd) && 
/* 142 */               roomIs.is(tx, ty, dd.next(2)) && !roomIs.is(tx, ty, dd.next(1)) && 
/* 143 */               roomIs.is(tx, ty, dd.next(-2)) && !roomIs.is(tx, ty, dd.next(-1))) {
/* 144 */               return null;
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 150 */           return Constructor.¤¤Problem;
/*     */         }
/*     */       };
/*     */     
/* 154 */     this.sFood = (RoomSprite)new RoomSprite1x1(js, "FOOD_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 159 */           if (blue.is(it.tile()) && blue.job.food(it.tx(), it.ty()) > 0)
/* 160 */             return super.render(r, s, data, it, degrade, isCandle); 
/* 161 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 166 */     this.sShit = (RoomSprite)new RoomSprite1x1(js, "LATRINE_EMPTY_1X1", js)
/*     */       {
/*     */         final RoomSprite1x1 full;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 173 */           if (blue.is(it.tile()) && blue.job.shit(it.tx(), it.ty()) > 0)
/* 174 */             return this.full.render(r, s, data, it, degrade, isCandle); 
/* 175 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 180 */     this.sStand = (RoomSprite)new RoomSprite1x1(js, "MISC_1X1");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 198 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 203 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_STOCKADE blue() {
/* 208 */     return this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderEmbryo(SPRITE_RENDERER r, int mask, RenderData.RenderIterator it, boolean isFloored, AREA area, boolean active) {
/* 214 */     if (active) {
/* 215 */       (GCOLOR.MAP()).BETTER.bind();
/*     */     }
/*     */     
/* 218 */     Room room = (SETT.ROOMS()).map.get(it.tile());
/*     */     
/* 220 */     if (isFloored) {
/* 221 */       COLOR.unbind();
/* 222 */       renderFence(r, ShadowBatch.DUMMY, it, 1.0D, false);
/*     */       
/*     */       return;
/*     */     } 
/* 226 */     if (mask != 15) {
/* 227 */       (SPRITES.cons()).BIG.filled.render(r, mask, it.x(), it.y());
/*     */       return;
/*     */     } 
/* 230 */     for (DIR d : DIR.NORTHO) {
/* 231 */       if (!room.isSame(it.tx(), it.ty(), it.tx() + d.x(), it.ty() + d.y())) {
/* 232 */         (SPRITES.cons()).BIG.filled.render(r, 15, it.x(), it.y());
/*     */         return;
/*     */       } 
/*     */     } 
/* 236 */     (GCOLOR.MAP()).BETTER.bind();
/* 237 */     super.renderEmbryo(r, mask, it, isFloored, area, active);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/* 242 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 247 */     GUTIL.coos().set(0);
/* 248 */     for (COORDINATE c : area.body()) {
/* 249 */       if (area.is(c) && !isFence((ROOMA)area, c.x(), c.y()) && (SETT.ROOMS()).fData.item.get(c) == null) {
/* 250 */         GUTIL.coos().get().set(c);
/* 251 */         GUTIL.coos().inc();
/*     */       } 
/*     */     } 
/*     */     
/* 255 */     int am = GUTIL.coos().getI();
/* 256 */     am = (int)Math.ceil(am / 5.0D);
/* 257 */     GUTIL.coos().shuffle(GUTIL.coos().getI());
/*     */     
/* 259 */     GUTIL.coos().set(0);
/*     */ 
/*     */     
/* 262 */     int a = (int)Math.ceil(am * 0.25D); int i;
/* 263 */     for (i = 0; i < a; i++) {
/* 264 */       (SETT.ROOMS()).data.set((ROOMA)area, (COORDINATE)GUTIL.coos().get(), 2);
/* 265 */       GUTIL.coos().inc();
/*     */     } 
/*     */ 
/*     */     
/* 269 */     a = (int)Math.ceil(am * 0.25D);
/* 270 */     for (i = 0; i < a; i++) {
/* 271 */       (SETT.ROOMS()).data.set((ROOMA)area, (COORDINATE)GUTIL.coos().get(), 3);
/* 272 */       GUTIL.coos().inc();
/*     */     } 
/*     */ 
/*     */     
/* 276 */     a = (int)Math.ceil(am * 0.5D);
/* 277 */     for (i = 0; i < a; i++) {
/* 278 */       (SETT.ROOMS()).data.set((ROOMA)area, (COORDINATE)GUTIL.coos().get(), 1);
/* 279 */       GUTIL.coos().inc();
/*     */     } 
/*     */     
/* 282 */     return (Room)new StockInstance(this.blue, area, init);
/*     */   }
/*     */   
/* 285 */   private static CharSequence ¤¤TooThin = "¤Area is too thin at places. Expand the area to at least 3x3.";
/*     */   
/*     */   static {
/* 288 */     D.ts(Constructor.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence constructionProblem(AREA area) {
/* 293 */     for (COORDINATE c : area.body()) {
/* 294 */       if (area.is(c)) {
/* 295 */         boolean ok = false;
/* 296 */         for (DIR d : DIR.ALL) {
/* 297 */           if (isFull(c.x(), c.y(), area, d)) {
/* 298 */             ok = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 302 */         if (!ok) {
/* 303 */           GUTIL.filler().done();
/* 304 */           return ¤¤TooThin;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 311 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isFull(int x, int y, AREA a, DIR d) {
/* 316 */     int tx = x + d.x();
/* 317 */     int ty = y + d.y();
/* 318 */     if (!a.is(tx, ty))
/* 319 */       return false; 
/* 320 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 321 */       DIR dd = (DIR)DIR.ALL.get(i);
/* 322 */       if (!a.is(tx, ty, dd))
/* 323 */         return false; 
/*     */     } 
/* 325 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTileBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, boolean floored) {
/* 330 */     if (floored) {
/* 331 */       renderFence(r, s, it, 0.0D, false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 338 */     super.putFloor(tx, ty, upgrade, area);
/*     */   }
/*     */   
/*     */   public boolean isFence(ROOMA ii, int tx, int ty) {
/* 342 */     if (!ii.is(tx, ty))
/* 343 */       return false; 
/* 344 */     if ((SETT.ROOMS()).fData.tile.get(tx, ty) != null)
/* 345 */       return false; 
/* 346 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 347 */       if (!ii.is(tx, ty, (DIR)DIR.ALL.get(di)))
/* 348 */         return true; 
/*     */     } 
/* 350 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderFence(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, double degrade, boolean exists) {
/* 356 */     if (exists) {
/* 357 */       int i = this.blue.job.type(it.tx(), it.ty());
/* 358 */       if (i == 2) {
/* 359 */         this.sFood.render(r, s, it.ran(), it, degrade, false);
/*     */         return;
/*     */       } 
/* 362 */       if (i == 3) {
/* 363 */         this.sShit.render(r, s, it.ran(), it, degrade, false);
/*     */         return;
/*     */       } 
/* 366 */       if (i == 1) {
/* 367 */         this.sStand.render(r, s, it.ran(), it, degrade, false);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 373 */     ROOMA ii = (ROOMA)(SETT.ROOMS()).map.rooma.get(it.tx(), it.ty());
/* 374 */     if (ii == null)
/*     */       return; 
/* 376 */     if (!isFence(ii, it.tx(), it.ty()))
/*     */       return;  int di;
/* 378 */     for (di = 0; di < DIR.ORTHO.size(); di++) {
/* 379 */       if (!ii.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(di))) {
/* 380 */         this.fence.render(r, s, di, it, degrade, false);
/*     */       }
/*     */     } 
/*     */     
/* 384 */     for (di = 0; di < DIR.NORTHO.size(); di++) {
/* 385 */       if (!ii.is(it.tx(), it.ty(), (DIR)DIR.NORTHO.get(di)))
/* 386 */         if (ii.is(it.tx(), it.ty(), ((DIR)DIR.NORTHO.get(di)).next(-1)) == ii.is(it.tx(), it.ty(), ((DIR)DIR.NORTHO.get(di)).next(1))) {
/* 387 */           this.fenceDia.render(r, s, di, it, degrade, false);
/* 388 */         } else if ((SETT.ROOMS()).fData.tile.get(it.tx(), it.ty(), ((DIR)DIR.NORTHO.get(di)).next(1)) != null || (SETT.ROOMS()).fData.tile.get(it.tx(), it.ty(), ((DIR)DIR.NORTHO.get(di)).next(-1)) != null) {
/* 389 */           this.fenceDia.render(r, s, di, it, degrade, false);
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */