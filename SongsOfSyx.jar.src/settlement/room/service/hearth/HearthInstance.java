/*    */ package settlement.room.service.hearth;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ final class HearthInstance extends RoomInstance implements ROOM_SERVICER {
/*    */   private static final long serialVersionUID = 1L;
/*    */   final RoomServiceInstance service;
/*    */   short used;
/*    */   
/*    */   protected HearthInstance(ROOM_HEARTH b, TmpArea area, RoomInit init) {
/* 22 */     super(b, area, init);
/*    */     
/* 24 */     int am = 0;
/* 25 */     for (COORDINATE c : body()) {
/* 26 */       if (is(c) && (SETT.ROOMS()).fData.tileData.is(c, 1)) {
/* 27 */         am++;
/*    */       }
/*    */     } 
/* 30 */     this.service = new RoomServiceInstance(am, (RoomService)(blueprintI()).data);
/* 31 */     for (COORDINATE c : body()) {
/* 32 */       if (is(c) && (SETT.ROOMS()).fData.tileData.is(c, 2)) {
/* 33 */         SETT.LIGHTS().fire(c.x(), c.y(), 0);
/* 34 */         SETT.LIGHTS().hide(c.x(), c.y(), true);
/*    */       } 
/* 36 */       if ((blueprintI()).bed.get(c.x(), c.y()) != null)
/* 37 */         (blueprintI()).bed.init(); 
/*    */     } 
/* 39 */     activate();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 44 */     return super.render(r, shadowBatch, it);
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
/* 59 */     if (day) {
/* 60 */       this.service.updateDay();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void dispose() {
/* 65 */     for (COORDINATE c : body()) {
/* 66 */       if (is(c)) {
/* 67 */         (SETT.JOBS()).clearer.set(c);
/* 68 */         Hearth t = (blueprintI()).bed.get(c.x(), c.y());
/* 69 */         if (t != null)
/* 70 */           t.dispose(); 
/*    */       } 
/*    */     } 
/* 73 */     this.service.dispose((RoomService)(blueprintI()).data);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ROOM_HEARTH blueprintI() {
/* 79 */     return (ROOM_HEARTH)blueprint();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceInstance service() {
/* 84 */     return this.service;
/*    */   }
/*    */ 
/*    */   
/*    */   public double quality() {
/* 89 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hearth\HearthInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */