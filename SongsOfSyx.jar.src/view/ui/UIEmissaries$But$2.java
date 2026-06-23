/*     */ package view.ui;
/*     */ 
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements INT.INTE
/*     */ {
/*     */   public int min() {
/* 158 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 163 */     if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).treg) {
/* 164 */       return (UIEmissaries.But.this.d()).treg.max((UIEmissaries.But.this.d()).reg);
/*     */     }
/* 166 */     if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).troy) {
/* 167 */       return (UIEmissaries.But.this.d()).troy.max((UIEmissaries.But.this.d()).roy);
/*     */     }
/* 169 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/* 174 */     if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).treg) {
/* 175 */       return (UIEmissaries.But.this.d()).treg.get((UIEmissaries.But.this.d()).reg);
/*     */     }
/* 177 */     if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).troy) {
/* 178 */       return (UIEmissaries.But.this.d()).troy.get((UIEmissaries.But.this.d()).roy);
/*     */     }
/* 180 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int t) {
/* 185 */     if (t == 0) {
/* 186 */       UIEmissaries.But.this.sl.reset();
/*     */     }
/* 188 */     if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).treg) {
/* 189 */       (UIEmissaries.But.this.d()).treg.set((UIEmissaries.But.this.d()).reg, t);
/*     */     }
/* 191 */     else if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).troy) {
/* 192 */       (UIEmissaries.But.this.d()).troy.set((UIEmissaries.But.this.d()).roy, t);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\UIEmissaries$But$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */