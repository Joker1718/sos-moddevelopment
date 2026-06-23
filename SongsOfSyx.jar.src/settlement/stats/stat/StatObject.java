/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.Induvidual;
/*    */ import util.data.GETTER_TRANS;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public abstract class StatObject<T>
/*    */   implements GETTER_TRANS.GETTER_TRANSE<Humanoid, T> {
/*    */   public final INFO info;
/*    */   
/*    */   public StatObject(CharSequence name, CharSequence desc) {
/* 13 */     this.info = new INFO(name, desc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T get(Humanoid f) {
/* 20 */     return get(f.indu());
/*    */   }
/*    */   
/*    */   public abstract T get(Induvidual paramInduvidual);
/*    */   
/*    */   public abstract STAT stat();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\StatObject.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */