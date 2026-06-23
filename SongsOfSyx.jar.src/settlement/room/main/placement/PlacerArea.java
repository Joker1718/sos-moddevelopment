/*     */ package settlement.room.main.placement;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GBox;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ class PlacerArea extends PlacableMulti {
/*  24 */   private static CharSequence ¤¤name = "¤Expand Room";
/*  25 */   private static CharSequence ¤¤shrink = "¤Shrink Room"; private final RoomPlacer embrio;
/*     */   static {
/*  27 */     D.ts(PlacerArea.class);
/*     */   }
/*     */ 
/*     */   
/*  31 */   private final PlacableMulti undo = new PlacableMulti(¤¤shrink, ¤¤shrink, (SPRITE)(SPRITES.icons()).m.shrink)
/*     */     {
/*     */       public void place(int tx, int ty, AREA a, PLACER_TYPE t)
/*     */       {
/*  35 */         if (PlacerArea.this.embrio.instance.is(tx, ty))
/*  36 */           PlacerArea.this.clear(tx, ty); 
/*  37 */         PlacerArea.this.embrio.history.placeEmbryo(tx, ty, -1);
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  42 */         if (!PlacerArea.this.embrio.instance.is(tx, ty)) {
/*  43 */           return PlacableMessages.¤¤ROOM_MUST;
/*     */         }
/*  45 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public PLACABLE getUndo() {
/*  50 */         return (PLACABLE)PlacerArea.this;
/*     */       }
/*     */ 
/*     */       
/*     */       public void finishPlacing(AREA placedArea) {
/*  55 */         for (COORDINATE c : placedArea.body()) {
/*  56 */           if (placedArea.is(c)) {
/*  57 */             PlacerArea.this.validateItems(c.x(), c.y());
/*     */           }
/*     */         } 
/*  60 */         super.finishPlacing(placedArea);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void placeInfo(GBox b, int oktiles, AREA a) {
/*  66 */         super.placeInfo(b, oktiles, a);
/*     */       }
/*     */     };
/*     */   
/*     */   int am; private final Rec rec;
/*     */   private final Rec rec2;
/*     */   
/*  73 */   void clear(int tx, int ty) { if (ConstructionData.dFloored.is(tx, ty, 1)) {
/*  74 */       this.embrio.resources.removeTile(tx, ty);
/*  75 */       (SETT.FLOOR()).clearer.clear(tx, ty);
/*     */     } 
/*     */ 
/*     */     
/*  79 */     (SETT.MAINTENANCE()).isser.is(tx, ty);
/*     */     
/*  81 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*  82 */     if (it != null) {
/*  83 */       boolean constructued = ConstructionData.dConstructed.is(tx, ty, 1);
/*  84 */       COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, Coo.TMP);
/*     */       
/*  86 */       int x1 = c.x();
/*  87 */       int y1 = c.y();
/*     */       
/*  89 */       (SETT.ROOMS()).fData.itemClear(tx, ty, (Room)this.embrio.instance);
/*  90 */       this.embrio.history.placeItem(it, x1, y1, -1);
/*  91 */       if (constructued) {
/*  92 */         this.embrio.resources.removeItem(x1, y1, it);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     this.embrio.instance.clear(tx, ty); }
/*     */   private void validateItems(int tx, int ty) { for (int i = 0; i < DIR.ALL.size(); i++) { DIR d = (DIR)DIR.ALL.get(i); int dx = tx + d.x(); int dy = ty + d.y(); if (this.embrio.instance.is(dx, dy)) { FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(dx, dy); if (it != null) { boolean constructued = ConstructionData.dConstructed.is(dx, dy, 1); COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(dx, dy, Coo.TMP); int x1 = c.x(); int y1 = c.y(); (SETT.ROOMS()).fData.itemClear(dx, dy, (Room)this.embrio.instance); if (!replaceItem(x1, y1, it, constructued)) { this.embrio.history.placeItem(it, x1, y1, -1); if (constructued)
/*     */               this.embrio.resources.removeItem(x1, y1, it);  }
/*     */            }
/*     */          }
/*     */        }
/* 107 */      } public PlacerArea(RoomPlacer embrio) { super(¤¤name, null, null, null);
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
/* 170 */     this.am = 0;
/*     */     
/* 172 */     this.rec = new Rec();
/* 173 */     this.rec2 = new Rec();
/*     */     this.embrio = embrio; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(AREA area, PLACER_TYPE type) {
/* 182 */     return null; } private boolean replaceItem(int x1, int y1, FurnisherItem it, boolean constructed) { int y; for (y = 0; y < it.height(); y++) { for (int x = 0; x < it.width(); x++) { if (this.embrio.placability.itemPlacable(x1 + x, y1 + y, x, y, it, (AREA)this.embrio.instance) != null)
/*     */           return false;  }  }
/*     */      if (this.embrio.placability.itemProblem(x1, y1, it.group, it, (AREA)this.embrio.instance) != null)
/*     */       return false;  (SETT.ROOMS()).fData.itemSet(x1, y1, it, this.embrio.instance); if (constructed)
/*     */       for (y = 0; y < it.height(); y++) { for (int x = 0; x < it.width(); x++) { if (it.get(x, y) != null)
/*     */             ConstructionData.dConstructed.set((ROOMA)this.embrio.instance, x + x1, y + y1, 1);  }
/*     */          }
/*     */         return true; }
/* 190 */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { if (ty == a.body().y1() && !a.is(tx - 1, ty)) {
/* 191 */       this.rec.clear();
/*     */       
/* 193 */       for (COORDINATE c : this.embrio.instance.body()) {
/* 194 */         if (this.embrio.instance.is(c))
/* 195 */           this.rec.unify(c.x(), c.y()); 
/*     */       } 
/* 197 */       this.am = 0;
/*     */     } 
/*     */     
/* 200 */     CharSequence s = PLACEMENT.placable(tx, ty, this.embrio.blueprint(), this.embrio.buildOnWalls.is());
/* 201 */     if (s != null) {
/* 202 */       return s;
/*     */     }
/* 204 */     s = this.embrio.blueprint().constructor().placable(tx, ty, null, null);
/* 205 */     if (s != null) {
/* 206 */       return s;
/*     */     }
/* 208 */     this.am++;
/* 209 */     if (this.embrio.instance.area() + this.am >= 2048) {
/* 210 */       return PlacableMessages.¤¤MAX_SIZE_REACHED;
/*     */     }
/* 212 */     if (tx - a.body().x1() >= 55) {
/* 213 */       return PlacableMessages.¤¤MAX_DIMENSION_REACHED;
/*     */     }
/* 215 */     if (ty - a.body().y1() >= 55) {
/* 216 */       return PlacableMessages.¤¤MAX_DIMENSION_REACHED;
/*     */     }
/* 218 */     if (this.embrio.instance.area() > 0) {
/* 219 */       this.rec2.set((RECTANGLE)this.rec);
/* 220 */       this.rec2.unify(tx, ty);
/* 221 */       if (this.rec2.width() > 55)
/* 222 */         return PlacableMessages.¤¤MAX_DIMENSION_REACHED; 
/* 223 */       if (this.rec2.height() > 55) {
/* 224 */         return PlacableMessages.¤¤MAX_DIMENSION_REACHED;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 229 */     return null; } public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/*     */     super.renderPlaceHolder(r, mask, x, y, tx, ty, area, type, isPlacable, areaIsPlacable);
/*     */     if (isPlacable && this.embrio.autoWalls.is())
/*     */       this.embrio.door.renderTmpPlaceArea(r, x, y, tx, ty, area); 
/*     */   } public void finishChecking(AREA placedArea) {
/* 234 */     GUTIL.coos().set(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 242 */     this.am--;
/* 243 */     if (!this.embrio.instance.is(tx, ty)) {
/* 244 */       (SETT.JOBS()).clearer.set(tx, ty);
/* 245 */       this.embrio.door.undo.place(tx, ty, null, null);
/* 246 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 247 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 248 */         this.embrio.door.undo.place(tx + d.x(), ty + d.y(), null, null);
/*     */       } 
/*     */       
/* 251 */       this.embrio.instance.set(tx, ty);
/* 252 */       GUTIL.coos().get().set(tx, ty);
/* 253 */       GUTIL.coos().inc();
/* 254 */       (SETT.ROOMS()).data.set((ROOMA)this.embrio.instance, tx, ty, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishPlacing(AREA placedArea) {
/* 264 */     int m = GUTIL.coos().getI();
/*     */     int i;
/* 266 */     for (i = 0; i < m; i++) {
/* 267 */       GUTIL.coos().set(i);
/* 268 */       int tx = GUTIL.coos().get().x();
/* 269 */       int ty = GUTIL.coos().get().y();
/* 270 */       validateItems(tx, ty);
/*     */     } 
/*     */     
/* 273 */     for (i = 0; i < m; i++) {
/* 274 */       GUTIL.coos().set(i);
/* 275 */       int tx = GUTIL.coos().get().x();
/* 276 */       int ty = GUTIL.coos().get().y();
/* 277 */       this.embrio.history.placeEmbryo(tx, ty, 1);
/*     */     } 
/*     */ 
/*     */     
/* 281 */     super.finishPlacing(placedArea);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 287 */     return (PLACABLE)this.undo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerArea.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */