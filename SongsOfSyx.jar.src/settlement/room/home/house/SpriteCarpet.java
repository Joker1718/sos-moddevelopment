/*    */ package settlement.room.home.house;
/*    */ 
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ class SpriteCarpet
/*    */ {
/*  8 */   private final int[][][][] data = new int[4][4][][];
/*    */ 
/*    */   
/*    */   SpriteCarpet() {
/* 12 */     this.data[0] = make(
/* 13 */         new int[][] {
/* 14 */           new int[3], {
/* 15 */             0, 16, 16
/* 16 */           }, { 0, 16, 16 }
/*    */         });
/*    */ 
/*    */     
/* 20 */     this.data[1] = make(
/* 21 */         new int[][] {
/* 22 */           new int[3], {
/* 23 */             0, 16, 16
/* 24 */           }, { 0, 16, 16
/* 25 */           }, { 0, 16, 16
/* 26 */           }, new int[3]
/*    */         });
/*    */ 
/*    */     
/* 30 */     this.data[2] = make(
/* 31 */         new int[][] {
/* 32 */           new int[5], {
/* 33 */             0, 16, 16, 16, 16
/* 34 */           }, { 0, 16, 16, 16, 16
/* 35 */           }, { 0, 16, 16, 16, 16
/* 36 */           }, { 0, 16, 16, 16, 16
/* 37 */           }, new int[5]
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private int[][][] make(int[][] o) {
/* 45 */     int[][][] r = new int[4][][];
/*    */     
/* 47 */     for (int i = 0; i < 4; i++) {
/* 48 */       r[i] = o;
/* 49 */       o = rotate(o);
/*    */     } 
/*    */     byte b;
/*    */     int j, arrayOfInt1[][][];
/* 53 */     for (j = (arrayOfInt1 = r).length, b = 0; b < j; ) { int[][] is = arrayOfInt1[b];
/* 54 */       int oi = 0;
/* 55 */       int co = 0;
/* 56 */       for (int y = 0; y < is.length; y++) {
/* 57 */         for (int x = 0; x < (is[y]).length; x++) {
/* 58 */           if (is[y][x] != 0)
/*    */           {
/* 60 */             if (is[y][x] != oi) {
/* 61 */               co = 0;
/* 62 */               oi = is[y][x];
/* 63 */               is[y][x] = is[y][x] | co;
/* 64 */               co++;
/*    */             } 
/*    */           }
/*    */         } 
/*    */       } 
/*    */       
/*    */       b++; }
/*    */     
/* 72 */     return r;
/*    */   }
/*    */   
/*    */   private int[][] rotate(int[][] l) {
/* 76 */     int M = l.length;
/* 77 */     int N = (l[0]).length;
/* 78 */     int[][] ret = new int[N][M];
/* 79 */     for (int r = 0; r < M; r++) {
/* 80 */       for (int c = 0; c < N; c++) {
/* 81 */         ret[c][M - 1 - r] = l[r][c];
/*    */       }
/*    */     } 
/* 84 */     return ret;
/*    */   }
/*    */   
/*    */   public int get(int rx, int ry, FurnisherItem it) {
/* 88 */     int[][] m = this.data[it.group().index()][it.rotation & 0x1];
/* 89 */     if (ry < 0 || ry >= m.length)
/* 90 */       return 0; 
/* 91 */     if (rx < 0 || rx >= (m[0]).length)
/* 92 */       return 0; 
/* 93 */     return m[ry][rx] >> 4 & 0xF;
/*    */   }
/*    */   
/*    */   public int get(int rx, int ry, DIR d, FurnisherItem it) {
/* 97 */     return get(rx + d.x(), ry + d.y(), it);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\SpriteCarpet.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */