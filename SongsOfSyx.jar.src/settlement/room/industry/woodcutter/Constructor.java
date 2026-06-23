/*     */ package settlement.room.industry.woodcutter;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
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
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   static final int B_WORK = 1;
/*     */   static final int B_STORAGE = 2;
/*     */   final FurnisherStat workers;
/*     */   final FurnisherStat output;
/*     */   final FurnisherStat irri;
/*     */   final RoomSpriteCombo sedge;
/*     */   final FurnisherStat efficiency;
/*     */   private final ROOM_WOODCUTTER blue;
/*     */   private final Addable overlay;
/*     */   
/*     */   protected Constructor(RoomInitData init, final ROOM_WOODCUTTER blue) throws IOException {
/*  60 */     super(init, 2, 4, 88, 44);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     this.overlay = new Addable(true, true) { public double get(AREA area, double fromItems) { double am = 0.0D; for (COORDINATE c : area.body()) { if (area.is(c)) am += Constructor.this.fertility(c.x(), c.y());  }  return Math.floor(am / 25.0D); } public GText format(GText t, double value) { return GFORMAT.i(t, (int)value); } }; this.efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers); this.irri = (FurnisherStat)new FurnisherStat.FurnisherStatIrrigation(this, blue); this.output = (FurnisherStat)new FurnisherStat.FurnisherStatProduction2(this, blue) { protected double getBase(AREA area, double[] fromItems) { return Constructor.this.workers.get(area, fromItems) * Constructor.this.efficiency.get(area, fromItems); } }
/*     */       ; this.sedge = new RoomSpriteCombo(sp, "EDGE_COMBO"); RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "STORAGE_1X1_TOP", true) { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof Instance) (((Instance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  } }
/*     */       ; RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "STORAGE_1X1_MID", false) { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof Instance) (((Instance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  } }; RoomSprite1xN roomSprite1xN3 = new RoomSprite1xN(sp, "STORAGE_1X1_END", false) { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof Instance) (((Instance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  } }; RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "SLAB_1X1") { public void renderAbove(SPRITE_RENDERER ren, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade) { Room r = (SETT.ROOMS()).map.get(it.tile()); if (r != null && r instanceof Instance) (((Instance)r).blueprintI()).job.storage.render(ren, shadowBatch, it.tx(), it.ty(), it.x(), it.y(), it.ran());  } }
/* 455 */       ; this.blue = blue; Json sp = init.data().json("SPRITES"); this.workers = new FurnisherStat(this, 1.0D) { public void renderBelow(Renderer r, RenderData.RenderIterator it) { renderUnder(Constructor.this.fertility(it.tx(), it.ty()), r, it, false);
/* 456 */           if (!(SETT.ROOMS()).placement.embryo.is(it.tile()) && SETT.TERRAIN().get(it.tile()).clearing().can()) {
/* 457 */             double w = (SETT.GROUND()).MOISTURE_TOT.get(it.tile()) * 2.0D;
/* 458 */             w = CLAMP.d(w, 0.0D, 1.0D);
/* 459 */             w *= w;
/* 460 */             if (w > 0.0D) {
/* 461 */               ColorImp.TMP.interpolate((GCOLOR.MAP()).OVERLAY_BAD, (GCOLOR.MAP()).OVERLAY_GOOD, w).bind();
/* 462 */               int s = (int)(16.0D + w * 3.0D * 64.0D / 4.0D);
/* 463 */               int x1 = it.x() + (64 - s) / 2;
/* 464 */               int y1 = it.y() + (64 - s) / 2;
/*     */               
/* 466 */               (UI.icons()).s.drop.render((SPRITE_RENDERER)r, x1, x1 + s, y1, y1 + s);
/*     */             } 
/*     */           }  } }; RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1((RoomSprite)roomSprite1x11) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { super.render(r, s, data, it, degrade, isCandle); if (!isCandle) {
/*     */             Icon icon = ((IndustryResource)((Industry)blue.indus.get(0)).outs().get(0)).resource.icon(); OPACITY.O99.bind(); icon.render(r, it.x() + 8, it.x() + 64 - 8, it.y() + 8, it.y() + 64 - 8); OPACITY.unbind();
/*     */           }  return false; } }
/*     */       ; RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "AUX_1X1") {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); }
/*     */       }; RoomSprite1xN roomSprite1xN4 = new RoomSprite1xN(sp, "AUX_MEDIUM_A_1X1", true) {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); }
/*     */       }; RoomSprite1xN roomSprite1xN5 = new RoomSprite1xN(sp, "AUX_MEDIUM_B_1X1", false) {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); }
/*     */       }; RoomSpriteXxX roomSpriteXxX = new RoomSpriteXxX(sp, "AUX_BIG_2X2", 2) {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = Constructor.this.aniSpeed(it.tile()); return super.render(r, s, data, it, degrade, isCandle); }
/*     */       }; RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "WORK_1X1") {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { this.animationSpeed = 0.0D; Room ro = (SETT.ROOMS()).map.get(it.tile()); if (r != null && ro instanceof Instance && Job.working((SETT.ROOMS()).data.get(it.tile())))
/*     */             this.animationSpeed = 1.0D;  return super.render(r, s, data, it, degrade, isCandle); }
/*     */       }; FurnisherItemTile ss = (new Aux(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile sA = (new Aux(this, true, (RoomSprite)roomSprite1xN1, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile sm = (new Aux(this, true, (RoomSprite)roomSprite1xN2, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile sc = (new Aux(this, true, (RoomSprite)roomSprite1xN3, AVAILABILITY.ROOM_SOLID, false)).setData(2);
/*     */     FurnisherItemTile cc = new Aux(this, false, (RoomSprite)roomSprite1x12, AVAILABILITY.ROOM_SOLID, true);
/*     */     FurnisherItemTile ms = new Aux(this, false, (RoomSprite)roomSprite1x13, AVAILABILITY.ROOM_SOLID, false);
/*     */     FurnisherItemTile mA = new Aux(this, false, (RoomSprite)roomSprite1xN4, AVAILABILITY.ROOM_SOLID, false);
/*     */     FurnisherItemTile mB = new Aux(this, false, (RoomSprite)roomSprite1xN5, AVAILABILITY.ROOM_SOLID, false);
/*     */     FurnisherItemTile ml = new Aux(this, false, (RoomSprite)roomSpriteXxX, AVAILABILITY.ROOM_SOLID, false);
/*     */     FurnisherItemTile ww = (new Aux(this, true, (RoomSprite)roomSprite1x14, AVAILABILITY.ROOM_SOLID, false)).setData(1);
/*     */     flush(1, 1, 3);
/*     */     flush(3);
/*     */   } private class Aux extends FurnisherItemTile {
/*     */     public Aux(Furnisher p, boolean mustBeReachable, RoomSprite sprite, AVAILABILITY availability, boolean canGoCandle) { super(p, mustBeReachable, sprite, availability, canGoCandle); } public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { return null; }
/* 493 */   } public CharSequence constructionProblem(AREA area) { return null; } public boolean usesArea() { return true; } public boolean mustBeIndoors() { return false; } public boolean mustBeOutdoors() { return true; } public Room create(TmpArea area, RoomInit init) { return (Room)new Instance(this.blue, area, init); } public Addable overlay() { return this.overlay; } public RoomBlueprintImp blue() { return (RoomBlueprintImp)this.blue; } public void putFloor(int tx, int ty, int upgrade, AREA area) { if ((SETT.ROOMS()).fData.item.get(tx, ty) == null) { int m = 0; for (DIR d : DIR.ORTHO) { if (area.is(tx, ty, d)) m |= d.mask();  }  (SETT.ROOMS()).fData.spriteData.set(tx, ty, m); }  (SETT.FLOOR()).clearer.clear(tx, ty); } public boolean removeFertility() { return false; }
/*     */   public boolean removeTerrain(int tx, int ty) { if ((SETT.FLOOR()).getter.get(tx, ty) != null) return true;  if ((SETT.ROOMS()).fData.item.get(tx, ty) != null) return true;  if ((SETT.TERRAIN()).TREES.isTree(tx, ty)) return false;  return super.removeTerrain(tx, ty); }
/*     */   public boolean canBeCopied() { return true; }
/*     */   private double aniSpeed(int tile) { Room r = (SETT.ROOMS()).map.get(tile); if (r != null && r instanceof Instance) { Instance ins = (Instance)r; return ins.workage / ins.employees().max(); }  return 0.0D; }
/*     */   private double fertility(int tx, int ty) { if ((SETT.GROUND()).types.FOREST.is(tx, ty)) return 1.0D;  return ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).vegitation * 0.25D; }
/* 498 */   public boolean growsGrass(int tx, int ty) { return ((SETT.ROOMS()).fData.item.get(tx, ty) == null); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */