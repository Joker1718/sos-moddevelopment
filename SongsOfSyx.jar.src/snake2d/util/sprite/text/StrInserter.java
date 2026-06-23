/*    */ package snake2d.util.sprite.text;
/*    */ 
/*    */ public abstract class StrInserter<T>
/*    */ {
/*    */   public final String key;
/*  6 */   private static final Str tmp = new Str(128);
/*    */   public StrInserter(String key) {
/*  8 */     this.key = key;
/*    */   }
/*    */   
/*    */   protected abstract void set(T paramT, Str paramStr);
/*    */   
/*    */   public boolean insert(T t, Str str) {
/* 14 */     boolean has = false;
/* 15 */     while (str.hasinsert(this.key)) {
/* 16 */       tmp.clear();
/* 17 */       has = true;
/* 18 */       set(t, tmp);
/* 19 */       str.insert(this.key, tmp);
/*    */     } 
/* 21 */     return has;
/*    */   }
/*    */   
/*    */   public static class Simple
/*    */     extends StrInserter<CharSequence> {
/*    */     public Simple(String key) {
/* 27 */       super(key);
/*    */     }
/*    */ 
/*    */     
/*    */     protected void set(CharSequence t, Str str) {
/* 32 */       str.add(t);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\text\StrInserter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */