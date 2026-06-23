/*     */ package settlement.room.infra.inn;
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
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_INN blue;
/*  35 */   final FurnisherStat beds = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*  36 */   final FurnisherStat coziness = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.beds);
/*  37 */   final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */   
/*     */   final FurnisherItemTile cc;
/*     */   
/*     */   private final Floors.Floor floor2;
/*     */   
/*     */   public static final int IHEAD = 1;
/*     */   public static final int ITAIL = 2;
/*     */   private static final int IWALL = 3;
/*     */   private final RoomSpriteCombo walls;
/*     */   FurnisherItemGroup mgroup;
/*     */   
/*     */   protected Constructor(final ROOM_INN blue, RoomInitData init) throws IOException {
/*  50 */     super(init, 3, 3, 88, 44);
/*  51 */     this.blue = blue;
/*  52 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.get(init.data().value("FLOOR2"), init.data());
/*     */     
/*  54 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  56 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "BED_UNMADE_HEAD_1X1", false, sp)
/*     */       {
/*     */         final RoomSprite made;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  64 */           int x = it.tx() + offX(data);
/*  65 */           int y = it.ty() + offY(data);
/*  66 */           if (blue.is(it.tile()) && ABed.isUnmade(x, y))
/*  67 */             return super.render(r, s, data, it, degrade, isCandle); 
/*  68 */           return this.made.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  73 */     RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "BED_UNMADE_TAIL_1X1", true, sp)
/*     */       {
/*     */         final RoomSprite made;
/*     */         
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  81 */           int x = it.tx() + offX(data);
/*  82 */           int y = it.ty() + offY(data);
/*  83 */           if (blue.is(it.tile()) && ABed.isUnmade(x, y)) {
/*  84 */             super.render(r, s, data, it, degrade, isCandle);
/*  85 */             if (blue.is(it.tile()) && ABed.isClaimed(x, y))
/*  86 */               this.top.render(r, s, getData2(it), it, degrade, false); 
/*  87 */             return false;
/*     */           } 
/*  89 */           return this.made.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  95 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/*  99 */     final RoomSprite1x1 stop = new RoomSprite1x1(sp, "TABLE_TOP_1X1");
/*     */     
/* 101 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 107 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 108 */             stop.render(r, s, data, it, degrade, false);
/*     */           }
/*     */         }
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 113 */           return stop.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 118 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "SHELF_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 124 */           this.top.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 129 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 134 */           if (item.width() >= 3 && item.height() >= 3) {
/* 135 */             return !item.is(rx, ry);
/*     */           }
/* 137 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 142 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "CHEST_1X1");
/*     */     
/* 144 */     RoomSprite sNone = new RoomSprite()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 149 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 155 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 160 */           return 0;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int sData() {
/* 166 */           return 0;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 171 */     this.walls = new RoomSpriteCombo(sp, "WALLS_COMBO");
/*     */     
/* 173 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "NICKNACK_1X1");
/*     */     
/* 175 */     FurnisherItemTile h1 = (new FurnisherItemTile(
/* 176 */         this, 
/* 177 */         (RoomSprite)roomSprite1xN1, 
/* 178 */         AVAILABILITY.AVOID_LIKE_FUCK, 
/* 179 */         false)).setData(1).setData(1);
/* 180 */     FurnisherItemTile t1 = (new FurnisherItemTile(
/* 181 */         this, 
/* 182 */         (RoomSprite)roomSprite1xN2, 
/* 183 */         AVAILABILITY.AVOID_LIKE_FUCK, 
/* 184 */         false)).setData(2).setData(2);
/* 185 */     this.cc = (new FurnisherItemTile(
/* 186 */         this, 
/* 187 */         sNone, 
/* 188 */         AVAILABILITY.ROOM, false)).setData(3);
/* 189 */     FurnisherItemTile ta = (new FurnisherItemTile(
/* 190 */         this, 
/* 191 */         (RoomSprite)roomSpriteCombo, 
/* 192 */         AVAILABILITY.ROOM_SOLID, true)).setData(3);
/*     */     
/* 194 */     FurnisherItemTile ss = new FurnisherItemTile(
/* 195 */         this, 
/* 196 */         true, 
/* 197 */         sNone, 
/* 198 */         AVAILABILITY.ROOM, 
/* 199 */         false);
/*     */     
/* 201 */     FurnisherItemTile sh = (new FurnisherItemTile(
/* 202 */         this, 
/* 203 */         (RoomSprite)roomSprite1x12, 
/* 204 */         AVAILABILITY.ROOM_SOLID, 
/* 205 */         false)).setData(1).setData(3);
/*     */     
/* 207 */     FurnisherItemTile ch = (new FurnisherItemTile(
/* 208 */         this, 
/* 209 */         (RoomSprite)roomSprite1x13, 
/* 210 */         AVAILABILITY.ROOM_SOLID, 
/* 211 */         false)).setData(1).setData(3);
/*     */     
/* 213 */     FurnisherItemTile nt = new FurnisherItemTile(
/* 214 */         this, 
/* 215 */         (RoomSprite)roomSpriteCombo, 
/* 216 */         AVAILABILITY.ROOM_SOLID, 
/* 217 */         true);
/*     */     
/* 219 */     FurnisherItemTile ni = new FurnisherItemTile(
/* 220 */         this, 
/* 221 */         (RoomSprite)roomSprite1x14, 
/* 222 */         AVAILABILITY.ROOM_SOLID, 
/* 223 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     this.mgroup = flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     flush(3);
/*     */     
/* 281 */     FurnisherItemTools.makeUnder(this, sp, "CARPET_COMBO");
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
/* 297 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 302 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 307 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void aboveR(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, double degrade) {
/* 313 */     if ((SETT.ROOMS()).fData.tileData.get(it.tile()) != 0) {
/* 314 */       int m = 0;
/* 315 */       for (DIR d : DIR.ALL) {
/* 316 */         if ((SETT.ROOMS()).fData.tile.get(it.tx(), it.ty(), d) == this.cc) {
/* 317 */           if (!d.isOrtho()) {
/* 318 */             m |= d.next(-1).mask();
/* 319 */             m |= d.next(1).mask(); continue;
/*     */           } 
/* 321 */           m |= d.mask();
/* 322 */           m |= d.next(-2).mask();
/* 323 */           m |= d.next(2).mask();
/*     */         } 
/*     */       } 
/*     */       
/* 327 */       if (m != 0 && m != 15) {
/* 328 */         this.walls.render(r, s, m, it, degrade, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 337 */     FurnisherItem t = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 338 */     if (t != null && t.group() == this.mgroup) {
/* 339 */       super.putFloor(tx, ty, upgrade, area);
/*     */     } else {
/* 341 */       this.floor2.placeFixed(tx, ty);
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
/* 364 */     return (Room)new InnInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 369 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */