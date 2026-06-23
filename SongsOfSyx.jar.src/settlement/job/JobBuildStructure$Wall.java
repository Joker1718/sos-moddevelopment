/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FResources;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.ToolConfig;
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
/*     */ 
/*     */ final class Wall
/*     */   extends JobBuild
/*     */ {
/*     */   Wall() {
/* 105 */     super("WALL_" + paramJobBuildStructure.building.key, paramJobBuildStructure.building.resource, paramJobBuildStructure.building.resAmount + 1, true, paramJobBuildStructure.building.nameWall, JobBuildStructure.¤¤WallD, paramJobBuildStructure.terrain.wall.getIcon());
/*     */   }
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 110 */     for (DIR d : DIR.ORTHO) {
/* 111 */       Job j = (Job)(SETT.JOBS()).getter.get(tx, ty, d);
/* 112 */       if (j instanceof Wall || JobBuildStructure.this.terrain.wall.is(tx, ty))
/* 113 */         mask |= d.mask(); 
/*     */     } 
/* 115 */     (SPRITES.cons()).BIG.dashedThick.render(r, mask, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 120 */     if ((SETT.ROOMS()).map.is(tx, ty)) {
/* 121 */       return PlacableMessages.¤¤ROOM_BLOCK;
/*     */     }
/* 123 */     if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty)) {
/* 124 */       return PlacableMessages.¤¤MOUNTAIN_NOT;
/*     */     }
/* 126 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 127 */     if (t == (SETT.TERRAIN()).WATER.DEEP) {
/* 128 */       return PlacableMessages.¤¤MISC;
/*     */     }
/* 130 */     if (t.clearing().needs() && !t.clearing().can())
/* 131 */       return PlacableMessages.¤¤MISC; 
/* 132 */     if ((SETT.JOBS()).getter.get(tx, ty) == this)
/* 133 */       return PLACABLE.E; 
/* 134 */     if (t == JobBuildStructure.this.terrain.wall)
/* 135 */       return PLACABLE.E; 
/* 136 */     if (!overwrite && 
/* 137 */       (SETT.JOBS()).getter.is(tx, ty)) {
/* 138 */       return PlacableMessages.¤¤JOB_BLOCK;
/*     */     }
/*     */     
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean terrainNeedsClear(int tx, int ty) {
/* 146 */     if (JobBuildStructure.this.terrain.roof.is(tx, ty))
/* 147 */       return false; 
/* 148 */     return super.terrainNeedsClear(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean resNeeds(int tx, int ty) {
/* 153 */     if (JobBuildStructure.this.terrain.roof.is(tx, ty))
/* 154 */       return (this.res != null && (SETT.JOBS()).progress.get(tx + ty * SETT.TWIDTH) == 0); 
/* 155 */     return super.resNeeds(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double constructionTime(Humanoid skill) {
/* 160 */     return CLAMP.d(JobBuildStructure.this.building.constructTime * 50.0D, 1.0D, 1500.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundRace constructSound() {
/* 165 */     return JobBuildStructure.this.terrain.sound;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean construct(int tx, int ty) {
/* 170 */     if (JobBuildStructure.this.building.resource != null)
/* 171 */       GAME.player().res().inc(JobBuildStructure.this.building.resource, FResources.RTYPE.CONSTRUCTION, -(JobBuildStructure.this.building.resAmount + 1)); 
/* 172 */     JobBuildStructure.this.terrain.wall.placeFixed(tx, ty);
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean becomesSolid() {
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstruction() {
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 188 */     return (Terrain.TerrainTile)JobBuildStructure.this.terrain.wall;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void extraHovInfo(GBox box) {
/* 193 */     box.textLL(JobBuildStructure.¤¤constructions);
/* 194 */     box.add((SPRITE)GFORMAT.i(box.text(), (int)constructionTime((Humanoid)null)));
/*     */   }
/*     */ 
/*     */   
/*     */   public ToolConfig config() {
/* 199 */     return JobBuildStructure.con(JobBuildStructure.this, placer());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildStructure$Wall.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */