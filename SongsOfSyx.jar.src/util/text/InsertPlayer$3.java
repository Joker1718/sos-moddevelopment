/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.MATH;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import world.region.RD;
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
/*    */   extends Inserter<Integer>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 65 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Integer t, Str str) {
/* 69 */     Faction res = null;
/* 70 */     int ri = t.intValue();
/* 71 */     for (int i = 0; i < FACTIONS.MAX(); i++) {
/* 72 */       Faction f = FACTIONS.getByIndex(MATH.mod(ri + i, 1023));
/* 73 */       if (f != null && f.isActive() && f != FACTIONS.player() && RD.DIST().distance().get(f.capitolRegion()) < 200) {
/* 74 */         res = f;
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/* 79 */     if (res != null) {
/* 80 */       str.add((CharSequence)res.name);
/*    */     } else {
/* 82 */       str.add("Empire of Sand");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertPlayer$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */