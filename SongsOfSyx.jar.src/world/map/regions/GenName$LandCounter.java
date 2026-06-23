/*     */ package world.map.regions;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class LandCounter
/*     */ {
/*     */   private final String[] names;
/* 136 */   private int nameI = 0;
/*     */   
/*     */   private double treshold;
/*     */   
/*     */   LandCounter(String[] names, double treshold) {
/* 141 */     for (int i = 0; i < names.length; i++) {
/* 142 */       String old = names[i];
/* 143 */       int k = RND.rInt(names.length);
/* 144 */       names[i] = names[k];
/* 145 */       names[k] = old;
/*     */     } 
/*     */     
/* 148 */     this.names = names;
/* 149 */     this.treshold = treshold;
/*     */   }
/*     */   private double value; int count;
/*     */   String getName() {
/* 153 */     int i = this.nameI;
/* 154 */     this.nameI++;
/* 155 */     if (this.nameI >= this.names.length)
/* 156 */       this.nameI = 0; 
/* 157 */     return this.names[i];
/*     */   }
/*     */   
/*     */   abstract boolean count(int paramInt1, int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenName$LandCounter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */