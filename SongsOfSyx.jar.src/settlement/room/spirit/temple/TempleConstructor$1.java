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
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0) {
/* 59 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double acc) {
/* 63 */     double d = 1.5D * area.area() / 2048.0D;
/* 64 */     return Math.pow(CLAMP.d(d, 0.0D, 1.0D), 0.5D);
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 69 */     GFORMAT.perc(t, value);
/* 70 */     return t;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleConstructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */