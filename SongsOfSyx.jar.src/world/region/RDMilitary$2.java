/*    */ package world.region;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import util.data.DataO;
/*    */ import util.info.INFO;
/*    */ import world.army.WDIV;
/*    */ import world.map.regions.Region;
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
/*    */   extends DataO<Region>.DataShort
/*    */ {
/*    */   null(DataO paramDataO, String $anonymous0, INFO $anonymous1, int $anonymous2) {
/* 52 */     super(paramDataO, $anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   public int get(Region t) {
/* 55 */     if (FACTIONS.player().capitolRegion() == t) {
/* 56 */       int pow = 0;
/* 57 */       for (WDIV d : RDMilitary.this.gar.player()) {
/* 58 */         pow += d.men();
/*    */       }
/* 60 */       return pow;
/*    */     } 
/* 62 */     return super.get(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(Region t, int s) {
/* 67 */     RDMilitary.this.gar.init();
/* 68 */     super.set(t, s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDMilitary$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */