/*     */ package settlement.thing;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.sett.SETT_HOVERABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ScatteredResource
/*     */   extends THINGS.Thing
/*     */   implements COORDINATE, SETT_HOVERABLE, RESOURCE_TILE
/*     */ {
/* 262 */   private final Rec body = new Rec(64.0D);
/* 263 */   private final int random = RND.rInt();
/*     */   
/*     */   private int resource;
/*     */   private short amount;
/*     */   private short claimed;
/*     */   
/*     */   ScatteredResource(int i) {
/* 270 */     super(i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/* 275 */     this.body.save(f);
/* 276 */     RESOURCES.map().saver().save((MAPPED)resource(), f);
/* 277 */     f.s(this.amount);
/* 278 */     f.s(this.claimed);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/* 283 */     this.body.load(f);
/* 284 */     this.resource = RESOURCES.map().loader().loadI(f);
/* 285 */     if (this.resource < 0)
/* 286 */       this.resource = RESOURCES.WOOD().index(); 
/* 287 */     this.amount = f.s();
/* 288 */     this.claimed = f.s();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 294 */     int x = this.body.x1() + offsetX;
/* 295 */     int y = this.body.y1() + offsetY;
/* 296 */     if (this.amount <= 0) {
/* 297 */       (UI.icons()).s.cancel.render((SPRITE_RENDERER)r, x, y);
/*     */       return;
/*     */     } 
/* 300 */     resource().renderLaying((SPRITE_RENDERER)r, x, y, this.random, this.amount);
/* 301 */     shadows.setDistance2Ground(1.0D).setHeight(0);
/* 302 */     resource().renderLaying((SPRITE_RENDERER)shadows, x, y, this.random, this.amount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int init(int tx, int ty, RESOURCE r, int amount) {
/* 309 */     if (amount > 10000) {
/* 310 */       amount = 10000;
/*     */     }
/* 312 */     if (amount <= 0) {
/* 313 */       throw new RuntimeException("" + amount);
/*     */     }
/* 315 */     this.amount = (short)CLAMP.i(amount, 0, 10000);
/*     */     
/* 317 */     this.resource = r.bIndex();
/* 318 */     this.body.moveX1Y1((tx << 6), (ty << 6));
/* 319 */     this.claimed = 0;
/* 320 */     (SETT.PATH()).finders.resource.reportPresence(this);
/* 321 */     return amount - this.amount;
/*     */   }
/*     */ 
/*     */   
/*     */   private int increaseAmount(int amount) {
/* 326 */     if (amount == 0)
/* 327 */       return 0; 
/* 328 */     if (this.amount == 10000) {
/* 329 */       return amount;
/*     */     }
/* 331 */     boolean res = findableReservedCanBe();
/* 332 */     int ret = 0;
/*     */     
/* 334 */     int a = this.amount + amount;
/*     */     
/* 336 */     if (a > 10000) {
/* 337 */       ret = a - 10000;
/* 338 */       a = 10000;
/*     */     } 
/* 340 */     this.amount = (short)a;
/* 341 */     if (!res) {
/* 342 */       (SETT.PATH()).finders.resource.reportPresence(this);
/* 343 */       ThingsResources.this.evaluate(x(), y());
/*     */     } 
/* 345 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addAction() {
/* 350 */     ThingsResources.this.evaluate(x(), y());
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 355 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 360 */     return (RESOURCE)RESOURCES.ALL().get(this.resource);
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 365 */     return this.body.cX() >> 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 370 */     return this.body.cY() >> 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 375 */     if (this.claimed < this.amount) {
/* 376 */       this.claimed = (short)(this.claimed + 1);
/* 377 */       if (this.claimed == this.amount) {
/* 378 */         (SETT.PATH()).finders.resource.reportAbsence(this);
/* 379 */         ThingsResources.this.evaluate(x(), y());
/*     */       } 
/*     */     } else {
/* 382 */       GAME.Error(debug());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String debug() {
/* 388 */     return String.valueOf((resource()).name) + " " + String.valueOf((resource()).name) + " " + x() + " amount:" + y() + " claimed:" + this.amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 393 */     if (this.claimed == 0)
/*     */       return; 
/* 395 */     if (this.claimed == this.amount) {
/* 396 */       this.claimed = (short)(this.claimed - 1);
/* 397 */       (SETT.PATH()).finders.resource.reportPresence(this);
/* 398 */       ThingsResources.this.evaluate(ctx(), cty());
/*     */     } else {
/* 400 */       this.claimed = (short)(this.claimed - 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourcePickup() {
/* 406 */     if (this.claimed == 0)
/* 407 */       GAME.Error(debug()); 
/* 408 */     this.claimed = (short)(this.claimed - 1);
/* 409 */     this.amount = (short)(this.amount - 1);
/* 410 */     if (this.amount < this.claimed)
/* 411 */       GAME.Error(debug()); 
/* 412 */     if (this.amount == 0) {
/* 413 */       remove();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeUnreserved(int a) {
/* 418 */     if (this.claimed < this.amount) {
/* 419 */       this.claimed = (short)(this.claimed + a);
/* 420 */       if (this.claimed > this.amount)
/* 421 */         throw new RuntimeException(); 
/* 422 */       if (this.claimed == this.amount) {
/* 423 */         (SETT.PATH()).finders.resource.reportAbsence(this);
/* 424 */         ThingsResources.this.evaluate(x(), y());
/*     */       } 
/* 426 */       this.amount = (short)(this.amount - a);
/* 427 */       this.claimed = (short)(this.claimed - a);
/* 428 */       if (this.amount == 0)
/* 429 */         remove(); 
/*     */     } else {
/* 431 */       GAME.Error(debug());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 437 */     return (this.claimed > 0);
/*     */   }
/*     */   
/*     */   public int amountReserved() {
/* 441 */     return this.claimed;
/*     */   }
/*     */ 
/*     */   
/*     */   public int amount() {
/* 446 */     return this.amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int reservable() {
/* 451 */     return this.amount - this.claimed;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 456 */     return (this.amount > 0 && this.claimed < this.amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box) {
/* 462 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 463 */       ThingsResources.this.hoverRes[r.bIndex()] = 0;
/* 464 */       ThingsResources.this.allclaimed[r.bIndex()] = 0;
/*     */     } 
/*     */     
/* 467 */     for (THINGS.Thing t : SETT.THINGS().get(ctx(), ctx() + 1, cty(), cty() + 1)) {
/* 468 */       if (t instanceof ScatteredResource) {
/*     */         
/* 470 */         ScatteredResource r = (ScatteredResource)t;
/* 471 */         if (r.body.cX() != body().cX() || r.body().cY() != body().cY())
/*     */           continue; 
/* 473 */         ThingsResources.this.hoverRes[r.resource().bIndex()] = ThingsResources.this.hoverRes[r.resource().bIndex()] + r.amount();
/* 474 */         ThingsResources.this.allclaimed[r.resource().bIndex()] = ThingsResources.this.allclaimed[r.resource().bIndex()] + r.claimed;
/*     */       } 
/*     */     } 
/*     */     
/* 478 */     int i = 0;
/* 479 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 480 */       if (ThingsResources.this.hoverRes[r.bIndex()] != 0) {
/* 481 */         i++;
/* 482 */         box.text(r.name);
/* 483 */         box.setResource(r, ThingsResources.this.hoverRes[r.bIndex()]);
/* 484 */         if ((S.get()).developer) {
/* 485 */           GText text = box.text();
/* 486 */           text.add(' ').add(ThingsResources.this.allclaimed[r.bIndex()]);
/* 487 */           text.add(' ').add(ThingsResources.this.has(x(), y(), r.bit));
/* 488 */           text.add(' ').add((ThingsResources.this.getReservable(x(), y(), r.bit) != null));
/* 489 */           box.add((SPRITE)text);
/*     */         } 
/* 491 */         box.NL();
/*     */       } 
/* 493 */       if (i > 5) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeClicked() {
/* 501 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 506 */     if (this.claimed < this.amount) {
/* 507 */       (SETT.PATH()).finders.resource.reportAbsence(this);
/* 508 */       this.claimed = 0;
/* 509 */       this.amount = 0;
/*     */       
/* 511 */       ThingsResources.this.evaluate(x(), y());
/* 512 */       this.resource = -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int z() {
/* 518 */     return 99;
/*     */   }
/*     */ 
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/* 523 */     return (SETT.THINGS()).resources;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStorage() {
/* 528 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrio() {
/* 533 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsResources$ScatteredResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */