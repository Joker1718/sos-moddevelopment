/*    */ package settlement.room.law.guard;
/*    */ 
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   int pi;
/*    */   
/*    */   null(SPRITE $anonymous0) {
/* 80 */     super($anonymous0);
/*    */     
/* 82 */     this.pi = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 87 */     if (this.pi >= Patrols.this.patrols.length)
/* 88 */       this.pi = 0; 
/* 89 */     Patrol p = Patrols.this.patrols[this.pi];
/* 90 */     Coo coo = p.pos(0);
/* 91 */     (VIEW.s().getWindow()).centerer.set(coo.x(), coo.y());
/* 92 */     Patrols.this.debug = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Patrols$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */