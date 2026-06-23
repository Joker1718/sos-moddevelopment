/*    */ package init.race.bio;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.stats.muls.StatsMultipliers;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.util.StatsJson;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends StatsJson
/*    */ {
/*    */   null(Json $anonymous0) throws IOException {
/* 53 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void doWithTheJson(STAT s, Json j, String key) {
/* 57 */     CharSequence[] tt = BioLine.insert.check((CharSequence[])j.texts(key));
/* 58 */     if (tt.length == 0)
/* 59 */       BioOpinionData.this.all[s.index()].setMore(BioLine.insert.check((CharSequence[])j.texts(key))); 
/* 60 */     BioOpinionData.this.all[s.index()].setMore(BioLine.insert.check((CharSequence[])j.texts(key)));
/*    */   }
/*    */   
/*    */   public void doWithMultiplier(StatsMultipliers.StatMultiplier m, Json j, String key) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\BioOpinionData$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */