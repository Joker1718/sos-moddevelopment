/*     */ package settlement.room.main.furnisher;
/*     */ 
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ public class FurnisherStatEfficiency
/*     */   extends FurnisherStat
/*     */ {
/*     */   private final FurnisherStat other;
/*     */   protected final double mul;
/*     */   
/*     */   public FurnisherStatEfficiency(Furnisher f, FurnisherStat workers) {
/* 171 */     this(f, workers, 1.0D);
/*     */   }
/*     */   
/*     */   public FurnisherStatEfficiency(Furnisher f, FurnisherStat workers, double mul) {
/* 175 */     super(f, FurnisherStat.¤¤Efficiency, FurnisherStat.¤¤EfficiencyD, 0.0D);
/* 176 */     this.other = workers;
/* 177 */     this.mul = mul;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText format(GText t, double d) {
/* 182 */     return GFORMAT.perc(t, (int)(100.0D * d) / 100.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(AREA area, double[] fromItems) {
/* 188 */     double i = fromItems[this.index];
/* 189 */     double o = this.other.get(area, fromItems);
/*     */     
/* 191 */     if (o == 0.0D) {
/* 192 */       if (i == 0.0D)
/* 193 */         return 0.5D; 
/* 194 */       return 1.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 199 */     return CLAMP.d(0.5D + this.mul * 0.5D * i / o, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public final double get(AREA area, double acc) {
/* 204 */     return acc;
/*     */   }
/*     */ 
/*     */   
/*     */   public double min() {
/* 209 */     return 0.5D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherStat$FurnisherStatEfficiency.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */