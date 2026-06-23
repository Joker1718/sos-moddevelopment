/*    */ package init.value;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.DOUBLE_O;
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
/*    */   extends Locker<T>
/*    */ {
/*    */   null(CharSequence $anonymous0, SPRITE $anonymous1) {
/* 46 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public boolean inUnlocked(T t) {
/* 50 */     return (v.getD(t) >= 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(GUI_BOX text, T t) {
/* 55 */     Lockers.this.hover(text, v.getD(t));
/*    */   }
/*    */ 
/*    */   
/*    */   public double progress(T t) {
/* 60 */     return v.getD(t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Lockers$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */