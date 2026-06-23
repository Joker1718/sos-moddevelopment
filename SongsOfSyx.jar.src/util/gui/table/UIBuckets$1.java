/*    */ package util.gui.table;
/*    */ 
/*    */ import java.util.Comparator;
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
/*    */   implements Comparator<UIBuckets.Column>
/*    */ {
/*    */   public int compare(UIBuckets.Column o1, UIBuckets.Column o2) {
/* 38 */     int i1 = o1.cards - o1.height * UIBuckets.this.cards.size() / UIBuckets.this.columns.size();
/* 39 */     int i2 = o2.cards - o2.height * UIBuckets.this.cards.size() / UIBuckets.this.columns.size();
/* 40 */     return i2 - i1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\UIBuckets$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */