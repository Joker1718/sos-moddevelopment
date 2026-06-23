/*     */ package settlement.room.main.furnisher;
/*     */ 
/*     */ import snake2d.util.sets.INDEXED;
/*     */ 
/*     */ public final class FurnisherItemGroup
/*     */   implements INDEXED {
/*     */   final FurnisherItem[][] items;
/*     */   public final CharSequence name;
/*     */   public final CharSequence desc;
/*     */   public final int max;
/*     */   public final int min;
/*     */   public final Furnisher blueprint;
/*     */   final double[] costs;
/*     */   final double[] stats;
/*     */   private final int index;
/*     */   
/*     */   FurnisherItemGroup(Furnisher b, int rots, CharSequence name, CharSequence desc, int min, int max, double[] costs, double[] stats) {
/*  18 */     if (rots >= 4) {
/*  19 */       throw new RuntimeException();
/*     */     }
/*  21 */     this.blueprint = b;
/*  22 */     if (FurnisherItem.itemsTmp.size() == 0)
/*  23 */       throw new RuntimeException("No items declared"); 
/*  24 */     this.costs = costs;
/*  25 */     this.stats = stats;
/*  26 */     this.name = name;
/*  27 */     this.desc = desc;
/*  28 */     this.items = new FurnisherItem[FurnisherItem.itemsTmp.size()][rots + 1];
/*  29 */     this.index = b.pgroups.add(this);
/*  30 */     this.max = max;
/*  31 */     this.min = min;
/*  32 */     for (int s = 0; s < FurnisherItem.itemsTmp.size(); s++) {
/*  33 */       FurnisherItem copy = (FurnisherItem)FurnisherItem.itemsTmp.get(s);
/*  34 */       FurnisherItem item = new FurnisherItem(s, copy.tiles, copy.multiplierStats, copy.multiplierCosts, this, b.allItems.size(), 0);
/*  35 */       b.allItems.add(item);
/*     */       
/*  37 */       this.items[s][0] = item;
/*  38 */       for (int r = 1; r <= rots; r++)
/*  39 */         this.items[s][r] = getRot(s, item, r); 
/*     */     } 
/*  41 */     FurnisherItem.itemsTmp.clear();
/*     */   }
/*     */   
/*     */   public CharSequence name() {
/*  45 */     return this.name;
/*     */   }
/*     */   
/*     */   public CharSequence desc() {
/*  49 */     return this.desc;
/*     */   }
/*     */ 
/*     */   
/*     */   private FurnisherItem getRot(int size, FurnisherItem other, int rot) {
/*  54 */     FurnisherItemTile[][] its = (FurnisherItemTile[][])other.tiles.clone();
/*     */     
/*  56 */     int r = rot;
/*  57 */     while (rot > 0) {
/*  58 */       its = rotate(its);
/*  59 */       rot--;
/*     */     } 
/*  61 */     FurnisherItem item = new FurnisherItem(size, its, other.multiplierStats, other.multiplierCosts, this, this.blueprint.allItems.size(), r);
/*     */     
/*  63 */     this.blueprint.allItems.add(item);
/*  64 */     return item;
/*     */   }
/*     */   
/*     */   private FurnisherItemTile[][] rotate(FurnisherItemTile[][] l) {
/*  68 */     int M = l.length;
/*  69 */     int N = (l[0]).length;
/*  70 */     FurnisherItemTile[][] ret = new FurnisherItemTile[N][M];
/*  71 */     for (int r = 0; r < M; r++) {
/*  72 */       for (int c = 0; c < N; c++) {
/*  73 */         ret[c][M - 1 - r] = l[r][c];
/*     */       }
/*     */     } 
/*  76 */     return ret;
/*     */   }
/*     */   
/*     */   public FurnisherItem item(int size, int rot) {
/*  80 */     return this.items[size][rot];
/*     */   }
/*     */   
/*     */   public int size() {
/*  84 */     return this.items.length;
/*     */   }
/*     */   
/*     */   public int rotations() {
/*  88 */     return (this.items[0]).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  93 */     return this.index;
/*     */   }
/*     */   
/*     */   public double cost(int ri, int upgrade) {
/*  97 */     return this.costs[ri] * this.blueprint.blue().upgrades().resMask(upgrade, ri);
/*     */   }
/*     */   
/*     */   public double stat(int si) {
/* 101 */     return this.stats[si];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherItemGroup.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */