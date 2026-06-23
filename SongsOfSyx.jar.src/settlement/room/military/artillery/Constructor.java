/*     */ package settlement.room.military.artillery;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.SheetPair;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ abstract class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_ARTILLERY blue;
/*     */   static final int SERVICE = 1;
/*     */   
/*     */   protected Constructor(RoomInitData init, final ROOM_ARTILLERY blue) throws IOException {
/*  32 */     super(init, 1, 0);
/*  33 */     this.blue = blue;
/*  34 */     Json js = init.data().json("SPRITES");
/*     */     
/*  36 */     final RoomSpriteXxX sArm = new RoomSpriteXxX(js, "ARM_2X2", 2, js)
/*     */       {
/*     */         RoomSprite srot;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  43 */           int rot = 0;
/*  44 */           ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/*  45 */           if (ins != null) {
/*  46 */             rot = ins.dirCurrent().id();
/*     */           }
/*     */           
/*  49 */           data = setRot(data, rot / 2);
/*     */           
/*  51 */           if ((rot & 0x1) == 1) {
/*  52 */             return this.srot.render(r, s, data, it, degrade, isCandle);
/*     */           }
/*  54 */           return super.render(r, s, data, it, degrade, isCandle);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int frame(SheetPair a, RenderData.RenderIterator it) {
/*  60 */           ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/*  61 */           if (ins != null && 
/*  62 */             ins.isLoaded) {
/*  63 */             return 0;
/*     */           }
/*     */           
/*  66 */           return 1;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  71 */     RoomSpriteXxX sBase = new RoomSpriteXxX(js, "BASE_2X2", 2, js)
/*     */       {
/*     */         RoomSprite srot;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  78 */           int rot = 0;
/*  79 */           ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/*  80 */           if (ins != null) {
/*  81 */             rot = ins.dirCurrent().id();
/*     */           }
/*     */           
/*  84 */           data = setRot(data, rot / 2);
/*     */           
/*  86 */           if ((rot & 0x1) == 1) {
/*  87 */             this.srot.render(r, s, data, it, degrade, isCandle);
/*     */           } else {
/*  89 */             super.render(r, s, data, it, degrade, isCandle);
/*     */           } 
/*  91 */           sArm.render(r, s, data, it, degrade, isCandle);
/*  92 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public int frame(SheetPair a, RenderData.RenderIterator it) {
/*  97 */           ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/*  98 */           if (ins != null) {
/*  99 */             return (int)(ins.progress() * 32.0D) & 0x1;
/*     */           }
/* 101 */           return 0;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 107 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(js, "STORAGE_1X1")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 111 */           super.render(r, s, data, it, degrade, isCandle);
/* 112 */           RESOURCES.STONE().renderLaying(r, it.x(), it.y(), it.ran(), 64.0D);
/* 113 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 117 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(js, "TORCH_1X1")
/*     */       {
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item)
/*     */         {
/* 122 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(rot(data).orthoID())).render(r, x, y);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 127 */     RoomSprite.Dummy dummy = new RoomSprite.Dummy();
/*     */ 
/*     */     
/* 130 */     FurnisherItemTile xx = new FurnisherItemTile(this, false, (RoomSprite)sBase, AVAILABILITY.SOLID, false);
/* 131 */     FurnisherItemTile ca = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.SOLID, true);
/* 132 */     FurnisherItemTile dp = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM, false);
/* 133 */     FurnisherItemTile __ = new FurnisherItemTile(this, false, (RoomSprite)dummy, AVAILABILITY.ROOM, false);
/* 134 */     FurnisherItemTile ee = new FurnisherItemTile(this, true, (RoomSprite)dummy, AVAILABILITY.ROOM, false);
/* 135 */     __.setData(1);
/* 136 */     ee.setData(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeTerrain(int tx, int ty) {
/* 168 */     if (SETT.TERRAIN().get(tx, ty) instanceof settlement.tilemap.terrain.TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player >= 0.0D)
/* 169 */       return false; 
/* 170 */     return super.removeTerrain(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/* 175 */     if (SETT.TERRAIN().get(tx, ty) instanceof settlement.tilemap.terrain.TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 176 */       return PlacableMessages.¤¤STRUCTURE_BLOCK; 
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_ARTILLERY blue() {
/* 182 */     return this.blue;
/*     */   }
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */