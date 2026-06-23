/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FResources;
/*     */ import init.constant.C;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.STOCKPILE;
/*     */ import init.sprite.SPRITES;
/*     */ import init.structure.STRUCTURES;
/*     */ import init.structure.Structure;
/*     */ import init.type.BUILDING_PREFS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JobBuildStructure
/*     */ {
/*  57 */   private static CharSequence ¤¤WallD = "¤Walls can be used to fence off areas.";
/*  58 */   private static CharSequence ¤¤CeilingD = "¤Ceilings can house rooms inside them and protects subjects from the elements.";
/*  59 */   private static CharSequence ¤¤Structure = "¤{0} Room.";
/*  60 */   private static CharSequence ¤¤StructureD = "A combination tool that makes ceilings surrounded by walls of a chosen material.";
/*     */   
/*  62 */   private static CharSequence ¤¤Convert = "Convert";
/*  63 */   private static CharSequence ¤¤ConvertD = "Convert existing structures into this type.";
/*  64 */   private static CharSequence ¤¤ConvertR = "Not enough resources in warehouses.";
/*     */   
/*  66 */   private static CharSequence ¤¤SameProblem = "Must be placed on a structure of a different type.";
/*     */   
/*  68 */   private static CharSequence ¤¤constructions = "Construction Seconds"; public final Structure building;
/*     */   
/*     */   static {
/*  71 */     D.ts(JobBuildStructure.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final TBuilding terrain;
/*     */   
/*     */   public final Job wall;
/*     */   
/*     */   public final Job ceiling;
/*     */   public final PlacableMulti combo;
/*     */   public final PlacableMulti convert;
/*     */   
/*     */   private JobBuildStructure(Structure building) {
/*  84 */     this.building = building;
/*  85 */     this.terrain = (SETT.TERRAIN()).BUILDINGS.get(building);
/*  86 */     this.wall = new Wall();
/*  87 */     this.ceiling = new Roof();
/*  88 */     this.combo = new Combo();
/*  89 */     this.convert = new Convert();
/*     */   }
/*     */ 
/*     */   
/*     */   static LIST<JobBuildStructure> make() {
/*  94 */     ArrayList<JobBuildStructure> all = new ArrayList(STRUCTURES.all().size());
/*  95 */     for (Structure s : STRUCTURES.all()) {
/*  96 */       all.add(new JobBuildStructure(s));
/*     */     }
/*  98 */     return (LIST<JobBuildStructure>)all;
/*     */   }
/*     */   
/*     */   private final class Wall
/*     */     extends JobBuild
/*     */   {
/*     */     Wall() {
/* 105 */       super("WALL_" + JobBuildStructure.this.building.key, JobBuildStructure.this.building.resource, JobBuildStructure.this.building.resAmount + 1, true, JobBuildStructure.this.building.nameWall, JobBuildStructure.¤¤WallD, JobBuildStructure.this.terrain.wall.getIcon());
/*     */     }
/*     */ 
/*     */     
/*     */     void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 110 */       for (DIR d : DIR.ORTHO) {
/* 111 */         Job j = (Job)(SETT.JOBS()).getter.get(tx, ty, d);
/* 112 */         if (j instanceof Wall || JobBuildStructure.this.terrain.wall.is(tx, ty))
/* 113 */           mask |= d.mask(); 
/*     */       } 
/* 115 */       (SPRITES.cons()).BIG.dashedThick.render(r, mask, x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 120 */       if ((SETT.ROOMS()).map.is(tx, ty)) {
/* 121 */         return PlacableMessages.¤¤ROOM_BLOCK;
/*     */       }
/* 123 */       if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty)) {
/* 124 */         return PlacableMessages.¤¤MOUNTAIN_NOT;
/*     */       }
/* 126 */       Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 127 */       if (t == (SETT.TERRAIN()).WATER.DEEP) {
/* 128 */         return PlacableMessages.¤¤MISC;
/*     */       }
/* 130 */       if (t.clearing().needs() && !t.clearing().can())
/* 131 */         return PlacableMessages.¤¤MISC; 
/* 132 */       if ((SETT.JOBS()).getter.get(tx, ty) == this)
/* 133 */         return PLACABLE.E; 
/* 134 */       if (t == JobBuildStructure.this.terrain.wall)
/* 135 */         return PLACABLE.E; 
/* 136 */       if (!overwrite && 
/* 137 */         (SETT.JOBS()).getter.is(tx, ty)) {
/* 138 */         return PlacableMessages.¤¤JOB_BLOCK;
/*     */       }
/*     */       
/* 141 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean terrainNeedsClear(int tx, int ty) {
/* 146 */       if (JobBuildStructure.this.terrain.roof.is(tx, ty))
/* 147 */         return false; 
/* 148 */       return super.terrainNeedsClear(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean resNeeds(int tx, int ty) {
/* 153 */       if (JobBuildStructure.this.terrain.roof.is(tx, ty))
/* 154 */         return (this.res != null && (SETT.JOBS()).progress.get(tx + ty * SETT.TWIDTH) == 0); 
/* 155 */       return super.resNeeds(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double constructionTime(Humanoid skill) {
/* 160 */       return CLAMP.d(JobBuildStructure.this.building.constructTime * 50.0D, 1.0D, 1500.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SoundRace constructSound() {
/* 165 */       return JobBuildStructure.this.terrain.sound;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean construct(int tx, int ty) {
/* 170 */       if (JobBuildStructure.this.building.resource != null)
/* 171 */         GAME.player().res().inc(JobBuildStructure.this.building.resource, FResources.RTYPE.CONSTRUCTION, -(JobBuildStructure.this.building.resAmount + 1)); 
/* 172 */       JobBuildStructure.this.terrain.wall.placeFixed(tx, ty);
/* 173 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean becomesSolid() {
/* 178 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isConstruction() {
/* 183 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public Terrain.TerrainTile becomes(int tx, int ty) {
/* 188 */       return (Terrain.TerrainTile)JobBuildStructure.this.terrain.wall;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void extraHovInfo(GBox box) {
/* 193 */       box.textLL(JobBuildStructure.¤¤constructions);
/* 194 */       box.add((SPRITE)GFORMAT.i(box.text(), (int)constructionTime((Humanoid)null)));
/*     */     }
/*     */ 
/*     */     
/*     */     public ToolConfig config() {
/* 199 */       return JobBuildStructure.con(JobBuildStructure.this, placer());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private final class Roof
/*     */     extends JobBuild
/*     */   {
/*     */     Roof() {
/* 208 */       super("CEILING_" + JobBuildStructure.this.building.key, JobBuildStructure.this.building.resource, JobBuildStructure.this.building.resAmount, false, JobBuildStructure.this.building.nameCeiling, JobBuildStructure.¤¤CeilingD, JobBuildStructure.this.terrain.roof.getIcon());
/*     */     }
/*     */ 
/*     */     
/*     */     void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 213 */       for (DIR d : DIR.ORTHO) {
/* 214 */         Job j = (Job)(SETT.JOBS()).getter.get(tx, ty, d);
/* 215 */         if (j instanceof JobBuildStructure.Wall || j instanceof Roof || JobBuildStructure.this.terrain.roof.is(tx, ty))
/* 216 */           mask |= d.mask(); 
/*     */       } 
/* 218 */       (SPRITES.cons()).BIG.dashed.render(r, mask, x, y);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 224 */       if (SETT.TERRAIN().get(tx, ty) == (SETT.TERRAIN()).WATER.DEEP) {
/* 225 */         return PlacableMessages.¤¤MISC;
/*     */       }
/* 227 */       if (JobBuildStructure.this.terrain.wall.is(tx, ty) && overwrite)
/* 228 */         return null; 
/* 229 */       return super.problem(tx, ty, overwrite);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double constructionTime(Humanoid skill) {
/* 234 */       return 1.0D + JobBuildStructure.this.building.constructTime * 140.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     protected SoundRace constructSound() {
/* 239 */       return JobBuildStructure.this.terrain.sound;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean terrainNeedsClear(int tx, int ty) {
/* 244 */       if (JobBuildStructure.this.terrain.wall.is(tx, ty))
/* 245 */         return false; 
/* 246 */       return super.terrainNeedsClear(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean resNeeds(int tx, int ty) {
/* 251 */       if (JobBuildStructure.this.terrain.wall.is(tx, ty))
/* 252 */         return false; 
/* 253 */       return super.resNeeds(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean construct(int tx, int ty) {
/* 258 */       if (JobBuildStructure.this.building.resource != null)
/* 259 */         GAME.player().res().inc(JobBuildStructure.this.building.resource, FResources.RTYPE.CONSTRUCTION, -JobBuildStructure.this.building.resAmount); 
/* 260 */       JobBuildStructure.this.terrain.roof.placeFixed(tx, ty);
/* 261 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isConstruction() {
/* 266 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public Terrain.TerrainTile becomes(int tx, int ty) {
/* 271 */       return (Terrain.TerrainTile)JobBuildStructure.this.terrain.roof;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void extraHovInfo(GBox box) {
/* 276 */       box.textLL(JobBuildStructure.¤¤constructions);
/* 277 */       box.add((SPRITE)GFORMAT.i(box.text(), (int)constructionTime(null)));
/*     */     }
/*     */ 
/*     */     
/*     */     public ToolConfig config() {
/* 282 */       return JobBuildStructure.con(JobBuildStructure.this, placer());
/*     */     }
/*     */   }
/*     */   
/*     */   private final class Combo
/*     */     extends PlacableMulti
/*     */   {
/*     */     public Combo() {
/* 290 */       super((CharSequence)(new Str(JobBuildStructure.¤¤Structure)).insert(0, JobBuildStructure.this.building.name), JobBuildStructure.¤¤StructureD, JobBuildStructure.this.terrain.iconCombo);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 295 */       if (isWall(tx, ty, a))
/* 296 */         return JobBuildStructure.this.wall.placer().isPlacable(tx, ty, a, t); 
/* 297 */       return JobBuildStructure.this.ceiling.placer().isPlacable(tx, ty, a, t);
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 302 */       if (isWall(tx, ty, a)) {
/* 303 */         JobBuildStructure.this.wall.placer().place(tx, ty, a, t);
/*     */       } else {
/* 305 */         JobBuildStructure.this.ceiling.placer().place(tx, ty, a, t);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA a, PLACER_TYPE t, boolean isPlacable, boolean areaIsPlacable) {
/* 311 */       if (isWall(tx, ty, a)) {
/* 312 */         JobBuildStructure.this.wall.renderAbove(r, x, y, mask, tx, ty);
/*     */       } else {
/* 314 */         JobBuildStructure.this.ceiling.renderAbove(r, x, y, mask, tx, ty);
/*     */       } 
/*     */     }
/*     */     private boolean isWall(int tx, int ty, AREA a) {
/* 318 */       for (DIR d : DIR.ALL) {
/* 319 */         if (!a.is(tx, ty, d)) {
/* 320 */           int y1 = a.body().y1();
/* 321 */           int y2 = a.body().y2();
/* 322 */           int x1 = a.body().x1();
/* 323 */           int x2 = a.body().x2();
/* 324 */           if ((a.body().height() & 0x1) == 1) {
/* 325 */             y1 = a.body().cY();
/* 326 */             y2 = a.body().cY();
/*     */           } else {
/* 328 */             y1 = a.body().cY() - 1;
/* 329 */             y2 = a.body().cY();
/*     */           } 
/*     */           
/* 332 */           if ((a.body().width() & 0x1) == 1) {
/* 333 */             x1 = a.body().cX();
/* 334 */             x2 = a.body().cX();
/*     */           } else {
/* 336 */             x1 = a.body().cX() - 1;
/* 337 */             x2 = a.body().cX();
/*     */           } 
/*     */           
/* 340 */           return ((tx < x1 || tx > x2) && (ty < y1 || ty > y2));
/*     */         } 
/*     */       } 
/* 343 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canBePlacedAs(PLACER_TYPE t) {
/* 348 */       return (t != PLACER_TYPE.LINE);
/*     */     }
/*     */ 
/*     */     
/*     */     public PLACABLE getUndo() {
/* 353 */       return JobBuildStructure.this.wall.placer().getUndo();
/*     */     } }
/*     */   
/*     */   private final class Convert extends PlacableMulti {
/*     */     boolean count;
/*     */     
/*     */     public Convert() {
/* 360 */       super(JobBuildStructure.¤¤Convert, JobBuildStructure.¤¤ConvertD, (SPRITE)new SPRITE.Twin(JobBuildStructure.this.terrain.wall.getIcon(), (SPRITE)(SPRITES.icons()).m.arrow_right));
/*     */ 
/*     */ 
/*     */       
/* 364 */       this.count = true;
/* 365 */       this.res = 0;
/* 366 */       this.allocated = 0;
/*     */     }
/*     */     int res; int allocated;
/*     */     public void updateRegardless(GameWindow window, AREA selected) {
/* 370 */       this.count = true;
/* 371 */       this.res = 0;
/* 372 */       this.allocated = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void finishChecking(AREA placedArea) {
/* 377 */       this.count = false;
/* 378 */       super.finishChecking(placedArea);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 384 */       Terrain.TerrainTile te = SETT.TERRAIN().get(tx, ty);
/* 385 */       if (te == null || !(te instanceof TBuilding.BuildingComponent))
/* 386 */         return JobBuildStructure.¤¤SameProblem; 
/* 387 */       if (JobBuildStructure.this.terrain.isser.is(tx, ty)) {
/* 388 */         return JobBuildStructure.¤¤SameProblem;
/*     */       }
/* 390 */       if (this.count) {
/* 391 */         if (te instanceof TBuilding.Wall && (((TBuilding.Wall)te).building()).wall == te && JobBuildStructure.this.wall.res() != null) {
/* 392 */           this.res += JobBuildStructure.this.wall.resAmount();
/* 393 */         } else if ((te instanceof TBuilding.Ceiling || te instanceof TBuilding.Ceiling.Opening) && JobBuildStructure.this.ceiling.res() != null) {
/* 394 */           this.res += JobBuildStructure.this.ceiling.resAmount();
/*     */         } 
/* 396 */         if (this.res >= ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())) {
/* 397 */           return JobBuildStructure.¤¤ConvertR;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 402 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void finishPlacing(AREA placedArea) {
/* 407 */       if (this.res > 1) {
/* 408 */         STOCKPILE.StockpileImp stock = new STOCKPILE.StockpileImp();
/* 409 */         stock.set(JobBuildStructure.this.wall.res(), this.res - 1);
/* 410 */         this.res = 0;
/* 411 */         this.allocated = 0;
/* 412 */         RESOURCE.remove(stock, FResources.RTYPE.CONSTRUCTION);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 419 */       if (JobBuildStructure.this.terrain.isser.is(tx, ty))
/*     */         return; 
/* 421 */       Terrain.TerrainTile te = SETT.TERRAIN().get(tx, ty);
/* 422 */       if (te instanceof TBuilding.Wall && (((TBuilding.Wall)te).building()).wall == te && this.allocated + JobBuildStructure.this.wall.resAmount() < ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())) {
/* 423 */         JobBuildStructure.this.terrain.wall.placeFixed(tx, ty);
/* 424 */         this.allocated += JobBuildStructure.this.wall.resAmount();
/*     */       }
/* 426 */       else if ((te instanceof TBuilding.Ceiling || te instanceof TBuilding.Ceiling.Opening) && this.allocated + JobBuildStructure.this.ceiling.resAmount() < ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())) {
/* 427 */         JobBuildStructure.this.terrain.roof.placeFixed(tx, ty);
/* 428 */         this.allocated += JobBuildStructure.this.ceiling.resAmount();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public PLACABLE getUndo() {
/* 434 */       return (PLACABLE)(SETT.JOBS()).tool_clear;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void placeInfo(GBox b, int oktiles, AREA a) {
/* 441 */       if (JobBuildStructure.this.wall.res() != null) {
/* 442 */         b.add((SPRITE)JobBuildStructure.this.wall.res().icon());
/* 443 */         b.add((SPRITE)GFORMAT.iofk(b.text(), this.res, ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())));
/*     */       } 
/* 445 */       super.placeInfo(b, oktiles, a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 450 */   private static Con pla = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ToolConfig con(JobBuildStructure struc, PlacableMulti job) {
/* 463 */     if (pla == null)
/* 464 */       pla = new Con(); 
/* 465 */     return pla.get(struc, job);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Job getPlacable() {
/* 470 */     if (pla == null)
/* 471 */       pla = new Con(); 
/* 472 */     if (pla.struc.wall == null || pla.struc.wall.lockText() != null)
/* 473 */       for (JobBuildStructure j : (SETT.JOBS()).build_structure) {
/* 474 */         if (j.wall.lockText() == null) {
/* 475 */           return j.wall;
/*     */         }
/*     */       }  
/* 478 */     return pla.struc.wall;
/*     */   }
/*     */   
/*     */   private static class Con
/*     */     implements ToolConfig {
/* 483 */     private final LinkedList<CLICKABLE> butts = new LinkedList();
/*     */     private JobBuildStructure struc;
/* 485 */     private int type = 0;
/*     */     PlacableMulti job;
/* 487 */     private final GuiSection section = new GuiSection();
/* 488 */     private GuiSection full = new GuiSection();
/* 489 */     private final GPanel panel = new GPanel();
/*     */     
/* 491 */     ACTION exit = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 495 */           (VIEW.s()).tools.placer.deactivate();
/*     */         }
/*     */       };
/*     */     
/*     */     public ToolConfig get(JobBuildStructure struc, PlacableMulti job) {
/* 500 */       if (job == struc.combo) {
/* 501 */         this.type = 0;
/* 502 */       } else if (job == struc.wall.placer()) {
/* 503 */         this.type = 1;
/* 504 */       } else if (job == struc.ceiling.placer()) {
/* 505 */         this.type = 2;
/*     */       } else {
/* 507 */         this.type = 3;
/* 508 */       }  this.struc = struc;
/* 509 */       this.job = job;
/* 510 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     Con() {
/* 515 */       this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wallceiling)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 519 */               JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.combo;
/* 520 */               JobBuildStructure.Con.this.type = 0;
/* 521 */               (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 526 */               JobBuildStructure.Con.this.struc.combo.hoverDesc((GBox)text);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 531 */               selectedSet((JobBuildStructure.Con.this.type == 0));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 536 */       this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wall)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 540 */               JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.wall.placer();
/* 541 */               JobBuildStructure.Con.this.type = 1;
/* 542 */               (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 547 */               JobBuildStructure.Con.this.struc.wall.placer().hoverDesc((GBox)text);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 552 */               selectedSet((JobBuildStructure.Con.this.type == 1));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 557 */       this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wall_opening)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 561 */               JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.ceiling.placer();
/* 562 */               JobBuildStructure.Con.this.type = 2;
/* 563 */               (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 568 */               JobBuildStructure.Con.this.struc.ceiling.placer().hoverDesc((GBox)text);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 573 */               selectedSet((JobBuildStructure.Con.this.type == 2));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 578 */       this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 582 */               JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.convert;
/* 583 */               JobBuildStructure.Con.this.type = 3;
/* 584 */               (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 589 */               JobBuildStructure.Con.this.struc.convert.hoverDesc((GBox)text);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 594 */               selectedSet((JobBuildStructure.Con.this.type == 3));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 599 */       for (JobBuildStructure j : (SETT.JOBS()).build_structure) {
/*     */ 
/*     */         
/* 602 */         GButt.ButtPanel b = new GButt.ButtPanel(j.wall.placer().getIcon())
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 606 */               JobBuildStructure.Con.this.setStruc(j);
/* 607 */               (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 612 */               text.title(j.building.name);
/* 613 */               text.text(j.building.desc);
/* 614 */               GBox b = (GBox)text;
/* 615 */               b.NL();
/* 616 */               if (j.building.resource != null) {
/* 617 */                 b.setResource(j.building.resource, (j.building.resAmount + 1));
/*     */               }
/* 619 */               b.NL(8);
/*     */               
/* 621 */               for (Race r : RACES.all()) {
/* 622 */                 double d = r.pref().structure(BUILDING_PREFS.get(j.building));
/* 623 */                 int k = 1 + (int)(5.0D * d);
/* 624 */                 if ((r.index & 0x3) == 0)
/* 625 */                   b.NL(); 
/* 626 */                 b.tab((r.index & 0x3) * 3);
/* 627 */                 b.add((SPRITE)(r.appearance()).icon);
/* 628 */                 ColorImp.TMP.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD.hovered, d);
/* 629 */                 for (int i = 0; i < k; i++) {
/* 630 */                   b.add((SPRITE)(SPRITES.icons()).s.heart, (COLOR)ColorImp.TMP);
/* 631 */                   b.rewind(8);
/*     */                 } 
/* 633 */                 b.space();
/*     */               } 
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 641 */               selectedSet((JobBuildStructure.Con.this.struc == j));
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 646 */         this.section.addRightC(0, (RENDEROBJ)b);
/* 647 */         if (j.wall.lockText() == null) {
/* 648 */           this.struc = j;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     void setStruc(JobBuildStructure struc) {
/* 654 */       this.struc = struc;
/* 655 */       switch (this.type) { case 0:
/* 656 */           this.job = struc.combo; break;
/* 657 */         case 1: this.job = struc.wall.placer(); break;
/* 658 */         case 2: this.job = struc.ceiling.placer(); break;
/* 659 */         case 3: this.job = struc.convert;
/*     */           break; }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void addUI(LISTE<RENDEROBJ> uis) {
/* 667 */       this.full.clear();
/*     */       
/* 669 */       (VIEW.s()).tools.placer.stealButtons(this.full);
/* 670 */       for (CLICKABLE c : this.butts) {
/* 671 */         this.full.addRightC(0, (RENDEROBJ)c);
/*     */       }
/* 673 */       if (this.job.getAdditionalButt() != null)
/* 674 */         for (CLICKABLE p : this.job.getAdditionalButt())
/* 675 */           this.full.addRightC(0, (RENDEROBJ)p);  
/* 676 */       this.full.body().centerX(C.DIM());
/* 677 */       this.full.addRelBody(8, DIR.N, (RENDEROBJ)this.section);
/*     */       
/* 679 */       this.panel.setButt();
/* 680 */       this.panel.inner().set((BODY_HOLDER)this.full);
/* 681 */       this.panel.clickActionSet(this.exit);
/* 682 */       this.full.add((RENDEROBJ)this.panel);
/* 683 */       this.full.moveLastToBack();
/* 684 */       this.full.body().moveY1(90.0D);
/* 685 */       uis.add(this.full);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildStructure.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */