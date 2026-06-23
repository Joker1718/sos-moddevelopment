/*    */ package view.ui.profile;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import snake2d.util.sprite.text.Str;
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
/* 81 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public Str text() {
/* 85 */     return (FACTIONS.player()).name;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void change() {
/* 90 */     if (FACTIONS.player().capitolRegion() != null)
/* 91 */       (FACTIONS.player().capitolRegion()).info.name().clear().add((CharSequence)text()); 
/* 92 */     super.change();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIProfile$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */