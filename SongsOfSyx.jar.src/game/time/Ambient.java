/*    */ package game.time;
/*    */ 
/*    */ import init.settings.S;
/*    */ import snake2d.CORE;
/*    */ import snake2d.util.color.RGB;
/*    */ import snake2d.util.light.AmbientLight;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Ambient
/*    */ {
/* 12 */   private final RGB.RGBImp moon2 = (new RGB.RGBImp()).r(0.65D).g(0.65D).b(1.7D);
/* 13 */   private final RGB.RGBImp dawn = (new RGB.RGBImp()).r(1.2D).g(1.0D).b(0.8D);
/* 14 */   private final RGB.RGBImp dusk = (new RGB.RGBImp()).r(1.6D).g(0.8D).b(0.6D);
/* 15 */   private final RGB.RGBImp day = (new RGB.RGBImp()).r(1.0D).g(1.0D).b(1.0D);
/*    */   
/* 17 */   private final RGB.RGBImp w = new RGB.RGBImp();
/* 18 */   private final RGB.RGBImp moon = new RGB.RGBImp();
/*    */   
/* 20 */   private final AmbientLight work = new AmbientLight();
/* 21 */   private final AmbientLight work2 = new AmbientLight();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void apply(int x1, int x2, int y1, int y2, RGB tint) {
/* 28 */     double t = (TIME.light()).shadow.dtilt();
/*    */     
/* 30 */     this.moon.copy((RGB)this.moon2);
/*    */ 
/*    */ 
/*    */     
/* 34 */     double dd = 0.1D;
/* 35 */     if (t < dd) {
/* 36 */       double d = t / dd;
/* 37 */       if ((TIME.light()).shadow.rising) {
/* 38 */         if ((TIME.light()).shadow.isNight) {
/* 39 */           this.w.interpolate((RGB)this.dusk, (RGB)this.moon, d);
/*    */         } else {
/* 41 */           this.w.interpolate((RGB)this.dawn, (RGB)this.day, d);
/*    */         } 
/*    */       } else {
/* 44 */         d = 1.0D - d;
/* 45 */         if ((TIME.light()).shadow.isNight) {
/* 46 */           this.w.interpolate((RGB)this.moon, (RGB)this.dawn, d);
/*    */         } else {
/* 48 */           this.w.interpolate((RGB)this.day, (RGB)this.dusk, d);
/*    */         }
/*    */       
/*    */       } 
/* 52 */     } else if ((TIME.light()).shadow.isNight) {
/* 53 */       this.w.copy((RGB)this.moon);
/*    */     } else {
/* 55 */       this.w.copy((RGB)this.day);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 60 */     double tilt = (TIME.light()).shadow.dtilt();
/* 61 */     double dir = (TIME.light()).shadow.dir();
/* 62 */     if ((S.get()).lightCycle.get() == 0) {
/* 63 */       this.w.copy((RGB)this.day);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 68 */     double strength = 0.55D + 0.75D * Math.pow(1.0D - tilt, 2.0D);
/* 69 */     strength *= 4.5D;
/* 70 */     strength *= 0.95D + (S.get()).brightness.getD() * 0.5D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 76 */     double reflect = 0.2D + 0.3D * Math.sqrt(tilt);
/* 77 */     double oo = (1.0D - reflect) / 2.0D;
/*    */     
/* 79 */     this.work.setTilt((TIME.light()).shadow.tilt()).setDir(dir).copy((RGB)this.w);
/* 80 */     this.work.shade(strength);
/* 81 */     this.work.multiply(tint);
/*    */     
/* 83 */     CORE.renderer().lightDepthSet((byte)0);
/* 84 */     this.work2.Set(this.work, oo);
/* 85 */     this.work2.register(x1, x2, y1, y2);
/*    */     
/* 87 */     CORE.renderer().lightDepthSet(127);
/* 88 */     this.work2.Set(this.work, oo);
/* 89 */     this.work2.register(x1, x2, y1, y2);
/*    */     
/* 91 */     double dTilt = (TIME.light()).shadow.tilt();
/*    */     
/* 93 */     CORE.renderer().shadeLight(false);
/* 94 */     this.work.setTilt(90.0D - dTilt).setDir(dir + 180.0D).copy((RGB)this.w);
/* 95 */     this.work2.Set(this.work, reflect);
/* 96 */     this.work2.register(x1, x2, y1, y2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Ambient.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */