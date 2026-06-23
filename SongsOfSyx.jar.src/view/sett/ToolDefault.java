/*     */ package view.sett;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.tilemap.GuiTerrainHoverInfo;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.BODY_HOLDERE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.Tool;
/*     */ import view.tool.ToolManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ToolDefault
/*     */   extends Tool
/*     */ {
/*     */   private boolean dragging = false;
/*  48 */   private final Coo dragCoo = new Coo();
/*  49 */   private static CharSequence ¤¤clickJob = "¤Hold '{0}' and click to place more of job: ";
/*  50 */   private static CharSequence ¤¤clickRoom = "¤Hold '{0}' and click to build another: ";
/*  51 */   private static CharSequence ¤¤clickRoom2 = "¤Hold '{0}' and click to copy this: ";
/*  52 */   private static CharSequence ¤¤reconstruct = "¤click to reconstruct rooms"; private final LIST<SettDebugClick> debugs;
/*     */   
/*     */   static {
/*  55 */     D.ts(ToolDefault.class);
/*     */   }
/*     */   
/*     */   private final BODY_HOLDERE body;
/*     */   
/*     */   ToolDefault(ToolManager m) {
/*  61 */     super(m);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     this.body = new BODY_HOLDERE()
/*     */       {
/*  77 */         private final Rec body = new Rec(64.0D);
/*     */         
/*     */         public RECTANGLEE body()
/*     */         {
/*  81 */           return (RECTANGLEE)this.body;
/*     */         }
/*     */       };
/*     */     this.debugs = (LIST<SettDebugClick>)new ArrayList((Iterable)SettDebugClick.all);
/*     */   }
/*     */   protected void renderHovered(SPRITE_RENDERER r, float ds, GameWindow window, GBox box) {
/*  87 */     if (!SETT.IN_BOUNDS((COORDINATE)window.tile())) {
/*     */       return;
/*     */     }
/*  90 */     if (MButt.RIGHT.isDown()) {
/*  91 */       if (!this.dragging) {
/*  92 */         this.dragging = true;
/*  93 */         this.dragCoo.set((COORDINATE)window.tile());
/*     */       } 
/*     */       
/*  96 */       box.add((SPRITE)(SPRITES.icons()).s.crossheir);
/*  97 */       box.add((SPRITE)box.text().add(VIEW.s().getWindow().tile().x()).add(',').add(VIEW.s().getWindow().tile().y()));
/*  98 */       box.tab(4);
/*     */       
/* 100 */       if (this.dragging) {
/*     */         
/* 102 */         int dx = this.dragCoo.x() - window.tile().x();
/* 103 */         int dy = this.dragCoo.y() - window.tile().y();
/* 104 */         int w = Math.abs(dx);
/* 105 */         int h = Math.abs(dy);
/* 106 */         if (w + h > 0) {
/* 107 */           dx = CLAMP.i(dx, -1, 1);
/* 108 */           dy = CLAMP.i(dy, -1, 1);
/* 109 */           box.add((SPRITE)box.text().add((w + 1)).add('x').add((h + 1)));
/*     */           int d;
/* 111 */           for (d = 1; d <= w; d++) {
/* 112 */             int x = window.tile().rel().x() + d * dx * 64;
/* 113 */             int y = window.tile().rel().y();
/* 114 */             (SPRITES.cons()).BIG.dashed_hollow.render(r, 0, x, y);
/*     */           } 
/*     */           
/* 117 */           for (d = 1; d <= h; d++) {
/* 118 */             int x = window.tile().rel().x() + dx * w * 64;
/* 119 */             int y = window.tile().rel().y() + d * dy * 64;
/* 120 */             (SPRITES.cons()).BIG.dashed_hollow.render(r, 0, x, y);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 125 */       box.sep();
/*     */       
/* 127 */       (SPRITES.cons()).BIG.dashed.render(r, 0, window.tile().rel().x(), window.tile().rel().y());
/* 128 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.questionmark);
/*     */ 
/*     */       
/* 131 */       int tx = VIEW.s().getWindow().tile().x();
/* 132 */       int ty = VIEW.s().getWindow().tile().y();
/* 133 */       GuiTerrainHoverInfo.add(box, tx, ty);
/* 134 */       if ((S.get()).developer) {
/* 135 */         box.text(((AVAILABILITY)(SETT.PATH()).availability.get((COORDINATE)VIEW.s().getWindow().tile())).name());
/*     */       }
/*     */ 
/*     */       
/* 139 */       box.NL();
/* 140 */       int ta = 0;
/* 141 */       for (SettEnvMap.SettEnv t : (SETT.ENV()).map.all()) {
/* 142 */         double v = t.get((COORDINATE)window.tile());
/* 143 */         if (v != 0.0D) {
/* 144 */           box.tab(ta * 6);
/* 145 */           box.add(t.icon);
/* 146 */           box.textL(t.info.name);
/* 147 */           box.tab(ta * 6 + 5);
/* 148 */           box.add((SPRITE)GFORMAT.perc(box.text(), v));
/* 149 */           ta++;
/* 150 */           if (ta > 1) {
/* 151 */             box.NL();
/* 152 */             ta = 0;
/*     */           } 
/*     */         } 
/*     */       } 
/* 156 */       for (ROOM_MONUMENT t : (SETT.ROOMS()).MONUMENTS.all) {
/* 157 */         double v = t.envValue.get((COORDINATE)window.tile());
/* 158 */         if (v != 0.0D) {
/* 159 */           box.tab(ta * 6);
/* 160 */           box.add(t.icon.small);
/* 161 */           box.textL(t.info.name);
/* 162 */           box.tab(ta * 6 + 5);
/* 163 */           box.add((SPRITE)GFORMAT.perc(box.text(), v));
/* 164 */           ta++;
/* 165 */           if (ta > 1) {
/* 166 */             box.NL();
/* 167 */             ta = 0;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 172 */       box.NL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       (SETT.OVERLAY()).RESOURCES.add();
/*     */     } else {
/*     */       
/* 181 */       GameWindow.SUB_MOUSE sUB_MOUSE = window.pixel();
/* 182 */       if (!SETT.PIXEL_BOUNDS.holdsPoint((COORDINATE)sUB_MOUSE))
/*     */         return; 
/* 184 */       ENTITY e = SETT.ENTITIES().getArroundPoint(sUB_MOUSE.x(), sUB_MOUSE.y());
/* 185 */       SETT_HOVERABLE t = SETT.THINGS().getArroundCoo(sUB_MOUSE.x(), sUB_MOUSE.y());
/*     */       
/* 187 */       if (isEntity((COORDINATE)sUB_MOUSE, e, t)) {
/* 188 */         if (e.canBeClicked())
/* 189 */           VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.questionmark); 
/* 190 */         SETT.OVERLAY().add(e);
/* 191 */         e.hover(box);
/* 192 */       } else if (isThing((COORDINATE)sUB_MOUSE, e, t)) {
/* 193 */         if (t.canBeClicked())
/* 194 */           VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.questionmark); 
/* 195 */         SETT.OVERLAY().add((THINGS.Thing)t);
/* 196 */         t.hover(box);
/*     */       }
/* 198 */       else if ((SETT.ROOMS()).map.is((COORDINATE)window.tile())) {
/* 199 */         Room room = (Room)(SETT.ROOMS()).map.get((COORDINATE)window.tile());
/* 200 */         RESOURCE_TILE res = room.resourceTile(window.tile().x(), window.tile().y());
/* 201 */         if (res != null && res.resource() != null) {
/* 202 */           this.body.body().moveX1Y1((window.tile().x() * 64), (window.tile().y() * 64));
/* 203 */           SETT.OVERLAY().add((BODY_HOLDER)this.body, COLOR.WHITE65);
/* 204 */           box.title((res.resource()).name);
/* 205 */           box.add((SPRITE)GFORMAT.i(box.text(), res.amount()));
/* 206 */           if ((S.get()).developer) {
/* 207 */             box.NL();
/* 208 */             box.add((SPRITE)box.text().add('a').add(res.reservable()));
/*     */           } 
/*     */         } else {
/*     */           
/* 212 */           (VIEW.s()).ui.rooms.hover(box, room, window.tile().x(), window.tile().y());
/* 213 */           if (room.blueprint() == (SETT.ROOMS()).THRONE) {
/* 214 */             box.title((SETT.ROOMS()).THRONE.info.name);
/* 215 */             box.text((SETT.ROOMS()).THRONE.info.desc);
/*     */           } 
/* 217 */           if (room instanceof settlement.room.main.RoomInstance)
/* 218 */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.questionmark); 
/* 219 */           SETT.OVERLAY().add(window.tile().x(), window.tile().y());
/*     */         } 
/*     */         
/* 222 */         if (room.constructor() != null && room.blueprint() != (SETT.ROOMS()).THRONE) {
/* 223 */           box.NL(8);
/* 224 */           GText te = box.text();
/* 225 */           te.lablifySub();
/* 226 */           te.add(¤¤clickRoom).insert(0, (KEYS.MAIN()).MOD.repr());
/* 227 */           box.add((SPRITE)te);
/* 228 */           box.NL().text((room.constructor().blue()).info.name);
/* 229 */           box.NL();
/*     */           
/* 231 */           if (room.constructor().canBeCopied()) {
/* 232 */             te = box.text();
/* 233 */             te.lablifySub();
/* 234 */             te.add(¤¤clickRoom2).insert(0, (KEYS.MAIN()).UNDO.repr());
/* 235 */             box.add((SPRITE)te);
/* 236 */             box.NL().text((room.constructor().blue()).info.name);
/* 237 */             if ((SETT.ROOMS()).construction.isser.is(window.tile().x(), window.tile().y())) {
/* 238 */               box.NL(8);
/* 239 */               box.textL(¤¤reconstruct);
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         } 
/*     */       } else {
/*     */         
/* 247 */         SETT.JOBS().hover(window.tile().x(), window.tile().y(), box);
/*     */         
/* 249 */         Job j = (Job)(SETT.JOBS()).jobGetter.get((COORDINATE)window.tile());
/*     */         
/* 251 */         if (j != null && j.placer() != null) {
/* 252 */           box.NL(8);
/* 253 */           GText te = box.text();
/* 254 */           te.lablifySub();
/* 255 */           te.add(¤¤clickJob).insert(0, (KEYS.MAIN()).MOD.repr());
/* 256 */           box.add((SPRITE)te);
/* 257 */           box.NL().text(j.placer().name());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateHovered(float ds, GameWindow window) {
/*     */     update(ds, window);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isEntity(COORDINATE coo, ENTITY e, SETT_HOVERABLE t) {
/* 270 */     if (e == null)
/* 271 */       return false; 
/* 272 */     if (t == null)
/* 273 */       return true; 
/* 274 */     double edist = COORDINATE.properDistance(coo.x(), coo.y(), e.body().cX(), e.body().cY());
/* 275 */     double tdist = COORDINATE.properDistance(coo.x(), coo.y(), ((THINGS.Thing)t).body().cX(), ((THINGS.Thing)t).body().cY());
/* 276 */     return (edist <= tdist);
/*     */   } protected void update(float ds, GameWindow window) {
/*     */     this.dragging &= MButt.RIGHT.isDown();
/*     */   } private boolean isThing(COORDINATE coo, ENTITY e, SETT_HOVERABLE t) {
/* 280 */     if (t == null)
/* 281 */       return false; 
/* 282 */     if (e == null)
/* 283 */       return true; 
/* 284 */     double edist = COORDINATE.properDistance(coo.x(), coo.y(), e.body().cX(), e.body().cY());
/* 285 */     double tdist = COORDINATE.properDistance(coo.x(), coo.y(), ((THINGS.Thing)t).body().cX(), ((THINGS.Thing)t).body().cY());
/* 286 */     return (edist > tdist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean rightClick() {
/* 292 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void click(GameWindow window) {
/* 297 */     if (MButt.RIGHT.isDown()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 303 */     int px = VIEW.s().getWindow().pixel().x();
/* 304 */     int py = VIEW.s().getWindow().pixel().y();
/* 305 */     int tx = VIEW.s().getWindow().tile().x();
/* 306 */     int ty = VIEW.s().getWindow().tile().y();
/* 307 */     for (SettDebugClick c : this.debugs) {
/* 308 */       if (c.debug(px, py, tx, ty)) {
/*     */         return;
/*     */       }
/*     */     } 
/* 312 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 313 */       Room room = (Room)(SETT.ROOMS()).map.get((COORDINATE)window.tile());
/* 314 */       if (room != null && room.constructor() != null && room.blueprint() != (SETT.ROOMS()).THRONE && (room.constructor().blue()).reqs.passes(FACTIONS.player())) {
/*     */         
/* 316 */         if ((room.constructor().blue()).cat == (SETT.ROOMS()).CATS.DECOR) {
/* 317 */           (VIEW.s()).ui.placer.init(room.constructor().blue(), window.tile().x(), window.tile().y());
/*     */         } else {
/* 319 */           (SETT.ROOMS()).placement.placer.structure.set(window.tile().x(), window.tile().y());
/* 320 */           (VIEW.s()).ui.placer.init(room.constructor().blue(), VIEW.s().getWindow().tile().x(), VIEW.s().getWindow().tile().y());
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 326 */       Job j = (Job)(SETT.JOBS()).jobGetter.get((COORDINATE)window.tile());
/* 327 */       if (j != null && j.placer() != null) {
/* 328 */         (VIEW.s()).tools.place((PLACABLE)j.placer(), j.config());
/*     */         return;
/*     */       } 
/*     */     } 
/* 332 */     if ((KEYS.MAIN()).UNDO.isPressed()) {
/* 333 */       Room room = (Room)(SETT.ROOMS()).map.get((COORDINATE)VIEW.s().getWindow().tile());
/* 334 */       if (room != null && room.constructor() != null && room.blueprint() != (SETT.ROOMS()).THRONE) {
/* 335 */         (SETT.ROOMS()).copy.copy(VIEW.s().getWindow().tile().x(), VIEW.s().getWindow().tile().y());
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 340 */     GameWindow.SUB_MOUSE sUB_MOUSE = window.pixel();
/* 341 */     if (!SETT.PIXEL_BOUNDS.holdsPoint((COORDINATE)sUB_MOUSE))
/*     */       return; 
/* 343 */     ENTITY e = SETT.ENTITIES().getArroundPoint(sUB_MOUSE.x(), sUB_MOUSE.y());
/* 344 */     SETT_HOVERABLE t = SETT.THINGS().getArroundCoo(sUB_MOUSE.x(), sUB_MOUSE.y());
/*     */     
/* 346 */     if (isEntity((COORDINATE)sUB_MOUSE, e, t) && e.canBeClicked()) {
/* 347 */       e.click();
/* 348 */     } else if (isThing((COORDINATE)sUB_MOUSE, e, t) && t.canBeClicked()) {
/* 349 */       t.click();
/* 350 */     } else if ((SETT.ROOMS()).map.is((COORDINATE)window.tile())) {
/* 351 */       Room room = (Room)(SETT.ROOMS()).map.get((COORDINATE)window.tile());
/* 352 */       (VIEW.s()).ui.rooms.click(room, window.tile().x(), window.tile().y());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\ToolDefault.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */