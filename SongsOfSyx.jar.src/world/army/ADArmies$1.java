/*    */ package world.army;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
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
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter f) {
/* 36 */     ADArmies.this.armies.save(f);
/* 37 */     (AD.iinit()).dataT.saver().save(ADArmies.this.faction(), f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter f) throws IOException {
/* 42 */     ADArmies.this.armies.load(f);
/* 43 */     (AD.iinit()).dataT.loader().load(ADArmies.this.faction(), f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 48 */     ADArmies.this.armies.clear();
/* 49 */     Arrays.fill(ADArmies.this.data, 0L);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADArmies$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */