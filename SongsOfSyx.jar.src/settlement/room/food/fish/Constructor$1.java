/*    */ package settlement.room.food.fish;
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
/*    */ class null
/*    */   extends FurnisherStat
/*    */ {
/*    */   null(Furnisher $anonymous0) {
/* 57 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double get(AREA area, double fromItems) {
/* 61 */     double shallow = 0.0D;
/* 62 */     double deep = 0.0D;
/* 63 */     for (COORDINATE c : area.body()) {
/* 64 */       if (area.is(c) && (SETT.TERRAIN()).WATER.SHALLOW.is(c)) {
/* 65 */         deep += (SETT.TERRAIN()).WATER.fishAmount.get(c);
/* 66 */         if ((SETT.TERRAIN()).WATER.SHALLOW.is(c)) {
/* 67 */           shallow++;
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 74 */     deep /= (SETT.TERRAIN()).WATER.fishAmount.max();
/*    */     
/* 76 */     return deep + shallow / 64.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public GText format(GText t, double value) {
/* 81 */     return GFORMAT.i(t, (int)value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */