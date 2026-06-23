/*     */ package settlement.room.water;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.overlay.Addable;
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
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import view.tool.ToolPlacer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Canal
/*     */   extends RoomBlueprintImp
/*     */   implements RoomPumpable.ROOM_PUMPABLE
/*     */ {
/*     */   public final CanalConstructor constructor;
/*     */   public final CanalInstance instance;
/*  52 */   private static CharSequence ¤¤problem = "Currently not operational. Make sure it's connected to a water pump's outlet, and that the connected pumps produce enough flow to reach it.";
/*  53 */   private static CharSequence ¤¤ok = "Operational";
/*     */   
/*     */   static {
/*  56 */     D.ts(Canal.class);
/*     */   }
/*     */   
/*     */   public Canal(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  60 */     super(init, 0, "_WATERCANAL", cat);
/*  61 */     this.instance = new CanalInstance(init.m, (RoomBlueprint)this);
/*  62 */     this.constructor = new CanalConstructor(init);
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  67 */     mm.add(new UIRoomModule()
/*     */         {
/*     */           public void hover(GBox box, Room i, int rx, int ry)
/*     */           {
/*  71 */             Canal.hover((GUI_BOX)box, rx, ry);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderFindable service(int tx, int ty) {
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  83 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hover(GUI_BOX box, int tx, int ty) {
/* 111 */     GBox b = (GBox)box;
/* 112 */     b.NL();
/* 113 */     boolean flow = ((SETT.ROOMS()).data.get(tx, ty) != 0);
/* 114 */     if (!flow) {
/* 115 */       b.add((SPRITE)b.text().warnify().add(¤¤problem));
/*     */     } else {
/* 117 */       b.add((SPRITE)b.text().normalify2().add(¤¤ok));
/* 118 */     }  b.NL();
/* 119 */     PumpGui.hoverSystem(b, tx, ty);
/*     */   }
/*     */   
/*     */   private final class CanalConstructor
/*     */     extends Furnisher {
/* 124 */     private final Canal.Overlay overlay = new Canal.Overlay();
/*     */     
/*     */     private final RoomSprite sp;
/*     */     
/*     */     protected CanalConstructor(RoomInitData init) throws IOException {
/* 129 */       super(init, 1, 0);
/*     */       
/* 131 */       this.sp = new WSprite.RSprite(Canal.this, Canal.this.instance.pump, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 137 */       flush(1, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean joinsWithFloor() {
/* 143 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean usesArea() {
/* 148 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean mustBeIndoors() {
/* 153 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Room create(TmpArea area, RoomInit init) {
/* 158 */       int tx = area.mX();
/* 159 */       int ty = area.my();
/* 160 */       Canal.this.instance.place(area);
/* 161 */       (SETT.ROOMS()).fData.spriteData2.set(tx, ty, 1);
/* 162 */       for (DIR d : DIR.ORTHO) {
/* 163 */         if (Canal.this.is(tx, ty, d)) {
/* 164 */           (SETT.ROOMS()).fData.spriteData2.set(tx, ty, d, 1);
/*     */         }
/*     */       } 
/*     */       
/* 168 */       return (SETT.ROOMS()).map.get(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     public RoomBlueprintImp blue() {
/* 173 */       return Canal.this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean envValue(SettEnvMap.SettEnv e, SettEnvMap.SettEnvValue v, int tx, int ty) {
/* 181 */       if (blue().is(tx, ty) && (SETT.ROOMS()).data.get(tx, ty) != 0 && e == (SETT.ENV()).map.WATER_SWEET) {
/* 182 */         v.value = 1.0D;
/* 183 */         v.radius = 1.0D;
/* 184 */         return true;
/*     */       } 
/* 186 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean envValue(SettEnvMap.SettEnv e) {
/* 194 */       return (e == (SETT.ENV()).map.WATER_SWEET);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean removeFertility() {
/* 199 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSpecialAreaPlacable() {
/* 204 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderExtra(SPRITE_RENDERER r, int x, int y, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 209 */       super.renderExtra(r, x, y, tx, ty, rx, ry, item);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Addable overlay() {
/* 215 */       return this.overlay;
/*     */     }
/*     */   }
/*     */   
/*     */   private class Overlay
/*     */     extends Addable
/*     */   {
/*     */     public Overlay() {
/* 223 */       super(true, false);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 228 */       if ((SETT.ROOMS()).construction.isser.is(it.tile()))
/*     */         return; 
/* 230 */       double d = (SETT.GROUND()).MOISTURE_TOT.get(it.tile());
/* 231 */       if (GUTIL.flooder().hasBeenPushed(it.tx(), it.ty())) {
/* 232 */         d += 2.0D * (1.0D - CLAMP.d(GUTIL.flooder().getValue(it.tx(), it.ty()) / 15.0D, 0.0D, 1.0D));
/*     */       }
/* 234 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 235 */       renderUnder(d, r, it, false);
/* 236 */       if (d > 0.75D) {
/* 237 */         d = (d - 0.75D) * 4.0D;
/* 238 */         renderPluses(d, r, it);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void initBelow(RenderData data) {
/* 245 */       for (COORDINATE c : data.tBounds()) {
/* 246 */         if (SETT.IN_BOUNDS(c)) {
/* 247 */           GUTIL.flooder().setValue2(c, 0.0D);
/*     */         }
/*     */       } 
/* 250 */       AREA a = ToolPlacer.area();
/* 251 */       if (a.area() == 0) {
/*     */         return;
/*     */       }
/* 254 */       GUTIL.flooder().init(this);
/*     */ 
/*     */       
/* 257 */       for (COORDINATE c : a.body()) {
/* 258 */         if (a.is(c) && c.distance(data.tBounds().cX(), data.tBounds().cY()) < (Math.max(data.tBounds().width() / 2, data.tBounds().height() / 2) + 18)) {
/* 259 */           GUTIL.flooder().pushSloppy(c, 0.0D);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 265 */       while (GUTIL.flooder().hasMore()) {
/* 266 */         PathTile t = GUTIL.flooder().pollSmallest();
/* 267 */         if (t.getValue() >= 15.0F) {
/*     */           continue;
/*     */         }
/* 270 */         for (DIR d : DIR.ALL) {
/* 271 */           if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 272 */             GUTIL.flooder().pushSloppy((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 277 */       super.initBelow(data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void finishBelow() {
/* 282 */       GUTIL.flooder().done();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CanalInstance
/*     */     extends RoomSingleton
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/* 294 */     private static final transient RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */     private RoomPumpable pump;
/*     */     
/* 297 */     CanalInstance(ROOMS m, RoomBlueprint p) { super(m, p);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 334 */       this.pump = new RoomPumpable()
/*     */         {
/*     */           public void drain(int tx, int ty)
/*     */           {
/* 338 */             Canal.CanalInstance.wrap.init((Room)Canal.CanalInstance.this, tx, ty);
/* 339 */             (SETT.ROOMS()).data.set(Canal.CanalInstance.wrap.area(), tx, ty, 0);
/* 340 */             Canal.CanalInstance.wrap.done();
/*     */           }
/*     */ 
/*     */           
/*     */           public void pump(int tx, int ty, DIR d, int dirmask) {
/* 345 */             Canal.CanalInstance.wrap.init((Room)Canal.CanalInstance.this, tx, ty);
/* 346 */             int da = (SETT.ROOMS()).data.get(tx, ty);
/* 347 */             da |= d.mask();
/* 348 */             (SETT.ROOMS()).data.set(Canal.CanalInstance.wrap.area(), tx, ty, da);
/* 349 */             Canal.CanalInstance.wrap.done();
/* 350 */             if ((dirmask & 0xF) != (dirmask(tx, ty) & 0xF)) {
/* 351 */               (SETT.ENV()).map.setChanged(tx, ty, (SETT.ENV()).map.WATER_SWEET);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void pumpFail(int tx, int ty, int dirmask) {
/* 357 */             if (dirmask != 0) {
/* 358 */               (SETT.ENV()).map.setChanged(tx, ty);
/*     */             }
/*     */           }
/*     */           
/*     */           public int dirmask(int tx, int ty) {
/* 363 */             return (SETT.ROOMS()).data.get(tx, ty) & 0xF;
/*     */           }
/*     */ 
/*     */           
/*     */           public int radius() {
/* 368 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           protected boolean pumpsTo(int fromX, int fromY, int tx, int ty) {
/* 373 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public double irrigation(int tx, int ty) {
/* 378 */             return (((SETT.ROOMS()).data.get(tx, ty) == 0) ? false : true); }
/*     */         }; }
/*     */     protected Object readResolve() { return (blueprintI()).instance; }
/*     */     public Canal blueprintI() { return (Canal)blueprint(); } public ROOM_DEGRADER degrader(int tx, int ty) { return null; } public void updateTileDay(int tx, int ty) {} protected void removeAction(ROOMA ins) {
/*     */       super.removeAction(ins);
/*     */       RoomPumpable.reportChange(ins.mX(), ins.mY(), 0);
/*     */     } protected void addAction(ROOMA ins) {
/*     */       super.removeAction(ins);
/*     */       RoomPumpable.reportChange(ins.mX(), ins.mY(), 0);
/*     */     }
/*     */   } public RoomPumpable pumpable(int tx, int ty) {
/* 389 */     if (is(tx, ty))
/* 390 */       return this.instance.pump; 
/* 391 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Canal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */