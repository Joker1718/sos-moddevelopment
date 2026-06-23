/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.MapDataF;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ final class UtilStats
/*     */ {
/*  18 */   private double[] stats = new double[8];
/*  19 */   private double[] statsR = new double[8];
/*  20 */   private double[] needed = new double[8];
/*  21 */   private double[] allocated = new double[8];
/*  22 */   private double[] resRemoved = new double[8];
/*  23 */   private int[] placedGroups = Alloc.ii(16);
/*     */   private final RoomPlacer p;
/*     */   int walls;
/*     */   int items;
/*  27 */   private int tick = -1;
/*     */   UtilStats(RoomPlacer p) {
/*  29 */     this.p = p;
/*     */   }
/*     */   
/*     */   public int needed(int ri) {
/*  33 */     update();
/*  34 */     return (int)Math.ceil(this.needed[ri]);
/*     */   }
/*     */   
/*     */   public int allocated(int ri) {
/*  38 */     update();
/*  39 */     return (int)Math.round(this.allocated[ri]);
/*     */   }
/*     */   
/*     */   public double stat(int si) {
/*  43 */     update();
/*  44 */     return this.statsR[si];
/*     */   }
/*     */   
/*     */   public int groups(FurnisherItemGroup g) {
/*  48 */     update();
/*  49 */     return this.placedGroups[g.index()];
/*     */   }
/*     */   
/*     */   void removeTile(int tx, int ty) {
/*  53 */     (SETT.FLOOR()).clearer.clear(tx, ty);
/*  54 */     for (int i = 0; i < this.p.blueprint().constructor().resources(); i++) {
/*  55 */       this.resRemoved[i] = this.resRemoved[i] + this.p.blueprint().constructor().areaCost(i, this.p.instance.upgrade()) * 0.75D;
/*  56 */       if (this.resRemoved[i] >= 1.0D) {
/*  57 */         (SETT.THINGS()).resources.create(tx, ty, this.p.blueprint().constructor().resource(i), (int)this.resRemoved[i]);
/*  58 */         GAME.player().res().inc(this.p.blueprint().constructor().resource(i), FResources.RTYPE.CONSTRUCTION, (int)this.resRemoved[i]);
/*  59 */         this.resRemoved[i] = this.resRemoved[i] - (int)this.resRemoved[i];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void removeItem(int tx, int ty, FurnisherItem it) {
/*  66 */     for (int i = 0; i < this.p.blueprint().constructor().resources(); i++) {
/*  67 */       this.resRemoved[i] = this.resRemoved[i] + it.cost2(i, this.p.instance.upgrade()) * 0.75D;
/*  68 */       if (this.resRemoved[i] >= 1.0D) {
/*  69 */         (SETT.THINGS()).resources.create(tx, ty, this.p.blueprint().constructor().resource(i), (int)this.resRemoved[i]);
/*  70 */         GAME.player().res().inc(this.p.blueprint().constructor().resource(i), FResources.RTYPE.CONSTRUCTION, (int)this.resRemoved[i]);
/*  71 */         this.resRemoved[i] = this.resRemoved[i] - (int)this.resRemoved[i];
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void updatee() {
/*  77 */     this.tick = GAME.updateI() - 1;
/*  78 */     update();
/*     */   }
/*     */   
/*     */   private void update() {
/*  82 */     if (this.tick == GAME.updateI()) {
/*     */       return;
/*     */     }
/*  85 */     this.tick = GAME.updateI();
/*  86 */     this.items = 0;
/*  87 */     if (this.p.blueprint() == null)
/*     */       return; 
/*  89 */     Furnisher b = this.p.blueprint().constructor();
/*  90 */     if (b == null) {
/*  91 */       GAME.Notify("? " + String.valueOf((this.p.blueprint()).info.name));
/*     */     }
/*  93 */     MapDataF d = (SETT.ROOMS()).fData;
/*  94 */     Instance instance = this.p.instance;
/*     */     int i;
/*  96 */     for (i = 0; i < this.needed.length; i++) {
/*  97 */       this.needed[i] = 0.0D;
/*  98 */       this.stats[i] = 0.0D;
/*  99 */       this.allocated[i] = 0.0D;
/* 100 */       this.statsR[i] = 0.0D;
/*     */     } 
/* 102 */     for (i = 0; i < this.placedGroups.length; i++) {
/* 103 */       this.placedGroups[i] = 0;
/*     */     }
/* 105 */     this.walls = this.p.autoWalls.is() ? this.p.door.getWalls() : 0;
/* 106 */     int floored = 0;
/* 107 */     for (COORDINATE c : instance.body()) {
/* 108 */       if (!instance.is(c))
/*     */         continue; 
/* 110 */       if (ConstructionData.dFloored.is(c, 1)) {
/* 111 */         floored++;
/*     */       }
/* 113 */       if (d.isMaster.is(c)) {
/* 114 */         this.items++;
/* 115 */         FurnisherItem it = (FurnisherItem)d.item.get(c);
/* 116 */         if (it == null) {
/* 117 */           System.err.println(String.valueOf((this.p.blueprint()).info.name) + " " + String.valueOf((this.p.blueprint()).info.name));
/*     */         }
/*     */ 
/*     */         
/* 121 */         this.placedGroups[it.group().index()] = this.placedGroups[it.group().index()] + 1;
/* 122 */         for (int k = 0; k < b.resources(); k++) {
/* 123 */           this.needed[k] = this.needed[k] + it.cost2(k, this.p.instance.upgrade());
/* 124 */           if (ConstructionData.dConstructed.is(c, 1) && ConstructionData.dBroken.is(c, 0))
/* 125 */             this.allocated[k] = this.allocated[k] + it.cost2(k, this.p.instance.upgrade()); 
/*     */         } 
/* 127 */         for (FurnisherStat s : b.stats()) {
/* 128 */           this.stats[s.index()] = this.stats[s.index()] + it.stat(s);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     for (int j = 0; j < b.resources(); j++) {
/*     */       
/* 135 */       this.allocated[j] = (int)Math.ceil(this.allocated[j]);
/*     */       
/* 137 */       this.needed[j] = this.needed[j] + Math.ceil(instance.area() * b.areaCost(j, this.p.instance.upgrade()));
/*     */       
/* 139 */       this.allocated[j] = this.allocated[j] + Math.ceil(floored * b.areaCost(j, this.p.instance.upgrade()));
/*     */     } 
/* 141 */     for (FurnisherStat s : b.stats())
/* 142 */       this.statsR[s.index()] = s.get((AREA)instance, this.stats); 
/*     */   }
/*     */   
/*     */   public void clear() {
/*     */     int i;
/* 147 */     for (i = 0; i < this.needed.length; i++) {
/* 148 */       this.needed[i] = 0.0D;
/* 149 */       this.stats[i] = 0.0D;
/* 150 */       this.allocated[i] = 0.0D;
/* 151 */       this.resRemoved[i] = 0.0D;
/* 152 */       this.statsR[i] = 0.0D;
/*     */     } 
/* 154 */     for (i = 0; i < this.placedGroups.length; i++)
/* 155 */       this.placedGroups[i] = 0; 
/* 156 */     this.items = 0;
/*     */   }
/*     */   
/*     */   public double statIncr(FurnisherItem it, FurnisherStat s) {
/* 160 */     double pp = this.stats[s.index()];
/* 161 */     double old = this.statsR[s.index()];
/* 162 */     this.stats[s.index()] = this.stats[s.index()] + it.stat(s);
/* 163 */     double n = s.get((AREA)this.p.instance, this.stats);
/* 164 */     this.stats[s.index()] = pp;
/* 165 */     return n - old;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilStats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */