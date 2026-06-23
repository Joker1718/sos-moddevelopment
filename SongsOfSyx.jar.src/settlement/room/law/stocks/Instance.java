/*    */ package settlement.room.law.stocks;
/*    */ 
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import settlement.room.service.module.ROOM_SERVICER;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.room.service.module.RoomServiceInstance;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ final class Instance extends RoomInstance implements ROOM_SERVICER {
/*    */   private static final long serialVersionUID = 1L;
/*    */   final RoomServiceInstance service;
/*    */   byte available;
/*    */   
/*    */   protected Instance(ROOM_STOCKS b, TmpArea area, RoomInit init) {
/* 21 */     super(b, area, init);
/*    */     
/* 23 */     this.service = new RoomServiceInstance((int)b.constructor.spectators.get(this), (RoomService)(blueprintI()).data);
/* 24 */     for (COORDINATE c : body()) {
/* 25 */       if (is(c)) {
/* 26 */         Tile t = (blueprintI()).tile.get(c.x(), c.y());
/* 27 */         if (t != null) {
/* 28 */           t.init();
/*    */         }
/*    */       } 
/*    */     } 
/* 32 */     activate();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 38 */     it.lit();
/* 39 */     return super.render(r, shadowBatch, it);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void activateAction() {
/* 44 */     for (COORDINATE c : body()) {
/* 45 */       if (is(c)) {
/* 46 */         Tile t = (blueprintI()).tile.get(c.x(), c.y());
/* 47 */         if (t != null) {
/* 48 */           t.stateSet(Tile.STATE.available);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void deactivateAction() {
/* 57 */     for (COORDINATE c : body()) {
/* 58 */       if (is(c)) {
/* 59 */         Tile t = (blueprintI()).tile.get(c.x(), c.y());
/* 60 */         if (t != null) {
/* 61 */           t.stateSet(Tile.STATE.none);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void updateAction(double updateInterval, boolean day) {
/* 70 */     if (day) {
/* 71 */       this.service.updateDay();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void dispose() {
/* 76 */     this.service.dispose((RoomService)(blueprintI()).data);
/*    */   }
/*    */ 
/*    */   
/*    */   public ROOM_STOCKS blueprintI() {
/* 81 */     return (ROOM_STOCKS)blueprint();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceInstance service() {
/* 86 */     return this.service;
/*    */   }
/*    */ 
/*    */   
/*    */   public double quality() {
/* 91 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */