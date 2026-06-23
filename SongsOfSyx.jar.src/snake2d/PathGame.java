/*     */ package snake2d;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface PathGame
/*     */   extends COORDINATE, SAVABLE
/*     */ {
/*     */   int getCapacity();
/*     */   
/*     */   int length();
/*     */   
/*     */   boolean isStart();
/*     */   
/*     */   void setStart();
/*     */   
/*     */   boolean isDest();
/*     */   
/*     */   boolean hasNext();
/*     */   
/*     */   boolean setNext();
/*     */   
/*     */   int getCurrentI();
/*     */   
/*     */   void setCurrentI(int paramInt);
/*     */   
/*     */   boolean hasPrev();
/*     */   
/*     */   boolean setPrev();
/*     */   
/*     */   public static abstract class DEST
/*     */   {
/*     */     protected abstract boolean isDest(int param1Int1, int param1Int2);
/*     */     
/*     */     protected abstract float getOptDistance(int param1Int1, int param1Int2);
/*     */     
/*     */     public static abstract class CLOSEST
/*     */       extends DEST
/*     */     {
/*     */       protected final float getOptDistance(int x, int y) {
/* 107 */         return 0.0F;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class PathSimple
/*     */     implements PathGame
/*     */   {
/*     */     private static final int bitA = 2;
/*     */     
/*     */     private static final int tilesPerInt = 8;
/*     */     private static final long mask = 3L;
/*     */     private static final long maskI = -4L;
/*     */     private final int[] bits;
/*     */     private int length;
/* 123 */     private int tilesI = 0;
/*     */ 
/*     */     
/*     */     private short currentX;
/*     */     
/*     */     private short currentY;
/*     */ 
/*     */     
/*     */     public PathSimple(int size) {
/* 132 */       int ints = size / 8;
/* 133 */       if (size % 8 > 0)
/* 134 */         ints++; 
/* 135 */       this.bits = Alloc.ii(ints);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 141 */       file.is(this.bits);
/* 142 */       file.i(this.length);
/* 143 */       file.i(this.tilesI);
/* 144 */       file.i(this.currentX).i(this.currentY);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 149 */       file.is(this.bits);
/*     */       
/* 151 */       this.length = file.i();
/* 152 */       this.tilesI = file.i();
/* 153 */       this.currentX = (short)file.i();
/* 154 */       this.currentY = (short)file.i();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 159 */       this.tilesI = 0;
/* 160 */       this.length = 0;
/*     */     }
/*     */     
/*     */     public void reverse() {
/* 164 */       while (hasPrev()) {
/* 165 */         setPrev();
/*     */       }
/*     */     }
/*     */     
/*     */     public void copyTo(PathSimple other) {
/* 170 */       if (other.getCapacity() < getCapacity())
/* 171 */         throw new RuntimeException(); 
/* 172 */       other.length = CLAMP.i(this.length, 0, other.getCapacity());
/* 173 */       other.tilesI = CLAMP.i(this.tilesI, 0, other.getCapacity());
/* 174 */       other.currentX = this.currentX;
/* 175 */       other.currentY = this.currentY;
/* 176 */       for (int i = 0; i < this.bits.length; i++) {
/* 177 */         other.bits[i] = this.bits[i];
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private final int get(int index) {
/* 183 */       if (index < 0 || index >= this.bits.length * 8 * 2) {
/* 184 */         throw new RuntimeException("outof");
/*     */       }
/* 186 */       index *= 2;
/* 187 */       int i1 = index / 32;
/*     */       
/* 189 */       index += 2;
/*     */       
/* 191 */       int i2 = index / 32;
/* 192 */       int b2 = index % 32;
/* 193 */       if (b2 == 0) {
/* 194 */         b2 = 32;
/*     */       }
/* 196 */       int res = this.bits[i1];
/*     */       
/* 198 */       if (i1 == i2 || b2 == 32) {
/* 199 */         res >>= 32 - b2;
/* 200 */         res = (int)(res & 0x3L);
/*     */       } else {
/* 202 */         res <<= b2;
/* 203 */         res = (int)(res & 0x3L);
/* 204 */         int res2 = this.bits[i2];
/* 205 */         res2 >>= 32 - b2;
/* 206 */         res2 = (int)(res2 & 3L >> b2);
/* 207 */         res |= res2;
/* 208 */         res = (int)(res & 0x3L);
/*     */       } 
/*     */       
/* 211 */       return res;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void set(int index, int value) {
/* 217 */       if (index < 0 || index >= this.bits.length * 8 * 2) {
/* 218 */         throw new RuntimeException("outof");
/*     */       }
/* 220 */       value = (int)(value & 0x3L);
/*     */       
/* 222 */       index *= 2;
/* 223 */       int i1 = index / 32;
/*     */       
/* 225 */       index += 2;
/*     */       
/* 227 */       int i2 = index / 32;
/* 228 */       int b2 = index % 32;
/* 229 */       if (b2 == 0) {
/* 230 */         b2 = 32;
/*     */       }
/* 232 */       int res = this.bits[i1];
/*     */       
/* 234 */       if (i1 == i2 || b2 == 32) {
/* 235 */         long m = -4L << 32 - b2;
/* 236 */         long m2 = (m ^ 0xFFFFFFFFFFFFFFFFL) >> 2L;
/* 237 */         res = (int)(res & (m | m2));
/* 238 */         res |= value << 32 - b2;
/* 239 */         this.bits[i1] = res;
/*     */       } else {
/*     */         
/* 242 */         res >>= 2 - b2;
/* 243 */         res <<= 2 - b2;
/* 244 */         res |= value >> b2;
/* 245 */         this.bits[i1] = res;
/*     */         
/* 247 */         res = this.bits[i2];
/* 248 */         int m = -1;
/* 249 */         for (int j = 0; j < b2; j++) {
/* 250 */           m >>= 1;
/* 251 */           m &= Integer.MAX_VALUE;
/*     */         } 
/* 253 */         res &= m;
/* 254 */         res |= value << 32 - b2;
/* 255 */         this.bits[i2] = res;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int getCapacity() {
/* 262 */       return this.bits.length * 8;
/*     */     }
/*     */     
/*     */     protected final void cancel() {
/* 266 */       this.length = 0;
/* 267 */       this.tilesI = 0;
/*     */     }
/*     */     
/*     */     public boolean set(PathTile dest) {
/* 271 */       if (dest == null) {
/* 272 */         cancel();
/* 273 */         return true;
/*     */       } 
/*     */       
/* 276 */       boolean ret = true;
/* 277 */       int i = 1;
/* 278 */       PathTile t = dest.pathParent;
/* 279 */       while (t != null) {
/* 280 */         i++;
/* 281 */         t = t.pathParent;
/*     */       } 
/*     */       
/* 284 */       this.length = i;
/*     */       
/* 286 */       int skip = this.length - getCapacity();
/* 287 */       if (skip > 0) {
/* 288 */         this.length = getCapacity();
/* 289 */         ret = false;
/* 290 */         while (skip > 0) {
/* 291 */           dest = dest.pathParent;
/* 292 */           skip--;
/*     */         } 
/*     */       } 
/*     */       
/* 296 */       this.tilesI = this.length - 2;
/* 297 */       this.currentX = dest.x;
/* 298 */       this.currentY = dest.y;
/* 299 */       while (this.tilesI >= 0) {
/* 300 */         dest = dest.pathParent;
/* 301 */         int dx = dest.x - this.currentX;
/* 302 */         int dy = dest.y - this.currentY;
/* 303 */         set(this.tilesI * 2, dy);
/* 304 */         set(this.tilesI * 2 + 1, dx);
/* 305 */         this.currentX = dest.x;
/* 306 */         this.currentY = dest.y;
/* 307 */         this.tilesI--;
/*     */       } 
/* 309 */       this.tilesI++;
/* 310 */       return ret;
/*     */     }
/*     */     
/*     */     public void setOne(int destX, int destY) {
/* 314 */       this.length = 1;
/*     */       
/* 316 */       this.currentX = (short)destX;
/* 317 */       this.currentY = (short)destY;
/* 318 */       this.tilesI = 0;
/*     */     }
/*     */     
/*     */     public void setTwo(int x1, int y1, int x2, int y2) {
/* 322 */       this.length = 2;
/* 323 */       set(0, y1 - y2);
/* 324 */       set(1, x1 - x2);
/* 325 */       this.currentX = (short)x1;
/* 326 */       this.currentY = (short)y1;
/* 327 */       this.tilesI = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int length() {
/* 332 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean isStart() {
/* 337 */       return (this.tilesI == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void setStart() {
/* 342 */       while (hasPrev()) {
/* 343 */         setPrev();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isDest() {
/* 349 */       return (this.tilesI >= this.length - 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean hasNext() {
/* 354 */       return (this.tilesI < this.length - 1);
/*     */     }
/*     */     
/*     */     public final boolean nextIsLast() {
/* 358 */       return (this.tilesI == this.length - 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean setNext() {
/* 363 */       if (hasNext()) {
/* 364 */         int x = get(this.tilesI * 2 + 1);
/* 365 */         int y = get(this.tilesI * 2);
/* 366 */         if (x == 3)
/* 367 */           x = -1; 
/* 368 */         if (y == 3)
/* 369 */           y = -1; 
/* 370 */         this.currentX = (short)(this.currentX - x);
/* 371 */         this.currentY = (short)(this.currentY - y);
/* 372 */         this.tilesI++;
/* 373 */         return true;
/*     */       } 
/* 375 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean hasPrev() {
/* 380 */       return (this.tilesI > 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean setPrev() {
/* 385 */       if (hasPrev()) {
/* 386 */         this.tilesI--;
/* 387 */         int y = get(this.tilesI * 2);
/* 388 */         int x = get(this.tilesI * 2 + 1);
/*     */         
/* 390 */         if (x == 3)
/* 391 */           x = -1; 
/* 392 */         if (y == 3)
/* 393 */           y = -1; 
/* 394 */         this.currentX = (short)(this.currentX + x);
/* 395 */         this.currentY = (short)(this.currentY + y);
/* 396 */         return true;
/*     */       } 
/* 398 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int x() {
/* 403 */       if (this.length > 0)
/* 404 */         return this.currentX; 
/* 405 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int y() {
/* 410 */       if (this.length > 0)
/* 411 */         return this.currentY; 
/* 412 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getCurrentI() {
/* 417 */       return this.tilesI;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCurrentI(int i) {
/* 422 */       if (i < 0 || i >= this.length)
/* 423 */         throw new RuntimeException(String.valueOf(i) + " " + this.length); 
/* 424 */       while (this.tilesI < i)
/* 425 */         setNext(); 
/* 426 */       while (this.tilesI > i)
/* 427 */         setPrev(); 
/*     */     }
/*     */     
/*     */     public void debug() {
/* 431 */       int iold = getCurrentI();
/* 432 */       setCurrentI(0);
/* 433 */       Printer.ln();
/* 434 */       Printer.ln("l:" + length());
/* 435 */       for (int i = 0; i < this.length; i++) {
/* 436 */         setCurrentI(i);
/* 437 */         Printer.ln("\t(" + x() + " " + y() + ")");
/*     */       } 
/* 439 */       setCurrentI(iold);
/* 440 */       Printer.ln();
/*     */     }
/*     */     
/*     */     protected void setLength(int length) {
/* 444 */       this.length = Math.min(length, this.length);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class PathFancy
/*     */     extends PathSimple
/*     */   {
/*     */     private boolean compleate;
/*     */     
/*     */     private double totalCost;
/*     */     
/*     */     private int totalLength;
/*     */     
/*     */     public PathFancy(int size) {
/* 459 */       super(size);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 466 */       super.save(file);
/* 467 */       file.bool(this.compleate);
/* 468 */       file.d(this.totalCost);
/* 469 */       file.i(this.totalLength);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 474 */       super.load(file);
/* 475 */       this.compleate = file.bool();
/* 476 */       this.totalCost = file.d();
/* 477 */       this.totalLength = file.i();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 482 */       super.clear();
/* 483 */       this.compleate = false;
/*     */     }
/*     */     
/*     */     public void copyTo(PathFancy other) {
/* 487 */       copyTo(other);
/* 488 */       if (other.getCapacity() < getCapacity())
/* 489 */         throw new RuntimeException(); 
/* 490 */       other.compleate = this.compleate;
/* 491 */       other.totalCost = this.totalCost;
/* 492 */       other.totalLength = this.totalLength;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean set(PathTile dest) {
/* 497 */       super.set(dest);
/* 498 */       this.totalCost = dest.accCost;
/*     */       
/* 500 */       int i = 1;
/* 501 */       PathTile t = dest.pathParent;
/* 502 */       while (t != null) {
/* 503 */         i++;
/* 504 */         t = t.pathParent;
/*     */       } 
/* 506 */       this.totalLength = i;
/*     */       
/* 508 */       this.compleate = super.set(dest);
/* 509 */       return this.compleate;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setOne(int destX, int destY) {
/* 515 */       super.setOne(destX, destY);
/* 516 */       this.totalCost = 0.0D;
/* 517 */       this.compleate = true;
/* 518 */       this.totalLength = 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setTwo(int x1, int y1, int x2, int y2) {
/* 523 */       super.setTwo(x1, y1, x2, y2);
/* 524 */       this.totalCost = 0.0D;
/* 525 */       this.totalLength = 2;
/* 526 */       this.compleate = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public final double getTotalCost() {
/* 531 */       return this.totalCost;
/*     */     }
/*     */     
/*     */     public int lengthTotal() {
/* 535 */       return this.totalLength;
/*     */     }
/*     */     
/*     */     public final boolean isCompleate() {
/* 539 */       return this.compleate;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface COST {
/*     */     public static final double BLOCKED = -1.0D;
/*     */     public static final double SKIP = -2.0D;
/*     */     
/*     */     double getCost(int param1Int1, int param1Int2, int param1Int3, int param1Int4);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\PathGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */