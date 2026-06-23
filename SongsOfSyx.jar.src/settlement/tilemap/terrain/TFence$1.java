/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import init.sprite.game.SheetPair;
/*    */ import init.sprite.game.Sheets;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0) {
/* 63 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 67 */     SheetPair da = sSquare.get(0);
/* 68 */     int z = CORE.renderer().getZoomout();
/* 69 */     CORE.renderer().setZoom(Integer.numberOfTrailingZeros(4));
/* 70 */     X1 *= 4;
/* 71 */     Y1 *= 4;
/* 72 */     int d = 64;
/* 73 */     da.s.render(da.d, X1, Y1, null, r, DIR.S.mask() | DIR.E.mask(), 0, 0.0D);
/* 74 */     da.s.render(da.d, X1 + d, Y1, null, r, DIR.S.mask() | DIR.W.mask(), 0, 0.0D);
/* 75 */     da.s.render(da.d, X1, Y1 + d, null, r, DIR.N.mask() | DIR.E.mask(), 0, 0.0D);
/* 76 */     da.s.render(da.d, X1 + d, Y1 + d, null, r, DIR.N.mask() | DIR.W.mask(), 0, 0.0D);
/* 77 */     CORE.renderer().setZoom(z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFence$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */