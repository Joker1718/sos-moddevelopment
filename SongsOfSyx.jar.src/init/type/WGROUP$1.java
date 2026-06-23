/*    */ package init.type;
/*    */ 
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
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 82 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2) {
/* 86 */     if (WGROUP.this.race == null || WGROUP.this.race.appearance() == null || (WGROUP.this.race.appearance()).icon == null)
/*    */       return; 
/* 88 */     double scale = (Y2 - Y1) / height();
/* 89 */     int x2 = (int)(X1 + (WGROUP.this.race.appearance()).icon.width() * scale);
/* 90 */     (WGROUP.this.race.appearance()).icon.render(rr, X1, x2, Y1, (int)(Y1 + (WGROUP.this.race.appearance()).icon.height() * scale));
/* 91 */     x2 = (int)(x2 - 6.0D * scale);
/* 92 */     WGROUP.this.type.CLASS.iconSmall().render(rr, x2, (int)(x2 + WGROUP.this.type.CLASS.iconSmall().width() * scale), Y1, (int)(Y1 + WGROUP.this.type.CLASS.iconSmall().width() * scale));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\WGROUP$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */