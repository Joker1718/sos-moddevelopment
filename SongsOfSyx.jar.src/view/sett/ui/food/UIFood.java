/*     */ package view.sett.ui.food;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.RoomProduction;
/*     */ import settlement.room.service.food.canteen.ROOM_CANTEEN;
/*     */ import settlement.room.service.food.eatery.ROOM_EATERY;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Queue;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ public class UIFood
/*     */   extends ISidePanel {
/*  46 */   private static CharSequence ¤¤expl = "The amount of days we can feed the population for. Note that this is a rough estimate. Many factors, such as trade, and production can affect this amount.";
/*     */   
/*     */   static {
/*  49 */     D.ts(UIFood.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public UIFood() {
/*  54 */     titleSet(Dic.¤¤Food);
/*     */ 
/*     */ 
/*     */     
/*  58 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  63 */             double am = 0.0D;
/*  64 */             for (ResG rr : RESOURCES.EDI().all()) {
/*  65 */               am += (SETT.ROOMS()).PROD.produced(rr.resource);
/*     */             }
/*     */             
/*  68 */             GFORMAT.f0(text, am);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  74 */             double am = 0.0D;
/*  75 */             for (ResG rr : RESOURCES.EDI().all()) {
/*  76 */               b.add((SPRITE)rr.resource.icon());
/*  77 */               b.textL(rr.resource.name);
/*  78 */               b.tab(7);
/*  79 */               double a = (SETT.ROOMS()).PROD.produced(rr.resource);
/*     */               
/*  81 */               b.add((SPRITE)GFORMAT.f0(b.text(), a));
/*  82 */               b.NL();
/*  83 */               am += a;
/*     */             } 
/*     */             
/*  86 */             b.NL(8);
/*     */             
/*  88 */             b.textLL(Dic.¤¤Total);
/*  89 */             b.tab(7);
/*     */             
/*  91 */             b.add((SPRITE)GFORMAT.f0(b.text(), am));
/*     */           }
/*  95 */         }).hv(Dic.¤¤ProductionRate));
/*     */     
/*  97 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 102 */             double needed = 0.0D;
/*     */             
/* 104 */             for (ResG res : RESOURCES.EDI().all()) {
/* 105 */               needed += (SETT.ROOMS()).PROD.consumed(res.resource);
/* 106 */               needed += SETT.MAINTENANCE().estimateGlobal(res.resource);
/*     */             } 
/* 108 */             for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 109 */               HCLASS c = (HCLASS)HCLASSES.ALL().get(ci);
/* 110 */               if (c.player) {
/* 111 */                 for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 112 */                   Race r = (Race)RACES.all().get(ri);
/* 113 */                   double n = (NEEDS.TYPES()).HUNGER.rate.get((BOOSTABLE_O)c.get(r)) * POP.physical(c, r) * (STATS.FOOD()).FOOD.decree().get(c, r);
/* 114 */                   needed += n;
/*     */                 } 
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 120 */             GFORMAT.f0(text, -needed);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 127 */             double needed = 0.0D;
/* 128 */             for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/*     */               
/* 130 */               HCLASS c = (HCLASS)HCLASSES.ALL().get(ci);
/* 131 */               if (c.player) {
/* 132 */                 for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 133 */                   Race r = (Race)RACES.all().get(ri);
/* 134 */                   double n = (NEEDS.TYPES()).HUNGER.rate.get((BOOSTABLE_O)c.get(r)) * POP.physical(c, r) * (STATS.FOOD()).FOOD.decree().get(c, r);
/* 135 */                   if (n > 0.0D) {
/* 136 */                     b.add((SPRITE)(r.appearance()).icon);
/* 137 */                     b.textL(c.names);
/*     */ 
/*     */                     
/* 140 */                     b.tab(7);
/* 141 */                     b.add((SPRITE)GFORMAT.f0(b.text(), -n));
/* 142 */                     b.NL();
/*     */                   } 
/* 144 */                   needed += n;
/*     */                 } 
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 151 */             b.sep();
/*     */             
/* 153 */             b.textLL(Dic.¤¤Total);
/* 154 */             b.tab(7);
/*     */             
/* 156 */             b.add((SPRITE)GFORMAT.f0(b.text(), -needed));
/*     */           }
/* 160 */         }).hv(Dic.¤¤ConsumptionRate));
/*     */     
/* 162 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 167 */             int a = 0;
/* 168 */             for (int ei = 0; ei < RESOURCES.EDI().all().size(); ei++) {
/* 169 */               ResG r = (ResG)RESOURCES.EDI().all().get(ei);
/* 170 */               a += (SETT.ROOMS()).STOCKPILE.tally().amountTotal(r.resource);
/*     */             } 
/*     */             int ri;
/* 173 */             for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 174 */               ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 175 */               a = (int)(a + e.totalFood());
/*     */             } 
/*     */             
/* 178 */             for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 179 */               ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 180 */               a = (int)(a + e.totalFood());
/*     */             } 
/*     */             
/* 183 */             GFORMAT.f0(text, a);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 191 */             int a = 0;
/* 192 */             for (int ei = 0; ei < RESOURCES.EDI().all().size(); ei++) {
/* 193 */               ResG r = (ResG)RESOURCES.EDI().all().get(ei);
/* 194 */               a += (SETT.ROOMS()).STOCKPILE.tally().amountTotal(r.resource);
/*     */             } 
/*     */             
/* 197 */             b.add((SETT.ROOMS()).STOCKPILE.icon.small);
/* 198 */             b.textL((SETT.ROOMS()).STOCKPILE.info.names);
/* 199 */             b.tab(7);
/* 200 */             b.add((SPRITE)GFORMAT.i(b.text(), a));
/* 201 */             b.NL();
/*     */             int ri;
/* 203 */             for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 204 */               ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 205 */               int am = (int)e.totalFood();
/* 206 */               a += am;
/*     */ 
/*     */               
/* 209 */               b.add(e.icon.small);
/* 210 */               b.textL(e.info.names);
/* 211 */               b.tab(7);
/* 212 */               b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 213 */               b.NL();
/*     */             } 
/*     */             
/* 216 */             for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 217 */               ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 218 */               int am = (int)e.totalFood();
/* 219 */               a += am;
/*     */ 
/*     */               
/* 222 */               b.add(e.icon.small);
/* 223 */               b.textL(e.info.names);
/* 224 */               b.tab(7);
/* 225 */               b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 226 */               b.NL();
/*     */             } 
/*     */             
/* 229 */             b.NL(8);
/*     */             
/* 231 */             b.textLL(Dic.¤¤Total);
/* 232 */             b.tab(7);
/*     */             
/* 234 */             b.add((SPRITE)GFORMAT.i(b.text(), a));
/*     */           }
/* 238 */         }).hv(Dic.¤¤Stored));
/*     */     
/* 240 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 245 */             GFORMAT.f(text, (STATS.FOOD()).FOOD_DAYS.data().getD(null) * (STATS.FOOD()).FOOD_DAYS.dataDivider());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 252 */             b.text(UIFood.¤¤expl);
/*     */           }
/* 256 */         }).hv(((STATS.FOOD()).FOOD_DAYS.info()).name));
/*     */     
/* 258 */     GStaples st = new GStaples(8)
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 262 */           int ii = 8 - stapleI - 1;
/* 263 */           box.title(((STATS.FOOD()).FOOD_DAYS.info()).name);
/*     */ 
/*     */           
/* 266 */           GText tt = box.text();
/* 267 */           DicTime.setDaysAgo((Str)tt, (ii * 4));
/* 268 */           box.textLL((CharSequence)tt);
/* 269 */           box.NL(4);
/*     */ 
/*     */ 
/*     */           
/* 273 */           box.textLL(((STATS.FOOD()).FOOD_DAYS.info()).name);
/* 274 */           box.tab(7);
/* 275 */           box.add((SPRITE)GFORMAT.f(box.text(), (STATS.FOOD()).FOOD_DAYS.data(null).getD(null, ii * 4) * (STATS.FOOD()).FOOD_DAYS.dataDivider()));
/* 276 */           box.NL();
/*     */ 
/*     */ 
/*     */           
/* 280 */           box.textLL(Dic.¤¤Population);
/* 281 */           box.tab(7);
/* 282 */           box.add((SPRITE)GFORMAT.i(box.text(), POP.physical(null, null)));
/* 283 */           box.NL();
/*     */ 
/*     */ 
/*     */           
/* 287 */           box.textLL(Dic.¤¤Stored);
/* 288 */           box.tab(7);
/* 289 */           int st = 0;
/* 290 */           for (ResG rr : RESOURCES.EDI().all()) {
/* 291 */             st += ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(rr.resource);
/*     */           }
/* 293 */           box.add((SPRITE)GFORMAT.i(box.text(), st));
/* 294 */           box.NL();
/*     */ 
/*     */           
/* 297 */           box.sep();
/*     */ 
/*     */           
/* 300 */           int net = 0;
/*     */           
/* 302 */           for (FResources.RTYPE t : FResources.RTYPE.all) {
/* 303 */             box.text(t.name);
/* 304 */             box.tab(7);
/* 305 */             int in = 0;
/* 306 */             int out = 0;
/* 307 */             for (ResG rr : RESOURCES.EDI().all()) {
/* 308 */               in += FACTIONS.player().res().in(t).history(rr.resource.tr()).get(ii);
/* 309 */               out += FACTIONS.player().res().out(t).history(rr.resource.tr()).get(ii);
/*     */             } 
/* 311 */             net += in;
/* 312 */             net -= out;
/* 313 */             box.add((SPRITE)GFORMAT.iIncr(box.text(), in));
/* 314 */             box.tab(9);
/* 315 */             box.add((SPRITE)GFORMAT.iIncr(box.text(), -out));
/* 316 */             box.NL();
/*     */           } 
/*     */           
/* 319 */           box.textL(Dic.¤¤Net);
/* 320 */           box.tab(7);
/* 321 */           box.add((SPRITE)GFORMAT.iIncr(box.text(), net));
/* 322 */           box.NL();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 332 */           int ii = 8 - stapleI - 1;
/* 333 */           return (STATS.FOOD()).FOOD_DAYS.data(null).getD(null, ii * 4) * (STATS.FOOD()).FOOD_DAYS.dataDivider();
/*     */         }
/*     */       };
/*     */     
/* 337 */     st.normalize(true);
/*     */     
/* 339 */     st.body().setWidth(400.0D).setHeight(80.0D);
/*     */     
/* 341 */     this.section.addRelBody(4, DIR.S, (RENDEROBJ)st);
/*     */ 
/*     */     
/* 344 */     Queue<ResG> all = new Queue(RESOURCES.EDI().all().size());
/*     */     
/* 346 */     for (ResG res : RESOURCES.EDI().all()) {
/* 347 */       all.push(res);
/*     */     }
/* 349 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 351 */     while (all.hasNext()) {
/*     */       
/* 353 */       GuiSection s = new GuiSection();
/*     */       
/* 355 */       for (int i = 0; i < 2 && all.hasNext(); i++)
/*     */       {
/* 357 */         s.addRightC(8, (RENDEROBJ)new RR((ResG)all.poll()));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 362 */       rows.add(s);
/*     */     } 
/*     */     
/* 365 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, HEIGHT - this.section.body().height() - 32)).view());
/*     */   }
/*     */ 
/*     */   
/*     */   private static class RR
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final ResG res;
/*     */     
/* 374 */     private final GText t = new GText((UI.FONT()).S, 8);
/*     */     
/*     */     RR(ResG res) {
/* 377 */       super(248, 60);
/* 378 */       this.res = res;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER ren, float ds, boolean isHovered) {
/* 383 */       GButt.ButtPanel.renderBG(ren, true, false, isHovered, (RECTANGLE)this.body);
/* 384 */       this.res.resource.icon().renderScaled(ren, this.body.x1() + 8, this.body.y1() + 6, 2);
/* 385 */       this.t.clear();
/*     */       
/* 387 */       int am = totStored();
/*     */       
/* 389 */       GFORMAT.i(this.t, am);
/* 390 */       this.t.adjustWidth();
/* 391 */       this.t.renderCY(ren, this.body.x1() + 120 - this.t.width(), this.body.cY());
/*     */       
/* 393 */       this.t.clear();
/*     */       
/* 395 */       GFORMAT.f0(this.t, (SETT.ROOMS()).PROD.produced(this.res.resource) - (SETT.ROOMS()).PROD.consumed(this.res.resource));
/* 396 */       this.t.adjustWidth();
/* 397 */       this.t.renderCY(ren, this.body.x2() - 8 - this.t.width(), this.body.cY());
/*     */       
/* 399 */       GButt.ButtPanel.renderFrame(ren, (RECTANGLE)this.body);
/*     */     }
/*     */     
/*     */     private int totStored() {
/* 403 */       int am = 0;
/* 404 */       am += (SETT.ROOMS()).STOCKPILE.tally().amountTotal(this.res.resource);
/*     */       int ri;
/* 406 */       for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 407 */         ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 408 */         am = (int)(am + e.amount(this.res));
/*     */       } 
/*     */       
/* 411 */       for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 412 */         ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 413 */         am = (int)(am + e.amount(this.res));
/*     */       } 
/* 415 */       return am;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 420 */       GBox b = (GBox)text;
/* 421 */       b.title(this.res.resource.names);
/*     */       
/* 423 */       b.textLL(Dic.¤¤Stored);
/* 424 */       b.NL();
/* 425 */       b.add((SETT.ROOMS()).STOCKPILE.icon.small);
/* 426 */       b.textL((SETT.ROOMS()).STOCKPILE.info.names);
/* 427 */       b.tab(7);
/* 428 */       b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).STOCKPILE.tally().amountTotal(this.res.resource)));
/* 429 */       b.NL();
/*     */       int ri;
/* 431 */       for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 432 */         ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 433 */         b.NL();
/* 434 */         b.add(e.icon.small);
/* 435 */         b.textL(e.info.names);
/* 436 */         b.tab(7);
/* 437 */         b.add((SPRITE)GFORMAT.i(b.text(), e.amount(this.res)));
/* 438 */         b.NL();
/*     */       } 
/*     */       
/* 441 */       for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 442 */         ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 443 */         b.NL();
/* 444 */         b.add(e.icon.small);
/* 445 */         b.textL(e.info.names);
/* 446 */         b.tab(7);
/* 447 */         b.add((SPRITE)GFORMAT.i(b.text(), e.amount(this.res)));
/* 448 */         b.NL();
/*     */       } 
/*     */       
/* 451 */       b.NL(4);
/*     */       
/* 453 */       b.textL(Dic.¤¤Total);
/* 454 */       b.tab(7);
/* 455 */       b.add((SPRITE)GFORMAT.i(b.text(), totStored()));
/*     */       
/* 457 */       b.sep();
/*     */       
/* 459 */       b.textLL(((STATS.FOOD()).FOOD_PREFFERENCE.info()).name);
/* 460 */       b.NL();
/*     */       
/* 462 */       for (Race r : RACES.all()) {
/* 463 */         if ((r.pref()).foodMask.has(this.res.resource)) {
/* 464 */           b.add((SPRITE)(r.appearance()).icon);
/* 465 */           b.textL(r.info.names);
/* 466 */           b.NL();
/*     */         } 
/*     */       } 
/*     */       
/* 470 */       b.sep();
/*     */       
/* 472 */       b.textLL(Dic.¤¤Production);
/* 473 */       b.NL();
/*     */       
/* 475 */       for (RoomProduction.Source ii : (SETT.ROOMS()).PROD.producers(this.res.resource)) {
/* 476 */         b.add(ii.icon());
/* 477 */         b.textLL(ii.name());
/* 478 */         if (ii.thereAreMultipleIns() != null) {
/* 479 */           for (IndustryResource iii : ii.thereAreMultipleIns().ins()) {
/* 480 */             b.add((iii.resource.icon()).small);
/*     */           }
/*     */         }
/*     */         
/* 484 */         b.tab(7);
/* 485 */         b.add((SPRITE)GFORMAT.f0(b.text(), ii.am()));
/* 486 */         b.NL();
/*     */       } 
/*     */       
/* 489 */       b.NL(8);
/* 490 */       b.textLL(Dic.¤¤Consumed);
/* 491 */       b.NL();
/*     */       
/* 493 */       for (RoomProduction.Source ii : (SETT.ROOMS()).PROD.consumers(this.res.resource)) {
/* 494 */         b.add(ii.icon());
/* 495 */         b.textLL(ii.name());
/* 496 */         if (ii.thereAreMultipleIns() != null) {
/* 497 */           for (IndustryResource iii : ii.thereAreMultipleIns().ins()) {
/* 498 */             b.add((iii.resource.icon()).small);
/*     */           }
/*     */         }
/*     */         
/* 502 */         b.tab(7);
/* 503 */         b.add((SPRITE)GFORMAT.f0(b.text(), -ii.am()));
/* 504 */         b.NL();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\food\UIFood.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */