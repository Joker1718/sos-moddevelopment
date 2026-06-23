/*     */ package settlement.entity.humanoid;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.VectorImp;
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
/*     */ class null
/*     */   extends PlacableSimple
/*     */ {
/*     */   private CAUSE_LEAVE cause;
/*     */   private final ECollision coll;
/*     */   
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1) {
/* 133 */     super($anonymous0, $anonymous1);
/*     */     
/* 135 */     this.cause = CAUSE_LEAVES.SLAYED();
/* 136 */     this.coll = new ECollision();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 142 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 147 */     return (SPRITE)(SPRITES.icons()).m.cancel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int x, int y) {
/* 153 */     for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 154 */       if (e instanceof Humanoid) {
/* 155 */         kill((Humanoid)e, x, y);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void kill(Humanoid e, int x, int y) {
/* 162 */     VectorImp vec = new VectorImp();
/* 163 */     double m = vec.set(x, y, e.body().cX(), e.body().cY());
/*     */     
/* 165 */     e.speed.setRaw(vec.nX() * m * 32.0D + e.speed.x(), vec.nY() * m * 32.0D + e.speed.y());
/*     */     
/* 167 */     this.coll.damagetileStrength = 0.0D;
/* 168 */     this.coll.tileMomentum = 0.0D;
/* 169 */     for (int i = 0; i < this.coll.damage.length; i++)
/* 170 */       this.coll.damage[i] = 0.0D; 
/* 171 */     this.coll.dirDot = 1.0D;
/* 172 */     this.coll.dirDotOther = 1.0D;
/* 173 */     this.coll.norX = 0.5D;
/* 174 */     this.coll.norY = 0.5D;
/* 175 */     this.coll.speedHasChanged = true;
/* 176 */     this.coll.other = null;
/* 177 */     e.collide(this.coll);
/* 178 */     if (!e.isRemoved()) {
/* 179 */       e.kill(true, this.cause);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int x, int y) {
/* 185 */     for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 186 */       if (e instanceof Humanoid) {
/* 187 */         return null;
/*     */       }
/*     */     } 
/* 190 */     return E;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\Humanoids$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */