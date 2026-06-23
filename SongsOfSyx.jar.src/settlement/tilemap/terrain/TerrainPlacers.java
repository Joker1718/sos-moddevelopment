/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ class TerrainPlacers
/*     */ {
/*     */   TerrainPlacers(Terrain t, LIST<Terrain.TerrainTile> tiles) {
/*  16 */     for (Terrain.TerrainTile tt : tiles)
/*     */     {
/*  18 */       make(tt);
/*     */     }
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void make(final Terrain.TerrainTile t) {
/*  43 */     PlacableMulti placableMulti = new PlacableMulti(t.getClass().getSimpleName() + " " + t.getClass().getSimpleName(), null, t.getIcon(), null)
/*     */       {
/*     */         public void place(int tx, int ty, AREA a, PLACER_TYPE type)
/*     */         {
/*  47 */           t.placeFixed(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/*  52 */           if (!t.isPlacable(tx, ty))
/*  53 */             return PlacableMessages.¤¤BLOCKED; 
/*  54 */           return null;
/*     */         }
/*     */       };
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
/*  84 */     IDebugPanelSett.add("terrain", (PLACABLE)placableMulti);
/*     */   }
/*     */ 
/*     */   
/*     */   private abstract class Increaser
/*     */     extends PlacableMulti
/*     */   {
/*     */     private Terrain.TerrainTile t;
/*     */ 
/*     */     
/*     */     Increaser(Terrain.TerrainTile t) {
/*  95 */       super(String.valueOf(t.name()) + " increase");
/*  96 */       this.t = t;
/*  97 */       IDebugPanelSett.add("terrain", (PLACABLE)this);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 102 */       return this.t.is(tx, ty) ? null : "";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private abstract class Decreaser
/*     */     extends PlacableMulti
/*     */   {
/*     */     private Terrain.TerrainTile t;
/*     */     
/*     */     Decreaser(Terrain.TerrainTile t) {
/* 113 */       super(String.valueOf(t.name()) + " decrease");
/* 114 */       this.t = t;
/* 115 */       IDebugPanelSett.add("terrain", (PLACABLE)this);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 120 */       return this.t.is(tx, ty) ? null : "";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TerrainPlacers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */