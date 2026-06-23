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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 71 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 75 */     if (area.area() == 0)
/* 76 */       return 0.0D; 
/* 77 */     double am = 0.0D;
/* 78 */     double v = 0.0D;
/* 79 */     for (COORDINATE c : area.body()) {
/* 80 */       if (area.is(c) && (SETT.MINERALS()).getter.get(c) == Constructor.this.blue.minable && (SETT.MINERALS()).amountD.get(c) > 0.0D) {
/* 81 */         am++;
/* 82 */         v += 0.9D + 0.2D * (SETT.MINERALS()).value.get(c);
/*    */       } 
/*    */     } 
/* 85 */     if (am == 0.0D)
/* 86 */       return 0.0D; 
/* 87 */     return v / am;
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 92 */     return GFORMAT.perc(t, value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */