/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ public final class ComposerSources
/*     */ {
/*     */   public final House house;
/*     */   public final Full full;
/*     */   public final House house2;
/*     */   public final Singles singles;
/*     */   public final Full full2;
/*     */   
/*  18 */   public final FullCombo combo = new FullCombo()
/*     */     {
/*     */       
/*     */       public ComposerSources.Source setSkip(int maxAmount, int skipfirst)
/*     */       {
/*  23 */         return null;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   ComposerSources() {
/*  29 */     this.full = new Full(6);
/*  30 */     this.singles = new Singles();
/*  31 */     this.full2 = new Full(3);
/*     */     
/*  33 */     this.house = new House(new Body(2, 2))
/*     */       {
/*     */         void setSize(int size) {
/*  36 */           this.size = size;
/*  37 */           int m = 2;
/*  38 */           this.offX[0] = 4 + 3 * size;
/*  39 */           this.offX[1] = 4 + 3 * size;
/*  40 */           this.offX[2] = 0;
/*  41 */           this.offX[3] = 0;
/*  42 */           this.offX[4] = 4 + 3 * size;
/*  43 */           this.offX[5] = 4 + 3 * size;
/*  44 */           this.offX[6] = 0;
/*  45 */           this.offX[7] = 0;
/*  46 */           this.offX[8] = 0 + 2 * size;
/*  47 */           this.offX[9] = 0 + 2 * size;
/*  48 */           this.offX[10] = 0 + 1 * size;
/*  49 */           this.offX[11] = 0 + 1 * size;
/*  50 */           this.offX[12] = 0 + 2 * size;
/*  51 */           this.offX[13] = 0 + 2 * size;
/*  52 */           this.offX[14] = 0 + 1 * size;
/*  53 */           this.offX[15] = 0 + 1 * size;
/*     */           
/*  55 */           this.offY[0] = 4 + 3 * size;
/*  56 */           this.offY[1] = 0 + 2 * size;
/*  57 */           this.offY[2] = 4 + 3 * size;
/*  58 */           this.offY[3] = 0 + 2 * size;
/*  59 */           this.offY[4] = 0;
/*  60 */           this.offY[5] = 0 + 1 * size;
/*  61 */           this.offY[6] = 0;
/*  62 */           this.offY[7] = 0 + 1 * size;
/*  63 */           this.offY[8] = 4 + 3 * size;
/*  64 */           this.offY[9] = 0 + 2 * size;
/*  65 */           this.offY[10] = 4 + 3 * size;
/*  66 */           this.offY[11] = 0 + 2 * size;
/*  67 */           this.offY[12] = 0;
/*  68 */           this.offY[13] = 0 + 1 * size;
/*  69 */           this.offY[14] = 0;
/*  70 */           this.offY[15] = 0 + 1 * size;
/*  71 */           this.width = 8 + 4 * size;
/*  72 */           this.height = 8 + 4 * size;
/*  73 */           this.body.init(0, 0, this.width, this.height, 1, 1);
/*     */         }
/*     */       };
/*     */     
/*  77 */     this.house2 = new House(new Body(4, 4))
/*     */       {
/*     */         void setSize(int size) {
/*  80 */           this.size = size;
/*  81 */           int m = 4;
/*  82 */           int m2 = 2;
/*     */           
/*  84 */           this.offX[0] = 0;
/*  85 */           this.offX[1] = 0 * (size + m2);
/*  86 */           this.offX[2] = 0 * (size + m2);
/*  87 */           this.offX[3] = 0 * (size + m2);
/*  88 */           this.offX[4] = 4 * (size + m2);
/*  89 */           this.offX[5] = 3 * (size + m2);
/*  90 */           this.offX[6] = 2 * (size + m2);
/*  91 */           this.offX[7] = 1 * (size + m2);
/*  92 */           this.offX[8] = 4 * (size + m2);
/*  93 */           this.offX[9] = 2 * (size + m2);
/*  94 */           this.offX[10] = 1 * (size + m2);
/*  95 */           this.offX[11] = 3 * (size + m2);
/*  96 */           this.offX[12] = 4 * (size + m2);
/*  97 */           this.offX[13] = 1 * (size + m2);
/*  98 */           this.offX[14] = 3 * (size + m2);
/*  99 */           this.offX[15] = 2 * (size + m2);
/*     */           
/* 101 */           this.offY[0] = 0;
/* 102 */           this.offY[1] = 1 * (size + m);
/* 103 */           this.offY[2] = 2 * (size + m);
/* 104 */           this.offY[3] = 0 * (size + m);
/* 105 */           this.offY[4] = 2 * (size + m);
/* 106 */           this.offY[5] = 1 * (size + m);
/* 107 */           this.offY[6] = 1 * (size + m);
/* 108 */           this.offY[7] = 2 * (size + m);
/* 109 */           this.offY[8] = 1 * (size + m);
/* 110 */           this.offY[9] = 0 * (size + m);
/* 111 */           this.offY[10] = 1 * (size + m);
/* 112 */           this.offY[11] = 0 * (size + m);
/* 113 */           this.offY[12] = 0 * (size + m);
/* 114 */           this.offY[13] = 0 * (size + m);
/* 115 */           this.offY[14] = 2 * (size + m);
/* 116 */           this.offY[15] = 2 * (size + m);
/* 117 */           this.width = m * 2 + m2 * 4 + 5 * size;
/* 118 */           this.height = m * 4 + 3 * size;
/* 119 */           this.body.init(0, 0, this.width, this.height, 1, 1);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Source
/*     */     implements BODY_HOLDER
/*     */   {
/*     */     int size;
/*     */ 
/*     */     
/*     */     abstract int height();
/*     */ 
/*     */     
/*     */     abstract int width();
/*     */ 
/*     */     
/*     */     abstract int x1();
/*     */     
/*     */     abstract int y1();
/*     */     
/*     */     public COLOR sample() {
/* 142 */       return ComposerThings.IColorSampler.save(Resources.c.sampleSource(x1(), y1()));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Body
/*     */     implements BODY_HOLDER
/*     */   {
/* 149 */     private final Rec body = new Rec();
/* 150 */     private final Rec allBody = new Rec();
/*     */     private final int marginLeft;
/*     */     private final int marginTop;
/*     */     
/*     */     Body(int marginLeft, int marginTop) {
/* 155 */       this.marginLeft = marginLeft;
/* 156 */       this.marginTop = marginTop;
/*     */     }
/*     */     private int bodiesX; private int bodiesY;
/*     */     void init(int x, int y, int width, int height, int nrWidth, int nrHeight) {
/* 160 */       this.body.set(x, (x + width), y, (y + height));
/* 161 */       this.bodiesX = nrWidth;
/* 162 */       this.bodiesY = nrHeight;
/* 163 */       this.allBody.set(x, (x + this.body.width() * nrWidth), y, (y + this.body.height() * nrHeight));
/* 164 */       assert nrWidth > 0 && nrHeight > 0 && this.marginLeft >= 0 && this.marginTop >= 0 && x >= 0 && y >= 0 && width > 0 && 
/* 165 */         height > 0;
/*     */     }
/*     */     
/*     */     void set(int nr) {
/* 169 */       int x = nr % this.bodiesX;
/* 170 */       int y = nr / this.bodiesX;
/* 171 */       if (y >= this.bodiesY)
/* 172 */         throw new RuntimeException("cant set var higher"); 
/* 173 */       this.body.moveX1Y1((this.allBody.x1() + x * this.body.width()), (this.allBody.y1() + y * this.body.height()));
/*     */     }
/*     */     
/*     */     int getStartX() {
/* 177 */       return this.body.x1() + this.marginLeft;
/*     */     }
/*     */     
/*     */     int getStartY() {
/* 181 */       return this.body.y1() + this.marginTop;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 186 */       return (RECTANGLE)this.allBody;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Imp
/*     */     extends Source
/*     */   {
/*     */     protected int size;
/*     */     private ComposerDests.Dest dest;
/*     */     
/*     */     public abstract boolean next();
/*     */     
/*     */     public abstract ComposerSources.Source setVar(int param1Int);
/*     */     
/*     */     public abstract ComposerSources.Source setSkip(int param1Int1, int param1Int2);
/*     */     
/*     */     public void paste(int dupRot, boolean setNext) {
/* 204 */       int i = 0;
/*     */       
/* 206 */       paste(setNext);
/*     */       
/* 208 */       for (int rot = 1; rot <= dupRot; ) {
/* 209 */         setRot(rot);
/*     */         while (true) {
/* 211 */           Resources.c.copy(this);
/* 212 */           Resources.c.pasteRotated(this.dest, rot);
/* 213 */           this.dest.jump(1);
/* 214 */           i++;
/* 215 */           if (next())
/*     */             rot++; 
/*     */         } 
/* 218 */       }  if (!setNext) {
/* 219 */         this.dest.jump(-i);
/*     */       }
/*     */     }
/*     */     
/*     */     public void paste(boolean setNext) {
/* 224 */       int i = 0;
/*     */       
/* 226 */       setRot(0);
/*     */       do {
/* 228 */         Resources.c.copy(this);
/* 229 */         Resources.c.paste(this.dest);
/* 230 */         this.dest.jump(1);
/* 231 */         i++;
/* 232 */       } while (!next());
/*     */       
/* 234 */       if (!setNext) {
/* 235 */         this.dest.jump(-i);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void pasteOverBackground(boolean setNext, double blend) {
/* 241 */       int i = 0;
/*     */       
/* 243 */       setRot(0);
/*     */       do {
/* 245 */         Resources.c.copy(this);
/* 246 */         Resources.c.paste(this.dest, blend);
/* 247 */         this.dest.jump(1);
/* 248 */         i++;
/* 249 */       } while (!next());
/*     */       
/* 251 */       if (!setNext) {
/* 252 */         this.dest.jump(-i);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void pasteRotated(int rotation, boolean setNext) {
/* 259 */       if (rotation == 0) {
/* 260 */         paste(setNext);
/*     */         
/*     */         return;
/*     */       } 
/* 264 */       int i = 0;
/*     */       
/* 266 */       setRot(rotation);
/*     */       do {
/* 268 */         Resources.c.copy(this);
/* 269 */         Resources.c.pasteRotated(this.dest, rotation);
/* 270 */         this.dest.jump(1);
/* 271 */         i++;
/* 272 */       } while (!next());
/*     */       
/* 274 */       if (!setNext) {
/* 275 */         this.dest.jump(-i);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void pasteStenciled(Imp stencil, int dupRot) {
/* 281 */       stencil.setRot(0);
/*     */       do {
/* 283 */         Resources.c.blendWithBackground(this.dest, stencil, this);
/* 284 */         Resources.c.paste(this.dest);
/* 285 */         this.dest.jump(1);
/* 286 */         next();
/* 287 */       } while (!stencil.next());
/*     */       
/* 289 */       for (int rot = 1; rot <= dupRot; ) {
/* 290 */         stencil.setRot(rot);
/*     */         while (true) {
/* 292 */           Resources.c.blendWithBackground(this.dest, stencil, this);
/* 293 */           Resources.c.pasteRotated(this.dest, rot);
/* 294 */           this.dest.jump(1);
/* 295 */           next();
/* 296 */           if (stencil.next())
/*     */             rot++; 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public void pasteNormal(int dupRot, boolean setNext) {
/* 303 */       int i = 0;
/*     */       
/* 305 */       setRot(0);
/*     */       do {
/* 307 */         Resources.c.copy(this);
/* 308 */         Resources.c.pasteNormalOnly(this.dest, 0);
/* 309 */         this.dest.jump(1);
/* 310 */         i++;
/* 311 */       } while (!next());
/*     */       
/* 313 */       for (int rot = 1; rot <= dupRot; ) {
/* 314 */         setRot(rot);
/*     */         while (true) {
/* 316 */           Resources.c.copy(this);
/* 317 */           Resources.c.pasteNormalOnly(this.dest, rot);
/* 318 */           this.dest.jump(1);
/* 319 */           i++;
/* 320 */           if (next())
/*     */             rot++; 
/*     */         } 
/* 323 */       }  if (!setNext) {
/* 324 */         this.dest.jump(-i);
/*     */       }
/*     */     }
/*     */     
/*     */     public void pasteEdges(boolean setNext) {
/* 329 */       this.dest.jump(1);
/* 330 */       Resources.c.copy(this);
/*     */       
/* 332 */       for (int i = 1; i < 16; i++) {
/*     */         
/* 334 */         if ((i & 0x1) > 0)
/* 335 */           Resources.c.paste(this.dest); 
/* 336 */         if ((i & 0x2) > 0)
/* 337 */           Resources.c.pasteRotated(this.dest, 1); 
/* 338 */         if ((i & 0x4) > 0)
/* 339 */           Resources.c.pasteRotated(this.dest, 2); 
/* 340 */         if ((i & 0x8) > 0)
/* 341 */           Resources.c.pasteRotated(this.dest, 3); 
/* 342 */         this.dest.jump(1);
/*     */       } 
/* 344 */       if (!setNext) {
/* 345 */         this.dest.jump(-16);
/*     */       }
/*     */     }
/*     */     
/*     */     void setDest(ComposerDests.Dest dest) {
/* 350 */       this.dest = dest;
/* 351 */       this.size = dest.size();
/*     */     }
/*     */ 
/*     */     
/*     */     abstract void setRot(int param1Int);
/*     */ 
/*     */     
/*     */     abstract int height();
/*     */ 
/*     */     
/*     */     abstract int width();
/*     */ 
/*     */     
/*     */     abstract int x1();
/*     */     
/*     */     abstract int y1();
/*     */     
/*     */     public final void debug() {
/* 369 */       LOG.ln("" + x1() + " " + x1());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Full
/*     */     extends Imp
/*     */   {
/* 376 */     private int tilesX = 8; private final int m;
/*     */     private int tileStart;
/*     */     private int tileEnd;
/*     */     private int tileCurrent;
/*     */     private int offX;
/*     */     private int offY;
/*     */     private int width;
/*     */     private int tilesY;
/*     */     private final ComposerSources.Body body;
/* 385 */     private int size = 0;
/*     */     
/*     */     private Full(int m) {
/* 388 */       this.m = m;
/* 389 */       this.body = new ComposerSources.Body(m, m);
/*     */     }
/*     */     
/*     */     private void setSize(int size) {
/* 393 */       this.size = size;
/* 394 */       this.body.init(0, 0, this.width, this.m * 2, 1, 1);
/*     */     }
/*     */     
/*     */     public Full init(int x, int y, int width, int height, int tilesX, int tilesY, ComposerDests.Tile dest) {
/* 398 */       setSize(dest.size());
/* 399 */       this.tilesX = tilesX;
/* 400 */       this.width = this.m * 2 + tilesX * this.size;
/* 401 */       this.body.init(x, y, this.width, tilesY * this.size + 2 * this.m, width, height);
/* 402 */       setVar(0);
/* 403 */       setSkip(0, tilesY * tilesX);
/* 404 */       this.tilesY = tilesY;
/* 405 */       setDest(dest);
/* 406 */       this.tileCurrent = 0;
/* 407 */       this.tileStart = 0;
/* 408 */       this.tileEnd = tilesX * tilesY;
/* 409 */       calc();
/* 410 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Full setSkip(int maxAmount, int skipfirst) {
/* 415 */       this.tileStart = skipfirst;
/* 416 */       this.tileEnd = this.tileStart + maxAmount;
/* 417 */       assert this.tileEnd <= this.tilesX * this.tilesY && this.tileEnd > this.tileStart;
/* 418 */       this.tileCurrent = this.tileStart;
/* 419 */       calc();
/* 420 */       return this;
/*     */     }
/*     */     
/*     */     public Full setNextSingle() {
/* 424 */       setSkip(1, this.tileStart + 1);
/* 425 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Full setVar(int var) {
/* 430 */       this.body.set(var);
/* 431 */       calc();
/* 432 */       return this;
/*     */     }
/*     */     
/*     */     private void calc() {
/* 436 */       this.offX = this.tileCurrent % this.tilesX;
/* 437 */       this.offY = this.tileCurrent / this.tilesX;
/* 438 */       this.offX *= this.size;
/* 439 */       this.offY *= this.size;
/* 440 */       this.offX += this.body.getStartX();
/* 441 */       this.offY += this.body.getStartY();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 447 */       this.tileCurrent++;
/*     */       
/* 449 */       if (this.tileCurrent >= this.tileEnd) {
/* 450 */         this.tileCurrent = this.tileStart;
/* 451 */         calc();
/* 452 */         return true;
/*     */       } 
/* 454 */       calc();
/* 455 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 460 */       return this.body.body();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void setRot(int rot) {}
/*     */ 
/*     */ 
/*     */     
/*     */     int height() {
/* 470 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 475 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 480 */       return this.offX;
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 485 */       return this.offY;
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class House
/*     */     extends Imp
/*     */   {
/* 607 */     protected final int[] offX = Alloc.ii(16);
/* 608 */     protected final int[] offY = Alloc.ii(16);
/* 609 */     protected int sx = 0, sy = 0;
/* 610 */     protected int tCurrent = 0;
/* 611 */     protected int tEnd = 16, tStart = 0;
/* 612 */     protected int rot = 0;
/* 613 */     protected int rotM = 0;
/*     */     
/*     */     protected int width;
/*     */     protected int height;
/*     */     protected final ComposerSources.Body body;
/* 618 */     protected int size = 0;
/*     */     
/*     */     private House(ComposerSources.Body b) {
/* 621 */       this.body = b;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public House init(int x, int y, int housesX, int housesY, ComposerDests.Dest dest) {
/* 627 */       setSize(dest.size());
/* 628 */       this.body.init(x, y, this.width, this.height, housesX, housesY);
/* 629 */       setDest(dest);
/* 630 */       setVar(0);
/* 631 */       setSkip(0, 16);
/* 632 */       setRot(0);
/* 633 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public House setSkip(int start, int amount) {
/* 638 */       this.tStart = start;
/* 639 */       this.tEnd = this.tStart + amount;
/* 640 */       this.tCurrent = this.tStart;
/* 641 */       assert this.tStart >= 0 && this.tEnd <= 16 && this.tStart < this.tEnd;
/* 642 */       setRot(0);
/* 643 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public House setVar(int var) {
/* 648 */       this.body.set(var);
/* 649 */       setRot(0);
/* 650 */       this.tCurrent = this.tStart;
/* 651 */       this.rot = 0;
/* 652 */       this.rotM = 0;
/* 653 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 658 */       this.tCurrent++;
/* 659 */       if (this.tCurrent >= this.tEnd) {
/* 660 */         this.tCurrent = this.tStart;
/* 661 */         return true;
/*     */       } 
/* 663 */       rotate();
/* 664 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void setRot(int rot) {
/* 669 */       this.rot = rot;
/* 670 */       rotate();
/*     */     }
/*     */     
/*     */     private void rotate() {
/* 674 */       this.rotM = this.tCurrent;
/* 675 */       for (int rotI = 0; rotI < this.rot; rotI++) {
/* 676 */         if ((this.rotM & 0x1) == 1) {
/* 677 */           this.rotM = this.rotM >> 1 | 0x8;
/*     */         } else {
/* 679 */           this.rotM >>= 1;
/*     */         } 
/* 681 */       }  this.sx = this.body.getStartX() + this.offX[this.rotM];
/* 682 */       this.sy = this.body.getStartY() + this.offY[this.rotM];
/*     */     }
/*     */ 
/*     */     
/*     */     int height() {
/* 687 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 692 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 697 */       return this.sx;
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 702 */       return this.sy;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 707 */       return this.body.body();
/*     */     }
/*     */     
/*     */     abstract void setSize(int param1Int);
/*     */   }
/*     */   
/*     */   public static class Singles extends Imp {
/* 714 */     private int tilesX = 4;
/*     */     private static final int m = 6;
/* 716 */     private int pixelX = 0; private int pixelY = 0;
/*     */     private int tileStart;
/*     */     private int tileEnd;
/*     */     private int tileCurrent;
/* 720 */     private final ComposerSources.Body body = new ComposerSources.Body(6, 6);
/*     */ 
/*     */     
/*     */     private int width;
/*     */ 
/*     */     
/*     */     private int tilesY;
/*     */ 
/*     */ 
/*     */     
/*     */     public Singles setVar(int var) {
/* 731 */       this.body.set(var);
/* 732 */       setSkip(0, this.tilesY * this.tilesX);
/* 733 */       calc();
/* 734 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Singles setSkip(int start, int amount) {
/* 739 */       this.tileStart = start;
/* 740 */       this.tileEnd = this.tileStart + amount;
/* 741 */       this.tileCurrent = this.tileStart;
/* 742 */       calc();
/* 743 */       return this;
/*     */     }
/*     */     
/*     */     public Singles init(int x, int y, int width, int height, int tilesX, int tilesY, ComposerDests.Dest dest) {
/* 747 */       this.tilesX = tilesX;
/* 748 */       this.tilesY = tilesY;
/* 749 */       setDest(dest);
/* 750 */       this.width = 6 + tilesX * (this.size + 6);
/* 751 */       int h = 6 + tilesY * (this.size + 6);
/* 752 */       this.body.init(x, y, this.width, h, width, height);
/* 753 */       setVar(0);
/* 754 */       return this;
/*     */     }
/*     */     
/*     */     private void calc() {
/* 758 */       int tx = this.tileCurrent % this.tilesX;
/* 759 */       int ty = this.tileCurrent / this.tilesX;
/* 760 */       this.pixelX = this.body.getStartX() + tx * (this.size + 6);
/* 761 */       this.pixelY = this.body.getStartY() + ty * (this.size + 6);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 767 */       this.tileCurrent++;
/*     */       
/* 769 */       if (this.tileCurrent >= this.tileEnd) {
/* 770 */         this.tileCurrent = this.tileStart;
/* 771 */         calc();
/* 772 */         return true;
/*     */       } 
/* 774 */       calc();
/* 775 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void setRot(int rot) {}
/*     */ 
/*     */ 
/*     */     
/*     */     int height() {
/* 785 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 790 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 795 */       return this.pixelX;
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 800 */       return this.pixelY;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 805 */       return this.body.body();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FullCombo
/*     */     extends Imp
/*     */   {
/*     */     int tx;
/*     */     int ty;
/*     */     private int comboWidth;
/*     */     private int comboHeight;
/* 817 */     private int sx = 0, sy = 0;
/* 818 */     private int rot = 0;
/*     */     
/* 820 */     private final ComposerSources.Body body = new ComposerSources.Body(6, 6);
/*     */ 
/*     */     
/*     */     private static final int m = 6;
/*     */ 
/*     */ 
/*     */     
/*     */     public FullCombo init(int x, int y, int combosX, int combosY, int comboSize, ComposerDests.Dest dest) {
/* 828 */       setDest(dest);
/* 829 */       this.comboWidth = comboSize;
/* 830 */       this.comboHeight = comboSize;
/* 831 */       int width = 12 + comboSize * this.size;
/* 832 */       this.body.init(x, y, width, width, combosX, combosY);
/* 833 */       setVar(0);
/* 834 */       this.tx = 0;
/* 835 */       this.ty = 0;
/* 836 */       setRot(0);
/* 837 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public FullCombo init(int x, int y, int combosX, int combosY, int width, int height, ComposerDests.Dest dest) {
/* 842 */       setDest(dest);
/* 843 */       this.comboWidth = width;
/* 844 */       this.comboHeight = height;
/* 845 */       this.body.init(x, y, 12 + width * this.size, 12 + height * this.size, combosX, combosY);
/* 846 */       setVar(0);
/* 847 */       this.tx = 0;
/* 848 */       this.ty = 0;
/* 849 */       setRot(0);
/* 850 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public FullCombo setVar(int var) {
/* 855 */       this.body.set(var);
/* 856 */       setRot(0);
/* 857 */       this.tx = 0;
/* 858 */       this.ty = 0;
/* 859 */       this.rot = 0;
/* 860 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean next() {
/* 865 */       this.tx++;
/* 866 */       if (this.tx >= this.comboWidth) {
/* 867 */         this.tx = 0;
/* 868 */         this.ty++;
/* 869 */         if (this.ty >= this.comboHeight) {
/* 870 */           this.ty = 0;
/* 871 */           return true;
/*     */         } 
/*     */       } 
/* 874 */       rotate();
/* 875 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void setRot(int rot) {
/* 880 */       this.rot = rot;
/* 881 */       rotate();
/*     */     }
/*     */ 
/*     */     
/*     */     private void rotate() {
/* 886 */       int x = this.tx;
/* 887 */       int y = this.ty;
/*     */       
/* 889 */       if ((this.rot & 0x1) > 0) {
/*     */         
/* 891 */         int i = x + y * this.comboWidth;
/*     */         
/* 893 */         x = i % this.comboHeight;
/* 894 */         y = i / this.comboHeight;
/*     */         
/* 896 */         int oldX = x;
/* 897 */         x = y;
/* 898 */         y = this.comboHeight - oldX - 1;
/*     */       } 
/*     */ 
/*     */       
/* 902 */       if ((this.rot & 0x2) > 0) {
/*     */         
/* 904 */         y = this.comboHeight - y - 1;
/* 905 */         x = this.comboWidth - x - 1;
/*     */       } 
/*     */ 
/*     */       
/* 909 */       this.sx = this.body.getStartX() + x * this.size;
/* 910 */       this.sy = this.body.getStartY() + y * this.size;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     int height() {
/* 916 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 921 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 926 */       return this.sx;
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 931 */       return this.sy;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 936 */       return this.body.body();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ComposerSources.Source setSkip(int maxAmount, int skipfirst) {
/* 942 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerSources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */