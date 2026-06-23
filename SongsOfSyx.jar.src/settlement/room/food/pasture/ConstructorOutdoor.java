/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import settlement.room.main.placement.UtilWallPlacability;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import settlement.tilemap.terrain.TerrainDiagonal;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ final class ConstructorOutdoor
/*     */   extends Constructor
/*     */ {
/*  36 */   private static CharSequence ¤¤Problem = "Must be facing the edge of the room.";
/*  37 */   private static CharSequence ¤¤Problem2 = "Must not be placed in a corner.";
/*  38 */   private static CharSequence ¤¤Problem3 = "Will be blocked by walls"; private ROOM_PASTURE blue; private final FurnisherItemTile gc; final FurnisherItemTile s1; final FurnisherItemTile s2; final FurnisherItemTile s3; private final Addable overlay; private final TerrainDiagonal.Diagonalizer dia;
/*     */   static {
/*  40 */     D.ts(ConstructorOutdoor.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ConstructorOutdoor(ROOM_PASTURE blue, RoomInitData init) throws IOException {
/*  53 */     super(blue, init);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.overlay = new Addable(true, true)
/*     */       {
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 177 */           double d = fertility(it.tx(), it.ty());
/* 178 */           d *= d;
/* 179 */           renderUnder(d, r, it, false);
/* 180 */           if (!(SETT.ROOMS()).placement.embryo.is(it.tile()) && SETT.TERRAIN().get(it.tile()).clearing().can()) {
/* 181 */             double w = (SETT.GROUND()).MOISTURE_TOT.get(it.tile()) * 2.0D;
/* 182 */             w = CLAMP.d(w, 0.0D, 1.0D);
/* 183 */             if (w > 0.0D) {
/* 184 */               ColorImp.TMP.interpolate((GCOLOR.MAP()).OVERLAY_BAD, (GCOLOR.MAP()).OVERLAY_GOOD, w).bind();
/* 185 */               int s = (int)(16.0D + w * 3.0D * 64.0D / 4.0D);
/* 186 */               int x1 = it.x() + (64 - s) / 2;
/* 187 */               int y1 = it.y() + (64 - s) / 2;
/*     */               
/* 189 */               (UI.icons()).s.drop.render((SPRITE_RENDERER)r, x1, x1 + s, y1, y1 + s);
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         private double fertility(int tx, int ty) {
/* 195 */           if (ConstructorOutdoor.this.mustBeIndoors()) {
/* 196 */             if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty))
/* 197 */               return 1.0D; 
/* 198 */             return 0.5D;
/*     */           } 
/* 200 */           double f = ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).farm - 0.1D;
/* 201 */           f *= f;
/* 202 */           return 0.4D + 0.6D * f;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     this.dia = new TerrainDiagonal.Diagonalizer()
/*     */       {
/*     */         public void setDia(int tx, int ty, boolean dia)
/*     */         {
/* 246 */           (SETT.ROOMS()).fData.spriteData.set(tx, ty, dia ? 1 : 0);
/*     */         } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { super.render(r, s, data, it, degrade, false); } public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { return false; } public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { return sbelow.getData(tx, ty, rx, ry, item, itemRan); } protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) { return item.sprite(rx, ry) instanceof RoomSpriteXxX; }
/*     */       }; this.blue = blue; Json js = init.data().json("SPRITES"); final RoomSprite1x1 sbelow = new RoomSprite1x1(js, "STORAGE_1X1"); RoomSpriteXxX roomSpriteXxX = new RoomSpriteXxX(js, "GATE_TOP_3X3", 3) { public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { if ((SETT.ROOMS()).placement.embryo.is(tx, ty) && (SETT.ROOMS()).placement.placer.autoWalls.is()) for (DIR d : DIR.ORTHO) { if (it.get(rx, ry, d) == null && UtilWallPlacability.wallCanBe.is(tx, ty, d) && (SETT.ROOMS()).placement.placer.placerDoor.isPlacable(tx + d.x(), ty + d.y(), null, null) == null) return ConstructorOutdoor.¤¤Problem3;  }   for (DIR d : DIR.ORTHO) { if (!roomIs.is(tx, ty, d)) return null;  }  return ConstructorOutdoor.¤¤Problem; }
/*     */       }).setData(5); FurnisherItemTile du = new FurnisherItemTile(this, (RoomSprite)roomSpriteXxX, AVAILABILITY.ROOM, false) { public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { for (DIR d : DIR.ORTHO) { if (it.get(rx, ry, d) != null) continue;  if (!p(tx + d.x(), ty + d.y(), roomIs)) return ConstructorOutdoor.¤¤Problem2;  }  return super.isPlacable(tx, ty, roomIs, it, rx, ry); } }
/*     */       ; FurnisherItemTile gl = (new FurnisherItemTile(this, (RoomSprite)roomSpriteXxX, AVAILABILITY.ROOM_SOLID, false)).setData(5); this.gc = (new FurnisherItemTile(this, (RoomSprite)roomSpriteXxX, AVAILABILITY.ROOM, false) {
/* 251 */         public boolean getDia(int tx, int ty) { return ((SETT.ROOMS()).fData.spriteData.get(tx, ty) == 1); } private boolean p(int tx, int ty, MAP_BOOLEAN roomIs) { for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*     */             if (!roomIs.is(tx, ty, (DIR)DIR.ORTHO.get(i)))
/*     */               return false; 
/*     */           }  return true; } }
/*     */       ; this.s1 = (new FurnisherItemTile(this, (RoomSprite)new SpriteDep(js, (RoomSprite)roomSprite1x1, blue.s1), AVAILABILITY.ROOM_SOLID, false)).setData(1); this.s1.setData(100); this.s2 = (new FurnisherItemTile(this, (RoomSprite)new SpriteDep(js, (RoomSprite)roomSprite1x1, blue.s2), AVAILABILITY.ROOM_SOLID, false)).setData(1); this.s2.setData(200); this.s3 = (new FurnisherItemTile(this, (RoomSprite)new SpriteDep(js, (RoomSprite)roomSprite1x1, blue.s3), AVAILABILITY.ROOM_SOLID, false)).setData(1); this.s3.setData(300); flush(1, 1, 3);
/*     */     makeAux(js);
/* 257 */   } public boolean mustBeIndoors() { return false; } public TerrainDiagonal.Diagonalizer dia(int tx, int ty) { if (this.blue.is(tx, ty) && fenceJoin((ROOMA)this.blue.get(tx, ty), tx, ty))
/* 258 */       return this.dia; 
/* 259 */     return null; } public boolean mustBeOutdoors() { return true; } public Addable overlay() { return this.overlay; }
/*     */   public boolean needsIsolation() { return false; }
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) { FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty); if (t != null) { super.putFloor(tx, ty, upgrade, area); } else { (SETT.FLOOR()).clearer.clear(tx, ty); }  }
/*     */   public boolean removeFertility() { return false; }
/*     */   protected boolean fenceJoin(FurnisherItemTile gc) { return (gc != this.gc); }
/* 264 */   public boolean growsGrass(int tx, int ty) { return ((SETT.ROOMS()).fData.item.get(tx, ty) == null); }
/*     */ 
/*     */   
/*     */   private static class SpriteDep
/*     */     extends RoomSpriteXxX {
/*     */     private final RoomSprite below;
/*     */     private final RoomResStorage st;
/*     */     
/*     */     public SpriteDep(Json json, RoomSprite below, RoomResStorage st) throws IOException {
/* 273 */       super(json, "GATE_TOP_3X3", 3);
/* 274 */       this.below = below;
/* 275 */       this.st = st;
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 280 */       super.render(r, s, data, it, degrade, false);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 285 */       boolean ret = this.below.render(r, s, getData2(it), it, degrade, isCandle);
/* 286 */       this.st.render(r, s, it.tx(), it.ty(), it.x(), it.y(), it.ran());
/*     */       
/* 288 */       return ret;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 294 */       return this.below.getData(tx, ty, rx, ry, item, itemRan);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 299 */       return item.sprite(rx, ry) instanceof RoomSpriteXxX;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ConstructorOutdoor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */