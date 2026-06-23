/*     */ package init.sprite.UI;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Big
/*     */ {
/*     */   public final UICons outline;
/*     */   public final UICons dashed;
/*     */   public final UICons dashedThick;
/*     */   public final UICons solid;
/*     */   public final UICons dots;
/*     */   public final UICons line;
/*     */   public final UICons dashed_hollow;
/*     */   public final UICons filled;
/*     */   public final UICons filled_striped;
/*     */   
/*     */   private Big() throws IOException {
/* 100 */     this.outline = new UICons((new ComposerThings.ITileSheet()
/*     */         {
/*     */           
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 105 */             s.house.init(0, s.house.body().y2(), 7, 2, (ComposerDests.Dest)d.s16);
/* 106 */             s.singles.init(0, s.house.body().y2(), 1, 1, 16, 1, (ComposerDests.Dest)d.s16);
/* 107 */             s.house.setVar(0).paste(true);
/* 108 */             s.singles.setSkip(0, 1);
/* 109 */             s.singles.pasteEdges(true);
/* 110 */             return d.s16.saveGame();
/*     */           }
/* 112 */         }).get(), paramUIConses.TINY.outline);
/* 113 */     this.dashed = getSmall(1, paramUIConses.TINY.dashed);
/* 114 */     this.dashedThick = getSmall(2, paramUIConses.TINY.dashed);
/* 115 */     this.solid = getSmall(3, paramUIConses.TINY.full);
/* 116 */     this.dots = getSmall(4, paramUIConses.TINY.dots);
/* 117 */     this.line = getSmall(5, paramUIConses.TINY.dashed);
/* 118 */     this.dashed_hollow = getSmall(7, paramUIConses.TINY.dashed);
/*     */     
/* 120 */     this.filled = getSmall(9, paramUIConses.TINY.full);
/*     */     
/* 122 */     this.filled_striped = getSmall(11, paramUIConses.TINY.full);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UICons getSmall(final int nr, UICons tiny) throws IOException {
/* 130 */     return new UICons((new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 134 */             s.house.setVar(nr).paste(true);
/* 135 */             s.singles.setSkip(nr, 1);
/* 136 */             s.singles.pasteEdges(true);
/* 137 */             return d.s16.saveGame();
/*     */           }
/* 141 */         }).get(), tiny);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIConses$Big.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */