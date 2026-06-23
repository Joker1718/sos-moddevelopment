/*      */ package settlement.tilemap.terrain;
/*      */ 
/*      */ import game.time.TIME;
/*      */ import init.paths.PATHS;
/*      */ import init.settings.S;
/*      */ import init.sprite.SPRITES;
/*      */ import java.io.IOException;
/*      */ import java.nio.file.Path;
/*      */ import settlement.main.SETT;
/*      */ import settlement.tilemap.ground.GroundType;
/*      */ import snake2d.CORE;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.color.ColorImp;
/*      */ import snake2d.util.color.OPACITY;
/*      */ import snake2d.util.color.OpacityImp;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.file.Alloc;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import snake2d.util.sprite.TILE_SHEET;
/*      */ import snake2d.util.sprite.TextureCoords;
/*      */ import snake2d.util.sprite.TileTexture;
/*      */ import util.rendering.RenderData;
/*      */ import util.spritecomposer.ComposerDests;
/*      */ import util.spritecomposer.ComposerSources;
/*      */ import util.spritecomposer.ComposerThings;
/*      */ import util.spritecomposer.ComposerUtil;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class Sprites
/*      */ {
/*      */   private final TILE_SHEET stencil;
/*      */   private final TILE_SHEET animation;
/*      */   private final TILE_SHEET animation_corner;
/*      */   private final TILE_SHEET single_stencil;
/*      */   private final TILE_SHEET single_animation;
/*      */   private final TILE_SHEET ice;
/*      */   private final TILE_SHEET ice_fulls;
/*      */   private final TILE_SHEET edge;
/*      */   private final TILE_SHEET bridgeRaw;
/*      */   private final TILE_SHEET bridge;
/*  963 */   public final ColorImp shore = new ColorImp(10, 40, 100);
/*  964 */   public final ColorImp normal = this.shore.shade(0.5D);
/*  965 */   public final ColorImp deep = this.normal.shade(0.5D);
/*      */   
/*  967 */   private short shoreOff = 0;
/*      */   
/*      */   private double waterTimer;
/*      */   private int shoreDir;
/*  971 */   private final TileTexture.TileTextureScroller dis1 = (SPRITES.textures()).dis_big.scroller(1.1D, -1.1D);
/*  972 */   private final TileTexture.TileTextureScroller dis2 = (SPRITES.textures()).dis_tiny.scroller(-0.8D, 0.8D);
/*  973 */   private final TileTexture.TileTextureScroller tex1 = (SPRITES.textures()).bumps.scroller(-1.0D, -1.0D);
/*  974 */   private final TileTexture.TileTextureScroller tex2 = (SPRITES.textures()).water.scroller(1.5D, 1.5D);
/*  975 */   private final OpacityImp o2 = new OpacityImp(63);
/*      */   
/*  977 */   private final int[] offs = Alloc.ii(16);
/*      */   
/*      */   final SPRITE icon;
/*      */ 
/*      */   
/*      */   Sprites() throws IOException {
/*  983 */     for (int i = 0; i < this.offs.length; i++) {
/*  984 */       int k = i;
/*  985 */       if (i > 7) {
/*  986 */         k = 7 - i - 7;
/*  987 */         if (k < 0)
/*  988 */           k = 0; 
/*      */       } 
/*  990 */       this.offs[i] = k;
/*      */     } 
/*      */     
/*  993 */     this.stencil = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT_MAP().get("Water"), 576, 300)
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/*  997 */           s.house.init(0, 0, 4, 1, (ComposerDests.Dest)d.s16);
/*  998 */           for (int i = 0; i < 4; i++)
/*  999 */             s.house.setVar(i).paste(true); 
/* 1000 */           return d.s16.saveGame();
/*      */         }
/* 1003 */       }).get();
/*      */     
/* 1005 */     this.animation = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1009 */           s.house.init(0, s.house.body().y2(), 4, 2, (ComposerDests.Dest)d.s16);
/* 1010 */           for (int i = 0; i < 8; i++)
/* 1011 */             s.house.setVar(i).paste(true); 
/* 1012 */           return d.s16.saveGame();
/*      */         }
/* 1015 */       }).get();
/*      */     
/* 1017 */     this.animation_corner = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1021 */           for (int i = 0; i < 8; i += 2) {
/* 1022 */             s.house.setVar(i).pasteEdges(true);
/*      */           }
/* 1024 */           return d.s16.saveGame();
/*      */         }
/* 1027 */       }).get();
/*      */     
/* 1029 */     this.single_stencil = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1033 */           s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/* 1034 */           s.full.paste(true);
/* 1035 */           return d.s16.saveGame();
/*      */         }
/* 1038 */       }).get();
/*      */     
/* 1040 */     this.single_animation = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1044 */           s.full.init(0, s.full.body().y2(), 1, 1, 16, 1, d.s16);
/* 1045 */           s.full.paste(true);
/* 1046 */           return d.s16.saveGame();
/*      */         }
/* 1049 */       }).get();
/*      */ 
/*      */     
/* 1052 */     this.ice = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1056 */           s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/* 1057 */           for (int i = 0; i < 4; i++)
/* 1058 */             s.house.setVar(i).paste(true); 
/* 1059 */           return d.s16.saveGame();
/*      */         }
/* 1062 */       }).get();
/*      */     
/* 1064 */     this.ice_fulls = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1068 */           s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/* 1069 */           s.full.paste(true);
/* 1070 */           return d.s16.saveGame();
/*      */         }
/* 1073 */       }).get();
/*      */     
/* 1075 */     this.edge = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1079 */           s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/* 1080 */           for (int i = 0; i < 4; i++)
/* 1081 */             s.house.setVar(i).paste(true); 
/* 1082 */           return d.s16.saveGame();
/*      */         }
/* 1085 */       }).get();
/*      */     
/* 1087 */     this.bridgeRaw = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1091 */           s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, d.s16);
/* 1092 */           s.full.paste(true);
/* 1093 */           return d.s16.saveGame();
/*      */         }
/* 1096 */       }).get();
/*      */     
/* 1098 */     this.bridge = (new ComposerThings.ITileSheet()
/*      */       {
/*      */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*      */         {
/* 1102 */           s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)d.s16);
/* 1103 */           s.house.setVar(0).paste(true);
/* 1104 */           s.house.setVar(1).paste(true);
/* 1105 */           s.house.setVar(2).pasteEdges(true);
/* 1106 */           s.house.setVar(3).pasteEdges(true);
/*      */           
/* 1108 */           return d.s16.saveGame();
/*      */         }
/* 1111 */       }).get();
/*      */     
/* 1113 */     this.icon = (SPRITE)new SPRITE.Imp(32)
/*      */       {
/* 1115 */         final int[] dx = new int[] { 0, 16, 16 };
/* 1116 */         final int[] dy = new int[] { 0, 0, 16, 16 };
/* 1117 */         final int[] mm = new int[] { DIR.S.mask() | DIR.E.mask(), DIR.S.mask() | DIR.W.mask(), DIR.N.mask() | DIR.E.mask(), DIR.N.mask() | DIR.W.mask() };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 1124 */           for (int i = 0; i < 4; i++) {
/* 1125 */             int x = X1 + this.dx[i];
/* 1126 */             int y = Y1 + this.dy[i];
/* 1127 */             int x2 = x + 16;
/* 1128 */             int y2 = y + 16;
/* 1129 */             int t = this.mm[i];
/* 1130 */             TWater.Sprites.this.normal.bind();
/* 1131 */             TWater.Sprites.this.stencil.render(r, t, x, x2, y, y2);
/* 1132 */             (SETT.GROUND()).types.NORMAL.miniC.bind();
/* 1133 */             TWater.Sprites.this.edge.render(r, t, x, x2, y, y2);
/*      */           } 
/*      */ 
/*      */           
/* 1137 */           COLOR.unbind();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void update(double ds) {
/* 1145 */     this.waterTimer += ds;
/* 1146 */     if (this.waterTimer > 0.20000000298023224D) {
/* 1147 */       this.waterTimer -= 0.20000000298023224D;
/* 1148 */       this.shoreOff = (short)(this.shoreOff + this.shoreDir);
/* 1149 */       if (this.shoreOff >= 7) {
/* 1150 */         this.shoreDir = -1;
/* 1151 */       } else if (this.shoreOff == 0) {
/* 1152 */         this.shoreDir = 1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1157 */     double wx = ds * (1.0D + (SETT.WEATHER()).wind.getD() * 6.0D) * (SETT.WEATHER()).wind.dirX();
/* 1158 */     double wy = ds * (1.0D + (SETT.WEATHER()).wind.getD() * 6.0D) * (SETT.WEATHER()).wind.dirY();
/* 1159 */     this.dis1.update(ds);
/* 1160 */     this.dis2.update((SETT.WEATHER()).wind.dirX() * ds * 0.8D, (SETT.WEATHER()).wind.dirY() * ds * 0.8D);
/* 1161 */     this.tex1.update(ds);
/* 1162 */     this.tex2.update(-wx * 1.5D, -wy * 1.2D);
/*      */     
/* 1164 */     this.shore.interpolate((SETT.TERRAIN()).colors.waternormal, (SETT.TERRAIN()).colors.waterWinter, 1.0D - (SETT.WEATHER()).growth.getD());
/* 1165 */     this.normal.set((COLOR)this.shore).shadeSelf(0.5D);
/* 1166 */     this.deep.set((COLOR)this.normal).shadeSelf(0.75D);
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderIce(int mask, int corner, RenderData.RenderIterator it) {
/* 1171 */     int ran = it.ran();
/* 1172 */     int x = it.x();
/* 1173 */     int y = it.y();
/*      */     
/* 1175 */     if (mask == 15) {
/* 1176 */       this.ice_fulls.render((SPRITE_RENDERER)CORE.renderer(), ran & 0xF, x, y);
/*      */     } else {
/* 1178 */       this.ice.render((SPRITE_RENDERER)CORE.renderer(), (ran & 0x3) * 16 + mask, x, y);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void render(int mask, int corner, RenderData.RenderIterator it, COLOR cForeGround, COLOR bg) {
/* 1184 */     int ran = it.ran();
/* 1185 */     int x = it.x();
/* 1186 */     int y = it.y();
/*      */     
/* 1188 */     if (mask == 0) {
/* 1189 */       bg.bind();
/* 1190 */       int t = ran & 0xF;
/* 1191 */       this.single_stencil.render((SPRITE_RENDERER)CORE.renderer(), t, x, y);
/* 1192 */       cForeGround.bind();
/* 1193 */       this.single_stencil.renderTextured(this.single_animation.getTexture(t), t, x, y);
/*      */     } else {
/* 1195 */       int stenI = (ran & 0x3) * 16 + mask;
/*      */ 
/*      */       
/* 1198 */       ran >>= 2;
/* 1199 */       int off = (int)(TIME.currentSecond() * 5.0D);
/* 1200 */       off += -1 + (ran & 0x3);
/* 1201 */       off &= 0xF;
/* 1202 */       off = this.offs[off];
/*      */       
/* 1204 */       int texI = off * 16 + mask;
/*      */       
/* 1206 */       bg.bind();
/* 1207 */       this.stencil.render((SPRITE_RENDERER)CORE.renderer(), stenI, x, y);
/*      */       
/* 1209 */       cForeGround.bind();
/* 1210 */       if (mask != 15) {
/* 1211 */         this.stencil.renderTextured(this.animation.getTexture(texI), stenI, x, y);
/*      */       }
/*      */       
/* 1214 */       if (corner != 0) {
/* 1215 */         this.animation_corner.render((SPRITE_RENDERER)CORE.renderer(), 16 * off / 2 + corner, x, y);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void above(int mask, int corner, RenderData.RenderIterator it) {
/* 1222 */     int ran = it.ran();
/* 1223 */     int x = it.x();
/* 1224 */     int y = it.y();
/*      */     
/* 1226 */     mask &= 0xF;
/*      */     
/* 1228 */     if (mask == 15) {
/*      */       return;
/*      */     }
/* 1231 */     int stenI = (ran & 0x3) * 16 + mask;
/*      */ 
/*      */ 
/*      */     
/* 1235 */     TextureCoords tex = SETT.GROUND().getTexture(it.tile(), it.ran());
/* 1236 */     ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).col(it.tile()).bind();
/* 1237 */     this.edge.renderTextured(tex, stenI, x, y);
/* 1238 */     COLOR.unbind();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void renderTexture(RenderData.RenderIterator i) {
/* 1244 */     if ((S.get()).graphics.get() == 0) {
/*      */       return;
/*      */     }
/* 1247 */     this.normal.bind();
/* 1248 */     this.o2.bind();
/*      */     
/* 1250 */     CORE.renderer().renderDisplace(this.dis1.x1(i.tx() + 4), this.dis1.y1(i.ty() + 4), this.tex1.x1(i.tx() + 2), this.tex1.y1(i.ty() + 2), 
/* 1251 */         16, 16, 16.0D, 
/* 1252 */         i.x(), i.x() + 64, i.y(), i.y() + 64);
/*      */     
/* 1254 */     CORE.renderer().renderDisplace(this.dis1.x1(i.tx() + 4), this.dis1.y1(i.ty() + 4), this.tex1.x1(i.tx() + 2), this.tex1.y1(i.ty() + 2), 
/* 1255 */         16, 16, 16.0D, 
/* 1256 */         i.x(), i.x() + 64, i.y(), i.y() + 64);
/* 1257 */     COLOR.unbind();
/* 1258 */     OPACITY.O25.bind();
/*      */     
/* 1260 */     CORE.renderer().renderDisplace(this.dis2.x1(i.tx()), this.dis2.y1(i.ty()), this.tex2.x1(i.tx()), this.tex2.y1(i.ty()), 
/* 1261 */         16, 16, 8.0D, 
/* 1262 */         i.x(), i.x() + 64, i.y(), i.y() + 64);
/*      */     
/* 1264 */     OPACITY.unbind();
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TWater$Sprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */