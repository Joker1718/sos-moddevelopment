/*     */ package settlement.room.service.food.tavern;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResGDrink;
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
/*     */ import settlement.room.main.furnisher.FurnisherItemTools;
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
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ class Constructor
/*     */   extends Furnisher
/*     */ {
/*  33 */   public static int ISTORAGE = 1;
/*  34 */   public static int ITABLE = 2;
/*     */   
/*     */   private final ROOM_TAVERN blue;
/*     */   
/*     */   final FurnisherStat tables;
/*     */   final FurnisherStat coziness;
/*     */   private final RoomSprite1x1 sJug;
/*     */   private final RoomSprite1x1 sFill;
/*     */   
/*     */   protected Constructor(final ROOM_TAVERN blue, RoomInitData init) throws IOException {
/*  44 */     super(init, 3, 2, 88, 44);
/*  45 */     this.blue = blue;
/*  46 */     this.tables = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue);
/*  47 */     this.coziness = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.tables);
/*     */     
/*  49 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  51 */     this.sJug = new RoomSprite1x1(sp, "JUG_1X1");
/*  52 */     this.sFill = new RoomSprite1x1(sp, "JUG_FILL_1X1");
/*     */     
/*  54 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "TABLE_COMBO");
/*     */     
/*  56 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "STORAGE_1X1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  60 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/*  62 */           TavernInstance i = (TavernInstance)blue.getter.get(it.tile());
/*  63 */           if (i != null) {
/*  64 */             int ran = it.ran();
/*  65 */             ResGroup<ResGDrink> es = RESOURCES.DRINKS();
/*  66 */             for (int ri = 1; ri <= 2; ri++) {
/*  67 */               ResGDrink res = (ResGDrink)es.all().get((ran & 0xF) % es.all().size());
/*  68 */               ran >>= 4;
/*  69 */               double d = blue.dist.stored(res.resource).get(i);
/*  70 */               d /= (i.distData.maxAmount * ri);
/*  71 */               d *= 16.0D;
/*  72 */               ran >>= 4;
/*  73 */               res.resource.renderLaying(r, it.x(), it.y(), ran, d);
/*     */             } 
/*     */           } 
/*  76 */           super.renderAbove(r, s, data, it, degrade);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  81 */     final RoomSprite1x1 sChair = new RoomSprite1x1(sp, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  85 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry) != this);
/*     */         }
/*     */       };
/*     */     
/*  89 */     final RoomSprite1x1 sServiceTop = new RoomSprite1x1(sp, "TABLE_DECOR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  93 */           return (item.sprite(rx - d.x() * 2, ry - d.y() * 2) == sChair);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  99 */           if (blue.dist.service(it.tx(), it.ty()) == null) {
/*     */             return;
/*     */           }
/* 102 */           DIR dir = rot(data);
/* 103 */           int ran = it.ran();
/*     */ 
/*     */           
/* 106 */           if (blue.dist.isWorked(it.tx(), it.ty())) {
/* 107 */             ResGDrink drink = (ResGDrink)RESOURCES.DRINKS().all().getC(ran);
/*     */             
/* 109 */             int sx = 8 - dir.x() * 5 * 4;
/* 110 */             int sy = 8 - dir.y() * 5 * 4;
/* 111 */             it.setOff(sx, sy);
/* 112 */             Constructor.this.sJug.renderRandom(r, s, it, ran, 0.0D);
/* 113 */             Constructor.this.sFill.renderRandom(r, s, it, ran, degrade, drink.color);
/* 114 */             ran >>= 3;
/*     */           } 
/*     */ 
/*     */           
/* 118 */           int used = blue.dist.usedAmount(it.tx(), it.ty());
/* 119 */           if (!blue.dist.isWorked(it.tx(), it.ty())) {
/* 120 */             used = 4;
/*     */           }
/*     */           
/* 123 */           if (used > 0) {
/* 124 */             int dd = 16;
/* 125 */             DIR d = dir.next(-2);
/* 126 */             if ((ran & 0x1) == 1)
/* 127 */               d = d.perpendicular(); 
/* 128 */             ran >>= 1;
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 133 */             used = CLAMP.i(used, 0, 4);
/* 134 */             for (int i = 0; i < used; i++) {
/* 135 */               int sx = -d.x() * 6 * 4 + d.x() * i * dd + -1 + (ran & 0x3);
/* 136 */               ran >>= 2;
/* 137 */               int sy = -d.y() * 6 * 4 + d.y() * i * dd + -1 + (ran & 0x3);
/* 138 */               ran >>= 2;
/* 139 */               it.setOff(sx, sy);
/* 140 */               Constructor.this.sJug.renderRandom(r, s, it, ran, 0.0D);
/* 141 */               ran >>= 3;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan)
/*     */         {
/* 154 */           return sServiceTop.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 159 */           sServiceTop.render(r, s, getData2(it), it, degrade, false);
/* 160 */           sServiceTop.renderAbove(r, s, getData2(it), it, degrade);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 166 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "MISC_1X1");
/*     */     
/* 168 */     RoomSpriteCombo roomSpriteCombo3 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1, sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 174 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 179 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 180 */             this.top.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */       };
/* 184 */     FurnisherItemTile pl = new FurnisherItemTile(
/* 185 */         this, 
/* 186 */         false, 
/* 187 */         (RoomSprite)roomSpriteCombo2, 
/* 188 */         AVAILABILITY.ROOM_SOLID, 
/* 189 */         false);
/*     */     
/* 191 */     pl.setData(ITABLE);
/* 192 */     FurnisherItemTile st = new FurnisherItemTile(
/* 193 */         this, 
/* 194 */         true, 
/* 195 */         (RoomSprite)roomSprite1x11, 
/* 196 */         AVAILABILITY.ROOM_SOLID, 
/* 197 */         true);
/*     */     
/* 199 */     st.setData(ISTORAGE);
/* 200 */     FurnisherItemTile ch = new FurnisherItemTile(
/* 201 */         this, 
/* 202 */         true, 
/* 203 */         (RoomSprite)roomSprite1x12, 
/* 204 */         AVAILABILITY.AVOID_PASS, 
/* 205 */         false);
/*     */     
/* 207 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 208 */         this, 
/* 209 */         false, 
/* 210 */         (RoomSprite)roomSprite1x14, 
/* 211 */         AVAILABILITY.ROOM_SOLID, 
/* 212 */         false);
/*     */     
/* 214 */     FurnisherItemTile __ = null;
/* 215 */     FurnisherItemTile nn = new FurnisherItemTile(
/* 216 */         this, 
/* 217 */         false, 
/* 218 */         (RoomSprite)roomSpriteCombo3, 
/* 219 */         AVAILABILITY.ROOM_SOLID, 
/* 220 */         true);
/*     */     
/* 222 */     FurnisherItemTile sm = new FurnisherItemTile(
/* 223 */         this, 
/* 224 */         false, 
/* 225 */         (RoomSprite)roomSprite1x11, 
/* 226 */         AVAILABILITY.ROOM_SOLID, 
/* 227 */         true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 327 */     flush(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 387 */     flush(3);
/*     */     
/* 389 */     FurnisherItemTools.makeUnder(this, sp, "CARPET_COMBO");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 436 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 441 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 446 */     return (Room)new TavernInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 451 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 456 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\tavern\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */