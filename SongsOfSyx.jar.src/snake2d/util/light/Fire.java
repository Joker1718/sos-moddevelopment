/*    */ package snake2d.util.light;
/*    */ 
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ public class Fire
/*    */   extends PointLight {
/*    */   private static final long serialVersionUID = 1L;
/*  8 */   private float offsetX = 0.0F;
/*  9 */   private float offsetY = 0.0F;
/* 10 */   private float offsetHeight = 0.0F;
/* 11 */   private float intensityOffset = 0.0F;
/* 12 */   private float timer = 0.05F;
/*    */   
/*    */   private float tmpRed;
/*    */   
/*    */   private float tmpGreen;
/*    */   private float tmpBlue;
/*    */   private float flickerFactor;
/*    */   
/*    */   public Fire(double intensity) {
/* 21 */     super(1.0D * intensity, 0.699999988079071D * intensity, 0.30000001192092896D * intensity);
/* 22 */     setZ(50);
/* 23 */     setRadius(100);
/* 24 */     this.flickerFactor = 20.0F;
/* 25 */     this.timer = -1.0F;
/* 26 */     flicker(0.0F);
/*    */   }
/*    */   
/*    */   public void flicker(float ds) {
/* 30 */     this.timer -= ds;
/* 31 */     if (this.timer > 0.0F) {
/*    */       return;
/*    */     }
/* 34 */     this.offsetX = -this.flickerFactor + RND.rFloat((2.0F * this.flickerFactor));
/* 35 */     this.offsetY = -this.flickerFactor + RND.rFloat((2.0F * this.flickerFactor));
/* 36 */     this.offsetHeight = RND.rFloat((this.flickerFactor / 4.0F));
/* 37 */     this.intensityOffset = (float)(1.0D + 0.2D * RND.rSign() * RND.rExpo());
/* 38 */     this.tmpRed = super.getRed() * this.intensityOffset;
/* 39 */     this.tmpGreen = super.getGreen() * this.intensityOffset;
/* 40 */     this.tmpBlue = super.getBlue() * this.intensityOffset;
/*    */     
/* 42 */     this.timer = 0.025F + RND.rFloat(0.05000000074505806D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float cx() {
/* 48 */     return x() + this.offsetX;
/*    */   }
/*    */ 
/*    */   
/*    */   public float cy() {
/* 53 */     return y() + this.offsetY;
/*    */   }
/*    */ 
/*    */   
/*    */   public float cz() {
/* 58 */     return super.cz() + this.offsetHeight;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getRed() {
/* 63 */     return this.tmpRed;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getGreen() {
/* 68 */     return this.tmpGreen;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getBlue() {
/* 73 */     return this.tmpBlue;
/*    */   }
/*    */   
/*    */   public float getFlickerFactor() {
/* 77 */     return this.flickerFactor;
/*    */   }
/*    */   
/*    */   public void setFlickerFactor(float flickerFactor) {
/* 81 */     this.flickerFactor = flickerFactor;
/*    */   }
/*    */   
/*    */   public void setIntensity(double d) {
/* 85 */     setRed(1.0D * d);
/* 86 */     setGreen(0.699999988079071D * d);
/* 87 */     setBlue(0.30000001192092896D * d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\light\Fire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */