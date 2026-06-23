/*    */ package snake2d.util.color;
/*    */ 
/*    */ import snake2d.CORE;
/*    */ 
/*    */ public class OpacityImp
/*    */   implements OPACITY
/*    */ {
/*  8 */   public static final OpacityImp TMP = new OpacityImp(0);
/*    */   
/*    */   private byte opacity;
/*    */   
/*    */   public OpacityImp(int op) {
/* 13 */     set(op);
/*    */   }
/*    */   
/*    */   public OpacityImp(OPACITY o) {
/* 17 */     this.opacity = o.get();
/*    */   }
/*    */   
/*    */   public void set(int op) {
/* 21 */     if (op < 0) {
/* 22 */       op = 0;
/* 23 */     } else if (op > 255) {
/* 24 */       op = 255;
/* 25 */     }  this.opacity = (byte)op;
/*    */   }
/*    */   
/*    */   public void set(double op) {
/* 29 */     set((int)(op * 255.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(OPACITY o) {
/* 34 */     this.opacity = o.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public byte get() {
/* 39 */     return this.opacity;
/*    */   }
/*    */   
/*    */   public void increase(float factor) {
/* 43 */     set((int)(this.opacity * factor));
/*    */   }
/*    */   
/*    */   public void increase(int amount) {
/* 47 */     set(this.opacity + amount);
/*    */   }
/*    */   
/*    */   public static void unBind() {
/* 51 */     CORE.renderer().setNormalOpacity();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     return String.valueOf(getClass().getName()) + " " + this.opacity;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\color\OpacityImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */