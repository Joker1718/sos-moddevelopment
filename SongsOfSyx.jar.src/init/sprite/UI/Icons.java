/*     */ package init.sprite.UI;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PathParser;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Icons
/*     */ {
/*  22 */   public final M m = new M();
/*  23 */   public final S s = new S();
/*  24 */   public final L l = new L();
/*  25 */   private KeyMap<IconMaker> makers = new KeyMap(); private final TextureCoords tfg; private final TextureCoords tbg;
/*     */   
/*  27 */   Icons() throws IOException { this.makers.put("16", this.s);
/*  28 */     this.makers.put("24", this.m);
/*  29 */     this.makers.put("32", this.l);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     this.tfg = new TextureCoords();
/*  48 */     this.tbg = new TextureCoords(); } public Icon get(Json j) throws IOException { return get(j, "ICON"); }
/*     */   public Icon get(Json j, Icon fallback) throws IOException { if (!j.has("ICON"))
/*     */       return fallback; 
/*     */     return get(j, "ICON"); }
/*  52 */   public Icon get(Json json, String key) throws IOException { if (json.jsonsIs(key)) {
/*  53 */       final ArrayListGrower<SPRITE> sps = new ArrayListGrower();
/*  54 */       int size = 0; byte b; int i;
/*     */       Json[] arrayOfJson;
/*  56 */       for (i = (arrayOfJson = json.jsons(key, 1)).length, b = 0; b < i; ) { Json j = arrayOfJson[b];
/*  57 */         SPRITE s = get(j.value("BG"), j, "BG");
/*  58 */         sps.add(s);
/*  59 */         size = Math.max(size, ((SPRITE)sps.last()).width());
/*     */         b++; }
/*     */       
/*  62 */       SPRITE.Imp imp = new SPRITE.Imp(size)
/*     */         {
/*     */ 
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  69 */             for (int i = 0; i < sps.size(); i++) {
/*  70 */               SPRITE ic = (SPRITE)sps.get(i);
/*  71 */               int d = X2 - X1 - (X2 - X1) * ic.width() / width();
/*  72 */               d /= 2;
/*     */               
/*  74 */               OPACITY.O66.bind();
/*  75 */               COLOR.BLACK.bind();
/*  76 */               ic.render(r, X1 + d + 3, X2 - d + 3, Y1 + d + 3, Y2 - d + 3);
/*  77 */               COLOR.unbind();
/*  78 */               OPACITY.unbind();
/*  79 */               ic.render(r, X1 + d, X2 - d, Y1 + d, Y2 - d);
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*  86 */       return new Icon((SPRITE)imp);
/*     */     } 
/*  88 */     if (json.jsonIs(key))
/*     */     {
/*  90 */       return getJ(json.json(key));
/*     */     }
/*     */ 
/*     */     
/*  94 */     String relPath = json.value(key);
/*  95 */     return get(relPath, json, key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Icon getJ(Json json) throws IOException {
/* 102 */     final int scale = json.i("SCALE", 1, 8, 1);
/* 103 */     final SPRITE bg = get(json.value("BG"), json, "BG").scaled(scale);
/* 104 */     COLOR c = json.has("COLOR") ? (COLOR)new ColorImp(json, "COLOR") : COLOR.WHITE100;
/* 105 */     if (!json.has("FG")) {
/* 106 */       return new Icon(bg.createColored(c));
/*     */     }
/* 108 */     final SPRITE fg = get(json.value("FG"), json, "FG").scaled(scale);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     final int offX = json.i("OFFX", -100, 100, 0);
/* 115 */     final int offY = json.i("OFFY", -100, 100, 0);
/* 116 */     final int shadow = json.i("SHADOW", -100, 100, 0);
/*     */     
/* 118 */     final SPRITE biggest = (bg.width() >= fg.width()) ? bg : fg;
/* 119 */     final SPRITE smallest = (bg == biggest) ? fg : bg;
/*     */     
/* 121 */     SPRITE.Imp imp = new SPRITE.Imp(biggest.width())
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 126 */           double dx = (X2 - X1) / width();
/* 127 */           double dy = (Y2 - Y1) / height();
/*     */           
/* 129 */           int cx = X1 + (X2 - X1) / 2;
/* 130 */           int cy = Y1 + (Y2 - Y1) / 2;
/*     */           
/* 132 */           int ox = (int)(offX * dx);
/* 133 */           int oy = (int)(offY * dy);
/*     */           
/* 135 */           boolean bind = true;
/* 136 */           COLOR c = CORE.renderer().colorGet();
/* 137 */           if (c.red() == Byte.MAX_VALUE && c.green() == Byte.MAX_VALUE && c.blue() == Byte.MAX_VALUE) {
/* 138 */             bind = false;
/*     */           }
/*     */           
/* 141 */           if (bg == biggest) {
/* 142 */             render(r, bg, dx, dy, cx, cy);
/*     */             
/* 144 */             if (bind)
/* 145 */               c.bind(); 
/* 146 */             if (shadow != 0) {
/* 147 */               OPACITY op = CORE.renderer().opacity();
/* 148 */               COLOR.BLACK.bind();
/* 149 */               OPACITY.O75.bind();
/* 150 */               render(r, fg, dx, dy, (int)((cx + ox) + dx * scale), (int)((cy + oy) + dy * scale));
/* 151 */               op.bind();
/* 152 */               c.bind();
/*     */             } 
/*     */             
/* 155 */             render(r, fg, dx, dy, cx + ox, cy + oy);
/*     */           } else {
/*     */             
/* 158 */             render(r, bg, dx, dy, cx + ox, cy + oy);
/*     */             
/* 160 */             if (bind)
/* 161 */               c.bind(); 
/* 162 */             if (shadow != 0) {
/* 163 */               OPACITY op = CORE.renderer().opacity();
/* 164 */               COLOR.BLACK.bind();
/* 165 */               OPACITY.O75.bind();
/* 166 */               render(r, fg, dx, dy, (int)(cx + dx * scale), (int)(cy + dy * scale));
/* 167 */               op.bind();
/* 168 */               c.bind();
/*     */             } 
/*     */             
/* 171 */             render(r, fg, dx, dy, cx, cy);
/*     */           } 
/*     */ 
/*     */           
/* 175 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private void render(SPRITE_RENDERER r, SPRITE icon, double dx, double dy, int CX, int CY) {
/* 182 */           int w = (int)(icon.width() * dx);
/* 183 */           int h = (int)(icon.height() * dy);
/*     */           
/* 185 */           int x1 = CX - w / 2;
/* 186 */           int y1 = CY - h / 2;
/* 187 */           int x2 = x1 + w;
/* 188 */           int y2 = y1 + h;
/*     */           
/* 190 */           icon.render(r, x1, x2, y1, y2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void renderShadow(double dx, double dy, int X1, int Y1) {
/* 196 */           if (shadow == 0) {
/*     */             return;
/*     */           }
/* 199 */           if (!(bg instanceof Icon.IconSheet)) {
/*     */             return;
/*     */           }
/* 202 */           if (!(fg instanceof Icon.IconSheet)) {
/*     */             return;
/*     */           }
/*     */ 
/*     */           
/* 207 */           Icons.this.tbg.get(biggest.texture());
/* 208 */           Icons.this.tfg.get(smallest.texture());
/*     */           
/* 210 */           int sx = shadow + (Icons.this.tbg.width() - Icons.this.tfg.width()) / 2 + offX;
/* 211 */           int sy = shadow + (Icons.this.tbg.height() - Icons.this.tfg.height()) / 2 + offY;
/*     */           
/* 213 */           int tx1 = sx;
/* 214 */           int ty1 = sy;
/* 215 */           if (tx1 >= biggest.width() || ty1 >= biggest.height()) {
/*     */             return;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 221 */           if (tx1 < 0) {
/* 222 */             tx1 = 0;
/*     */           }
/*     */           
/* 225 */           if (ty1 < 0) {
/* 226 */             ty1 = 0;
/*     */           }
/*     */           
/* 229 */           int wi = smallest.width();
/* 230 */           int hi = smallest.height();
/*     */           
/* 232 */           if (tx1 + wi > biggest.width()) {
/* 233 */             wi = bg.width() - tx1;
/*     */           }
/*     */           
/* 236 */           if (ty1 + hi > biggest.height()) {
/* 237 */             hi = bg.height() - ty1;
/*     */           }
/*     */           
/* 240 */           if (wi < 0 || hi < 0) {
/*     */             return;
/*     */           }
/*     */           
/* 244 */           Icons.this.tbg.x1 = (short)(Icons.this.tbg.x1 + tx1);
/* 245 */           Icons.this.tbg.y1 = (short)(Icons.this.tbg.y1 + ty1);
/* 246 */           Icons.this.tbg.x2 = (short)(Icons.this.tbg.x1 + wi);
/* 247 */           Icons.this.tbg.y2 = (short)(Icons.this.tbg.y1 + hi);
/*     */ 
/*     */           
/* 250 */           Icons.this.tfg.x1 = (short)(Icons.this.tfg.x1 - Math.max(-sx, 0));
/* 251 */           Icons.this.tfg.x2 = (short)(Icons.this.tfg.x1 + wi);
/* 252 */           Icons.this.tfg.y1 = (short)(Icons.this.tfg.y1 + Math.max(-sy, 0));
/* 253 */           Icons.this.tfg.y2 = (short)(Icons.this.tfg.y1 + hi);
/*     */           
/* 255 */           int x1 = X1 + (int)(tx1 * dx);
/* 256 */           int x2 = X1 + (int)((tx1 + wi) * dx);
/*     */           
/* 258 */           int y1 = Y1 + (int)(ty1 * dy);
/* 259 */           int y2 = Y1 + (int)((ty1 + wi) * dy);
/*     */           
/* 261 */           COLOR.WHITE30.bind();
/*     */           
/* 263 */           if (bg == biggest) {
/* 264 */             CORE.renderer().renderTextured(x1, x2, y1, y2, Icons.this.tbg, Icons.this.tfg);
/*     */           } else {
/* 266 */             CORE.renderer().renderTextured(x1, x2, y1, y2, Icons.this.tfg, Icons.this.tbg);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 271 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */     
/* 275 */     return new Icon((SPRITE)imp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Icon get(String relPath, Json j, String key) throws IOException {
/* 281 */     String[] ss = relPath.split("->");
/*     */ 
/*     */     
/* 284 */     if (ss.length < 2) {
/* 285 */       GAME.Warn(j.errorGet("is badly formatted. Needs to contain a path with separation denoted by -> and the final entry being a number indicating which icon to pick of the sheet", key));
/* 286 */       return this.m.DUMMY;
/*     */     } 
/* 288 */     if (!this.makers.containsKey(ss[0])) {
/* 289 */       String e = "icons must be either in 16, 24 or 32 folders.";
/* 290 */       PathParser.error(e, j, key);
/* 291 */       return this.m.DUMMY;
/*     */     } 
/*     */     
/* 294 */     IconMaker m = (IconMaker)this.makers.get(ss[0]);
/*     */     
/* 296 */     relPath = relPath.substring(relPath.indexOf("->") + "->".length());
/*     */     
/* 298 */     return m.get(relPath, j, key);
/*     */   }
/*     */   public static class M extends IconMaker { int i; public final Icon clear_structure; public final Icon capitol; public final Icon furniture; public final Icon raider; public final Icon agriculture; public final Icon fertility; public final Icon cancel; public final Icon terrain; public final Icon storage_pullers; public final Icon crossair; public final Icon storage_pull; public final Icon wall; public final Icon anti; public final Icon storage_push; public final Icon noble; public final Icon copy; public final Icon wildlife; public final Icon priority; public final Icon foundation; public final Icon baby; public final Icon skull; public final Icon descrimination; public final Icon admin; public final Icon familyTree; public final Icon ok; public final Icon questionmark; public final Icon arrow_up; public final Icon arrow_right; public final Icon arrow_down; public final Icon arrow_left; public final Icon expand; public final Icon shrink; public final Icon citizen; public final Icon rebellion; public final Icon urn; public final Icon stength; public final Icon plus; public final Icon minus; public final Icon rotate; public final Icon exit; public final Icon repair; public final Icon time; public final Icon menu; public final Icon wheel; public final Icon city; public final Icon flag; public final Icon cog; public final Icon openscroll; public final Icon raw_materials; public final Icon building; public final Icon pickaxe; public final Icon place_fill; public final Icon shield; public final Icon horn; public final Icon clear_food; public final Icon for_loose; public final Icon for_tight; public final Icon fast_forw; public final Icon for_muster; public final Icon circle_frame; public final Icon circle_inner; public final Icon cog_big; public final Icon place_brush; public final Icon place_rec; public final Icon place_line; public final Icon place_ellispse; public final Icon place_rec_hollow; public final Icon trash; public final Icon menu2; public final Icon law; public final Icon overwrite; public final Icon workshop; public final Icon slave; public final Icon water; public final Icon sword; public final Icon heart; public final Icon lock; public final Icon search; public final Icon bow; public final Icon fortification; public final Icon disease; public final Icon ceiling; public final Icon wallceiling; public final Icon chainsFree; public final Icon coins; public final Icon factions; public final Icon place_ellispse_hollow; public final Icon place_hex; public final Icon place_hex_hollow; public final Icon wall_opening; public final Icon gov; public final Icon advice; public final Icon b_muster; public final Icon b_for_tight; public final Icon b_for_loose; public final Icon b_run; public final Icon b_guard; public final Icon b_fire; public final Icon b_fire_stop;
/*     */     public final Icon b_chase;
/*     */     public final Icon b_charge;
/*     */     public final Icon b_stop;
/*     */     
/*     */     private M() throws IOException {
/* 306 */       super("24", 24);
/*     */ 
/*     */       
/* 309 */       this.i = 0;
/*     */       
/* 311 */       this.clear_structure = get();
/* 312 */       this.capitol = get();
/* 313 */       this.furniture = get();
/* 314 */       this.raider = get();
/* 315 */       this.agriculture = get();
/* 316 */       this.fertility = get();
/* 317 */       this.cancel = get();
/* 318 */       this.terrain = get();
/*     */       
/* 320 */       this.storage_pullers = get();
/* 321 */       this.crossair = get();
/* 322 */       this.storage_pull = get();
/* 323 */       this.wall = get();
/* 324 */       this.anti = get();
/* 325 */       this.storage_push = get();
/* 326 */       this.noble = get();
/* 327 */       this.copy = get();
/*     */       
/* 329 */       this.wildlife = get();
/* 330 */       this.priority = get();
/* 331 */       this.foundation = get();
/* 332 */       get();
/* 333 */       this.baby = get();
/* 334 */       get();
/* 335 */       this.skull = get();
/* 336 */       this.descrimination = get();
/*     */       
/* 338 */       this.admin = get();
/* 339 */       this.familyTree = get();
/* 340 */       this.ok = get();
/* 341 */       this.questionmark = get();
/* 342 */       this.arrow_up = get();
/* 343 */       this.arrow_right = get();
/* 344 */       this.arrow_down = get();
/* 345 */       this.arrow_left = get();
/* 346 */       get();
/* 347 */       this.expand = get();
/* 348 */       this.shrink = get();
/* 349 */       this.citizen = get();
/* 350 */       this.rebellion = get();
/* 351 */       get();
/* 352 */       this.urn = get();
/* 353 */       get();
/* 354 */       get();
/* 355 */       this.stength = get();
/* 356 */       this.plus = get();
/* 357 */       this.minus = get();
/* 358 */       this.rotate = get();
/* 359 */       this.exit = get();
/* 360 */       this.repair = get();
/* 361 */       this.time = get();
/* 362 */       this.menu = get();
/* 363 */       this.wheel = get();
/* 364 */       this.city = get();
/* 365 */       get();
/* 366 */       this.flag = get();
/* 367 */       this.cog = get();
/* 368 */       this.openscroll = get();
/* 369 */       this.raw_materials = get();
/* 370 */       get();
/* 371 */       get();
/* 372 */       get();
/* 373 */       this.building = get();
/* 374 */       this.pickaxe = get();
/* 375 */       this.place_fill = get();
/* 376 */       this.shield = get();
/* 377 */       this.horn = get();
/* 378 */       this.clear_food = get();
/* 379 */       this.for_loose = get();
/* 380 */       this.for_tight = get();
/* 381 */       this.fast_forw = get();
/* 382 */       this.for_muster = get();
/* 383 */       this.circle_frame = get();
/* 384 */       this.circle_inner = get();
/* 385 */       get();
/* 386 */       this.cog_big = get();
/* 387 */       this.place_brush = get();
/* 388 */       this.place_rec = get();
/* 389 */       this.place_line = get();
/* 390 */       this.place_ellispse = get();
/* 391 */       this.place_rec_hollow = get();
/* 392 */       this.trash = get();
/* 393 */       this.menu2 = get();
/* 394 */       this.law = get();
/* 395 */       this.overwrite = get();
/* 396 */       this.workshop = get();
/* 397 */       this.slave = get();
/* 398 */       get();
/* 399 */       this.water = get();
/* 400 */       this.sword = get();
/* 401 */       get();
/* 402 */       get();
/* 403 */       this.heart = get();
/* 404 */       this.lock = get();
/* 405 */       this.search = get();
/* 406 */       this.bow = get();
/* 407 */       this.fortification = get();
/* 408 */       this.disease = get();
/* 409 */       this.ceiling = get();
/* 410 */       this.wallceiling = get();
/* 411 */       this.chainsFree = get();
/* 412 */       this.coins = get();
/* 413 */       this.factions = get();
/* 414 */       get();
/* 415 */       this.place_ellispse_hollow = get();
/* 416 */       this.place_hex = get();
/* 417 */       this.place_hex_hollow = get();
/* 418 */       this.wall_opening = get();
/* 419 */       this.gov = get();
/* 420 */       this.advice = get();
/*     */       
/* 422 */       this.i = 0;
/* 423 */       this.b_muster = m();
/* 424 */       this.b_for_tight = m();
/* 425 */       this.b_for_loose = m();
/* 426 */       this.b_run = m();
/* 427 */       this.b_guard = m();
/* 428 */       this.b_fire = m();
/* 429 */       this.b_fire_stop = m();
/* 430 */       m();
/* 431 */       this.b_chase = m();
/* 432 */       this.b_charge = m();
/* 433 */       this.b_stop = m();
/*     */     }
/*     */     
/*     */     private Icon get() throws IOException {
/* 437 */       int k = this.i;
/* 438 */       this.i++;
/* 439 */       return get("_Icons", k);
/*     */     }
/*     */     
/*     */     private Icon m() throws IOException {
/* 443 */       int k = this.i;
/* 444 */       this.i++;
/* 445 */       return get("_Battle", k);
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class S
/*     */     extends IconMaker
/*     */   {
/* 453 */     private static ArrayListGrower<IconS> all = new ArrayListGrower(); int i; public final IconS magnifier; public final IconS minifier; public final IconS minimap; public final IconS arrowUp; public final IconS arrowDown; public final IconS cancel; public final IconS camera; public final IconS crazy; public final IconS menu; public final IconS cog; public final IconS question; public final IconS storage; public final IconS magnifierBig; public final IconS minifierBig; public final IconS human; public final IconS hammer; public final IconS column; public final IconS vial; public final IconS gift; public final IconS plate; public final IconS sword; public final IconS money; public final IconS crossheir; public final IconS standard; public final IconS temperature; public final IconS eye; public final IconS law; public final IconS pickaxe; public final IconS shield; public final IconS capitol; public final IconS sprout; public final IconS trade; public final IconS bow; public final IconS fish; public final IconS heart; public final IconS citizen; public final IconS slave; public final IconS noble; public final IconS world; public final IconS admin; public final IconS muster; public final IconS time; public final IconS ice; public final IconS heat; public final IconS pluses; public final IconS squatter; public final IconS fly; public final IconS honor; public final IconS bed;
/*     */     public final IconS alert;
/*     */     public final IconS arrow_right;
/*     */     public final IconS arrow_left;
/*     */     public final IconS plus;
/*     */     
/*     */     private S() throws IOException {
/* 460 */       super("16", 16);
/*     */       
/*     */       all.clear();
/* 463 */       this.i = 0;
/*     */ 
/*     */       
/* 466 */       this.magnifier = get();
/* 467 */       this.minifier = get();
/* 468 */       this.minimap = get();
/* 469 */       this.arrowUp = get();
/*     */       
/* 471 */       this.arrowDown = get();
/* 472 */       this.cancel = get();
/* 473 */       this.camera = get();
/* 474 */       this.crazy = get();
/*     */       
/* 476 */       this.menu = get();
/* 477 */       this.cog = get();
/* 478 */       this.question = get();
/* 479 */       this.storage = get();
/*     */       
/* 481 */       this.magnifierBig = get();
/* 482 */       this.minifierBig = get();
/* 483 */       this.human = get();
/* 484 */       this.hammer = get();
/*     */       
/* 486 */       this.column = get();
/* 487 */       this.vial = get();
/* 488 */       this.gift = get();
/* 489 */       this.plate = get();
/*     */       
/* 491 */       this.sword = get();
/* 492 */       this.money = get();
/* 493 */       this.crossheir = get();
/* 494 */       this.standard = get();
/*     */       
/* 496 */       this.temperature = get();
/* 497 */       this.eye = get();
/* 498 */       this.law = get();
/* 499 */       this.pickaxe = get();
/*     */       
/* 501 */       this.shield = get();
/* 502 */       this.capitol = get();
/* 503 */       this.sprout = get();
/* 504 */       this.trade = get();
/*     */       
/* 506 */       this.bow = get();
/* 507 */       this.fish = get();
/* 508 */       this.heart = get();
/* 509 */       this.citizen = get();
/*     */       
/* 511 */       this.slave = get();
/* 512 */       this.noble = get();
/* 513 */       this.world = get();
/* 514 */       this.admin = get();
/*     */       
/* 516 */       this.muster = get();
/* 517 */       this.time = get();
/* 518 */       this.ice = get();
/* 519 */       this.heat = get();
/*     */       
/* 521 */       this.pluses = get();
/* 522 */       this.squatter = get();
/* 523 */       this.fly = get();
/* 524 */       this.honor = get();
/*     */       
/* 526 */       this.bed = get();
/* 527 */       this.alert = get();
/* 528 */       this.arrow_right = get();
/* 529 */       this.arrow_left = get();
/*     */       
/* 531 */       this.plus = get();
/* 532 */       this.minus = get();
/* 533 */       this.allRight = get();
/* 534 */       this.circle = get();
/*     */       
/* 536 */       this.clock = get();
/* 537 */       this.death = get();
/* 538 */       this.dot = get();
/* 539 */       this.house = get();
/*     */       
/* 541 */       this.degrade = get();
/* 542 */       this.fist = get();
/* 543 */       this.armour = get();
/* 544 */       this.handOpen = get();
/* 545 */       this.speed = get();
/*     */       
/* 547 */       this.boom = get();
/* 548 */       this.drop = get();
/* 549 */       this.star = get();
/* 550 */       this.ship = get();
/* 551 */       this
/*     */ 
/*     */ 
/*     */         
/* 555 */         .chevrons = new IconS[] { get(), get(), get(), get() };
/*     */ 
/*     */       
/* 558 */       this.happy = get();
/* 559 */       this.soso = get();
/* 560 */       this.angry = get();
/* 561 */       this
/*     */ 
/*     */         
/* 564 */         .faces = new SPRITE[] { this.angry.createColored((COLOR)new ColorImp(165, 30, 30)), this.soso.createColored((COLOR)new ColorImp(165, 165, 10)), this.happy.createColored((COLOR)new ColorImp(30, 165, 30)) };
/*     */ 
/*     */       
/* 567 */       this.crown = get();
/* 568 */       this.flags = get();
/* 569 */       this.expand = get();
/* 570 */       this.wheel = get();
/* 571 */       this.flag = get();
/* 572 */       this.cameraBig = get();
/* 573 */       this.tolerence = get();
/* 574 */       this.headspike = get();
/* 575 */       this.jug = get();
/* 576 */       this.bars = get();
/* 577 */       this.shrine = get();
/* 578 */       this.temple = get();
/* 579 */       this.book = get();
/* 580 */       this.plus2 = get();
/* 581 */       this.plusBig = get();
/* 582 */       this.copy = get();
/* 583 */       this.smallSkull = get();
/* 584 */       this.divWalk = get();
/* 585 */       this.divRun = get();
/*     */       
/* 587 */       this.typeCitizen = get();
/* 588 */       this.typeRetire = get();
/* 589 */       this.typeRecruit = get();
/* 590 */       this.typeSoldier = get();
/* 591 */       this.typeStudent = get();
/* 592 */       this.typePrison = get();
/* 593 */       this.typeTourist = get();
/* 594 */       this.typeRioter = get();
/* 595 */       this.typeCrazy = get();
/* 596 */       this.typeChild = get();
/* 597 */       this.typeParent = get();
/*     */       
/* 599 */       this.reproduction = get();
/*     */       
/* 601 */       this.typeGuard = get();
/* 602 */       this.trust = get();
/* 603 */       this.emissary = get();
/*     */     } public final IconS minus; public final IconS allRight; public final IconS circle; public final IconS clock; public final IconS death; public final IconS dot; public final IconS house; public final IconS degrade; public final IconS fist; public final IconS armour; public final IconS handOpen; public final IconS speed; public final IconS boom; public final IconS drop; public final IconS star; public final IconS ship; public final IconS[] chevrons; public final IconS happy; public final IconS soso; public final IconS angry; public final SPRITE[] faces; public final IconS crown; public final IconS flags; public final IconS expand; public final IconS wheel; public final IconS flag; public final IconS cameraBig; public final IconS tolerence; public final IconS headspike; public final IconS jug; public final IconS bars; public final IconS shrine; public final IconS temple; public final IconS book; public final IconS plus2; public final IconS plusBig; public final IconS copy; public final IconS smallSkull; public final IconS divWalk; public final IconS divRun; public final IconS typeCitizen; public final IconS typeRetire; public final IconS typeRecruit; public final IconS typeSoldier; public final IconS typeStudent; public final IconS typePrison; public final IconS typeTourist; public final IconS typeRioter; public final IconS typeCrazy; public final IconS typeChild; public final IconS typeParent; public final IconS reproduction; public final IconS typeGuard; public final IconS trust; public final IconS emissary;
/*     */     public IconS chevron(DIR d) {
/* 606 */       return this.chevrons[d.orthoID()];
/*     */     }
/*     */     
/*     */     private IconS get() throws IOException {
/* 610 */       int k = this.i;
/* 611 */       this.i++;
/*     */       
/* 613 */       return new IconS(get("_Icons", k));
/*     */     }
/*     */     
/* 616 */     private static final COLOR mask = (COLOR)new ColorImp(142, 134, 107);
/*     */     
/*     */     public static class IconS
/*     */       extends Icon {
/*     */       public final int index;
/*     */       
/*     */       IconS(Icon i) {
/* 623 */         super(16, i);
/* 624 */         this.index = Icons.S.all.add(this);
/*     */       }
/*     */ 
/*     */       
/*     */       public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 629 */         COLOR c = CORE.renderer().colorGet();
/* 630 */         if (c.red() == Byte.MAX_VALUE && c.green() == Byte.MAX_VALUE && c.blue() == Byte.MAX_VALUE) {
/* 631 */           Icons.S.mask.bind();
/* 632 */           super.render(r, X1, X2, Y1, Y2);
/* 633 */           COLOR.unbind();
/*     */         }
/*     */         else {
/*     */           
/* 637 */           super.render(r, X1, X2, Y1, Y2);
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IconS get(int index) {
/* 646 */       if (index > all.size())
/* 647 */         return this.cancel; 
/* 648 */       return (IconS)all.get(index);
/*     */     } }
/*     */   public static class L extends IconMaker { private int i; public final Icon agri; public final Icon work; public final Icon service; public final Icon jobs; public final Icon gov; public final Icon thumbsDown; public final Icon rebel; public final Icon menu; public final Icon world; public final Icon battle; public final Icon city; public final Icon coin; public final Icon flags; public final Icon vial; public final Icon tourist; public final Icon book; public final Icon up; public final Icon infra; public final Icon crate; public final Icon crown; public final Icon crossheir; public final Icon swords; public final Icon star; public final Icon bannerPole; public final Icon[] banners; public final Icon clear_all; public final Icon copy; public final Icon copyRoom; public final Icon repair; public final Icon suspend; public final Icon dia; public final Icon square; public final Icon prints; public final Icon upgrade; public final Icon mine; public final Icon pasture; public final Icon farm; public final Icon fish; public final Icon refiner; public final Icon workshop; public final Icon law; public final Icon trainig; public final Icon admin; public final Icon breeding; public final Icon decor; public final Icon logistics; public final Icon water; public final Icon religion; public final Icon dist; public final Icon health; public final Icon entertain; public final Icon death; public final Icon home; public final Icon demolish;
/*     */     public final Icon event;
/*     */     public final Icon eventInactive;
/*     */     public final Icon demolishRoad;
/*     */     
/*     */     private L() throws IOException {
/* 656 */       super("32", 32);
/*     */ 
/*     */       
/* 659 */       this.i = 0;
/* 660 */       this.agri = get();
/* 661 */       this.work = get();
/* 662 */       this.service = get();
/* 663 */       this.jobs = get();
/* 664 */       this.gov = get();
/* 665 */       this.thumbsDown = get();
/* 666 */       get(); get();
/*     */ 
/*     */       
/* 669 */       this.rebel = get();
/* 670 */       this.menu = get();
/* 671 */       this.world = get();
/* 672 */       this.battle = get();
/* 673 */       this.city = get();
/* 674 */       this.coin = get();
/* 675 */       this.flags = get();
/* 676 */       this.vial = get();
/* 677 */       this.tourist = get();
/* 678 */       this.book = get();
/* 679 */       this.up = get();
/* 680 */       this.infra = get();
/* 681 */       this.crate = get();
/* 682 */       this.crown = get();
/* 683 */       this.crossheir = get();
/* 684 */       this.swords = get();
/* 685 */       this.star = get();
/*     */       
/* 687 */       this.i = 0;
/*     */       
/* 689 */       this.bannerPole = b();
/* 690 */       this
/*     */         
/* 692 */         .banners = new Icon[] { b(), b(), b(), b(), b(), b(), b(), b() };
/*     */ 
/*     */       
/* 695 */       this.i = 0;
/*     */       
/* 697 */       this.clear_all = get2();
/* 698 */       this.copy = get2();
/* 699 */       this.copyRoom = get2();
/* 700 */       this.repair = get2();
/* 701 */       this.suspend = get2();
/* 702 */       this.dia = get2();
/* 703 */       this.square = get2();
/* 704 */       this.prints = get2();
/* 705 */       this.upgrade = get2();
/* 706 */       this.mine = get2();
/* 707 */       this.pasture = get2();
/* 708 */       this.farm = get2();
/*     */       
/* 710 */       this.fish = get2();
/* 711 */       this.refiner = get2();
/* 712 */       this.workshop = get2();
/* 713 */       this.law = get2();
/* 714 */       this.trainig = get2();
/* 715 */       this.admin = get2();
/* 716 */       this.breeding = get2();
/* 717 */       this.decor = get2();
/* 718 */       this.logistics = get2();
/* 719 */       this.water = get2();
/* 720 */       this.religion = get2();
/* 721 */       this.dist = get2();
/* 722 */       this.health = get2();
/* 723 */       this.entertain = get2();
/* 724 */       this.death = get2();
/* 725 */       this.home = get2();
/* 726 */       this.demolish = get2();
/* 727 */       this.event = get2();
/* 728 */       this.eventInactive = get2();
/* 729 */       this.demolishRoad = get2();
/*     */     }
/*     */     private Icon get() throws IOException {
/* 732 */       int k = this.i;
/* 733 */       this.i++;
/* 734 */       return get("_UI", k);
/*     */     }
/*     */     
/*     */     private Icon get2() throws IOException {
/* 738 */       int k = this.i;
/* 739 */       this.i++;
/* 740 */       return get("_ICONS", k);
/*     */     }
/*     */     
/*     */     private Icon b() throws IOException {
/* 744 */       int k = this.i;
/* 745 */       this.i++;
/* 746 */       return get("_BANNER", k);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\Icons.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */