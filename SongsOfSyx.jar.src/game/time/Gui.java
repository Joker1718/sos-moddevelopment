/*    */ package game.time;
/*    */ 
/*    */ import init.settings.S;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.light.AmbientLight;
/*    */ import snake2d.util.light.Fire;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class Gui
/*    */   extends AmbientLight {
/*    */   private boolean night;
/*    */   private Fire one;
/*    */   
/*    */   Gui() {
/* 16 */     this.one = new Fire(0.1D);
/* 17 */     this.one.setRadius(300);
/*    */     
/* 19 */     this.one.setFalloff(1.0F);
/* 20 */     this.one.setFlickerFactor(1.0F);
/*    */     
/* 22 */     setDir(220.0D);
/* 23 */     setTilt(35.0D);
/* 24 */     g(1.2999999523162842D);
/* 25 */     b(1.2999999523162842D);
/* 26 */     r(1.2999999523162842D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void update(Light s, double ds) {
/* 32 */     if ((S.get()).uilightCycle.get() == 1 && TIME.light().nightIs()) {
/*    */       
/* 34 */       this.night = true;
/* 35 */       this.one.setIntensity((float)(0.5D * s.partOfCircular()));
/* 36 */       this.one.flicker(0.015625F);
/* 37 */       r(1.0D + 0.3D * (1.0D - s.partOfCircular()));
/* 38 */       g(1.0D + 0.3D * (1.0D - s.partOfCircular()));
/* 39 */       b(1.2D + 0.1D * (1.0D - s.partOfCircular()));
/*    */     } else {
/*    */       
/* 42 */       this.night = false;
/* 43 */       g(1.2999999523162842D);
/* 44 */       b(1.2999999523162842D);
/* 45 */       r(1.2999999523162842D);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void register(float ds, RECTANGLE rec) {
/* 51 */     if (this.night) {
/*    */       
/* 53 */       this.one.set((COORDINATE)VIEW.mouse());
/* 54 */       this.one.register();
/*    */     } 
/*    */ 
/*    */     
/* 58 */     register(rec);
/*    */   }
/*    */ 
/*    */   
/*    */   public void register(float ds, int x1, int x2, int y1, int y2) {
/* 63 */     if (this.night) {
/*    */       
/* 65 */       this.one.set((COORDINATE)VIEW.mouse());
/* 66 */       this.one.register();
/*    */     } 
/*    */ 
/*    */     
/* 70 */     register(x1, x2, y1, y2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */