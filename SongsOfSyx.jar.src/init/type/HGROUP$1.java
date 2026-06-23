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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 86 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2) {
/* 90 */     if (HGROUP.this.race == null || HGROUP.this.race.appearance() == null || (HGROUP.this.race.appearance()).icon == null)
/*    */       return; 
/* 92 */     double scale = (Y2 - Y1) / height();
/* 93 */     int x2 = (int)(X1 + (HGROUP.this.race.appearance()).icon.width() * scale);
/* 94 */     (HGROUP.this.race.appearance()).icon.render(rr, X1, x2, Y1, (int)(Y1 + (HGROUP.this.race.appearance()).icon.height() * scale));
/* 95 */     x2 = (int)(x2 - 6.0D * scale);
/* 96 */     HGROUP.this.type.iconSmall().render(rr, x2, (int)(x2 + HGROUP.this.type.iconSmall().width() * scale), Y1, (int)(Y1 + HGROUP.this.type.iconSmall().width() * scale));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HGROUP$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */