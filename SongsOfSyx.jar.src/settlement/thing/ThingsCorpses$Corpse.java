/*     */ package settlement.thing;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.spirte.HCorpseRenderer;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Corpse
/*     */   extends ThingFindable
/*     */   implements SETT_HOVERABLE, DRAGGABLE
/*     */ {
/*     */   private Induvidual indu;
/*     */   private byte direction;
/*     */   private float decay;
/* 331 */   private float flyTimer = 0.0F;
/*     */   private boolean intact;
/* 333 */   private int ran = RND.rInt();
/* 334 */   private Rec hitbox = new Rec();
/*     */   
/*     */   private CAUSE_LEAVE cause;
/* 337 */   private short sParent = -1;
/* 338 */   private short sNext = -1;
/*     */   
/*     */   private float res;
/*     */   private boolean claimed;
/*     */   private boolean inDangerZone = false;
/* 343 */   private int burryServiceTile = -1;
/*     */ 
/*     */   
/*     */   Corpse(int index) {
/* 347 */     super(index);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/* 352 */     this.indu.save(f);
/* 353 */     f.b(this.direction);
/* 354 */     f.f(this.decay);
/* 355 */     f.f(this.flyTimer);
/* 356 */     f.bool(this.intact);
/* 357 */     f.i(this.ran);
/* 358 */     this.hitbox.save(f);
/* 359 */     f.bool(this.claimed);
/* 360 */     f.b((byte)this.cause.index());
/* 361 */     f.s(this.sParent);
/* 362 */     f.s(this.sNext);
/* 363 */     f.f(this.res);
/* 364 */     f.i(this.burryServiceTile);
/* 365 */     f.bool(this.inDangerZone);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/* 370 */     this.indu = new Induvidual(f);
/* 371 */     this.direction = f.b();
/* 372 */     this.decay = f.f();
/* 373 */     this.flyTimer = f.f();
/* 374 */     this.intact = f.bool();
/* 375 */     this.ran = f.i();
/* 376 */     this.hitbox.load(f);
/* 377 */     this.claimed = f.bool();
/* 378 */     this.cause = (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(f.b());
/* 379 */     this.sParent = f.s();
/* 380 */     this.sNext = f.s();
/* 381 */     this.res = f.f();
/* 382 */     this.burryServiceTile = f.i();
/* 383 */     this.inDangerZone = f.bool();
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 388 */     return (RECTANGLE)this.hitbox;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 394 */     boolean inWater = (SETT.ENTITIES()).submerged.is(ctx(), cty());
/* 395 */     int x = this.hitbox.x1() + offsetX - (this.indu.race().appearance()).off;
/* 396 */     int y = this.hitbox.y1() + offsetY - (this.indu.race().appearance()).off;
/*     */ 
/*     */ 
/*     */     
/* 400 */     if (this.decay > 1.2D) {
/* 401 */       HCorpseRenderer.renderSkelleton(this.indu.race(), (this.indu.hType() != HTYPES.CHILD()), this.direction, inWater, r, shadows, this.ran, x, y);
/*     */     } else {
/* 403 */       float decay = (this.decay > 1.0F) ? 1.0F : this.decay;
/*     */       
/* 405 */       if (!(this.indu.race()).physics.decays) {
/* 406 */         decay = 0.0F;
/*     */       }
/* 408 */       (STATS.NEEDS()).DIRTINESS.setD(this.indu, decay);
/*     */       
/* 410 */       if (this.intact) {
/* 411 */         HCorpseRenderer.renderCorpse(this.indu, this.direction, inWater, decay, r, shadows, x, y, 0);
/*     */       } else {
/* 413 */         HCorpseRenderer.renderGore(this.indu, this.direction, inWater, decay, r, shadows, x, y);
/*     */       } 
/* 415 */       x = this.hitbox.cX() + offsetX;
/* 416 */       y = this.hitbox.cY() + offsetY;
/*     */       
/* 418 */       int d = (int)(5.0F * decay);
/* 419 */       if (d > 0) {
/* 420 */         this.flyTimer += ds * decay;
/* 421 */         if (this.flyTimer >= 0.0F) {
/* 422 */           this.flyTimer = -RND.rFloat(15.0D);
/* 423 */           (SETT.THINGS()).corpses.soundDecay.rnd(this.indu.race(), (RECTANGLE)this.hitbox);
/*     */         } 
/* 425 */         ThingsCorpses.flies.render(this.ran, d, x, y);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void init(Induvidual a, int cx, int cy, DIR d, boolean intact, CAUSE_LEAVE cause) {
/* 432 */     this.indu = a;
/* 433 */     this.intact = intact;
/* 434 */     this.decay = 0.0F;
/* 435 */     this.hitbox.setDim((a.race()).physics.hitBoxsize(), (a.race()).physics.hitBoxsize());
/* 436 */     this.hitbox.moveC(cx, cy);
/* 437 */     this.direction = (byte)d.id();
/* 438 */     this.flyTimer = -RND.rFloat(15.0D);
/* 439 */     this.claimed = false;
/* 440 */     this.cause = cause;
/* 441 */     this.res = (float)((intact ? 1.0D : 0.5D) * ((a.hType() == HTYPES.CHILD()) ? 0.25D : 1.0D));
/* 442 */     this.burryServiceTile = -1;
/* 443 */     (STATS.APPEARANCE()).dead.indu().set(a, 1);
/*     */     
/* 445 */     if (!(SETT.PATH()).reachability.is(ctx(), cty())) {
/* 446 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 447 */         if ((SETT.PATH()).reachability.is(ctx(), cty(), (DIR)DIR.ALL.get(di))) {
/* 448 */           this.hitbox.incrX((((DIR)DIR.ALL.get(di)).x() * 64));
/* 449 */           this.hitbox.incrY((((DIR)DIR.ALL.get(di)).y() * 64));
/*     */ 
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 460 */     add();
/* 461 */     updateDanger();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAction() {
/* 467 */     super.addAction();
/* 468 */     (SETT.THINGS()).corpses.holder.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 479 */     (SETT.THINGS()).corpses.holder.remove(this);
/* 480 */     super.removeAction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box) {
/* 488 */     (SETT.THINGS()).corpses.hov.cause = this.cause;
/* 489 */     (SETT.THINGS()).corpses.hov.indu = this.indu;
/* 490 */     box.add((RENDEROBJ)(SETT.THINGS()).corpses.hov);
/* 491 */     box.NL();
/*     */ 
/*     */     
/* 494 */     box.NL(2);
/*     */     
/* 496 */     box.textL(ThingsCorpses.¤¤burrial);
/* 497 */     box.NL();
/* 498 */     HCLASS c = this.indu.hType().parentClass();
/* 499 */     for (StatsBurial.StatGrave g : (this.indu.race().service()).GRAVES.get(c.index())) {
/*     */       
/* 501 */       box.add((SPRITE)(g.grave().blueprint()).icon);
/* 502 */       box.textLL((g.grave().blueprint()).info.name);
/* 503 */       box.tab(6);
/* 504 */       box.add(g.grave().permission().get(c, this.indu.race()) ? (SPRITE)(UI.icons()).m.ok : (SPRITE)(UI.icons()).m.cancel);
/* 505 */       box.NL();
/*     */     } 
/*     */ 
/*     */     
/* 509 */     box.add((SPRITE)(SETT.ROOMS()).DUMP.icon);
/* 510 */     box.textLL((SETT.ROOMS()).DUMP.info.name);
/* 511 */     box.tab(6);
/* 512 */     box.add((SPRITE)(UI.icons()).m.ok);
/* 513 */     box.NL();
/* 514 */     box.NL();
/*     */ 
/*     */     
/* 517 */     if (this.inDangerZone) {
/* 518 */       box.NL(8);
/* 519 */       box.text(ThingsCorpses.¤¤inDanger);
/*     */     } 
/*     */     
/* 522 */     if (findableReservedCanBe()) {
/* 523 */       box.NL(8);
/* 524 */       box.NL(8);
/* 525 */       box.text(ThingsCorpses.¤¤noClaim);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeClicked() {
/* 532 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void click() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected int z() {
/* 542 */     return 99;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update() {
/* 548 */     if (this.decay == 0.0F && (STATS.NEEDS()).INJURIES.COUNT.indu().getD(this.indu) > RND.rFloat()) {
/* 549 */       (SETT.THINGS()).gore.drops.make(body().cX(), body().cY(), 0.0D, 0.0D, (COLOR)ColorImp.TMP.set((this.indu.race().appearance()).colors.blood).shadeSelf(0.5D + 0.5D * (0.4D - this.decay)));
/*     */     }
/*     */     
/* 552 */     float d = 0.05F;
/*     */     
/* 554 */     this.decay += d * RND.rFloat();
/* 555 */     if ((this.decay > 2.5F && !findableReservedIs()) || this.decay > 20.0F) {
/* 556 */       HCLASS c = this.indu.hType().parentClass();
/* 557 */       for (StatsBurial.StatGrave g : (this.indu.race().service()).GRAVES.get(c.index())) {
/* 558 */         g.grave().get(c).fail(this, 1);
/*     */       }
/* 560 */       remove();
/*     */     } 
/* 562 */     if (this.inDangerZone)
/* 563 */       updateDanger(); 
/*     */   }
/*     */   
/*     */   private boolean inDangerZone() {
/* 567 */     int dist = (SETT.PATH()).comps.zero.size();
/* 568 */     for (DIR d : DIR.ALLC) {
/* 569 */       SComp0 sComp0 = (SETT.PATH()).comps.zero.get(ctx() + d.x() * dist, cty() + d.y() * dist);
/* 570 */       if (sComp0 != null) {
/* 571 */         if ((SETT.PATH()).comps.data.people(false).get((SComponent)sComp0) > 0)
/* 572 */           return true; 
/* 573 */         if ((SETT.PATH()).comps.data.reservableAnimals.get((SComponent)sComp0) > 0)
/* 574 */           return true; 
/*     */       } 
/*     */     } 
/* 577 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 583 */     return (!this.claimed && !this.inDangerZone);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 588 */     return this.claimed;
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 593 */     super.findableReserveCancel();
/* 594 */     updateDanger();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 599 */     return ctx();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 604 */     return cty();
/*     */   }
/*     */   
/*     */   private void updateDanger() {
/* 608 */     boolean dan = inDangerZone();
/* 609 */     if (this.inDangerZone == dan)
/*     */       return; 
/* 611 */     if (findableReservedCanBe())
/* 612 */       finder().report(this, -1); 
/* 613 */     this.inDangerZone = dan;
/* 614 */     if (findableReservedCanBe()) {
/* 615 */       finder().report(this, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void reserve(int d) {
/* 621 */     if (d == -1 && this.claimed) {
/* 622 */       this.claimed = false;
/* 623 */       this.burryServiceTile = -1;
/*     */     }
/* 625 */     else if (d == 1 && !this.claimed) {
/* 626 */       this.claimed = true;
/*     */     } else {
/* 628 */       throw new RuntimeException("" + d + " " + d);
/*     */     } 
/*     */   }
/*     */   
/*     */   public SFinderFindable finder() {
/* 633 */     return (SFinderFindable)(SETT.PATH()).finders.corpses;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drag(DIR d, int cx, int cy, int fromDist) {
/* 638 */     if (!this.claimed)
/* 639 */       throw new RuntimeException(); 
/* 640 */     this.direction = (byte)d.perpendicular().id();
/* 641 */     this.hitbox.moveC(cx - fromDist * d.xN(), cy - fromDist * d.yN());
/* 642 */     if (this.hitbox.cX() < 0)
/* 643 */       this.hitbox.moveCX(0.0D); 
/* 644 */     if (this.hitbox.cX() >= SETT.PIXEL_BOUNDS.x2())
/* 645 */       this.hitbox.moveCX((SETT.PIXEL_BOUNDS.x2() - 1)); 
/* 646 */     if (this.hitbox.cY() < 0)
/* 647 */       this.hitbox.moveCY(0.0D); 
/* 648 */     if (this.hitbox.cY() >= SETT.PIXEL_BOUNDS.y2())
/* 649 */       this.hitbox.moveCY((SETT.PIXEL_BOUNDS.y2() - 1)); 
/* 650 */     move();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drag(DIR d, int cx, int cy) {
/* 655 */     drag(d, cx, cy, body().width());
/*     */   }
/*     */   
/*     */   public boolean hasMeat() {
/* 659 */     return (this.decay < 2.0F);
/*     */   }
/*     */   
/*     */   public void removeMeat() {
/* 663 */     if (this.decay < 2.0F) {
/* 664 */       this.decay = 2.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/* 669 */     return (SETT.THINGS()).corpses;
/*     */   }
/*     */   
/*     */   public CAUSE_LEAVE cause() {
/* 673 */     return this.cause;
/*     */   }
/*     */   
/*     */   public Induvidual indu() {
/* 677 */     return this.indu;
/*     */   }
/*     */   
/*     */   public double resLeft() {
/* 681 */     return this.res * (1.0D - this.decay);
/*     */   }
/*     */   
/*     */   public void resRemove() {
/* 685 */     this.res = (float)(this.res - 0.25D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeDragged() {
/* 691 */     return (this.claimed && !isRemoved());
/*     */   }
/*     */   
/*     */   public Race race() {
/* 695 */     return this.indu.race();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsCorpses$Corpse.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */