/*     */ package settlement.room.military.artillery;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderSoldierManning;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.thing.projectiles.SProjectiles;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class ArtilleryInstance
/*     */   extends RoomInstance implements SFinderSoldierManning.FINDABLE_MANNING_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public boolean hovered;
/*     */   public boolean selected;
/*     */   private boolean enemy;
/*     */   boolean invisible;
/*     */   private final byte dir;
/*     */   private byte dirCurrent;
/*     */   byte men;
/*     */   private boolean mustered;
/*     */   private boolean fireAtWill;
/*  41 */   private final Coo cTarget = new Coo(-1.0D, -1.0D);
/*  42 */   private short dTarget = -1;
/*     */   
/*     */   private boolean bombard = false;
/*     */   private volatile boolean trajLock;
/*  46 */   private final Trajectory traj = new Trajectory();
/*     */   volatile boolean hasTrajectory = false;
/*     */   private float progress;
/*     */   private float skill;
/*     */   private float skillI;
/*     */   boolean isLoaded;
/*     */   private boolean targetIsUserSet = false;
/*  53 */   private static final Trajectory trajTmp = new Trajectory();
/*     */   
/*     */   ArtilleryInstance(ROOM_ARTILLERY b, TmpArea area, RoomInit init) {
/*  56 */     super(b, area, init);
/*  57 */     this.dir = (byte)(((FurnisherItem)(SETT.ROOMS()).fData.item.get(mX(), mY())).rotation * 2);
/*  58 */     this.dirCurrent = this.dir;
/*  59 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_ARTILLERY blueprintI() {
/*  64 */     return (ROOM_ARTILLERY)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   void work(double amount, Humanoid hu) {
/*  69 */     this.invisible = false;
/*     */     
/*  71 */     if (!needsWork()) {
/*     */       return;
/*     */     }
/*  74 */     double skill = (1.0D - 0.75D * getDegrade()) * blueprintI().bonus().get((BOOSTABLE_O)hu.indu()) / blueprintI().bonus().max(Induvidual.class);
/*  75 */     amount /= 6.0D * (blueprintI()).projectile.reloadSeconds(skill);
/*     */     
/*  77 */     if (this.hasTrajectory) {
/*  78 */       DIR d = DIR.get(this.traj.vx(), this.traj.vy());
/*  79 */       if (d != dirCurrent()) {
/*  80 */         this.progress = (float)(this.progress + amount * 8.0D);
/*  81 */         if (this.progress >= 1.0F) {
/*  82 */           this.progress--;
/*  83 */           if (d == dirCurrent().next(-2)) {
/*  84 */             this.dirCurrent = (byte)dirCurrent().next(-1).id();
/*  85 */           } else if (d == dirCurrent().next(2)) {
/*  86 */             this.dirCurrent = (byte)dirCurrent().next(1).id();
/*     */           } else {
/*  88 */             this.dirCurrent = (byte)d.id();
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       } 
/*  93 */       if (this.isLoaded && (targetCooGet() != null || targetDivGet() != null)) {
/*     */         
/*  95 */         this.isLoaded = false;
/*  96 */         int h = SETT.TERRAIN().get(body().cX(), body().cY()).heightEnt(body().cX(), body().cY()) * 64;
/*  97 */         h += 133;
/*  98 */         getTrajectory(trajTmp);
/*  99 */         int fx = body().x1() * 64 + body().width() * 64 / 2;
/* 100 */         int fy = body().y1() * 64 + body().height() * 64 / 2;
/* 101 */         fx += 64 * dir().x();
/* 102 */         fy += 64 * dir().y();
/* 103 */         double ref = CLAMP.d((this.skill / this.skillI), 0.0D, 1.0D);
/* 104 */         this.skillI = 0.0F;
/* 105 */         this.skill = 0.0F;
/* 106 */         SETT.PROJS().launch(fx, fy, h, trajTmp, (blueprintI()).projectile, 1.0D - (blueprintI()).projectile.accuracy(ref), ref, null);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     if (!this.isLoaded) {
/* 113 */       this.progress = (float)(this.progress + amount);
/* 114 */       this.skill = (float)(this.skill + skill);
/* 115 */       this.skillI++;
/* 116 */       if (this.progress >= 1.0F) {
/* 117 */         this.progress--;
/* 118 */         this.isLoaded = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisible() {
/* 126 */     this.invisible = false;
/*     */   }
/*     */   
/*     */   double progress() {
/* 130 */     return this.progress;
/*     */   }
/*     */   
/*     */   public boolean needsWork() {
/* 134 */     return !(!this.hasTrajectory && this.isLoaded);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 149 */     if (this.invisible)
/* 150 */       return false; 
/* 151 */     return super.render(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 156 */     if (this.invisible)
/* 157 */       return false; 
/* 158 */     return super.renderAbove(r, shadowBatch, i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 163 */     if (this.invisible)
/* 164 */       return false; 
/* 165 */     return super.renderBelow(r, shadowBatch, i);
/*     */   }
/*     */   
/*     */   public DIR dirCurrent() {
/* 169 */     return (DIR)DIR.ALL.get(this.dirCurrent);
/*     */   }
/*     */   
/*     */   public DIR dir() {
/* 173 */     return (DIR)DIR.ALL.get(this.dir);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 178 */     muster(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Army army() {
/* 183 */     return this.enemy ? GAME.ARMIES().enemy() : GAME.ARMIES().player();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inService() {
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   public boolean mustered() {
/* 192 */     return this.mustered;
/*     */   }
/*     */   
/*     */   public void muster(boolean muster) {
/* 196 */     if (this.mustered == muster) {
/*     */       return;
/*     */     }
/* 199 */     this.men = 0;
/* 200 */     if (!muster) {
/* 201 */       for (COORDINATE c : body()) {
/* 202 */         if (is(c))
/* 203 */           (blueprintI()).service.deactivate(c.x(), c.y()); 
/*     */       } 
/* 205 */       this.mustered = muster;
/*     */     }
/*     */     else {
/*     */       
/* 209 */       this.mustered = muster;
/* 210 */       for (COORDINATE c : body()) {
/* 211 */         if (is(c))
/* 212 */           (blueprintI()).service.activate(c.x(), c.y()); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean fireAtWill() {
/* 218 */     return this.fireAtWill;
/*     */   }
/*     */   
/*     */   public void fireAtWill(boolean fire) {
/* 222 */     this.fireAtWill = fire;
/*     */   }
/*     */   
/*     */   public boolean isFiring() {
/* 226 */     return (mustered() && menMustering() > 0.0D && this.hasTrajectory && (targetCooGet() != null || targetDivGet() != null));
/*     */   }
/*     */   
/*     */   public void clearTarget() {
/* 230 */     this.cTarget.set(-1.0D, -1.0D);
/* 231 */     this.dTarget = -1;
/*     */   }
/*     */   
/*     */   public void targetDivSet(Div div, boolean userSet) {
/* 235 */     clearTarget();
/* 236 */     this.dTarget = div.index();
/*     */   }
/*     */   
/*     */   public Div targetDivGet() {
/* 240 */     if (this.dTarget == -1)
/* 241 */       return null; 
/* 242 */     Div d = GAME.ARMIES().division(this.dTarget);
/*     */     
/* 244 */     return d;
/*     */   }
/*     */   
/*     */   public COORDINATE targetCooGet() {
/* 248 */     if (this.cTarget.x() == -1)
/* 249 */       return null; 
/* 250 */     return (COORDINATE)this.cTarget;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void targetCooSet(int tx, int ty, boolean bombard, boolean userSet) {
/* 256 */     clearTarget();
/* 257 */     this.cTarget.set(tx, ty);
/* 258 */     this.bombard = bombard;
/*     */   }
/*     */ 
/*     */   
/*     */   void getTrajectory(Trajectory t) {
/* 263 */     lockTrajectory();
/* 264 */     t.set(this.traj.vx(), this.traj.vy(), this.traj.vz());
/* 265 */     this.trajLock = false;
/*     */   }
/*     */   
/*     */   public void setTrajectory(Trajectory t) {
/* 269 */     lockTrajectory();
/* 270 */     if (t == null) {
/* 271 */       this.hasTrajectory = false;
/*     */     } else {
/* 273 */       this.traj.set(t.vx(), t.vy(), t.vz());
/* 274 */       this.hasTrajectory = true;
/*     */     } 
/*     */     
/* 277 */     this.trajLock = false;
/*     */   }
/*     */   private synchronized void lockTrajectory() {
/*     */     do {
/*     */     
/* 282 */     } while (this.trajLock);
/*     */     
/* 284 */     this.trajLock = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 289 */     box.add((SPRITE)blueprintI().iconBig());
/* 290 */     box.text((CharSequence)name());
/* 291 */     box.NL();
/* 292 */     Hoverer.hover((GBox)box, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE centre() {
/* 297 */     int fx = body().x1() * 64 + body().width() * 64 / 2;
/* 298 */     int fy = body().y1() * 64 + body().height() * 64 / 2;
/* 299 */     fx += 64 * dir().x();
/* 300 */     fy += 64 * dir().y();
/* 301 */     Coo.TMP.set(fx, fy);
/* 302 */     return (COORDINATE)Coo.TMP;
/*     */   }
/*     */   
/*     */   public boolean bombarding() {
/* 306 */     return this.bombard;
/*     */   }
/*     */   
/*     */   public int rangeMin() {
/* 310 */     return (int)(blueprintI()).projectile.velocity(blueprintI().ref());
/*     */   }
/*     */   
/*     */   public int rangeMax() {
/* 314 */     return (int)Trajectory.range(0, (blueprintI()).projectile.maxAngle(32767.0D), (blueprintI()).projectile.velocity(blueprintI().ref()));
/*     */   }
/*     */   
/*     */   public boolean targetIsUserSet() {
/* 318 */     return this.targetIsUserSet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean testTarget(int tx, int ty) {
/* 324 */     int fx = body().cX() * 64 + 32;
/* 325 */     int fy = body().cY() * 64 + 32;
/* 326 */     fx += 64 * dir().x();
/* 327 */     fy += 64 * dir().y();
/*     */     
/* 329 */     int dx = tx - fx;
/* 330 */     int dy = ty - fy;
/* 331 */     double l = Math.sqrt((dx * dx + dy * dy));
/*     */     
/* 333 */     double min = rangeMin();
/* 334 */     double max = rangeMax();
/* 335 */     if (l < min) {
/* 336 */       return false;
/*     */     }
/* 338 */     if (l > max) {
/* 339 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 343 */     DIR d = dir().next(-1);
/* 344 */     double Ax = fx + min * d.xN();
/* 345 */     double Ay = fy + min * d.yN();
/* 346 */     double Bx = fx + max * d.xN();
/* 347 */     double By = fy + max * d.yN();
/* 348 */     if (dd(Ax, Ay, Bx, By, tx, ty) < 0.0D) {
/* 349 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 355 */     d = dir().next(1);
/* 356 */     Ax = fx + min * d.xN();
/* 357 */     Ay = fy + min * d.yN();
/* 358 */     Bx = fx + max * d.xN();
/* 359 */     By = fy + max * d.yN();
/* 360 */     if (dd(Ax, Ay, Bx, By, tx, ty) > 0.0D) {
/* 361 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 365 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence testTarget(int px, int py, Trajectory traj, boolean entity) {
/* 371 */     if (!testTarget(px, py)) {
/* 372 */       return SProjectiles.¤¤OUT_OF_RANGE;
/*     */     }
/* 374 */     int fx = body().x1() * 64 + body().width() * 64 / 2;
/* 375 */     int fy = body().y1() * 64 + body().height() * 64 / 2;
/* 376 */     fx += 64 * dir().x();
/* 377 */     fy += 64 * dir().y();
/*     */     
/* 379 */     int h = SETT.TERRAIN().get(body().cX(), body().cY()).heightEnt(body().cX(), body().cY()) * 64;
/* 380 */     h += 133;
/*     */     
/* 382 */     int ttx = px >> 6;
/* 383 */     int tty = px >> 6;
/* 384 */     if (entity) {
/* 385 */       h -= SETT.TERRAIN().get(ttx, tty).heightEnt(ttx, tty) + 64;
/*     */     } else {
/* 387 */       h -= SETT.TERRAIN().get(ttx, tty).heightStart(ttx, tty) + (SETT.TERRAIN().get(ttx, tty).heightEnd(ttx, tty) - SETT.TERRAIN().get(ttx, tty).heightStart(ttx, tty)) / 2;
/*     */     } 
/* 389 */     CharSequence problem = SProjectiles.¤¤OUT_OF_RANGE;
/*     */     
/* 391 */     if (traj.calcLow(h, fx, fy, px, py, (blueprintI()).projectile.maxAngle(32767.0D), (blueprintI()).projectile.velocity(blueprintI().ref()))) {
/*     */       
/* 393 */       problem = SProjectiles.trajectoryProblem(army(), traj, fx, fy);
/* 394 */       if (problem == null) {
/* 395 */         return null;
/*     */       }
/*     */     } 
/* 398 */     if (traj.calcHigh(h, fx, fy, px, py, (blueprintI()).projectile.maxAngle(32767.0D), (blueprintI()).projectile.velocity(blueprintI().ref()))) {
/* 399 */       problem = SProjectiles.trajectoryProblem(army(), traj, fx, fy);
/* 400 */       if (problem == null)
/* 401 */         return null; 
/*     */     } 
/* 403 */     return problem;
/*     */   }
/*     */ 
/*     */   
/*     */   private double dd(double Ax, double Ay, double Bx, double By, double Cx, double Cy) {
/* 408 */     return (Bx - Ax) * (Cy - Ay) - (By - Ay) * (Cx - Ax);
/*     */   }
/*     */   
/*     */   public void setEnemy() {
/* 412 */     muster(false);
/* 413 */     this.enemy = true;
/* 414 */     this.invisible = true;
/* 415 */     muster(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderSoldierManning.FINDABLE_MANNING getManning(int tx, int ty) {
/* 420 */     return (blueprintI()).service.get(tx, ty);
/*     */   }
/*     */   
/*     */   public double menMustering() {
/* 424 */     return this.men / 6.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 429 */     if (this.enemy) {
/* 430 */       (SETT.THINGS()).gore.debris(centre().x(), centre().y(), 0.0D, 0.0D);
/* 431 */       remove(tx, ty, false, this, true).clear();
/*     */     } else {
/*     */       
/* 434 */       super.destroyTile(tx, ty);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\ArtilleryInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */