/*     */ package util.gui.misc;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.colors.GCOLOR;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public class GChart
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private static final int max = 16;
/*     */   private static final int M = 1;
/*  28 */   private double[] dividers = new double[16];
/*  29 */   private final ArrayList<HISTORY> entries = new ArrayList(16);
/*     */   
/*  31 */   private COLOR[] colors = new COLOR[16];
/*  32 */   private CharSequence[] lables = new CharSequence[16];
/*     */   private int steps;
/*  34 */   private int hoverI = -1;
/*     */   private double smallestCycle;
/*     */   private TIMECYCLE smallest;
/*     */   private CharSequence title;
/*  38 */   private static final GText tText = new GText((UI.FONT()).M, 128);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean legend = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  50 */     if (this.entries.size() == 0)
/*     */       return; 
/*  52 */     this.steps = 0;
/*  53 */     for (HISTORY h : this.entries) {
/*  54 */       if (h.historyRecords() > this.steps)
/*  55 */         this.steps = h.historyRecords(); 
/*  56 */     }  if (this.steps == 0) {
/*     */       return;
/*     */     }
/*  59 */     Font f = (UI.FONT()).M;
/*  60 */     int y1 = this.body.y1();
/*  61 */     if (this.title != null) {
/*  62 */       y1 += f.height();
/*     */     }
/*     */ 
/*     */     
/*  66 */     int height = this.body.y2() - y1;
/*  67 */     if (this.legend) {
/*  68 */       height -= (UI.FONT()).M.height();
/*     */     }
/*     */     
/*  71 */     renderStaples(r, this.body.x1(), y1, this.body.width(), height);
/*     */     
/*  73 */     if (this.legend) {
/*  74 */       tText.clear().add(-this.steps);
/*  75 */       tText.add(' ');
/*  76 */       tText.add(this.smallest.cycleNames());
/*  77 */       (UI.FONT()).M.renderC(r, this.body.cX(), y1 + height, (CharSequence)tText);
/*     */     } 
/*     */     
/*  80 */     if (this.title != null) {
/*  81 */       tText.clear().set(this.title);
/*  82 */       tText.lablify();
/*  83 */       int w = tText.width();
/*  84 */       int x1 = this.body.cX() - w / 2;
/*  85 */       tText.render(r, x1, this.body.y1());
/*     */       
/*  87 */       tText.clear();
/*     */       
/*  89 */       int am = 0;
/*     */       
/*  91 */       for (int i = 0; i < this.entries.size(); i++)
/*  92 */         am = (int)(am + ((HISTORY)this.entries.get(i)).getD() / this.dividers[i]); 
/*  93 */       GFORMAT.i(tText, am);
/*  94 */       tText.render(r, x1 + w + 10, this.body.y1());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderStaples(SPRITE_RENDERER r, int x1, int y1, int width, int height) {
/* 101 */     int dx = (width - (this.steps - 1) * 1) / this.steps;
/*     */     
/* 103 */     x1 += (width - (dx + 1) * this.steps) / 2;
/*     */     
/* 105 */     height -= 10;
/*     */     
/* 107 */     if (dx <= 0)
/*     */       return; 
/* 109 */     double biggestValue = 0.0D;
/* 110 */     this.smallestCycle = Double.MAX_VALUE;
/* 111 */     this.smallest = null;
/* 112 */     for (HISTORY e : this.entries) {
/* 113 */       if (e.time().cycleSeconds() < this.smallestCycle) {
/* 114 */         this.smallestCycle = e.time().cycleSeconds();
/* 115 */         this.smallest = e.time();
/*     */       } 
/* 117 */       for (int j = 0; j < e.historyRecords(); j++) {
/* 118 */         if (e.getD(j) > biggestValue)
/* 119 */           biggestValue = e.getD(j); 
/*     */       } 
/*     */     } 
/* 122 */     for (int i = this.steps - 1; i >= 0; i--) {
/*     */ 
/*     */       
/* 125 */       int x = x1 + (this.steps - 1 - i) * (dx + 1);
/* 126 */       if (i == this.hoverI) {
/* 127 */         COLOR.WHITE15WHITE50.render(r, x, x + dx + 1, y1, y1 + height);
/*     */       }
/*     */       
/* 130 */       for (int ei = 0; ei < this.entries.size(); ei++) {
/* 131 */         HISTORY e = (HISTORY)this.entries.get(ei);
/* 132 */         int hi = (int)(i * e.time().cycleSeconds() / this.smallestCycle);
/*     */         
/* 134 */         if (hi < e.historyRecords()) {
/*     */           
/* 136 */           double v = e.getD(hi);
/* 137 */           int h = (int)(height * v / biggestValue);
/*     */ 
/*     */ 
/*     */           
/* 141 */           int y = y1 + height - h;
/*     */           
/* 143 */           if (i != this.hoverI)
/* 144 */             OPACITY.O66.bind(); 
/* 145 */           ColorImp.TMP.interpolate(this.colors[ei], COLOR.BLACK, 0.5D);
/* 146 */           if (dx >= 3 && height > 3) {
/* 147 */             ColorImp.TMP.render(r, x, x + dx, y, y1 + height);
/* 148 */             this.colors[ei].render(r, x + 1, x + dx - 1, y + 1, y1 + height - 1);
/* 149 */           } else if (dx > 0 && height > 0) {
/* 150 */             ColorImp.TMP.render(r, x, x + dx, y, y1 + height);
/*     */           } 
/*     */           
/* 153 */           OPACITY.unbind();
/*     */         } 
/*     */       } 
/* 156 */       x += dx + 1;
/*     */       
/* 158 */       if (i % 10 == 0) {
/* 159 */         COLOR.WHITE100.render(r, x - 2, x + 1, y1 + height, y1 + height + 10);
/* 160 */       } else if (i % 5 == 0) {
/* 161 */         COLOR.WHITE100.render(r, x - 1, x, y1 + height, y1 + height + 8);
/*     */       } else {
/* 163 */         COLOR.WHITE100.render(r, x - 1, x, y1 + height + 1, y1 + height + 5);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 168 */     this.hoverI = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 174 */     this.hoverI = -1;
/* 175 */     if (super.hover(mCoo)) {
/* 176 */       this.steps = 0;
/* 177 */       for (HISTORY h : this.entries) {
/* 178 */         if (h.historyRecords() > this.steps)
/* 179 */           this.steps = h.historyRecords(); 
/* 180 */       }  if (this.steps == 0)
/* 181 */         return true; 
/* 182 */       int dx = (this.body.width() - (this.steps - 1) * 1) / this.steps;
/*     */       
/* 184 */       int x1 = this.body.x1() + (this.body.width() - (dx + 1) * this.steps) / 2;
/* 185 */       if (mCoo.x() - x1 >= 0) {
/* 186 */         int h = (mCoo.x() - x1) / (dx + 1);
/* 187 */         if (h < this.steps)
/* 188 */           this.hoverI = this.steps - 1 - h; 
/*     */       } 
/* 190 */       return true;
/*     */     } 
/* 192 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 197 */     if (this.hoverI < 0)
/*     */       return; 
/* 199 */     if (this.smallest == null)
/*     */       return; 
/* 201 */     hoverInfo(this.hoverI, this.smallestCycle, (GBox)text, (LIST<HISTORY>)this.entries, this.colors);
/*     */   }
/*     */   
/* 204 */   private static CharSequence ¤¤current = "¤Current"; public final SPRITE sprite;
/*     */   
/*     */   public GChart() {
/* 207 */     D.ts(GChart.class);
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
/*     */ 
/*     */     
/* 265 */     this.sprite = new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 269 */           return GChart.this.body().width();
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 274 */           return GChart.this.body().height();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 285 */           GChart.this.body().moveX1Y1(X1, Y1);
/* 286 */           GChart.this.render(r, 0.0F, false);
/*     */         }
/*     */       };
/*     */     body().setDim(300.0D, 100.0D);
/*     */   }
/*     */   
/*     */   protected void hoverInfo(int h, double secondSpan, GBox box, LIST<HISTORY> hs, COLOR[] colors) {
/*     */     if (h == 0) {
/*     */       box.add((SPRITE)box.text().add(¤¤current).add(' ').add(this.smallest.cycleName()));
/*     */     } else {
/*     */       box.add((SPRITE)box.text().add('-').add(h).add(' ').add(this.smallest.cycleNames()));
/*     */     } 
/*     */     box.NL();
/*     */     for (int i = 0; i < hs.size(); i++) {
/*     */       int index = (int)(h * secondSpan / ((HISTORY)hs.get(i)).time().cycleSeconds());
/*     */       hoverInfo(index, box, (HISTORY)hs.get(i), colors[i], this.lables[i]);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void hoverInfo(int back, GBox box, HISTORY hs, COLOR color, CharSequence label) {
/*     */     int index = back;
/*     */     if (index < hs.historyRecords()) {
/*     */       if (label != null)
/*     */         box.add((SPRITE)box.text().color(color).add(label)); 
/*     */       box.add((SPRITE)box.text().color(color).add(hs.getD(index)));
/*     */     } 
/*     */     box.NL();
/*     */   }
/*     */   
/*     */   public void clear() {
/*     */     this.entries.clear();
/*     */   }
/*     */   
/*     */   public void add(HISTORY entry, double divider, COLOR color, CharSequence name) {
/*     */     int i = this.entries.add(entry);
/*     */     this.dividers[i] = divider;
/*     */     this.colors[i] = color;
/*     */     this.lables[i] = name;
/*     */   }
/*     */   
/*     */   public void add(HISTORY entry) {
/*     */     add(entry, 1.0D, (GCOLOR.T()).NORMAL, (CharSequence)null);
/*     */   }
/*     */   
/*     */   public void title(CharSequence title) {
/*     */     this.title = title;
/*     */   }
/*     */   
/*     */   public GChart legend() {
/*     */     this.legend = true;
/*     */     return this;
/*     */   }
/*     */   
/*     */   public SPRITE sprite(HISTORY h) {
/*     */     clear();
/*     */     add(h);
/*     */     return this.sprite;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GChart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */