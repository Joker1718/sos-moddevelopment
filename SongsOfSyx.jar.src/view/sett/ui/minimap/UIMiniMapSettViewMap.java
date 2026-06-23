/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.battle.thread.order.BattleOrderPath;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.spawning.AnimalSpawnSpot;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import settlement.tilemap.SettMarks;
/*     */ import settlement.tilemap.TerrainHotspots;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.ColorShifting;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GFrame;
/*     */ import view.main.Mouse;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ 
/*     */ 
/*     */ class UIMiniMapSettViewMap
/*     */ {
/*  45 */   private final Rec zoomWindow = new Rec(200.0D);
/*     */   
/*     */   private final UIMinimapSettConfig config;
/*     */   
/*     */   private final Rec tmp;
/*     */   
/*     */   private COLOR rCol;
/*     */   private final DivFormationImp forCurrent;
/*     */   
/*     */   void render(Renderer r, float ds, GameWindow window, RECTANGLE absBounds, COORDINATE hoverPixel, boolean hovered) {
/*  55 */     r.newLayer(false, 0);
/*     */ 
/*     */     
/*  58 */     TIME.light().applyGuiLight(0.0F, 0, C.WIDTH(), 0, C.HEIGHT());
/*     */     
/*  60 */     int scale = 64 >> window.zoomout();
/*     */     
/*  62 */     hovered &= VIEW.mouse().isWithinRec(absBounds);
/*     */     
/*  64 */     renderHotspots(window, absBounds, hovered);
/*     */ 
/*     */     
/*  67 */     if (hovered) {
/*     */       
/*  69 */       renderBlack(window.zoomout(), (RECTANGLE)window.pixels(), true);
/*  70 */       renderFrame();
/*     */       
/*  72 */       renderDivs(window, absBounds, true);
/*  73 */       r.newLayer(true, 0);
/*  74 */       renderSquares(window, absBounds, true);
/*  75 */       renderRooms(window, absBounds, true);
/*     */       
/*  77 */       r.newLayer(true, 0);
/*  78 */       renderEnts(r, window, absBounds, true);
/*     */       
/*  80 */       r.newLayer(true, 0);
/*     */ 
/*     */       
/*  83 */       renderFractured(r, window, absBounds);
/*  84 */       GAME.s().render(r, ds, 2, hoverPixel.x(), hoverPixel.y(), (RECTANGLE)this.zoomWindow, this.config);
/*     */     } else {
/*     */       
/*  87 */       this.zoomWindow.moveC(-500.0D, -500.0D);
/*  88 */       renderBlack(window.zoomout(), (RECTANGLE)window.pixels(), false);
/*  89 */       renderDivs(window, absBounds, false);
/*  90 */       r.newLayer(true, 0);
/*  91 */       renderSquares(window, absBounds, true);
/*  92 */       renderRooms(window, absBounds, true);
/*  93 */       r.newLayer(true, 0);
/*  94 */       renderEnts(r, window, absBounds, true);
/*  95 */       r.newLayer(true, 0);
/*     */       
/*  97 */       SETT.MINIMAP().render((SPRITE_RENDERER)r, 
/*  98 */           window.pixels().x1() / 64.0D, window.pixels().y1() / 64.0D, 
/*  99 */           absBounds.x1(), absBounds.y1(), 
/* 100 */           absBounds.width(), absBounds.height(), 
/* 101 */           scale);
/*     */       
/* 103 */       this.config.shade().bind();
/* 104 */       COLOR.BLACK.render((SPRITE_RENDERER)r, absBounds);
/* 105 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private final BattleOrderPath path;
/*     */   
/*     */   private final BattleOrderTask task;
/*     */   private final ColorImp col;
/*     */   private final GText name;
/*     */   
/*     */   private void renderFrame() {
/* 117 */     GCOLOR.UI().border().render((SPRITE_RENDERER)CORE.renderer(), this.zoomWindow.x1(), this.zoomWindow.x2(), this.zoomWindow.y1(), this.zoomWindow.y1() + 8);
/* 118 */     GCOLOR.UI().border().render((SPRITE_RENDERER)CORE.renderer(), this.zoomWindow.x1(), this.zoomWindow.x2(), this.zoomWindow.y2() - 8, this.zoomWindow.y2());
/* 119 */     GCOLOR.UI().border().render((SPRITE_RENDERER)CORE.renderer(), this.zoomWindow.x1(), this.zoomWindow.x1() + 8, this.zoomWindow.y1(), this.zoomWindow.y2());
/* 120 */     GCOLOR.UI().border().render((SPRITE_RENDERER)CORE.renderer(), this.zoomWindow.x2() - 8, this.zoomWindow.x2(), this.zoomWindow.y1(), this.zoomWindow.y2());
/* 121 */     GFrame.render((SPRITE_RENDERER)CORE.renderer(), 0.0F, (RECTANGLE)this.zoomWindow);
/*     */   }
/*     */   
/* 124 */   UIMiniMapSettViewMap(UIMinimapSettConfig config) { this.tmp = new Rec();
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
/* 197 */     this.rCol = (COLOR)new ColorShifting(COLOR.WHITE65, COLOR.WHITE150);
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
/* 217 */     this.forCurrent = new DivFormationImp();
/* 218 */     this.path = new BattleOrderPath();
/* 219 */     this.task = new BattleOrderTask();
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
/* 493 */     this.col = new ColorImp();
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
/* 581 */     this.name = new GText((UI.FONT()).H1, 20);
/*     */     this.config = config; }
/*     */   
/*     */   private void renderHotspots(GameWindow window, RECTANGLE absBounds, boolean hovered) {
/* 585 */     if (window.zoomout() >= window.zoomoutmax() - 1) {
/* 586 */       this.name.setFont((UI.FONT()).H1);
/*     */     } else {
/* 588 */       this.name.setFont((UI.FONT()).H1);
/*     */     } 
/*     */     
/* 591 */     for (SettMarks.SettMark d : (SETT.TILE_MAP()).marks.active()) {
/* 592 */       if (!d.active)
/*     */         continue; 
/* 594 */       if (d.tile.isWithinRec(window.tiles())) {
/* 595 */         int cx = absBounds.x1() + (d.tile.x() * 64 - window.pixels().x1() >> window.zoomout());
/* 596 */         int cy = absBounds.y1() + (d.tile.y() * 64 - window.pixels().y1() >> window.zoomout());
/* 597 */         this.name.set((CharSequence)d.name).toLower();
/* 598 */         int x1 = cx - this.name.width() / 2;
/* 599 */         int y1 = cy - this.name.height() / 2;
/*     */         
/* 601 */         if (this.zoomWindow.touches(x1, x1 + this.name.width() * 2, y1, y1 + this.name.height() * 2)) {
/*     */           continue;
/*     */         }
/* 604 */         d.color.bind();
/* 605 */         (UI.FONT()).H1.render((SPRITE_RENDERER)CORE.renderer(), (CharSequence)d.name, x1, y1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 611 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private void renderSquares(GameWindow window, RECTANGLE absBounds, boolean hovered) {
/*     */     if (this.config.renderGrowable() || this.config.renderMinable())
/*     */       for (TerrainHotspots.TerrainHotSpot s : SETT.TILE_MAP().hotspots().ALL()) {
/*     */         if (this.config.renderGrowable() && s.type == 0) {
/*     */           renderSquare(s.body(), COLOR.GREEN100, window, absBounds, hovered);
/*     */           renderSprite(s.icon, s.body().cX(), s.body().cY(), window, absBounds, hovered);
/*     */           continue;
/*     */         } 
/*     */         if (this.config.renderMinable() && s.type == 1) {
/*     */           renderSquare(s.body(), COLOR.RED100, window, absBounds, hovered);
/*     */           renderSprite(s.icon, s.body().cX(), s.body().cY(), window, absBounds, hovered);
/*     */         } 
/*     */       }  
/*     */     if (this.config.renderPack())
/*     */       for (AnimalSpawnSpot s : (SETT.ANIMALS()).spawn.all()) {
/*     */         if (s.active()) {
/*     */           this.tmp.setDim((16 + s.max()));
/*     */           this.tmp.moveC((COORDINATE)s);
/*     */           renderSquare((RECTANGLE)this.tmp, COLOR.WHITE85, window, absBounds, hovered);
/*     */           renderSprite((SPRITE)(s.species()).icon, s.x(), s.y(), window, absBounds, hovered);
/*     */         } 
/*     */       }  
/*     */   }
/*     */   
/*     */   private void renderSquare(RECTANGLE rec, COLOR color, GameWindow window, RECTANGLE absBounds, boolean hovered) {
/*     */     int x1 = absBounds.x1() + (rec.x1() * 64 - window.pixels().x1() >> window.zoomout()) - 10;
/*     */     int y1 = absBounds.y1() + (rec.y1() * 64 - window.pixels().y1() >> window.zoomout()) - 10;
/*     */     int x2 = absBounds.x1() + (rec.x2() * 64 - window.pixels().x1() >> window.zoomout()) + 10;
/*     */     int y2 = absBounds.y1() + (rec.y2() * 64 - window.pixels().y1() >> window.zoomout()) + 10;
/*     */     ColorImp.TMP.set(color).shadeSelf(0.5D);
/*     */     renderSquare(x1, x2, y1, y2, (COLOR)ColorImp.TMP, 4, hovered);
/*     */     renderSquare(x1 + 1, x2 - 1, y1 + 1, y2 - 1, color, 1, hovered);
/*     */   }
/*     */   
/*     */   private void renderSquare(int x1, int x2, int y1, int y2, COLOR color, int d, boolean hovered) {
/*     */     renderSquare(x1, x2, y1, y1 + d, color, hovered);
/*     */     renderSquare(x1, x2, y2 - d, y2, color, hovered);
/*     */     renderSquare(x1, x1 + d, y1, y2, color, hovered);
/*     */     renderSquare(x2 - d, x2, y1, y2, color, hovered);
/*     */   }
/*     */   
/*     */   private void renderSquare(int x1, int x2, int y1, int y2, COLOR color, boolean hovered) {
/*     */     if (x2 - x1 <= 0 || y2 - y1 <= 0)
/*     */       return; 
/*     */     if (hovered && this.zoomWindow.touches(x1, x2, y1, y2)) {
/*     */       if (x1 < this.zoomWindow.x2())
/*     */         renderSquare(this.zoomWindow.x2(), x2, y1, y2, color, hovered); 
/*     */       if (x2 > this.zoomWindow.x1())
/*     */         renderSquare(x1, this.zoomWindow.x1(), y1, y2, color, hovered); 
/*     */       if (y1 < this.zoomWindow.y2())
/*     */         renderSquare(x1, x2, this.zoomWindow.y2(), y2, color, hovered); 
/*     */       if (y2 > this.zoomWindow.y1())
/*     */         renderSquare(x1, x2, y1, this.zoomWindow.y1(), color, hovered); 
/*     */     } else {
/*     */       color.render((SPRITE_RENDERER)CORE.renderer(), x1, x2, y1, y2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderRooms(GameWindow window, RECTANGLE absBounds, boolean hovered) {
/*     */     for (RoomBlueprint bb : SETT.ROOMS().all()) {
/*     */       if (bb instanceof RoomBlueprintIns) {
/*     */         RoomBlueprintIns<?> b = (RoomBlueprintIns)bb;
/*     */         if (this.config.room(b))
/*     */           for (int i = 0; i < b.instancesSize(); i++) {
/*     */             RoomInstance ins = b.getInstance(i);
/*     */             renderSprite((SPRITE)b.iconBig(), ins.body().cX(), ins.body().cY(), window, absBounds, hovered);
/*     */           }  
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderDivs(GameWindow window, RECTANGLE absBounds, boolean hovered) {
/*     */     if (!this.config.renderDivs())
/*     */       return; 
/*     */     for (Div div : GAME.ARMIES().divisions()) {
/*     */       if (div.menNrOf() == 0)
/*     */         continue; 
/*     */       DivPositionCopyable pos = div.current();
/*     */       if (pos.deployed() == 0)
/*     */         continue; 
/*     */       if (div.centre().cX() < 0)
/*     */         continue; 
/*     */       int cardX = div.centre().cX();
/*     */       int cardY = div.centre().cY();
/*     */       if (!div.settings().mustering()) {
/*     */         (div.order()).dest.get((Copyable)this.forCurrent);
/*     */         COORDINATE c = this.forCurrent.centrePixel();
/*     */         if (c != null && this.forCurrent.deployed() > 0) {
/*     */           cardX = c.x();
/*     */           cardY = c.y();
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */       } 
/*     */       SPRITE icon = (VIEW.UI()).div.battle.miniDiv(div, false, false);
/*     */       cardX = absBounds.x1() + (cardX - window.pixels().x1() >> window.zoomout());
/*     */       cardY = absBounds.y1() + (cardY - window.pixels().y1() >> window.zoomout());
/*     */       int d = icon.width() / 2;
/*     */       int x1 = cardX - d;
/*     */       int x2 = cardX + d;
/*     */       int y1 = cardY - d;
/*     */       int y2 = cardY + d;
/*     */       if (!hovered || !this.zoomWindow.touches(x1, x2, y1, y2))
/*     */         icon.renderC((SPRITE_RENDERER)CORE.renderer(), cardX, cardY); 
/*     */       if (this.forCurrent.deployed() > 0) {
/*     */         (div.order()).task.get((Copyable)this.task);
/*     */         if ((this.task.task()).showDest || (S.get()).developer) {
/*     */           int men = this.forCurrent.deployed();
/*     */           if (men == 0)
/*     */             continue; 
/*     */           if (!this.forCurrent.body().touches((RECTANGLE)window.pixels()))
/*     */             continue; 
/*     */           for (int i = 0; i < men; i++) {
/*     */             int m = this.forCurrent.dirMaskOrtho(i);
/*     */             if (m != 15) {
/*     */               COORDINATE c = this.forCurrent.pixel(i);
/*     */               int x = absBounds.x1() + (c.x() - window.pixels().x1() >> window.zoomout());
/*     */               int y = absBounds.y1() + (c.y() - window.pixels().y1() >> window.zoomout());
/*     */               if (!hovered || !this.zoomWindow.touches(x, x + 1, y, y + 1))
/*     */                 CORE.renderer().renderParticle(x, y); 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         if (div.settings().mustering() && ((this.task.task()).showDest || (S.get()).developer)) {
/*     */           (div.order()).path.get((Copyable)this.path);
/*     */           if (this.path.length() > 0) {
/*     */             COLOR.ORANGE100.bind();
/*     */             int curr = this.path.currentI();
/*     */             int k = (curr > 0) ? (curr - 1) : curr;
/*     */             for (int i = k; i < this.path.length(); i++) {
/*     */               this.path.setCurrentI(i);
/*     */               int x = absBounds.x1() + (this.path.x() - window.pixels().x1() >> window.zoomout());
/*     */               int y = absBounds.y1() + (this.path.y() - window.pixels().y1() >> window.zoomout());
/*     */               if (!hovered || !this.zoomWindow.touches(x, x + 1, y, y + 1))
/*     */                 CORE.renderer().renderParticle(x, y); 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderSprite(SPRITE icon, int cx, int cy, GameWindow window, RECTANGLE absBounds, boolean hovered) {
/*     */     if (window.tiles().holdsPoint(cx, cy)) {
/*     */       cx = absBounds.x1() + (cx * 64 - window.pixels().x1() >> window.zoomout());
/*     */       cy = absBounds.y1() + (cy * 64 - window.pixels().y1() >> window.zoomout());
/*     */       int d = icon.width() / 2;
/*     */       int x1 = cx - d;
/*     */       int x2 = cx + d;
/*     */       int y1 = cy - d;
/*     */       int y2 = cy + d;
/*     */       if (!hovered || !this.zoomWindow.touches(x1, x2, y1, y2)) {
/*     */         COLOR.BLACK.bind();
/*     */         icon.renderC((SPRITE_RENDERER)CORE.renderer(), cx + 4, cy + 4);
/*     */         this.rCol.bind();
/*     */         icon.renderC((SPRITE_RENDERER)CORE.renderer(), cx, cy);
/*     */         COLOR.unbind();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderBlack(int zoom, RECTANGLE game, boolean hovered) {
/*     */     int x1 = Math.max(0, -game.x1()) >> zoom;
/*     */     int x2 = Math.min(game.x2(), SETT.PWIDTH);
/*     */     x2 -= game.x1();
/*     */     x2 >>= zoom;
/*     */     int y1 = Math.max(0, -game.y1()) >> zoom;
/*     */     int y2 = Math.min(game.y2(), SETT.PHEIGHT);
/*     */     y2 -= game.y1();
/*     */     y2 >>= zoom;
/*     */     COLOR c = COLOR.WHITE20;
/*     */     renderColor(c, 0, x1, 0, C.DIM().height(), hovered);
/*     */     renderColor(c, x2, C.DIM().width(), 0, C.DIM().height(), hovered);
/*     */     renderColor(c, 0, C.DIM().width(), 0, y1, hovered);
/*     */     renderColor(c, 0, C.DIM().width(), y2, C.DIM().height(), hovered);
/*     */     c = GCOLOR.UI().border();
/*     */     renderColor(c, x1 - 3, x2 + 3, y1 - 3, y1, hovered);
/*     */     renderColor(c, x1 - 3, x2 + 3, y2, y2 + 3, hovered);
/*     */     renderColor(c, x1 - 3, x1, y1, y2, hovered);
/*     */     renderColor(c, x2, x2 + 3, y1, y2, hovered);
/*     */   }
/*     */   
/*     */   private void renderColor(COLOR col, int x1, int x2, int y1, int y2, boolean hovered) {
/*     */     if (x1 >= x2)
/*     */       return; 
/*     */     if (y1 >= y2)
/*     */       return; 
/*     */     if (hovered && this.zoomWindow.touches(x1, x2, y1, y2)) {
/*     */       if (x1 < this.zoomWindow.x2())
/*     */         renderColor(col, this.zoomWindow.x2(), x2, y1, y2, hovered); 
/*     */       if (x2 > this.zoomWindow.x1())
/*     */         renderColor(col, x1, this.zoomWindow.x1(), y1, y2, hovered); 
/*     */       if (y1 < this.zoomWindow.y2())
/*     */         renderColor(col, x1, x2, this.zoomWindow.y2(), y2, hovered); 
/*     */       if (y2 > this.zoomWindow.y1())
/*     */         renderColor(col, x1, x2, y1, this.zoomWindow.y1(), hovered); 
/*     */     } else {
/*     */       col.render((SPRITE_RENDERER)CORE.renderer(), x1, x2, y1, y2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderFractured(Renderer r, GameWindow window, RECTANGLE absBounds) {
/*     */     int scale = 64 >> window.zoomout();
/*     */     int mmx = this.zoomWindow.x1() - absBounds.x1();
/*     */     int mmy = this.zoomWindow.y1() - absBounds.y1();
/*     */     if (mmy < 0)
/*     */       mmy = 0; 
/*     */     int mmy2 = this.zoomWindow.y2() - absBounds.y1();
/*     */     if (mmy2 < 0)
/*     */       mmy2 = 0; 
/*     */     int mx1 = 0;
/*     */     int mx2 = absBounds.width();
/*     */     int my1 = 0;
/*     */     int my2 = mmy;
/*     */     if (mx2 - mx1 > 0 && my2 - my1 > 0) {
/*     */       double px = window.pixels().x1() / 64.0D + mx1 / scale;
/*     */       double py = window.pixels().y1() / 64.0D + my1 / scale;
/*     */       ren(r, px, py, mx1 + absBounds.x1(), my1 + absBounds.y1(), mx2 - mx1 + 2, my2 - my1 + 2, scale);
/*     */     } 
/*     */     mx1 = 0;
/*     */     mx2 = mmx;
/*     */     my1 = mmy;
/*     */     my2 = mmy2;
/*     */     if (mx2 - mx1 > 0 && my2 - my1 > 0) {
/*     */       double px = window.pixels().x1() / 64.0D + mx1 / scale;
/*     */       double py = window.pixels().y1() / 64.0D + my1 / scale;
/*     */       ren(r, px, py, mx1 + absBounds.x1(), my1 + absBounds.y1(), mx2 - mx1, my2 - my1 + 2, scale);
/*     */     } 
/*     */     mx1 = mmx + this.zoomWindow.width();
/*     */     mx2 = absBounds.width();
/*     */     my1 = mmy;
/*     */     my2 = mmy2;
/*     */     if (mx2 - mx1 > 0 && my2 - my1 > 0) {
/*     */       double px = window.pixels().x1() / 64.0D + mx1 / scale;
/*     */       double py = window.pixels().y1() / 64.0D + my1 / scale;
/*     */       ren(r, px, py, mx1 + absBounds.x1(), my1 + absBounds.y1(), mx2 - mx1 + 1, my2 - my1 + 1, scale);
/*     */     } 
/*     */     mx1 = 0;
/*     */     mx2 = absBounds.width();
/*     */     my1 = mmy2;
/*     */     my2 = absBounds.height();
/*     */     if (mx2 - mx1 > 0 && my2 - my1 > 0) {
/*     */       double px = window.pixels().x1() / 64.0D + mx1 / scale;
/*     */       double py = window.pixels().y1() / 64.0D + my1 / scale;
/*     */       ren(r, px, py, mx1 + absBounds.x1(), my1 + absBounds.y1(), mx2 - mx1 + 1, my2 - my1, scale);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ren(Renderer r, double px, double py, int x1, int y1, int x2, int y2, int scale) {
/*     */     SETT.MINIMAP().render((SPRITE_RENDERER)r, px, py, x1, y1, x2, y2, scale);
/*     */     this.config.shade().bind();
/*     */     int dy = (int)(scale * (py - (int)py));
/*     */     COLOR.BLACK.render((SPRITE_RENDERER)r, x1, x1 + x2, y1 - dy, y1 + y2 + dy * 2);
/*     */     OPACITY.unbind();
/*     */   }
/*     */   
/*     */   private void renderEnts(Renderer r, GameWindow window, RECTANGLE absBounds, boolean hovered) {
/*     */     int am = SETT.ENTITIES().Imax();
/*     */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*     */     if (am > 20000) {
/*     */       for (int ei = 0; ei < am; ei++) {
/*     */         ENTITY e = es[ei];
/*     */         if (e != null) {
/*     */           COLOR c = this.config.col(e);
/*     */           if (c != null && e.physics.body().isWithin((RECTANGLE)window.pixels())) {
/*     */             int x1 = absBounds.x1() + (e.physics.body().x1() - window.pixels().x1() >> window.zoomout());
/*     */             int y1 = absBounds.y1() + (e.physics.body().y1() - window.pixels().y1() >> window.zoomout());
/*     */             if (!hovered || !this.zoomWindow.holdsPoint(x1, y1)) {
/*     */               c.bind();
/*     */               r.renderParticle(x1, y1);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       for (int ei = 0; ei < am; ei++) {
/*     */         ENTITY e = es[ei];
/*     */         if (e != null) {
/*     */           COLOR c = this.config.col(e);
/*     */           if (c != null && e.physics.body().isWithin((RECTANGLE)window.pixels())) {
/*     */             int x1 = absBounds.x1() + (e.physics.body().x1() - window.pixels().x1() >> window.zoomout());
/*     */             int y1 = absBounds.y1() + (e.physics.body().y1() - window.pixels().y1() >> window.zoomout());
/*     */             if (!hovered || !this.zoomWindow.holdsPoint(x1, y1)) {
/*     */               this.col.interpolate(c, COLOR.WHITE100, 0.5D).bind();
/*     */               r.renderParticle(x1 - 1, y1 - 1);
/*     */               this.col.interpolate(c, COLOR.BLACK, 0.5D).bind();
/*     */               r.renderParticle(x1 + 1, y1 + 1);
/*     */               c.bind();
/*     */               r.renderParticle(x1, y1);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     if (this.config.halfEnts())
/*     */       for (HalfEntity e : SETT.HALFENTS().all()) {
/*     */         if (e == null)
/*     */           continue; 
/*     */         if (window.tiles().holdsPoint(e.ctx(), e.cty())) {
/*     */           int x1 = absBounds.x1() + (e.body().x1() - window.pixels().x1() >> window.zoomout());
/*     */           int y1 = absBounds.y1() + (e.body().y1() - window.pixels().y1() >> window.zoomout());
/*     */           if (hovered && this.zoomWindow.holdsPoint(x1, y1))
/*     */             continue; 
/*     */           COLOR.BROWN.bind();
/*     */           r.renderParticle(x1, y1);
/*     */         } 
/*     */       }  
/*     */     COLOR.unbind();
/*     */     OPACITY.unbind();
/*     */   }
/*     */   
/*     */   void update() {
/*     */     Mouse mouse = VIEW.mouse();
/*     */     this.zoomWindow.moveCX(mouse.x());
/*     */     if (this.zoomWindow.x1() <= 2)
/*     */       this.zoomWindow.moveX1(2.0D); 
/*     */     if (this.zoomWindow.x2() > C.DIM().width())
/*     */       this.zoomWindow.moveX2(C.WIDTH()); 
/*     */     this.zoomWindow.moveY1(((mouse.y() - 24 - this.zoomWindow.height() < 0) ? (mouse.y() + 24) : (mouse.y() - 24 - this.zoomWindow.height())));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMiniMapSettViewMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */