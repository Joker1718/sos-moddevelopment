/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.C;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ final class BattlePlacerSelect
/*     */   extends BattlePlacer.Mode
/*     */ {
/*     */   private final GameWindow w;
/*     */   private final DivSelection s;
/*     */   private final boolean debug;
/*     */   private final BattlePlacer.Action a;
/*     */   private final Rec fill;
/*     */   private final CharSequence sSelect;
/*     */   double hovDelay;
/*     */   
/*     */   public BattlePlacerSelect(GameWindow w, DivSelection s, BattlePlacer.Action action) {
/*  39 */     this.fill = new Rec();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     this.sSelect = "Click to select. Click and hold to select area";
/*     */     
/* 223 */     this.hovDelay = 0.0D;
/*     */     this.w = w;
/*     */     this.s = s;
/*     */     this.a = action;
/*     */     this.debug = (S.get()).developer; } void hoverTimer(GBox text) {
/* 228 */     if (!this.a.clicked) {
/* 229 */       ENTITY e = SETT.ENTITIES().getArroundPoint(this.w.pixel().x(), this.w.pixel().y());
/* 230 */       if (e instanceof Humanoid) {
/* 231 */         Div d = ((Humanoid)e).division();
/* 232 */         if (d != null) {
/* 233 */           this.s.hover(d);
/* 234 */           if (GAME.SPEED.isPaused() || VIEW.renderSecond() - this.hovDelay > 1.5D) {
/* 235 */             d.hoverInfo(text);
/* 236 */             if (d.army() == GAME.ARMIES().player()) {
/* 237 */               text.NL(5);
/* 238 */               text.text(this.sSelect);
/*     */             } 
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 246 */       this.hovDelay = VIEW.renderSecond();
/*     */       
/* 248 */       Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)this.w.tile());
/* 249 */       if (r != null && r instanceof ArtilleryInstance) {
/* 250 */         ((ArtilleryInstance)r).hover((GUI_BOX)text);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 255 */       this.hovDelay = VIEW.renderSecond();
/*     */     } 
/*     */   }
/*     */   
/*     */   void update(boolean hovered) {
/*     */     if (!hovered)
/*     */       return; 
/*     */     if (this.a.clicked || this.a.clickReleased) {
/*     */       int i, x1 = Math.min(this.a.start.x(), this.w.pixel().x()) - 32;
/*     */       int y1 = Math.min(this.a.start.y(), this.w.pixel().y()) - 32;
/*     */       int x2 = Math.max(this.a.start.x(), this.w.pixel().x()) + 32;
/*     */       int y2 = Math.max(this.a.start.y(), this.w.pixel().y()) + 32;
/*     */       this.fill.set(x1, x2, y1, y2);
/*     */       x1 >>= 6;
/*     */       y1 >>= 6;
/*     */       x2 >>= 6;
/*     */       y2 >>= 6;
/*     */       boolean include = false;
/*     */       for (ENTITY e : SETT.ENTITIES().fill((RECTANGLE)this.fill)) {
/*     */         if (e instanceof Humanoid) {
/*     */           Div d = ((Humanoid)e).division();
/*     */           if (d != null && (this.debug || d.army() == GAME.ARMIES().player())) {
/*     */             this.s.hover(d);
/*     */             i = include | (this.s.selected(d) ? 0 : 1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       int y;
/*     */       for (y = y1; y <= y2; y++) {
/*     */         for (int x = x1; x <= x2; x++) {
/*     */           Room r = (SETT.ROOMS()).map.get(x, y);
/*     */           if (r != null && r instanceof ArtilleryInstance) {
/*     */             ArtilleryInstance ca = (ArtilleryInstance)r;
/*     */             if (ca.army() == GAME.ARMIES().player()) {
/*     */               ca.hovered = true;
/*     */               i |= ca.selected ? 0 : 1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       if (this.a.clickReleased) {
/*     */         for (ENTITY e : SETT.ENTITIES().fill((RECTANGLE)this.fill)) {
/*     */           if (e instanceof Humanoid) {
/*     */             Div d = ((Humanoid)e).division();
/*     */             if (d != null && (this.debug || d.army() == GAME.ARMIES().player())) {
/*     */               if (i != 0) {
/*     */                 this.s.select(d);
/*     */                 continue;
/*     */               } 
/*     */               this.s.deSelect(d);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         for (y = y1; y <= y2; y++) {
/*     */           for (int x = x1; x <= x2; x++) {
/*     */             for (ENTITY e : SETT.ENTITIES().getAtTile(x, y)) {
/*     */               if (e instanceof Humanoid) {
/*     */                 Div d = ((Humanoid)e).division();
/*     */                 if (d != null && (this.debug || d.army() == GAME.ARMIES().player())) {
/*     */                   if (i != 0) {
/*     */                     this.s.select(d);
/*     */                     continue;
/*     */                   } 
/*     */                   this.s.deSelect(d);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             Room r = (SETT.ROOMS()).map.get(x, y);
/*     */             if (r != null && r instanceof ArtilleryInstance) {
/*     */               ArtilleryInstance ca = (ArtilleryInstance)r;
/*     */               if (ca.army() == GAME.ARMIES().player())
/*     */                 if (i != 0) {
/*     */                   this.s.artillery.select(ca);
/*     */                 } else {
/*     */                   this.s.artillery.deSelect(ca);
/*     */                 }  
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       ENTITY e = SETT.ENTITIES().getArroundPoint(this.w.pixel().x(), this.w.pixel().y());
/*     */       if (e instanceof Humanoid) {
/*     */         Div d = ((Humanoid)e).division();
/*     */         if (d != null) {
/*     */           this.s.hover(d);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)this.w.tile());
/*     */       if (r != null && r instanceof ArtilleryInstance) {
/*     */         ArtilleryInstance ca = (ArtilleryInstance)r;
/*     */         ca.hovered = true;
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/*     */     VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.expand);
/*     */     if (!this.a.clicked)
/*     */       return; 
/*     */     int x1 = Math.min(this.a.start.x(), this.w.pixel().x());
/*     */     int y1 = Math.min(this.a.start.y(), this.w.pixel().y());
/*     */     int x2 = Math.max(this.a.start.x(), this.w.pixel().x());
/*     */     int y2 = Math.max(this.a.start.y(), this.w.pixel().y());
/*     */     int dim = 2 << this.w.zoomout();
/*     */     int mX = C.WIDTH() << this.w.zoomout();
/*     */     int mY = C.HEIGHT() << this.w.zoomout();
/*     */     if (x2 - x1 < dim)
/*     */       return; 
/*     */     if (y2 - y1 < dim)
/*     */       return; 
/*     */     x1 -= data.offX1();
/*     */     x2 -= data.offX1();
/*     */     y1 -= data.offY1();
/*     */     y2 -= data.offY1();
/*     */     if (x1 + dim > 0) {
/*     */       int ry1 = Math.max(y1, 0);
/*     */       int ry2 = Math.min(y2, mY);
/*     */       (GCOLOR.MAP()).BATTLE_OK.render((SPRITE_RENDERER)r, x1, x1 + dim, ry1, ry2);
/*     */     } 
/*     */     if (x2 < mX) {
/*     */       int ry1 = Math.max(y1, 0);
/*     */       int ry2 = Math.min(y2, mY);
/*     */       (GCOLOR.MAP()).BATTLE_OK.render((SPRITE_RENDERER)r, x2, x2 + dim, ry1, ry2);
/*     */     } 
/*     */     if (y1 + dim > 0) {
/*     */       int rx1 = Math.max(x1, 0);
/*     */       int rx2 = Math.min(x2, mX);
/*     */       (GCOLOR.MAP()).BATTLE_OK.render((SPRITE_RENDERER)r, rx1, rx2, y1, y1 + dim);
/*     */     } 
/*     */     if (y2 < mY) {
/*     */       int rx1 = Math.max(x1, 0);
/*     */       int rx2 = Math.min(x2, mX);
/*     */       (GCOLOR.MAP()).BATTLE_OK.render((SPRITE_RENDERER)r, rx1, rx2, y2, y2 + dim);
/*     */     } 
/*     */   }
/*     */   
/*     */   void renderCurrent(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerSelect.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */