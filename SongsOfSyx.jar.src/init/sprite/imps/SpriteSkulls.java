/*     */ package init.sprite.imps;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.Sheet;
/*     */ import init.sprite.game.SheetData;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ class SpriteSkulls
/*     */ {
/*     */   TILE_SHEET small;
/*     */   TILE_SHEET medium;
/*     */   TILE_SHEET big;
/*     */   
/*     */   SpriteSkulls(Json json) throws IOException {
/*  28 */     this.small = SPRITES.GAME().raw((SheetType)SheetType.s1x1, "SKULL_SMALL_1X1", json);
/*  29 */     this.medium = SPRITES.GAME().raw((SheetType)SheetType.s1x1, "SKULL_MEDIUM_1X1", json);
/*  30 */     this.big = SPRITES.GAME().raw((SheetType)SheetType.s1x1, "SKULL_BIG_1X1", json);
/*     */     
/*  32 */     Sheet sheet = new Sheet(324, true, false)
/*     */       {
/*     */         
/*     */         public TextureCoords texture(int tile)
/*     */         {
/*  37 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/*  42 */           shadow.setDistance2Ground(0.0D);
/*  43 */           shadow.setHeight(4);
/*  44 */           SpriteSkulls.this.render(x, y, DIR.C, it, (SPRITE_RENDERER)shadow, random);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/*  50 */           SpriteSkulls.this.render(x, y, DIR.C, it, sr, random);
/*     */         }
/*     */       };
/*     */     
/*  54 */     SPRITES.GAME().add((SheetType)SheetType.s1x1, (LIST)new ArrayList(sheet), "SKULL_MOUND_1X1");
/*     */     
/*  56 */     sheet = new Sheet(324, true, false)
/*     */       {
/*     */         
/*     */         public TextureCoords texture(int tile)
/*     */         {
/*  61 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/*  66 */           shadow.setDistance2Ground(0.0D);
/*  67 */           shadow.setHeight(4);
/*     */           
/*  69 */           DIR d = DIR.get(0.5D - SheetType.s2x2.dx(tile), 0.5D - SheetType.s2x2.dy(tile));
/*     */           
/*  71 */           SpriteSkulls.this.render(x, y, d, it, (SPRITE_RENDERER)shadow, random);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/*  77 */           DIR d = DIR.get(0.5D - SheetType.s2x2.dx(tile), 0.5D - SheetType.s2x2.dy(tile));
/*  78 */           SpriteSkulls.this.render(x, y, d, it, sr, random);
/*     */         }
/*     */       };
/*     */     
/*  82 */     SPRITES.GAME().add((SheetType)SheetType.s2x2, (LIST)new ArrayList(sheet), "SKULL_MOUND_2X2");
/*     */     
/*  84 */     sheet = new Sheet(324, true, false)
/*     */       {
/*     */         
/*     */         public TextureCoords texture(int tile)
/*     */         {
/*  89 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/*  94 */           shadow.setDistance2Ground(0.0D);
/*  95 */           shadow.setHeight(4);
/*     */           
/*  97 */           DIR d = DIR.get((1 - SheetType.s3x3.dx(tile)), (1 - SheetType.s3x3.dy(tile)));
/*     */           
/*  99 */           SpriteSkulls.this.render(x, y, d, it, (SPRITE_RENDERER)shadow, random);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 105 */           DIR d = DIR.get((1 - SheetType.s3x3.dx(tile)), (1 - SheetType.s3x3.dy(tile)));
/* 106 */           SpriteSkulls.this.render(x, y, d, it, sr, random);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 111 */     SPRITES.GAME().add((SheetType)SheetType.s3x3, (LIST)new ArrayList(sheet), "SKULL_MOUND_3X3");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(int x, int y, DIR dir, RenderData.RenderIterator it, SPRITE_RENDERER sr, int random) {
/* 117 */     int count = (GAME.count()).EXECUTIONS.current() / 16 + (GUTIL.ran2().get(it.tile()) & 0xF);
/*     */     
/* 119 */     int ran = it.ran();
/*     */     
/* 121 */     count = 28;
/*     */ 
/*     */ 
/*     */     
/* 125 */     if (count >= 9) {
/* 126 */       this.big.render(sr, ran % this.big.tiles(), x, y);
/*     */       
/* 128 */       if (count >= 15) {
/* 129 */         this.medium.render(sr, ran % this.big.tiles(), (int)(x + dir.xN() * 8.0D), (int)(y + dir.yN() * 8.0D));
/*     */       }
/*     */       
/* 132 */       if (count >= 12) {
/* 133 */         this.small.render(sr, ran % this.big.tiles(), (int)(x + dir.xN() * 8.0D), (int)(y + dir.yN() * 8.0D));
/*     */       
/*     */       }
/*     */     }
/* 137 */     else if (count >= 6) {
/* 138 */       this.medium.render(sr, ran % this.medium.tiles(), x, y);
/*     */     } else {
/* 140 */       this.small.render(sr, ran % this.small.tiles(), x, y);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\imps\SpriteSkulls.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */