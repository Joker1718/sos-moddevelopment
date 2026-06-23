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
/*    */ class null
/*    */   extends PlacableSimpleTile
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 43 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty) {
/* 47 */     WBattleSpec s = Tests.this.spec(tx, ty, null, null);
/* 48 */     (VIEW.world()).UI.battle.battle(s);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 54 */     return WORLD.IN_BOUNDS(tx, ty) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Tests$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */