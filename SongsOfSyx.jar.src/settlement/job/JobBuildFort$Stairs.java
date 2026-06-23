/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
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
/*     */ final class Stairs
/*     */   extends JobBuild
/*     */ {
/*     */   Stairs() {
/* 140 */     super("STAIRS", RESOURCES.STONE(), 2, false, (SETT.TERRAIN()).FSTAIRS.name(), JobBuildFort.¤¤dStairs, (SETT.TERRAIN()).FSTAIRS.getIcon());
/*     */   }
/*     */ 
/*     */   
/*     */   protected double constructionTime(Humanoid skill) {
/* 145 */     return 50.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean construct(int tx, int ty) {
/* 150 */     GAME.player().res().inc(this.res, FResources.RTYPE.CONSTRUCTION, -this.resAmount);
/* 151 */     (SETT.TERRAIN()).FSTAIRS.placeFixed(tx, ty);
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SoundRace constructSound() {
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 164 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 165 */     if (t instanceof settlement.tilemap.terrain.TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player < 0.0D) {
/* 166 */       return null;
/*     */     }
/* 168 */     if (super.problem(tx, ty, overwrite) != null) {
/* 169 */       return super.problem(tx, ty, overwrite);
/*     */     }
/*     */     
/* 172 */     if ((SETT.PATH()).solidity.is(tx, ty))
/* 173 */       return PlacableMessages.¤¤SOLID_BLOCK; 
/* 174 */     if (t.clearing().needs() && !t.clearing().can())
/* 175 */       return PlacableMessages.¤¤MISC; 
/* 176 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 181 */     (SPRITES.cons()).BIG.dashed.render(r, 0, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 186 */     return (Terrain.TerrainTile)(SETT.TERRAIN()).FSTAIRS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ToolConfig config() {
/* 193 */     return (SETT.JOBS()).build_fort.pla.get(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildFort$Stairs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */