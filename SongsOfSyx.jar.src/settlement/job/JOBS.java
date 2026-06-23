/*     */ package settlement.job;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.map.MAP_SETTER;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.COLOR_MAP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.BOOLEAN;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPSAVE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JOBS
/*     */   extends SETT.SettResource
/*     */ {
/*  46 */   private final Bitsmap2D map = new Bitsmap2D(0, 12, SETT.TWIDTH, SETT.THEIGHT);
/*  47 */   private final Bitsmap1D statei = new Bitsmap1D(-1, 2, SETT.TAREA);
/*     */   
/*  49 */   public Bitsmap2D paintmap = new Bitsmap2D(0, 3, SETT.TWIDTH, SETT.THEIGHT);
/*     */   
/*  51 */   public final BOOLEAN.BOOLEAN_MUTABLE planMode = new BOOLEAN.BOOLEAN_MUTABLE()
/*     */     {
/*     */       private boolean i = false;
/*     */ 
/*     */       
/*     */       public boolean is() {
/*  57 */         return this.i;
/*     */       }
/*     */ 
/*     */       
/*     */       public BOOLEAN.BOOLEAN_MUTABLE set(boolean b) {
/*  62 */         this.i = b;
/*  63 */         return this;
/*     */       }
/*     */     };
/*     */   
/*  67 */   private int hoverI = -1;
/*     */   
/*  69 */   final Bitsmap1D progress = new Bitsmap1D(0, 3, SETT.TAREA);
/*  70 */   final Bitmap1D wantsRes = new Bitmap1D(SETT.TAREA, false);
/*  71 */   final StateManager state = new StateManager(this.statei);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_OBJECT<Job> getter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   public final PlacableMulti tool_clear = new PlacerDelete();
/*  89 */   public final PlacableMulti tool_activate = new PlacerActivate();
/*  90 */   public final PlacableMulti tool_dormant = new PlacerDormant();
/*  91 */   public final PlacableMulti tool_remove_all = new PlacerRemoveAll();
/*  92 */   public final PlacableMulti tool_remove_smartl = new PlacerRemoveSmart();
/*  93 */   public final MAP_OBJECT<Job> jobGetter = new JobGetter();
/*  94 */   final JobRoom room = new JobRoom(null);
/*  95 */   final JobRoom[] rooms = new JobRoom[RESOURCES.ALL().size()];
/*     */   
/*     */   public final PlacableMulti tool_repair;
/*     */   
/*     */   public final JobBuildRoad.JobBuildRoads roads;
/*     */   
/*     */   public final LIST<JobBuildStructure> build_structure;
/*     */   
/*     */   public final JobBuildFort.JobBuildForts build_fort;
/*     */   
/*     */   public final LIST<Job> fences;
/*     */   
/*     */   public final JobClears clearss;
/*     */   public final LIST<PLACABLE> clears;
/*     */   public final BlockedJobs blocked;
/*     */   public final MAP_SETTER clearer;
/*     */   
/*     */   public JOBS() {
/* 113 */     super("JOBS", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     for (int i = 0; i < this.rooms.length; i++) {
/*     */       this.rooms[i] = new JobRoom((RESOURCE)RESOURCES.ALL().get(i));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.tool_repair = new PlacerRepair();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.roads = new JobBuildRoad.JobBuildRoads();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.build_structure = JobBuildStructure.make();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.build_fort = new JobBuildFort.JobBuildForts();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.fences = JobBuildFence.make();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.clearss = new JobClears();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.clears = (LIST<PLACABLE>)new ArrayList((Object[])this.clearss.placers);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.blocked = new BlockedJobs();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 340 */     this.clearer = new MAP_SETTER()
/*     */       {
/*     */         public MAP_SETTER set(int tx, int ty)
/*     */         {
/* 344 */           PlacerDelete.place(tx, ty);
/* 345 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_SETTER set(int tile) {
/* 350 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */     this.getter = new MAP_OBJECT<Job>() {
/*     */         public Job get(int tx, int ty) {
/*     */           if (!SETT.IN_BOUNDS(tx, ty))
/*     */             return null; 
/*     */           int i = JOBS.this.map.get(tx, ty);
/*     */           if (i != 0) {
/*     */             Job j = (Job)Job.all.get(i - 1);
/*     */             if (!j.get(tx, ty)) {
/*     */               PlacerDelete.place(tx, ty);
/*     */               return null;
/*     */             } 
/*     */             return j;
/*     */           } 
/*     */           return null;
/*     */         }
/*     */         
/*     */         public Job get(int tile) {
/*     */           return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */         }
/*     */         
/*     */         public boolean is(int tile) {
/*     */           int i = JOBS.this.map.get(tile);
/*     */           return (i != 0);
/*     */         }
/*     */         
/*     */         public boolean is(int tx, int ty) {
/*     */           if (!SETT.IN_BOUNDS(tx, ty))
/*     */             return false; 
/*     */           return is(tx + ty * SETT.TWIDTH);
/*     */         }
/*     */       };
/*     */     (new ON_TOP_RENDERABLE() {
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/*     */           RenderData.RenderIterator i = data.onScreenTiles();
/*     */           COLOR_MAP c = GCOLOR.MAP();
/*     */           while (i.has()) {
/*     */             int index = JOBS.this.map.get(i.tile());
/*     */             if (index != 0) {
/*     */               index--;
/*     */               if (i.tile() == JOBS.this.hoverI) {
/*     */                 COLOR.WHITE2WHITE.bind();
/*     */               } else {
/*     */                 switch (JOBS.this.state.get(i.tile())) {
/*     */                   case DORMANT:
/*     */                     c.DORMANT.bind();
/*     */                     break;
/*     */                   case RESERVABLE:
/*     */                     c.JOB_ACTIVE.bind();
/*     */                     break;
/*     */                   case RESERVED:
/*     */                     c.JOB_RESERVED.bind();
/*     */                     break;
/*     */                   case null:
/*     */                     c.JOB_BLOCKED.bind();
/*     */                     break;
/*     */                 } 
/*     */               } 
/*     */               Job j = (Job)Job.all.get(index);
/*     */               if (j != null) {
/*     */                 j.renderAbove((SPRITE_RENDERER)r, i.x(), i.y(), 0, i.tx(), i.ty());
/*     */                 if (CORE.renderer().getZoomout() <= 1) {
/*     */                   j.get(i.tx(), i.ty());
/*     */                   RESOURCE res = j.resourceCurrentlyNeeded();
/*     */                   if ((j == JOBS.this.clearss.food && !(SETT.WEATHER()).growthRipe.cropsAreRipe()) || (res != null && !j.jobReservedIs(res) && !(SETT.PATH()).finders.resource.normal.has(i.tx(), i.ty(), res))) {
/*     */                     COLOR.WHITE702WHITE100.bind();
/*     */                     (SPRITES.cons()).ICO.warning.render((SPRITE_RENDERER)r, i.x(), i.y());
/*     */                     COLOR.unbind();
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } else if (SETT.TERRAIN().get(i.tile()) instanceof TGrowable && ((TGrowable)(SETT.TERRAIN()).GROWABLES.get(0)).job.is(i.tile())) {
/*     */               if (i.tile() == JOBS.this.hoverI) {
/*     */                 COLOR.WHITE2WHITE.bind();
/*     */               } else {
/*     */                 c.DORMANT.bind();
/*     */               } 
/*     */               (SPRITES.cons()).BIG.dashed_hollow.render((SPRITE_RENDERER)r, 0, i.x(), i.y());
/*     */             } 
/*     */             i.next();
/*     */           } 
/*     */           COLOR.unbind();
/*     */         }
/*     */       }).add();
/*     */     clear();
/*     */     KeyMap<Job> map = new KeyMap();
/*     */     for (Job j : Job.all)
/*     */       map.put(j.key(), j); 
/*     */   }
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/*     */     RenderData.RenderIterator i = data.onScreenTiles();
/*     */     while (i.has()) {
/*     */       int index = this.map.get(i.tile());
/*     */       if (index != 0)
/*     */         ((Job)Job.all.get(index - 1)).renderBelow(r, shadowBatch, i, this.progress.get(i.tile())); 
/*     */       i.next();
/*     */     } 
/*     */   }
/*     */   
/*     */   void set(Job job, int tx, int ty) {
/*     */     this.map.set(tx, ty, (job == null) ? 0 : (job.index() + 1));
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*     */     this.map.save(saveFile);
/*     */     MAPSAVE.saveMeta(saveFile, (LIST)Job.all);
/*     */     this.statei.save(saveFile);
/*     */     this.progress.save(saveFile);
/*     */     this.wantsRes.save(saveFile);
/*     */     this.paintmap.save(saveFile);
/*     */     this.blocked.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*     */     this.map.load(saveFile);
/*     */     int[] oo = MAPSAVE.saveWash(saveFile, (LIST)Job.all, 0);
/*     */     this.statei.load(saveFile);
/*     */     this.progress.load(saveFile);
/*     */     this.wantsRes.load(saveFile);
/*     */     if (oo != null)
/*     */       for (int i = 0; i < SETT.TAREA; i++) {
/*     */         int bb = this.map.get(i);
/*     */         if (bb == 0 || bb < 0 || bb >= oo.length || oo[bb] == 0) {
/*     */           this.map.set(i, 0);
/*     */           this.statei.set(i, 0);
/*     */           this.progress.set(i, 0);
/*     */           this.wantsRes.set(i, false);
/*     */         } 
/*     */       }  
/*     */     this.paintmap.load(saveFile);
/*     */     this.blocked.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clear() {
/*     */     this.map.clear();
/*     */     this.statei.clear();
/*     */     this.progress.clear();
/*     */     this.wantsRes.clear();
/*     */     this.blocked.clear();
/*     */   }
/*     */   
/*     */   protected void init(boolean loaded) {
/*     */     this.clearss.initSpeeds();
/*     */     if (loaded)
/*     */       for (COORDINATE c : SETT.TILE_BOUNDS)
/*     */         this.getter.get(c);  
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/*     */     this.hoverI = -1;
/*     */     this.blocked.update(ds);
/*     */   }
/*     */   
/*     */   public void hover(int tx, int ty, GBox box) {
/*     */     this.hoverI = tx + ty * SETT.TWIDTH;
/*     */     if (this.getter.is(tx, ty)) {
/*     */       Job j = (Job)this.getter.get(tx, ty);
/*     */       this.hoverI = j.tile;
/*     */       j.hover(box);
/*     */       box.NL();
/*     */       box.add((SPRITE)box.text().add(this.state.getDepth(tx, ty)));
/*     */     } else if (SETT.TERRAIN().get(tx, ty) instanceof TGrowable && ((TGrowable)(SETT.TERRAIN()).GROWABLES.get(0)).job.is(tx, ty)) {
/*     */       this.clearss.HoverEdible(box, tx, ty);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JOBS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */