/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends WorldWater.WATER
/*     */ {
/*     */   private SPRITE icon;
/*     */   
/*     */   null(WorldWater paramWorldWater2, String $anonymous0) {
/*  67 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void pplace(int tx, int ty) {
/*  76 */     placeRaw(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean coversCompleatly(int tile) {
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isFertile() {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canTravelTo(int data, DIR to) {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 103 */     if (this.icon == null)
/* 104 */       this.icon = WorldWater.this.OCEAN.icon.twin((SPRITE)(UI.icons()).m.anti, DIR.C, 0); 
/* 105 */     return this.icon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 111 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldWater$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */