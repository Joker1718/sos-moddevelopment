/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.TileMap;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
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
/*     */ public final class Snow
/*     */   extends TileMap.Resource
/*     */ {
/*  32 */   private Bitsmap1D amount = new Bitsmap1D(0, 2, SETT.TAREA);
/*     */   
/*     */   private final TILE_SHEET sheet;
/*     */ 
/*     */   
/*     */   public Snow(TileMap tileMap) throws IOException {
/*  38 */     this.sheet = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  42 */           ComposerDests.Tile t = d.s24;
/*  43 */           ComposerSources.Singles f = s.singles;
/*  44 */           f.init(0, 0, 1, 1, 16, 4, (ComposerDests.Dest)t);
/*  45 */           f.setVar(0).paste(true);
/*  46 */           return t.saveGame();
/*     */         }
/*  49 */       }).get();
/*  50 */     HeightMap height = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 8, 8);
/*  51 */     for (int i = 0; i < SETT.TAREA; i++) {
/*  52 */       this.amount.set(i, (int)Math.round(height.get(i) * 3.0D));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*  59 */     this.amount.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*  64 */     this.amount.load(saveFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearAll() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, RenderData data) {
/*  76 */     if ((S.get()).downpour.get() == 0) {
/*     */       return;
/*     */     }
/*  79 */     RenderData.RenderIterator i = data.onScreenTiles(1, 1, 1, 1);
/*     */     
/*  81 */     double snow = (SETT.WEATHER()).snow.getD() * 7.0D;
/*  82 */     double ri = 1.5259021896696422E-5D;
/*  83 */     if ((S.get()).graphics.get() == 0) {
/*  84 */       snow *= 0.25D;
/*     */     }
/*  86 */     if (snow == 0.0D) {
/*     */       return;
/*     */     }
/*     */     
/*  90 */     while (i.has()) {
/*     */       
/*  92 */       long ran = i.ran();
/*     */       
/*  94 */       double rr = (ran & 0xFFFFL) * ri;
/*  95 */       double s = snow;
/*     */       
/*  97 */       s -= (SETT.ENV()).map.LIGHT.get(i.tile()) * 7.0D;
/*     */       
/*  99 */       s -= this.amount.get(i.tile());
/* 100 */       s -= rr;
/* 101 */       if (s < 1.0D) {
/* 102 */         s -= rr;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       if (s >= 0.0D && !SETT.TERRAIN().get(i.tile()).roofIs() && !SETT.TERRAIN().get(i.tile()).isMassiveWall() && !(SETT.ROOMS()).placement.embryo.is(i.tile())) {
/* 114 */         int c = (int)s;
/* 115 */         ran >>= 8L;
/* 116 */         if ((SETT.ROOMS()).map.is(i.tile()) || (SETT.FLOOR()).getter.get(i.tile()) != null || (SETT.MINERALS()).amountInt.get(i.tile()) > 0) {
/*     */           
/* 118 */           c = CLAMP.i(c, -1, 1);
/* 119 */           c = (int)(c - (ran & 0x1L));
/*     */         } else {
/* 121 */           c = CLAMP.i(c, -1, 3);
/*     */         } 
/*     */ 
/*     */         
/* 125 */         c = (int)(c - Math.ceil((SETT.PATH()).huristics.getter.get(i.tile()) * 16.0D * 4.0D));
/* 126 */         if (c >= 0) {
/* 127 */           int d = (int)(((ran & 0x7L) - 7L) * 4L);
/* 128 */           ran >>= 3L;
/* 129 */           int x = i.x() + d;
/* 130 */           d = (int)(((ran & 0x7L) - 7L) * 4L);
/* 131 */           ran >>= 3L;
/* 132 */           int y = i.y() + d;
/* 133 */           this.sheet.render((SPRITE_RENDERER)r, (int)(ran & 0xFL) + c * 16, x, y);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 138 */       i.next();
/*     */     } 
/* 140 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\Snow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */