/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Minimap
/*     */ {
/* 220 */   private final int w = 64;
/* 221 */   private final int h = 32;
/* 222 */   private byte[][] values = new byte[32][64];
/*     */   
/*     */   Minimap() {
/* 225 */     for (int i = 0; i < 32; i += 4) {
/* 226 */       int sx = ((i & 0x4) != 0) ? 8 : 0;
/* 227 */       drawWave(sx, i, (byte)-50, 8);
/* 228 */       drawWave(sx, i + 1, (byte)40, 8);
/* 229 */       drawWave(sx, i + 2, (byte)30, 8);
/* 230 */       drawWave(sx, i + 3, (byte)20, 8);
/* 231 */       drawWave(sx, i + 4, (byte)10, 8);
/* 232 */       drawWave(sx, i + 5, (byte)5, 8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawWave(int sx, int sy, byte v, int period) {
/* 242 */     for (int i = 0; i < 64; i++) {
/* 243 */       int x = i + sx & 0x3F;
/* 244 */       int y = i & period - 1;
/* 245 */       if ((i & period) != 0)
/* 246 */         y = period - y; 
/* 247 */       y += sy;
/* 248 */       y &= 0x1F;
/* 249 */       this.values[y][x] = v;
/*     */     } 
/*     */   }
/*     */   
/*     */   COLOR miniCPimp(ColorImp c, int tx, int ty, boolean northern, boolean southern) {
/* 254 */     int x = tx & 0x3F;
/* 255 */     int y = ty & 0x1F;
/* 256 */     if (this.values[y][x] != 0) {
/* 257 */       double v = 1.0D - 0.5D * this.values[y][x] / 128.0D;
/* 258 */       c.shadeSelf(v);
/*     */     } 
/*     */     
/* 261 */     if (northern != southern)
/* 262 */     { if (northern) {
/* 263 */         c.shadeSelf(1.5D);
/*     */       } else {
/* 265 */         c.shadeSelf(0.75D);
/*     */       }  }
/* 267 */     else { for (DIR d : DIR.ORTHO) {
/* 268 */         if ((SETT.TERRAIN()).CAVE.is(tx, ty, d)) {
/* 269 */           c.interpolate((COLOR)c, (SETT.TERRAIN()).CAVE.miniC, 0.5D);
/*     */           
/*     */           break;
/*     */         } 
/*     */       }  }
/*     */     
/* 275 */     return (COLOR)c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$Minimap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */