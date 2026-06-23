/*    */ package settlement.stats.disease;
/*    */ import game.battle.div.Div;
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.boosting.BValue;
/*    */ import game.boosting.Boostable;
/*    */ import game.boosting.BoosterValue;
/*    */ import game.faction.player.Player;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.HTYPES;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.POP;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ 
/*    */ class BoostsHealth {
/* 20 */   private static CharSequence ¤¤entries = "New arrivals";
/*    */   
/*    */   static {
/* 23 */     D.ts(BoostsHealth.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public BoostsHealth() {
/* 28 */     BSourceInfo s = new BSourceInfo(Dic.¤¤Population, (SPRITE)(UI.icons()).s.human);
/* 29 */     BValue.BValueFaction bValueFaction2 = new BValue.BValueFaction((BOOSTABLES.PHYSICS()).HEALTH)
/*    */       {
/*    */         public double vGet(Player f)
/*    */         {
/* 33 */           double d = 1.0D - 5.0D / (1 + POP.tot(null, null));
/* 34 */           d = CLAMP.d(d, 0.0D, 1.0D);
/* 35 */           return d;
/*    */         }
/*    */       };
/* 38 */     (new BoosterValue((BValue)bValueFaction2, s, 100.0D, 0.0D, true)).add((BOOSTABLES.PHYSICS()).HEALTH);
/*    */ 
/*    */ 
/*    */     
/* 42 */     s = new BSourceInfo(¤¤entries, (SPRITE)(UI.icons()).s.arrow_right);
/* 43 */     BValue.BValueFaction bValueFaction1 = new BValue.BValueFaction((BOOSTABLES.PHYSICS()).HEALTH)
/*    */       {
/*    */         public double vGet(Player f)
/*    */         {
/* 47 */           return CLAMP.d((STATS.POP()).COUNT.newEntries(), 0.0D, 1.0D);
/*    */         }
/*    */       };
/* 50 */     (new BoosterValue((BValue)bValueFaction1, s, 1.0D, 0.5D, true)).add((BOOSTABLES.PHYSICS()).HEALTH);
/*    */ 
/*    */ 
/*    */     
/* 54 */     s = new BSourceInfo((HTYPES.CHILD()).names, (HTYPES.CHILD()).icon);
/* 55 */     BValue.BValueInduOnly bValueInduOnly = new BValue.BValueInduOnly()
/*    */       {
/*    */         public double vGet(Div div)
/*    */         {
/* 59 */           return 0.0D;
/*    */         }
/*    */ 
/*    */         
/*    */         public double vGet(Induvidual indu) {
/* 64 */           if (indu.hType().parent() != indu.hType()) {
/* 65 */             return 1.0D;
/*    */           }
/* 67 */           return 0.0D;
/*    */         }
/*    */       };
/* 70 */     (new BoosterValue((BValue)bValueInduOnly, s, 1.0D, 0.25D, true)).add((BOOSTABLES.PHYSICS()).HEALTH);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\BoostsHealth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */