/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.path.SPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SFinderEntry
/*    */ {
/*    */   public boolean find(int sx, int sy, SPath path, int max) {
/* 14 */     SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/* 15 */     if (s == null)
/* 16 */       return false; 
/* 17 */     if (s.hasEntry() && 
/* 18 */       path.request(sx, sy, this.point, max)) {
/* 19 */       return true;
/*    */     }
/* 21 */     if (s.hasEdge()) {
/* 22 */       return path.request(sx, sy, this.any, max);
/*    */     }
/* 24 */     return false;
/*    */   }
/*    */   
/*    */   public boolean any(int sx, int sy, SPath path, int max) {
/* 28 */     SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/* 29 */     if (s == null)
/* 30 */       return false; 
/* 31 */     if (s.hasEdge()) {
/* 32 */       return path.request(sx, sy, this.any, max);
/*    */     }
/* 34 */     return false;
/*    */   }
/*    */   
/*    */   public boolean anyHas(int sx, int sy) {
/* 38 */     SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/* 39 */     if (s == null)
/* 40 */       return false; 
/* 41 */     return s.hasEdge();
/*    */   }
/*    */ 
/*    */   
/* 45 */   private final SFINDER point = new SFINDER()
/*    */     {
/*    */       public boolean isInComponent(SComponent c, double distance)
/*    */       {
/* 49 */         return c.hasEntry();
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean isTile(int tx, int ty, int tileNr) {
/* 54 */         if ((SETT.PATH()).solidity.is(tx, ty))
/* 55 */           return false; 
/* 56 */         if (tx == 0 || tx == SETT.TWIDTH - 1 || ty == 0 || ty == SETT.THEIGHT - 1) {
/* 57 */           return (SETT.ENTRY()).points.map.is(tx, ty);
/*    */         }
/* 59 */         return false;
/*    */       }
/*    */     };
/*    */   
/* 63 */   private final SFINDER any = new SFINDER()
/*    */     {
/*    */       public boolean isInComponent(SComponent c, double distance)
/*    */       {
/* 67 */         return c.hasEdge();
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean isTile(int tx, int ty, int tile) {
/* 72 */         if ((SETT.PATH()).solidity.is(tx, ty))
/* 73 */           return false; 
/* 74 */         return !(tx != 0 && tx != SETT.TWIDTH - 1 && ty != 0 && ty != SETT.THEIGHT - 1);
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderEntry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */