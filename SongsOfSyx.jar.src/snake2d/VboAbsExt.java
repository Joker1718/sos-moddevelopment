/*    */ package snake2d;
/*    */ 
/*    */ import snake2d.util.file.Alloc;
/*    */ 
/*    */ 
/*    */ abstract class VboAbsExt
/*    */   extends VboAbs
/*    */ {
/*  9 */   protected int count = 0;
/*    */   
/* 11 */   protected int[] vFrom = Alloc.ii(255);
/* 12 */   protected int[] vTo = Alloc.ii(255);
/* 13 */   protected int current = 0;
/*    */   
/*    */   VboAbsExt(int type, int maxElements, VboAbs.VboAttribute... attributes) {
/* 16 */     super(type, maxElements, attributes);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void clear() {
/* 24 */     super.clear();
/* 25 */     this.current = 0;
/* 26 */     this.count = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VboAbsExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */