/*    */ package settlement.entity;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.MATH;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class EntityIterator
/*    */ {
/*    */   protected abstract boolean processAndShouldBreak(ENTITY paramENTITY, int paramInt);
/*    */   
/*    */   public final void iterate() {
/* 17 */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/* 18 */     int m = SETT.ENTITIES().Imax();
/* 19 */     for (int i = 0; i <= m; i++) {
/* 20 */       if (es[i] != null && 
/* 21 */         processAndShouldBreak(es[i], i))
/*    */         return; 
/*    */     } 
/*    */   }
/*    */   
/*    */   public final void iterate(int off) {
/* 27 */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/* 28 */     int m = SETT.ENTITIES().Imax() + 1;
/* 29 */     for (int i = 0; i < m; i++) {
/* 30 */       int k = MATH.mod(i + off, m);
/* 31 */       if (es[k] != null && 
/* 32 */         processAndShouldBreak(es[k], k))
/*    */         return; 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static abstract class Humans
/*    */     extends EntityIterator
/*    */   {
/*    */     public final boolean processAndShouldBreak(ENTITY e, int ie) {
/* 41 */       if (e instanceof Humanoid) {
/* 42 */         return processAndShouldBreakH((Humanoid)e, ie);
/*    */       }
/* 44 */       return false;
/*    */     }
/*    */     
/*    */     protected abstract boolean processAndShouldBreakH(Humanoid param1Humanoid, int param1Int);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\EntityIterator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */