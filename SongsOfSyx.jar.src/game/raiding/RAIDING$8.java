/*     */ package game.raiding;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import snake2d.util.misc.ACTION;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 161 */     BValue.BValueAll vv = new BValue.BValueAll()
/*     */       {
/*     */         public double get()
/*     */         {
/* 165 */           if (DIP.overlord((Faction)FACTIONS.player()) != null)
/* 166 */             return 1.0D; 
/* 167 */           return 0.0D;
/*     */         }
/*     */       };
/* 170 */     BSourceInfo s = new BSourceInfo((DIP.VASSAL()).name, (DIP.VASSAL()).icon);
/* 171 */     (new BoosterValue((BValue)vv, s, 0.0D, 4.0D, false)).add((BOOSTABLES.CIVICS()).RAID_SECURITY);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RAIDING$8.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */