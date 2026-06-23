/*    */ package tools.tmp;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.util.List;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ 
/*    */ 
/*    */ public class WorkFulfillments
/*    */ {
/* 13 */   private static KeyMap<String> tmp = new KeyMap();
/*    */ 
/*    */   
/*    */   public static void main(String[] args) throws IOException {
/* 17 */     File root = new File("C:\\Users\\jakob\\Desktop\\jakob\\syx\\code\\syx71\\Syx\\tool\\tmp\\Fulfillments.csv");
/*    */     
/* 19 */     List<String> tt = Files.readAllLines(root.toPath());
/*    */     
/* 21 */     ArrayListGrower<ArrayListGrower<String>> all = new ArrayListGrower();
/* 22 */     String[] races = { "Cretonian", "Dondorian", "Garthimi", "Human", "Amevia", "Tilapi", "Argonosh", "Cantor" }; byte b; int j; String[] arrayOfString1;
/* 23 */     for (j = (arrayOfString1 = races).length, b = 0; b < j; ) { String r = arrayOfString1[b];
/* 24 */       all.add(new ArrayListGrower()); b++; }
/*    */     
/* 26 */     boolean first = true;
/* 27 */     for (String l : tt) {
/* 28 */       if (first) {
/* 29 */         first = false;
/*    */         continue;
/*    */       } 
/* 32 */       String[] ss = l.split(",");
/* 33 */       if (ss[0].length() == 0)
/*    */         continue; 
/* 35 */       String room = ss[0];
/* 36 */       room = room.replace("__", "_");
/* 37 */       System.out.println(l);
/*    */       
/* 39 */       double def = value(ss[2]);
/* 40 */       System.out.println(room + " " + room);
/*    */       
/* 42 */       for (int k = 0; k < races.length; k++) {
/* 43 */         double v = value(ss[3 + k]);
/* 44 */         if (v != def) {
/* 45 */           ((ArrayListGrower)all.get(k)).add(room + ": " + room + ",");
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 53 */     for (int i = 0; i < races.length; i++) {
/* 54 */       System.out.println(races[i]);
/* 55 */       for (String s : all.get(i)) {
/* 56 */         System.out.println(s);
/*    */       }
/* 58 */       System.out.println();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static double value(String s) {
/* 65 */     s = s.replace("%", "");
/* 66 */     double d = Integer.parseInt(s);
/* 67 */     d /= 100.0D;
/* 68 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\tmp\WorkFulfillments.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */