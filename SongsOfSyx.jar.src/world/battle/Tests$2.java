/*    */ package world.battle;
/*    */ 
/*    */ import view.main.VIEW;
/*    */ import view.tool.PlacableSimpleTile;
/*    */ import world.WORLD;
/*    */ import world.battle.spec.WBattleSpec;
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
/*    */   extends PlacableSimpleTile
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 58 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty) {
/* 62 */     WBattleSpec s = Tests.this.spec(tx, ty, null, null);
/* 63 */     (VIEW.world()).UI.battle.assist(s);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 69 */     return WORLD.IN_BOUNDS(tx, ty) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Tests$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */