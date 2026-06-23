/*    */ package settlement.room.knowledge.laboratory;
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
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0) {
/* 44 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 48 */     return fromItems;
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 53 */     return GFORMAT.i(t, (int)(value * Constructor.this.blue.data.knowledgePerStation));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\laboratory\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */