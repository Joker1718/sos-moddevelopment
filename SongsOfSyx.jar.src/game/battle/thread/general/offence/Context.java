/*    */ package game.battle.thread.general.offence;
/*    */ 
/*    */ import init.constant.Config;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.DIMENSION;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ import snake2d.util.sets.Bitmap2D;
/*    */ import util.data.DOUBLE;
/*    */ import util.data.INT;
/*    */ 
/*    */ class Context
/*    */   implements SAVABLE {
/* 19 */   public final Bitmap2D blob = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/* 20 */   public final Bitmap2D block = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/* 21 */   public final ContextLines lines = new ContextLines();
/* 22 */   public INT.IntImp checkI = new INT.IntImp();
/* 23 */   public final DOUBLE.DoubleImp value = new DOUBLE.DoubleImp();
/* 24 */   public Bitmap1D deployedToLine = new Bitmap1D((Config.battle()).DIVISIONS_PER_ARMY, false);
/* 25 */   public int[] distsToLine = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 26 */   public int[] distsFromLineToBlob = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 27 */   public int[] trickedDivs = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 28 */   public double flanking = (RND.rFloat() * 50.0F);
/* 29 */   public final UtilDivMap map = new UtilDivMap();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 38 */     this.blob.save(file);
/* 39 */     this.block.save(file);
/* 40 */     this.lines.save(file);
/* 41 */     this.checkI.save(file);
/* 42 */     this.value.save(file);
/* 43 */     this.deployedToLine.save(file);
/* 44 */     file.isE(this.distsToLine);
/* 45 */     file.isE(this.distsFromLineToBlob);
/* 46 */     file.isE(this.trickedDivs);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 53 */     this.blob.load(file);
/* 54 */     this.block.load(file);
/* 55 */     this.lines.load(file);
/* 56 */     this.checkI.load(file);
/* 57 */     this.value.load(file);
/* 58 */     this.deployedToLine.load(file);
/* 59 */     file.isE(this.distsToLine);
/* 60 */     file.isE(this.distsFromLineToBlob);
/* 61 */     file.isE(this.trickedDivs);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 67 */     this.flanking = (RND.rFloat() * 50.0F);
/* 68 */     this.lines.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\Context.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */