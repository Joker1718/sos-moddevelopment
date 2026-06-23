/*    */ package settlement.weather;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ 
/*    */ public final class WeatherGrowthRipe
/*    */   extends WeatherThing
/*    */ {
/*    */   private static final double ripeStart = 0.125D;
/*    */   private static final double ripeEnd = 0.625D;
/* 16 */   private double d = 0.0D;
/*    */   WeatherGrowthRipe() {
/* 18 */     super("Ripness", "");
/*    */   }
/*    */   
/*    */   private boolean ripening;
/*    */   private boolean ripe;
/*    */   
/*    */   public boolean cropsAreRipe() {
/* 25 */     return this.ripe;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 33 */     this.ripening = false;
/* 34 */     double part = TIME.years().bitPartOf();
/* 35 */     if (part > 0.625D) {
/* 36 */       this.d = CLAMP.d(1.0D - (part - 0.625D) * 4.0D, 0.0D, 1.0D);
/* 37 */     } else if (part > 0.125D) {
/* 38 */       this.ripening = true;
/* 39 */       this.d = CLAMP.d((part - 0.125D) * 4.0D, 0.0D, 1.0D);
/*    */     } else {
/* 41 */       this.d = 0.0D;
/*    */     } 
/*    */     
/* 44 */     this.ripening |= (getD() > 0.0D) ? 1 : 0;
/* 45 */     this.ripe = (getD() == 1.0D && (SETT.WEATHER()).moisture.getD() > 0.25D);
/* 46 */     setD(this.d);
/* 47 */     super.update(ds);
/*    */   }
/*    */   
/*    */   public boolean ripening() {
/* 51 */     return this.ripening;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 56 */     update(0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {
/* 61 */     super.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 66 */     super.load(file);
/* 67 */     update(0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherGrowthRipe.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */