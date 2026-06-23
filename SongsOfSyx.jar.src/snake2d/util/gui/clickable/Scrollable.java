/*     */ package snake2d.util.gui.clickable;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ 
/*     */ public abstract class Scrollable {
/*  11 */   private final GuiSection section = new GuiSection()
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds)
/*     */       {
/*  15 */         if (Scrollable.this.nrOfElements != Scrollable.this.nrOFEntries()) {
/*  16 */           Scrollable.this.move(Scrollable.this.itemTop);
/*     */         }
/*     */         
/*  19 */         super.render(r, ds);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean hover(COORDINATE mCoo) {
/*  24 */         boolean ret = super.hover(mCoo);
/*  25 */         if (hoveredIs()) {
/*  26 */           double dw = MButt.clearWheelSpin();
/*  27 */           if (Scrollable.this.nrOfElements != Scrollable.this.nrOFEntries() || (hoveredIs() && dw != 0.0D)) {
/*  28 */             Scrollable.this.move(Scrollable.this.itemTop + (int)-dw);
/*     */           }
/*     */         } 
/*  31 */         return ret;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  36 */   private final GuiSection elements = new GuiSection();
/*  37 */   private int itemTop = -1;
/*  38 */   private int nrOfElements = 0;
/*     */   
/*     */   private final int elementsY;
/*     */   private final int offY1;
/*     */   private final int width;
/*     */   private final ScrollRow[] rows;
/*     */   
/*     */   public Scrollable(RENDEROBJ title, ScrollRow... rows) {
/*  46 */     int h = 0;
/*  47 */     int w = 0; byte b; int i; ScrollRow[] arrayOfScrollRow;
/*  48 */     for (i = (arrayOfScrollRow = rows).length, b = 0; b < i; ) { ScrollRow s = arrayOfScrollRow[b];
/*  49 */       h += s.body().height();
/*  50 */       if (s.body().width() > w)
/*  51 */         w = s.body().width();  b++; }
/*     */     
/*  53 */     this.width = w;
/*  54 */     this.rows = rows;
/*  55 */     int height = h;
/*     */ 
/*     */     
/*  58 */     this.elementsY = rows.length;
/*  59 */     if (this.width <= 0 || height <= 0) {
/*  60 */       throw new RuntimeException(String.valueOf(this.width) + " " + height + " " + rows.length);
/*     */     }
/*  62 */     this.elements.body().setDim(this.width, height);
/*  63 */     this.section.add((RENDEROBJ)this.elements);
/*     */ 
/*     */     
/*  66 */     if (title != null) {
/*  67 */       title.body().centerX((BODY_HOLDER)this.section);
/*  68 */       title.body().moveY2(this.section.body().y1());
/*  69 */       this.section.add(title);
/*  70 */       this.offY1 = title.body().height();
/*     */     } else {
/*  72 */       this.offY1 = 0;
/*     */     } 
/*  74 */     this.nrOfElements = -1;
/*  75 */     this.itemTop = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void move(int first) {
/*  81 */     if (first >= nrOFEntries() - this.elementsY) {
/*  82 */       first = nrOFEntries() - this.elementsY;
/*     */     }
/*  84 */     if (first < 0) {
/*  85 */       first = 0;
/*     */     }
/*  87 */     if (this.itemTop == first && this.nrOfElements == nrOFEntries()) {
/*     */       return;
/*     */     }
/*  90 */     this.nrOfElements = nrOFEntries();
/*  91 */     this.itemTop = first;
/*  92 */     this.elements.clear();
/*     */     
/*  94 */     int real = this.itemTop;
/*  95 */     int virtual = 0;
/*     */     
/*  97 */     int y1 = this.elements.body().y1();
/*     */     
/*  99 */     while (real < nrOFEntries() && virtual < this.elementsY) {
/* 100 */       RENDEROBJ r = getElement(virtual, real);
/* 101 */       real++;
/* 102 */       if (r != null) {
/* 103 */         r.body().moveX1(this.elements.body().x1());
/* 104 */         r.body().moveY1(y1);
/* 105 */         this.elements.add(r);
/* 106 */         y1 += r.body().height();
/* 107 */         virtual++;
/*     */       } 
/*     */     } 
/* 110 */     this.elements.body().moveX1(this.section.body().x1());
/* 111 */     this.elements.body().moveY1((this.section.body().y1() + this.offY1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final RENDEROBJ getElement(int virtual, int real) {
/* 117 */     this.rows[virtual].init(real);
/* 118 */     return this.rows[virtual];
/*     */   }
/*     */   
/*     */   public final GuiSection getView() {
/* 122 */     return this.section;
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface ScrollRow
/*     */     extends RENDEROBJ
/*     */   {
/*     */     void init(int param1Int);
/*     */ 
/*     */     
/*     */     public static class ScrollRowImp
/*     */       extends GuiSection
/*     */       implements ScrollRow
/*     */     {
/*     */       public void init(int index) {}
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int min() {
/* 142 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 147 */     return nrOFEntries() - this.rows.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/* 152 */     return this.itemTop;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int t) {
/* 157 */     move(t);
/* 158 */     this.nrOfElements = nrOFEntries();
/*     */   }
/*     */   
/*     */   public abstract int nrOFEntries();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\gui\clickable\Scrollable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */