/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UICons;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.text.D;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PlacerDoor
/*     */ {
/*     */   protected final Room.RoomInstanceImp a;
/*     */   private final UtilHistory history;
/*  34 */   final UICons cWall = (SPRITES.cons()).BIG.filled;
/*  35 */   final UICons cDoor = (SPRITES.cons()).BIG.outline;
/*     */   
/*  37 */   private static CharSequence ¤¤name = "¤Place Doorway";
/*  38 */   private static CharSequence ¤¤shrink = "¤Remove Doorway";
/*  39 */   private static CharSequence ¤¤cp = "Room will be blocked! Place doorways so that the room can be entered from the outside";
/*     */   
/*     */   static {
/*  42 */     D.ts(PlacerDoor.class);
/*     */   }
/*     */   
/*  45 */   final PlacableMulti undo = new PlacableMulti(¤¤shrink)
/*     */     {
/*  47 */       private SPRITE icon = (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.wall_opening, (SPRITE)(SPRITES.icons()).m.anti);
/*     */ 
/*     */       
/*     */       public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  51 */         if (PlacerDoor.this.removeWithoutHistory(tx, ty)) {
/*  52 */           PlacerDoor.this.history.placeDoor(tx, ty, -1);
/*     */         }
/*     */       }
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE t) {
/*  57 */         if (!PlacerDoor.this.isEdge.is(tx, ty)) {
/*  58 */           return E;
/*     */         }
/*  60 */         if (!UtilWallPlacability.wallCanBe.is(tx, ty)) {
/*  61 */           return E;
/*     */         }
/*  63 */         if (!PlacerDoor.this.isOpening.is(tx, ty)) {
/*  64 */           return E;
/*     */         }
/*  66 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public SPRITE getIcon() {
/*  71 */         return this.icon;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  76 */   final PlacableMulti placer = new PlacableMulti(¤¤name)
/*     */     {
/*     */       public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */       {
/*  80 */         if (PlacerDoor.this.placeWithoutHistory(tx, ty)) {
/*  81 */           PlacerDoor.this.history.placeDoor(tx, ty, 1);
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  87 */         if (!PlacerDoor.this.isEdge.is(tx, ty))
/*  88 */           return E; 
/*  89 */         if (!UtilWallPlacability.wallCanBe.is(tx, ty))
/*  90 */           return E; 
/*  91 */         if (PlacerDoor.this.isOpening.is(tx, ty))
/*  92 */           return E; 
/*  93 */         return null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/*  99 */         PlacerDoor.this.cDoor.render(r, mask, x, y);
/*     */       }
/*     */ 
/*     */       
/*     */       public PLACABLE getUndo() {
/* 104 */         return (PLACABLE)PlacerDoor.this.undo;
/*     */       }
/*     */ 
/*     */       
/*     */       public SPRITE getIcon() {
/* 109 */         return (SPRITE)(SPRITES.icons()).m.wall_opening;
/*     */       }
/*     */     };
/*     */   
/*     */   public boolean isOpening(int tx, int ty) {
/* 114 */     if (!this.isEdge.is(tx, ty))
/* 115 */       return false; 
/* 116 */     if (!UtilWallPlacability.wallCanBe.is(tx, ty))
/* 117 */       return false; 
/* 118 */     return true;
/*     */   }
/*     */   private int tick;
/*     */   private int walls;
/*     */   private int openings;
/*     */   private int mountains;
/*     */   private final MAP_BOOLEAN isolationMap;
/*     */   private final MAP_BOOLEAN isEdge;
/*     */   private MAP_BOOLEAN isOpening;
/*     */   
/*     */   boolean placeWithoutHistory(int tx, int ty) {
/* 129 */     if (!this.isEdge.is(tx, ty))
/* 130 */       return false; 
/* 131 */     if (!UtilWallPlacability.wallCanBe.is(tx, ty))
/* 132 */       return false; 
/* 133 */     if (this.isOpening.is(tx, ty)) {
/* 134 */       return false;
/*     */     }
/* 136 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 137 */       DIR d = (DIR)DIR.ALL.get(i);
/* 138 */       int dx = tx + d.x();
/* 139 */       int dy = ty + d.y();
/* 140 */       if (this.a.is(dx, dy)) {
/*     */ 
/*     */         
/* 143 */         int m = ConstructionData.dWall.get(dx, dy);
/*     */         
/* 145 */         if (d.isOrtho()) {
/* 146 */           m |= d.mask();
/*     */         } else {
/* 148 */           m |= d.mask() << 4;
/*     */         } 
/* 150 */         ConstructionData.dWall.set((ROOMA)this.a, dx, dy, m);
/*     */       } 
/* 152 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean removeWithoutHistory(int tx, int ty) {
/* 157 */     if (!this.isEdge.is(tx, ty)) {
/* 158 */       return false;
/*     */     }
/* 160 */     if (!UtilWallPlacability.wallCanBe.is(tx, ty)) {
/* 161 */       return false;
/*     */     }
/* 163 */     if (!this.isOpening.is(tx, ty)) {
/* 164 */       return false;
/*     */     }
/* 166 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 167 */       DIR d = (DIR)DIR.ALL.get(i);
/* 168 */       int dx = tx + d.x();
/* 169 */       int dy = ty + d.y();
/* 170 */       if (this.a.is(dx, dy)) {
/*     */ 
/*     */         
/* 173 */         int m = ConstructionData.dWall.get(dx, dy);
/*     */         
/* 175 */         if (d.isOrtho()) {
/* 176 */           m &= d.mask() ^ 0xFFFFFFFF;
/*     */         } else {
/* 178 */           m &= d.mask() << 4 ^ 0xFFFFFFFF;
/*     */         } 
/* 180 */         ConstructionData.dWall.set((ROOMA)this.a, dx, dy, m & 0xFF);
/*     */       } 
/* 182 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(int tx, int ty) {
/* 194 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 195 */       DIR d = (DIR)DIR.ALL.get(i);
/*     */       
/* 197 */       if (this.isEdge.is(tx, ty, d) && 
/* 198 */         UtilWallPlacability.openingIsReal.is(tx, ty, d)) {
/* 199 */         placeWithoutHistory(tx + d.x(), ty + d.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void update() {
/* 208 */     if (this.tick == GAME.updateI()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 213 */     this.tick = GAME.updateI();
/* 214 */     this.walls = 0;
/* 215 */     this.openings = 0;
/* 216 */     this.mountains = 0;
/*     */     
/* 218 */     boolean over = Job.overwrite;
/* 219 */     Job.overwrite = false;
/*     */     
/* 221 */     for (int y = this.a.body().y1() - 1; y <= this.a.body().y2(); y++) {
/* 222 */       for (int x = this.a.body().x1() - 1; x <= this.a.body().x2(); x++) {
/* 223 */         if (this.isEdge.is(x, y))
/*     */         {
/*     */           
/* 226 */           if (!UtilWallPlacability.wallisReal.is(x, y)) {
/* 227 */             if (this.isOpening.is(x, y)) {
/* 228 */               if (!(SETT.TERRAIN()).CAVE.is(x, y))
/*     */               {
/*     */                 
/* 231 */                 this.openings++;
/*     */               }
/* 233 */             } else if ((SETT.TERRAIN()).CAVE.is(x, y)) {
/* 234 */               this.mountains++;
/*     */             }
/*     */           
/*     */           }
/* 238 */           else if (UtilWallPlacability.wallShouldBuild.is(x, y)) {
/* 239 */             if ((SETT.TERRAIN()).CAVE.is(x, y)) {
/* 240 */               this.mountains++;
/* 241 */             } else if (this.isOpening.is(x, y)) {
/* 242 */               this.openings++;
/*     */             } else {
/* 244 */               this.walls++;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 250 */     Job.overwrite = over;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWalls() {
/* 255 */     update();
/* 256 */     return this.walls;
/*     */   }
/*     */   
/*     */   public int getOpenings() {
/* 260 */     update();
/* 261 */     return this.openings;
/*     */   }
/*     */   
/*     */   public int getMountains() {
/* 265 */     update();
/* 266 */     return this.mountains;
/*     */   }
/*     */   
/*     */   CharSequence createProblem() {
/* 270 */     for (COORDINATE c : this.a.body()) {
/* 271 */       if (!this.a.is(c)) {
/*     */         continue;
/*     */       }
/* 274 */       if ((SETT.ROOMS()).fData.tile.get(c) != null && ((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c)).isBlocker()) {
/*     */         continue;
/*     */       }
/* 277 */       int m = ConstructionData.dWall.get(c) & 0xF;
/* 278 */       if (m == 0)
/*     */         continue; 
/* 280 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 281 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 282 */         int dx = c.x() + d.x();
/* 283 */         int dy = c.y() + d.y();
/* 284 */         if (SETT.IN_BOUNDS(dx, dy))
/*     */         {
/* 286 */           if (!this.a.is(dx, dy)) {
/* 287 */             if (UtilWallPlacability.wallCanBe.is(dx, dy) && (d.perpendicular().mask() & m) != 0)
/* 288 */               return null; 
/* 289 */             if ((SETT.ROOMS()).map.is(dx, dy) && (SETT.PATH().getAvailability(dx, dy)).player > 0.0D)
/* 290 */               return null; 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 295 */     return ¤¤cp;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTmpPlaceArea(SPRITE_RENDERER r, int x, int y, int tx, int ty, AREA area) {
/* 300 */     if (this.a.is(tx, ty)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 305 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 306 */       DIR d = (DIR)DIR.ALL.get(i);
/* 307 */       int dx = tx + d.x();
/* 308 */       int dy = ty + d.y();
/*     */ 
/*     */       
/* 311 */       if (UtilWallPlacability.wallShouldBuild.is(dx, dy))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 316 */         if (!area.is(dx, dy))
/*     */         {
/*     */           
/* 319 */           if (!this.isEdge.is(dx, dy))
/*     */           {
/*     */             
/* 322 */             this.cWall.render(r, 0, x + 64 * d.x(), y + 64 * d.y()); }  } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderWall(SPRITE_RENDERER r, RenderData.RenderIterator it) {
/* 328 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 329 */       DIR d = (DIR)DIR.ALL.get(i);
/* 330 */       int dx = it.tx() + d.x();
/* 331 */       int dy = it.ty() + d.y();
/* 332 */       if (!this.a.is(dx, dy))
/*     */       {
/* 334 */         if (UtilWallPlacability.wallisReal.is(dx, dy)) {
/* 335 */           if (this.isOpening.is(dx, dy)) {
/* 336 */             this.cDoor.render(r, 0, it.x() + 64 * d.x(), it.y() + 64 * d.y());
/*     */           
/*     */           }
/*     */         }
/* 340 */         else if (UtilWallPlacability.wallShouldBuild.is(dx, dy)) {
/*     */ 
/*     */ 
/*     */           
/* 344 */           if (this.isOpening.is(dx, dy)) {
/* 345 */             this.cDoor.render(r, 0, it.x() + 64 * d.x(), it.y() + 64 * d.y());
/*     */           } else {
/* 347 */             this.cWall.render(r, 0, it.x() + 64 * d.x(), it.y() + 64 * d.y());
/*     */           } 
/*     */         }  } 
/*     */     } 
/*     */   } public void renderWall(SPRITE_RENDERER r, FurnisherItem a, int tx, int ty, int rx, int ry, int x, int y) {
/* 352 */     if (!a.is(rx, ry) || (a.get(rx, ry)).mustBeReachable) {
/*     */       return;
/*     */     }
/* 355 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 356 */       DIR d = (DIR)DIR.ALL.get(i);
/* 357 */       int dx = tx + d.x();
/* 358 */       int dy = ty + d.y();
/*     */       
/* 360 */       if (!a.is(rx + d.x(), ry + d.y()))
/*     */       {
/*     */         
/* 363 */         if (!UtilWallPlacability.wallisReal.is(dx, dy))
/*     */         {
/*     */ 
/*     */           
/* 367 */           if (UtilWallPlacability.wallCanBe.is(dx, dy))
/*     */           {
/*     */             
/* 370 */             if (UtilWallPlacability.wallShouldBuild.is(dx, dy))
/*     */             {
/*     */ 
/*     */               
/* 374 */               getType(a, rx + d.x(), ry + d.y()).render(r, 0, x + 64 * d.x(), y + 64 * d.y()); }  } 
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private UICons getType(FurnisherItem a, int rx, int ry) {
/* 381 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 382 */       DIR d = (DIR)DIR.ORTHO.get(i);
/* 383 */       if (a.get(rx, ry, d) != null && ((FurnisherItemTile)a.get(rx, ry, d)).mustBeReachable)
/* 384 */         return this.cDoor; 
/*     */     } 
/* 386 */     return this.cWall;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void build(TBuilding structure) {
/* 393 */     for (COORDINATE c : this.a.body()) {
/* 394 */       if (!this.a.is(c)) {
/*     */         continue;
/*     */       }
/* 397 */       FurnisherItemTile tile = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c);
/* 398 */       if (tile != null && tile.noWalls) {
/*     */         continue;
/*     */       }
/*     */       
/* 402 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 403 */         DIR d = (DIR)DIR.ALL.get(i);
/* 404 */         int dx = c.x() + d.x();
/* 405 */         int dy = c.y() + d.y();
/* 406 */         build(structure, dx, dy);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void build(TBuilding structure, int tx, int ty) {
/* 413 */     if (this.isOpening.is(tx, ty)) {
/* 414 */       UtilWallPlacability.openingBuild(tx, ty, structure);
/* 415 */     } else if (UtilWallPlacability.wallShouldBuild.is(tx, ty)) {
/* 416 */       if (this.isOpening.is(tx, ty)) {
/* 417 */         UtilWallPlacability.openingBuild(tx, ty, structure);
/*     */       } else {
/* 419 */         UtilWallPlacability.wallBuild(tx, ty, structure);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public PlacerDoor(RoomPlacer embryo) {
/* 424 */     this.isolationMap = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tile)
/*     */         {
/* 428 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty) {
/* 433 */           return (UtilWallPlacability.wallCanBe.is(tx, ty) && !PlacerDoor.this.isOpening.is(tx, ty));
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 443 */     this.isEdge = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 447 */           if (PlacerDoor.this.a.is(tx, ty))
/* 448 */             return false; 
/* 449 */           for (int i = 0; i < DIR.ALL.size(); i++) {
/* 450 */             DIR d = (DIR)DIR.ALL.get(i);
/* 451 */             if (PlacerDoor.this.a.is(tx, ty, d)) {
/* 452 */               return true;
/*     */             }
/*     */           } 
/* 455 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 461 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 465 */     this.isOpening = new MAP_BOOLEAN()
/*     */       {
/*     */         
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 470 */           for (int i = 0; i < DIR.ALL.size(); i++) {
/* 471 */             DIR d = (DIR)DIR.ALL.get(i);
/* 472 */             int dx = tx + d.x();
/* 473 */             int dy = ty + d.y();
/* 474 */             if (PlacerDoor.this.a.is(dx, dy)) {
/* 475 */               int m = d.isOrtho() ? d.mask() : (d.mask() << 4);
/* 476 */               return ((ConstructionData.dWall.get(dx, dy) & m) != 0);
/*     */             } 
/*     */           } 
/* 479 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 485 */           return false;
/*     */         }
/*     */       };
/*     */     this.a = embryo.instance;
/*     */     this.history = embryo.history;
/*     */   }
/*     */   
/*     */   public double isolation(RoomBlueprint blue, AREA area, boolean wallOn) {
/*     */     return (SETT.ROOMS()).isolation.getProspect(blue, area, wallOn ? this.isolationMap : UtilWallPlacability.wallisReal);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerDoor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */