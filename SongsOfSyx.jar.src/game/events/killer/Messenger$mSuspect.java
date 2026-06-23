/*     */ package game.events.killer;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class mSuspect
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String mess1;
/*     */   private final String mess2;
/*     */   private final String quest;
/*     */   private final int supsect;
/*     */   private final int murders;
/*     */   private final int killer;
/*     */   
/*     */   mSuspect(CharSequence title, CharSequence mess1, CharSequence mess2, CharSequence quest, int suspect, int murders, int killer) {
/* 163 */     super(title);
/* 164 */     this.mess1 = String.valueOf(mess1);
/* 165 */     this.mess2 = String.valueOf(mess2);
/* 166 */     this.quest = String.valueOf(quest);
/* 167 */     this.supsect = suspect;
/* 168 */     this.murders = murders;
/* 169 */     this.killer = killer;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 174 */     paragraph(this.mess1);
/* 175 */     paragraph(this.mess2);
/* 176 */     paragraph(this.quest);
/*     */     
/* 178 */     section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Yes)
/*     */         {
/*     */           protected void clickA() {
/* 181 */             if (Messenger.mSuspect.this.murders == (GAME.events()).killer.murders() && (GAME.events()).killer.theKiller() != null && (GAME.events()).killer.theKiller().id() == Messenger.mSuspect.this.killer)
/* 182 */               (GAME.events()).killer.setSuspect(Messenger.mSuspect.this.supsect); 
/* 183 */             Messenger.mSuspect.this.close();
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 187 */             activeSet(((GAME.events()).killer.suspect() == -1 && Messenger.mSuspect.this.murders == (GAME.events()).killer.murders() && (GAME.events()).killer.theKiller() != null && (GAME.events()).killer.theKiller().id() == Messenger.mSuspect.this.killer));
/*     */           }
/*     */         });
/*     */     
/* 191 */     section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤No)
/*     */         {
/*     */           protected void clickA() {
/* 194 */             Messenger.mSuspect.this.close();
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 198 */             activeSet(((GAME.events()).killer.suspect() == -1 && Messenger.mSuspect.this.murders == (GAME.events()).killer.murders() && (GAME.events()).killer.theKiller() != null && (GAME.events()).killer.theKiller().id() == Messenger.mSuspect.this.killer));
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\Messenger$mSuspect.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */