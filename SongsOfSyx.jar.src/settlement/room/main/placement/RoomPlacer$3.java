/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.Renderer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ON_TOP_RENDERABLE
/*     */ {
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/*  97 */     if (RoomPlacer.this.blueprint() == null || RoomPlacer.this.blueprint().constructor() == null)
/*     */       return; 
/*  99 */     RenderData.RenderIterator it = data.onScreenTiles();
/* 100 */     while (it.has()) {
/* 101 */       Room room = (SETT.ROOMS()).map.get(it.tx(), it.ty());
/* 102 */       if (room == RoomPlacer.this.instance) {
/* 103 */         RoomPlacer.this.renderPlaceholder(r, shadowBatch, it);
/*     */       }
/* 105 */       it.next();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\RoomPlacer$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */