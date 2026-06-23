/*    */ package init.race.appearence;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RNames
/*    */ {
/*    */   public final LIST<String> firstNames;
/*    */   public final LIST<String> lastNames;
/*    */   
/*    */   RNames(Json json, KeyMap<String[]> names) {
/* 18 */     this.firstNames = (LIST<String>)names("NAMESET_FILE_FIRST", json, names);
/* 19 */     this.lastNames = (LIST<String>)names("NAMESET_FILE_SURNAME", json, names);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static ArrayList<String> names(String key, Json json, KeyMap<String[]> names) {
/* 25 */     String v = json.value(key);
/* 26 */     if (names.containsKey(v))
/* 27 */       return new ArrayList((Object[])names.get(v)); 
/* 28 */     Json d = new Json(PATHS.TEXT().getFolder("names").getFolder("nameset").gets(v));
/* 29 */     String[] mm = d.texts("NAMES", 1, 4095);
/* 30 */     names.put(v, mm);
/* 31 */     return new ArrayList((Object[])mm);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RNames.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */