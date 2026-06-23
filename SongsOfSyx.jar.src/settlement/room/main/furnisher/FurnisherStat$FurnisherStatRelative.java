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
/*     */ public class FurnisherStatRelative
/*     */   extends FurnisherStat
/*     */ {
/*     */   private final FurnisherStat other;
/*     */   private final double mod;
/*     */   
/*     */   public FurnisherStatRelative(Furnisher f, FurnisherStat other) {
/* 130 */     this(f, other, 1.0D);
/*     */   }
/*     */   
/*     */   public FurnisherStatRelative(Furnisher f, FurnisherStat other, double mod) {
/* 134 */     super(f);
/* 135 */     this.other = other;
/* 136 */     this.mod = mod;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText format(GText t, double d) {
/* 141 */     return GFORMAT.perc(t, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(AREA area, double[] fromItems) {
/* 147 */     double i = fromItems[this.index];
/* 148 */     double o = this.other.get(area, fromItems);
/*     */     
/* 150 */     if (o == 0.0D) {
/* 151 */       if (i == 0.0D)
/* 152 */         return 0.0D; 
/* 153 */       return 1.0D;
/*     */     } 
/*     */     
/* 156 */     return CLAMP.d(this.mod * i / o, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public final double get(AREA area, double acc) {
/* 161 */     return acc;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherStat$FurnisherStatRelative.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */