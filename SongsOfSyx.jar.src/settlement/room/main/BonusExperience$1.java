/*    */ package settlement.room.main;
/*    */ 
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.updating.IUpdater;
/*    */ import view.ui.message.MessageText;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 58 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(int index, double timeSinceLast) {
/* 63 */     BonusExperience.RoomExperienceBonus bo = (BonusExperience.RoomExperienceBonus)BonusExperience.all.get(index);
/*    */     
/* 65 */     int am = bo.blue.employment().employed();
/*    */     
/* 67 */     if (BonusExperience.this.currents[index] < bo.minEmployed && am >= bo.minEmployed && (BonusExperience.this.sent[index] & 0x1) == 0) {
/* 68 */       MessageText m = new MessageText(BonusExperience.¤¤mGainedTitle);
/* 69 */       Str s = Str.TMP;
/* 70 */       s.clear();
/* 71 */       s.add(BonusExperience.¤¤mGainedBody);
/* 72 */       s.insert(0, bo.minEmployed);
/* 73 */       s.insert(1, bo.blue.info.names);
/* 74 */       s.insert(2, bo.maxEmployed);
/* 75 */       m.paragraph((CharSequence)s);
/* 76 */       m.send();
/* 77 */       BonusExperience.this.sent[index] = (byte)(BonusExperience.this.sent[index] | 0x1);
/* 78 */     } else if (BonusExperience.this.currents[index] >= bo.minEmployed && am < bo.minEmployed && (BonusExperience.this.sent[index] & 0x2) == 0) {
/* 79 */       MessageText m = new MessageText(BonusExperience.¤¤mLostTitle);
/*    */       
/* 81 */       Str s = Str.TMP;
/* 82 */       s.clear();
/* 83 */       s.add(BonusExperience.¤¤mLostBody);
/* 84 */       s.insert(0, bo.blue.info.names);
/*    */       
/* 86 */       m.paragraph((CharSequence)s);
/* 87 */       m.send();
/* 88 */       BonusExperience.this.sent[index] = (byte)(BonusExperience.this.sent[index] | 0x2);
/*    */     } 
/* 90 */     BonusExperience.this.currents[index] = am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\BonusExperience$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */