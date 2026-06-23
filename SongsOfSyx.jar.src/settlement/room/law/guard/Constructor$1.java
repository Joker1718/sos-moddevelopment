/*    */ package settlement.room.law.guard;
/*    */ 
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherStat;
/*    */ import snake2d.util.datatypes.AREA;
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
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0) {
/* 43 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double acc) {
/* 47 */     return Math.ceil(acc);
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 52 */     GFORMAT.i(t, (int)value);
/* 53 */     return t;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */