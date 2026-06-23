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
/*    */ final class MessDemandTY
/*    */   extends MessageSection
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 16 */   private static CharSequence ¤¤title = "Raider Satisfied";
/* 17 */   private static CharSequence ¤¤body = "Since we paid the ransom, this raider will leave us alone. For now...";
/*    */   
/*    */   static {
/* 20 */     D.ts(MessDemandTY.class);
/*    */   }
/*    */   
/*    */   private final Raider raider;
/*    */   
/*    */   public MessDemandTY(Raider raider) {
/* 26 */     super(¤¤title);
/* 27 */     this.raider = raider;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void make(GuiSection section) {
/* 33 */     for (String s : this.raider.text.payed) {
/* 34 */       paragraph(s);
/*    */     }
/* 36 */     section.addRelBody(16, DIR.S, (SPRITE)(new GText((UI.FONT()).S, ¤¤body)).lablifySub().setMaxWidth(900));
/*    */     
/* 38 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessDemandTY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */