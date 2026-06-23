/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.royalty.Royalty;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import util.data.GETTER;
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
/*    */ class Portrait
/*    */   extends UIRoyalty.PortraitAbs
/*    */ {
/*    */   final GETTER<Royalty> g;
/*    */   
/*    */   public Portrait(int scale, GETTER<Royalty> g) {
/* 25 */     super(scale);
/* 26 */     this.g = g;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 31 */     super.render(r, X1, X2, Y1, Y2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Induvidual indu() {
/* 36 */     return ((Royalty)this.g.get()).induvidual;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int succ() {
/* 41 */     return ((Royalty)this.g.get()).successionI();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIRoyalty$Portrait.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */