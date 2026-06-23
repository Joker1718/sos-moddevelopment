/*     */ package util.text;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  88 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void set(Integer t, Str str) {
/*  92 */     Faction res = null;
/*  93 */     int ri = t.intValue() + 10;
/*  94 */     for (int i = 0; i < FACTIONS.MAX(); i++) {
/*  95 */       Faction f = FACTIONS.getByIndex(MATH.mod(ri + i, 1023));
/*  96 */       if (f != null && f.isActive() && f != FACTIONS.player() && RD.DIST().distance().get(f.capitolRegion()) > 200) {
/*  97 */         res = f;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 102 */     if (res != null) {
/* 103 */       str.add((CharSequence)res.name);
/*     */     } else {
/* 105 */       str.add("Empire of Sand");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertPlayer$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */