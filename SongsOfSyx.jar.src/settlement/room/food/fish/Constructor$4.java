/*     */ package settlement.room.food.fish;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends FurnisherStat
/*     */ {
/*     */   null(Furnisher $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, double $anonymous3) {
/* 117 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */   
/*     */   public GText format(GText t, double value) {
/* 121 */     return GFORMAT.f0(t, value, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(AREA area, double acc) {
/* 126 */     double deep = 0.0D;
/* 127 */     for (COORDINATE c : area.body()) {
/* 128 */       if (area.is(c))
/* 129 */         deep += (SETT.TERRAIN()).WATER.fishAmount.get(c); 
/*     */     } 
/* 131 */     return deep / (SETT.TERRAIN()).WATER.fishAmount.max();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\Constructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */