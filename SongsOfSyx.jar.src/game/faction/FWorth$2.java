/*    */ package game.faction;
/*    */ 
/*    */ import init.race.Race;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import world.region.RD;
/*    */ import world.region.pop.RDRace;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends FWorth.WINT
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 81 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   public int pget(Faction f) {
/* 84 */     double cache = 0.0D;
/* 85 */     for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 86 */       Race res = ((RDRace)(RD.RACES()).all.get(ri)).race;
/* 87 */       cache += (f.citizens(res) * 400) * 5.0D / (res.population()).max;
/*    */     } 
/* 89 */     return (int)cache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FWorth$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */