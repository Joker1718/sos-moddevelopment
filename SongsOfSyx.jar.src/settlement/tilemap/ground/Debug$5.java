/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 101 */   int i = 0;
/*     */ 
/*     */   
/*     */   public void exe() {
/* 105 */     this.i++;
/* 106 */     this.i %= CLIMATES.ALL().size();
/* 107 */     COLOR wet = ((CLIMATE)CLIMATES.ALL().get(this.i)).colorGroundWet;
/* 108 */     COLOR dry = ((CLIMATE)CLIMATES.ALL().get(this.i)).colorGroundDry;
/* 109 */     LOG.ln(Integer.valueOf(this.i));
/* 110 */     g.setColors(dry, wet, 0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Debug$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */