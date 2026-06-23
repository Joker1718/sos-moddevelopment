/*     */ package game.battle.thread.status;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ public final class DivStatus
/*     */   implements SAVABLE
/*     */ {
/*     */   byte enemyDirMask;
/*  19 */   double flanks = 0.0D;
/*  20 */   double encirclement = 0.0D;
/*  21 */   double enemyThreats = 0.0D;
/*  22 */   double friends = 0.0D;
/*  23 */   short engagements = 0;
/*     */   
/*     */   static final int iSize = 8;
/*  26 */   private static int iFriendlyColl = 0;
/*  27 */   private static int iEnemyColl = 8;
/*  28 */   private static int iEnemyInRange = 16;
/*  29 */   private static int iEnemyDist = 24;
/*  30 */   private static int iFriendlyInRange = 32;
/*  31 */   private static int iEnemyCharging = 40;
/*     */   
/*  33 */   final short[] lists = new short[iEnemyCharging + 8];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean threatAt(DIR d, Div div) {
/*  43 */     return !((GAME.ARMIES()).factors.projectiles(div) <= 0.0D && (this.enemyDirMask == 0 || (!threat(d) && !threat(d.next(-1)) && !threat(d.next(1)))));
/*     */   }
/*     */   
/*     */   public boolean threat(DIR d) {
/*  47 */     if (d.isOrtho()) {
/*  48 */       return ((this.enemyDirMask & d.mask()) != 0);
/*     */     }
/*  50 */     return ((this.enemyDirMask >> 4 & d.mask()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  56 */     file.ss(this.lists);
/*  57 */     file.b(this.enemyDirMask);
/*  58 */     file.d(this.flanks);
/*  59 */     file.d(this.enemyThreats);
/*  60 */     file.d(this.friends);
/*  61 */     file.s(this.engagements);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  66 */     file.ss(this.lists);
/*  67 */     this.enemyDirMask = file.b();
/*  68 */     this.flanks = file.d();
/*  69 */     this.enemyThreats = file.d();
/*  70 */     this.friends = file.d();
/*  71 */     this.engagements = file.s();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  76 */     Arrays.fill(this.lists, (short)-1);
/*  77 */     this.enemyDirMask = 0;
/*  78 */     this.flanks = 0.0D;
/*  79 */     this.enemyThreats = 0.0D;
/*  80 */     this.friends = 0.0D;
/*  81 */     this.engagements = 0;
/*     */   }
/*     */   
/*     */   public LIST<Div> friendlyCollisions(LISTE<Div> res) {
/*  85 */     return fill(iFriendlyColl, res);
/*     */   }
/*     */   
/*     */   public int friendlyCollisions() {
/*  89 */     return count(iFriendlyColl);
/*     */   }
/*     */   
/*     */   void friendlyCollisionSet(short di) {
/*  93 */     set(iFriendlyColl, di);
/*     */   }
/*     */   
/*     */   public LIST<Div> enemyCollisions(LISTE<Div> res) {
/*  97 */     return fill(iEnemyColl, res);
/*     */   }
/*     */   
/*     */   public int enemyCollisions() {
/* 101 */     return count(iEnemyColl);
/*     */   }
/*     */   
/*     */   void enemyCollisionSet(short di) {
/* 105 */     set(iEnemyColl, di);
/*     */   }
/*     */   
/*     */   public LIST<Div> enemiesClosest(LISTE<Div> res) {
/* 109 */     return fill(iEnemyInRange, res);
/*     */   }
/*     */   
/*     */   public int enemiesClosest() {
/* 113 */     return count(iEnemyInRange);
/*     */   }
/*     */   
/*     */   public Div enemyClosest() {
/* 117 */     return getFirst(iEnemyInRange);
/*     */   }
/*     */   
/*     */   public int enemyClosestDist() {
/* 121 */     return this.lists[iEnemyDist];
/*     */   }
/*     */   
/*     */   public int enemyClosestDist(int i) {
/* 125 */     return this.lists[iEnemyDist + i];
/*     */   }
/*     */   
/*     */   void enemiesClosestSet(short di, int tiles) {
/* 129 */     set(iEnemyInRange, di);
/* 130 */     set(iEnemyDist, (short)(tiles & 0xFFFF));
/*     */   }
/*     */   
/*     */   public LIST<Div> friendlyClosest(LISTE<Div> res) {
/* 134 */     return fill(iFriendlyInRange, res);
/*     */   }
/*     */   
/*     */   public int friendlyClosest() {
/* 138 */     return count(iFriendlyInRange);
/*     */   }
/*     */   
/*     */   void friendlyClosestSet(short di) {
/* 142 */     set(iFriendlyInRange, di);
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(int start, short di) {
/* 147 */     if (this.lists[start + 8 - 1] != -1)
/*     */       return; 
/* 149 */     for (int i = 0; i < 8; i++) {
/* 150 */       int k = i + start;
/* 151 */       if (this.lists[k] == -1) {
/* 152 */         this.lists[k] = di;
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private int count(int start) {
/* 159 */     for (int i = 0; i < 8; i++) {
/* 160 */       int k = i + start;
/* 161 */       if (this.lists[k] == -1)
/* 162 */         return i; 
/*     */     } 
/* 164 */     return 8;
/*     */   }
/*     */   
/*     */   private LIST<Div> fill(int start, LISTE<Div> res) {
/* 168 */     for (int i = 0; i < 8; i++) {
/* 169 */       int k = i + start;
/* 170 */       if (this.lists[k] == -1)
/* 171 */         return (LIST<Div>)res; 
/* 172 */       res.add(GAME.ARMIES().division(this.lists[k]));
/* 173 */       if (!res.hasRoom())
/* 174 */         return (LIST<Div>)res; 
/*     */     } 
/* 176 */     return (LIST<Div>)res;
/*     */   }
/*     */   
/*     */   private Div getFirst(int start) {
/* 180 */     if (this.lists[start] == -1)
/* 181 */       return null; 
/* 182 */     return GAME.ARMIES().division(this.lists[start]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFighting() {
/* 187 */     return (this.engagements > 0);
/*     */   }
/*     */   
/*     */   public double ajacentFriendsPower() {
/* 191 */     return this.friends;
/*     */   }
/*     */   
/*     */   public double ajacentEnemiesPower() {
/* 195 */     return this.enemyThreats;
/*     */   }
/*     */   
/*     */   public double encirclementPower() {
/* 199 */     return this.encirclement;
/*     */   }
/*     */   
/*     */   public int engagements() {
/* 203 */     return this.engagements;
/*     */   }
/*     */   
/*     */   public double flanks() {
/* 207 */     return this.flanks;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\DivStatus.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */