/*     */ package util.updating;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ public abstract class TileUpdater
/*     */   implements SAVABLE
/*     */ {
/*     */   private static final int randomizerSize = 64;
/*     */   private static final int randomizerMask = 63;
/*  14 */   private static final byte[][] randomizerX = new byte[64][64];
/*  15 */   private static final byte[][] randomizerY = new byte[64][64];
/*     */   static {
/*     */     int y;
/*  18 */     for (y = 0; y < 64; y++) {
/*  19 */       for (int x = 0; x < 64; x++) {
/*  20 */         randomizerX[y][x] = (byte)x;
/*  21 */         randomizerY[y][x] = (byte)y;
/*     */       } 
/*     */     } 
/*     */     
/*  25 */     for (y = 0; y < 64; y++) {
/*  26 */       for (int x = 0; x < 64; x++) {
/*     */         
/*  28 */         byte ax = randomizerX[y][x];
/*  29 */         byte ay = randomizerY[y][x];
/*     */         
/*  31 */         int x2 = RND.rInt(64);
/*  32 */         int y2 = RND.rInt(64);
/*     */         
/*  34 */         randomizerX[y][x] = randomizerX[y2][x2];
/*  35 */         randomizerY[y][x] = randomizerY[y2][x2];
/*     */         
/*  37 */         randomizerX[y2][x2] = ax;
/*  38 */         randomizerY[y2][x2] = ay;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private final int width;
/*     */   private final int height;
/*     */   private int x;
/*     */   private int y;
/*     */   private int i;
/*     */   private final double secondsBetween;
/*     */   private final double tilesPerSecond;
/*  49 */   private double acc = 0.0D;
/*     */ 
/*     */   
/*     */   public TileUpdater(int width, int height, double secondsBetween) {
/*  53 */     this.width = width;
/*  54 */     this.height = height;
/*  55 */     this.secondsBetween = secondsBetween;
/*  56 */     this.tilesPerSecond = (width * height) / secondsBetween;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/*  61 */     this.acc += ds * this.tilesPerSecond;
/*     */     
/*  63 */     int a = (int)this.acc;
/*  64 */     this.acc -= a;
/*  65 */     while (a > 0) {
/*  66 */       a--;
/*  67 */       update(this.x, this.y, this.i, this.secondsBetween);
/*     */       
/*  69 */       this.i++;
/*  70 */       this.x++;
/*  71 */       if (this.x >= this.width) {
/*  72 */         this.x = 0;
/*  73 */         this.y++;
/*     */       } 
/*  75 */       if (this.y >= this.height) {
/*  76 */         this.y = 0;
/*  77 */         this.x = 0;
/*  78 */         this.i = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRandom(double ds) {
/*  85 */     this.acc += ds * this.tilesPerSecond;
/*     */     
/*  87 */     int a = (int)this.acc;
/*  88 */     this.acc -= a;
/*     */     
/*  90 */     int qw = this.width / 64;
/*  91 */     int qh = this.height / 64;
/*     */     
/*  93 */     int divI = this.width / 64 * this.height / 64;
/*     */     
/*  95 */     while (a > 0) {
/*  96 */       a--;
/*     */ 
/*     */ 
/*     */       
/* 100 */       int di = this.i % divI;
/* 101 */       int qx = di % qw;
/* 102 */       int qy = di / qw % qh;
/* 103 */       qx *= 64;
/* 104 */       qy *= 64;
/*     */       
/* 106 */       int ri = this.i / divI;
/* 107 */       int rx = ri & 0x3F;
/* 108 */       int ry = ri / 64;
/*     */ 
/*     */ 
/*     */       
/* 112 */       qx += randomizerX[ry][rx];
/* 113 */       qy += randomizerY[ry][rx];
/*     */ 
/*     */ 
/*     */       
/* 117 */       int ui = qx + qy * this.width;
/* 118 */       update(qx, qy, ui, this.secondsBetween);
/*     */       
/* 120 */       this.i++;
/*     */       
/* 122 */       this.x++;
/* 123 */       if (this.x >= this.width) {
/* 124 */         this.x = 0;
/* 125 */         this.y++;
/*     */       } 
/*     */ 
/*     */       
/* 129 */       if (this.y >= this.height) {
/* 130 */         this.y = 0;
/* 131 */         this.x = 0;
/* 132 */         this.i = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void update(int paramInt1, int paramInt2, int paramInt3, double paramDouble);
/*     */   
/*     */   public final void save(FilePutter fp) {
/* 141 */     fp.writeInt(this.i);
/* 142 */     fp.writeInt(this.x);
/* 143 */     fp.writeInt(this.y);
/* 144 */     fp.d(this.acc);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void load(FileGetter fp) throws IOException {
/* 149 */     this.i = fp.i();
/* 150 */     this.x = fp.i();
/* 151 */     this.y = fp.i();
/* 152 */     this.acc = fp.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 157 */     this.i = 0;
/* 158 */     this.x = 0;
/* 159 */     this.y = 0;
/* 160 */     this.acc = 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\uti\\updating\TileUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */