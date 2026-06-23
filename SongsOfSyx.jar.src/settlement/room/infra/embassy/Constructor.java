/*     */ package settlement.room.infra.embassy;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.IndustryResource;
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
/*     */ final class Constructor
/*     */   extends Furnisher {
/*  29 */   public final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this);
/*  30 */   public final FurnisherStat efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers);
/*     */ 
/*     */   
/*     */   private final ROOM_EMBASSY blue;
/*     */   
/*     */   static final int IWORK = 3;
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_EMBASSY blue, RoomInitData init) throws IOException {
/*  39 */     super(init, 3, 2);
/*  40 */     this.blue = blue;
/*     */     
/*  42 */     Json sp = init.data().json("SPRITES");
/*     */ 
/*     */ 
/*     */     
/*  46 */     final RoomSprite1x1 sDecor = new RoomSprite1x1(sp, "DECOR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  50 */           if ((d.orthoID() == item.rotation || d.perpendicular().orthoID() == item.rotation) && 
/*  51 */             item.get(rx, ry) != null && (item.get(rx, ry)).sprite instanceof RoomSpriteCombo) {
/*  52 */             return true;
/*     */           }
/*     */           
/*  55 */           return false;
/*     */         }
/*     */       };
/*  58 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo(sp, "TABLE_COMBO");
/*     */     
/*  60 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1, sp)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  78 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/*  80 */           this.top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  86 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */     
/*  90 */     RoomSpriteCombo roomSpriteCombo3 = new RoomSpriteCombo((RoomSprite)roomSpriteCombo1)
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/*  94 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/*  96 */           sDecor.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 102 */           return sDecor.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 108 */           super.renderPlaceholder(r, x, y, data, tx, ty, rx, ry, item);
/* 109 */           if (item.width() == 1 || item.height() == 1);
/* 110 */           (SPRITES.cons()).ICO.arrows.get(item.rotation);
/*     */         }
/*     */       };
/*     */     
/* 114 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "SHELF_1X1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 118 */           if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */             return; 
/* 120 */           sDecor.render(r, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 125 */           if (item.width() > 1 && item.height() > 1) {
/* 126 */             if ((((DIR)DIR.ORTHO.get(item.rotation)).x() * d.x() != 0 || ((DIR)DIR.ORTHO.get(item.rotation)).y() * d.y() != 0) && item.sprite(rx, ry) == this)
/* 127 */               return true; 
/* 128 */             return false;
/*     */           } 
/* 130 */           return (DIR.ORTHO.get(item.rotation) == d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 135 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "TABLE_1X1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 139 */           EmbassyInstance ins = (EmbassyInstance)blue.getter.get(it.tx(), it.ty());
/* 140 */           if (ins != null && blue.consumption().ins().size() == 0) {
/* 141 */             long iran = it.bigRan();
/* 142 */             int ri = (int)((iran & 0xFL) % blue.consumption().ins().size());
/* 143 */             iran >>= 4L;
/* 144 */             double dam = (iran & 0xFFL) / 255.0D;
/*     */ 
/*     */             
/* 147 */             int am = 8 * blue.consumption().stored((IndustryResource)blue.consumption().ins().get(ri)).get(ins) / Constructor.this.blue.maxRes(ri, ins);
/* 148 */             am = (int)(am * (0.5D + dam));
/* 149 */             if (am > 0) {
/* 150 */               ((IndustryResource)blue.consumption().ins().get(ri)).resource.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 157 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "STOOL_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 160 */           return item.sprite(rx, ry) instanceof RoomSpriteCombo;
/*     */         }
/*     */       };
/*     */     
/* 164 */     FurnisherItemTile rr = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x13, AVAILABILITY.ROOM_SOLID, false);
/* 165 */     FurnisherItemTile ww = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo2, AVAILABILITY.ROOM_SOLID, true);
/* 166 */     FurnisherItemTile dd = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo3, AVAILABILITY.ROOM_SOLID, true);
/* 167 */     FurnisherItemTile ch = new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x14, AVAILABILITY.AVOID_PASS, false);
/* 168 */     FurnisherItemTile sh = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.AVOID_PASS, true);
/* 169 */     ww.setData(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     flush(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 266 */     flush(3);
/*     */     
/* 268 */     FurnisherItemTools.makeUnder(this, sp, "CARPET_COMBO");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 273 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 278 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 283 */     return (Room)new EmbassyInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 288 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 293 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\embassy\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */