/*    */ package init.race.bio;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
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
/*    */   extends BioLine
/*    */ {
/*    */   null(LISTE<BioLine> $anonymous0, Json $anonymous1, String $anonymous2) {
/* 53 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   protected boolean use(Humanoid a) {
/* 56 */     if (!a.indu().player())
/* 57 */       return true; 
/* 58 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\BioLines$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */