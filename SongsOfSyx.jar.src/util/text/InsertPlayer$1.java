/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
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
/*    */ class null
/*    */   extends Inserter<Integer>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 23 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Integer t, Str str) {
/* 27 */     Region res = FACTIONS.player().capitolRegion();
/* 28 */     int ri = t.intValue();
/* 29 */     for (int i = 0; i < 1023; i++) {
/* 30 */       Region reg = (Region)WORLD.REGIONS().all().getC(ri + i);
/* 31 */       if (reg.active() && reg != FACTIONS.player().capitolRegion() && RD.DIST().distance().get(reg) < 200) {
/* 32 */         res = reg;
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/* 37 */     if (res != null)
/* 38 */       str.add((CharSequence)res.info.name()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertPlayer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */