/*     */ package settlement.room.spirit.grave;
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
/*     */ import settlement.room.main.furnisher.FurnisherItemTools;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class CGraveyard
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_GRAVEYARD blue;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat services;
/*     */   final FurnisherStat respekk;
/*     */   private final Floors.Floor pathway;
/*     */   private static final int PI = 3;
/*     */   
/*     */   protected CGraveyard(final ROOM_GRAVEYARD blue, RoomInitData init) throws IOException {
/*  46 */     super(init, 4, 3, 88, 44);
/*  47 */     this.blue = blue;
/*     */ 
/*     */ 
/*     */     
/*  51 */     this.workers = (FurnisherStat)new FurnisherStat.FurnisherStatEmployees(this, 0.0D);
/*  52 */     this.services = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  53 */     this.respekk = (FurnisherStat)new FurnisherStat.FurnisherStatRelative(this, this.services);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  60 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "GRAVE_A_TOP_1X1", true, sp)
/*     */       {
/*     */         final RoomSprite made;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  67 */           if (blue.is(it.tile()) && 
/*  68 */             Grave.isUsed(it.tx() + rot(data).x(), it.ty() + rot(data).y())) {
/*  69 */             return this.made.render(r, s, data, it, degrade, isCandle);
/*     */           }
/*     */           
/*  72 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  77 */     RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "GRAVE_A_BOTTOM_1X1", false, sp)
/*     */       {
/*     */         final RoomSprite made;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  84 */           if (blue.is(it.tile()) && 
/*  85 */             Grave.isUsed(it.tx(), it.ty())) {
/*  86 */             return this.made.render(r, s, data, it, degrade, isCandle);
/*     */           }
/*     */           
/*  89 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  94 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "TOMBSTONE_1X1", sp)
/*     */       {
/*     */         final RoomSprite made;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 101 */           super.render(r, s, data, it, degrade, isCandle);
/* 102 */           OPACITY.O85.bind();
/* 103 */           this.made.render(r, s, data, it, degrade, isCandle);
/* 104 */           OPACITY.unbind();
/* 105 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 110 */           return item.sprite(rx, ry) instanceof RoomSprite1xN;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 115 */     FurnisherItemTile h1 = (new FurnisherItemTile(
/* 116 */         this, 
/* 117 */         false, 
/* 118 */         (RoomSprite)roomSprite1xN1, 
/* 119 */         AVAILABILITY.AVOID_PASS, 
/* 120 */         false)).setData(2);
/* 121 */     FurnisherItemTile t1 = (new FurnisherItemTile(
/* 122 */         this, 
/* 123 */         true, 
/* 124 */         (RoomSprite)roomSprite1xN2, 
/* 125 */         AVAILABILITY.AVOID_PASS, 
/* 126 */         false)).setData(1);
/* 127 */     FurnisherItemTile st = new FurnisherItemTile(
/* 128 */         this, 
/* 129 */         false, 
/* 130 */         (RoomSprite)roomSprite1x11, 
/* 131 */         AVAILABILITY.SOLID, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     flush(1, 3);
/*     */ 
/*     */     
/* 178 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "MON_1X1");
/* 179 */     FurnisherItemTile it = new FurnisherItemTile(
/* 180 */         this, 
/* 181 */         false, 
/* 182 */         (RoomSprite)roomSprite1x12, 
/* 183 */         AVAILABILITY.SOLID, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     RoomSpriteXxX roomSpriteXxX2 = new RoomSpriteXxX(sp, "MON_2X2", 2);
/* 191 */     it = new FurnisherItemTile(
/* 192 */         this, 
/* 193 */         false, 
/* 194 */         (RoomSprite)roomSpriteXxX2, 
/* 195 */         AVAILABILITY.SOLID, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     RoomSpriteXxX roomSpriteXxX1 = new RoomSpriteXxX(sp, "MON_3X3", 3);
/* 204 */     it = new FurnisherItemTile(
/* 205 */         this, 
/* 206 */         false, 
/* 207 */         (RoomSprite)roomSpriteXxX1, 
/* 208 */         AVAILABILITY.SOLID, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     flush(1, 3);
/*     */ 
/*     */     
/* 219 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo(sp, "FLOWER_COMBO");
/* 220 */     it = new FurnisherItemTile(
/* 221 */         this, 
/* 222 */         false, 
/* 223 */         (RoomSprite)roomSpriteCombo2, 
/* 224 */         AVAILABILITY.AVOID_LIKE_FUCK, false);
/* 225 */     FurnisherItemTools.makeArea(this, it);
/*     */ 
/*     */     
/* 228 */     this.pathway = (Floors.Floor)(SETT.FLOOR()).map.read("PATHWAY", init.data());
/*     */ 
/*     */     
/* 231 */     RoomSpriteCombo roomSpriteCombo1 = new RoomSpriteCombo();
/* 232 */     it = new FurnisherItemTile(
/* 233 */         this, 
/* 234 */         false, 
/* 235 */         (RoomSprite)roomSpriteCombo1, 
/* 236 */         AVAILABILITY.ROOM, false);
/* 237 */     it.setData(3);
/* 238 */     FurnisherItemTools.makeArea(this, it);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/* 245 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 250 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 255 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 260 */     return true;
/*     */   }
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 264 */     return (Room)new GraveInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 269 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 274 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3) {
/* 275 */       this.pathway.placeFixed(tx, ty);
/*     */     } else {
/* 277 */       double f = CLAMP.d((((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).vegitation - 0.2D) * 4.0D, 0.0D, 0.5D);
/* 278 */       (SETT.GRASS()).current.set(tx, ty, f);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\CGraveyard.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */