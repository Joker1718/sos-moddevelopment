/*    */ package game.raiding;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.ui.message.MessageSection;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class MessVictory
/*    */   extends MessageSection
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 15 */   private static CharSequence ¤¤title = "Raider Raids"; private final Raider raider;
/*    */   
/*    */   static {
/* 18 */     D.ts(MessVictory.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private String[] mm;
/*    */   
/*    */   public MessVictory(Raider raider) {
/* 25 */     super(¤¤title);
/* 26 */     this.raider = raider;
/* 27 */     this.mm = new String[raider.text.afterRaid.size()];
/* 28 */     int mi = 0;
/* 29 */     for (String s : raider.text.afterRaid)
/* 30 */       this.mm[mi++] = s; 
/*    */   } protected void make(GuiSection section) {
/*    */     byte b;
/*    */     int i;
/*    */     String[] arrayOfString;
/* 35 */     for (i = (arrayOfString = this.mm).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 36 */       paragraph(s); b++; }
/*    */     
/* 38 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessVictory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */