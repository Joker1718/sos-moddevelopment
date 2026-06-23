/*     */ package settlement.misc.placers;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PlacerLanding
/*     */ {
/*     */   static Placer get() {
/*  34 */     TBuilding b = (SETT.TERRAIN()).BUILDINGS.MUD;
/*  35 */     if (b == null) {
/*  36 */       b = (TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(0);
/*     */     }
/*  38 */     Tile ww = new Tiles.Terrain((Terrain.TerrainTile)b.wall)
/*     */       {
/*     */         public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  41 */           if ((SETT.TERRAIN()).CAVE.is(tx, ty)) {
/*  42 */             (SETT.TERRAIN()).MOUNTAIN.placeFixed(tx, ty);
/*     */           } else {
/*  44 */             super.place(tx, ty, grid, rx, ry);
/*     */           }  }
/*     */       };
/*  47 */     Tile roof = new Tiles.Terrain((Terrain.TerrainTile)b.roof)
/*     */       {
/*     */         public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  50 */           if ((SETT.TERRAIN()).CAVE.is(tx, ty))
/*     */             return; 
/*  52 */           super.place(tx, ty, grid, rx, ry);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  58 */     Tile rr = new Tiles.Conpound(new Tile[] { roof });
/*     */     
/*  60 */     Tile throne = new Tile()
/*     */       {
/*     */         public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/*  63 */           return (SPRITES.cons()).ICO.cancel;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  68 */           (SETT.ROOMS()).THRONE.init.place(tx, ty, 2);
/*     */           
/*  70 */           FACTIONS.player().credits().inc((int)(5000.0D * (BOOSTABLES.CIVICS()).LANDING.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null))), FCredits.CTYPE.MISC);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  76 */           return (SETT.ROOMS()).THRONE.init.placableTile(tx, ty);
/*     */         }
/*     */       };
/*  79 */     Tile thone2 = new Tile()
/*     */       {
/*     */         public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/*  82 */           return (SPRITES.cons()).ICO.cancel;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, TileGrid grid, int rx, int ry) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  92 */           return (SETT.ROOMS()).THRONE.init.placableTile(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  97 */     Tile th = new Tiles.Conpound(new Tile[] { roof, throne });
/*  98 */     Tile to = new Tiles.Conpound(new Tile[] { roof, thone2 });
/*  99 */     Json j = (new Json(PATHS.INIT().getFolder("config").gets("LandingParty"))).json("RESOURCES");
/* 100 */     LIST<String> keys = j.keys();
/*     */     
/* 102 */     Tile R1 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 0) });
/* 103 */     Tile R2 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 1) });
/* 104 */     Tile R3 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 2) });
/* 105 */     Tile R4 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 3) });
/* 106 */     Tile R5 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 4) });
/* 107 */     Tile R6 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 5) });
/* 108 */     Tile R7 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 6) });
/* 109 */     Tile R8 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 7) });
/* 110 */     Tile R9 = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 8) });
/* 111 */     Tile RA = new Tiles.Conpound(new Tile[] { rr, new Resource(j, keys, 9) });
/*     */ 
/*     */     
/* 114 */     Tile dd = new Tile()
/*     */       {
/* 116 */         private int am = -1;
/* 117 */         private int ePerTile = -1;
/*     */         
/*     */         public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 120 */           return (SPRITES.cons()).ICO.cancel;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 125 */           if ((STATS.POP()).POP.data(null).get(null) == 0) {
/* 126 */             this.am = 10 + (int)(10.0D * (BOOSTABLES.CIVICS()).LANDING.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null)));
/*     */             
/* 128 */             this.ePerTile = (int)Math.ceil(this.am / 10.0D);
/*     */           } 
/* 130 */           for (int i = 0; i < this.ePerTile; i++) {
/* 131 */             if (this.am > 0) {
/*     */               
/* 133 */               Humanoid h = SETT.HUMANOIDS().create(FACTIONS.player().race(), tx, ty, HTYPES.SUBJECT(), CAUSE_ARRIVES.IMMIGRATED());
/* 134 */               (STATS.POP()).TYPE.IMMIGRANT.set(h.indu());
/* 135 */               this.am--;
/*     */             } 
/* 137 */           }  VIEW.messages().hide();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 143 */           return !(SETT.PATH()).solidity.is(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 148 */     Tile[][] grid = { 
/* 149 */         { ww, ww, ww, ww, ww, ww, ww, ww, ww
/* 150 */         }, { ww, rr, th, to, to, to, to, rr, ww
/* 151 */         }, { ww, rr, to, to, to, to, to, rr, ww
/* 152 */         }, { ww, rr, to, to, to, to, to, rr, ww
/* 153 */         }, { ww, rr, R7, R3, R1, R2, R8, rr, ww
/* 154 */         }, { ww, rr, R9, R5, R4, R6, RA, rr, ww
/* 155 */         }, { ww, rr, rr, rr, rr, rr, rr, rr, ww
/* 156 */         }, { ww, ww, ww, rr, rr, rr, ww, ww, ww
/* 157 */         }, { Tiles.__, dd, Tiles.__, Tiles.__, Tiles.__, Tiles.__, Tiles.__, dd, Tiles.__
/* 158 */         }, { Tiles.__, dd, dd, Tiles.__, Tiles.__, Tiles.__, dd, dd, Tiles.__ }, 
/* 159 */         { Tiles.__, dd, dd, Tiles.__, Tiles.__, Tiles.__, dd, dd, Tiles.__
/* 160 */         }, { Tiles.__, Tiles.__, Tiles.__, Tiles.__, Tiles.__, Tiles.__, Tiles.__, Tiles.__, Tiles.__ } };
/*     */ 
/*     */     
/* 163 */     return new Placer("Landing Party", new TileGrid(grid));
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Resource
/*     */     implements Tile
/*     */   {
/*     */     final RESOURCE r;
/*     */     final int amount;
/*     */     
/*     */     Resource(Json j, LIST<String> keys, int index) {
/* 174 */       if (index >= keys.size()) {
/* 175 */         this.r = null;
/* 176 */         this.amount = 0;
/*     */       } else {
/* 178 */         this.r = (RESOURCE)RESOURCES.map().get((String)keys.get(index), j);
/* 179 */         this.amount = j.i((String)keys.get(index), 1, 500);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 187 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 192 */       if (this.r != null) {
/* 193 */         (SETT.THINGS()).resources.createPrecise(tx, ty, this.r, this.amount + (int)(this.amount * (BOOSTABLES.CIVICS()).LANDING.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null))));
/*     */       }
/*     */     }
/*     */     
/*     */     public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 198 */       return (SPRITES.cons()).ICO.clear;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\PlacerLanding.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */