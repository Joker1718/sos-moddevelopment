/*    */ package settlement.room.health.asylum;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import snake2d.util.bit.Bit;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ final class Cell {
/*  9 */   private static final Bit reserved = new Bit(1);
/* 10 */   final Coo coo = new Coo();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 16 */   private static Cell self = new Cell();
/*    */   
/*    */   private AsylumInstance ins;
/*    */   
/*    */   static Cell init(int tx, int ty) {
/* 21 */     self.ins = (AsylumInstance)b().get(tx, ty);
/* 22 */     if (self.ins == null || (SETT.ROOMS()).fData.tileData.get(tx, ty) != 1) {
/* 23 */       return null;
/*    */     }
/* 25 */     self.coo.set(tx, ty);
/* 26 */     return self;
/*    */   }
/*    */ 
/*    */   
/*    */   public void reserve() {
/* 31 */     if (!reservedIs()) {
/* 32 */       int d = reserved.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 33 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/* 34 */       this.ins.inc(1);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void reserveCancel() {
/* 39 */     if (reservedIs()) {
/* 40 */       int d = reserved.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 41 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/* 42 */       this.ins.inc(-1);
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean reservedIs() {
/* 47 */     return reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*    */   }
/*    */   
/*    */   private static final ROOM_ASYLUM b() {
/* 51 */     return (SETT.ROOMS()).ASYLUM;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\Cell.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */