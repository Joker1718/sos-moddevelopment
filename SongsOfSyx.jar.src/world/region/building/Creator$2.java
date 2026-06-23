/*     */ package world.region.building;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import init.race.RACES;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
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
/*     */   BSourceInfo info;
/*     */   
/*     */   null() {
/* 243 */     this.info = new BSourceInfo(paramRoomBlueprintImp.info.name, (SPRITE)paramRoomBlueprintImp.icon);
/*     */   }
/*     */   public void exe() {
/* 246 */     for (int i = 1; i < b.levels.size(); i++) {
/* 247 */       for (BoostSpec s : sp.all()) {
/* 248 */         double am = s.booster.to() * i / (b.levels.size() - 1);
/* 249 */         ((RDBuildingLevel)b.levels.get(i)).local.push((Booster)new BoosterValue(BValue.VALUE1, this.info, am, s.booster.isMul), s.boostable);
/*     */       } 
/*     */     } 
/* 252 */     for (CLIMATE c : CLIMATES.ALL()) {
/* 253 */       for (int si = 0; si < c.boosters.all().size(); si++) {
/* 254 */         BoostSpec s = (BoostSpec)c.boosters.all().get(si);
/* 255 */         if (s.boostable == blue.bonus()) {
/* 256 */           CLIMATES.pushIfDoesntExist(c, s.booster.to(), b.efficiency, s.booster.isMul);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     for (RDRace c : (RD.RACES()).all) {
/* 265 */       for (int si = 0; si < c.race.boosts.all().size(); si++) {
/* 266 */         BoostSpec s = (BoostSpec)c.race.boosts.all().get(si);
/* 267 */         if (s.boostable == blue.bonus()) {
/*     */           
/* 269 */           BoostSpec sp = RACES.boosts().pushIfDoesntExist(c.race, s.booster.to(), b.efficiency, s.booster.isMul);
/* 270 */           if (sp != null && !sp.boostable.contains(sp.booster))
/* 271 */             sp.booster.add(sp.boostable); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\Creator$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */