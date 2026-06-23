/*    */ package util;
/*    */ 
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */   implements Debugger
/*    */ {
/* 44 */   private final Str tmp = new Str(128);
/*    */ 
/*    */ 
/*    */   
/*    */   public void title(CharSequence name) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Str debug(CharSequence name) {
/* 53 */     this.tmp.clear();
/* 54 */     return this.tmp;
/*    */   }
/*    */   
/*    */   public void debugObject(CharSequence name, Object o) {}
/*    */   
/*    */   public void debug(CharSequence name, ACTION a) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\Debugger$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */