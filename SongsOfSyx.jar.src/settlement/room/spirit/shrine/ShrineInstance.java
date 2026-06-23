/*    */ package settlement.room.spirit.shrine;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import settlement.room.service.module.ROOM_SERVICER;
/*    */ import settlement.room.service.module.RoomServiceInstance;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ final class ShrineInstance
/*    */   extends RoomInstance implements ROOM_SERVICER {
/*    */   private static final long serialVersionUID = 1L;
/*    */   final RoomServiceInstance service;
/*    */   short used;
/*    */   
/*    */   protected ShrineInstance(ROOM_SHRINE b, TmpArea area, RoomInit init) {
/* 22 */     super(b, area, init);
/*    */     
/* 24 */     int am = 0;
/* 25 */     for (COORDINATE c : body()) {
/* 26 */       if (is(c) && b.bed(c.x(), c.y()) != null) {
/* 27 */         am++;
/*    */       }
/*    */     } 
/* 30 */     this.service = new RoomServiceInstance(am, (blueprintI()).data);
/* 31 */     for (COORDINATE c : body()) {
/* 32 */       if (is(c) && (SETT.ROOMS()).fData.tileData.is(c, 2)) {
/* 33 */         SETT.LIGHTS().fire(c.x(), c.y(), 0);
/*    */       }
/* 35 */       if ((blueprintI()).bed.get(c.x(), c.y()) != null)
/* 36 */         (blueprintI()).bed.init(); 
/*    */     } 
/* 38 */     activate();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 43 */     return super.render(r, shadowBatch, it);
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
/* 58 */     if (day) {
/* 59 */       this.service.updateDay();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void dispose() {
/* 64 */     for (COORDINATE c : body()) {
/* 65 */       if (is(c)) {
/* 66 */         (SETT.JOBS()).clearer.set(c);
/* 67 */         Service t = (blueprintI()).bed.get(c.x(), c.y());
/* 68 */         if (t != null)
/* 69 */           t.dispose(); 
/*    */       } 
/*    */     } 
/* 72 */     this.service.dispose((blueprintI()).data);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ROOM_SHRINE blueprintI() {
/* 78 */     return (ROOM_SHRINE)blueprint();
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomServiceInstance service() {
/* 83 */     return this.service;
/*    */   }
/*    */ 
/*    */   
/*    */   public double quality() {
/* 88 */     double base = (upgrade() + 1.0D) / (blueprintI().upgrades().max() + 1.0D);
/* 89 */     return ROOM_SERVICER.defQuality(this, base);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\shrine\ShrineInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */