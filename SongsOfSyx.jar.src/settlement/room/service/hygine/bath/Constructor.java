/*     */ package settlement.room.service.hygine.bath;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
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
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteTex;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_BATH blue;
/*     */   final FurnisherItemTile tileBasin;
/*     */   
/*  43 */   final FurnisherStat baths = new FurnisherStat(this, 1.0D)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  47 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  52 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */   
/*  56 */   final FurnisherStat relaxation = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.baths, 1.5D);
/*     */   
/*     */   protected Constructor(final ROOM_BATH blue, RoomInitData init) throws IOException {
/*  59 */     super(init, 2, 2);
/*  60 */     this.blue = blue;
/*     */     
/*  62 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  64 */     final RoomSpriteCombo spriteNormal = new RoomSpriteCombo(sp, "FRAME_COMBO", sp, init)
/*     */       {
/*     */         RoomSprite spriteFloor;
/*     */         
/*     */         COLOR wColor;
/*     */         double wOp;
/*     */         OpacityImp opacity;
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  73 */           this.spriteFloor.render(r, ShadowBatch.DUMMY, 0, it, degrade, isCandle);
/*  74 */           if (blue.is(it.tile())) {
/*  75 */             int i = (SETT.ROOMS()).data.get(it.tile()) & 0x1;
/*  76 */             if (i > 0) {
/*  77 */               renderB(r, s, it);
/*     */             }
/*     */           } 
/*  80 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderB(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*  85 */           int x2 = it.x() + 64;
/*  86 */           int y2 = it.y() + 64;
/*     */ 
/*     */           
/*  89 */           this.wColor.bind();
/*  90 */           this.opacity.bind();
/*  91 */           TextureCoords oo = (SPRITES.textures()).dis_small.get((it.tx() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D, (it.ty() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D);
/*  92 */           CORE.renderer().renderSprite(it.x(), x2, it.y(), y2, oo);
/*  93 */           oo = (SPRITES.textures()).dis_small.get(((it.tx() + 1) * 16) - 8.0D * TIME.currentSecond(), ((it.ty() + 1) * 16) - 8.0D * TIME.currentSecond());
/*  94 */           CORE.renderer().renderSprite(it.x(), x2, it.y(), y2, oo);
/*  95 */           COLOR.unbind();
/*  96 */           OPACITY.unbind();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "WORK_1X1")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 107 */           animate(0.0D);
/* 108 */           if (blue.is(it.tile()) && Crank.working((SETT.ROOMS()).data.get(it.tile()))) {
/* 109 */             animate(1.0D);
/*     */           }
/* 111 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 117 */     final RoomSprite1x1 spriteOven = new RoomSprite1x1(sp, "OVEN_1X1");
/*     */     
/* 119 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "ENTRANCE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 122 */           return (item.sprite(rx, ry) == spriteNormal);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 127 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "PIPE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 130 */           return !(item.sprite(rx, ry) != spriteOven && item.sprite(rx, ry) != this);
/*     */         }
/*     */       };
/*     */     
/* 134 */     RoomSprite1x1 roomSprite1x15 = new RoomSprite1x1(sp, "BENCH_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 138 */           return (d.perpendicular().orthoID() == item.rotation);
/*     */         }
/*     */       };
/*     */     
/* 142 */     RoomSprite1x1 roomSprite1x16 = new RoomSprite1x1((RoomSprite)roomSprite1x15)
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 145 */           return (d.orthoID() == item.rotation);
/*     */         }
/*     */       };
/*     */     
/* 149 */     RoomSprite1x1 roomSprite1x17 = new RoomSprite1x1(sp, "TORCH_1X1");
/*     */     
/* 151 */     FurnisherItemTile ww = (new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false)).setData(32768);
/* 152 */     FurnisherItemTile ss = (new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x13, AVAILABILITY.AVOID_PASS, false)).setData(49152);
/* 153 */     FurnisherItemTile nn = (new FurnisherItemTile(this, (RoomSprite)roomSpriteCombo, AVAILABILITY.AVOID_PASS, false)).setData(57344);
/* 154 */     FurnisherItemTile mm = new FurnisherItemTile(this, (RoomSprite)roomSprite1x17, AVAILABILITY.ROOM_SOLID, true);
/* 155 */     FurnisherItemTile ov = (new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, false)).setData(16384);
/* 156 */     FurnisherItemTile pi = new FurnisherItemTile(this, (RoomSprite)roomSprite1x14, AVAILABILITY.ROOM_SOLID, false);
/* 157 */     FurnisherItemTile b1 = (new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x15, AVAILABILITY.AVOID_PASS, false)).setData(8192);
/* 158 */     FurnisherItemTile b2 = (new FurnisherItemTile(this, (RoomSprite)roomSprite1x16, AVAILABILITY.AVOID_PASS, false)).setData(84);
/* 159 */     FurnisherItemTile __ = null;
/* 160 */     this.tileBasin = nn;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     flush(1, 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 268 */     flush(3);
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
/* 283 */     return (Room)new BathInstance(this.blue, area, init);
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */