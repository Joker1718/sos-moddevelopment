/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
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
/*     */ public abstract class ITileSheetL
/*     */ {
/*     */   protected ITileSheetL() {}
/*     */   
/*     */   protected ITileSheetL(Path path, int width, int height) throws IOException {
/* 158 */     Resources.c.setSource(path, width, height);
/*     */   }
/*     */   
/*     */   public LIST<TILE_SHEET> get() throws IOException {
/* 162 */     if (Resources.g == null) {
/* 163 */       Resources.p.mark("list");
/* 164 */       int j = init(Resources.c, Resources.sources, Resources.dests);
/* 165 */       Resources.p.i(j);
/* 166 */       ArrayList<TILE_SHEET> arrayList = new ArrayList(j);
/* 167 */       for (int k = 0; k < j; k++) {
/* 168 */         arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests));
/*     */       }
/* 170 */       Resources.p.mark("list");
/* 171 */       return (LIST<TILE_SHEET>)arrayList;
/*     */     } 
/*     */     
/* 174 */     Resources.g.check("list");
/* 175 */     int a = Resources.g.i();
/* 176 */     ArrayList<TILE_SHEET> res = new ArrayList(a);
/* 177 */     for (int i = 0; i < a; i++) {
/* 178 */       res.add(ComposerThings.ITileSheet.read(Resources.g));
/*     */     }
/* 180 */     Resources.g.check("list");
/* 181 */     return (LIST<TILE_SHEET>)res;
/*     */   }
/*     */   
/*     */   protected abstract int init(ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*     */   
/*     */   protected abstract TILE_SHEET next(int paramInt, ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings$ITileSheetL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */