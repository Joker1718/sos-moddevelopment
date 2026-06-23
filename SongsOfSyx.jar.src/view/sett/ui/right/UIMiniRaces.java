/*     */ package view.sett.ui.right;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.constant.C;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
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
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ 
/*     */ final class UIMiniRaces extends UIPanelRightSett.Expansion {
/*     */   private final INT.INTE t;
/*     */   
/*     */   public UIMiniRaces(int index, int y1) {
/*  51 */     super(index);
/*     */     
/*  53 */     RENDEROBJ[] rows = new RENDEROBJ[RACES.all().size()];
/*  54 */     for (int i = 0; i < RACES.all().size(); i++) {
/*  55 */       rows[i] = noble(i);
/*     */     }
/*     */     
/*  58 */     int width = rows[0].body().width();
/*  59 */     body().setDim((width + 6), (C.HEIGHT() - y1));
/*     */ 
/*     */ 
/*     */     
/*  63 */     GButt.Glow glow = new GButt.Glow((UI.decor()).up)
/*     */       {
/*     */         protected void renAction() {
/*  66 */           activeSet((UIMiniRaces.this.t.get() > 0));
/*     */         }
/*     */         
/*     */         protected void clickA() {
/*  70 */           UIMiniRaces.this.t.inc(-1);
/*     */         }
/*     */       };
/*  73 */     glow.body().moveCX(body().cX());
/*  74 */     glow.body().moveY1((body().y1() + 3));
/*  75 */     add((RENDEROBJ)glow);
/*     */     
/*  77 */     GScrollRows sc = new GScrollRows(rows, C.HEIGHT() - y1 - (glow.body().height() + 3) * 2, 0, false);
/*  78 */     addDownC(0, (RENDEROBJ)sc.view());
/*     */     
/*  80 */     glow = new GButt.Glow((UI.decor()).down)
/*     */       {
/*     */         protected void renAction() {
/*  83 */           activeSet((UIMiniRaces.this.t.get() != UIMiniRaces.this.t.max()));
/*     */         }
/*     */         
/*     */         protected void clickA() {
/*  87 */           UIMiniRaces.this.t.inc(1);
/*     */         }
/*     */       };
/*  90 */     addDownC(0, (RENDEROBJ)glow);
/*  91 */     body().moveY1(y1);
/*  92 */     this.t = sc.target;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 104 */     if (visableIs()) {
/* 105 */       (GCOLOR.UI()).panBG.render(r, (RECTANGLE)body());
/* 106 */       GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/* 107 */       super.render(r, ds);
/*     */     } 
/* 109 */     if (!MButt.LEFT.isDown())
/* 110 */       clickI = -1; 
/*     */   }
/*     */   
/* 113 */   private static CharSequence ¤¤Immigrants = "¤Immigrants";
/* 114 */   private static CharSequence ¤¤ToBeAccepted = "¤To be Accepted";
/* 115 */   private static CharSequence ¤¤Children = "¤Infants";
/* 116 */   private static CharSequence ¤¤Desc = "¤An assortment of opinions from your citizens:";
/* 117 */   private static CharSequence ¤¤Double = "¤Double click to grant access to all immigrants. Right click to open species settings.";
/* 118 */   private static CharSequence ¤¤Incoming = "¤Incoming";
/* 119 */   private static CharSequence ¤¤PerDay = "/day";
/*     */   
/*     */   static {
/* 122 */     D.ts(UIMiniRaces.class);
/*     */   }
/*     */   
/* 125 */   static int clickI = -1;
/*     */ 
/*     */   
/*     */   private static class RaceUI
/*     */     extends GuiSection
/*     */   {
/* 131 */     private double viewI = -300.0D;
/* 132 */     private int cache = 0;
/*     */     private int old;
/*     */     private final int ri;
/* 135 */     private final ArrayList<Str> tmp = new ArrayList((Object[])new Str[] {
/* 136 */           new Str(128), 
/* 137 */           new Str(128), 
/* 138 */           new Str(128), 
/* 139 */           new Str(128)
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int li;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RaceUI(final int ri) {
/* 195 */       this.li = -1; this.ri = ri; body().setWidth(48.0D); addDownC(2, (SPRITE)new SPRITE.Imp(24, 24) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { Race res = (FACTIONS.player()).races.get(ri); if (POP.next(HCLASSES.CITIZEN(), res) == 0) COLOR.WHITE65.bind();  (res.appearance()).icon.render(r, X1, Y1); COLOR.unbind(); if (VIEW.renderSecond() - UIMiniRaces.RaceUI.this.viewI > 5.0D) { UIMiniRaces.RaceUI.this.old = UIMiniRaces.RaceUI.this.cache; UIMiniRaces.RaceUI.this.cache = SETT.ENTRY().immi().wanted(res); UIMiniRaces.RaceUI.this.viewI = VIEW.renderSecond(); }  if (UIMiniRaces.RaceUI.this.cache == 0) return;  int am = CLAMP.i(UIMiniRaces.RaceUI.this.cache / 5, 1, 4); COLOR.BLACK.bind(); int i; for (i = 0; i < am; i++) (SPRITES.icons()).s.arrow_right.render(r, X1 - 10 + 12 * i, Y1 - 2);  COLOR.YELLOW100.bind(); if (UIMiniRaces.RaceUI.this.cache > UIMiniRaces.RaceUI.this.old)
/*     */                 OPACITY.O25TO100.bind();  for (i = 0; i < am; i++)
/*     */                 (SPRITES.icons()).s.arrow_right.render(r, X1 - 12 + 12 * i, Y1 - 4);  COLOR.unbind(); OPACITY.unbind(); } }
/*     */         ); addDownC(-2, (RENDEROBJ)(new GStat() { public void update(GText text) { Race res = (FACTIONS.player()).races.get(ri); GFORMAT.iBig(text, POP.tot(HCLASSES.CITIZEN(), res)); } }).bg().decrease().r(DIR.C)); pad(0, 4);
/* 199 */     } public void hoverInfoGet(GUI_BOX text) { this.viewI = -5.0D;
/* 200 */       GBox b = (GBox)text;
/* 201 */       Race res = (FACTIONS.player()).races.get(this.ri);
/* 202 */       b.title((CharSequence)b.text().add((HCLASSES.CITIZEN()).names).add(':').s().add(res.info.names));
/* 203 */       b.text(res.info.desc);
/* 204 */       b.NL();
/*     */       
/* 206 */       b.add((SPRITE)b.text().lablifySub().add(((STATS.POP()).POP.info()).name));
/* 207 */       b.tab(6);
/* 208 */       b.add((SPRITE)b.text().add((POP.tot(HCLASSES.CITIZEN(), res) - STATS.POP().pop(res, (STATS.POP()).reproduction.child(HCLASSES.CITIZEN())))));
/* 209 */       b.NL();
/*     */       
/* 211 */       if (res.physics.babyDays > 0) {
/* 212 */         b.textL(((STATS.POP()).reproduction.child(HCLASSES.CITIZEN())).names);
/* 213 */         b.tab(6);
/* 214 */         b.add((SPRITE)GFORMAT.i(b.text(), STATS.POP().pop(res, (STATS.POP()).reproduction.child(HCLASSES.CITIZEN()))));
/* 215 */         b.tab(8);
/* 216 */         b.add((SPRITE)GFORMAT.f0(b.text(), (STATS.POP()).reproduction.kidsPerYear(HCLASSES.CITIZEN(), res) / TIME.years().bitConversion((TIMECYCLE)TIME.days())));
/* 217 */         b.text(UIMiniRaces.¤¤PerDay);
/* 218 */         b.NL();
/* 219 */         b.textL(UIMiniRaces.¤¤Children);
/* 220 */         b.tab(6);
/* 221 */         b.add((SPRITE)GFORMAT.iIncr(b.text(), STATS.POP().pop(res, (STATS.POP()).reproduction.parent(HCLASSES.CITIZEN()))));
/* 222 */         b.NL(2);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 227 */       b.add((SPRITE)b.text().lablifySub().add((STANDINGS.CITIZEN().info()).name));
/* 228 */       b.tab(6);
/* 229 */       b.add((SPRITE)GFORMAT.perc(b.text(), (STANDINGS.CITIZEN()).loyalty.getD(res)));
/* 230 */       b.NL(8);
/*     */       
/* 232 */       b.add((SPRITE)b.text().lablifySub().add((STANDINGS.CITIZEN()).bhappiness.name));
/* 233 */       b.tab(6);
/* 234 */       b.add((SPRITE)GFORMAT.perc(b.text(), (STANDINGS.CITIZEN()).happiness.getD(res)));
/* 235 */       b.NL(8);
/*     */       
/* 237 */       if (WORLD.camps().available(res)) {
/*     */         
/* 239 */         b.NL(8);
/* 240 */         b.textLL(Dic.¤¤havens);
/* 241 */         b.tab(6);
/* 242 */         b.add((SPRITE)GFORMAT.i(b.text(), WORLD.camps().current((Faction)FACTIONS.player(), res)));
/* 243 */         b.NL();
/*     */         
/* 245 */         b.textL(UIMiniRaces.¤¤Immigrants);
/* 246 */         b.tab(6);
/* 247 */         b.add((SPRITE)GFORMAT.i(b.text(), SETT.ENTRY().immi().wanted(res)));
/* 248 */         b.tab(8);
/* 249 */         b.add((SPRITE)GFORMAT.f0(b.text(), (SETT.ENTRY().immi().wanted(res) <= 0) ? 0.0D : SETT.ENTRY().immi().immigrantsPerDay(res)));
/* 250 */         b.text(UIMiniRaces.¤¤PerDay);
/* 251 */         b.NL();
/* 252 */         b.tab(1);
/* 253 */         b.textL(UIMiniRaces.¤¤Incoming);
/* 254 */         b.tab(6);
/* 255 */         b.add((SPRITE)GFORMAT.iIncr(b.text(), SETT.ENTRY().immi().admitted(res)));
/* 256 */         b.NL(2);
/*     */       }
/*     */       else {
/*     */         
/* 260 */         b.textL(UIMiniRaces.¤¤ToBeAccepted);
/* 261 */         b.tab(6);
/* 262 */         b.add((SPRITE)GFORMAT.i(b.text(), SETT.ENTRY().immi().wanted(res)));
/* 263 */         b.tab(8);
/* 264 */         b.add((SPRITE)GFORMAT.f0(b.text(), (SETT.ENTRY().immi().wanted(res) <= 0) ? 0.0D : SETT.ENTRY().immi().immigrantsPerDay(res)));
/* 265 */         b.text(UIMiniRaces.¤¤PerDay);
/* 266 */         b.NL();
/* 267 */         b.tab(1);
/* 268 */         b.textL(UIMiniRaces.¤¤Incoming);
/* 269 */         b.tab(6);
/* 270 */         b.add((SPRITE)GFORMAT.iIncr(b.text(), SETT.ENTRY().immi().admitted(res)));
/* 271 */         b.NL(2);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 278 */       b.NL(8);
/*     */       
/* 280 */       b.text(UIMiniRaces.¤¤Double);
/*     */       
/* 282 */       b.sep();
/*     */       
/* 284 */       if (POP.tot(HCLASSES.CITIZEN(), res) > 0) {
/* 285 */         b.textL(UIMiniRaces.¤¤Desc);
/* 286 */         b.NL();
/*     */         
/* 288 */         if (this.li < TIME.currentSecond()) {
/* 289 */           this.li = 60 + (int)TIME.currentSecond();
/* 290 */           ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/* 291 */           int ei = RND.rInt(ee.length);
/* 292 */           for (int i = 0; i < ee.length; i++) {
/* 293 */             ENTITY e = ee[(ei + i) % ee.length];
/* 294 */             if (e instanceof Humanoid) {
/* 295 */               Humanoid a = (Humanoid)e;
/* 296 */               if (a.indu().player() && a.indu().clas() == HCLASSES.CITIZEN() && a.race() == res) {
/* 297 */                 res.bio().opinions((LIST)this.tmp, a);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 305 */         for (Str s : this.tmp) {
/* 306 */           if (s.length() > 0) {
/* 307 */             b.add((SPRITE)b.text().warnify().add('\'').add((CharSequence)s).add('\''));
/* 308 */             b.NL(4);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 313 */       super.hoverInfoGet(text); }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 318 */       Race res = (FACTIONS.player()).races.get(this.ri);
/*     */       
/* 320 */       GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y1(), body().y1() + 1);
/* 321 */       COLOR.WHITE05.render(r, (RECTANGLE)body(), -1);
/* 322 */       double dfrom = (STANDINGS.CITIZEN()).loyalty.getD(res);
/* 323 */       double dto = (STANDINGS.CITIZEN()).loyalty.getD(res);
/*     */ 
/*     */ 
/*     */       
/* 327 */       if (hoveredIs()) {
/* 328 */         COLOR.WHITE30.render(r, (RECTANGLE)body(), -3);
/* 329 */       } else if (POP.tot(HCLASSES.CITIZEN(), res) > 0) {
/* 330 */         GMeter.renderDelta(r, dfrom, dto, body().x1() + 1, body().x2() - 1, body().y1() + 2, body().y2() - 1);
/*     */       } else {
/* 332 */         GMeter.renderDelta(r, dfrom, dto, body().x1() + 1, body().x2() - 1, body().y1() + 2, body().y2() - 1, GMeter.C_GRAY);
/*     */       } 
/*     */       
/* 335 */       if (hoveredIs() && MButt.RIGHT.consumeClick()) {
/* 336 */         (VIEW.s()).ui.standing.open(res);
/*     */       }
/*     */       
/* 339 */       if (hoveredIs() && UIMiniRaces.clickI >= 0 && UIMiniRaces.clickI != this.ri) {
/*     */         
/* 341 */         COLOR.GREEN100.render(r, body().x1(), body().x2(), body().y1() - 1, body().y1() + 2);
/* 342 */         if (!MButt.LEFT.isDown()) {
/* 343 */           (FACTIONS.player()).races.order((FACTIONS.player()).races.get(UIMiniRaces.clickI), this.ri);
/* 344 */           UIMiniRaces.clickI = -1;
/*     */         } 
/*     */       } 
/*     */       
/* 348 */       super.render(r, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 353 */       if (MButt.LEFT.isDouble()) {
/* 354 */         Race res = (FACTIONS.player()).races.get(this.ri);
/* 355 */         int am = SETT.ENTRY().immi().wanted(res);
/* 356 */         if (am > 0)
/* 357 */           SETT.ENTRY().immi().admit(res, am); 
/*     */       } 
/* 359 */       UIMiniRaces.clickI = this.ri;
/*     */       
/* 361 */       return super.click();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ noble(int ri) {
/* 368 */     return (RENDEROBJ)new RaceUI(ri);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniRaces.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */