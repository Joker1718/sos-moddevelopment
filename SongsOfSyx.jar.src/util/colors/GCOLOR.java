/*    */ package util.colors;
/*    */ 
/*    */ public class GCOLOR
/*    */ {
/*    */   private static GCOLOR_TEXT text;
/*    */   private static GCOLOR_UI ui;
/*    */   private static COLOR_MAP map;
/*    */   
/*    */   public static GCOLOR_TEXT T() {
/* 10 */     return text;
/*    */   }
/*    */   
/*    */   public static GCOLOR_UI UI() {
/* 14 */     return ui;
/*    */   }
/*    */   
/*    */   public static COLOR_MAP MAP() {
/* 18 */     return map;
/*    */   }
/*    */   
/*    */   public static void read() {
/* 22 */     text = new GCOLOR_TEXT();
/* 23 */     ui = new GCOLOR_UI();
/* 24 */     map = new COLOR_MAP();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\colors\GCOLOR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */