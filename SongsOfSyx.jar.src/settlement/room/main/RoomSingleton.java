/*     */ package settlement.room.main;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.Deleter;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoomSingleton
/*     */   extends Room
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int size;
/*  35 */   private final Rec tiles = new Rec(0.0D, 0.0D, 0.0D, 0.0D);
/*  36 */   private final Coo dataCoo = new Coo();
/*  37 */   private final Coo upperLeft = new Coo();
/*     */   
/*     */   private int dataTile;
/*     */   private int data;
/*     */   protected transient FurnisherItem item;
/*  42 */   protected static final transient RoomAreaWrapper wrap = new RoomAreaWrapper();
/*  43 */   protected static final transient RoomAreaWrapper wrapD = new RoomAreaWrapper();
/*     */   private transient ROOMA degA;
/*     */   private final Degrader degrader;
/*  46 */   public final RoomSingleton place(TmpArea area) { int mx = area.mx(); int my = area.my(); area.replaceAndClear(this); iniHard(mx, my); ROOMA a = wrap.init(this, mx, my); addAction(a); (SETT.ROOMS()).map.init(a); isolationSet(a.mX(), a.mY(), (SETT.ROOMS()).isolation.getProspect(blueprint(), a, null)); wrap.done(); SETT.MAINTENANCE().initRoomDegrade(this, a.mX(), a.mY()); return this; } protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) { RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile()); if (s != null) return s.render((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(i.tx(), i.ty()), (SETT.ROOMS()).fData.candle.is(i.tile()));  return false; } protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) { RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile()); if (s != null) s.renderAbove((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(i.tx(), i.ty()));  return false; } protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) { RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile()); if (s != null) s.renderBelow((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(i.tx(), i.ty()));  return false; } protected AVAILABILITY getAvailability(int tile) { FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tile); if (t != null) return t.availability;  return AVAILABILITY.ROOM; } public final Furnisher constructor() { return blueprintI().constructor(); } public boolean destroyTileCan(int tx, int ty) { return !(((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(tx, ty)).player >= 0.0D && ((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(tx, ty)).enemy >= 0.0D); } protected RoomSingleton(ROOMS m, RoomBlueprint p) { super(m, p, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     this.degrader = new Degrader(); }
/*     */   public void destroyTile(int tx, int ty) { iniHard(tx, ty); ConstructionInit init = new ConstructionInit(this, tx, ty, true); ROOMA ar = wrap.init(this, tx, ty); for (COORDINATE c : ar.body()) { if (!ar.is(c))
/*     */         continue;  (SETT.PATH()).availability.updateService(c.x(), c.y()); if (!((Terrain.TerrainTile)SETT.TERRAIN().get(c)).clearing().isStructure())
/*     */         (SETT.TERRAIN()).NADA.placeFixed(c.x(), c.y());  }
/*     */      wrap.done(); TmpArea a = remove(tx, ty, false, this, true); (SETT.ROOMS()).construction.breakIt(a, init, tx, ty); }
/*     */   public int area(int tx, int ty) { iniHard(tx, ty); return this.size; } public final TmpArea remove(int tx, int ty, boolean scatter, Object obj, boolean force) { iniHard(tx, ty); ROOMA a = wrap.init(this, tx, ty); (SETT.ROOMS()).stats.broken().remove(a.mX(), a.mY()); removeAction(a); if (scatter)
/*     */       Deleter.scatterMaterials(a, constructor(), upgrade(tx, ty), getDegrade(tx, ty));  for (COORDINATE c : a.body()) {
/*     */       if (!a.is(c))
/*     */         continue;  SETT.LIGHTS().remove(c.x(), c.y()); (SETT.FLOOR()).clearer.clear(c.x(), c.y()); (SETT.ROOMS()).data.set(a, c, 0); ConstructionData.dConstructed.set(a, c, 1); ConstructionData.dFloored.set(a, c, 1);
/*     */     }  TmpArea ar = (SETT.ROOMS()).map.delete(this, a.mX(), a.mY(), obj); wrap.done(); wrap.clear(); this.tiles.setDim(0.0D).moveX1Y1(-1.0D, -1.0D); return ar; } protected void addAction(ROOMA ins) {} protected void removeAction(ROOMA ins) {} public ROOM_DEGRADER degrader(int tx, int ty) { iniHard(tx, ty); this.degA = wrapD.init(this, this.dataCoo.x(), this.dataCoo.y()); wrapD.done(); return this.degrader; } private class Degrader extends ROOM_DEGRADER implements Serializable
/*     */   {
/* 195 */     public int resSize() { return RoomSingleton.this.item.group.blueprint.resources(); }
/*     */     
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public int resAmount(int i) {
/* 200 */       return (int)Math.ceil(RoomSingleton.this.item.cost2(i, RoomSingleton.this.upgrade(RoomSingleton.this.degA.mX(), RoomSingleton.this.degA.mY())));
/*     */     }
/*     */ 
/*     */     
/*     */     public RESOURCE res(int i) {
/* 205 */       return RoomSingleton.this.item.group.blueprint.resource(i);
/*     */     }
/*     */ 
/*     */     
/*     */     public double degRate() {
/* 210 */       return RoomSingleton.this.degradeResNeeded();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getData() {
/* 215 */       return RoomSingleton.this.data;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void setData(int v, boolean realDegradeChange) {
/* 220 */       double old = get();
/* 221 */       RoomSingleton.this.data = v;
/*     */       
/* 223 */       (SETT.ROOMS()).data.set(RoomSingleton.this.degA, RoomSingleton.this.dataTile, RoomSingleton.this.data);
/* 224 */       if (old != get()) {
/* 225 */         RoomSingleton.this.degradeChange(RoomSingleton.this.dataCoo.x(), RoomSingleton.this.dataCoo.y(), old, get(), realDegradeChange);
/*     */       }
/*     */     }
/*     */     
/*     */     public int roomArea() {
/* 230 */       return RoomSingleton.this.item.width() * RoomSingleton.this.item.height();
/*     */     }
/*     */ 
/*     */     
/*     */     public double base() {
/* 235 */       return RoomSingleton.this.blueprintI().degradeRate();
/*     */     }
/*     */ 
/*     */     
/*     */     public double expenseRate() {
/* 240 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double rate(double bonus) {
/* 245 */       double am = 0.0D;
/* 246 */       for (int ri = 0; ri < resSize(); ri++) {
/* 247 */         am += resAmount(ri);
/*     */       }
/* 249 */       return rate(bonus, base(), RoomSingleton.this.isolation(RoomSingleton.this.dataCoo.x(), RoomSingleton.this.dataCoo.y()), am, RoomSingleton.this.area(RoomSingleton.this.dataCoo.x(), RoomSingleton.this.dataCoo.y()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount(int ri, int upgrade) {
/* 255 */     return (int)Math.ceil(this.item.cost2(ri, upgrade));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void degradeChange(int mx, int my, double oldD, double newD, boolean realDegradeChange) {}
/*     */ 
/*     */   
/*     */   protected double degradeResNeeded() {
/* 263 */     return 0.5D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence name(int tx, int ty) {
/* 270 */     iniHard(tx, ty);
/* 271 */     if (blueprintI().constructor() != null && blueprintI().constructor().groups().size() > 1)
/* 272 */       return this.item.group.name; 
/* 273 */     return (blueprintI()).info.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public Icon icon() {
/* 278 */     return blueprintI().iconBig();
/*     */   }
/*     */   
/*     */   private final boolean ini(int tx, int ty) {
/* 282 */     if (this.tiles.holdsPoint(tx, ty) && this.item != null && this.item == (SETT.ROOMS()).fData.item.get(tx, ty)) {
/* 283 */       return true;
/*     */     }
/* 285 */     (SETT.ROOMS()).fData.itemX1Y1(tx, ty, this.upperLeft, this);
/* 286 */     this.item = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 287 */     this.dataCoo.set((COORDINATE)this.upperLeft);
/* 288 */     this.dataCoo.increment(this.item.firstX(), this.item.firstY());
/*     */     
/* 290 */     this.tiles.moveX1Y1((COORDINATE)this.upperLeft);
/* 291 */     this.tiles.setWidth(this.item.width());
/* 292 */     this.tiles.setHeight(this.item.height());
/* 293 */     this.size = this.item.width() * this.item.height();
/* 294 */     this.dataTile = this.dataCoo.x() + this.dataCoo.y() * SETT.TWIDTH;
/* 295 */     this.data = (SETT.ROOMS()).data.get(this.dataTile);
/*     */     
/* 297 */     return true;
/*     */   }
/*     */   
/*     */   protected void iniHard(int tx, int ty) {
/* 301 */     if (!ini(tx, ty)) {
/* 302 */       throw new RuntimeException("" + tx + " " + tx + " " + ty + " " + String.valueOf(this));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSame(int tx, int ty, int ox, int oy) {
/* 308 */     if (blueprint().is(tx, ty)) {
/* 309 */       iniHard(tx, ty);
/* 310 */       return iss(ox, oy);
/*     */     } 
/* 312 */     return false;
/*     */   }
/*     */   
/* 315 */   private static Coo upperLeftTest = new Coo();
/*     */   
/*     */   private boolean iss(int tx, int ty) {
/* 318 */     if (this.tiles.holdsPoint(tx, ty) && this.item == (SETT.ROOMS()).fData.item.get(tx, ty)) {
/* 319 */       (SETT.ROOMS()).fData.itemX1Y1(tx, ty, upperLeftTest, this);
/* 320 */       if (upperLeftTest.isSameAs((COORDINATE)this.upperLeft))
/* 321 */         return true; 
/*     */     } 
/* 323 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX(int tx, int ty) {
/* 328 */     iniHard(tx, ty);
/* 329 */     return this.dataCoo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY(int tx, int ty) {
/* 334 */     iniHard(tx, ty);
/* 335 */     return this.dataCoo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x1(int tx, int ty) {
/* 340 */     iniHard(tx, ty);
/* 341 */     return this.tiles.x1();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y1(int tx, int ty) {
/* 346 */     iniHard(tx, ty);
/* 347 */     return this.tiles.y1();
/*     */   }
/*     */ 
/*     */   
/*     */   public int width(int tx, int ty) {
/* 352 */     iniHard(tx, ty);
/* 353 */     return this.tiles.width();
/*     */   }
/*     */ 
/*     */   
/*     */   public int height(int tx, int ty) {
/* 358 */     iniHard(tx, ty);
/* 359 */     return this.tiles.height();
/*     */   }
/*     */   
/*     */   public abstract RoomBlueprintImp blueprintI();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomSingleton.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */