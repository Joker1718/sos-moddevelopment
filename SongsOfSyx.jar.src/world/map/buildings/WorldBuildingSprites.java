/*     */ package world.map.buildings;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ public class WorldBuildingSprites
/*     */ {
/*  16 */   private final PATH getter = PATHS.SPRITE().getFolder("world").getFolder("map").getFolder("buildings");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   public final TILE_SHEET garrison = (new ComposerThings.ITileSheet(this.getter.get("Garrison"), 236, 20)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  50 */         s.singles.init(0, 0, 1, 1, 8, 1, (ComposerDests.Dest)d.s8);
/*  51 */         s.singles.paste(3, true);
/*  52 */         return d.s8.saveGame();
/*     */       }
/*  54 */     }).get();
/*     */   
/*  56 */   public final TILE_SHEET terrainStencil = (new ComposerThings.ITileSheet(this.getter.get("TerrainStencil"), 120, 60)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  60 */         s.full.init(0, 0, 1, 1, 3, 3, d.s16);
/*  61 */         s.full.paste(true);
/*  62 */         return d.s16.saveGame();
/*     */       }
/*  64 */     }).get();
/*     */   
/*  66 */   public final TILE_SHEET mines = (new ComposerThings.ITileSheet(this.getter.get("Mines"), 364, 100)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  70 */         s.singles.init(0, 0, 1, 1, 8, 1, (ComposerDests.Dest)d.s16);
/*  71 */         s.singles.paste(true);
/*  72 */         return d.s16.saveGame();
/*     */       }
/*  74 */     }).get();
/*     */   
/*  76 */   public final TILE_SHEET roads = (new ComposerThings.ITileSheet(this.getter.get("Roads"), 576, 172)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  80 */         s.house.init(0, 0, 4, 2, (ComposerDests.Dest)d.s16);
/*  81 */         for (int i = 0; i < 4; i++)
/*  82 */           s.house.setVar(i).paste(1, true); 
/*  83 */         return d.s16.saveGame();
/*     */       }
/*  85 */     }).get();
/*     */   
/*  87 */   public final TILE_SHEET roadsMini = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  91 */         s.house.init(0, 0, 4, 2, (ComposerDests.Dest)d.s16);
/*  92 */         for (int i = 0; i < 4; i++)
/*  93 */           s.house.setVar(4 + i).paste(1, true); 
/*  94 */         return d.s16.saveGame();
/*     */       }
/*  96 */     }).get();
/*     */   
/*  98 */   public final TILE_SHEET bridge = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 102 */         s.singles.init(0, s.house.body().y2(), 1, 1, 3, 1, (ComposerDests.Dest)d.s16);
/* 103 */         for (int i = 0; i < 3; i++)
/* 104 */           s.singles.setSkip(i, 1).paste(3, true); 
/* 105 */         return d.s16.saveGame();
/*     */       }
/* 107 */     }).get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   public final TILE_SHEET siege = (new ComposerThings.ITileSheet(this.getter.get("Siege"), 120, 60)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 141 */         ComposerDests.Tile t = d.s16;
/* 142 */         ComposerSources.Full f = s.full;
/* 143 */         f.init(0, 0, 1, 1, 3, 3, t);
/* 144 */         f.paste(true);
/* 145 */         return t.saveGame();
/*     */       }
/* 148 */     }).get();
/*     */ 
/*     */   
/* 151 */   public final TILE_SHEET harbour = (new ComposerThings.ITileSheet(this.getter.get("Harbour"), 252, 220)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 155 */         s.singles.init(0, 0, 1, 1, 4, 4, (ComposerDests.Dest)d.s24);
/* 156 */         s.singles.paste(3, true);
/* 157 */         return d.s24.saveGame();
/*     */       }
/* 159 */     }).get();
/*     */   
/* 161 */   public final TILE_SHEET harbourRiver = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 165 */         s.singles.init(0, s.singles.body().y2(), 1, 1, 4, 4, (ComposerDests.Dest)d.s16);
/* 166 */         s.singles.paste(3, true);
/* 167 */         return d.s16.saveGame();
/*     */       }
/* 169 */     }).get();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\buildings\WorldBuildingSprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */