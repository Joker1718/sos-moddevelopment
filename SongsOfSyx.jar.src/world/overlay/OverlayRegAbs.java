/*     */ package world.overlay;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.raiding.RaidingMap;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ abstract class OverlayRegAbs
/*     */   extends WorldOverlays.OverlayTileNormal
/*     */ {
/*     */   private boolean inv;
/*     */   
/*     */   OverlayRegAbs(CharSequence name, CharSequence desc, boolean inv) {
/*  26 */     super(name, desc, true, true);
/*  27 */     this.inv = inv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(Renderer ren, ShadowBatch s, RenderData data) {
/*  34 */     super.renderAbove(ren, s, data);
/*     */     
/*  36 */     for (Region reg : WORLD.REGIONS().active()) {
/*  37 */       if (is(reg)) {
/*  38 */         double v = value(reg) * 100.0D;
/*     */         
/*  40 */         int x = data.transformGX(reg.cx() * 64 + 32);
/*  41 */         int y = data.transformGY(reg.cy() * 64 + 32);
/*  42 */         Str.TMP.clear().add(v, 1);
/*  43 */         Str.TMP.add('%');
/*     */         
/*  45 */         int w = 128;
/*  46 */         int h = 64;
/*     */         
/*  48 */         (GCOLOR.UI()).panBG.render((SPRITE_RENDERER)ren, x - w, x + w, y - h, y + h);
/*  49 */         GCOLOR.UI().border().renderFrame((SPRITE_RENDERER)ren, x - w, x + w, y - h, y + h, 4, 4);
/*  50 */         (UI.FONT()).S.renderC((SPRITE_RENDERER)ren, x, y, (CharSequence)Str.TMP, 4.0D);
/*     */       } 
/*     */     } 
/*     */     
/*  54 */     COLOR.WHITE2WHITE.bind();
/*     */ 
/*     */     
/*  57 */     for (RaidingMap.RaidEntryPoint c : (GAME.raiders()).entry.entrySpots()) {
/*  58 */       int x = data.transformGX(c.c().x() * 64);
/*  59 */       int y = data.transformGY(c.c().y() * 64);
/*     */       
/*  61 */       (UI.icons()).s.alert.renderScaled((SPRITE_RENDERER)ren, x, y, 4);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean is(Region paramRegion);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract double value(Region paramRegion);
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*  81 */     COLOR.ORANGE100.bind();
/*     */     
/*  83 */     if ((WORLD.PATH()).map.is.is(it.tile()))
/*     */     {
/*  85 */       for (DIR d : DIR.ALL) {
/*  86 */         if ((WORLD.PATH()).map.can(it.tile(), d)) {
/*  87 */           ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  94 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 101 */     int m = 15;
/* 102 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 103 */     if (WORLD.REGIONS().border().is(it.tile())) {
/* 104 */       m = 0;
/* 105 */       for (DIR d : DIR.ORTHO) {
/* 106 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d) || reg == (WORLD.REGIONS()).map.get(it.tx(), it.ty(), d)) {
/* 107 */           m |= d.mask();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     if (reg != null && is(reg))
/* 113 */     { double v = value(reg);
/* 114 */       if (this.inv)
/* 115 */         v = 1.0D - v; 
/* 116 */       if (v > 0.0D) {
/* 117 */         ColorImp.TMP.interpolate((GCOLOR.MAP()).F_NEAUTRAL, (GCOLOR.MAP()).F_ENEMY, v).bind();
/*     */       } else {
/* 119 */         (GCOLOR.MAP()).F_ALLY.bind();
/*     */       }  }
/* 121 */     else { (GCOLOR.MAP()).F_REBEL.bind(); }
/*     */ 
/*     */     
/* 124 */     renderUnder(m, r, it);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayRegAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */