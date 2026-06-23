/*    */ package snake2d.util.color;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface RGB
/*    */ {
/* 12 */   public static final RGB WHITE = (new RGBImp()).set(1.0D, 1.0D, 1.0D);
/*    */   double r();
/*    */   
/*    */   double g();
/*    */   
/*    */   double b();
/*    */   
/*    */   public static class RGBImp implements RGB { private double red;
/*    */     
/*    */     public double r() {
/* 22 */       return this.red;
/*    */     }
/*    */     private double green; private double blue;
/*    */     
/*    */     public double g() {
/* 27 */       return this.green;
/*    */     }
/*    */ 
/*    */     
/*    */     public double b() {
/* 32 */       return this.blue;
/*    */     }
/*    */     
/*    */     public RGBImp r(double r) {
/* 36 */       this.red = r;
/* 37 */       return this;
/*    */     }
/*    */ 
/*    */     
/*    */     public RGBImp g(double g) {
/* 42 */       this.green = g;
/* 43 */       return this;
/*    */     }
/*    */     
/*    */     public RGBImp b(double b) {
/* 47 */       this.blue = b;
/* 48 */       return this;
/*    */     }
/*    */     
/*    */     public RGBImp set(double r, double g, double b) {
/* 52 */       return r(r).g(g).b(b);
/*    */     }
/*    */     
/*    */     public RGBImp shade(double shade) {
/* 56 */       this.red *= shade;
/* 57 */       this.green *= shade;
/* 58 */       this.blue *= shade;
/* 59 */       return this;
/*    */     }
/*    */     
/*    */     public RGBImp copy(RGB other) {
/* 63 */       this.red = other.r();
/* 64 */       this.green = other.g();
/* 65 */       this.blue = other.b();
/* 66 */       return this;
/*    */     }
/*    */     
/*    */     public RGBImp interpolate(RGB a, RGB b, double part) {
/* 70 */       r(a.r() + (b.r() - a.r()) * part);
/* 71 */       g(a.g() + (b.g() - a.g()) * part);
/* 72 */       b(a.b() + (b.b() - a.b()) * part);
/* 73 */       return this;
/*    */     }
/*    */     
/*    */     public RGBImp multiply(RGB currentDay) {
/* 77 */       r(r() * currentDay.r());
/* 78 */       g(g() * currentDay.g());
/* 79 */       b(b() * currentDay.b());
/* 80 */       return this;
/*    */     }
/*    */     
/*    */     public RGBImp multiply(RGB currentDay, double part) {
/* 84 */       r(r() * currentDay.r());
/* 85 */       g(g() * currentDay.g());
/* 86 */       b(b() * currentDay.b());
/* 87 */       return this;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\color\RGB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */