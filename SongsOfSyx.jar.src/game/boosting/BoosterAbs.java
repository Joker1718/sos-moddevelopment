/*     */ package game.boosting;
/*     */ 
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ public abstract class BoosterAbs<T>
/*     */ {
/*     */   public final BSourceInfo info;
/*     */   public final boolean isMul;
/*     */   private static final int htab = 7;
/*     */   
/*     */   public BoosterAbs(BSourceInfo info, boolean isMul) {
/*  19 */     this.info = info;
/*  20 */     this.isMul = isMul;
/*     */   }
/*     */   
/*     */   public abstract double from();
/*     */   
/*     */   public abstract double to();
/*     */   
/*     */   public double min() {
/*  28 */     return Math.min(from(), to());
/*     */   }
/*     */   
/*     */   public double max() {
/*  32 */     return Math.max(from(), to());
/*     */   }
/*     */   
/*     */   public abstract double getValue(double paramDouble);
/*     */   
/*     */   public double get(T o) {
/*  38 */     return getValue(pget(o));
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract double pget(T paramT);
/*     */ 
/*     */   
/*     */   public boolean isPositive(double input) {
/*  46 */     return !((!this.isMul || getValue(input) < 1.0D) && getValue(input) <= 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverSpan(GUI_BOX box, T o) {
/*  52 */     hoverSpan(box, get(o));
/*     */   }
/*     */   
/*     */   public void hoverSpan(GUI_BOX box, double value) {
/*  56 */     hoverSpan(box, from(), to());
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, double value) {
/*  60 */     hover(box, value, 0);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, double d, int tab) {
/*  64 */     hover(box, d, tab, this.info.icon, this.isMul, this.info.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hover(GUI_BOX box, double d, int tab, SPRITE icon, boolean isMul, CharSequence name) {
/*  69 */     GBox b = (GBox)box;
/*  70 */     b.tab(tab * 9);
/*  71 */     b.add(icon);
/*     */     
/*  73 */     if (!isMul) {
/*  74 */       COLOR c = (GCOLOR.T()).INACTIVE;
/*  75 */       if (d < 0.0D) {
/*  76 */         c = (GCOLOR.T()).IBAD;
/*  77 */       } else if (d > 0.0D) {
/*  78 */         c = (GCOLOR.T()).IGOOD;
/*     */       } 
/*     */       
/*  81 */       b.add((SPRITE)b.text().color(c).add(name));
/*  82 */       b.tab(tab * 9 + 7);
/*     */       
/*  84 */       GText t = b.text();
/*  85 */       if (d == (int)d) {
/*  86 */         GFORMAT.iIncr(t, (int)d);
/*     */       } else {
/*  88 */         GFORMAT.f0(t, d);
/*  89 */       }  t.color(c);
/*  90 */       b.add((SPRITE)t);
/*     */     } else {
/*     */       
/*  93 */       COLOR c = (GCOLOR.T()).INACTIVE;
/*  94 */       if (d < 1.0D) {
/*  95 */         c = (GCOLOR.T()).IBAD;
/*  96 */       } else if (d > 1.0D) {
/*  97 */         c = (GCOLOR.T()).IGOOD;
/*  98 */       }  b.add((SPRITE)b.text().color(c).add(name));
/*  99 */       b.tab(tab * 9 + 7);
/*     */       
/* 101 */       GText t = b.text();
/* 102 */       t.add('*');
/* 103 */       GFORMAT.f1(t, d);
/* 104 */       t.color(c);
/* 105 */       b.add((SPRITE)t);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hoverSpan(GUI_BOX box, double from, double to) {
/* 112 */     GBox b = (GBox)box;
/* 113 */     b.tab(9);
/*     */     
/* 115 */     GText t = b.text();
/* 116 */     t.color(COLOR.WHITE65);
/*     */     
/* 118 */     t.add('(');
/* 119 */     t.add(from);
/* 120 */     b.add((SPRITE)t);
/* 121 */     b.tab(11);
/*     */     
/* 123 */     t = b.text();
/* 124 */     t.color(COLOR.WHITE65);
/*     */     
/* 126 */     t.add('<').add('-').add('>').s();
/* 127 */     t.add(to);
/* 128 */     t.add(')');
/* 129 */     b.add((SPRITE)t);
/* 130 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public GText format(GText t, double value) {
/* 135 */     return format(t, value, this.isMul);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText format(GText t, double value, boolean isMul) {
/* 142 */     if (isMul) {
/* 143 */       t.add('*').s();
/* 144 */       GFORMAT.f1(t, value);
/*     */     }
/* 146 */     else if (value == (int)value) {
/* 147 */       GFORMAT.iIncr(t, (int)value);
/*     */     } else {
/* 149 */       GFORMAT.f0(t, value);
/*     */     } 
/* 151 */     return t;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoosterAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */