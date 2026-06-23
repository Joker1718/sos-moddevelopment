/*    */ package view.battle.editor;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import snake2d.util.sprite.text.StringInputSprite;
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
/*    */   extends StringInputSprite
/*    */ {
/*    */   null(int $anonymous0, Font $anonymous1) {
/* 45 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   public void renAction() {
/* 48 */     text().clear().add((CharSequence)f.name);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void change() {
/* 53 */     f.name.clear().add((CharSequence)text());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmyFactionButt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */