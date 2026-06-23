/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FResources;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TFence;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.D;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JobBuildFence
/*     */   extends JobBuild
/*     */ {
/*     */   private final TFence fence;
/*  25 */   private static CharSequence ¤¤desc = "¤Stops subjects and animals from wandering where you don't desire them.";
/*     */   
/*     */   static LIST<Job> make() {
/*  28 */     D.ts(JobBuildFence.class);
/*  29 */     ArrayList<Job> all = new ArrayList((SETT.TERRAIN()).FENCES.all().size());
/*  30 */     for (TFence s : (SETT.TERRAIN()).FENCES.all()) {
/*  31 */       all.add(new JobBuildFence(s));
/*     */     }
/*  33 */     return (LIST<Job>)all;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JobBuildFence(TFence fence) {
/*  44 */     super("FENCE_" + fence.key(), fence.tile.resource, 1, true, fence.tile.name(), ¤¤desc, fence.tile.getIcon());
/*  45 */     this.needsFerClear = false;
/*  46 */     this.fence = fence;
/*     */   }
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/*  51 */     for (DIR d : DIR.ORTHO) {
/*  52 */       if ((SETT.FLOOR()).getter.is(tx, ty, d) || (SETT.JOBS()).getter.get(tx, ty, d) instanceof JobBuildFence)
/*  53 */         mask |= d.mask(); 
/*     */     } 
/*  55 */     (SPRITES.cons()).BIG.dashedThick.render(r, mask, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double constructionTime(Humanoid skill) {
/*  60 */     return 10.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundRace constructSound() {
/*  65 */     return this.fence.tile.clearing().sound(this.coo.x(), this.coo.y());
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean construct(int tx, int ty) {
/*  70 */     if (this.fence.tile.resource != null)
/*  71 */       GAME.player().res().inc(this.fence.tile.resource, FResources.RTYPE.CONSTRUCTION, -this.fence.tile.resAmount); 
/*  72 */     this.fence.tile.placeFixed(tx, ty);
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstruction() {
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/*  83 */     return (Terrain.TerrainTile)this.fence.tile;
/*     */   }
/*     */   
/*  86 */   private static JobComboPlacer pla = null;
/*     */ 
/*     */   
/*     */   public ToolConfig config() {
/*  90 */     return pp().get(this);
/*     */   }
/*     */   
/*     */   public static Job getPlacable() {
/*  94 */     return pp().current();
/*     */   }
/*     */   
/*     */   static JobComboPlacer pp() {
/*  98 */     if (pla == null)
/*  99 */       pla = new JobComboPlacer((SETT.JOBS()).fences, "FENCE"); 
/* 100 */     return pla;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildFence.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */