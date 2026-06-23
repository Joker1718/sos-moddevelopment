/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PData
/*     */ {
/*     */   private static final int CHUNK = 32768;
/*     */   private int activeLast;
/*     */   private float[] space;
/*     */   private int[] next;
/*     */   private short[] type;
/*     */   private float[] ref;
/*     */   private int[] shooter;
/*  25 */   private final Data data = new Data();
/*  26 */   private final Data dd = new Data();
/*     */   
/*     */   private final Map map;
/*  29 */   private static int SPACESIZE = 7;
/*     */   
/*  31 */   private final VectorImp vec = new VectorImp();
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */   
/*     */   public int create(int x, int y, int height, double dx, double dy, double dz, Projectile t, double reff, ENTITY entity) {
/*  39 */     if (!SETT.PIXEL_IN_BOUNDS(x, y))
/*  40 */       return -1; 
/*  41 */     if (this.activeLast >= this.next.length) {
/*  42 */       int nz = this.next.length + 32768;
/*     */       
/*  44 */       float[] space = new float[nz * SPACESIZE];
/*  45 */       for (int i = 0; i < this.space.length; i++)
/*  46 */         space[i] = this.space[i]; 
/*  47 */       this.space = space;
/*  48 */       int[] next = Alloc.ii(nz);
/*  49 */       short[] type = new short[nz];
/*  50 */       float[] ref = new float[nz];
/*  51 */       int[] shooter = Alloc.ii(nz);
/*  52 */       Arrays.fill(shooter, -1);
/*  53 */       for (int j = 0; j < this.next.length; j++) {
/*  54 */         next[j] = this.next[j];
/*  55 */         type[j] = this.type[j];
/*  56 */         ref[j] = this.ref[j];
/*  57 */         shooter[j] = this.shooter[j];
/*     */       } 
/*  59 */       this.next = next;
/*  60 */       this.type = type;
/*  61 */       this.ref = ref;
/*  62 */       this.shooter = shooter;
/*     */     } 
/*  64 */     this.dd.sI = this.activeLast * SPACESIZE;
/*     */ 
/*     */     
/*  67 */     this.dd.xSet(x);
/*  68 */     this.dd.ySet(y);
/*  69 */     this.dd.zSet(height);
/*     */ 
/*     */     
/*  72 */     double m = this.vec.set(dx, dy);
/*  73 */     this.dd.nxSet(this.vec.nX());
/*  74 */     this.dd.nySet(this.vec.nY());
/*  75 */     this.dd.dzSet(dz);
/*  76 */     this.dd.magnitudeSet(m);
/*     */     
/*  78 */     shooterSet(this.activeLast, entity);
/*  79 */     type(this.activeLast, t.index);
/*  80 */     ref(this.activeLast, reff);
/*  81 */     this.map.add(this.activeLast);
/*  82 */     t.soundRelease().rnd(x, y, 1.0D);
/*  83 */     this.activeLast++;
/*  84 */     return this.activeLast - 1;
/*     */   }
/*     */   
/*     */   public void remove(int index) {
/*  88 */     this.map.remove(index);
/*  89 */     this.activeLast--;
/*  90 */     if (index != this.activeLast) {
/*  91 */       this.map.remove(this.activeLast);
/*  92 */       copy(this.activeLast, index);
/*  93 */       this.map.add(index);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean move(int i, double nx, double ny) {
/* 102 */     float x = (float)nx;
/* 103 */     float y = (float)ny;
/*     */     
/* 105 */     if (!SETT.PIXEL_IN_BOUNDS((int)x, (int)y)) {
/* 106 */       remove(i);
/* 107 */       return false;
/*     */     } 
/*     */     
/* 110 */     this.dd.sI = i * SPACESIZE;
/* 111 */     if ((int)x >> Map.gridScroll != this.dd.qx() || (int)y >> Map.gridScroll != this.dd.qy()) {
/* 112 */       this.map.remove(i);
/* 113 */       this.dd.xSet(x);
/* 114 */       this.dd.ySet(y);
/* 115 */       this.map.add(i);
/*     */     } else {
/* 117 */       this.dd.xSet(x);
/* 118 */       this.dd.ySet(y);
/*     */     } 
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void copy(int fromI, int toI) {
/* 126 */     this.type[toI] = this.type[fromI];
/* 127 */     this.next[toI] = this.next[fromI];
/* 128 */     this.ref[toI] = this.ref[fromI];
/* 129 */     toI *= SPACESIZE;
/* 130 */     fromI *= SPACESIZE;
/*     */     
/* 132 */     for (int i = 0; i < SPACESIZE; i++) {
/* 133 */       this.space[toI + i] = this.space[fromI + i];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final class Data
/*     */   {
/*     */     private int sI;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float x() {
/* 148 */       return PData.this.space[this.sI + 0];
/*     */     }
/*     */     private void xSet(float x) {
/* 151 */       PData.this.space[this.sI + 0] = x;
/*     */     }
/*     */     public float y() {
/* 154 */       return PData.this.space[this.sI + 1];
/*     */     }
/*     */     private void ySet(float x) {
/* 157 */       PData.this.space[this.sI + 1] = x;
/*     */     }
/*     */     public float z() {
/* 160 */       return PData.this.space[this.sI + 2];
/*     */     }
/*     */     public void zSet(double x) {
/* 163 */       PData.this.space[this.sI + 2] = (float)x;
/*     */     }
/*     */     
/*     */     public float nx() {
/* 167 */       return PData.this.space[this.sI + 3];
/*     */     }
/*     */     public void nxSet(double x) {
/* 170 */       PData.this.space[this.sI + 3] = (float)x;
/*     */     }
/*     */     public float ny() {
/* 173 */       return PData.this.space[this.sI + 4];
/*     */     }
/*     */     public void nySet(double x) {
/* 176 */       PData.this.space[this.sI + 4] = (float)x;
/*     */     }
/*     */     public float dz() {
/* 179 */       return PData.this.space[this.sI + 5];
/*     */     }
/*     */     public void dzSet(double x) {
/* 182 */       PData.this.space[this.sI + 5] = (float)x;
/*     */     }
/*     */     void magnitudeSet(double x) {
/* 185 */       PData.this.space[this.sI + 6] = (float)x;
/*     */     }
/*     */     public double dMagnitude() {
/* 188 */       return PData.this.space[this.sI + 6];
/*     */     }
/*     */     
/*     */     public double speedX() {
/* 192 */       return nx() * dMagnitude();
/*     */     }
/*     */     
/*     */     public double speedY() {
/* 196 */       return ny() * dMagnitude();
/*     */     }
/*     */     
/*     */     public int qx() {
/* 200 */       return (int)x() >> Map.gridScroll;
/*     */     }
/*     */     
/*     */     public int qy() {
/* 204 */       return (int)y() >> Map.gridScroll;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Data data(int index) {
/* 212 */     this.data.sI = index * SPACESIZE;
/* 213 */     return this.data;
/*     */   }
/*     */   
/*     */   public int next(int index) {
/* 217 */     return this.next[index];
/*     */   }
/*     */   
/*     */   public Projectile type(int index) {
/* 221 */     return (Projectile)Projectile.ALL.get(this.type[index] & 0x7F);
/*     */   }
/*     */ 
/*     */   
/*     */   public double ref(int index) {
/* 226 */     return this.ref[index];
/*     */   }
/*     */   
/*     */   public void ref(int index, double ref) {
/* 230 */     this.ref[index] = (float)ref;
/*     */   }
/*     */   
/*     */   public void nextSet(int index, int n) {
/* 234 */     this.next[index] = n;
/*     */   }
/*     */   
/*     */   public void type(int index, short t) {
/* 238 */     this.type[index] = (short)(this.type[index] & t & 0x8000);
/* 239 */     this.type[index] = (short)(this.type[index] | t);
/*     */   }
/*     */   
/*     */   public ENTITY shooter(int index) {
/* 243 */     return SETT.ENTITIES().getByID(this.shooter[index]);
/*     */   }
/*     */   
/*     */   public void shooterSet(int index, ENTITY e) {
/* 247 */     int i = (e == null) ? -1 : e.id();
/* 248 */     this.shooter[index] = i;
/*     */   }
/*     */   
/*     */   public void live(int index, boolean live) {
/* 252 */     if (!live) {
/* 253 */       this.type[index] = (short)(this.type[index] | 0x8000);
/*     */     } else {
/* 255 */       this.type[index] = (short)(this.type[index] & 0xFFFF7FFF);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean live(int index) {
/* 260 */     return ((this.type[index] & 0x8000) == 0);
/*     */   }
/*     */   
/*     */   public final int last() {
/* 264 */     return this.activeLast;
/*     */   }
/*     */   PData(Map map) {
/* 267 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 271 */           file.i(PData.this.activeLast);
/* 272 */           for (int i = 0; i < PData.this.activeLast; i++) {
/* 273 */             file.s(PData.this.type[i]);
/* 274 */             file.f(PData.this.ref[i]);
/* 275 */             file.i(PData.this.shooter[i]);
/*     */           } 
/* 277 */           int am = PData.this.activeLast * PData.SPACESIZE;
/* 278 */           for (int j = 0; j < am; j++) {
/* 279 */             file.f(PData.this.space[j]);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 286 */           PData.this.activeLast = file.i();
/* 287 */           int l = (int)Math.ceil((PData.this.activeLast + 1) / 32768.0D);
/* 288 */           PData.this.space = new float[l * 32768 * PData.SPACESIZE];
/* 289 */           PData.this.next = Alloc.ii(l * 32768);
/* 290 */           PData.this.type = new short[l * 32768];
/* 291 */           PData.this.ref = new float[l * 32768];
/* 292 */           PData.this.shooter = Alloc.ii(l * 32768);
/* 293 */           int MZ = Projectile.ALL.size();
/* 294 */           for (int i = 0; i < PData.this.activeLast; i++) {
/* 295 */             PData.this.type[i] = file.s();
/* 296 */             if (PData.this.type[i] >= MZ)
/* 297 */               PData.this.type[i] = (short)(MZ - 1); 
/* 298 */             PData.this.ref[i] = file.f();
/* 299 */             PData.this.shooter[i] = file.i();
/*     */           } 
/* 301 */           int am = PData.this.activeLast * PData.SPACESIZE; int j;
/* 302 */           for (j = 0; j < am; j++) {
/* 303 */             PData.this.space[j] = file.f();
/*     */           }
/* 305 */           Arrays.fill(PData.this.next, -1);
/* 306 */           for (j = 0; j < PData.this.last(); j++) {
/* 307 */             PData.this.map.add(j);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 313 */           PData.this.space = new float[32768 * PData.SPACESIZE];
/* 314 */           PData.this.next = Alloc.ii(32768);
/* 315 */           Arrays.fill(PData.this.next, -1);
/* 316 */           PData.this.type = new short[32768];
/* 317 */           PData.this.ref = new float[32768];
/* 318 */           PData.this.shooter = Alloc.ii(32768);
/* 319 */           Arrays.fill(PData.this.shooter, -1);
/* 320 */           PData.this.activeLast = 0;
/*     */         }
/*     */       };
/*     */     this.map = map;
/*     */     this.saver.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\PData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */