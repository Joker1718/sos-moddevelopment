/*     */ package util.updating;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ public abstract class IUpdater
/*     */   implements SAVABLE
/*     */ {
/*     */   private final int amount;
/*     */   private int i;
/*     */   private final double secondsBetween;
/*     */   private final double tilesPerSecond;
/*  17 */   private double acc = 0.0D;
/*     */ 
/*     */   
/*     */   public IUpdater(int amount, double secondsBetween) {
/*  21 */     this.amount = amount;
/*  22 */     this.secondsBetween = secondsBetween;
/*  23 */     this.tilesPerSecond = amount / secondsBetween;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/*  28 */     this.acc += ds * this.tilesPerSecond;
/*     */     
/*  30 */     int a = (int)this.acc;
/*  31 */     this.acc -= a;
/*  32 */     while (a > 0) {
/*  33 */       a--;
/*  34 */       update(this.i, this.secondsBetween);
/*  35 */       this.i++;
/*  36 */       if (this.i >= this.amount)
/*  37 */         this.i = 0; 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void backup() {
/*  42 */     this.i--;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void update(int paramInt, double paramDouble);
/*     */   
/*     */   public void save(FilePutter file) {
/*  49 */     file.i(this.i);
/*  50 */     file.d(this.acc);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  55 */     this.i = file.i();
/*  56 */     this.i %= this.amount;
/*  57 */     this.acc = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  62 */     this.i = 0;
/*  63 */     this.acc = 0.0D;
/*     */   }
/*     */   
/*     */   public void debug() {
/*  67 */     LOG.ln();
/*  68 */     LOG.ln(Integer.valueOf(this.amount));
/*  69 */     LOG.ln(Double.valueOf(this.secondsBetween));
/*  70 */     LOG.ln(Double.valueOf(this.tilesPerSecond));
/*  71 */     LOG.ln(Double.valueOf(this.acc));
/*  72 */     LOG.ln(Integer.valueOf(this.i));
/*     */   }
/*     */   
/*     */   public static abstract class IUpdaterSer
/*     */     implements Serializable
/*     */   {
/*     */     private final int amount;
/*     */     private int i;
/*     */     private final double secondsBetween;
/*     */     private final double tilesPerSecond;
/*  82 */     private double acc = 0.0D;
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public IUpdaterSer(int amount, double secondsBetween) {
/*  86 */       this.amount = amount;
/*  87 */       this.secondsBetween = secondsBetween;
/*  88 */       this.tilesPerSecond = amount / secondsBetween;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(double ds) {
/*  93 */       this.acc += ds * this.tilesPerSecond;
/*     */       
/*  95 */       int a = (int)this.acc;
/*  96 */       this.acc -= a;
/*  97 */       while (a > 0) {
/*  98 */         a--;
/*  99 */         update(this.i, this.secondsBetween);
/* 100 */         this.i++;
/* 101 */         if (this.i >= this.amount)
/* 102 */           this.i = 0; 
/*     */       } 
/*     */     }
/*     */     
/*     */     protected abstract void update(int param1Int, double param1Double);
/*     */     
/*     */     public void debug() {
/* 109 */       LOG.ln();
/* 110 */       LOG.ln(Integer.valueOf(this.amount));
/* 111 */       LOG.ln(Double.valueOf(this.secondsBetween));
/* 112 */       LOG.ln(Double.valueOf(this.tilesPerSecond));
/* 113 */       LOG.ln(Double.valueOf(this.acc));
/* 114 */       LOG.ln(Integer.valueOf(this.i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\uti\\updating\IUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */