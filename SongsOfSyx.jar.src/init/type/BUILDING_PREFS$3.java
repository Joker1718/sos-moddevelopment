/*    */ package init.type;
/*    */ 
/*    */ import init.structure.STRUCTURES;
/*    */ import init.structure.Structure;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends BUILDING_PREF
/*    */ {
/*    */   null(String $anonymous0, LISTE<BUILDING_PREF> $anonymous1) {
/* 47 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public SPRITE icon() {
/* 51 */     return ((SETT.TERRAIN()).BUILDINGS.get((Structure)STRUCTURES.all().get(ind))).iconCombo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\BUILDING_PREFS$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */