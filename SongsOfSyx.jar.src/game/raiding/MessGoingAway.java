/*    */ package game.raiding;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ import view.ui.message.MessageSection;
/*    */ 
/*    */ 
/*    */ final class MessGoingAway
/*    */   extends MessageSection
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 15 */   private static CharSequence ¤¤title = "Raider Retreats";
/* 16 */   private static CharSequence ¤¤desc = "Due to unknown reasons, {0} has turned back {1} army and left our lands. Lets pray {2} never returns.";
/*    */   
/*    */   static {
/* 19 */     D.ts(MessGoingAway.class);
/*    */   }
/*    */   
/*    */   private final Raider raider;
/*    */   
/*    */   public MessGoingAway(Raider raider) {
/* 25 */     super(¤¤title);
/* 26 */     this.raider = raider;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void make(GuiSection section) {
/* 31 */     Str s = Str.TMP.clear();
/* 32 */     s.add(¤¤desc);
/* 33 */     s.insert(0, this.raider.name);
/* 34 */     s.insert(1, (this.raider.indu.race()).info.pHIS.get(this.raider.indu, false));
/* 35 */     s.insert(2, (this.raider.indu.race()).info.pHE.get(this.raider.indu, false));
/* 36 */     paragraph((CharSequence)s);
/*    */     
/* 38 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessGoingAway.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */