/*    */ package game.boosting;
/*    */ 
/*    */ import init.sprite.UI.Icon;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ public class BSourceInfo
/*    */ {
/*    */   public final CharSequence name;
/*    */   public final CharSequence desc;
/*    */   public final SPRITE icon;
/*    */   
/*    */   public BSourceInfo(CharSequence name, SPRITE icon) {
/* 14 */     this(name, null, icon);
/*    */   }
/*    */   
/*    */   public BSourceInfo(CharSequence name, CharSequence append, SPRITE icon) {
/* 18 */     this(name, null, append, icon);
/*    */   }
/*    */   
/*    */   public BSourceInfo(CharSequence name, CharSequence desc, CharSequence append, SPRITE icon) {
/*    */     Icon icon1;
/* 23 */     if (append != null)
/* 24 */       name = String.valueOf(name) + " (" + String.valueOf(name) + ")"; 
/* 25 */     this.name = name;
/* 26 */     this.desc = desc;
/* 27 */     if (icon == null)
/* 28 */       icon1 = (UI.icons()).s.DUMMY; 
/* 29 */     this.icon = (SPRITE)new SPRITE.Resized((SPRITE)icon1, 16);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BSourceInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */