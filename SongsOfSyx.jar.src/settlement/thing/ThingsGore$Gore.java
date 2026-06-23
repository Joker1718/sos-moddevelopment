/*     */ package settlement.thing;
/*     */ 
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Gore
/*     */   extends THINGS.Thing
/*     */ {
/* 117 */   private static final ColorImp colTmp = new ColorImp();
/*     */   
/*     */   Gore(int index) {
/* 120 */     super(index);
/*     */   }
/*     */   
/*     */   protected abstract boolean update(double paramDouble);
/*     */   
/*     */   protected abstract void init(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, COLOR paramCOLOR);
/*     */   
/*     */   protected void bindCol(COLOR color, int am) {
/* 128 */     bindCol(color, am, 1.0F);
/*     */   }
/*     */   
/*     */   protected void bindCol(COLOR color, int am, float mul) {
/* 132 */     float[] tt = ThingsGore.colRan[am & 0x3F];
/* 133 */     colTmp.set((int)(color.red() * tt[0] * mul) & 0xFF, (int)(color.green() * tt[1] * mul) & 0xFF, (int)(color.blue() * tt[2] * mul) & 0xFF).bind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsGore$Gore.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */