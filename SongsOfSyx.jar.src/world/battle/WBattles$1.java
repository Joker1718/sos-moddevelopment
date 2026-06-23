/*    */ package world.battle;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import world.WORLD;
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
/*    */   extends WORLD.WorldResourceManager
/*    */ {
/*    */   public void save(FilePutter file) {
/* 43 */     WBattles.this.regAttack.save(file);
/* 44 */     WBattles.this.poller.save(file);
/* 45 */     WBattles.this.siege.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 50 */     WBattles.this.regAttack.load(file);
/* 51 */     WBattles.this.poller.load(file);
/* 52 */     WBattles.this.siege.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 57 */     WBattles.this.regAttack.clear();
/* 58 */     WBattles.this.poller.clear();
/* 59 */     WBattles.this.siege.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\WBattles$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */