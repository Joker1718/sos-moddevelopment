/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ public abstract class ITileSpriteL
/*     */ {
/*     */   public LIST<TILE_SHEET> get() throws IOException {
/* 195 */     if (Resources.g == null) {
/* 196 */       Resources.p.mark("list");
/* 197 */       int j = init(Resources.c, Resources.sources, Resources.dests);
/* 198 */       Resources.p.i(j);
/* 199 */       ArrayList<TILE_SHEET> arrayList = new ArrayList(j);
/* 200 */       for (int k = 0; k < j; k++) {
/* 201 */         arrayList.add(next(k, Resources.c, Resources.sources, Resources.dests));
/*     */       }
/* 203 */       Resources.p.mark("list");
/* 204 */       return (LIST<TILE_SHEET>)arrayList;
/*     */     } 
/*     */     
/* 207 */     Resources.g.check("list");
/* 208 */     int a = Resources.g.i();
/* 209 */     ArrayList<TILE_SHEET> res = new ArrayList(a);
/* 210 */     for (int i = 0; i < a; i++) {
/* 211 */       res.add(ComposerThings.ITileSheet.read(Resources.g));
/*     */     }
/* 213 */     Resources.g.check("list");
/* 214 */     return (LIST<TILE_SHEET>)res;
/*     */   }
/*     */   
/*     */   protected abstract int init(ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*     */   
/*     */   protected abstract TILE_SHEET next(int paramInt, ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings$ITileSpriteL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */