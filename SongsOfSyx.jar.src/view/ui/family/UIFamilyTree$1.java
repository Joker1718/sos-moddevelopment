/*    */ package view.ui.family;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 51 */     int am = 0;
/* 52 */     for (int i = 0; i < STATS.REL().references(); i++) {
/* 53 */       if (STATS.REL().isRef(i))
/* 54 */         am++; 
/* 55 */     }  GFORMAT.iofk(text, am, STATS.REL().references());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTree$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */