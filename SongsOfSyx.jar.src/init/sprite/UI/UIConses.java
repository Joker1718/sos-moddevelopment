/*     */ package init.sprite.UI;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
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
/*     */ public class UIConses
/*     */ {
/*  33 */   public final Small TINY = new Small();
/*  34 */   public final Big BIG = new Big();
/*     */   
/*  36 */   public final Icons ICO = new Icons();
/*  37 */   public final Rotaters ROT = new Rotaters();
/*  38 */   public final TILE_SHEET fullArrows = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*  41 */         s.singles.init(0, s.singles.body().y2(), 1, 1, 1, 1, (ComposerDests.Dest)d.s16);
/*  42 */         s.singles.paste(3, true);
/*  43 */         s.combo.init(s.singles.body().x2(), s.singles.body().y1(), 1, 1, 2, (ComposerDests.Dest)d.s16);
/*  44 */         s.combo.paste(3, true);
/*  45 */         s.combo.init(s.combo.body().x2(), s.singles.body().y1(), 1, 1, 3, (ComposerDests.Dest)d.s16);
/*  46 */         s.combo.paste(3, true);
/*  47 */         return d.s16.saveGame();
/*     */       }
/*  50 */     }).get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Small
/*     */   {
/*  63 */     public final UICons high = new UICons((new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  67 */             s.house.init(0, 0, 7, 1, (ComposerDests.Dest)d.s8);
/*  68 */             s.house.setVar(0).paste(true);
/*  69 */             return d.s8.save(8);
/*     */           }
/*  71 */         }).get());
/*  72 */     public final UICons low = getTiny(1);
/*  73 */     public final UICons flat = getTiny(2);
/*  74 */     public final UICons outline = getTiny(3);
/*  75 */     public final UICons dashed = getTiny(4);
/*  76 */     public final UICons full = getTiny(5);
/*  77 */     public final UICons dots = getTiny(6);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private UICons getTiny(final int nr) throws IOException {
/*  85 */       return new UICons((new ComposerThings.ITileSheet()
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/*  89 */               s.house.setVar(nr).paste(true);
/*  90 */               return d.s8.save(8);
/*     */             }
/*  92 */           }).get());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final class Big
/*     */   {
/* 100 */     public final UICons outline = new UICons((new ComposerThings.ITileSheet()
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
/* 112 */         }).get(), UIConses.this.TINY.outline);
/* 113 */     public final UICons dashed = getSmall(1, UIConses.this.TINY.dashed);
/* 114 */     public final UICons dashedThick = getSmall(2, UIConses.this.TINY.dashed);
/* 115 */     public final UICons solid = getSmall(3, UIConses.this.TINY.full);
/* 116 */     public final UICons dots = getSmall(4, UIConses.this.TINY.dots);
/* 117 */     public final UICons line = getSmall(5, UIConses.this.TINY.dashed);
/* 118 */     public final UICons dashed_hollow = getSmall(7, UIConses.this.TINY.dashed);
/*     */     
/* 120 */     public final UICons filled = getSmall(9, UIConses.this.TINY.full);
/*     */     
/* 122 */     public final UICons filled_striped = getSmall(11, UIConses.this.TINY.full);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private UICons getSmall(final int nr, UICons tiny) throws IOException {
/* 130 */       return new UICons((new ComposerThings.ITileSheet()
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 134 */               s.house.setVar(nr).paste(true);
/* 135 */               s.singles.setSkip(nr, 1);
/* 136 */               s.singles.pasteEdges(true);
/* 137 */               return d.s16.saveGame();
/*     */             }
/* 141 */           }).get(), tiny);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final class Icons
/*     */   {
/* 150 */     public final SPRITE unclear = ComposerThings.ISprite.game((new ComposerThings.ISpriteData()
/*     */         {
/*     */           protected SpriteData init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 154 */             s.singles.init(0, s.singles.body().y2(), 1, 1, 19, 1, (ComposerDests.Dest)d.s16);
/* 155 */             s.singles.setSkip(0, 1).paste(true);
/* 156 */             return d.s16.saveSprite();
/*     */           }
/* 159 */         }).get());
/* 160 */     public final SPRITE clear = getS(1);
/* 161 */     public final SPRITE cancel = getS(2);
/*     */ 
/*     */     
/* 164 */     public final LIST<SPRITE> arrows = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */         {
/*     */           protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 168 */             s.singles.setSkip(3, 1).pasteRotated(i, true);
/* 169 */             return d.s16.saveSprite();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 174 */             return 4;
/*     */           }
/* 177 */         }).get());
/* 178 */     public final LIST<SPRITE> arrows2 = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */         {
/*     */           protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 182 */             s.singles.setSkip(4 + (i & 0x1), 1).pasteRotated(i / 2, true);
/* 183 */             return d.s16.saveSprite();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 188 */             return 8;
/*     */           }
/* 191 */         }).get());
/* 192 */     public final SPRITE crosshair = getS(6);
/* 193 */     public final SPRITE smallup = getS(7);
/* 194 */     public final SPRITE repair = getS(8);
/* 195 */     public final SPRITE arrows_inward = getS(9);
/* 196 */     public final SPRITE warning = getS(10);
/* 197 */     public final SPRITE tile = getS(11);
/* 198 */     public final SPRITE scratch = getS(12);
/* 199 */     public final LIST<SPRITE> arrows_inwards = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */         {
/*     */           protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 203 */             s.singles.setSkip(13, 1).pasteRotated(i, true);
/* 204 */             return d.s16.saveSprite();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 209 */             return 4;
/*     */           }
/* 212 */         }).get());
/*     */     public final LIST<SPRITE> arrows_entity;
/*     */     
/*     */     private Icons() throws IOException {
/* 216 */       LIST<SPRITE> li = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */           {
/*     */             protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 220 */               s.singles.setSkip(14, 1).pasteRotated(i, true);
/* 221 */               return d.s16.saveSprite();
/*     */             }
/*     */ 
/*     */             
/*     */             protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 226 */               return 4;
/*     */             }
/* 229 */           }).get());
/* 230 */       LIST<SPRITE> l2 = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */           {
/*     */             protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 234 */               s.singles.setSkip(14, 1).pasteRotated(i, true);
/* 235 */               return d.s16.saveSprite();
/*     */             }
/*     */ 
/*     */             
/*     */             protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 240 */               return 4;
/*     */             }
/* 243 */           }).get());
/* 244 */       ArrayList<SPRITE> ea = new ArrayList(8);
/* 245 */       for (int i = 0; i < 4; i++) {
/* 246 */         ea.add(li.get(i));
/* 247 */         ea.add(l2.get(i));
/*     */       } 
/* 249 */       this.arrows_entity = (LIST<SPRITE>)ea;
/*     */     }
/*     */ 
/*     */     
/*     */     private SPRITE getS(final int nr) throws IOException {
/* 254 */       return ComposerThings.ISprite.game((new ComposerThings.ISpriteData()
/*     */           {
/*     */             protected SpriteData init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 258 */               s.singles.setSkip(nr, 1).paste(true);
/* 259 */               return d.s16.saveSprite();
/*     */             }
/* 262 */           }).get());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final class Rotaters
/*     */   {
/* 271 */     public final LIST<SPRITE> single = ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */         {
/*     */           protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 275 */             s.singles.setSkip(0, 1).pasteRotated(i, true);
/* 276 */             return d.s16.saveSprite();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 281 */             s.singles.init(0, s.singles.body().y2(), 1, 1, 8, 1, (ComposerDests.Dest)d.s16);
/* 282 */             return 4;
/*     */           }
/* 285 */         }).get());
/* 286 */     public final LIST<SPRITE> join = getS(1);
/* 287 */     public final LIST<SPRITE> join_thin = getS(2);
/* 288 */     public final LIST<SPRITE> north_south = getS(3);
/* 289 */     public final LIST<SPRITE> full = getS(4);
/* 290 */     public final LIST<SPRITE> join_big = getS(5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private LIST<SPRITE> getS(final int nr) throws IOException {
/* 300 */       return ComposerThings.ISprite.game((new ComposerThings.ISpriteList()
/*     */           {
/*     */             protected SpriteData next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 304 */               s.singles.setSkip(nr, 1).pasteRotated(i, true);
/* 305 */               return d.s16.saveSprite();
/*     */             }
/*     */ 
/*     */             
/*     */             protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 310 */               return 4;
/*     */             }
/* 313 */           }).get());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIConses.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */