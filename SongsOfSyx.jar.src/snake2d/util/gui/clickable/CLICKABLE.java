/*     */ package snake2d.util.gui.clickable;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SoundEffect;
/*     */ import snake2d.SoundSimple;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ 
/*     */ public interface CLICKABLE
/*     */   extends HOVERABLE {
/*     */   CLICKABLE hoverSoundSet(SoundEffect paramSoundEffect);
/*     */   
/*     */   CLICKABLE hoverInfoSet(CharSequence paramCharSequence);
/*     */   
/*     */   CLICKABLE clickSoundSet(SoundEffect paramSoundEffect);
/*     */   
/*     */   CLICKABLE selectedSet(boolean paramBoolean);
/*     */   
/*     */   CLICKABLE selectTmp();
/*     */   
/*     */   CLICKABLE selectedToggle();
/*     */   
/*     */   CLICKABLE visableSet(boolean paramBoolean);
/*     */   
/*     */   CLICKABLE clickActionSet(ACTION paramACTION);
/*     */   
/*     */   boolean click();
/*     */   
/*     */   boolean activeIs();
/*     */   
/*     */   CLICKABLE activeSet(boolean paramBoolean);
/*     */   
/*     */   boolean selectedIs();
/*     */   
/*     */   CLICKABLE hoverTitleSet(CharSequence paramCharSequence);
/*     */   
/*     */   public static abstract class ClickableAbs
/*     */     implements CLICKABLE {
/*     */     public static boolean clickableHovered = false;
/*  50 */     private float repTimer = 0.0F;
/*  51 */     private float clicks = 0.0F;
/*     */     
/*  53 */     public static SoundSimple defaultHoverSound = null;
/*  54 */     public static SoundSimple defaultClickSound = null;
/*     */     
/*  56 */     public final Rec body = new Rec();
/*     */     
/*     */     protected boolean isHovered = false;
/*     */     
/*     */     private boolean isVisable = true;
/*     */     private boolean isSelected = false;
/*     */     private boolean isActive = true;
/*     */     private boolean wasHovered = false;
/*     */     private boolean tmpSelect = false;
/*     */     private boolean repetative;
/*  66 */     private SoundSimple hoverSound = defaultHoverSound;
/*  67 */     private SoundSimple clickSound = defaultClickSound;
/*  68 */     protected CharSequence hoverInfo = null;
/*  69 */     protected CharSequence hoverTitle = null;
/*     */ 
/*     */ 
/*     */     
/*     */     protected ACTION clickAction;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ClickableAbs(int width, int height) {
/*  79 */       this.body.setWidth(width).setHeight(height);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean activeIs() {
/*  84 */       return this.isActive;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/*  89 */       if (!this.isVisable) {
/*  90 */         return false;
/*     */       }
/*     */       
/*  93 */       if (mCoo.isWithinRec((RECTANGLE)body())) {
/*  94 */         this.isHovered = true;
/*  95 */         if (!this.isActive) {
/*  96 */           return true;
/*     */         }
/*  98 */         if (!this.wasHovered) {
/*  99 */           this.repTimer = 0.0F;
/* 100 */           this.wasHovered = true;
/* 101 */           if (this.hoverSound != null) {
/* 102 */             this.hoverSound.play(false);
/*     */           }
/*     */         } 
/*     */       } else {
/* 106 */         this.isHovered = false;
/* 107 */         this.wasHovered = false;
/* 108 */         this.repTimer = 0.0F;
/*     */       } 
/* 110 */       if (isRepetative() && this.isHovered && MButt.LEFT.isDown()) {
/*     */         
/* 112 */         for (int i = 0; i < (int)this.clicks; i++) {
/* 113 */           if (this.clickAction != null)
/* 114 */             this.clickAction.exe(); 
/* 115 */           clickA();
/*     */         } 
/* 117 */         this.clicks -= (int)this.clicks;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       if (this.isHovered) {
/* 135 */         clickableHovered = true;
/*     */       }
/* 137 */       return this.isHovered;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hoveredIs() {
/* 142 */       return this.isHovered;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 147 */       if (this.hoverInfo != null) {
/* 148 */         text.text(this.hoverInfo);
/*     */       }
/* 150 */       if (this.hoverTitle != null) {
/* 151 */         text.title(this.hoverTitle);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean click() {
/* 156 */       if (this.isVisable && this.isHovered && this.isActive) {
/* 157 */         clickA();
/* 158 */         if (this.clickSound != null)
/* 159 */           this.clickSound.play(false); 
/* 160 */         if (this.clickAction != null) {
/* 161 */           this.clickAction.exe();
/*     */         }
/* 163 */         this.repTimer = 0.0F;
/*     */         
/* 165 */         return true;
/*     */       } 
/* 167 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {}
/*     */ 
/*     */     
/*     */     public boolean visableIs() {
/* 176 */       return this.isVisable;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLEE body() {
/* 181 */       return (RECTANGLEE)this.body;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void renAction() {}
/*     */ 
/*     */     
/*     */     public final void render(SPRITE_RENDERER r, float ds) {
/* 190 */       renAction();
/* 191 */       if (isRepetative() && this.isHovered && MButt.LEFT.isDown()) {
/* 192 */         this.repTimer = (float)(this.repTimer + ((1.0F + this.repTimer * 2.0F) * ds) / 15.0D);
/* 193 */         if (this.repTimer > 10000.0F)
/* 194 */           this.repTimer = 10000.0F; 
/* 195 */         this.clicks += this.repTimer;
/*     */       } else {
/*     */         
/* 198 */         this.repTimer = 0.0F;
/* 199 */         this.clicks = 0.0F;
/*     */       } 
/*     */       
/* 202 */       if (this.isVisable)
/* 203 */         render(r, ds, this.isActive, this.isSelected | this.tmpSelect, this.isHovered); 
/* 204 */       this.isHovered = false;
/* 205 */       this.tmpSelect = false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverSoundSet(SoundEffect sound) {
/* 215 */       this.hoverSound = (SoundSimple)sound;
/* 216 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverInfoSet(CharSequence s) {
/* 222 */       this.hoverInfo = s;
/* 223 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverTitleSet(CharSequence s) {
/* 228 */       this.hoverTitle = s;
/* 229 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE clickSoundSet(SoundEffect sound) {
/* 234 */       this.clickSound = (SoundSimple)sound;
/* 235 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE activeSet(boolean activate) {
/* 240 */       this.isActive = activate;
/* 241 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectedSet(boolean yes) {
/* 246 */       this.isSelected = yes;
/* 247 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectTmp() {
/* 252 */       this.tmpSelect = true;
/* 253 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public ClickableAbs selectedToggle() {
/* 258 */       this.isSelected ^= 0x1;
/* 259 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE visableSet(boolean yes) {
/* 264 */       this.isVisable = yes;
/* 265 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean selectedIs() {
/* 270 */       return !(!this.isSelected && !this.tmpSelect);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE clickActionSet(ACTION f) {
/* 275 */       this.clickAction = f;
/* 276 */       return this;
/*     */     }
/*     */     
/*     */     public final boolean isRepetative() {
/* 280 */       return this.repetative;
/*     */     }
/*     */     public CLICKABLE repetativeSet(boolean repetative) {
/* 283 */       this.repetative = repetative;
/* 284 */       return this;
/*     */     }
/*     */     
/*     */     protected ClickableAbs() {}
/*     */     
/*     */     protected abstract void render(SPRITE_RENDERER param1SPRITE_RENDERER, float param1Float, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3);
/*     */   }
/*     */   
/*     */   public static class ClickSwitch
/*     */     extends ClickWrap {
/*     */     private RENDEROBJ c;
/*     */     
/*     */     public ClickSwitch(RENDEROBJ c) {
/* 297 */       super(c);
/* 298 */       this.c = c;
/*     */     }
/*     */     
/*     */     public ClickSwitch(int w, int h) {
/* 302 */       super(w, h);
/*     */     }
/*     */     
/*     */     public void set(RENDEROBJ c) {
/* 306 */       this.c = c;
/*     */     }
/*     */ 
/*     */     
/*     */     protected RENDEROBJ pget() {
/* 311 */       return this.c;
/*     */     }
/*     */     
/*     */     public RENDEROBJ current() {
/* 315 */       return this.c;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class ClickWrap
/*     */     implements CLICKABLE
/*     */   {
/*     */     boolean dirty = false;
/* 323 */     private final Rec body = new Rec()
/*     */       {
/*     */         private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public Rec moveX1(double X1) {
/* 331 */           CLICKABLE.ClickWrap.this.dirty = true;
/* 332 */           return super.moveX1(X1);
/*     */         }
/*     */ 
/*     */         
/*     */         public Rec moveY1(double X1) {
/* 337 */           CLICKABLE.ClickWrap.this.dirty = true;
/* 338 */           return super.moveY1(X1);
/*     */         }
/*     */       };
/* 341 */     private DIR dd = DIR.NW;
/*     */     
/*     */     public ClickWrap(DIMENSION dim) {
/* 344 */       this.body.setDim(dim);
/*     */     }
/*     */     
/*     */     public ClickWrap(int width, int height) {
/* 348 */       this.body.setDim(width, height);
/*     */     }
/*     */     
/*     */     public ClickWrap(RENDEROBJ obj) {
/* 352 */       this.body.set((RECTANGLE)obj.body());
/*     */     }
/*     */     
/*     */     public ClickWrap setD(DIR dd) {
/* 356 */       this.dd = dd;
/* 357 */       return this;
/*     */     }
/*     */     
/*     */     private RENDEROBJ get() {
/* 361 */       RENDEROBJ o = pget();
/* 362 */       if (o == null)
/* 363 */         return null; 
/* 364 */       if (this.dirty) {
/* 365 */         this.dirty = false;
/* 366 */         int dw = (this.body.width() - o.body().width()) / 2;
/* 367 */         int dh = (this.body.height() - o.body().height()) / 2;
/* 368 */         o.body().moveC(this.body.cX(), this.body.cY());
/* 369 */         o.body().incrX((dw * this.dd.x()));
/* 370 */         o.body().incrY((dh * this.dd.y()));
/* 371 */         this.body.unify((RECTANGLE)o.body());
/*     */       } 
/*     */       
/* 374 */       return o;
/*     */     }
/*     */ 
/*     */     
/*     */     private HOVERABLE hov() {
/* 379 */       if (get() != null && get() instanceof HOVERABLE)
/* 380 */         return (HOVERABLE)get(); 
/* 381 */       return null;
/*     */     }
/*     */     
/*     */     private CLICKABLE cli() {
/* 385 */       if (get() != null && get() instanceof CLICKABLE)
/* 386 */         return (CLICKABLE)get(); 
/* 387 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean activeIs() {
/* 392 */       if (cli() == null)
/* 393 */         return false; 
/* 394 */       return cli().activeIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 399 */       this.dirty = true;
/* 400 */       if (hov() == null)
/* 401 */         return false; 
/* 402 */       return hov().hover(mCoo);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hoveredIs() {
/* 407 */       if (hov() == null)
/* 408 */         return false; 
/* 409 */       return hov().hoveredIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 414 */       if (hov() != null) {
/* 415 */         hov().hoverInfoGet(text);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean click() {
/* 420 */       if (cli() == null)
/* 421 */         return false; 
/* 422 */       return cli().click();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean visableIs() {
/* 427 */       if (get() == null)
/* 428 */         return false; 
/* 429 */       return get().visableIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLEE body() {
/* 434 */       return (RECTANGLEE)this.body;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void render(SPRITE_RENDERER r, float ds) {
/* 439 */       this.dirty = true;
/* 440 */       if (get() != null) {
/* 441 */         get().render(r, ds);
/*     */       }
/* 443 */       renAction();
/* 444 */       this.dirty = true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void renAction() {}
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverSoundSet(SoundEffect sound) {
/* 453 */       if (cli() == null)
/* 454 */         return null; 
/* 455 */       return cli().hoverSoundSet(sound);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverInfoSet(CharSequence s) {
/* 460 */       if (hov() == null)
/* 461 */         return null; 
/* 462 */       hov().hoverInfoSet(s);
/* 463 */       return cli();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverTitleSet(CharSequence s) {
/* 468 */       if (hov() == null)
/* 469 */         return null; 
/* 470 */       hov().hoverTitleSet(s);
/* 471 */       return cli();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE clickSoundSet(SoundEffect sound) {
/* 476 */       if (cli() == null)
/* 477 */         return null; 
/* 478 */       return cli().clickSoundSet(sound);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE activeSet(boolean activate) {
/* 483 */       if (cli() == null)
/* 484 */         return null; 
/* 485 */       return cli().activeSet(activate);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectedSet(boolean yes) {
/* 490 */       if (cli() == null)
/* 491 */         return null; 
/* 492 */       return cli().selectedSet(yes);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectTmp() {
/* 497 */       if (cli() == null)
/* 498 */         return null; 
/* 499 */       return cli().selectTmp();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectedToggle() {
/* 504 */       if (cli() == null)
/* 505 */         return null; 
/* 506 */       return cli().selectedToggle();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE visableSet(boolean yes) {
/* 511 */       if (cli() == null)
/* 512 */         return null; 
/* 513 */       return cli().visableSet(yes);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean selectedIs() {
/* 518 */       if (cli() == null)
/* 519 */         return false; 
/* 520 */       return cli().selectedIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE clickActionSet(ACTION f) {
/* 525 */       if (cli() == null)
/* 526 */         return null; 
/* 527 */       return cli().clickActionSet(f);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract RENDEROBJ pget();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class ClickWrap2
/*     */     implements CLICKABLE
/*     */   {
/*     */     private HOVERABLE hov() {
/* 542 */       if (get() != null && get() instanceof HOVERABLE)
/* 543 */         return (HOVERABLE)get(); 
/* 544 */       return null;
/*     */     }
/*     */     
/*     */     private CLICKABLE cli() {
/* 548 */       if (get() != null && get() instanceof CLICKABLE)
/* 549 */         return (CLICKABLE)get(); 
/* 550 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean activeIs() {
/* 555 */       if (cli() == null)
/* 556 */         return false; 
/* 557 */       return cli().activeIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 562 */       if (hov() == null)
/* 563 */         return false; 
/* 564 */       return hov().hover(mCoo);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hoveredIs() {
/* 569 */       if (hov() == null)
/* 570 */         return false; 
/* 571 */       return hov().hoveredIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 576 */       if (hov() != null) {
/* 577 */         hov().hoverInfoGet(text);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean click() {
/* 582 */       if (cli() == null)
/* 583 */         return false; 
/* 584 */       return cli().click();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean visableIs() {
/* 589 */       if (get() == null)
/* 590 */         return false; 
/* 591 */       return get().visableIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLEE body() {
/* 596 */       return get().body();
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 601 */       get().render(r, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverSoundSet(SoundEffect sound) {
/* 606 */       if (cli() == null)
/* 607 */         return null; 
/* 608 */       return cli().hoverSoundSet(sound);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverInfoSet(CharSequence s) {
/* 613 */       if (hov() == null)
/* 614 */         return null; 
/* 615 */       hov().hoverInfoSet(s);
/* 616 */       return cli();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE hoverTitleSet(CharSequence s) {
/* 621 */       if (hov() == null)
/* 622 */         return null; 
/* 623 */       hov().hoverTitleSet(s);
/* 624 */       return cli();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE clickSoundSet(SoundEffect sound) {
/* 629 */       if (cli() == null)
/* 630 */         return null; 
/* 631 */       return cli().clickSoundSet(sound);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE activeSet(boolean activate) {
/* 636 */       if (cli() == null)
/* 637 */         return null; 
/* 638 */       return cli().activeSet(activate);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectedSet(boolean yes) {
/* 643 */       if (cli() == null)
/* 644 */         return null; 
/* 645 */       return cli().selectedSet(yes);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectTmp() {
/* 650 */       if (cli() == null)
/* 651 */         return null; 
/* 652 */       return cli().selectTmp();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE selectedToggle() {
/* 657 */       if (cli() == null)
/* 658 */         return null; 
/* 659 */       return cli().selectedToggle();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE visableSet(boolean yes) {
/* 664 */       if (cli() == null)
/* 665 */         return null; 
/* 666 */       return cli().visableSet(yes);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean selectedIs() {
/* 671 */       if (cli() == null)
/* 672 */         return false; 
/* 673 */       return cli().selectedIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE clickActionSet(ACTION f) {
/* 678 */       if (cli() == null)
/* 679 */         return null; 
/* 680 */       return cli().clickActionSet(f);
/*     */     }
/*     */     
/*     */     protected abstract RENDEROBJ get();
/*     */   }
/*     */   
/*     */   public static class Pair
/*     */     extends ClickableAbs {
/*     */     private final RENDEROBJ a;
/*     */     private final RENDEROBJ b;
/*     */     final int offax;
/*     */     
/*     */     public Pair(RENDEROBJ a, RENDEROBJ b, DIR align, int margin) {
/* 693 */       int dy = (a.body().height() + b.body().height()) / 2 + margin;
/* 694 */       int dx = (a.body().width() + b.body().width()) / 2 + margin;
/* 695 */       int sx = a.body().cX();
/* 696 */       int sy = a.body().cY();
/* 697 */       b.body().moveC((sx + dx * align.x()), (sy + dy * align.y()));
/* 698 */       this.a = a;
/* 699 */       this.b = b;
/* 700 */       this.body.set((BODY_HOLDER)a);
/* 701 */       this.body.unify((RECTANGLE)b.body());
/* 702 */       this.offax = a.body().x1() - this.body.x1();
/* 703 */       this.offay = a.body().y1() - this.body.y1();
/* 704 */       this.offbx = b.body().x1() - this.body.x1();
/* 705 */       this.offby = b.body().y1() - this.body.y1();
/*     */     }
/*     */     final int offay; final int offbx; final int offby; private HOVERABLE h;
/*     */     public Pair(RENDEROBJ a, RENDEROBJ b) {
/* 709 */       this.a = a;
/* 710 */       this.b = b;
/* 711 */       this.body.set((BODY_HOLDER)a);
/* 712 */       this.body.unify((RECTANGLE)b.body());
/* 713 */       this.offax = a.body().x1() - this.body.x1();
/* 714 */       this.offay = a.body().y1() - this.body.y1();
/* 715 */       this.offbx = b.body().x1() - this.body.x1();
/* 716 */       this.offby = b.body().y1() - this.body.y1();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 721 */       if (!visableIs())
/* 722 */         return false; 
/* 723 */       this.h = null;
/* 724 */       if (this.a instanceof HOVERABLE && ((HOVERABLE)this.a).hover(mCoo)) {
/* 725 */         this.h = (HOVERABLE)this.a;
/* 726 */         if (this.b instanceof HOVERABLE)
/* 727 */           ((HOVERABLE)this.b).hover(mCoo); 
/* 728 */       } else if (this.b instanceof HOVERABLE && ((HOVERABLE)this.b).hover(mCoo)) {
/* 729 */         this.h = (HOVERABLE)this.b;
/* 730 */         if (this.b instanceof HOVERABLE)
/* 731 */           ((HOVERABLE)this.b).hover(mCoo); 
/*     */       } 
/* 733 */       this.isHovered = !(this.h == null && !mCoo.isWithinRec((RECTANGLE)this.body));
/* 734 */       return this.isHovered;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 739 */       this.a.body().moveX1Y1((RECTANGLE)this.body);
/* 740 */       this.a.body().incrX(this.offax).incrY(this.offay);
/* 741 */       this.b.body().moveX1Y1((RECTANGLE)this.body);
/* 742 */       this.b.body().incrX(this.offbx).incrY(this.offby);
/* 743 */       this.a.render(r, ds);
/* 744 */       this.b.render(r, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 749 */       if (this.h != null && this.h instanceof CLICKABLE) {
/* 750 */         ((CLICKABLE)this.h).click();
/* 751 */         return true;
/*     */       } 
/* 753 */       return super.click();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 758 */       if (this.h != null && this.h instanceof HOVERABLE)
/* 759 */         this.h.hoverInfoGet(text); 
/* 760 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\gui\clickable\CLICKABLE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */