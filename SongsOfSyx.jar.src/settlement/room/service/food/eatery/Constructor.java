/*     */ package settlement.room.service.food.eatery;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.resources.ResGEat;
/*     */ import init.resources.ResGroup;
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
/*     */   private final ROOM_EATERY blue;
/*     */   private static final int CR = 1;
/*     */   private static final int DP = 2;
/*     */   
/*     */   boolean isCrate(int tx, int ty) {
/*  44 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 1);
/*     */   }
/*     */   
/*     */   boolean isDeposit(int tx, int ty) {
/*  48 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_EATERY blue, RoomInitData init) throws IOException {
/*  53 */     super(init, 1, 2, 88, 44);
/*  54 */     this.blue = blue;
/*  55 */     this.storage = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue, 1);
/*  56 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this, 0.01D);
/*     */     
/*  58 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  60 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "CRATE_BOTTOM_A_1X1", sp)
/*     */       {
/*     */         RoomSprite top;
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  67 */           this.top.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  72 */           super.render(r, s, data, it, degrade, isCandle);
/*  73 */           EateryInstance i = (EateryInstance)blue.getter.get(it.tile());
/*  74 */           if (i != null) {
/*  75 */             int ran = it.ran();
/*  76 */             ResGroup<ResGEat> es = RESOURCES.EDI();
/*  77 */             for (int ri = 1; ri <= 2; ri++) {
/*  78 */               ResG res = (ResG)es.all().get((ran & 0xF) % es.all().size());
/*  79 */               ran >>= 4;
/*  80 */               double d = blue.dist.stored(res.resource).get(i);
/*  81 */               d /= (i.distData.maxAmount * ri);
/*  82 */               d *= 16.0D;
/*  83 */               ran >>= 4;
/*  84 */               res.resource.renderLaying(r, it.x(), it.y(), ran, d);
/*     */             } 
/*     */           } 
/*     */           
/*  88 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  92 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "STALL_BOTTOM_1X1", sp)
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
/* 103 */           return j(tx, ty, rx, ry, d, item);
/*     */         }
/*     */         
/*     */         private boolean j(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 107 */           if (item.width() == 1 || item.height() == 1) {
/* 108 */             return (d.id() == item.rotation);
/*     */           }
/* 110 */           if ((((DIR)DIR.ORTHO.get(item.rotation)).x() * d.x() != 0 || ((DIR)DIR.ORTHO.get(item.rotation)).y() * d.y() != 0) && item.sprite(rx, ry) == this) {
/* 111 */             return true;
/*     */           }
/* 113 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 118 */           this.top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 123 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 128 */           super.render(r, s, data, it, degrade, isCandle);
/* 129 */           EateryInstance ins = (EateryInstance)blue.getter.get(it.tile());
/* 130 */           if (blue.dist.isWorked(it.tx(), it.ty())) {
/* 131 */             long ran = it.bigRan();
/* 132 */             ResGroup<ResGEat> es = RESOURCES.EDI();
/* 133 */             DIR dir = rot(data);
/*     */             
/* 135 */             int dim = 10;
/*     */ 
/*     */             
/* 138 */             int x1 = it.x() + 32 - (32 - dim) * dir.next(2).x();
/* 139 */             int y1 = it.y() + 32 - (32 - dim) * dir.next(2).y();
/* 140 */             x1 -= dim * dir.x();
/* 141 */             y1 -= dim * dir.y();
/* 142 */             int start = (int)ran % 6;
/* 143 */             ran >>= 3L;
/* 144 */             for (int i = 0; i < 6; i++) {
/* 145 */               int pos = i + start;
/* 146 */               pos %= 6;
/* 147 */               int x = x1 + dir.next(2).x() * pos * dim;
/* 148 */               int y = y1 + dir.next(2).y() * pos * dim;
/* 149 */               ResG res = (ResG)es.all().get(((int)ran & 0xF) % es.all().size());
/*     */               
/* 151 */               ran >>= 4L;
/*     */               
/* 153 */               double d = blue.dist.stored(res.resource).get(ins);
/* 154 */               if (d > (ran & 0x7L) / 7.0D)
/* 155 */                 res.resource.renderOneC(r, x, y, (int)ran); 
/* 156 */               ran >>= 2L;
/*     */             } 
/*     */           } 
/* 159 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 164 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "MISC_BOTTOM_1X1", sp) {
/*     */         RoomSprite1x1 top;
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 168 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 169 */             this.top.renderRandom(r, s, it, it.ran(), degrade);
/*     */           }
/*     */         }
/*     */       };
/* 173 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(sp, "CARPET_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 177 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 183 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 188 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 193 */     FurnisherItemTile cr = (new FurnisherItemTile(
/* 194 */         this, 
/* 195 */         false, 
/* 196 */         (RoomSprite)roomSprite1x11, 
/* 197 */         AVAILABILITY.SOLID, 
/* 198 */         false)).setData(2);
/*     */     
/* 200 */     FurnisherItemTile st = (new FurnisherItemTile(
/* 201 */         this, 
/* 202 */         false, 
/* 203 */         (RoomSprite)roomSprite1x12, 
/* 204 */         AVAILABILITY.SOLID, 
/* 205 */         false)).setData(1);
/*     */     
/* 207 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 208 */         this, 
/* 209 */         false, 
/* 210 */         (RoomSprite)roomSprite1x13, 
/* 211 */         AVAILABILITY.SOLID, 
/* 212 */         true);
/*     */ 
/*     */     
/* 215 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 216 */         this, 
/* 217 */         false, 
/* 218 */         (RoomSprite)roomSpriteCombo, 
/* 219 */         AVAILABILITY.ROOM, 
/* 220 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 283 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 294 */     return (RoomBlueprintImp)this.blue;
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
/* 318 */     return (Room)new EateryInstance(this.blue, area, init);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */