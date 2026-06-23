/*    */ package settlement.room.spirit.grave;
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
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0) {
/* 45 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 49 */     fromItems /= area.area();
/* 50 */     fromItems *= 2.0D;
/* 51 */     return CLAMP.d(fromItems, 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 56 */     return GFORMAT.perc(t, value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\CTomb$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */