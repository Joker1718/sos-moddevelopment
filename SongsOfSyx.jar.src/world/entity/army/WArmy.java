/*     */ package world.entity.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.io.IOException;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADArmies;
/*     */ import world.army.ADDivs;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.WEntityConstructor;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.map.pathing.WPath;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ public final class WArmy
/*     */   extends WEntity
/*     */ {
/*  40 */   int iteration = 0;
/*  41 */   short index = -1;
/*  42 */   public final Str name = new Str(24);
/*     */   
/*  44 */   private final ADDivs army = new ADDivs(this);
/*  45 */   private final WRegFinder.Treaty treaty = new WRegFinder.Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */       {
/*  49 */         if (to == null)
/*  50 */           return true; 
/*  51 */         if (tx != to.cx() || ty != to.cy())
/*  52 */           return true; 
/*  53 */         if (to.faction() == WArmy.this.faction())
/*  54 */           return true; 
/*  55 */         if (to.faction() == null || WArmy.this.faction() == null)
/*  56 */           return false; 
/*  57 */         if ((DIP.get(to.faction(), WArmy.this.faction())).ally)
/*  58 */           return true; 
/*  59 */         return false;
/*     */       }
/*     */     };
/*  62 */   private final WPath path = new P(this.treaty);
/*  63 */   static double speed = 6.4D;
/*     */   public static final int size = 128;
/*  65 */   private byte state = 0;
/*     */   
/*     */   short stateShort;
/*     */   float stateFloat;
/*  69 */   public static int reinforceTiles = 4;
/*  70 */   private float upD = 0.0F;
/*     */   
/*     */   void init(int tx, int ty, Faction f) {
/*  73 */     body().moveCX((tx * 64 + 32));
/*  74 */     body().moveCY((ty * 64 + 32));
/*  75 */     this.state = 0;
/*  76 */     this.iteration++;
/*  77 */     this.army.clear();
/*  78 */     this.path.clear();
/*  79 */     this.army.clear();
/*  80 */     add();
/*  81 */     if (!added())
/*  82 */       throw new RuntimeException(); 
/*  83 */     AD.addOnlyToBeCalledFromAnArmy(this, f);
/*     */   }
/*     */   
/*     */   public WArmy() {
/*  87 */     super(128, 128);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  93 */     file.i(this.iteration);
/*  94 */     file.s(this.index);
/*  95 */     this.name.save(file);
/*  96 */     this.army.save(file);
/*  97 */     this.path.save(file);
/*  98 */     file.f(this.stateFloat);
/*  99 */     file.s(this.stateShort);
/* 100 */     file.b(this.state);
/* 101 */     file.f(this.upD);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WEntity load(FileGetter file) throws IOException {
/* 106 */     this.iteration = file.i();
/* 107 */     this.index = file.s();
/* 108 */     this.name.load(file);
/* 109 */     this.army.load(file);
/* 110 */     this.path.load(file);
/*     */     
/* 112 */     this.stateFloat = file.f();
/* 113 */     this.stateShort = file.s();
/* 114 */     this.state = file.b();
/* 115 */     this.upD = file.f();
/* 116 */     (WORLD.ENTITIES()).armies.load(this);
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 122 */     for (int i = 0; i < divs().size(); i++) {
/* 123 */       divs().get(i).disband();
/* 124 */       i--;
/*     */     } 
/* 126 */     checkForResources();
/* 127 */     AD.removeOnlyTobeCalledFromAnArmy(this);
/* 128 */     (WORLD.ENTITIES()).armies.ret(this);
/*     */   }
/*     */   
/*     */   public int iteration() {
/* 132 */     return this.iteration;
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
/*     */   protected void renderBelowTerrain(Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderAboveTerrain(Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 153 */     if (faction() != FACTIONS.player() && 
/* 154 */       WORLD.FOW().is(ctx(), cty())) {
/*     */       return;
/*     */     }
/* 157 */     (WORLD.ENTITIES()).armies.sprite.render(this, r, s, x, y, this.path.dir());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleFow() {
/* 163 */     if (faction() == FACTIONS.player()) {
/* 164 */       WORLD.FOW().enlighten(ctx(), cty(), 5);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 170 */     return AD.faction(this);
/*     */   }
/*     */   
/*     */   public ADArmies armies() {
/* 174 */     Faction f = faction();
/* 175 */     if (f != null)
/* 176 */       return f.armies(); 
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 183 */     if (AD.men(null).get(this) == 0) {
/* 184 */       if (region() == null || region().faction() != faction()) {
/* 185 */         remove(); return;
/*     */       } 
/* 187 */       if (state() != WArmyState.fortifying && 
/* 188 */         state() != WArmyState.fortified) {
/* 189 */         setState((byte)WArmyState.fortifying.index());
/*     */       }
/*     */     } 
/*     */     
/* 193 */     if (faction() == FACTIONS.player() && region() != null && region().faction() instanceof FactionNPC) {
/* 194 */       FactionNPC ff = (FactionNPC)region().faction();
/* 195 */       if (!(DIP.get(ff)).ally) {
/* 196 */         ROPINION.STANCE().tresPass(ff, ds);
/*     */       }
/*     */     } 
/* 199 */     int ox = body().x1();
/* 200 */     int oy = body().y1();
/* 201 */     setState((byte)state().update(this, ds).index());
/* 202 */     this.upD = (float)(this.upD - ds);
/* 203 */     if (ox != body().x1() || oy != body().y1()) {
/* 204 */       this.upD = -1.0F;
/* 205 */       WORLD.BATTLES().report(this);
/* 206 */     } else if (this.upD <= 0.0F) {
/* 207 */       this.upD = 16.0F;
/* 208 */       checkForResources();
/* 209 */       WORLD.BATTLES().report(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void checkForResources() {
/* 215 */     if (faction() == FACTIONS.player()) {
/* 216 */       for (ADSupply s : (AD.supplies()).all) {
/* 217 */         if (s.current().get(this) > s.targetAmount(this)) {
/* 218 */           returnResources();
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void setState(int state) {
/* 226 */     this.state = (byte)state;
/*     */   }
/*     */   
/*     */   private void returnResources() {
/* 230 */     Shipment ship = (WORLD.ENTITIES()).caravans.create(ctx(), cty(), FACTIONS.player().capitolRegion(), TRADE_TYPE.spoils);
/* 231 */     if (ship != null) {
/* 232 */       for (ADSupply ss : (AD.supplies()).all) {
/* 233 */         int am = ss.current().get(this) - ss.targetAmount(this);
/* 234 */         am = CLAMP.i(am, 0, 32767);
/* 235 */         if (am > 0) {
/* 236 */           ship.loadAndReserve((TRADABLE)TR.get(ss.res), am);
/*     */ 
/*     */           
/* 239 */           ss.current().inc(this, -am);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected WEntityConstructor<? extends WEntity> constructor() {
/* 247 */     return (WORLD.ENTITIES()).armies;
/*     */   }
/*     */   
/*     */   public short armyIndex() {
/* 251 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDestination(int tx, int ty) {
/* 256 */     if (AD.men(null).get(this) == 0)
/*     */       return; 
/* 258 */     stop();
/* 259 */     if (this.path.find(ctx(), cty(), tx, ty))
/* 260 */       setState((byte)WArmyState.moving.index()); 
/*     */   }
/*     */   
/*     */   public void besiege(Region reg) {
/* 264 */     if (AD.men(null).get(this) == 0)
/*     */       return; 
/* 266 */     if (besieging(reg)) {
/* 267 */       WORLD.BATTLES().besige(this, reg);
/*     */     } else {
/* 269 */       stop();
/* 270 */       COORDINATE c = besigeTile(reg);
/* 271 */       if (c != null && 
/* 272 */         this.path.find(ctx(), cty(), c.x(), c.y())) {
/* 273 */         setState((byte)WArmyState.besieging.index());
/* 274 */         this.stateFloat = 0.0F;
/* 275 */         this.stateShort = (short)reg.index();
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void raid(Region reg) {
/* 284 */     if (AD.men(null).get(this) == 0) {
/*     */       return;
/*     */     }
/* 287 */     if (region() == reg) {
/* 288 */       raid(true);
/*     */       
/*     */       return;
/*     */     } 
/* 292 */     stop();
/*     */ 
/*     */     
/* 295 */     COORDINATE c = besigeTile(reg);
/* 296 */     if (c != null && 
/* 297 */       this.path.find(ctx(), cty(), c.x(), c.y())) {
/* 298 */       GUTIL.coos().set(0);
/*     */       do {
/* 300 */         if (reg.is(this.path.x(), this.path.y())) {
/* 301 */           GUTIL.coos().get().set(this.path.x(), this.path.y());
/* 302 */           GUTIL.coos().inc();
/*     */         } 
/* 304 */         this.path.setNext();
/* 305 */       } while (!this.path.arrived());
/*     */       
/* 307 */       int am = GUTIL.coos().getI() - 1;
/* 308 */       GAME.Notify(Integer.valueOf(am));
/*     */       
/* 310 */       if (am > 0) {
/* 311 */         GUTIL.coos().shuffle(am);
/* 312 */         GUTIL.coos().set(0);
/* 313 */         if (this.path.find(ctx(), cty(), GUTIL.coos().get().x(), GUTIL.coos().get().y())) {
/* 314 */           setState((byte)WArmyState.movingRaid.index());
/* 315 */           this.stateFloat = 0.0F;
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 322 */     besigeTile(reg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void raid(boolean raid) {
/* 327 */     if (raid && !canRaid())
/*     */       return; 
/* 329 */     if (raid == raiding()) {
/*     */       return;
/*     */     }
/* 332 */     this.stateFloat = 0.0F;
/*     */     
/* 334 */     if (raid) {
/*     */       
/* 336 */       setState((byte)WArmyState.raiding.index());
/*     */     } else {
/* 338 */       setState((byte)WArmyState.fortifying.index());
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean canRaid() {
/* 343 */     return (region() != null);
/*     */   }
/*     */   
/*     */   public boolean raiding() {
/* 347 */     return (state() == WArmyState.raiding);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE besigeTile(Region reg) {
/* 353 */     if ((WORLD.REGIONS()).centre.get(ctx(), cty()) == reg) {
/* 354 */       Rec.TEMP.setDim(5.0D, 5.0D);
/* 355 */       Rec.TEMP.moveC(reg.cx(), reg.cy());
/*     */       
/* 357 */       for (COORDINATE c : Rec.TEMP) {
/* 358 */         if (reg.isBesigeTile(c.x(), c.y())) {
/* 359 */           return c;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 364 */     if (reg.isBesigeTile(ctx(), cty())) {
/* 365 */       Coo.TMP.set(ctx(), cty());
/* 366 */       return (COORDINATE)Coo.TMP;
/*     */     } 
/*     */     
/* 369 */     PathTile t = WORLD.PATH().path(ctx(), cty(), reg.cx(), reg.cy(), WRegFinder.Treaty.DUMMY);
/* 370 */     while (t != null) {
/* 371 */       if (reg.isBesigeTile(t.x(), t.y())) {
/* 372 */         return (COORDINATE)t;
/*     */       }
/* 374 */       t = t.getParent();
/*     */     } 
/* 376 */     return (COORDINATE)t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void teleport(int tx, int ty) {
/* 381 */     body().moveCX((tx * 64 + 32));
/* 382 */     body().moveCY((ty * 64 + 32));
/* 383 */     stop();
/* 384 */     WORLD.BATTLES().report(this);
/*     */   }
/*     */   
/*     */   public void intercept(WArmy other) {
/* 388 */     if (AD.men(null).get(this) == 0)
/*     */       return; 
/* 390 */     stop();
/* 391 */     if (this.path.find(ctx(), cty(), other.ctx(), other.cty())) {
/* 392 */       this.stateShort = other.armyIndex();
/* 393 */       setState(WArmyState.intercepting.index());
/*     */     } 
/*     */   }
/*     */   
/*     */   public WArmy intercepting() {
/* 398 */     if (state() == WArmyState.intercepting && 
/* 399 */       this.stateShort != -1) {
/* 400 */       WArmy aa = (WORLD.ENTITIES()).armies.get(this.stateShort);
/* 401 */       if (aa == null || !aa.added()) {
/* 402 */         return null;
/*     */       }
/* 404 */       return aa;
/*     */     } 
/*     */ 
/*     */     
/* 408 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 413 */     this.path.clear();
/* 414 */     if (state() != WArmyState.fortifying && state() != WArmyState.fortified) {
/*     */       
/* 416 */       this.stateFloat = 0.0F;
/* 417 */       setState((byte)WArmyState.fortifying.index());
/* 418 */       this.upD = -1.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ADDivs divs() {
/* 424 */     return this.army;
/*     */   }
/*     */   
/*     */   public void disband() {
/* 428 */     if (added()) {
/* 429 */       remove();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WPath path() {
/* 436 */     return this.path;
/*     */   }
/*     */   
/*     */   public WArmyState state() {
/* 440 */     return (WArmyState)WArmyState.all().get(this.state);
/*     */   }
/*     */   
/*     */   public Region region() {
/* 444 */     return (Region)(WORLD.REGIONS()).map.get(ctx(), cty());
/*     */   }
/*     */   
/*     */   public double supplyAmount() {
/* 448 */     if ((WORLD.REGIONS()).map.get(ctx(), cty()) != null && ((Region)(WORLD.REGIONS()).map.get(ctx(), cty())).faction() == faction())
/* 449 */       return 1.0D; 
/* 450 */     return 1.0D;
/*     */   }
/*     */   
/*     */   public boolean recruiting() {
/* 454 */     if ((WORLD.REGIONS()).map.get(ctx(), cty()) != null && ((Region)(WORLD.REGIONS()).map.get(ctx(), cty())).faction() == faction())
/* 455 */       return (state() == WArmyState.fortified); 
/* 456 */     return false;
/*     */   }
/*     */   
/*     */   public double besigeTimer() {
/* 460 */     if (state() == WArmyState.besieging)
/* 461 */       return this.stateFloat; 
/* 462 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public boolean besieging(Region reg) {
/* 466 */     return (reg != null && reg == besieging());
/*     */   }
/*     */   
/*     */   public Region besieging() {
/* 470 */     if (state() != WArmyState.besieging)
/* 471 */       return null; 
/* 472 */     Region reg = WORLD.REGIONS().getByIndex(this.stateShort);
/* 473 */     if (reg == null) {
/* 474 */       return null;
/*     */     }
/* 476 */     if (!DIP.WAR().is(faction(), reg.faction()))
/* 477 */       return null; 
/* 478 */     if (AD.men(null).get(this) <= 0) {
/* 479 */       return null;
/*     */     }
/* 481 */     if (this.path.isValid())
/* 482 */       return reg.isBesigeTile(this.path.destX(), this.path.destY()) ? reg : null; 
/* 483 */     return reg.isBesigeTile(ctx(), cty()) ? reg : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 489 */     return "[" + this.index + "]" + String.valueOf(this.name) + " (" + ctx() + "," + cty() + ")";
/*     */   }
/*     */   
/*     */   private static final class P
/*     */     extends WPath
/*     */   {
/*     */     private final WRegFinder.Treaty t;
/*     */     
/*     */     P(WRegFinder.Treaty t) {
/* 498 */       this.t = t;
/*     */     }
/*     */ 
/*     */     
/*     */     public WRegFinder.Treaty treaty() {
/* 503 */       return this.t;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */