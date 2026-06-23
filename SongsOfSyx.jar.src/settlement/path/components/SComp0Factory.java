/*    */ package settlement.path.components;
/*    */ 
/*    */ import snake2d.util.sets.ArrayListIntegerResize;
/*    */ import snake2d.util.sets.ArrayListResize;
/*    */ 
/*    */ 
/*    */ final class SComp0Factory
/*    */ {
/*  9 */   private ArrayListResize<SComp0> all = new ArrayListResize(SComp0Level.startSize, 2147483647);
/* 10 */   private ArrayListIntegerResize unused = new ArrayListIntegerResize(1024, 2147483647);
/* 11 */   final SComp0 NONE = create();
/*    */   
/*    */   public SComp0 create() {
/* 14 */     if (this.unused.isEmpty()) {
/* 15 */       int j = this.all.size();
/* 16 */       SComp0 c = new SComp0(j);
/* 17 */       this.all.add(c);
/* 18 */       c.retire(false);
/* 19 */       return c;
/*    */     } 
/* 21 */     int i = this.unused.get(this.unused.size() - 1);
/* 22 */     this.unused.remove(this.unused.size() - 1);
/* 23 */     ((SComp0)this.all.get(i)).retire(false);
/* 24 */     return (SComp0)this.all.get(i);
/*    */   }
/*    */   
/*    */   public void clear() {
/* 28 */     this.all.clear();
/* 29 */     this.unused.clear();
/* 30 */     this.all.add(this.NONE);
/*    */   }
/*    */   
/*    */   public SComp0 get(int id) {
/* 34 */     return (SComp0)this.all.get(id);
/*    */   }
/*    */   
/*    */   public void retire(SComp0 c) {
/* 38 */     this.unused.add(c.index());
/* 39 */     c.retire();
/*    */   }
/*    */   
/*    */   public int maxAmount() {
/* 43 */     return this.all.size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComp0Factory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */