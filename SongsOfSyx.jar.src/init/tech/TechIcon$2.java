/*    */ package init.tech;
/*    */ 
/*    */ import game.boosting.BoostSpec;
/*    */ import snake2d.SPRITE_RENDERER;
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
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0) {
/* 37 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 41 */     int w = (X2 - X1) / 2;
/* 42 */     int h = (Y2 - Y1) / 2;
/* 43 */     for (int i = 0; i < t.boosters.all().size() && i < 4; i++) {
/* 44 */       int dx = i % 2 * w;
/* 45 */       int dy = i / 2 * h;
/* 46 */       ((BoostSpec)t.boosters.all().get(i)).boostable.icon.render(r, X1 + dx, X1 + w + dx, Y1 + dy, Y1 + h + dy);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TechIcon$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */