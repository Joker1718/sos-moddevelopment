/*    */ package game.raiding;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.D;
/*    */ import view.ui.message.MessageSection;
/*    */ 
/*    */ 
/*    */ final class MessCustom
/*    */   extends MessageSection
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 16 */   private static CharSequence ¤¤title = "Raider";
/*    */   private String body;
/*    */   
/*    */   static {
/* 20 */     D.ts(MessCustom.class);
/*    */   }
/*    */   
/*    */   private final Raider raider;
/*    */   
/*    */   public MessCustom(Raider raider, String body) {
/* 26 */     super(¤¤title);
/* 27 */     this.raider = raider;
/* 28 */     this.body = body;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void make(GuiSection section) {
/* 34 */     for (String s : this.raider.text.payed) {
/* 35 */       paragraph(s);
/*    */     }
/* 37 */     section.addRelBody(16, DIR.S, (SPRITE)(new GText((UI.FONT()).S, this.body)).lablifySub().setMaxWidth(900));
/*    */     
/* 39 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessCustom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */