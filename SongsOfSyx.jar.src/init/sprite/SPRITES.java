/*    */ package init.sprite;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.sprite.UI.Icons;
/*    */ import init.sprite.UI.UI;
/*    */ import init.sprite.UI.UIConses;
/*    */ import init.sprite.UI.UISpecials;
/*    */ import init.sprite.game.GameSheets;
/*    */ import java.io.IOException;
/*    */ import snake2d.CORE;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPRITES
/*    */ {
/*    */   private static SPRITES self;
/*    */   private final UIConses panelsOverlays;
/*    */   private final Textures textures;
/*    */   private final SPRITE loadScreen;
/*    */   private final UISpecials specials;
/*    */   private final GameSheets game;
/*    */   private final RLoadPrinter loader;
/*    */   
/*    */   public SPRITES(GAME gameg) throws IOException {
/* 31 */     self = this;
/* 32 */     CORE.checkIn();
/*    */     
/* 34 */     CORE.checkIn();
/*    */     
/* 36 */     this.panelsOverlays = new UIConses();
/* 37 */     this.loadScreen = UI.image().get("_LoadScreen", null, null);
/* 38 */     CORE.checkIn();
/* 39 */     this.specials = new UISpecials();
/* 40 */     CORE.checkIn();
/* 41 */     this.textures = new Textures();
/* 42 */     this.game = new GameSheets();
/* 43 */     this.loader = new RLoadPrinter();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final class COLOR_REMOVE
/*    */   {
/*    */     public static void bad2Good(ColorImp c, double d) {
/* 54 */       if (d < 0.0D)
/* 55 */         d = 0.0D; 
/* 56 */       if (d > 1.0D)
/* 57 */         d = 1.0D; 
/* 58 */       double r = (d > 0.5D) ? (1.0D - (d - 0.5D) * 2.0D) : 1.0D;
/* 59 */       double g = (d < 0.5D) ? (d * 2.0D) : 1.0D;
/* 60 */       c.set(30 + (int)(70.0D * r), 30 + (int)(70.0D * g), 30);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static Icons icons() {
/* 66 */     return UI.icons();
/*    */   }
/*    */   
/*    */   public static UIConses cons() {
/* 70 */     return self.panelsOverlays;
/*    */   }
/*    */   
/*    */   public static SPRITE loadScreen() {
/* 74 */     return self.loadScreen;
/*    */   }
/*    */   
/*    */   public static UISpecials specials() {
/* 78 */     return self.specials;
/*    */   }
/*    */   
/*    */   public static Textures textures() {
/* 82 */     return self.textures;
/*    */   }
/*    */   
/*    */   public static GameSheets GAME() {
/* 86 */     return self.game;
/*    */   }
/*    */   
/*    */   public static RLoadPrinter loader() {
/* 90 */     return self.loader;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\SPRITES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */