/*     */ package settlement.entity.humanoid;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Placer
/*     */   extends PlacableSimple
/*     */ {
/*     */   private final Race r;
/*     */   private final HTYPE f;
/*     */   
/*     */   private Placer(Race r, HTYPE f) {
/* 257 */     super(String.valueOf(r.info.name) + " " + String.valueOf(r.info.name), "");
/* 258 */     this.r = r;
/* 259 */     this.f = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 264 */     return (SPRITE)(this.r.appearance()).icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int x, int y) {
/* 269 */     if (isPlacable(x, y) == null) {
/* 270 */       Humanoid a = new Humanoid(x, y, this.r, this.f, CAUSE_ARRIVES.IMMIGRATED());
/* 271 */       if (a != null && this.f == HTYPES.PRISONER()) {
/* 272 */         (STATS.LAW()).prisonerType.set(a.indu(), CRIMES.all(a.indu().clas()).rnd());
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int x, int y) {
/* 279 */     int x1 = (x - this.r.physics.hitBoxsize() / 2) / 64;
/* 280 */     int x2 = (x + this.r.physics.hitBoxsize() / 2) / 64;
/* 281 */     int y1 = (y - this.r.physics.hitBoxsize() / 2) / 64;
/* 282 */     int y2 = (y + this.r.physics.hitBoxsize() / 2) / 64;
/* 283 */     if (!SETT.IN_BOUNDS(x1, y1) || !SETT.IN_BOUNDS(x2, y2))
/* 284 */       return E; 
/* 285 */     return (!(SETT.PATH()).solidity.is(x1, y1) && !(SETT.PATH()).solidity.is(x2, y1) && 
/* 286 */       !(SETT.PATH()).solidity.is(x1, y2) && !(SETT.PATH()).solidity.is(x2, y2) && 
/* 287 */       SETT.ENTITIES().getAtPoint(x, y) == null) ? null : E;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 293 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\Humanoids$Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */