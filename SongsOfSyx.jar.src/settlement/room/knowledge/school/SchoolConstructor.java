/*     */ package settlement.room.knowledge.school;
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
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SchoolConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   public final FurnisherStat stations;
/*     */   public final FurnisherStat quality;
/*     */   private final ROOM_SCHOOL blue;
/*     */   static final int ISERVICE = 1;
/*     */   static final int IWORK = 2;
/*     */   
/*     */   protected SchoolConstructor(final ROOM_SCHOOL blue, RoomInitData init) throws IOException {
/*  38 */     super(init, 3, 2, 88, 44);
/*  39 */     this.blue = blue;
/*  40 */     this.stations = (FurnisherStat)new FurnisherStat.FurnisherStatServices(this, blue);
/*  41 */     this.quality = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.stations);
/*     */     
/*  43 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  45 */     RoomSpriteImp roomSpriteImp1 = (new RoomSprite1x1(sp, "TABLE_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  58 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  63 */           if (blue.is(it.tile())) {
/*  64 */             DIR d = (DIR)DIR.ORTHO.get(getRot(data));
/*  65 */             FSERVICE f = blue.station.service(it.tx() + d.x(), it.ty() + d.y());
/*  66 */             if (f != null && (f.findableReservedCanBe() || f.findableReservedIs())) {
/*  67 */               this.top.render(r, s, getData2(it), it, degrade, false);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  74 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*  78 */       }).sData(2);
/*     */     
/*  80 */     RoomSpriteImp roomSpriteImp2 = (new RoomSprite1x1(sp, "STOOL_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  84 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 2);
/*     */         }
/*  87 */       }).sData(1);
/*     */     
/*  89 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "SHELF_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  95 */           if (item.width() > 1 && item.height() > 1) {
/*  96 */             return ((d == DIR.ORTHO.get(item.rotation) || d == ((DIR)DIR.ORTHO.get(item.rotation)).perpendicular()) && item.sprite(rx, ry) == this);
/*     */           }
/*  98 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 103 */           this.top.render(r, s, data, it, degrade, false);
/*     */         }
/*     */       };
/*     */     
/* 107 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1((RoomSprite)roomSpriteImp1, sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 113 */           if (item.width() > 1 && item.height() > 1) {
/* 114 */             return ((d == DIR.ORTHO.get(item.rotation) || d == ((DIR)DIR.ORTHO.get(item.rotation)).perpendicular()) && item.sprite(rx, ry) == this);
/*     */           }
/* 116 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 121 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 122 */             this.top.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 128 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 133 */     FurnisherItemTile ss = new FurnisherItemTile(this, true, (RoomSprite)roomSpriteImp1, AVAILABILITY.ROOM_SOLID, false);
/* 134 */     ss.setData(2);
/* 135 */     FurnisherItemTile bb = new FurnisherItemTile(this, true, (RoomSprite)roomSpriteImp2, AVAILABILITY.AVOID_PASS, false);
/* 136 */     bb.setData(1);
/* 137 */     FurnisherItemTile sh = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false);
/* 138 */     FurnisherItemTile ta = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, true);
/*     */     
/* 140 */     FurnisherItemTile __ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     flush(3);
/*     */     
/* 231 */     FurnisherItemTools.makeUnder(this, sp, "CARPET_COMBO");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 236 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 241 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 247 */     return (Room)new SchoolInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 252 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 257 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\SchoolConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */