/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TileTexture;
/*     */ import util.rendering.RenderData;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class WorldWaterSprites
/*     */ {
/*  24 */   public final TILE_SHEET bg = (new ComposerThings.ITileSheet(PATHS.SPRITE_WORLD_MAP().get("Water"), 576, 272)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  28 */         ComposerDests.Tile t = d.s16;
/*  29 */         s.house.init(0, 0, 4, 1, (ComposerDests.Dest)t);
/*     */         
/*  31 */         for (int i = 0; i < 4; i++)
/*  32 */           s.house.setVar(i).paste(1, true); 
/*  33 */         return t.saveGame();
/*     */       }
/*  36 */     }).get();
/*     */   
/*  38 */   public final TILE_SHEET bgSingles = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  42 */         s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/*  43 */         s.full.paste(true);
/*  44 */         return d.s16.saveGame();
/*     */       }
/*  46 */     }).get();
/*     */   
/*  48 */   public final TILE_SHEET sheet = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  53 */         s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/*     */         
/*  55 */         for (int i = 0; i < 4; i++)
/*  56 */           s.house.setVar(i).paste(1, true); 
/*  57 */         return d.s16.saveGame();
/*     */       }
/*  60 */     }).get();
/*     */   
/*  62 */   public final TILE_SHEET sheetCorners = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  66 */         s.house.setVar(0).setSkip(0, 1).pasteEdges(true);
/*  67 */         return d.s16.saveGame();
/*     */       }
/*  70 */     }).get();
/*     */   
/*  72 */   public final TILE_SHEET sheetSingles = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  76 */         s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/*  77 */         s.full.paste(true);
/*  78 */         return d.s16.saveGame();
/*     */       }
/*  80 */     }).get();
/*     */   
/*  82 */   public final TILE_SHEET deep = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*  85 */         s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/*     */         
/*  87 */         for (int i = 0; i < 4; i++)
/*  88 */           s.house.setVar(i).paste(1, true); 
/*  89 */         return d.s16.saveGame();
/*     */       }
/*  91 */     }).get();
/*     */   
/*  93 */   public final TILE_SHEET riverBG = (new ComposerThings.ITileSheet(PATHS.SPRITE_WORLD().getFolder("map").get("RiverBig"), 576, 172)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  97 */         ComposerDests.Tile t = d.s16;
/*  98 */         s.house.init(0, 0, 4, 1, (ComposerDests.Dest)t);
/*     */         
/* 100 */         for (int i = 0; i < 4; i++)
/* 101 */           s.house.setVar(i).paste(1, true); 
/* 102 */         return t.saveGame();
/*     */       }
/* 105 */     }).get();
/*     */   
/* 107 */   public final TILE_SHEET riverFG = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 111 */         ComposerDests.Tile t = d.s16;
/* 112 */         s.house.init(0, s.house.body().y2(), 4, 1, (ComposerDests.Dest)t);
/*     */         
/* 114 */         for (int i = 0; i < 4; i++)
/* 115 */           s.house.setVar(i).paste(1, true); 
/* 116 */         return t.saveGame();
/*     */       }
/* 119 */     }).get();
/*     */   
/* 121 */   public final TILE_SHEET deltaShore = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 125 */         ComposerDests.Tile t = d.s16;
/* 126 */         s.singles.init(0, s.house.body().y2(), 1, 1, 4, 1, (ComposerDests.Dest)t);
/* 127 */         for (int i = 0; i < 4; i++) {
/* 128 */           s.singles.setSkip(i, 1).paste(3, true);
/*     */         }
/* 130 */         return t.saveGame();
/*     */       }
/* 132 */     }).get();
/*     */   
/* 134 */   public final TILE_SHEET delta = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 138 */         ComposerDests.Tile t = d.s16;
/* 139 */         s.singles.init(s.singles.body().x2(), s.singles.body().y1(), 1, 1, 4, 1, (ComposerDests.Dest)t);
/* 140 */         for (int i = 0; i < 4; i++) {
/* 141 */           s.singles.setSkip(i, 1).paste(3, true);
/*     */         }
/* 143 */         return t.saveGame();
/*     */       }
/* 145 */     }).get();
/*     */   
/* 147 */   public final TILE_SHEET riverSmallBG = (new ComposerThings.ITileSheet(PATHS.SPRITE_WORLD().getFolder("map").get("RiverSmall"), 576, 144)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 151 */         ComposerDests.Tile t = d.s16;
/* 152 */         s.house.init(0, 0, 4, 1, (ComposerDests.Dest)t);
/*     */         
/* 154 */         for (int i = 0; i < 4; i++)
/* 155 */           s.house.setVar(i).paste(1, true); 
/* 156 */         return t.saveGame();
/*     */       }
/* 159 */     }).get();
/*     */   
/* 161 */   public final TILE_SHEET riverSmallFG = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 165 */         ComposerDests.Tile t = d.s16;
/* 166 */         s.house.init(0, s.house.body().y2(), 4, 1, (ComposerDests.Dest)t);
/*     */         
/* 168 */         for (int i = 0; i < 4; i++)
/* 169 */           s.house.setVar(i).paste(1, true); 
/* 170 */         return t.saveGame();
/*     */       }
/* 173 */     }).get();
/*     */ 
/*     */   
/*     */   private final TileTexture.TileTextureScroller dis1;
/*     */   
/*     */   private final TileTexture.TileTextureScroller dis2;
/*     */   private final TileTexture.TileTextureScroller tex1;
/*     */   
/*     */   public void renderBackground(SPRITE_RENDERER r, RenderData.RenderIterator it, int rot, int corner) {
/* 182 */     if (rot == 0) {
/* 183 */       this.bgSingles.render(r, it.ran() & 0xF, it.x(), it.y());
/* 184 */     } else if (rot != 15 && corner != 15) {
/* 185 */       this.bg.render(r, 16 * (it.ran() & 0x7) + rot, it.x(), it.y());
/*     */     } 
/*     */   }
/*     */   private final TileTexture.TileTextureScroller tex2; private final OpacityImp o1; private final OpacityImp o2;
/*     */   public void render(SPRITE_RENDERER r, RenderData.RenderIterator it, int rot, int corner) {
/* 190 */     if (rot == 0) {
/* 191 */       this.sheetSingles.render(r, it.ran() & 0xF, it.x(), it.y());
/*     */     } else {
/* 193 */       this.sheet.render(r, 16 * (it.ran() & 0x7) + rot, it.x(), it.y());
/* 194 */       this.sheetCorners.render(r, corner, it.x(), it.y());
/*     */     } 
/* 196 */     renderTexture(it);
/*     */   }
/*     */   
/*     */   public void renderDeep(SPRITE_RENDERER r, RenderData.RenderIterator it, int rot) {
/* 200 */     this.deep.render(r, 16 * (it.ran() & 0x3) + rot, it.x(), it.y());
/* 201 */     renderTexture(it);
/*     */   }
/*     */   
/*     */   public WorldWaterSprites() throws IOException {
/* 205 */     this.dis1 = (SPRITES.textures()).dis_tiny.scroller(1.5D, 1.5D);
/* 206 */     this.dis2 = (SPRITES.textures()).dis_small.scroller(-2.0D, -2.0D);
/* 207 */     this.tex1 = (SPRITES.textures()).water.scroller(-1.0D, 1.0D);
/* 208 */     this.tex2 = (SPRITES.textures()).bumps.scroller(2.0D, 2.0D);
/* 209 */     this.o1 = new OpacityImp(25);
/* 210 */     this.o2 = new OpacityImp(51);
/*     */   }
/*     */   void update(double ds) {
/* 213 */     this.dis1.update(ds);
/* 214 */     this.dis2.update(ds);
/* 215 */     this.tex1.update(ds);
/* 216 */     this.tex2.update(ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTexture(RenderData.RenderIterator i) {
/* 222 */     this.o2.bind();
/*     */ 
/*     */     
/* 225 */     COLOR c = CORE.renderer().colorGet();
/* 226 */     COLOR.unbind();
/*     */     
/* 228 */     CORE.renderer().renderDisplace(
/* 229 */         this.dis1.x1(i.tx()), this.dis1.y1(i.ty()), this.tex1.x1(i.tx()), this.tex1.y1(i.ty()), 16, 16, 8.0D, i.x(), i.x() + 64, i.y(), i.y() + 64);
/*     */     
/* 231 */     c.bind();
/* 232 */     this.o1.bind();
/* 233 */     CORE.renderer().renderDisplace(
/* 234 */         this.dis2.x1(i.tx()), this.dis2.y1(i.ty()), this.tex2.x1(i.tx()), this.tex2.y1(i.ty()), 16, 16, 4.0D, i.x(), i.x() + 64, i.y(), i.y() + 64);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     OPACITY.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldWaterSprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */