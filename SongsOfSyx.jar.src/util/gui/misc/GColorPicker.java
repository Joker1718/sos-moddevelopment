/*     */ package util.gui.misc;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.text.D;
/*     */ 
/*     */ public abstract class GColorPicker extends GuiSection {
/*  14 */   private static CharSequence ¤¤color = "¤color";
/*  15 */   private static CharSequence ¤¤red = "¤red";
/*  16 */   private static CharSequence ¤¤green = "¤green";
/*  17 */   private static CharSequence ¤¤blue = "¤blue";
/*     */   static {
/*  19 */     D.ts(GColorPicker.class);
/*     */   }
/*     */   
/*     */   public GColorPicker(boolean glow) {
/*  23 */     this(glow, ¤¤color);
/*     */   }
/*     */   
/*     */   public GColorPicker(boolean glow, CharSequence name) {
/*  27 */     final int max = glow ? 255 : 127;
/*  28 */     int w = 120;
/*  29 */     GSliderInt r = new GSliderInt(new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  33 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  38 */             return max;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  43 */             return GColorPicker.this.color().red() & 0xFF;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  49 */             GColorPicker.this.color().setRed(t);
/*  50 */             GColorPicker.this.change();
/*     */           }
/*     */         }, 
/*  53 */         w, false);
/*  54 */     r.addRelBody(8, DIR.W, (SPRITE)(new GText((UI.FONT()).S, ¤¤red)).lablify());
/*  55 */     GSliderInt g = new GSliderInt(new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  59 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  64 */             return max;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  69 */             return GColorPicker.this.color().green() & 0xFF;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  74 */             GColorPicker.this.color().setGreen(t);
/*  75 */             GColorPicker.this.change();
/*     */           }
/*  77 */         },  w, false);
/*  78 */     g.addRelBody(8, DIR.W, (SPRITE)(new GText((UI.FONT()).S, ¤¤green)).lablify());
/*  79 */     GSliderInt b = new GSliderInt(new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  83 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  88 */             return max;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  93 */             return GColorPicker.this.color().blue() & 0xFF;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  98 */             GColorPicker.this.color().setBlue(t);
/*  99 */             GColorPicker.this.change();
/*     */           }
/* 101 */         },  w, false);
/* 102 */     b.addRelBody(8, DIR.W, (SPRITE)(new GText((UI.FONT()).S, ¤¤blue)).lablify());
/*     */     
/* 104 */     add((RENDEROBJ)r);
/* 105 */     g.body().moveX2(r.body().x2());
/* 106 */     g.body().moveY1(r.body().y2());
/* 107 */     add((RENDEROBJ)g);
/* 108 */     b.body().moveX2(g.body().x2());
/* 109 */     b.body().moveY1(g.body().y2());
/* 110 */     add((RENDEROBJ)b);
/*     */     
/* 112 */     addRelBody(4, DIR.N, (SPRITE)(new GText((UI.FONT()).H2, name)).lablify());
/*     */   }
/*     */   
/*     */   public void change() {}
/*     */   
/*     */   public abstract ColorImp color();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GColorPicker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */