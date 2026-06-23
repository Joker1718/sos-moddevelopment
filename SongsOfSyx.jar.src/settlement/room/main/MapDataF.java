/*     */ package settlement.room.main;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.map.MAP_INT;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Bitmap1D;
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
/*     */ public class MapDataF
/*     */ {
/*     */   public static final short NOTHING = 0;
/*  38 */   private final byte[] itemI = Alloc.bb(SETT.TAREA);
/*  39 */   private final byte[] tileI = Alloc.bb(SETT.TAREA);
/*  40 */   private final byte[] spriteDataI = Alloc.bb(SETT.TAREA);
/*  41 */   private final byte[] spriteDataI2 = Alloc.bb(SETT.TAREA);
/*  42 */   private final Bitmap1D masterTileI = new Bitmap1D(SETT.TAREA, false);
/*  43 */   private final Bitmap1D candleI = new Bitmap1D(SETT.TAREA, false); final SAVABLE saver;
/*     */   private final MAP_INTE itemIndex;
/*     */   public final MAP_INT itemIndexx;
/*     */   public final MAP_OBJECT<FurnisherItem> item;
/*     */   public final MAP_INT tileData;
/*     */   
/*  49 */   MapDataF(ROOMS r) { this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  53 */           file.bs(MapDataF.this.itemI);
/*  54 */           file.bs(MapDataF.this.tileI);
/*  55 */           file.bs(MapDataF.this.spriteDataI);
/*  56 */           file.bs(MapDataF.this.spriteDataI2);
/*  57 */           MapDataF.this.masterTileI.save(file);
/*  58 */           MapDataF.this.candleI.save(file);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  64 */           file.bs(MapDataF.this.itemI);
/*  65 */           file.bs(MapDataF.this.tileI);
/*  66 */           file.bs(MapDataF.this.spriteDataI);
/*  67 */           file.bs(MapDataF.this.spriteDataI2);
/*  68 */           MapDataF.this.masterTileI.load(file);
/*  69 */           MapDataF.this.candleI.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  74 */           for (int i = 0; i < SETT.TAREA; i++) {
/*  75 */             MapDataF.this.itemI[i] = 0;
/*  76 */             MapDataF.this.tileI[i] = 0;
/*     */           } 
/*  78 */           MapDataF.this.masterTileI.setAll(false);
/*  79 */           MapDataF.this.candleI.setAll(false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  84 */     this.itemIndex = new MAP_INTE()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/*  88 */           if (SETT.IN_BOUNDS(tx, ty))
/*  89 */             return get(tx + ty * SETT.TWIDTH); 
/*  90 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/*  95 */           return MapDataF.this.itemI[tile] & 0xFF;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tx, int ty, int value) {
/* 100 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 101 */             return set(tx + ty * SETT.TWIDTH, value);
/*     */           }
/* 103 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 108 */           MapDataF.this.itemI[tile] = (byte)value;
/* 109 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 113 */     this.itemIndexx = (MAP_INT)this.itemIndex;
/*     */     
/* 115 */     this.item = new MAP_OBJECT<FurnisherItem>()
/*     */       {
/*     */         public FurnisherItem get(int tx, int ty)
/*     */         {
/* 119 */           if (SETT.IN_BOUNDS(tx, ty))
/* 120 */             return get(tx + ty * SETT.TWIDTH); 
/* 121 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public FurnisherItem get(int tile) {
/* 126 */           Room r = (SETT.ROOMS()).map.get(tile);
/* 127 */           if (r != null && r.constructor() != null) {
/* 128 */             return r.constructor().item(MapDataF.this.itemI[tile] & 0xFF);
/*     */           }
/* 130 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 134 */     this.tileData = new MAP_INT()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 138 */           if (SETT.IN_BOUNDS(tx, ty))
/* 139 */             return get(tx + ty * SETT.TWIDTH); 
/* 140 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int t) {
/* 145 */           FurnisherItemTile tt = (FurnisherItemTile)MapDataF.this.tile.get(t);
/* 146 */           if (tt != null)
/* 147 */             return tt.data(); 
/* 148 */           return 0;
/*     */         }
/*     */       };
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
/* 239 */     this.masterFind = new Coo();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     this.tileIndex = new MAP_INTE()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 377 */           if (SETT.IN_BOUNDS(tx, ty))
/* 378 */             return get(tx + ty * SETT.TWIDTH); 
/* 379 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 384 */           return MapDataF.this.tileI[tile] & 0xFF;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tx, int ty, int value) {
/* 389 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 390 */             return set(tx + ty * SETT.TWIDTH, value);
/*     */           }
/* 392 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 397 */           MapDataF.this.tileI[tile] = (byte)(value & 0xFF);
/* 398 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 402 */     this.tIndex = (MAP_INT)this.tileIndex;
/*     */     
/* 404 */     this.tile = new MAP_OBJECT<FurnisherItemTile>()
/*     */       {
/*     */         public FurnisherItemTile get(int tx, int ty)
/*     */         {
/* 408 */           if (SETT.IN_BOUNDS(tx, ty))
/* 409 */             return get(tx + ty * SETT.TWIDTH); 
/* 410 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public FurnisherItemTile get(int tile) {
/* 415 */           Room r = (SETT.ROOMS()).map.get(tile);
/* 416 */           if (r != null && r.constructor() != null) {
/* 417 */             return r.constructor().tile(MapDataF.this.tileI[tile] & 0xFF);
/*     */           }
/* 419 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 423 */     this.sprite = new MAP_OBJECT<RoomSprite>()
/*     */       {
/*     */         public RoomSprite get(int tx, int ty)
/*     */         {
/* 427 */           FurnisherItemTile t = (FurnisherItemTile)MapDataF.this.tile.get(tx, ty);
/* 428 */           if (t != null)
/* 429 */             return t.sprite(); 
/* 430 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomSprite get(int t) {
/* 435 */           FurnisherItemTile tt = (FurnisherItemTile)MapDataF.this.tile.get(t);
/* 436 */           if (tt != null)
/* 437 */             return tt.sprite(); 
/* 438 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 442 */     this.spriteData = new MAP_INTE()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 446 */           if (SETT.IN_BOUNDS(tx, ty))
/* 447 */             return get(tx + ty * SETT.TWIDTH); 
/* 448 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 453 */           return MapDataF.this.spriteDataI[tile] & 0xFF;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tx, int ty, int value) {
/* 458 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 459 */             return set(tx + ty * SETT.TWIDTH, value);
/*     */           }
/* 461 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 466 */           MapDataF.this.spriteDataI[tile] = (byte)(value & 0xFF);
/* 467 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 471 */     this.spriteData2 = new MAP_INTE()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 475 */           if (SETT.IN_BOUNDS(tx, ty))
/* 476 */             return get(tx + ty * SETT.TWIDTH); 
/* 477 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 482 */           return MapDataF.this.spriteDataI2[tile] & 0xFF;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tx, int ty, int value) {
/* 487 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 488 */             return set(tx + ty * SETT.TWIDTH, value);
/*     */           }
/* 490 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 495 */           MapDataF.this.spriteDataI2[tile] = (byte)(value & 0xFF);
/* 496 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 500 */     this.candle = new MAP_BOOLEANE()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 504 */           if (SETT.IN_BOUNDS(tx, ty))
/* 505 */             return is(tx + ty * SETT.TWIDTH); 
/* 506 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 511 */           return MapDataF.this.candleI.get(tile);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tile, boolean value) {
/* 516 */           MapDataF.this.candleI.set(tile, value);
/* 517 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 522 */           MapDataF.this.candleI.set(tx + ty * SETT.TWIDTH, value);
/* 523 */           return this;
/*     */         }
/*     */       };
/*     */     
/* 527 */     this.isMaster = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 531 */           if (SETT.IN_BOUNDS(tx, ty))
/* 532 */             return is(tx + ty * SETT.TWIDTH); 
/* 533 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 538 */           return MapDataF.this.masterTileI.get(tile);
/*     */         }
/*     */       };
/*     */     
/* 542 */     this.availability = new MAP_OBJECT<AVAILABILITY>()
/*     */       {
/*     */         public AVAILABILITY get(int tx, int ty)
/*     */         {
/* 546 */           FurnisherItemTile t = (FurnisherItemTile)MapDataF.this.tile.get(tx, ty);
/* 547 */           if (t != null)
/* 548 */             return t.availability; 
/* 549 */           return AVAILABILITY.ROOM;
/*     */         }
/*     */ 
/*     */         
/*     */         public AVAILABILITY get(int tt) {
/* 554 */           FurnisherItemTile t = (FurnisherItemTile)MapDataF.this.tile.get(tt);
/* 555 */           if (t != null)
/* 556 */             return t.availability; 
/* 557 */           return AVAILABILITY.ROOM;
/*     */         }
/*     */       };
/*     */     
/* 561 */     this.blocking = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tt)
/*     */         {
/* 565 */           FurnisherItemTile t = (FurnisherItemTile)MapDataF.this.tile.get(tt);
/* 566 */           if (t != null)
/* 567 */             return t.isBlocker(); 
/* 568 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty) {
/* 575 */           FurnisherItemTile t = (FurnisherItemTile)MapDataF.this.tile.get(tx, ty);
/* 576 */           if (t != null)
/* 577 */             return t.isBlocker(); 
/* 578 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 582 */     this.mustReach = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tt)
/*     */         {
/* 586 */           FurnisherItemTile t = (FurnisherItemTile)MapDataF.this.tile.get(tt);
/* 587 */           if (t != null)
/* 588 */             return t.mustBeReachable; 
/* 589 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty) {
/* 596 */           FurnisherItemTile t = (FurnisherItemTile)MapDataF.this.tile.get(tx, ty);
/* 597 */           if (t != null)
/* 598 */             return t.mustBeReachable; 
/* 599 */           return false;
/*     */         } }; }
/*     */   public void itemSet(int x1, int y1, FurnisherItem item, Room.RoomInstanceImp r) { int ran = RND.rInt() & 0xFFFF; if (r.constructor() != null && r.constructor() != item.group.blueprint)
/*     */       throw new RuntimeException(String.valueOf(r.name(x1, y1)));  for (int y = 0; y < item.height(); y++) {
/*     */       for (int x = 0; x < item.width(); x++) {
/*     */         int dx = x + x1; int dy = y + y1; if (!SETT.IN_BOUNDS(dx, dy))
/*     */           throw new RuntimeException("" + x1 + " " + x1 + " " + y1 + " " + x);  FurnisherItemTile t = item.get(x, y); if (t != null) {
/*     */           int i = dx + dy * SETT.TWIDTH; if (!r.is(dx, dy))
/*     */             throw new RuntimeException(String.valueOf((r.constructor().blue()).info.name) + " " + String.valueOf((r.constructor().blue()).info.name) + " " + item.width() + " THIS IS A SPECIAL ERROR THAT THE DEV IS LOOKING FOR. Please help. If you can reproduce the issue in one of your saves, send the save to: info@songsofsyx.com !");  if (this.itemIndex.get(i) != 0)
/*     */             throw new RuntimeException(String.valueOf(item) + " " + String.valueOf(item));  if (this.tileIndex.get(i) != 0)
/*     */             throw new RuntimeException((r.constructor().blue()).key);  this.masterTileI.set(i, (x == item.firstX() && y == item.firstY())); this.tileIndex.set(i, t.index()); this.itemIndex.set(i, item.index()); if (t.sprite() != null) {
/*     */             byte d = t.sprite().getData(dx, dy, x, y, item, ran); this.spriteDataI[i] = d; d = t.sprite().getData2(dx, dy, x, y, item, ran); this.spriteDataI2[i] = d;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }  } public void itemClear(int tx, int ty, Room r) { FurnisherItem i = (FurnisherItem)this.item.get(tx, ty); if (i == null)
/*     */       return;  COORDINATE m = itemMaster(tx, ty, this.masterFind, r); int sx = m.x() - i.firstX(); int sy = m.y() - i.firstY(); for (int y = 0; y < i.height(); y++) {
/*     */       for (int x = 0; x < i.width(); x++) {
/*     */         if (i != null && i.get(x, y) != null) {
/*     */           int dx = sx + x; int dy = sy + y; if (!r.isSame(tx, ty, dx, dy))
/*     */             throw new RuntimeException(String.valueOf((r.constructor().blue()).info.name) + " " + String.valueOf((r.constructor().blue()).info.name) + " " + i.width() + " THIS IS A SPECIAL ERROR THAT THE DEV IS LOOKING FOR. Please help. If you can reproduce the issue in one of your saves, send the save to: info@songsofsyx.com !");  int index = dx + dy * SETT.TWIDTH; this.itemIndex.set(index, 0); this.tileIndex.set(index, 0); this.masterTileI.set(index, false); this.candleI.set(index, false); SETT.LIGHTS().remove(x, y);
/*     */         } 
/*     */       } 
/*     */     }  FurnisherItem i2 = (FurnisherItem)this.item.get(tx, ty);
/*     */     if (i2 != null)
/* 624 */       throw new RuntimeException("" + i.rotation + " " + i.rotation + " " + i.group.index() + " " + (i.group.blueprint.blue()).key + " " + i2.rotation + " " + i2.group.index());  } private static final RoomAreaWrapper wrap = new RoomAreaWrapper(); private final Coo masterFind; private final MAP_INTE tileIndex; public MAP_INT tIndex; public final MAP_OBJECT<FurnisherItemTile> tile; public final MAP_OBJECT<RoomSprite> sprite; public final MAP_INTE spriteData; public final MAP_INTE spriteData2; public final MAP_BOOLEANE candle; boolean isClean(int tile) { return (this.itemI[tile] == 0 && this.tileI[tile] == 0); }
/*     */   public final MAP_BOOLEAN isMaster;
/*     */   public final MAP_OBJECT<AVAILABILITY> availability;
/*     */   public final MAP_BOOLEAN blocking;
/* 628 */   public final MAP_BOOLEAN mustReach; public void clear(int mx, int my, Room r) { ROOMA a = wrap.init(r, mx, my); for (COORDINATE c : a.body()) { if (a.is(c)) itemClear(c.x(), c.y(), r);  }  wrap.done(); } public COORDINATE itemMaster(int tx, int ty, Coo res, Room room) { if ((SETT.ROOMS()).map.indexGetter.get(tx, ty) != room.index()) throw new RuntimeException("" + tx + " " + tx + ty + " " + String.valueOf(room));  int itI = this.itemIndex.get(tx, ty); FurnisherItem it = room.constructor().item(itI); if (it == null) throw new RuntimeException("" + itI);  if (this.masterTileI.get(tx + ty * SETT.TWIDTH)) { res.set(tx, ty); return (COORDINATE)res; }  int w = it.width(); int h = it.height(); int x1 = tx - w + 1 + it.firstX(); int y1 = ty - h + 1 + it.firstY(); int y; for (y = 0; y < h; y++) { for (int x = 0; x < w; x++) { int dx = x1 + x; int dy = y1 + y; if (SETT.TILE_BOUNDS.holdsPoint(dx, dy)) if ((SETT.ROOMS()).map.indexGetter.get(dx, dy) == room.index()) if (itI == this.itemIndex.get(dx, dy)) if (this.masterTileI.get(dx + dy * SETT.TWIDTH)) { int qx = dx - it.firstX(); int qy = dy - it.firstY(); qx = tx - qx; qy = ty - qy; if (it.get(qx, qy) != null) { res.set(dx, dy); return (COORDINATE)res; }  }     }  }  LOG.ln("" + tx + " " + tx + " " + ty + " " + String.valueOf(room) + " " + room.index() + " " + it.firstX() + " " + it.firstY() + " " + w); for (y = 0; y <= h; y++) { for (int x = 0; x <= w; x++) { int dx = x1 + x; int dy = y1 + y; int qx = dx - it.firstX(); int qy = dy - it.firstY(); qx = tx - qx; qy = ty - qy; LOG.ln("" + x + " " + x + " " + y + " " + dx + " " + dy + (((SETT.ROOMS()).map.indexGetter.get(dx, dy) == room.index()) ? 1 : 0) + " " + ((itI != this.itemIndex.get(dx, dy)) ? 1 : 0) + " " + this.masterTileI.get(dx + dy * SETT.TWIDTH)); if (SETT.TILE_BOUNDS.holdsPoint(dx, dy)) if ((SETT.ROOMS()).map.indexGetter.get(dx, dy) == room.index()) if (itI == this.itemIndex.get(dx, dy)) if (this.masterTileI.get(dx + dy * SETT.TWIDTH)) if (it.get(qx, qy) != null) { res.set(dx, dy); return (COORDINATE)res; }      }  }  LOG.ln("" + tx + " " + tx + " " + ty + " " + String.valueOf(room) + " " + String.valueOf(room.constructor()) + " " + String.valueOf(it.group.name) + " " + it.width()); String m = "A very strange bug has happened that the developer is looking for. It has to do with the remove tool that has been used to remove houses. The house in question was at tile x: " + tx + " y" + ty + " If you can replicate this by attemting the removal again around these tiles, the devloper is dying for a reproducable example. Please send the save with instructions of where to delete to info@songsofsyx.com. You can find the saves through the game launcher."; throw new RuntimeException(m); } public COORDINATE itemMaster(int tx, int ty, Coo res) { Room r = (SETT.ROOMS()).map.get(tx, ty); if (r == null) return null;  return itemMaster(tx, ty, res, r); } public COORDINATE itemMaster(COORDINATE c, Coo res) { return itemMaster(c.x(), c.y(), res); } public COORDINATE itemX1Y1(int tx, int ty, Coo res, Room room) { itemMaster(tx, ty, res, room); int itI = this.itemIndex.get(tx, ty); FurnisherItem it = room.constructor().item(itI); res.increment(-it.firstX(), -it.firstY()); return (COORDINATE)res; } public COORDINATE itemX1Y1(int tx, int ty, Coo res) { Room r = (SETT.ROOMS()).map.get(tx, ty); if (r == null) return null;  return itemX1Y1(tx, ty, res, r); } public COORDINATE itemX1Y1(int tx, int ty, DIR d, Coo res) { return itemX1Y1(tx + d.x(), ty + d.y(), res); } public COORDINATE itemX1Y1(COORDINATE c, Coo res) { return itemX1Y1(c.x(), c.y(), res); } void clean(int tile) { this.itemI[tile] = 0;
/* 629 */     this.tileI[tile] = 0;
/* 630 */     this.spriteDataI[tile] = 0;
/* 631 */     this.spriteDataI2[tile] = 0;
/* 632 */     this.masterTileI.set(tile, false);
/* 633 */     this.candleI.set(tile, false); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\MapDataF.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */