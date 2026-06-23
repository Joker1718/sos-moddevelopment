/*     */ package launcher;
/*     */ 
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LSettingInt
/*     */   extends LSettings.LSetting
/*     */   implements INT.INTE
/*     */ {
/*     */   protected int v;
/*     */   public final int defaultValue;
/*     */   private final int max;
/*     */   
/*     */   private LSettingInt(String key, int defaultValue, int max) {
/* 198 */     super(key);
/* 199 */     this.defaultValue = defaultValue;
/* 200 */     this.max = max;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/* 205 */     return CLAMP.i(this.v, 0, max());
/*     */   }
/*     */ 
/*     */   
/*     */   public int min() {
/* 210 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 215 */     return this.max;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int t) {
/* 220 */     this.v = CLAMP.i(t, 0, max());
/* 221 */     LSettings.this.save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setDefault() {
/* 227 */     this.v = this.defaultValue;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void read(Json json) {
/* 232 */     this.v = json.i(this.key, -2147483647, 2147483647, this.defaultValue);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void write(JsonE json) {
/* 237 */     json.add(this.key, this.v);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\LSettings$LSettingInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */