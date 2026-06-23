/*     */ package util.gui.misc;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.LOG;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.slider.GSliderVer;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class GBox
/*     */   implements SPRITE, GUI_BOX {
/*  32 */   public int maxHeight = 600;
/*  33 */   public int maxWidth = 500;
/*     */   
/*  35 */   private static final GBox dummy = new GBox();
/*  36 */   public static final GBox tmp = new GBox();
/*     */   
/*     */   private static final int MARGIN = 4;
/*     */   
/*     */   private int dx;
/*     */   
/*     */   private int dy;
/*     */   private int dHeight;
/*     */   private int width;
/*     */   private int height;
/*  46 */   private ArrayList<Ren> rens = new ArrayList(2048);
/*  47 */   private ArrayList<Ren> rensFree = new ArrayList(2048);
/*  48 */   private ArrayList<GText> texts = new ArrayList(2048);
/*  49 */   private int rensFreeI = 0;
/*  50 */   private int textsFreeI = 0;
/*  51 */   private final GPanel box = new GPanel();
/*     */   
/*  53 */   private final ArrayListGrower<Sep> sepsFree = new ArrayListGrower();
/*  54 */   private int sepsFreeI = 0;
/*  55 */   private final Scroll scroll = new Scroll();
/*     */   
/*  57 */   private RENDEROBJ.RenderImp object = new RENDEROBJ.RenderImp()
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds) {
/*  60 */         GBox.this.render(r, (RECTANGLE)this.body);
/*     */       }
/*     */     };
/*     */   
/*     */   public GBox() {
/*  65 */     while (this.rensFree.hasRoom()) {
/*  66 */       this.rensFree.add(new Ren());
/*  67 */       this.texts.add(new GText((UI.FONT()).S, 256));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clear() {
/*  72 */     this.rens.clear();
/*  73 */     this.dx = 0;
/*  74 */     this.dy = 0;
/*  75 */     this.dHeight = 0;
/*  76 */     this.rensFreeI = 0;
/*  77 */     this.textsFreeI = 0;
/*  78 */     this.sepsFreeI = 0;
/*  79 */     this.width = 0;
/*  80 */     this.height = 0;
/*  81 */     this.box.title().clear();
/*     */   }
/*     */   private final class Ren { private int x; private int y;
/*     */     private SPRITE renderable;
/*     */     private RENDEROBJ ren;
/*     */     private final ColorImp col;
/*     */     
/*     */     private Ren() {
/*  89 */       this.col = new ColorImp();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int height() {
/*  96 */       if (this.renderable != null)
/*  97 */         return this.renderable.height(); 
/*  98 */       return this.ren.body().height();
/*     */     }
/*     */     
/*     */     private void init(SPRITE o, int fixed) {
/* 102 */       this.renderable = o;
/* 103 */       this.x = GBox.this.dx;
/* 104 */       this.y = GBox.this.dy;
/* 105 */       GBox.this.dx += fixed;
/* 106 */       if (o.height() > GBox.this.dHeight)
/* 107 */         GBox.this.dHeight = o.height(); 
/* 108 */       if (this.x + o.width() > GBox.this.width) {
/* 109 */         GBox.this.width = this.x + o.width();
/*     */       }
/* 111 */       this.col.set(COLOR.WHITE100);
/* 112 */       GBox.this.rensFreeI++;
/* 113 */       GBox.this.rens.add(this);
/* 114 */       this.ren = null;
/*     */     }
/*     */     
/*     */     private void init(RENDEROBJ o, int fixed) {
/* 118 */       this.renderable = null;
/* 119 */       this.ren = o;
/* 120 */       this.x = GBox.this.dx;
/* 121 */       this.y = GBox.this.dy;
/* 122 */       GBox.this.dx += fixed;
/* 123 */       if (o.body().height() > GBox.this.dHeight)
/* 124 */         GBox.this.dHeight = o.body().height(); 
/* 125 */       if (this.x + o.body().width() > GBox.this.width) {
/* 126 */         GBox.this.width = this.x + o.body().width();
/*     */       }
/* 128 */       GBox.this.rensFreeI++;
/* 129 */       GBox.this.rens.add(this);
/* 130 */       this.col.set(COLOR.WHITE100);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GBox title(CharSequence title) {
/* 137 */     this.box.setTitle(title);
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GBox NL() {
/* 143 */     return NL(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GBox NL(int m) {
/* 149 */     for (int i = this.rens.size() - 1; i >= 0; i--) {
/* 150 */       Ren r = (Ren)this.rens.get(i);
/* 151 */       if (r.y != this.dy)
/*     */         break; 
/* 153 */       if (r.height() != this.dHeight) {
/* 154 */         r.y += (this.dHeight - r.height()) / 2;
/*     */       }
/*     */     } 
/*     */     
/* 158 */     this.dHeight += m;
/*     */     
/* 160 */     this.dy += this.dHeight;
/* 161 */     this.dx = 0;
/* 162 */     this.height += this.dHeight;
/* 163 */     this.dHeight = 0;
/* 164 */     return this;
/*     */   }
/*     */   
/*     */   public GBox tab(int tabs) {
/* 168 */     this.dx = 40 * tabs;
/* 169 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GBox space() {
/* 174 */     this.dx += 12;
/* 175 */     return this;
/*     */   }
/*     */   
/*     */   public GBox space(int size) {
/* 179 */     this.dx += size;
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText text() {
/*     */     GText t;
/* 186 */     if (this.textsFreeI >= this.texts.size()) {
/* 187 */       t = (GText)this.texts.get(0);
/*     */     } else {
/* 189 */       t = (GText)this.texts.get(this.textsFreeI);
/* 190 */       this.textsFreeI++;
/*     */     } 
/*     */     
/* 193 */     t.clear();
/* 194 */     t.setFont((UI.FONT()).S);
/* 195 */     t.setMaxWidth(this.maxWidth);
/* 196 */     t.normalify();
/* 197 */     return t;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GBox textLL(CharSequence t) {
/* 221 */     GText tt = text();
/* 222 */     if (tt == null)
/* 223 */       return this; 
/* 224 */     tt.lablify().add(t);
/* 225 */     add((SPRITE)tt);
/* 226 */     return this;
/*     */   }
/*     */   
/*     */   public GBox textL(CharSequence t) {
/* 230 */     GText tt = text();
/* 231 */     tt.lablifySub().add(t);
/* 232 */     add((SPRITE)tt);
/* 233 */     return this;
/*     */   }
/*     */   
/*     */   public GBox textLL(CharSequence t, int mTabW) {
/* 237 */     GText tt = text();
/* 238 */     if (tt == null)
/* 239 */       return this; 
/* 240 */     tt.lablify().add(t);
/* 241 */     tt.setMaxWidth(40 * mTabW);
/* 242 */     add((SPRITE)tt);
/* 243 */     return this;
/*     */   }
/*     */   
/*     */   public GBox textL(CharSequence t, int mTabW) {
/* 247 */     GText tt = text();
/* 248 */     tt.lablifySub().add(t);
/* 249 */     tt.setMaxWidth(40 * mTabW);
/* 250 */     add((SPRITE)tt);
/* 251 */     return this;
/*     */   }
/*     */   
/*     */   public GText textS(CharSequence te) {
/* 255 */     if (this.textsFreeI >= this.texts.size())
/* 256 */       return null; 
/* 257 */     GText t = (GText)this.texts.get(this.textsFreeI);
/* 258 */     this.textsFreeI++;
/*     */     
/* 260 */     t.clear();
/* 261 */     t.setFont((UI.FONT()).S);
/* 262 */     t.setMaxWidth(200);
/* 263 */     t.normalify();
/* 264 */     t.add(te);
/* 265 */     add((SPRITE)t);
/* 266 */     return t;
/*     */   }
/*     */   
/*     */   public GBox textSLL(CharSequence t) {
/* 270 */     GText tt = textS(t);
/* 271 */     tt.lablify();
/* 272 */     return this;
/*     */   }
/*     */   
/*     */   public GBox textSL(CharSequence t) {
/* 276 */     GText tt = textS(t);
/* 277 */     tt.lablifySub();
/* 278 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GBox add(SPRITE s) {
/* 283 */     if (s instanceof Text) {
/* 284 */       ((Text)s).adjustWidth();
/* 285 */       if (((Text)s).width() > this.maxWidth) {
/* 286 */         ((Text)s).setMaxWidth(this.maxWidth);
/*     */       }
/*     */     } 
/* 289 */     return add(s, s.width() + 4);
/*     */   }
/*     */   
/*     */   public GBox add(SPRITE s, COLOR col) {
/* 293 */     add(s);
/* 294 */     ((Ren)this.rens.get(this.rens.size() - 1)).col.set(col);
/* 295 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GBox add(SPRITE s, int width) {
/* 301 */     if (this.rensFreeI >= this.rensFree.size()) {
/* 302 */       GAME.Notify("" + this.rensFreeI);
/* 303 */       return this;
/*     */     } 
/* 305 */     ((Ren)this.rensFree.get(this.rensFreeI)).init(s, width);
/* 306 */     this.rensFreeI++;
/* 307 */     return this;
/*     */   }
/*     */   
/*     */   public GBox rewind() {
/* 311 */     if (this.rens.size() == 0)
/* 312 */       return this; 
/* 313 */     this.dx = ((Ren)this.rens.get(this.rens.size() - 1)).x;
/* 314 */     return this;
/*     */   }
/*     */   
/*     */   public void rewind(int am) {
/* 318 */     this.dx -= am;
/*     */   }
/*     */   
/*     */   public void debug() {
/* 322 */     LOG.ln(this.rensFree);
/*     */   }
/*     */ 
/*     */   
/*     */   public GBox add(RENDEROBJ obj) {
/* 327 */     if (this.rensFreeI >= this.rensFree.size()) {
/* 328 */       GAME.Notify("" + this.rensFreeI);
/* 329 */       return this;
/*     */     } 
/* 331 */     ((Ren)this.rensFree.get(this.rensFreeI)).init(obj, obj.body().width() + 4);
/* 332 */     this.rensFreeI++;
/* 333 */     return this;
/*     */   }
/*     */   
/*     */   public GBox add(INFO info) {
/* 337 */     title(info.name);
/* 338 */     text(info.desc);
/* 339 */     NL(4);
/* 340 */     return this;
/*     */   }
/*     */   
/*     */   public GBox setArea(RECTANGLE b) {
/* 344 */     if (b.width() > 1 || b.height() > 1) {
/* 345 */       GText t = text();
/* 346 */       t.add(b.width()).add('x').add(b.height()).adjustWidth();
/* 347 */       add((SPRITE)t);
/* 348 */       space();
/*     */     } 
/* 350 */     return this;
/*     */   }
/*     */   
/*     */   public GBox setResource(RESOURCE r, double amount) {
/* 354 */     if (this.rensFree.isEmpty()) {
/* 355 */       GAME.Notify(r.name);
/* 356 */       return this;
/*     */     } 
/* 358 */     if (amount == 0.0D)
/* 359 */       return this; 
/* 360 */     add((r.icon()).small);
/* 361 */     GText t = text();
/* 362 */     if (amount - (int)amount == 0.0D) {
/* 363 */       t.add((int)amount).adjustWidth();
/*     */     } else {
/* 365 */       t.add(amount).adjustWidth();
/* 366 */     }  if (!(SETT.PATH()).finders.resource.normal.has(r))
/* 367 */       t.errorify(); 
/* 368 */     add((SPRITE)t);
/* 369 */     return this;
/*     */   }
/*     */   
/*     */   public GBox resLine(RESOURCE r, double amount) {
/* 373 */     if (this.rensFree.isEmpty()) {
/* 374 */       GAME.Notify(r.name);
/* 375 */       return this;
/*     */     } 
/* 377 */     if (amount == 0.0D)
/* 378 */       return this; 
/* 379 */     add((r.icon()).small);
/* 380 */     text(r.names);
/* 381 */     tab(6);
/* 382 */     GFORMAT.f0(text(), amount);
/* 383 */     NL();
/* 384 */     return this;
/*     */   }
/*     */   
/*     */   public GBox setResource(RESOURCE r, int amount, int of) {
/* 388 */     add((r.icon()).small);
/* 389 */     GText t = text();
/* 390 */     GFORMAT.iofkInv(t, amount, of);
/* 391 */     if (!(SETT.PATH()).finders.resource.normal.has(r) && amount < of) {
/* 392 */       t.errorify();
/*     */     } else {
/* 394 */       t.normalify();
/* 395 */     }  add((SPRITE)t);
/* 396 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 401 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 406 */     return this.height + this.dHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 413 */     if (this.dHeight != 0) {
/* 414 */       NL();
/*     */     }
/* 416 */     if (this.width == 0 || this.height == 0) {
/* 417 */       this.box.inner().setWidth(this.width).setHeight(this.height);
/* 418 */       this.box.inner().moveX1(X1);
/* 419 */       this.box.inner().moveY1(Y1);
/* 420 */       this.box.renderTitle(r);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 428 */     this.box.inner().setWidth(this.width).setHeight(this.height);
/* 429 */     this.box.inner().moveX1(X1);
/* 430 */     this.box.inner().moveY1(Y1);
/*     */ 
/*     */     
/* 433 */     if (this.scroll.init()) {
/* 434 */       this.box.inner().incrW((this.scroll.sl.body().width() + 8));
/* 435 */       this.box.inner().setHeight(this.maxHeight);
/*     */     } 
/* 437 */     this.box.render(r, 0.0F);
/*     */     
/* 439 */     renderWithout(r, X1, Y1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderWithout(SPRITE_RENDERER r, int X1, int Y1) {
/* 444 */     if (this.dHeight != 0) {
/* 445 */       NL();
/*     */     }
/* 447 */     if (this.scroll.init()) {
/* 448 */       for (Ren ren : this.rens) {
/* 449 */         this.scroll.render(r, ren, X1, Y1);
/*     */       }
/*     */       
/* 452 */       this.scroll.sl.body().moveX1((X1 + this.width + 4));
/* 453 */       this.scroll.sl.body().moveY1(Y1);
/* 454 */       this.scroll.sl.render(r, 0.0F);
/*     */     } else {
/*     */       
/* 457 */       for (Ren ren : this.rens) {
/* 458 */         if (ren.renderable != null) {
/* 459 */           ren.col.bind();
/*     */           
/* 461 */           ren.renderable.render(r, X1 + ren.x, Y1 + ren.y);
/* 462 */           COLOR.unbind();
/*     */           
/*     */           continue;
/*     */         } 
/* 466 */         RENDEROBJ o = ren.ren;
/*     */         
/* 468 */         o.body().moveX1Y1((X1 + ren.x), (Y1 + ren.y));
/* 469 */         o.render(r, 0.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 480 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public RENDEROBJ asRenObj() {
/* 484 */     if (this.dHeight != 0)
/* 485 */       NL(); 
/* 486 */     this.object.body().setWidth(this.width).setHeight(this.height);
/* 487 */     return (RENDEROBJ)this.object;
/*     */   }
/*     */   
/*     */   public static GBox Dummy() {
/* 491 */     dummy.clear();
/* 492 */     return dummy;
/*     */   }
/*     */   
/*     */   public void error(CharSequence s) {
/* 496 */     if (s.length() > 0) {
/* 497 */       add((SPRITE)text().errorify().add(s));
/* 498 */       NL();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void warn(CharSequence s) {
/* 503 */     if (s.length() > 0) {
/* 504 */       add((SPRITE)text().warnify().add(s));
/* 505 */       NL();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean emptyIs() {
/* 511 */     return (this.rensFreeI == 0 && this.box.title().length() == 0);
/*     */   }
/*     */   
/*     */   public boolean emptyIs2() {
/* 515 */     return (this.rensFreeI == 0);
/*     */   }
/*     */   
/*     */   public GBox sep() {
/* 519 */     NL();
/* 520 */     if (this.sepsFreeI >= this.sepsFree.size()) {
/* 521 */       this.sepsFree.add(new Sep());
/*     */     }
/* 523 */     add((RENDEROBJ)this.sepsFree.get(this.sepsFreeI));
/* 524 */     NL();
/* 525 */     this.sepsFreeI++;
/* 526 */     return this;
/*     */   }
/*     */   
/*     */   private class Sep
/*     */     extends RENDEROBJ.RenderImp {
/*     */     Sep() {
/* 532 */       super(1, 12);
/*     */     }
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 536 */       GCOLOR.UI().border().render(r, this.body.x1(), this.body.x1() + GBox.this.width, this.body.y1() + 6, this.body.y1() + 7);
/*     */     } }
/*     */   
/*     */   private class Scroll {
/*     */     int current;
/*     */     int max;
/*     */     final int dh;
/*     */     
/*     */     private Scroll() {
/* 545 */       this.dh = (int)(GBox.this.maxHeight / 5.0D);
/* 546 */       this.ri = -1;
/* 547 */       this.ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 551 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 556 */             return GBox.Scroll.this.max;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 561 */             return GBox.Scroll.this.current;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 566 */             GBox.Scroll.this.current = t;
/*     */           }
/*     */         };
/*     */       
/* 570 */       this.sl = new GSliderVer(this.ii, GBox.this.maxHeight);
/*     */     }
/*     */     int ri; final INT.INTE ii; final GSliderVer sl;
/*     */     public boolean init() {
/* 574 */       int h = GBox.this.height + GBox.this.dHeight;
/* 575 */       if (h < GBox.this.maxHeight) {
/* 576 */         return false;
/*     */       }
/* 578 */       this.max = (int)Math.ceil((h - GBox.this.maxHeight) / this.dh);
/*     */       
/* 580 */       if (Math.abs(VIEW.RI() - this.ri) > 2) {
/* 581 */         this.current = 0;
/*     */       }
/*     */       
/* 584 */       this.ri = VIEW.RI();
/*     */ 
/*     */       
/* 587 */       double dv = MButt.clearWheelSpin();
/* 588 */       if (dv < 0.0D) {
/* 589 */         this.current++;
/* 590 */       } else if (dv > 0.0D) {
/* 591 */         this.current--;
/* 592 */       }  this.current = CLAMP.i(this.current, 0, this.max);
/* 593 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean passes(GBox.Ren ren) {
/* 599 */       int y1 = this.current * this.dh;
/* 600 */       int y2 = y1 + GBox.this.maxHeight;
/* 601 */       if (ren.renderable != null) {
/* 602 */         return (ren.y >= y1 && ren.y + ren.renderable.height() < y2);
/*     */       }
/* 604 */       RENDEROBJ o = ren.ren;
/* 605 */       return (ren.y >= y1 && ren.y + o.body().height() < y2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, GBox.Ren ren, int X1, int Y1) {
/* 614 */       if (passes(ren)) {
/* 615 */         Y1 -= this.current * this.dh;
/* 616 */         if (ren.renderable != null) {
/* 617 */           ren.col.bind();
/*     */           
/* 619 */           ren.renderable.render(r, X1 + ren.x, Y1 + ren.y);
/* 620 */           COLOR.unbind();
/*     */         }
/*     */         else {
/*     */           
/* 624 */           RENDEROBJ o = ren.ren;
/*     */           
/* 626 */           o.body().moveX1Y1((X1 + ren.x), (Y1 + ren.y));
/* 627 */           o.render(r, 0.0F);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GBox.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */