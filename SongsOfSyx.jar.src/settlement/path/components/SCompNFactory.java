/*    */ package settlement.path.components;
/*    */ 
/*    */ import snake2d.util.sets.ArrayListIntegerResize;
/*    */ import snake2d.util.sets.ArrayListResize;
/*    */ 
/*    */ final class SCompNFactory
/*    */ {
/*    */   private final ArrayListResize<SCompN> all;
/*    */   private final ArrayListIntegerResize unused;
/*    */   private final byte level;
/*    */   
/*    */   SCompNFactory(int level, int size) {
/* 13 */     this.level = (byte)level;
/* 14 */     this.all = new ArrayListResize(2048 / level, 2147483647);
/* 15 */     this.unused = new ArrayListIntegerResize(512 / level, 2147483647);
/*    */   }
/*    */   
/*    */   public SCompN create() {
/* 19 */     if (this.unused.isEmpty()) {
/* 20 */       int j = this.all.size();
/* 21 */       SCompN c = new SCompN(j, this.level);
/* 22 */       this.all.add(c);
/* 23 */       c.retired = false;
/* 24 */       return c;
/*    */     } 
/* 26 */     int i = this.unused.get(this.unused.size() - 1);
/* 27 */     this.unused.remove(this.unused.size() - 1);
/* 28 */     ((SCompN)this.all.get(i)).retired = false;
/* 29 */     return (SCompN)this.all.get(i);
/*    */   }
/*    */   
/*    */   public void clear() {
/* 33 */     this.all.clear();
/* 34 */     this.unused.clear();
/*    */   }
/*    */   
/*    */   public SCompN get(int id) {
/* 38 */     return (SCompN)this.all.get(id);
/*    */   }
/*    */   
/*    */   public void retire(SCompN c) {
/* 42 */     if (c.retired)
/*    */       return; 
/* 44 */     this.unused.add(c.index());
/* 45 */     c.retire();
/*    */   }
/*    */   
/*    */   public int maxAmount() {
/* 49 */     return this.all.size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompNFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */