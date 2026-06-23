/*     */ package view.tool;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PlacableFixedTool
/*     */   extends ToolPlacer.placeFunc
/*     */ {
/*     */   private PlacableFixed placable;
/*  26 */   private final ArrayList<CLICKABLE> butts = new ArrayList(3);
/*  27 */   private final CLICKABLE bIncrease = KeyButt.wrap((CLICKABLE)new GButt.Panel((SPRITE)(SPRITES.icons()).m.plus)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  31 */           activeSet((PlacableFixedTool.this.placable.size() < PlacableFixedTool.this.placable.sizes() - 1));
/*     */         }
/*     */         
/*     */         protected void clickA() {
/*  35 */           if (PlacableFixedTool.this.placable.size() < PlacableFixedTool.this.placable.sizes() - 1)
/*  36 */             PlacableFixedTool.this.placable.sizeSet(PlacableFixedTool.this.placable.size() + 1); 
/*     */         }
/*  38 */       }(KEYS.MAIN()).GROW);
/*  39 */   private final CLICKABLE bDecrease = KeyButt.wrap((CLICKABLE)new GButt.Panel((SPRITE)(SPRITES.icons()).m.minus)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  43 */           activeSet((PlacableFixedTool.this.placable.size() > 0));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  48 */           if (PlacableFixedTool.this.placable.size() > 0)
/*  49 */             PlacableFixedTool.this.placable.sizeSet(PlacableFixedTool.this.placable.size() - 1); 
/*     */         }
/*  51 */       }(KEYS.MAIN()).SHRINK);
/*  52 */   private final CLICKABLE bRotate = KeyButt.wrap((CLICKABLE)new GButt.Panel((SPRITE)(SPRITES.icons()).m.rotate)
/*     */       {
/*     */         protected void clickA() {
/*  55 */           int r = PlacableFixedTool.this.placable.rot() + 1;
/*  56 */           r %= PlacableFixedTool.this.placable.rotations();
/*  57 */           PlacableFixedTool.this.placable.rotSet(r);
/*     */         }
/*  59 */       }(KEYS.MAIN()).ROTATE);
/*     */ 
/*     */ 
/*     */   
/*     */   void updateHovered(float ds, GameWindow window, boolean pressed) {
/*  64 */     double s = MButt.peekWheel();
/*  65 */     if ((KEYS.MAIN()).MOD.isPressed() && s != 0.0D) {
/*     */       
/*  67 */       if (s > 0.0D && this.placable.size() < this.placable.sizes() - 1) {
/*  68 */         this.placable.sizeSet(this.placable.size() + 1);
/*  69 */       } else if (s < 0.0D && this.placable.size() > 0) {
/*  70 */         this.placable.sizeSet(this.placable.size() - 1);
/*     */       } 
/*  72 */       MButt.clearWheelSpin();
/*     */     } 
/*     */     
/*  75 */     if ((KEYS.MAIN()).GROW.consumeClick() && this.placable.size() < this.placable.sizes() - 1) {
/*  76 */       this.placable.sizeSet(this.placable.size() + 1);
/*  77 */     } else if ((KEYS.MAIN()).SHRINK.consumeClick() && this.placable.size() > 0) {
/*  78 */       this.placable.sizeSet(this.placable.size() - 1);
/*     */     } 
/*     */     
/*  81 */     if ((KEYS.MAIN()).ROTATE.consumeClick()) {
/*  82 */       int r = this.placable.rot() + 1;
/*  83 */       r %= this.placable.rotations();
/*  84 */       this.placable.rotSet(r);
/*     */     } 
/*     */     
/*  87 */     if (pressed) {
/*  88 */       click(window);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(float ds, GameWindow window, boolean pressed) {
/*  95 */     this.placable.updateRegardless(window);
/*  96 */     super.update(ds, window, pressed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(SPRITE_RENDERER r, float ds, GameWindow window) {
/* 102 */     this.placable.init(window.tile().x(), window.tile().y());
/*     */     
/* 104 */     int w = this.placable.width();
/* 105 */     int h = this.placable.height();
/*     */     
/* 107 */     int x1 = window.tile().x() - w / 2;
/* 108 */     int y1 = window.tile().y() - h / 2;
/*     */ 
/*     */     
/* 111 */     CharSequence pError = this.placable.placableWhole(x1, y1);
/* 112 */     CharSequence e = null;
/*     */     
/* 114 */     for (int dy = 0; dy < h; dy++) {
/* 115 */       for (int dx = 0; dx < w; dx++) {
/* 116 */         CharSequence e2 = this.placable.placable(x1 + dx, y1 + dy, dx, dy);
/* 117 */         if (e2 != null) {
/* 118 */           e = e2;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 123 */     COLOR normal = (pError == null && e == null) ? (GCOLOR.MAP()).OK : (GCOLOR.MAP()).SOSO;
/*     */     
/* 125 */     for (int i = 0; i < h; i++) {
/* 126 */       for (int dx = 0; dx < w; dx++) {
/* 127 */         CharSequence e2 = this.placable.placable(x1 + dx, y1 + i, dx, i);
/* 128 */         if (e2 != null) {
/* 129 */           (GCOLOR.MAP()).BAD.bind();
/*     */         } else {
/* 131 */           normal.bind();
/*     */         } 
/* 133 */         int x = window.tile().rel().x() + (-w / 2 + dx) * 64;
/* 134 */         int y = window.tile().rel().y() + (-h / 2 + i) * 64;
/*     */         
/* 136 */         int m = 0;
/* 137 */         if (dx == 0)
/* 138 */           m |= DIR.W.mask(); 
/* 139 */         if (dx == w - 1)
/* 140 */           m |= DIR.E.mask(); 
/* 141 */         if (i == 0)
/* 142 */           m |= DIR.N.mask(); 
/* 143 */         if (i == h - 1) {
/* 144 */           m |= DIR.S.mask();
/*     */         }
/* 146 */         m ^= 0xFFFFFFFF;
/* 147 */         m &= 0xF;
/*     */         
/* 149 */         this.placable.renderPlaceHolder(r, m, x, y, x1 + dx, y1 + i, dx, i, (e2 == null), (pError == null));
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     COLOR.unbind();
/* 154 */     int dist = (int)Math.ceil(h / 2.0D + 1.0D);
/* 155 */     dist *= 64;
/* 156 */     dist >>= CORE.renderer().getZoomout();
/* 157 */     VIEW.hoverBoxDistance(dist);
/* 158 */     if (pError != null && pError.length() > 0) {
/* 159 */       VIEW.hoverBox().error(pError);
/* 160 */     } else if (e != null && e.length() > 0) {
/* 161 */       VIEW.hoverBox().error(e);
/*     */     } else {
/* 163 */       this.placable.placeInfo(VIEW.hoverBox(), x1, y1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void click(GameWindow window) {
/* 169 */     this.placable.init(window.tile().x(), window.tile().y());
/*     */ 
/*     */     
/* 172 */     int w = this.placable.width();
/* 173 */     int h = this.placable.height();
/*     */     
/* 175 */     int x1 = window.tile().x() - w / 2;
/* 176 */     int y1 = window.tile().y() - h / 2;
/*     */     
/* 178 */     if (this.placable.placableWhole(x1, y1) != null)
/*     */       return; 
/*     */     int dy;
/* 181 */     for (dy = 0; dy < h; dy++) {
/* 182 */       for (int dx = 0; dx < w; dx++) {
/* 183 */         if (this.placable.placable(x1 + dx, y1 + dy, dx, dy) != null) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/* 188 */     for (dy = 0; dy < h; dy++) {
/* 189 */       for (int dx = 0; dx < w; dx++) {
/* 190 */         this.placable.place(x1 + dx, y1 + dy, dx, dy);
/*     */       }
/*     */     } 
/*     */     
/* 194 */     this.placable.afterPlaced(x1, y1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void activate(PLACABLE placer, GameWindow window) {
/* 200 */     this.placable = (PlacableFixed)placer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void clickRelease(GameWindow window) {}
/*     */ 
/*     */ 
/*     */   
/*     */   LIST<CLICKABLE> gui() {
/* 210 */     this.butts.clear();
/* 211 */     if (this.placable.sizes() > 1) {
/* 212 */       this.butts.add(this.bDecrease);
/* 213 */       this.butts.add(this.bIncrease);
/*     */     } 
/*     */ 
/*     */     
/* 217 */     if (this.placable.rotations() > 1) {
/* 218 */       this.butts.add(this.bRotate);
/*     */     }
/* 220 */     return (LIST<CLICKABLE>)this.butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableFixedTool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */