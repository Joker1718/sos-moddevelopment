/*    */ package view.ui.economy;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.keymap.MAPPED;
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
/* 35 */     int b = RRowPriceDia.this.hres.get((MAPPED)RRowPriceDia.this.res);
/* 36 */     if (RRowPriceDia.this.res == null)
/* 37 */       b /= RESOURCES.ALL().size(); 
/* 38 */     GFORMAT.i(text, b);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\RRowPriceDia$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */