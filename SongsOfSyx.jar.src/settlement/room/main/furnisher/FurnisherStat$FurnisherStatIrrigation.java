/*     */ package settlement.room.main.furnisher;
/*     */ 
/*     */ import settlement.room.water.RoomIrrigated;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import snake2d.util.datatypes.AREA;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FurnisherStatIrrigation
/*     */   extends FurnisherStat
/*     */ {
/*     */   private final boolean nop;
/*     */   private final RoomIrrigated.ROOM_IRRIGATED ii;
/*     */   
/*     */   public FurnisherStatIrrigation(Furnisher f, RoomIrrigated.ROOM_IRRIGATED ii) {
/* 221 */     super(f, Ground.¤¤moisture, FurnisherStat.¤¤wdesc, 0.0D);
/* 222 */     this.ii = ii;
/* 223 */     this.nop = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GText format(GText t, double d) {
/* 229 */     if (this.nop) {
/* 230 */       t.add('-').add('-');
/* 231 */       return t;
/*     */     } 
/*     */     
/* 234 */     return GFORMAT.perc(t, (int)(100.0D * d) / 100.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(AREA area, double[] fromItems) {
/* 240 */     return this.ii.irrigation().valueProspect(area);
/*     */   }
/*     */ 
/*     */   
/*     */   public final double get(AREA area, double acc) {
/* 245 */     return acc;
/*     */   }
/*     */ 
/*     */   
/*     */   public double min() {
/* 250 */     return (this.ii.irrigation()).from;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherStat$FurnisherStatIrrigation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */