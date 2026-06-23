/*    */ package world.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FCredits;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.updating.IUpdater;
/*    */ import view.ui.message.MessageText;
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
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 39 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void update(int di, double timeSinceLast) {
/* 43 */     if (di == 10) {
/* 44 */       int missed = 0;
/* 45 */       int cc = 0;
/* 46 */       for (WDivMercenary wDivMercenary : WDivMercenaries.this.all) {
/* 47 */         if (wDivMercenary.army() == null || wDivMercenary.army().faction() != FACTIONS.player())
/*    */           continue; 
/* 49 */         if (wDivMercenary.missedPayments < 0) {
/* 50 */           wDivMercenary.missedPayments = 0;
/*    */           continue;
/*    */         } 
/* 53 */         int cost = (int)((wDivMercenary.costPerMan() * wDivMercenary.men()) * wDivMercenary.army().supplyAmount());
/* 54 */         if (cost > FACTIONS.player().credits().credits()) {
/* 55 */           wDivMercenary.missedPayments = (byte)(wDivMercenary.missedPayments + 1);
/* 56 */           if (wDivMercenary.missedPayments >= 2) {
/* 57 */             wDivMercenary.reassign(null);
/*    */           }
/* 59 */           cc += cost;
/* 60 */           missed = Math.max(missed, wDivMercenary.missedPayments); continue;
/*    */         } 
/* 62 */         FACTIONS.player().credits().inc(-cost, FCredits.CTYPE.MERCINARIES);
/* 63 */         wDivMercenary.missedPayments = (byte)(wDivMercenary.missedPayments - 1);
/* 64 */         if (wDivMercenary.missedPayments > 0 && cost <= FACTIONS.player().credits().credits()) {
/* 65 */           FACTIONS.player().credits().inc(-cost, FCredits.CTYPE.MERCINARIES);
/*    */         }
/*    */       } 
/*    */ 
/*    */       
/* 70 */       if (missed == 1) {
/* 71 */         Str.TMP.clear().add(WDivMercenaries.¤¤mWBody);
/* 72 */         Str.TMP.insert(0, cc);
/* 73 */         (new MessageText(WDivMercenaries.¤¤mWTitle, (CharSequence)Str.TMP)).send();
/* 74 */       } else if (missed == 2) {
/* 75 */         (new MessageText(WDivMercenaries.¤¤mTitle, WDivMercenaries.¤¤mBody)).send();
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 81 */     WDivMercenary d = (WDivMercenary)WDivMercenaries.this.all.get(di);
/*    */     
/* 83 */     if (d.army() != null) {
/* 84 */       if (d.army().recruiting()) {
/* 85 */         d.menSet(CLAMP.i(d.men() + 1, 0, d.menTarget()));
/*    */       }
/*    */     }
/*    */     else {
/*    */       
/* 90 */       (STATS.POP()).age.DAYS.inc(d.cheif(), 1);
/* 91 */       if ((STATS.POP()).age.shouldDieOfOldAge(d.cheif())) {
/* 92 */         d.randomize();
/*    */       }
/*    */       
/* 95 */       if (d.disbandTime > 0.0F)
/* 96 */         d.disbandTime = (float)(d.disbandTime - timeSinceLast); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivMercenaries$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */