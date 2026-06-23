/*    */ package view.battle.editor;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.time.TIME;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.rnd.RND;
/*    */ import view.world.generator.WorldViewGenerator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 59 */     int time = RND.rInt(100);
/* 60 */     TIME.set((TIME.secondsPerDay() * time / 100));
/* 61 */     WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/* 62 */     WORLD.LANDMARKS().saver().generate(WorldViewGenerator.loadPrint);
/* 63 */     WorldViewGenerator.loadPrint.exe();
/* 64 */     WORLD.MINIMAP().repaint();
/* 65 */     WorldViewGenerator.loadPrint.exe();
/* 66 */     (WORLD.GEN()).hasGeneratedTerrain = true;
/* 67 */     (FACTIONS.otherFaction()).bonus.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\Placer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */