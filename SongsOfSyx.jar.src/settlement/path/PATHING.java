/*     */ package settlement.path;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCOMPONENTS;
/*     */ import settlement.path.components.SCompNLevel;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.finders.SFINDERS;
/*     */ import settlement.path.thread.FinderThread;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import util.data.BOOLEAN;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PATHING
/*     */   extends SETT.SettResource
/*     */ {
/*  35 */   public final CostMethods coster = new CostMethods();
/*  36 */   public final SFINDERS finders = new SFINDERS();
/*     */   
/*  38 */   private BOOLEAN.BOOLEAN_MUTABLE performanceTest = (BOOLEAN.BOOLEAN_MUTABLE)new BOOLEAN.BOOLEANImp(false);
/*     */   
/*  40 */   public final PlayerHuristics huristics = new PlayerHuristics();
/*     */ 
/*     */   
/*  43 */   public final SCOMPONENTS comps = new SCOMPONENTS();
/*  44 */   public final AvailabilityMap availability = new AvailabilityMap(this.comps); public final MAP_BOOLEAN solidity; public final MAP_BOOLEAN reachability;
/*  45 */   public final FinderThread thread = new FinderThread(this.comps); public final MAP_BOOLEAN connectivity; public final MAP_DOUBLE cost;
/*     */   public PATHING() {
/*  47 */     super("PATHING", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     this.solidity = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tile)
/*     */         {
/* 158 */           return ((PATHING.this.availability.get(tile)).player < 0.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty) {
/* 163 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 164 */             return true; 
/* 165 */           return is(tx + ty * SETT.TWIDTH);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     this.reachability = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 176 */           SComponent c = (SComponent)PATHING.this.comps.superComp.get(tx, ty);
/* 177 */           if (c != null && c.is(THRONE.coo()))
/* 178 */             return true; 
/* 179 */           for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 180 */             c = (SComponent)PATHING.this.comps.superComp.get(tx, ty, (DIR)DIR.ORTHO.get(i));
/* 181 */             if (c != null && c.is(THRONE.coo())) {
/* 182 */               return true;
/*     */             }
/*     */           } 
/* 185 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 190 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     this.connectivity = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 202 */           SComponent c = (SComponent)PATHING.this.comps.superComp.get(tx, ty);
/* 203 */           if (c != null && c.is(THRONE.coo()))
/* 204 */             return true; 
/* 205 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 210 */           return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
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
/* 226 */     this.cost = new MAP_DOUBLE()
/*     */       {
/*     */         public double get(int tile)
/*     */         {
/* 230 */           return (PATHING.this.availability.get(tile)).player;
/*     */         }
/*     */         
/*     */         public double get(int tx, int ty)
/*     */         {
/* 235 */           AVAILABILITY a = PATHING.this.availability.get(tx, ty);
/* 236 */           if (a == null)
/* 237 */             return -1.0D; 
/* 238 */           return (PATHING.this.availability.get(tx, ty)).player;
/*     */         }
/*     */       };
/*     */     IDebugPanelSett.add("2100 paths/s", this.performanceTest);
/*     */   } public boolean isInTheNeighbourhood(int tx, int ty, int dx, int dy) {
/* 243 */     SComponent c = ((SCompNLevel)this.comps.levels.get(0)).get(tx, ty);
/* 244 */     if (c == null)
/* 245 */       return false; 
/* 246 */     SComponent d = ((SCompNLevel)this.comps.levels.get(0)).get(dx, dy);
/* 247 */     if (d == null)
/* 248 */       return false; 
/* 249 */     if (c == d)
/* 250 */       return true; 
/* 251 */     SComponentEdge e = c.edgefirst();
/* 252 */     while (e != null) {
/* 253 */       if (e.to() == d)
/* 254 */         return true; 
/* 255 */       e = e.next();
/*     */     } 
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   public SFINDERS finders() {
/*     */     return this.finders;
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*     */     this.thread.stop();
/*     */     this.huristics.saver.save(saveFile);
/*     */     this.thread.start();
/*     */     this.finders.saver.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*     */     this.thread.stop();
/*     */     this.huristics.saver.load(saveFile);
/*     */     this.finders.saver.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clear() {
/*     */     this.thread.stop();
/*     */     this.huristics.saver.clear();
/*     */     this.comps.clear();
/*     */     this.finders.saver.clear();
/*     */   }
/*     */   
/*     */   public boolean willUpdateTile(int tx, int ty) {
/*     */     return this.comps.zero.updating().is(tx, ty);
/*     */   }
/*     */   
/*     */   public boolean willUpdate() {
/*     */     return this.comps.zero.uping();
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/*     */     this.thread.setStop();
/*     */     this.huristics.update(ds);
/*     */     this.finders.update(ds);
/*     */     this.thread.stop();
/*     */     this.comps.update();
/*     */     this.thread.start();
/*     */   }
/*     */   
/*     */   protected void init(boolean loaded) {
/*     */     this.thread.stop();
/*     */     this.availability.init();
/*     */     this.comps.init();
/*     */     this.thread.start();
/*     */   }
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/*     */     if (!SETT.IN_BOUNDS(x, y))
/*     */       return AVAILABILITY.SOLID; 
/*     */     return this.availability.get(x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\PATHING.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */