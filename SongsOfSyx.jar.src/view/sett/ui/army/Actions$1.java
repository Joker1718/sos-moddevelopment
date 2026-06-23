/*    */ package view.sett.ui.army;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ import view.keyboard.KEYS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.Glow
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 59 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {}
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 68 */     Str tmp = Str.TMP.clear().add(Dic.¤¤Unitinfo);
/* 69 */     tmp.insert(0, (KEYS.MAIN()).UNDO.repr());
/* 70 */     tmp.insert(1, (KEYS.MAIN()).MOD.repr());
/* 71 */     text.text((CharSequence)tmp);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Actions$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */