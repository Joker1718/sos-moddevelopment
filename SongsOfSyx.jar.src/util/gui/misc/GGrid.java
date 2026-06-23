/*     */ package util.gui.misc;
/*     */ 
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ public class GGrid
/*     */ {
/*     */   private final ArrayList<RENDEROBJ> row;
/*  13 */   private int maxHeight = 0;
/*     */   
/*     */   private int startX;
/*     */   private int startY;
/*     */   private final int elements;
/*     */   private int width;
/*  19 */   private int marginY = 0;
/*     */   
/*     */   private int count;
/*  22 */   private DIR align = DIR.NW;
/*     */   
/*     */   public final GuiSection section;
/*     */   
/*     */   public GGrid(GuiSection section, int width, int elements, int x1, int y1) {
/*  27 */     this(section, width, elements, x1, y1, 0);
/*     */   }
/*     */   
/*     */   public GGrid(GuiSection section, int elements) {
/*  31 */     this(section, section.body().width(), elements, section.body().x1(), section.body().y1(), 0);
/*     */   }
/*     */   
/*     */   public GGrid(GuiSection section, int elements, int y1) {
/*  35 */     this(section, section.body().width(), elements, section.body().x1(), y1, 0);
/*     */   }
/*     */   
/*     */   public GGrid(GuiSection section, int width, int elements, int x1, int y1, int marginX) {
/*  39 */     this.startX = x1 + marginX;
/*  40 */     this.startY = y1;
/*  41 */     this.width = width - marginX * 2;
/*  42 */     this.elements = elements;
/*  43 */     this.section = section;
/*  44 */     this.row = new ArrayList(elements);
/*     */   }
/*     */   
/*     */   public GGrid setStartY(int y1) {
/*  48 */     this.startY = y1;
/*  49 */     return this;
/*     */   }
/*     */   
/*     */   public GGrid setAlignment(DIR align) {
/*  53 */     this.align = align;
/*  54 */     return this;
/*     */   }
/*     */   
/*     */   public void setTile(RENDEROBJ o) {
/*  58 */     o.body().moveY2((this.startY - 2));
/*  59 */     o.body().moveCX((this.startX + this.width / 2));
/*  60 */     this.section.add(o);
/*     */   }
/*     */   
/*     */   public void centered(RENDEROBJ o) {
/*  64 */     NL(8);
/*  65 */     o.body().moveY1((this.startY + 4));
/*  66 */     o.body().moveCX((this.startX + this.width / 2));
/*  67 */     this.section.add(o);
/*  68 */     this.count = 0;
/*  69 */     this.row.clear();
/*  70 */     this.maxHeight = 0;
/*  71 */     this.startY = this.section.getLastY2();
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(RENDEROBJ o) {
/*  76 */     if (o.body().height() > this.maxHeight) {
/*  77 */       this.maxHeight = o.body().height();
/*  78 */       int x = 0;
/*  79 */       for (RENDEROBJ r : this.row) {
/*  80 */         if (r != null) {
/*  81 */           align(x++, r);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     align(this.count, o);
/*  87 */     this.row.add(o);
/*  88 */     this.section.add(o);
/*     */     
/*  90 */     this.count++;
/*  91 */     if (this.count == this.row.max())
/*  92 */       NL(); 
/*     */   }
/*     */   
/*     */   private void align(int row, RENDEROBJ o) {
/*  96 */     int dw = this.width / this.elements;
/*  97 */     int x1 = this.startX + row % this.elements * dw;
/*  98 */     int y1 = this.startY;
/*  99 */     int dx = (int)Math.ceil((dw - o.body().width()) / 2.0D);
/* 100 */     int dy = (this.maxHeight - o.body().height()) / 2;
/*     */     
/* 102 */     int cx = x1 + dw / 2;
/* 103 */     int cy = y1 + this.maxHeight / 2;
/*     */     
/* 105 */     cx += this.align.x() * dx;
/* 106 */     cy += this.align.y() * dy;
/*     */     
/* 108 */     o.body().moveC(cx, cy);
/*     */   }
/*     */   
/*     */   public void skip() {
/* 112 */     if (this.count == 0)
/*     */       return; 
/* 114 */     this.count++;
/* 115 */     if (this.count == this.row.max())
/* 116 */       NL(); 
/*     */   }
/*     */   
/*     */   public void add(SPRITE s) {
/* 120 */     add((RENDEROBJ)new RENDEROBJ.Sprite(s));
/*     */   }
/*     */   
/*     */   public int sx(int i) {
/* 124 */     int dw = this.width / this.elements;
/* 125 */     return this.startX + i % this.elements * dw;
/*     */   }
/*     */ 
/*     */   
/*     */   public void NL() {
/* 130 */     this.startY += this.maxHeight + this.marginY;
/* 131 */     this.count = 0;
/* 132 */     this.row.clear();
/* 133 */     this.maxHeight = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void NL(int margin) {
/* 139 */     this.startY += this.maxHeight + margin;
/* 140 */     this.count = 0;
/* 141 */     this.row.clear();
/* 142 */     this.maxHeight = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public GGrid widthSet(int width) {
/* 147 */     this.width = width;
/* 148 */     return this;
/*     */   }
/*     */   
/*     */   public GGrid setMarginY(int y) {
/* 152 */     this.marginY = y;
/* 153 */     return this;
/*     */   }
/*     */   
/*     */   public GGrid incStartX(int x) {
/* 157 */     this.startX += x;
/* 158 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GGrid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */