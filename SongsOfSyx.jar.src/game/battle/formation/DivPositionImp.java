/*    */ package game.battle.formation;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ 
/*    */ public class DivPositionImp
/*    */   implements DivPosition, SAVABLE
/*    */ {
/* 15 */   private int deployed = 0;
/*    */   private final int half;
/*    */   private final int[] coos;
/* 18 */   private final Coo coo = new Coo();
/*    */   
/*    */   DivPositionImp(int maxMen) {
/* 21 */     this.coos = Alloc.ii(maxMen * 2);
/* 22 */     this.half = maxMen;
/*    */   }
/*    */ 
/*    */   
/*    */   public COORDINATE tile(int i) {
/* 27 */     if (i >= this.deployed)
/* 28 */       return null; 
/* 29 */     this.coo.set((this.coos[i] >> 6), (this.coos[i + this.half] >> 6));
/* 30 */     return (COORDINATE)this.coo;
/*    */   }
/*    */ 
/*    */   
/*    */   public COORDINATE pixel(int i) {
/* 35 */     if (i >= this.deployed)
/* 36 */       return null; 
/* 37 */     this.coo.set(this.coos[i], this.coos[i + this.half]);
/* 38 */     return (COORDINATE)this.coo;
/*    */   }
/*    */ 
/*    */   
/*    */   public int px(int i) {
/* 43 */     return this.coos[i];
/*    */   }
/*    */ 
/*    */   
/*    */   public int py(int i) {
/* 48 */     return this.coos[i + this.half];
/*    */   }
/*    */ 
/*    */   
/*    */   public int tx(int i) {
/* 53 */     return this.coos[i] >> 6;
/*    */   }
/*    */ 
/*    */   
/*    */   public int ty(int i) {
/* 58 */     return this.coos[i + this.half] >> 6;
/*    */   }
/*    */   
/*    */   public void init(int men) {
/* 62 */     if (men != this.deployed) {
/* 63 */       this.deployed = men;
/*    */     }
/*    */   }
/*    */   
/*    */   public void set(int i, int x, int y) {
/* 68 */     this.coos[i] = x;
/* 69 */     this.coos[i + this.half] = y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 74 */     file.i(this.deployed);
/* 75 */     file.is(this.coos);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 80 */     this.deployed = file.i();
/* 81 */     file.is(this.coos);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 86 */     this.deployed = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int deployed() {
/* 91 */     return this.deployed;
/*    */   }
/*    */   
/*    */   public void copyposition(DivPosition pos) {
/* 95 */     this.deployed = pos.deployed();
/* 96 */     for (int i = 0; i < this.deployed; i++) {
/* 97 */       this.coos[i] = pos.px(i);
/* 98 */       this.coos[i + this.half] = pos.py(i);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivPositionImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */