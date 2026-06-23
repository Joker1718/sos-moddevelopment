/*    */ package world.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.misc.ACTION;
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
/* 53 */     for (ADArmies a : AD.this.fArmies)
/* 54 */       a.saver.save(file); 
/* 55 */     AD.this.updater.save(file);
/* 56 */     AD.this.updaterDiv.save(file);
/* 57 */     AD.this.AI.saver.save(file);
/* 58 */     AD.this.divsCity.save(file);
/* 59 */     AD.this.divsMerc.save(file);
/* 60 */     AD.this.divsReg.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 65 */     for (ADArmies a : AD.this.fArmies)
/* 66 */       a.saver.load(file); 
/* 67 */     AD.this.updater.load(file);
/* 68 */     AD.this.updaterDiv.load(file);
/* 69 */     AD.this.AI.saver.load(file);
/* 70 */     AD.this.divsCity.load(file);
/* 71 */     AD.this.divsMerc.load(file);
/* 72 */     AD.this.divsReg.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 77 */     for (ADArmies a : AD.this.fArmies)
/* 78 */       a.saver.clear(); 
/* 79 */     AD.this.updater.clear();
/* 80 */     AD.this.updaterDiv.clear();
/* 81 */     AD.this.AI.saver.clear();
/*    */     
/* 83 */     AD.this.divsReg.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public void generate(ACTION loadPrint) {
/* 88 */     for (Faction f : FACTIONS.all()) {
/* 89 */       if (f.isActive()) {
/* 90 */         for (ACTION.ACTION_O<Faction> a : AD.this.init.inits) {
/* 91 */           a.exe(f);
/*    */         }
/* 93 */         AD.this.AI.init(f);
/*    */       } 
/*    */     } 
/*    */     
/* 97 */     AD.mercenaries().randmoize();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\AD$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */