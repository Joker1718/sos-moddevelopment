/*     */ package settlement.entity.animal.spawning;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import util.GUTIL;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ public final class AnimalSpawnSpot
/*     */   implements COORDINATE, INDEXED
/*     */ {
/*     */   public static final int MAX = 64;
/*     */   private final int index;
/*     */   private int cx;
/*     */   private int cy;
/*     */   private int am;
/*     */   private int max;
/*     */   private int si;
/*     */   boolean blocked;
/*     */   private double timer;
/*     */   
/*     */   AnimalSpawnSpot(int index) {
/*  30 */     this.index = index;
/*  31 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  36 */     return this.cx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  41 */     return this.cy;
/*     */   }
/*     */   
/*     */   public int max() {
/*  45 */     return this.max;
/*     */   }
/*     */   
/*     */   public int current() {
/*  49 */     return this.am;
/*     */   }
/*     */   
/*     */   public AnimalSpecies species() {
/*  53 */     return (AnimalSpecies)(SETT.ANIMALS()).species.get(this.si);
/*     */   }
/*     */   
/*     */   public boolean active() {
/*  57 */     return (this.cx > 0 && this.cy > 0 && !this.blocked);
/*     */   }
/*     */   
/*     */   public boolean blocked() {
/*  61 */     return this.blocked;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  66 */     return this.index;
/*     */   }
/*     */   
/*     */   public void deregisterAnimal() {
/*  70 */     this.am--;
/*  71 */     this.am = CLAMP.i(this.am, 0, this.max);
/*     */   }
/*     */   
/*     */   void init(int cx, int cy, int max, AnimalSpecies s) {
/*  75 */     this.cy = cy;
/*  76 */     this.cx = cx;
/*  77 */     this.max = max;
/*  78 */     this.am = max;
/*  79 */     this.si = s.index();
/*     */   }
/*     */   
/*     */   void save(FilePutter f) {
/*  83 */     f.i(this.cx);
/*  84 */     f.i(this.cy);
/*  85 */     f.i(this.am);
/*  86 */     f.i(this.max);
/*  87 */     (SETT.ANIMALS()).map.saver().save((MAPPED)species(), f);
/*  88 */     f.d(this.timer);
/*  89 */     f.bool(this.blocked);
/*     */   }
/*     */   
/*     */   void load(FileGetter f) throws IOException {
/*  93 */     this.cx = f.i();
/*  94 */     this.cy = f.i();
/*  95 */     this.am = f.i();
/*  96 */     this.max = f.i();
/*  97 */     this.si = ((AnimalSpecies)(SETT.ANIMALS()).map.loader().loadB(f, null)).index();
/*  98 */     this.timer = f.d();
/*  99 */     this.blocked = f.bool();
/*     */   }
/*     */   
/*     */   void clear() {
/* 103 */     this.cx = -1;
/* 104 */     this.cy = -1;
/* 105 */     this.am = 0;
/* 106 */     this.max = 0;
/* 107 */     this.si = 0;
/* 108 */     this.timer = 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     return String.valueOf((species()).name) + " " + String.valueOf((species()).name) + " " + this.max + " " + active();
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double rate) {
/* 118 */     this.blocked = false;
/* 119 */     if (!active())
/*     */       return; 
/* 121 */     this.blocked = checkBlocked();
/*     */     
/* 123 */     if (this.blocked) {
/*     */       return;
/*     */     }
/*     */     
/* 127 */     int m = GUTIL.coos().getI();
/* 128 */     GUTIL.coos().shuffle(m);
/*     */     
/* 130 */     this.timer += rate * this.max;
/* 131 */     for (int i = 0; i < m && this.timer >= 1.0D && this.am < this.max; i++) {
/* 132 */       GUTIL.coos().set(i);
/* 133 */       int ax = GUTIL.coos().get().x() * 64 + 32;
/* 134 */       int ay = GUTIL.coos().get().y() * 64 + 32;
/* 135 */       if (SETT.ANIMALS().isPlacable(species(), ax, ay)) {
/* 136 */         Animal a = new Animal(ax, ay, species(), this);
/* 137 */         if (!a.isRemoved()) {
/* 138 */           this.am++;
/* 139 */           this.timer--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 144 */     this.timer -= (int)this.timer;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkBlocked() {
/*     */     int i;
/* 150 */     this.blocked = true;
/* 151 */     int x1 = x() - 4;
/* 152 */     int y1 = y() - 4;
/* 153 */     int x2 = x1 + 8;
/* 154 */     int y2 = y1 + 8;
/*     */     
/* 156 */     GUTIL.coos().set(0);
/*     */     
/* 158 */     boolean any = false;
/*     */     
/* 160 */     for (int y = y1; y < y2; y++) {
/* 161 */       for (int x = x1; x < x2; x++) {
/* 162 */         if (SETT.IN_BOUNDS(x, y)) {
/*     */ 
/*     */           
/* 165 */           if ((SETT.ROOMS()).map.is(x, y))
/* 166 */             return true; 
/* 167 */           if ((SETT.FLOOR()).getter.is(x, y))
/* 168 */             return true; 
/* 169 */           if (SETT.TERRAIN().get(x, y) instanceof settlement.tilemap.terrain.TBuilding.BuildingComponent)
/* 170 */             return true; 
/* 171 */           i = any | ((SETT.PATH()).solidity.is(x, y) ? 0 : 1);
/* 172 */           GUTIL.coos().get().set(x, y);
/* 173 */           GUTIL.coos().inc();
/*     */         } 
/*     */       } 
/* 176 */     }  return !(i != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\spawning\AnimalSpawnSpot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */