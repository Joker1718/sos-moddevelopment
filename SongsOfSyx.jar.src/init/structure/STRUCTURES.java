/*    */ package init.structure;
/*    */ 
/*    */ import init.INIT;
/*    */ import init.paths.PATHS;
/*    */ import java.util.Locale;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import util.keymap.RMAPS;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class STRUCTURES
/*    */   extends INIT.InitResource
/*    */ {
/*    */   private static final String KEY = "STRUCTURE";
/*    */   private static Structure MUD;
/*    */   private static RMAPS<Structure> map;
/*    */   
/*    */   public STRUCTURES(INIT init) {
/* 22 */     super(init);
/*    */     
/* 24 */     PATHS.ResFolder f = path();
/*    */ 
/*    */ 
/*    */     
/* 28 */     LinkedList<String> keys = new LinkedList();
/* 29 */     keys.add("_MUD");
/* 30 */     keys.add((Object[])f.init.getFiles());
/*    */     
/* 32 */     ArrayList<Structure> all = new ArrayList(keys.size());
/* 33 */     for (String key : keys) {
/* 34 */       Json d = new Json(f.init.gets(key));
/* 35 */       Json t = new Json(f.text.gets(key));
/*    */     } 
/*    */     
/* 38 */     map = new RMAPS("STRUCTURE", (LIST)all);
/* 39 */     MUD = (Structure)all.get(0);
/*    */   }
/*    */   
/*    */   public static LIST<Structure> all() {
/* 43 */     return map.all();
/*    */   }
/*    */   
/*    */   public static RMAPS<Structure> map() {
/* 47 */     return map;
/*    */   }
/*    */   
/*    */   public static Structure mud() {
/* 51 */     return MUD;
/*    */   }
/*    */   
/*    */   public static PATHS.ResFolder path() {
/* 55 */     String f = "STRUCTURE".toLowerCase(Locale.ROOT);
/* 56 */     return PATHS.SETT().folder(f);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\structure\STRUCTURES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */