/*    */ package settlement.room.food.hunter;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryResource;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0, double $anonymous1) {
/* 52 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double[] fromItems) {
/* 56 */     double a = Constructor.this.workers.get(area, fromItems);
/* 57 */     return a * ((IndustryResource)((Industry)Constructor.this.blue.indus.get(0)).outs().get(0)).rate * Constructor.this.blue.bonus().get((BOOSTABLE_O)HCLASS_RACE.clP()) * Constructor.this.blue.eBonus((int)Math.ceil(a));
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 62 */     double a = Constructor.this.workers.get(area, fromItems);
/* 63 */     return a * ((IndustryResource)((Industry)Constructor.this.blue.indus.get(0)).outs().get(0)).rate * Constructor.this.blue.bonus().get((BOOSTABLE_O)HCLASS_RACE.clP()) * Constructor.this.blue.eBonus((int)Math.ceil(a));
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 68 */     return GFORMAT.i(t, (int)value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */