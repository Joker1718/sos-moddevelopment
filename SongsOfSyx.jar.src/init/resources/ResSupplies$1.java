/*    */ package init.resources;
/*    */ 
/*    */ import init.race.Race;
/*    */ import snake2d.util.file.Json;
/*    */ import util.keymap.RMAP;
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
/*    */   extends RMAP<ResSupply>.KJson
/*    */ {
/*    */   null(RMAP paramRMAP, String $anonymous0, Json $anonymous1) {
/* 47 */     super(paramRMAP, $anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void process(ResSupply s, Json j, String key, boolean isWeak) {
/* 51 */     s.setRace(race, j.i(key, 0, 10000));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\ResSupplies$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */