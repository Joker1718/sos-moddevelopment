/*    */ package settlement.room.infra.stockpile;
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
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0) {
/* 31 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 35 */     return fromItems * (Constructor.this.blue.upgrades().boost(0) - 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 40 */     return GFORMAT.i(t, (int)value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */