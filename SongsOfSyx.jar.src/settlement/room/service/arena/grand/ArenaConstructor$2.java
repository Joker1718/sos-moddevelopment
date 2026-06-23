/*     */ package settlement.room.service.arena.grand;
/*     */ 
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
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
/*     */ class null
/*     */   extends FurnisherStat
/*     */ {
/*     */   null(Furnisher $anonymous0) {
/*  85 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public GText format(GText t, double value) {
/*  89 */     GFORMAT.i(t, (int)Math.ceil(value));
/*  90 */     t.s();
/*  91 */     t.add('(');
/*  92 */     GFORMAT.i(t, (int)Math.ceil(value * blue.service().totalMultiplier()));
/*  93 */     t.add(')');
/*  94 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(AREA area, double acc) {
/*  99 */     ArenaConstructor.this.init(area);
/* 100 */     return ArenaConstructor.this.cSpec;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\ArenaConstructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */