/*     */ package world.entity;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ADDABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmyConstructor;
/*     */ import world.entity.caravan.Shipments;
/*     */ import world.entity.haven.WHavens;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ public class WEntities
/*     */   extends WORLD.WorldResource
/*     */ {
/*     */   private final ArrayListResize<WEntity> fast;
/*     */   private final ArrayListResize<WEntity> slow;
/*     */   private final _WEntityMap map;
/*  35 */   private final ArrayList<WEntity> tmp = new ArrayList(2056);
/*  36 */   private final ArrayList<WEntityConstructor<?>> constructors = new ArrayList(20);
/*  37 */   private final Rec rectmp = new Rec();
/*     */   
/*  39 */   public final Shipments caravans = new Shipments((LISTE)this.constructors);
/*  40 */   public final WArmyConstructor armies = new WArmyConstructor((LISTE)this.constructors);
/*  41 */   public final WHavens havens = new WHavens((LISTE)this.constructors);
/*  42 */   private double slowUp = 0.0D;
/*     */   
/*  44 */   private final Tree<WEntity> renderables = new Tree<WEntity>(2056)
/*     */     {
/*     */       protected boolean isGreaterThan(WEntity current, WEntity cmp)
/*     */       {
/*  48 */         return (current.getZ() < cmp.getZ());
/*     */       }
/*     */     };
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   public WEntities(WORLD world) throws IOException {
/*  54 */     super("entities", "ENTS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  65 */           for (WEntityConstructor<?> c : WEntities.this.constructors)
/*  66 */             c.save(file); 
/*  67 */           file.d(WEntities.this.slowUp);
/*  68 */           file.i(WEntities.this.fast.size() + WEntities.this.slow.size());
/*  69 */           for (WEntity e : WEntities.this.fast) {
/*  70 */             file.i((e.constructor()).index);
/*  71 */             e.save(file);
/*  72 */             e.hitBox.save(file);
/*     */           } 
/*  74 */           for (WEntity e : WEntities.this.slow) {
/*  75 */             file.i((e.constructor()).index);
/*  76 */             e.save(file);
/*  77 */             e.hitBox.save(file);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  83 */           for (WEntityConstructor<?> c : WEntities.this.constructors)
/*  84 */             c.load(file); 
/*  85 */           WEntities.this.fast.clear();
/*  86 */           WEntities.this.slow.clear();
/*  87 */           WEntities.this.map.clear();
/*  88 */           WEntities.this.slowUp = file.d();
/*  89 */           int am = file.i();
/*     */           
/*  91 */           for (int i = 0; i < am; i++) {
/*  92 */             WEntityConstructor<?> c = (WEntityConstructor)WEntities.this.constructors.get(file.i());
/*  93 */             WEntity e = (WEntity)c.create();
/*  94 */             e = e.load(file);
/*  95 */             e.hitBox.load(file);
/*  96 */             WEntities.this.clear(e);
/*  97 */             e.index = c.fast ? WEntities.this.fast.add(e) : WEntities.this.slow.add(e);
/*  98 */             e.renderNext = null;
/*  99 */             e.regionNext = null;
/* 100 */             e.regionI = -1;
/* 101 */             WEntities.this.map.add(e);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 107 */           for (WEntityConstructor<?> c : WEntities.this.constructors)
/* 108 */             c.clear(); 
/* 109 */           WEntities.this.fast.clear();
/* 110 */           WEntities.this.slow.clear();
/* 111 */           WEntities.this.map.clear();
/*     */         }
/*     */ 
/*     */         
/*     */         public void generate(ACTION loadPrint) {
/* 116 */           clear();
/* 117 */           loadPrint.exe();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 123 */           ArrayListGrower<PLACABLE> res = new ArrayListGrower();
/* 124 */           res.add((Iterable)new Placers(WEntities.this.havens.types));
/* 125 */           return (LIST<PLACABLE>)res; }
/*     */       };
/*     */     this.fast = new ArrayListResize(1024, 64000);
/*     */     this.slow = new ArrayListResize(256, 64000);
/*     */     this.map = new _WEntityMap(WORLD.PWIDTH(), WORLD.PHEIGHT());
/*     */   } public WORLD.WorldResourceManager saver() {
/* 131 */     return this.saver;
/*     */   }
/*     */ 
/*     */   
/*     */   private void clear(WEntity e) {
/* 136 */     e.index = -1;
/* 137 */     e.renderNext = null;
/* 138 */     e.regionNext = null;
/* 139 */     e.regionI = -1;
/* 140 */     e.gridX = -1;
/* 141 */     e.gridY = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canAdd(boolean fast) {
/* 147 */     return fast ? this.fast.hasRoom() : this.slow.hasRoom();
/*     */   }
/*     */   
/*     */   void add(WEntity e) {
/* 151 */     if (e.index != -1)
/* 152 */       throw new RuntimeException(); 
/* 153 */     int i = (e.constructor()).fast ? this.fast.add(e) : this.slow.add(e);
/* 154 */     clear(e);
/* 155 */     e.index = i;
/* 156 */     this.map.add(e);
/*     */   }
/*     */ 
/*     */   
/*     */   WEntity regFirst(Region reg) {
/* 161 */     return this.map.regFirst(reg);
/*     */   }
/*     */   
/*     */   void remove(WEntity e) {
/* 165 */     if (e.index == -1)
/* 166 */       throw new RuntimeException(); 
/* 167 */     this.map.remove(e);
/*     */     
/* 169 */     ArrayListResize<WEntity> ents = (e.constructor()).fast ? this.fast : this.slow;
/*     */     
/* 171 */     WEntity e2 = (WEntity)ents.remove(ents.size() - 1);
/*     */     
/* 173 */     if (e2 != e) {
/* 174 */       ents.replace(e.index, e2);
/* 175 */       e2.index = e.index;
/*     */     } 
/* 177 */     clear(e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds, Profiler prof) {
/* 183 */     prof.logStart(this);
/*     */     
/* 185 */     for (WEntityConstructor<?> c : this.constructors) {
/* 186 */       c.update(ds);
/*     */     }
/*     */     
/* 189 */     for (int i = 0; i < this.fast.size(); i++) {
/* 190 */       WEntity e = (WEntity)this.fast.get(i);
/* 191 */       e.update(ds);
/* 192 */       if (!e.added()) {
/* 193 */         i--;
/*     */       } else {
/* 195 */         this.map.move(e);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 200 */     if (this.slowUp > 10000.0D) {
/* 201 */       this.slowUp -= 10000.0D;
/*     */     }
/*     */     
/* 204 */     int from = (int)this.slowUp;
/* 205 */     this.slowUp += ds * 0.1D;
/* 206 */     int to = (int)this.slowUp;
/* 207 */     int am = to - from;
/* 208 */     for (int k = 0; k < am; k++) {
/*     */       
/* 210 */       if (this.slow.size() <= 0) {
/*     */         break;
/*     */       }
/* 213 */       int j = from + k;
/* 214 */       j %= this.slow.size();
/*     */       
/* 216 */       if (k != 0 && j == from) {
/*     */         break;
/*     */       }
/* 219 */       WEntity e = (WEntity)this.slow.get(j);
/* 220 */       e.update(ds);
/* 221 */       if (!e.added()) {
/* 222 */         j--;
/*     */       } else {
/* 224 */         this.map.move(e);
/*     */       } 
/*     */     } 
/* 227 */     prof.logEnd(this);
/*     */   }
/*     */   
/*     */   public void fill(RECTANGLE area, LISTE<WEntity> result) {
/* 231 */     this.map.fill(area, result);
/*     */   }
/*     */   
/*     */   public LIST<WEntity> fill(RECTANGLE area) {
/* 235 */     this.tmp.clear();
/* 236 */     fill(area, (LISTE<WEntity>)this.tmp);
/* 237 */     return (LIST<WEntity>)this.tmp;
/*     */   }
/*     */   
/*     */   public LIST<WEntity> fill(int x1, int x2, int y1, int y2) {
/* 241 */     this.tmp.clear();
/* 242 */     this.map.fill(x1, x2, y1, y2, (ADDABLE<WEntity>)this.tmp);
/* 243 */     return (LIST<WEntity>)this.tmp;
/*     */   }
/*     */   
/*     */   public LIST<WEntity> fillTiles(int x1, int x2, int y1, int y2) {
/* 247 */     return fill(x1 * 64, x2 * 64, y1 * 64, y2 * 64);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<WEntity> fill(int x1, int y1) {
/* 252 */     this.tmp.clear();
/* 253 */     this.map.fill(x1, x1 + 1, y1, y1 + 1, (ADDABLE<WEntity>)this.tmp);
/* 254 */     return (LIST<WEntity>)this.tmp;
/*     */   }
/*     */   
/*     */   public void fill(COORDINATE coo, LISTE<WEntity> result) {
/* 258 */     fill(coo.x(), coo.y(), result);
/*     */   }
/*     */   
/*     */   public void fill(int x, int y, LISTE<WEntity> result) {
/* 262 */     this.map.fill(x, y, (ADDABLE<WEntity>)result);
/*     */   }
/*     */   
/*     */   public WEntity getTallest(COORDINATE coo) {
/* 266 */     this.tmp.clear();
/* 267 */     fill(coo, (LISTE<WEntity>)this.tmp);
/* 268 */     WEntity tallest = null;
/* 269 */     double dist = Double.MAX_VALUE;
/* 270 */     for (WEntity e : this.tmp) {
/* 271 */       double d = coo.distance(e.body().cX(), e.body().cY());
/* 272 */       if (tallest == null || d < dist) {
/* 273 */         tallest = e;
/* 274 */         dist = d;
/*     */       } 
/*     */     } 
/* 277 */     return tallest;
/*     */   }
/*     */   
/*     */   public boolean areaIsClearOfEnts(RECTANGLE rec) {
/* 281 */     return fill(rec).isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public LISTE<WEntity> getTempsAtTile(int tileX, int tileY, int tilesX, int tilesY) {
/* 286 */     this.tmp.clear();
/*     */     
/* 288 */     this.rectmp.set((tileX * 64), ((tileX + tilesX) * 64), (tileY * 64), ((
/* 289 */         tileY + tilesY) * 64));
/*     */     
/* 291 */     fill((RECTANGLE)this.rectmp, (LISTE<WEntity>)this.tmp);
/*     */     
/* 293 */     return (LISTE<WEntity>)this.tmp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelowTerrain(Renderer r, ShadowBatch s, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 300 */     offX -= renWindow.x1();
/* 301 */     offY -= renWindow.y1();
/*     */ 
/*     */ 
/*     */     
/* 305 */     for (WEntity e : this.tmp) {
/* 306 */       e.renderBelowTerrain(r, s, ds, e.body().x1() + offX, e.body().y1() + offY);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAboveTerrain(Renderer r, ShadowBatch s, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 313 */     this.renderables.clear();
/* 314 */     this.map.fill(renWindow, this.renderables);
/*     */     
/* 316 */     offX -= renWindow.x1();
/* 317 */     offY -= renWindow.y1();
/* 318 */     this.tmp.clear();
/*     */ 
/*     */     
/* 321 */     while (this.renderables.hasMore()) {
/* 322 */       WEntity e = (WEntity)this.renderables.pollGreatest();
/* 323 */       e.handleFow();
/* 324 */       this.tmp.add(e);
/*     */     } 
/*     */     
/* 327 */     for (WEntity e : this.tmp) {
/* 328 */       e.renderAboveTerrain(r, s, ds, e.body().x1() + offX, e.body().y1() + offY);
/*     */     }
/*     */   }
/*     */   
/*     */   public LIST<WEntity> allFast() {
/* 333 */     return (LIST<WEntity>)this.fast;
/*     */   }
/*     */   
/*     */   public LIST<WEntity> allSlow() {
/* 337 */     return (LIST<WEntity>)this.slow;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\WEntities.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */