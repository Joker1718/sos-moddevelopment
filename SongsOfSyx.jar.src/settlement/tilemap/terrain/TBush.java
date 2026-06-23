/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.TileTexture;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TBush
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final TILE_SHEET sheet;
/*     */   private static final int SET = 16;
/*  38 */   private final TileTexture.TileTextureScroller dis1 = (SPRITES.textures()).dis_low.scroller(72.0D, -66.0D);
/*     */   
/*  40 */   private final TerrainClearing clearing = new TerrainClearing()
/*     */     {
/*  42 */       private final SoundRace sound = AUDIO.race("CLEAR_BUSH");
/*     */ 
/*     */       
/*     */       public RESOURCE clear1(int tx, int ty) {
/*  46 */         TBush.this.shared.NADA.placeFixed(tx, ty);
/*  47 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean can() {
/*  52 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int clearAll(int tx, int ty) {
/*  57 */         TBush.this.shared.NADA.placeFixed(tx, ty);
/*  58 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public SoundRace sound(int tx, int ty) {
/*  63 */         return this.sound;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEasilyCleared() {
/*  68 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   TBush(Terrain t) throws IOException {
/*  74 */     super("BUSH", t, "bush", (SPRITE)(SPRITES.icons()).m.cancel, (COLOR)null);
/*  75 */     this.sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT_MAP().get("Bush"), 716, 94)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  79 */           s.singles.init(0, 0, 1, 1, 16, 4, (ComposerDests.Dest)d.s16);
/*  80 */           s.singles.paste(true);
/*  81 */           return d.s16.saveGame();
/*     */         }
/*  83 */       }).get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/*  89 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/*  94 */     double v = 0.0D;
/*  95 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/*  96 */       DIR dIR = (DIR)DIR.ALL.get(i);
/*  97 */       if (is(tx, ty, dIR) || this.shared.TREES.isTree(tx + dIR.x(), ty + dIR.y()))
/*  98 */         v += 0.5D; 
/*     */     } 
/* 100 */     int d = (int)(v - 0.1D);
/* 101 */     placeRaw(tx, ty);
/* 102 */     this.shared.data.set(tx, ty, d * 16);
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 115 */     render(i, r, s, i.x(), i.y(), i.ran(), data);
/* 116 */     i.countVegetation();
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 122 */     double w = Math.pow((SETT.WEATHER()).wind.getD(), 1.5D);
/* 123 */     if (w > 0.1D) {
/* 124 */       this.dis1.update(ds * w);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(RenderData.RenderIterator i, SPRITE_RENDERER r, ShadowBatch s, int x, int y, int ran, int data) {
/* 139 */     int d = data / 16;
/* 140 */     data = CLAMP.i((int)((d + 1) * (SETT.WEATHER()).moisture.getD() + (i.ran() & 0x3)), 0, d) * 16;
/*     */     
/* 142 */     int t = ran & 0xF;
/* 143 */     t += data;
/* 144 */     (SETT.TERRAIN()).colors.tree.get(ran >> 4).bind();
/* 145 */     if (t < 0 || t > 64)
/* 146 */       GAME.Notify("nono"); 
/* 147 */     this.sheet.render(r, t, x, y);
/*     */     
/* 149 */     if ((S.get()).graphics.get() > 0) {
/* 150 */       OPACITY.O50.bind();
/* 151 */       TextureCoords ti = (SPRITES.textures()).dots.get(i.tx(), i.ty(), 0.0D, 0.0D);
/* 152 */       CORE.renderer().renderDisplaced(x, x + 64, y, y + 64, this.dis1.get(i.tx(), i.ty()), ti);
/* 153 */       OPACITY.unbind();
/*     */     } 
/*     */ 
/*     */     
/* 157 */     s.setDistance2Ground(0.0D).setHeight(2);
/* 158 */     this.sheet.render((SPRITE_RENDERER)s, t, x, y);
/* 159 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public void render(RenderData.RenderIterator i, SPRITE_RENDERER r, ShadowBatch s, int x, int y, int ran) {
/* 163 */     int ss = (ran & 0x3) * 16;
/* 164 */     ran >>= 2;
/* 165 */     render(i, r, s, x, y, ran, ss);
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 170 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBush.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */