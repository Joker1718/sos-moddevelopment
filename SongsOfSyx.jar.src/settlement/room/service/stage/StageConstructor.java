/*     */ package settlement.room.service.stage;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StageConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_STAGE blue;
/*     */   static final int STATION = 1;
/*     */   final FurnisherStat.FurnisherStatI workers;
/*     */   final FurnisherStat spectators;
/*     */   
/*     */   protected StageConstructor(ROOM_STAGE blue, RoomInitData init) throws IOException {
/*  31 */     super(init, 1, 2);
/*  32 */     this.blue = blue;
/*     */     
/*  34 */     this.workers = new FurnisherStat.FurnisherStatI(this);
/*  35 */     this.spectators = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue);
/*     */     
/*  37 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  39 */     RoomSpriteBoxN first = new RoomSpriteBoxN(sp, "A_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  43 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() >= 0);
/*     */         }
/*     */       };
/*  46 */     first.sData(0);
/*     */     
/*  48 */     RoomSpriteBoxN second = new RoomSpriteBoxN(sp, "B_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  52 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() >= 1);
/*     */         }
/*     */       };
/*  55 */     second.sData(1);
/*     */     
/*  57 */     RoomSpriteBoxN third = new RoomSpriteBoxN(sp, "C_BOX")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  61 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() >= 2);
/*     */         }
/*     */       };
/*  64 */     third.sData(2);
/*     */     
/*  66 */     FurnisherItemTile AA = new FurnisherItemTile(
/*  67 */         this, 
/*  68 */         (RoomSprite)first, 
/*  69 */         AVAILABILITY.PENALTY4, 
/*  70 */         false);
/*  71 */     AA.setData(1);
/*  72 */     FurnisherItemTile aa = new FurnisherItemTile(
/*  73 */         this, 
/*  74 */         false, 
/*  75 */         (RoomSprite)first, 
/*  76 */         AVAILABILITY.ROOM, 
/*  77 */         false);
/*  78 */     FurnisherItemTile ai = new FurnisherItemTile(
/*  79 */         this, 
/*  80 */         (RoomSprite)first, 
/*  81 */         AVAILABILITY.SOLID, 
/*  82 */         true);
/*     */     
/*  84 */     FurnisherItemTile BB = new FurnisherItemTile(
/*  85 */         this, 
/*  86 */         (RoomSprite)second, 
/*  87 */         AVAILABILITY.PENALTY4, 
/*  88 */         false);
/*  89 */     BB.setData(1);
/*  90 */     FurnisherItemTile bb = new FurnisherItemTile(
/*  91 */         this, 
/*  92 */         (RoomSprite)second, 
/*  93 */         AVAILABILITY.ROOM, 
/*  94 */         false);
/*     */     
/*  96 */     FurnisherItemTile CC = new FurnisherItemTile(
/*  97 */         this, 
/*  98 */         (RoomSprite)third, 
/*  99 */         AVAILABILITY.PENALTY4, 
/* 100 */         false);
/* 101 */     CC.setData(1);
/* 102 */     FurnisherItemTile cc = new FurnisherItemTile(
/* 103 */         this, 
/* 104 */         (RoomSprite)third, 
/* 105 */         AVAILABILITY.PENALTY4, 
/* 106 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     flush(1, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 166 */     return (Room)new StageInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 171 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\stage\StageConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */