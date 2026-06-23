/*     */ package settlement.room.water.pool;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomSingleton;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.water.RoomPumpable;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ROOM_POOL
/*     */   extends RoomBlueprintImp
/*     */   implements RoomPumpable.ROOM_PUMPABLE
/*     */ {
/*     */   public final CanalConstructor constructor;
/*     */   public final Instance instance;
/*  58 */   private static CharSequence ¤¤problem = "Has no fresh water access and is not functional. Must be adjacent to a functioning canal to operate.";
/*  59 */   private static CharSequence ¤¤ok = "Operational";
/*     */   
/*  61 */   private static CharSequence ¤¤available = "Available for a swim";
/*  62 */   private static CharSequence ¤¤unavailable = "Unavailable for a swim";
/*     */   public final double defaultFullfillment;
/*     */   private final Fin bath;
/*     */   
/*     */   static {
/*  67 */     D.ts(ROOM_POOL.class);
/*     */   }
/*     */   public void appendView(LISTE<UIRoomModule> mm) { mm.add(new UIRoomModule()
/*     */         {
/*     */           public void hover(GBox box, Room i, int rx, int ry) { ROOM_POOL.hover((GUI_BOX)box, ((SETT.ROOMS()).extraBit.get(rx, ry) != 0), ROOM_POOL.this.fservice(rx, ry).findableReservedCanBe()); }
/*     */         }); }
/*  73 */   public SFinderFindable service(int tx, int ty) { return null; } public FINDABLE fservice(int tx, int ty) { return this.bath.get(tx, ty); } public Furnisher constructor() { return this.constructor; } protected void save(FilePutter file) {} protected void load(FileGetter file) throws IOException {} protected void clear() {} public ROOM_POOL(int index, RoomInitData init, String key, RoomCategorySub cat) throws IOException { super(init, index, key, cat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 439 */     this.bath = new Fin(); this.instance = new Instance(init.m, (RoomBlueprint)this); this.constructor = new CanalConstructor(init); this.defaultFullfillment = init.data().dTry("FULLFILLMENT", 0.0D, 1.0D, 0.0D); } protected void update(double ds) {} public RoomPumpable pumpable(int tx, int ty) { return this.instance.pump; } public static boolean isWater(int tx, int ty) { return ((SETT.ROOMS()).map.blueprint.get(tx, ty) instanceof ROOM_POOL && (SETT.ROOMS()).extraBit.get(tx, ty) == 1); } public static void hover(GUI_BOX box, boolean flow, boolean bath) { GBox b = (GBox)box; b.NL(); if (!flow) { b.add((SPRITE)b.text().warnify().add(¤¤problem)); } else { b.add((SPRITE)b.text().normalify2().add(¤¤ok)); }  b.NL(); if (!bath) { b.add((SPRITE)b.text().warnify().add(¤¤unavailable)); } else { b.add((SPRITE)b.text().normalify2().add(¤¤available)); }  } private final class CanalConstructor extends Furnisher {
/*     */     private final boolean clearFer; protected CanalConstructor(RoomInitData init) throws IOException { super(init, 1, 0); Json sp = init.data().json("SPRITES"); final ColorImp color = new ColorImp(init.data(), "WATER_COLOR"); final OpacityImp opacity = new OpacityImp((int)(init.data().d("WATER_DEPTH", 0.0D, 1.0D) * 255.0D)); this.clearFer = init.data().bool("CLEARS_GRASS"); final TILE_SHEET bottom = SPRITES.GAME().raw((SheetType)SheetType.sTex, "BOTTOM_TEXTURE", init.data()); RoomSpriteCombo s = new RoomSpriteCombo(sp, "FRAME_COMBO", sp) { final RoomSprite1x1 ontop; final RoomSpriteCombo stencil; public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) { data = 0; for (DIR d : DIR.ORTHO) { if ((SETT.ROOMS()).map.blueprintImp.get(tx, ty, d) == ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this)) data |= d.mask();  }  (SPRITES.cons()).BIG.outline.render(r, data, x, y); } public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { data = getData(it.tx(), it.ty(), 0, 0, null, GUTIL.ran2().get(it.tile())); super.render(SPRITE_RENDERER.DUMMY, s, data, it, degrade, false); } public void renderB(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { data = getData(it.tx(), it.ty(), 0, 0, null, GUTIL.ran2().get(it.tile())) & 0xF; TextureCoords tex = this.stencil.texture(data, it); int x2 = it.x() + 64; int y2 = it.y() + 64; CORE.renderer().renderTextured(it.x(), x2, it.y(), y2, bottom.getTexture(it.ran() % bottom.tiles()), tex); if ((SETT.ROOMS()).map.get(it.tile()) != (ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this)).instance || ((SETT.ROOMS()).extraBit.get(it.tile()) & 0x1) != 1) return;  data = this.stencil.getData(it.tx(), it.ty(), 0, 0, null, GUTIL.ran2().get(it.tile())) & 0xF; tex = this.stencil.texture(data, it); color.bind(); opacity.bind(); TextureCoords oo = (SPRITES.textures()).dis_small.get((it.tx() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D, (it.ty() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D); CORE.renderer().renderTextured(it.x(), x2, it.y(), y2, oo, tex); oo = (SPRITES.textures()).dis_small.get(((it.tx() + 1) * 16) - 8.0D * TIME.currentSecond(), ((it.ty() + 1) * 16) - 8.0D * TIME.currentSecond()); CORE.renderer().renderTextured(it.x(), x2, it.y(), y2, oo, tex); COLOR.unbind(); OPACITY.unbind(); } protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) { return ((SETT.ROOMS()).map.get(tx, ty) == (ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this)).instance); } public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) { renderB(r, s, data, it, degrade); data = 0; int iceMask = 0; for (DIR d : DIR.ORTHO) { if ((SETT.ROOMS()).map.get(it.tx(), it.ty(), d) == (ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this)).instance) { data |= d.mask(); if (((SETT.ROOMS()).extraBit.get(it.tx(), it.ty()) & 0x1) == 1 && (SETT.TERRAIN()).WATER.is.is(it.tx() + d.x(), it.ty() + d.y())) iceMask |= d.mask();  }  }  if ((SETT.TERRAIN()).WATER.ice.is(it.tx(), it.ty())) { (SETT.TERRAIN()).WATER.renderIce(it, iceMask); super.render(r, ShadowBatch.DUMMY, data, it, degrade, isCandle); } else { super.render(r, ShadowBatch.DUMMY, data, it, degrade, isCandle); this.ontop.render(r, s, getData2(it), it, degrade, false); }  data = getData(it.tx(), it.ty(), 0, 0, null, 0); TextureCoords tex = this.stencil.texture(data, it); CORE.renderer().setMaxDepth(it.x(), it.x() + 64, it.y(), it.y() + 64, tex, CORE.renderer().getDepth() + 1); return false; } }
/*     */         ; flush(1, 0); } public boolean removeFertility() { return this.clearFer; } public boolean usesArea() { return false; } public boolean mustBeIndoors() { return false; } public void putFloor(int tx, int ty, int upgrade, AREA area) {} public Room create(TmpArea area, RoomInit init) { int tx = area.mX(); int ty = area.my(); ROOM_POOL.this.instance.place(area); (SETT.ROOMS()).fData.spriteData2.set(tx, ty, 1); for (DIR d : DIR.ORTHO) { if (ROOM_POOL.this.is(tx, ty, d)) (SETT.ROOMS()).fData.spriteData2.set(tx, ty, d, 1);  }  return (SETT.ROOMS()).map.get(tx, ty); } public RoomBlueprintImp blue() { return ROOM_POOL.this; } public boolean isSpecialAreaPlacable() { return true; }
/*     */   } private static class Instance extends RoomSingleton {
/*     */     private static final long serialVersionUID = 1L; private RoomPumpable pump; Instance(ROOMS m, RoomBlueprint p) { super(m, p); this.pump = new RoomPumpable() {
/*     */           protected int radius() { return 0; } protected void pump(int tx, int ty, DIR d, int dirmask) { int da = (SETT.ROOMS()).extraBit.get(tx, ty); if ((da & 0x1) == 0) { da |= 0x1; (SETT.ROOMS()).extraBit.set(tx, ty, da); FINDABLE s = ROOM_POOL.Instance.this.blueprintI().fservice(tx, ty); if (s != null && s.findableReservedCanBe()) (SETT.PATH()).finders.water.report(tx, ty, 1);  }  } protected void drain(int tx, int ty) { FINDABLE s = ROOM_POOL.Instance.this.blueprintI().fservice(tx, ty); if (s != null && s.findableReservedCanBe()) (SETT.PATH()).finders.water.report(tx, ty, -1);  (SETT.ROOMS()).extraBit.set(tx, ty, 0); } protected int dirmask(int tx, int ty) { return 0; } protected boolean pumpsTo(int fromX, int fromY, int tx, int ty) { return ((SETT.ROOMS()).map.blueprint.get(tx, ty) == ROOM_POOL.Instance.this.blueprintI()); } public double irrigation(int tx, int ty) { return ((SETT.ROOMS()).extraBit.get(tx, ty) & 0x1); }
/*     */         }; } protected Object readResolve() { return (blueprintI()).instance; } public ROOM_POOL blueprintI() { return (ROOM_POOL)blueprint(); } public void updateTileDay(int tx, int ty) {} protected void removeAction(ROOMA ins) { for (COORDINATE c : ins.body()) { if (ins.is(c)) { (SETT.ROOMS()).extraBit.set(c, 0); RoomPumpable.reportChange(c.x(), c.y(), 0); if (((SETT.ROOMS()).extraBit.get(c.x(), c.y()) & 0x1) == 1) { FINDABLE s = blueprintI().fservice(c.x(), c.y()); if (s != null && s.findableReservedCanBe()) (SETT.PATH()).finders.water.report(c.x(), c.y(), -1);  }  }  }  } protected void addAction(ROOMA ins) { super.addAction(ins); for (COORDINATE c : ins.body()) { if (ins.is(c)) { (SETT.ROOMS()).extraBit.set(c, 0); RoomPumpable.reportChange(c.x(), c.y(), 0); }  }  } protected AVAILABILITY getAvailability(int tile) { return AVAILABILITY.AVOID_PASS; }
/*     */   } private class Fin implements FINDABLE {
/* 447 */     public FINDABLE get(int tx, int ty) { if (ROOM_POOL.this.is(tx, ty)) {
/* 448 */         this.tx = tx;
/* 449 */         this.ty = ty;
/*     */       } 
/* 451 */       return this; }
/*     */     
/*     */     private int tx;
/*     */     private int ty;
/*     */     
/*     */     public int y() {
/* 457 */       return this.ty;
/*     */     }
/*     */ 
/*     */     
/*     */     public int x() {
/* 462 */       return this.tx;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean findableReservedIs() {
/* 468 */       return (((SETT.ROOMS()).extraBit.get(this.tx, this.ty) & 0x3) == 3);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean findableReservedCanBe() {
/* 473 */       return (((SETT.ROOMS()).extraBit.get(this.tx, this.ty) & 0x3) == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void findableReserveCancel() {
/* 478 */       if (findableReservedIs()) {
/* 479 */         int d = (SETT.ROOMS()).extraBit.get(this.tx, this.ty);
/* 480 */         d &= 0xFFFFFFFD;
/* 481 */         (SETT.ROOMS()).extraBit.set(this.tx, this.ty, d);
/* 482 */         if (findableReservedCanBe()) {
/* 483 */           (SETT.PATH()).finders.water.report(this.tx, this.ty, 1);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void findableReserve() {
/* 490 */       if (findableReservedCanBe()) {
/* 491 */         int d = (SETT.ROOMS()).extraBit.get(this.tx, this.ty);
/* 492 */         d |= 0x2;
/*     */         
/* 494 */         (SETT.ROOMS()).extraBit.set(this.tx, this.ty, d);
/* 495 */         (SETT.PATH()).finders.water.report(this.tx, this.ty, -1);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\pool\ROOM_POOL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */