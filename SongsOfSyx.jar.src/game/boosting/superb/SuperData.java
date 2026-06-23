/*    */ package game.boosting.superb;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ public class SuperData
/*    */   implements SAVABLE
/*    */ {
/*    */   private final SuperBoostable<?> daddy;
/*    */   private double[] values;
/*    */   private double[] times;
/*    */   private double[] state;
/*    */   
/*    */   SuperData(SuperBoostable<?> daddy) {
/* 18 */     this.daddy = daddy;
/*    */   }
/*    */   
/*    */   private void init() {
/* 22 */     if (this.values == null || this.values.length != this.daddy.ups.size()) {
/* 23 */       this.values = new double[this.daddy.ups.size()];
/* 24 */       this.times = new double[this.daddy.ups.size()];
/* 25 */       this.state = new double[this.daddy.ups.size()];
/*    */     } 
/*    */   }
/*    */   
/*    */   double[] values() {
/* 30 */     init();
/* 31 */     return this.values;
/*    */   }
/*    */   
/*    */   double[] times() {
/* 35 */     init();
/* 36 */     return this.times;
/*    */   }
/*    */   
/*    */   double[] states() {
/* 40 */     init();
/* 41 */     return this.state;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 46 */     init();
/* 47 */     for (int i = 0; i < this.values.length; i++) {
/* 48 */       file.d(this.values[i]);
/* 49 */       file.d(this.times[i]);
/* 50 */       file.d(this.state[i]);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 56 */     init();
/* 57 */     clear();
/*    */     
/* 59 */     int[] so = this.daddy.saveOrder();
/* 60 */     for (int i = 0; i < so.length; i++) {
/* 61 */       double v = file.d();
/* 62 */       double t = file.d();
/* 63 */       double s = file.d();
/* 64 */       if (so[i] >= 0 && so[i] < this.values.length) {
/* 65 */         this.values[so[i]] = v;
/* 66 */         this.times[so[i]] = t;
/* 67 */         this.state[so[i]] = s;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 74 */     init();
/* 75 */     Arrays.fill(this.values, 0.0D);
/* 76 */     Arrays.fill(this.times, 0.0D);
/* 77 */     Arrays.fill(this.state, 0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */