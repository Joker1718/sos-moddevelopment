/*    */ package init.race;
/*    */ 
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASSES;
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
/*    */ import settlement.stats.standing.StatStanding;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ abstract class Sorter<T>
/*    */ {
/*    */   LIST<LIST<T>> sort(LIST<T> all, final Race race) {
/* 44 */     ArrayList<LIST<T>> res = new ArrayList(HCLASSES.ALL().size());
/*    */     
/* 46 */     for (HCLASS dd : HCLASSES.ALL()) {
/*    */       
/* 48 */       final HCLASS c = (dd == HCLASSES.OTHER()) ? HCLASSES.CITIZEN() : dd;
/*    */ 
/*    */       
/* 51 */       int am = 0;
/* 52 */       for (T h : all) {
/* 53 */         if ((standing(h).definition(race).get(c)).max > 0.0D) {
/* 54 */           am++;
/*    */         }
/*    */       } 
/*    */       
/* 58 */       Object[] al = new Object[am];
/* 59 */       am = 0;
/* 60 */       for (T h : all) {
/* 61 */         if ((standing(h).definition(race).get(c)).max > 0.0D) {
/* 62 */           al[am++] = h;
/*    */         }
/*    */       } 
/*    */       
/* 66 */       Arrays.sort(al, (Comparator)new Comparator<T>()
/*    */           {
/*    */             public int compare(T o1, T o2)
/*    */             {
/* 70 */               double d = (RaceServiceSorter.Sorter.this.standing(o1).definition(race).get(c)).max - (RaceServiceSorter.Sorter.this.standing(o2).definition(race).get(c)).max;
/* 71 */               if (d < 0.0D)
/* 72 */                 return 1; 
/* 73 */               if (d > 0.0D)
/* 74 */                 return -1; 
/* 75 */               return 0;
/*    */             }
/*    */           });
/* 78 */       res.add(new ArrayList(al));
/*    */     } 
/*    */ 
/*    */     
/* 82 */     return (LIST<LIST<T>>)res;
/*    */   }
/*    */   
/*    */   abstract StatStanding standing(T paramT);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceServiceSorter$Sorter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */