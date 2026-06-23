/*     */ package init.resources;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATH;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.RoomProduction;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RESOURCE
/*     */   extends INFO
/*     */   implements MAPPED
/*     */ {
/*     */   public final String key;
/*     */   private final byte index;
/*     */   private final double degradeSpeed;
/*     */   private final Sprite sprite;
/*     */   private final Icon icon;
/*     */   private final TILE_SHEET debris;
/*     */   private final COLOR tint;
/*     */   private final COLOR miniC;
/*     */   public final int category;
/*     */   final long bitL1;
/*     */   final long bitL2;
/*     */   public final RBIT bit;
/*     */   public final double priceCapDef;
/*     */   public final double priceMulDef;
/*  72 */   public CharSequence specialHelpText = null;
/*     */   
/*     */   RESOURCE(LISTE<RESOURCE> all, String key, PATH gData, PATH gText, PATH gSprite, PATH gDebris, KeyMap<Sprite> spriteMap, KeyMap<TILE_SHEET> debrisMap) throws IOException {
/*  75 */     super(new Json(gText.gets(key)));
/*  76 */     Json data = new Json(gData.gets(key));
/*  77 */     this.key = key;
/*  78 */     this.index = (byte)all.add(this);
/*     */     
/*  80 */     if (this.index < 64) {
/*  81 */       this.bitL1 = 1L << this.index;
/*  82 */       this.bitL2 = 0L;
/*     */     } else {
/*     */       
/*  85 */       this.bitL1 = 0L;
/*  86 */       this.bitL2 = 1L << this.index - 64;
/*     */     } 
/*  88 */     this.bit = new RBIT(this.bitL1, this.bitL2);
/*     */     
/*  90 */     this.degradeSpeed = data.d("DEGRADE_RATE", 0.0D, 1.0D);
/*  91 */     this.tint = (COLOR)new ColorImp(data);
/*  92 */     this.miniC = (COLOR)new ColorImp(data, "MINIMAP_COLOR");
/*  93 */     this.category = data.i("CATEGORY_DEFAULT", 0, 3);
/*  94 */     this.icon = SPRITES.icons().get(data);
/*     */     
/*  96 */     this.priceCapDef = data.dTry("PRICE_CAP", 0.0D, 1.0D, 1.0D);
/*  97 */     this.priceMulDef = data.dTry("PRICE_MUL", 0.0D, 100.0D, 1.0D);
/*  98 */     String vSprite = data.value("SPRITE");
/*  99 */     if (!spriteMap.containsKey(vSprite)) {
/* 100 */       spriteMap.put(vSprite, new Sprite(gSprite.get(vSprite)));
/*     */     }
/* 102 */     this.sprite = (Sprite)spriteMap.get(vSprite);
/*     */     
/* 104 */     String vDebris = data.value("SPRITE_DEBRIS");
/* 105 */     if (!debrisMap.containsKey(vDebris)) {
/* 106 */       TILE_SHEET s = (new ComposerThings.ITileSheet(gDebris.get(vDebris), 716, 28)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 110 */             s.singles.init(0, 0, 1, 1, 16, 1, (ComposerDests.Dest)d.s16);
/* 111 */             s.singles.setVar(0).paste(1, true);
/* 112 */             return d.s16.saveGame();
/*     */           }
/* 114 */         }).get();
/* 115 */       debrisMap.put(vDebris, s);
/*     */     } 
/* 117 */     this.debris = (TILE_SHEET)debrisMap.get(vDebris);
/*     */   }
/*     */   public static final int renderMax = 36;
/*     */   
/*     */   public double degradeSpeed() {
/* 122 */     return this.degradeSpeed;
/*     */   }
/*     */   
/*     */   public final byte bIndex() {
/* 126 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 131 */     return this.index;
/*     */   }
/*     */   
/*     */   public Icon icon() {
/* 135 */     return this.icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 140 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderLaying(SPRITE_RENDERER r, int x, int y, int random, double amount) {
/* 147 */     this.tint.bind();
/*     */     
/* 149 */     if (amount > 36.0D) {
/* 150 */       amount = 36.0D;
/*     */     }
/* 152 */     if (amount >= 16.0D) {
/* 153 */       amount -= 16.0D;
/* 154 */       int ra = random & 0x3;
/* 155 */       random >>= 2;
/* 156 */       random &= Integer.MAX_VALUE;
/* 157 */       random |= ra << 30;
/* 158 */       this.sprite.lay.render(r, (ra & 0x3) + 12, x, y);
/*     */     } 
/*     */     
/* 161 */     if (amount >= 9.0D) {
/* 162 */       amount -= 9.0D;
/* 163 */       int ra = random & 0x3;
/* 164 */       random >>= 2;
/* 165 */       random &= Integer.MAX_VALUE;
/* 166 */       random |= ra << 30;
/* 167 */       int d = -1 + ra;
/* 168 */       this.sprite.lay.render(r, (ra & 0x3) + 8, x + d, y + d);
/*     */     } 
/*     */     
/* 171 */     while (amount >= 4.0D) {
/* 172 */       amount -= 4.0D;
/* 173 */       int ra = random & 0x7;
/* 174 */       random >>= 3;
/* 175 */       random &= Integer.MAX_VALUE;
/* 176 */       random |= ra << 29;
/* 177 */       int d = -4 + ra;
/* 178 */       this.sprite.lay.render(r, (ra & 0x3) + 4, x + d, y + d);
/*     */     } 
/*     */     
/* 181 */     while (amount > 0.0D) {
/* 182 */       amount--;
/* 183 */       int ra = random & 0x7;
/* 184 */       random >>= 3;
/* 185 */       random &= Integer.MAX_VALUE;
/* 186 */       random |= ra << 29;
/* 187 */       int d = -4 + ra;
/* 188 */       this.sprite.lay.render(r, ra & 0x3, x + d, y + d);
/*     */     } 
/*     */     
/* 191 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderLayingRel(SPRITE_RENDERER r, int x, int y, int random, double amount) {
/* 197 */     amount *= 36.0D;
/* 198 */     renderLaying(r, x, y, random, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderOne(SPRITE_RENDERER r, int x, int y, int random) {
/* 205 */     this.tint.bind();
/* 206 */     this.sprite.lay.render(r, random & 0x3, x, y);
/* 207 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderOneC(SPRITE_RENDERER r, int x, int y, int random) {
/* 213 */     this.tint.bind();
/* 214 */     this.sprite.lay.renderC(r, random & 0x3, x, y);
/* 215 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderCarried(SPRITE_RENDERER r, int cx, int cy, DIR d) {
/* 220 */     this.tint.bind();
/* 221 */     int dd = this.sprite.carry.size() / 2;
/* 222 */     cx -= dd;
/* 223 */     cy -= dd;
/*     */     
/* 225 */     int i = d.id();
/* 226 */     cx += 10 * d.x();
/* 227 */     cy += 10 * d.y();
/* 228 */     this.sprite.carry.render(r, i, cx, cy);
/* 229 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public void renderDebris(SPRITE_RENDERER r, ShadowBatch s, int x, int y, int ran, int amount) {
/* 233 */     int start = 0;
/*     */     
/* 235 */     ran &= 0x1F;
/*     */     
/* 237 */     amount = CLAMP.i(amount, 0, 5);
/*     */     
/* 239 */     for (int i = 0; i < amount; i++) {
/* 240 */       x += -4 * (ran & 0x3) + 4 * (ran >> 2 & 0x3);
/* 241 */       y += -4 * (ran >> 4 & 0x3) + 4 * (ran >> 6 & 0x3);
/*     */       
/* 243 */       this.debris.render(r, start + (ran & 0x1F), x, y);
/* 244 */       ran >>= 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniC() {
/* 250 */     return this.miniC;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 255 */     return this.key + "[" + this.key + "]";
/*     */   }
/*     */   
/*     */   public TRADABLE tr() {
/* 259 */     return (TRADABLE)TR.get(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 264 */     GBox b = (GBox)box;
/*     */     
/* 266 */     b.title(this.name);
/* 267 */     b.text(this.desc);
/* 268 */     b.NL(8);
/* 269 */     b.add((SPRITE)(BOOSTABLES.CIVICS()).SPOILAGE.icon);
/* 270 */     b.textLL(¤¤DecayRate);
/* 271 */     double d = degradeSpeed();
/* 272 */     b.tab(6);
/* 273 */     b.add((SPRITE)GFORMAT.perc(b.text(), -d, 2));
/* 274 */     b.add((SPRITE)b.text().add('/').s().add(TIME.years().cycleName()));
/* 275 */     b.NL();
/* 276 */     d /= (BOOSTABLES.CIVICS()).SPOILAGE.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null));
/* 277 */     b.tab(6);
/* 278 */     b.add((SPRITE)GFORMAT.perc(b.text(), -0.5D * d, 2));
/* 279 */     b.text(Dic.¤¤Stored);
/*     */ 
/*     */     
/* 282 */     b.NL(8);
/* 283 */     if (RESOURCES.EDI().is(this)) {
/* 284 */       b.textL(Dic.¤¤Edible);
/*     */     }
/* 286 */     b.NL();
/* 287 */     if (RESOURCES.DRINKS().is(this)) {
/* 288 */       b.textL(Dic.¤¤Drinkable);
/*     */     }
/*     */     
/* 291 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/* 295 */   private static CharSequence ¤¤Exists = "¤Resources exist scattered on the map that are not yet stored and counted: ";
/* 296 */   private static CharSequence ¤¤Production = "¤Produced per day (estimation):";
/* 297 */   private static CharSequence ¤¤DecayRate = "¤Decay-Rate";
/*     */   static {
/* 299 */     D.ts(RESOURCE.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverDetailed(GUI_BOX text) {
/* 304 */     hover(text);
/* 305 */     RESOURCE res = this;
/*     */     
/* 307 */     int a = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(res);
/* 308 */     int c = ((SETT.ROOMS()).STOCKPILE.tally()).space.total(res);
/* 309 */     GBox b = (GBox)text;
/*     */     
/* 311 */     b.textLL(Dic.¤¤buyPrice);
/* 312 */     b.tab(6);
/* 313 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesBuy.get((MAPPED)TR.get(this))));
/* 314 */     b.tab(8);
/* 315 */     COLOR col = (GCOLOR.UI()).BAD.hovered;
/* 316 */     Icons.S.IconS iconS2 = (UI.icons()).s.chevron(DIR.W);
/*     */     
/* 318 */     double d = SETT.TRADE().seller(tr()).tradeValue();
/*     */     
/* 320 */     int am = (int)Math.round(d * 5.0D);
/* 321 */     if (am > 8)
/* 322 */       am = 8; 
/* 323 */     col.bind(); int i;
/* 324 */     for (i = 0; i < am; i++) {
/* 325 */       b.add((SPRITE)iconS2, col);
/* 326 */       b.rewind(8);
/*     */     } 
/* 328 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 332 */     b.NL();
/* 333 */     b.textLL(Dic.¤¤sellPrice);
/* 334 */     b.tab(6);
/* 335 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesSell.get((MAPPED)TR.get(this))));
/* 336 */     b.tab(8);
/* 337 */     col = (GCOLOR.UI()).GOOD.hovered;
/* 338 */     Icons.S.IconS iconS1 = (UI.icons()).s.chevron(DIR.E);
/*     */     
/* 340 */     d = SETT.TRADE().buyer(tr()).tradeValue();
/* 341 */     b.rewind(8);
/* 342 */     am = (int)Math.round(d * 5.0D);
/* 343 */     if (am > 8)
/* 344 */       am = 8; 
/* 345 */     col.bind();
/* 346 */     for (i = 0; i < am; i++) {
/* 347 */       b.add((SPRITE)iconS1, col);
/* 348 */       b.rewind(8);
/*     */     } 
/* 350 */     b.NL();
/*     */     
/* 352 */     b.sep();
/* 353 */     b.textLL(¤¤Production);
/* 354 */     b.NL();
/*     */     
/* 356 */     double tot = 0.0D;
/*     */     int si;
/* 358 */     for (si = 0; si < (SETT.ROOMS()).PROD.producers(res).size(); si++) {
/* 359 */       RoomProduction.Source rr = (RoomProduction.Source)(SETT.ROOMS()).PROD.producers(res).get(si);
/* 360 */       if (rr.am() != 0.0D) {
/*     */         
/* 362 */         tot += rr.am();
/* 363 */         b.add(rr.icon());
/* 364 */         b.textL(rr.name());
/* 365 */         if (rr.thereAreMultipleIns() != null)
/* 366 */           for (IndustryResource ii : rr.thereAreMultipleIns().ins()) {
/* 367 */             b.add((ii.resource.icon()).small);
/*     */           } 
/* 369 */         b.tab(7);
/* 370 */         b.add((SPRITE)GFORMAT.f0(b.text(), rr.am()));
/* 371 */         b.NL();
/*     */       } 
/* 373 */     }  for (si = 0; si < (SETT.ROOMS()).PROD.consumers(res).size(); si++) {
/* 374 */       RoomProduction.Source rr = (RoomProduction.Source)(SETT.ROOMS()).PROD.consumers(res).get(si);
/* 375 */       if (rr.am() != 0.0D) {
/*     */         
/* 377 */         tot -= rr.am();
/* 378 */         b.add(rr.icon());
/* 379 */         b.textL(rr.name());
/* 380 */         if (rr.thereAreMultipleIns() != null)
/* 381 */           for (IndustryResource ii : rr.thereAreMultipleIns().ins()) {
/* 382 */             b.add((ii.resource.icon()).small);
/*     */           } 
/* 384 */         b.tab(7);
/* 385 */         b.add((SPRITE)GFORMAT.f0(b.text(), -rr.am()));
/* 386 */         b.NL();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 391 */     b.NL(4);
/* 392 */     b.textLL(Dic.¤¤Net);
/* 393 */     b.add((SPRITE)GFORMAT.f0(b.text(), tot));
/*     */     
/* 395 */     b.sep();
/* 396 */     b.textLL(Dic.¤¤Stored);
/* 397 */     b.NL();
/* 398 */     b.add((SETT.ROOMS()).STOCKPILE.icon.small);
/* 399 */     b.textL((SETT.ROOMS()).STOCKPILE.info.names);
/* 400 */     b.tab(7);
/* 401 */     b.add((SPRITE)GFORMAT.iofk(b.text(), a, c));
/* 402 */     b.NL();
/*     */     
/* 404 */     b.add((SETT.ROOMS()).HAULER.icon.small);
/* 405 */     b.textL((SETT.ROOMS()).HAULER.info.names);
/* 406 */     b.tab(7);
/* 407 */     b.add((SPRITE)GFORMAT.iofk(b.text(), (SETT.ROOMS()).HAULER.tally.amount.total(res), (SETT.ROOMS()).HAULER.tally.space.total(res)));
/* 408 */     b.NL();
/*     */     
/* 410 */     b.add((SETT.ROOMS()).IMPORT.icon.small);
/* 411 */     b.textL((SETT.ROOMS()).IMPORT.info.names);
/* 412 */     b.tab(7);
/* 413 */     b.add((SPRITE)GFORMAT.iofk(b.text(), (SETT.ROOMS()).IMPORT.tally.amount.get(res), (SETT.ROOMS()).IMPORT.tally.capacity.get(res)));
/* 414 */     b.NL();
/*     */     
/* 416 */     b.add((SETT.ROOMS()).EXPORT.icon.small);
/* 417 */     b.textL((SETT.ROOMS()).EXPORT.info.names);
/* 418 */     b.tab(7);
/* 419 */     b.add((SPRITE)GFORMAT.iofk(b.text(), (SETT.ROOMS()).EXPORT.tally.amount.get(res), (SETT.ROOMS()).EXPORT.tally.capacity.get(res)));
/* 420 */     b.NL(8);
/*     */     
/* 422 */     b.add((SETT.ROOMS()).STATION.icon.small);
/* 423 */     b.textL((SETT.ROOMS()).STATION.info.names);
/* 424 */     b.tab(7);
/* 425 */     b.add((SPRITE)GFORMAT.iofk(b.text(), ((SETT.ROOMS()).STATION.tally(res).stored() + (SETT.ROOMS()).STATION.tally(res).incoming()), (SETT.ROOMS()).STATION.tally(res).space()));
/* 426 */     b.NL(8);
/*     */     
/* 428 */     Str.TMP.clear().add(¤¤Exists);
/* 429 */     Str.TMP.s().add((SETT.PATH()).finders.resource.scattered.has(res));
/* 430 */     b.text((CharSequence)Str.TMP);
/*     */   }
/*     */   
/*     */   private int sellable() {
/* 434 */     int stocked = ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(this);
/* 435 */     stocked += (SETT.ROOMS()).EXPORT.tally.amount.get(this);
/* 436 */     stocked += (SETT.ROOMS()).HAULER.tally.amountReservable.get(this);
/* 437 */     return stocked;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void remove(STOCKPILE.StockpileImp stock, FResources.RTYPE record) {
/* 442 */     double[] res = new double[RESOURCES.ALL().size()];
/* 443 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 444 */       double d = stock.get(r) / (1.0D + r.sellable());
/* 445 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 446 */       res[r.index()] = d;
/*     */     } 
/*     */     
/* 449 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 450 */       Room r = (Room)(SETT.ROOMS()).map.get(c);
/* 451 */       if (r == null)
/*     */         continue; 
/* 453 */       RESOURCE_TILE cr = cr(r, c.x(), c.y());
/* 454 */       if (cr != null && cr.resource() != null && stock.get(cr.resource()) > 0 && res[cr.resource().index()] > 0.0D) {
/* 455 */         int a = (int)Math.ceil(res[cr.resource().index()] * cr.reservable());
/* 456 */         stock.inc(cr.resource(), -a);
/* 457 */         for (int i = 0; i < a; i++) {
/* 458 */           cr.findableReserve();
/* 459 */           cr.resourcePickup();
/*     */         } 
/* 461 */         FACTIONS.player().res().inc((TRADABLE)TR.get(cr.resource()), record, -a);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static STOCKPILE.StockpileImp remove(double am, RBIT mask, FResources.RTYPE record) {
/* 467 */     STOCKPILE.StockpileImp imp = new STOCKPILE.StockpileImp();
/*     */     
/* 469 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 470 */       Room r = (SETT.ROOMS()).map.get(c.x(), c.y());
/* 471 */       if (r == null)
/*     */         continue; 
/* 473 */       RESOURCE_TILE cr = cr(r, c.x(), c.y());
/* 474 */       if (cr != null && cr.resource() != null && mask.has(cr.resource())) {
/* 475 */         int a = (int)Math.ceil(am * cr.reservable());
/* 476 */         for (int i = 0; i < a; i++) {
/* 477 */           cr.findableReserve();
/* 478 */           cr.resourcePickup();
/*     */         } 
/* 480 */         FACTIONS.player().res().inc((TRADABLE)TR.get(cr.resource()), record, -a);
/* 481 */         imp.add(cr.resource(), a);
/*     */       } 
/*     */     } 
/* 484 */     return imp;
/*     */   }
/*     */   
/*     */   private static RESOURCE_TILE cr(Room in, int tx, int ty) {
/* 488 */     RESOURCE_TILE cr = in.resourceTile(tx, ty);
/* 489 */     if (cr == null && in.storage(tx, ty) instanceof RESOURCE_TILE)
/* 490 */       cr = (RESOURCE_TILE)in.storage(tx, ty); 
/* 491 */     return cr;
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(int total, FResources.RTYPE record) {
/* 496 */     int am = total;
/*     */     
/* 498 */     total = remove((RoomBlueprintIns<?>)(SETT.ROOMS()).STOCKPILE, total, record);
/* 499 */     if (total > 0)
/* 500 */       total = remove((RoomBlueprintIns<?>)(SETT.ROOMS()).HAULER, total, record); 
/* 501 */     if (total > 0)
/* 502 */       total = remove((RoomBlueprintIns<?>)(SETT.ROOMS()).EXPORT, total, record); 
/* 503 */     if (total > 0) {
/* 504 */       total = remove((RoomBlueprintIns<?>)(SETT.ROOMS()).IMPORT, total, record);
/*     */     }
/* 506 */     return am - total;
/*     */   }
/*     */   
/*     */   private int remove(RoomBlueprintIns<?> b, int total, FResources.RTYPE record) {
/* 510 */     for (int ini = 0; ini < b.instancesSize(); ini++) {
/* 511 */       RoomInstance in = b.getInstance(ini);
/* 512 */       for (COORDINATE c : in.body()) {
/* 513 */         if (in.is(c)) {
/* 514 */           RESOURCE_TILE cr = cr((Room)in, c.x(), c.y());
/* 515 */           if (cr != null && cr.resource() == this) {
/* 516 */             int a = Math.min(cr.reservable(), total);
/* 517 */             for (int i = 0; i < a; i++) {
/* 518 */               cr.findableReserve();
/* 519 */               cr.resourcePickup();
/*     */             } 
/* 521 */             if (record != null)
/* 522 */               FACTIONS.player().res().inc((TRADABLE)TR.get(cr.resource()), record, -a); 
/* 523 */             total -= a;
/* 524 */             if (total <= 0) {
/* 525 */               return 0;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 532 */     return total;
/*     */   }
/*     */   
/*     */   public int owned() {
/* 536 */     int stocked = ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(this);
/* 537 */     stocked += (SETT.ROOMS()).EXPORT.tally.amount.get(this);
/* 538 */     stocked += (SETT.ROOMS()).IMPORT.tally.amount.get(this);
/* 539 */     stocked += (SETT.ROOMS()).HAULER.tally.amountReservable.get(this);
/* 540 */     stocked += (SETT.ROOMS()).STATION.tally(this).stored() + (SETT.ROOMS()).STATION.tally(this).incoming();
/* 541 */     stocked -= FACTIONS.player().seller(tr()).promised().get(null);
/* 542 */     return stocked;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\RESOURCE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */