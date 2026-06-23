/*    */ package init.resources;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public final class ResGDrink
/*    */   extends ResG {
/*    */   public final COLOR color;
/*    */   public final boolean serve;
/*    */   
/*    */   private ResGDrink(String key, int index, Json json) throws IOException {
/* 17 */     super(index, key, (RESOURCE)RESOURCES.map().get(key, json));
/* 18 */     this.color = (COLOR)new ColorImp(json);
/* 19 */     this.serve = !json.bool("DONT_SERVE", false);
/*    */   }
/*    */   
/*    */   static ResGroup<ResGDrink> make(PATH pathData) throws IOException {
/* 23 */     String folder = "drinkable";
/* 24 */     PATH pd = pathData.getFolder(folder);
/*    */     
/* 26 */     String[] files = pd.getFiles();
/* 27 */     ArrayList<ResGDrink> res = new ArrayList(files.length); byte b; int i;
/*    */     String[] arrayOfString1;
/* 29 */     for (i = (arrayOfString1 = files).length, b = 0; b < i; ) { String p = arrayOfString1[b];
/* 30 */       Json j = new Json(pd.gets(p));
/* 31 */       ResGDrink g = new ResGDrink(p, res.size(), j);
/* 32 */       res.add(g);
/*    */       b++; }
/*    */     
/* 35 */     return new ResGroup<>("DRINKABLE", (LIST<ResGDrink>)res);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\ResGDrink.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */