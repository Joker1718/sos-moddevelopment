/*    */ package world.entity.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
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
/*    */ class null
/*    */   extends WArmyState
/*    */ {
/*    */   WArmyState update(WArmy a, double ds) {
/* 53 */     WArmyState.checkTile(a);
/* 54 */     if (a.faction() == null && a.region().faction() == FACTIONS.player()) {
/* 55 */       return raiding;
/*    */     }
/* 57 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public GText info(WArmy a, GText box) {
/* 62 */     box.normalify();
/* 63 */     box.set(Dic.¤¤Fortified);
/* 64 */     return box;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name(WArmy a) {
/* 69 */     return Dic.¤¤Fortified;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyState$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */