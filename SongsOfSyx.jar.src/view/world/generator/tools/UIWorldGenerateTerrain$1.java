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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 56 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 60 */     UIWorldGenerateTerrain.this.ttt--;
/* 61 */     if (UIWorldGenerateTerrain.this.ttt < 0)
/* 62 */       UIWorldGenerateTerrain.this.ttt = types.length; 
/* 63 */     tt.type = (UIWorldGenerateTerrain.this.ttt < types.length) ? types[UIWorldGenerateTerrain.this.ttt] : null;
/* 64 */     spec.map = (UIWorldGenerateTerrain.this.ttt < types.length) ? (types[UIWorldGenerateTerrain.this.ttt]).name : null;
/* 65 */     super.clickA();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\tools\UIWorldGenerateTerrain$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */