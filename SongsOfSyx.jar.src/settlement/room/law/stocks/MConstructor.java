/*     */ package settlement.room.law.stocks;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   FurnisherStat spectators;
/*     */   private final ROOM_STOCKS blue;
/*     */   private final FurnisherItemTile ss;
/*     */   
/*     */   MConstructor(final ROOM_STOCKS blue, RoomInitData init) throws IOException {
/*  37 */     super(init, 1, 1, 88, 44);
/*     */     
/*  39 */     this.spectators = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue);
/*  40 */     this.blue = blue;
/*     */ 
/*     */     
/*  43 */     Json sData = init.data().json("SPRITES");
/*     */     
/*  45 */     RoomSpriteBoxN roomSpriteBoxN1 = new RoomSpriteBoxN(sData, "BOX")
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  49 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  55 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  60 */     RoomSpriteBoxN roomSpriteBoxN2 = new RoomSpriteBoxN((RoomSprite)roomSpriteBoxN1, sData)
/*     */       {
/*     */         RoomSprite ssmall;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         RoomSprite stop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  74 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  80 */           return this.ssmall.render(r, s, getData2(it), it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  85 */           Tile t = blue.tile.get(it.tx(), it.ty());
/*  86 */           if (t != null && t.state() == Tile.STATE.used) {
/*  87 */             this.stop.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  95 */           this.ssmall.renderPlaceholder(r, x, y, (item.rotation + 1) % 4, tx, ty, rx, ry, item);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 100 */           return this.ssmall.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.ss = new FurnisherItemTile(
/* 108 */         this, 
/* 109 */         false, 
/* 110 */         (RoomSprite)roomSpriteBoxN2, 
/* 111 */         AVAILABILITY.AVOID_LIKE_FUCK, 
/* 112 */         false);
/*     */ 
/*     */     
/* 115 */     FurnisherItemTile tt = new FurnisherItemTile(
/* 116 */         this, 
/* 117 */         false, 
/* 118 */         (RoomSprite)roomSpriteBoxN1, 
/* 119 */         AVAILABILITY.ROOM, 
/* 120 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     flush(3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean service(int tx, int ty) {
/* 177 */     return (this.blue.is(tx, ty) && (SETT.ROOMS()).fData.tile.get(tx, ty) == this.ss);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 182 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 192 */     return (Room)new Instance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 197 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 203 */     super.putFloor(tx, ty, upgrade, area);
/* 204 */     floor(tx, ty, upgrade);
/*     */   }
/*     */   
/*     */   private void floor(int tx, int ty, int up) {
/* 208 */     Floors.Floor res = floor(up);
/* 209 */     int am = 1;
/* 210 */     for (DIR d : DIR.ORTHO) {
/* 211 */       if ((SETT.ROOMS()).map.is(tx, ty, d))
/*     */         continue; 
/* 213 */       Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty, d);
/* 214 */       if (f != null && f != res) {
/* 215 */         int a = testFloor(tx, ty, f);
/* 216 */         if (a > am) {
/* 217 */           am = a;
/* 218 */           res = f;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 223 */     if ((SETT.FLOOR()).getter.get(tx, ty) != res)
/* 224 */       res.placeFixed(tx, ty); 
/*     */   }
/*     */   
/*     */   private int testFloor(int tx, int ty, Floors.Floor f) {
/* 228 */     int am = 0;
/* 229 */     for (DIR d : DIR.ALL) {
/* 230 */       if ((SETT.ROOMS()).map.is(tx, ty, d))
/*     */         continue; 
/* 232 */       Floors.Floor f2 = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty, d);
/* 233 */       if (f2 == f) {
/* 234 */         am++;
/*     */       }
/*     */     } 
/* 237 */     return am;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\MConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */