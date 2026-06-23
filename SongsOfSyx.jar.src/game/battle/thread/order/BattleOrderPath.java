/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.C;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ public final class BattleOrderPath
/*     */   implements COORDINATE, SAVABLE, Copyable<BattleOrderPath>
/*     */ {
/*     */   public static final int size = 128;
/*  22 */   private static final VectorImp vec = new VectorImp();
/*     */   
/*  24 */   private final int[] coos = Alloc.ii(256);
/*  25 */   private int current = 0;
/*  26 */   private int length = 0;
/*  27 */   private final Coo finalDest = new Coo(-1.0D, -1.0D);
/*     */   private boolean isComplete;
/*  29 */   private int tilesToDest = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public int dCount;
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  38 */     file.is(this.coos);
/*  39 */     file.i(this.current);
/*  40 */     file.i(this.length);
/*  41 */     this.finalDest.save(file);
/*  42 */     file.bool(this.isComplete);
/*  43 */     file.i(this.tilesToDest);
/*  44 */     file.i(this.dCount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  49 */     file.is(this.coos);
/*  50 */     this.current = file.i();
/*  51 */     this.length = file.i();
/*  52 */     this.finalDest.load(file);
/*  53 */     this.isComplete = file.bool();
/*  54 */     this.tilesToDest = file.i();
/*  55 */     this.dCount = file.i();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  60 */     this.current = 0;
/*  61 */     this.length = 0;
/*  62 */     this.finalDest.set(-1.0D, -1.0D);
/*  63 */     this.tilesToDest = 0;
/*  64 */     this.dCount = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  69 */     return this.coos[this.current];
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  74 */     return this.coos[this.current + 128];
/*     */   }
/*     */   
/*     */   private boolean canWalkTheLine2(int sx, int sy, int dx, int dy, double max, PathCost cost, Army a, Race race) {
/*  78 */     double c = 0.0D;
/*  79 */     double l = vec.set(sx, sy, dx, dy);
/*  80 */     int steps = (int)Math.abs(l / 64.0D);
/*  81 */     for (int i = 1; i <= steps; i++) {
/*  82 */       int x = (int)(sx + (i * 64) * vec.nX());
/*  83 */       int y = (int)(sy + (i * 64) * vec.nY());
/*  84 */       if (DivPlacability.pixelIsBlocked(x, y, 64, a))
/*  85 */         return false; 
/*  86 */       if (i < steps) {
/*  87 */         int nx = (int)(sx + ((i + 1) * 64) * vec.nX());
/*  88 */         int ny = (int)(sy + ((i + 1) * 64) * vec.nY());
/*  89 */         if (!DivPlacability.checkPixelStep(x, y, nx, ny, race, a))
/*  90 */           return false; 
/*     */       } 
/*  92 */       c += getCost(x, y, cost);
/*  93 */       if (c > max) {
/*  94 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(int startPX, int startPY, PathGame.PathFancy p, int ftDestX, int ftDestY, PathCost cost, Army a, Race race) {
/* 107 */     this.finalDest.set(ftDestX, ftDestY);
/* 108 */     this.coos[0] = startPX;
/* 109 */     this.coos[128] = startPY;
/* 110 */     this.length = 1;
/* 111 */     this.current = 0;
/* 112 */     int currentI = 0;
/* 113 */     if (p.hasNext()) {
/* 114 */       p.setNext();
/* 115 */       int distance = 1;
/*     */ 
/*     */       
/* 118 */       while (++currentI < 128) {
/* 119 */         int sx = this.coos[currentI - 1];
/* 120 */         int sy = this.coos[currentI - 1 + 128];
/* 121 */         double costt = getCost(sx, sy, cost);
/* 122 */         while (p.hasNext() && distance < 32) {
/* 123 */           int px = p.x();
/* 124 */           int py = p.y();
/* 125 */           p.setNext();
/* 126 */           int i = (p.x() << 6) + 32;
/* 127 */           int j = (p.y() << 6) + 32;
/* 128 */           costt += getCost(i, j, cost) * ((px != p.x() && py != p.y()) ? C.SQR2 : 1.0D);
/*     */           
/* 130 */           if (!canWalkTheLine2(sx, sy, i, j, costt, cost, a, race)) {
/* 131 */             p.setPrev();
/*     */             
/*     */             break;
/*     */           } 
/* 135 */           distance++;
/*     */         } 
/* 137 */         int dx = (p.x() << 6) + 32;
/* 138 */         int dy = (p.y() << 6) + 32;
/* 139 */         double d = vec.set(sx, sy, dx, dy);
/* 140 */         this.length++;
/* 141 */         if (d < 96.0D) {
/* 142 */           this.coos[currentI] = dx;
/* 143 */           this.coos[currentI + 128] = dy;
/* 144 */           if (!p.hasNext())
/*     */             break; 
/* 146 */           p.setNext();
/*     */         } else {
/* 148 */           this.coos[currentI] = (int)(sx + vec.nX() * 64.0D);
/* 149 */           this.coos[currentI + 128] = (int)(sy + vec.nY() * 64.0D);
/*     */         } 
/* 151 */         if (distance > 0) {
/* 152 */           distance--;
/*     */         }
/*     */       } 
/*     */     } 
/* 156 */     setCurrentI(this.length - 1);
/*     */     
/* 158 */     setCurrentI(0);
/*     */     
/* 160 */     this.current = 0;
/*     */     
/* 162 */     this.isComplete = (p.isCompleate() && this.length < 128);
/*     */     
/* 164 */     this.tilesToDest = p.lengthTotal() - p.getCurrentI() + length();
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 169 */     return this.length;
/*     */   }
/*     */   
/*     */   public int currentI() {
/* 173 */     return this.current;
/*     */   }
/*     */   
/*     */   public void setCurrentI(int i) {
/* 177 */     if (i < 0 || i >= this.length)
/* 178 */       throw new RuntimeException("" + i + " " + i); 
/* 179 */     this.current = i;
/*     */   }
/*     */   
/*     */   public void currentIInc(int d) {
/* 183 */     setCurrentI(this.current + d);
/*     */   }
/*     */   
/*     */   public boolean isDest() {
/* 187 */     return (this.current >= this.length - 1);
/*     */   }
/*     */   
/*     */   public COORDINATE finalTDest() {
/* 191 */     return (COORDINATE)this.finalDest;
/*     */   }
/*     */   
/*     */   public boolean isComplete() {
/* 195 */     return this.isComplete;
/*     */   }
/*     */   
/*     */   public int tilesToDest() {
/* 199 */     return this.tilesToDest - currentI();
/*     */   }
/*     */ 
/*     */   
/*     */   public void copy(BattleOrderPath toBeCopied) {
/* 204 */     for (int i = 0; i < this.coos.length; i++) {
/* 205 */       this.coos[i] = toBeCopied.coos[i];
/*     */     }
/* 207 */     this.current = toBeCopied.current;
/* 208 */     this.length = toBeCopied.length;
/* 209 */     this.tilesToDest = toBeCopied.tilesToDest;
/* 210 */     this.finalDest.set((COORDINATE)toBeCopied.finalDest);
/* 211 */     this.isComplete = toBeCopied.isComplete;
/* 212 */     this.current = toBeCopied.current;
/* 213 */     this.dCount = toBeCopied.dCount;
/*     */   }
/*     */ 
/*     */   
/*     */   private static double getCost(int x1, int y1, PathCost m) {
/* 218 */     return m.cost(x1 >> 6, y1 >> 6);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\BattleOrderPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */