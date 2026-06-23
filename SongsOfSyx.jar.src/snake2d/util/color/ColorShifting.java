/*    */ package snake2d.util.color;
/*    */ 
/*    */ import snake2d.CORE;
/*    */ 
/*    */ public class ColorShifting
/*    */   extends ColorImp {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private int dRed;
/*    */   private int dGreen;
/*    */   private int dBlue;
/*    */   private int r;
/*    */   private int g;
/*    */   private int b;
/* 14 */   private float speed = 0.5F;
/* 15 */   private double old = -1.0D;
/*    */   
/*    */   public ColorShifting(COLOR from, COLOR to) {
/* 18 */     super(0, 0, 0);
/* 19 */     this.r = Byte.toUnsignedInt(from.red());
/* 20 */     this.g = Byte.toUnsignedInt(from.green());
/* 21 */     this.b = Byte.toUnsignedInt(from.blue());
/*    */ 
/*    */     
/* 24 */     this.dRed = Byte.toUnsignedInt(to.red()) - this.r;
/* 25 */     this.dGreen = Byte.toUnsignedInt(to.green()) - this.g;
/* 26 */     this.dBlue = Byte.toUnsignedInt(to.blue()) - this.b;
/*    */   }
/*    */   
/*    */   private void update() {
/* 30 */     if (this.old != CORE.getUpdateInfo().getSecondsSinceFirstUpdate()) {
/* 31 */       this.old = CORE.getUpdateInfo().getSecondsSinceFirstUpdate();
/* 32 */       double timer = CORE.getUpdateInfo().getSecondsSinceFirstUpdate() * this.speed;
/*    */       
/* 34 */       double d = timer - (int)timer;
/*    */       
/* 36 */       if (d > 0.5D) {
/* 37 */         timer = 1.0D - (d - 0.5D) * 2.0D;
/*    */       } else {
/* 39 */         timer = d * 2.0D;
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 44 */       setRed((int)(this.r + timer * this.dRed));
/* 45 */       setGreen((int)(this.g + timer * this.dGreen));
/* 46 */       setBlue((int)(this.b + timer * this.dBlue));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void bind() {
/* 53 */     update();
/* 54 */     super.bind();
/*    */   }
/*    */ 
/*    */   
/*    */   public byte red() {
/* 59 */     update();
/* 60 */     return super.red();
/*    */   }
/*    */   
/*    */   public ColorShifting setSpeed(double speed) {
/* 64 */     this.speed = (float)speed;
/* 65 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\color\ColorShifting.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */