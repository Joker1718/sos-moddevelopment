/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ public abstract class ProjectileSprite
/*     */ {
/*  26 */   private static final KeyMap<TILE_SHEET> map = new KeyMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static final ProjectileSprite DUMMY = new ProjectileSprite()
/*     */     {
/*     */       
/*     */       public void renderProj(Projectile p, double ref, Renderer r, ShadowBatch s, double x, double y, int h, int ran, double dx, double dy, double dz, float ds, int zoomout)
/*     */       {
/*  43 */         if (zoomout < 2) {
/*  44 */           double l = Math.sqrt(dx * dx + dy * dy + dz * dz * 4.0D);
/*  45 */           dx /= l;
/*  46 */           dy /= l;
/*  47 */           dx *= 4.0D;
/*  48 */           dy *= 4.0D;
/*  49 */           for (int k = 0; k < 8; k++) {
/*  50 */             r.renderParticle((int)x, (int)y);
/*  51 */             x += dx;
/*  52 */             y += dy;
/*     */           } 
/*     */         } 
/*     */         
/*  56 */         s.setDistance2Ground((h / 4));
/*  57 */         (SPRITES.icons()).s.dot.renderC((SPRITE_RENDERER)s, (int)x, (int)y);
/*     */       }
/*     */     };
/*     */   
/*     */   public static ProjectileSprite get(Json json) throws IOException {
/*  62 */     ColorImp colorImp = new ColorImp(json, "COLOR");
/*  63 */     if (json.has("SPRITE_FILE")) {
/*  64 */       return get((COLOR)colorImp, json.value("SPRITE_FILE"));
/*     */     }
/*  66 */     final COLOR[] cols = cols((COLOR)colorImp);
/*  67 */     return new ProjectileSprite()
/*     */       {
/*     */         
/*     */         public void renderProj(Projectile p, double ref, Renderer r, ShadowBatch s, double x, double y, int h, int ran, double dx, double dy, double dz, float ds, int zoomout)
/*     */         {
/*  72 */           if (zoomout < 2) {
/*  73 */             cols[ran & 0x3F].bind();
/*  74 */             double l = Math.sqrt(dx * dx + dy * dy + dz * dz * 4.0D);
/*  75 */             dx /= l;
/*  76 */             dy /= l;
/*  77 */             dx *= 4.0D;
/*  78 */             dy *= 4.0D;
/*  79 */             for (int k = 0; k < 8; k++) {
/*  80 */               r.renderParticle((int)x, (int)y);
/*  81 */               x += dx;
/*  82 */               y += dy;
/*     */             } 
/*  84 */             COLOR.unbind();
/*     */           } 
/*     */           
/*  87 */           s.setHeight(0).setDistance2Ground((h / 4));
/*  88 */           (SPRITES.icons()).s.dot.renderC((SPRITE_RENDERER)s, (int)x, (int)y);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ProjectileSprite get(COLOR col, String key) throws IOException {
/*  96 */     if (!map.containsKey(key)) {
/*  97 */       TILE_SHEET tILE_SHEET = (new ComposerThings.ITileSheet(PATHS.SPRITE_SETTLEMENT().getFolder("projectile").get(key), 112, 28)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 101 */             s.singles.init(0, 0, 2, 1, 1, 1, (ComposerDests.Dest)d.s16);
/* 102 */             for (int i = 0; i < 4; i++) {
/* 103 */               s.singles.setVar(0).pasteRotated(i, true);
/* 104 */               s.singles.setVar(1).pasteRotated(i, true);
/*     */             } 
/*     */             
/* 107 */             return d.s16.saveGame();
/*     */           }
/* 109 */         }).get();
/* 110 */       map.put(key, tILE_SHEET);
/*     */     } 
/*     */ 
/*     */     
/* 114 */     final COLOR[] cols = cols(col);
/* 115 */     final TILE_SHEET sheet = (TILE_SHEET)map.get(key);
/* 116 */     return new ProjectileSprite()
/*     */       {
/*     */         
/*     */         public void renderProj(Projectile p, double ref, Renderer r, ShadowBatch s, double x, double y, int h, int ran, double dx, double dy, double dz, float ds, int zoomout)
/*     */         {
/* 121 */           int i = DIR.get(dx, dy).id();
/* 122 */           double sc = 1.0D + h * 0.015625D * 0.125D;
/*     */           
/* 124 */           int w = (int)(sheet.size() * sc);
/* 125 */           int x1 = (int)(x - (w / 2));
/* 126 */           int y1 = (int)(y - (w / 2));
/* 127 */           int x2 = x1 + w;
/* 128 */           int y2 = y1 + w;
/*     */ 
/*     */           
/* 131 */           cols[ran & 0x3F].bind();
/* 132 */           sheet.render((SPRITE_RENDERER)r, i, x1, x2, y1, y2);
/* 133 */           s.setHeight(0).setDistance2Ground((h / 4));
/* 134 */           sheet.renderC((SPRITE_RENDERER)s, i, (int)x, (int)y);
/* 135 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void renderProj(Projectile paramProjectile, double paramDouble1, Renderer paramRenderer, ShadowBatch paramShadowBatch, double paramDouble2, double paramDouble3, int paramInt1, int paramInt2, double paramDouble4, double paramDouble5, double paramDouble6, float paramFloat, int paramInt3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static COLOR[] cols(COLOR col) {
/* 152 */     COLOR[] cols = new COLOR[64];
/* 153 */     for (int i = 0; i < cols.length; i++) {
/* 154 */       cols[i] = (COLOR)(new ColorImp(
/* 155 */           CLAMP.i(col.red() + RND.rInt(5), 0, 128), 
/* 156 */           CLAMP.i(col.green() + RND.rInt(5), 0, 127), 
/* 157 */           CLAMP.i(col.blue() + RND.rInt(5), 0, 127)))
/* 158 */         .shadeSelf(RND.rFloat1(0.5D));
/*     */     }
/* 160 */     return cols;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\ProjectileSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */