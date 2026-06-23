/*    */ package settlement.overlay;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.infra.logistics.MoveJob;
/*    */ import settlement.room.infra.logistics.MoveOrderPull;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.color.COLOR;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ 
/*    */ public final class OverlayPull
/*    */   extends Addable
/*    */ {
/*    */   private MoveOrderPull.MoveOrderPullInstance special;
/*    */   
/*    */   OverlayPull() {
/* 18 */     super(null, null, null, null, true, false);
/* 19 */     this.exclusive = true;
/*    */   }
/*    */   
/*    */   public void add(MoveOrderPull.MoveOrderPullInstance ins) {
/* 23 */     add();
/* 24 */     this.special = ins;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 30 */     COLOR c = COLOR.WHITE10;
/*    */     
/* 32 */     Room room = (SETT.ROOMS()).map.get(it.tx(), it.ty());
/* 33 */     if (room != null && room != this.special && room instanceof MoveJob.ROOM_MOVE_SOURCE) {
/* 34 */       MoveJob.ROOM_MOVE_SOURCE s = (MoveJob.ROOM_MOVE_SOURCE)room;
/* 35 */       if (s.moveCapacity().has(this.special.moveOrderPullAccepted())) {
/* 36 */         c = (GCOLOR.MAP()).OVERLAY_GOOD;
/*    */       } else {
/* 38 */         c = (GCOLOR.MAP()).OVERLAY_BAD;
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 44 */     renderUnder(c, r, it);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void finishBelow() {
/* 51 */     this.special = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\OverlayPull.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */