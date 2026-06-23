/*     */ package world;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.Errors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WorldGenMapType
/*     */ {
/*     */   public final int DIM;
/*     */   private final byte[][] map;
/*     */   private final double ii;
/*  82 */   private static COLOR[] cols = new COLOR[] {
/*  83 */       (COLOR)new ColorImp(25, 25, 50), 
/*  84 */       (COLOR)new ColorImp(50, 60, 20), 
/*  85 */       (COLOR)new ColorImp(30, 25, 25)
/*     */     };
/*     */   
/*     */   public final String name;
/*     */   
/*     */   public WorldGenMapType(String name, int worldDim) {
/*  91 */     this.name = name;
/*  92 */     Path path = PATHS.SPRITE().getFolder("world").getFolder("generatorMaps").get(name);
/*  93 */     SnakeImage im = new SnakeImage(path);
/*  94 */     this.DIM = im.width;
/*  95 */     if (this.DIM != im.height)
/*  96 */       throw new Errors.DataError(String.valueOf(PATHS.SPRITE().getFolder("world").getFolder("generatorMaps").get(name).toAbsolutePath()) + " is not a square. Image must have the same with and height"); 
/*  97 */     this.map = new byte[this.DIM][this.DIM];
/*  98 */     for (int y = 0; y < im.height; y++) {
/*  99 */       for (int x = 0; x < im.width; x++) {
/* 100 */         this.map[y][x] = (byte)(im.rgb.get(x, y) >> 8 & 0xFF);
/*     */       }
/*     */     } 
/* 103 */     this.ii = 1.0D / worldDim;
/* 104 */     im.dispose();
/*     */   }
/*     */   
/*     */   private double g(int x, int y) {
/* 108 */     return (this.map[y][x] & 0xFF) * this.ii;
/*     */   }
/*     */   
/*     */   private double dd(double d) {
/* 112 */     if (d < 0.5D)
/* 113 */       return -(0.5D - d) * 2.0D; 
/* 114 */     return (d - 0.5D) * 2.0D;
/*     */   }
/*     */   
/*     */   public double h(int x, int y) {
/* 118 */     return dd(g(x, y));
/*     */   }
/*     */ 
/*     */   
/*     */   public double h(int x, int y, int w, int h) {
/* 123 */     double xx = x;
/* 124 */     xx /= w;
/* 125 */     x = (int)(xx * this.DIM);
/* 126 */     xx -= (int)xx;
/* 127 */     double yy = y;
/* 128 */     yy /= h;
/* 129 */     y = (int)(yy * this.DIM);
/* 130 */     yy -= (int)yy;
/*     */ 
/*     */     
/* 133 */     double area = 0.0D;
/* 134 */     double res = 0.0D;
/*     */     
/* 136 */     double a = (1.0D - xx) * (1.0D - yy);
/* 137 */     res += a * g(x, y);
/* 138 */     area += a;
/*     */     
/* 140 */     if (x + 1 < this.map.length) {
/* 141 */       a = xx * (1.0D - yy);
/* 142 */       res += a * g(x + 1, y);
/* 143 */       area += a;
/*     */     } 
/*     */     
/* 146 */     if (y + 1 < this.map.length) {
/* 147 */       a = (1.0D - xx) * yy;
/* 148 */       res += a * g(x, y + 1);
/* 149 */       area += a;
/*     */     } 
/*     */     
/* 152 */     if (x + 1 < this.map.length && y + 1 < this.map.length) {
/* 153 */       a = xx * yy;
/* 154 */       res += a * g(x + 1, y + 1);
/* 155 */       area += a;
/*     */     } 
/*     */     
/* 158 */     return dd(res / area);
/*     */   }
/*     */   
/*     */   public void save(FilePutter f) {
/* 162 */     f.bs(this.map);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, int i) {
/* 166 */     for (int y = 0; y < this.DIM; y++) {
/* 167 */       for (int x = 0; x < this.DIM; x++) {
/* 168 */         int e = (int)((this.map[y][x] & 0xFF) * this.ii * cols.length);
/* 169 */         int xx = x1 + x * i;
/* 170 */         int yy = y1 + y * i;
/* 171 */         cols[e].render(r, xx, xx + i, yy, yy + i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldGenMapType[] getAll(int worldDim) {
/* 178 */     PATH p = PATHS.SPRITE().getFolder("world").getFolder("generatorMaps");
/* 179 */     String[] files = p.getFiles();
/* 180 */     WorldGenMapType[] res = new WorldGenMapType[files.length];
/* 181 */     for (int i = 0; i < files.length; i++)
/* 182 */       res[i] = new WorldGenMapType(files[i], worldDim); 
/* 183 */     return res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\WorldGen$WorldGenMapType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */