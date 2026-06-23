/*    */ package init.race.bio;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import init.paths.PATHS;
/*    */ import init.race.Race;
/*    */ import java.io.IOException;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.standing.STANDINGS;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ 
/*    */ 
/*    */ public final class Bio
/*    */ {
/* 18 */   private static KeyMap<BioLines> cachebio = new KeyMap();
/*    */   
/*    */   private final BioLines data;
/*    */   private final BioOpinion improve;
/* 22 */   private final LIST<Str> tmp = (LIST<Str>)new ArrayList(new Str(128));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Bio(Json json, Race race) throws IOException {
/* 38 */     String f = json.value("BIO_FILE");
/* 39 */     Json org = new Json(PATHS.TEXT().getFolder("race").getFolder("bio").get(f));
/* 40 */     if (!cachebio.containsKey(f)) {
/*    */       
/* 42 */       BioLines d = new BioLines(org);
/* 43 */       cachebio.put(f, d);
/*    */     } 
/*    */ 
/*    */     
/* 47 */     BioLines data = (BioLines)cachebio.get(f);
/* 48 */     Json spe = null;
/* 49 */     if (json.has("BIO_FILE_SPECIFIC")) {
/* 50 */       spe = new Json(PATHS.TEXT().getFolder("race").getFolder("bio").getFolder("specific").get(json.value("BIO_FILE_SPECIFIC")));
/* 51 */       data = new BioLines(data, spe);
/*    */     } 
/* 53 */     this.data = data;
/*    */     
/* 55 */     this.improve = new BioOpinion(
/* 56 */         new BioOpinionData(org, spe), 
/* 57 */         race);
/*    */   }
/*    */   
/*    */   public LIST<BioLine> lines() {
/* 61 */     return (LIST<BioLine>)this.data.descs;
/*    */   }
/*    */   
/*    */   public CharSequence opinionTitle(Humanoid indu) {
/* 65 */     return this.improve.title(indu, STANDINGS.get(indu.indu().clas()).current(indu.indu()));
/*    */   }
/*    */   
/*    */   public void opinions(LIST<Str> res, Humanoid indu) {
/* 69 */     this.improve.get(res, indu);
/*    */   }
/*    */   
/*    */   public CharSequence opinion(Humanoid indu) {
/* 73 */     this.improve.get(this.tmp, indu);
/* 74 */     return (CharSequence)this.tmp.get(0);
/*    */   }
/*    */   
/*    */   public CharSequence houseProblem(Humanoid a) {
/* 78 */     for (BioLine d : this.data.houseP) {
/* 79 */       CharSequence s = d.get(a);
/* 80 */       if (s != null) {
/* 81 */         return s;
/*    */       }
/*    */     } 
/* 84 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\bio\Bio.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */