/*     */ package settlement.room.spirit.temple;
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
/*     */ import settlement.room.main.furnisher.FurnisherItemTools;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class TempleConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_TEMPLE blue;
/*     */   final FurnisherStat priests;
/*     */   final FurnisherStat worshippers;
/*     */   final FurnisherStat decor;
/*     */   final FurnisherStat grandure;
/*     */   final FurnisherStat space;
/*     */   private final FurnisherItemTile ca;
/*     */   final FurnisherItemTile ap;
/*     */   final FurnisherItemTile al;
/*     */   final FurnisherItemTile es;
/*     */   final FurnisherItemTile wo;
/*     */   
/*     */   protected TempleConstructor(final ROOM_TEMPLE blue, RoomInitData init) throws IOException {
/*  53 */     super(init, 5, 5, 304, 240);
/*  54 */     this.blue = blue;
/*     */     
/*  56 */     this.priests = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this);
/*  57 */     this.worshippers = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, blue);
/*  58 */     this.decor = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.worshippers, 0.7D);
/*  59 */     this.grandure = new FurnisherStat(this)
/*     */       {
/*     */         public double get(AREA area, double acc)
/*     */         {
/*  63 */           double d = 1.5D * area.area() / 2048.0D;
/*  64 */           return Math.pow(CLAMP.d(d, 0.0D, 1.0D), 0.5D);
/*     */         }
/*     */ 
/*     */         
/*     */         public GText format(GText t, double value) {
/*  69 */           GFORMAT.perc(t, value);
/*  70 */           return t;
/*     */         }
/*     */       };
/*  73 */     this.space = new FurnisherStat(this)
/*     */       {
/*     */         public double get(AREA area, double acc)
/*     */         {
/*  77 */           return acc;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(AREA area, double[] fromItems) {
/*  82 */           double p = fromItems[TempleConstructor.this.priests.index()];
/*  83 */           if (p == 0.0D) {
/*  84 */             return 1.0D;
/*     */           }
/*  86 */           double d = area.area() / p * 38.0D;
/*  87 */           return Math.pow(CLAMP.d(d, 0.0D, 1.0D), 0.5D);
/*     */         }
/*     */ 
/*     */         
/*     */         public GText format(GText t, double value) {
/*  92 */           GFORMAT.perc(t, value);
/*  93 */           return t;
/*     */         }
/*     */       };
/*     */     
/*  97 */     Floors.Floor path = (Floors.Floor)(SETT.FLOOR()).map.read("FLOOR_PATH", init.data());
/*     */     
/*  99 */     Json sj = init.data().json("SPRITES");
/*     */     
/* 101 */     final RoomSpriteBoxN sPedistal = new RoomSpriteBoxN(sj, "PEDISTAL_BOX")
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 104 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 109 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 113 */     RoomSpriteBoxN sAltar = new RoomSpriteBoxN(sj, "ALTAR_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 117 */           return (item.get(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 122 */           sPedistal.renderBelow(r, s, 15, it, degrade);
/*     */         }
/*     */       };
/* 125 */     sAltar.sData(1);
/*     */     
/* 127 */     RoomSpriteBoxN roomSpriteBoxN1 = new RoomSpriteBoxN((RoomSprite)sAltar, sj) {
/*     */         RoomSpriteImp sEmblem;
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 131 */           return (item.get(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 136 */           super.render(r, s, data, it, degrade, isCandle);
/* 137 */           this.sEmblem.render(r, s, getData2(it), it, degrade, isCandle);
/* 138 */           if (blue.altar.get(it.tx(), it.ty()) != null)
/* 139 */             blue.altar.render(r, s, it); 
/* 140 */           return false;
/*     */         }
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 144 */           return this.sEmblem.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/* 147 */     roomSpriteBoxN1.sData(1);
/*     */     
/* 149 */     RoomSpriteXxX roomSpriteXxX = new RoomSpriteXxX(sj, "EMBLEM_2X2", 2);
/*     */ 
/*     */     
/* 152 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sj, "NICHE_A_1X1", true);
/* 153 */     RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sj, "NICHE_B_1X1", false);
/* 154 */     RoomSprite1xN roomSprite1xN3 = new RoomSprite1xN(sj, "NICHE_C_1X1", false);
/* 155 */     RoomSprite1xN roomSprite1xN4 = new RoomSprite1xN(sj, "NICHE_D_1X1", false);
/*     */     
/* 157 */     final RoomSprite1x1 sCS = new RoomSprite1x1(sj, "TORCH_1X1");
/*     */     
/* 159 */     RoomSpriteBoxN roomSpriteBoxN2 = new RoomSpriteBoxN((RoomSprite)sPedistal)
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 163 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 169 */           sCS.render(r, s, getData2(it), it, degrade, true);
/* 170 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 175 */           return sCS.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/* 179 */     RoomSprite1xN roomSprite1xN5 = new RoomSprite1xN(sj, "COFFIN_A_1X1", false);
/* 180 */     RoomSprite1xN roomSprite1xN6 = new RoomSprite1xN((RoomSprite)roomSprite1xN5, true);
/* 181 */     RoomSprite1xN roomSprite1xN7 = new RoomSprite1xN((RoomSprite)roomSprite1xN5, false);
/*     */     
/* 183 */     this.wo = new FurnisherItemTile(
/* 184 */         this, 
/* 185 */         false, 
/* 186 */         (RoomSprite)sPedistal, 
/* 187 */         AVAILABILITY.ROOM, 
/* 188 */         false);
/*     */     
/* 190 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 191 */         this, 
/* 192 */         (RoomSprite)sPedistal, 
/* 193 */         AVAILABILITY.ROOM, 
/* 194 */         false);
/*     */     
/* 196 */     this.es = new FurnisherItemTile(
/* 197 */         this, 
/* 198 */         (RoomSprite)roomSpriteBoxN1, 
/* 199 */         AVAILABILITY.AVOID_LIKE_FUCK, 
/* 200 */         false);
/*     */     
/* 202 */     FurnisherItemTile eb = new FurnisherItemTile(
/* 203 */         this, 
/* 204 */         (RoomSprite)roomSpriteXxX, 
/* 205 */         AVAILABILITY.ROOM, 
/* 206 */         false);
/*     */     
/* 208 */     this.al = new FurnisherItemTile(
/* 209 */         this, 
/* 210 */         (RoomSprite)sAltar, 
/* 211 */         AVAILABILITY.AVOID_LIKE_FUCK, 
/* 212 */         false);
/*     */     
/* 214 */     this.ap = new FurnisherItemTile(
/* 215 */         this, 
/* 216 */         (RoomSprite)sAltar, 
/* 217 */         AVAILABILITY.AVOID_LIKE_FUCK, 
/* 218 */         false);
/*     */     
/* 220 */     FurnisherItemTile b0 = new FurnisherItemTile(
/* 221 */         this, 
/* 222 */         (RoomSprite)roomSprite1xN1, 
/* 223 */         AVAILABILITY.ROOM_SOLID, 
/* 224 */         false);
/*     */     
/* 226 */     FurnisherItemTile b1 = new FurnisherItemTile(
/* 227 */         this, 
/* 228 */         (RoomSprite)roomSprite1xN2, 
/* 229 */         AVAILABILITY.ROOM_SOLID, 
/* 230 */         false);
/*     */     
/* 232 */     FurnisherItemTile b2 = new FurnisherItemTile(
/* 233 */         this, 
/* 234 */         (RoomSprite)roomSprite1xN3, 
/* 235 */         AVAILABILITY.ROOM_SOLID, 
/* 236 */         false);
/*     */     
/* 238 */     FurnisherItemTile b3 = new FurnisherItemTile(
/* 239 */         this, 
/* 240 */         (RoomSprite)roomSprite1xN4, 
/* 241 */         AVAILABILITY.ROOM_SOLID, 
/* 242 */         false);
/*     */     
/* 244 */     this.ca = new FurnisherItemTile(
/* 245 */         this, 
/* 246 */         (RoomSprite)roomSpriteBoxN2, 
/* 247 */         AVAILABILITY.ROOM_SOLID, 
/* 248 */         true);
/*     */     
/* 250 */     FurnisherItemTile sA = new FurnisherItemTile(
/* 251 */         this, 
/* 252 */         (RoomSprite)roomSprite1xN5, 
/* 253 */         AVAILABILITY.ROOM_SOLID, 
/* 254 */         false);
/*     */     
/* 256 */     FurnisherItemTile sB = new FurnisherItemTile(
/* 257 */         this, 
/* 258 */         (RoomSprite)roomSprite1xN6, 
/* 259 */         AVAILABILITY.ROOM_SOLID, 
/* 260 */         false);
/*     */     
/* 262 */     FurnisherItemTile sC = new FurnisherItemTile(
/* 263 */         this, 
/* 264 */         (RoomSprite)roomSprite1xN7, 
/* 265 */         AVAILABILITY.ROOM_SOLID, 
/* 266 */         false);
/*     */     
/* 268 */     FurnisherItemTile cs = new FurnisherItemTile(
/* 269 */         this, 
/* 270 */         (RoomSprite)roomSprite1x1, 
/* 271 */         AVAILABILITY.ROOM_SOLID, 
/* 272 */         true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     flush(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 329 */     flush(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 335 */     flush(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     flush(3);
/*     */     
/* 344 */     FurnisherItemTools.makeFloor(this, path);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 350 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 355 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 360 */     TempleInstance ins = new TempleInstance(this.blue, area, init);
/* 361 */     for (COORDINATE c : ins.body()) {
/* 362 */       if (ins.is(c) && (SETT.ROOMS()).fData.tile.get(c) == this.ca) {
/* 363 */         SETT.LIGHTS().candle(c.x(), c.y(), 0);
/*     */       }
/*     */     } 
/* 366 */     return (Room)ins;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 371 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 376 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */