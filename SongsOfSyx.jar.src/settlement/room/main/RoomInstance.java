/*     */ package settlement.room.main;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.UI.Icon;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.util.Deleter;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public abstract class RoomInstance
/*     */   extends Room.RoomInstanceImp
/*     */   implements AREA
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private boolean exists = false;
/*     */   private final int size;
/*     */   private boolean reachable = true;
/*     */   private boolean active = false;
/*     */   private final short fx;
/*     */   private final short fy;
/*  42 */   private final RoomEmploymentIns work = new RoomEmploymentIns(this);
/*     */   
/*     */   private final Rec tiles;
/*     */   
/*     */   private double[] stats;
/*     */   private double[] ress;
/*     */   private double resMul;
/*  49 */   private int degrade = 0;
/*     */   
/*  51 */   protected final Str iname = (Str)new Str.StringReusableSer(32);
/*     */   private byte upgrade;
/*  53 */   private float isolation = 0.0F;
/*     */   
/*     */   protected RoomInstance(RoomBlueprintIns<? extends RoomInstance> blueprint, TmpArea area, RoomInit init) {
/*  56 */     super(SETT.ROOMS(), blueprint, false);
/*  57 */     this.size = area.area();
/*  58 */     this.tiles = new Rec(area.body());
/*  59 */     this.stats = init.stats;
/*  60 */     this.ress = init.res;
/*  61 */     this.resMul = init.resMul;
/*  62 */     int a = 0;
/*  63 */     this.degrade = init.degrade;
/*  64 */     int ffx = -1;
/*  65 */     int ffy = 0;
/*     */     
/*  67 */     area.replaceAndClear(this);
/*     */     
/*  69 */     for (COORDINATE c : body()) {
/*  70 */       if (is(c)) {
/*     */         
/*  72 */         if (ffx == -1) {
/*  73 */           if (this.tiles.width() == 1 && this.tiles.height() == 1) {
/*  74 */             ffx = c.x();
/*  75 */             ffy = c.y();
/*     */           } 
/*  77 */           AVAILABILITY av = getAvailability(c.x() + c.y() * SETT.TWIDTH);
/*  78 */           if (av.from <= 0.0D && av.player > 0.0D) {
/*  79 */             ffx = c.x();
/*  80 */             ffy = c.y();
/*     */           } 
/*     */         } 
/*     */         
/*  84 */         a++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  89 */     if (ffx == -1) {
/*  90 */       throw new RuntimeException(this.tiles.toString() + " " + this.tiles.toString());
/*     */     }
/*  92 */     this.fx = (short)ffx;
/*  93 */     this.fy = (short)ffy;
/*     */     
/*  95 */     if (a != this.size) {
/*  96 */       throw new RuntimeException("" + a + " " + a);
/*     */     }
/*  98 */     if (a == 0) {
/*  99 */       throw new RuntimeException();
/*     */     }
/* 101 */     this.exists = true;
/*     */     
/* 103 */     int nr = blueprint.instancesSize() + 1;
/*     */     
/* 105 */     this.iname.add(blueprint.info.name).s().add('#');
/* 106 */     if (nr < 100)
/* 107 */       this.iname.add('0'); 
/* 108 */     if (nr < 10)
/* 109 */       this.iname.add('0'); 
/* 110 */     this.iname.add(nr);
/*     */     
/* 112 */     blueprint.addInstance(this);
/* 113 */     this.isolation = (float)(SETT.ROOMS()).isolation.getProspect(blueprint, this, null);
/* 114 */     SETT.MAINTENANCE().initRoomDegrade(this, mX(), mY());
/*     */ 
/*     */     
/* 117 */     (SETT.ROOMS()).map.init(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean exists() {
/* 123 */     return this.exists;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void update(double updateInterval, boolean day) {
/* 128 */     updateReachability();
/*     */     
/* 130 */     updateAction(updateInterval, day);
/*     */ 
/*     */     
/* 133 */     this.work.update(active(), day, (blueprintI() instanceof ROOM_EMPLOY_AUTO && ((ROOM_EMPLOY_AUTO)blueprintI()).autoEmploy(this)), updateInterval);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 141 */     if ((blueprintI()).soundAmbiance != null)
/* 142 */       (blueprintI()).soundAmbiance.priorityInc(1.0D); 
/* 143 */     RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile());
/* 144 */     if (s != null)
/* 145 */       return s.render((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade(), (SETT.ROOMS()).fData.candle.is(i.tile())); 
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 151 */     RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile());
/* 152 */     if (s != null)
/* 153 */       s.renderAbove((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade()); 
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 159 */     RoomSprite s = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(i.tile());
/* 160 */     if (s != null)
/* 161 */       s.renderBelow((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, getDegrade()); 
/* 162 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 167 */     FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tile);
/* 168 */     if (t != null)
/* 169 */       return t.availability; 
/* 170 */     return AVAILABILITY.ROOM;
/*     */   }
/*     */   
/*     */   private final void updateReachability() {
/* 174 */     boolean was = active();
/* 175 */     this.reachable = (SETT.PATH()).reachability.is(mX(), mY());
/*     */     
/* 177 */     if (!active() && was) {
/* 178 */       deactivateAction();
/* 179 */     } else if (active() && !was) {
/* 180 */       activateAction();
/*     */     } 
/* 182 */     this.work.activate(active());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 187 */     return (SETT.ROOMS()).map.is(tile, this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {}
/*     */ 
/*     */   
/*     */   public final boolean reachable() {
/* 195 */     return this.reachable;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void activate(boolean a) {
/* 200 */     if (active()) {
/* 201 */       deactivateAction();
/*     */     }
/*     */     
/* 204 */     this.active = a;
/*     */     
/* 206 */     if (active()) {
/* 207 */       activateAction();
/*     */     }
/*     */     
/* 210 */     this.work.activate(active());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int area() {
/* 221 */     return this.size;
/*     */   }
/*     */   
/*     */   public final boolean active() {
/* 225 */     return (this.exists && this.active && this.reachable);
/*     */   }
/*     */   
/*     */   public final void activate() {
/* 229 */     activate(true);
/* 230 */     update(0.0D, false);
/*     */   }
/*     */   
/*     */   public final void deactivate() {
/* 234 */     activate(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Str name(int tx, int ty) {
/* 239 */     return this.iname;
/*     */   }
/*     */   
/*     */   public Str name() {
/* 243 */     return this.iname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 250 */     return (RECTANGLE)this.tiles;
/*     */   }
/*     */ 
/*     */   
/*     */   public final TmpArea remove(int tx, int ty, boolean scatter, Object obj, boolean forced) {
/* 255 */     if (!this.exists)
/* 256 */       throw new RuntimeException(); 
/* 257 */     if (!is(tx, ty)) {
/* 258 */       throw new RuntimeException();
/*     */     }
/* 260 */     if (!canRemoveAndRemoveAction(tx, ty, scatter, obj, forced)) {
/* 261 */       return SETT.ROOMS().tmpArea(obj);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 266 */     (SETT.ROOMS()).stats.finished().remove(mX(), mY());
/* 267 */     deactivate();
/*     */     
/* 269 */     employees().dispose();
/*     */     
/* 271 */     dispose();
/*     */     
/* 273 */     if (scatter && constructor() != null) {
/* 274 */       Deleter.scatterMaterials(this, constructor(), upgrade(), getDegrade());
/*     */     }
/*     */ 
/*     */     
/* 278 */     for (COORDINATE c : body()) {
/* 279 */       if (!is(c))
/*     */         continue; 
/* 281 */       SETT.LIGHTS().remove(c.x(), c.y());
/* 282 */       (SETT.JOBS()).clearer.set(c);
/*     */       
/* 284 */       (SETT.ROOMS()).data.set(this, c, 0);
/* 285 */       if ((SETT.ROOMS()).fData.item.get(c) != null)
/* 286 */         ConstructionData.dConstructed.set(this, c, 1); 
/* 287 */       ConstructionData.dFloored.set(this, c, 1);
/*     */     } 
/*     */     
/* 290 */     this.exists = false;
/* 291 */     blueprintI().removeInstance(this);
/*     */     
/* 293 */     TmpArea a = (SETT.ROOMS()).map.delete(this, mX(), mY(), obj);
/* 294 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canRemoveAndRemoveAction(int tx, int ty, boolean scatter, Object obj, boolean forced) {
/* 299 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 304 */     ConstructionInit in = new ConstructionInit(this, mX(), mY(), true);
/* 305 */     TmpArea a = remove(tx, ty, false, this, true);
/* 306 */     (SETT.ROOMS()).construction.breakIt(a, in, tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 311 */     return !(((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(tx, ty)).player >= 0.0D && ((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(tx, ty)).enemy >= 0.0D);
/*     */   }
/*     */   
/*     */   public boolean acceptsWork() {
/* 315 */     return true;
/*     */   }
/*     */   
/*     */   public double getDegrade() {
/* 319 */     return Degrader.get(this.degrade);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 324 */     if (constructor() != null) {
/* 325 */       deg.ins = this;
/* 326 */       deg.fu = constructor();
/* 327 */       return deg;
/*     */     } 
/* 329 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 334 */     return this.fx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 339 */     return this.fy;
/*     */   }
/*     */   
/*     */   public final RoomEmploymentIns employees() {
/* 343 */     return this.work;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Furnisher constructor() {
/* 348 */     return blueprintI().constructor();
/*     */   }
/*     */ 
/*     */   
/*     */   public double isolation(int tx, int ty) {
/* 353 */     if (constructor() == null || !constructor().mustBeIndoors())
/* 354 */       return 1.0D; 
/* 355 */     return this.isolation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void isolationSet(int tx, int ty, double isolation) {
/* 360 */     this.isolation = (float)isolation;
/*     */   }
/*     */   
/* 363 */   private static final Degrader deg = new Degrader();
/*     */   
/*     */   public final double stat(int si) {
/* 366 */     if (this.stats == null)
/* 367 */       this.stats = new double[blueprintI().constructor().stats().size()]; 
/* 368 */     if (this.stats.length != blueprintI().constructor().stats().size()) {
/* 369 */       double[] ns = new double[blueprintI().constructor().stats().size()];
/* 370 */       for (int i = 0; i < ns.length && i < this.stats.length; i++)
/* 371 */         ns[i] = this.stats[i]; 
/* 372 */       this.stats = ns;
/*     */     } 
/* 374 */     return this.stats[si];
/*     */   }
/*     */ 
/*     */   
/*     */   public Icon icon() {
/* 379 */     return blueprintI().iconBig();
/*     */   }
/*     */   
/*     */   private static class Degrader
/*     */     extends ROOM_DEGRADER
/*     */   {
/*     */     private RoomInstance ins;
/*     */     private Furnisher fu;
/*     */     
/*     */     public int resSize() {
/* 389 */       return this.ins.constructor().resources();
/*     */     }
/*     */ 
/*     */     
/*     */     public int resAmount(int i) {
/* 394 */       return this.ins.resAmount(i, this.ins.upgrade());
/*     */     }
/*     */ 
/*     */     
/*     */     public RESOURCE res(int i) {
/* 399 */       return this.fu.resource(i);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double degRate() {
/* 405 */       return this.ins.blueprintI().degradeRate();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getData() {
/* 411 */       return this.ins.degrade;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void setData(int v, boolean realChange) {
/* 416 */       (this.ins.blueprintI()).averageDegrade -= (int)Math.ceil(100.0D * get());
/* 417 */       this.ins.degrade = v;
/* 418 */       (this.ins.blueprintI()).averageDegrade += (int)Math.ceil(100.0D * get());
/*     */     }
/*     */ 
/*     */     
/*     */     public int roomArea() {
/* 423 */       return this.ins.area();
/*     */     }
/*     */ 
/*     */     
/*     */     public double base() {
/* 428 */       return this.ins.blueprintI().degradeRate();
/*     */     }
/*     */ 
/*     */     
/*     */     public double expenseRate() {
/* 433 */       return this.ins.resMul;
/*     */     }
/*     */ 
/*     */     
/*     */     public double rate(double bonus) {
/* 438 */       double am = 0.0D;
/* 439 */       for (int ri = 0; ri < RoomInstance.deg.resSize(); ri++) {
/* 440 */         am += RoomInstance.deg.resAmount(ri);
/*     */       }
/* 442 */       return rate(bonus, base(), this.ins.isolation(this.ins.mX(), this.ins.mY()), am, this.ins.area());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int resAmount(int ri, int upgrade) {
/* 450 */     if (this.ress == null)
/* 451 */       this.ress = new double[blueprintI().constructor().resources()]; 
/* 452 */     if (this.stats.length != blueprintI().constructor().resources()) {
/* 453 */       double[] ns = new double[blueprintI().constructor().resources()];
/* 454 */       for (int i = 0; i < ns.length && i < this.ress.length; i++)
/* 455 */         ns[i] = this.ress[i]; 
/* 456 */       this.ress = ns;
/*     */     } 
/*     */     
/* 459 */     if (ri < this.ress.length)
/* 460 */       return (int)Math.ceil(this.ress[ri] * blueprintI().upgrades().resMask(upgrade, ri)); 
/* 461 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomState makeState(int rx, int ry, boolean broken) {
/* 467 */     return (RoomState)new RoomState.RoomStateInstance(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int upgrade() {
/* 474 */     return CLAMP.i(this.upgrade, 0, blueprintI().upgrades().max());
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int upgrade) {
/* 479 */     if (this.upgrade != upgrade) {
/* 480 */       (blueprintI()).upgrades -= this.upgrade * area();
/* 481 */       this.upgrade = (byte)upgrade;
/* 482 */       (blueprintI()).upgrades += this.upgrade * area();
/* 483 */       for (COORDINATE c : body()) {
/* 484 */         if (is(c)) {
/* 485 */           blueprintI().constructor().putFloor(c.x(), c.y(), upgrade, this);
/*     */         }
/* 487 */         SETT.MAINTENANCE().setChanged(c.x(), c.y());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract RoomBlueprintIns<? extends RoomInstance> blueprintI();
/*     */   
/*     */   protected abstract void activateAction();
/*     */   
/*     */   protected abstract void deactivateAction();
/*     */   
/*     */   protected abstract void dispose();
/*     */   
/*     */   public static abstract class SecretEmployment {
/*     */     protected abstract void update(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, double param1Double);
/*     */     
/*     */     protected abstract void activate(boolean param1Boolean);
/*     */     
/*     */     protected abstract void dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */