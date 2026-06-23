/*    */ package game.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
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
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 28 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 32 */     TargetMap.this.breakIt(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 37 */     return (TargetMap.this.attackable.is(tx, ty, GAME.ARMIES().player()) || TargetMap.this.attackable.is(tx, ty, GAME.ARMIES().enemy())) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\TargetMap$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */