/*     */ package settlement.room.industry.workshop;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.game.SheetPair;
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
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_WORKSHOP blue;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat efficiency;
/*     */   final FurnisherStat output;
/*     */   static final int B_STORAGE = 2;
/*     */   static final int B_WORK = 3;
/*     */   
/*     */   protected Constructor(final ROOM_WORKSHOP blue, RoomInitData init) throws IOException {
/*  49 */     super(init, 3, 3);
/*  50 */     this.blue = blue;
/*     */     
/*  52 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this)
/*     */       {
/*     */         public double get(AREA area, double acc) {
/*  55 */           int am = 0;
/*  56 */           for (COORDINATE c : area.body()) {
/*  57 */             if (area.is(c) && 
/*  58 */               (SETT.ROOMS()).fData.tileData.get(c) == 3)
/*  59 */               am++; 
/*     */           } 
/*  61 */           return am;
/*     */         }
/*     */       };
/*  64 */     this.efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers);
/*  65 */     this.output = (FurnisherStat)new FurnisherStat.FurnisherStatProduction2(this, blue)
/*     */       {
/*     */         protected double getBase(AREA area, double[] fromItems) {
/*  68 */           return Constructor.this.workers.get(area, fromItems) * Constructor.this.efficiency.get(area, fromItems);
/*     */         }
/*     */       };
/*     */     
/*  72 */     Json js = init.data().json("SPRITES");
/*     */     
/*  74 */     final RoomSprite1x1 blue = new RoomSprite1x1(js, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  78 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */       };
/*     */     
/*  82 */     STable sTable1 = new STable(js)
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  87 */           super.render(r, s, data, it, degrade, isCandle);
/*  88 */           WorkshopInstance ins = (WorkshopInstance)blue.get(it.tx(), it.ty());
/*  89 */           if (!isCandle && ins != null) {
/*  90 */             Icon icon = ((IndustryResource)ins.industry().outs().get(0)).resource.icon();
/*  91 */             OPACITY.O99.bind();
/*  92 */             icon.render(r, it.x() + 8, it.x() + 64 - 8, it.y() + 8, it.y() + 64 - 8);
/*  93 */             OPACITY.unbind();
/*     */           } 
/*  95 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  99 */     STable sTable2 = new STable(js)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 103 */           if (blue.is(it.tile())) {
/* 104 */             blue.job.storage.render(r, s, it.tx(), it.ty(), it.x(), it.y(), it.ran());
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 109 */     STable sTable3 = new STable(js, js, blue)
/*     */       {
/*     */         final RoomSprite1x1 under;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         final RoomSprite1x1 above;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 160 */           super.render(r, s, data, it, degrade, isCandle);
/* 161 */           this.under.render(r, s, getData2(it), it, degrade, isCandle);
/* 162 */           if (blue.is(it.tile())) {
/* 163 */             int d = (SETT.ROOMS()).data.get(it.tx(), it.ty());
/* 164 */             if (blue.job.FETCH.working(d)) {
/* 165 */               WorkshopInstance ins = (WorkshopInstance)blue.get(it.tile());
/* 166 */               DIR dir = (DIR)DIR.ORTHO.get((SETT.ROOMS()).fData.spriteData2.get(it.tile()) & 0x3);
/*     */               
/* 168 */               ((IndustryResource)ins.industry().outs().get(0)).resource.renderOne(r, it.x() + dir.x() * 8, it.y() + dir.y() * 8, it.ran());
/*     */             } 
/*     */           } 
/* 171 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 176 */           this.above.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 182 */           return this.above.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 187 */     STable sTable4 = new STable(js)
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 191 */           super.render(r, s, data, it, degrade, isCandle);
/* 192 */           RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(it.tile());
/* 193 */           if (ins != null && blue.job.FETCH.get(it.tx(), it.ty(), ins) != null)
/* 194 */             blue.job.FETCH.renderNeighs(ins, r, s, it.x(), it.y(), it.ran()); 
/* 195 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 199 */     STable sTable5 = new STable(js, js)
/*     */       {
/*     */         RoomSprite top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 210 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 211 */             this.top.render(r, s, getData2(it), it, degrade, this.rotates);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 217 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 222 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(js, "MISC_BELOW_1X1", js)
/*     */       {
/*     */         RoomSprite top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 237 */           if ((GUTIL.ran2().get(it.tile()) & 0x1) == 1)
/* 238 */             return false; 
/* 239 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 245 */           this.top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 250 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 255 */           return (d.orthoID() == (GUTIL.ran2().get(tx, ty) & 0x3));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 260 */     FurnisherItemTile ff = (new FurnisherItemTile(this, true, (RoomSprite)sTable4, AVAILABILITY.ROOM_SOLID, false)).setData(3);
/* 261 */     FurnisherItemTile ww = (new FurnisherItemTile(this, false, (RoomSprite)sTable3, AVAILABILITY.ROOM_SOLID, false)).setData(3);
/* 262 */     FurnisherItemTile cc = new FurnisherItemTile(this, false, (RoomSprite)sTable5, AVAILABILITY.ROOM_SOLID, true);
/* 263 */     FurnisherItemTile mm = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, false);
/* 264 */     FurnisherItemTile ss = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.AVOID_PASS, false);
/* 265 */     FurnisherItemTile __ = null;
/*     */     
/* 267 */     FurnisherItemTile s1 = new FurnisherItemTile(this, false, (RoomSprite)sTable1, AVAILABILITY.ROOM_SOLID, true);
/* 268 */     FurnisherItemTile s2 = (new FurnisherItemTile(this, true, (RoomSprite)sTable2, AVAILABILITY.ROOM_SOLID, false)).setData(2);
/*     */ 
/*     */     
/* 271 */     int sw = 2;
/* 272 */     int ew = 10;
/*     */     
/* 274 */     for (int height = 1; height <= 2; height++) {
/* 275 */       for (int width = sw; width <= ew; width++) {
/* 276 */         FurnisherItemTile[][] tiles = new FurnisherItemTile[height][width];
/* 277 */         for (int y = 0; y < height; y++) {
/* 278 */           for (int x = 0; x < width; x++) {
/* 279 */             tiles[y][x] = (x == 0) ? s1 : s2;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 285 */     flush(1, 1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 395 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 457 */     flush(3);
/*     */   }
/*     */   
/*     */   private static class STable
/*     */     extends RoomSpriteCombo {
/*     */     private final RoomSprite top;
/*     */     
/*     */     public STable(Json json) throws IOException {
/* 465 */       super(json, "TABLE_COMBO");
/* 466 */       this.top = (RoomSprite)new RoomSpriteCombo(json, "TABLE_TOP_COMBO");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 472 */       super.render(r, s, data, it, degrade, isCandle);
/* 473 */       this.top.render(r, s, data, it, degrade, isCandle);
/* 474 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 481 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 486 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 491 */     return (Room)new WorkshopInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 496 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */   
/*     */   public boolean isHeavy() {
/* 500 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */