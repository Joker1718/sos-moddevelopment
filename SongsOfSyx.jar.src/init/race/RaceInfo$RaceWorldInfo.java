/*     */ package init.race;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import snake2d.util.file.Json;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RaceWorldInfo
/*     */ {
/*     */   public final String[] intros;
/*     */   public final String[] fNames;
/*     */   public final String[] rIntro;
/*     */   public final String[] rNames;
/*     */   
/*     */   RaceWorldInfo(String key) {
/* 107 */     Json json = new Json(PATHS.NAMES().getFolder("world").gets(key));
/* 108 */     this.intros = json.texts("INTRO", 1, 128);
/* 109 */     this.fNames = json.texts("NAMES", 1, 512);
/* 110 */     this.rIntro = json.texts("RULER_INTRO", 1, 128);
/* 111 */     this.rNames = json.texts("RULER", 1, 512);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceInfo$RaceWorldInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */