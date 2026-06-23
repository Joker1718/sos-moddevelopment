/*    */ package game.save;
/*    */ 
/*    */ import init.settings.S;
/*    */ import snake2d.CORE;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class AutoSaver
/*    */ {
/*  9 */   private long last = -1L;
/* 10 */   private long count = 0L;
/*    */   
/*    */   private final GameSaver saver;
/*    */   
/*    */   AutoSaver(GameSaver saver) {
/* 15 */     this.saver = saver;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void autosave(double ds) {
/* 21 */     if ((S.get()).autoSaveInterval.get() > 0 && VIEW.canSave()) {
/* 22 */       if (ds != 0.0D) {
/* 23 */         if (this.last != -1L) {
/* 24 */           this.count += CORE.getUpdateInfo().getNowMillis() - this.last;
/*    */         }
/* 26 */         this.last = CORE.getUpdateInfo().getNowMillis();
/*    */         
/* 28 */         long time = (1 + 2 * ((S.get()).autoSaveInterval.max() - (S.get()).autoSaveInterval.get()));
/* 29 */         time *= 60000L;
/*    */         
/* 31 */         if (this.count >= time && (VIEW.current()).uiManager.isGoodTimeToSave()) {
/* 32 */           save();
/* 33 */           reset();
/*    */         }
/*    */       
/*    */       } 
/*    */     } else {
/*    */       
/* 39 */       this.count = 0L;
/*    */     } 
/*    */   }
/*    */   
/*    */   private void save() {
/* 44 */     this.saver.saveNamed("AutoSave", (S.get()).autoSaveFiles.get(), true);
/*    */   }
/*    */   
/*    */   public void reset() {
/* 48 */     this.count = 0L;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\save\AutoSaver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */