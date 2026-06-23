/*     */ package util.gui.table;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderVer;
/*     */ 
/*     */ public class GScrollRows {
/*     */   private final RENDEROBJ[] rows;
/*  16 */   private final GuiSection srows = new GuiSection(); private final ArrayList<RENDEROBJ> current;
/*  17 */   private final GuiSection section = new GuiSection()
/*     */     {
/*     */       
/*     */       public void render(SPRITE_RENDERER r, float ds)
/*     */       {
/*  22 */         if (hoveredIs()) {
/*  23 */           double d = MButt.clearWheelSpin();
/*  24 */           if (d > 0.0D) {
/*  25 */             GScrollRows.this.first--;
/*  26 */           } else if (d < 0.0D) {
/*  27 */             GScrollRows.this.first++;
/*     */           } 
/*     */         } 
/*  30 */         GScrollRows.this.init();
/*  31 */         super.render(r, ds);
/*     */       }
/*     */     };
/*  34 */   private int first = 0;
/*     */   private int last;
/*     */   public final INT.INTE target;
/*     */   
/*     */   public GScrollRows(Iterable<? extends RENDEROBJ> rows, int height) {
/*  39 */     this(convert(rows), height, 0);
/*     */   }
/*     */   
/*     */   public GScrollRows(Iterable<RENDEROBJ> rows, int height, int width) {
/*  43 */     this(convert(rows), height, width - GSliderVer.WIDTH());
/*     */   }
/*     */   
/*     */   public GScrollRows(Iterable<RENDEROBJ> rows, int height, int width, boolean slide) {
/*  47 */     this(convert(rows), height, width - GSliderVer.WIDTH(), slide);
/*     */   }
/*     */   
/*     */   public GScrollRows(RENDEROBJ[] renrows, int height, int width) {
/*  51 */     this(renrows, height, width, true);
/*     */   }
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
/*     */   private static RENDEROBJ[] convert(Iterable<? extends RENDEROBJ> rows) {
/*  73 */     int size = 0;
/*  74 */     for (RENDEROBJ r : rows)
/*  75 */       size++; 
/*  76 */     RENDEROBJ[] rs = new RENDEROBJ[size];
/*  77 */     size = 0;
/*  78 */     for (RENDEROBJ r : rows)
/*  79 */       rs[size++] = r; 
/*  80 */     return rs;
/*     */   }
/*     */   
/*     */   public void init() {
/*  84 */     this.current.clearSloppy();
/*     */     
/*  86 */     for (int i = 0; i < this.rows.length; i++) {
/*  87 */       if (passesFilter(i, this.rows[i])) {
/*  88 */         this.current.add(this.rows[i]);
/*     */       }
/*     */     } 
/*     */     
/*  92 */     int h = 0;
/*  93 */     this.last = 0; int j;
/*  94 */     for (j = this.current.size() - 1; j >= 0; j--) {
/*  95 */       h += ((RENDEROBJ)this.current.get(j)).body().height();
/*  96 */       if (h > this.section.body().height()) {
/*  97 */         this.last = j + 1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 102 */     this.first = CLAMP.i(this.first, 0, this.last);
/* 103 */     this.srows.clear();
/* 104 */     this.srows.body().moveX1Y1((RECTANGLE)this.section.body());
/*     */     
/* 106 */     for (j = this.first; j < this.current.size(); j++) {
/* 107 */       RENDEROBJ rr = (RENDEROBJ)this.current.get(j);
/* 108 */       if (this.srows.body().height() + rr.body().height() > this.section.body().height())
/*     */         break; 
/* 110 */       this.srows.add(rr, this.srows.body().x1(), this.srows.getLastY2());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean passesFilter(int i, RENDEROBJ o) {
/* 118 */     return true;
/*     */   }
/*     */   
/*     */   public CLICKABLE view() {
/* 122 */     return (CLICKABLE)this.section;
/*     */   }
/*     */   public GScrollRows(RENDEROBJ[] renrows, int height, int width, boolean slide) {
/* 125 */     this.target = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 129 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 134 */           return GScrollRows.this.last;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 139 */           return GScrollRows.this.first;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 144 */           GScrollRows.this.first = t;
/* 145 */           GScrollRows.this.init();
/*     */         }
/*     */       };
/*     */     this.rows = renrows;
/*     */     this.current = new ArrayList(renrows.length);
/*     */     this.section.body().setHeight(height);
/*     */     int w = width;
/*     */     byte b;
/*     */     int i;
/*     */     RENDEROBJ[] arrayOfRENDEROBJ;
/*     */     for (i = (arrayOfRENDEROBJ = this.rows).length, b = 0; b < i; ) {
/*     */       RENDEROBJ r = arrayOfRENDEROBJ[b];
/*     */       if (r.body().width() > w)
/*     */         w = r.body().width(); 
/*     */       b++;
/*     */     } 
/*     */     this.section.body().setWidth(w);
/*     */     if (slide) {
/*     */       GSliderVer slider = new GSliderVer(this.target, height);
/*     */       this.section.add((RENDEROBJ)slider, this.section.body().x2(), this.section.body().y1());
/*     */     } 
/*     */     this.srows.body().moveX1Y1((RECTANGLE)this.section.body());
/*     */     this.section.add((RENDEROBJ)this.srows);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GScrollRows.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */