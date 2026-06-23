/*     */ package util.spritecomposer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ComposerSources.House
/*     */ {
/*     */   null(ComposerSources.Body $anonymous0) {
/*  77 */     super($anonymous0);
/*     */   }
/*     */   void setSize(int size) {
/*  80 */     this.size = size;
/*  81 */     int m = 4;
/*  82 */     int m2 = 2;
/*     */     
/*  84 */     this.offX[0] = 0;
/*  85 */     this.offX[1] = 0 * (size + m2);
/*  86 */     this.offX[2] = 0 * (size + m2);
/*  87 */     this.offX[3] = 0 * (size + m2);
/*  88 */     this.offX[4] = 4 * (size + m2);
/*  89 */     this.offX[5] = 3 * (size + m2);
/*  90 */     this.offX[6] = 2 * (size + m2);
/*  91 */     this.offX[7] = 1 * (size + m2);
/*  92 */     this.offX[8] = 4 * (size + m2);
/*  93 */     this.offX[9] = 2 * (size + m2);
/*  94 */     this.offX[10] = 1 * (size + m2);
/*  95 */     this.offX[11] = 3 * (size + m2);
/*  96 */     this.offX[12] = 4 * (size + m2);
/*  97 */     this.offX[13] = 1 * (size + m2);
/*  98 */     this.offX[14] = 3 * (size + m2);
/*  99 */     this.offX[15] = 2 * (size + m2);
/*     */     
/* 101 */     this.offY[0] = 0;
/* 102 */     this.offY[1] = 1 * (size + m);
/* 103 */     this.offY[2] = 2 * (size + m);
/* 104 */     this.offY[3] = 0 * (size + m);
/* 105 */     this.offY[4] = 2 * (size + m);
/* 106 */     this.offY[5] = 1 * (size + m);
/* 107 */     this.offY[6] = 1 * (size + m);
/* 108 */     this.offY[7] = 2 * (size + m);
/* 109 */     this.offY[8] = 1 * (size + m);
/* 110 */     this.offY[9] = 0 * (size + m);
/* 111 */     this.offY[10] = 1 * (size + m);
/* 112 */     this.offY[11] = 0 * (size + m);
/* 113 */     this.offY[12] = 0 * (size + m);
/* 114 */     this.offY[13] = 0 * (size + m);
/* 115 */     this.offY[14] = 2 * (size + m);
/* 116 */     this.offY[15] = 2 * (size + m);
/* 117 */     this.width = m * 2 + m2 * 4 + 5 * size;
/* 118 */     this.height = m * 4 + 3 * size;
/* 119 */     this.body.init(0, 0, this.width, this.height, 1, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerSources$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */