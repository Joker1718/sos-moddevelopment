/*     */ package settlement.room.service.arena.pit;
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
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ArenaConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_FIGHTPIT blue;
/*     */   final FurnisherStat.FurnisherStatI workers;
/*     */   final FurnisherStat spectators;
/*     */   static final int STATION = 1;
/*     */   static final int ARENA = 2;
/*     */   private final FurnisherItemTile cc;
/*     */   
/*     */   protected ArenaConstructor(ROOM_FIGHTPIT blue, RoomInitData init) throws IOException {
/*  49 */     super(init, 1, 2);
/*     */     
/*  51 */     this.blue = blue;
/*  52 */     this.workers = new FurnisherStat.FurnisherStatI(this);
/*  53 */     this.spectators = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue);
/*  54 */     Json sp = init.data().json("SPRITES");
/*  55 */     RoomSpriteBoxN roomSpriteBoxN1 = new RoomSpriteBoxN(sp, "SEAT_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  59 */           return (ArenaConstructor.this.getLevel(rx, ry, item) >= ArenaConstructor.this.getLevel(rx - d.x(), ry - d.y(), item));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  65 */           boolean ret = super.render(r, s, data, it, degrade, isCandle);
/*  66 */           ArenaConstructor.this.renderLevel(r, getData2(it), it);
/*  67 */           return ret;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  72 */           return (byte)ArenaConstructor.this.getLevel(rx, ry, item);
/*     */         }
/*     */       };
/*     */     
/*  76 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "WALL_1X1", (RoomSprite)roomSpriteBoxN1)
/*     */       {
/*     */         final RoomSprite ss;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  89 */           return (item.sprite(rx, ry) == null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  95 */           return this.ss.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 100 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 105 */           return this.ss.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/* 109 */     RoomSpriteBoxN roomSpriteBoxN2 = new RoomSpriteBoxN(sp, "RIM_BOX")
/*     */       {
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 115 */           return (ArenaConstructor.this.getLevel(rx, ry, item) >= ArenaConstructor.this.getLevel(rx - d.x(), ry - d.y(), item));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 121 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 126 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 131 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "TOWER_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 135 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 141 */           return false;
/*     */         }
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 145 */           super.render(r, s, data, it, degrade, this.rotates);
/*     */         }
/*     */       };
/*     */     
/* 149 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "TORCH_1X1", sp)
/*     */       {
/*     */         RoomSprite1x1 tt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 161 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 167 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 172 */           super.render(r, s, data, it, degrade, false);
/* 173 */           this.tt.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 178 */           return this.tt.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 184 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 185 */         this, 
/* 186 */         (RoomSprite)roomSprite1x11, 
/* 187 */         AVAILABILITY.SOLID, 
/* 188 */         false);
/*     */     
/* 190 */     this.cc = new FurnisherItemTile(
/* 191 */         this, 
/* 192 */         (RoomSprite)roomSprite1x13, 
/* 193 */         AVAILABILITY.SOLID, 
/* 194 */         false);
/*     */     
/* 196 */     FurnisherItemTile pp = new FurnisherItemTile(
/* 197 */         this, 
/* 198 */         (RoomSprite)roomSprite1x12, 
/* 199 */         AVAILABILITY.SOLID, 
/* 200 */         false);
/*     */ 
/*     */     
/* 203 */     FurnisherItemTile ee = new FurnisherItemTile(
/* 204 */         this, 
/* 205 */         true, 
/* 206 */         (RoomSprite)roomSpriteBoxN1, 
/* 207 */         AVAILABILITY.ROOM, 
/* 208 */         false);
/*     */     
/* 210 */     FurnisherItemTile sl = new FurnisherItemTile(
/* 211 */         this, 
/* 212 */         (RoomSprite)new SStairs(sp, "STAIRS_LEFT_1X1"), 
/* 213 */         AVAILABILITY.ROOM, 
/* 214 */         false);
/* 215 */     FurnisherItemTile sc = new FurnisherItemTile(
/* 216 */         this, 
/* 217 */         (RoomSprite)new SStairs(sp, "STAIRS_CENTRE_1X1"), 
/* 218 */         AVAILABILITY.ROOM, 
/* 219 */         false);
/* 220 */     FurnisherItemTile sr = new FurnisherItemTile(
/* 221 */         this, 
/* 222 */         (RoomSprite)new SStairs(sp, "STAIRS_RIGHT_1X1"), 
/* 223 */         AVAILABILITY.ROOM, 
/* 224 */         false);
/*     */     
/* 226 */     FurnisherItemTile _1 = new FurnisherItemTile(
/* 227 */         this, 
/* 228 */         (RoomSprite)roomSpriteBoxN1, 
/* 229 */         AVAILABILITY.ROOM, 
/* 230 */         false);
/*     */     
/* 232 */     FurnisherItemTile _2 = new FurnisherItemTile(
/* 233 */         this, 
/* 234 */         (RoomSprite)roomSpriteBoxN1, 
/* 235 */         AVAILABILITY.PENALTY4, 
/* 236 */         false);
/* 237 */     _2.setData(1);
/*     */     
/* 239 */     FurnisherItemTile xu = new FurnisherItemTile(
/* 240 */         this, 
/* 241 */         (RoomSprite)roomSpriteBoxN2, 
/* 242 */         AVAILABILITY.SOLID, 
/* 243 */         false);
/*     */     
/* 245 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 246 */         this, 
/* 247 */         null, 
/* 248 */         AVAILABILITY.ROOM, 
/* 249 */         false);
/* 250 */     __.setData(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 288 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getLevel(int rx, int ry, FurnisherItem item) {
/* 295 */     for (int i = 1; i < item.width(); i++) {
/* 296 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 297 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 298 */         int dx = rx + d.x() * i;
/* 299 */         int dy = ry + d.y() * i;
/* 300 */         if (item.get(dx, dy) == null)
/* 301 */           return i - 1; 
/*     */       } 
/*     */     } 
/* 304 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 309 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 314 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 319 */     ArenaInstance a = new ArenaInstance(this.blue, area, init);
/* 320 */     for (COORDINATE c : a.body()) {
/* 321 */       if (a.is(c) && (SETT.ROOMS()).fData.tile.get(c) == this.cc) {
/* 322 */         SETT.LIGHTS().candle(c.x(), c.y(), 0);
/*     */       }
/*     */     } 
/* 325 */     return (Room)a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 330 */     for (int di = 0; di < DIR.ALLC.size(); di++) {
/* 331 */       DIR d = (DIR)DIR.ALLC.get(di);
/* 332 */       if (area.is(tx, ty, d) && ((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty, d)).data() == 2) {
/* 333 */         super.putFloor(tx, ty, upgrade, area);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 342 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */   
/*     */   private void renderLevel(SPRITE_RENDERER r, int level, RenderData.RenderIterator it) {
/* 346 */     int cc = level & 0xF;
/* 347 */     OpacityImp.TMP.set(cc * 8);
/* 348 */     OpacityImp.TMP.bind();
/* 349 */     COLOR.BLACK.render(r, it.x(), it.x() + 64, it.y(), it.y() + 64);
/* 350 */     OPACITY.unbind();
/*     */   }
/*     */   
/*     */   private class SStairs
/*     */     extends RoomSprite1x1 {
/*     */     public SStairs(Json json, String key) throws IOException {
/* 356 */       super(json, key);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 361 */       return (ArenaConstructor.this.getLevel(rx, ry, item) > ArenaConstructor.this.getLevel(rx - d.x(), ry - d.y(), item));
/*     */     }
/*     */ 
/*     */     
/*     */     public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 366 */       return (byte)ArenaConstructor.this.getLevel(rx, ry, item);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 371 */       super.render(r, s, data & 0xF, it, degrade, false);
/* 372 */       ArenaConstructor.this.renderLevel(r, getData2(it), it);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 378 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\pit\ArenaConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */