/*    */ package settlement.room.service.hygine.well;
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
/*    */ final class WellInstance extends RoomInstance implements ROOM_SERVICER {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected WellInstance(ROOM_WELL b, TmpArea area, RoomInit init) {
/* 19 */     super(b, area, init);
/*    */ 
/*    */     
/* 22 */     int am = 0;
/* 23 */     for (COORDINATE c : body()) {
/* 24 */       if (is(c) && b.bed.get(c.x(), c.y()) != null)
/* 25 */         am++; 
/* 26 */     }  this.service = new RoomServiceInstance(am, (RoomService)(blueprintI()).data);
/* 27 */     for (COORDINATE c : body()) {
/* 28 */       if (is(c))
/* 29 */         b.bed.init(c.x(), c.y()); 
/*    */     } 
/* 31 */     activate();
/*    */   }
/*    */   final RoomServiceInstance service;
/*    */   
/*    */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 36 */     return super.render(r, shadowBatch, it);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void activateAction() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void deactivateAction() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void updateAction(double updateInterval, boolean day) {
/* 51 */     if (day) {
/* 52 */       this.service.updateDay();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void dispose() {
/* 57 */     for (COORDINATE c : body()) {
/* 58 */       if (is(c)) {
/* 59 */         Wash t = (blueprintI()).bed.get(c.x(), c.y());
/* 60 */         if (t != null)
/* 61 */           t.dispose(); 
/*    */       } 
/*    */     } 
/* 64 */     this.service.dispose((RoomService)(blueprintI()).data);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ROOM_WELL blueprintI() {
/* 70 */     return (ROOM_WELL)blueprint();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceInstance service() {
/* 75 */     return this.service;
/*    */   }
/*    */ 
/*    */   
/*    */   public double quality() {
/* 80 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\well\WellInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */