/*    */ package settlement.room.main.job;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ public class ResourceUnderflow
/*    */   implements SAVABLE
/*    */ {
/* 15 */   public int[] underflow = Alloc.ii(RESOURCES.ALL().size());
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 19 */     RESOURCES.map().saver().save(this.underflow, file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 24 */     RESOURCES.map().loader().load(this.underflow, file, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 29 */     Arrays.fill(this.underflow, 0);
/*    */   }
/*    */   
/*    */   public int withdraw(RESOURCE res, int target, int max) {
/* 33 */     if (target > max) {
/* 34 */       this.underflow[res.index()] = this.underflow[res.index()] + target - max;
/* 35 */       return max;
/*    */     } 
/* 37 */     return target;
/*    */   }
/*    */   
/*    */   public int deposit(RESOURCE res, int amount) {
/* 41 */     int u = this.underflow[res.index()];
/* 42 */     if (u > 0) {
/* 43 */       int a = Math.min(amount, u);
/* 44 */       this.underflow[res.index()] = this.underflow[res.index()] - a;
/* 45 */       return amount - a;
/*    */     } 
/* 47 */     return amount;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\ResourceUnderflow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */