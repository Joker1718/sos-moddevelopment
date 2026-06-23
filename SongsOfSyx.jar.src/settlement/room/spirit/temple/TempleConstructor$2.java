/*    */ package settlement.room.spirit.temple;
/*    */ 
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherStat;
/*    */ import snake2d.util.datatypes.AREA;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   null(Furnisher $anonymous0) {
/* 73 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double acc) {
/* 77 */     return acc;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(AREA area, double[] fromItems) {
/* 82 */     double p = fromItems[TempleConstructor.this.priests.index()];
/* 83 */     if (p == 0.0D) {
/* 84 */       return 1.0D;
/*    */     }
/* 86 */     double d = area.area() / p * 38.0D;
/* 87 */     return Math.pow(CLAMP.d(d, 0.0D, 1.0D), 0.5D);
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 92 */     GFORMAT.perc(t, value);
/* 93 */     return t;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleConstructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */