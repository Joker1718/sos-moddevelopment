/*     */ package util.text;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Inserter<Integer>.II
/*     */ {
/*     */   null(Inserter paramInserter, String $anonymous0) {
/* 113 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void set(Integer t, Str str) {
/* 117 */     str.add("Bob");
/* 118 */     int ri = Integer.MAX_VALUE & t.intValue();
/* 119 */     int skip = kk;
/* 120 */     ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/* 121 */     int f = ri % ee.length;
/* 122 */     for (int k = 0; k < ee.length; k++) {
/* 123 */       f++;
/* 124 */       if (f >= ee.length)
/* 125 */         f = 0; 
/* 126 */       if (ee[f] instanceof Humanoid) {
/* 127 */         Humanoid a = (Humanoid)ee[f];
/*     */         
/* 129 */         skip--;
/* 130 */         if (a.indu().player() && a.race() == FACTIONS.player().race() && skip < 0) {
/* 131 */           str.clear().add(STATS.APPEARANCE().name(a.indu()));
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertPlayer$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */