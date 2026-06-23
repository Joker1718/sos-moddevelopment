/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.data.GETTER;
/*    */ import util.gui.common.UIPickerArmy;
/*    */ import view.main.VIEW;
/*    */ import world.WORLD;
/*    */ import world.entity.army.WArmy;
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
/*    */   extends UIPickerArmy
/*    */ {
/*    */   null(GETTER<? extends Faction> $anonymous0, int $anonymous1) {
/* 64 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected boolean canBePicked(WArmy a) {
/* 68 */     return !WORLD.FOW().is(a.ctx(), a.cty());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void pick(WArmy a) {
/* 73 */     if (!WORLD.FOW().is(a.ctx(), a.cty())) {
/* 74 */       VIEW.world().activate();
/* 75 */       (VIEW.UI()).manager.close();
/* 76 */       (VIEW.world()).window.centererTile.set(a.ctx(), a.cty());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(GUI_BOX text, WArmy a) {
/* 82 */     if (!WORLD.FOW().is(a.ctx(), a.cty()))
/* 83 */       super.hover(text, a); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Realm$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */