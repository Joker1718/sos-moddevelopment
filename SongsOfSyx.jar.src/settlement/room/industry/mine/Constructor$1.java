/*    */ package settlement.room.industry.mine;
/*    */ 
/*    */ import settlement.main.SETT;
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
/* 54 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 58 */     double am = 0.0D;
/* 59 */     for (COORDINATE c : area.body()) {
/* 60 */       if (area.is(c) && (SETT.MINERALS()).getter.get(c) == Constructor.this.blue.minable && (SETT.MINERALS()).amountD.get(c) > 0.0D && (SETT.ROOMS()).fData.item.get(c) == null)
/* 61 */         am++; 
/*    */     } 
/* 63 */     return Math.floor(am / 1.5D);
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 68 */     return GFORMAT.i(t, (int)value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */