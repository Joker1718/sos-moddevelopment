/*    */ package settlement.path.components;
/*    */ 
/*    */ import util.data.BOOLEANO;
/*    */ 
/*    */ public final class SComponentChecker
/*    */   implements BOOLEANO<SComponent> {
/*    */   private final SComponentLevel level;
/*    */   private short[] neighbourcheck;
/*  9 */   private short neigbourcheckI = 0;
/*    */   
/*    */   public SComponentChecker(SComponentLevel level) {
/* 12 */     this.level = level;
/* 13 */     this.neighbourcheck = new short[level.componentsMax() + 100];
/*    */   }
/*    */ 
/*    */   
/*    */   public SComponentChecker init() {
/* 18 */     if (this.neighbourcheck.length < this.level.componentsMax()) {
/* 19 */       this.neighbourcheck = new short[this.level.componentsMax() + 100];
/* 20 */       this.neigbourcheckI = 0;
/*    */     } 
/* 22 */     this.neigbourcheckI = (short)(this.neigbourcheckI + 1);
/* 23 */     if (this.neigbourcheckI == 0) {
/* 24 */       for (int i = 0; i < this.neighbourcheck.length; i++)
/* 25 */         this.neighbourcheck[i] = 0; 
/* 26 */       this.neigbourcheckI = 1;
/*    */     } 
/* 28 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean is(SComponent c) {
/* 38 */     return isSet(c.index());
/*    */   }
/*    */   
/*    */   public boolean inbounds(SComponent c) {
/* 42 */     if (c.index() < 0 || c.index() >= this.neighbourcheck.length)
/* 43 */       return false; 
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSet(int c) {
/* 53 */     if (c < 0 || c >= this.neighbourcheck.length)
/* 54 */       return false; 
/* 55 */     return (this.neighbourcheck[c] == this.neigbourcheckI);
/*    */   }
/*    */   
/*    */   public void unset(SComponent c) {
/* 59 */     this.neighbourcheck[c.index()] = (short)(this.neigbourcheckI - 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSetAndSet(SComponent c) {
/* 70 */     if (!is(c)) {
/* 71 */       this.neighbourcheck[c.index()] = this.neigbourcheckI;
/* 72 */       return false;
/*    */     } 
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComponentChecker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */