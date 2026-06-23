/*     */ package settlement.overlay;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.Minable;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.work.AIModule_Work;
/*     */ import settlement.environment.Foundation;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.environment.SettEnvShape;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0Level;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentChecker;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.service.module.RoomFinderHaser;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ 
/*     */ public final class SettOverlay {
/*  58 */   private final SComponentChecker cCheck = new SComponentChecker((SComponentLevel)(SETT.PATH()).comps.zero); private final LIST<Env> envs; public boolean added; public Addable RESOURCES; public Addable EDIBLES;
/*     */   public SettOverlay() {
/*  60 */     D.gInit(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     this.RESOURCES = new Addable(false, true)
/*     */       {
/*     */         
/*     */         public boolean render(Renderer r, RenderData.RenderIterator it)
/*     */         {
/*  70 */           if ((SETT.MINERALS()).getter.is(it.tile())) {
/*  71 */             double v = 1.0D;
/*  72 */             if (!(SETT.TERRAIN()).CAVE.is(it.tile())) {
/*  73 */               renderUnder(v, r, it, false);
/*     */             }
/*  75 */             if ((SETT.ROOMS()).map.is(it.tile()))
/*  76 */               return false; 
/*  77 */             if ((SETT.MINERALS()).getter.is(it.tile())) {
/*  78 */               COLOR.unbind();
/*  79 */               double am = 0.5D + (SETT.MINERALS()).value.get(it.tile()) / 2.0D;
/*  80 */               int size = (int)(64.0D * am);
/*  81 */               int off = (64 - size) / 2;
/*  82 */               renderAbove(am * 2.0D - 1.0D, r, it, true);
/*  83 */               COLOR.unbind();
/*  84 */               ((Minable)(SETT.MINERALS()).getter.get(it.tile())).resource.icon().render((SPRITE_RENDERER)r, it.x() + off, it.x() + off + size, it.y() + off, it.y() + off + size);
/*  85 */               return true;
/*     */             } 
/*     */           } 
/*  88 */           if (SETT.TERRAIN().get(it.tile()) instanceof TGrowable) {
/*  89 */             SettOverlay.this.EDIBLES.renderBelow(r, it);
/*  90 */             SettOverlay.this.EDIBLES.render(r, it);
/*  91 */             return true;
/*     */           } 
/*  93 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  98 */     this.EDIBLES = new Addable(true, true)
/*     */       {
/*     */         public boolean render(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 102 */           if ((SETT.JOBS()).getter.get(it.tile()) == null && SETT.TERRAIN().get(it.tile()) instanceof TGrowable)
/*     */           {
/* 104 */             if (SETT.TERRAIN().get(it.tile()) instanceof TGrowable) {
/* 105 */               COLOR.unbind();
/* 106 */               double am = 1.0D;
/* 107 */               ColorImp.TMP.interpolate(COLOR.WHITE20, COLOR.WHITE100, am).bind();
/* 108 */               int size = (int)(64.0D * am);
/* 109 */               int off = (64 - size) / 2;
/* 110 */               COLOR.unbind();
/* 111 */               ((TGrowable)SETT.TERRAIN().get(it.tile())).growable.resource.icon().render((SPRITE_RENDERER)r, it.x() + off, it.x() + off + size, it.y() + off, it.y() + off + size);
/*     */               
/* 113 */               return true;
/*     */             } 
/*     */           }
/* 116 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 122 */           double v = 0.0D;
/* 123 */           if (SETT.TERRAIN().get(it.tile()) instanceof TGrowable) {
/* 124 */             TGrowable b = (TGrowable)SETT.TERRAIN().get(it.tile());
/* 125 */             v = 0.5D + 0.5D * b.size.DM.get(it.tile());
/*     */           } 
/* 127 */           renderUnder(v, r, it, false);
/*     */         }
/*     */       };
/*     */     
/* 131 */     this.MOISTURE = new Addable((SPRITE)(UI.icons()).m.fertility.twin((SPRITE)(UI.icons()).s.drop, DIR.NE, 1), "MOISTURE", Ground.¤¤moisture, D.g("MoistureD", "Highlights moisture of the ground."), true, false)
/*     */       {
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 135 */           double d = (SETT.GROUND()).MOISTURE_TOT.get(it.tile());
/* 136 */           d = CLAMP.d(d, 0.0D, 1.0D);
/* 137 */           d *= d;
/* 138 */           renderUnder(d, r, it, false);
/* 139 */           if (d > 0.75D) {
/* 140 */             d = (d - 0.75D) * 4.0D;
/* 141 */             renderPluses(d, r, it);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     this.FERTILITY_BASE = new Addable((SPRITE)(UI.icons()).m.fertility, "FERTILITY_base", D.g("Soil"), D.g("SoilD", "Type of soil."), true, true)
/*     */       {
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 153 */           double d = ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).farm / (SETT.GROUND()).types.NORMAL.farm;
/* 154 */           d *= d;
/* 155 */           renderUnder(d, r, it, false);
/* 156 */           if (d > 0.75D) {
/* 157 */             d = (d - 0.75D) * 4.0D;
/* 158 */             renderPluses(d, r, it);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 164 */           double d = ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).farm / (SETT.GROUND()).types.NORMAL.farm;
/* 165 */           d *= d;
/* 166 */           if (renderAbove(d, r, it, false)) {
/* 167 */             if (d > 0.75D) {
/* 168 */               d = (d - 0.75D) * 4.0D;
/* 169 */               renderPluses(d, r, it);
/*     */             } 
/* 171 */             return true;
/*     */           } 
/* 173 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 178 */     this.SHAPE = new Addable((SPRITE)(UI.icons()).m.place_rec, "SHAPE_base", SettEnvShape.¤¤name, "shaped", true, false)
/*     */       {
/*     */         
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 183 */           COLOR c = COLOR.WHITE05;
/* 184 */           boolean base = false;
/* 185 */           if (!(SETT.ROOMS()).map.is(it.tile()) || (SETT.ROOMS()).map.get(it.tile()).blueprint().registersEnvironment()) {
/*     */ 
/*     */             
/* 188 */             if ((SETT.ENV()).map.SHAPE.round.is(it.tile())) {
/* 189 */               c = (GCOLOR.MAP()).OVERLAY_GOOD;
/*     */             }
/* 191 */             else if ((SETT.ENV()).map.SHAPE.square.is(it.tile())) {
/* 192 */               c = (GCOLOR.MAP()).OVERLAY_BAD;
/* 193 */             }  base = (VIEW.s().getWindow().zoomout() <= 1 && (SETT.ENV()).map.SHAPE.isBase(it.tx(), it.ty()));
/*     */           } 
/*     */           
/* 196 */           renderUnder(c, r, it);
/* 197 */           if (base) {
/* 198 */             renderPluses(1.0D, r, it);
/*     */           }
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
/* 211 */     this.FOUNDATION = new Addable((SPRITE)(UI.icons()).m.foundation, "FOUNDATION", Foundation.¤¤name, Foundation.¤¤desc, true, false)
/*     */       {
/*     */         
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 216 */           renderUnder((SETT.ENV()).foundation.get(it.tx(), it.ty()), r, it);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     this.input = new InputOverlay();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 357 */     this.MAINTENANCE = new OverlayMaintenance();
/*     */     
/* 359 */     this.ROOM_PROBLEM = new RoomProblem();
/*     */     
/* 361 */     this.ROADING = new Addable((SPRITE)(SETT.FLOOR()).defaultRoad.getIcon(), "ROADING", D.g("Path-Usage"), D.g("Path-UsageD", "Highlights the tiles your subjects use when moving."), true, false)
/*     */       {
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 365 */           if ((SETT.ROOMS()).map.is(it.tile()))
/*     */             return; 
/* 367 */           if ((SETT.JOBS()).getter.get(it.tile()) != null) {
/*     */             return;
/*     */           }
/* 370 */           double p = (SETT.PATH()).huristics.getter.get(it.tile()) * 16.0D;
/* 371 */           p = CLAMP.d(p, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 378 */           double d = 0.25D + (SETT.PATH()).huristics.getter.get(it.tile()) * 8.0D;
/* 379 */           d = CLAMP.d(d, 0.0D, 1.0D);
/* 380 */           renderUnder(d, r, it, false);
/* 381 */           ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_GOOD, p).bind();
/* 382 */           renderPluses(p, r, it);
/*     */           
/* 384 */           if ((SETT.FLOOR()).getter.is(it.tile()) || (SETT.JOBS()).jobGetter.is(it.tile())) {
/* 385 */             ColorImp.TMP.interpolate(COLOR.WHITE05, (GCOLOR.MAP()).OVERLAY_GOOD, p).bind();
/* 386 */             renderPluses(p, r, it);
/*     */             
/*     */             return;
/*     */           } 
/*     */         }
/*     */       };
/* 392 */     this.RODIFY = new Addable(null, null, null, null, true, false)
/*     */       {
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 396 */           renderUnder(((SETT.FLOOR()).floorundernot.is(it.tile()) ? false : true), r, it, false);
/*     */         }
/*     */       };
/*     */     
/* 400 */     this.PAINTER = new Addable((SPRITE)(UI.icons()).m.place_brush, "MAP_PAINTED", D.g("Paint-Tool"), D.g("Paint-ToolD", "shows your manual paintings on the map."), true, true)
/*     */       {
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/* 404 */           int ci = (SETT.JOBS()).paintmap.get(it.tile());
/* 405 */           COLOR c = (ci == 0) ? COLOR.WHITE10 : (COLOR)COLOR.UNIQUE.get(ci);
/* 406 */           renderUnder(c, r, it);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 411 */           int ci = (SETT.JOBS()).paintmap.get(it.tile());
/* 412 */           COLOR c = (ci == 0) ? COLOR.WHITE10 : (COLOR)COLOR.UNIQUE.get(ci);
/* 413 */           return renderAbove(c, r, it);
/*     */         }
/*     */       };
/*     */     
/* 417 */     this.WORKLOAD = new Addable((SPRITE)(UI.icons()).m.workshop, "WORKLOAD", RoomEmploymentIns.¤¤Workload, RoomEmploymentIns.¤¤WorkloadD, true, false)
/*     */       {
/* 419 */         private final ColorImp c = new ColorImp();
/*     */ 
/*     */         
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 423 */           this.c.set(COLOR.WHITE05);
/* 424 */           Room ro = (SETT.ROOMS()).map.get(it.tx(), it.ty());
/* 425 */           if (ro != null && ro instanceof RoomInstance) {
/* 426 */             RoomInstance i = (RoomInstance)ro;
/* 427 */             if (i.blueprintI().employment() != null) {
/* 428 */               this.c.interpolate((GCOLOR.MAP()).OVERLAY_BAD, (GCOLOR.MAP()).OVERLAY_GOOD, i.employees().efficiency());
/*     */             }
/*     */           } 
/*     */           
/* 432 */           renderUnder((COLOR)this.c, r, it);
/*     */         }
/*     */       };
/* 435 */     this.PULL = new OverlayPull();
/*     */     
/* 437 */     this.service = new ServiceRadius();
/* 438 */     this.radius = new RadiusInter();
/* 439 */     this.roomRadius = new RoomRadius(this.cCheck);
/*     */     
/* 441 */     this.mon = new Mon();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 470 */     this.HOMELESS = new Homeless("HOMELESS", D.g("Homeless"), D.g("HomelessD", "Highlights homeless workplaces and homeless oddjobbers."));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 478 */     this.tiles = new ArrayList(100);
/* 479 */     this.objects = new ArrayList(100);
/* 480 */     this.rooms = new ArrayCooShort(5);
/* 481 */     this.colors = new COLOR[100];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 674 */     LinkedList<Env> ee = new LinkedList();
/* 675 */     for (SettEnvMap.SettEnv s : (SETT.ENV()).map.all())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 692 */       ee.add(new Env(s, false));
/*     */     }
/*     */     
/* 695 */     this.envs = (LIST<Env>)new ArrayList((Iterable)ee);
/*     */   }
/*     */   
/*     */   public Addable MOISTURE;
/*     */   public Addable FERTILITY_BASE;
/*     */   public Addable SHAPE;
/*     */   public Addable FOUNDATION;
/*     */   private final InputOverlay input;
/*     */   public OverlayMaintenance MAINTENANCE;
/*     */   public final Addable ROOM_PROBLEM;
/*     */   public Addable ROADING;
/*     */   public Addable RODIFY;
/*     */   public Addable PAINTER;
/*     */   public Addable WORKLOAD;
/*     */   public final OverlayPull PULL;
/*     */   private final ServiceRadius service;
/*     */   private final RadiusInter radius;
/*     */   private final RoomRadius roomRadius;
/*     */   private Mon mon;
/*     */   public Addable HOMELESS;
/*     */   private ArrayList<Addable> tmp;
/*     */   private final ArrayList<ON_TOP_TILE> tiles;
/*     */   private final ArrayList<BODY_HOLDER> objects;
/*     */   private final ArrayCooShort rooms;
/*     */   private final COLOR[] colors;
/*     */   
/*     */   private final class InputOverlay extends Addable {
/*     */     private RoomInstance ins;
/*     */     private double max = 36.0D;
/*     */     private final Rec bounds = new Rec();
/*     */     
/*     */     public InputOverlay() {
/*     */       super(true, false);
/*     */     }
/*     */     
/*     */     public void initBelow(RenderData data) {
/*     */       PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */       f.init(this);
/*     */       double speed = 0.0D;
/*     */       double speedCount = 0.0D;
/*     */       ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*     */       for (int i = 0; i < SETT.ENTITIES().Imax(); i++) {
/*     */         ENTITY e = es[i];
/*     */         if (e != null && e instanceof Humanoid) {
/*     */           Humanoid a = (Humanoid)e;
/*     */           if ((STATS.WORK()).EMPLOYED.get(a) == this.ins) {
/*     */             speed += (BOOSTABLES.PHYSICS()).SPEED.get((BOOSTABLE_O)a.indu());
/*     */             speedCount++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       if (speedCount == 0.0D) {
/*     */         speed = (BOOSTABLES.PHYSICS()).SPEED.baseValue;
/*     */       } else {
/*     */         speed /= speedCount;
/*     */       } 
/*     */       this.max = 36.0D * speed / (BOOSTABLES.PHYSICS()).SPEED.baseValue;
/*     */       for (COORDINATE c : this.ins.body()) {
/*     */         if (this.ins.is(c))
/*     */           f.pushSmaller(c, 0.0D); 
/*     */       } 
/*     */       SComp0Level cc = (SETT.PATH()).comps.zero;
/*     */       this.bounds.set(VIEW.s().getWindow().tiles());
/*     */       this.bounds.pad(cc.size(), cc.size());
/*     */       for (COORDINATE c : this.bounds) {
/*     */         if (SETT.IN_BOUNDS(c))
/*     */           f.setValue2(c, -1.0D); 
/*     */       } 
/*     */       while (f.hasMore()) {
/*     */         PathTile t = GUTIL.flooder().pollSmallest();
/*     */         if (t.getValue() >= this.max) {
/*     */           f.reopen(t);
/*     */           f.pushSloppy((COORDINATE)t, t.getValue());
/*     */           break;
/*     */         } 
/*     */         t.setValue2(t.getValue() / this.max);
/*     */         for (DIR d : DIR.ALL) {
/*     */           if ((SETT.PATH()).coster.player.getCost(t.x(), t.y(), t.x() + d.x(), t.y() + d.y()) >= 0.0D)
/*     */             f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance() / ((AVAILABILITY)(SETT.PATH()).availability.get((COORDINATE)t, d)).movementSpeed); 
/*     */         } 
/*     */       } 
/*     */       while (f.hasMore()) {
/*     */         PathTile t = GUTIL.flooder().pollSmallest();
/*     */         SComponent c = (SComponent)cc.get((COORDINATE)t);
/*     */         if (c == null)
/*     */           continue; 
/*     */         if (t.getValue() >= AIModule_Work.MAX_FETCH_DISTANCE) {
/*     */           int x1 = c.centreX() & (cc.size() - 1 ^ 0xFFFFFFFF);
/*     */           int y1 = c.centreY() & (cc.size() - 1 ^ 0xFFFFFFFF);
/*     */           f.setValue2(x1, y1, -2.0D);
/*     */         } 
/*     */         SComponentEdge e = c.edgefirst();
/*     */         while (e != null) {
/*     */           f.pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance());
/*     */           e = e.next();
/*     */         } 
/*     */       } 
/*     */       f.done();
/*     */     }
/*     */     
/*     */     public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/*     */       double v = GUTIL.flooder().getValue2(it.coo());
/*     */       if (v == -1.0D) {
/*     */         SComp0Level cc = (SETT.PATH()).comps.zero;
/*     */         SComponent c = (SComponent)cc.get(it.coo());
/*     */         if (c != null) {
/*     */           int x1 = c.centreX() & (cc.size() - 1 ^ 0xFFFFFFFF);
/*     */           int y1 = c.centreY() & (cc.size() - 1 ^ 0xFFFFFFFF);
/*     */           if (GUTIL.flooder().getValue2(x1, y1) == -2.0F)
/*     */             v = -2.0D; 
/*     */         } 
/*     */       } 
/*     */       if (v == -2.0D) {
/*     */         renderUnder(0.0D, r, it, false);
/*     */       } else if (v == -1.0D) {
/*     */         renderUnder(0.2D, r, it, false);
/*     */       } else {
/*     */         v = 1.0D - v;
/*     */         v += 0.5D;
/*     */         v = CLAMP.d(v, 0.0D, 1.0D);
/*     */         renderUnder(v, r, it, false);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void finishBelow() {}
/*     */   }
/*     */   
/*     */   public void addFetch(RoomInstance ins) {
/*     */     this.input.ins = ins;
/*     */     this.input.add();
/*     */   }
/*     */   
/*     */   public Addable monument(ROOM_MONUMENT m) {
/*     */     this.mon.set(m);
/*     */     this.mon.add();
/*     */     return this.mon;
/*     */   }
/*     */   
/*     */   public void monument(ROOM_MONUMENT m, FurnisherItem it, int x1, int y1, int radius) {
/*     */     this.mon.set(m, it, x1, y1, radius);
/*     */   }
/*     */   
/*     */   public void service(RoomFinderHaser blue) {
/*     */     this.service.add(blue);
/*     */   }
/*     */   
/*     */   public void RadiusInter(RoomBlueprintIns<? extends RADIUS_INTER> blue, SFinderFindable fin) {
/*     */     this.radius.add(blue, fin);
/*     */   }
/*     */   
/*     */   public void RadiusInter(RoomBlueprintIns<? extends RADIUS_INTER> blue, SFinderFindable fin, int tx, int ty, double ra) {
/*     */     this.radius.add(blue, fin, tx, ty, ra);
/*     */   }
/*     */   
/*     */   public void roomRadius(RoomInstance ins, int radius) {
/*     */     this.roomRadius.add(ins, radius);
/*     */   }
/*     */   
/*     */   public LIST<Addable> all() {
/*     */     return (LIST<Addable>)Addable.ALL;
/*     */   }
/*     */   
/*     */   public boolean renderOnGround(Renderer r, RenderData data, int zoomout) {
/*     */     this.added = false;
/*     */     Addable aa = getUnder();
/*     */     for (Addable a : Addable.ALL)
/*     */       a.added = false; 
/*     */     if (aa == null)
/*     */       return false; 
/*     */     r.newLayer(true, zoomout);
/*     */     RenderData.RenderIterator it = data.onScreenTiles();
/*     */     aa.initBelow(data);
/*     */     while (it.has()) {
/*     */       aa.renderBelow(r, it);
/*     */       it.next();
/*     */     } 
/*     */     aa.finishBelow();
/*     */     COLOR.unbind();
/*     */     return true;
/*     */   }
/*     */   
/*     */   private Addable getUnder() {
/*     */     Addable aa = null;
/*     */     for (Addable a : Addable.ALL) {
/*     */       if (a.added && a.under)
/*     */         aa = a; 
/*     */     } 
/*     */     return aa;
/*     */   }
/*     */   
/*     */   private void prune() {
/*     */     Addable aa = null;
/*     */     for (Addable a : Addable.ALL) {
/*     */       if (a.added && a.exclusive) {
/*     */         if (aa != null)
/*     */           a.added = false; 
/*     */         aa = a;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderAbove(Renderer r, RenderData data, int zoomout) {
/*     */     if (this.tmp == null || this.tmp.max() != Addable.ALL.size())
/*     */       this.tmp = new ArrayList(Addable.ALL.size()); 
/*     */     this.tmp.clear();
/*     */     prune();
/*     */     for (Addable a : Addable.ALL) {
/*     */       if (a.added && a.above) {
/*     */         a.initAbove(data);
/*     */         this.tmp.add(a);
/*     */       } 
/*     */     } 
/*     */     r.newLayer(true, zoomout);
/*     */     RenderData.RenderIterator it = data.onScreenTiles();
/*     */     while (it.has()) {
/*     */       for (Addable a : this.tmp) {
/*     */         if (a.render(r, it))
/*     */           break; 
/*     */       } 
/*     */       it.next();
/*     */     } 
/*     */     for (Addable a : this.tmp)
/*     */       a.finishAbove(); 
/*     */     ents(r, data);
/*     */   }
/*     */   
/*     */   private void ents(Renderer r, RenderData data) {
/*     */     if (this.objects.size() == 0 && this.rooms.getI() == 0 && this.tiles.size() == 0)
/*     */       return; 
/*     */     for (int i = 0; i < this.objects.size(); i++) {
/*     */       this.colors[i].bind();
/*     */       BODY_HOLDER e = (BODY_HOLDER)this.objects.get(i);
/*     */       (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, e.body().x1() - data.offX1(), e.body().y1() - data.offY1(), e.body().width(), e.body().height());
/*     */     } 
/*     */     this.objects.clear();
/*     */     int rI = this.rooms.getI();
/*     */     for (int j = 0; j < rI; j++) {
/*     */       COORDINATEE cOORDINATEE = this.rooms.set(j);
/*     */       Room room = (Room)(SETT.ROOMS()).map.get((COORDINATE)cOORDINATEE);
/*     */       if (room != null) {
/*     */         if ((GAME.ARMIES()).map.army.get(room.mX(cOORDINATEE.x(), cOORDINATEE.y()), room.mY(cOORDINATEE.x(), cOORDINATEE.y())) == GAME.ARMIES().enemy()) {
/*     */           COLOR.RED2RED.bind();
/*     */         } else {
/*     */           (GCOLOR.MAP()).OK_2_BETTER.bind();
/*     */         } 
/*     */         int x1 = room.x1(cOORDINATEE.x(), cOORDINATEE.y());
/*     */         int x2 = x1 + room.width(cOORDINATEE.x(), cOORDINATEE.y());
/*     */         int y1 = room.y1(cOORDINATEE.x(), cOORDINATEE.y());
/*     */         int y2 = y1 + room.height(cOORDINATEE.x(), cOORDINATEE.y());
/*     */         int mx = room.mX(cOORDINATEE.x(), cOORDINATEE.y());
/*     */         int my = room.mY(cOORDINATEE.x(), cOORDINATEE.y());
/*     */         for (int ty = y1 - 1; ty <= y2; ty++) {
/*     */           for (int tx = x1 - 1; tx <= x2; tx++) {
/*     */             if (!room.isSame(mx, my, tx, ty)) {
/*     */               int m = 0;
/*     */               for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*     */                 DIR d = (DIR)DIR.ORTHO.get(di);
/*     */                 if (!room.isSame(mx, my, tx + d.x(), ty + d.y()))
/*     */                   m |= d.mask(); 
/*     */               } 
/*     */               if (m != 15) {
/*     */                 int x = tx * 64 - data.offX1();
/*     */                 int y = ty * 64 - data.offY1();
/*     */                 (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)r, m, x, y);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     this.rooms.set(0);
/*     */     COLOR.unbind();
/*     */     for (ON_TOP_TILE t : this.tiles)
/*     */       t.render(r, (ShadowBatch)null, data); 
/*     */     this.tiles.clearSloppy();
/*     */   }
/*     */   
/*     */   public Addable envThing(SettEnvMap.SettEnv t) {
/*     */     return (Addable)this.envs.get(t.index());
/*     */   }
/*     */   
/*     */   public void add(int rx, int ry) {
/*     */     if (this.rooms.getI() < this.rooms.size() - 1) {
/*     */       this.rooms.set(this.rooms.getI()).set(rx, ry);
/*     */       this.rooms.set(this.rooms.getI() + 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void add(ENTITY e) {
/*     */     if (e instanceof Humanoid) {
/*     */       Humanoid a = (Humanoid)e;
/*     */       if (a.indu().hostile()) {
/*     */         add((BODY_HOLDER)e, UIMinimapSettConfig.colHostile);
/*     */       } else {
/*     */         add((BODY_HOLDER)e, UIMinimapSettConfig.colNormal);
/*     */       } 
/*     */     } else {
/*     */       add((BODY_HOLDER)e, UIMinimapSettConfig.colAnimal);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void add(THINGS.Thing t) {
/*     */     add((BODY_HOLDER)t, COLOR.WHITE2WHITE);
/*     */   }
/*     */   
/*     */   public void add(HalfEntity t) {
/*     */     add((BODY_HOLDER)t, COLOR.WHITE2WHITE);
/*     */   }
/*     */   
/*     */   public void add(ON_TOP_TILE t) {
/*     */     if (this.tiles.contains(t))
/*     */       return; 
/*     */     this.tiles.add(t);
/*     */   }
/*     */   
/*     */   public void add(BODY_HOLDER object, COLOR c) {
/*     */     if (!this.objects.hasRoom())
/*     */       return; 
/*     */     this.objects.add(object);
/*     */     int i = this.objects.size() - 1;
/*     */     this.colors[i] = c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\SettOverlay.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */