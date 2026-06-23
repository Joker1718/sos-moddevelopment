/*    */ package init.constant;
/*    */ 
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class C
/*    */ {
/*    */   public static final int STEAM_ID = 1162750;
/*    */   public static final int MAX_SPRITES = 65536;
/*    */   public static final String NAME = "Songs of Syx";
/*    */   public static final int SCALE = 4;
/*    */   public static final int SCALE_NORMAL = 2;
/*    */   public static final int SG = 1;
/*    */   public static final int GM = 24;
/*    */   public static final int T_PIXELS = 16;
/*    */   public static final int T_SCROLL = 6;
/*    */   public static final int TILE_SIZE = 64;
/*    */   public static final double ITILE_SIZE = 0.015625D;
/*    */   public static final int TILE_SIZEH = 32;
/*    */   public static final int T_MASK = 63;
/* 27 */   private static int WIDTH = 1280;
/* 28 */   private static int HEIGHT = 768;
/*    */ 
/*    */   
/*    */   public static final int MIN_WIDTH = 1280;
/*    */   
/*    */   public static final int MIN_HEIGHT = 768;
/*    */   
/*    */   public static final int MAX_SCREEN_AREA = 2700000;
/*    */   
/* 37 */   private static final Rec DIM = new Rec(0.0D, WIDTH, 0.0D, HEIGHT);
/*    */ 
/*    */   
/* 40 */   public static final double SQR2 = Math.sqrt(2.0D);
/* 41 */   public static final double SQR2I = 1.0D / Math.sqrt(2.0D);
/*    */   public static final String WEB_PAGE = "https://songsofsyx.com";
/*    */   public static final String BUG_MAIL = "info@songsofsyx.com";
/*    */   
/*    */   public static int WIDTH() {
/* 46 */     return WIDTH;
/*    */   }
/*    */   
/*    */   public static int HEIGHT() {
/* 50 */     return HEIGHT;
/*    */   }
/*    */   
/*    */   public static RECTANGLE DIM() {
/* 54 */     return (RECTANGLE)DIM;
/*    */   }
/*    */   
/*    */   public static void init(int width, int height) {
/* 58 */     WIDTH = width;
/* 59 */     HEIGHT = height;
/* 60 */     DIM.set(0.0D, WIDTH, 0.0D, HEIGHT);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\constant\C.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */