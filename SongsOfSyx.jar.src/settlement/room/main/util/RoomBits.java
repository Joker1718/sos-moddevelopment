/*    */ package settlement.room.main.util;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import snake2d.util.bit.Bits;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.data.INT;
/*    */ 
/*    */ public class RoomBits
/*    */   implements INT {
/*    */   protected final Bits bits;
/*    */   private final COORDINATE coo;
/*    */   
/*    */   public RoomBits(COORDINATE coo, int mask) {
/* 17 */     this.bits = new Bits(mask);
/* 18 */     this.coo = coo;
/*    */   }
/*    */   
/*    */   public RoomBits(COORDINATE coo, Bits bits) {
/* 22 */     this.bits = bits;
/* 23 */     this.coo = coo;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 28 */     return this.bits.get((SETT.ROOMS()).data.get(this.coo));
/*    */   }
/*    */   
/*    */   public int get(int rawData) {
/* 32 */     return this.bits.get(rawData);
/*    */   }
/*    */   
/*    */   public int get(int tx, int ty) {
/* 36 */     return this.bits.get((SETT.ROOMS()).data.get(tx, ty));
/*    */   }
/*    */ 
/*    */   
/*    */   public int min() {
/* 41 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 46 */     return this.bits.mask;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void remove() {}
/*    */ 
/*    */   
/*    */   protected void add() {}
/*    */ 
/*    */   
/*    */   public void set(ROOMA r, int t) {
/* 58 */     remove();
/* 59 */     set(this.coo.x(), this.coo.y(), r, t);
/* 60 */     add();
/*    */   }
/*    */   
/*    */   public void set(ROOMA r, DIR d, int t) {
/* 64 */     remove();
/* 65 */     set(this.coo.x() + d.x(), this.coo.y() + d.y(), r, t);
/* 66 */     add();
/*    */   }
/*    */   
/*    */   public void set(int tx, int ty, ROOMA r, int t) {
/* 70 */     int d = (SETT.ROOMS()).data.get(tx, ty);
/* 71 */     d = this.bits.set(d, t);
/* 72 */     (SETT.ROOMS()).data.set(r, tx, ty, d);
/*    */   }
/*    */   
/*    */   public void inc(ROOMA r, int i) {
/* 76 */     set(r, CLAMP.i(get() + i, 0, this.bits.mask));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomBits.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */