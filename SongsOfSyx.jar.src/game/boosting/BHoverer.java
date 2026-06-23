/*     */ package game.boosting;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.ArrayListInt;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class BHoverer {
/*  13 */   private static final ArrayListInt sort = new ArrayListInt(1024);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void hoverDetailed(GUI_BOX box, LIST<? extends BoosterAbs<T>> all, T f, CharSequence name, double baseValue, boolean keepNops) {
/*  22 */     GBox b = (GBox)box;
/*  23 */     if (name != null)
/*  24 */       b.textLL(name); 
/*  25 */     b.NL();
/*     */     
/*  27 */     if (baseValue != 0.0D)
/*  28 */       BoosterAbs.hover(box, baseValue, 0, (SPRITE)(UI.icons()).s.dot, false, Dic.¤¤BaseValue); 
/*  29 */     box.NL();
/*     */     
/*  31 */     for (BoosterAbs<T> l : all) {
/*  32 */       double d = l.get(f);
/*     */ 
/*     */ 
/*     */       
/*  36 */       if (!l.isMul && d != 0.0D) {
/*  37 */         l.hover(box, d);
/*  38 */         BoosterAbs.hoverSpan(box, l.from(), l.to());
/*  39 */         box.NL();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  44 */     b.NL(4);
/*     */     
/*  46 */     for (BoosterAbs<T> l : all) {
/*  47 */       double d = l.get(f);
/*  48 */       if (l.isMul && d != 1.0D) {
/*  49 */         l.hover(box, d);
/*  50 */         BoosterAbs.hoverSpan(box, l.from(), l.to());
/*  51 */         box.NL();
/*     */       } 
/*     */     } 
/*     */     
/*  55 */     tot(box, all, f, baseValue);
/*     */     
/*  57 */     if (keepNops) {
/*  58 */       b.NL(4);
/*     */       
/*  60 */       for (BoosterAbs<T> l : all) {
/*  61 */         double d = l.get(f);
/*  62 */         if (!l.isMul && d == 0.0D) {
/*  63 */           l.hover(box, d);
/*  64 */           BoosterAbs.hoverSpan(box, l.from(), l.to());
/*  65 */           box.NL();
/*     */         } 
/*     */       } 
/*  68 */       for (BoosterAbs<T> l : all) {
/*  69 */         double d = l.get(f);
/*  70 */         if (l.isMul && d == 1.0D) {
/*  71 */           l.hover(box, d);
/*  72 */           BoosterAbs.hoverSpan(box, l.from(), l.to());
/*  73 */           box.NL();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  79 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> void hover(GUI_BOX box, LIST<? extends BoosterAbs<T>> all, T f, CharSequence name, double baseValue, boolean keepNops) {
/*  84 */     GBox b = (GBox)box;
/*  85 */     hoverNoTot(box, all, f, name, baseValue, keepNops);
/*     */     
/*  87 */     b.NL(8);
/*     */     
/*  89 */     tot(box, all, f, baseValue);
/*  90 */     b.NL(8);
/*     */     
/*  92 */     if (keepNops) {
/*  93 */       int t = 0;
/*  94 */       for (BoosterAbs<T> l : all) {
/*  95 */         if (t > 1) {
/*  96 */           t = 0;
/*  97 */           b.NL();
/*     */         } 
/*  99 */         double d = l.get(f);
/* 100 */         if (l.isMul && d == 1.0D) {
/* 101 */           hov(f, b, l, t++); continue;
/* 102 */         }  if (!l.isMul && d == 0.0D) {
/* 103 */           hov(f, b, l, t++);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void hoverNoTot(GUI_BOX box, LIST<? extends BoosterAbs<T>> all, T f, CharSequence name, double baseValue, boolean keepNops) {
/* 114 */     GBox b = (GBox)box;
/* 115 */     if (name != null)
/* 116 */       b.textLL(name); 
/* 117 */     b.NL();
/*     */     
/* 119 */     sort.clear();
/* 120 */     int ii = 0;
/* 121 */     for (BoosterAbs<T> l : all) {
/* 122 */       double d = l.get(f);
/* 123 */       if (d > 0.0D && !l.isMul) {
/* 124 */         sort.add(ii);
/*     */       }
/* 126 */       ii++;
/*     */     } 
/* 128 */     int i = 0;
/* 129 */     for (BoosterAbs<T> l : all) {
/* 130 */       double d = l.get(f);
/* 131 */       if (d < 0.0D && !l.isMul) {
/* 132 */         if (i < sort.size()) {
/* 133 */           hov(f, b, (BoosterAbs<T>)all.get(sort.get(i)), 0);
/* 134 */           i++;
/*     */         } 
/* 136 */         hov(f, b, l, 1);
/* 137 */         b.NL();
/*     */       } 
/*     */     } 
/* 140 */     for (; i < sort.size(); i++) {
/* 141 */       hov(f, b, (BoosterAbs<T>)all.get(sort.get(i)), 0);
/* 142 */       b.NL();
/*     */     } 
/*     */     
/* 145 */     b.NL(4);
/* 146 */     sort.clear();
/* 147 */     ii = 0;
/* 148 */     for (BoosterAbs<T> l : all) {
/* 149 */       double d = l.get(f);
/* 150 */       if (d > 1.0D && l.isMul) {
/* 151 */         sort.add(ii);
/*     */       }
/* 153 */       ii++;
/*     */     } 
/* 155 */     i = 0;
/* 156 */     for (BoosterAbs<T> l : all) {
/* 157 */       double d = l.get(f);
/* 158 */       if (d < 1.0D && l.isMul) {
/* 159 */         if (i < sort.size()) {
/* 160 */           hov(f, b, (BoosterAbs<T>)all.get(sort.get(i)), 0);
/* 161 */           i++;
/*     */         } 
/* 163 */         hov(f, b, l, 1);
/* 164 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     for (; i < sort.size(); i++) {
/* 169 */       hov(f, b, (BoosterAbs<T>)all.get(sort.get(i)), 0);
/* 170 */       b.NL();
/*     */     } 
/*     */     
/* 173 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> void tot(GUI_BOX box, LIST<? extends BoosterAbs<T>> all, T t, double baseValue) {
/* 178 */     double mul = 1.0D;
/* 179 */     double padd = (baseValue > 0.0D) ? baseValue : 0.0D;
/* 180 */     double sub = (baseValue < 0.0D) ? baseValue : 0.0D;
/* 181 */     for (BoosterAbs<T> s : all) {
/* 182 */       if (s.isMul) {
/* 183 */         mul *= s.get(t); continue;
/*     */       } 
/* 185 */       double a = s.get(t);
/* 186 */       if (a < 0.0D) {
/* 187 */         sub += a; continue;
/*     */       } 
/* 189 */       padd += a;
/*     */     } 
/*     */ 
/*     */     
/* 193 */     double tot = padd * mul + sub;
/*     */     
/* 195 */     GBox b = (GBox)box;
/* 196 */     b.tab(1);
/* 197 */     b.textL(Dic.¤¤Total);
/* 198 */     b.tab(5);
/*     */     
/* 200 */     b.add((SPRITE)GFORMAT.f0(b.text(), padd));
/* 201 */     b.add((SPRITE)b.text().add('*'));
/* 202 */     b.add((SPRITE)GFORMAT.f1(b.text(), mul));
/* 203 */     if (sub != 0.0D)
/* 204 */       b.add((SPRITE)GFORMAT.f0(b.text(), sub)); 
/* 205 */     b.add((SPRITE)b.text().add('='));
/*     */     
/* 207 */     b.add((SPRITE)GFORMAT.fRel(b.text(), tot, baseValue));
/* 208 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> void hov(T f, GBox b, BoosterAbs<T> l, int tab) {
/* 214 */     l.hover((GUI_BOX)b, l.get(f), tab);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BHoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */