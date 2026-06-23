/*     */ package settlement.room.infra.monument;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Imp
/*     */   extends ROOM_MONUMENT
/*     */ {
/*     */   private final Furnisher constructor;
/*     */   
/*     */   public Imp(RoomInitData init, int tindex, String key, RoomCategorySub cat) throws IOException {
/*  30 */     super(init, tindex, key, cat);
/*     */     
/*  32 */     this.constructor = new Constructor(this, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  37 */     return this.constructor;
/*     */   }
/*     */   
/*     */   private static class Constructor
/*     */     extends MConstructor
/*     */   {
/*     */     Constructor(Imp blue, RoomInitData init) throws IOException {
/*  44 */       super(blue, init); byte b; int i;
/*     */       Json[] arrayOfJson;
/*  46 */       for (i = (arrayOfJson = init.data().jsons("SPRITES")).length, b = 0; b < i; ) { Json sData = arrayOfJson[b];
/*     */         
/*  48 */         final RoomSpriteCombo floor = new RoomSpriteCombo(sData, "FLOOR_COMBO")
/*     */           {
/*     */             protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  51 */               return (item.get(rx, ry) != null);
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*  57 */         if (sData.has("1x1")) {
/*  58 */           RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sData, "1x1")
/*     */             {
/*     */               public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  61 */                 return floor.getData(tx, ty, rx, ry, item, itemRan);
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  67 */                 floor.render(r, s, getData2(it), it, degrade, false);
/*  68 */                 return false;
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  74 */                 animate(1.0D - (SETT.ROOMS()).map.get(it.tile()).getDegrade(it.tx(), it.ty()));
/*  75 */                 super.render(r, s, data, it, degrade, false);
/*     */               }
/*     */             };
/*     */           
/*  79 */           FurnisherItemTile ss = new FurnisherItemTile(
/*  80 */               this, 
/*  81 */               false, 
/*  82 */               (RoomSprite)roomSprite1x1, 
/*  83 */               blue.avail, 
/*  84 */               false);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  91 */         if (sData.has("2x2")) {
/*     */           
/*  93 */           RoomSpriteXxX roomSpriteXxX = new RoomSpriteXxX(sData, "2x2", 2)
/*     */             {
/*     */               public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  96 */                 return floor.getData(tx, ty, rx, ry, item, itemRan);
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 102 */                 floor.render(r, s, getData2(it), it, degrade, false);
/* 103 */                 return false;
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 109 */                 animate(1.0D - (SETT.ROOMS()).map.get(it.tile()).getDegrade(it.tx(), it.ty()));
/* 110 */                 super.render(r, s, data, it, degrade, false);
/*     */               }
/*     */             };
/* 113 */           FurnisherItemTile tt = new FurnisherItemTile(
/* 114 */               this, 
/* 115 */               false, 
/* 116 */               (RoomSprite)roomSpriteXxX, 
/* 117 */               blue.avail, 
/* 118 */               false);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 126 */         if (sData.has("3x3")) {
/*     */           
/* 128 */           RoomSpriteXxX roomSpriteXxX = new RoomSpriteXxX(sData, "3x3", 3)
/*     */             {
/*     */               public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 131 */                 return floor.getData(tx, ty, rx, ry, item, itemRan);
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 137 */                 floor.render(r, s, getData2(it), it, degrade, false);
/* 138 */                 return false;
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 144 */                 animate(1.0D - (SETT.ROOMS()).map.get(it.tile()).getDegrade(it.tx(), it.ty()));
/* 145 */                 super.render(r, s, data, it, degrade, false);
/*     */               }
/*     */             };
/* 148 */           FurnisherItemTile tt = new FurnisherItemTile(
/* 149 */               this, 
/* 150 */               false, 
/* 151 */               (RoomSprite)roomSpriteXxX, 
/* 152 */               blue.avail, 
/* 153 */               false);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 162 */         flush(3);
/*     */         b++; }
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean removeTerrain(int tx, int ty) {
/* 169 */       if (SETT.TERRAIN().get(tx, ty) instanceof settlement.tilemap.terrain.TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player >= 0.0D)
/* 170 */         return false; 
/* 171 */       return super.removeTerrain(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/* 176 */       if (SETT.TERRAIN().get(tx, ty) instanceof settlement.tilemap.terrain.TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 177 */         return PlacableMessages.¤¤STRUCTURE_BLOCK; 
/* 178 */       return super.placable(tx, ty, item, tile);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 184 */       super.putFloor(tx, ty, upgrade, area);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */