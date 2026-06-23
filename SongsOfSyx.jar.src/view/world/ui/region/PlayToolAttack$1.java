/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.faction.diplomacy.DIP;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import world.WORLD;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 42 */     DIP.WAR().set(PlayToolAttack.this.reg.faction(), PlayToolAttack.this.aa.faction());
/* 43 */     WORLD.BATTLES().regAttack(PlayToolAttack.this.reg, PlayToolAttack.this.aa);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayToolAttack$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */