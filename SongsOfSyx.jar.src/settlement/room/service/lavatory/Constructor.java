/*     */ package settlement.room.service.lavatory;
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
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ class Constructor
/*     */   extends Furnisher {
/*     */   private final ROOM_LAVATORY blue;
/*     */   final FurnisherStat latrines;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat basins;
/*     */   
/*     */   protected Constructor(final ROOM_LAVATORY blue, RoomInitData init) throws IOException {
/*  35 */     super(init, 2, 3, 88, 44);
/*  36 */     this.blue = blue;
/*     */     
/*  38 */     this.latrines = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue);
/*  39 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployeesR(this, this.latrines, 0.125D);
/*  40 */     this.basins = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.latrines);
/*     */     
/*  42 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  44 */     final RoomSprite1x1 sNick = new RoomSprite1x1(sp, "NICKNACK_1X1");
/*     */     
/*  46 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "SIT_COMBO", sp)
/*     */       {
/*     */         private RoomSprite rim;
/*     */ 
/*     */         
/*     */         private RoomSprite lid;
/*     */ 
/*     */         
/*     */         private RoomSprite shit;
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  59 */           return this.rim.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  65 */           super.render(r, s, data, it, degrade, isCandle);
/*  66 */           if (blue.is(it.tile()) && Lavatory.isOpen((SETT.ROOMS()).data.get(it.tile()))) {
/*  67 */             this.shit.render(r, s, getData2(it), it, degrade, isCandle);
/*  68 */             this.rim.render(r, s, getData2(it), it, degrade, isCandle);
/*     */           } else {
/*  70 */             this.lid.render(r, s, getData2(it), it, degrade, isCandle);
/*     */           } 
/*     */           
/*  73 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  78 */     RoomSpriteImp roomSpriteImp = (new RoomSpriteCombo((RoomSprite)roomSpriteCombo1, sp)
/*     */       {
/*     */         private final RoomSprite top;
/*     */ 
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
/*  92 */           super.render(r, s, data, it, degrade, isCandle);
/*  93 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  98 */           this.top.render(r, s, getData2(it), it, degrade, this.rotates);
/*  99 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile()) && (
/* 100 */             GUTIL.ran2().get(it.tile()) & 0x3) == 0) {
/* 101 */             sNick.render(r, s, 0, it, degrade, false);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 107 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/* 110 */       }).sData(1);
/*     */     
/* 112 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 115 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 116 */             sNick.render(r, s, 0, it, degrade, false);
/*     */           }
/*     */         }
/*     */       };
/* 120 */     RoomSpriteCombo roomSpriteCombo3 = new RoomSpriteCombo(sp, "TABLE_COMBO", sp)
/*     */       {
/*     */         private RoomSprite water;
/*     */ 
/*     */ 
/*     */         
/*     */         private RoomSprite basin;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 132 */           return this.basin.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 138 */           super.render(r, s, data, it, degrade, isCandle);
/* 139 */           this.water.render(r, s, getData2(it), it, degrade, isCandle);
/* 140 */           this.basin.render(r, s, getData2(it), it, degrade, isCandle);
/* 141 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 146 */     RoomSpriteCombo roomSpriteCombo4 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo3)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 150 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 151 */             sNick.render(r, s, data, it, degrade, false);
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 156 */     FurnisherItemTile tt = (new FurnisherItemTile(this, true, (RoomSprite)roomSpriteCombo1, AVAILABILITY.AVOID_PASS, false)).setData(32768);
/* 157 */     FurnisherItemTile cc = new FurnisherItemTile(this, (RoomSprite)roomSpriteImp, AVAILABILITY.ROOM_SOLID, false);
/* 158 */     FurnisherItemTile ce = new FurnisherItemTile(this, (RoomSprite)roomSpriteCombo2, AVAILABILITY.ROOM_SOLID, true);
/* 159 */     FurnisherItemTile ww = (new FurnisherItemTile(this, true, (RoomSprite)roomSpriteCombo3, AVAILABILITY.ROOM_SOLID, false)).setData(16384);
/* 160 */     FurnisherItemTile m1 = new FurnisherItemTile(this, (RoomSprite)roomSpriteCombo4, AVAILABILITY.ROOM_SOLID, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     flush(0, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 260 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 270 */     return (Room)new LavatoryInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 275 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 280 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\lavatory\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */