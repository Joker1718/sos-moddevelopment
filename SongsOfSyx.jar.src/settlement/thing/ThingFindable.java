/*    */ package settlement.thing;
/*    */ 
/*    */ import settlement.misc.util.FINDABLE;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ 
/*    */ public abstract class ThingFindable
/*    */   extends THINGS.Thing
/*    */   implements FINDABLE {
/*    */   public ThingFindable(int index) {
/* 10 */     super(index);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 15 */     if (!findableReservedCanBe())
/* 16 */       throw new RuntimeException(); 
/* 17 */     reserve(1);
/* 18 */     if (!findableReservedCanBe()) {
/* 19 */       finder().report(this, -1);
/*    */     }
/*    */   }
/*    */   
/*    */   protected abstract void reserve(int paramInt);
/*    */   
/*    */   public void findableReserveCancel() {
/* 26 */     if (!findableReservedIs())
/*    */       return; 
/* 28 */     if (findableReservedCanBe())
/*    */       return; 
/* 30 */     reserve(-1);
/* 31 */     finder().report(this, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract SFinderFindable finder();
/*    */   
/*    */   protected void addAction() {
/* 38 */     if (findableReservedCanBe()) {
/* 39 */       finder().report(this, 1);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void removeAction() {
/* 44 */     if (findableReservedCanBe())
/* 45 */       finder().report(this, -1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingFindable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */