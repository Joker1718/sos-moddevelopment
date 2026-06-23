/*     */ package settlement.room.service.pleasure;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherItemTools;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_PLEASURE blue;
/*  41 */   final FurnisherStat beds = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*  42 */   final FurnisherStat coziness = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.beds);
/*  43 */   final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */   
/*     */   private final FurnisherItemTile ww;
/*     */   
/*     */   private final Floors.Floor floor2;
/*     */   
/*     */   private static final int IIN = 1;
/*     */   public static final int ISERVICE = 2;
/*     */   private static final int IWALL = 3;
/*     */   private final RoomSpriteCombo walls;
/*     */   FurnisherItemGroup mgroup;
/*  54 */   private final COLOR[] pixCols = new COLOR[256];
/*     */ 
/*     */   
/*     */   protected Constructor(ROOM_PLEASURE blue, RoomInitData init) throws IOException {
/*  58 */     super(init, 3, 3, 88, 44);
/*  59 */     this.blue = blue;
/*  60 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.get(init.data().value("FLOOR2"), init.data());
/*     */     
/*  62 */     Json sp = init.data().json("SPRITES");
/*     */ 
/*     */     
/*  65 */     ColorImp colorImp = new ColorImp(init.data(), "COLOR_PIXEL_BASE");
/*     */     
/*  67 */     for (int i = 0; i < this.pixCols.length; i++) {
/*  68 */       int r = colorImp.red();
/*  69 */       int g = colorImp.green();
/*  70 */       int b = colorImp.blue();
/*  71 */       double hue = 0.25D + 0.5D * RND.rFloat();
/*     */ 
/*     */       
/*  74 */       r = (int)(hue * r + (RND.rFloat() * 5.0F));
/*  75 */       g = (int)(hue * g + (RND.rFloat() * 5.0F));
/*  76 */       b = (int)(hue * b + (RND.rFloat() * 5.0F));
/*  77 */       this.pixCols[i] = (COLOR)new ColorImp(r, g, b);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  82 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "BED_HEAD_1X1", false);
/*  83 */     RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "BED_TAIL_1X1", true);
/*     */     
/*  85 */     final RoomSprite1x1 stop = new RoomSprite1x1(sp, "TABLE_TOP_1X1");
/*     */ 
/*     */ 
/*     */     
/*  89 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  95 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/*  96 */             stop.render(r, s, data, it, degrade, false);
/*     */           }
/*     */         }
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 101 */           return stop.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 106 */     final RoomSprite sNone = new RoomSprite()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 111 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 117 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 122 */           return 0;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int sData() {
/* 128 */           return 0;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 133 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "SHELF_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 139 */           this.top.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 144 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 151 */           if (item.width() >= 3 && item.height() >= 3) {
/*     */             
/* 153 */             rx -= d.x() * 2;
/* 154 */             ry -= d.y() * 2;
/*     */             
/* 156 */             return (item.get(rx, ry) != null && item.sprite(rx, ry) == sNone);
/*     */           } 
/*     */           
/* 159 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 165 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "NICKNACK_1X1")
/*     */       {
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 170 */           if (item.width() >= 3 && item.height() >= 3) {
/*     */             
/* 172 */             rx -= d.x() * 2;
/* 173 */             ry -= d.y() * 2;
/*     */             
/* 175 */             return (item.get(rx, ry) != null && item.sprite(rx, ry) == sNone);
/*     */           } 
/*     */           
/* 178 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 184 */     this.walls = new RoomSpriteCombo(sp, "WALLS_COMBO");
/*     */ 
/*     */     
/* 187 */     FurnisherItemTile b1 = (new FurnisherItemTile(
/* 188 */         this, 
/* 189 */         (RoomSprite)roomSprite1xN1, 
/* 190 */         AVAILABILITY.ROOM_SOLID, 
/* 191 */         false)).setData(3);
/* 192 */     FurnisherItemTile b2 = (new FurnisherItemTile(
/* 193 */         this, 
/* 194 */         (RoomSprite)roomSprite1xN2, 
/* 195 */         AVAILABILITY.ROOM_SOLID, 
/* 196 */         false)).setData(3);
/*     */     
/* 198 */     this.ww = (new FurnisherItemTile(
/* 199 */         this, 
/* 200 */         false, 
/* 201 */         sNone, 
/* 202 */         AVAILABILITY.ROOM, false)).setData(2);
/*     */ 
/*     */     
/* 205 */     FurnisherItemTile ta = (new FurnisherItemTile(
/* 206 */         this, 
/* 207 */         (RoomSprite)roomSpriteCombo, 
/* 208 */         AVAILABILITY.ROOM_SOLID, true)).setData(3);
/*     */     
/* 210 */     FurnisherItemTile __ = (new FurnisherItemTile(
/* 211 */         this, 
/* 212 */         true, 
/* 213 */         sNone, 
/* 214 */         AVAILABILITY.ROOM, 
/* 215 */         false)).setData(1);
/*     */     
/* 217 */     FurnisherItemTile sh = (new FurnisherItemTile(
/* 218 */         this, 
/* 219 */         (RoomSprite)roomSprite1x12, 
/* 220 */         AVAILABILITY.ROOM_SOLID, 
/* 221 */         false)).setData(3);
/*     */     
/* 223 */     FurnisherItemTile ch = (new FurnisherItemTile(
/* 224 */         this, 
/* 225 */         (RoomSprite)roomSprite1x13, 
/* 226 */         AVAILABILITY.ROOM_SOLID, 
/* 227 */         false)).setData(3);
/*     */     
/* 229 */     FurnisherItemTile ns = new FurnisherItemTile(
/* 230 */         this, 
/* 231 */         (RoomSprite)roomSprite1x12, 
/* 232 */         AVAILABILITY.ROOM_SOLID, 
/* 233 */         false);
/*     */     
/* 235 */     FurnisherItemTile nt = new FurnisherItemTile(
/* 236 */         this, 
/* 237 */         (RoomSprite)roomSpriteCombo, 
/* 238 */         AVAILABILITY.ROOM_SOLID, 
/* 239 */         true);
/*     */     
/* 241 */     FurnisherItemTile ni = new FurnisherItemTile(
/* 242 */         this, 
/* 243 */         (RoomSprite)roomSprite1x13, 
/* 244 */         AVAILABILITY.ROOM_SOLID, 
/* 245 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     this.mgroup = flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 305 */     flush(3);
/*     */     
/* 307 */     FurnisherItemTools.makeUnder(this, sp, "CARPET_COMBO");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 323 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 333 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aboveR(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, double degrade) {
/* 339 */     if ((SETT.ROOMS()).fData.tileData.get(it.tile()) > 0) {
/*     */       
/* 341 */       boolean blur = (this.blue.bed.init(it.tx(), it.ty()) != null && this.blue.bed.clientUndressed.get() == 1);
/* 342 */       int m = 0;
/* 343 */       for (DIR d : DIR.ALL) {
/* 344 */         if ((SETT.ROOMS()).fData.tile.get(it.tx(), it.ty(), d) == this.ww) {
/* 345 */           if (!d.isOrtho()) {
/* 346 */             m |= d.next(-1).mask();
/* 347 */             m |= d.next(1).mask();
/*     */           } else {
/* 349 */             m |= d.mask();
/* 350 */             m |= d.next(-2).mask();
/* 351 */             m |= d.next(2).mask();
/*     */           } 
/* 353 */           if (!blur) {
/* 354 */             ABed b = this.blue.bed.init(it.tx() + d.x(), it.ty() + d.y());
/* 355 */             if (b != null && b.clientUndressed.get() == 1) {
/* 356 */               blur = true;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 361 */       double rs = VIEW.renderSecond();
/*     */       
/* 363 */       if (blur) {
/* 364 */         long ran = GUTIL.ran2().get(it.tile());
/* 365 */         ran <<= 32L;
/* 366 */         ran |= GUTIL.ran1().get(it.tile());
/* 367 */         int D = 16;
/* 368 */         for (int y = 0; y < 4; y++) {
/* 369 */           for (int x = 0; x < 4; x++) {
/* 370 */             int ci = (int)((ran & 0xFFL) + rs * 10.0D);
/* 371 */             this.pixCols[ci % 255].render(r, it.x() + D * x, it.x() + D * x + D, 
/* 372 */                 it.y() + D * y, it.y() + D * y + D);
/* 373 */             ran >>= 4L;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 378 */       if ((SETT.ROOMS()).fData.tileData.get(it.tile()) > 1 && 
/* 379 */         m != 0 && m != 15) {
/* 380 */         this.walls.render(r, s, m, it, degrade, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 393 */     FurnisherItem t = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 394 */     if (t != null && t.group() == this.mgroup) {
/* 395 */       this.floor2.placeFixed(tx, ty);
/*     */     } else {
/* 397 */       super.putFloor(tx, ty, upgrade, area);
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 420 */     return (Room)new PleasureInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 425 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */