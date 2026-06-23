/*     */ package util.updating;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import snake2d.LOG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class IUpdaterSer
/*     */   implements Serializable
/*     */ {
/*     */   private final int amount;
/*     */   private int i;
/*     */   private final double secondsBetween;
/*     */   private final double tilesPerSecond;
/*  82 */   private double acc = 0.0D;
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public IUpdaterSer(int amount, double secondsBetween) {
/*  86 */     this.amount = amount;
/*  87 */     this.secondsBetween = secondsBetween;
/*  88 */     this.tilesPerSecond = amount / secondsBetween;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/*  93 */     this.acc += ds * this.tilesPerSecond;
/*     */     
/*  95 */     int a = (int)this.acc;
/*  96 */     this.acc -= a;
/*  97 */     while (a > 0) {
/*  98 */       a--;
/*  99 */       update(this.i, this.secondsBetween);
/* 100 */       this.i++;
/* 101 */       if (this.i >= this.amount)
/* 102 */         this.i = 0; 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract void update(int paramInt, double paramDouble);
/*     */   
/*     */   public void debug() {
/* 109 */     LOG.ln();
/* 110 */     LOG.ln(Integer.valueOf(this.amount));
/* 111 */     LOG.ln(Double.valueOf(this.secondsBetween));
/* 112 */     LOG.ln(Double.valueOf(this.tilesPerSecond));
/* 113 */     LOG.ln(Double.valueOf(this.acc));
/* 114 */     LOG.ln(Integer.valueOf(this.i));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\uti\\updating\IUpdater$IUpdaterSer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */