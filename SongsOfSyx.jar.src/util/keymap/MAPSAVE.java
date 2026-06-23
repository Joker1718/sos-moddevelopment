/*    */ package util.keymap;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ public class MAPSAVE
/*    */ {
/*    */   public static void saveMeta(FilePutter saveFile, LIST<? extends MAPPED> all) {
/* 15 */     saveFile.i(all.size());
/* 16 */     for (MAPPED j : all) {
/* 17 */       saveFile.chars(j.key());
/*    */     }
/*    */   }
/*    */   
/*    */   public static int[] saveWash(FileGetter f, LIST<? extends MAPPED> all, int nothingReplacer) throws IOException {
/* 22 */     int j, am = f.i();
/* 23 */     int[] order = Alloc.ii(am);
/* 24 */     KeyMap<MAPPED> map = new KeyMap();
/*    */     
/* 26 */     for (MAPPED t : all) {
/* 27 */       map.put(t.key(), t);
/*    */     }
/*    */     
/* 30 */     Arrays.fill(order, nothingReplacer);
/* 31 */     boolean different = false;
/* 32 */     for (int i = 0; i < am; i++) {
/* 33 */       String k = f.chars();
/*    */       
/* 35 */       order[i] = map.containsKey(k) ? ((MAPPED)map.get(k)).index() : nothingReplacer;
/* 36 */       j = different | ((order[i] != i) ? 1 : 0);
/*    */     } 
/* 38 */     if (j == 0)
/* 39 */       return null; 
/* 40 */     return order;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\MAPSAVE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */