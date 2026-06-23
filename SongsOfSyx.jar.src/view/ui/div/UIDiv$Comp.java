/*    */ package view.ui.div;
/*    */ 
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import java.util.Comparator;
/*    */ import settlement.stats.equip.EquipBattle;
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
/*    */ class Comp
/*    */   implements Comparator<EquipBattle>
/*    */ {
/*    */   DIV_SPEC d;
/*    */   
/*    */   public int compare(EquipBattle o1, EquipBattle o2) {
/* 47 */     return (o1.sprites[(this.d.race()).index]).z - (o2.sprites[(this.d.race()).index]).z;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDiv$Comp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */