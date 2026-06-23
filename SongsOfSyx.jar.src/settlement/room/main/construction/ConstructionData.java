/*    */ package settlement.room.main.construction;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.MapRoomData;
/*    */ import settlement.room.main.ROOMA;
/*    */ import snake2d.util.bit.Bits;
/*    */ 
/*    */ 
/*    */ public class ConstructionData
/*    */ {
/* 11 */   public static final Map dFloored = new Map(new Bits(1));
/*    */   
/* 13 */   public static final Map dConstructed = new Map(new Bits(2));
/*    */   
/* 15 */   public static final Map dBroken = new Map(new Bits(4));
/*    */   
/* 17 */   public static final Map dExpensive = new Map(new Bits(8));
/* 18 */   public static final Map dData = new Map(new Bits(15));
/*    */ 
/*    */   
/* 21 */   public static final Map dBlocked = new Map(new Bits(4096));
/*    */ 
/*    */   
/* 24 */   public static final Map dWall = new Map(new Bits(4080));
/*    */ 
/*    */ 
/*    */   
/* 28 */   static final Map dMarked = new Map(new Bits(16));
/*    */   
/* 30 */   static final Map dError = new Map(new Bits(32));
/*    */   
/* 32 */   static final Map dTmpInstance = new Map(new Bits(32));
/* 33 */   static final Map[] dResourceNeeded = new Map[] {
/* 34 */       new Map(new Bits(240)), 
/* 35 */       new Map(new Bits(3840)), 
/* 36 */       new Map(new Bits(61440)), 
/* 37 */       new Map(new Bits(983040))
/*    */     };
/*    */   
/* 40 */   static final Map dResourceNeededAll = new Map(new Bits(1048560));
/*    */   
/* 42 */   static final Map dResAllocated = new Map(new Bits(66060288));
/*    */   
/* 44 */   static final Map dWorkAmount = new Map(new Bits(-67108864));
/*    */ 
/*    */   
/*    */   public static final class Map
/*    */     implements MapRoomData
/*    */   {
/*    */     private final Bits bits;
/*    */     public final int max;
/*    */     
/*    */     Map(Bits bits) {
/* 54 */       this.bits = bits;
/* 55 */       this.max = bits.mask;
/*    */     }
/*    */ 
/*    */     
/*    */     public int get(int tile) {
/* 60 */       return this.bits.get((SETT.ROOMS()).data.get(tile));
/*    */     }
/*    */ 
/*    */     
/*    */     public int get(int tx, int ty) {
/* 65 */       if (SETT.IN_BOUNDS(tx, ty))
/* 66 */         return get(tx + ty * SETT.TWIDTH); 
/* 67 */       return 0;
/*    */     }
/*    */ 
/*    */     
/*    */     public void set(ROOMA r, int tile, int value) {
/* 72 */       if (value < 0 || value > this.max)
/* 73 */         throw new RuntimeException("" + value); 
/* 74 */       int d = (SETT.ROOMS()).data.get(tile);
/* 75 */       d = this.bits.set(d, value);
/* 76 */       (SETT.ROOMS()).data.set(r, tile, d);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\ConstructionData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */