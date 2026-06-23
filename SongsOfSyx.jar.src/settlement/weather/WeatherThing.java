/*    */ package settlement.weather;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import util.data.DOUBLE;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public class WeatherThing
/*    */   implements DOUBLE.DOUBLE_MUTABLE
/*    */ {
/*    */   static LinkedList<WeatherThing> all;
/*    */   private double d;
/*    */   public final INFO info;
/*    */   
/*    */   WeatherThing(CharSequence name, CharSequence desc) {
/* 19 */     this.info = new INFO(name, desc);
/* 20 */     all.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public double getD() {
/* 25 */     return this.d;
/*    */   }
/*    */ 
/*    */   
/*    */   public DOUBLE.DOUBLE_MUTABLE setD(double d) {
/* 30 */     this.d = CLAMP.d(d, 0.0D, 1.0D);
/* 31 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 36 */     return this.info;
/*    */   }
/*    */   
/*    */   protected void save(FilePutter file) {
/* 40 */     file.d(this.d);
/*    */   }
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 44 */     this.d = file.d();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void init() {}
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected double adjustTowards(double current, double speed, double target) {
/* 58 */     if (current >= target) {
/* 59 */       current -= speed;
/* 60 */       if (current < target)
/* 61 */         current = target; 
/* 62 */     } else if (current < target) {
/* 63 */       current += speed;
/* 64 */       if (current > target)
/* 65 */         current = target; 
/*    */     } 
/* 67 */     return current;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherThing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */