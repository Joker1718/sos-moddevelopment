/*    */ package settlement.battle;
/*    */ 
/*    */ import game.debug.Profiler;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ 
/*    */ public final class SBattle
/*    */   extends SETT.SettResource
/*    */ {
/* 13 */   public final BannerRenderer bannerR = new BannerRenderer();
/*    */   public final ArmyTrainingInfo info;
/*    */   private double ti;
/*    */   
/*    */   public SBattle(SETT sett) {
/* 18 */     super("battle", false);
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
/* 37 */     this.ti = 0.0D;
/*    */     this.info = new ArmyTrainingInfo();
/*    */   } protected void update(double ds, Profiler profiler) {
/* 40 */     this.ti += ds;
/* 41 */     if (this.ti > 0.1D) {
/* 42 */       this.ti -= 0.1D;
/* 43 */       this.info.update();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void save(FilePutter file) {
/*    */     this.info.saver.save(file);
/*    */   }
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/*    */     this.info.saver.load(file);
/*    */   }
/*    */   
/*    */   protected void clear() {
/*    */     this.info.saver.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\SBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */