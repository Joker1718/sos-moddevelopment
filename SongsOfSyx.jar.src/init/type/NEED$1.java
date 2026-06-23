/*    */ package init.type;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.service.StatService;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0) {
/* 45 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 49 */     LIST<StatService> g = STATS.SERVICE().perNeed(NEED.this);
/* 50 */     if (g != null && g.size() > 0) {
/* 51 */       ((StatService)g.get(0)).icon.render(r, X1, X2, Y1, Y2);
/*    */     } else {
/* 53 */       ii.render(r, X1, X2, Y1, Y2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\NEED$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */