/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.data.INT_O;
/*    */ import util.keymap.MAPPED;
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
/*    */   implements INT_O.INT_OE<Race>
/*    */ {
/*    */   public int min(Race t) {
/* 44 */     return min;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Race t) {
/* 49 */     return m;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(Race t) {
/* 54 */     if (t == null) {
/* 55 */       int m = 0;
/* 56 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 57 */         Race r = (Race)RACES.all().get(ri);
/* 58 */         m = Math.max(m, get(r));
/*    */       } 
/* 60 */       return m;
/*    */     } 
/* 62 */     return CLAMP.i(StatDecree.this.levels.get((MAPPED)c).get((MAPPED)t), min, m);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(Race t, int i) {
/* 67 */     if (t == null) {
/* 68 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 69 */         Race r = (Race)RACES.all().get(ri);
/* 70 */         set(r, i);
/*    */       } 
/*    */       return;
/*    */     } 
/* 74 */     StatDecree.this.levels.get((MAPPED)c).set((MAPPED)t, CLAMP.i(i, min, m));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\StatDecree$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */