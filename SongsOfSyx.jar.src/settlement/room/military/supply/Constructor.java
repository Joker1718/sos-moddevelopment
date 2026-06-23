/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import game.GAME;
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
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final Floors.Floor floor2;
/*     */   
/*  37 */   final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatI(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  41 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  46 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */   
/*  50 */   final FurnisherStat storage = new FurnisherStat(this, 0.0D)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  54 */         return fromItems * 80.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  59 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   protected Constructor(ROOM_SUPPLY b, RoomInitData init) throws IOException {
/*  65 */     super(init, 1, 2, 88, 44);
/*     */     
/*  67 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.read("FLOOR2", init.data());
/*     */     
/*  69 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  71 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(sp, "FENCE_COMBO");
/*     */     
/*  73 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "TORCH_1X1");
/*  74 */     final Crate crate = new Crate(b);
/*  75 */     RoomSprite.Imp imp1 = new RoomSprite.Imp()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  80 */           if (crate.get(it.tx(), it.ty()) != null && !crate.away()) {
/*  81 */             (SETT.HALFENTS()).transports.sprite.renderBelow(r, s, data * 2, it.x() + 32, it.y() + 32, 0.0D, it.ran(), degrade, crate.realResource(), crate.resAmount());
/*     */           }
/*  83 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  88 */           if (crate.get(it.tx(), it.ty()) != null && !crate.away()) {
/*  89 */             (SETT.HALFENTS()).transports.sprite.render(r, s, data * 2, it.x() + 32, it.y() + 32, degrade, true);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  95 */           return (byte)item.rotation;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 101 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(data)).render(r, x, y);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 106 */     RoomSprite.Imp imp2 = new RoomSprite.Imp()
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 111 */           DIR d = ((DIR)DIR.ORTHO.get(data)).perpendicular();
/* 112 */           int tx = it.tx() + d.x();
/* 113 */           int ty = it.ty() + d.y();
/* 114 */           if (crate.get(tx, ty) != null && !crate.away() && crate.animalHas()) {
/* 115 */             double mov = (GAME.intervals().get05() + it.ran() & 0xFF);
/* 116 */             mov /= 255.0D;
/* 117 */             SETT.ANIMALS().renderCaravan(r, s, mov, it.x() + 32, it.y() + 32, null, 0, false, data * 2, it.ran());
/*     */           } 
/*     */           
/* 120 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 125 */           return (byte)item.rotation;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 131 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(data)).render(r, x, y);
/*     */         }
/*     */       };
/*     */     
/* 135 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "OVERLAY_1X1")
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 138 */           OPACITY.O50.bind();
/* 139 */           super.render(r, s, data, it, degrade, false);
/* 140 */           OPACITY.unbind();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 146 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 151 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 157 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(data)).render(r, x, y);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 162 */     FurnisherItemTile ff = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo, AVAILABILITY.ROOM_SOLID, false);
/* 163 */     FurnisherItemTile ss = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, true);
/* 164 */     FurnisherItemTile cc = (new FurnisherItemTile(this, false, (RoomSprite)imp1, AVAILABILITY.ROOM_SOLID, false)).setData(1);
/* 165 */     FurnisherItemTile aa = (new FurnisherItemTile(this, false, (RoomSprite)imp2, AVAILABILITY.ROOM_SOLID, false)).setData(2);
/* 166 */     FurnisherItemTile oo = (new FurnisherItemTile(this, true, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM, false)).setData(3);
/* 167 */     FurnisherItemTile __ = new FurnisherItemTile(this, false, null, AVAILABILITY.ROOM, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 211 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 216 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 221 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 226 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 0) {
/* 227 */       super.putFloor(tx, ty, upgrade, area);
/*     */     } else {
/* 229 */       this.floor2.placeFixed(tx, ty);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 234 */     return (Room)new SupplyInstance(blue(), area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_SUPPLY blue() {
/* 239 */     return (SETT.ROOMS()).SUPPLY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */