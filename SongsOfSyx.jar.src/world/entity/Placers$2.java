/*    */ package world.entity;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ import world.entity.haven.WHavenType;
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
/*    */   null(SPRITE $anonymous0) {
/* 56 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 60 */     type.set(t);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 65 */     this.label = (SPRITE)(t.race.appearance()).icon;
/* 66 */     selectedSet((type.get() == t));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\Placers$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */