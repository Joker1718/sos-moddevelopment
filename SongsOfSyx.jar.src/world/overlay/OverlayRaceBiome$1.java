/*    */ package world.overlay;
/*    */ 
/*    */ import java.util.Comparator;
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
/*    */ class null
/*    */   implements Comparator<RDRace>
/*    */ {
/*    */   public int compare(RDRace o1, RDRace o2) {
/* 39 */     return Double.compare(o2.pop.biome.get(OverlayRaceBiome.this.compReg), o1.pop.biome.get(OverlayRaceBiome.this.compReg));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayRaceBiome$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */