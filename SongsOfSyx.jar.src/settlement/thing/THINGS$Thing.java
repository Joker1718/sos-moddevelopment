/*     */ package settlement.thing;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectStreamException;
/*     */ import settlement.entity.ESpeed;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Thing
/*     */   implements BODY_HOLDER
/*     */ {
/* 435 */   private short ix = -1;
/* 436 */   private short iy = -1;
/* 437 */   short addedNext = -1;
/* 438 */   short addedPrev = -1;
/*     */   private final short index;
/*     */   private Thing next;
/*     */   private Thing prev;
/* 442 */   protected final RBIT.RBITImp resourcemask = new RBIT.RBITImp();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, float paramFloat, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Thing(int index) {
/* 453 */     this.index = (short)index;
/*     */   }
/*     */   
/*     */   public final boolean isRemoved() {
/* 457 */     return (this.ix == -1);
/*     */   }
/*     */   
/*     */   public final void remove() {
/* 461 */     if (this.ix == -1)
/* 462 */       throw new RuntimeException(); 
/* 463 */     THINGS m = SETT.THINGS();
/* 464 */     this.resourcemask.clear();
/* 465 */     if (this.next != null) {
/* 466 */       this.next.prev = this.prev;
/*     */     }
/* 468 */     if (this.prev != null) {
/* 469 */       this.prev.next = this.next;
/*     */     }
/*     */     
/* 472 */     if (m.grid[this.iy][this.ix] == this) {
/* 473 */       m.grid[this.iy][this.ix] = this.next;
/*     */     }
/*     */     
/* 476 */     this.next = null;
/* 477 */     this.prev = null;
/* 478 */     this.ix = -1;
/* 479 */     factory().remove(this);
/* 480 */     removeAction();
/*     */   }
/*     */   
/*     */   Object readResolve() throws ObjectStreamException {
/* 484 */     if (!isRemoved())
/* 485 */       addColdAsHell(); 
/* 486 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {}
/*     */ 
/*     */   
/*     */   final void addColdAsHell() {
/* 499 */     THINGS m = SETT.THINGS();
/* 500 */     this.next = null;
/* 501 */     if (m.grid[this.iy][this.ix] == null) {
/* 502 */       m.grid[this.iy][this.ix] = this;
/*     */       
/*     */       return;
/*     */     } 
/* 506 */     this.resourcemask.or((RBIT)(m.grid[this.iy][this.ix]).resourcemask);
/*     */     
/* 508 */     if (m.grid[this.iy][this.ix].z() >= z()) {
/* 509 */       (m.grid[this.iy][this.ix]).prev = this;
/* 510 */       this.next = m.grid[this.iy][this.ix];
/* 511 */       m.grid[this.iy][this.ix] = this;
/*     */       
/*     */       return;
/*     */     } 
/* 515 */     Thing parent = m.grid[this.iy][this.ix];
/* 516 */     while (parent.next != null && parent.next.z() < z()) {
/* 517 */       parent = parent.next;
/*     */     }
/* 519 */     if (parent.next != null) {
/* 520 */       parent.next.prev = this;
/* 521 */       this.next = parent.next;
/*     */     } 
/*     */     
/* 524 */     parent.next = this;
/* 525 */     this.prev = parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void add() {
/* 533 */     if (this.ix != -1)
/* 534 */       throw new RuntimeException(); 
/* 535 */     this.ix = (short)ctx();
/* 536 */     this.iy = (short)cty();
/* 537 */     if (!SETT.TILE_BOUNDS.holdsPoint(this.ix, this.iy)) {
/* 538 */       this.ix = -1;
/*     */       
/*     */       return;
/*     */     } 
/* 542 */     addColdAsHell();
/* 543 */     if (factory() != null)
/* 544 */       factory().add(this); 
/* 545 */     addAction();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void move(ESpeed speed, double ds, float restituion, RECTANGLEE body, boolean tileCollide) {
/* 551 */     body.incrX(speed.x() * ds);
/* 552 */     body.incrY(speed.y() * ds);
/*     */     
/* 554 */     if (this.ix != ctx() || this.iy != cty()) {
/* 555 */       if (!isRemoved())
/* 556 */         remove(); 
/* 557 */       add();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void move() {
/* 563 */     if (this.ix != ctx() || this.iy != cty()) {
/* 564 */       remove();
/* 565 */       add();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int ctx() {
/* 571 */     return body().cX() >> 6;
/*     */   }
/*     */   
/*     */   public int cty() {
/* 575 */     return body().cY() >> 6;
/*     */   }
/*     */   
/*     */   protected abstract int z();
/*     */   
/*     */   final void saveP(FilePutter f) {
/* 581 */     f.bool(!isRemoved());
/* 582 */     this.resourcemask.save(f);
/*     */   }
/*     */   
/*     */   final void loadP(FileGetter f) throws IOException {
/* 586 */     clear();
/*     */     
/* 588 */     if (f.bool()) {
/* 589 */       this.resourcemask.load(f);
/* 590 */       this.ix = (short)ctx();
/* 591 */       this.iy = (short)cty();
/* 592 */       addColdAsHell();
/* 593 */       factory().add(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   final void clear() {
/* 598 */     this.addedNext = -1;
/* 599 */     this.addedPrev = -1;
/* 600 */     this.next = null;
/* 601 */     this.prev = null;
/* 602 */     this.ix = -1;
/* 603 */     this.iy = -1;
/*     */   }
/*     */   
/*     */   protected abstract void save(FilePutter paramFilePutter);
/*     */   
/*     */   protected abstract void load(FileGetter paramFileGetter) throws IOException;
/*     */   
/*     */   public short index() {
/* 611 */     return this.index;
/*     */   }
/*     */   
/*     */   public abstract THINGS.ThingFactory<?> factory();
/*     */   
/*     */   public Thing tileNext() {
/* 617 */     return this.next;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\THINGS$Thing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */