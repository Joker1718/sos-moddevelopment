/*    */ package game.battle.setting;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.Armies;
/*    */ import game.battle.div.Div;
/*    */ import game.save.Savable;
/*    */ import init.constant.Config;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import util.updating.IUpdater;
/*    */ 
/*    */ 
/*    */ public class BattleSettings
/*    */ {
/* 16 */   private final DivSettings[] all = new DivSettings[(Config.battle()).DIVISIONS_PER_BATTLE];
/* 17 */   private final IUpdater updater = new IUpdater((Config.battle()).DIVISIONS_PER_BATTLE, 1.0D)
/*    */     {
/*    */       protected void update(int i, double timeSinceLast)
/*    */       {
/* 21 */         BattleSettings.this.all[i].update();
/*    */       }
/*    */     };
/*    */   
/*    */   public BattleSettings(Armies armies) {
/* 26 */     for (Div d : armies.divisions()) {
/* 27 */       this.all[d.index()] = new DivSettings(d);
/*    */     }
/*    */     
/* 30 */     GAME.saver().addSpecialSaver(new Savable("BATTLE_DIV_SETTINGS") {
/*    */           protected void save(FilePutter file) { byte b;
/*    */             int i;
/*    */             DivSettings[] arrayOfDivSettings;
/* 34 */             for (i = (arrayOfDivSettings = BattleSettings.this.all).length, b = 0; b < i; ) { DivSettings s = arrayOfDivSettings[b];
/* 35 */               s.save(file);
/*    */               b++; }
/*    */              }
/*    */           protected void load(FileGetter file) throws IOException { byte b;
/*    */             int i;
/*    */             DivSettings[] arrayOfDivSettings;
/* 41 */             for (i = (arrayOfDivSettings = BattleSettings.this.all).length, b = 0; b < i; ) { DivSettings s = arrayOfDivSettings[b];
/* 42 */               s.load(file);
/*    */               b++; }
/*    */              } protected void loadFail() {
/*    */             byte b;
/*    */             int i;
/*    */             DivSettings[] arrayOfDivSettings;
/* 48 */             for (i = (arrayOfDivSettings = BattleSettings.this.all).length, b = 0; b < i; ) { DivSettings s = arrayOfDivSettings[b];
/* 49 */               s.clear();
/*    */               b++; }
/*    */           
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   public static DivSettings get(Div d) {
/* 57 */     return (GAME.ARMIES()).settings.all[d.index()];
/*    */   }
/*    */   
/*    */   public void update(double ds) {
/* 61 */     this.updater.update(ds);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(Div d) {
/* 66 */     d.settings().update();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\setting\BattleSettings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */