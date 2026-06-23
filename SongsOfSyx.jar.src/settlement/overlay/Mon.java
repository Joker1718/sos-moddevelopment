/*    */ package settlement.overlay;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.rendering.RenderData;
/*    */ 
/*    */ class Mon
/*    */   extends Addable
/*    */ {
/*    */   public ROOM_MONUMENT m;
/*    */   public FurnisherItem it;
/*    */   public int radius;
/*    */   public int x1;
/*    */   public int y1;
/*    */   
/*    */   Mon() {
/* 21 */     super(null, null, null, null, true, false);
/*    */   }
/*    */ 
/*    */   
/*    */   void set(ROOM_MONUMENT m, FurnisherItem it, int x1, int y1, int radius) {
/* 26 */     this.m = m;
/* 27 */     this.it = it;
/* 28 */     this.radius = radius;
/* 29 */     this.x1 = x1;
/* 30 */     this.y1 = y1;
/* 31 */     add();
/*    */   }
/*    */   
/*    */   void set(ROOM_MONUMENT m) {
/* 35 */     this.m = m;
/* 36 */     this.it = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void initBelow(RenderData data) {
/* 41 */     if (this.it != null)
/* 42 */       (SETT.ENV()).map.MONUMENT.addExtra(this.m, this.it, this.x1, this.y1); 
/* 43 */     super.initBelow(data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 48 */     int d = 0;
/* 49 */     RoomBlueprint b = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(it.tile());
/* 50 */     if (b == null || b.registersEnvironment()) {
/* 51 */       d = this.m.mapData.get(it.tx(), it.ty());
/* 52 */       if (this.it != null) {
/* 53 */         d = CLAMP.i(d + (SETT.ENV()).map.MONUMENT.extra(this.x1, this.y1, it.tx(), it.ty()), 0, this.m.maxEnv());
/*    */       }
/*    */     } 
/* 56 */     renderUnder(d / this.m.maxEnv(), r, it);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void finishBelow() {
/* 63 */     this.it = null;
/* 64 */     super.finishBelow();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\Mon.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */