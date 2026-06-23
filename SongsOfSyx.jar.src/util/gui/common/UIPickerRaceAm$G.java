/*    */ package util.gui.common;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import util.data.GETTER;
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
/*    */ 
/*    */ 
/*    */ class G
/*    */   implements GETTER<Race>
/*    */ {
/*    */   private final GETTER<Integer> ier;
/*    */   
/*    */   G(GETTER<Integer> ier) {
/* 75 */     this.ier = ier;
/*    */   }
/*    */ 
/*    */   
/*    */   public Race get() {
/* 80 */     return (Race)RACES.all().get(UIPickerRaceAm.this.all.get(((Integer)this.ier.get()).intValue()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRaceAm$G.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */