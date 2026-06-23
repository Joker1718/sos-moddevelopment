/*    */ package game.faction;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.div.Div;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import init.trade.TR;
/*    */ import init.trade.TRADABLE;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends FWorth.WINT
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 50 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public int pget(Faction f) {
/* 54 */     double cache = 0.0D;
/* 55 */     for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 56 */       RESOURCE res = (RESOURCE)RESOURCES.ALL().get(ri);
/* 57 */       cache += FWorth.worthResource((TRADABLE)TR.get(res), f.res().getAvailable((TRADABLE)TR.get(res)));
/*    */     } 
/* 59 */     for (int ei = 0; ei < STATS.EQUIP().BATTLE_ALL().size(); ei++) {
/* 60 */       EquipBattle e = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(ei);
/* 61 */       int am = 0;
/* 62 */       for (int di = 0; di < GAME.ARMIES().player().divisions().size(); di++) {
/* 63 */         Div d = (Div)GAME.ARMIES().player().divisions().get(di);
/* 64 */         am += d.info.equipI(e) * d.menNrOf();
/*    */       } 
/* 66 */       if (am > f.res().getAvailable((TRADABLE)TR.get(e.resource)))
/* 67 */         am = f.res().getAvailable((TRADABLE)TR.get(e.resource)); 
/* 68 */       cache -= FWorth.worthResource((TRADABLE)TR.get(e.resource), am);
/*    */     } 
/*    */     
/* 71 */     return (int)cache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FWorth$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */