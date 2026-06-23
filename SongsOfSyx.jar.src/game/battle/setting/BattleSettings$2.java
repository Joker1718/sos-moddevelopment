/*    */ package game.battle.setting;
/*    */ 
/*    */ import game.save.Savable;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
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
/*    */   extends Savable
/*    */ {
/*    */   null(String $anonymous0) {
/* 30 */     super($anonymous0);
/*    */   } protected void save(FilePutter file) { byte b;
/*    */     int i;
/*    */     DivSettings[] arrayOfDivSettings;
/* 34 */     for (i = (arrayOfDivSettings = BattleSettings.this.all).length, b = 0; b < i; ) { DivSettings s = arrayOfDivSettings[b];
/* 35 */       s.save(file);
/*    */       b++; }
/*    */      }
/*    */   protected void load(FileGetter file) throws IOException { byte b;
/*    */     int i;
/*    */     DivSettings[] arrayOfDivSettings;
/* 41 */     for (i = (arrayOfDivSettings = BattleSettings.this.all).length, b = 0; b < i; ) { DivSettings s = arrayOfDivSettings[b];
/* 42 */       s.load(file);
/*    */       b++; }
/*    */      } protected void loadFail() {
/*    */     byte b;
/*    */     int i;
/*    */     DivSettings[] arrayOfDivSettings;
/* 48 */     for (i = (arrayOfDivSettings = BattleSettings.this.all).length, b = 0; b < i; ) { DivSettings s = arrayOfDivSettings[b];
/* 49 */       s.clear();
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\setting\BattleSettings$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */