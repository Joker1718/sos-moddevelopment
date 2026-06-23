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
/* 44 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Integer t, Str str) {
/* 48 */     Region res = FACTIONS.player().capitolRegion();
/* 49 */     int ri = t.intValue() + 10;
/* 50 */     for (int i = 0; i < 1023; i++) {
/* 51 */       Region reg = (Region)WORLD.REGIONS().all().getC(ri + i);
/* 52 */       if (reg.active() && reg != FACTIONS.player().capitolRegion() && RD.DIST().distance().get(reg) > 200) {
/* 53 */         res = reg;
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/* 58 */     if (res != null)
/* 59 */       str.add((CharSequence)res.info.name()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertPlayer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */