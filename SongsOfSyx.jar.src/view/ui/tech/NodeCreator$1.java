/*    */ package view.ui.tech;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.map.MAP_OBJECT;
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
/*    */   implements MAP_OBJECT<RENDEROBJ>
/*    */ {
/*    */   public RENDEROBJ get(int tx, int ty) {
/* 37 */     if (NodeCreator.this.bounds.holdsPoint(tx, ty))
/* 38 */       return res[ty][tx]; 
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public RENDEROBJ get(int tile) {
/* 44 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\NodeCreator$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */