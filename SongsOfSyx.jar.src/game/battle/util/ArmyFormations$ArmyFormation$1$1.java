/*    */ package game.battle.util;
/*    */ 
/*    */ import game.boosting.Boostable;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayListGrower;
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
/*    */   extends RMAP<Boostable>.KJson
/*    */ {
/*    */   protected void process(Boostable s, Json j, String key, boolean isWeak) {
/* 70 */     for (ArmyFormations.Pair pp : boosts) {
/* 71 */       if (pp.bo == s) {
/* 72 */         pp.value = j.d(key);
/*    */         return;
/*    */       } 
/*    */     } 
/* 76 */     ArmyFormations.Pair p = new ArmyFormations.Pair(s);
/* 77 */     p.value = j.d(key);
/* 78 */     boosts.add(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\ArmyFormations$ArmyFormation$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */