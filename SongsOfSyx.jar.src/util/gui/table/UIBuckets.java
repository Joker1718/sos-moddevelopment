/*     */ package util.gui.table;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ public class UIBuckets
/*     */   extends GuiSection
/*     */ {
/*     */   private final int WIDTH;
/*     */   private final int HEIGHT;
/*     */   private UIBucketsCard dragging;
/*     */   private Column draggingTo;
/*     */   private final ArrayList<Card> cards;
/*     */   private final ArrayList<Column> columns;
/*     */   private final Column[] toSort;
/*     */   private boolean dirty = true;
/*     */   
/*  34 */   private final Comparator<Column> sorter = new Comparator<Column>()
/*     */     {
/*     */       public int compare(UIBuckets.Column o1, UIBuckets.Column o2)
/*     */       {
/*  38 */         int i1 = o1.cards - o1.height * UIBuckets.this.cards.size() / UIBuckets.this.columns.size();
/*  39 */         int i2 = o2.cards - o2.height * UIBuckets.this.cards.size() / UIBuckets.this.columns.size();
/*  40 */         return i2 - i1;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public UIBuckets(int width, LIST<SPRITE> bucketSprites, LIST<UIBucketsCard> cardSprites) {
/*  46 */     this.WIDTH = width;
/*  47 */     this.cards = new ArrayList(cardSprites.size());
/*  48 */     this.columns = new ArrayList(bucketSprites.size());
/*  49 */     this.toSort = new Column[bucketSprites.size()];
/*  50 */     for (UIBucketsCard g : cardSprites) {
/*  51 */       this.cards.add(new Card(g));
/*     */     }
/*     */     
/*  54 */     this.HEIGHT = ((Card)this.cards.get(0)).body.height() + 16;
/*     */     
/*  56 */     int m = (int)Math.ceil((this.cards.size() / (1 + this.WIDTH / ((Card)this.cards.get(0)).body().width())));
/*  57 */     m = CLAMP.i(m, 0, 2);
/*     */ 
/*     */ 
/*     */     
/*  61 */     int i = 0;
/*  62 */     for (SPRITE s : bucketSprites) {
/*  63 */       this.columns.add(new Column(i++, s));
/*     */     }
/*     */     
/*  66 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  75 */     if (this.dirty) {
/*  76 */       init();
/*  77 */       this.dragging = null;
/*  78 */       this.draggingTo = null;
/*  79 */       this.dirty = false;
/*     */     } 
/*     */     
/*  82 */     this.draggingTo = null;
/*     */     
/*  84 */     super.render(r, ds);
/*  85 */     if (!MButt.LEFT.isDown()) {
/*  86 */       if (this.draggingTo != null) {
/*  87 */         this.dragging.prio = this.draggingTo.pp;
/*  88 */         this.dirty = true;
/*     */       } 
/*  90 */       this.dragging = null;
/*  91 */       this.draggingTo = null;
/*  92 */     } else if (this.dragging != null) {
/*  93 */       if (MButt.RIGHT.consumeClick()) {
/*  94 */         this.dragging = null;
/*  95 */         this.draggingTo = null;
/*     */       } else {
/*  97 */         this.dragging.s.renderC(r, (COORDINATE)VIEW.mouse());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void init() {
/* 103 */     int x1 = body().x1();
/* 104 */     int y1 = body().y1();
/* 105 */     clear();
/*     */     
/* 107 */     for (Column c : this.columns) {
/* 108 */       this.toSort[c.pp] = c;
/* 109 */       c.cards = 0;
/* 110 */       c.height = 0;
/*     */     } 
/*     */     
/* 113 */     for (Card c : this.cards) {
/* 114 */       if (!isActive(c.g))
/*     */         continue; 
/* 116 */       (this.toSort[c.g.prio]).cards++;
/*     */     } 
/*     */     
/* 119 */     for (int i = 0; i <= this.columns.size() - 1; i++) {
/* 120 */       Arrays.sort(this.toSort, this.sorter);
/* 121 */       (this.toSort[0]).height++;
/*     */     } 
/*     */     
/* 124 */     for (Column c : this.columns) {
/* 125 */       c.init(this.cards);
/* 126 */       addDown(2, (RENDEROBJ)c);
/*     */     } 
/* 128 */     body().moveX1Y1(x1, y1);
/*     */   }
/*     */   
/*     */   private class Column
/*     */     extends GuiSection {
/*     */     private final int pp;
/*     */     private final SPRITE icon;
/*     */     int cards;
/* 136 */     int height = 0;
/*     */     
/*     */     Column(int prio, SPRITE icon) {
/* 139 */       this.pp = prio;
/* 140 */       body().setDim(UIBuckets.this.WIDTH, UIBuckets.this.HEIGHT);
/* 141 */       this.icon = icon;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 147 */       boolean hov = ((hoveredIs() & ((UIBuckets.this.dragging != null) ? 1 : 0)) != 0 && UIBuckets.this.dragging.prio != this.pp);
/*     */       
/* 149 */       if (hov)
/* 150 */         UIBuckets.this.draggingTo = this; 
/* 151 */       GButt.ButtPanel.renderBG(r, true, hov, hov, (RECTANGLE)body());
/*     */       
/* 153 */       GCOLOR.UI().border().renderFrame(r, (RECTANGLE)body(), 0, 1);
/* 154 */       super.render(r, ds);
/* 155 */       this.icon.renderC(r, body().x1() + 16, body().cY());
/*     */     }
/*     */ 
/*     */     
/*     */     void init(ArrayList<UIBuckets.Card> cards) {
/* 160 */       int am = 0;
/* 161 */       for (UIBuckets.Card c : cards) {
/* 162 */         if (!UIBuckets.this.isActive(c.g))
/*     */           continue; 
/* 164 */         if (c.g.prio == this.pp) {
/* 165 */           am++;
/*     */         }
/*     */       } 
/*     */       
/* 169 */       int x1 = body().x1();
/* 170 */       int y1 = body().y1();
/*     */       
/* 172 */       clear();
/* 173 */       body().setDim(UIBuckets.this.WIDTH, (UIBuckets.this.HEIGHT + this.height * 32));
/*     */       
/* 175 */       if (am == 0) {
/*     */         return;
/*     */       }
/* 178 */       int WW = UIBuckets.this.WIDTH - 32;
/*     */       
/* 180 */       int dist = (this.height + 1) * (WW - ((UIBuckets.Card)cards.get(0)).body.width()) / am;
/* 181 */       if (dist > ((UIBuckets.Card)cards.get(0)).body.width()) {
/* 182 */         dist = ((UIBuckets.Card)cards.get(0)).body.width();
/*     */       }
/*     */ 
/*     */       
/* 186 */       int sy = body().y1() + 8;
/* 187 */       int sx = body().x1() + 32;
/*     */ 
/*     */ 
/*     */       
/* 191 */       for (UIBuckets.Card c : cards) {
/* 192 */         if (!UIBuckets.this.isActive(c.g))
/*     */           continue; 
/* 194 */         if (c.g.prio == this.pp) {
/* 195 */           add((RENDEROBJ)c, sx, sy);
/* 196 */           sx += dist;
/* 197 */           if (sx + ((UIBuckets.Card)cards.get(0)).body.width() + 8 > body().x2()) {
/* 198 */             sy += 32;
/* 199 */             sx = body().x1() + 32;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 204 */       body().moveX1Y1(x1, y1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 209 */       GBox b = (GBox)text;
/* 210 */       super.hoverInfoGet((GUI_BOX)b);
/* 211 */       if (b.emptyIs()) {
/* 212 */         UIBuckets.this.hoverBucket(b, this.pp);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverBucket(GBox text, int bucket) {}
/*     */ 
/*     */   
/*     */   public void hoverCard(GBox text, UIBucketsCard c) {}
/*     */ 
/*     */   
/*     */   public boolean isActive(UIBucketsCard c) {
/* 226 */     return true;
/*     */   }
/*     */   
/*     */   private class Card
/*     */     extends GButt.ButtPanel {
/*     */     private final UIBuckets.UIBucketsCard g;
/*     */     
/*     */     Card(UIBuckets.UIBucketsCard g) {
/* 234 */       super(g.s);
/* 235 */       this.g = g;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 240 */       UIBuckets.this.dragging = this.g;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 245 */       selectedSet((UIBuckets.this.dragging == this.g));
/* 246 */       if (UIBuckets.this.dragging != null)
/* 247 */         this.isHovered = false; 
/* 248 */       super.renAction();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 253 */       UIBuckets.this.hoverCard((GBox)text, this.g);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBucket(UIBucketsCard c, int bucket) {
/* 259 */     c.prio = CLAMP.i(bucket, 0, this.columns.size() - 1);
/*     */   }
/*     */   
/*     */   public static class UIBucketsCard
/*     */   {
/* 264 */     int prio = 0;
/*     */     final SPRITE s;
/*     */     public final Object o;
/*     */     
/*     */     public UIBucketsCard(SPRITE s, Object o) {
/* 269 */       this.s = s;
/* 270 */       this.o = o;
/*     */     }
/*     */     
/*     */     public int prio() {
/* 274 */       return this.prio;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\UIBuckets.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */