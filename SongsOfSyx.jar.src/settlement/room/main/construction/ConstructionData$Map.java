/*    */ package settlement.room.main.construction;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.MapRoomData;
/*    */ import settlement.room.main.ROOMA;
/*    */ import snake2d.util.bit.Bits;
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
/*    */ public final class Map
/*    */   implements MapRoomData
/*    */ {
/*    */   private final Bits bits;
/*    */   public final int max;
/*    */   
/*    */   Map(Bits bits) {
/* 54 */     this.bits = bits;
/* 55 */     this.max = bits.mask;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(int tile) {
/* 60 */     return this.bits.get((SETT.ROOMS()).data.get(tile));
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(int tx, int ty) {
/* 65 */     if (SETT.IN_BOUNDS(tx, ty))
/* 66 */       return get(tx + ty * SETT.TWIDTH); 
/* 67 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(ROOMA r, int tile, int value) {
/* 72 */     if (value < 0 || value > this.max)
/* 73 */       throw new RuntimeException("" + value); 
/* 74 */     int d = (SETT.ROOMS()).data.get(tile);
/* 75 */     d = this.bits.set(d, value);
/* 76 */     (SETT.ROOMS()).data.set(r, tile, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\ConstructionData$Map.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */