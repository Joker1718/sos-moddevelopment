/*    */ package view.sett;
/*    */ 
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ 
/*    */ public final class UISettMap
/*    */ {
/*  9 */   private static final KeyMap<RENDEROBJ> map = new KeyMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void clear() {
/* 16 */     map.clear();
/*    */   }
/*    */   
/*    */   public static void add(RENDEROBJ o, String key) {
/* 20 */     map.put(key, o);
/*    */   }
/*    */   
/*    */   public static RENDEROBJ getByKey(String key) {
/* 24 */     if (!map.containsKey(key))
/* 25 */       for (String s : map.keysSorted()) {
/* 26 */         LOG.ln(s);
/*    */       } 
/* 28 */     return (RENDEROBJ)map.get(key);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\UISettMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */