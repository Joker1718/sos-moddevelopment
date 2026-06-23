/*     */ package settlement.room.service.barber;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
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
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_BARBER blue;
/*     */   public static final int IWORK = 1;
/*     */   final FurnisherStat latrines;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat quality;
/*     */   
/*     */   protected Constructor(final ROOM_BARBER blue, RoomInitData init) throws IOException {
/*  39 */     super(init, 2, 3, 88, 44);
/*  40 */     this.blue = blue;
/*     */     
/*  42 */     this.latrines = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue);
/*  43 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployeesR(this, this.latrines, 1.0D);
/*  44 */     this.quality = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.latrines);
/*     */     
/*  46 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  48 */     final RoomSprite1x1 sNick = new RoomSprite1x1(sp, "NICKNACK_1X1");
/*  49 */     final RoomSprite1x1 sCentre = new RoomSprite1x1(sp, "TABLE_CENTRE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  52 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 22);
/*     */         }
/*     */       };
/*  55 */     final RoomSprite1x1 sCentreTop = new RoomSprite1x1(sp, "TABLE_CENTRE_TOP_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  58 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 22);
/*     */         }
/*     */       };
/*  61 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  65 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/*  66 */             sNick.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  73 */           return sNick.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/*  77 */     final RoomSpriteCombo sTableC = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  81 */           sCentre.render(r, s, getData2(it), it, degrade, false);
/*  82 */           sCentreTop.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  89 */           return sCentre.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/*  93 */     RoomSpriteImp roomSpriteImp = (new RoomSprite1x1(sp, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  96 */           return (item.sprite(rx, ry) == sTableC);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 101 */           FSERVICE ss = blue.ll.service(it.tx(), it.ty());
/* 102 */           if (ss == null)
/* 103 */             return false; 
/* 104 */           if (ss.findableReservedIs() || ss.findableReservedCanBe())
/* 105 */             return super.render(r, s, data, it, degrade, false); 
/* 106 */           return false;
/*     */         }
/* 109 */       }).sData(22);
/* 110 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "SEPARATOR_1X1")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 115 */           DIR rot = rot(data);
/* 116 */           it.setOff(-rot.x() * 32 / 2, -rot.y() * 32 / 2);
/* 117 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 122 */           rx -= d.x();
/* 123 */           ry -= d.y();
/* 124 */           d = d.next(-2);
/* 125 */           rx += d.x();
/* 126 */           ry += d.y();
/* 127 */           return (item.sprite(rx, ry) == sTableC);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 132 */     FurnisherItemTile tt = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo1, AVAILABILITY.ROOM_SOLID, true);
/* 133 */     FurnisherItemTile tc = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo2, AVAILABILITY.ROOM_SOLID, false);
/* 134 */     FurnisherItemTile oo = new FurnisherItemTile(this, true, (RoomSprite)roomSpriteImp, AVAILABILITY.AVOID_PASS, false);
/* 135 */     oo.setData(1);
/* 136 */     FurnisherItemTile __ = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x14, AVAILABILITY.ROOM_SOLID, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     flush(1, 3);
/*     */     
/* 222 */     FurnisherItemTools.makeUnder(this, sp, "CARPET_COMBO");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 227 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 237 */     return (Room)new Instance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 242 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 247 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\barber\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */