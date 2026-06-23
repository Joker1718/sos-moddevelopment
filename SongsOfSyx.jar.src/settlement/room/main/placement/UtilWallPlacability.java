/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import settlement.job.Job;
/*     */ import settlement.job.JobBuildStructure;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UtilWallPlacability
/*     */ {
/*  20 */   public static final MAP_BOOLEAN openingIsReal = new MAP_BOOLEAN()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  24 */         return (SETT.IN_BOUNDS(tx, ty) && !(SETT.ROOMS()).map.is(tx, ty) && UtilWallPlacability.get(tx, ty).roofIs());
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/*  29 */         return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */     };
/*     */   
/*  33 */   public static final MAP_BOOLEAN openingCanBe = new MAP_BOOLEAN()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  37 */         if (UtilWallPlacability.openingIsReal.is(tx, ty))
/*  38 */           return true; 
/*  39 */         if ((SETT.TERRAIN()).MOUNTAIN.is(tx, ty)) {
/*  40 */           return (UtilWallPlacability.placable((SETT.JOBS()).clearss.tunnel, tx, ty) == null);
/*     */         }
/*  42 */         return (UtilWallPlacability.placable(((JobBuildStructure)(SETT.JOBS()).build_structure.get(0)).ceiling, tx, ty) == null);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/*  47 */         return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */     };
/*     */   
/*  51 */   public static final MAP_BOOLEAN openingShouldBuild = new MAP_BOOLEAN()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  55 */         if (UtilWallPlacability.openingIsReal.is(tx, ty))
/*  56 */           return false; 
/*  57 */         return UtilWallPlacability.openingCanBe.is(tx, ty);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/*  62 */         return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */     };
/*     */   
/*  66 */   public static final MAP_BOOLEAN wallisReal = new MAP_BOOLEAN()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  70 */         return (SETT.IN_BOUNDS(tx, ty) && !(SETT.ROOMS()).map.is(tx, ty) && UtilWallPlacability.get(tx, ty).isMassiveWall());
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/*  75 */         return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */     };
/*     */   
/*  79 */   public static final MAP_BOOLEAN wallCanBe = new MAP_BOOLEAN()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  83 */         if (UtilWallPlacability.wallisReal.is(tx, ty))
/*  84 */           return true; 
/*  85 */         if ((SETT.TERRAIN()).CAVE.is(tx, ty)) {
/*  86 */           return (UtilWallPlacability.placable((SETT.JOBS()).clearss.caveFill, tx, ty) == null);
/*     */         }
/*  88 */         return (UtilWallPlacability.placable(((JobBuildStructure)(SETT.JOBS()).build_structure.get(0)).wall, tx, ty) == null);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/*  93 */         return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */     };
/*     */   
/*  97 */   public static final MAP_BOOLEAN wallShouldBuild = new MAP_BOOLEAN()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/* 101 */         if (UtilWallPlacability.wallisReal.is(tx, ty))
/* 102 */           return false; 
/* 103 */         return UtilWallPlacability.wallCanBe.is(tx, ty);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/* 108 */         return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */       }
/*     */     };
/*     */   
/*     */   private static Terrain.TerrainTile get(int tx, int ty) {
/* 113 */     if ((SETT.JOBS()).getter.is(tx, ty))
/* 114 */       return ((Job)(SETT.JOBS()).getter.get(tx, ty)).becomes(tx, ty); 
/* 115 */     return SETT.TERRAIN().get(tx, ty);
/*     */   }
/*     */   
/*     */   private static CharSequence placable(Job j, int tx, int ty) {
/* 119 */     boolean over = Job.overwrite;
/* 120 */     Job.overwrite = true;
/* 121 */     CharSequence s = j.placer().isPlacable(tx, ty, null, null);
/* 122 */     Job.overwrite = over;
/* 123 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void wallBuild(int tx, int ty, TBuilding building) {
/* 129 */     if ((SETT.ROOMS()).map.is(tx, ty))
/*     */       return; 
/* 131 */     if ((SETT.TERRAIN()).MOUNTAIN.is(tx, ty)) {
/* 132 */       (SETT.JOBS()).clearer.set(tx, ty);
/*     */       return;
/*     */     } 
/* 135 */     if (building.wall.is(tx, ty)) {
/* 136 */       (SETT.JOBS()).clearer.set(tx, ty);
/*     */       
/*     */       return;
/*     */     } 
/* 140 */     if ((SETT.TERRAIN()).CAVE.is(tx, ty)) {
/* 141 */       if (placable((SETT.JOBS()).clearss.caveFill, tx, ty) == null)
/* 142 */         (SETT.JOBS()).clearss.caveFill.placer().place(tx, ty, null, null); 
/* 143 */     } else if (SETT.TERRAIN().get(tx, ty) != building.wall && placable(((JobBuildStructure)(SETT.JOBS()).build_structure.get(building.structure.index())).wall, tx, ty) == null) {
/* 144 */       ((JobBuildStructure)(SETT.JOBS()).build_structure.get(building.structure.index())).wall.placer().place(tx, ty, null, null);
/*     */     } 
/*     */   }
/*     */   public static void openingBuild(int tx, int ty, TBuilding building) {
/* 148 */     if ((SETT.ROOMS()).map.is(tx, ty))
/*     */       return; 
/* 150 */     if ((SETT.TERRAIN()).CAVE.is(tx, ty)) {
/* 151 */       (SETT.JOBS()).clearer.set(tx, ty);
/*     */       return;
/*     */     } 
/* 154 */     if (building.roof.is(tx, ty)) {
/* 155 */       (SETT.JOBS()).clearer.set(tx, ty);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 160 */     if ((SETT.TERRAIN()).MOUNTAIN.is(tx, ty)) {
/* 161 */       if (placable((SETT.JOBS()).clearss.tunnel, tx, ty) == null)
/* 162 */         (SETT.JOBS()).clearss.tunnel.placer().place(tx, ty, null, null); 
/* 163 */     } else if (placable(((JobBuildStructure)(SETT.JOBS()).build_structure.get(building.structure.index())).ceiling, tx, ty) == null) {
/* 164 */       ((JobBuildStructure)(SETT.JOBS()).build_structure.get(building.structure.index())).ceiling.placer().place(tx, ty, null, null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilWallPlacability.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */