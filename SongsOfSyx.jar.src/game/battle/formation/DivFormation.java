/*    */ package game.battle.formation;
/*    */ 
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface DivFormation
/*    */   extends DivPosition, BODY_HOLDER
/*    */ {
/*    */   DIR dir();
/*    */   
/*    */   DIV_FORMATION formation();
/*    */   
/*    */   COORDINATE start();
/*    */   
/*    */   double dx();
/*    */   
/*    */   double dy();
/*    */   
/*    */   int width();
/*    */   
/*    */   int height(DIV_SPEC paramDIV_SPEC);
/*    */   
/*    */   int dirMaskOrtho(int paramInt);
/*    */   
/*    */   DIR dir(int paramInt);
/*    */   
/*    */   boolean isEdge(int paramInt);
/*    */   
/*    */   default boolean isSameAs(DivFormation o) {
/* 37 */     return (start().isSameAs(o.start()) && dx() == o.dx() && dy() == o.dy() && deployed() == o.deployed() && width() == o.width() && formation() == o.formation() && centrePixel().isSameAs(o.centrePixel()));
/*    */   }
/*    */   
/*    */   COORDINATE centreTile();
/*    */   
/*    */   COORDINATE centrePixel();
/*    */   
/*    */   boolean isCoherent();
/*    */   
/*    */   boolean hasExtraRoom();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivFormation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */