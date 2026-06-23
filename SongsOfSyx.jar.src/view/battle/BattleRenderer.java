/*     */ package view.battle;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPosition;
/*     */ import game.battle.formation.DivRenderer;
/*     */ import game.battle.formation.FormationBody;
/*     */ import game.battle.thread.order.BattleOrderPath;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.C;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class BattleRenderer extends ON_TOP_RENDERABLE {
/*  37 */   private final COLOR cHover = (COLOR)new ColorImp(0, 127, 0); private final DivSelection s;
/*  38 */   private final COLOR cHoverEnemy = (COLOR)new ColorImp(127, 0, 0);
/*  39 */   private final BattleOrderTask task = new BattleOrderTask();
/*     */   
/*  41 */   public static ColorImp colAttack = new ColorImp(127, 40, 40);
/*     */ 
/*     */   
/*     */   private final DivFormationImp tmp;
/*     */ 
/*     */   
/*     */   private final BattleOrderPath pathDiv;
/*     */ 
/*     */   
/*     */   public void render(ShadowBatch shadowBatch, RenderData data, int zoomout, double ds) {
/*  51 */     CORE.renderer().newLayer(false, 0);
/*  52 */     AmbientLight.full.register(0, C.WIDTH(), 0, C.HEIGHT());
/*  53 */     remove();
/*  54 */     Renderer r = CORE.renderer();
/*     */     
/*  56 */     if (r.getZoomout() < 4) {
/*  57 */       ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*  58 */       int m = SETT.ENTITIES().Imax();
/*  59 */       for (int ei = 0; ei < m; ei++) {
/*  60 */         ENTITY e = es[ei];
/*  61 */         if (e != null && data.gBounds().holdsPoint(e.body().cX(), e.body().cY()))
/*     */         {
/*  63 */           if (e instanceof Humanoid) {
/*  64 */             Div d = ((Humanoid)e).division();
/*  65 */             if (d != null && (this.s.hovered(d) || this.s.selected(d))) {
/*  66 */               if (d.army() == GAME.ARMIES().enemy()) {
/*  67 */                 this.cHoverEnemy.bind();
/*     */               } else {
/*  69 */                 this.cHover.bind();
/*  70 */               }  int rx = data.absBounds().x1() + e.body().cX() - data.gBounds().x1() >> zoomout;
/*  71 */               int ry = data.absBounds().y1() + e.body().cY() - data.gBounds().y1() >> zoomout;
/*  72 */               DIR dir = d.position().dir(d.reporter.positionSpot((Humanoid)e));
/*  73 */               if (dir == null) {
/*  74 */                 dir = e.speed.dir();
/*     */               }
/*  76 */               if (zoomout == 3) {
/*  77 */                 SPRITE s = (SPRITES.cons()).TINY.dots.get(0);
/*  78 */                 int dd = 8;
/*  79 */                 s.render((SPRITE_RENDERER)r, rx - dd / 2, rx + dd / 2, ry - dd / 2, ry + dd / 2);
/*     */               } else {
/*  81 */                 SPRITE s = (SPRITE)(SPRITES.cons()).ICO.arrows2.get(dir.id());
/*     */                 
/*  83 */                 int dd = s.width() >> Math.min(zoomout + 1, 2);
/*  84 */                 int x1 = rx - dd / 2;
/*  85 */                 int y1 = ry - dd / 2;
/*  86 */                 s.render((SPRITE_RENDERER)r, x1, x1 + dd, y1, y1 + dd);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     if ((KEYS.BATTLE()).SHOW_DIVISIONS.isPressed()) {
/*  98 */       int i; for (i = 0; i < GAME.ARMIES().divisions().size(); i++) {
/*  99 */         Div d = (Div)GAME.ARMIES().divisions().getC(i);
/*     */         
/* 101 */         if (!this.s.hovered(d) && !this.s.selected(d)) {
/*     */ 
/*     */           
/* 104 */           int x = d.centre().cX();
/* 105 */           int y = d.centre().cY();
/*     */           
/* 107 */           if (data.gBounds().holdsPoint(x, y)) {
/* 108 */             x = data.absBounds().x1() + x - data.gBounds().x1() >> zoomout;
/* 109 */             y = data.absBounds().y1() + y - data.gBounds().y1() >> zoomout;
/* 110 */             SPRITE icon = (VIEW.UI()).div.battle.miniDiv(d, false, false);
/* 111 */             icon.renderC((SPRITE_RENDERER)r, x, y);
/*     */           } 
/*     */         } 
/*     */       } 
/* 115 */       for (i = 0; i < GAME.ARMIES().divisions().size(); i++) {
/*     */         
/* 117 */         Div d = (Div)GAME.ARMIES().divisions().getC(i);
/* 118 */         if (this.s.hovered(d) || this.s.selected(d)) {
/* 119 */           SPRITE icon = (VIEW.UI()).div.battle.miniDiv(d, this.s.hovered(d), this.s.selected(d));
/* 120 */           int x = d.centre().cX();
/* 121 */           int y = d.centre().cY();
/*     */           
/* 123 */           if (data.gBounds().holdsPoint(x, y)) {
/* 124 */             x = data.absBounds().x1() + x - data.gBounds().x1() >> zoomout;
/* 125 */             y = data.absBounds().y1() + y - data.gBounds().y1() >> zoomout;
/* 126 */             icon.renderC((SPRITE_RENDERER)r, x, y);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     for (int di = 0; di < GAME.ARMIES().divisions().size(); di++) {
/* 138 */       Div d = (Div)GAME.ARMIES().divisions().getC(di);
/* 139 */       if (d.menNrOf() > 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 145 */         if (this.s.hovered(d) || this.s.selected(d) || (KEYS.BATTLE()).SHOW_DIVISIONS.isPressed()) {
/*     */           
/* 147 */           (d.order()).task.get((Copyable)this.task);
/* 148 */           Div t = this.task.targetDiv();
/* 149 */           Icon icon = (this.task.task() == BattleOrderTask.DIVTASK.ATTACK_RANGED) ? (UI.icons()).l.crossheir : (UI.icons()).l.swords;
/*     */           
/* 151 */           if (t != null && t.reporter.body().touches(data.gBounds())) {
/* 152 */             int x = t.centre().cX();
/* 153 */             int y = t.centre().cY();
/* 154 */             if (data.gBounds().holdsPoint(x, y)) {
/* 155 */               x = data.absBounds().x1() + x - data.gBounds().x1() >> zoomout;
/* 156 */               y = data.absBounds().y1() + y - data.gBounds().y1() >> zoomout;
/* 157 */               COLOR.RED2RED.bind();
/* 158 */               icon.renderCScaled((SPRITE_RENDERER)r, x, y, 8 >> zoomout);
/*     */             } 
/*     */             
/* 161 */             if (body.init((DivPosition)t.current())) {
/*     */               
/* 163 */               int x1 = data.absBounds().x1() + body.x1() - data.gBounds().x1() >> zoomout;
/* 164 */               int y1 = data.absBounds().y1() + body.y1() - data.gBounds().y1() >> zoomout;
/* 165 */               int y2 = data.absBounds().y1() + body.y2() - data.gBounds().y1() >> zoomout;
/* 166 */               int x2 = data.absBounds().x1() + body.x2() - data.gBounds().x1() >> zoomout;
/*     */               
/* 168 */               this.cHoverEnemy.renderFrame((SPRITE_RENDERER)r, x1, x2, y1, y2, 1, 8 >> zoomout);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 174 */           if (this.task.targetTileX() != -1 && data.tBounds().touches(this.task.targetTileX(), this.task.targetTileY())) {
/* 175 */             int x = this.task.targetTileX() * 64;
/* 176 */             int y = this.task.targetTileY() * 64;
/* 177 */             x = data.absBounds().x1() + x - data.gBounds().x1() >> zoomout;
/* 178 */             y = data.absBounds().y1() + y - data.gBounds().y1() >> zoomout;
/* 179 */             COLOR.RED2RED.bind();
/* 180 */             (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, x, y);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 185 */     for (ArtilleryInstance ins : this.s.artillery.all()) {
/*     */ 
/*     */ 
/*     */       
/* 189 */       if (ins.hovered) {
/* 190 */         if (ins.army() != GAME.ARMIES().player()) {
/* 191 */           this.cHoverEnemy.bind();
/*     */         } else {
/* 193 */           this.cHover.bind();
/*     */         } 
/* 195 */       } else if (ins.selected) {
/* 196 */         this.cHover.bind();
/*     */       } else {
/*     */         continue;
/*     */       } 
/* 200 */       if (data.tBounds().touches(ins.body())) {
/* 201 */         int x1 = ins.body().x1() * 64;
/* 202 */         int y1 = ins.body().y1() * 64;
/* 203 */         x1 = data.absBounds().x1() + x1 - data.gBounds().x1() >> zoomout;
/* 204 */         y1 = data.absBounds().y1() + y1 - data.gBounds().y1() >> zoomout;
/* 205 */         int w = ins.body().width() * 64 >> zoomout;
/* 206 */         int h = ins.body().height() * 64 >> zoomout;
/* 207 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, x1, y1, w, h);
/*     */       } 
/* 209 */       Div t = ins.targetDivGet();
/* 210 */       if (t != null && t.reporter.body().touches(data.gBounds())) {
/* 211 */         int x = t.centre().cX();
/* 212 */         int y = t.centre().cY();
/* 213 */         if (data.gBounds().holdsPoint(x, y)) {
/* 214 */           x = data.absBounds().x1() + x - data.gBounds().x1() >> zoomout;
/* 215 */           y = data.absBounds().y1() + y - data.gBounds().y1() >> zoomout;
/* 216 */           colAttack.bind();
/* 217 */           (UI.icons()).l.crossheir.renderCScaled((SPRITE_RENDERER)r, x, y, 2);
/*     */         } 
/*     */       } 
/* 220 */       COORDINATE coo = ins.targetCooGet();
/* 221 */       if (coo != null) {
/* 222 */         int x = coo.x();
/* 223 */         int y = coo.y();
/* 224 */         if (data.gBounds().holdsPoint(x, y)) {
/* 225 */           x = data.absBounds().x1() + x - data.gBounds().x1() >> zoomout;
/* 226 */           y = data.absBounds().y1() + y - data.gBounds().y1() >> zoomout;
/* 227 */           colAttack.bind();
/* 228 */           (UI.icons()).l.crossheir.renderCScaled((SPRITE_RENDERER)r, x, y, 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 239 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {}
/*     */ 
/*     */   
/*     */   public BattleRenderer(DivSelection s)
/*     */   {
/* 248 */     this.tmp = new DivFormationImp();
/* 249 */     this.pathDiv = new BattleOrderPath();
/* 250 */     this.s = s; } private static FormationBody body = new FormationBody();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(SPRITE_RENDERER ren, RenderData data) {
/* 256 */     Icons.S.IconS iconS = (SPRITES.icons()).s.circle;
/* 257 */     for (Div d : GAME.ARMIES().divisions()) {
/* 258 */       COLOR.GREEN40.bind();
/* 259 */       if ((d.army() == GAME.ARMIES().player() || (S.get()).developer) && (this.s.hovered(d) || this.s.selected(d) || (KEYS.BATTLE()).SHOW_DIVISIONS.isPressed())) {
/*     */         
/* 261 */         if ((S.get()).developer) {
/* 262 */           DivRenderer.render(ren, d.position(), data);
/*     */         }
/* 264 */         if (body.init((DivPosition)d.current())) {
/*     */           
/* 266 */           if (body.width() > d.position().width() * 2 || body.height() > d.position().width() * 2) {
/* 267 */             body.init((DivPosition)d.position());
/*     */           }
/* 269 */           int x1 = body.x1() - data.offX1();
/* 270 */           int y1 = body.y1() - data.offY1();
/* 271 */           int y2 = body.y2() - data.offY1();
/* 272 */           int x2 = body.x2() - data.offX1();
/*     */           
/* 274 */           (d.player() ? this.cHover : this.cHoverEnemy).renderFrame(ren, x1, x2, y1, y2, 1, 8);
/*     */         } 
/*     */         
/* 277 */         if (this.s.hovered(d)) {
/* 278 */           COLOR.WHITE100.bind();
/*     */         } else {
/* 280 */           COLOR.WHITE50.bind();
/* 281 */         }  (d.order()).task.get((Copyable)this.task);
/* 282 */         if ((this.task.task()).showDest || (S.get()).developer) {
/* 283 */           (d.order()).dest.get((Copyable)this.tmp);
/* 284 */           DivRenderer.render(ren, (DivFormation)this.tmp, data);
/*     */         } 
/* 286 */         if ((this.task.task()).showPath || (S.get()).developer) {
/* 287 */           (d.order()).path.get((Copyable)this.pathDiv);
/* 288 */           if (this.pathDiv.length() > 0) {
/* 289 */             COLOR.ORANGE100.bind();
/* 290 */             int curr = this.pathDiv.currentI();
/* 291 */             int k = (curr > 0) ? (curr - 1) : curr;
/* 292 */             for (int i = k; i < this.pathDiv.length(); i++) {
/* 293 */               this.pathDiv.setCurrentI(i);
/* 294 */               int rx = this.pathDiv.x() - iconS.width() / 2;
/* 295 */               int ry = this.pathDiv.y() - iconS.width() / 2;
/* 296 */               rx -= data.offX1();
/* 297 */               ry -= data.offY1();
/*     */               
/* 299 */               iconS.renderScaled(ren, rx, ry, 4);
/*     */             } 
/* 301 */             this.pathDiv.setCurrentI(curr);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 306 */         COLOR.unbind();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 311 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattleRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */