/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Resource
/*     */   extends TempleAltar
/*     */ {
/*     */   private final RESOURCE res;
/*     */   
/*     */   Resource(ROOM_TEMPLE blue, RESOURCE resources) {
/*  82 */     super(blue);
/*  83 */     this.res = resources;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*  88 */     int am = this.resources.get();
/*     */     
/*  90 */     if (am > 0) {
/*  91 */       this.res.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void updateDay(int am) {
/* 103 */     this.ins.sacrificesTotal = (short)(this.ins.sacrificesTotal + am);
/* 104 */     int rr = this.resources.get();
/* 105 */     am = CLAMP.i(am, 0, rr);
/* 106 */     this.resources.inc((ROOMA)this.ins, -am);
/* 107 */     this.ins.sacrifices = (short)(this.ins.sacrifices + am);
/* 108 */     this.ins.consumed += am;
/* 109 */     this.blue.consumed += am;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean shouldKill() {
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   void kill() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\TempleAltar$Resource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */