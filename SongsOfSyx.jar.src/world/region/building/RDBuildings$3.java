/*     */ package world.region.building;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Booster;
/*     */ import snake2d.util.file.Json;
/*     */ import util.keymap.RMAP;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RBooster;
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
/*     */ class null
/*     */   extends RMAP<RDBuilding>.KJson
/*     */ {
/*     */   null(RMAP paramRMAP, String $anonymous0, Json $anonymous1) {
/* 114 */     super(paramRMAP, $anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void process(RDBuilding t, Json json, String key, boolean isWeak) {
/* 118 */     double v = json.d(key);
/*     */     
/* 120 */     for (int i = 1; i < t.levels.size(); i++) {
/* 121 */       RDBuildingLevel l = (RDBuildingLevel)t.levels.get(i);
/* 122 */       for (int bi = 0; bi < l.local.all().size(); bi++) {
/* 123 */         BoostSpec sp = (BoostSpec)l.local.all().get(bi);
/*     */         
/* 125 */         if (sp.boostable == rdrace.loyalty.target) {
/* 126 */           replace(l.local, bi, sp, v);
/* 127 */         } else if (sp.boostable == rdrace.pop.dtarget) {
/* 128 */           replace(l.local, bi, sp, v);
/* 129 */         } else if (sp.boostable == rdrace.pop.growth) {
/* 130 */           replace(l.local, bi, sp, v);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void replace(BoostSpecs l, int i, BoostSpec sp, double value) {
/* 139 */     double from = sp.booster.from();
/* 140 */     double to = sp.booster.to();
/* 141 */     if (sp.booster.isMul) {
/* 142 */       from = (from - 1.0D) * value + 1.0D;
/* 143 */       to = (to - 1.0D) * value + 1.0D;
/*     */     } else {
/* 145 */       from *= value;
/* 146 */       to *= value;
/*     */     } 
/*     */     
/* 149 */     RBooster nn = new RBooster(sp.booster.info, from, to, sp.booster.isMul)
/*     */       {
/*     */         public double get(Region t)
/*     */         {
/* 153 */           return 1.0D;
/*     */         }
/*     */       };
/*     */     
/* 157 */     l.replace(i, (Booster)nn, sp.boostable);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuildings$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */