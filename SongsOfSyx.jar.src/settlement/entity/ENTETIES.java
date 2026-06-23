/*     */ package settlement.entity;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.AvailabilityListener;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.ADDABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.IntegerStack;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ 
/*     */ 
/*     */ public class ENTETIES
/*     */   extends SETT.SettResource
/*     */ {
/*     */   public static final int MAX = 40000;
/*     */   public static final int MM = 60000;
/*     */   private final Grid grid;
/*  44 */   private final ENTITY[] ents = new ENTITY[60000];
/*  45 */   private final IntegerStack freeIndexes = new IntegerStack(60000);
/*  46 */   private final Bits order = new Bits(262143);
/*  47 */   private final Bits count = new Bits(2147221504);
/*  48 */   private int eLastIndex = -1;
/*  49 */   private final Tree<ENTITY> renderables = new Tree<ENTITY>(8000)
/*     */     {
/*     */       protected boolean isGreaterThan(ENTITY current, ENTITY cmp)
/*     */       {
/*  53 */         double d = current.height() + current.physics.getZ() - cmp.height() + cmp.physics.getZ();
/*  54 */         if (d > 0.0D)
/*  55 */           return true; 
/*  56 */         return false;
/*     */       }
/*     */     };
/*     */   
/*  60 */   private final ArrayList<ENTITY> temp = new ArrayList(3000);
/*  61 */   private final Rec lWin = new Rec();
/*     */   
/*  63 */   public final MAP_BOOLEAN submerged = new SubmergedMap(); private int k; private double lastDs;
/*     */   public final PLACABLE remove;
/*     */   
/*  66 */   public ENTETIES() { super("ENTETIES", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 340 */     this.k = 0;
/* 341 */     this.lastDs = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 502 */     this.remove = (PLACABLE)new PlacableSimple("Remove Entity", "")
/*     */       {
/*     */         public void place(int x, int y)
/*     */         {
/* 506 */           ENTITY e = SETT.ENTITIES().getAtPoint(x, y);
/* 507 */           if (e != null) {
/* 508 */             e.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */           }
/*     */         }
/*     */         
/*     */         public CharSequence isPlacable(int x, int y) {
/* 513 */           return (SETT.ENTITIES().getAtPoint(x, y) != null) ? null : E; } }; this.grid = new Grid();
/*     */     this.freeIndexes.clear();
/*     */     for (int i = 59999; i >= 0; i--)
/*     */       this.freeIndexes.push(i); 
/*     */     this.eLastIndex = 0;
/* 518 */     IDebugPanelSett.add(this.remove); } public boolean isMax() { return this.freeIndexes.isEmpty(); }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*     */     this.freeIndexes.save(file);
/*     */     file.i(this.eLastIndex);
/*     */     for (int iter = 0; iter <= this.eLastIndex; iter++) {
/*     */       ENTITY e = this.ents[iter];
/*     */       if (e == null) {
/*     */         file.i(0);
/*     */       } else {
/*     */         if (e instanceof Animal) {
/*     */           file.i(1);
/*     */         } else if (e instanceof Humanoid) {
/*     */           file.i(2);
/*     */         } else {
/*     */           throw new RuntimeException(String.valueOf(e.getClass()));
/*     */         } 
/*     */         e.save(file);
/*     */       } 
/*     */     } 
/*     */     super.save(file);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*     */     this.grid.clear();
/*     */     for (int iter = 0; iter <= this.eLastIndex; iter++)
/*     */       this.ents[iter] = null; 
/*     */     this.freeIndexes.load(file);
/*     */     int l = file.i();
/*     */     for (int j = 0; j <= l; j++) {
/*     */       int in = file.i();
/*     */       if (in != 0) {
/*     */         if (in == 1) {
/*     */           this.ents[j] = (ENTITY)new Animal(file);
/*     */         } else if (in == 2) {
/*     */           this.ents[j] = (ENTITY)new Humanoid(file);
/*     */         } else {
/*     */           throw new IOException("" + in);
/*     */         } 
/*     */         if (this.ents[j] != null) {
/*     */           this.grid.addRaw(this.ents[j]);
/*     */           if (j > this.eLastIndex)
/*     */             this.eLastIndex = j; 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     int old = this.freeIndexes.size();
/*     */     int am = 0;
/*     */     this.eLastIndex = 0;
/*     */     this.freeIndexes.clear();
/*     */     for (int i = 0; i < 60000; i++) {
/*     */       if (this.ents[i] != null) {
/*     */         am++;
/*     */         if (i > this.eLastIndex)
/*     */           this.eLastIndex = i; 
/*     */       } else {
/*     */         this.freeIndexes.push(i);
/*     */       } 
/*     */     } 
/*     */     if (60000 - old != am)
/*     */       GAME.Notify("" + 60000 - old + " " + 60000 - old); 
/*     */   }
/*     */   
/*     */   protected void clear() {
/*     */     this.grid.clear();
/*     */     for (int iter = 0; iter <= this.eLastIndex; iter++)
/*     */       this.ents[iter] = null; 
/*     */     this.eLastIndex = -1;
/*     */     this.freeIndexes.clear();
/*     */     for (int i = 59999; i >= 0; i--)
/*     */       this.freeIndexes.push(i); 
/*     */   }
/*     */   
/*     */   boolean add(ENTITY e, boolean collide) {
/*     */     if (e.handlerId != -1)
/*     */       throw new RuntimeException("entity already added!"); 
/*     */     if (this.freeIndexes.isEmpty())
/*     */       return false; 
/*     */     int i = this.freeIndexes.pop();
/*     */     int oi = this.order.get(i);
/*     */     if (oi > this.eLastIndex)
/*     */       this.eLastIndex = oi; 
/*     */     int ci = this.count.get(i) + 1;
/*     */     if (ci > this.count.mask)
/*     */       ci = 0; 
/*     */     i = this.count.set(i, ci);
/*     */     this.ents[oi] = e;
/*     */     e.handlerId = i;
/*     */     e.physics.initMoveCheck();
/*     */     this.grid.add(e, collide);
/*     */     return true;
/*     */   }
/*     */   
/*     */   public void moveIntoTheTheUnknown(ENTITY e) {
/*     */     this.grid.remove(e);
/*     */   }
/*     */   
/*     */   public void returnFromTheTheUnknown(ENTITY e) {
/*     */     if (e.gx == -1 && e.gy == -1)
/*     */       this.grid.add(e, false); 
/*     */   }
/*     */   
/*     */   public ENTITY[] getAllEnts() {
/*     */     return this.ents;
/*     */   }
/*     */   
/*     */   public int Imax() {
/*     */     return this.eLastIndex;
/*     */   }
/*     */   
/*     */   public void renderA(Renderer r, ShadowBatch shadowBatch, float ds, RECTANGLE renWindow, int offX, int offY) {
/*     */     shadowBatch.setHard();
/*     */     this.lWin.setWidth((renWindow.width() + 200)).setHeight((renWindow.height() + 200)).centerIn(renWindow);
/*     */     int offXs = offX - renWindow.x1();
/*     */     int offYs = offY - renWindow.y1();
/*     */     fill((RECTANGLE)this.lWin, (ADDABLE<ENTITY>)this.renderables);
/*     */     if (CORE.renderer().getZoomout() >= 2) {
/*     */       while (this.renderables.hasMore()) {
/*     */         ENTITY e = (ENTITY)this.renderables.pollSmallest();
/*     */         e.renderSimple(r, shadowBatch, ds, offXs, offYs);
/*     */       } 
/*     */     } else {
/*     */       while (this.renderables.hasMore()) {
/*     */         ENTITY e = (ENTITY)this.renderables.pollSmallest();
/*     */         e.render(r, shadowBatch, ds, offXs, offYs);
/*     */       } 
/*     */     } 
/*     */     shadowBatch.setSoft();
/*     */   }
/*     */   
/*     */   public void renderZoomed(Renderer r, ShadowBatch shadowBatch, float ds, RECTANGLE renWindow, int offX, int offY, UIMinimapSettConfig con) {
/*     */     byte b;
/*     */     int i;
/*     */     ENTITY[] arrayOfENTITY;
/*     */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) {
/*     */       ENTITY e = arrayOfENTITY[b];
/*     */       if (e != null) {
/*     */         int x1 = e.physics.body().cX();
/*     */         int y1 = e.physics.body().cY();
/*     */         if (renWindow.holdsPoint(x1, y1)) {
/*     */           DIR d = e.speed.dir();
/*     */           x1 -= renWindow.x1() - offX + 32;
/*     */           y1 -= renWindow.y1() - offY + 32;
/*     */           COLOR c = con.col(e);
/*     */           if (c != null) {
/*     */             c.bind();
/*     */             ((SPRITE)(SPRITES.cons()).ICO.arrows_entity.getC(d.ordinal())).render((SPRITE_RENDERER)r, x1, y1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       b++;
/*     */     } 
/*     */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public void fill(Coo coo, ADDABLE<ENTITY> result) {
/*     */     this.grid.fill(coo.x(), coo.y(), result);
/*     */   }
/*     */   
/*     */   public void fill(RECTANGLE area, ADDABLE<ENTITY> result) {
/*     */     this.grid.fill(area, result);
/*     */   }
/*     */   
/*     */   public LIST<ENTITY> fill(RECTANGLE pixels) {
/*     */     this.temp.clear();
/*     */     this.grid.fill(pixels, (ADDABLE<ENTITY>)this.temp);
/*     */     return (LIST<ENTITY>)this.temp;
/*     */   }
/*     */   
/*     */   public LIST<ENTITY> fillTiles(RECTANGLE tiles) {
/*     */     this.lWin.moveX1Y1((tiles.x1() << 6), (tiles.y1() << 6));
/*     */     this.lWin.setWidth((tiles.width() << 6)).setHeight((tiles.height() << 6));
/*     */     return fill((RECTANGLE)this.lWin);
/*     */   }
/*     */   
/*     */   public LIST<ENTITY> fillTiles(int tx, int ty, int w, int h) {
/*     */     this.lWin.moveX1Y1((tx << 6), (ty << 6));
/*     */     this.lWin.setWidth((w << 6)).setHeight((h << 6));
/*     */     return fill((RECTANGLE)this.lWin);
/*     */   }
/*     */   
/*     */   public boolean save(String p) {
/*     */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   void remove(ENTITY e) {
/*     */     if (e.handlerId == -1)
/*     */       throw new RuntimeException(); 
/*     */     e.removeAction();
/*     */     this.grid.remove(e);
/*     */     this.ents[this.order.get(e.handlerId)] = null;
/*     */     this.freeIndexes.push(e.handlerId);
/*     */     e.handlerId = -1;
/*     */   }
/*     */   
/*     */   public void update(double ds, Profiler profiler) {
/*     */     this.k++;
/*     */     this.k &= 0x1;
/*     */     double dds = ds;
/*     */     ds += this.lastDs;
/*     */     this.lastDs = dds;
/*     */     int s = (this.k == 0) ? 0 : (this.eLastIndex / 2);
/*     */     int l = (this.k == 0) ? this.eLastIndex : (this.eLastIndex / 2);
/*     */     for (int i = s; i <= l; i++) {
/*     */       ENTITY e = this.ents[i];
/*     */       if (e != null) {
/*     */         e.update(ds);
/*     */         if (e.handlerId != -1)
/*     */           this.grid.move(e); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void move(ENTITY e) {
/*     */     this.grid.move(e);
/*     */   }
/*     */   
/*     */   public ENTITY getAtPoint(COORDINATE coo) {
/*     */     return getAtPoint(coo.x(), coo.y());
/*     */   }
/*     */   
/*     */   public ENTITY getAtPoint(int x, int y) {
/*     */     this.temp.clear();
/*     */     this.grid.fill(x, y, (ADDABLE<ENTITY>)this.temp);
/*     */     if (!this.temp.isEmpty())
/*     */       return (ENTITY)this.temp.get(0); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public Iterable<ENTITY> getAtPointL(int x, int y) {
/*     */     this.temp.clear();
/*     */     this.grid.fill(x, y, (ADDABLE<ENTITY>)this.temp);
/*     */     return (Iterable<ENTITY>)this.temp;
/*     */   }
/*     */   
/*     */   public ENTITY getArroundPoint(int x, int y) {
/*     */     this.temp.clear();
/*     */     Rec.TEMP.setDim(64.0D);
/*     */     Rec.TEMP.moveC(x, y);
/*     */     this.grid.fill((RECTANGLE)Rec.TEMP, (ADDABLE<ENTITY>)this.temp);
/*     */     ENTITY res = null;
/*     */     while (!this.temp.isEmpty()) {
/*     */       ENTITY candidate = (ENTITY)this.temp.removeLast();
/*     */       if (res == null || candidate.body().getDistance((RECTANGLE)Rec.TEMP) < res.body().getDistance((RECTANGLE)Rec.TEMP))
/*     */         res = candidate; 
/*     */     } 
/*     */     return res;
/*     */   }
/*     */   
/*     */   public LIST<ENTITY> getArroundPoint(int x, int y, int size) {
/*     */     this.temp.clear();
/*     */     Rec.TEMP.setDim(size);
/*     */     Rec.TEMP.moveC(x, y);
/*     */     this.grid.fill((RECTANGLE)Rec.TEMP, (ADDABLE<ENTITY>)this.temp);
/*     */     return (LIST<ENTITY>)this.temp;
/*     */   }
/*     */   
/*     */   public Iterable<ENTITY> getAtTile(int tx, int ty) {
/*     */     this.temp.clear();
/*     */     this.grid.fillTile(tx, ty, (ADDABLE<ENTITY>)this.temp);
/*     */     return (Iterable<ENTITY>)this.temp;
/*     */   }
/*     */   
/*     */   public ENTITY getAtTileSingle(int tx, int ty) {
/*     */     return this.grid.getFirst(tx, ty);
/*     */   }
/*     */   
/*     */   public boolean tileIsClear(int tx, int ty) {
/*     */     this.temp.clear();
/*     */     this.grid.fill(tx, ty, (ADDABLE<ENTITY>)this.temp);
/*     */     for (ENTITY e : this.temp) {
/*     */       if (e.physics.getMass() != 0.0D)
/*     */         return false; 
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean hasAtTile(ENTITY asker, int tx, int ty) {
/*     */     ENTITY e = this.grid.getFirst(tx, ty);
/*     */     if (e != null && e == asker)
/*     */       e = e.next; 
/*     */     return (e != null);
/*     */   }
/*     */   
/*     */   public boolean hasAtTileHigher(ENTITY asker, int tx, int ty) {
/*     */     ENTITY e = this.grid.getFirst(tx, ty);
/*     */     while (e != null) {
/*     */       if (e != asker && e.id() > asker.id())
/*     */         return true; 
/*     */       e = e.next;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public int amountAtTile(int tx, int ty) {
/*     */     int am = 0;
/*     */     ENTITY e = this.grid.getFirst(tx, ty);
/*     */     if (e != null && am < 10) {
/*     */       e = e.next;
/*     */       am++;
/*     */     } 
/*     */     return am;
/*     */   }
/*     */   
/*     */   public boolean hasAtTile(int tx, int ty) {
/*     */     ENTITY e = this.grid.getFirst(tx, ty);
/*     */     return (e != null);
/*     */   }
/*     */   
/*     */   public LIST<ENTITY> getInProximity(ENTITY e, int radius) {
/*     */     this.temp.clear();
/*     */     this.grid.fill(e, radius, (ADDABLE<ENTITY>)this.temp);
/*     */     return (LIST<ENTITY>)this.temp;
/*     */   }
/*     */   
/*     */   public ENTITY getByID(int id) {
/*     */     if (id < 0)
/*     */       return null; 
/*     */     int oi = this.order.get(id);
/*     */     if (oi > this.ents.length)
/*     */       return null; 
/*     */     ENTITY t = this.ents[oi];
/*     */     if (t == null)
/*     */       return null; 
/*     */     if (t.isRemoved())
/*     */       return null; 
/*     */     if (id != t.handlerId)
/*     */       return null; 
/*     */     return t;
/*     */   }
/*     */   
/*     */   public ENTITY getByIndex(int id) {
/*     */     return this.ents[id];
/*     */   }
/*     */   
/*     */   public int size() {
/*     */     return 40000 - this.freeIndexes.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\ENTETIES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */