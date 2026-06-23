/*     */ package world.entity.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.thing.pointlight.FireSparks;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ class WArmySprite
/*     */ {
/*  29 */   final TILE_SHEET sheet = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("world").getFolder("entity").get("Army"), 136, 104)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  33 */         s.singles.init(0, 0, 2, 1, 2, 6, (ComposerDests.Dest)d.s8);
/*  34 */         s.singles.setVar(0); int i;
/*  35 */         for (i = 0; i < 7; i++) {
/*  36 */           s.singles.setSkip(i * 2, 2);
/*  37 */           s.singles.paste(3, true);
/*     */         } 
/*  39 */         s.singles.setVar(1);
/*  40 */         for (i = 0; i < 7; i++) {
/*  41 */           s.singles.setSkip(i * 2, 2);
/*  42 */           s.singles.paste(3, true);
/*     */         } 
/*     */ 
/*     */         
/*  46 */         return d.s8.saveGame();
/*     */       }
/*  49 */     }).get();
/*     */ 
/*     */ 
/*     */   
/*     */   static final int OFF = 56;
/*     */ 
/*     */   
/*     */   static final int OFF_BOAT = 24;
/*     */ 
/*     */   
/*     */   void render(WArmy a, Renderer r, ShadowBatch s, int x, int y, DIR dir) {
/*  60 */     COLOR color = (a.faction() == null) ? COLOR.WHITE50 : (COLOR)a.faction().banner().colorBG();
/*     */ 
/*     */ 
/*     */     
/*  64 */     color.bind();
/*     */     
/*  66 */     (SPRITES.cons()).BIG.dashed_hollow.renderBox((SPRITE_RENDERER)r, x + 16, y + 16, a.body().width() - 32, a.body().height() - 32);
/*  67 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */     
/*  71 */     s.setHeight(1).setDistance2Ground(1.0D);
/*  72 */     s.setHard();
/*     */     
/*  74 */     int d = 0;
/*  75 */     if (a.path().moving(a.body()))
/*  76 */       d = 8 * GAME.intervals().get05() % 3; 
/*  77 */     d *= 8;
/*  78 */     if ((WORLD.WATER()).has.is(a.ctx(), a.cty())) {
/*  79 */       d += 24;
/*  80 */     } else if (a.state() == WArmyState.fortified) {
/*  81 */       d = 48;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     double si = 2.0D * AD.men(null).get(a) / (Config.battle()).MEN_PER_ARMY;
/*  88 */     si = CLAMP.d(si, 0.0D, 1.0D);
/*     */     
/*  90 */     int am = (int)Math.ceil(si * 16.0D);
/*  91 */     int wi = (int)Math.ceil(si * 4.0D);
/*  92 */     int hi = (int)Math.ceil(1.0D + si * 3.0D);
/*     */     
/*  94 */     int y1 = (int)((y + 64) - (hi * 32) / 2.0D);
/*  95 */     for (int dy = 0; dy < hi; dy++) {
/*  96 */       int py = y1 + dy * 32;
/*  97 */       int w = am;
/*  98 */       w = CLAMP.i(w, 0, wi);
/*  99 */       am -= w;
/*     */       
/* 101 */       int px = x + 64;
/* 102 */       px -= 32 * w / 2;
/* 103 */       for (int dx = 0; dx < w; dx++) {
/* 104 */         this.sheet.render((SPRITE_RENDERER)r, d + 56 + dir.id(), px, py);
/* 105 */         color.bind();
/* 106 */         this.sheet.render((SPRITE_RENDERER)r, d + dir.id(), px, py);
/* 107 */         COLOR.unbind();
/* 108 */         this.sheet.render((SPRITE_RENDERER)s, d + 56 + dir.id(), px, py);
/* 109 */         px += 32;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 114 */     if (a.raiding())
/* 115 */       FireSparks.render(VIEW.renderSecond() * 26.0D, x + a.body().width() / 2, y + a.body().height() / 2, 30, 1321342345, 0.5D); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmySprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */