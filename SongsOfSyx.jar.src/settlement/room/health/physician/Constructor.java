/*     */ package settlement.room.health.physician;
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
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_PHYSICIAN blue;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat services;
/*     */   final FurnisherStat quality;
/*     */   static final int BIT_SERVICE = 3;
/*     */   
/*     */   protected Constructor(ROOM_PHYSICIAN blue, RoomInitData init) throws IOException {
/*  37 */     super(init, 2, 3, 88, 44);
/*  38 */     this.blue = blue;
/*     */     
/*  40 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  41 */     this.services = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, (RoomService.ROOM_SERVICE_HASER)blue, 1);
/*  42 */     this.quality = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.services);
/*     */     
/*  44 */     Json js = init.data().json("SPRITES");
/*  45 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(js, "SHELF_1X1", js)
/*     */       {
/*     */         RoomSprite top;
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  51 */           return (d.orthoID() == item.rotation);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  56 */           this.top.render(r, s, data, it, degrade, false); }
/*     */       };
/*  58 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(js, "BUNK_1X1_TOP", false);
/*  59 */     final RoomSprite1xN sBunkB = new RoomSprite1xN(js, "BUNK_1X1_BOTTOM", true);
/*     */     
/*  61 */     final RoomSprite1x1 top = new RoomSprite1x1(js, "TABLE_ONTOP_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  65 */           if (!(item.sprite(rx + d.perpendicular().x() * 2, ry + d.perpendicular().y() * 2) instanceof RoomSpriteCombo))
/*  66 */             return true; 
/*  67 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  71 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(js, "TABLE_COMBO")
/*     */       {
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  77 */           if (!SETT.LIGHTS().is(it.tx(), it.ty())) {
/*  78 */             top.render(r, s, (SETT.ROOMS()).fData.spriteData2.get(it.tile()), it, degrade, false);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  84 */           return top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  89 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(js, "STORAGE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  93 */           return (item.sprite(rx, ry) == sBunkB);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  98 */     RoomSprite.Dummy dummy = new RoomSprite.Dummy();
/*     */ 
/*     */     
/* 101 */     FurnisherItemTile sh = new FurnisherItemTile(
/* 102 */         this, 
/* 103 */         (RoomSprite)roomSprite1x11, 
/* 104 */         AVAILABILITY.ROOM_SOLID, 
/* 105 */         false);
/*     */     
/* 107 */     FurnisherItemTile ch = new FurnisherItemTile(
/* 108 */         this, 
/* 109 */         (RoomSprite)roomSprite1x12, 
/* 110 */         AVAILABILITY.ROOM_SOLID, 
/* 111 */         false);
/*     */     
/* 113 */     FurnisherItemTile ta = new FurnisherItemTile(
/* 114 */         this, 
/* 115 */         (RoomSprite)roomSpriteCombo, 
/* 116 */         AVAILABILITY.ROOM_SOLID, 
/* 117 */         true);
/*     */     
/* 119 */     FurnisherItemTile tt = new FurnisherItemTile(
/* 120 */         this, 
/* 121 */         true, 
/* 122 */         (RoomSprite)roomSpriteCombo, 
/* 123 */         AVAILABILITY.ROOM_SOLID, 
/* 124 */         true);
/*     */     
/* 126 */     FurnisherItemTile b1 = (new FurnisherItemTile(
/* 127 */         this, 
/* 128 */         true, 
/* 129 */         (RoomSprite)roomSprite1xN1, 
/* 130 */         AVAILABILITY.NOT_ACCESSIBLE, 
/* 131 */         false)).setData(3);
/*     */     
/* 133 */     FurnisherItemTile b2 = new FurnisherItemTile(
/* 134 */         this, 
/* 135 */         (RoomSprite)roomSprite1xN2, 
/* 136 */         AVAILABILITY.NOT_ACCESSIBLE, 
/* 137 */         false);
/*     */     
/* 139 */     FurnisherItemTile ee = new FurnisherItemTile(
/* 140 */         this, 
/* 141 */         true, 
/* 142 */         (RoomSprite)dummy, 
/* 143 */         AVAILABILITY.ROOM, 
/* 144 */         false);
/* 145 */     ee.noWalls = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 200 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 205 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 210 */     return (Room)new Instance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 215 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */   
/*     */   public boolean isHeavy() {
/* 219 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\physician\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */