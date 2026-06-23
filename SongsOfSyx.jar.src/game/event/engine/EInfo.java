/*    */ package game.event.engine;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.UI;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ public final class EInfo
/*    */ {
/* 12 */   public CharSequence name = "";
/* 13 */   public CharSequence[] messages = new CharSequence[0];
/* 14 */   public CharSequence desc = "";
/* 15 */   public CharSequence subject = "";
/* 16 */   public SPRITE icon = (SPRITE)(UI.icons()).l.event;
/*    */   public final boolean showRemaining;
/*    */   
/*    */   EInfo() {
/* 20 */     this.showRemaining = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public EInfo(Json data, Json text) throws IOException {
/* 25 */     if (text != null) {
/* 26 */       this.name = text.text("NAME", "");
/* 27 */       this.desc = text.text("DESC", "");
/* 28 */       this.messages = (CharSequence[])text.textsTry("MESSAGE");
/* 29 */       this.subject = text.text("SUBJECT", "");
/* 30 */       text.has("CHOICES");
/* 31 */       text.checkUnused();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 36 */     if (data.has("ICON"))
/* 37 */       this.icon = (SPRITE)SPRITES.icons().get(data); 
/* 38 */     this.showRemaining = data.bool("SHOW_TIME", true);
/*    */     
/* 40 */     EContext.insert.check(this.desc);
/* 41 */     EContext.insert.check(this.messages);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */