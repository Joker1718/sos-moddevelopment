/*     */ package settlement.room.service.food.canteen;
/*     */ 
/*     */ import init.resources.Meal;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
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
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   final FurnisherStat guests;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat tables;
/*     */   private final ROOM_CANTEEN blue;
/*     */   private final RoomSprite sPlate;
/*     */   
/*     */   protected Constructor(final ROOM_CANTEEN blue, RoomInitData init) throws IOException {
/*  42 */     super(init, 2, 3, 88, 44);
/*  43 */     this.blue = blue;
/*  44 */     this.guests = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue, 1);
/*  45 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this, 1.0D);
/*  46 */     this.tables = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.guests);
/*     */     
/*  48 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  50 */     this.sPlate = (RoomSprite)new RoomSprite1x1(sp, "PLATE_1X1");
/*     */     
/*  52 */     final RoomSpriteCombo spriteOven = new RoomSpriteCombo(sp, "TABLE_COMBO", sp)
/*     */       {
/*     */         final RoomSprite1x1 beneath;
/*     */ 
/*     */ 
/*     */         
/*     */         final RoomSprite1x1 beneath_used;
/*     */ 
/*     */         
/*     */         final RoomSprite1x1 oven;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  66 */           super.render(r, s, data, it, degrade, isCandle);
/*  67 */           this.beneath.render(r, s, getData2(it), it, degrade, isCandle);
/*  68 */           CanteenInstance i = (CanteenInstance)blue.getter.get(it.tile());
/*  69 */           if (i == null)
/*  70 */             return false; 
/*  71 */           SWork o = blue.job.get(it.tx(), it.ty());
/*  72 */           if (o == null)
/*  73 */             return false; 
/*  74 */           if (o.hasCoal()) {
/*  75 */             this.beneath_used.render(r, s, getData2(it), it, degrade, isCandle);
/*     */           }
/*  77 */           if (o.res() != null) {
/*  78 */             (o.res()).resource.renderOne(r, it.x(), it.y(), it.ran());
/*     */           }
/*  80 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  85 */           this.oven.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  90 */           return this.oven.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  96 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 101 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/* 103 */           CanteenInstance ins = (CanteenInstance)blue.getter.get(it.tile());
/* 104 */           if (ins == null) {
/*     */             return;
/*     */           }
/* 107 */           int ran = it.ran();
/* 108 */           int dist = 21;
/* 109 */           int ri = ran % RESOURCES.EDI().all().size();
/* 110 */           for (int i = 0; i < 9; i++) {
/*     */             
/* 112 */             ResG e = (ResG)RESOURCES.EDI().all().get(ri % RESOURCES.EDI().all().size());
/*     */             
/* 114 */             double a = 7.0D * ins.amount(e) / ins.maxAmount;
/* 115 */             if (a > 0.0D && a >= (ran & 0x7)) {
/* 116 */               DIR dir = (DIR)DIR.ALLC.get(ri % DIR.ALLC.size());
/* 117 */               it.setOff(dir.x() * dist, dir.y() * dist);
/* 118 */               Constructor.this.renderDish(r, s, e.resource, it, ran);
/*     */             } 
/* 120 */             ri++;
/* 121 */             ran >>>= 3;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 127 */           return !(!super.joins(tx, ty, rx, ry, d, item) && item.sprite(rx, ry) != spriteOven);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 132 */     RoomSpriteCombo roomSpriteCombo3 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo2, sp)
/*     */       {
/*     */         private final RoomSprite top;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 138 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/* 140 */           this.top.render(r, s, 0, it, degrade, false);
/*     */         }
/*     */       };
/*     */     
/* 144 */     RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sp, "STOOL_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 147 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */       };
/* 150 */     RoomSpriteCombo roomSpriteCombo4 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo2, sp) {
/*     */         private final RoomSprite top;
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 154 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/* 156 */           this.top.render(r, s, 0, it, degrade, false);
/*     */         }
/*     */       };
/*     */     
/* 160 */     RoomSpriteCombo roomSpriteCombo5 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo2)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 164 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/* 166 */           if (blue.is(it.tile())) {
/* 167 */             int d = (SETT.ROOMS()).data.get(it.tile());
/* 168 */             if (d > 0) {
/* 169 */               RESOURCE res = (Meal.get(d)).resource;
/* 170 */               int am = Meal.amount(d);
/* 171 */               blue.chair.render(r, s, rotMask(data), it, am, res);
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 180 */     FurnisherItemTile jj = (new FurnisherItemTile(
/* 181 */         this, 
/* 182 */         true, 
/* 183 */         (RoomSprite)roomSpriteCombo1, 
/* 184 */         AVAILABILITY.ROOM_SOLID, 
/* 185 */         false)).setData(1);
/*     */     
/* 187 */     FurnisherItemTile ss = (new FurnisherItemTile(
/* 188 */         this, 
/* 189 */         true, 
/* 190 */         (RoomSprite)roomSpriteCombo2, 
/* 191 */         AVAILABILITY.ROOM_SOLID, 
/* 192 */         false)).setData(2);
/*     */     
/* 194 */     FurnisherItemTile se = new FurnisherItemTile(
/* 195 */         this, 
/* 196 */         false, 
/* 197 */         (RoomSprite)roomSpriteCombo2, 
/* 198 */         AVAILABILITY.ROOM_SOLID, 
/* 199 */         true);
/*     */     
/* 201 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 202 */         this, 
/* 203 */         false, 
/* 204 */         (RoomSprite)roomSpriteCombo3, 
/* 205 */         AVAILABILITY.ROOM_SOLID, 
/* 206 */         true);
/*     */     
/* 208 */     FurnisherItemTile st = (new FurnisherItemTile(
/* 209 */         this, 
/* 210 */         true, 
/* 211 */         (RoomSprite)roomSprite1x1, 
/* 212 */         AVAILABILITY.PENALTY4, 
/* 213 */         false)).setData(3);
/*     */     
/* 215 */     FurnisherItemTile ta = new FurnisherItemTile(
/* 216 */         this, 
/* 217 */         false, 
/* 218 */         (RoomSprite)roomSpriteCombo4, 
/* 219 */         AVAILABILITY.ROOM_SOLID, 
/* 220 */         true);
/*     */     
/* 222 */     FurnisherItemTile ts = new FurnisherItemTile(
/* 223 */         this, 
/* 224 */         false, 
/* 225 */         (RoomSprite)roomSpriteCombo5, 
/* 226 */         AVAILABILITY.ROOM_SOLID, 
/* 227 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     flush(1, 3);
/*     */     
/* 256 */     FurnisherItemTile __ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 335 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 341 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 346 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 351 */     return (RoomBlueprintImp)this.blue;
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
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 374 */     return (Room)new CanteenInstance(this.blue, area, init);
/*     */   }
/*     */   
/*     */   public void renderDish(SPRITE_RENDERER r, ShadowBatch shadowBatch, RESOURCE res, RenderData.RenderIterator it, int ran) {
/* 378 */     this.sPlate.render(r, shadowBatch, ran, it, 0.0D, false);
/* 379 */     if (res != null) {
/* 380 */       COLOR.WHITE50.bind();
/* 381 */       res.renderOne(r, it.x(), it.y(), ran);
/* 382 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 388 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */