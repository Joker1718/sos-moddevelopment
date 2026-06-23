/*    */ package settlement.overlay;
/*    */ 
/*    */ import settlement.entity.EntityIterator;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.stats.STATS;
/*    */ import util.GUTIL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends EntityIterator.Humans
/*    */ {
/*    */   protected boolean processAndShouldBreakH(Humanoid a, int ie) {
/* 41 */     if ((a.indu().clas()).player && 
/* 42 */       (STATS.HOME()).GETTER.hasSearched.indu().get(a.indu()) == 1) {
/* 43 */       RoomInstance r = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a.indu());
/* 44 */       if (r != null) {
/* 45 */         if (!GUTIL.flooder().hasBeenPushed(r.mX(), r.mY())) {
/* 46 */           GUTIL.flooder().close(r.mX(), r.mY(), r.employees().employed());
/* 47 */           GUTIL.flooder().setValue2(r.mX(), r.mY(), 1.0D);
/*    */         } else {
/* 49 */           GUTIL.flooder().setValue2(r.mX(), r.mY(), GUTIL.flooder().getValue2(r.mX(), r.mY()));
/*    */         } 
/*    */       } else {
/* 52 */         GUTIL.flooder().close(a.tc().x(), a.tc().y(), 0.0D);
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\Homeless$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */