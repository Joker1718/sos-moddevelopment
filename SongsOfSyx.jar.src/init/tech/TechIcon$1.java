/*    */ package init.tech;
/*    */ 
/*    */ import init.value.Lock;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
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
/* 17 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 21 */     int w = (X2 - X1) / 2;
/* 22 */     int h = (Y2 - Y1) / 2;
/* 23 */     for (int i = 0; i < t.lockers.all().size() && i < 4; i++) {
/* 24 */       int dx = i % 2 * w;
/* 25 */       int dy = i / 2 * h;
/* 26 */       ((Lock)t.lockers.all().get(i)).lockable.icon.render(r, X1 + dx, X1 + w + dx, Y1 + dy, Y1 + h + dy);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TechIcon$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */