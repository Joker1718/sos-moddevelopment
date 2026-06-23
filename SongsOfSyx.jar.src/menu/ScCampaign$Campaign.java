/*     */ package menu;
/*     */ 
/*     */ import game.GameSpec;
/*     */ import game.VERSION;
/*     */ import init.paths.PATHS;
/*     */ import java.nio.file.Path;
/*     */ import script.ScriptEngine;
/*     */ import script.ScriptLoad;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.info.INFO;
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
/*     */ class Campaign
/*     */ {
/*     */   public final Json cutsceneData;
/*     */   public final Json cutsceneText;
/*     */   public final INFO info;
/*     */   public String[] requires;
/*     */   public final Path save;
/*     */   public final String[] scripts;
/*     */   public final String key;
/*     */   
/*     */   public Campaign(Json json, String key) {
/* 269 */     this.key = key;
/* 270 */     Json text = new Json(PATHS.TEXT().getFolder("campaign").gets(key));
/* 271 */     this.info = new INFO(text);
/* 272 */     this.cutsceneText = text.json("CUTSCENE");
/* 273 */     this.cutsceneData = json.json("CUTSCENE");
/* 274 */     this.requires = json.values("REQUIRES");
/* 275 */     if (json.bool("SAVE_LOCAL")) {
/* 276 */       Path s = (PATHS.local()).SAVE_CAMPAIGN.exists(key) ? (PATHS.local()).SAVE_CAMPAIGN.get(key) : null;
/* 277 */       if (s != null) {
/* 278 */         GameSpec f = GameSpec.get(s);
/* 279 */         if (VERSION.versionMajor(f.version) != 71)
/* 280 */           s = null; 
/*     */       } 
/* 282 */       this.save = s;
/*     */     } else {
/*     */       
/* 285 */       this.save = (PATHS.MISC()).SAVES_CAMPAIGN.get(key);
/*     */     } 
/* 287 */     String[] ss = json.values("SCRIPTS");
/* 288 */     ArrayListGrower<ScriptLoad> scripts = new ArrayListGrower();
/* 289 */     for (int i = 0; i < ss.length; i++) {
/* 290 */       if (!(PATHS.SCRIPT()).jar.exists(ss[i])) {
/* 291 */         json.error(String.valueOf((PATHS.SCRIPT()).jar.get().toAbsolutePath()) + " /" + String.valueOf((PATHS.SCRIPT()).jar.get().toAbsolutePath()) + " does not exist", "SCRIPTS");
/*     */       } else {
/* 293 */         scripts.add((Iterable)ScriptEngine.getInJar(ss[i]));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 298 */     this.scripts = new String[scripts.size()];
/* 299 */     int ii = 0;
/* 300 */     for (ScriptLoad l : scripts) {
/* 301 */       this.scripts[ii++] = l.key;
/*     */     }
/*     */   }
/*     */   
/*     */   boolean locked() {
/* 306 */     if (this.save == null)
/* 307 */       return true;  byte b; int i; String[] arrayOfString;
/* 308 */     for (i = (arrayOfString = this.requires).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 309 */       if (!ScCampaign.this.completed.contains(s))
/* 310 */         return true;  b++; }
/* 311 */      return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScCampaign$Campaign.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */