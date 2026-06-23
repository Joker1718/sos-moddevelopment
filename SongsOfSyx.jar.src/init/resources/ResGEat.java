/*    */ package init.resources;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public final class ResGEat
/*    */   extends ResG {
/*    */   public final boolean serve;
/*    */   
/*    */   private ResGEat(String key, int index, Json json) throws IOException {
/* 14 */     super(index, key, (RESOURCE)RESOURCES.map().get(key, json));
/* 15 */     this.serve = !json.bool("DONT_SERVE", false);
/*    */   }
/*    */   
/*    */   static ResGroup<ResGEat> make(PATH pathData) throws IOException {
/* 19 */     String folder = "edible";
/* 20 */     PATH pd = pathData.getFolder(folder);
/*    */     
/* 22 */     String[] files = pd.getFiles();
/* 23 */     ArrayList<ResGEat> res = new ArrayList(files.length); byte b; int i;
/*    */     String[] arrayOfString1;
/* 25 */     for (i = (arrayOfString1 = files).length, b = 0; b < i; ) { String p = arrayOfString1[b];
/* 26 */       Json j = new Json(pd.gets(p));
/* 27 */       ResGEat g = new ResGEat(p, res.size(), j);
/* 28 */       res.add(g);
/*    */       b++; }
/*    */     
/* 31 */     return new ResGroup<>("EDIBLE", (LIST<ResGEat>)res);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\ResGEat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */