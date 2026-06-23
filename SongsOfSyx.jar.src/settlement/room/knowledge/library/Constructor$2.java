/*    */ package settlement.room.knowledge.library;
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
/* 49 */     return fromItems;
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 54 */     return GFORMAT.f0(t, value * Constructor.this.blue.data.knowledgePerStation);
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(AREA area, double[] fromItems) {
/* 59 */     return super.get(area, fromItems) * Constructor.this.efficiency.get(area, fromItems);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\library\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */