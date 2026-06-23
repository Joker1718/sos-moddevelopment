/*     */ package settlement.room.industry.refiner;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
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
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat efficiency;
/*     */   final FurnisherStat output;
/*     */   private final ROOM_REFINER blue;
/*     */   static final int B_STORAGE = 2;
/*     */   static final int B_WORK = 3;
/*     */   
/*     */   protected Constructor(RoomInitData init, final ROOM_REFINER blue) throws IOException {
/*  48 */     super(init, 3, 3, 88, 44);
/*  49 */     this.blue = blue;
/*     */ 
/*     */     
/*  52 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this)
/*     */       {
/*     */         public double get(AREA area, double acc) {
/*  55 */           int am = 0;
/*  56 */           for (COORDINATE c : area.body()) {
/*  57 */             if (area.is(c) && (SETT.ROOMS()).fData.tileData.get(c) == 3)
/*  58 */               am++; 
/*     */           } 
/*  60 */           return am;
/*     */         }
/*     */       };
/*  63 */     this.efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers, 1.0D);
/*  64 */     this.output = (FurnisherStat)new FurnisherStat.FurnisherStatProduction2(this, blue)
/*     */       {
/*     */         protected double getBase(AREA area, double[] fromItems) {
/*  67 */           return Constructor.this.workers.get(area, fromItems) * Constructor.this.efficiency.get(area, fromItems);
/*     */         }
/*     */       };
/*     */     
/*  71 */     Json js = init.data().json("SPRITES");
/*     */     
/*  73 */     final RoomSpriteCombo sMachineTop = new RoomSpriteCombo(js, "MAIN_MACHINE_COMBO_TOP");
/*     */     
/*  75 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo(js, "MAIN_MACHINE_COMBO", js)
/*     */       {
/*     */         final RoomSprite1x1 top2;
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  81 */           super.render(r, s, data, it, degrade, isCandle);
/*  82 */           sMachineTop.render(r, s, getData2(it), it, degrade, isCandle);
/*  83 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  88 */           if ((it.ran() & 0x3) == 0 && !(SETT.ROOMS()).fData.candle.is(it.tile())) {
/*  89 */             this.top2.animate(Constructor.this.aniSpeed(it));
/*  90 */             this.top2.render(r, s, 0, it, degrade, this.rotates);
/*     */           } 
/*  92 */           super.renderAbove(r, s, data, it, degrade);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  97 */           return sMachineTop.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/* 101 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(js, "WORK_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 106 */           this.animationSpeed = 0.0D;
/* 107 */           if (blue.is(it.tile())) {
/* 108 */             int d = (SETT.ROOMS()).data.get(it.tile());
/* 109 */             if (blue.job.FETCH.working(d)) {
/* 110 */               this.animationSpeed = 1.0D;
/*     */             }
/*     */           } 
/*     */           
/* 114 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 119 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 124 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(js, "STORAGE_IN_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 127 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 133 */           RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(it.tile());
/* 134 */           if (ins != null && blue.job.FETCH.get(it.tx(), it.ty(), ins) != null) {
/* 135 */             blue.job.FETCH.renderNeighs(ins, r, s, it.x(), it.y(), it.ran());
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 141 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(js, "NICKNACK_BOTTOM_1X1", js)
/*     */       {
/*     */         private RoomSprite1x1 top;
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 147 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 153 */           super.render(r, s, data, it, degrade, isCandle);
/* 154 */           if ((GUTIL.ran2().get(it.tile()) & 0x1) == 1)
/* 155 */             this.top.render(r, s, data, it, degrade, isCandle); 
/* 156 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 161 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(js, "MACHINE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 165 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 171 */           this.animationSpeed = Constructor.this.aniSpeed(it);
/* 172 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 178 */     final RoomSprite1x1 sStorageTop = new RoomSprite1x1(js, "CONVEYOR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 181 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 187 */           this.animationSpeed = Constructor.this.aniSpeed(it);
/* 188 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 193 */     RoomSprite1xN roomSprite1xN = new RoomSprite1xN(js, "STORAGE_1X1", false)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 196 */           if (blue.is(it.tile())) {
/* 197 */             blue.job.storage.render(r, s, it.tx(), it.ty(), it.x(), it.y(), it.ran());
/*     */           }
/*     */         }
/*     */         
/*     */         protected boolean isMaster(int rx, int ry, FurnisherItem item) {
/* 202 */           return (item.sprite(rx, ry) == sStorageTop);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 207 */     RoomSpriteCombo roomSpriteCombo3 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo2)
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 212 */           super.render(r, s, data, it, degrade, isCandle);
/* 213 */           sMachineTop.render(r, s, getData2(it), it, degrade, isCandle);
/* 214 */           RefinerInstance ins = (RefinerInstance)blue.get(it.tx(), it.ty());
/* 215 */           if (!isCandle && ins != null) {
/* 216 */             Icon icon = ((IndustryResource)ins.industry().outs().get(0)).resource.icon();
/* 217 */             OPACITY.O99.bind();
/* 218 */             icon.render(r, it.x() + 8, it.x() + 64 - 8, it.y() + 8, it.y() + 64 - 8);
/* 219 */             OPACITY.unbind();
/*     */           } 
/* 221 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 226 */           return sMachineTop.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     FurnisherItemTile me = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo2, AVAILABILITY.ROOM_SOLID, true);
/* 234 */     FurnisherItemTile mm = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x13, AVAILABILITY.ROOM_SOLID, false);
/* 235 */     FurnisherItemTile ma = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x14, AVAILABILITY.ROOM_SOLID, false);
/* 236 */     FurnisherItemTile ff = (new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, false)).setData(3);
/* 237 */     FurnisherItemTile ww = (new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false)).setData(3);
/*     */     
/* 239 */     FurnisherItemTile st = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x15, AVAILABILITY.ROOM_SOLID, false);
/* 240 */     FurnisherItemTile sm = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1xN, AVAILABILITY.ROOM_SOLID, false);
/* 241 */     FurnisherItemTile sb = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1xN, AVAILABILITY.ROOM_SOLID, false);
/* 242 */     FurnisherItemTile se = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo3, AVAILABILITY.ROOM_SOLID, true);
/* 243 */     sm.setData(2);
/* 244 */     sb.setData(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     flush(1, 1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 401 */     flush(3);
/*     */   }
/*     */ 
/*     */   
/*     */   private double aniSpeed(RenderData.RenderIterator it) {
/* 406 */     if (this.blue.is(it.tile())) {
/* 407 */       RefinerInstance ins = (RefinerInstance)this.blue.get(it.tile());
/* 408 */       return ins.WI / ins.employees().max();
/*     */     } 
/* 410 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 415 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 420 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 425 */     return (Room)new RefinerInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 430 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 435 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\refiner\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */