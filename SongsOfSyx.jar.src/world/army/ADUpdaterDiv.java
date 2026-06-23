/*    */ package world.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.time.TIME;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ import util.updating.IUpdater;
/*    */ import view.ui.message.MessageText;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ final class ADUpdaterDiv
/*    */   extends IUpdater {
/* 15 */   private static CharSequence ¤¤Desertion = "¤Desertion!";
/* 16 */   private static CharSequence ¤¤DesertionD = "¤Army supplies are low, and as a result {0} soldiers have deserted from {1}.";
/*    */   
/*    */   static {
/* 19 */     D.ts(ADUpdaterDiv.class);
/*    */   }
/*    */   
/*    */   public ADUpdaterDiv(ADInit init) {
/* 23 */     super(FACTIONS.MAX(), TIME.secondsPerDay());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 29 */     Faction f = (i == 0) ? null : FACTIONS.getByIndex(i - 1);
/*    */     
/* 31 */     ADArmies as = AD.army(f);
/* 32 */     for (int ai = 0; ai < as.all().size(); ai++) {
/* 33 */       WArmy a = (WArmy)as.all().get(ai);
/* 34 */       if (a.faction() != FACTIONS.player() || AD.supplies().health(a) >= 1.0D) {
/* 35 */         train(a);
/*    */       } else {
/* 37 */         starve(a);
/*    */       } 
/* 39 */       if (!a.added()) {
/* 40 */         ai--;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   void train(WArmy a) {
/* 46 */     for (int di = 0; di < a.divs().size(); di++) {
/* 47 */       WDIV div = a.divs().get(di);
/* 48 */       if (div instanceof WDivRegional) {
/* 49 */         WDivRegional d = (WDivRegional)div;
/* 50 */         d.updateDay();
/* 51 */       } else if (div instanceof WDivStored) {
/* 52 */         ((WDivStored)div).age();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   void starve(WArmy a) {
/* 59 */     double health = AD.supplies().health(a);
/* 60 */     int am = 0;
/* 61 */     for (int di = 0; di < a.divs().size(); di++) {
/* 62 */       ADDiv div = a.divs().get(di);
/* 63 */       if (health < RND.rFloat() && 
/* 64 */         div.needSupplies()) {
/* 65 */         int aa = (int)(div.men() * (1.0D - health) * (0.5D + 0.5D * RND.rFloat()));
/* 66 */         am += aa;
/* 67 */         div.menSet(div.men() - aa);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 72 */     if (am > 0) {
/* 73 */       Str.TMP.clear();
/* 74 */       Str.TMP.add(¤¤DesertionD).insert(0, am).insert(1, (CharSequence)a.name);
/* 75 */       (new MessageText(¤¤Desertion, (CharSequence)Str.TMP)).send();
/* 76 */       if (AD.men(null).get(a) <= 0)
/* 77 */         a.stop(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADUpdaterDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */