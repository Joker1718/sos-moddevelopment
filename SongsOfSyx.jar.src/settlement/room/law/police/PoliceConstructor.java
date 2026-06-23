/*     */ package settlement.room.law.police;
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
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PoliceConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_POLICE blue;
/*  31 */   final FurnisherStat prisoners = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*  32 */   final FurnisherStat.FurnisherStatEfficiency efficiency = new FurnisherStat.FurnisherStatEfficiency(this, this.prisoners);
/*     */   
/*     */   static final int bitWork = 1;
/*     */   
/*     */   static final int bitService = 3;
/*     */   
/*     */   static final int bitBed = 7;
/*     */   
/*     */   private final RoomSprite table;
/*     */   
/*     */   protected PoliceConstructor(ROOM_POLICE blue, RoomInitData init) throws IOException {
/*  43 */     super(init, 5, 2);
/*  44 */     this.blue = blue;
/*     */     
/*  46 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  48 */     final RoomSprite1x1 sStrap = new RoomSprite1x1(sp, "BED_STRAP_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  52 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */       };
/*     */     
/*  56 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "BED_1X1A", true)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  60 */           sStrap.render(r, s, getData2(it), it, degrade, false);
/*  61 */           super.renderAbove(r, s, data, it, degrade);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  66 */           return sStrap.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/*  70 */     RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "BED_1X1A", false)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  74 */           if (SETT.ENTITIES().getAtTile(it.tx(), it.ty()) != null)
/*  75 */             sStrap.render(r, s, getData2(it), it, degrade, false); 
/*  76 */           super.renderAbove(r, s, data, it, degrade);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  81 */           return sStrap.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  86 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  90 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  95 */           if (SETT.ENTITIES().getAtTile(it.tx(), it.ty()) != null) {
/*  96 */             sStrap.render(r, s, getData2(it), it, degrade, false);
/*     */           }
/*  98 */           super.renderAbove(r, s, data, it, degrade);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 103 */           return sStrap.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 108 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "CAGE_A_1X1", sp)
/*     */       {
/*     */         final RoomSprite roof;
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 114 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 119 */           super.render(r, s, data, it, degrade, false);
/* 120 */           this.roof.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 128 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 133 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "CAGE_B_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 137 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 142 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 148 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 153 */     RoomSprite1x1 roomSprite1x15 = new RoomSprite1x1(sp, "CAGE_LATCH_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 157 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 162 */           DIR d = rot(data).perpendicular();
/* 163 */           if (SETT.ENTITIES().getAtTile(it.tx() + d.x(), it.ty() + d.y()) != null)
/*     */             return; 
/* 165 */           super.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 171 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 177 */     this.table = (RoomSprite)new RoomSpriteCombo(sp, "TABLE_COMBO", sp)
/*     */       {
/*     */         final RoomSprite1x1 top;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 183 */           if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 184 */             this.top.render(r, s, data, it, degrade, false);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 190 */     FurnisherItemTile __ = new FurnisherItemTile(this, true, (RoomSprite)RoomSprite.DUMMY, AVAILABILITY.AVOID_PASS, false);
/* 191 */     FurnisherItemTile tt = (new FurnisherItemTile(this, this.table, AVAILABILITY.ROOM_SOLID, true)).setData(1);
/*     */ 
/*     */     
/* 194 */     FurnisherItemTile ss = new FurnisherItemTile(this, (RoomSprite)roomSprite1xN2, AVAILABILITY.NOT_ACCESSIBLE, false);
/* 195 */     FurnisherItemTile furnisherItemTile2 = (new FurnisherItemTile(this, (RoomSprite)roomSprite1xN1, AVAILABILITY.NOT_ACCESSIBLE, false)).setData(7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     flush(3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     ss = (new FurnisherItemTile(this, (RoomSprite)roomSprite1x12, AVAILABILITY.NOT_ACCESSIBLE, false)).setData(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 253 */     flush(3);
/*     */ 
/*     */     
/* 256 */     FurnisherItemTile sh = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x15, AVAILABILITY.AVOID_PASS, false);
/*     */ 
/*     */     
/* 259 */     FurnisherItemTile furnisherItemTile1 = (new FurnisherItemTile(this, (RoomSprite)roomSprite1x13, AVAILABILITY.NOT_ACCESSIBLE, false)).setData(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     flush(3);
/*     */ 
/*     */ 
/*     */     
/* 290 */     furnisherItemTile1 = (new FurnisherItemTile(this, (RoomSprite)roomSprite1x14, AVAILABILITY.NOT_ACCESSIBLE, false)).setData(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 317 */     flush(3);
/*     */ 
/*     */     
/* 320 */     tt = (new FurnisherItemTile(this, true, this.table, AVAILABILITY.ROOM_SOLID, true)).setData(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 369 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 376 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 381 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 386 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 391 */     return (Room)new PoliceInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 396 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 401 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\PoliceConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */