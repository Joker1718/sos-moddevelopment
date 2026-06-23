/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.ROOMA;
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
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import settlement.tilemap.terrain.TerrainDiagonal;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ abstract class Constructor extends Furnisher {
/*  46 */   private static CharSequence ¤¤TooThin = "¤Area is too thin at places. Expand the area to at least 3x3."; private ROOM_PASTURE blue;
/*     */   
/*     */   static {
/*  49 */     D.ts(Constructor.class);
/*     */   }
/*     */ 
/*     */   
/*  53 */   final FurnisherStat workers = new FurnisherStat(this, 1.0D)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  57 */         return 0.015625D * Constructor.this.ferarea.get(area, fromItems);
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  62 */         return GFORMAT.f(t, value, 1);
/*     */       }
/*     */     };
/*     */   
/*     */   public static final int STORAGE1 = 100;
/*     */   public static final int STORAGE2 = 200;
/*     */   public static final int STORAGE3 = 300;
/*     */   final FurnisherStat ferarea;
/*     */   final FurnisherStat efficiency;
/*     */   final FurnisherStat irri;
/*     */   private final RoomSpriteCombo fence;
/*     */   private final RoomSpriteCombo fenceDia;
/*     */   private final ColorImp color;
/*     */   private final TerrainDiagonal.Diagonalizer dia;
/*     */   
/*     */   protected Constructor(final ROOM_PASTURE blue, RoomInitData init) throws IOException
/*     */   {
/*  79 */     super(init, 2, 4, 88, 44);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     this.color = new ColorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 376 */     this.dia = new TerrainDiagonal.Diagonalizer()
/*     */       {
/*     */         public void setDia(int tx, int ty, boolean dia)
/*     */         {
/* 380 */           (SETT.ROOMS()).fData.spriteData.set(tx, ty, dia ? 1 : 0);
/*     */         } public double get(AREA area, double fromItems) { double f = 0.0D; for (COORDINATE c : area.body()) { DIR d; if (!area.is(c))
/*     */               continue;  Iterator<DIR> iterator = DIR.ALL.iterator(); do { if (!iterator.hasNext()) { f += Constructor.this.fertility(c.x(), c.y()); break; }  d = iterator.next(); } while (area.is(c, d)); }
/*     */            return f; }
/*     */       }; this.blue = blue; this.irri = (FurnisherStat)new FurnisherStat.FurnisherStatIrrigation(this, blue); this.efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers); this.ferarea = new FurnisherStat(this, 1.0D) { public GText format(GText t, double value) { double am = 0.0D; for (IndustryResource o : ((Industry)blue.industries().get(0)).outs())
/* 385 */             am += o.rate;  return GFORMAT.f(t, 0.015625D * value * am, 1); } public boolean getDia(int tx, int ty) { return ((SETT.ROOMS()).fData.spriteData.get(tx, ty) == 1); } }; Json js = init.data().json("SPRITES"); this.fence = new RoomSpriteCombo(js, "FENCE_COMBO"); this.fenceDia = new RoomSpriteCombo(js, "FENCE_D_COMBO"); } protected void makeAux(Json js) throws IOException { RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(js, "AUX_EDGE_1X1", false) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { return false; } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { super.render(r, s, data, it, degrade, false); } }
/*     */       ; RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(js, "AUX_MID_1X1", true) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { return false; } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { super.render(r, s, data, it, degrade, false); } }
/*     */       ; RoomSpriteXxX auxBig = new RoomSpriteXxX(js, "AUX_BIG_2X2", 2) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { return false; } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { super.render(r, s, data, it, degrade, false); } }
/*     */       ; FurnisherItemTile m1 = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1xN1, AVAILABILITY.ROOM, false) { public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { for (int i = 0; i < DIR.ALL.size(); i++) { if (!roomIs.is(tx, ty, (DIR)DIR.ALL.get(i))) return Dic.empty;  }  return super.isPlacable(tx, ty, roomIs, it, rx, ry); } }
/*     */       ; FurnisherItemTile m2 = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1xN2, AVAILABILITY.ROOM, false) { public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { for (int i = 0; i < DIR.ALL.size(); i++) { if (!roomIs.is(tx, ty, (DIR)DIR.ALL.get(i))) return Dic.empty;  }  return super.isPlacable(tx, ty, roomIs, it, rx, ry); } }
/*     */       ; FurnisherItemTile ml = new FurnisherItemTile(this, false, (RoomSprite)auxBig, AVAILABILITY.ROOM, false) { public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { for (int i = 0; i < DIR.ALL.size(); i++) { if (!roomIs.is(tx, ty, (DIR)DIR.ALL.get(i))) return Dic.empty;  }  return super.isPlacable(tx, ty, roomIs, it, rx, ry); } }
/* 391 */       ; flush(3); } public boolean usesArea() { return true; } public ROOM_PASTURE blue() { return this.blue; } private double fertility(int tx, int ty) { if (mustBeIndoors()) { if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty)) return 1.5D;  return 1.0D; }  double f = ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).farm - 0.1D; f *= f; return 0.4D + 0.6D * f; } public void renderEmbryo(SPRITE_RENDERER r, int mask, RenderData.RenderIterator it, boolean isFloored, AREA area, boolean active) { double f = ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).farm; COLOR col = CORE.renderer().colorGet(); if (active) { this.color.interpolate((GCOLOR.MAP()).SOSO, (GCOLOR.MAP()).BETTER, 0.75D + 0.25D * f); this.color.bind(); }  Room room = (SETT.ROOMS()).map.get(it.tile()); if (isFloored) { COLOR.unbind(); renderFence(r, ShadowBatch.DUMMY, it, 0.0D); return; }  if (mask != 15) { (SPRITES.cons()).BIG.filled.render(r, mask, it.x(), it.y()); return; }  for (DIR d : DIR.NORTHO) { if (!room.isSame(it.tx(), it.ty(), it.tx() + d.x(), it.ty() + d.y())) { (SPRITES.cons()).BIG.filled.render(r, 15, it.x(), it.y()); return; }  }  col.bind(); super.renderEmbryo(r, mask, it, isFloored, area, active); } public Room create(TmpArea area, RoomInit init) { return (Room)new PastureInstance(this.blue, area, init); } public TerrainDiagonal.Diagonalizer dia(int tx, int ty) { if (this.blue.is(tx, ty) && fenceJoin((ROOMA)this.blue.get(tx, ty), tx, ty))
/* 392 */       return this.dia; 
/* 393 */     return null; } public CharSequence constructionProblem(AREA area) { for (COORDINATE c : area.body()) { if (area.is(c)) { boolean ok = false; for (DIR d : DIR.ALL) { if (isFull(c, area, d)) { ok = true; break; }  }  if (!ok) { GUTIL.filler().done(); return ¤¤TooThin; }  }  }  return null; } private boolean isFull(COORDINATE c, AREA a, DIR d) { int tx = c.x() + d.x(); int ty = c.y() + d.y(); if (!a.is(tx, ty)) return false;  for (int i = 0; i < DIR.ALL.size(); i++) { DIR dd = (DIR)DIR.ALL.get(i); if (!a.is(tx, ty, dd)) return false;  }  return true; }
/*     */   public void renderTileBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, boolean floored) { if (floored) renderFence(r, s, it, 0.0D);  }
/*     */   public boolean fenceJoin(ROOMA ii, int tx, int ty) { if (!ii.is(tx, ty)) return false;  if (!fenceJoin((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty))) return false;  for (int di = 0; di < DIR.ALL.size(); di++) { DIR d = (DIR)DIR.ALL.get(di); if (!ii.is(tx, ty, d) && !((Terrain.TerrainTile)SETT.TERRAIN().get(tx, ty, d)).isMassiveWall()) return true;  }  return false; }
/*     */   public boolean isFence(ROOMA ii, int tx, int ty) { if (!ii.is(tx, ty)) return false;  if ((SETT.ROOMS()).fData.tile.get(tx, ty) != null) return false;  for (int di = 0; di < DIR.ORTHO.size(); di++) { if (!ii.is(tx, ty, (DIR)DIR.ORTHO.get(di))) return true;  }  return false; }
/*     */   public void renderFence(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, double degrade) { ROOMA ii = (ROOMA)(SETT.ROOMS()).map.rooma.get(it.tx(), it.ty()); if (ii == null) return;  if (!fenceJoin(ii, it.tx(), it.ty())) return;  int m = 0; for (DIR d : DIR.ORTHO) { if (fenceJoin(ii, it.tx() + d.x(), it.ty() + d.y()) || SETT.TERRAIN().get(it.tx() + d.x(), it.ty() + d.y()).isMassiveWall()) m |= d.mask();  }  if (m != 15) if ((SETT.ROOMS()).fData.spriteData.get(it.tile()) == 1) { this.fenceDia.render(r, s, m, it, degrade, false); } else { this.fence.render(r, s, m, it, degrade, false); }   }
/* 398 */   public boolean growsGrass(int tx, int ty) { return ((SETT.ROOMS()).fData.item.get(tx, ty) == null); }
/*     */ 
/*     */   
/*     */   protected abstract boolean fenceJoin(FurnisherItemTile paramFurnisherItemTile);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */