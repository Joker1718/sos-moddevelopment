/*     */ package launcher;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SoundEffect;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScrollBox
/*     */   implements CLICKABLE
/*     */ {
/* 223 */   private final ArrayList<HOVERABLE> objects = new ArrayList<>();
/* 224 */   private CLICKABLE hovered = null;
/* 225 */   private int first = 0;
/* 226 */   private int last = -1;
/*     */   private boolean visable = true;
/* 228 */   private final Bounds bounds = new Bounds();
/*     */   
/*     */   private CLICKABLE upButt;
/*     */   private CLICKABLE downButt;
/*     */   
/*     */   public ScrollBox(int height) {
/* 234 */     this.bounds.setHeight(height);
/*     */   }
/*     */   
/*     */   public ScrollBox addNavButts(CLICKABLE up, CLICKABLE down) {
/* 238 */     this.upButt = up;
/* 239 */     this.downButt = down;
/* 240 */     fixButts();
/* 241 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private void fixButts() {
/* 246 */     if (this.upButt != null)
/* 247 */       this.upButt.activeSet(canUp()); 
/* 248 */     if (this.downButt != null)
/* 249 */       this.downButt.activeSet(canDown()); 
/*     */   }
/*     */   
/*     */   public void scrollUp() {
/* 253 */     if (!canUp())
/*     */       return; 
/* 255 */     int dy = ((HOVERABLE)this.objects.get(this.last - 1)).body().height();
/* 256 */     this.first--;
/* 257 */     for (int i = 0; i < this.objects.size(); i++) {
/* 258 */       ((HOVERABLE)this.objects.get(i)).body().incrY(dy);
/* 259 */       if (((HOVERABLE)this.objects.get(i)).body().y2() <= this.bounds.y2())
/* 260 */         this.last = i; 
/*     */     } 
/* 262 */     fixButts();
/*     */   }
/*     */ 
/*     */   
/*     */   public void scrollDown() {
/* 267 */     if (!canDown())
/*     */       return; 
/* 269 */     int dy = -((HOVERABLE)this.objects.get(this.first)).body().height();
/* 270 */     this.first++;
/* 271 */     for (int i = 0; i < this.objects.size(); i++) {
/* 272 */       ((HOVERABLE)this.objects.get(i)).body().incrY(dy);
/* 273 */       if (((HOVERABLE)this.objects.get(i)).body().y2() <= this.bounds.y2())
/* 274 */         this.last = i; 
/*     */     } 
/* 276 */     fixButts();
/*     */   }
/*     */   
/*     */   public int size() {
/* 280 */     return this.objects.size();
/*     */   }
/*     */   
/*     */   public void centreAtIndex(int index) {
/* 284 */     int currentCentre = this.first + (this.last - this.first) / 2;
/* 285 */     while (currentCentre < index && canDown()) {
/* 286 */       scrollDown();
/* 287 */       currentCentre = this.first + (this.last - this.first) / 2;
/*     */     } 
/* 289 */     while (currentCentre > index && canUp()) {
/* 290 */       scrollUp();
/* 291 */       currentCentre = this.first + (this.last - this.first) / 2;
/*     */     } 
/* 293 */     fixButts();
/*     */   }
/*     */ 
/*     */   
/*     */   public void centreAtGuiObj(CLICKABLE g) {
/* 298 */     int i = 0;
/* 299 */     for (HOVERABLE o : this.objects) {
/* 300 */       if (o == g) {
/* 301 */         centreAtIndex(i);
/*     */         return;
/*     */       } 
/* 304 */       i++;
/*     */     } 
/* 306 */     fixButts();
/*     */   }
/*     */   
/*     */   public float getCentrePosition() {
/* 310 */     float eleHeight = (this.last - this.first);
/* 311 */     float tot = this.objects.size() - eleHeight - 1.0F;
/* 312 */     if (tot <= 0.0F)
/* 313 */       return 0.0F; 
/* 314 */     float res = this.first / tot;
/* 315 */     return res;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 319 */     this.first = 0;
/* 320 */     this.last = -1;
/* 321 */     this.objects.clear();
/* 322 */     this.hovered = null;
/* 323 */     fixButts();
/*     */   }
/*     */   
/*     */   public boolean canUp() {
/* 327 */     return (this.first > 0);
/*     */   }
/*     */   
/*     */   public boolean canDown() {
/* 331 */     return (this.last < this.objects.size() - 1);
/*     */   }
/*     */   
/*     */   public int add(HOVERABLE object) {
/* 335 */     if (this.objects.isEmpty()) {
/* 336 */       object.body().moveX1Y1(this.bounds.x1(), this.bounds.y1());
/*     */     } else {
/* 338 */       object.body().moveX1Y1(this.bounds.x1(), ((HOVERABLE)this.objects.get(this.objects.size() - 1)).body().y2());
/*     */     } 
/*     */     
/* 341 */     int i = this.objects.size();
/* 342 */     this.objects.add(object);
/*     */     
/* 344 */     if (object.body().y2() <= this.bounds.y2()) {
/* 345 */       this.last = this.objects.size() - 1;
/*     */     }
/* 347 */     if (object.body().width() > this.bounds.width())
/* 348 */       this.bounds.setWidth(object.body().width()); 
/* 349 */     fixButts();
/* 350 */     return i;
/*     */   }
/*     */   
/*     */   public void add(SPRITE s) {
/* 354 */     HOVERABLE.Sprite r = new HOVERABLE.Sprite(s);
/* 355 */     if (this.objects.isEmpty()) {
/* 356 */       r.body().moveX1Y1(this.bounds.x1(), this.bounds.y1());
/*     */     } else {
/* 358 */       r.body().moveX1Y1(this.bounds.x1(), ((HOVERABLE)this.objects.get(this.objects.size() - 1)).body().y2());
/*     */     } 
/* 360 */     this.objects.add(r);
/*     */     
/* 362 */     if (r.body().y2() <= this.bounds.y2())
/* 363 */       this.last = this.objects.size() - 1; 
/* 364 */     fixButts();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 370 */     double s = MButt.clearWheelSpin();
/* 371 */     while (s < 0.0D && canDown()) {
/* 372 */       scrollDown();
/* 373 */       s++;
/*     */     } 
/* 375 */     while (s > 0.0D && canUp()) {
/* 376 */       scrollUp();
/* 377 */       s--;
/*     */     } 
/*     */     
/* 380 */     for (int i = this.first; i <= this.last; i++) {
/* 381 */       ((HOVERABLE)this.objects.get(i)).render(r, ds);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 390 */     if (this.hovered != null && this.hovered.hover(mCoo)) {
/* 391 */       return true;
/*     */     }
/* 393 */     this.hovered = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 398 */     for (int i = this.first; i <= this.last; i++) {
/* 399 */       if (this.objects.get(i) instanceof CLICKABLE) {
/* 400 */         CLICKABLE g = (CLICKABLE)this.objects.get(i);
/* 401 */         if (g.hover(mCoo)) {
/* 402 */           this.hovered = (CLICKABLE)this.objects.get(i);
/* 403 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 408 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hoveredIs() {
/* 413 */     return (this.hovered != null && this.hovered.hoveredIs());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 418 */     return (this.hovered != null && this.hovered.click());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 423 */     if (this.hovered != null && this.hovered.hoveredIs()) {
/* 424 */       this.hovered.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CLICKABLE hoverTitleSet(CharSequence s) {
/* 430 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ScrollBox activeSet(boolean activate) {
/* 435 */     for (HOVERABLE g : this.objects) {
/* 436 */       if (g instanceof CLICKABLE)
/* 437 */         ((CLICKABLE)g).activeSet(activate); 
/*     */     } 
/* 439 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ScrollBox hoverSoundSet(SoundEffect sound) {
/* 444 */     for (HOVERABLE g : this.objects) {
/* 445 */       if (g instanceof CLICKABLE)
/* 446 */         ((CLICKABLE)g).hoverSoundSet(sound); 
/*     */     } 
/* 448 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ScrollBox clickSoundSet(SoundEffect sound) {
/* 453 */     for (HOVERABLE g : this.objects) {
/* 454 */       if (g instanceof CLICKABLE)
/* 455 */         ((CLICKABLE)g).clickSoundSet(sound); 
/*     */     } 
/* 457 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ScrollBox selectedSet(boolean yes) {
/* 462 */     for (HOVERABLE g : this.objects) {
/* 463 */       if (g instanceof CLICKABLE)
/* 464 */         ((CLICKABLE)g).selectedSet(yes); 
/*     */     } 
/* 466 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean selectedIs() {
/* 471 */     for (HOVERABLE g : this.objects) {
/* 472 */       if (g instanceof CLICKABLE && (
/* 473 */         (CLICKABLE)g).selectedIs())
/* 474 */         return true; 
/*     */     } 
/* 476 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean activeIs() {
/* 481 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ScrollBox visableSet(boolean yes) {
/* 486 */     this.visable = yes;
/* 487 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean visableIs() {
/* 492 */     return this.visable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScrollBox selectedToggle() {
/* 504 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private class Bounds
/*     */     extends Rec
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Rec moveX1(double X1) {
/* 514 */       double dx = X1 - x1();
/* 515 */       for (HOVERABLE g : GUI.ScrollBox.this.objects) {
/* 516 */         g.body().incrX(dx);
/*     */       }
/* 518 */       return super.moveX1(X1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Rec moveY1(double Y1) {
/* 523 */       double dy = Y1 - y1();
/* 524 */       for (HOVERABLE g : GUI.ScrollBox.this.objects) {
/* 525 */         g.body().incrY(dy);
/*     */       }
/* 527 */       return super.moveY1(Y1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec body() {
/* 533 */     return this.bounds;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CLICKABLE clickActionSet(ACTION f) {
/* 539 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CLICKABLE selectTmp() {
/* 545 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CLICKABLE hoverInfoSet(CharSequence s) {
/* 551 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\GUI$ScrollBox.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */