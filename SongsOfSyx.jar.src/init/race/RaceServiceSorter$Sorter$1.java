/*    */ package init.race;
/*    */ 
/*    */ import init.type.HCLASS;
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
/*    */   implements Comparator<T>
/*    */ {
/*    */   public int compare(T o1, T o2) {
/* 70 */     double d = (RaceServiceSorter.Sorter.this.standing(o1).definition(race).get(c)).max - (RaceServiceSorter.Sorter.this.standing(o2).definition(race).get(c)).max;
/* 71 */     if (d < 0.0D)
/* 72 */       return 1; 
/* 73 */     if (d > 0.0D)
/* 74 */       return -1; 
/* 75 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceServiceSorter$Sorter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */