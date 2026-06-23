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
/*    */ final class MessDemandRejected
/*    */   extends MessageSection
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 16 */   private static CharSequence ¤¤title = "Raider Rejected";
/* 17 */   private static CharSequence ¤¤body = "This is ill news for us indeed. Perhaps we should have paid the ransom. Now we must prepare for an attack.";
/*    */   
/*    */   static {
/* 20 */     D.ts(MessDemandRejected.class);
/*    */   }
/*    */   
/*    */   private final Raider raider;
/*    */   
/*    */   public MessDemandRejected(Raider raider) {
/* 26 */     super(¤¤title);
/* 27 */     this.raider = raider;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void make(GuiSection section) {
/* 33 */     for (String s : this.raider.text.rejected) {
/* 34 */       paragraph(s);
/*    */     }
/* 36 */     section.addRelBody(16, DIR.S, (SPRITE)(new GText((UI.FONT()).S, ¤¤body)).lablifySub().setMaxWidth(900));
/*    */     
/* 38 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessDemandRejected.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */