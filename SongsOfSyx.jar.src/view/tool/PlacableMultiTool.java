/*     */ package view.tool;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.MButt;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.map.MAP_SETTER;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ final class PlacableMultiTool extends ToolPlacer.placeFunc {
/*     */   private PlacableMulti placable;
/*     */   private int size;
/*     */   private final Coo hTile;
/*     */   private final Coo clickedTile;
/*     */   private boolean newTile;
/*     */   private PLACER_TYPE type;
/*     */   
/*     */   PlacableMultiTool() {
/*  33 */     this.size = 0;
/*  34 */     this.hTile = new Coo();
/*  35 */     this.clickedTile = new Coo();
/*     */     
/*  37 */     this.type = PLACER_TYPE.SQUARE;
/*  38 */     this.a = PlacerArea.self;
/*     */ 
/*     */ 
/*     */     
/*  42 */     D.gInit(this);
/*     */ 
/*     */     
/*  45 */     this.butts = new ArrayList(2 + PLACER_TYPE.all.size());
/*  46 */     this.bIncrease = KeyButt.wrap((CLICKABLE)new GButt.Panel((SPRITE)(SPRITES.icons()).m.plus)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  50 */             activeSet((PlacableMultiTool.this.type.usesSize && PlacableMultiTool.this.size < 15));
/*     */           }
/*     */           
/*     */           protected void clickA() {
/*  54 */             PlacableMultiTool.this.radius(1);
/*     */           }
/*  56 */         }(KEYS.MAIN()).GROW);
/*  57 */     this.bDecrease = KeyButt.wrap((CLICKABLE)new GButt.Panel((SPRITE)(SPRITES.icons()).m.minus)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  61 */             activeSet((PlacableMultiTool.this.type.usesSize && PlacableMultiTool.this.size > 0));
/*     */           }
/*     */           
/*     */           protected void clickA() {
/*  65 */             PlacableMultiTool.this.radius(-1);
/*     */           }
/*  67 */         }(KEYS.MAIN()).SHRINK);
/*  68 */     this.buttsTypes = new GButt.Panel[PLACER_TYPE.all.size()];
/*     */     
/*  70 */     for (int i = 0; i < this.buttsTypes.length; i++) {
/*  71 */       final PLACER_TYPE t = (PLACER_TYPE)PLACER_TYPE.all.get(i);
/*  72 */       this.buttsTypes[i] = new GButt.Panel((SPRITE)t.icon())
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  76 */             selectedSet((PlacableMultiTool.this.type == t));
/*     */           }
/*     */           
/*     */           protected void clickA() {
/*  80 */             PlacableMultiTool.this.type = t;
/*  81 */             PlacableMultiTool.this.placable.previous = t;
/*  82 */             PlacableMultiTool.this.clear();
/*  83 */             (VIEW.inters()).popup.close();
/*     */           }
/*     */         };
/*     */     } 
/*     */     
/*  88 */     this.typeButts = new GuiSection();
/*  89 */     this.buttType = new GButt.Panel((SPRITE)(SPRITES.icons()).m.cancel, D.g("type"))
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  93 */           replaceLabel((SPRITE)PlacableMultiTool.this.type.icon(), DIR.C);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  98 */           (VIEW.inters()).popup.show((RENDEROBJ)PlacableMultiTool.this.typeButts, (CLICKABLE)this);
/*     */         }
/*     */       };
/*     */   } private final PlacerArea a; private final ArrayList<CLICKABLE> butts; private final CLICKABLE bIncrease; private final CLICKABLE bDecrease; private final GButt.Panel[] buttsTypes; private final GuiSection typeButts; private final GButt.Panel buttType;
/*     */   private void radius(int d) {
/* 103 */     this.size = CLAMP.i(this.size + d, 0, 15);
/* 104 */     this.placable.prevSize = this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void updateHovered(float ds, GameWindow window, boolean pressed) {
/* 111 */     this.newTile |= this.hTile.set((COORDINATE)window.tile());
/* 112 */     if (MButt.RIGHT.isDown()) {
/* 113 */       clear();
/*     */     }
/* 115 */     if (this.type.usesSize) {
/* 116 */       double s = MButt.clearWheelSpin();
/* 117 */       if ((KEYS.MAIN()).MOD.isPressed() && s != 0.0D) {
/*     */         
/* 119 */         if (s > 0.0D) {
/* 120 */           radius(1);
/* 121 */         } else if (s < 0.0D) {
/* 122 */           radius(-1);
/*     */         } 
/* 124 */         MButt.clearWheelSpin();
/*     */       } 
/*     */       
/* 127 */       if ((KEYS.MAIN()).GROW.consumeClick()) {
/* 128 */         radius(1);
/* 129 */       } else if ((KEYS.MAIN()).SHRINK.consumeClick()) {
/* 130 */         radius(-1);
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     PlacerArea.self.clear();
/* 135 */     if (this.type == PLACER_TYPE.FILL) {
/* 136 */       specialFill(this.hTile.x(), this.hTile.y(), this.size, this.a.set, this.placable);
/* 137 */     } else if (this.type.drag && pressed) {
/* 138 */       this.type.paint(this.hTile.x(), this.hTile.y(), this.clickedTile.x(), this.clickedTile.y(), this.size, this.a.set);
/*     */     } else {
/* 140 */       this.type.paint(this.hTile.x(), this.hTile.y(), this.hTile.x(), this.hTile.y(), this.size, this.a.set);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 145 */     GUTIL.filler().init(this);
/*     */ 
/*     */ 
/*     */     
/* 149 */     for (COORDINATE c : this.a.body()) {
/* 150 */       if (this.a.is(c)) {
/* 151 */         GUTIL.filler().fill(c);
/*     */       }
/*     */     } 
/* 154 */     while (GUTIL.filler().hasMore()) {
/* 155 */       COORDINATE c = GUTIL.filler().poll();
/* 156 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 157 */         DIR d = (DIR)DIR.ALL.get(i);
/* 158 */         int dx = c.x() + d.x();
/* 159 */         int dy = c.y() + d.y();
/* 160 */         if (SETT.IN_BOUNDS(dx, dy))
/*     */         {
/* 162 */           if (this.placable.expandsTo(c.x(), c.y(), dx, dy)) {
/* 163 */             GUTIL.filler().fill(dx, dy);
/* 164 */             this.a.set.set(dx, dy);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 169 */     GUTIL.filler().done();
/*     */ 
/*     */ 
/*     */     
/* 173 */     if (!this.type.drag && 
/* 174 */       pressed && this.newTile) {
/* 175 */       place();
/*     */     }
/*     */ 
/*     */     
/* 179 */     this.newTile = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(float ds, GameWindow window, boolean pressed) {
/* 186 */     this.placable.updateRegardless(window, PlacerArea.self);
/* 187 */     super.update(ds, window, pressed);
/*     */   }
/*     */ 
/*     */   
/*     */   private void specialFill(int x1, int y1, int size, MAP_SETTER area, PlacableMulti multi) {
/* 192 */     if (!SETT.IN_BOUNDS(x1, y1)) {
/*     */       return;
/*     */     }
/* 195 */     GUTIL.flooder().init(area);
/* 196 */     GUTIL.flooder().pushSmaller(x1, y1, 0.0D);
/* 197 */     while (GUTIL.flooder().hasMore()) {
/* 198 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 199 */       if (t.getValue() > (size + 1))
/*     */         break; 
/* 201 */       area.set(t.x(), t.y());
/* 202 */       if (multi.isPlacable(t.x(), t.y(), PlacerArea.self, PLACER_TYPE.FILL) == null) {
/* 203 */         for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 204 */           DIR d = (DIR)DIR.ORTHO.get(i);
/* 205 */           int dx = t.x() + d.x();
/* 206 */           int dy = t.y() + d.y();
/* 207 */           if (SETT.IN_BOUNDS(dx, dy) && multi.isPlacable(dx, dy, PlacerArea.self, PLACER_TYPE.FILL) == null && multi.magicExpandTo(x1, y1, dx, dy)) {
/* 208 */             GUTIL.flooder().pushSmaller(dx, dy, (t.getValue() + 1.0F));
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 214 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void clear() {
/* 221 */     this.newTile = true;
/* 222 */     PlacerArea.self.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void render(SPRITE_RENDERER r, float ds, GameWindow window) {
/* 228 */     if (this.a.area() == 0)
/*     */       return; 
/* 230 */     CharSequence pError = this.placable.isPlacable(this.a, this.type);
/* 231 */     CharSequence e = null;
/*     */ 
/*     */     
/* 234 */     int errors = 0;
/* 235 */     for (COORDINATE c : PlacerArea.self.body()) {
/* 236 */       if (!this.a.is(c))
/*     */         continue; 
/* 238 */       CharSequence e2 = this.placable.isPlacable(c.x(), c.y(), this.a, this.type);
/* 239 */       if (e2 != null) {
/* 240 */         errors++;
/* 241 */         e = e2;
/*     */       } 
/* 243 */       int x = (c.x() - window.tile().x()) * 64 + window.tile().rel().x();
/* 244 */       int y = (c.y() - window.tile().y()) * 64 + window.tile().rel().y();
/* 245 */       int m = 0;
/* 246 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 247 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 248 */         if (this.a.is(c, d))
/* 249 */           m |= d.mask(); 
/*     */       } 
/* 251 */       boolean isPlacable = (e2 == null);
/* 252 */       boolean areaIsPlacable = (pError == null);
/* 253 */       if (!isPlacable) {
/* 254 */         (GCOLOR.MAP()).BAD.bind();
/* 255 */       } else if (!areaIsPlacable) {
/* 256 */         (GCOLOR.MAP()).SOSO.bind();
/*     */       } else {
/* 258 */         (GCOLOR.MAP()).BEST.bind();
/* 259 */       }  this.placable.renderPlaceHolder(r, m, x, y, c.x(), c.y(), this.a, this.type, isPlacable, areaIsPlacable);
/*     */     } 
/* 261 */     COLOR.unbind();
/* 262 */     if (pError != null && pError.length() > 0) {
/* 263 */       VIEW.hoverBox().error(pError);
/* 264 */     } else if (errors == this.a.area() && e.length() > 0) {
/* 265 */       VIEW.hoverBox().error(e);
/*     */     } else {
/* 267 */       this.placable.placeInfo(VIEW.hoverBox(), this.a.area() - errors, this.a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void click(GameWindow window) {
/* 273 */     this.clickedTile.set((COORDINATE)window.tile());
/* 274 */     if (!this.type.drag) {
/* 275 */       place();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void activate(PLACABLE placer, GameWindow window) {
/* 281 */     this.hTile.set((COORDINATE)window.tile());
/* 282 */     this.placable = (PlacableMulti)placer;
/* 283 */     if (this.placable.previous != null) {
/* 284 */       this.type = this.placable.previous;
/*     */     } else {
/* 286 */       this.type = PLACER_TYPE.SQUARE;
/*     */     } 
/* 288 */     if (!this.placable.canBePlacedAs(this.type)) {
/* 289 */       for (PLACER_TYPE t : PLACER_TYPE.all) {
/* 290 */         if (this.placable.canBePlacedAs(t)) {
/* 291 */           this.type = t;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 296 */     if (this.placable.prevSize != -1) {
/* 297 */       this.size = this.placable.prevSize;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 302 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   void clickRelease(GameWindow window) {
/* 307 */     if (this.type.drag) {
/* 308 */       place();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void place() {
/* 314 */     this.placable.finishChecking(this.a);
/*     */     
/* 316 */     if (this.placable.isPlacable(this.a, this.type) != null) {
/*     */       return;
/*     */     }
/* 319 */     for (int y = this.a.body().y1(); y < this.a.body().y2(); y++) {
/* 320 */       for (int x = this.a.body().x1(); x < this.a.body().x2(); x++) {
/* 321 */         if (this.a.is(x, y) && this.placable.isPlacable(x, y, this.a, this.type) == null)
/*     */         {
/* 323 */           this.placable.place(x, y, this.a, this.type); } 
/*     */       } 
/*     */     } 
/* 326 */     this.placable.finishPlacing(this.a);
/*     */   }
/*     */   
/*     */   LIST<CLICKABLE> gui() {
/*     */     int j;
/* 331 */     this.butts.clear();
/* 332 */     int i = 0;
/* 333 */     boolean any = false;
/* 334 */     int x1 = this.typeButts.body().x1();
/* 335 */     int y1 = this.typeButts.body().y1();
/* 336 */     this.typeButts.clear();
/* 337 */     this.typeButts.body().moveX1Y1(x1, y1); byte b; int k; GButt.Panel[] arrayOfPanel;
/* 338 */     for (k = (arrayOfPanel = this.buttsTypes).length, b = 0; b < k; ) { GButt.Panel p = arrayOfPanel[b];
/* 339 */       if (this.placable.canBePlacedAs((PLACER_TYPE)PLACER_TYPE.all.get(i))) {
/* 340 */         j = any | (((PLACER_TYPE)PLACER_TYPE.all.get(i)).usesSize ? 0 : 1);
/* 341 */         this.typeButts.addDown(0, (RENDEROBJ)p);
/*     */       } 
/* 343 */       i++; b++; }
/*     */     
/* 345 */     this.butts.add(this.buttType);
/* 346 */     if (j != 0) {
/* 347 */       this.butts.add(this.bIncrease);
/* 348 */       this.butts.add(this.bDecrease);
/*     */     } 
/*     */     
/* 351 */     return (LIST<CLICKABLE>)this.butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableMultiTool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */