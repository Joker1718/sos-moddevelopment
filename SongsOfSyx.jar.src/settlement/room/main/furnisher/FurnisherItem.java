/*     */ package settlement.room.main.furnisher;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ 
/*     */ public final class FurnisherItem
/*     */   implements INDEXED, MAP_OBJECT<FurnisherItemTile> {
/*     */   final FurnisherItemTile[][] tiles;
/*     */   public final double multiplierStats;
/*     */   public final double multiplierCosts;
/*     */   final int id;
/*     */   private final int firstX;
/*     */   private final int firstY;
/*     */   public final FurnisherItemGroup group;
/*  21 */   static final ArrayList<FurnisherItem> itemsTmp = new ArrayList(127);
/*     */ 
/*     */   
/*     */   public final int area;
/*     */ 
/*     */   
/*     */   private final int[] brokenResourceAmount;
/*     */ 
/*     */   
/*     */   public final int rotation;
/*     */   
/*     */   final int size;
/*     */   
/*     */   private final int reachableTiles;
/*     */ 
/*     */   
/*     */   FurnisherItem(int size, FurnisherItemTile[][] its, double multiplierStats, double multiplierCosts, FurnisherItemGroup group, int index, int rot) {
/*  38 */     this.size = size;
/*  39 */     this.id = index;
/*  40 */     this.tiles = its;
/*  41 */     this.multiplierStats = multiplierStats;
/*  42 */     this.multiplierCosts = multiplierCosts;
/*  43 */     this.group = group;
/*  44 */     this.rotation = rot;
/*  45 */     int fx = -1;
/*  46 */     int fy = -1;
/*  47 */     int a = 0; int y;
/*  48 */     for (y = 0; y < its.length; y++) {
/*  49 */       for (int x = 0; x < (its[0]).length; x++) {
/*  50 */         if (this.tiles[y][x] != null && this.tiles[y][x].sprite() != null) {
/*  51 */           a++;
/*  52 */           if (fx == -1 && fy == -1) {
/*  53 */             fx = x;
/*  54 */             fy = y;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  60 */     if (fx == -1 || fy == -1) {
/*  61 */       for (y = 0; y < its.length; y++) {
/*  62 */         for (int x = 0; x < (its[0]).length; x++) {
/*  63 */           if (this.tiles[y][x] != null) {
/*  64 */             a++;
/*  65 */             if (fx == -1 && fy == -1) {
/*  66 */               fx = x;
/*  67 */               fy = y;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  74 */     if (fx == -1 || fy == -1) {
/*  75 */       throw new RuntimeException();
/*     */     }
/*     */     
/*  78 */     this.area = a;
/*  79 */     this.firstX = fx;
/*  80 */     this.firstY = fy;
/*     */ 
/*     */     
/*  83 */     if (group != null) {
/*  84 */       this.brokenResourceAmount = Alloc.ii(group.blueprint.resources());
/*  85 */       for (int j = 0; j < group.blueprint.resources(); j++) {
/*  86 */         this.brokenResourceAmount[j] = (int)Math.ceil(group.costs[j] * multiplierCosts / this.area);
/*     */       }
/*     */     } else {
/*  89 */       this.brokenResourceAmount = null;
/*     */     } 
/*     */     
/*  92 */     int re = 0;
/*  93 */     for (int i = 0; i < its.length; i++) {
/*  94 */       for (int x = 0; x < (its[0]).length; x++) {
/*  95 */         FurnisherItemTile t = get(x, i);
/*  96 */         if (t != null)
/*     */         {
/*  98 */           if (t.availability.player <= AVAILABILITY.ROOM.player) {
/*  99 */             re++;
/*     */           } else {
/* 101 */             for (DIR d : DIR.ORTHO) {
/* 102 */               t = (FurnisherItemTile)get(x, i, d);
/* 103 */               if (t == null || t.availability.player <= AVAILABILITY.ROOM.player) {
/* 104 */                 re++; break;
/*     */               } 
/*     */             } 
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 110 */     this.reachableTiles = re;
/*     */   }
/*     */ 
/*     */   
/*     */   public FurnisherItem(FurnisherItemTile[][] its, double multiplierCosts, double multiplierStats) {
/* 115 */     this(0, its, multiplierStats, multiplierCosts, (FurnisherItemGroup)null, 0, 0);
/* 116 */     itemsTmp.add(this);
/*     */   }
/*     */   
/*     */   public FurnisherItem(FurnisherItemTile[][] its, double multiplier) {
/* 120 */     this(its, multiplier, multiplier);
/*     */   }
/*     */   
/*     */   public int width() {
/* 124 */     return (this.tiles[0]).length;
/*     */   }
/*     */   
/*     */   public int height() {
/* 128 */     return this.tiles.length;
/*     */   }
/*     */   
/*     */   public int firstX() {
/* 132 */     return this.firstX;
/*     */   }
/*     */   
/*     */   public int firstY() {
/* 136 */     return this.firstY;
/*     */   }
/*     */   
/*     */   public FurnisherItemGroup group() {
/* 140 */     return this.group;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double cost2(int index, int upgrade) {
/* 148 */     return this.group.costs[index] * this.multiplierCosts * this.group.blueprint.blue().upgrades().resMask(upgrade, index);
/*     */   }
/*     */   
/*     */   public double costFlat(int index) {
/* 152 */     return this.group.costs[index] * this.multiplierCosts;
/*     */   }
/*     */   
/*     */   public double stat(FurnisherStat stat) {
/* 156 */     return this.group.stats[stat.index()] * this.multiplierStats;
/*     */   }
/*     */   
/*     */   public int brokenResourceAmount(int index) {
/* 160 */     return this.brokenResourceAmount[index];
/*     */   }
/*     */   
/*     */   public CharSequence placable(int tx1, int ty1) {
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 169 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public FurnisherItemTile get(int tile) {
/* 174 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public int reachableTiles() {
/* 178 */     return this.reachableTiles;
/*     */   }
/*     */ 
/*     */   
/*     */   public FurnisherItemTile get(int tx, int ty) {
/* 183 */     if (tx < 0 || tx >= width())
/* 184 */       return null; 
/* 185 */     if (ty < 0 || ty >= height())
/* 186 */       return null; 
/* 187 */     return this.tiles[ty][tx];
/*     */   }
/*     */   
/*     */   public RoomSprite sprite(int tx, int ty) {
/* 191 */     FurnisherItemTile t = get(tx, ty);
/* 192 */     if (t != null)
/* 193 */       return t.sprite(); 
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   public int variation() {
/* 198 */     return this.size;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherItem.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */