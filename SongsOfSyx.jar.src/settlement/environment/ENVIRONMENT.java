/*    */ package settlement.environment;
/*    */ 
/*    */ import game.debug.Profiler;
/*    */ import init.type.CLIMATE;
/*    */ import init.type.CLIMATES;
/*    */ import java.io.IOException;
/*    */ import settlement.main.CapitolArea;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ public final class ENVIRONMENT
/*    */   extends SETT.SettResource
/*    */ {
/* 15 */   private CLIMATE climate = CLIMATES.COLD();
/* 16 */   public final SettEnvMap map = new SettEnvMap();
/*    */   public final Foundation foundation;
/*    */   
/*    */   public ENVIRONMENT() throws IOException {
/* 20 */     super("ENVIRONMENT", true);
/* 21 */     this.foundation = new Foundation();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void generate(CapitolArea area) {
/* 29 */     this.climate = area.climate();
/* 30 */     this.foundation.generate();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {
/* 35 */     file.i(this.climate.index());
/* 36 */     this.foundation.saver.save(file);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(double ds, Profiler profiler) {
/* 42 */     this.map.update(ds);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init(boolean loaded) {
/* 47 */     this.map.init();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 52 */     this.climate = (CLIMATE)CLIMATES.ALL().get(file.i());
/* 53 */     this.foundation.saver.load(file);
/*    */   }
/*    */   
/*    */   public CLIMATE climate() {
/* 57 */     return this.climate;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\ENVIRONMENT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */