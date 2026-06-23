/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.job.JobBuildStructure;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableFixed;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ class PlacerItemSingle
/*     */   extends PlacableFixed
/*     */ {
/*     */   protected final RoomPlacer embryo;
/*     */   private RoomBlueprintImp blueprint;
/*     */   protected FurnisherItemGroup group;
/*     */   protected final UtilStats res;
/*     */   protected final Instance area;
/*     */   private int upgrade;
/*     */   private int[] sizes;
/*  45 */   private static CharSequence ¤¤undo = "¤Remove Item";
/*     */   static {
/*  47 */     D.ts(PlacerItemSingle.class);
/*     */   }
/*     */   
/*  50 */   private final PlacableMulti undo = new PlacableMulti(¤¤undo)
/*     */     {
/*     */       public void place(int tx, int ty, AREA a, PLACER_TYPE t)
/*     */       {
/*  54 */         Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  55 */         if (r != null && r.constructor() == PlacerItemSingle.this.blueprint.constructor()) {
/*  56 */           r.remove(tx, ty, true, this, false).clear();
/*     */         }
/*     */       }
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  61 */         Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  62 */         if (r != null && r.constructor() == PlacerItemSingle.this.blueprint.constructor())
/*  63 */           return null; 
/*  64 */         return E;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*  69 */         Room r = (SETT.ROOMS()).map.get(fromX, fromY);
/*  70 */         if (r != null && r.constructor() == PlacerItemSingle.this.blueprint.constructor() && r.isSame(fromX, fromY, toX, toY))
/*  71 */           return true; 
/*  72 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private final Area itemArea;
/*     */   
/*     */   AREA itemAreaCurrent;
/*     */ 
/*     */   
/*     */   public void set(RoomBlueprintImp b, int group, int upgrade) {
/*  83 */     if (SETT.ROOMS() != null) {
/*  84 */       if (this.sizes == null) {
/*  85 */         this.sizes = Alloc.ii((SETT.ROOMS()).AMOUNT_OF_BLUEPRINTS);
/*     */       }
/*  87 */       if (this.blueprint != null) {
/*  88 */         this.sizes[this.blueprint.index()] = size();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  93 */     this.blueprint = b;
/*  94 */     this.group = (FurnisherItemGroup)b.constructor().pgroups().getC(group);
/*  95 */     this.upgrade = upgrade;
/*  96 */     if (this.sizes != null) {
/*  97 */       sizeSet(this.sizes[b.index()]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 103 */     return this.group.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, int rx, int ry) {
/* 108 */     FurnisherItem it = this.group.item(size(), rot());
/*     */     
/* 110 */     if (rx == 0 && ry == 0) {
/*     */       
/* 112 */       TBuilding s = this.blueprint.constructor().mustBeIndoors() ? (TBuilding)this.embryo.structure.get() : null;
/*     */ 
/*     */       
/* 115 */       if (s != null && this.embryo.autoWalls.is()) {
/* 116 */         this.embryo.instance.clear(this.blueprint); int y;
/* 117 */         for (y = 0; y < it.height(); y++) {
/* 118 */           for (int x = 0; x < it.width(); x++) {
/* 119 */             if (it.get(x, y) != null) {
/* 120 */               this.embryo.instance.set(tx + x, ty + y);
/*     */             }
/*     */           } 
/*     */         } 
/* 124 */         this.embryo.door.build(s);
/* 125 */         this.embryo.instance.clear(this.blueprint);
/*     */         
/* 127 */         for (y = 0; y < it.height(); y++) {
/* 128 */           for (int x = 0; x < it.width(); x++) {
/*     */             
/* 130 */             if (it.get(x, y) != null && (it.get(x, y)).mustBeReachable) {
/* 131 */               for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 132 */                 int dx = tx + x + ((DIR)DIR.ORTHO.get(di)).x();
/* 133 */                 int dy = ty + y + ((DIR)DIR.ORTHO.get(di)).y();
/* 134 */                 if (UtilWallPlacability.wallisReal.is(dx, dy)) {
/* 135 */                   UtilWallPlacability.openingBuild(dx, dy, s);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 144 */       FurnisherItem secret = this.blueprint.constructor().secretReplacementItem(rot(), it);
/*     */       
/* 146 */       if (secret != null) {
/* 147 */         for (int y = 0; y < it.height(); y += secret.height()) {
/* 148 */           for (int x = 0; x < it.width(); x += secret.width()) {
/* 149 */             place(secret, tx + x, ty + y, s);
/*     */           }
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 155 */         place(it, tx, ty, s);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void place(FurnisherItem it, int tx, int ty, TBuilding s) {
/* 163 */     TmpArea tmp = SETT.ROOMS().tmpArea(this);
/*     */ 
/*     */ 
/*     */     
/* 167 */     for (int y = 0; y < it.height(); y++) {
/* 168 */       for (int x = 0; x < it.width(); x++) {
/*     */         
/* 170 */         if (it.get(x, y) != null) {
/* 171 */           tmp.set(tx + x, ty + y);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 178 */     (SETT.ROOMS()).fData.itemSet(tx, ty, it, tmp.room());
/*     */     
/* 180 */     ConstructionInit init = new ConstructionInit(0, this.blueprint.constructor(), s, 0, this.blueprint.constructor().getConstructionState());
/*     */     
/* 182 */     (SETT.ROOMS()).construction.createClean(tmp, init);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/* 188 */     FurnisherItem it = this.group.item(size(), rot());
/*     */     
/* 190 */     FurnisherItemTile t = it.get(rx, ry);
/* 191 */     if (t != null)
/*     */     {
/* 193 */       if (t.mustBeReachable) {
/* 194 */         (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/* 195 */         COLOR c = CORE.renderer().colorGet();
/* 196 */         COLOR.unbind();
/*     */         
/* 198 */         int ri = -1;
/*     */         
/* 200 */         if (t.sprite() != null) {
/* 201 */           int d = t.sprite().getData(tx, ty, rx, ry, it, 0);
/* 202 */           ri = t.sprite.rotation(d, it) - 1;
/*     */         } 
/*     */         
/* 205 */         if (ri < 0) {
/* 206 */           (SPRITES.cons()).ICO.arrows_inward.render(r, x, y);
/*     */         } else {
/* 208 */           ((SPRITE)(SPRITES.cons()).ICO.arrows_inwards.get(ri)).render(r, x, y);
/* 209 */         }  c.bind();
/* 210 */       } else if (t.sprite() != null) {
/* 211 */         int d = t.sprite().getData(tx, ty, rx, ry, it, 0);
/*     */ 
/*     */ 
/*     */         
/* 215 */         t.sprite().renderPlaceholder(r, x, y, d, tx, ty, rx, ry, it);
/*     */       } else {
/*     */         
/* 218 */         (SPRITES.cons()).BIG.dashed.render(r, mask, x, y);
/*     */       } 
/*     */     }
/* 221 */     this.group.blueprint.renderExtra(r, x, y, tx, ty, rx, ry, it);
/*     */ 
/*     */     
/* 224 */     if (this.blueprint.constructor().mustBeIndoors() && (SETT.ROOMS()).placement.placer.autoWalls.is()) {
/* 225 */       (SETT.ROOMS()).placement.placer.door.renderWall(r, it, tx, ty, rx, ry, x, y);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 231 */     return this.group.item(size(), rot()).width();
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 236 */     return this.group.item(size(), rot()).height();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placableWhole(int tx1, int ty1) {
/* 241 */     this.itemAreaCurrent = null;
/*     */ 
/*     */     
/* 244 */     FurnisherItem it = this.group.item(size(), rot());
/* 245 */     CharSequence s = it.placable(tx1, ty1);
/* 246 */     if (s != null) {
/* 247 */       return s;
/*     */     }
/* 249 */     this.itemAreaCurrent = this.itemArea.set(this.group.item(size(), rot()), tx1, ty1);
/*     */     
/* 251 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 256 */     FurnisherItem it = this.group.item(size(), rot());
/* 257 */     if (it.get(rx, ry) == null) {
/* 258 */       return null;
/*     */     }
/*     */     
/* 261 */     CharSequence s = PLACEMENT.placable(tx, ty, this.blueprint, true);
/* 262 */     if (s != null)
/* 263 */       return s; 
/* 264 */     s = this.group.blueprint.placable(tx, ty, it, (it == null) ? null : it.get(rx, ry));
/* 265 */     if (s != null) {
/* 266 */       return s;
/*     */     }
/* 268 */     if ((it.get(rx, ry)).mustBeReachable && 
/* 269 */       SETT.PLACA().willBeBlocked(tx, ty, rx, ry, (MAP_OBJECT)it)) {
/* 270 */       return PlacableMessages.¤¤BLOCKED_WILL;
/*     */     }
/*     */     
/* 273 */     if (it.get(rx, ry).isBlocker() && 
/* 274 */       (SETT.PLACA()).willBlock.is(tx, ty)) {
/* 275 */       return PlacableMessages.¤¤BLOCK_WILL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 281 */     return it.get(rx, ry).isPlacable(tx, ty, (MAP_BOOLEAN)this.embryo.instance, it, rx, ry);
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox box, int x1, int y1) {
/* 286 */     box.add((SPRITE)box.text().add(width()).add('x').add(height()));
/* 287 */     box.NL();
/* 288 */     for (int i = 0; i < this.group.blueprint.resources(); i++) {
/* 289 */       if (this.group.item(size(), rot()).cost2(i, this.upgrade) > 0.0D) {
/* 290 */         box.setResource(this.group.blueprint.resource(i), Math.ceil(this.group.item(size(), rot()).cost2(i, this.upgrade)));
/* 291 */         box.space();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 296 */     if (this.blueprint.constructor().mustBeIndoors() && (SETT.ROOMS()).placement.placer.autoWalls.is() && this.embryo.structure.get() != null) {
/* 297 */       FurnisherItem it = this.group.item(size(), rot());
/* 298 */       int roofs = 0;
/* 299 */       int walls = 0;
/* 300 */       for (int y = -1; y <= it.height(); y++) {
/* 301 */         for (int x = -1; x <= it.width(); x++) {
/*     */           
/* 303 */           if (it.get(x, y) != null) {
/* 304 */             roofs++;
/* 305 */           } else if (UtilWallPlacability.wallCanBe.is(x1 + x, y1 + y)) {
/* 306 */             int j; boolean roof = false;
/* 307 */             for (DIR d : DIR.ORTHO) {
/* 308 */               j = roof | ((it.get(x, y, d) != null && ((FurnisherItemTile)it.get(x, y, d)).mustBeReachable) ? 1 : 0);
/*     */             }
/*     */             
/* 311 */             for (DIR d : DIR.ALL) {
/* 312 */               if (it.get(x, y, d) != null) {
/* 313 */                 if (j != 0) {
/* 314 */                   roofs++; break;
/*     */                 } 
/* 316 */                 walls++;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 324 */       int am = roofs * ((JobBuildStructure)(SETT.JOBS()).build_structure.get(((TBuilding)this.embryo.structure.get()).structure.index())).ceiling.resAmount();
/* 325 */       am += walls * ((JobBuildStructure)(SETT.JOBS()).build_structure.get(((TBuilding)this.embryo.structure.get()).structure.index())).wall.resAmount();
/* 326 */       box.setResource(((TBuilding)this.embryo.structure.get()).structure.resource, am);
/* 327 */       box.space();
/*     */     } 
/*     */ 
/*     */     
/* 331 */     for (FurnisherStat s : this.group.blueprint.stats()) {
/* 332 */       double am = this.group.item(size(), rot()).stat(s);
/* 333 */       if (am != 0.0D) {
/* 334 */         box.NL();
/* 335 */         box.add((SPRITE)box.text().lablify().add(s.name()));
/* 336 */         box.tab(7);
/* 337 */         box.add((SPRITE)s.format(box.text(), am));
/*     */       } 
/*     */     } 
/*     */     
/* 341 */     box.NL(8);
/* 342 */     this.group.blueprint.placeInfo(box, this.group.item(size(), rot()), x1, y1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverDesc(GBox box) {
/* 347 */     box.title(this.group.name);
/* 348 */     box.text(this.group.desc);
/* 349 */     box.NL();
/* 350 */     for (int i = 0; i < this.group.blueprint.resources(); i++) {
/* 351 */       if (this.group.item(0, 0).cost2(i, this.upgrade) > 0.0D) {
/* 352 */         box.setResource(this.group.blueprint.resource(i), Math.ceil(this.group.item(0, 0).cost2(i, this.upgrade)));
/* 353 */         box.space();
/*     */       } 
/*     */     } 
/*     */     
/* 357 */     for (FurnisherStat s : this.group.blueprint.stats()) {
/* 358 */       if (this.group.item(0, 0).stat(s) > 0.0D) {
/* 359 */         box.NL();
/* 360 */         box.add((SPRITE)box.text().lablify().add(s.name()));
/* 361 */         box.add((SPRITE)s.format(box.text(), this.group.item(0, 0).stat(s)));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 369 */     return (PLACABLE)this.undo;
/*     */   }
/*     */ 
/*     */   
/*     */   public int rotations() {
/* 374 */     return this.group.rotations();
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizes() {
/* 379 */     return this.group.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 385 */     return null;
/*     */   }
/*     */   
/* 388 */   public PlacerItemSingle(RoomPlacer embryo) { this.itemArea = new Area();
/* 389 */     this.itemAreaCurrent = null;
/*     */     this.embryo = embryo;
/*     */     this.res = embryo.resources;
/*     */     this.area = embryo.instance; } final class Area implements AREA { private final Rec area; Area() {
/* 393 */       this.area = new Rec();
/* 394 */       this.size = 0;
/*     */     }
/*     */     private int size; private FurnisherItem item;
/*     */     AREA set(FurnisherItem item, int x1, int y1) {
/* 398 */       this.item = item;
/* 399 */       this.area.setDim(item.width(), item.height());
/* 400 */       this.area.moveX1Y1(x1, y1);
/* 401 */       this.size = this.area.width() * this.area.height();
/* 402 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 407 */       return (RECTANGLE)this.area;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean is(int tile) {
/* 413 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 418 */       return (this.area.holdsPoint(tx, ty) && this.item.get(tx - body().x1(), ty - body().y1()) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public int area() {
/* 423 */       return this.size;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerItemSingle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */