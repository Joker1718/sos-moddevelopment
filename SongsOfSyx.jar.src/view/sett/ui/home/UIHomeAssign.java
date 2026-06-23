/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HGROUP;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class UIHomeAssign
/*     */   extends PlacableMulti
/*     */ {
/*  37 */   private static CharSequence ¤¤name = "Assign";
/*  38 */   private static CharSequence ¤¤desc = "Lets you assign homes to specific criteria.";
/*  39 */   private static CharSequence ¤¤prob = "Must be placed on a house or a house construction.";
/*     */   
/*  41 */   private static CharSequence ¤¤everyone = "Set permission for everyone";
/*  42 */   private static CharSequence ¤¤none = "Set permission for none";
/*  43 */   private static CharSequence ¤¤permission = "Set permission for:";
/*  44 */   private static CharSequence ¤¤permissionAll = "Set permission for All:";
/*     */ 
/*     */   
/*     */   static {
/*  48 */     D.ts(UIHomeAssign.class);
/*     */   }
/*     */   
/*  51 */   private final HGROUP.HTypeBitsImp data = new HGROUP.HTypeBitsImp(false);
/*     */   private final LIST<CLICKABLE> butts;
/*     */   private final ON_TOP_RENDERABLE ren;
/*     */   
/*     */   public UIHomeAssign() {
/*  56 */     super(¤¤name, ¤¤desc, (SPRITE)(SPRITES.icons()).m.citizen);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 187 */     this.ren = new ON_TOP_RENDERABLE()
/*     */       {
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */         {
/* 191 */           RenderData.RenderIterator it = data.onScreenTiles();
/* 192 */           while (it.has()) {
/* 193 */             ROOMA h = UIHomeAssign.this.room(it.tx(), it.ty());
/* 194 */             if (h != null && h.body().cX() == it.tx() && h.body().cY() == it.ty())
/*     */             {
/* 196 */               render(r, h, UIHomeAssign.this.availability(it.tx(), it.ty()), it);
/*     */             }
/* 198 */             it.next();
/*     */           } 
/* 200 */           remove();
/*     */         }
/*     */         
/* 203 */         private final ArrayList<HGROUP> rens = new ArrayList(HGROUP.all().size());
/*     */ 
/*     */         
/*     */         private void render(Renderer r, ROOMA h, HGROUP.HTypeBits t, RenderData.RenderIterator it) {
/* 207 */           double dx = h.body().x1() + h.body().width() * 0.5D;
/* 208 */           dx -= h.body().x1();
/* 209 */           int cx = it.x() - 32;
/*     */           
/* 211 */           double dy = h.body().y1() + h.body().height() * 0.5D;
/* 212 */           dy -= h.body().y1();
/* 213 */           int cy = it.y() - 32;
/*     */ 
/*     */           
/* 216 */           int am = 0;
/* 217 */           HGROUP single = null;
/* 218 */           for (HGROUP hh : HGROUP.all()) {
/* 219 */             if (t.is(hh)) {
/* 220 */               single = hh;
/* 221 */               am++;
/*     */             } 
/*     */           } 
/*     */           
/* 225 */           if (am == HGROUP.all().size()) {
/* 226 */             renderSingle(r, cx, cy, (SPRITE)(UI.icons()).m.questionmark);
/* 227 */           } else if (am == 0) {
/* 228 */             renderSingle(r, cx, cy, (SPRITE)(UI.icons()).m.cancel);
/* 229 */           } else if (am == 1) {
/* 230 */             renderSingle(r, cx, cy, single.icon);
/* 231 */           } else if (am < HGROUP.all().size() / 2) {
/* 232 */             this.rens.clearSloppy();
/* 233 */             for (HGROUP hh : HGROUP.all()) {
/* 234 */               if (t.is(hh)) {
/* 235 */                 this.rens.add(hh);
/*     */               }
/*     */             } 
/* 238 */             renderMany(r, cx, cy, h, false);
/*     */           } else {
/* 240 */             this.rens.clearSloppy();
/* 241 */             for (HGROUP hh : HGROUP.all()) {
/* 242 */               if (!t.is(hh)) {
/* 243 */                 this.rens.add(hh);
/*     */               }
/*     */             } 
/* 246 */             if (this.rens.size() > 0)
/* 247 */               renderMany(r, cx, cy, h, true); 
/*     */           } 
/*     */         }
/*     */         
/*     */         private void renderSingle(Renderer r, int cx, int cy, SPRITE icon) {
/* 252 */           int w = icon.width() * 4;
/* 253 */           int h = icon.height() * 4;
/* 254 */           int x1 = cx - w / 2;
/* 255 */           int y1 = cy - h / 2;
/* 256 */           icon.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h);
/*     */         }
/*     */ 
/*     */         
/*     */         private void renderMany(Renderer r, int cx, int cy, ROOMA house, boolean anti) {
/* 261 */           int width = house.body().width() * 64;
/* 262 */           int w = 48;
/* 263 */           int h = ((HGROUP)this.rens.get(0)).icon.height() * 4 / 2;
/*     */           
/* 265 */           int dx = width / this.rens.size();
/* 266 */           dx = CLAMP.i(dx, 1, w);
/*     */           
/* 268 */           int x1 = cx - dx * this.rens.size() / 2;
/* 269 */           int y1 = cy - h;
/*     */           
/* 271 */           for (HGROUP t : this.rens) {
/* 272 */             t.icon.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h);
/* 273 */             if (anti)
/* 274 */               (UI.icons()).m.anti.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h); 
/* 275 */             x1 += dx;
/*     */           } 
/*     */         }
/*     */       };
/*     */     GuiSection sec = new GuiSection();
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.questionmark) {
/*     */           protected void clickA() {
/*     */             UIHomeAssign.this.data.setEveryone();
/*     */           }
/*     */         }).hoverInfoSet(¤¤everyone));
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)HCLASSES.CITIZEN().icon()) {
/*     */           protected void clickA() {
/*     */             UIHomeAssign.this.data.clear();
/*     */             for (Race r : RACES.all())
/*     */               UIHomeAssign.this.data.set(HGROUP.get(HCLASSES.CITIZEN(), r)); 
/*     */           }
/*     */         }).hoverInfoSet(String.valueOf(¤¤permissionAll) + " " + String.valueOf(¤¤permissionAll)));
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)HCLASSES.SLAVE().icon()) {
/*     */           protected void clickA() {
/*     */             UIHomeAssign.this.data.clear();
/*     */             for (Race r : RACES.all())
/*     */               UIHomeAssign.this.data.set(HGROUP.get(HCLASSES.SLAVE(), r)); 
/*     */           }
/*     */         }).hoverInfoSet(String.valueOf(¤¤permissionAll) + " " + String.valueOf(¤¤permissionAll)));
/*     */     sec.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel) {
/*     */           protected void clickA() {
/*     */             UIHomeAssign.this.data.clear();
/*     */           }
/*     */         }).hoverInfoSet(¤¤none));
/*     */     GuiSection s = new GuiSection();
/*     */     for (HGROUP t : HGROUP.all()) {
/*     */       CLICKABLE bb = (new GButt.ButtPanel(t.icon) {
/*     */           protected void clickA() {
/*     */             if (selectedIs()) {
/*     */               UIHomeAssign.this.data.clear(t);
/*     */             } else {
/*     */               UIHomeAssign.this.data.set(t);
/*     */             } 
/*     */           }
/*     */           
/*     */           protected void renAction() {
/*     */             selectedSet(UIHomeAssign.this.data.is(t));
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
/*     */     if (room(tx, ty) != null)
/*     */       return null; 
/*     */     return ¤¤prob;
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */     settingSet((HGROUP.HTypeBits)this.data, tx, ty);
/*     */   }
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*     */     return (room(fromX, fromY) != null && room(fromX, fromY) == room(toX, toY));
/*     */   }
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/*     */     this.ren.add();
/*     */     return this.butts;
/*     */   }
/*     */   
/*     */   public ROOMA room(int tx, int ty) {
/*     */     if (availability(tx, ty) != null)
/*     */       return (ROOMA)(SETT.ROOMS()).map.get(tx, ty); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public HomeInstance.State state(int tx, int ty) {
/*     */     RoomState state = (SETT.ROOMS()).construction.state(tx, ty);
/*     */     if (state instanceof HomeInstance.State)
/*     */       return (HomeInstance.State)state; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public HGROUP.HTypeBits availability(int tx, int ty) {
/*     */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/*     */     if (h != null)
/*     */       return h.setting(); 
/*     */     HomeInstance.State s = state(tx, ty);
/*     */     if (s != null)
/*     */       return (HGROUP.HTypeBits)s.egroup; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public void settingSet(HGROUP.HTypeBits bits, int tx, int ty) {
/*     */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/*     */     if (h != null) {
/*     */       h.settingSet(bits);
/*     */     } else {
/*     */       HomeInstance.State s = state(tx, ty);
/*     */       if (s != null)
/*     */         s.egroup.copy(bits); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomeAssign.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */