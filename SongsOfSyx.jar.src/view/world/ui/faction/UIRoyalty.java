/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UIRoyalty
/*     */ {
/*     */   static class Portrait
/*     */     extends PortraitAbs
/*     */   {
/*     */     final GETTER<Royalty> g;
/*     */     
/*     */     public Portrait(int scale, GETTER<Royalty> g) {
/*  25 */       super(scale);
/*  26 */       this.g = g;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  31 */       super.render(r, X1, X2, Y1, Y2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Induvidual indu() {
/*  36 */       return ((Royalty)this.g.get()).induvidual;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int succ() {
/*  41 */       return ((Royalty)this.g.get()).successionI();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  47 */   private static final ArrayList<COLOR> cols = new ArrayList((Object[])new ColorImp[] {
/*  48 */         new ColorImp(127, 127, 50), 
/*  49 */         new ColorImp(100, 100, 100), 
/*  50 */         new ColorImp(88, 75, 62)
/*     */       });
/*     */ 
/*     */   
/*     */   public static void render(SPRITE_RENDERER r, int X1, int Y1, Royalty roy, int scale) {
/*  55 */     if (roy == null) {
/*     */       return;
/*     */     }
/*  58 */     int y = Y1;
/*     */     
/*  60 */     Induvidual ro = roy.induvidual;
/*     */     
/*  62 */     STATS.APPEARANCE().portraitRender(r, ro, X1, y, scale);
/*     */     
/*  64 */     int X2 = X1 + scale * 40;
/*     */     
/*  66 */     if (roy.successionI() == 0) {
/*  67 */       ((SPRITE)(ro.race().appearance()).crown.crowns().get(0)).renderScaled(r, X1, Y1 + 8 * scale, scale);
/*     */     } else {
/*  69 */       ((COLOR)cols.getC(roy.successionI() - 1)).bind();
/*  70 */       int w = scale / 2;
/*  71 */       w = CLAMP.i(w, 1, 2);
/*  72 */       (UI.icons()).s.star.render(r, X2 - 16 * w - 4, X2 - 4, Y1 + 4, Y1 + 4 + w * 16);
/*  73 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class PortraitAbs
/*     */     extends SPRITE.Imp
/*     */   {
/*     */     final int scale;
/*     */ 
/*     */     
/*     */     public PortraitAbs(int scale) {
/*  85 */       super(40 * scale, 64 * scale);
/*  86 */       this.scale = scale;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  91 */       Induvidual ro = indu();
/*     */       
/*  93 */       if (ro == null) {
/*     */         return;
/*     */       }
/*  96 */       int y = Y1;
/*     */       
/*  98 */       STATS.APPEARANCE().portraitRender(r, ro, X1, y, this.scale);
/*     */       
/* 100 */       if (succ() == 0) {
/* 101 */         ((SPRITE)(ro.race().appearance()).crown.crowns().get(0)).renderScaled(r, X1, y + 8 * this.scale, this.scale);
/*     */       } else {
/* 103 */         ((COLOR)UIRoyalty.cols.getC(succ() - 1)).bind();
/* 104 */         int w = this.scale / 2;
/* 105 */         w = CLAMP.i(w, 1, 2);
/* 106 */         (UI.icons()).s.star.render(r, X2 - 16 * w - 4, X2 - 4, Y1 + 4, Y1 + 4 + w * 16);
/* 107 */         COLOR.unbind();
/*     */       } 
/*     */     }
/*     */     
/*     */     protected abstract Induvidual indu();
/*     */     
/*     */     protected abstract int succ();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIRoyalty.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */