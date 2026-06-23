/*    */ package snake2d.util.color;
/*    */ 
/*    */ import snake2d.CORE;
/*    */ 
/*    */ public class OpaPuls
/*    */   extends OpacityImp {
/*    */   private int base;
/*    */   private int delta;
/*    */   
/*    */   public OpaPuls(int base, int max) {
/* 11 */     super(base);
/* 12 */     this.base = base;
/* 13 */     this.delta = max - base;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void set(int op) {
/* 19 */     this.base = op;
/*    */   }
/*    */ 
/*    */   
/*    */   public void increase(float factor) {
/* 24 */     this.base = (int)(this.base * factor);
/*    */   }
/*    */ 
/*    */   
/*    */   public void increase(int amount) {
/* 29 */     this.base += amount;
/*    */   }
/*    */   
/*    */   public void increaseMax(float factor) {
/* 33 */     this.delta = (int)(this.delta * factor);
/*    */   }
/*    */   
/*    */   public void increaseMax(int amount) {
/* 37 */     this.delta += amount;
/*    */   }
/*    */ 
/*    */   
/*    */   public void bind() {
/* 42 */     super.set((int)(this.base + this.delta * CORE.getUpdateInfo().getPendulum0To1s1()));
/* 43 */     super.bind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\color\OpaPuls.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */