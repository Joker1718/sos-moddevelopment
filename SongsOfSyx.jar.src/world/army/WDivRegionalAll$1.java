/*    */ package world.army;
/*    */ 
/*    */ import game.VERSION;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */   implements ACTION.ACTION_O<Path>
/*    */ {
/*    */   public void exe(Path t) {
/* 28 */     if (VERSION.versionIsBefore(70, 23))
/* 29 */       for (WDivRegional rr : WDivRegionalAll.this.all) {
/* 30 */         if (rr.army() != null)
/* 31 */           rr.menSet(rr.men()); 
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivRegionalAll$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */