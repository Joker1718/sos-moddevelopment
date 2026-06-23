/*    */ package view.keyboard;
/*    */ 
/*    */ import snake2d.util.sets.ArrayListResize;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.MapIndexed;
/*    */ 
/*    */ public abstract class KeyPage
/*    */ {
/*  9 */   final ArrayListResize<Key> all = new ArrayListResize(64, 1024);
/* 10 */   final MapIndexed<Key> map = new MapIndexed();
/*    */   public final String key;
/*    */   
/*    */   KeyPage(String key) {
/* 14 */     this.key = key;
/*    */   }
/*    */   
/*    */   public Key get(int modCode, int keyCode) {
/* 18 */     if (this.map.contains(Key.hash(modCode, keyCode)))
/* 19 */       return (Key)this.map.get(Key.hash(modCode, keyCode)); 
/* 20 */     return null;
/*    */   }
/*    */   
/*    */   public LIST<Key> all() {
/* 24 */     return (LIST<Key>)this.all;
/*    */   }
/*    */   
/*    */   public abstract CharSequence name();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\KeyPage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */