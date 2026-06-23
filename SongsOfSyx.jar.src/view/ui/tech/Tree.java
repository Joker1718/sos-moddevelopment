/*     */ package view.ui.tech;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.tech.TechTree;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderHor;
/*     */ import util.gui.slider.GSliderVer;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class Tree extends GuiSection {
/*     */   private final NodeCreator rows;
/*  23 */   private GuiSection content = new GuiSection();
/*     */   private final int dh;
/*     */   private final int dw;
/*     */   private boolean dragging = false;
/*  27 */   private Coo dragCoo = new Coo();
/*  28 */   private Coo dragXY = new Coo();
/*     */ 
/*     */   
/*     */   Tree(TechTree tree, int height, int width) {
/*  32 */     width -= 24;
/*     */ 
/*     */ 
/*     */     
/*  36 */     body().setDim(width, height);
/*  37 */     add((RENDEROBJ)this.content);
/*     */     
/*  39 */     this.rows = new NodeCreator(tree);
/*     */     
/*  41 */     for (RENDEROBJ rr : this.rows.rows) {
/*  42 */       this.content.addDown(0, rr);
/*     */     }
/*     */     
/*  45 */     this.dh = this.content.body().height() - height;
/*  46 */     this.dw = this.content.body().width() - width;
/*     */     
/*  48 */     add((SPRITE)new SPRITE.Imp(0)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  52 */             COLOR.WHITE15.render(r, 0, C.WIDTH(), 0, Tree.this.body().y1() - 16);
/*  53 */             if (Tree.this.dh > 0) {
/*  54 */               COLOR.WHITE15.render(r, Tree.this.body().x2() - 32, C.WIDTH(), 0, C.HEIGHT());
/*     */             }
/*     */             
/*  57 */             if (Tree.this.dw > 0) {
/*  58 */               COLOR.WHITE15.render(r, 0, C.WIDTH(), Tree.this.body().y2() - 32, C.HEIGHT());
/*     */             
/*     */             }
/*     */           }
/*  62 */         }0, 0);
/*     */     
/*  64 */     if (this.dh > 0) {
/*     */       
/*  66 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  70 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  75 */             return Tree.this.dh;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  80 */             return Tree.this.body().y1() - Tree.this.content.body().y1();
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  85 */             Tree.this.content.body().moveY1((Tree.this.body().y1() - t));
/*     */           }
/*     */         };
/*     */       
/*  89 */       GSliderVer sl = new GSliderVer(ii, height - 32);
/*  90 */       sl.body().moveY1(body().y1());
/*  91 */       sl.body().moveX2((body().width() - 6));
/*     */       
/*  93 */       add((RENDEROBJ)sl);
/*     */     } 
/*     */     
/*  96 */     if (this.dw > 0) {
/*     */       
/*  98 */       INT.IntImp ii = new INT.IntImp(0, this.dw)
/*     */         {
/*     */           public void set(int t) {
/* 101 */             t = CLAMP.i(t, 0, Tree.this.dw);
/* 102 */             Tree.this.content.body().moveX1(-t);
/* 103 */             super.set(t);
/*     */           }
/*     */         };
/* 106 */       GSliderHor sl = new GSliderHor((INT.INTE)ii, width);
/* 107 */       sl.body().moveY2((body().y2() - 6));
/* 108 */       sl.body().moveX1(body().x1());
/*     */       
/* 110 */       add((RENDEROBJ)sl);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     adjust(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void moveCallback() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 129 */     this.dragging &= MButt.LEFT.isDown();
/*     */     
/* 131 */     if (this.dragging) {
/*     */       
/* 133 */       if (this.dw > 0) {
/* 134 */         int x1 = this.dragXY.x() + VIEW.mouse().x() - this.dragCoo.x();
/* 135 */         x1 = CLAMP.i(x1, body().x1() - this.dw, body().x1());
/* 136 */         this.content.body().moveX1(x1);
/*     */       } 
/* 138 */       if (this.dh > 0) {
/* 139 */         int y1 = this.dragXY.y() + VIEW.mouse().y() - this.dragCoo.y();
/* 140 */         y1 = CLAMP.i(y1, body().y1() - this.dh, body().y1());
/* 141 */         this.content.body().moveY1(y1);
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 147 */     else if (body().holdsPoint((COORDINATE)VIEW.mouse())) {
/* 148 */       double d = (MButt.clearWheelSpin() * Node.HEIGHT());
/* 149 */       if ((KEYS.MAIN()).MOD.isPressed() && 
/* 150 */         this.dw > 0) {
/* 151 */         int x1 = (int)(this.content.body().x1() + d);
/* 152 */         x1 = CLAMP.i(x1, body().x1() - this.dw, body().x1());
/* 153 */         this.content.body().moveX1(x1);
/* 154 */         d = 0.0D;
/*     */       } 
/*     */       
/* 157 */       if (this.dh > 0) {
/* 158 */         int y1 = (int)(this.content.body().y1() + d);
/* 159 */         y1 = CLAMP.i(y1, body().y1() - this.dh, body().y1());
/* 160 */         this.content.body().moveY1(y1);
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 171 */     if ((!super.click() || (this.content.hoveredIs() && this.content.getHovered() instanceof RENDEROBJ)) && 
/* 172 */       hoveredIs()) {
/* 173 */       this.dragging = true;
/* 174 */       this.dragCoo.set((COORDINATE)VIEW.mouse());
/* 175 */       this.dragXY.set(this.content.body().x1(), this.content.body().y1());
/*     */     } 
/*     */     
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void adjust(int fr) {
/* 185 */     int x1 = this.content.body().x1();
/* 186 */     int y1 = this.content.body().y1();
/* 187 */     int w = this.content.body().width();
/* 188 */     int h = this.content.body().height();
/* 189 */     this.content.clear();
/* 190 */     this.content.body().setDim(w, h);
/* 191 */     this.content.body().moveX1Y1(x1, y1);
/* 192 */     int y = y1;
/*     */ 
/*     */     
/* 195 */     int dy = 0;
/* 196 */     for (int i = 0; i < fr; i++) {
/* 197 */       dy += ((RENDEROBJ)this.rows.rows.get(i)).body().height();
/*     */     }
/* 199 */     y -= dy;
/*     */ 
/*     */ 
/*     */     
/* 203 */     for (RENDEROBJ rr : this.rows.rows) {
/*     */       
/* 205 */       int hi = rr.body().height();
/*     */ 
/*     */       
/* 208 */       rr.body().moveX1(x1);
/* 209 */       rr.body().moveY1(y);
/*     */       
/* 211 */       if (y >= y1 && y + hi <= this.content.body().y2()) {
/* 212 */         this.content.add(rr);
/*     */       }
/*     */       
/* 215 */       y += hi;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Tree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */