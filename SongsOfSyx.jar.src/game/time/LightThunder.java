/*    */ package game.time;
/*    */ 
/*    */ import snake2d.util.light.AmbientLight;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ public final class LightThunder
/*    */ {
/*  8 */   private final AmbientLight flash = new AmbientLight();
/*    */   
/*    */   private double flashI;
/*    */   private boolean flashIs;
/*    */   private static final float thunderTimer = 5.0F;
/*    */   private static final float thunderLength = 0.2F;
/* 14 */   private float timer1 = RND.rFloat() * 5.0F;
/* 15 */   private float timer2 = RND.rFloat() * 0.2F;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 23 */     this.flashIs = false;
/*    */     
/* 25 */     if (this.timer1 > 0.0F) {
/* 26 */       this.timer1 = (float)(this.timer1 - ds);
/*    */     
/*    */     }
/* 29 */     else if (this.timer2 > 0.0F) {
/* 30 */       this.timer2 = (float)(this.timer2 - ds);
/* 31 */       this.flashIs = true;
/*    */     }
/*    */     else {
/*    */       
/* 35 */       this.timer2 = RND.rFloat() * 0.2F;
/* 36 */       if (RND.rInt(4) == 0) {
/* 37 */         this.timer1 = RND.rFloat() * 5.0F;
/* 38 */         this.flash.setDir(RND.rInt(360));
/* 39 */         this.flash.setTilt((-10 + RND.rInt(20)));
/* 40 */         this.flashI = (RND.rFloat() * 5.0F);
/*    */       } else {
/*    */         
/* 43 */         this.flashI /= 1.5D;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void apply(int x1, int x2, int y1, int y2) {
/* 51 */     if (this.flashIs) {
/* 52 */       this.flash.r(this.flashI).g(this.flashI).b(this.flashI);
/* 53 */       this.flash.register(x1, x2, y1, y2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\LightThunder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */