/*    */ package init.sprite.UI;
/*    */ 
/*    */ import init.INIT;
/*    */ import java.io.IOException;
/*    */ import util.colors.GCOLOR;
/*    */ 
/*    */ 
/*    */ public class UI
/*    */   extends INIT.InitResource
/*    */ {
/*    */   private static UIDecor decor;
/*    */   private static UIPanels panels;
/*    */   private static UIFonts fonts;
/*    */   private static Icons icons;
/*    */   private static UIImageMaker image;
/*    */   
/*    */   public UI(INIT init) throws IOException {
/* 18 */     super(init);
/* 19 */     GCOLOR.read();
/* 20 */     fonts = new UIFonts();
/* 21 */     panels = new UIPanels();
/* 22 */     decor = new UIDecor();
/* 23 */     icons = new Icons();
/* 24 */     image = new UIImageMaker();
/*    */   }
/*    */   
/*    */   public static UIFonts FONT() {
/* 28 */     return fonts;
/*    */   }
/*    */   
/*    */   public static UIPanels PANEL() {
/* 32 */     return panels;
/*    */   }
/*    */   
/*    */   public static UIDecor decor() {
/* 36 */     return decor;
/*    */   }
/*    */   
/*    */   public static Icons icons() {
/* 40 */     return icons;
/*    */   }
/*    */   
/*    */   public static UIImageMaker image() {
/* 44 */     return image;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */