/*    */ package view.keyboard;
/*    */ public class KeyPageBattle extends KeyPage {
/*    */   public final Key UP;
/*    */   public final Key DOWN;
/*    */   public final Key LEFT;
/*    */   public final Key RIGHT;
/*    */   public final Key SELECT_ALL;
/*    */   
/*    */   KeyPageBattle() {
/* 10 */     super("BATTLE");
/*    */ 
/*    */ 
/*    */     
/* 14 */     D.gInit(this);
/*    */ 
/*    */ 
/*    */     
/* 18 */     this.UP = new Key("UP", D.g("Up"), D.g("UpD", "Move selected Divisions."), this, 265);
/* 19 */     this.DOWN = new Key("DOWN", D.g("Down"), this.UP.desc, this, 264);
/* 20 */     this.LEFT = new Key("LEFT", D.g("Left"), this.UP.desc, this, 263);
/* 21 */     this.RIGHT = new Key("RIGHT", D.g("Right"), this.UP.desc, this, 262);
/* 22 */     this.SELECT_ALL = new Key("SELECT_ALL", D.g("Select"), D.g("SelectD", "Selects all divisions."), this, 341, 32);
/* 23 */     this.SHOW_DIVISIONS = new Key("SHOW_DIVISION", D.g("Show"), D.g("ShowD", "Shows all division positions."), this, 32);
/*    */     
/* 25 */     this.FORM_LOOSE = new Key("FORM_LOOSE", D.g("floose", "Loose Formation"), D.g("flooseD", "Loose Formation. Good against projectiles"), this, 76);
/* 26 */     this.FORM_TIGHT = new Key("FORM_TIGHT", D.g("ftight", "Tight Formation"), D.g("ftightD", "Tight Formation. Good in melee."), this, 84);
/*    */     
/* 28 */     this.GUARD = new Key("GUARD", D.g("Guard"), D.g("guardD", "When in guard, soldiers will maintain formation in battle, and stay on the defensive."), this, 71);
/*    */     
/* 30 */     this.CHARGE = new Key("CHARGE", D.g("Charge"), D.g("stopD", "Soldiers will start running in their current direction until they reach an enemy or obstacle. Soldiers will not have a lot of defense, but have a lot of extra force when colliding, as well as scaring the enemy force."), this, 67);
/*    */   }
/*    */   public final Key SHOW_DIVISIONS; public final Key FORM_LOOSE; public final Key FORM_TIGHT; public final Key GUARD; public final Key CHARGE;
/*    */   public CharSequence name() {
/* 34 */     return Dic.¤¤Battle;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\KeyPageBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */