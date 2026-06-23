/*     */ package util.rendering;
/*     */ 
/*     */ import settlement.entity.EPHYSICS;
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Real
/*     */   extends ShadowBatch
/*     */ {
/*  23 */   protected double dD = 127.0D;
/*     */   
/*     */   protected int iterations;
/*     */   
/*     */   protected int startX;
/*     */   protected int startY;
/*     */   protected double x;
/*     */   protected double y;
/*     */   protected double dx;
/*     */   protected double dy;
/*     */   protected boolean bx;
/*  34 */   protected int lastHeight = -1;
/*  35 */   protected final byte SoftShadow = Byte.MAX_VALUE;
/*  36 */   protected final byte fullShadow = -1;
/*  37 */   protected byte streangth = Byte.MAX_VALUE;
/*  38 */   protected byte prev = this.streangth;
/*     */   
/*     */   protected int zoomout;
/*  41 */   protected double[] xs = new double[32];
/*  42 */   protected double[] ys = new double[32];
/*  43 */   protected double[] dds = new double[32];
/*  44 */   protected int[] iis = Alloc.ii(32);
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(int zoomout, double dx, double dy) {
/*  49 */     this.x = dx;
/*  50 */     this.y = dy;
/*     */     
/*  52 */     this.bx = (Math.abs(this.x) > Math.abs(this.y));
/*  53 */     this.zoomout = zoomout;
/*     */     
/*  55 */     for (int i = 0; i < this.iis.length; i++) {
/*  56 */       psetHeight(i);
/*  57 */       this.xs[i] = this.dx;
/*  58 */       this.ys[i] = this.dy;
/*  59 */       this.iis[i] = this.iterations;
/*  60 */       this.dds[i] = this.dD;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void psetHeight(int height) {
/*  66 */     this.lastHeight = height;
/*     */ 
/*     */     
/*  69 */     this.dx = this.x * height;
/*  70 */     this.dy = this.y * height;
/*     */     
/*  72 */     if (this.bx) {
/*  73 */       this.iterations = (int)Math.abs(this.dx);
/*     */     } else {
/*  75 */       this.iterations = (int)Math.abs(this.dy);
/*     */     } 
/*     */     
/*  78 */     this.iterations = (int)Math.ceil(this.iterations);
/*     */     
/*  80 */     this.iterations = 1 + (this.iterations >> this.zoomout);
/*     */ 
/*     */     
/*  83 */     this.dx /= this.iterations;
/*  84 */     this.dy /= this.iterations;
/*     */     
/*  86 */     this.dD = 127.0D / this.iterations;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShadowBatch setHeight(int height) {
/*  93 */     if (height == this.lastHeight) {
/*  94 */       return this;
/*     */     }
/*     */     
/*  97 */     this.lastHeight = height;
/*     */     
/*  99 */     if (height < this.iis.length) {
/* 100 */       this.dx = this.xs[height];
/* 101 */       this.dy = this.ys[height];
/* 102 */       this.iterations = this.iis[height];
/* 103 */       this.dD = this.dds[height];
/* 104 */       return this;
/*     */     } 
/*     */ 
/*     */     
/* 108 */     psetHeight(height);
/*     */     
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ShadowBatch setHeightUI(double height) {
/* 116 */     this.dx = 0.5D * height;
/* 117 */     this.dy = 0.5D * height;
/*     */     
/* 119 */     if (this.bx) {
/* 120 */       this.iterations = (int)Math.abs(this.dx);
/*     */     } else {
/* 122 */       this.iterations = (int)Math.abs(this.dy);
/*     */     } 
/*     */     
/* 125 */     this.iterations = (int)Math.ceil(height);
/*     */     
/* 127 */     this.iterations = 1 + (this.iterations >> this.zoomout);
/*     */ 
/*     */     
/* 130 */     this.dx /= this.iterations;
/* 131 */     this.dy /= this.iterations;
/*     */     
/* 133 */     this.dD = 127.0D / this.iterations;
/* 134 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShadowBatch setDistance2Ground(double height) {
/* 139 */     this.startX = (int)(height * this.x);
/* 140 */     this.startY = (int)(height * this.y);
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(EPHYSICS.Solid e) {
/* 146 */     setHeight((int)e.getHeight());
/* 147 */     setDistance2Ground(e.getZ());
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderSprite(int x1, int x2, int y1, int y2, TextureCoords texture) {
/* 152 */     x1 += this.startX;
/* 153 */     x2 += this.startX;
/* 154 */     y1 += this.startY;
/* 155 */     y2 += this.startY;
/*     */ 
/*     */ 
/*     */     
/* 159 */     double j = 0.0D;
/* 160 */     if (this.startX + this.startY == 0)
/* 161 */       j++; 
/* 162 */     CORE.renderer().shadowDepthSet(this.streangth);
/* 163 */     while (j <= this.iterations) {
/* 164 */       int ix = (int)(this.dx * j);
/* 165 */       int iy = (int)(this.dy * j);
/*     */       
/* 167 */       CORE.renderer().renderShadow(x1 + ix, x2 + ix, y1 + iy, y2 + iy, texture, (byte)(int)(j * this.dD));
/* 168 */       j++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ShadowBatch setSoft() {
/* 174 */     this.prev = this.streangth;
/* 175 */     this.streangth = Byte.MAX_VALUE;
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShadowBatch setHard() {
/* 181 */     this.prev = this.streangth;
/* 182 */     this.streangth = -1;
/* 183 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShadowBatch setDistance2GroundUI(double height) {
/* 188 */     this.startX = (int)height;
/* 189 */     this.startY = (int)height;
/* 190 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShadowBatch setPrev() {
/* 195 */     this.streangth = this.prev;
/* 196 */     CORE.renderer().shadowDepthSet(this.streangth);
/* 197 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\rendering\ShadowBatch$Real.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */