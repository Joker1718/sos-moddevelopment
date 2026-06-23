/*    */ package settlement.room.food.hunter;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import snake2d.util.bit.Bits;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ 
/*    */ public class Tile
/*    */ {
/* 13 */   public final Coo coo = new Coo();
/*    */   
/* 15 */   public final RoomBits reserved = new RoomBits((COORDINATE)this.coo, new Bits(1));
/* 16 */   public final RoomBits cadaver = new RoomBits((COORDINATE)this.coo, new Bits(2));
/* 17 */   static final Bits gore = new Bits(112);
/*    */ 
/*    */   
/*    */   Tile(ROOM_HUNTER h) {}
/*    */ 
/*    */   
/*    */   public Tile init(int tx, int ty, HunterInstance ins) {
/* 24 */     if (!ins.is(tx, ty))
/* 25 */       return null; 
/* 26 */     if ((SETT.ROOMS()).fData.tile.is(tx, ty, (ins.blueprintI()).constructor.ww)) {
/* 27 */       this.coo.set(tx, ty);
/* 28 */       return this;
/*    */     } 
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   void reset(HunterInstance ins, COORDINATE c) {
/* 34 */     int d = (SETT.ROOMS()).data.get(c);
/* 35 */     (SETT.ROOMS()).data.set((ROOMA)ins, c, gore.set(d, 0));
/*    */   }
/*    */   
/*    */   void gore(HunterInstance ins, COORDINATE c) {
/* 39 */     int d = (SETT.ROOMS()).data.get(c);
/* 40 */     (SETT.ROOMS()).data.set((ROOMA)ins, c, gore.inc(d, 1));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */