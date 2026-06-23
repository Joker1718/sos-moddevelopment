/*    */ package view.world.generator.tools;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import world.WorldGen;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 70 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 74 */     UIWorldGenerateTerrain.this.ttt++;
/* 75 */     if (UIWorldGenerateTerrain.this.ttt > types.length)
/* 76 */       UIWorldGenerateTerrain.this.ttt = 0; 
/* 77 */     tt.type = (UIWorldGenerateTerrain.this.ttt < types.length) ? types[UIWorldGenerateTerrain.this.ttt] : null;
/* 78 */     spec.map = (UIWorldGenerateTerrain.this.ttt < types.length) ? (types[UIWorldGenerateTerrain.this.ttt]).name : null;
/* 79 */     super.clickA();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\tools\UIWorldGenerateTerrain$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */