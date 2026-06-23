/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ 
/*     */ public class GroundTypes
/*     */ {
/*  17 */   private static CharSequence ¤¤nnmae = "Rich";
/*  18 */   private static CharSequence ¤¤ndesc = "Richest of soils, very suitable for farming.";
/*  19 */   private static CharSequence ¤¤fnmae = "Alluvium";
/*  20 */   private static CharSequence ¤¤fdesc = "Trees will grow here, but soil is poor for agriculture. Suitable for woodcutters and orchards.";
/*  21 */   private static CharSequence ¤¤pnmae = "Till";
/*  22 */   private static CharSequence ¤¤pdesc = "Not the best soil, but all right for agriculture.";
/*  23 */   private static CharSequence ¤¤rnmae = "Rock";
/*  24 */   private static CharSequence ¤¤rdesc = "Can not be cultivated";
/*  25 */   private static CharSequence ¤¤snmae = "Sand";
/*  26 */   private static CharSequence ¤¤sdesc = "Sand is devoid of nutrients and can hardly be cultivated.";
/*     */   
/*  28 */   private static CharSequence ¤¤poor = "Infertile";
/*  29 */   private static CharSequence ¤¤poorD = "Infertile soil is devoid of nutrients and hard to work.";
/*     */   
/*     */   static {
/*  32 */     D.ts(GroundTypes.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int VARS = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   final TILE_SHEET s_masks = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT_MAP().get("Ground"), 536, 408)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  52 */         s.full.init(0, 0, 1, 1, 8, 1, d.s16);
/*  53 */         s.full.setSkip(8, 0);
/*  54 */         s.full.paste(true);
/*  55 */         s.full.pasteRotated(1, true);
/*  56 */         s.full.pasteRotated(2, true);
/*  57 */         s.full.pasteRotated(3, true);
/*  58 */         return d.s16.saveGame();
/*     */       }
/*  60 */     }).get();
/*  61 */   final TILE_SHEET c_masks = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  65 */         s.full.init(0, 0, 1, 1, 16, 1, d.s16);
/*  66 */         s.full.setSkip(8, 8);
/*  67 */         s.full.paste(true);
/*  68 */         s.full.pasteRotated(1, true);
/*  69 */         s.full.pasteRotated(2, true);
/*  70 */         s.full.pasteRotated(3, true);
/*  71 */         return d.s16.saveGame();
/*     */       }
/*  73 */     }).get();
/*     */   GroundTypes() throws IOException {
/*  75 */     TILE_SHEET s_normal = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  79 */           s.full.init(0, s.full.body().y2(), 1, 1, 16, 4, d.s16);
/*  80 */           s.full.paste(true);
/*  81 */           return d.s16.saveGame();
/*     */         }
/*  83 */       }).get();
/*     */     
/*  85 */     TILE_SHEET s_rock = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  89 */           s.full.init(0, s.full.body().y2(), 1, 1, 16, 4, d.s16);
/*  90 */           s.full.paste(true);
/*  91 */           return d.s16.saveGame();
/*     */         }
/*  93 */       }).get();
/*     */     
/*  95 */     TILE_SHEET s_sand = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  99 */           s.full.init(0, s.full.body().y2(), 1, 1, 16, 4, d.s16);
/* 100 */           s.full.paste(true);
/* 101 */           return d.s16.saveGame();
/*     */         }
/* 103 */       }).get();
/*     */     
/* 105 */     TILE_SHEET s_tree = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 109 */           s.full.init(0, s.full.body().y2(), 1, 1, 16, 4, d.s16);
/* 110 */           s.full.paste(true);
/* 111 */           return d.s16.saveGame();
/*     */         }
/* 113 */       }).get();
/*     */     
/* 115 */     TILE_SHEET s_pasture = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 119 */           s.full.init(0, s.full.body().y2(), 1, 1, 16, 4, d.s16);
/* 120 */           s.full.paste(true);
/* 121 */           return d.s16.saveGame();
/*     */         }
/* 123 */       }).get();
/*     */     
/* 125 */     TILE_SHEET s_infertile = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 129 */           s.full.init(0, s.full.body().y2(), 1, 1, 16, 4, d.s16);
/* 130 */           s.full.paste(true);
/* 131 */           return d.s16.saveGame();
/*     */         }
/* 133 */       }).get();
/*     */     
/* 135 */     Json j = new Json((PATHS.CONFIG()).init.gets("SettColors"));
/*     */     
/* 137 */     this.NORMAL = new GroundType(0, s_normal, ¤¤nnmae, ¤¤ndesc, 1.0D, 1.1D);
/* 138 */     this.FOREST = new GroundType(1, s_tree, ¤¤fnmae, ¤¤fdesc, 1.0D, 0.75D);
/* 139 */     this.PASTURE = new GroundType(2, s_pasture, ¤¤pnmae, ¤¤pdesc, 1.0D, 0.9D);
/* 140 */     this.INFERTILE = new GroundType(3, s_infertile, ¤¤poor, ¤¤poorD, 0.25D, 0.5D);
/* 141 */     this.ROCK = (new GroundType(4, s_rock, ¤¤rnmae, ¤¤rdesc, 1.0D, 0.4D)).setColors(j.json("GROUND_ROCK"));
/* 142 */     this.SAND = (new GroundType(5, s_sand, ¤¤snmae, ¤¤sdesc, 0.1D, 0.4D)).setColors(j.json("GROUND_SAND"));
/*     */ 
/*     */     
/* 145 */     this.ROCK.miniC.set(COLOR.WHITE25);
/* 146 */     this.ALL = new GroundType[] {
/* 147 */         this.NORMAL, 
/* 148 */         this.FOREST, 
/* 149 */         this.PASTURE, 
/* 150 */         this.INFERTILE, 
/* 151 */         this.ROCK, 
/* 152 */         this.SAND };
/*     */   }
/*     */   
/*     */   public final GroundType NORMAL;
/*     */   public final GroundType FOREST;
/*     */   public final GroundType PASTURE;
/*     */   public final GroundType SAND;
/*     */   public final GroundType ROCK;
/*     */   public final GroundType INFERTILE;
/*     */   public final GroundType[] ALL;
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\GroundTypes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */