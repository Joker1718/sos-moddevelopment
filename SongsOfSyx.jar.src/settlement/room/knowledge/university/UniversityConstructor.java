/*     */ package settlement.room.knowledge.university;
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
/*     */ final class UniversityConstructor
/*     */   extends Furnisher
/*     */ {
/*  27 */   public final FurnisherStat students = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*  28 */   public final FurnisherStat quality = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.students, 1.0D);
/*     */   
/*     */   private final ROOM_UNIVERSITY blue;
/*     */   
/*     */   static final int IWORK = 1;
/*     */   
/*     */   static final int IWORKE = 2;
/*     */ 
/*     */   
/*     */   protected UniversityConstructor(ROOM_UNIVERSITY blue, RoomInitData init) throws IOException {
/*  38 */     super(init, 2, 2, 88, 44);
/*  39 */     this.blue = blue;
/*     */     
/*  41 */     Json sp = init.data().json("SPRITES");
/*     */ 
/*     */ 
/*     */     
/*  45 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "BENCH_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  49 */           for (int i = 0; i < 3; i++) {
/*  50 */             if (item.sprite(rx + d.x() * i, ry + d.y() * i) != null && item.sprite(rx + d.x() * i, ry + d.y() * i).sData() == 2)
/*  51 */               return true; 
/*     */           } 
/*  53 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  59 */           type().renderOverlay(
/*  60 */               x, y, r, AVAILABILITY.AVOID_PASS, 
/*  61 */               0, data, true);
/*     */         }
/*     */       };
/*     */     
/*  65 */     final RoomSpriteImp sCarpet = (new RoomSpriteCombo(sp, "CARPET_COMBO")
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  68 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  73 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  78 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*  80 */       }).sData(1);
/*  81 */     RoomSpriteImp roomSpriteImp2 = (new RoomSpriteCombo((RoomSprite)roomSpriteImp1, sp)
/*     */       {
/*     */         final RoomSprite ca;
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  87 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  92 */           return this.ca.render(r, s, getData2(it), it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  97 */           return this.ca.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 102 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/* 104 */       }).sData(1);
/*     */     
/* 106 */     RoomSpriteImp roomSpriteImp3 = (new RoomSpriteCombo(sp, "PODIUM_COMBO")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 111 */           super.render(r, s, data, it, degrade, isCandle);
/* 112 */           data = getData2(it);
/* 113 */           if (data != 0)
/* 114 */             sCarpet.renderBelow(r, s, getData2(it), it, degrade); 
/* 115 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 121 */           int m = 0;
/* 122 */           if (!isC(rx, ry, item))
/* 123 */             return 0; 
/* 124 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 125 */             DIR d = (DIR)DIR.ORTHO.get(di);
/* 126 */             if (isC(rx + d.x(), ry + d.y(), item))
/* 127 */               m |= d.mask(); 
/*     */           } 
/* 129 */           return (byte)m;
/*     */         }
/*     */         
/*     */         private boolean isC(int rx, int ry, FurnisherItem item) {
/* 133 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 134 */             DIR d = (DIR)DIR.ORTHO.get(di);
/* 135 */             if (item.sprite(rx + d.x(), ry + d.y()) != this)
/* 136 */               return false; 
/*     */           } 
/* 138 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 143 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 2);
/*     */         }
/* 146 */       }).sData(2);
/*     */     
/* 148 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "SHELF_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 154 */           if (item.width() == 1 || item.height() == 1)
/* 155 */             return (d.orthoID() == item.rotation); 
/* 156 */           return (item.sprite(rx, ry) == this && (d.orthoID() == item.rotation || d.perpendicular().orthoID() == item.rotation));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 162 */           super.render(r, s, data, it, degrade, isCandle);
/* 163 */           it.ranOffset(1, 1);
/* 164 */           return this.top.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 169 */     FurnisherItemTile po = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteImp3, AVAILABILITY.AVOID_PASS, false);
/* 170 */     FurnisherItemTile pc = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteImp3, AVAILABILITY.AVOID_PASS, false);
/* 171 */     pc.setData(2);
/* 172 */     FurnisherItemTile bb = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.AVOID_PASS, false);
/* 173 */     bb.setData(1);
/* 174 */     FurnisherItemTile sh = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, false);
/* 175 */     FurnisherItemTile ca = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteImp2, AVAILABILITY.ROOM_SOLID, true);
/* 176 */     FurnisherItemTile __ = null;
/* 177 */     FurnisherItemTile cc = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteImp1, AVAILABILITY.ROOM, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 261 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 271 */     return (Room)new UniversityInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 276 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 281 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledg\\university\UniversityConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */