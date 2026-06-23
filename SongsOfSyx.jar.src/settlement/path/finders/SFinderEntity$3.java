/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.components.finder.SCompFinder;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.rnd.RND;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 28 */     long n = System.currentTimeMillis();
/* 29 */     int sx = RND.rInt(SETT.TWIDTH);
/* 30 */     int sy = RND.rInt(SETT.THEIGHT);
/* 31 */     int max = 100;
/* 32 */     SFinderEntity.this.enemies = SFinderEntity.this.s().people(true);
/* 33 */     SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/* 34 */     if (s != null) {
/* 35 */       SCompFinder.SCompPath p = (SETT.PATH()).comps.pather.find(sx, sy, SFinderEntity.this.findSafety, max, 16);
/* 36 */       if (p != null) {
/* 37 */         SPathFinder.SPathUtilResult r = (SETT.PATH()).finders.finder().find(sx, sy, SFinderEntity.this.findSafety, max, p);
/* 38 */         if (r != null) {
/* 39 */           LOG.ln("yay " + sx + " " + sy + " " + r.destX + " " + r.destY);
/*    */         }
/*    */       } 
/*    */     } 
/* 43 */     LOG.ln("" + System.currentTimeMillis() - n);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderEntity$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */