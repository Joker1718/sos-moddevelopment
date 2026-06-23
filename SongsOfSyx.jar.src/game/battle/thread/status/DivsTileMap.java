/*     */ package game.battle.thread.status;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_INT;
/*     */ import snake2d.util.map.MAP_OBJECT_ISSER;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DivsTileMap
/*     */ {
/*  23 */   private final Tile[] tiles = new Tile[65535];
/*  24 */   private int tileNewI = 1;
/*  25 */   private final short[] firstTiles = new short[SETT.TAREA];
/*     */   
/*  27 */   private final Bitsmap2D[] soldiers = new Bitsmap2D[] {
/*  28 */       new Bitsmap2D(0, 4, SETT.TWIDTH, SETT.THEIGHT), 
/*  29 */       new Bitsmap2D(0, 4, SETT.TWIDTH, SETT.THEIGHT)
/*     */     };
/*     */   private final DivStatus[] statuses;
/*  32 */   private static IntChecker checker = new IntChecker((Config.battle()).DIVISIONS_PER_ARMY * 2);
/*     */   
/*  34 */   private final ArrayList<Div> tmp = new ArrayList(16);
/*     */ 
/*     */   
/*     */   public MAP_OBJECT_ISSER<Army> hasEnemy;
/*     */ 
/*     */   
/*     */   public MAP_OBJECT_ISSER<Army> hasAlly;
/*     */ 
/*     */   
/*     */   public MAP_OBJECT_ISSER<Div> hasOtherAlly;
/*     */ 
/*     */   
/*     */   public MAP_OBJECT_ISSER<Div> isser;
/*     */ 
/*     */   
/*     */   void add(short div, DivPositionImp next) {
/*  50 */     checker.init();
/*     */     
/*  52 */     for (int i = 0; i < next.deployed(); i++) {
/*  53 */       int x = next.tx(i);
/*  54 */       int y = next.ty(i);
/*  55 */       if (SETT.IN_BOUNDS(x, y)) {
/*  56 */         add(x, y, div);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void add(int x, int y, short currentI) {
/*  62 */     int tileI = x + y * SETT.TWIDTH;
/*  63 */     Tile first = this.tiles[this.firstTiles[tileI] & 0xFFFF];
/*  64 */     Div current = GAME.ARMIES().division(currentI);
/*     */     
/*  66 */     this.soldiers[current.army().index()].increment(tileI, 1);
/*     */     
/*  68 */     if (this.tileNewI > 65535) {
/*     */       return;
/*     */     }
/*  71 */     if (first == null) {
/*  72 */       this.firstTiles[tileI] = makeNewTile((short)0, current);
/*  73 */       this.tmp.clear();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  79 */     Tile t = first;
/*  80 */     while (t != null) {
/*  81 */       if (t.divI == currentI) {
/*     */         return;
/*     */       }
/*  84 */       t = this.tiles[t.next & 0xFFFF];
/*     */     } 
/*     */ 
/*     */     
/*  88 */     t = first;
/*     */     
/*  90 */     DivStatus currentOrder = this.statuses[currentI];
/*     */     
/*  92 */     boolean engaged = false;
/*     */     
/*  94 */     while (t != null) {
/*     */       
/*  96 */       Div other = GAME.ARMIES().division(t.divI);
/*  97 */       if (!engaged && other.army() != current.army()) {
/*  98 */         currentOrder.engagements = (short)(currentOrder.engagements + 1);
/*  99 */         (this.statuses[other.index()]).engagements = (short)((this.statuses[other.index()]).engagements + 1);
/* 100 */         engaged = true;
/*     */       } 
/*     */       
/* 103 */       if (!checker.isSetAndSet(t.divI)) {
/* 104 */         if (other.army() == current.army()) {
/* 105 */           currentOrder.friendlyCollisionSet(t.divI);
/* 106 */           this.statuses[t.divI].friendlyCollisionSet(currentI);
/*     */         } else {
/* 108 */           currentOrder.enemyCollisionSet(t.divI);
/* 109 */           this.statuses[t.divI].enemyCollisionSet(currentI);
/*     */         } 
/*     */       }
/* 112 */       t = this.tiles[t.next & 0xFFFF];
/*     */     } 
/*     */     
/* 115 */     for (int di = 0; di < DIR.ORTHO.size() && !engaged; di++) {
/*     */       
/* 117 */       DIR dd = (DIR)DIR.ORTHO.get(di);
/* 118 */       if (SETT.IN_BOUNDS(x, y, dd)) {
/*     */ 
/*     */         
/* 121 */         int ti = tileI + dd.x() + dd.y() * SETT.TWIDTH;
/*     */ 
/*     */ 
/*     */         
/* 125 */         if (ti < this.firstTiles.length) {
/*     */           
/* 127 */           first = this.tiles[this.firstTiles[ti] & 0xFFFF];
/* 128 */           while (t != null) {
/*     */             
/* 130 */             Div other = GAME.ARMIES().division(t.divI);
/* 131 */             if (other.army() != current.army()) {
/* 132 */               currentOrder.engagements = (short)(currentOrder.engagements + 1);
/* 133 */               (this.statuses[other.index()]).engagements = (short)((this.statuses[other.index()]).engagements + 1);
/* 134 */               engaged = true;
/*     */               break;
/*     */             } 
/* 137 */             t = this.tiles[t.next & 0xFFFF];
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 142 */     this.firstTiles[tileI] = makeNewTile(this.firstTiles[tileI], current);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private short makeNewTile(short next, Div div) {
/* 149 */     short i = (short)this.tileNewI;
/* 150 */     Tile t = this.tiles[this.tileNewI & 0xFFFF];
/* 151 */     t.next = next;
/* 152 */     t.divI = div.index();
/* 153 */     this.tileNewI++;
/* 154 */     return i;
/*     */   }
/*     */   
/*     */   public Iterable<Div> get(LISTE<Div> res, int tx, int ty) {
/* 158 */     return get(res, tx, ty, 3);
/*     */   }
/*     */   
/*     */   public Iterable<Div> get(LISTE<Div> res, int tx, int ty, DIR d) {
/* 162 */     tx += d.x();
/* 163 */     ty += d.y();
/* 164 */     return get(res, tx, ty);
/*     */   }
/*     */   
/*     */   public Iterable<Div> getAlly(LISTE<Div> res, int tx, int ty, Army a) {
/* 168 */     return get(res, tx, ty, a.bit);
/*     */   }
/*     */   
/*     */   public Iterable<Div> getEnemy(LISTE<Div> res, int tx, int ty, Army a) {
/* 172 */     return get(res, tx, ty, a.bit ^ 0xFFFFFFFF);
/*     */   }
/*     */   
/*     */   public Div getEnemySingle(int tx, int ty, Army a) {
/* 176 */     return getSingle(tx, ty, a.bit ^ 0xFFFFFFFF);
/*     */   }
/*     */   
/*     */   public Div get(int tx, int ty, Army a) {
/* 180 */     return get(tx + ty * SETT.TWIDTH, a.bit);
/*     */   }
/*     */   
/*     */   public MAP_INT soldiers(Army a) {
/* 184 */     return (MAP_INT)this.soldiers[a.index()];
/*     */   }
/*     */   
/* 187 */   public DivsTileMap(DivStatus[] statuses) { this.hasEnemy = new MAP_OBJECT_ISSER<Army>()
/*     */       {
/*     */         public boolean is(int tile, Army value)
/*     */         {
/* 191 */           return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH, value);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty, Army value) {
/* 196 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 197 */             return false; 
/* 198 */           int tile = tx + ty * SETT.TWIDTH;
/* 199 */           return (DivsTileMap.this.soldiers[value.index() + 1 & 0x1].get(tile) > 0);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 204 */     this.hasAlly = new MAP_OBJECT_ISSER<Army>()
/*     */       {
/*     */         public boolean is(int tile, Army value)
/*     */         {
/* 208 */           return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH, value);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty, Army value) {
/* 213 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 214 */             return false; 
/* 215 */           int tile = tx + ty * SETT.TWIDTH;
/* 216 */           return (DivsTileMap.this.soldiers[value.index()].get(tile) > 0);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 221 */     this.hasOtherAlly = new MAP_OBJECT_ISSER<Div>()
/*     */       {
/*     */         public boolean is(int tileI, Div value)
/*     */         {
/* 225 */           DivsTileMap.Tile t = DivsTileMap.this.tiles[DivsTileMap.this.firstTiles[tileI] & 0xFFFF];
/* 226 */           while (t != null) {
/* 227 */             Div d = GAME.ARMIES().division(t.divI);
/* 228 */             if (d != value && d.army() == value.army())
/* 229 */               return true; 
/* 230 */             t = DivsTileMap.this.tiles[t.next & 0xFFFF];
/*     */           } 
/* 232 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty, Div value) {
/* 237 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 238 */             return false; 
/* 239 */           int tile = tx + ty * SETT.TWIDTH;
/* 240 */           return is(tile, value);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 245 */     this.isser = new MAP_OBJECT_ISSER<Div>()
/*     */       {
/*     */         public boolean is(int tileI, Div value)
/*     */         {
/* 249 */           DivsTileMap.Tile t = DivsTileMap.this.tiles[DivsTileMap.this.firstTiles[tileI] & 0xFFFF];
/* 250 */           while (t != null) {
/* 251 */             Div d = GAME.ARMIES().division(t.divI);
/* 252 */             if (d == value)
/* 253 */               return true; 
/* 254 */             t = DivsTileMap.this.tiles[t.next & 0xFFFF];
/*     */           } 
/* 256 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty, Div value) {
/* 261 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 262 */             return false; 
/* 263 */           int tile = tx + ty * SETT.TWIDTH;
/* 264 */           return is(tile, value); }
/*     */       };
/*     */     this.statuses = statuses;
/*     */     if ((Config.battle()).MEN_PER_ARMY * 2 > 65535)
/*     */       throw new RuntimeException("too many men in battle. This class must be fixed! Use ints"); 
/*     */     for (int i = 1; i < this.tiles.length; i++)
/* 270 */       this.tiles[i] = new Tile();  } private Iterable<Div> get(LISTE<Div> res, int tx, int ty, int aMask) { if (!SETT.IN_BOUNDS(tx, ty))
/* 271 */       return (Iterable<Div>)res; 
/* 272 */     int tileI = tx + ty * SETT.TWIDTH;
/* 273 */     return getMask(res, tileI, aMask); }
/*     */ 
/*     */   
/*     */   private Div getSingle(int tx, int ty, int aMask) {
/* 277 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 278 */       return null; 
/* 279 */     int tileI = tx + ty * SETT.TWIDTH;
/* 280 */     return getMaskSingle(tileI, aMask);
/*     */   }
/*     */   
/*     */   public Iterable<Div> get(LISTE<Div> res, int tileI) {
/* 284 */     return getMask(res, tileI, 3);
/*     */   }
/*     */   
/*     */   private Iterable<Div> getMask(LISTE<Div> res, int tileI, int aMask) {
/* 288 */     Tile t = this.tiles[this.firstTiles[tileI] & 0xFFFF];
/* 289 */     while (t != null && res.hasRoom()) {
/* 290 */       Div d = GAME.ARMIES().division(t.divI);
/* 291 */       if (((d.army()).bit & aMask) != 0)
/* 292 */         res.add(d); 
/* 293 */       t = this.tiles[t.next & 0xFFFF];
/*     */     } 
/* 295 */     return (Iterable<Div>)res;
/*     */   }
/*     */   
/*     */   private Div getMaskSingle(int tileI, int aMask) {
/* 299 */     Tile t = this.tiles[this.firstTiles[tileI] & 0xFFFF];
/* 300 */     while (t != null) {
/* 301 */       Div d = GAME.ARMIES().division(t.divI);
/* 302 */       if (((d.army()).bit & aMask) != 0)
/* 303 */         return d; 
/* 304 */       t = this.tiles[t.next & 0xFFFF];
/*     */     } 
/* 306 */     return null;
/*     */   }
/*     */   
/*     */   private Div get(int tileI, int aMask) {
/* 310 */     Tile t = this.tiles[this.firstTiles[tileI] & 0xFFFF];
/* 311 */     while (t != null) {
/* 312 */       Div d = GAME.ARMIES().division(t.divI);
/* 313 */       if (((d.army()).bit & aMask) != 0)
/* 314 */         return d; 
/* 315 */       t = this.tiles[t.next & 0xFFFF];
/*     */     } 
/* 317 */     return null;
/*     */   }
/*     */   
/*     */   void clear() {
/* 321 */     Arrays.fill(this.firstTiles, (short)0); byte b; int i; Bitsmap2D[] arrayOfBitsmap2D;
/* 322 */     for (i = (arrayOfBitsmap2D = this.soldiers).length, b = 0; b < i; ) { Bitsmap2D m = arrayOfBitsmap2D[b];
/* 323 */       m.clear(); b++; }
/* 324 */      this.tileNewI = 1;
/*     */   }
/*     */   
/*     */   private static final class Tile {
/*     */     private short next;
/*     */     private short divI;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\DivsTileMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */