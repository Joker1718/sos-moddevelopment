/*     */ package settlement.thing;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HCorpseRenderer;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.sett.SETT_HOVERABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThingsCorpses
/*     */   extends THINGS.ThingFactory<ThingsCorpses.Corpse>
/*     */ {
/*     */   public static final int MAX = 8192;
/*  55 */   private final Corpse[] corpses = new Corpse[8192];
/*  56 */   private final SpecialHolder holder = new SpecialHolder();
/*  57 */   private static String ¤¤burrial = "¤Burial Priority";
/*  58 */   private static String ¤¤inDanger = "¤This corpse is in a dangerous zone, and will not be fetched.";
/*  59 */   private static String ¤¤noClaim = "¤No one has claimed these remains .";
/*  60 */   private final Hov hov = new Hov();
/*  61 */   private static CharSequence ¤¤Cause = "¤Death Cause:";
/*  62 */   private static CharSequence ¤¤Corpse = "¤Remains";
/*     */   
/*  64 */   public final SoundRace soundDecay = AUDIO.race("ROTTING_CORPSE");
/*     */   
/*     */   static {
/*  67 */     D.ts(ThingsCorpses.class);
/*     */   }
/*  69 */   private final IUpdater updater = new IUpdater(this.corpses.length, 100.0D)
/*     */     {
/*     */       protected void update(int i, double timeSinceLast)
/*     */       {
/*  73 */         if (!ThingsCorpses.this.corpses[i].isRemoved()) {
/*  74 */           ThingsCorpses.this.corpses[i].update();
/*     */         }
/*     */       }
/*     */     };
/*     */   
/*  79 */   public final DRAGGABLE.DRAGGABLE_HOLDER draggable = new DRAGGABLE.DRAGGABLE_HOLDER()
/*     */     {
/*     */       public DRAGGABLE draggable(int index)
/*     */       {
/*  83 */         return ThingsCorpses.this.corpses[index];
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public ThingsCorpses(LISTE<THINGS.ThingFactory<?>> all) {
/*  89 */     super(all, 8192);
/*  90 */     for (int i = 0; i < this.corpses.length; i++) {
/*  91 */       this.corpses[i] = new Corpse(i);
/*     */     }
/*     */     
/*  94 */     Arrays.fill(this.holder.amounts, 0);
/*  95 */     Arrays.fill(this.holder.firsts, -1);
/*  96 */     Arrays.fill(this.holder.lasts, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Corpse[] all() {
/* 101 */     return this.corpses;
/*     */   }
/*     */ 
/*     */   
/*     */   public Corpse create(Humanoid h, boolean intact, CAUSE_LEAVE cause) {
/* 106 */     return create(h.indu(), h.body().cX(), h.body().cY(), h.speed.dir(), intact, cause);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Corpse create(Induvidual a, int cx, int cy, DIR d, boolean intact, CAUSE_LEAVE cause) {
/* 112 */     if (!cause.leavesCorpse) {
/* 113 */       return null;
/*     */     }
/* 115 */     if (remainingToAdd() == 0) {
/* 116 */       return null;
/*     */     }
/* 118 */     if ((SETT.TERRAIN()).WATER.DEEP.is(cx >> 6, cy >> 6)) {
/* 119 */       return null;
/*     */     }
/* 121 */     Corpse c = nextInLine();
/*     */     
/* 123 */     if (!c.isRemoved()) {
/* 124 */       throw new RuntimeException();
/*     */     }
/*     */     
/* 127 */     c.init(a, cx, cy, d, intact, cause);
/* 128 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public Corpse getByIndex(short index) {
/* 133 */     if (index < 0 || index >= this.corpses.length)
/* 134 */       return null; 
/* 135 */     if (this.corpses[index].isRemoved())
/* 136 */       return null; 
/* 137 */     return this.corpses[index];
/*     */   }
/*     */ 
/*     */   
/*     */   public String debug(int index) {
/* 142 */     return "" + this.corpses[index].isRemoved() + " " + this.corpses[index].isRemoved() + " " + this.corpses[index].ctx();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 148 */     this.updater.update(ds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 155 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 160 */     clear();
/* 161 */     super.load(file); byte b; int i;
/*     */     Corpse[] arrayOfCorpse;
/* 163 */     for (i = (arrayOfCorpse = this.corpses).length, b = 0; b < i; ) { Corpse c = arrayOfCorpse[b];
/* 164 */       if (!c.isRemoved()) {
/* 165 */         this.holder.add(c);
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   protected void clear() {
/* 172 */     for (int i = 0; i < this.corpses.length; i++)
/* 173 */       this.corpses[i] = new Corpse(i); 
/* 174 */     super.clear();
/* 175 */     Arrays.fill(this.holder.amounts, 0);
/* 176 */     Arrays.fill(this.holder.amountsPlayer, 0);
/* 177 */     Arrays.fill(this.holder.firsts, -1);
/* 178 */     Arrays.fill(this.holder.lasts, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int nrOfCorpses() {
/* 183 */     return added();
/*     */   }
/*     */   
/*     */   public int amount(CAUSE_LEAVE l) {
/* 187 */     return this.holder.amount(l);
/*     */   }
/*     */   
/*     */   public Corpse getFirst(CAUSE_LEAVE l) {
/* 191 */     return this.holder.getFirst(l);
/*     */   }
/*     */   
/*     */   public Corpse getNext(Corpse corpse) {
/* 195 */     return this.holder.getNext(corpse);
/*     */   }
/*     */   
/* 198 */   static final Flies flies = new Flies();
/*     */   
/*     */   final class SpecialHolder
/*     */   {
/* 202 */     private final int[] amounts = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/* 203 */     private final int[] amountsPlayer = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/* 204 */     private final int[] firsts = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/* 205 */     private final int[] lasts = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/*     */ 
/*     */     
/*     */     void add(ThingsCorpses.Corpse corpse) {
/* 209 */       int i = corpse.cause.indexDeath;
/* 210 */       corpse.sParent = -1;
/* 211 */       corpse.sNext = -1;
/* 212 */       if (this.firsts[i] == -1) {
/* 213 */         this.firsts[i] = corpse.index();
/* 214 */         this.lasts[i] = corpse.index();
/*     */       } else {
/* 216 */         (ThingsCorpses.this.corpses[this.lasts[i]]).sNext = corpse.index();
/* 217 */         corpse.sParent = ThingsCorpses.this.corpses[this.lasts[i]].index();
/* 218 */         this.lasts[i] = corpse.index();
/*     */       } 
/* 220 */       this.amounts[i] = this.amounts[i] + 1;
/* 221 */       if (corpse.indu.player()) {
/* 222 */         this.amountsPlayer[i] = this.amountsPlayer[i] + 1;
/*     */       }
/*     */     }
/*     */     
/*     */     void remove(ThingsCorpses.Corpse corpse) {
/* 227 */       int i = corpse.cause.indexDeath;
/* 228 */       if (corpse.sParent != -1) {
/* 229 */         (ThingsCorpses.this.corpses[corpse.sParent]).sNext = corpse.sNext;
/*     */       }
/* 231 */       if (corpse.sNext != -1) {
/* 232 */         (ThingsCorpses.this.corpses[corpse.sNext]).sParent = corpse.sParent;
/*     */       }
/* 234 */       if (this.firsts[i] == corpse.index())
/* 235 */         this.firsts[i] = corpse.sNext; 
/* 236 */       if (this.lasts[i] == corpse.index()) {
/* 237 */         this.lasts[i] = corpse.sParent;
/*     */       }
/* 239 */       corpse.sNext = -1;
/* 240 */       corpse.sParent = -1;
/* 241 */       this.amounts[i] = this.amounts[i] - 1;
/* 242 */       if (corpse.indu.player())
/* 243 */         this.amountsPlayer[i] = this.amountsPlayer[i] - 1; 
/*     */     }
/*     */     
/*     */     int amount(CAUSE_LEAVE l) {
/* 247 */       if (!l.death)
/* 248 */         return 0; 
/* 249 */       return this.amountsPlayer[l.indexDeath];
/*     */     }
/*     */     
/*     */     public ThingsCorpses.Corpse getFirst(CAUSE_LEAVE l) {
/* 253 */       if (this.firsts[l.indexDeath] != -1)
/* 254 */         return ThingsCorpses.this.corpses[this.firsts[l.indexDeath]]; 
/* 255 */       return null;
/*     */     }
/*     */     
/*     */     public ThingsCorpses.Corpse getNext(ThingsCorpses.Corpse corpse) {
/* 259 */       if (corpse.sNext == -1)
/* 260 */         return null; 
/* 261 */       return ThingsCorpses.this.corpses[corpse.sNext];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Flies
/*     */   {
/* 269 */     private final int frames = 64;
/* 270 */     private final int flies = 64;
/* 271 */     private final int dim = 128;
/* 272 */     private final byte[] positions = Alloc.bb(8192);
/*     */ 
/*     */     
/*     */     Flies() {
/* 276 */       for (int f = 0; f < 64; f++) {
/* 277 */         int x = (int)(RND.rFloat0(1.0D) * RND.rFloat() * 128.0F);
/* 278 */         int y = (int)(RND.rFloat0(1.0D) * RND.rFloat() * 128.0F);
/* 279 */         double dx = (RND.rFloat() * 1.0F * (RND.rBoolean() ? true : -1));
/* 280 */         double dy = (RND.rFloat() * 1.0F * (RND.rBoolean() ? true : -1)); int k;
/* 281 */         for (k = 0; k <= 32; k++) {
/* 282 */           int i = f * 64 * 2 + k * 2;
/* 283 */           this.positions[i] = (byte)x;
/* 284 */           this.positions[i + 1] = (byte)y;
/* 285 */           x = (int)(x + RND.rInt0(3) + dx);
/* 286 */           y = (int)(y + RND.rInt0(3) + dy);
/* 287 */           dx += RND.rFloat0(1.0D);
/* 288 */           dy += RND.rFloat0(1.0D);
/* 289 */           if (x > 128)
/* 290 */             x -= 4; 
/* 291 */           if (y > 128)
/* 292 */             y -= 4; 
/*     */         } 
/* 294 */         for (k = 1; k < 32; k++) {
/* 295 */           int o = f * 64 * 2 + (32 - k) * 2;
/* 296 */           int n = f * 64 * 2 + (32 + k) * 2;
/* 297 */           this.positions[n] = this.positions[o];
/* 298 */           this.positions[n + 1] = this.positions[o + 1];
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void render(int ran, int amount, int x, int y) {
/* 305 */       if (amount <= 0)
/*     */         return; 
/* 307 */       COLOR.WHITE20.bind();
/* 308 */       ran &= 0x3F;
/* 309 */       for (int i = 0; i < amount; i++) {
/*     */         
/* 311 */         int k = ran * 64 * 2;
/* 312 */         k += (GAME.intervals().get20() + i * 20) % 64 * 2;
/* 313 */         CORE.renderer().renderParticle(x + this.positions[k], y + this.positions[k + 1]);
/*     */         
/* 315 */         ran++;
/* 316 */         ran &= 0x3F;
/*     */       } 
/*     */       
/* 319 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Corpse
/*     */     extends ThingFindable
/*     */     implements SETT_HOVERABLE, DRAGGABLE
/*     */   {
/*     */     private Induvidual indu;
/*     */     private byte direction;
/*     */     private float decay;
/* 331 */     private float flyTimer = 0.0F;
/*     */     private boolean intact;
/* 333 */     private int ran = RND.rInt();
/* 334 */     private Rec hitbox = new Rec();
/*     */     
/*     */     private CAUSE_LEAVE cause;
/* 337 */     private short sParent = -1;
/* 338 */     private short sNext = -1;
/*     */     
/*     */     private float res;
/*     */     private boolean claimed;
/*     */     private boolean inDangerZone = false;
/* 343 */     private int burryServiceTile = -1;
/*     */ 
/*     */     
/*     */     Corpse(int index) {
/* 347 */       super(index);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void save(FilePutter f) {
/* 352 */       this.indu.save(f);
/* 353 */       f.b(this.direction);
/* 354 */       f.f(this.decay);
/* 355 */       f.f(this.flyTimer);
/* 356 */       f.bool(this.intact);
/* 357 */       f.i(this.ran);
/* 358 */       this.hitbox.save(f);
/* 359 */       f.bool(this.claimed);
/* 360 */       f.b((byte)this.cause.index());
/* 361 */       f.s(this.sParent);
/* 362 */       f.s(this.sNext);
/* 363 */       f.f(this.res);
/* 364 */       f.i(this.burryServiceTile);
/* 365 */       f.bool(this.inDangerZone);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void load(FileGetter f) throws IOException {
/* 370 */       this.indu = new Induvidual(f);
/* 371 */       this.direction = f.b();
/* 372 */       this.decay = f.f();
/* 373 */       this.flyTimer = f.f();
/* 374 */       this.intact = f.bool();
/* 375 */       this.ran = f.i();
/* 376 */       this.hitbox.load(f);
/* 377 */       this.claimed = f.bool();
/* 378 */       this.cause = (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(f.b());
/* 379 */       this.sParent = f.s();
/* 380 */       this.sNext = f.s();
/* 381 */       this.res = f.f();
/* 382 */       this.burryServiceTile = f.i();
/* 383 */       this.inDangerZone = f.bool();
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 388 */       return (RECTANGLE)this.hitbox;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 394 */       boolean inWater = (SETT.ENTITIES()).submerged.is(ctx(), cty());
/* 395 */       int x = this.hitbox.x1() + offsetX - (this.indu.race().appearance()).off;
/* 396 */       int y = this.hitbox.y1() + offsetY - (this.indu.race().appearance()).off;
/*     */ 
/*     */ 
/*     */       
/* 400 */       if (this.decay > 1.2D) {
/* 401 */         HCorpseRenderer.renderSkelleton(this.indu.race(), (this.indu.hType() != HTYPES.CHILD()), this.direction, inWater, r, shadows, this.ran, x, y);
/*     */       } else {
/* 403 */         float decay = (this.decay > 1.0F) ? 1.0F : this.decay;
/*     */         
/* 405 */         if (!(this.indu.race()).physics.decays) {
/* 406 */           decay = 0.0F;
/*     */         }
/* 408 */         (STATS.NEEDS()).DIRTINESS.setD(this.indu, decay);
/*     */         
/* 410 */         if (this.intact) {
/* 411 */           HCorpseRenderer.renderCorpse(this.indu, this.direction, inWater, decay, r, shadows, x, y, 0);
/*     */         } else {
/* 413 */           HCorpseRenderer.renderGore(this.indu, this.direction, inWater, decay, r, shadows, x, y);
/*     */         } 
/* 415 */         x = this.hitbox.cX() + offsetX;
/* 416 */         y = this.hitbox.cY() + offsetY;
/*     */         
/* 418 */         int d = (int)(5.0F * decay);
/* 419 */         if (d > 0) {
/* 420 */           this.flyTimer += ds * decay;
/* 421 */           if (this.flyTimer >= 0.0F) {
/* 422 */             this.flyTimer = -RND.rFloat(15.0D);
/* 423 */             (SETT.THINGS()).corpses.soundDecay.rnd(this.indu.race(), (RECTANGLE)this.hitbox);
/*     */           } 
/* 425 */           ThingsCorpses.flies.render(this.ran, d, x, y);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void init(Induvidual a, int cx, int cy, DIR d, boolean intact, CAUSE_LEAVE cause) {
/* 432 */       this.indu = a;
/* 433 */       this.intact = intact;
/* 434 */       this.decay = 0.0F;
/* 435 */       this.hitbox.setDim((a.race()).physics.hitBoxsize(), (a.race()).physics.hitBoxsize());
/* 436 */       this.hitbox.moveC(cx, cy);
/* 437 */       this.direction = (byte)d.id();
/* 438 */       this.flyTimer = -RND.rFloat(15.0D);
/* 439 */       this.claimed = false;
/* 440 */       this.cause = cause;
/* 441 */       this.res = (float)((intact ? 1.0D : 0.5D) * ((a.hType() == HTYPES.CHILD()) ? 0.25D : 1.0D));
/* 442 */       this.burryServiceTile = -1;
/* 443 */       (STATS.APPEARANCE()).dead.indu().set(a, 1);
/*     */       
/* 445 */       if (!(SETT.PATH()).reachability.is(ctx(), cty())) {
/* 446 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 447 */           if ((SETT.PATH()).reachability.is(ctx(), cty(), (DIR)DIR.ALL.get(di))) {
/* 448 */             this.hitbox.incrX((((DIR)DIR.ALL.get(di)).x() * 64));
/* 449 */             this.hitbox.incrY((((DIR)DIR.ALL.get(di)).y() * 64));
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 460 */       add();
/* 461 */       updateDanger();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void addAction() {
/* 467 */       super.addAction();
/* 468 */       (SETT.THINGS()).corpses.holder.add(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void removeAction() {
/* 479 */       (SETT.THINGS()).corpses.holder.remove(this);
/* 480 */       super.removeAction();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox box) {
/* 488 */       (SETT.THINGS()).corpses.hov.cause = this.cause;
/* 489 */       (SETT.THINGS()).corpses.hov.indu = this.indu;
/* 490 */       box.add((RENDEROBJ)(SETT.THINGS()).corpses.hov);
/* 491 */       box.NL();
/*     */ 
/*     */       
/* 494 */       box.NL(2);
/*     */       
/* 496 */       box.textL(ThingsCorpses.¤¤burrial);
/* 497 */       box.NL();
/* 498 */       HCLASS c = this.indu.hType().parentClass();
/* 499 */       for (StatsBurial.StatGrave g : (this.indu.race().service()).GRAVES.get(c.index())) {
/*     */         
/* 501 */         box.add((SPRITE)(g.grave().blueprint()).icon);
/* 502 */         box.textLL((g.grave().blueprint()).info.name);
/* 503 */         box.tab(6);
/* 504 */         box.add(g.grave().permission().get(c, this.indu.race()) ? (SPRITE)(UI.icons()).m.ok : (SPRITE)(UI.icons()).m.cancel);
/* 505 */         box.NL();
/*     */       } 
/*     */ 
/*     */       
/* 509 */       box.add((SPRITE)(SETT.ROOMS()).DUMP.icon);
/* 510 */       box.textLL((SETT.ROOMS()).DUMP.info.name);
/* 511 */       box.tab(6);
/* 512 */       box.add((SPRITE)(UI.icons()).m.ok);
/* 513 */       box.NL();
/* 514 */       box.NL();
/*     */ 
/*     */       
/* 517 */       if (this.inDangerZone) {
/* 518 */         box.NL(8);
/* 519 */         box.text(ThingsCorpses.¤¤inDanger);
/*     */       } 
/*     */       
/* 522 */       if (findableReservedCanBe()) {
/* 523 */         box.NL(8);
/* 524 */         box.NL(8);
/* 525 */         box.text(ThingsCorpses.¤¤noClaim);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean canBeClicked() {
/* 532 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void click() {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected int z() {
/* 542 */       return 99;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void update() {
/* 548 */       if (this.decay == 0.0F && (STATS.NEEDS()).INJURIES.COUNT.indu().getD(this.indu) > RND.rFloat()) {
/* 549 */         (SETT.THINGS()).gore.drops.make(body().cX(), body().cY(), 0.0D, 0.0D, (COLOR)ColorImp.TMP.set((this.indu.race().appearance()).colors.blood).shadeSelf(0.5D + 0.5D * (0.4D - this.decay)));
/*     */       }
/*     */       
/* 552 */       float d = 0.05F;
/*     */       
/* 554 */       this.decay += d * RND.rFloat();
/* 555 */       if ((this.decay > 2.5F && !findableReservedIs()) || this.decay > 20.0F) {
/* 556 */         HCLASS c = this.indu.hType().parentClass();
/* 557 */         for (StatsBurial.StatGrave g : (this.indu.race().service()).GRAVES.get(c.index())) {
/* 558 */           g.grave().get(c).fail(this, 1);
/*     */         }
/* 560 */         remove();
/*     */       } 
/* 562 */       if (this.inDangerZone)
/* 563 */         updateDanger(); 
/*     */     }
/*     */     
/*     */     private boolean inDangerZone() {
/* 567 */       int dist = (SETT.PATH()).comps.zero.size();
/* 568 */       for (DIR d : DIR.ALLC) {
/* 569 */         SComp0 sComp0 = (SETT.PATH()).comps.zero.get(ctx() + d.x() * dist, cty() + d.y() * dist);
/* 570 */         if (sComp0 != null) {
/* 571 */           if ((SETT.PATH()).comps.data.people(false).get((SComponent)sComp0) > 0)
/* 572 */             return true; 
/* 573 */           if ((SETT.PATH()).comps.data.reservableAnimals.get((SComponent)sComp0) > 0)
/* 574 */             return true; 
/*     */         } 
/*     */       } 
/* 577 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean findableReservedCanBe() {
/* 583 */       return (!this.claimed && !this.inDangerZone);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean findableReservedIs() {
/* 588 */       return this.claimed;
/*     */     }
/*     */ 
/*     */     
/*     */     public void findableReserveCancel() {
/* 593 */       super.findableReserveCancel();
/* 594 */       updateDanger();
/*     */     }
/*     */ 
/*     */     
/*     */     public int x() {
/* 599 */       return ctx();
/*     */     }
/*     */ 
/*     */     
/*     */     public int y() {
/* 604 */       return cty();
/*     */     }
/*     */     
/*     */     private void updateDanger() {
/* 608 */       boolean dan = inDangerZone();
/* 609 */       if (this.inDangerZone == dan)
/*     */         return; 
/* 611 */       if (findableReservedCanBe())
/* 612 */         finder().report(this, -1); 
/* 613 */       this.inDangerZone = dan;
/* 614 */       if (findableReservedCanBe()) {
/* 615 */         finder().report(this, 1);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected void reserve(int d) {
/* 621 */       if (d == -1 && this.claimed) {
/* 622 */         this.claimed = false;
/* 623 */         this.burryServiceTile = -1;
/*     */       }
/* 625 */       else if (d == 1 && !this.claimed) {
/* 626 */         this.claimed = true;
/*     */       } else {
/* 628 */         throw new RuntimeException("" + d + " " + d);
/*     */       } 
/*     */     }
/*     */     
/*     */     public SFinderFindable finder() {
/* 633 */       return (SFinderFindable)(SETT.PATH()).finders.corpses;
/*     */     }
/*     */ 
/*     */     
/*     */     public void drag(DIR d, int cx, int cy, int fromDist) {
/* 638 */       if (!this.claimed)
/* 639 */         throw new RuntimeException(); 
/* 640 */       this.direction = (byte)d.perpendicular().id();
/* 641 */       this.hitbox.moveC(cx - fromDist * d.xN(), cy - fromDist * d.yN());
/* 642 */       if (this.hitbox.cX() < 0)
/* 643 */         this.hitbox.moveCX(0.0D); 
/* 644 */       if (this.hitbox.cX() >= SETT.PIXEL_BOUNDS.x2())
/* 645 */         this.hitbox.moveCX((SETT.PIXEL_BOUNDS.x2() - 1)); 
/* 646 */       if (this.hitbox.cY() < 0)
/* 647 */         this.hitbox.moveCY(0.0D); 
/* 648 */       if (this.hitbox.cY() >= SETT.PIXEL_BOUNDS.y2())
/* 649 */         this.hitbox.moveCY((SETT.PIXEL_BOUNDS.y2() - 1)); 
/* 650 */       move();
/*     */     }
/*     */ 
/*     */     
/*     */     public void drag(DIR d, int cx, int cy) {
/* 655 */       drag(d, cx, cy, body().width());
/*     */     }
/*     */     
/*     */     public boolean hasMeat() {
/* 659 */       return (this.decay < 2.0F);
/*     */     }
/*     */     
/*     */     public void removeMeat() {
/* 663 */       if (this.decay < 2.0F) {
/* 664 */         this.decay = 2.0F;
/*     */       }
/*     */     }
/*     */     
/*     */     public THINGS.ThingFactory<?> factory() {
/* 669 */       return (SETT.THINGS()).corpses;
/*     */     }
/*     */     
/*     */     public CAUSE_LEAVE cause() {
/* 673 */       return this.cause;
/*     */     }
/*     */     
/*     */     public Induvidual indu() {
/* 677 */       return this.indu;
/*     */     }
/*     */     
/*     */     public double resLeft() {
/* 681 */       return this.res * (1.0D - this.decay);
/*     */     }
/*     */     
/*     */     public void resRemove() {
/* 685 */       this.res = (float)(this.res - 0.25D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean canBeDragged() {
/* 691 */       return (this.claimed && !isRemoved());
/*     */     }
/*     */     
/*     */     public Race race() {
/* 695 */       return this.indu.race();
/*     */     }
/*     */   }
/*     */   
/*     */   private final class Hov
/*     */     extends GuiSection
/*     */   {
/*     */     private Induvidual indu;
/*     */     private CAUSE_LEAVE cause;
/*     */     
/*     */     Hov() {
/* 706 */       addRightC(0, (SPRITE)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 710 */               text.color(COLOR.WHITE85);
/* 711 */               text.add((ThingsCorpses.Hov.this.indu.race()).info.namePosessive).s().add(ThingsCorpses.¤¤Corpse);
/*     */             }
/* 713 */           }).increase());
/*     */       
/* 715 */       add((SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 719 */               text.color(COLOR.WHITE85);
/* 720 */               int age = (int)Math.ceil((STATS.POP()).age.years.getD(ThingsCorpses.Hov.this.indu));
/* 721 */               text.clear().add(STATS.APPEARANCE().name(ThingsCorpses.Hov.this.indu)).add(',').s().add(age).add(',').s().add((ThingsCorpses.Hov.this.indu.hType()).name);
/*     */             }
/*     */           }, 
/*     */ 
/*     */           
/* 726 */           0, body().y2() + 2);
/*     */       
/* 728 */       addDown(2, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 732 */               text.color(COLOR.WHITE85);
/* 733 */               text.add(ThingsCorpses.¤¤Cause).s().add(ThingsCorpses.Hov.this.cause.name);
/*     */             }
/*     */           });
/*     */       
/* 737 */       addRelBody(8, DIR.W, (SPRITE)new SPRITE.Imp(80, 128)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 740 */               STATS.APPEARANCE().portraitRender(r, ThingsCorpses.Hov.this.indu, X1, Y1, 2);
/* 741 */               OPACITY.O25.bind();
/* 742 */               COLOR.BLACK.render(r, X1, X2, Y1, Y2);
/* 743 */               OPACITY.unbind();
/*     */             }
/*     */           });
/*     */       
/* 747 */       body().setWidth(500.0D);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsCorpses.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */