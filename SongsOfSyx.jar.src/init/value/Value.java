/*    */ package init.value;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.DOUBLE_O;
/*    */ 
/*    */ 
/*    */ public class Value<T>
/*    */ {
/*    */   public final SPRITE icon;
/*    */   public final String key;
/*    */   public final CharSequence name;
/*    */   public final DOUBLE_O<T> d;
/*    */   public final boolean percentage;
/*    */   public final boolean isBool;
/*    */   
/*    */   Value(String key, SPRITE icon, CharSequence name, DOUBLE_O<T> d, boolean percentage, boolean isBool) {
/* 17 */     this.icon = icon.resized(16);
/* 18 */     this.name = name;
/* 19 */     this.d = d;
/* 20 */     this.percentage = percentage;
/* 21 */     this.isBool = isBool;
/* 22 */     this.key = key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Value.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */