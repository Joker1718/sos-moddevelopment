/*     */ package settlement.room.spirit.grave;
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
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class CTomb
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_TOMB blue;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat services;
/*     */   final FurnisherStat respekk;
/*     */   final RoomSprite sHead;
/*     */   
/*     */   protected CTomb(final ROOM_TOMB blue, RoomInitData init) throws IOException {
/*  40 */     super(init, 2, 3, 88, 44);
/*  41 */     this.blue = blue;
/*     */     
/*  43 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this, 0.0D);
/*  44 */     this.services = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  45 */     this.respekk = new FurnisherStat(this)
/*     */       {
/*     */         public double get(AREA area, double fromItems)
/*     */         {
/*  49 */           fromItems /= area.area();
/*  50 */           fromItems *= 2.0D;
/*  51 */           return CLAMP.d(fromItems, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public GText format(GText t, double value) {
/*  56 */           return GFORMAT.perc(t, value);
/*     */         }
/*     */       };
/*  59 */     Json sData = init.data().json("SPRITES");
/*     */     
/*  61 */     this.sHead = (RoomSprite)new RoomSprite1xN(sData, "HEAD_BOTTOM_1X1", false, sData)
/*     */       {
/*     */         final RoomSprite1xN lid;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  68 */           super.render(r, s, data, it, degrade, isCandle);
/*  69 */           if (blue.is(it.tile())) {
/*  70 */             int x = it.tx() + offX(data);
/*  71 */             int y = it.ty() + offY(data);
/*  72 */             if (Grave.isUsed(x, y)) {
/*  73 */               this.lid.render(r, s, getData2(it), it, degrade, isCandle);
/*     */             }
/*     */           } 
/*  76 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  81 */           return this.lid.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/*  85 */     RoomSprite1xN roomSprite1xN = new RoomSprite1xN(sData, "TAIL_BOTTOM_1X1", true, sData)
/*     */       {
/*     */         final RoomSprite1xN lid;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  92 */           super.render(r, s, data, it, degrade, isCandle);
/*  93 */           if (blue.is(it.tile()) && 
/*  94 */             Grave.isUsed(it.tx(), it.ty())) {
/*  95 */             this.lid.render(r, s, getData2(it), it, degrade, isCandle);
/*     */           }
/*     */           
/*  98 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 103 */           return this.lid.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 108 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sData, "STONE_1X1");
/*     */ 
/*     */ 
/*     */     
/* 112 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sData, "MONUMENT_1x1");
/* 113 */     RoomSpriteXxX roomSpriteXxX1 = new RoomSpriteXxX(sData, "MONUMENT_2x2", 2);
/* 114 */     RoomSpriteXxX roomSpriteXxX2 = new RoomSpriteXxX(sData, "MONUMENT_3x3", 3);
/*     */     
/* 116 */     FurnisherItemTile ss = new FurnisherItemTile(
/* 117 */         this, 
/* 118 */         false, 
/* 119 */         (RoomSprite)roomSprite1x12, 
/* 120 */         AVAILABILITY.SOLID, 
/* 121 */         false);
/*     */     
/* 123 */     FurnisherItemTile sm = new FurnisherItemTile(
/* 124 */         this, 
/* 125 */         false, 
/* 126 */         (RoomSprite)roomSpriteXxX1, 
/* 127 */         AVAILABILITY.SOLID, 
/* 128 */         false);
/*     */     
/* 130 */     FurnisherItemTile sl = new FurnisherItemTile(
/* 131 */         this, 
/* 132 */         false, 
/* 133 */         (RoomSprite)roomSpriteXxX2, 
/* 134 */         AVAILABILITY.SOLID, 
/* 135 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     FurnisherItemTile h1 = new FurnisherItemTile(
/* 141 */         this, 
/* 142 */         false, 
/* 143 */         this.sHead, 
/* 144 */         AVAILABILITY.SOLID, 
/* 145 */         false);
/*     */     
/* 147 */     FurnisherItemTile t1 = (new FurnisherItemTile(
/* 148 */         this, 
/* 149 */         true, 
/* 150 */         (RoomSprite)roomSprite1xN, 
/* 151 */         AVAILABILITY.SOLID, 
/* 152 */         false)).setData(1);
/* 153 */     FurnisherItemTile st = new FurnisherItemTile(
/* 154 */         this, 
/* 155 */         false, 
/* 156 */         (RoomSprite)roomSprite1x11, 
/* 157 */         AVAILABILITY.SOLID, true);
/* 158 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 159 */         this, 
/* 160 */         false, 
/* 161 */         null, 
/* 162 */         AVAILABILITY.ROOM, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 227 */     return (Room)new GraveInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 232 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\CTomb.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */