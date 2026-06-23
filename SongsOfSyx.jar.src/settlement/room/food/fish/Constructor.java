/*     */ package settlement.room.food.fish;
/*     */ 
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
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
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ final class Constructor extends Furnisher {
/*     */   static final int B_WORK = 1;
/*     */   static final int B_STORAGE = 2;
/*  47 */   static CharSequence ¤¤problem = "¤Must not be placed on water";
/*  48 */   static CharSequence ¤¤problem2 = "¤Shape must contain more water tiles in order to function";
/*  49 */   private static CharSequence ¤¤deep = "Deep Sea.";
/*  50 */   private static CharSequence ¤¤deepD = "Deep sea access. Increased worker capacity.";
/*     */ 
/*     */   
/*     */   static {
/*  54 */     D.ts(Constructor.class);
/*     */   }
/*     */   
/*  57 */   final FurnisherStat workers = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  61 */         double shallow = 0.0D;
/*  62 */         double deep = 0.0D;
/*  63 */         for (COORDINATE c : area.body()) {
/*  64 */           if (area.is(c) && (SETT.TERRAIN()).WATER.SHALLOW.is(c)) {
/*  65 */             deep += (SETT.TERRAIN()).WATER.fishAmount.get(c);
/*  66 */             if ((SETT.TERRAIN()).WATER.SHALLOW.is(c)) {
/*  67 */               shallow++;
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  74 */         deep /= (SETT.TERRAIN()).WATER.fishAmount.max();
/*     */         
/*  76 */         return deep + shallow / 64.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  81 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*  84 */   final FurnisherStat storage = new FurnisherStat(this)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  88 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  93 */         return GFORMAT.i(t, (int)(value * Constructor.this.blue.job.storage.max()));
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   final FurnisherStat production;
/*     */   
/* 100 */   final FurnisherStat efficiency = (FurnisherStat)new FurnisherStat.FurnisherStatEfficiency(this, this.workers)
/*     */     {
/*     */       public double get(AREA area, double[] fromItems)
/*     */       {
/* 104 */         double w = Constructor.this.workers.get(area, fromItems);
/*     */ 
/*     */ 
/*     */         
/* 108 */         if (w <= 0.0D)
/* 109 */           w = 1.0D; 
/* 110 */         double i = fromItems[this.index];
/*     */ 
/*     */         
/* 113 */         return CLAMP.d(0.5D + this.mul * 0.5D * i / w, 0.0D, 1.0D);
/*     */       }
/*     */     };
/*     */   
/* 117 */   final FurnisherStat deepBoost = new FurnisherStat(this, ¤¤deep, ¤¤deepD, 0.0D)
/*     */     {
/*     */       public GText format(GText t, double value)
/*     */       {
/* 121 */         return GFORMAT.f0(t, value, 1.0D);
/*     */       }
/*     */ 
/*     */       
/*     */       public double get(AREA area, double acc) {
/* 126 */         double deep = 0.0D;
/* 127 */         for (COORDINATE c : area.body()) {
/* 128 */           if (area.is(c))
/* 129 */             deep += (SETT.TERRAIN()).WATER.fishAmount.get(c); 
/*     */         } 
/* 131 */         return deep / (SETT.TERRAIN()).WATER.fishAmount.max();
/*     */       }
/*     */     };
/*     */   
/*     */   private final ROOM_FISHERY blue;
/*     */   final RoomSpriteCombo sEdge;
/*     */   final RoomSprite1x1 sMisc;
/*     */   public final Addable FISH;
/*     */   
/*     */   protected Constructor(RoomInitData init, final ROOM_FISHERY blue) throws IOException {
/* 141 */     super(init, 2, 5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 382 */     this.FISH = new Addable(null, null, null, null, false, true) { protected double getBase(AREA area, double[] acc) { return Constructor.this.efficiency.get(area, acc) * (int)Constructor.this.workers.get(area, acc); } }
/*     */       ; Json sp = init.data().json("SPRITES"); RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "STORAGE_BOTTOM_1X1", sp) { final RoomSpriteImp sStorageTop; public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { super.render(r, s, data, it, degrade, isCandle); Room ro = (SETT.ROOMS()).map.get(it.tile()); if (ro != null && ro instanceof FishInstance) (((FishInstance)ro).blueprintI()).job.storage.render(r, s, it.tx(), it.ty(), it.x(), it.y(), it.ran());  return false; } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { this.sStorageTop.render(r, s, getData2(it), it, degrade, this.rotates); } public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { return this.sStorageTop.getData(tx, ty, rx, ry, item, itemRan); } }
/*     */       ; final RoomSprite1x1 miscTop = new RoomSprite1x1(sp, "MISC_TOP_1X1"); RoomSprite1x1 sCandle = new RoomSprite1x1(sp, "CANDLE_1X1") { public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { if (!(SETT.ROOMS()).fData.candle.is(it.tile())) miscTop.render(r, s, getData2(it), it, degrade, false);  } }
/*     */       ; this.blue = blue; this.production = (FurnisherStat)new FurnisherStat.FurnisherStatProduction2(this, blue) { public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { return miscTop.getData(tx, ty, rx, ry, item, itemRan); } }
/*     */       ; RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "AUX_EDGE_1X1", false); RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "AUX_MID_1X1", true); RoomSpriteXxX auxBig = new RoomSpriteXxX(sp, "AUX_BIG_2X2", 2); RoomSprite1x1 work = new RoomSprite1x1(sp, "WORKTABLE_1X1") {
/* 387 */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { if (blue.is(it.tile()) && Job.working((SETT.ROOMS()).data.get(it.tile()))) { int dx = 0; int dy = 0; if (this.rotates) { dx += rot(data).x() * 8; dy += rot(data).y() * 8; }  ((IndustryResource)blue.productionData.outs().get(0)).resource.renderLaying(r, it.x() + dx, it.y() + dy, it.ran(), 1.0D); }  } protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) { return (item.get(rx, ry) != null && item.get(rx - d.x() * 2, ry + d.y() * 2) == null); } public boolean render(Renderer r, RenderData.RenderIterator it) { if ((SETT.TERRAIN()).WATER.SHALLOW.is(it.tile()) && !(SETT.ROOMS()).map.is(it.tile()) && !(SETT.ROOMS()).placement.embryo.is(it.tile())) {
/*     */             
/* 389 */             double d = (SETT.TERRAIN()).WATER.fishAmount.get(it.tile()) / (SETT.TERRAIN()).WATER.fishAmount.max();
/* 390 */             if (d == 0.0D)
/* 391 */               return false; 
/* 392 */             ColorImp.TMP.interpolate((GCOLOR.MAP()).OVERLAY_BAD, (GCOLOR.MAP()).OVERLAY_GOOD, d);
/* 393 */             ColorImp.TMP.bind();
/* 394 */             (UI.icons()).s.fish.renderScaled((SPRITE_RENDERER)r, it.x(), it.y(), 4);
/*     */             
/* 396 */             if ((S.get()).developer && (SETT.TERRAIN()).WATER.deepSeaFishSpot.is(it.tile())) {
/* 397 */               (UI.icons()).s.cancel.render((SPRITE_RENDERER)r, it.x(), it.y());
/*     */             }
/*     */           } 
/*     */           
/* 401 */           return false; }
/*     */       }; RoomSprite1x1 misc = new RoomSprite1x1(sp, "MISC_1X1") { public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { if (blue.is(it.tile()) && Job.working((SETT.ROOMS()).data.get(it.tile())))
/*     */             ((IndustryResource)blue.productionData.outs().get(0)).resource.renderLaying(r, it.x(), it.y(), it.ran(), 1.0D);  } protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) { return (item.get(rx, ry) != null && item.get(rx - d.x() * 2, ry + d.y() * 2) == null); } }; this.sEdge = new RoomSpriteCombo(sp, "EDGE_COMBO"); this.sMisc = new RoomSprite1x1(sp, "MISC_GROUND_1X1"); FurnisherItemTile ss = (new Aux(this, true, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false)).setData(2); FurnisherItemTile cc = new Aux(this, false, (RoomSprite)sCandle, AVAILABILITY.ROOM_SOLID, true); FurnisherItemTile ms = new Aux(this, false, (RoomSprite)misc, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile m1 = new Aux(this, false, (RoomSprite)roomSprite1xN1, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile m2 = new Aux(this, false, (RoomSprite)roomSprite1xN2, AVAILABILITY.ROOM_SOLID, false); FurnisherItemTile ml = new Aux(this, false, (RoomSprite)auxBig, AVAILABILITY.ROOM_SOLID, false);
/*     */     FurnisherItemTile ww = (new Aux(this, true, (RoomSprite)work, AVAILABILITY.ROOM_SOLID, false)).setData(1);
/*     */     flush(1, 1, 3);
/*     */     flush(3);
/* 407 */   } public Addable overlay() { return this.FISH; } private class Aux extends FurnisherItemTile {
/*     */     public Aux(Furnisher p, boolean mustBeReachable, RoomSprite sprite, AVAILABILITY availability, boolean canGoCandle) { super(p, mustBeReachable, sprite, availability, canGoCandle); }
/*     */     public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) { if ((SETT.TERRAIN()).WATER.SHALLOW.is(tx, ty))
/*     */         return Constructor.¤¤problem; 
/*     */       return null; } }
/* 412 */   public boolean usesArea() { return true; }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 417 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 422 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 427 */     return (Room)new FishInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 432 */     return (RoomBlueprintImp)this.blue;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 456 */     if ((SETT.ROOMS()).fData.item.get(tx, ty) == null) {
/* 457 */       int m = 0;
/* 458 */       for (DIR d : DIR.ORTHO) {
/* 459 */         if (area.is(tx, ty, d) || (SETT.TERRAIN()).WATER.DEEP.is(tx, ty, d) || (SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty, d)) {
/* 460 */           m |= d.mask();
/*     */         }
/*     */       } 
/* 463 */       (SETT.ROOMS()).fData.spriteData.set(tx, ty, m);
/*     */     } 
/* 465 */     (SETT.FLOOR()).clearer.clear(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/* 470 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence constructionProblem(AREA area) {
/* 475 */     if (this.workers.get(area, 0.0D) < 1.0D)
/* 476 */       return ¤¤problem2; 
/* 477 */     return super.constructionProblem(area);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/* 482 */     if ((SETT.TERRAIN()).WATER.DEEP.is(tx, ty))
/* 483 */       return PlacableMessages.¤¤TERRAIN_BLOCK; 
/* 484 */     return super.placable(tx, ty, item, tile);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeTerrain(int tx, int ty) {
/* 489 */     return (!(SETT.TERRAIN()).WATER.SHALLOW.is(tx, ty) && !(SETT.TERRAIN()).NADA.is(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeCopied() {
/* 494 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */