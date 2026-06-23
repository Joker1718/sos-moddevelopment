/*     */ package view.sett.ui.room.priority;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import init.type.WGROUP;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ final class UIRoomRaceAssign
/*     */   extends PlacableMulti
/*     */ {
/*  41 */   private static CharSequence ¤¤name = "Assign Work Groups";
/*  42 */   private static CharSequence ¤¤desc = "Lets you assign Work Groups (species + class) to individual rooms. If the set priorities allows for it, the rooms will be employed according to these settings.";
/*  43 */   private static CharSequence ¤¤prob = "Must be placed on a workplaces.";
/*  44 */   private static CharSequence ¤¤prob2 = "Some or all of the selected groups are not employed in the current room type, and the setting will have no effect.";
/*  45 */   private static CharSequence ¤¤everyone = "Set priority for everyone";
/*  46 */   private static CharSequence ¤¤none = "Set priority for none";
/*  47 */   private static CharSequence ¤¤permission = "Set priority for:";
/*  48 */   private static CharSequence ¤¤permissionAll = "Set priority for All:";
/*     */ 
/*     */   
/*     */   static {
/*  52 */     D.ts(UIRoomRaceAssign.class);
/*     */   }
/*     */   
/*  55 */   private final WGROUP.HTypeBitsImp data = new WGROUP.HTypeBitsImp(false);
/*     */   private final LIST<CLICKABLE> butts;
/*     */   private final ON_TOP_RENDERABLE ren;
/*     */   
/*     */   public UIRoomRaceAssign() {
/*  60 */     super(¤¤name, ¤¤desc, (SPRITE)(SPRITES.icons()).m.citizen);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     this.ren = new ON_TOP_RENDERABLE()
/*     */       {
/*     */         
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */         {
/* 196 */           RenderData.RenderIterator it = data.onScreenTiles();
/* 197 */           GUTIL.filler().init(this);
/* 198 */           while (it.has()) {
/* 199 */             if (!GUTIL.filler().isFilled(it.tx(), it.ty())) {
/* 200 */               RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(it.tx(), it.ty());
/*     */               
/* 202 */               if (ins != null && ins.blueprintI().employment() != null) {
/*     */                 
/* 204 */                 int x = it.tx();
/* 205 */                 int y = it.ty();
/* 206 */                 GUTIL.filler().fill(x, y);
/* 207 */                 int cx = ins.body().cX();
/* 208 */                 int cy = ins.body().cY();
/* 209 */                 int shortest = Integer.MAX_VALUE;
/*     */                 
/* 211 */                 while (GUTIL.filler().hasMore()) {
/* 212 */                   COORDINATE c = GUTIL.filler().poll();
/* 213 */                   int dist = c.x() - cx & Integer.MAX_VALUE;
/* 214 */                   dist += c.y() - cy & Integer.MAX_VALUE;
/* 215 */                   if (dist < shortest) {
/* 216 */                     shortest = dist;
/* 217 */                     x = c.x();
/* 218 */                     y = c.y();
/*     */                   } 
/*     */                   
/* 221 */                   for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 222 */                     DIR d = (DIR)DIR.ORTHO.get(di);
/* 223 */                     if (ins.is(c, d)) {
/* 224 */                       GUTIL.filler().fill(c, d);
/*     */                     }
/*     */                   } 
/*     */                 } 
/* 228 */                 cx *= 64;
/* 229 */                 cy *= 64;
/* 230 */                 cx = data.transformGX(cx);
/* 231 */                 cy = data.transformGY(cy);
/* 232 */                 render(r, ins, cx, cy);
/*     */               } 
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 240 */             it.next();
/*     */           } 
/* 242 */           GUTIL.filler().done();
/* 243 */           remove();
/*     */         }
/*     */         
/* 246 */         private final ArrayList<WGROUP> rens = new ArrayList(WGROUP.all().size());
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private void render(Renderer r, RoomInstance h, int cx, int cy) {
/* 252 */           WGROUP.HTypeBits t = h.employees().preffered();
/* 253 */           int am = 0;
/* 254 */           WGROUP single = null;
/* 255 */           for (WGROUP hh : WGROUP.all()) {
/* 256 */             if (t.is(hh)) {
/* 257 */               single = hh;
/* 258 */               am++;
/*     */             } 
/*     */           } 
/*     */           
/* 262 */           if (am == WGROUP.all().size()) {
/* 263 */             renderSingle(r, cx, cy, (SPRITE)(UI.icons()).m.questionmark);
/* 264 */           } else if (am == 0) {
/* 265 */             renderSingle(r, cx, cy, (SPRITE)(UI.icons()).m.cancel);
/* 266 */           } else if (am == 1) {
/* 267 */             renderSingle(r, cx, cy, h, single);
/* 268 */           } else if (am < WGROUP.all().size() / 2) {
/* 269 */             this.rens.clearSloppy();
/* 270 */             for (WGROUP hh : WGROUP.all()) {
/* 271 */               if (t.is(hh)) {
/* 272 */                 this.rens.add(hh);
/*     */               }
/*     */             } 
/* 275 */             renderMany(r, cx, cy, h, false);
/*     */           } else {
/* 277 */             this.rens.clearSloppy();
/* 278 */             for (WGROUP hh : WGROUP.all()) {
/* 279 */               if (!t.is(hh)) {
/* 280 */                 this.rens.add(hh);
/*     */               }
/*     */             } 
/* 283 */             if (this.rens.size() > 0)
/* 284 */               renderMany(r, cx, cy, h, true); 
/*     */           } 
/*     */         }
/*     */         
/*     */         private void renderSingle(Renderer r, int cx, int cy, SPRITE icon) {
/* 289 */           int w = icon.width() * 4;
/* 290 */           int h = icon.height() * 4;
/* 291 */           int x1 = cx - w / 2;
/* 292 */           int y1 = cy - h / 2;
/* 293 */           icon.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h);
/*     */         }
/*     */         
/*     */         private void renderSingle(Renderer r, int cx, int cy, RoomInstance house, WGROUP g) {
/* 297 */           SPRITE icon = g.icon;
/* 298 */           int w = icon.width() * 4;
/* 299 */           int h = icon.height() * 4;
/* 300 */           int x1 = cx - w / 2;
/* 301 */           int y1 = cy - h / 2;
/* 302 */           icon.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h);
/* 303 */           if (house.blueprintI().employment().employed(g) <= 0) {
/* 304 */             (GCOLOR.UI()).BAD.hovered.bind();
/* 305 */             int w2 = 64;
/* 306 */             (UI.icons()).s.alert.render((SPRITE_RENDERER)r, x1, x1 + w2, y1 - w2 / 2, y1 + w2 / 2);
/* 307 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         private void renderMany(Renderer r, int cx, int cy, RoomInstance house, boolean anti) {
/* 313 */           int width = house.body().width() * 64;
/* 314 */           int w = 48;
/* 315 */           int h = ((WGROUP)this.rens.get(0)).icon.height() * 4 / 2;
/*     */           
/* 317 */           int dx = width / this.rens.size();
/* 318 */           dx = CLAMP.i(dx, 1, w);
/*     */           
/* 320 */           int x1 = cx - dx * this.rens.size() / 2;
/* 321 */           int y1 = cy - h;
/*     */           
/* 323 */           for (WGROUP t : this.rens) {
/* 324 */             t.icon.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h);
/*     */             
/* 326 */             if (anti)
/* 327 */               (UI.icons()).m.anti.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h); 
/* 328 */             if (house.blueprintI().employment().employed(t) <= 0) {
/* 329 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 330 */               int w2 = 32;
/* 331 */               (UI.icons()).s.alert.render((SPRITE_RENDERER)r, x1, x1 + w2, y1 - w2 / 2, y1 + w2 / 2);
/* 332 */               COLOR.unbind();
/*     */             } 
/*     */             
/* 335 */             x1 += dx;
/*     */           } 
/*     */         }
/*     */       };
/*     */     GuiSection sec = new GuiSection();
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.questionmark) {
/*     */           protected void clickA() {
/*     */             UIRoomRaceAssign.this.data.setEveryone();
/*     */           }
/*     */         }).hoverInfoSet(¤¤everyone));
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)HCLASSES.CITIZEN().icon()) {
/*     */           protected void clickA() {
/*     */             UIRoomRaceAssign.this.data.clear();
/*     */             for (Race r : RACES.all())
/*     */               UIRoomRaceAssign.this.data.set(WGROUP.get(HTYPES.SUBJECT(), r)); 
/*     */           }
/*     */         }).hoverInfoSet(String.valueOf(¤¤permissionAll) + " " + String.valueOf(¤¤permissionAll)));
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)HCLASSES.SLAVE().icon()) {
/*     */           protected void clickA() {
/*     */             UIRoomRaceAssign.this.data.clear();
/*     */             for (Race r : RACES.all())
/*     */               UIRoomRaceAssign.this.data.set(WGROUP.get(HTYPES.SLAVE(), r)); 
/*     */           }
/*     */         }).hoverInfoSet(String.valueOf(¤¤permissionAll) + " " + String.valueOf(¤¤permissionAll)));
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel) {
/*     */           protected void clickA() {
/*     */             UIRoomRaceAssign.this.data.clear();
/*     */           }
/*     */         }).hoverInfoSet(¤¤none));
/*     */     GuiSection s = new GuiSection();
/*     */     for (WGROUP t : WGROUP.all()) {
/*     */       CLICKABLE bb = (new GButt.ButtPanel(t.icon) {
/*     */           protected void clickA() {
/*     */             if (selectedIs()) {
/*     */               UIRoomRaceAssign.this.data.clear(t);
/*     */             } else {
/*     */               UIRoomRaceAssign.this.data.set(t);
/*     */             } 
/*     */           }
/*     */           
/*     */           protected void renAction() {
/*     */             selectedSet(UIRoomRaceAssign.this.data.is(t));
/*     */           }
/*     */         }).hoverInfoSet(String.valueOf(¤¤permission) + " " + String.valueOf(¤¤permission));
/*     */       if (s.getLastX2() > 500) {
/*     */         bb.body().moveX1(0.0D).moveY1(s.body().y2());
/*     */         s.add((RENDEROBJ)bb);
/*     */         continue;
/*     */       } 
/*     */       s.addRightC(0, (RENDEROBJ)bb);
/*     */     } 
/*     */     sec.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */     this.butts = (LIST<CLICKABLE>)new ArrayList(sec);
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */     RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(tx, ty);
/*     */     if (ins != null && ins.blueprintI().employment() != null)
/*     */       return null; 
/*     */     return ¤¤prob;
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */     RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(tx, ty);
/*     */     if (ins != null && ins.blueprintI().employment() != null)
/*     */       ins.employees().prefferedSet((WGROUP.HTypeBits)this.data); 
/*     */   }
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*     */     RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(fromX, fromY);
/*     */     return (ins != null && ins.is(toX, toY));
/*     */   }
/*     */   
/*     */   public void placeInfo(GBox b, int oktiles, AREA a) {
/*     */     super.placeInfo(b, oktiles, a);
/*     */     b.NL();
/*     */     for (COORDINATE c : a.body()) {
/*     */       if (a.is(c)) {
/*     */         RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(c.x(), c.y());
/*     */         if (ins == null || !c.isSameAs(ins.mX(), ins.mY()) || ins.blueprintI().employmentExtra() == null)
/*     */           continue; 
/*     */         for (WGROUP g : WGROUP.all()) {
/*     */           if (this.data.is(g) && ins.blueprintI().employment().employed(g) <= 0) {
/*     */             GText t = b.text();
/*     */             t.warnify().add(¤¤prob2);
/*     */             b.add((SPRITE)t);
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/*     */     this.ren.add();
/*     */     return this.butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\UIRoomRaceAssign.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */