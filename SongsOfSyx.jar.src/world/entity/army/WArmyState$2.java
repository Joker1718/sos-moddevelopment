/*    */ package world.entity.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.time.TIME;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.Dic;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends WArmyState
/*    */ {
/*    */   WArmyState update(WArmy a, double ds) {
/* 77 */     WArmyState.checkTile(a);
/* 78 */     if (a.faction() == null && a.region().faction() == FACTIONS.player()) {
/* 79 */       return raiding;
/*    */     }
/* 81 */     a.stateFloat = (float)(a.stateFloat + ds);
/* 82 */     if (a.stateFloat > (TIME.secondsPerDay() / 2))
/* 83 */       return fortified; 
/* 84 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public GText info(WArmy a, GText box) {
/* 90 */     box.normalify();
/* 91 */     box.set(Dic.¤¤Fortifying);
/* 92 */     return box;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name(WArmy a) {
/* 97 */     return Dic.¤¤Fortifying;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyState$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */