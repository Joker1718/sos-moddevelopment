/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import util.keymap.RMAPS;
/*    */ import util.keymap.RMapInt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RMapInt.RMapIntTwo<HCLASS, Race>
/*    */ {
/*    */   null(RMAPS<HCLASS> $anonymous0, RMAPS<Race> $anonymous1) {
/* 19 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   public void clear() {
/* 22 */     super.clear();
/* 23 */     setAll(StatDecree.this.def);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\StatDecree$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */