/*    */ package settlement.path.components;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.finder.SCompFinder;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ public final class FindableDataSingle
/*    */   extends FindableData
/*    */   implements SCompFinder.SCompPatherFinder
/*    */ {
/* 11 */   static final LinkedList<FindableDataSingle> all = new LinkedList();
/*    */   
/*    */   FindableDataSingle(CharSequence name) {
/* 14 */     super(name);
/* 15 */     all.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 20 */     return (get(c) > 0);
/*    */   }
/*    */   
/*    */   public boolean has(int startX, int startY) {
/* 24 */     SComponent s = (SETT.PATH()).comps.zero.get(startX, startY);
/* 25 */     if (s == null)
/* 26 */       return false; 
/* 27 */     while (s.superComp() != null)
/* 28 */       s = s.superComp(); 
/* 29 */     return (get(s) > 0);
/*    */   }
/*    */   
/*    */   public boolean has(SComponent s) {
/* 33 */     if (s == null)
/* 34 */       return false; 
/* 35 */     while (s.superComp() != null)
/* 36 */       s = s.superComp(); 
/* 37 */     return (get(s) > 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\FindableDataSingle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */