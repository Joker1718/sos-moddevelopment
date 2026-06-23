/*    */ package init.type;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ public class DISEASES
/*    */ {
/*    */   private final LIST<DISEASE> all;
/*    */   private static DISEASES s;
/*    */   private final RMAP<DISEASE> map;
/*    */   private final double regularDays;
/*    */   
/*    */   DISEASES() {
/* 20 */     s = this;
/* 21 */     PATH pd = PATHS.INIT().getFolder("disease");
/* 22 */     PATH ps = PATHS.TEXT().getFolder("disease");
/* 23 */     this.regularDays = (new Json(pd.gets("_CONFIG"))).d("REGULAR_SICKNESS_DAY_INVERVAL", 1.0D, 1.0E7D);
/* 24 */     LinkedList<DISEASE> all = new LinkedList(); byte b; int i;
/*    */     String[] arrayOfString;
/* 26 */     for (i = (arrayOfString = pd.getFiles(1, 120)).length, b = 0; b < i; ) { String k = arrayOfString[b]; b++; }
/*    */ 
/*    */ 
/*    */     
/* 30 */     this.all = (LIST<DISEASE>)new ArrayList((Iterable)all);
/*    */     
/* 32 */     this.map = new RMAP("DISEASE", (LIST)all);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static LIST<DISEASE> all() {
/* 38 */     return s.all;
/*    */   }
/*    */   
/*    */   public static RMAP<DISEASE> map() {
/* 42 */     return s.map;
/*    */   }
/*    */   
/*    */   public static double regularDays() {
/* 46 */     return s.regularDays;
/*    */   }
/*    */   
/*    */   public static DISEASE randomEpidemic(double ran) {
/* 50 */     double lim = 0.0D;
/* 51 */     for (int i = 0; i < s.all.size(); i++) {
/* 52 */       DISEASE dd = (DISEASE)s.all.get(i);
/* 53 */       if (dd.epidemic)
/*    */       {
/* 55 */         lim += dd.occurence(); } 
/*    */     } 
/* 57 */     lim *= ran;
/* 58 */     double d = 0.0D;
/* 59 */     for (int j = 0; j < s.all.size(); j++) {
/* 60 */       DISEASE dd = (DISEASE)s.all.get(j);
/* 61 */       if (dd.epidemic) {
/*    */         
/* 63 */         d += dd.occurence();
/* 64 */         if (d >= lim)
/* 65 */           return dd; 
/*    */       } 
/* 67 */     }  return (DISEASE)s.all.get(s.all.size() - 1);
/*    */   }
/*    */   
/*    */   public static DISEASE randomRegular() {
/* 71 */     double lim = 0.0D;
/* 72 */     for (int i = 0; i < s.all.size(); i++) {
/* 73 */       DISEASE dd = (DISEASE)s.all.get(i);
/* 74 */       if (dd.regular)
/*    */       {
/* 76 */         lim += dd.occurence(); } 
/*    */     } 
/* 78 */     lim *= RND.rFloat();
/* 79 */     double d = 0.0D;
/* 80 */     for (int j = 0; j < s.all.size(); j++) {
/* 81 */       DISEASE dd = (DISEASE)s.all.get(j);
/* 82 */       if (dd.regular) {
/*    */         
/* 84 */         d += dd.occurence();
/* 85 */         if (d >= lim)
/* 86 */           return dd; 
/*    */       } 
/* 88 */     }  return (DISEASE)s.all.get(s.all.size() - 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\DISEASES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */