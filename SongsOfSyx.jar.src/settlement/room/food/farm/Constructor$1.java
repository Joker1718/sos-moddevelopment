/*    */ package settlement.room.food.farm;
/*    */ 
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherStat;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0, double $anonymous1) {
/* 46 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public GText format(GText t, double value) {
/* 50 */     return GFORMAT.perc(t, value);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 56 */     double v = 0.0D;
/* 57 */     for (COORDINATE c : area.body()) {
/*    */       
/* 59 */       if (area.is(c)) {
/* 60 */         v += Constructor.this.fertility(c.x(), c.y());
/*    */       }
/*    */     } 
/*    */     
/* 64 */     return v / area.area();
/*    */   }
/*    */ 
/*    */   
/*    */   public double max() {
/* 69 */     return Constructor.this.isIndoors ? 1.0D : 1.2D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double min() {
/* 74 */     return Constructor.this.isIndoors ? 0.9D : 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */