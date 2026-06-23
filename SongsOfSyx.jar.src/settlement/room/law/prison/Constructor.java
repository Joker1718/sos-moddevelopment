/*     */ package settlement.room.law.prison;
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
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.Errors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
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
/*     */   private final ROOM_PRISON blue;
/*     */   final int PRISONERS_PER_CELL;
/*     */   final int WORKERS_PER_CELL;
/*  37 */   final FurnisherStat prisoners = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  38 */   final FurnisherStat guards = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */   
/*     */   private final FurnisherItemTile cc;
/*     */   
/*     */   private final RoomSprite1x1 sCandle;
/*     */   
/*     */   private final Floors.Floor floor2;
/*     */   static final int CODE_ENTRANCE = 1;
/*     */   static final int CODE_LATRINE = 2;
/*     */   static final int CODE_FOOD = 3;
/*     */   
/*     */   protected Constructor(ROOM_PRISON blue, RoomInitData init) throws IOException {
/*  50 */     super(init, 1, 2, 88, 44);
/*  51 */     this.blue = blue;
/*  52 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.get(init.data().value("FLOOR2"), init.data());
/*     */     
/*  54 */     Json sp = init.data().json("SPRITES");
/*     */ 
/*     */     
/*  57 */     RoomSpriteCombo sWall = new RoomSpriteCombo(sp, "WALLS_COMBO");
/*  58 */     final RoomSprite1x1 sBars = new RoomSprite1x1(sp, "BARS_1X1");
/*     */     
/*  60 */     SCellOther sCellOther1 = new SCellOther(sWall, sBars, (RoomSprite)new RoomSprite1x1(sp, "LATRINE_EMPTY_1X1"), sp)
/*     */       {
/*     */         RoomSprite1x1 full;
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  66 */           if (Constructor.this.blue().is(it.tile()) && Latrine.latrineUsed((SETT.ROOMS()).data.get(it.tile())))
/*  67 */             return this.full.render(r, s, data, it, degrade, isCandle); 
/*  68 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  73 */     SCellOther sCellOther2 = new SCellOther(sWall, sBars, (RoomSprite)new RoomSprite1x1(sp, "FOOD_1X1"))
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  78 */           if (Constructor.this.blue().is(it.tile())) {
/*  79 */             int am = Food.foodAmount((SETT.ROOMS()).data.get(it.tile()));
/*  80 */             if (am > 1) {
/*  81 */               return super.render(r, s, data, it, degrade, isCandle);
/*     */             }
/*     */           } 
/*  84 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  90 */     SCellOther sCellOther3 = new SCellOther(sWall, sBars, (RoomSprite)new RoomSprite1x1(sp, "MISC_1X1"));
/*     */     
/*  92 */     final RoomSprite1x1 sOpeningp = new RoomSprite1x1(sp, "OPENING_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  95 */           return (item.get(rx, ry) == null);
/*     */         }
/*     */       };
/*     */     
/*  99 */     SCellOther sCellOther4 = new SCellOther(sWall, sBars, (RoomSprite)sOpeningp)
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 103 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 108 */           sBars.render(r, s, ((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile())).rotation, it, degrade, this.rotates);
/* 109 */           sOpeningp.render(r, s, getData2(it), it, degrade, this.rotates);
/*     */         }
/*     */       };
/*     */     
/* 113 */     this.sCandle = new RoomSprite1x1(sp, "CANDLE_SHELF_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 116 */           return (item.get(rx, ry) != null);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 121 */     FurnisherItemTile c1 = new FurnisherItemTile(
/* 122 */         this, 
/* 123 */         (RoomSprite)this.sCandle, 
/* 124 */         AVAILABILITY.ROOM, true);
/* 125 */     FurnisherItemTile dd = new FurnisherItemTile(
/* 126 */         this, 
/* 127 */         (RoomSprite)sCellOther3, 
/* 128 */         AVAILABILITY.NOT_ACCESSIBLE, false);
/* 129 */     FurnisherItemTile ll = (new FurnisherItemTile(
/* 130 */         this, 
/* 131 */         (RoomSprite)sCellOther1, 
/* 132 */         AVAILABILITY.NOT_ACCESSIBLE, false)).setData(2);
/* 133 */     FurnisherItemTile ff = (new FurnisherItemTile(
/* 134 */         this, 
/* 135 */         (RoomSprite)sCellOther2, 
/* 136 */         AVAILABILITY.NOT_ACCESSIBLE, false)).setData(3);
/* 137 */     this.cc = new FurnisherItemTile(
/* 138 */         this, 
/* 139 */         (RoomSprite)sCellOther3, 
/* 140 */         AVAILABILITY.ROOM, false);
/*     */ 
/*     */     
/* 143 */     FurnisherItemTile ss = (new FurnisherItemTile(
/* 144 */         this, 
/* 145 */         true, 
/* 146 */         (RoomSprite)sCellOther4, 
/* 147 */         AVAILABILITY.ROOM, 
/* 148 */         false)).setData(1);
/*     */     
/* 150 */     FurnisherItemTile __ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     flush(1, 3);
/*     */     
/* 163 */     this.PRISONERS_PER_CELL = (int)item(1).stat(this.prisoners);
/* 164 */     if (this.PRISONERS_PER_CELL <= 0 || this.PRISONERS_PER_CELL > 8) {
/* 165 */       throw new Errors.GameError("Prisoner stat must be between 1-8  " + this.PRISONERS_PER_CELL);
/*     */     }
/* 167 */     this.WORKERS_PER_CELL = (int)item(1).stat(this.guards);
/* 168 */     if (this.WORKERS_PER_CELL <= 0 || this.WORKERS_PER_CELL > 3) {
/* 169 */       throw new Errors.GameError("Worker stat must be between 1-3  " + this.WORKERS_PER_CELL);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isWithinCell(int nx, int ny, int cx, int cy) {
/* 175 */     if ((SETT.ROOMS()).fData.item.get(nx, ny) != null && (SETT.ROOMS()).fData.sprite.get(nx, ny) != this.sCandle && (SETT.ROOMS()).fData.item.get(cx, cy) != null) {
/* 176 */       COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(nx, ny, Coo.TMP);
/* 177 */       nx = c.x();
/* 178 */       ny = c.y();
/* 179 */       return (SETT.ROOMS()).fData.itemX1Y1(cx, cy, Coo.TMP).isSameAs(nx, ny);
/*     */     } 
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 198 */     return (Room)new PrisonInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 203 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 208 */     FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 209 */     if (t != null && t.sprite() != this.sCandle) {
/* 210 */       this.floor2.placeFixed(tx, ty);
/*     */     } else {
/* 212 */       super.putFloor(tx, ty, upgrade, area);
/*     */     } 
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
/*     */   public boolean isHeavy() {
/* 237 */     return true;
/*     */   }
/*     */   
/*     */   private static class SCellOther
/*     */     extends RoomSpriteCombo {
/*     */     private final RoomSprite other;
/*     */     private final RoomSprite1x1 sBars;
/*     */     
/*     */     public SCellOther(RoomSpriteCombo sWall, RoomSprite1x1 sBars, RoomSprite other) throws IOException {
/* 246 */       super((RoomSprite)sWall);
/* 247 */       this.sBars = sBars;
/* 248 */       this.other = other;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 254 */       return this.other.render(r, s, getData2(it), it, degrade, isCandle);
/*     */     }
/*     */ 
/*     */     
/*     */     public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 259 */       return this.other.getData(tx, ty, rx, ry, item, itemRan);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 264 */       this.sBars.render(r, s, ((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile())).rotation, it, degrade, this.rotates);
/* 265 */       super.render(r, s, data, it, degrade, this.rotates);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */