/*    */ package init.sprite.UI;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Small
/*    */ {
/* 63 */   public final UICons high = new UICons((new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 67 */           s.house.init(0, 0, 7, 1, (ComposerDests.Dest)d.s8);
/* 68 */           s.house.setVar(0).paste(true);
/* 69 */           return d.s8.save(8);
/*    */         }
/* 71 */       }).get());
/* 72 */   public final UICons low = getTiny(1);
/* 73 */   public final UICons flat = getTiny(2);
/* 74 */   public final UICons outline = getTiny(3);
/* 75 */   public final UICons dashed = getTiny(4);
/* 76 */   public final UICons full = getTiny(5);
/* 77 */   public final UICons dots = getTiny(6);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private UICons getTiny(final int nr) throws IOException {
/* 85 */     return new UICons((new ComposerThings.ITileSheet()
/*    */         {
/*    */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */           {
/* 89 */             s.house.setVar(nr).paste(true);
/* 90 */             return d.s8.save(8);
/*    */           }
/* 92 */         }).get());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIConses$Small.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */