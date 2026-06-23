/*     */ package init.sprite.UI;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.spritecomposer.SpriteData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Icons
/*     */ {
/* 150 */   public final SPRITE unclear = ComposerThings.ISprite.game((new ComposerThings.ISpriteData()
/*     */       {
/*     */         protected SpriteData init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 154 */           s.singles.init(0, s.singles.body().y2(), 1, 1, 19, 1, (ComposerDests.Dest)d.s16);
/* 155 */           s.singles.setSkip(0, 1).paste(true);
/* 156 */           return d.s16.saveSprite();
/*     */         }
/* 159 */       }).get());
/* 160 */   public final SPRITE clear = getS(1);
/* 161 */   public final SPRITE cancel = getS(2);
/*     */ 
/*     */   
/* 164 */   public final LIST<SPRITE> arrows = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */       {
/*     */         protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 168 */           s.singles.setSkip(3, 1).pasteRotated(i, true);
/* 169 */           return d.s16.saveSprite();
/*     */         }
/*     */ 
/*     */         
/*     */         protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 174 */           return 4;
/*     */         }
/* 177 */       }).get());
/* 178 */   public final LIST<SPRITE> arrows2 = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */       {
/*     */         protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 182 */           s.singles.setSkip(4 + (i & 0x1), 1).pasteRotated(i / 2, true);
/* 183 */           return d.s16.saveSprite();
/*     */         }
/*     */ 
/*     */         
/*     */         protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 188 */           return 8;
/*     */         }
/* 191 */       }).get());
/* 192 */   public final SPRITE crosshair = getS(6);
/* 193 */   public final SPRITE smallup = getS(7);
/* 194 */   public final SPRITE repair = getS(8);
/* 195 */   public final SPRITE arrows_inward = getS(9);
/* 196 */   public final SPRITE warning = getS(10);
/* 197 */   public final SPRITE tile = getS(11);
/* 198 */   public final SPRITE scratch = getS(12);
/* 199 */   public final LIST<SPRITE> arrows_inwards = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */       {
/*     */         protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 203 */           s.singles.setSkip(13, 1).pasteRotated(i, true);
/* 204 */           return d.s16.saveSprite();
/*     */         }
/*     */ 
/*     */         
/*     */         protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 209 */           return 4;
/*     */         }
/* 212 */       }).get());
/*     */   public final LIST<SPRITE> arrows_entity;
/*     */   
/*     */   private Icons() throws IOException {
/* 216 */     LIST<SPRITE> li = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */         {
/*     */           protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 220 */             s.singles.setSkip(14, 1).pasteRotated(i, true);
/* 221 */             return d.s16.saveSprite();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 226 */             return 4;
/*     */           }
/* 229 */         }).get());
/* 230 */     LIST<SPRITE> l2 = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */         {
/*     */           protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 234 */             s.singles.setSkip(14, 1).pasteRotated(i, true);
/* 235 */             return d.s16.saveSprite();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 240 */             return 4;
/*     */           }
/* 243 */         }).get());
/* 244 */     ArrayList<SPRITE> ea = new ArrayList(8);
/* 245 */     for (int i = 0; i < 4; i++) {
/* 246 */       ea.add(li.get(i));
/* 247 */       ea.add(l2.get(i));
/*     */     } 
/* 249 */     this.arrows_entity = (LIST<SPRITE>)ea;
/*     */   }
/*     */ 
/*     */   
/*     */   private SPRITE getS(final int nr) throws IOException {
/* 254 */     return ComposerThings.ISprite.game((new ComposerThings.ISpriteData()
/*     */         {
/*     */           protected SpriteData init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 258 */             s.singles.setSkip(nr, 1).paste(true);
/* 259 */             return d.s16.saveSprite();
/*     */           }
/* 262 */         }).get());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIConses$Icons.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */