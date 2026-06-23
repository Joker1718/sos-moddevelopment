/*    */ package game.battle;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import java.util.Iterator;
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
/*    */   implements Iterator<Div>
/*    */ {
/*    */   public boolean hasNext() {
/* 36 */     return (ArmyDivOrder.this.ii < ArmyDivOrder.this.order.length - 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public Div next() {
/* 41 */     int i = ArmyDivOrder.this.order[ArmyDivOrder.this.ii];
/* 42 */     ArmyDivOrder.this.ii++;
/* 43 */     return (Div)ArmyDivOrder.this.army.divisions().get(i);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\ArmyDivOrder$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */