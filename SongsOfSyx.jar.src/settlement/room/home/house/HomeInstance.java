/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.Race;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.HGROUP;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.bit.BitsLong;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RecShort;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HomeInstance
/*     */   extends Room.RoomInstanceImp
/*     */   implements HOME
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final RecShort tiles;
/*     */   private long resourceData;
/*  49 */   private final HGROUP.HTypeBitsImp egroup = new HGROUP.HTypeBitsImp(true); private final int[] occupants;
/*     */   private byte litTimer;
/*     */   private final byte random;
/*     */   private byte isolation;
/*     */   private byte am;
/*     */   private byte amOdd;
/*     */   private byte renderTimer;
/*     */   private byte bitData;
/*     */   private final byte sx;
/*     */   private final byte sy;
/*  59 */   private static final Bits lit = new Bits(1);
/*  60 */   private static final Bits upgrade = new Bits(14);
/*  61 */   private static BitsLong[] resources = new BitsLong[8];
/*     */   static {
/*  63 */     for (int i = 0; i < resources.length; i++) {
/*  64 */       int m = 15 << i * 4;
/*  65 */       resources[i] = new BitsLong(m);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected HomeInstance(ROOM_HOME p, TmpArea a) {
/*  71 */     super(SETT.ROOMS(), (RoomBlueprint)p, false);
/*     */ 
/*     */ 
/*     */     
/*  75 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(a.mx(), a.my());
/*  76 */     int sx = 0;
/*  77 */     int sy = 0;
/*  78 */     for (int y = 0; y < it.height(); y++) {
/*  79 */       for (int x = 0; x < it.width(); x++) {
/*  80 */         if (it.get(x, y) == (SETT.ROOMS()).HOME.constructor.tOpening) {
/*  81 */           sx = x;
/*  82 */           sy = y;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  88 */     this.sx = (byte)sx;
/*  89 */     this.sy = (byte)sy;
/*     */     
/*  91 */     this.tiles = new RecShort(a.body());
/*  92 */     this.random = (byte)RND.rInt();
/*  93 */     int[] mo = (blueprintI()).constructor.maxOccupants[(it()).group.index()];
/*  94 */     this.occupants = Alloc.ii(mo[mo.length - 1]);
/*     */     
/*  96 */     a.replaceAndClear((Room)this);
/*  97 */     for (COORDINATE c : this.tiles) {
/*  98 */       if (is(c))
/*  99 */         (SETT.ROOMS()).extraBit.set(c, 0); 
/*     */     } 
/* 101 */     (SETT.ROOMS()).extraBit.set(serviceX(), serviceY(), 1);
/*     */     
/* 103 */     for (COORDINATE c : body()) {
/* 104 */       if (is(c)) {
/* 105 */         int m = 0;
/* 106 */         Sprite s = sprite(c.x(), c.y());
/*     */         
/* 108 */         if (s != null) {
/* 109 */           s.house = this;
/* 110 */           m = s.getData(c.x(), c.y(), c.x() - body().x1(), c.y() - body().y1(), it(), this.random);
/*     */         } 
/* 112 */         (SETT.ROOMS()).fData.spriteData.set(c.x(), c.y(), m);
/* 113 */         (SETT.PATH()).availability.updateAvailability(c.x(), c.y());
/* 114 */         (SETT.ROOMS()).extraBit.set(c, 0);
/*     */       } 
/*     */     } 
/*     */     
/* 118 */     isolationSet((SETT.ROOMS()).isolation.getProspect(blueprint(), (AREA)this, null));
/* 119 */     (blue()).odd.update(serviceX(), serviceY());
/* 120 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 125 */     return (SPRITE)(blueprintI()).icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 130 */     return (blueprintI()).constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 135 */     return this.tiles.x1() + it().firstX();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 140 */     return this.tiles.y1() + it().firstY();
/*     */   }
/*     */ 
/*     */   
/*     */   public int area() {
/* 145 */     return (it()).area;
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 150 */     return (RECTANGLE)this.tiles;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 155 */     return ((SETT.ROOMS()).map.indexGetter.get(tile) == this.roomI);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 160 */     RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile());
/* 161 */     if (s != null)
/* 162 */       return s.render((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(i.tx(), i.ty()), (SETT.ROOMS()).fData.candle.is(i.tile())); 
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 168 */     RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile());
/* 169 */     if (s != null) {
/* 170 */       s.renderAbove((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(i.tx(), i.ty()));
/*     */     }
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 177 */     RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile());
/* 178 */     if (s != null)
/* 179 */       s.renderBelow((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(i.tx(), i.ty())); 
/* 180 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name(int tx, int ty) {
/* 185 */     return Dic.empty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 192 */     AVAILABILITY a = (AVAILABILITY)(SETT.ROOMS()).fData.availability.get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/* 193 */     if (a == AVAILABILITY.ROOM) {
/* 194 */       int tx = tile % SETT.TWIDTH;
/* 195 */       int ty = tile / SETT.TWIDTH;
/* 196 */       Sprite s = sprite(tx, ty);
/* 197 */       if (s != null && s.solid)
/* 198 */         return AVAILABILITY.NOT_ACCESSIBLE; 
/*     */     } 
/* 200 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public TmpArea remove(int tx, int ty, boolean scatter, Object user, boolean forced) {
/* 205 */     dispose();
/* 206 */     (SETT.ROOMS()).stats.broken().remove(mX(), mY());
/* 207 */     TmpArea a = delete(tx, ty, user);
/* 208 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 213 */     return !(((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(tx, ty)).player >= 0.0D && ((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(tx, ty)).enemy >= 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 218 */     ConstructionInit init = new ConstructionInit((Room)this, tx, ty, true);
/* 219 */     TmpArea a = remove(tx, ty, false, this, true);
/* 220 */     (SETT.ROOMS()).construction.breakIt(a, init, tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 227 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount(int ri, int upgrade) {
/* 232 */     return (int)(it()).group.cost(ri, upgrade);
/*     */   }
/*     */   
/*     */   public ROOM_HOME blueprintI() {
/* 236 */     return (SETT.ROOMS()).HOME;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 241 */     return new State(this);
/*     */   }
/*     */   
/*     */   void dispose() {
/* 245 */     for (int i = 0; i < occupants(); i++) {
/* 246 */       Humanoid a = occupant(i);
/* 247 */       (STATS.HOME()).GETTER.set(a, null);
/* 248 */       i--;
/*     */     } 
/* 250 */     remove();
/*     */   }
/*     */ 
/*     */   
/*     */   public HOME vacate(Humanoid h) {
/* 255 */     remove();
/* 256 */     for (int oi = 0; oi < occupants(); oi++) {
/* 257 */       Humanoid o = occupant(oi);
/* 258 */       if (o == h) {
/* 259 */         this.occupants[oi] = 0;
/* 260 */         this.am = (byte)(this.am - 1);
/* 261 */         if ((STATS.WORK()).EMPLOYED.get(o) == null)
/* 262 */           this.amOdd = (byte)(this.amOdd - 1); 
/* 263 */         for (int k = oi + 1; k < occupantsMax(); k++) {
/* 264 */           this.occupants[k - 1] = this.occupants[k];
/*     */         }
/* 266 */         add();
/* 267 */         if (this.am == 0)
/* 268 */           turnOffLight(); 
/* 269 */         (SETT.ROOMS()).HOME.odd.update(serviceX(), serviceY());
/* 270 */         return this;
/*     */       } 
/*     */     } 
/*     */     
/* 274 */     throw new RuntimeException(String.valueOf(h) + " " + String.valueOf(h) + " " + this.am);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HOME occupy(Humanoid h) {
/* 280 */     if (this.am >= occupantsMax()) {
/* 281 */       if (this.amOdd == 0)
/* 282 */         throw new RuntimeException(String.valueOf(h) + " " + String.valueOf(h) + " " + this.am); 
/* 283 */       vacateOddjobber();
/*     */     } 
/* 285 */     remove();
/* 286 */     if (h != SETT.ENTITIES().getByID(h.id()))
/* 287 */       throw new RuntimeException("" + h.id()); 
/* 288 */     this.occupants[this.am] = h.id();
/* 289 */     this.am = (byte)(this.am + 1);
/* 290 */     if ((STATS.WORK()).EMPLOYED.get(h) == null)
/* 291 */       this.amOdd = (byte)(this.amOdd + 1); 
/* 292 */     add();
/* 293 */     return this;
/*     */   }
/*     */   
/*     */   private void vacateOddjobber() {
/* 297 */     if (this.amOdd == 0) {
/*     */       return;
/*     */     }
/* 300 */     for (int i = 0; i < this.am; i++) {
/* 301 */       Humanoid o = occupant(i);
/* 302 */       if ((STATS.WORK()).EMPLOYED.get(o) == null) {
/* 303 */         (STATS.HOME()).GETTER.set(o, null);
/*     */         return;
/*     */       } 
/*     */     } 
/* 307 */     throw new RuntimeException("" + this.am + " " + this.am);
/*     */   }
/*     */   
/*     */   public HOME use() {
/* 311 */     this.litTimer = (byte)(GAME.updateI() >> 8 & 0xFF);
/* 312 */     if (lit.get(this.bitData) == 1) {
/* 313 */       return this;
/*     */     }
/* 315 */     this.bitData = (byte)lit.set(this.bitData, 1);
/*     */     
/* 317 */     for (COORDINATE c : this.tiles) {
/* 318 */       if (is(c)) {
/* 319 */         Sprite sprite = sprite(c.x(), c.y());
/* 320 */         if (sprite != null && sprite == (blue()).constructor.sp.nSta && !SETT.LIGHTS().is(c.x(), c.y())) {
/* 321 */           SETT.LIGHTS().candle(c.x(), c.y(), 1);
/*     */         }
/*     */       } 
/*     */     } 
/* 325 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void turnOffLight() {
/* 331 */     this.bitData = (byte)lit.set(this.bitData, 0);
/* 332 */     for (COORDINATE c : this.tiles) {
/* 333 */       if (is(c)) {
/* 334 */         Sprite sprite = sprite(c.x(), c.y());
/* 335 */         if (sprite != null && sprite == (blue()).constructor.sp.nSta && SETT.LIGHTS().is(c.x(), c.y())) {
/* 336 */           SETT.LIGHTS().remove(c.x(), c.y());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid occupant(int oi) {
/* 344 */     if (oi < this.am) {
/* 345 */       int i = this.occupants[oi];
/* 346 */       ENTITY e = SETT.ENTITIES().getByID(i);
/* 347 */       if (e != null && e instanceof Humanoid) {
/* 348 */         return (Humanoid)e;
/*     */       }
/* 350 */       throw new RuntimeException("" + oi + " " + oi + " " + String.valueOf(this.tiles));
/*     */     } 
/* 352 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int occupants() {
/* 357 */     return this.am;
/*     */   }
/*     */   
/*     */   public int occupantsOdd() {
/* 361 */     return this.amOdd;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serviceX() {
/* 366 */     return this.tiles.x1() + this.sx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int serviceY() {
/* 371 */     return this.tiles.y1() + this.sy;
/*     */   }
/*     */   
/*     */   Sprite sprite(int tx, int ty) {
/* 375 */     int ri = this.random & 0xFF;
/*     */     
/* 377 */     ri %= ((blue()).constructor.sp.sp.sprites[(it()).group.index()]).length;
/*     */     
/* 379 */     SpriteConfig sp = (blue()).constructor.sp.sp.sprites[(it()).group.index()][ri];
/* 380 */     int dx = tx - this.tiles.x1();
/* 381 */     int dy = ty - this.tiles.y1();
/* 382 */     return (Sprite)sp.get((it()).rotation).get(dx, dy);
/*     */   }
/*     */   
/*     */   public DIR dir() {
/* 386 */     return (DIR)DIR.ORTHO.get((it()).rotation);
/*     */   }
/*     */   
/*     */   public HGROUP.HTypeBits availability() {
/* 390 */     if (this.am - this.amOdd >= occupantsMax())
/* 391 */       return null; 
/* 392 */     return psetting();
/*     */   }
/*     */   
/*     */   public void settingSet(HGROUP.HTypeBits bits) {
/* 396 */     for (int i = 0; i < this.am; i++) {
/* 397 */       Humanoid o = occupant(i);
/* 398 */       if (!bits.is(o)) {
/* 399 */         i--;
/* 400 */         (STATS.HOME()).GETTER.set(o, null);
/*     */       } 
/*     */     } 
/* 403 */     remove();
/* 404 */     this.egroup.copy(bits);
/* 405 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canOccupy(Humanoid h) {
/* 410 */     return (availability() != null && availability().is(h));
/*     */   }
/*     */   
/*     */   private HGROUP.HTypeBits psetting() {
/* 414 */     if (occupants() > 0)
/* 415 */       return HGROUP.HTypeBitsImp.specific(HGROUP.get(occupant(0))); 
/* 416 */     return setting();
/*     */   }
/*     */   
/*     */   public HGROUP.HTypeBits setting() {
/* 420 */     return (HGROUP.HTypeBits)this.egroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void remove() {
/* 427 */     (SETT.ROOMS()).HOME.report(-this.am, -occupantsMax(), psetting());
/* 428 */     if (availability() != null) {
/* 429 */       (SETT.PATH()).comps.data.home.reportAbsence(serviceX(), serviceY(), availability());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void add() {
/* 436 */     (SETT.ROOMS()).HOME.report(this.am, occupantsMax(), psetting());
/* 437 */     if (availability() != null) {
/* 438 */       (SETT.PATH()).comps.data.home.reportPresence(serviceX(), serviceY(), availability());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 443 */   private static final DirCoo dcoo = new DirCoo();
/*     */ 
/*     */   
/*     */   public static class DirCoo
/*     */     extends Coo
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     public DIR dir;
/*     */     public boolean isLay;
/*     */   }
/*     */   
/*     */   public int occupantsMax() {
/* 455 */     return (blueprintI()).constructor.maxOccupants[(it()).group.index()][upgrade.get(this.bitData)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int resourceAm(int ri) {
/* 461 */     resCount();
/* 462 */     return resources[ri].get(this.resourceData);
/*     */   }
/*     */ 
/*     */   
/*     */   private void resCount() {
/* 467 */     unuse();
/* 468 */     if (occupants() == 0)
/*     */       return; 
/* 470 */     if ((this.renderTimer & 0xFF) != (GAME.updateI() >> 8 & 0xFF)) {
/* 471 */       this.renderTimer = (byte)(GAME.updateI() >> 8 & 0xFF);
/* 472 */       int ri = 0;
/* 473 */       for (RES_AMOUNT a : occupant(0).race().home().clas(occupant(0)).resources()) {
/* 474 */         double am = 0.0D;
/* 475 */         for (int i = 0; i < occupants(); i++) {
/* 476 */           am += STATS.HOME().current(occupant(i), ri);
/*     */         }
/* 478 */         this.resourceData = resources[ri].set(this.resourceData, (int)Math.ceil(am / occupants()));
/* 479 */         ri++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void unuse() {
/* 485 */     if (lit.get(this.bitData) == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 489 */     if (Bits.getDistance(this.litTimer, GAME.updateI() >> 8, 255) > 15) {
/* 490 */       turnOffLight();
/*     */     }
/*     */     
/* 493 */     this.litTimer = (byte)(GAME.updateI() >> 8 & 0xFF);
/*     */   }
/*     */   
/*     */   public DirCoo getService(int tx, int ty) {
/* 497 */     Sprite s = sprite(tx, ty);
/* 498 */     if (s != null && s.service) {
/* 499 */       dcoo.dir = s.dir((SETT.ROOMS()).fData.spriteData.get(tx, ty));
/* 500 */       dcoo.set(tx, ty);
/* 501 */       dcoo.isLay = (s == (blue()).constructor.sp.bedS);
/* 502 */       return dcoo;
/*     */     } 
/* 504 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DirCoo findService(Humanoid h) {
/* 511 */     int rx = body().x1() + RND.rInt(it().width());
/* 512 */     int ry = body().y1() + RND.rInt(it().height());
/*     */     
/* 514 */     for (int y = 0; y < it().height(); y++) {
/* 515 */       for (int x = 0; x < it().width(); x++) {
/*     */         
/* 517 */         DirCoo c = getService(rx, ry);
/* 518 */         if (c != null && SETT.ENTITIES().getAtTileSingle(rx, ry) == null) {
/* 519 */           return c;
/*     */         }
/* 521 */         rx++;
/* 522 */         if (rx >= this.tiles.x1() + it().width()) {
/* 523 */           rx = this.tiles.x1();
/* 524 */           ry++;
/* 525 */           if (ry >= this.tiles.y1() + it().height()) {
/* 526 */             ry = this.tiles.y1();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 531 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double isolation() {
/* 539 */     return (this.isolation & 0xFF) / 255.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void isolationSet(int tx, int ty, double isolation) {
/* 544 */     isolationSet(isolation);
/*     */   }
/*     */   
/*     */   public HomeInstance isolationSet(double am) {
/* 548 */     this.isolation = (byte)(int)(am * 255.0D);
/* 549 */     return this;
/*     */   }
/*     */   
/*     */   public static ROOM_HOME blue() {
/* 553 */     return (SETT.ROOMS()).HOME;
/*     */   }
/*     */   
/*     */   public Race race() {
/* 557 */     return occupant(0).race();
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int upgrade) {
/* 562 */     if (upgrade <= upgrade()) {
/*     */       return;
/*     */     }
/*     */     
/* 566 */     remove();
/*     */ 
/*     */ 
/*     */     
/* 570 */     this.bitData = (byte)HomeInstance.upgrade.set(this.bitData, upgrade);
/* 571 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int upgrade() {
/* 577 */     return upgrade.get(this.bitData);
/*     */   }
/*     */   
/*     */   public FurnisherItem it() {
/* 581 */     return (FurnisherItem)(SETT.ROOMS()).fData.item.get(serviceX(), serviceY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class State
/*     */     extends RoomState
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/* 595 */     public final HGROUP.HTypeBitsImp egroup = new HGROUP.HTypeBitsImp(true); State(HomeInstance h) {
/* 596 */       if (h != null) {
/* 597 */         this.egroup.copy((HGROUP.HTypeBits)h.egroup);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void apply(Room r, int tx, int ty) {
/* 603 */       HomeInstance h = (HomeInstance)r;
/* 604 */       h.settingSet((HGROUP.HTypeBits)this.egroup);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void applyRepaired(Room r, int tx, int ty) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence typeName(int tx, int ty) {
/* 618 */     return ((FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty)).group.name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\HomeInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */