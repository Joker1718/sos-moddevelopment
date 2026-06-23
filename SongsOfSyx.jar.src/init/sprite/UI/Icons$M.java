/*     */ package init.sprite.UI;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class M
/*     */   extends IconMaker
/*     */ {
/*     */   int i;
/*     */   public final Icon clear_structure;
/*     */   public final Icon capitol;
/*     */   public final Icon furniture;
/*     */   public final Icon raider;
/*     */   public final Icon agriculture;
/*     */   public final Icon fertility;
/*     */   public final Icon cancel;
/*     */   public final Icon terrain;
/*     */   public final Icon storage_pullers;
/*     */   public final Icon crossair;
/*     */   public final Icon storage_pull;
/*     */   public final Icon wall;
/*     */   public final Icon anti;
/*     */   public final Icon storage_push;
/*     */   public final Icon noble;
/*     */   public final Icon copy;
/*     */   public final Icon wildlife;
/*     */   public final Icon priority;
/*     */   public final Icon foundation;
/*     */   public final Icon baby;
/*     */   public final Icon skull;
/*     */   public final Icon descrimination;
/*     */   public final Icon admin;
/*     */   public final Icon familyTree;
/*     */   public final Icon ok;
/*     */   public final Icon questionmark;
/*     */   public final Icon arrow_up;
/*     */   public final Icon arrow_right;
/*     */   public final Icon arrow_down;
/*     */   public final Icon arrow_left;
/*     */   public final Icon expand;
/*     */   public final Icon shrink;
/*     */   public final Icon citizen;
/*     */   public final Icon rebellion;
/*     */   public final Icon urn;
/*     */   public final Icon stength;
/*     */   public final Icon plus;
/*     */   public final Icon minus;
/*     */   public final Icon rotate;
/*     */   public final Icon exit;
/*     */   public final Icon repair;
/*     */   public final Icon time;
/*     */   public final Icon menu;
/*     */   public final Icon wheel;
/*     */   public final Icon city;
/*     */   public final Icon flag;
/*     */   public final Icon cog;
/*     */   public final Icon openscroll;
/*     */   public final Icon raw_materials;
/*     */   public final Icon building;
/*     */   public final Icon pickaxe;
/*     */   public final Icon place_fill;
/*     */   public final Icon shield;
/*     */   public final Icon horn;
/*     */   public final Icon clear_food;
/*     */   public final Icon for_loose;
/*     */   public final Icon for_tight;
/*     */   public final Icon fast_forw;
/*     */   public final Icon for_muster;
/*     */   public final Icon circle_frame;
/*     */   public final Icon circle_inner;
/*     */   public final Icon cog_big;
/*     */   public final Icon place_brush;
/*     */   public final Icon place_rec;
/*     */   public final Icon place_line;
/*     */   public final Icon place_ellispse;
/*     */   public final Icon place_rec_hollow;
/*     */   public final Icon trash;
/*     */   public final Icon menu2;
/*     */   public final Icon law;
/*     */   public final Icon overwrite;
/*     */   public final Icon workshop;
/*     */   public final Icon slave;
/*     */   public final Icon water;
/*     */   public final Icon sword;
/*     */   public final Icon heart;
/*     */   public final Icon lock;
/*     */   public final Icon search;
/*     */   public final Icon bow;
/*     */   public final Icon fortification;
/*     */   public final Icon disease;
/*     */   public final Icon ceiling;
/*     */   public final Icon wallceiling;
/*     */   public final Icon chainsFree;
/*     */   public final Icon coins;
/*     */   public final Icon factions;
/*     */   public final Icon place_ellispse_hollow;
/*     */   public final Icon place_hex;
/*     */   public final Icon place_hex_hollow;
/*     */   public final Icon wall_opening;
/*     */   public final Icon gov;
/*     */   public final Icon advice;
/*     */   public final Icon b_muster;
/*     */   public final Icon b_for_tight;
/*     */   public final Icon b_for_loose;
/*     */   public final Icon b_run;
/*     */   public final Icon b_guard;
/*     */   public final Icon b_fire;
/*     */   public final Icon b_fire_stop;
/*     */   public final Icon b_chase;
/*     */   public final Icon b_charge;
/*     */   public final Icon b_stop;
/*     */   
/*     */   private M() throws IOException {
/* 306 */     super("24", 24);
/*     */ 
/*     */     
/* 309 */     this.i = 0;
/*     */     
/* 311 */     this.clear_structure = get();
/* 312 */     this.capitol = get();
/* 313 */     this.furniture = get();
/* 314 */     this.raider = get();
/* 315 */     this.agriculture = get();
/* 316 */     this.fertility = get();
/* 317 */     this.cancel = get();
/* 318 */     this.terrain = get();
/*     */     
/* 320 */     this.storage_pullers = get();
/* 321 */     this.crossair = get();
/* 322 */     this.storage_pull = get();
/* 323 */     this.wall = get();
/* 324 */     this.anti = get();
/* 325 */     this.storage_push = get();
/* 326 */     this.noble = get();
/* 327 */     this.copy = get();
/*     */     
/* 329 */     this.wildlife = get();
/* 330 */     this.priority = get();
/* 331 */     this.foundation = get();
/* 332 */     get();
/* 333 */     this.baby = get();
/* 334 */     get();
/* 335 */     this.skull = get();
/* 336 */     this.descrimination = get();
/*     */     
/* 338 */     this.admin = get();
/* 339 */     this.familyTree = get();
/* 340 */     this.ok = get();
/* 341 */     this.questionmark = get();
/* 342 */     this.arrow_up = get();
/* 343 */     this.arrow_right = get();
/* 344 */     this.arrow_down = get();
/* 345 */     this.arrow_left = get();
/* 346 */     get();
/* 347 */     this.expand = get();
/* 348 */     this.shrink = get();
/* 349 */     this.citizen = get();
/* 350 */     this.rebellion = get();
/* 351 */     get();
/* 352 */     this.urn = get();
/* 353 */     get();
/* 354 */     get();
/* 355 */     this.stength = get();
/* 356 */     this.plus = get();
/* 357 */     this.minus = get();
/* 358 */     this.rotate = get();
/* 359 */     this.exit = get();
/* 360 */     this.repair = get();
/* 361 */     this.time = get();
/* 362 */     this.menu = get();
/* 363 */     this.wheel = get();
/* 364 */     this.city = get();
/* 365 */     get();
/* 366 */     this.flag = get();
/* 367 */     this.cog = get();
/* 368 */     this.openscroll = get();
/* 369 */     this.raw_materials = get();
/* 370 */     get();
/* 371 */     get();
/* 372 */     get();
/* 373 */     this.building = get();
/* 374 */     this.pickaxe = get();
/* 375 */     this.place_fill = get();
/* 376 */     this.shield = get();
/* 377 */     this.horn = get();
/* 378 */     this.clear_food = get();
/* 379 */     this.for_loose = get();
/* 380 */     this.for_tight = get();
/* 381 */     this.fast_forw = get();
/* 382 */     this.for_muster = get();
/* 383 */     this.circle_frame = get();
/* 384 */     this.circle_inner = get();
/* 385 */     get();
/* 386 */     this.cog_big = get();
/* 387 */     this.place_brush = get();
/* 388 */     this.place_rec = get();
/* 389 */     this.place_line = get();
/* 390 */     this.place_ellispse = get();
/* 391 */     this.place_rec_hollow = get();
/* 392 */     this.trash = get();
/* 393 */     this.menu2 = get();
/* 394 */     this.law = get();
/* 395 */     this.overwrite = get();
/* 396 */     this.workshop = get();
/* 397 */     this.slave = get();
/* 398 */     get();
/* 399 */     this.water = get();
/* 400 */     this.sword = get();
/* 401 */     get();
/* 402 */     get();
/* 403 */     this.heart = get();
/* 404 */     this.lock = get();
/* 405 */     this.search = get();
/* 406 */     this.bow = get();
/* 407 */     this.fortification = get();
/* 408 */     this.disease = get();
/* 409 */     this.ceiling = get();
/* 410 */     this.wallceiling = get();
/* 411 */     this.chainsFree = get();
/* 412 */     this.coins = get();
/* 413 */     this.factions = get();
/* 414 */     get();
/* 415 */     this.place_ellispse_hollow = get();
/* 416 */     this.place_hex = get();
/* 417 */     this.place_hex_hollow = get();
/* 418 */     this.wall_opening = get();
/* 419 */     this.gov = get();
/* 420 */     this.advice = get();
/*     */     
/* 422 */     this.i = 0;
/* 423 */     this.b_muster = m();
/* 424 */     this.b_for_tight = m();
/* 425 */     this.b_for_loose = m();
/* 426 */     this.b_run = m();
/* 427 */     this.b_guard = m();
/* 428 */     this.b_fire = m();
/* 429 */     this.b_fire_stop = m();
/* 430 */     m();
/* 431 */     this.b_chase = m();
/* 432 */     this.b_charge = m();
/* 433 */     this.b_stop = m();
/*     */   }
/*     */   
/*     */   private Icon get() throws IOException {
/* 437 */     int k = this.i;
/* 438 */     this.i++;
/* 439 */     return get("_Icons", k);
/*     */   }
/*     */   
/*     */   private Icon m() throws IOException {
/* 443 */     int k = this.i;
/* 444 */     this.i++;
/* 445 */     return get("_Battle", k);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\Icons$M.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */