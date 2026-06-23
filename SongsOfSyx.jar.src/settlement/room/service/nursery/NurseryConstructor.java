/*     */ package settlement.room.service.nursery;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class NurseryConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_NURSERY blue;
/*     */   static final int TABLE = 1;
/*     */   static final int CARPET = 2;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat kids;
/*     */   final FurnisherStat coziness;
/*     */   
/*     */   protected NurseryConstructor(final ROOM_NURSERY blue, RoomInitData init) throws IOException {
/*  37 */     super(init, 3, 3);
/*  38 */     this.blue = blue;
/*     */ 
/*     */     
/*  41 */     this.kids = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  42 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployeesR(this, this.kids, 0.2D);
/*  43 */     this.coziness = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.kids);
/*     */     
/*  45 */     Json sData = init.data().json("SPRITES");
/*     */     
/*  47 */     final RoomSprite1x1 sStuff = new RoomSprite1x1(sData, "STUFF_1X1");
/*     */     
/*  49 */     final RoomSprite.Dummy sAbove = new RoomSprite.Dummy()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  54 */           if (!isCandle) {
/*  55 */             long rr = it.bigRan();
/*  56 */             for (int i = 0; i < blue.ss.stuff(it.tx(), it.ty()); i++) {
/*  57 */               it.ranOffset(((DIR)DIR.ORTHO.get(i)).x(), ((DIR)DIR.ORTHO.get(i)).y());
/*  58 */               DIR dd = (DIR)DIR.ALL.getC((int)(rr & 0x111L));
/*  59 */               it.setOff((int)(dd.xN() * 32.0D / 2.0D), (int)(dd.yN() * 32.0D / 2.0D));
/*  60 */               rr >>= 3L;
/*  61 */               int data2 = (int)(rr & 0xFL);
/*  62 */               rr >>= 4L;
/*  63 */               sStuff.render(r, s, data2, it, degrade, false);
/*     */             } 
/*     */           } 
/*     */           
/*  67 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  72 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(sData, "TABLE_COMBO")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  76 */           boolean ret = super.render(r, s, data, it, degrade, isCandle);
/*     */           
/*  78 */           sAbove.render(r, s, data, it, degrade, isCandle);
/*     */ 
/*     */           
/*  81 */           return ret;
/*     */         }
/*     */       };
/*  84 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sData, "1x1_CHAIR")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  87 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */       };
/*  90 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sData, "SHELF_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  93 */           return (d.orthoID() == item.rotation);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 100 */           super.render(r, s, data, it, degrade, isCandle);
/*     */ 
/*     */           
/* 103 */           sStuff.render(r, s, getData2(it), it, degrade, false);
/* 104 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 109 */           return sStuff.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 114 */     FurnisherItemTile tt = new FurnisherItemTile(
/* 115 */         this, 
/* 116 */         (RoomSprite)roomSpriteCombo, 
/* 117 */         AVAILABILITY.ROOM_SOLID, 
/* 118 */         true);
/* 119 */     tt.setData(1);
/*     */     
/* 121 */     FurnisherItemTile ss = new FurnisherItemTile(
/* 122 */         this, 
/* 123 */         true, 
/* 124 */         (RoomSprite)roomSprite1x12, 
/* 125 */         AVAILABILITY.AVOID_PASS, 
/* 126 */         false);
/*     */     
/* 128 */     FurnisherItemTile sh = new FurnisherItemTile(
/* 129 */         this, 
/* 130 */         (RoomSprite)roomSprite1x13, 
/* 131 */         AVAILABILITY.ROOM_SOLID, 
/* 132 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     flush(3);
/*     */     
/* 196 */     FurnisherItemTile cc = FurnisherItemTools.makeUnder(this, sData, "CARPET_COMBO", (RoomSprite)dummy);
/* 197 */     cc.setData(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 226 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 231 */     return (Room)new NurseryInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 236 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 241 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\NurseryConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */