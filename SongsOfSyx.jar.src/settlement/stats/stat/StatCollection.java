/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import settlement.stats.StatsInit;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public abstract class StatCollection
/*    */   implements INDEXED {
/*    */   public final String key;
/*    */   public final INFO info;
/*    */   private final int index;
/* 14 */   final ArrayListGrower<STAT> all = new ArrayListGrower();
/*    */   
/*    */   protected StatCollection(StatsInit init, String key, CharSequence name, CharSequence desc) {
/* 17 */     this.index = init.holders.add(this);
/* 18 */     init.init(key, this);
/* 19 */     this.key = key;
/* 20 */     this.info = new INFO(name, desc);
/*    */   }
/*    */   
/*    */   public LIST<STAT> all() {
/* 24 */     return (LIST<STAT>)this.all;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 29 */     return this.index;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\StatCollection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */