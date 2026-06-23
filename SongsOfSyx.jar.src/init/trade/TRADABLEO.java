/*    */ package init.trade;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public class TRADABLEO<T>
/*    */   extends TRADABLE {
/*    */   public final T t;
/*    */   
/*    */   public TRADABLEO(T t, String key, int index, INFO info, SPRITE icon) {
/* 11 */     super(key, index, info, icon);
/* 12 */     this.t = t;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\trade\TRADABLEO.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */