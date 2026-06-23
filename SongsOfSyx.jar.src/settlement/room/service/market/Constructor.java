/*     */ package settlement.room.service.market;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.RaceResources;
/*     */ import init.resources.RESOURCE;
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
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   static final int MAX = 16;
/*     */   final FurnisherStat storage;
/*     */   final FurnisherStat workers;
/*     */   private final ROOM_MARKET blue;
/*     */   private static final int ST = 2;
/*     */   private static final int CR = 1;
/*     */   
/*     */   boolean isCrate(int tx, int ty) {
/*  43 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 1);
/*     */   }
/*     */   
/*     */   boolean isStore(int tx, int ty) {
/*  47 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_MARKET blue, RoomInitData init) throws IOException {
/*  52 */     super(init, 1, 2, 88, 44);
/*  53 */     this.blue = blue;
/*  54 */     this.storage = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue, 1);
/*  55 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this, 0.01D);
/*     */     
/*  57 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  59 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "CRATE_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  64 */           super.render(r, s, data, it, degrade, isCandle);
/*  65 */           MarketInstance i = (MarketInstance)blue.getter.get(it.tile());
/*  66 */           if (i != null) {
/*  67 */             int ran = it.ran();
/*  68 */             for (int ri = 1; ri <= 2; ri++) {
/*  69 */               RaceResources.RaceResource res = (RaceResources.RaceResource)(RACES.res()).ALL.get((ran & 0xFF) % (RACES.res()).ALL.size());
/*  70 */               ran >>= 4;
/*  71 */               double d = blue.dist.stored(res.res).get(i);
/*  72 */               d /= (i.distData.maxAmount * ri);
/*  73 */               d *= 16.0D;
/*  74 */               ran >>= 4;
/*  75 */               res.res.renderLaying(r, it.x(), it.y(), ran, d);
/*     */             } 
/*     */           } 
/*     */           
/*  79 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  83 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "STALL_BOTTOM_COMBO", sp)
/*     */       {
/*     */         RoomSprite1x1 top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  94 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */         
/*     */         private boolean j(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  98 */           if (item.width() == 1 || item.height() == 1) {
/*  99 */             return (d.id() == item.rotation);
/*     */           }
/* 101 */           if ((((DIR)DIR.ORTHO.get(item.rotation)).x() * d.x() != 0 || ((DIR)DIR.ORTHO.get(item.rotation)).y() * d.y() != 0) && item.sprite(rx, ry) == this) {
/* 102 */             return true;
/*     */           }
/* 104 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 109 */           this.top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 114 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 119 */           super.render(r, s, data, it, degrade, isCandle);
/* 120 */           MarketInstance ins = (MarketInstance)blue.getter.get(it.tile());
/* 121 */           if (blue.dist.isWorked(it.tx(), it.ty())) {
/* 122 */             long ran = it.bigRan();
/* 123 */             DIR dir = this.top.rot(data);
/*     */             
/* 125 */             int dim = 10;
/*     */ 
/*     */             
/* 128 */             int x1 = it.x() + 32 - (32 - dim) * dir.next(2).x();
/* 129 */             int y1 = it.y() + 32 - (32 - dim) * dir.next(2).y();
/* 130 */             x1 -= dim * dir.x();
/* 131 */             y1 -= dim * dir.y();
/* 132 */             int start = (int)ran % 6;
/* 133 */             ran >>= 3L;
/* 134 */             for (int i = 0; i < 6; i++) {
/* 135 */               int pos = i + start;
/* 136 */               pos %= 6;
/* 137 */               int x = x1 + dir.next(2).x() * pos * dim;
/* 138 */               int y = y1 + dir.next(2).y() * pos * dim;
/* 139 */               RESOURCE res = (RESOURCE)blue.dist.all.get(((int)ran & 0xF) % blue.dist.all.size());
/*     */               
/* 141 */               ran >>= 4L;
/*     */               
/* 143 */               double d = blue.dist.stored(res).get(ins);
/* 144 */               if (d > (ran & 0x7L) / 7.0D)
/* 145 */                 res.renderOneC(r, x, y, (int)ran); 
/* 146 */               ran >>= 2L;
/*     */             } 
/*     */           } 
/* 149 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 154 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "MISC_BOTTOM_1X1", sp) {
/*     */         RoomSprite1x1 top;
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 158 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 159 */             this.top.renderRandom(r, s, it, it.ran(), degrade);
/*     */           }
/*     */         }
/*     */       };
/* 163 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo(sp, "CARPET_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 167 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 173 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 178 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 183 */     FurnisherItemTile cr = (new FurnisherItemTile(
/* 184 */         this, 
/* 185 */         false, 
/* 186 */         (RoomSprite)roomSprite1x11, 
/* 187 */         AVAILABILITY.SOLID, 
/* 188 */         false)).setData(2);
/*     */     
/* 190 */     FurnisherItemTile st = (new FurnisherItemTile(
/* 191 */         this, 
/* 192 */         false, 
/* 193 */         (RoomSprite)roomSpriteCombo1, 
/* 194 */         AVAILABILITY.SOLID, 
/* 195 */         false)).setData(1);
/*     */     
/* 197 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 198 */         this, 
/* 199 */         false, 
/* 200 */         (RoomSprite)roomSprite1x12, 
/* 201 */         AVAILABILITY.SOLID, 
/* 202 */         true);
/*     */ 
/*     */     
/* 205 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 206 */         this, 
/* 207 */         false, 
/* 208 */         (RoomSprite)roomSpriteCombo2, 
/* 209 */         AVAILABILITY.ROOM, 
/* 210 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 273 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 278 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 284 */     return (RoomBlueprintImp)this.blue;
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
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 308 */     return (Room)new MarketInstance(this.blue, area, init);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\market\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */