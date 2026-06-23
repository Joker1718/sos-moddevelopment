/*    */ package util.data;
/*    */ 
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.map.MAP_INT;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ public final class RANMAP
/*    */   implements MAP_INT {
/*  9 */   private final int SIZE = 128;
/* 10 */   private final int yScroll = Integer.numberOfTrailingZeros(128);
/* 11 */   private final int tMaskX = 127;
/* 12 */   private final int tMask = 16383;
/*    */   
/* 14 */   private final int[] ran = Alloc.ii(16384);
/*    */   
/*    */   public RANMAP() {
/* 17 */     for (int i = 0; i < this.ran.length; i++) {
/* 18 */       this.ran[i] = RND.rInt() & Integer.MAX_VALUE;
/*    */     }
/*    */   }
/*    */   
/*    */   public int get(int tile) {
/* 23 */     return this.ran[tile & 0x3FFF];
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(int tx, int ty) {
/* 28 */     tx &= 0x7F;
/* 29 */     ty &= 0x7F;
/* 30 */     return this.ran[tx + (ty << this.yScroll)];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\RANMAP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */