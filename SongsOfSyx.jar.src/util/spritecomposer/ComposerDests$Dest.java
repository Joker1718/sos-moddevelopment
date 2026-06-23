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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Dest
/*     */ {
/*     */   abstract int x1();
/*     */   
/*     */   abstract int y1();
/*     */   
/*     */   abstract int width();
/*     */   
/*     */   abstract int height();
/*     */   
/*     */   public abstract void jump(int paramInt);
/*     */   
/*     */   public void diffuseSet(int x, int y, int r, int g, int b, int a) {
/* 156 */     int res = r;
/* 157 */     res <<= 8;
/* 158 */     res |= g;
/* 159 */     res <<= 8;
/* 160 */     res |= b;
/* 161 */     res <<= 8;
/* 162 */     res |= a;
/* 163 */     diffuseSet(x, y, res);
/*     */   }
/*     */   
/*     */   public void normalSet(int x, int y, int r, int g, int b, int a) {
/* 167 */     int res = r;
/* 168 */     res <<= 8;
/* 169 */     res |= g;
/* 170 */     res <<= 8;
/* 171 */     res |= b;
/* 172 */     res <<= 8;
/* 173 */     res |= a;
/* 174 */     normalSet(x, y, res);
/*     */   }
/*     */   
/*     */   public abstract void diffuseSet(int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   public abstract int diffuseGet(int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract void normalSet(int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   public abstract int normalGet(int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract int destWidth();
/*     */   
/*     */   public abstract void dispose();
/*     */   
/*     */   abstract int size();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerDests$Dest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */