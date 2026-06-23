/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements ACTION
/*     */ {
/*  81 */   final SPath p = new SPath();
/*     */ 
/*     */   
/*     */   public void exe() {
/*  85 */     int am = 1000;
/*  86 */     int[] sx = Alloc.ii(1000);
/*  87 */     int[] sy = Alloc.ii(1000);
/*     */     
/*  89 */     for (int i = 0; i < 1000; i++) {
/*  90 */       sx[i] = RND.rInt(SETT.TWIDTH);
/*  91 */       sy[i] = RND.rInt(SETT.THEIGHT);
/*     */     } 
/*     */ 
/*     */     
/*  95 */     int[] dx = Alloc.ii(1000);
/*  96 */     int[] dy = Alloc.ii(1000);
/*  97 */     for (int k = 0; k < 1000; k++) {
/*  98 */       dx[k] = RND.rInt(SETT.TWIDTH);
/*  99 */       dy[k] = RND.rInt(SETT.THEIGHT);
/*     */     } 
/* 101 */     long l2 = System.currentTimeMillis();
/* 102 */     int i1 = 0;
/* 103 */     l2 = System.currentTimeMillis();
/* 104 */     i1 = 0;
/* 105 */     for (int i3 = 0; i3 < 1000; i3++) {
/* 106 */       if (find(sx[i3], sy[i3], dx[i3], dy[i3], false))
/* 107 */         i1++; 
/*     */     } 
/* 109 */     double d3 = i1;
/* 110 */     d3 /= (System.currentTimeMillis() - l2);
/* 111 */     d3 *= 1000.0D;
/* 112 */     LOG.ln("long paths: " + d3 + "p/s, paths: " + i1);
/*     */ 
/*     */ 
/*     */     
/* 116 */     dx = Alloc.ii(1000);
/* 117 */     dy = Alloc.ii(1000);
/* 118 */     for (int j = 0; j < 1000; j++) {
/* 119 */       dx[j] = CLAMP.i(sx[j] + RND.rInt0(100), 0, SETT.TWIDTH);
/* 120 */       dy[j] = CLAMP.i(sy[j] + RND.rInt0(100), 0, SETT.TWIDTH);
/*     */     } 
/* 122 */     long l1 = System.currentTimeMillis();
/* 123 */     i1 = 0;
/* 124 */     l1 = System.currentTimeMillis();
/* 125 */     i1 = 0;
/* 126 */     for (int i2 = 0; i2 < 1000; i2++) {
/* 127 */       if (find(sx[i2], sy[i2], dx[i2], dy[i2], false))
/* 128 */         i1++; 
/*     */     } 
/* 130 */     double d2 = i1;
/* 131 */     d2 /= (System.currentTimeMillis() - l1);
/* 132 */     d2 *= 1000.0D;
/* 133 */     LOG.ln("short paths: " + d2 + "p/s, paths: " + i1);
/*     */ 
/*     */ 
/*     */     
/* 137 */     long now = System.currentTimeMillis();
/* 138 */     int a = 0;
/*     */     
/* 140 */     now = System.currentTimeMillis();
/* 141 */     a = 0;
/* 142 */     for (int n = 0; n < 1000; n++) {
/* 143 */       if (findR(sx[n], sy[n], false))
/* 144 */         a++; 
/*     */     } 
/* 146 */     double d1 = a;
/* 147 */     d1 /= (System.currentTimeMillis() - now);
/* 148 */     d1 *= 1000.0D;
/* 149 */     LOG.ln("res closest: " + d1 + "p/s, paths: " + a);
/*     */ 
/*     */ 
/*     */     
/* 153 */     now = System.currentTimeMillis();
/* 154 */     a = 0;
/*     */     
/* 156 */     now = System.currentTimeMillis();
/* 157 */     a = 0;
/* 158 */     for (int m = 0; m < 1000; m++) {
/* 159 */       if (findJ(sx[m], sy[m]))
/* 160 */         a++; 
/*     */     } 
/* 162 */     double d = a;
/* 163 */     d /= (System.currentTimeMillis() - now);
/* 164 */     d *= 1000.0D;
/* 165 */     LOG.ln("job: " + d + "p/s, paths: " + a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean find(int startX, int startY, int destX, int destY, boolean full) {
/* 174 */     if (!this.p.request(startX, startY, destX, destY, full)) {
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     return forward();
/*     */   }
/*     */   private boolean forward() {
/*     */     do {
/*     */     
/* 183 */     } while (!this.p.isDest() && this.p.isSuccessful() && this.p.setNext());
/*     */ 
/*     */     
/* 186 */     return this.p.isSuccessful();
/*     */   }
/*     */   
/*     */   private boolean findR(int startX, int startY, boolean full) {
/* 190 */     RESOURCE res = (SETT.PATH()).finders.resource.scattered.reserve(startX, startY, RBIT.ALL, this.p, 250);
/* 191 */     if (res == null) {
/* 192 */       return false;
/*     */     }
/*     */     
/* 195 */     (SETT.PATH()).finders.resource.unreserve(res, this.p.destX(), this.p.destY(), 1);
/*     */     
/* 197 */     return forward();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean findJ(int startX, int startY) {
/* 202 */     if ((SETT.PATH()).finders.job.find(startX, startY, this.p, true) != null) {
/* 203 */       return forward();
/*     */     }
/* 205 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\Tests$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */