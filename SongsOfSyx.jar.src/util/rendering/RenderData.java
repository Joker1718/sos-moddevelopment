/*     */ package util.rendering;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import util.GUTIL;
/*     */ import util.data.RANMAP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderData
/*     */ {
/*  17 */   private int waters = 0;
/*  18 */   private int vegitations = 0;
/*     */   private int caves;
/*     */   private final Bitmap1D lit;
/*     */   private final Bitmap1D hid;
/*  22 */   private final RANMAP ran = GUTIL.ran1();
/*  23 */   private final RANMAP ran2 = GUTIL.ran2();
/*     */   
/*  25 */   private final Rec absoluteWin = new Rec();
/*  26 */   private final Rec gameWin = new Rec();
/*  27 */   private final Rec tileWin = new Rec();
/*     */   
/*     */   public boolean isLit = false;
/*     */   
/*     */   private int tx1;
/*     */   
/*     */   private int ty1;
/*     */   
/*     */   private int ty2;
/*     */   
/*     */   private int tx2;
/*     */   private short x1;
/*     */   private short y1;
/*     */   private final int TWIDTH;
/*     */   private final int THEIGHT;
/*     */   private final RenderIterator iter;
/*     */   
/*     */   public void init(RECTANGLE renWindow, int offX, int offY) {
/*  45 */     this.gameWin.set(renWindow);
/*  46 */     this.absoluteWin.set(renWindow).moveX1Y1(offX, offY);
/*     */     
/*  48 */     this.tx1 = renWindow.x1() / 64;
/*  49 */     this.tx2 = renWindow.x2() / 64;
/*     */     
/*  51 */     this.ty1 = renWindow.y1() / 64;
/*  52 */     this.ty2 = renWindow.y2() / 64;
/*     */     
/*  54 */     this.x1 = (short)(offX - renWindow.x1() % 64);
/*  55 */     this.y1 = (short)(offY - renWindow.y1() % 64);
/*     */     
/*  57 */     if (this.tx2 >= this.TWIDTH)
/*  58 */       this.tx2 = this.TWIDTH - 1; 
/*  59 */     if (this.ty2 >= this.THEIGHT) {
/*  60 */       this.ty2 = this.THEIGHT - 1;
/*     */     }
/*  62 */     if (this.ty1 < 0) {
/*  63 */       this.y1 = (short)(this.y1 - this.ty1 * 64);
/*  64 */       this.ty1 = 0;
/*     */     } 
/*     */     
/*  67 */     if (this.tx1 < 0) {
/*  68 */       this.x1 = (short)(this.x1 - this.tx1 * 64);
/*  69 */       this.tx1 = 0;
/*     */     } 
/*     */     
/*  72 */     for (int y = this.ty1 - 5; y <= this.ty2 + 5; y++) {
/*  73 */       for (int x = this.tx1 - 5; x <= this.tx2 + 5; x++) {
/*  74 */         if (x >= 0 && x < this.TWIDTH && y >= 0 && y < this.THEIGHT) {
/*  75 */           int i = y * this.TWIDTH + x;
/*  76 */           this.lit.set(i, false);
/*  77 */           this.hid.set(i, false);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  83 */     this.tileWin.set(this.tx1, (this.tx2 + 1), this.ty1, (this.ty2 + 1));
/*  84 */     this.vegitations = 0;
/*  85 */     this.waters = 0;
/*  86 */     this.caves = 0;
/*     */   }
/*     */   
/*     */   public int waters() {
/*  90 */     return this.waters;
/*     */   }
/*     */   
/*     */   public int caves() {
/*  94 */     return this.caves;
/*     */   }
/*     */   
/*     */   public int vegitations() {
/*  98 */     return this.vegitations;
/*     */   }
/*     */   
/*     */   public int area() {
/* 102 */     return this.tileWin.height() * this.tileWin.width();
/*     */   }
/*     */   
/*     */   public int offX1() {
/* 106 */     return this.tx1 * 64 - this.x1;
/*     */   }
/*     */   
/*     */   public int offY1() {
/* 110 */     return this.ty1 * 64 - this.y1;
/*     */   }
/*     */   
/*     */   public int x1() {
/* 114 */     return this.x1;
/*     */   }
/*     */   
/*     */   public int y1() {
/* 118 */     return this.y1;
/*     */   }
/*     */   
/*     */   public RECTANGLE absBounds() {
/* 122 */     return (RECTANGLE)this.absoluteWin;
/*     */   }
/*     */   
/*     */   public RECTANGLE gBounds() {
/* 126 */     return (RECTANGLE)this.gameWin;
/*     */   }
/*     */   
/*     */   public RECTANGLE tBounds() {
/* 130 */     return (RECTANGLE)this.tileWin;
/*     */   }
/*     */   
/*     */   public int tx1() {
/* 134 */     return this.tx1;
/*     */   }
/*     */   
/*     */   public int tx2() {
/* 138 */     return this.tx2;
/*     */   }
/*     */   
/*     */   public int ty1() {
/* 142 */     return this.ty1;
/*     */   }
/*     */   
/*     */   public int ty2() {
/* 146 */     return this.ty2;
/*     */   }
/*     */   
/*     */   public int transformGX(int x) {
/* 150 */     x -= this.gameWin.x1();
/* 151 */     x += this.absoluteWin.x1();
/* 152 */     return x;
/*     */   }
/*     */   
/*     */   public int transformGY(int x) {
/* 156 */     x -= this.gameWin.y1();
/* 157 */     x += this.absoluteWin.y1();
/* 158 */     return x;
/*     */   }
/*     */   
/*     */   public int random(int tx, int ty) {
/* 162 */     return this.ran.get(tx + ty * this.THEIGHT);
/*     */   }
/*     */   
/* 165 */   public RenderData(int twidth, int theight) { this.iter = new RenderIterator(); this.TWIDTH = twidth;
/*     */     this.THEIGHT = theight;
/*     */     this.lit = new Bitmap1D(twidth * theight, false);
/* 168 */     this.hid = new Bitmap1D(twidth * theight, false); } public RenderIterator onScreenTiles() { return this.iter.init(0, 0, 0, 0); }
/*     */ 
/*     */   
/*     */   public RenderIterator onScreenTiles(int offX1, int offX2, int offY1, int offY2) {
/* 172 */     return this.iter.init(offX1, offX2, offY1, offY2);
/*     */   }
/*     */   public final class RenderIterator { private int tStartX; private int tStartY;
/*     */     private int tEndX;
/*     */     private int tEndY;
/*     */     private int tx;
/*     */     private int ty;
/*     */     private int tile;
/*     */     private short x;
/*     */     private short y;
/*     */     private int rann;
/*     */     private long rann2;
/*     */     private int offX;
/*     */     private int offY;
/* 186 */     private final Coo coo = new Coo();
/*     */     
/*     */     private RenderIterator init(int offX1, int offX2, int offY1, int offY2) {
/* 189 */       this.tStartX = RenderData.this.tx1 - offX1;
/* 190 */       if (this.tStartX < 0)
/* 191 */         this.tStartX = 0; 
/* 192 */       this.tStartY = RenderData.this.ty1 - offY1;
/* 193 */       if (this.tStartY < 0)
/* 194 */         this.tStartY = 0; 
/* 195 */       this.tEndX = RenderData.this.tx2 + offX2;
/* 196 */       if (this.tEndX >= RenderData.this.TWIDTH)
/* 197 */         this.tEndX = RenderData.this.TWIDTH - 1; 
/* 198 */       this.tEndY = RenderData.this.ty2 + offY2;
/* 199 */       if (this.tEndY >= RenderData.this.THEIGHT)
/* 200 */         this.tEndY = RenderData.this.THEIGHT - 1; 
/* 201 */       this.x = (short)(RenderData.this.x1 - (RenderData.this.tx1 - this.tStartX) * 64);
/* 202 */       this.y = (short)(RenderData.this.y1 - (RenderData.this.ty1 - this.tStartY) * 64);
/* 203 */       this.tx = this.tStartX;
/* 204 */       this.ty = this.tStartY;
/* 205 */       this.tile = this.tx + this.ty * RenderData.this.TWIDTH;
/* 206 */       this.rann = RenderData.this.ran.get(this.tile);
/* 207 */       this.rann2 = RenderData.this.ran2.get(this.tile) << 32L | this.rann;
/* 208 */       if (this.tEndX <= this.tStartX) {
/* 209 */         this.ty = this.tStartY + 1;
/*     */       }
/* 211 */       if (this.tx >= this.tEndX)
/* 212 */         this.ty = this.tEndY + 1; 
/* 213 */       this.offX = 0;
/* 214 */       this.offY = 0;
/* 215 */       return this;
/*     */     }
/*     */     
/*     */     public final boolean has() {
/* 219 */       return (this.ty <= this.tEndY);
/*     */     }
/*     */     
/*     */     public final void countVegetation() {
/* 223 */       RenderData.this.vegitations++;
/*     */     }
/*     */     
/*     */     public final void countWater() {
/* 227 */       RenderData.this.waters++;
/*     */     }
/*     */     
/*     */     public final void countCave() {
/* 231 */       RenderData.this.caves++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void setOff(int dx, int dy) {
/* 239 */       this.offX = dx;
/* 240 */       this.offY = dy;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void next() {
/* 245 */       n();
/*     */ 
/*     */       
/* 248 */       if (RenderData.this.hid.get(this.tile)) {
/* 249 */         while (RenderData.this.hid.get(this.tile) && has()) {
/* 250 */           n();
/*     */         }
/*     */       }
/*     */       
/* 254 */       this.rann = RenderData.this.ran.get(this.tile);
/* 255 */       this.rann2 = RenderData.this.ran2.get(this.tile) << 32L | this.rann;
/* 256 */       this.offX = 0;
/* 257 */       this.offY = 0;
/*     */     }
/*     */     
/*     */     private final void n() {
/* 261 */       this.tile++;
/* 262 */       this.tx++;
/* 263 */       this.x = (short)(this.x + 64);
/* 264 */       if (this.tx > this.tEndX) {
/* 265 */         this.tx = this.tStartX;
/* 266 */         this.ty++;
/* 267 */         this.x = (short)(RenderData.this.x1 - (RenderData.this.tx1 - this.tStartX) * 64);
/* 268 */         this.tile = this.tx + this.ty * RenderData.this.TWIDTH;
/* 269 */         this.y = (short)(this.y + 64);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public final void nextAll() {
/* 275 */       this.tile++;
/* 276 */       this.tx++;
/* 277 */       this.x = (short)(this.x + 64);
/* 278 */       if (this.tx > this.tEndX) {
/* 279 */         this.tx = this.tStartX;
/* 280 */         this.ty++;
/* 281 */         this.x = (short)(RenderData.this.x1 - (RenderData.this.tx1 - this.tStartX) * 64);
/* 282 */         this.tile = this.tx + this.ty * RenderData.this.TWIDTH;
/* 283 */         this.y = (short)(this.y + 64);
/*     */       } 
/* 285 */       this.rann = RenderData.this.ran.get(this.tile);
/* 286 */       this.rann2 = RenderData.this.ran2.get(this.tile) << 32L | this.rann;
/* 287 */       this.tile = this.tx + this.ty * RenderData.this.TWIDTH;
/* 288 */       this.offX = 0;
/* 289 */       this.offY = 0;
/*     */     }
/*     */     
/*     */     public final int tx() {
/* 293 */       return this.tx;
/*     */     }
/*     */     
/*     */     public final int ty() {
/* 297 */       return this.ty;
/*     */     }
/*     */     
/*     */     public final COORDINATE coo() {
/* 301 */       this.coo.set(this.tx, this.ty);
/* 302 */       return (COORDINATE)this.coo;
/*     */     }
/*     */     
/*     */     public final int tile() {
/* 306 */       return this.tile;
/*     */     }
/*     */     
/*     */     public final int oX() {
/* 310 */       return this.offX;
/*     */     }
/*     */     
/*     */     public final int oY() {
/* 314 */       return this.offY;
/*     */     }
/*     */     
/*     */     public final int x() {
/* 318 */       return this.x + this.offX;
/*     */     }
/*     */     
/*     */     public final int y() {
/* 322 */       return this.y + this.offY;
/*     */     }
/*     */     
/*     */     public final int offX() {
/* 326 */       return -RenderData.this.tx1 * 64 + RenderData.this.x1;
/*     */     }
/*     */     
/*     */     public final int offY() {
/* 330 */       return -RenderData.this.ty1 * 64 + RenderData.this.y1;
/*     */     }
/*     */     
/* 333 */     public final COORDINATE realStart = new COORDINATE()
/*     */       {
/*     */         public int y()
/*     */         {
/* 337 */           return (RenderData.RenderIterator.access$0(RenderData.RenderIterator.this)).gameWin.x1();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/* 342 */           return (RenderData.RenderIterator.access$0(RenderData.RenderIterator.this)).gameWin.y1();
/*     */         }
/*     */       };
/*     */     
/*     */     public final void ranOffset(int dx, int dy) {
/* 347 */       this.rann = RenderData.this.ran.get(this.tile + dx + dy * RenderData.this.TWIDTH);
/* 348 */       this.rann2 = RenderData.this.ran2.get(this.tile + dx + dy * RenderData.this.TWIDTH) << 32L | this.rann;
/*     */     }
/*     */     
/*     */     public final void ranSwap() {
/* 352 */       this.rann = RenderData.this.ran2.get(this.tile);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int ran() {
/* 358 */       return this.rann;
/*     */     }
/*     */     
/*     */     public final long bigRan() {
/* 362 */       return this.rann2;
/*     */     }
/*     */     
/*     */     public final int ranGet(int dx, int dy) {
/* 366 */       int x = this.tx + dx;
/* 367 */       if (x < 0) {
/* 368 */         x += RenderData.this.TWIDTH;
/* 369 */       } else if (x >= RenderData.this.TWIDTH) {
/* 370 */         x -= RenderData.this.TWIDTH;
/*     */       } 
/* 372 */       int y = this.ty + dy;
/* 373 */       if (y < 0) {
/* 374 */         y += RenderData.this.THEIGHT;
/* 375 */       } else if (y >= RenderData.this.THEIGHT) {
/* 376 */         y -= RenderData.this.THEIGHT;
/* 377 */       }  return RenderData.this.ran.get(x + y * RenderData.this.THEIGHT);
/*     */     }
/*     */     
/*     */     public final int ran(int tx, int ty) {
/* 381 */       return RenderData.this.ran.get(tx + ty * RenderData.this.THEIGHT);
/*     */     }
/*     */     
/*     */     public final boolean litIs() {
/* 385 */       return RenderData.this.lit.get(this.tile);
/*     */     }
/*     */     
/*     */     public final boolean litIs(DIR d) {
/* 389 */       int t = this.tile + d.x() + d.y() * RenderData.this.TWIDTH;
/* 390 */       return RenderData.this.lit.get(t);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void lit() {
/* 395 */       RenderData.this.isLit = true;
/* 396 */       RenderData.this.lit.set(this.tile, true);
/*     */     }
/*     */     
/*     */     public final void hiddenSet() {
/* 400 */       RenderData.this.hid.set(this.tile, true);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\rendering\RenderData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */