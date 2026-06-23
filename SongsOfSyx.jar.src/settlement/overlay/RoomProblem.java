/*    */ package settlement.overlay;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.GUTIL;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class RoomProblem
/*    */   extends Addable {
/* 18 */   private static CharSequence ¤¤desc = "Show problems that exists with your rooms.";
/*    */   static {
/* 20 */     D.ts(RoomProblem.class);
/*    */   }
/*    */ 
/*    */   
/*    */   RoomProblem() {
/* 25 */     super((SPRITE)(UI.icons()).s.alert, "PROBLEM", Dic.¤¤Problem, ¤¤desc, true, false);
/* 26 */     this.exclusive = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void initBelow(RenderData data) {
/* 31 */     GUTIL.flooder().init(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 37 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 42 */     Room ro = (SETT.ROOMS()).map.get(it.tx(), it.ty());
/* 43 */     if (ro != null)
/* 44 */     { int mx = ro.mX(it.tx(), it.ty());
/* 45 */       int my = ro.mY(it.tx(), it.ty());
/* 46 */       if (!GUTIL.flooder().hasBeenPushed(mx, my)) {
/* 47 */         int i = 0;
/* 48 */         if ((VIEW.s()).ui.rooms.problem(ro, mx, my)) {
/* 49 */           i = 1;
/* 50 */         } else if ((VIEW.s()).ui.rooms.warning(ro, mx, my)) {
/* 51 */           i = 2;
/* 52 */         }  GUTIL.flooder().close(mx, my, i);
/*    */       } 
/*    */       
/* 55 */       double v = GUTIL.flooder().getValue(mx, my);
/* 56 */       if (v == 0.0D) {
/* 57 */         renderUnder((GCOLOR.MAP()).OVERLAY_GOOD, r, it);
/* 58 */       } else if (v == 1.0D) {
/* 59 */         renderUnder((GCOLOR.MAP()).OVERLAY_BAD, r, it);
/*    */       } else {
/* 61 */         renderUnder((GCOLOR.MAP()).SOSO, r, it);
/*    */       }  }
/* 63 */     else { renderUnder(COLOR.WHITE15, r, it); }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public void finishBelow() {
/* 69 */     GUTIL.flooder().done();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\RoomProblem.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */