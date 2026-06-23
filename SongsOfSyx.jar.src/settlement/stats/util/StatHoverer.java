/*     */ package settlement.stats.util;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.stat.SETT_STATISTICS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public class StatHoverer
/*     */ {
/*  25 */   private static CharSequence ¤¤Liked = "¤This is liked by your {0}. Higher value = more fulfillment.";
/*  26 */   private static CharSequence ¤¤Dislike = "¤This is disliked by your {0}. Higher value = less fulfillment.";
/*  27 */   private static CharSequence ¤¤DontCare = "¤Your {0} don't care about this and its value has no effect on fulfillment";
/*     */   
/*  29 */   private static CharSequence ¤¤ValueCurrent = "¤Current value: ";
/*  30 */   private static CharSequence ¤¤FulfillmentValue = "¤Current Fulfillment: ";
/*     */   
/*  32 */   private static CharSequence ¤¤HistoryValue = "¤History Value (days)";
/*  33 */   private static CharSequence ¤¤HistoryFulfillment = "¤History Fulfillment (days)";
/*  34 */   private static CharSequence ¤¤toReachMAx = "¤To reach max fulfillment, value needs to be : {0}%";
/*     */   
/*     */   static {
/*  37 */     D.ts(StatHoverer.class);
/*     */   }
/*     */   
/*  40 */   private static UtilGraph h1 = new UtilGraph();
/*  41 */   private static UtilGraph h2 = new UtilGraph();
/*     */   
/*     */   public static void hover(GUI_BOX text, STAT s) {
/*  44 */     GBox b = (GBox)text;
/*  45 */     b.title((s.info()).name);
/*  46 */     b.text((s.info()).desc);
/*  47 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hover(GUI_BOX text, STAT s, HCLASS cl, Race type) {
/*  52 */     GBox b = (GBox)text;
/*  53 */     double max = s.standing().max(cl, type);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     double m = s.standing().get(cl, type, 0.0D);
/*  60 */     double mm = s.standing().get(cl, type, 1.0D);
/*  61 */     if (m == mm) {
/*  62 */       GText t = b.text();
/*  63 */       t.add(¤¤DontCare);
/*  64 */       t.insert(0, cl.names);
/*  65 */       b.add((SPRITE)t);
/*  66 */     } else if (m > mm) {
/*  67 */       b.add((SPRITE)(SPRITES.icons()).m.arrow_down);
/*  68 */       GText t = b.text();
/*  69 */       t.add(¤¤Dislike);
/*  70 */       t.insert(0, cl.names);
/*  71 */       t.errorify();
/*  72 */       b.add((SPRITE)t);
/*     */     } else {
/*  74 */       b.add((SPRITE)(SPRITES.icons()).m.arrow_up);
/*  75 */       GText t = b.text();
/*  76 */       t.add(¤¤Liked);
/*  77 */       t.insert(0, cl.names);
/*  78 */       t.normalify2();
/*  79 */       b.add((SPRITE)t);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     b.NL(8);
/*     */     
/*  88 */     b.textL(¤¤ValueCurrent);
/*  89 */     b.tab(7);
/*     */     
/*  91 */     b.add((SPRITE)format(b.text(), s, s.data(cl).getD(type), cl, type));
/*  92 */     if (s.info().isInt()) {
/*  93 */       b.add((SPRITE)b.text().add('(').add((int)(s.data(cl).getD(type) * 100.0D)).add('%').add(')'));
/*     */     }
/*     */ 
/*     */     
/*  97 */     double d = s.data(cl).getD(type) - s.data().getD(type, 1);
/*  98 */     b.tab(11);
/*  99 */     b.add((SPRITE)GFORMAT.percInc(b.text(), d));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     b.NL();
/*     */     
/* 107 */     if (max > 0.0D) {
/*     */ 
/*     */ 
/*     */       
/* 111 */       b.textL(¤¤FulfillmentValue);
/* 112 */       b.tab(7);
/* 113 */       b.add((SPRITE)GFORMAT.fofkInv(b.text(), s.standing().get(cl, type), max));
/* 114 */       d = s.standing().get(cl, type) - s.standing().getHistoric(cl, type, 1);
/* 115 */       b.tab(11);
/* 116 */       b.add((SPRITE)GFORMAT.f0(b.text(), d));
/* 117 */       b.NL();
/*     */       
/* 119 */       if (type != null) {
/* 120 */         GText t = b.text();
/* 121 */         t.add(¤¤toReachMAx);
/* 122 */         if (!(s.standing().definition(type)).inverted) {
/* 123 */           double e = ((s.standing().definition(type)).exp == null) ? 1.0D : (s.standing().definition(type)).exp.pow;
/* 124 */           e = Math.pow(1.0D, -e) / (s.standing().definition(type)).mul;
/* 125 */           t.insert(0, (int)(100.0D * e));
/*     */         } else {
/* 127 */           t.insert(0, 0);
/* 128 */         }  b.add((SPRITE)t);
/* 129 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     b.NL(16);
/* 134 */     b.textLL(¤¤HistoryValue);
/* 135 */     if (max > 0.0D) {
/* 136 */       b.tab(8);
/* 137 */       b.textLL(¤¤HistoryFulfillment);
/*     */     } 
/*     */     
/* 140 */     b.NL(4);
/* 141 */     b.add(h1.init(cl, (SETT_STATISTICS)s, s.info().isInt(), type, true));
/* 142 */     if (max > 0.0D) {
/* 143 */       b.tab(8);
/* 144 */       b.add(h2.init(cl, (SETT_STATISTICS)s, s.info().isInt(), type, false));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hover(GUI_BOX text, STAT s, Induvidual indu) {
/* 151 */     HCLASS cl = indu.clas();
/* 152 */     Race type = indu.race();
/* 153 */     GBox b = (GBox)text;
/*     */     
/* 155 */     b.NL(8);
/*     */     
/* 157 */     double max = s.standing().max(cl, type);
/*     */ 
/*     */     
/* 160 */     double m = s.standing().get(cl, type, 0.0D);
/* 161 */     double mm = s.standing().get(cl, type, 1.0D);
/*     */     
/* 163 */     if (m == mm) {
/* 164 */       GText t = b.text();
/* 165 */       t.add(¤¤DontCare);
/* 166 */       t.insert(0, cl.names);
/* 167 */       b.add((SPRITE)t);
/* 168 */     } else if (m > mm) {
/* 169 */       b.add((SPRITE)(SPRITES.icons()).m.arrow_down);
/* 170 */       GText t = b.text();
/* 171 */       t.add(¤¤Dislike);
/* 172 */       t.insert(0, cl.names);
/* 173 */       t.errorify();
/* 174 */       b.add((SPRITE)t);
/*     */     } else {
/* 176 */       b.add((SPRITE)(SPRITES.icons()).m.arrow_up);
/* 177 */       GText t = b.text();
/* 178 */       t.add(¤¤Liked);
/* 179 */       t.insert(0, cl.names);
/* 180 */       t.normalify2();
/* 181 */       b.add((SPRITE)t);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 186 */     b.NL(8);
/*     */     
/* 188 */     b.textL(¤¤ValueCurrent);
/* 189 */     b.tab(7);
/* 190 */     if (s.info().isInt()) {
/* 191 */       b.add((SPRITE)format(b.text(), s, s.indu().getD(indu), cl, indu.race()));
/* 192 */       b.add((SPRITE)b.text().add('(').add((int)(s.indu().getD(indu) * 100.0D)).add('%').add(')'));
/*     */     } else {
/*     */       
/* 195 */       b.add((SPRITE)format(b.text(), s, s.indu().getD(indu), cl, indu.race()));
/* 196 */       if ((s.standing.definition(indu.race())).mul != 1.0D) {
/*     */         
/* 198 */         GText t = b.text();
/* 199 */         t.add('-').add('>').s();
/* 200 */         t.add((s.standing.definition(indu.race())).mul).s().add('x').add(s.indu().getD(indu), 2).s().add('=').s();
/* 201 */         t.add((s.standing.definition(indu.race())).mul * s.indu().getD(indu), 2);
/* 202 */         b.add((SPRITE)t);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 207 */     b.NL();
/*     */     
/* 209 */     if (max > 0.0D) {
/* 210 */       b.textL(¤¤FulfillmentValue);
/* 211 */       b.tab(7);
/* 212 */       b.add((SPRITE)GFORMAT.fofkInv(b.text(), s.standing().get(indu), max));
/* 213 */       b.NL();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static GText format(GText t, STAT s, double v, HCLASS cl, Race race) {
/* 219 */     if (race == null) {
/* 220 */       if (s.info().isInt()) {
/* 221 */         return GFORMAT.f(t, v * s.dataDivider());
/*     */       }
/* 223 */       return GFORMAT.perc(t, v).normalify();
/*     */     } 
/*     */ 
/*     */     
/* 227 */     double d = (race.stats().def(s.standing()).get(cl)).to - (race.stats().def(s.standing()).get(cl)).from;
/* 228 */     if (s.info().isInt()) {
/* 229 */       double m = s.dataDivider();
/* 230 */       double n = v * s.dataDivider();
/*     */       
/* 232 */       if (d > 0.0D)
/* 233 */         return GFORMAT.f0(t, n, m); 
/* 234 */       if (d < 0.0D) {
/* 235 */         return GFORMAT.f0Inv(t, n, m);
/*     */       }
/* 237 */       return GFORMAT.f(t, n);
/*     */     } 
/*     */     
/* 240 */     if (d > 0.0D)
/* 241 */       return GFORMAT.perc(t, v); 
/* 242 */     if (d < 0.0D) {
/* 243 */       return GFORMAT.percInv(t, v);
/*     */     }
/* 245 */     return GFORMAT.perc(t, v).normalify();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SPRITE chart(HCLASS cl, SETT_STATISTICS s, Race race, boolean isInt, boolean isValue) {
/* 252 */     h1.init(cl, s, isInt, race, isValue);
/* 253 */     return h1;
/*     */   }
/*     */   
/*     */   private static class UtilGraph
/*     */     implements SPRITE {
/* 258 */     private final GStaples staples = new GStaples(32)
/*     */       {
/*     */         protected void hover(GBox box, int stapleI) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 268 */           int fromZero = 32 - stapleI - 1;
/* 269 */           if (!StatHoverer.UtilGraph.this.valuev && StatHoverer.UtilGraph.this.global instanceof STAT) {
/*     */             
/* 271 */             STAT s = (STAT)StatHoverer.UtilGraph.this.global;
/* 272 */             double m = s.standing.max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race);
/* 273 */             if (m <= 0.0D)
/* 274 */               return 0.0D; 
/* 275 */             if (s.standing().max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, fromZero) > 0.0D) {
/* 276 */               return s.standing().get(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, StatHoverer.UtilGraph.this.global.data(StatHoverer.UtilGraph.this.c).getD(StatHoverer.UtilGraph.this.race, fromZero)) / m;
/*     */             }
/*     */           } 
/*     */           
/* 280 */           return StatHoverer.UtilGraph.this.global.data(StatHoverer.UtilGraph.this.c).getD(StatHoverer.UtilGraph.this.race, fromZero);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void setColor(ColorImp col, int stapleI, double value) {
/* 285 */           int fromZero = 32 - stapleI - 1;
/*     */           
/* 287 */           if (!StatHoverer.UtilGraph.this.valuev && StatHoverer.UtilGraph.this.global instanceof STAT) {
/* 288 */             STAT s = (STAT)StatHoverer.UtilGraph.this.global;
/* 289 */             if (s.standing().max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, fromZero) > 0.0D) {
/* 290 */               col.set((GCOLOR.UI()).NEUTRAL.normal);
/*     */               return;
/*     */             } 
/*     */           } 
/* 294 */           col.set(COLOR.WHITE65);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void setColorBg(ColorImp col, int stapleI, double value) {
/* 300 */           col.set(COLOR.WHITE05);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     private SETT_STATISTICS global;
/*     */     private HCLASS c;
/*     */     private Race race;
/*     */     private boolean valuev;
/*     */     
/*     */     UtilGraph() {
/* 311 */       this.staples.body().setDim(250.0D, 64.0D);
/* 312 */       this.staples.normalize(false);
/*     */     }
/*     */     
/*     */     SPRITE init(HCLASS c, SETT_STATISTICS global, boolean isInt, Race race, boolean isValue) {
/* 316 */       this.valuev = isValue;
/* 317 */       this.c = c;
/* 318 */       this.global = global;
/* 319 */       this.race = race;
/* 320 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 325 */       return this.staples.body().width();
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 330 */       return this.staples.body().height();
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 335 */       this.staples.body().moveX1Y1(X1, Y1);
/* 336 */       this.staples.render(r, 0.0F);
/*     */     }
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stat\\util\StatHoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */