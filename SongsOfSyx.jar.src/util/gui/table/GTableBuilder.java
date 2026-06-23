/*     */ package util.gui.table;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.ColorShifting;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.Scrollable;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GTableBuilder
/*     */ {
/*  31 */   private final ArrayListResize<HOVERABLE> titles = new ArrayListResize(10, 20);
/*  32 */   private final ArrayListShort widths = new ArrayListShort(20);
/*  33 */   private final ArrayListResize<GRowBuilder> cells = new ArrayListResize(10, 20);
/*  34 */   private final ArrayListResize<DIR> dirs = new ArrayListResize(10, 20);
/*  35 */   public static final COLOR cHovered = (COLOR)new ColorImp(28, 23, 53);
/*  36 */   public static final COLOR cSelected = (COLOR)new ColorShifting(cHovered, (COLOR)cHovered.shade(1.5D));
/*     */   private GScrollable scroller;
/*     */   
/*     */   public void column(CharSequence title, int width, GRowBuilder ren) {
/*  40 */     column(title, width, ren, DIR.W);
/*     */   }
/*     */   private static final int M = 3;
/*     */   
/*     */   public void column(int width, GRowBuilder ren, DIR d) {
/*  45 */     column((HOVERABLE)null, width, ren, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void column(CharSequence title, int width, GRowBuilder ren, DIR d) {
/*  50 */     GTextR gTextR = (title != null && title.length() > 0) ? (new GText((UI.FONT()).S, title)).lablifySub().r(DIR.NW) : null;
/*  51 */     column((HOVERABLE)gTextR, width, ren, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void column(HOVERABLE t, int width, GRowBuilder ren, DIR d) {
/*  56 */     this.titles.add(t);
/*  57 */     this.widths.add(width);
/*  58 */     this.cells.add(ren);
/*  59 */     this.dirs.add(d);
/*     */   }
/*     */   
/*     */   public GuiSection createHeight(int heightt, boolean decorate) {
/*  63 */     int height = 0;
/*  64 */     GETTER.GETTER_IMP<Integer> inin = new GETTER.GETTER_IMP();
/*  65 */     for (int k = 0; k < this.titles.size(); k++) {
/*  66 */       if (this.cells.get(k) != null) {
/*  67 */         RENDEROBJ o = ((GRowBuilder)this.cells.get(k)).build((GETTER<Integer>)inin);
/*  68 */         if (o.body().height() > height)
/*  69 */           height = o.body().height(); 
/*     */       } 
/*     */     } 
/*  72 */     height += decorate ? 6 : 0;
/*  73 */     if (this.titles.size() > 0) {
/*  74 */       for (RENDEROBJ s : this.titles) {
/*  75 */         if (s != null) {
/*  76 */           heightt -= (UI.FONT()).M.height();
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*  81 */     int rows = heightt / height;
/*  82 */     if (rows <= 0)
/*  83 */       rows = 1; 
/*  84 */     return create(rows, decorate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiSection create(int rows, final boolean decorate) {
/*  91 */     if (rows < 0)
/*  92 */       rows = 0; 
/*  93 */     Scrollable.ScrollRow[] rs = new Scrollable.ScrollRow[rows];
/*  94 */     int width = 0;
/*  95 */     int height = 0;
/*  96 */     GETTER.GETTER_IMP<Integer> inin = new GETTER.GETTER_IMP();
/*  97 */     for (int k = 0; k < this.titles.size(); k++) {
/*  98 */       if (this.cells.get(k) != null) {
/*  99 */         RENDEROBJ o = ((GRowBuilder)this.cells.get(k)).build((GETTER<Integer>)inin);
/* 100 */         if (o.body().height() > height)
/* 101 */           height = o.body().height(); 
/*     */       } 
/* 103 */       width += this.widths.get(k) + 6;
/*     */     } 
/*     */     
/* 106 */     width += decorate ? 8 : 0;
/* 107 */     height += decorate ? 6 : 0;
/* 108 */     for (int i = 0; i < rows; i++) {
/*     */       
/* 110 */       final GETTER.GETTER_IMP<Integer> in = new GETTER.GETTER_IMP();
/*     */       
/* 112 */       Scrollable.ScrollRow.ScrollRowImp row = new Scrollable.ScrollRow.ScrollRowImp()
/*     */         {
/* 114 */           float clickT = 0.0F;
/*     */ 
/*     */           
/*     */           public void init(int index) {
/* 118 */             in.set(Integer.valueOf(index));
/*     */           }
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 123 */             if (decorate) {
/* 124 */               boolean isHovered = hoveredIs();
/* 125 */               boolean isSelected = GTableBuilder.this.selectedIs(((Integer)in.get()).intValue());
/* 126 */               GButt.BSection.renderBG(r, (RECTANGLE)body(), true, isHovered, isSelected);
/*     */             } 
/* 128 */             if (this.clickT >= 0.0F)
/* 129 */               this.clickT -= ds; 
/* 130 */             super.render(r, ds);
/* 131 */             if (!GTableBuilder.this.activeIs(((Integer)in.get()).intValue())) {
/* 132 */               OPACITY.O50.bind();
/* 133 */               COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 134 */               OPACITY.unbind();
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean hover(COORDINATE mCoo) {
/* 141 */             if (super.hover(mCoo)) {
/* 142 */               GTableBuilder.this.hover(((Integer)in.get()).intValue());
/* 143 */               return true;
/*     */             } 
/* 145 */             GTableBuilder.this.hover(-1);
/* 146 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 151 */             super.hoverInfoGet(text);
/* 152 */             GTableBuilder.this.hoverInfo(((Integer)in.get()).intValue(), (GBox)text);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean click() {
/* 158 */             if (!super.click()) {
/* 159 */               if (this.clickT > 0.0F) {
/* 160 */                 GTableBuilder.this.doubleClick(((Integer)in.get()).intValue());
/* 161 */                 this.clickT = 0.0F;
/*     */               } else {
/* 163 */                 this.clickT = 0.3F;
/*     */               } 
/*     */               
/* 166 */               return true;
/*     */             } 
/* 168 */             return false;
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 173 */       row.body().setWidth(width).setHeight(height);
/*     */ 
/*     */       
/* 176 */       int m = 0;
/* 177 */       for (int n = 0; n < this.titles.size(); n++) {
/* 178 */         if (this.cells.get(n) != null) {
/* 179 */           RENDEROBJ o = ((GRowBuilder)this.cells.get(n)).build((GETTER<Integer>)in);
/* 180 */           DIR d = (DIR)this.dirs.get(n);
/*     */           
/* 182 */           int x1 = m + 3;
/*     */           
/* 184 */           if (d.x() < 0) {
/* 185 */             o.body().moveX1(x1);
/* 186 */           } else if (m > 0) {
/* 187 */             o.body().moveX2((x1 + this.widths.get(n)));
/*     */           } else {
/* 189 */             o.body().moveCX((x1 + this.widths.get(n) / 2));
/*     */           } 
/* 191 */           if (d.y() < 0) {
/* 192 */             o.body().moveY1(0.0D);
/* 193 */           } else if (d.y() > 0) {
/* 194 */             o.body().moveY2(height);
/*     */           } else {
/* 196 */             o.body().moveCY((height / 2));
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 206 */           if (decorate && n > 0) {
/* 207 */             row.add((RENDEROBJ)new RENDEROBJ.RenderImp(2, height - 4)
/*     */                 {
/*     */                   public void render(SPRITE_RENDERER r, float ds)
/*     */                   {
/* 211 */                     GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/*     */                   }
/* 214 */                 }m, o.body().cY() - (height - 4) / 2);
/*     */           }
/* 216 */           row.add(o);
/*     */         } 
/*     */         
/* 219 */         m += this.widths.get(n) + 6;
/*     */       } 
/*     */ 
/*     */       
/* 223 */       row.clickActionSet(new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 227 */               GTableBuilder.this.click(((Integer)in.get()).intValue());
/*     */             }
/*     */           });
/*     */       
/* 231 */       row.body().setWidth(m);
/* 232 */       rs[i] = (Scrollable.ScrollRow)row;
/*     */     } 
/*     */ 
/*     */     
/* 236 */     this.scroller = new GScrollable(rs)
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 240 */           return GTableBuilder.this.nrOFEntries();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     GuiSection guiSection1 = this.scroller.getView();
/*     */ 
/*     */     
/* 250 */     GuiSection res = new GuiSection();
/*     */     
/* 252 */     boolean title = false;
/* 253 */     RENDEROBJ last = null;
/*     */     
/* 255 */     int x = 0;
/* 256 */     for (int j = 0; j < this.titles.size(); j++) {
/* 257 */       if (this.titles.get(j) != null) {
/* 258 */         if (!title) {
/* 259 */           title = true;
/* 260 */           guiSection1.body().incrY(16.0D);
/*     */         } 
/*     */         
/* 263 */         int x1 = x;
/* 264 */         int y1 = 0;
/*     */         
/* 266 */         RENDEROBJ o = (RENDEROBJ)this.titles.get(j);
/*     */         
/* 268 */         int dx = this.widths.get(j) - o.body().width() - 6;
/* 269 */         o.body().moveY1(y1);
/* 270 */         DIR d = (DIR)this.dirs.get(j);
/* 271 */         o.body().moveX1((x + 3) + (dx * (d.x() + 1)) / 2.0D);
/*     */         
/* 273 */         if ((j & 0x1) == 1 && (o.body().width() > this.widths.get(j) - 10 || (last != null && last.body().width() > this.widths.get(j - 1) - 10)))
/* 274 */           o.body().moveY2(0.0D); 
/* 275 */         if (decorate) {
/* 276 */           res.add((RENDEROBJ)new RENDEROBJ.RenderImp(2, -o.body().y1() + o.body().height())
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds)
/*     */                 {
/* 280 */                   GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/*     */                 }
/* 283 */               }x1, o.body().y1() + 2);
/*     */         }
/*     */ 
/*     */         
/* 287 */         res.add(o);
/* 288 */         last = o;
/*     */       } else {
/* 290 */         last = null;
/*     */       } 
/* 292 */       x += this.widths.get(j) + 6;
/*     */     } 
/*     */     
/* 295 */     res.add((RENDEROBJ)guiSection1);
/*     */     
/* 297 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int nrOFEntries();
/*     */ 
/*     */   
/*     */   public void click(int index) {}
/*     */ 
/*     */   
/*     */   public void doubleClick(int index) {}
/*     */ 
/*     */   
/*     */   public void hover(int index) {}
/*     */ 
/*     */   
/*     */   public final void set(int index) {
/* 315 */     this.scroller.set(index);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(int index, GBox box) {}
/*     */ 
/*     */   
/*     */   public boolean selectedIs(int index) {
/* 323 */     return false;
/*     */   }
/*     */   
/*     */   public boolean activeIs(int index) {
/* 327 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class GRowBuilder
/*     */   {
/*     */     public abstract RENDEROBJ build(GETTER<Integer> param1GETTER);
/*     */   }
/*     */   
/*     */   public final void pad(int width) {
/* 337 */     int x = 0;
/* 338 */     for (int k = 0; k < this.titles.size(); k++) {
/* 339 */       x += this.widths.get(k);
/*     */     }
/* 341 */     if (x < width)
/* 342 */       column("", width - x, (GRowBuilder)null); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GTableBuilder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */