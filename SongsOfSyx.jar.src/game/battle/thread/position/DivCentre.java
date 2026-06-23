/*    */ package game.battle.thread.position;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public final class DivCentre
/*    */   implements SAVABLE
/*    */ {
/*    */   int cx;
/*    */   int cy;
/*    */   int cxSoft;
/*    */   int cySoft;
/*    */   int squareCX;
/*    */   int squareCY;
/*    */   short inPosition;
/*    */   
/*    */   public void save(FilePutter file) {
/* 26 */     file.s(this.inPosition);
/* 27 */     file.i(this.cx).i(this.cy);
/* 28 */     file.i(this.cxSoft).i(this.cySoft);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 33 */     this.inPosition = file.s();
/* 34 */     this.cx = file.i();
/* 35 */     this.cy = file.i();
/* 36 */     this.cxSoft = file.i();
/* 37 */     this.cySoft = file.i();
/* 38 */     this.squareCX = file.i();
/* 39 */     this.squareCY = file.i();
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 44 */     this.cx = -1;
/* 45 */     this.cy = -1;
/* 46 */     this.cxSoft = -1;
/* 47 */     this.cySoft = -1;
/* 48 */     this.inPosition = 0;
/* 49 */     this.squareCX = -1;
/* 50 */     this.squareCY = -1;
/*    */   }
/*    */   
/*    */   public int cUnitX() {
/* 54 */     return this.cx;
/*    */   }
/*    */   
/*    */   public int cUnitY() {
/* 58 */     return this.cy;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int cX() {
/* 66 */     return this.cxSoft;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int cY() {
/* 74 */     return this.cySoft;
/*    */   }
/*    */   
/*    */   public int inFormation() {
/* 78 */     return this.inPosition;
/*    */   }
/*    */   
/*    */   public int squareCX() {
/* 82 */     return this.squareCX;
/*    */   }
/*    */   
/*    */   public int squareCY() {
/* 86 */     return this.squareCY;
/*    */   }
/*    */   
/*    */   public int ctX() {
/* 90 */     return this.cxSoft / 64;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int ctY() {
/* 98 */     return this.cySoft / 64;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\position\DivCentre.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */