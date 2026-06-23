/*    */ package init.race;
/*    */ 
/*    */ import game.boosting.BoostSpec;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 48 */     for (Race c : RACES.all()) {
/*    */       
/* 50 */       for (BoostSpec s : c.boosts.all()) {
/* 51 */         String k = s.boostable.key + s.boostable.key;
/* 52 */         if (!RaceBoosts.this.bvmap.containsKey(k)) {
/* 53 */           RaceBoosts.this.bvmap.put(k, new RaceBoosts.BV(RaceBoosts.this.boosters, s.boostable, s.booster.isMul));
/*    */         }
/* 55 */         ((RaceBoosts.BV)RaceBoosts.this.bvmap.get(k)).set(c, s.booster.to());
/*    */       } 
/*    */     } 
/*    */     
/* 59 */     RaceBoosts.this.setPrio();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceBoosts$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */