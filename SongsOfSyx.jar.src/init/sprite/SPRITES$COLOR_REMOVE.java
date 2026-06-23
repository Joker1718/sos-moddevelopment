/*    */ package init.sprite;
/*    */ 
/*    */ import snake2d.util.color.ColorImp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class COLOR_REMOVE
/*    */ {
/*    */   public static void bad2Good(ColorImp c, double d) {
/* 54 */     if (d < 0.0D)
/* 55 */       d = 0.0D; 
/* 56 */     if (d > 1.0D)
/* 57 */       d = 1.0D; 
/* 58 */     double r = (d > 0.5D) ? (1.0D - (d - 0.5D) * 2.0D) : 1.0D;
/* 59 */     double g = (d < 0.5D) ? (d * 2.0D) : 1.0D;
/* 60 */     c.set(30 + (int)(70.0D * r), 30 + (int)(70.0D * g), 30);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\SPRITES$COLOR_REMOVE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */