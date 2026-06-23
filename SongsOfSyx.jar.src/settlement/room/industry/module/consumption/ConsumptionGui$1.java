/*    */ package settlement.room.industry.module.consumption;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import settlement.room.industry.module.IndustryUtil;
/*    */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   GText t;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1) {
/* 71 */     super($anonymous0, $anonymous1);
/* 72 */     this.t = new GText((UI.FONT()).S, 8);
/*    */   }
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 75 */     this.t.clear();
/*    */     
/* 77 */     RoomInstance ins = (RoomInstance)getter.get();
/* 78 */     ROOM_IDATA_INSTANCE insi = (ROOM_IDATA_INSTANCE)getter.get();
/*    */     
/* 80 */     double am = ins.employees().employed() * IndustryUtil.calcConsumptionRate(rr.rate, ins, ConsumptionGui.this.cons);
/* 81 */     if (ConsumptionGui.this.cons.stored(rr).get(insi) <= 0) {
/* 82 */       am *= 1.0D + ConsumptionGui.this.cons.boost(rr);
/*    */     }
/*    */     
/* 85 */     GFORMAT.i(this.t, -((int)am));
/* 86 */     rr.resource.icon().renderC(r, X1, X2, Y1, Y1 + 32);
/* 87 */     this.t.adjustWidth();
/* 88 */     this.t.renderC(r, X1, X2, Y2 - 32, Y2);
/*    */     
/* 90 */     ROOM_IDATA_INSTANCE iins = (ROOM_IDATA_INSTANCE)getter.get();
/* 91 */     if (!iins.getWork().resourceReachable(rr.resource)) {
/* 92 */       (GCOLOR.T()).IBAD.bind();
/* 93 */       (UI.icons()).s.alert.render(r, X1 + 4, Y1 + 4);
/* 94 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\ConsumptionGui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */