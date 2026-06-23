/*    */ package game.time;
/*    */ 
/*    */ import snake2d.util.file.Json;
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
/*    */ public final class Season
/*    */ {
/*    */   public final String name;
/*    */   private final int index;
/*    */   final double dayNightRatio;
/*    */   public final double red;
/*    */   public final double green;
/*    */   public final double blue;
/*    */   public final double winterValue;
/*    */   
/*    */   Season(int index, double winterValue, String key, Json data, Json text) {
/* 66 */     this.name = text.text(key);
/* 67 */     data = data.json(key);
/* 68 */     this.dayNightRatio = data.d("NIGHTRATIO", 0.1D, 0.9D);
/* 69 */     this.red = data.d("RED", 0.0D, 10.0D);
/* 70 */     this.green = data.d("GREEN", 0.0D, 10.0D);
/* 71 */     this.blue = data.d("BLUE", 0.0D, 10.0D);
/* 72 */     this.index = index;
/* 73 */     this.winterValue = winterValue;
/*    */   }
/*    */   
/*    */   public int index() {
/* 77 */     return this.index;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Seasons$Season.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */