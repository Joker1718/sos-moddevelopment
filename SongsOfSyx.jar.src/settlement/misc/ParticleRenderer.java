/*    */ package settlement.misc;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.CORE;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.DEG;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ 
/*    */ public class ParticleRenderer
/*    */   extends SETT.SettResource
/*    */ {
/*    */   private static final int MAX = 64;
/*    */   private static final float MAG = 64.0F;
/*    */   private static final float vel = 120.0F;
/*    */   private static final double iV = 7.8125E-4D;
/* 18 */   private final float[] mags = new float[64];
/* 19 */   private final float[] dxs = new float[64];
/* 20 */   private final float[] dys = new float[64];
/* 21 */   private final COLOR color = (COLOR)new ColorImp(18, 14, 5);
/*    */   
/*    */   private boolean touched = false;
/*    */   
/*    */   public ParticleRenderer() {
/* 26 */     super("PART", false);
/* 27 */     for (int i = 0; i < 64; i++) {
/* 28 */       this.mags[i] = RND.rFloat() * 64.0F;
/* 29 */       DEG.setRandom();
/* 30 */       this.dxs[i] = (float)DEG.getCurrentX();
/* 31 */       this.dys[i] = (float)DEG.getCurrentY();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDust(int x, int y, double magnitude) {
/* 38 */     magnitude *= 7.8125E-4D;
/* 39 */     int m = (int)(magnitude * 64.0D);
/*    */     
/* 41 */     if (m > 64)
/* 42 */       m = 64; 
/* 43 */     if (m <= 0)
/*    */       return; 
/* 45 */     this.color.bind();
/* 46 */     for (int i = 0; i < m; i++) {
/* 47 */       int dx = (int)(x + this.dxs[i] * this.mags[i]);
/* 48 */       int dy = (int)(y + this.dys[i] * this.mags[i]);
/* 49 */       CORE.renderer().renderParticle(dx, dy);
/*    */     } 
/* 51 */     COLOR.unbind();
/* 52 */     this.touched = true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void postRender(float ds) {
/* 57 */     if (!this.touched)
/*    */       return; 
/* 59 */     this.touched = false;
/* 60 */     for (int i = 0; i < 64; i++) {
/* 61 */       this.mags[i] = this.mags[i] + ds * 120.0F;
/* 62 */       if (this.mags[i] > 64.0F)
/* 63 */         this.mags[i] = this.mags[i] - 64.0F; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\ParticleRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */