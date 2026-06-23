/*     */ package snake2d.util.gui;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SoundEffect;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ public class GuiSection implements CLICKABLE {
/*  21 */   protected final ArrayListResize<RENDEROBJ> renderables = new ArrayListResize(2, 2048);
/*     */   
/*     */   private RECTANGLE previous;
/*     */   
/*     */   private HOVERABLE hovered;
/*     */   
/*     */   protected CLICKABLE clicked;
/*     */   
/*     */   private ACTION clickAction;
/*     */   private boolean visable = true;
/*     */   protected boolean active = true;
/*  32 */   private Bounds bounds = new Bounds(null);
/*     */   
/*     */   protected boolean hoveredIs = false;
/*     */   
/*  36 */   private CharSequence hoverInfo = null;
/*  37 */   private CharSequence hoverTitle = null;
/*     */   
/*     */   public GuiSection() {
/*  40 */     this.previous = (RECTANGLE)this.bounds;
/*     */   }
/*     */   
/*     */   public GuiSection(float x, float y) {
/*  44 */     this.bounds.moveX1Y1(x, y);
/*  45 */     this.previous = (RECTANGLE)this.bounds;
/*     */   }
/*     */   
/*     */   public GuiSection(HOVERABLE r) {
/*  49 */     this.bounds.set((RECTANGLE)r.body());
/*  50 */     add((RENDEROBJ)r);
/*     */   }
/*     */   
/*     */   public GuiSection(CLICKABLE g) {
/*  54 */     this.bounds.set((RECTANGLE)g.body());
/*  55 */     this.renderables.add(g);
/*  56 */     this.previous = (RECTANGLE)g.body();
/*  57 */     this.hovered = (HOVERABLE)g;
/*     */   }
/*     */   
/*     */   public GuiSection(SPRITE s, int x, int y) {
/*  61 */     this.bounds.set(x, x, y, y);
/*  62 */     add(s, x, y);
/*     */   }
/*     */   
/*     */   public void clear() {
/*  66 */     this.renderables.clearSoft();
/*  67 */     this.hovered = null;
/*  68 */     this.clicked = null;
/*  69 */     this.hoveredIs = false;
/*  70 */     this.clickAction = null;
/*  71 */     this.bounds.setWidth(0.0D).setHeight(0.0D);
/*  72 */     this.bounds.moveX1Y1(0.0D, 0.0D);
/*  73 */     this.previous = (RECTANGLE)this.bounds;
/*     */   }
/*     */   
/*     */   public LIST<RENDEROBJ> elements() {
/*  77 */     return (LIST<RENDEROBJ>)this.renderables;
/*     */   }
/*     */   
/*     */   public void pad(int margin) {
/*  81 */     body().incrW((margin * 2));
/*  82 */     body().incrH((margin * 2));
/*  83 */     for (RENDEROBJ r : this.renderables)
/*  84 */       r.body().incrX(margin).incrY(margin); 
/*     */   }
/*     */   
/*     */   public void pad(int mx, int my) {
/*  88 */     body().incrW((mx * 2));
/*  89 */     body().incrH((my * 2));
/*  90 */     for (RENDEROBJ r : this.renderables) {
/*  91 */       r.body().incrX(mx).incrY(my);
/*     */     }
/*     */   }
/*     */   
/*     */   public void padX(int left, int right) {
/*  96 */     body().incrX(left);
/*     */     
/*  98 */     body().incrW(right);
/*  99 */     for (RENDEROBJ r : this.renderables) {
/* 100 */       r.body().incrX(right);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 106 */     if (!this.visable) {
/* 107 */       return false;
/*     */     }
/* 109 */     this.hoveredIs = mCoo.isWithinRec((RECTANGLE)this.bounds);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.hovered = null;
/*     */     
/* 117 */     Iterator<RENDEROBJ> itr = this.renderables.iteratorReverse();
/*     */     
/* 119 */     while (itr.hasNext()) {
/* 120 */       RENDEROBJ c = itr.next();
/* 121 */       if (c instanceof HOVERABLE && ((HOVERABLE)c).hover(mCoo)) {
/* 122 */         this.hovered = (HOVERABLE)c;
/* 123 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 128 */     return this.hoveredIs;
/*     */   }
/*     */   
/*     */   public boolean isHoveringAHoverElement() {
/* 132 */     return (this.hovered != null && this.hovered instanceof HOVERABLE);
/*     */   }
/*     */   
/*     */   public RENDEROBJ getHovered() {
/* 136 */     return (RENDEROBJ)this.hovered;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 144 */     if (!this.active || !this.visable) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this.hovered != null && this.visable && 
/* 148 */       this.hovered instanceof CLICKABLE) {
/* 149 */       ((CLICKABLE)this.hovered).click();
/* 150 */       return true;
/*     */     } 
/*     */     
/* 153 */     if (this.hoveredIs) {
/*     */       
/* 155 */       clickA();
/* 156 */       if (this.clickAction != null) {
/* 157 */         this.clickAction.exe();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 162 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 174 */     if (!this.visable) {
/* 175 */       this.hoveredIs = false;
/*     */       
/*     */       return;
/*     */     } 
/* 179 */     for (RENDEROBJ ren : this.renderables)
/* 180 */       ren.render(r, ds); 
/* 181 */     this.hoveredIs = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection add(RENDEROBJ r) {
/* 186 */     if (this.bounds.width() == 0 && this.renderables.isEmpty()) {
/* 187 */       this.bounds.set((RECTANGLE)r.body());
/*     */     } else {
/* 189 */       this.bounds.unify((RECTANGLE)r.body());
/*     */     } 
/* 191 */     if (r instanceof CLICKABLE) {
/* 192 */       this.renderables.add(r);
/*     */     } else {
/*     */       
/* 195 */       this.renderables.add(r);
/*     */     } 
/* 197 */     this.previous = (RECTANGLE)r.body();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */   public GuiSection moveLastToBack() {
/* 202 */     this.renderables.shiftRight();
/* 203 */     return this;
/*     */   }
/*     */   
/*     */   public GuiSection add(RENDEROBJ r, int x, int y) {
/* 207 */     r.body().moveX1Y1(x, y);
/* 208 */     return add(r);
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection addGrid(RENDEROBJ r, int i, int rows, int mx, int my) {
/* 213 */     int x = body().x1() + i % rows * (r.body().width() + mx);
/* 214 */     int y = body().y1() + i / rows * (r.body().height() + my);
/*     */     
/* 216 */     return add(r, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection addGridD(RENDEROBJ r, int i, int cols, int width, int height, DIR align) {
/* 221 */     int x = body().x1() + i % cols * width;
/* 222 */     int y = body().y1() + i / cols * height;
/*     */     
/* 224 */     if (x + width > body().width()) {
/* 225 */       body().setWidth((x + width));
/*     */     }
/* 227 */     r.body().moveC((x + width / 2), (y + height / 2));
/* 228 */     int dx = (width - r.body().width()) / 2;
/* 229 */     int dy = (height - r.body().height()) / 2;
/* 230 */     r.body().incr((dx * align.x()), (dy * align.y()));
/* 231 */     return add(r);
/*     */   }
/*     */   
/*     */   public GuiSection addC(RENDEROBJ r, int cx, int cy) {
/* 235 */     r.body().moveC(cx, cy);
/* 236 */     return add(r);
/*     */   }
/*     */ 
/*     */   
/*     */   public RENDEROBJ.Sprite addC(SPRITE r, int cx, int cy) {
/* 241 */     return add(r, cx - r.width() / 2, cy - r.height() / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public RENDEROBJ.Sprite add(SPRITE s, int x, int y) {
/* 246 */     RENDEROBJ.Sprite r = new RENDEROBJ.Sprite(s);
/* 247 */     r.body().moveX1Y1(x, y);
/* 248 */     add((RENDEROBJ)r);
/* 249 */     return r;
/*     */   }
/*     */   
/*     */   public void addRight(int margin, RENDEROBJ s) {
/* 253 */     s.body().moveX1((this.previous.x2() + margin));
/* 254 */     s.body().moveY1(this.previous.y1());
/* 255 */     add(s);
/*     */   }
/*     */   
/*     */   public void addRight(int margin, SPRITE s) {
/* 259 */     add(s, this.previous.x2() + margin, this.previous.y1());
/*     */   }
/*     */   
/*     */   public GuiSection addRightC(int margin, RENDEROBJ s) {
/* 263 */     s.body().moveX1((this.previous.x2() + margin));
/* 264 */     s.body().centerY(this.previous);
/* 265 */     add(s);
/* 266 */     return this;
/*     */   }
/*     */   
/*     */   public void addRightC(int margin, SPRITE s) {
/* 270 */     int dy = this.previous.height() - s.height();
/* 271 */     add(s, this.previous.x2() + margin, this.previous.y1() + dy / 2);
/*     */   }
/*     */   
/*     */   public void addRightCAbs(int x, RENDEROBJ s) {
/* 275 */     s.body().moveX1((this.previous.x1() + x));
/* 276 */     s.body().centerY(this.previous);
/* 277 */     add(s);
/*     */   }
/*     */   
/*     */   public void addCentredY(RENDEROBJ s, int x1) {
/* 281 */     s.body().moveX1(x1);
/* 282 */     s.body().centerY(this.previous);
/* 283 */     add(s);
/*     */   }
/*     */   
/*     */   public void addCentredY(SPRITE s, int x1) {
/* 287 */     add(s, x1, this.previous.cY() - s.height() / 2);
/*     */   }
/*     */   
/*     */   public void addCentredX(RENDEROBJ s, int cx) {
/* 291 */     s.body().moveCX(cx);
/* 292 */     s.body().centerY(this.previous);
/* 293 */     add(s);
/*     */   }
/*     */   
/*     */   public void addCentredX(SPRITE s, int cx) {
/* 297 */     add(s, cx - s.width() / 2, this.previous.cY() - s.height() / 2);
/*     */   }
/*     */   
/*     */   public void addRightCAbs(int x, SPRITE s) {
/* 301 */     int dy = this.previous.height() - s.height();
/* 302 */     add(s, this.previous.x1() + x, this.previous.y1() + dy / 2);
/*     */   }
/*     */   
/*     */   public void addDown(int margin, RENDEROBJ s) {
/* 306 */     s.body().moveY1((this.previous.y2() + margin));
/* 307 */     s.body().moveX1(this.previous.x1());
/* 308 */     add(s);
/*     */   }
/*     */   
/*     */   public void addDown(int margin, SPRITE s) {
/* 312 */     add(s, this.previous.x1(), this.previous.y2() + margin);
/*     */   }
/*     */   
/*     */   public void addDownC(int margin, RENDEROBJ s) {
/* 316 */     s.body().centerIn(this.previous);
/* 317 */     s.body().moveY1((this.previous.y2() + margin));
/* 318 */     add(s);
/*     */   }
/*     */   
/*     */   public void addDownC(int margin, SPRITE s) {
/* 322 */     add(s, this.previous.x1() + (this.previous.width() - s.width()) / 2, this.previous.y2() + margin);
/*     */   }
/*     */   
/*     */   public void addOnTop(RENDEROBJ s) {
/* 326 */     s.body().moveX1(this.previous.x1());
/* 327 */     s.body().moveY1(this.previous.y1());
/* 328 */     add(s);
/*     */   }
/*     */   
/*     */   public void addOnTop(SPRITE s) {
/* 332 */     add(s, this.previous.x1(), this.previous.y1());
/*     */   }
/*     */   
/*     */   public void addOnTopC(RENDEROBJ s) {
/* 336 */     s.body().centerIn(this.previous);
/* 337 */     add(s);
/*     */   }
/*     */   
/*     */   public void addOnTopC(SPRITE s) {
/* 341 */     int dx = (this.previous.width() - s.width()) / 2;
/* 342 */     int dy = (this.previous.height() - s.height()) / 2;
/* 343 */     add(s, this.previous.x1() + dx, this.previous.y1() + dy);
/*     */   }
/*     */   
/*     */   public RECTANGLE getLast() {
/* 347 */     return this.previous;
/*     */   }
/*     */   
/*     */   public int getLastX1() {
/* 351 */     return this.previous.x1();
/*     */   }
/*     */   
/*     */   public int getLastX2() {
/* 355 */     return this.previous.x2();
/*     */   }
/*     */   
/*     */   public int getLastY1() {
/* 359 */     return this.previous.y1();
/*     */   }
/*     */   
/*     */   public int getLastY2() {
/* 363 */     return this.previous.y2();
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection activeSet(boolean activate) {
/* 368 */     this.active = activate;
/* 369 */     for (RENDEROBJ c : this.renderables) {
/* 370 */       if (c instanceof CLICKABLE)
/* 371 */         ((CLICKABLE)c).activeSet(activate); 
/*     */     } 
/* 373 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection selectedSet(boolean yes) {
/* 378 */     for (RENDEROBJ c : this.renderables) {
/* 379 */       if (c instanceof CLICKABLE)
/* 380 */         ((CLICKABLE)c).selectedSet(yes); 
/*     */     } 
/* 382 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public CLICKABLE selectTmp() {
/* 387 */     for (RENDEROBJ c : this.renderables) {
/* 388 */       if (c instanceof CLICKABLE)
/* 389 */         ((CLICKABLE)c).selectTmp(); 
/*     */     } 
/* 391 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean activeIs() {
/* 396 */     return this.active;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection visableSet(boolean yes) {
/* 401 */     this.visable = yes;
/* 402 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean visableIs() {
/* 407 */     return this.visable;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection hoverSoundSet(SoundEffect sound) {
/* 412 */     for (RENDEROBJ c : this.renderables) {
/* 413 */       if (c instanceof CLICKABLE)
/* 414 */         ((CLICKABLE)c).hoverSoundSet(sound); 
/*     */     } 
/* 416 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection clickSoundSet(SoundEffect sound) {
/* 421 */     for (RENDEROBJ c : this.renderables) {
/* 422 */       if (c instanceof CLICKABLE)
/* 423 */         ((CLICKABLE)c).clickSoundSet(sound); 
/*     */     } 
/* 425 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean selectedIs() {
/* 430 */     for (RENDEROBJ c : this.renderables) {
/* 431 */       if (c instanceof CLICKABLE && (
/* 432 */         (CLICKABLE)c).selectedIs()) {
/* 433 */         return true;
/*     */       }
/*     */     } 
/* 436 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiSection selectedToggle() {
/* 442 */     for (RENDEROBJ c : this.renderables) {
/* 443 */       if (c instanceof CLICKABLE)
/* 444 */         ((CLICKABLE)c).selectedToggle(); 
/*     */     } 
/* 446 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hoveredIs() {
/* 452 */     return this.hoveredIs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 457 */     if (this.hovered != null && this.hovered.hoveredIs()) {
/* 458 */       this.hovered.hoverInfoGet(text);
/*     */     }
/*     */     
/* 461 */     if (hoveredIs() && text.emptyIs()) {
/* 462 */       hoverInfoSelf(text);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void hoverInfoSelf(GUI_BOX box) {
/* 467 */     if (this.hoverInfo != null) {
/* 468 */       box.text(this.hoverInfo);
/*     */     }
/* 470 */     if (this.hoverTitle != null)
/* 471 */       box.title(this.hoverTitle); 
/*     */   }
/*     */   
/*     */   private class Bounds extends Rec {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private Bounds() {}
/*     */     
/*     */     public Rec moveX1(double X1) {
/* 480 */       int dx = (int)(X1 - this.x);
/*     */       
/* 482 */       for (RENDEROBJ ren : GuiSection.this.renderables) {
/* 483 */         if (ren.body() == this)
/* 484 */           throw new RuntimeException(); 
/* 485 */         ren.body().incrX(dx);
/*     */       } 
/* 487 */       this.x = X1;
/* 488 */       GuiSection.this.moveCallback();
/* 489 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Rec moveY1(double Y1) {
/* 494 */       int dy = (int)(Y1 - this.y);
/*     */       
/* 496 */       for (RENDEROBJ ren : GuiSection.this.renderables)
/* 497 */         ren.body().incrY(dy); 
/* 498 */       this.y = Y1;
/* 499 */       GuiSection.this.moveCallback();
/* 500 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void moveCallback() {}
/*     */ 
/*     */   
/*     */   public void merge(GuiSection section) {
/* 510 */     for (RENDEROBJ r : section.renderables) {
/* 511 */       this.renderables.add(r);
/*     */     }
/* 513 */     if (body().width() == 0 && body().height() == 0) {
/* 514 */       body().set((BODY_HOLDER)section);
/*     */     } else {
/* 516 */       body().unify((RECTANGLE)section.body());
/* 517 */     }  this.previous = (RECTANGLE)section.body();
/*     */   }
/*     */   
/*     */   public void absorb(GuiSection section) {
/* 521 */     for (RENDEROBJ r : section.renderables) {
/* 522 */       add(r);
/*     */     }
/* 524 */     body().unify((RECTANGLE)section.body());
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec body() {
/* 529 */     return this.bounds;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection hoverInfoSet(CharSequence s) {
/* 534 */     this.hoverInfo = s;
/* 535 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public CLICKABLE hoverTitleSet(CharSequence s) {
/* 540 */     this.hoverTitle = s;
/* 541 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public CLICKABLE clickActionSet(ACTION f) {
/* 546 */     this.clickAction = f;
/* 547 */     return this;
/*     */   }
/*     */   
/*     */   protected HOVERABLE hovered() {
/* 551 */     return this.hovered;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection addRelBody(int m, DIR e, RENDEROBJ ren) {
/* 556 */     int cx = body().cX() + e.x() * ((ren.body().width() + body().width()) / 2 + m);
/* 557 */     int cy = body().cY() + e.y() * ((ren.body().height() + body().height()) / 2 + m);
/* 558 */     ren.body().moveC(cx, cy);
/* 559 */     add(ren);
/* 560 */     return this;
/*     */   }
/*     */   
/*     */   public GuiSection addRelBody(int m, DIR e, SPRITE ren) {
/* 564 */     return addRelBody(m, e, (RENDEROBJ)new RENDEROBJ.Sprite(ren));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\gui\GuiSection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */