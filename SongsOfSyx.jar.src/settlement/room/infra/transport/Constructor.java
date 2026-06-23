/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
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
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_TRANSPORT blue;
/*     */   final FurnisherStat crates;
/*     */   private final Floors.Floor floor2;
/*     */   final FurnisherItemTile an;
/*     */   final FurnisherItemTile ww;
/*     */   
/*     */   protected Constructor(final ROOM_TRANSPORT blue, RoomInitData init) throws IOException {
/*  43 */     super(init, 1, 1);
/*     */ 
/*     */     
/*  46 */     this.blue = blue;
/*  47 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.read("FLOOR2", init.data());
/*     */     
/*  49 */     this.crates = new FurnisherStat(this, 1.0D)
/*     */       {
/*     */         public double get(AREA area, double fromItems)
/*     */         {
/*  53 */           return fromItems;
/*     */         }
/*     */ 
/*     */         
/*     */         public GText format(GText t, double value) {
/*  58 */           return GFORMAT.i(t, (int)value);
/*     */         }
/*     */       };
/*     */     
/*  62 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  64 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "GROUND_THING_1X1")
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  67 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  73 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  78 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  83 */     RoomSprite.Imp imp1 = new RoomSprite.Imp()
/*     */       {
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan)
/*     */         {
/*  87 */           return 0;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  93 */           TransportInstance ins = (TransportInstance)blue.get(it.tx(), it.ty());
/*  94 */           if (ins != null && ins.resource() != null) {
/*  95 */             int am = blue.job.bamount.get(it.tx(), it.ty());
/*  96 */             if (am > 0) {
/*  97 */               ins.data.resource().renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 106 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 110 */     RoomSprite.Imp imp2 = new RoomSprite.Imp()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 116 */           RESOURCE res = null;
/* 117 */           int am = 0;
/*     */           
/* 119 */           TransportInstance ins = (TransportInstance)blue.get(it.tx(), it.ty());
/* 120 */           if (ins != null) {
/* 121 */             res = ins.data.resource();
/* 122 */             am = ins.data.stored();
/* 123 */             if (am > 0 || ins.data.cartVisible()) {
/* 124 */               int iii = (SETT.ROOMS()).fData.tileData.get(it.tile()) - 1;
/* 125 */               int dx = 0;
/* 126 */               int dy = 0;
/* 127 */               if ((iii & 0x1) == 1) {
/* 128 */                 DIR dd = (DIR)DIR.ORTHO.get(data);
/* 129 */                 dx = dd.x() * 32;
/* 130 */                 dy = dd.y() * 32;
/*     */               } 
/* 132 */               (SETT.HALFENTS()).transports.sprite.renderBelow(r, s, data * 2, it.x() + dx + 32, it.y() + dy + 32, 0.0D, it.ran(), degrade, res, am / 400.0D);
/*     */             } 
/*     */           } 
/*     */           
/* 136 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 142 */           TransportInstance ins = (TransportInstance)blue.get(it.tx(), it.ty());
/* 143 */           if (ins != null && ins.data.cartVisible()) {
/* 144 */             int iii = (SETT.ROOMS()).fData.tileData.get(it.tile()) - 1;
/* 145 */             int dx = 0;
/* 146 */             int dy = 0;
/* 147 */             if ((iii & 0x1) == 1) {
/* 148 */               DIR dd = (DIR)DIR.ORTHO.get(data);
/* 149 */               dx = dd.x() * 32;
/* 150 */               dy = dd.y() * 32;
/*     */             } 
/* 152 */             (SETT.HALFENTS()).transports.sprite.render(r, s, data * 2, it.x() + dx + 32, it.y() + dy + 32, degrade, false);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 159 */           return (byte)item.rotation;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 165 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(item.rotation)).render(r, x, y);
/*     */         }
/*     */       };
/*     */     
/* 169 */     RoomSprite dummy = new RoomSprite()
/*     */       {
/*     */         
/*     */         public int sData()
/*     */         {
/* 174 */           return 0;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 181 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 187 */           return 0;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 193 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(item.rotation)).render(r, x, y);
/*     */         }
/*     */       };
/*     */     
/* 197 */     RoomSprite.Imp imp3 = new RoomSprite.Imp()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 202 */           TransportInstance ins = (TransportInstance)blue.get(it.tx(), it.ty());
/* 203 */           if (ins != null && ins.data.oxVisible()) {
/* 204 */             double mov = (GAME.intervals().get05() + it.ran() & 0xFF);
/* 205 */             mov /= 255.0D;
/* 206 */             SETT.ANIMALS().renderCaravan(r, s, mov, it.x() + 32, it.y() + 32, null, 0, false, data * 2, it.ran());
/*     */           } 
/*     */           
/* 209 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 214 */           return (byte)item.rotation;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 220 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(item.rotation)).render(r, x, y);
/*     */         }
/*     */       };
/*     */     
/* 224 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "TORCH_1X1");
/*     */     
/* 226 */     FurnisherItemTile pp = new FurnisherItemTile(
/* 227 */         this, 
/* 228 */         false, 
/* 229 */         (RoomSprite)roomSprite1x12, 
/* 230 */         AVAILABILITY.ROOM_SOLID, 
/* 231 */         true);
/*     */     
/* 233 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 234 */         this, 
/* 235 */         false, 
/* 236 */         (RoomSprite)roomSprite1x11, 
/* 237 */         AVAILABILITY.ROOM, 
/* 238 */         false);
/*     */     
/* 240 */     this.ww = new FurnisherItemTile(
/* 241 */         this, 
/* 242 */         false, 
/* 243 */         (RoomSprite)imp1, 
/* 244 */         AVAILABILITY.ROOM_SOLID, 
/* 245 */         false);
/*     */     
/* 247 */     FurnisherItemTile xx = (new FurnisherItemTile(
/* 248 */         this, 
/* 249 */         false, 
/* 250 */         dummy, 
/* 251 */         AVAILABILITY.ROOM_SOLID, 
/* 252 */         false)).setData(1);
/*     */     
/* 254 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 255 */         this, 
/* 256 */         false, 
/* 257 */         (RoomSprite)new RoomSprite.Dummy(), 
/* 258 */         AVAILABILITY.ROOM, 
/* 259 */         false);
/*     */     
/* 261 */     this.an = (new FurnisherItemTile(
/* 262 */         this, 
/* 263 */         false, 
/* 264 */         (RoomSprite)imp3, 
/* 265 */         AVAILABILITY.ROOM_SOLID, 
/* 266 */         false)).setData(1);
/*     */     
/* 268 */     FurnisherItemTile c0 = (new FurnisherItemTile(
/* 269 */         this, 
/* 270 */         false, 
/* 271 */         (RoomSprite)imp2, 
/* 272 */         AVAILABILITY.ROOM_SOLID, 
/* 273 */         false)).setData(1);
/*     */     
/* 275 */     FurnisherItemTile c1 = (new FurnisherItemTile(
/* 276 */         this, 
/* 277 */         false, 
/* 278 */         (RoomSprite)imp2, 
/* 279 */         AVAILABILITY.ROOM_SOLID, 
/* 280 */         false)).setData(2);
/*     */     
/* 282 */     FurnisherItemTile c2 = (new FurnisherItemTile(
/* 283 */         this, 
/* 284 */         false, 
/* 285 */         (RoomSprite)imp2, 
/* 286 */         AVAILABILITY.ROOM_SOLID, 
/* 287 */         false)).setData(3);
/*     */     
/* 289 */     FurnisherItemTile c3 = (new FurnisherItemTile(
/* 290 */         this, 
/* 291 */         false, 
/* 292 */         (RoomSprite)imp2, 
/* 293 */         AVAILABILITY.ROOM_SOLID, 
/* 294 */         false)).setData(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 317 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 322 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 328 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 333 */     if ((SETT.ROOMS()).fData.tile.get(tx, ty) != null && ((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty)).data() > 0) {
/* 334 */       this.floor2.placeFixed(tx, ty);
/*     */     } else {
/* 336 */       super.putFloor(tx, ty, upgrade, area);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 342 */     return (Room)new TransportInstance(this.blue, area, init);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */