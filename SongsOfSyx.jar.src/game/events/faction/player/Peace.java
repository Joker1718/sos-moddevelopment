/*    */ package game.events.faction.player;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.diplomacy.deal.Deal;
/*    */ import game.faction.diplomacy.deal.DealDrawfter;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.race.KingMessages;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.Dic;
/*    */ import view.ui.diplomacy.UIDipMessDeal;
/*    */ import world.army.AD;
/*    */ 
/*    */ class Peace {
/*    */   boolean update() {
/* 17 */     if (SETT.INVADOR().invading()) {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     if (!RND.oneIn(6)) {
/* 22 */       return true;
/*    */     }
/* 24 */     FactionNPC f = null;
/*    */     
/* 26 */     for (FactionNPC ff : DIP.WAR().player()) {
/* 27 */       if (f == null || AD.power().get((Faction)ff) > AD.power().get((Faction)f)) {
/* 28 */         f = ff;
/*    */       }
/*    */     } 
/* 31 */     if (f != null && !f.request.has()) {
/* 32 */       KingMessages m = (f.court().king().roy()).induvidual.race().kingMessage();
/* 33 */       Deal d = DIP.TMP();
/* 34 */       d.setFactionAndClear(f);
/* 35 */       d.bools.PEACE.set(true);
/* 36 */       CharSequence desc = null;
/* 37 */       double credits = d.valueCredits();
/* 38 */       if (credits > 0.0D) {
/* 39 */         desc = m.PEACE_GOOD.get(f);
/*    */       } else {
/*    */         
/* 42 */         desc = m.PEACE_BAD.get(f);
/*    */       } 
/* 44 */       credits += (1.0D + RND.rFloat() * 0.5D) * Math.abs(credits);
/* 45 */       DealDrawfter.draft(d, credits, true, true);
/* 46 */       (new UIDipMessDeal(Dic.¤¤peace, desc, d, 0.5D, -0.5D)).send();
/* 47 */       return true;
/*    */     } 
/* 49 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\Peace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */