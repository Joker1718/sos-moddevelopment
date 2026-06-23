/*    */ package settlement.room.food.orchard;
/*    */ 
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherStat;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0, double $anonymous1) {
/* 56 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public GText format(GText t, double value) {
/* 60 */     return GFORMAT.perc(t, value);
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 65 */     if (Constructor.this.mustBeIndoors())
/* 66 */       return 1.0D; 
/* 67 */     double v = 0.0D;
/* 68 */     for (COORDINATE c : area.body()) {
/*    */       
/* 70 */       if (area.is(c)) {
/* 71 */         v += Constructor.this.fertility(c.x(), c.y());
/*    */       }
/*    */     } 
/* 74 */     return CLAMP.d(v / area.area(), 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */