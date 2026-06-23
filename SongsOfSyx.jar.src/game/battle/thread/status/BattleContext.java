/*    */ package game.battle.thread.status;
/*    */ 
/*    */ import init.constant.Config;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ final class BattleContext
/*    */   implements SAVABLE
/*    */ {
/* 12 */   final DivStatus[] statuses = new DivStatus[(Config.battle()).DIVISIONS_PER_BATTLE];
/* 13 */   final DivsTileMap map = new DivsTileMap(this.statuses);
/* 14 */   final DivsQuadMap quads = new DivsQuadMap();
/* 15 */   final DivsSpaceMap space = new DivsSpaceMap(this.statuses);
/* 16 */   final DivArmyMap army = new DivArmyMap(this.statuses);
/*    */   
/*    */   BattleContext() {
/* 19 */     for (int i = 0; i < this.statuses.length; i++)
/* 20 */       this.statuses[i] = new DivStatus(); 
/*    */   } public void save(FilePutter file) {
/*    */     byte b;
/*    */     int i;
/*    */     DivStatus[] arrayOfDivStatus;
/* 25 */     for (i = (arrayOfDivStatus = this.statuses).length, b = 0; b < i; ) { DivStatus s = arrayOfDivStatus[b];
/* 26 */       s.save(file);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   public void load(FileGetter file) throws IOException { byte b;
/*    */     int i;
/*    */     DivStatus[] arrayOfDivStatus;
/* 33 */     for (i = (arrayOfDivStatus = this.statuses).length, b = 0; b < i; ) { DivStatus s = arrayOfDivStatus[b];
/* 34 */       s.load(file);
/*    */       b++; }
/*    */      } public void clear() {
/*    */     byte b;
/*    */     int i;
/*    */     DivStatus[] arrayOfDivStatus;
/* 40 */     for (i = (arrayOfDivStatus = this.statuses).length, b = 0; b < i; ) { DivStatus s = arrayOfDivStatus[b];
/* 41 */       s.clear();
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\BattleContext.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */