/*    */ package settlement.path.finders;
/*    */ 
/*    */ import game.battle.Army;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FINDABLE;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ public final class SFinderSoldierManning
/*    */   extends SFinderFindable
/*    */ {
/*    */   private final boolean army;
/*    */   
/*    */   SFinderSoldierManning(boolean army) {
/* 16 */     super("s_manning");
/* 17 */     this.army = army;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FINDABLE_MANNING getReservable(int x, int y) {
/* 23 */     Room i = (SETT.ROOMS()).map.get(x, y);
/* 24 */     if (i == null || !(i instanceof FINDABLE_MANNING_INSTANCE))
/* 25 */       return null; 
/* 26 */     FINDABLE_MANNING f = ((FINDABLE_MANNING_INSTANCE)i).getManning(x, y);
/* 27 */     if (f != null && f.army().player() == this.army && f.findableReservedCanBe())
/* 28 */       return f; 
/* 29 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public FINDABLE_MANNING getReserved(int x, int y) {
/* 34 */     Room i = (SETT.ROOMS()).map.get(x, y);
/* 35 */     if (i == null || !(i instanceof FINDABLE_MANNING_INSTANCE))
/* 36 */       return null; 
/* 37 */     FINDABLE_MANNING f = ((FINDABLE_MANNING_INSTANCE)i).getManning(x, y);
/* 38 */     if (f != null && f.army().player() == this.army && f.findableReservedIs())
/* 39 */       return f; 
/* 40 */     return null;
/*    */   }
/*    */   
/*    */   public static interface FINDABLE_MANNING extends FINDABLE {
/*    */     DIR faceDIR();
/*    */     
/*    */     void work(double param1Double, Humanoid param1Humanoid);
/*    */     
/*    */     boolean needsWork();
/*    */     
/*    */     Army army();
/*    */   }
/*    */   
/*    */   public static interface FINDABLE_MANNING_INSTANCE {
/*    */     SFinderSoldierManning.FINDABLE_MANNING getManning(int param1Int1, int param1Int2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderSoldierManning.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */