/*     */ package game.battle.thread.status;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import snake2d.CircleCooIterator;
/*     */ import snake2d.util.map.MAP_OBJECT_ISSER;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DivsQuadMap
/*     */ {
/*     */   public static final int size = 32;
/*  25 */   private final QDiv[][] map = new QDiv[SETT.TWIDTH / 32][SETT.THEIGHT / 32];
/*  26 */   private final Bitsmap1D artillery = new Bitsmap1D(0, 2, this.map.length * (this.map[0]).length);
/*  27 */   private final QDiv[] free = new QDiv[(Config.battle()).DIVISIONS_PER_BATTLE];
/*  28 */   private final CircleCooIterator iter = new CircleCooIterator((int)Math.ceil(Math.sqrt(((this.map[0]).length * (this.map[0]).length + this.map.length * this.map.length))), GUTIL.flooder());
/*  29 */   private int freeI = 0;
/*  30 */   private static final int add_scroll = Integer.numberOfTrailingZeros(2048);
/*  31 */   private static final int a_scroll = Integer.numberOfTrailingZeros(32);
/*  32 */   private final Tree<QDiv> sort = new Tree<QDiv>(this.free.length)
/*     */     {
/*     */       protected boolean isGreaterThan(DivsQuadMap.QDiv current, DivsQuadMap.QDiv cmp)
/*     */       {
/*  36 */         return (current.dist > cmp.dist);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_OBJECT_ISSER<Army> ART;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void add(Div div, int pcx, int pcy) {
/*  51 */     pcx >>= add_scroll;
/*  52 */     if (pcx < 0 || pcx >= (this.map[0]).length) {
/*     */       return;
/*     */     }
/*  55 */     pcy >>= add_scroll;
/*  56 */     if (pcy < 0 || pcy >= this.map.length) {
/*     */       return;
/*     */     }
/*  59 */     QDiv old = this.map[pcy][pcx];
/*  60 */     QDiv n = this.free[this.freeI];
/*  61 */     this.freeI++;
/*  62 */     n.next = old;
/*  63 */     n.divI = div.index();
/*  64 */     this.map[pcy][pcx] = n; } void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     QDiv[][] arrayOfQDiv;
/*  68 */     for (i = (arrayOfQDiv = this.map).length, b = 0; b < i; ) { QDiv[] qq = arrayOfQDiv[b];
/*  69 */       Arrays.fill((Object[])qq, (Object)null); b++; }
/*  70 */      this.artillery.clear();
/*  71 */     this.freeI = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getNearest(LISTE<Div> res, int px, int py, int pixelDistance, Army target, Div self) {
/*  76 */     if (!res.hasRoom()) {
/*     */       return;
/*     */     }
/*  79 */     int fx = px;
/*  80 */     int fy = py;
/*     */     
/*  82 */     px >>= add_scroll;
/*  83 */     py >>= add_scroll;
/*     */ 
/*     */     
/*  86 */     int ra = (int)Math.ceil(pixelDistance / 2048.0D);
/*  87 */     ra = CLAMP.i(ra, 0, this.iter.radius(this.iter.length() - 1));
/*  88 */     this.sort.clear();
/*     */     
/*  90 */     int rac = 0;
/*  91 */     int i = 0;
/*  92 */     while (this.iter.radius(i) <= ra) {
/*  93 */       if (rac != this.iter.radius(i)) {
/*  94 */         while (this.sort.hasMore() && res.hasRoom()) {
/*  95 */           res.add(GAME.ARMIES().divisions().get(((QDiv)this.sort.pollSmallest()).divI));
/*     */         }
/*  97 */         if (!res.hasRoom())
/*     */           return; 
/*  99 */         rac = this.iter.radius(i);
/*     */       } 
/* 101 */       int dx = this.iter.get(i).x();
/* 102 */       int dy = this.iter.get(i).y();
/* 103 */       i++;
/* 104 */       int pcx = px + dx;
/* 105 */       if (pcx < 0 || pcx >= (this.map[0]).length) {
/*     */         continue;
/*     */       }
/* 108 */       int pcy = py + dy;
/* 109 */       if (pcy < 0 || pcy >= this.map.length) {
/*     */         continue;
/*     */       }
/* 112 */       QDiv f = this.map[pcy][pcx];
/* 113 */       while (f != null) {
/* 114 */         Div d = (Div)GAME.ARMIES().divisions().get(f.divI);
/* 115 */         if (d != self && d.army() == target) {
/* 116 */           int xx = d.centre().cUnitX() - fx;
/* 117 */           int yy = d.centre().cUnitY() - fy;
/* 118 */           int dist = (int)Math.sqrt((xx * xx + yy * yy));
/* 119 */           if (dist < pixelDistance) {
/* 120 */             f.dist = dist;
/* 121 */             this.sort.add(f);
/*     */           } 
/*     */         } 
/* 124 */         f = f.next;
/*     */       } 
/*     */     } 
/*     */     
/* 128 */     while (this.sort.hasMore() && res.hasRoom()) {
/* 129 */       res.add(GAME.ARMIES().divisions().get(((QDiv)this.sort.pollSmallest()).divI));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void getInQuad(LISTE<Div> res, int tx, int ty, Army target) {
/* 135 */     tx >>= a_scroll;
/* 136 */     ty >>= a_scroll;
/* 137 */     QDiv f = this.map[ty][tx];
/* 138 */     while (f != null && res.hasRoom()) {
/* 139 */       Div d = (Div)GAME.ARMIES().divisions().get(f.divI);
/* 140 */       if (d.army() == target) {
/* 141 */         res.add(d);
/*     */       }
/* 143 */       f = f.next;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final class QDiv {
/*     */     private int dist;
/*     */     private QDiv next;
/*     */     private short divI; }
/*     */   
/*     */   public DivsQuadMap() {
/* 153 */     this.ART = new MAP_OBJECT_ISSER<Army>()
/*     */       {
/*     */         public boolean is(int tile, Army value)
/*     */         {
/* 157 */           return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH, value);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty, Army value) {
/* 162 */           tx >>= DivsQuadMap.a_scroll;
/* 163 */           ty >>= DivsQuadMap.a_scroll;
/* 164 */           return ((DivsQuadMap.this.artillery.get(tx + ty * (DivsQuadMap.this.map[0]).length) & value.bit) != 0);
/*     */         }
/*     */       };
/*     */     for (int i = 0; i < this.free.length; i++) {
/*     */       this.free[i] = new QDiv();
/*     */     }
/*     */   }
/*     */   
/*     */   void addArtillery(ArtilleryInstance ins) {
/* 173 */     int tx = ins.body().cX();
/* 174 */     int ty = ins.body().cY();
/* 175 */     tx >>= a_scroll;
/* 176 */     ty >>= a_scroll;
/* 177 */     int i = this.artillery.get(tx + ty * (this.map[0]).length);
/* 178 */     i |= (ins.army()).bit;
/* 179 */     this.artillery.set(tx + ty * (this.map[0]).length, i);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\DivsQuadMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */