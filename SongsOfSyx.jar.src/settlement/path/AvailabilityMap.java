/*     */ package settlement.path;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCOMPONENTS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.map.MAP_OBJECTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AvailabilityMap
/*     */   implements MAP_OBJECTE<AVAILABILITY>
/*     */ {
/*  16 */   private final byte[] costs = Alloc.bb(SETT.TAREA);
/*  17 */   int state = 0;
/*     */   private final SCOMPONENTS comps;
/*     */   
/*     */   public AvailabilityMap(SCOMPONENTS comps) {
/*  21 */     this.comps = comps;
/*  22 */     for (int i = SETT.TWIDTH * SETT.TWIDTH - 1; i >= 0; i--) {
/*  23 */       this.costs[i] = (byte)AVAILABILITY.NORMAL.ordinal();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY get(int tile) {
/*  29 */     return AVAILABILITY.values[this.costs[tile]];
/*     */   }
/*     */ 
/*     */   
/*     */   public AVAILABILITY get(int tx, int ty) {
/*  34 */     if (!SETT.IN_BOUNDS(tx, ty))
/*  35 */       return null; 
/*  36 */     return get(tx + ty * SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int tile, AVAILABILITY c) {
/*  41 */     AVAILABILITY old = get(tile);
/*  42 */     this.costs[tile] = (byte)c.ordinal();
/*  43 */     if (old.player == c.player) {
/*  44 */       int i = tile % SETT.TWIDTH;
/*  45 */       int j = tile / SETT.THEIGHT;
/*  46 */       if ((SETT.MAINTENANCE()).reservable.is(tile))
/*     */       {
/*  48 */         this.comps.updateAvailability(i, j);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*  53 */     this.state++;
/*  54 */     int x = tile % SETT.TWIDTH;
/*  55 */     int y = tile / SETT.THEIGHT;
/*  56 */     this.comps.updateAvailability(x, y);
/*  57 */     boolean change = (old.player * c.player < 0.0D);
/*  58 */     AvailabilityListener.notify(x, y, c, old, change);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int tx, int ty, AVAILABILITY object) {
/*  63 */     if (SETT.IN_BOUNDS(tx, ty))
/*  64 */       set(tx + ty * SETT.TWIDTH, object); 
/*     */   }
/*     */   
/*     */   void init() {
/*  68 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  69 */       this.costs[c.x() + c.y() * SETT.TWIDTH] = (byte)pget(c.x(), c.y()).ordinal();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private AVAILABILITY pget(int tx, int ty) {
/*  76 */     AVAILABILITY a = SETT.TERRAIN().get(tx, ty).getAvailability(tx, ty);
/*  77 */     if (a != null) {
/*  78 */       return a;
/*     */     }
/*  80 */     a = SETT.ROOMS().getAvailability(tx, ty);
/*  81 */     if (a != null) {
/*  82 */       return a;
/*     */     }
/*  84 */     a = SETT.FLOOR().getAvailability(tx, ty);
/*  85 */     if (a != null) {
/*  86 */       return a;
/*     */     }
/*  88 */     return AVAILABILITY.NORMAL;
/*     */   }
/*     */   
/*     */   public void updateAvailability(int tx, int ty) {
/*  92 */     set(tx, ty, pget(tx, ty));
/*     */   }
/*     */ 
/*     */   
/*     */   public int state() {
/*  97 */     return this.state;
/*     */   }
/*     */   
/*     */   public void updateService(int x, int y) {
/* 101 */     this.comps.updateService(x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\AvailabilityMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */