/*     */ package game.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.map.MAP_OBJECT_ISSER;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TargetMap
/*     */ {
/*     */   public final MAP_OBJECT<Army> army;
/*     */   public final MAP_OBJECT_ISSER<Army> attackable;
/*     */   public final MAP_OBJECT_ISSER<Induvidual> attackableI;
/*     */   public MAP_DOUBLE strength;
/*     */   
/*     */   TargetMap() {
/*  43 */     this.army = new MAP_OBJECT<Army>()
/*     */       {
/*     */         public Army get(int tile)
/*     */         {
/*  47 */           Room r = (SETT.ROOMS()).map.get(tile);
/*  48 */           if (r != null) {
/*  49 */             if (r instanceof ArtilleryInstance) {
/*  50 */               return ((ArtilleryInstance)r).army();
/*     */             }
/*  52 */             return GAME.ARMIES().player();
/*     */           } 
/*     */           
/*  55 */           return (((SETT.PATH()).availability.get(tile)).player < 0.0D) ? GAME.ARMIES().player() : null;
/*     */         }
/*     */ 
/*     */         
/*     */         public Army get(int tx, int ty) {
/*  60 */           if (!SETT.IN_BOUNDS(tx, ty))
/*  61 */             return null; 
/*  62 */           return get(tx + ty * SETT.TWIDTH);
/*     */         }
/*     */       };
/*     */     
/*  66 */     this.attackable = new MAP_OBJECT_ISSER<Army>()
/*     */       {
/*     */         public boolean is(int tx, int ty, Army value)
/*     */         {
/*  70 */           if (!SETT.IN_BOUNDS(tx, ty))
/*  71 */             return false; 
/*  72 */           return is(tx + ty * SETT.TWIDTH, value);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tile, Army value) {
/*  79 */           Room r = (SETT.ROOMS()).map.get(tile);
/*  80 */           if (r != null) {
/*  81 */             if (r instanceof ArtilleryInstance) {
/*  82 */               return (((ArtilleryInstance)r).army() != value);
/*     */             }
/*  84 */             return (GAME.ARMIES().player() != value);
/*     */           } 
/*     */           
/*  87 */           if (value == GAME.ARMIES().player() && 
/*  88 */             SETT.TERRAIN().get(tile).clearing().isStructure()) {
/*  89 */             return false;
/*     */           }
/*     */           
/*  92 */           if ((SETT.PATH()).availability.get(tile).isSolid(value) && SETT.TERRAIN().get(tile).clearing().canDestroy(tile % SETT.TWIDTH, tile / SETT.TWIDTH)) {
/*  93 */             return true;
/*     */           }
/*  95 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 100 */     this.attackableI = new MAP_OBJECT_ISSER<Induvidual>()
/*     */       {
/*     */         public boolean is(int tx, int ty, Induvidual value)
/*     */         {
/* 104 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 105 */             return false; 
/* 106 */           return is(tx + ty * SETT.TWIDTH, value);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tile, Induvidual in) {
/* 112 */           Army value = in.army();
/* 113 */           Room r = (SETT.ROOMS()).map.get(tile);
/* 114 */           if (r != null) {
/* 115 */             if (in.hType() == HTYPES.RIOTER() && r.blueprint() instanceof settlement.room.spirit.grave.GraveData.GRAVE_DATA_HOLDER)
/* 116 */               return false; 
/* 117 */             if (r instanceof ArtilleryInstance) {
/* 118 */               return (((ArtilleryInstance)r).army() != value);
/*     */             }
/* 120 */             return (GAME.ARMIES().player() != value);
/*     */           } 
/*     */           
/* 123 */           if (value == GAME.ARMIES().player() && 
/* 124 */             SETT.TERRAIN().get(tile).clearing().isStructure()) {
/* 125 */             return false;
/*     */           }
/*     */           
/* 128 */           if ((SETT.PATH()).availability.get(tile).isSolid(value) && SETT.TERRAIN().get(tile).clearing().canDestroy(tile % SETT.TWIDTH, tile / SETT.TWIDTH)) {
/* 129 */             return true;
/*     */           }
/* 131 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 136 */     this.strength = new MAP_DOUBLE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 140 */           if (!SETT.IN_BOUNDS(tx, ty)) {
/* 141 */             return 0.0D;
/*     */           }
/* 143 */           return get(tx + ty * SETT.TWIDTH);
/*     */         } public void place(int tx, int ty, AREA a, PLACER_TYPE t) { TargetMap.this.breakIt(tx, ty); }
/*     */       };
/*     */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("break something") {
/*     */           public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { return (TargetMap.this.attackable.is(tx, ty, GAME.ARMIES().player()) || TargetMap.this.attackable.is(tx, ty, GAME.ARMIES().enemy())) ? null : E; } public double get(int tile) {
/* 148 */             RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(tile);
/* 149 */             if (p != null) {
/* 150 */               return p.strength(tile);
/*     */             }
/* 152 */             return SETT.TERRAIN().get(tile).clearing().strength();
/*     */           }
/*     */         });
/*     */   }
/*     */   public void breakIt(int x, int y) {
/* 157 */     Room r = (SETT.ROOMS()).map.get(x, y);
/* 158 */     if (r != null && r.destroyTileCan(x, y)) {
/* 159 */       if (r.destroyTileCan(x, y)) {
/* 160 */         (SETT.THINGS()).gore.debris((x << 6) + 32, (y << 6) + 32, 0.0D, 0.0D);
/* 161 */         r.destroyTile(x, y);
/* 162 */         (SETT.JOBS()).tool_repair.place(x, y, null, null);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 167 */     Terrain.TerrainTile b = SETT.TERRAIN().get(x, y);
/* 168 */     if (b.clearing().canDestroy(x, y)) {
/* 169 */       (SETT.THINGS()).gore.debris((x << 6) + 32, (y << 6) + 32, 0.0D, 0.0D);
/* 170 */       b.clearing().destroy(x, y);
/* 171 */       (SETT.JOBS()).tool_repair.place(x, y, null, null);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\TargetMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */