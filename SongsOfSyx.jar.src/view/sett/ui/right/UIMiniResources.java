/*     */ package view.sett.ui.right;
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.C;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class UIMiniResources extends UIPanelRightSett.Expansion {
/*  37 */   private static CharSequence ¤¤desc = "¤Click to open resource details, right click to go to warehouse."; private GuiSection mini;
/*     */   
/*     */   static {
/*  40 */     D.ts(UIMiniResources.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection full;
/*     */   
/*     */   public UIMiniResources(int index, int y1) {
/*  47 */     super(index);
/*     */     
/*  49 */     this.full = new Full(y1);
/*  50 */     this.mini = new Mini(y1);
/*     */     
/*  52 */     add((RENDEROBJ)this.full);
/*     */     
/*  54 */     GButt.Glow glow = new GButt.Glow((SPRITE)(SPRITES.icons()).s.arrow_left)
/*     */       {
/*     */         protected void clickA() {
/*  57 */           int y1 = body().y1();
/*  58 */           UIMiniResources.this.clear();
/*  59 */           UIMiniResources.this.add((RENDEROBJ)UIMiniResources.this.full);
/*  60 */           body().moveY1(y1);
/*     */         }
/*     */       };
/*  63 */     this.mini.add((RENDEROBJ)glow, this.mini.body().x2() - glow.body().width() - 4, this.mini.body().y1() + 4);
/*  64 */     glow = new GButt.Glow((SPRITE)(SPRITES.icons()).s.arrow_right)
/*     */       {
/*     */         protected void clickA() {
/*  67 */           int y1 = body().y1();
/*  68 */           UIMiniResources.this.clear();
/*  69 */           UIMiniResources.this.add((RENDEROBJ)UIMiniResources.this.mini);
/*  70 */           body().moveY1(y1);
/*     */         }
/*     */       };
/*  73 */     this.full.add((RENDEROBJ)glow, this.full.body().x2() - glow.body().width() - 4, this.full.body().y1() + 4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Mini
/*     */     extends GuiSection
/*     */   {
/*     */     private final INT.INTE t;
/*     */ 
/*     */ 
/*     */     
/*     */     Mini(int y1) {
/*  86 */       RENDEROBJ row = UIMiniResources.mini((RESOURCE)RESOURCES.ALL().get(0));
/*  87 */       int width = row.body().width();
/*  88 */       body().moveY1(y1);
/*  89 */       int cats = 0;
/*  90 */       for (RESOURCE r : RESOURCES.ALL()) {
/*  91 */         if (r.category > cats)
/*  92 */           cats = r.category; 
/*     */       } 
/*  94 */       LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */       
/*  96 */       int cat = ((RESOURCE)RESOURCES.ALL().get(0)).category;
/*     */       
/*  98 */       for (RESOURCE r : RESOURCES.ALL()) {
/*  99 */         if (r.category != cat) {
/* 100 */           rows.add(new RENDEROBJ.RenderImp(width, 16)
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds) {
/* 103 */                   GCOLOR.UI().borderH(r, body().x1() + 4, body().x2() - 4, body().y1() + 7, body().y1() + 10);
/*     */                 }
/*     */               });
/* 106 */           cat = r.category;
/*     */         } 
/*     */         
/* 109 */         rows.add(UIMiniResources.mini(r));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 115 */       body().setDim((width + 6), (C.HEIGHT() - y1));
/*     */ 
/*     */       
/* 118 */       y1 += 4;
/*     */       
/* 120 */       GButt.Glow glow = new GButt.Glow((UI.decor()).up)
/*     */         {
/*     */           protected void renAction() {
/* 123 */             activeSet((UIMiniResources.Mini.this.t.get() > 0));
/*     */           }
/*     */           
/*     */           protected void clickA() {
/* 127 */             UIMiniResources.Mini.this.t.inc(-1);
/*     */           }
/*     */         };
/* 130 */       glow.body().moveCX((body().cX() + 2));
/* 131 */       glow.body().moveY1(y1);
/* 132 */       add((RENDEROBJ)glow);
/*     */ 
/*     */       
/* 135 */       GScrollRows sc = new GScrollRows((Iterable)rows, C.HEIGHT() - getLastY2() - glow.body().height() - 8, 0, false);
/* 136 */       addDownC(0, (RENDEROBJ)sc.view());
/*     */       
/* 138 */       this.t = sc.target;
/*     */       
/* 140 */       glow = new GButt.Glow((UI.decor()).down)
/*     */         {
/*     */           protected void renAction() {
/* 143 */             activeSet((UIMiniResources.Mini.this.t.get() != UIMiniResources.Mini.this.t.max()));
/*     */           }
/*     */           
/*     */           protected void clickA() {
/* 147 */             UIMiniResources.Mini.this.t.inc(1);
/*     */           }
/*     */         };
/* 150 */       addDownC(4, (RENDEROBJ)glow);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Full
/*     */     extends GuiSection
/*     */   {
/*     */     private final INT.INTE t;
/*     */ 
/*     */     
/*     */     Full(int y1) {
/* 162 */       RENDEROBJ row = UIMiniResources.big((RESOURCE)RESOURCES.ALL().get(0));
/* 163 */       int width = row.body().width() * 2;
/* 164 */       body().setDim((width + 6), (C.HEIGHT() - y1));
/* 165 */       body().moveY1(y1);
/* 166 */       int cats = 0;
/* 167 */       for (RESOURCE r : RESOURCES.ALL()) {
/* 168 */         if (r.category > cats)
/* 169 */           cats = r.category; 
/*     */       } 
/* 171 */       LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */       
/* 173 */       GuiSection s = null;
/* 174 */       int cat = ((RESOURCE)RESOURCES.ALL().get(0)).category;
/*     */       
/* 176 */       for (RESOURCE r : RESOURCES.ALL()) {
/* 177 */         if (r.category != cat) {
/* 178 */           rows.add(new RENDEROBJ.RenderImp(width, 16)
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds) {
/* 181 */                   GCOLOR.UI().borderH(r, body().x1() + 4, body().x2() - 4, body().y1() + 7, body().y1() + 10);
/*     */                 }
/*     */               });
/* 184 */           s = new GuiSection();
/* 185 */           rows.add(s);
/* 186 */           cat = r.category;
/*     */         } 
/*     */         
/* 189 */         if (s == null || s.elements().size() >= 2) {
/* 190 */           s = new GuiSection();
/* 191 */           rows.add(s);
/*     */         } 
/*     */         
/* 194 */         s.addRightC(0, UIMiniResources.big(r));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 206 */       y1 += 4;
/*     */       
/* 208 */       GButt.Glow glow = new GButt.Glow((UI.decor()).up)
/*     */         {
/*     */           protected void renAction() {
/* 211 */             activeSet((UIMiniResources.Full.this.t.get() > 0));
/*     */           }
/*     */           
/*     */           protected void clickA() {
/* 215 */             UIMiniResources.Full.this.t.inc(-1);
/*     */           }
/*     */         };
/*     */       
/* 219 */       glow.body().centerX((BODY_HOLDER)this);
/* 220 */       glow.body().moveY1(y1);
/* 221 */       add((RENDEROBJ)glow);
/*     */ 
/*     */       
/* 224 */       GScrollRows sc = new GScrollRows((Iterable)rows, C.HEIGHT() - getLastY2() - glow.body().height() - 6, 0, false);
/* 225 */       addDownC(0, (RENDEROBJ)sc.view());
/*     */       
/* 227 */       this.t = sc.target;
/*     */       
/* 229 */       glow = new GButt.Glow((UI.decor()).down)
/*     */         {
/*     */           protected void renAction() {
/* 232 */             activeSet((UIMiniResources.Full.this.t.get() != UIMiniResources.Full.this.t.max()));
/*     */           }
/*     */           
/*     */           protected void clickA() {
/* 236 */             UIMiniResources.Full.this.t.inc(1);
/*     */           }
/*     */         };
/* 239 */       addDownC(4, (RENDEROBJ)glow);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static GuiSection resBody(final RESOURCE res) {
/* 248 */     return new GuiSection()
/*     */       {
/* 250 */         int wI = 0;
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 254 */           res.hoverDetailed(text);
/* 255 */           GBox b = (GBox)text;
/* 256 */           b.sep();
/* 257 */           b.text(UIMiniResources.¤¤desc);
/*     */           
/* 259 */           super.hoverInfoGet(text);
/*     */         }
/* 261 */         int ri = 0;
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 265 */           double a = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(res);
/* 266 */           double c = ((SETT.ROOMS()).STOCKPILE.tally()).space.total(res);
/* 267 */           double d = 0.0D;
/* 268 */           if (c > 0.0D)
/* 269 */             d = a / c; 
/* 270 */           if (d > 0.9D) {
/* 271 */             GMeter.render(r, GMeter.C_REDPURPLE, d, (RECTANGLE)body());
/* 272 */           } else if (c > 0.0D) {
/* 273 */             GMeter.render(r, GMeter.C_REDGREEN, d, (RECTANGLE)body());
/*     */           } else {
/* 275 */             GMeter.render(r, GMeter.C_INACTIVE, d, (RECTANGLE)body());
/*     */           } 
/* 277 */           if ((SETT.ROOMS()).IMPORT.tally.capacity.get(res) > 0) {
/* 278 */             d = (FACTIONS.player().buyer(res.tr())).limit.getD();
/* 279 */             if (d > 0.0D) {
/* 280 */               int x1 = (int)(body().x1() + d * (body().width() - 2));
/* 281 */               COLOR.WHITE85.render(r, x1, x1 + 1, body().y1(), body().y2());
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 287 */           if (!hoveredIs()) {
/* 288 */             OPACITY.O25.bind();
/* 289 */             COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 290 */             OPACITY.unbind();
/*     */           } 
/*     */ 
/*     */           
/* 294 */           if (Math.abs(this.ri - VIEW.RI()) <= 1 && hoveredIs() && 
/* 295 */             MButt.RIGHT.consumeClick())
/*     */           {
/* 297 */             for (int i = 0; i < (SETT.ROOMS()).STOCKPILE.instancesSize(); i++) {
/* 298 */               this.wI++;
/* 299 */               if (this.wI >= (SETT.ROOMS()).STOCKPILE.instancesSize()) {
/* 300 */                 this.wI = 0;
/*     */               }
/* 302 */               RoomInstance ins = (SETT.ROOMS()).STOCKPILE.getInstance(this.wI, res);
/*     */               
/* 304 */               if (ins != null) {
/* 305 */                 (VIEW.s().getWindow()).centererTile.set(ins.body().cX(), ins.body().cY());
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */           
/* 312 */           this.ri = VIEW.RI();
/* 313 */           super.render(r, ds);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean click() {
/* 319 */           (VIEW.UI()).goods.detail(res, (Faction)GAME.player());
/* 320 */           return super.click();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ stat(final RESOURCE res) {
/* 327 */     return (RENDEROBJ)(new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 331 */           text.setFont((UI.FONT()).S);
/* 332 */           int a = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(res);
/* 333 */           GFORMAT.i(text, a);
/*     */           
/* 335 */           if (a == 0)
/* 336 */             if ((SETT.PATH()).finders.resource.scattered.has(res)) {
/* 337 */               text.normalify();
/*     */             } else {
/* 339 */               text.errorify();
/*     */             }  
/*     */         }
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 343 */           OPACITY.O018.bind();
/* 344 */           COLOR.BLACK.render(r, X1 - 1, X2 + 1, Y1 - 1, Y2 + 1);
/* 345 */           OPACITY.unbind();
/* 346 */           super.render(r, X1, X2, Y1, Y2);
/*     */         }
/* 349 */       }).r(DIR.NW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 357 */     if (visableIs()) {
/* 358 */       (GCOLOR.UI()).panBG.render(r, (RECTANGLE)body());
/* 359 */       GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/* 360 */       super.render(r, ds);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ mini(RESOURCE res) {
/* 368 */     GuiSection s = resBody(res);
/*     */     
/* 370 */     s.add((res.icon()).small, 0, 0);
/* 371 */     RENDEROBJ r = stat(res);
/*     */ 
/*     */     
/* 374 */     s.addRightC(3, r);
/* 375 */     s.body().incrW(40.0D);
/*     */ 
/*     */ 
/*     */     
/* 379 */     s.pad(2, 4);
/* 380 */     return (RENDEROBJ)s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ big(RESOURCE res) {
/* 387 */     GuiSection s = resBody(res);
/*     */     
/* 389 */     s.add((SPRITE)res.icon(), 0, 0);
/* 390 */     RENDEROBJ r = stat(res);
/*     */ 
/*     */     
/* 393 */     s.addRightC(1, r);
/* 394 */     s.body().incrW(42.0D);
/*     */ 
/*     */ 
/*     */     
/* 398 */     s.pad(2, 4);
/* 399 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniResources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */