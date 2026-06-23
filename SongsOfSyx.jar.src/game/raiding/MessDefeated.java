/*    */ package game.raiding;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FCredits;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ import view.ui.message.MessageSection;
/*    */ 
/*    */ final class MessDefeated extends MessageSection {
/* 13 */   private static CharSequence ¤¤title = "Raider Defeated";
/* 14 */   private static CharSequence ¤¤desc = "¤The once mighty {0} lies dead at your feet, oh mighty one. This will surely send a powerful message throughout all of Syx.";
/* 15 */   private static CharSequence ¤¤loot = "¤In addition, {HIS} personal treasury has been found and looted by our men. A total of {0} denari was found and has been transported to our treasury.";
/*    */   static {
/* 17 */     D.ts(MessDefeated.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   private final Raider raider;
/*    */ 
/*    */   
/*    */   public MessDefeated(Raider raider) {
/* 27 */     super(¤¤title);
/* 28 */     this.raider = raider;
/* 29 */     if (raider.bounty > 0) {
/* 30 */       FACTIONS.player().credits().inc(raider.bounty, FCredits.CTYPE.MISC);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void make(GuiSection section) {
/* 36 */     paragraph((CharSequence)Str.TMP.clear().add(¤¤desc).insert(0, this.raider.name));
/* 37 */     if (this.raider.bounty > 0) {
/* 38 */       Str.TMP.clear().add(¤¤loot);
/* 39 */       Str.TMP.insert("HIS", (this.raider.indu.race()).info.pHIS.get(this.raider.indu, false));
/* 40 */       Str.TMP.insert(0, (CharSequence)Str.TMP2.clear().add(this.raider.bounty, true));
/* 41 */       paragraph((CharSequence)Str.TMP);
/*    */     } 
/*    */     
/* 44 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider).dead(true));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessDefeated.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */