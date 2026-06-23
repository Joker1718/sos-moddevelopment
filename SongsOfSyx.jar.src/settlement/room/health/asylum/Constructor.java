/*     */ package settlement.room.health.asylum;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_ASYLUM blue;
/*  36 */   final FurnisherStat prisoners = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  37 */   final FurnisherStat guards = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */   
/*     */   private final RoomSprite1x1 sCandle;
/*     */   
/*     */   private final Floors.Floor floor2;
/*     */   private final RoomSprite sWalls;
/*     */   private final RoomSprite sBars;
/*     */   private final RoomSprite sOpening;
/*     */   static final int CODE_ENTRANCE = 1;
/*     */   static final int CODE_FOOD = 2;
/*     */   
/*     */   protected Constructor(final ROOM_ASYLUM blue, RoomInitData init) throws IOException {
/*  49 */     super(init, 1, 2, 88, 44);
/*  50 */     this.blue = blue;
/*  51 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.get(init.data().value("FLOOR2"), init.data());
/*     */     
/*  53 */     Json sjson = init.data().json("SPRITES");
/*     */     
/*  55 */     this.sWalls = (RoomSprite)new RoomSpriteCombo(sjson, "WALLS_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  59 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry) != Constructor.this.sCandle);
/*     */         }
/*     */       };
/*     */     
/*  63 */     this.sBars = (RoomSprite)new RoomSprite1x1(sjson, "BARS_1X1");
/*     */     
/*  65 */     this.sOpening = (RoomSprite)new RoomSprite1x1(sjson, "OPENING_1X1");
/*     */     
/*  67 */     RoomSprite.Dummy dummy1 = new RoomSprite.Dummy()
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  71 */           Constructor.this.prenderAbove(r, s, it, degrade, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  77 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  82 */     RoomSprite.Dummy dummy2 = new RoomSprite.Dummy()
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  86 */           Constructor.this.prenderAbove(r, s, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  92 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  98 */     RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sjson, "DECOR_1X1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 101 */           Constructor.this.prenderAbove(r, s, it, degrade, true);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 106 */           return (DIR.ORTHO.getC(item.rotation + 3) == d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 112 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 118 */     RoomSpriteCombo stablemisc = new RoomSpriteCombo(sjson, "TABLE_COMBO", sjson)
/*     */       {
/*     */         RoomSprite sTableTop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 140 */           Constructor.this.prenderAbove(r, s, it, degrade, true);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 145 */           return this.sTableTop.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 151 */           super.render(r, s, data, it, degrade, isCandle);
/* 152 */           if (blue.is(it.tile()) && ((AsylumInstance)blue.get(it.tx(), it.ty())).isReserved(it.tx(), it.ty())) {
/* 153 */             this.sTableTop.render(r, s, (SETT.ROOMS()).fData.spriteData2.get(it.tile()), it, degrade, isCandle);
/*     */           }
/* 155 */           this.sTableTop.render(r, s, (SETT.ROOMS()).fData.spriteData2.get(it.tile()), it, degrade, isCandle);
/* 156 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 162 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */     
/* 166 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sjson, "TABLE_COMBO")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 170 */           Constructor.this.prenderAbove(r, s, it, degrade, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 176 */           super.render(r, s, data, it, degrade, isCandle);
/* 177 */           if (blue.is(it.tile())) {
/* 178 */             int am = Food.food((SETT.ROOMS()).data.get(it.tile()));
/* 179 */             ((IndustryResource)blue.consumtion.ins().get(0)).resource.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */           } 
/* 181 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 187 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */     
/* 191 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sjson, "BED_1X1_TOP", true)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 194 */           Constructor.this.prenderAbove(r, s, it, degrade, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 200 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */     
/* 204 */     RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sjson, "BED_1X1_BOTTOM", false)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 207 */           Constructor.this.prenderAbove(r, s, it, degrade, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 213 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */     
/* 217 */     this.sCandle = new RoomSprite1x1(sjson, "CANDLE_HOLDER_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 221 */           return (item.get(rx, ry) != null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 227 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */     
/* 231 */     FurnisherItemTile b1 = new FurnisherItemTile(
/* 232 */         this, 
/* 233 */         (RoomSprite)roomSprite1xN1, 
/* 234 */         AVAILABILITY.NOT_ACCESSIBLE, false);
/* 235 */     FurnisherItemTile b2 = new FurnisherItemTile(
/* 236 */         this, 
/* 237 */         (RoomSprite)roomSprite1xN2, 
/* 238 */         AVAILABILITY.NOT_ACCESSIBLE, false);
/*     */     
/* 240 */     FurnisherItemTile c1 = new FurnisherItemTile(
/* 241 */         this, 
/* 242 */         (RoomSprite)this.sCandle, 
/* 243 */         AVAILABILITY.AVOID_PASS, true);
/* 244 */     FurnisherItemTile oo = new FurnisherItemTile(
/* 245 */         this, 
/* 246 */         (RoomSprite)dummy1, 
/* 247 */         AVAILABILITY.AVOID_PASS, false);
/* 248 */     FurnisherItemTile ni = new FurnisherItemTile(
/* 249 */         this, 
/* 250 */         (RoomSprite)roomSprite1x1, 
/* 251 */         AVAILABILITY.ROOM_SOLID, false);
/* 252 */     FurnisherItemTile ta = new FurnisherItemTile(
/* 253 */         this, 
/* 254 */         (RoomSprite)stablemisc, 
/* 255 */         AVAILABILITY.ROOM_SOLID, false);
/* 256 */     FurnisherItemTile fo = (new FurnisherItemTile(
/* 257 */         this, 
/* 258 */         (RoomSprite)roomSpriteCombo1, 
/* 259 */         AVAILABILITY.ROOM_SOLID, false)).setData(2);
/*     */     
/* 261 */     FurnisherItemTile ss = (new FurnisherItemTile(
/* 262 */         this, 
/* 263 */         true, 
/* 264 */         (RoomSprite)dummy2, 
/* 265 */         AVAILABILITY.AVOID_PASS, 
/* 266 */         false)).setData(1);
/*     */     
/* 268 */     FurnisherItemTile __ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isWithinCell(int nx, int ny, int cx, int cy) {
/* 285 */     if ((SETT.ROOMS()).fData.item.get(nx, ny) != null && (SETT.ROOMS()).fData.sprite.get(nx, ny) != this.sCandle && (SETT.ROOMS()).fData.item.get(cx, cy) != null) {
/* 286 */       COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(nx, ny, Coo.TMP);
/* 287 */       nx = c.x();
/* 288 */       ny = c.y();
/* 289 */       return (SETT.ROOMS()).fData.itemX1Y1(cx, cy, Coo.TMP).isSameAs(nx, ny);
/*     */     } 
/* 291 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 303 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 308 */     return (Room)new AsylumInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 313 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 318 */     FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 319 */     if (t != null && t.sprite() != this.sCandle) {
/* 320 */       this.floor2.placeFixed(tx, ty);
/*     */     } else {
/* 322 */       super.putFloor(tx, ty, upgrade, area);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void prenderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, double degrade, boolean wall) {
/* 332 */     FurnisherItem i = (FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tx(), it.ty());
/* 333 */     this.sBars.render(r, s, i.rotation, it, degrade, false);
/*     */     
/* 335 */     if (!wall) {
/* 336 */       this.sOpening.render(r, s, i.rotation + 2 & 0x3, it, degrade, false);
/*     */       
/*     */       return;
/*     */     } 
/* 340 */     COORDINATE coo = (SETT.ROOMS()).fData.itemMaster(it.tx(), it.ty(), Coo.TMP);
/* 341 */     int mX = coo.x();
/* 342 */     int mY = coo.y();
/*     */     
/* 344 */     RoomInstance ro = (RoomInstance)(SETT.ROOMS()).map.instance.get(it.tx(), it.ty());
/* 345 */     if (ro == null)
/*     */       return; 
/* 347 */     int m = 0;
/* 348 */     for (DIR d : DIR.ORTHO) {
/* 349 */       if (ro.is(it.tx(), it.ty(), d) && (SETT.ROOMS()).fData.sprite.get(it.tx(), it.ty(), d) != this.sCandle && (SETT.ROOMS()).fData.item.get(it.tx(), it.ty(), d) != null) {
/* 350 */         coo = (SETT.ROOMS()).fData.itemMaster(it.tx() + d.x(), it.ty() + d.y(), Coo.TMP);
/* 351 */         if (coo != null && coo.isSameAs(mX, mY)) {
/* 352 */           m |= d.mask();
/*     */         }
/*     */       } 
/*     */     } 
/* 356 */     this.sWalls.render(r, s, m, it, degrade, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 361 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */