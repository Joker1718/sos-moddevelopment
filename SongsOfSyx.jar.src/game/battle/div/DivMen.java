/*    */ package game.battle.div;
/*    */ 
/*    */ import init.constant.Config;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ final class DivMen
/*    */   implements SAVABLE
/*    */ {
/*    */   private final short[] order;
/*    */   private final short[] orderR;
/* 14 */   private short orderI = 0;
/*    */   
/*    */   DivMen() {
/* 17 */     this.orderR = new short[(Config.battle()).MEN_PER_DIVISION];
/* 18 */     this.order = new short[(Config.battle()).MEN_PER_DIVISION];
/* 19 */     clear();
/*    */   }
/*    */   
/*    */   short getSpot(int i) {
/* 23 */     return this.orderR[i];
/*    */   }
/*    */   
/*    */   short spotTranslate(int i) {
/* 27 */     return this.order[i];
/*    */   }
/*    */   
/*    */   int freeSpots() {
/* 31 */     return this.order.length - this.orderI;
/*    */   }
/*    */   
/*    */   public int men() {
/* 35 */     return this.orderI;
/*    */   }
/*    */   
/*    */   public short getNewSpot() {
/* 39 */     if (freeSpots() <= 0)
/* 40 */       throw new RuntimeException(); 
/* 41 */     short spot = this.order[this.orderI];
/* 42 */     this.orderR[spot] = this.orderI;
/* 43 */     this.orderI = (short)(this.orderI + 1);
/*    */     
/* 45 */     return spot;
/*    */   }
/*    */   
/*    */   public void returnSpot(short spot) {
/* 49 */     if (this.orderI == 0)
/* 50 */       throw new RuntimeException(); 
/* 51 */     if (this.orderI == 1) {
/* 52 */       this.orderI = 0;
/*    */       return;
/*    */     } 
/* 55 */     int spotLast = this.order[this.orderI - 1];
/* 56 */     int orderIA = this.orderR[spot];
/* 57 */     if (orderIA >= this.orderI) {
/* 58 */       throw new RuntimeException("" + orderIA + " " + orderIA);
/*    */     }
/* 60 */     this.order[orderIA] = (short)spotLast;
/* 61 */     this.order[this.orderI - 1] = spot;
/*    */     
/* 63 */     this.orderR[spot] = -1;
/* 64 */     this.orderR[spotLast] = (short)orderIA;
/*    */     
/* 66 */     this.orderI = (short)(this.orderI - 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 73 */     file.ss(this.order);
/* 74 */     file.ss(this.orderR);
/* 75 */     file.i(this.orderI);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 80 */     file.ss(this.order);
/* 81 */     file.ss(this.orderR);
/* 82 */     this.orderI = (short)file.i();
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 87 */     for (int i = 0; i < this.order.length; i++) {
/* 88 */       this.order[i] = (short)i;
/* 89 */       this.orderR[i] = -1;
/*    */     } 
/* 91 */     this.orderI = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\div\DivMen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */