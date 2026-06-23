/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ 
/*     */ final class JobBuildFillCave
/*     */   extends JobBuild
/*     */ {
/*  27 */   private static CharSequence ¤¤name = "¤Refill Mountain Cave";
/*  28 */   private static CharSequence ¤¤desc = "¤Refills dug tunnels or natural mountain caves";
/*     */   
/*     */   static {
/*  31 */     D.ts(JobBuildFillCave.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JobBuildFillCave() {
/*  41 */     super("FILL_MOUNTAIN", RESOURCES.STONE(), 2, true, ¤¤name, ¤¤desc, (SETT.TERRAIN()).MOUNTAIN.getIcon());
/*     */     
/*  43 */     this.placer = new Placer(this, RESOURCES.STONE(), 2, ¤¤desc) {
/*  44 */         private final String jobs = "Jobs: ";
/*     */         
/*     */         public void placeInfo(GBox b, int okTiles, AREA a) {
/*  47 */           super.placeInfo(b, okTiles, a);
/*  48 */           if (okTiles > 0) {
/*  49 */             VIEW.hoverBox().add((SPRITE)VIEW.hoverBox().text().add("Jobs: ").add(okTiles));
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/*  55 */           return (LIST<CLICKABLE>)(SETT.JOBS()).clearss.butts;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/*  62 */     (SPRITES.cons()).ICO.unclear.render(r, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/*  67 */     if ((SETT.ROOMS()).map.is(tx, ty))
/*  68 */       return PlacableMessages.¤¤ROOM_BLOCK; 
/*  69 */     if ((SETT.PLACA()).willBlock.is(tx, ty)) {
/*  70 */       return PlacableMessages.¤¤BLOCK_WILL;
/*     */     }
/*  72 */     if (!overwrite && 
/*  73 */       (SETT.JOBS()).getter.is(tx, ty)) {
/*  74 */       return PlacableMessages.¤¤JOB_BLOCK;
/*     */     }
/*     */ 
/*     */     
/*  78 */     if (!(SETT.TERRAIN()).CAVE.is(tx, ty))
/*  79 */       return PlacableMessages.¤¤CAVE_MUST; 
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean terrainNeedsClear(int tx, int ty) {
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double constructionTime(Humanoid h) {
/*  90 */     return 20.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean construct(int tx, int ty) {
/*  95 */     GAME.player().res().inc(RESOURCES.STONE(), FResources.RTYPE.CONSTRUCTION, -2);
/*  96 */     (SETT.FLOOR()).clearer.clear(tx, ty);
/*  97 */     (SETT.TERRAIN()).MOUNTAIN.placeFixed(tx, ty);
/*  98 */     (SETT.TERRAIN()).MOUNTAIN.strengthSet(tx, ty, 0.0D);
/*     */     
/* 100 */     for (DIR d : DIR.ALLC) {
/* 101 */       if ((SETT.TERRAIN()).CAVE.canFix(tx + d.x(), ty + d.y())) {
/* 102 */         (SETT.TERRAIN()).CAVE.fix(tx + d.x(), ty + d.y());
/*     */       }
/*     */     } 
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundRace constructSound() {
/* 110 */     return (SETT.TERRAIN()).MOUNTAIN.clearing().sound(this.coo.x(), this.coo.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean becomesSolid() {
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstruction() {
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 125 */     return (Terrain.TerrainTile)(SETT.TERRAIN()).MOUNTAIN;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildFillCave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */