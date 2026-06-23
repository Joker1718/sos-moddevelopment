/*    */ package menu;
/*    */ 
/*    */ import game.audio.AudioFactory;
/*    */ import init.paths.PATH;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SoundEffect;
/*    */ import snake2d.util.sets.LinkedList;
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
/*    */   extends AudioFactory<SoundEffect>
/*    */ {
/*    */   null(String $anonymous0, PATH $anonymous1, SoundEffect $anonymous2) {
/* 88 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected SoundEffect create(LinkedList<SoundEffect> all, Path p, String key) {
/* 92 */     return CORE.getSoundCore().getEffect(p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\RESOURCES$RSound$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */