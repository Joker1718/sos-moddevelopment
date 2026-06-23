/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
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
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*  46 */   private static CharSequence ¤¤warning = "Fertility for this orchard is very low, which will result in low yields. This can be improved by irrigation. Proceed anyway?"; static final int TREE = 1; static final int STORAGE = 2; final boolean isIndoors; private final ROOM_ORCHARD blue;
/*     */   static {
/*  48 */     D.ts(Constructor.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   final FurnisherStat fertility = new FurnisherStat(this, 1.0E-4D)
/*     */     {
/*     */       public GText format(GText t, double value)
/*     */       {
/*  60 */         return GFORMAT.perc(t, value);
/*     */       }
/*     */ 
/*     */       
/*     */       public double get(AREA area, double fromItems) {
/*  65 */         if (Constructor.this.mustBeIndoors())
/*  66 */           return 1.0D; 
/*  67 */         double v = 0.0D;
/*  68 */         for (COORDINATE c : area.body()) {
/*     */           
/*  70 */           if (area.is(c)) {
/*  71 */             v += Constructor.this.fertility(c.x(), c.y());
/*     */           }
/*     */         } 
/*  74 */         return CLAMP.d(v / area.area(), 0.0D, 1.0D);
/*     */       }
/*     */     };
/*     */   
/*  78 */   final FurnisherStat workers = new FurnisherStat(this, 0.01D)
/*     */     {
/*     */       public GText format(GText t, double value)
/*     */       {
/*  82 */         return GFORMAT.f(t, value);
/*     */       }
/*     */ 
/*     */       
/*     */       public double get(AREA area, double fromItems) {
/*  87 */         return 4.0D * fromItems / ROOM_ORCHARD.TILES_PER_WORKER;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   final RoomSpriteCombo sEdge;
/*     */   
/*     */   final FurnisherStat irri;
/*     */   
/*     */   final FurnisherStat output;
/*     */   
/*  98 */   final RoomResStorage storage = new RoomResStorage(3000)
/*     */     {
/*     */       public RESOURCE resource() {
/* 101 */         if (this.ins instanceof Instance) {
/* 102 */           return ((IndustryResource)((Instance)this.ins).industry().outs().get(0)).resource;
/*     */         }
/* 104 */         return (RESOURCE)RESOURCES.ALL().get(0);
/*     */       }
/*     */ 
/*     */       
/*     */       protected boolean is(int tx, int ty) {
/* 109 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */       }
/*     */     };
/*     */   
/*     */   private final Addable overlay;
/*     */   
/* 115 */   protected Constructor(final ROOM_ORCHARD blue, RoomInitData init) throws IOException { super(init, 2, 4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 422 */     this.overlay = new Addable(true, false)
/*     */       {
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 425 */           double d = Constructor.this.fertility(it.tx(), it.ty());
/* 426 */           d *= d;
/* 427 */           renderUnder(d, r, it, false);
/* 428 */           if (!(SETT.ROOMS()).placement.embryo.is(it.tile())) {
/* 429 */             double w = (SETT.GROUND()).MOISTURE_TOT.get(it.tile());
/* 430 */             w = CLAMP.d(w, 0.0D, 1.0D);
/* 431 */             if (w > 0.0D) {
/* 432 */               ColorImp.TMP.interpolate((GCOLOR.MAP()).OVERLAY_BAD, (GCOLOR.MAP()).OVERLAY_GOOD, w).bind();
/* 433 */               int s = (int)(16.0D + w * 3.0D * 64.0D / 4.0D);
/* 434 */               int x1 = it.x() + (64 - s) / 2;
/* 435 */               int y1 = it.y() + (64 - s) / 2;
/*     */               
/* 437 */               (UI.icons()).s.drop.render((SPRITE_RENDERER)r, x1, x1 + s, y1, y1 + s);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }; this.irri = (FurnisherStat)new FurnisherStat.FurnisherStatIrrigation(this, blue); this.output = (FurnisherStat)new FurnisherStat.FurnisherStatProduction2(this, blue, 0.01D) { protected double getBase(AREA area, double[] acc) { double f = area.area(); if (!Constructor.this.isIndoors) {
/*     */             f = 0.0D; for (COORDINATE c : area.body()) {
/*     */               if (area.is(c))
/*     */                 f += Constructor.this.fertility(c.x(), c.y()); 
/*     */             } 
/*     */           }  f /= area.area(); f = CLAMP.d(f, 0.0D, 1.0D); return f * Constructor.this.workers.get(area, acc[Constructor.this.workers.index()]); } }
/*     */       ; this.isIndoors = init.data().bool("INDOORS"); this.blue = blue; Json sp = init.data().json("SPRITES"); final RoomSprite1x1 sfruit = new RoomSprite1x1(sp, "FRUIT_1X1"); final RoomSprite1x1 ssmall = new RoomSprite1x1(sp, "TREE_1X1"); RoomSpriteXxX tree = new RoomSpriteXxX(sp, "TREE_2X2", 2) { public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { if (type().dx(data) == 0 || type().dy(data) == 0)
/*     */             return false;  OTile t = blue.tile.get(it.tx(), it.ty()); if (t != null) {
/*     */             OTile.STATE state = t.state(); if (state == t.ISAPLING) {
/*     */               (SETT.TERRAIN()).BUSH.render(it, r, s, it.x() - 32, it.y() - 32, it.ran());
/*     */             } else if (state == t.ISMALL) {
/*     */               it.setOff(-32, -32); ssmall.render(r, s, data, it, degrade, isCandle);
/*     */             } 
/*     */           } else {
/*     */             (SETT.TERRAIN()).BUSH.render(it, r, s, it.x() - 32, it.y() - 32, it.ran());
/*     */           }  return false; } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { OTile t = blue.tile.get(it.tx(), it.ty()); if (t == null)
/*     */             return;  OTile.STATE state = t.state(); if (state != t.IBIG && state != t.IDEAD)
/*     */             return;  degrade = state.deadAmount(); super.render(r, s, data, it, degrade, false); int dx = 16 - 32 * type().dx(data) + it.oX(); int dy = 16 - 32 * type().dy(data) + it.oY(); it.setOff(dx, dy); Instance ins = (Instance)blue.getter.get(it.tile()); double a = 4.0D * state.fruitAmount() * Constructor.this.fertility.get(ins) * ins.skill() * blue.time.fruit(); int am = (int)a; for (int i = 0; i < am; i++) {
/*     */             it.ranOffset(i, 0); sfruit.render(r, s, data, it, degrade, false);
/*     */           }  } }
/*     */       ; this.sEdge = new RoomSpriteCombo(sp, "EDGE_COMBO"); RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "STORAGE_1X1") {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { boolean ret = super.render(r, s, data, it, degrade, isCandle); Constructor.this.storage.render(r, s, it.tx(), it.ty(), it.x(), it.y(), it.ran()); return ret; }
/*     */       }; FurnisherItemTile ss = new FurnisherItemTile(this, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, false); ss.setData(2); FurnisherItemTile tt = new FurnisherItemTile(this, (RoomSprite)tree, AVAILABILITY.AVOID_PASS, false); tt.setData(1); FurnisherItemTile __ = new FurnisherItemTile(this, (RoomSprite)RoomSprite.DUMMY, AVAILABILITY.ROOM, false); __.setData(3); flush(1, 1, 1);
/* 464 */     flush(3); } public boolean usesArea() { return true; } public boolean mustBeIndoors() { return this.isIndoors; } public Addable overlay() { return this.overlay; }
/*     */   public boolean mustBeOutdoors() { return !this.isIndoors; }
/*     */   public RoomBlueprintImp blue() { return (RoomBlueprintImp)this.blue; }
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) { if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 1) SETT.GRASS().grow(tx, ty, 16);  int m = 0; for (DIR d : DIR.ORTHO) { if (area.is(tx, ty, d)) m |= d.mask();  }  if (m != 15)
/* 468 */       (SETT.ROOMS()).fData.spriteData2.set(tx, ty, m);  (SETT.FLOOR()).clearer.clear(tx, ty); super.putFloor(tx, ty, upgrade, area); } public double fertility(int tx, int ty) { double d = ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).farm / (SETT.GROUND()).types.NORMAL.farm;
/* 469 */     if ((SETT.GROUND()).types.FOREST.is(tx, ty)) {
/* 470 */       d = 1.0D;
/*     */     } else {
/* 472 */       d *= 0.5D;
/* 473 */     }  d = CLAMP.d(d, 0.0D, 1.0D);
/* 474 */     return d; }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 479 */     return (Room)new Instance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence warning(AREA area) {
/* 484 */     double d = this.fertility.get(area, 0.0D);
/* 485 */     if (d < 0.5D)
/* 486 */       return ¤¤warning; 
/* 487 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doBeforePlanning(int tx, int ty) {
/* 493 */     super.doBeforePlanning(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/* 498 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean growsGrass(int tx, int ty) {
/* 503 */     return ((SETT.ROOMS()).fData.item.get(tx, ty) == null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */