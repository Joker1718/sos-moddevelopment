/*     */ package world.map.pathing;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.GETTER_TRANS;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WRegFinder
/*     */ {
/*  22 */   private final RegDist[] regs = new RegDist[1023];
/*  23 */   private final ArrayList<RegDist> li = new ArrayList(1023);
/*     */   
/*  25 */   private int upI = -1;
/*  26 */   private Treaty lastTreaty = null;
/*  27 */   private BOOLEANO<Region> lastSelector = null;
/*     */   
/*     */   private int lx;
/*     */   
/*     */   private int ly;
/*     */   private final GETTER_TRANS.GETTER_TRANSE<PathTile, Region> prevReg;
/*     */   private final BOOLEANO.BOOLEAN_OE<PathTile> isWater;
/*     */   
/*     */   public LIST<RegDist> all(Faction f, Treaty trav, WRegSel selector) {
/*  36 */     return all(f.capitolRegion().cx(), f.capitolRegion().cy(), trav, selector);
/*     */   }
/*     */   
/*     */   public LIST<RegDist> all(Region home, Treaty trav, WRegSel selector) {
/*  40 */     return all(home.cx(), home.cy(), trav, selector);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<RegDist> all(int tx, int ty, Treaty treaty, WRegSel selector) {
/*  45 */     if (this.upI == GAME.updateI() && tx == this.lx && ty == this.ly && this.lastTreaty == treaty && selector == this.lastSelector) {
/*  46 */       return (LIST<RegDist>)this.li;
/*     */     }
/*  48 */     this.upI = GAME.updateI();
/*  49 */     this.lastTreaty = treaty;
/*  50 */     this.lastSelector = selector;
/*  51 */     this.lx = tx;
/*  52 */     this.ly = ty;
/*     */     
/*  54 */     Region origin = reg(tx, ty);
/*     */ 
/*     */     
/*  57 */     this.li.clearSloppy();
/*     */     
/*  59 */     LIST<PathTile> ll = (WORLD.PATH()).comps.finder.getComps(tx, ty);
/*     */     
/*  61 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  62 */     f.init(f);
/*  63 */     for (PathTile t : ll) {
/*  64 */       t = f.pushSloppy((COORDINATE)t, t.getValue());
/*  65 */       this.isWater.set(t, false);
/*  66 */       this.prevReg.set(t, origin);
/*     */     } 
/*     */ 
/*     */     
/*  70 */     while (f.hasMore()) {
/*  71 */       PathTile t = f.pollSmallest();
/*     */       
/*  73 */       if (t.getParent() != null) {
/*  74 */         t.setValue2(t.getParent().getValue2());
/*  75 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t) && (WORLD.ROADS()).harbour.is((COORDINATE)t)) {
/*  76 */           this.isWater.set(t, true);
/*     */         }
/*     */       } 
/*     */       
/*  80 */       Region from = reg(t.x(), t.y());
/*     */       
/*  82 */       if (from != null && t.isSameAs(from.cx(), from.cy()) && selector.is(from)) {
/*  83 */         RegDist rr = this.regs[from.index()];
/*  84 */         rr.reg = from;
/*  85 */         rr.distance = (int)t.getValue();
/*  86 */         rr.water = this.isWater.is(t);
/*  87 */         this.li.add(rr);
/*     */       } 
/*     */       
/*  90 */       if (from != null) {
/*  91 */         this.prevReg.set(t, from);
/*     */       } else {
/*  93 */         from = (Region)this.prevReg.get(t);
/*     */       } 
/*     */       
/*  96 */       Comps.WComp c = (Comps.WComp)(WORLD.PATH()).comps.get((COORDINATE)t);
/*  97 */       for (int i = 0; i < c.neighs(); i++) {
/*  98 */         Comps.WComp to = c.neigh(i);
/*     */         
/* 100 */         Region rto = reg(to.x(), to.y());
/*     */         
/* 102 */         double v = t.getValue() + c.dist(i);
/* 103 */         if (treaty.can(origin, from, rto, to.x(), to.y(), v)) {
/* 104 */           f.pushSmaller(to.x(), to.y(), v, t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 110 */     f.done();
/* 111 */     return (LIST<RegDist>)this.li;
/*     */   }
/*     */ 
/*     */   
/*     */   public RegDist single(int tx, int ty, Treaty treaty, WRegSel selector) {
/* 116 */     Region origin = reg(tx, ty);
/* 117 */     this.upI = -1;
/*     */ 
/*     */     
/* 120 */     LIST<PathTile> ll = (WORLD.PATH()).comps.finder.getComps(tx, ty);
/*     */     
/* 122 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 123 */     f.init(f);
/* 124 */     for (PathTile t : ll) {
/* 125 */       t = f.pushSloppy((COORDINATE)t, t.getValue());
/* 126 */       this.isWater.set(t, false);
/* 127 */       this.prevReg.set(t, origin);
/*     */     } 
/*     */ 
/*     */     
/* 131 */     while (f.hasMore()) {
/* 132 */       PathTile t = f.pollSmallest();
/*     */       
/* 134 */       if (t.getParent() != null) {
/* 135 */         t.setValue2(t.getParent().getValue2());
/* 136 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t) && (WORLD.ROADS()).harbour.is((COORDINATE)t)) {
/* 137 */           this.isWater.set(t, true);
/*     */         }
/*     */       } 
/*     */       
/* 141 */       Region from = reg(t.x(), t.y());
/*     */       
/* 143 */       if (from != null && t.isSameAs(from.cx(), from.cy()) && selector.is(from)) {
/* 144 */         RegDist rr = this.regs[from.index()];
/* 145 */         rr.reg = from;
/* 146 */         rr.distance = (int)t.getValue();
/* 147 */         rr.water = this.isWater.is(t);
/* 148 */         f.done();
/* 149 */         return rr;
/*     */       } 
/*     */       
/* 152 */       if (from != null) {
/* 153 */         this.prevReg.set(t, from);
/*     */       } else {
/* 155 */         from = (Region)this.prevReg.get(t);
/*     */       } 
/*     */       
/* 158 */       Comps.WComp c = (Comps.WComp)(WORLD.PATH()).comps.get((COORDINATE)t);
/* 159 */       for (int i = 0; i < c.neighs(); i++) {
/* 160 */         Comps.WComp to = c.neigh(i);
/*     */         
/* 162 */         Region rto = reg(to.x(), to.y());
/*     */         
/* 164 */         double v = t.getValue() + c.dist(i);
/* 165 */         if (treaty.can(origin, from, rto, to.x(), to.y(), v)) {
/* 166 */           f.pushSmaller(to.x(), to.y(), v, t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 172 */     f.done();
/* 173 */     return null;
/*     */   }
/*     */   
/*     */   private Region reg(int tx, int ty) {
/* 177 */     return (Region)(WORLD.PATH()).regMap.get(tx, ty);
/*     */   }
/*     */   
/*     */   public WRegFinder() {
/* 181 */     this.prevReg = new GETTER_TRANS.GETTER_TRANSE<PathTile, Region>()
/*     */       {
/*     */         public Region get(PathTile f)
/*     */         {
/* 185 */           int i = (int)f.getValue2();
/* 186 */           i >>= 4;
/* 187 */           if (i <= 0 || i > 1023)
/* 188 */             return null; 
/* 189 */           return (Region)WORLD.REGIONS().all().get(i - 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(PathTile f, Region t) {
/* 194 */           int i = (t == null) ? -1 : t.index();
/* 195 */           i++;
/* 196 */           int v = (int)f.getValue2();
/* 197 */           v &= 0xF;
/* 198 */           v |= i << 4;
/* 199 */           f.setValue2(v);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 204 */     this.isWater = new BOOLEANO.BOOLEAN_OE<PathTile>()
/*     */       {
/*     */         public boolean is(PathTile t)
/*     */         {
/* 208 */           int i = (int)t.getValue2();
/* 209 */           return ((i & 0x1) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public BOOLEANO.BOOLEAN_OE<PathTile> set(PathTile t, boolean b) {
/* 214 */           int v = (int)t.getValue2();
/* 215 */           v &= 0xFFFFFFFE;
/* 216 */           if (b)
/* 217 */             v |= 0x1; 
/* 218 */           t.setValue2(v);
/* 219 */           return this;
/*     */         }
/*     */       };
/*     */     for (int i = 0; i < this.regs.length; i++) {
/*     */       this.regs[i] = new RegDist();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class RegDist
/*     */   {
/*     */     public Region reg;
/*     */ 
/*     */ 
/*     */     
/*     */     public int distance;
/*     */ 
/*     */     
/*     */     public boolean water;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Treaty
/*     */   {
/* 246 */     public static final Treaty REG_NEIGHS = new Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */         {
/* 250 */           if (prevReg == null)
/* 251 */             return true; 
/* 252 */           if (prevReg == origin)
/* 253 */             return true; 
/* 254 */           return (prevReg == to);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     public static final Treaty FACTION_REACHABLE = new Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */         {
/* 268 */           if (origin == null)
/* 269 */             return false; 
/* 270 */           if (from == null)
/* 271 */             return false; 
/* 272 */           if (to == null)
/* 273 */             return true; 
/* 274 */           Faction o = origin.faction();
/*     */           
/* 276 */           if (o == null) {
/* 277 */             return (to.faction() == null);
/*     */           }
/*     */           
/* 280 */           if (to.faction() == null) {
/* 281 */             return false;
/*     */           }
/* 283 */           if (from.faction() == origin.faction()) {
/* 284 */             return true;
/*     */           }
/* 286 */           if (from.faction() == to.faction()) {
/* 287 */             return true;
/*     */           }
/* 289 */           if (origin.faction() == null) {
/* 290 */             return false;
/*     */           }
/* 292 */           if ((DIP.get(origin.faction(), from.faction())).transit)
/* 293 */             return true; 
/* 294 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 298 */     public static final Treaty FACTION_CAN_ATTACK = new Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */         {
/* 302 */           if (origin == null)
/* 303 */             return false; 
/* 304 */           Faction o = origin.faction();
/* 305 */           if (o == null) {
/* 306 */             return false;
/*     */           }
/*     */           
/* 309 */           if (from == null) {
/* 310 */             return true;
/*     */           }
/* 312 */           if (from.faction() == null) {
/* 313 */             return false;
/*     */           }
/* 315 */           if (from.faction() == o) {
/* 316 */             return true;
/*     */           }
/*     */           
/* 319 */           if ((DIP.get(o, from.faction())).ally) {
/* 320 */             return true;
/*     */           }
/*     */           
/* 323 */           if (to == null) {
/* 324 */             return false;
/*     */           }
/* 326 */           if (to.faction() == null) {
/* 327 */             return false;
/*     */           }
/* 329 */           return (from.faction() == to.faction());
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 337 */     public static final Treaty FACTION_REACHABLE_NPC_TRADE = new Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */         {
/* 341 */           if (origin == null)
/* 342 */             return false; 
/* 343 */           if (to == null)
/* 344 */             return true; 
/* 345 */           Faction o = origin.faction();
/*     */           
/* 347 */           if (o == null) {
/* 348 */             return (to.faction() == null);
/*     */           }
/*     */           
/* 351 */           if (to.faction() == null) {
/* 352 */             return !(from.faction() != null && from.faction() != o);
/*     */           }
/* 354 */           if (from.faction() == null || from.faction() == o) {
/* 355 */             return true;
/*     */           }
/*     */           
/* 358 */           if (from.faction() == origin.faction()) {
/* 359 */             return true;
/*     */           }
/* 361 */           if (from.faction() == to.faction()) {
/* 362 */             return true;
/*     */           }
/* 364 */           if (from.faction() == FACTIONS.player()) {
/* 365 */             return true;
/*     */           }
/*     */           
/* 368 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     public static final Treaty FACTION_BORDERS = new Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */         {
/* 379 */           if (origin == null)
/* 380 */             return false; 
/* 381 */           if (from == null) {
/* 382 */             return false;
/*     */           }
/* 384 */           if (to == null)
/* 385 */             return true; 
/* 386 */           if (from == to) {
/* 387 */             return true;
/*     */           }
/* 389 */           Faction o = origin.faction();
/* 390 */           if (from.faction() == o) {
/* 391 */             return true;
/*     */           }
/* 393 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 400 */     public static final Treaty FACTION = new Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */         {
/* 404 */           if (origin == null)
/* 405 */             return false; 
/* 406 */           if (from == null) {
/* 407 */             return false;
/*     */           }
/* 409 */           if (to == null)
/* 410 */             return true; 
/* 411 */           if (from == to) {
/* 412 */             return true;
/*     */           }
/* 414 */           Faction o = origin.faction();
/* 415 */           if (from.faction() == o && to.faction() == o) {
/* 416 */             return true;
/*     */           }
/* 418 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 425 */     public static final Treaty DUMMY = new Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region from, Region to, int tx, int ty, double dist)
/*     */         {
/* 429 */           return true;
/*     */         }
/*     */       };
/*     */     
/*     */     public abstract boolean can(Region param1Region1, Region param1Region2, Region param1Region3, int param1Int1, int param1Int2, double param1Double);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WRegFinder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */