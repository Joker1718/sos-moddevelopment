/*     */ package settlement.job;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.tilemap.terrain.TRock;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends JobClear
/*     */ {
/*     */   final Addable a;
/*     */   
/*     */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3, SPRITE $anonymous4) {
/*  79 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     this.a = new Addable(null, null, null, null, true, false)
/*     */       {
/*     */         
/*     */         public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*     */         {
/*  91 */           double v = 0.0D;
/*  92 */           if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/*  93 */             Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/*  94 */             if (t instanceof TRock) {
/*  95 */               TRock b = (TRock)t;
/*  96 */               b.getClass(); v = Math.max(v, 0.5D + 0.5D * b.amountGet(it.tx(), it.ty()) / 15.0D);
/*     */             } 
/*     */           } 
/*     */           
/* 100 */           renderUnder(v, r, it, false);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 108 */     if (super.problem(tx, ty, overwrite) != null)
/* 109 */       return super.problem(tx, ty, overwrite); 
/* 110 */     if (!(SETT.TERRAIN()).ROCK.is(tx, ty)) {
/* 111 */       return PlacableMessages.¤¤ROCK_MUST;
/*     */     }
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 118 */     return 5.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Addable overlay() {
/* 124 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClears$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */