/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectStreamException;
/*     */ import snake2d.UTIL;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum DIR
/*     */   implements COORDINATE
/*     */ {
/*  18 */   N(0, -1, 1, "north", 1) {
/*     */   
/*     */   },
/*  21 */   NE(1, -1, 1, "north-east", 2) {
/*     */   
/*     */   },
/*  24 */   E(1, 0, 2, "east", 5) {
/*     */   
/*     */   },
/*  27 */   SE(1, 1, 2, "south-east", 8) {
/*     */   
/*     */   },
/*  30 */   S(0, 1, 4, "south", 7) {
/*     */   
/*     */   },
/*  33 */   SW(-1, 1, 4, "south-west", 6) {
/*     */   
/*     */   },
/*  36 */   W(-1, 0, 8, "west", 3),
/*  37 */   NW(-1, -1, 8, "north-west", 0),
/*  38 */   C(4) {
/*     */      }; public static final LIST<DIR> ALL; public static final LIST<DIR> ALLC; public static final LIST<DIR> ORTHO; public static final LIST<DIR> ORTHOC; public static final LIST<DIR> NORTHO; private final transient int x; private final transient int y; private final transient double norX; private final transient double norY; private final transient String name; private final byte index; public final int bit; private final transient int mask; private final transient double distance; public final int boxID;
/*     */   private static final int[] toBox;
/*     */   
/*  42 */   static { ALL = (LIST<DIR>)new ArrayList((Object[])new DIR[] { N, NE, E, SE, S, SW, W, NW });
/*  43 */     ALLC = (LIST<DIR>)new ArrayList((Object[])new DIR[] { N, NE, E, SE, S, SW, W, NW, C });
/*  44 */     ORTHO = (LIST<DIR>)new ArrayList((Object[])new DIR[] { N, E, S, W });
/*  45 */     ORTHOC = (LIST<DIR>)new ArrayList((Object[])new DIR[] { C, N, E, S, W });
/*  46 */     NORTHO = (LIST<DIR>)new ArrayList((Object[])new DIR[] { NE, SE, SW, NW });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     toBox = Alloc.ii(16);
/*     */     
/* 280 */     toBox[W.mask | S.mask | E.mask] = 1;
/* 281 */     toBox[W.mask | S.mask] = 2;
/* 282 */     toBox[N.mask | S.mask | E.mask] = 3;
/* 283 */     toBox[15] = 4;
/* 284 */     toBox[N.mask | S.mask | W.mask] = 5;
/* 285 */     toBox[N.mask | E.mask] = 6;
/* 286 */     toBox[N.mask | E.mask | W.mask] = 7;
/* 287 */     toBox[N.mask | W.mask] = 8; }
/*     */   public static DIR get(COORDINATE coo) { return get(coo.x(), coo.y()); }
/*     */   public static DIR get(COORDINATE from, COORDINATE to) { return get((to.x() - from.x()), (to.y() - from.y())); }
/*     */   public static DIR get(int fx, int fy, COORDINATE to) { return get((to.x() - fx), (to.y() - fy)); }
/* 291 */   public static DIR get(COORDINATE from, int tx, int ty) { return get((tx - from.x()), (ty - from.y())); } public static DIR get(RECTANGLE a, RECTANGLE b) { double dx = (b.cX() - a.cX()); double dy = (b.cY() - a.cY()); return get(dx, dy); } public static DIR get(int fx, int fy, int tx, int ty) { return get((tx - fx), (ty - fy)); } public static DIR get(double norX2, double norY2) { if (norX2 == 0.0D && norY2 == 0.0D) return C;  if (norX2 == 0.0D) return (norY2 < 0.0D) ? N : S;  if (norY2 == 0.0D) return (norX2 < 0.0D) ? W : E;  double ratio = Math.abs(norX2 / norY2); if (ratio < 0.38D) return (norY2 < 0.0D) ? N : S;  if (ratio > 2.43D) return (norX2 < 0.0D) ? W : E;  if (norY2 < 0.0D) { if (norX2 < 0.0D) return NW;  return NE; }  if (norX2 < 0.0D) return SW;  return SE; } DIR(int boxId) { this.x = 0; this.y = 0; this.index = (byte)ordinal(); this.bit = 0; this.mask = 0; this.norX = 0.0D; this.norY = 0.0D; this.name = "centre"; this.distance = 0.0D; this.boxID = boxId; } DIR(int x, int y, int mask, String name, int boxID) { this.x = x; this.y = y; this.index = (byte)ordinal(); this.bit = 1 << this.index; this.name = name; this.mask = mask; if (x != 0 && y != 0) { this.norX = x * Math.sqrt(0.5D); this.norY = y * Math.sqrt(0.5D); this.distance = UTIL.SQRT2; } else { this.norX = x; this.norY = y; this.distance = 1.0D; }  this.boxID = boxID; } public double tileDistance() { return this.distance; } Object readResolve() throws ObjectStreamException { return ALL.get(this.index); } public int mask() { return this.mask; } public static int toBoxID(int orthoMask) { return toBox[orthoMask]; }
/*     */   public int x() { return this.x; }
/*     */   public int y() { return this.y; }
/*     */   public double xN() { return this.norX; }
/* 295 */   public double yN() { return this.norY; } public String getName() { return this.name; } public int id() { return this.index; } public DIR next(int nr) { return (DIR)ALL.get(this.index + nr & 0x7); } public DIR perpendicular() { return (DIR)ALL.get((id() + ALL.size() / 2) % ALL.size()); } public void positionWithin(RECTANGLEE target, RECTANGLE ref) { int x = ref.x1() + ref.width() / 2 * (x() + 1); int y = ref.y1() + ref.height() / 2 * (y() + 1); target.moveX2(x); target.moveY2(y); } public void positionCentered(RECTANGLEE target, RECTANGLE ref) { int x = ref.x1() + ref.width() / 2 * (x() + 1); int y = ref.y1() + ref.height() / 2 * (y() + 1); target.moveC(x, y); } public void positionEdge(Rec target, RECTANGLE ref) { int x = ref.x1() + ref.width() / 2 * (x() + 1); int y = ref.y1() + ref.height() / 2 * (y() + 1); target.moveX1Y1(x, y); } public void reposition(Rec old, int nWidth, int nHeight) { if (this.x < 0) { old.setWidth(nWidth); } else if (this.x > 0) { int x2 = old.x2(); old.setWidth(nWidth); old.moveX2(x2); } else { int cx = old.cX(); old.setWidth(nWidth); old.moveCX(cx); }  if (this.y < 0) { old.setHeight(nHeight); } else if (this.y > 0) { int y2 = old.y2(); old.setHeight(nHeight); old.moveY2(y2); } else { int cY = old.cY(); old.setHeight(nHeight); old.moveCY(cY); }  } public boolean isOrtho() { return (absSum() == 1.0D); } public int orthoID() { return this.index >> 1; }
/*     */ 
/*     */   
/*     */   public static void save(DIR dir, FilePutter file) {
/* 299 */     byte b = (byte)((dir == null) ? -1 : dir.id());
/* 300 */     file.b(b);
/*     */   }
/*     */   
/*     */   public static DIR load(FileGetter file) throws IOException {
/* 304 */     byte b = file.b();
/* 305 */     if (b < 0)
/* 306 */       return null; 
/* 307 */     return (DIR)ALL.get(b);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\DIR.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */