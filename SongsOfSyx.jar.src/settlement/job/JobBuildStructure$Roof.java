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
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
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
/*     */ final class Roof
/*     */   extends JobBuild
/*     */ {
/*     */   Roof() {
/* 208 */     super("CEILING_" + paramJobBuildStructure.building.key, paramJobBuildStructure.building.resource, paramJobBuildStructure.building.resAmount, false, paramJobBuildStructure.building.nameCeiling, JobBuildStructure.¤¤CeilingD, paramJobBuildStructure.terrain.roof.getIcon());
/*     */   }
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 213 */     for (DIR d : DIR.ORTHO) {
/* 214 */       Job j = (Job)(SETT.JOBS()).getter.get(tx, ty, d);
/* 215 */       if (j instanceof JobBuildStructure.Wall || j instanceof Roof || JobBuildStructure.this.terrain.roof.is(tx, ty))
/* 216 */         mask |= d.mask(); 
/*     */     } 
/* 218 */     (SPRITES.cons()).BIG.dashed.render(r, mask, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 224 */     if (SETT.TERRAIN().get(tx, ty) == (SETT.TERRAIN()).WATER.DEEP) {
/* 225 */       return PlacableMessages.¤¤MISC;
/*     */     }
/* 227 */     if (JobBuildStructure.this.terrain.wall.is(tx, ty) && overwrite)
/* 228 */       return null; 
/* 229 */     return super.problem(tx, ty, overwrite);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double constructionTime(Humanoid skill) {
/* 234 */     return 1.0D + JobBuildStructure.this.building.constructTime * 140.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundRace constructSound() {
/* 239 */     return JobBuildStructure.this.terrain.sound;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean terrainNeedsClear(int tx, int ty) {
/* 244 */     if (JobBuildStructure.this.terrain.wall.is(tx, ty))
/* 245 */       return false; 
/* 246 */     return super.terrainNeedsClear(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean resNeeds(int tx, int ty) {
/* 251 */     if (JobBuildStructure.this.terrain.wall.is(tx, ty))
/* 252 */       return false; 
/* 253 */     return super.resNeeds(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean construct(int tx, int ty) {
/* 258 */     if (JobBuildStructure.this.building.resource != null)
/* 259 */       GAME.player().res().inc(JobBuildStructure.this.building.resource, FResources.RTYPE.CONSTRUCTION, -JobBuildStructure.this.building.resAmount); 
/* 260 */     JobBuildStructure.this.terrain.roof.placeFixed(tx, ty);
/* 261 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstruction() {
/* 266 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 271 */     return (Terrain.TerrainTile)JobBuildStructure.this.terrain.roof;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void extraHovInfo(GBox box) {
/* 276 */     box.textLL(JobBuildStructure.¤¤constructions);
/* 277 */     box.add((SPRITE)GFORMAT.i(box.text(), (int)constructionTime(null)));
/*     */   }
/*     */ 
/*     */   
/*     */   public ToolConfig config() {
/* 282 */     return JobBuildStructure.con(JobBuildStructure.this, placer());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildStructure$Roof.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */