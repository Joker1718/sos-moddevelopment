/*    */ package settlement.room.food.cannibal;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import snake2d.util.bit.Bits;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ public class Cage {
/*    */   private final ROOM_CANNIBAL b;
/*    */   private CannibalInstance ins;
/* 13 */   private Coo coo = new Coo();
/*    */ 
/*    */   
/* 16 */   private final int sNone = 0;
/* 17 */   private final int sReserved = 1;
/* 18 */   private final int sInside = 2;
/* 19 */   private final int sFetching = 3;
/*    */   
/* 21 */   private final RoomBits state = new RoomBits((COORDINATE)this.coo, new Bits(7))
/*    */     {
/*    */       protected void remove()
/*    */       {
/* 25 */         if (get() > 0) {
/* 26 */           Cage.this.ins.prisoners = (short)(Cage.this.ins.prisoners - 1);
/* 27 */           Cage.this.b.prisoners--;
/*    */         } 
/* 29 */         if (get() == 2) {
/* 30 */           Cage.this.ins.reservable = (short)(Cage.this.ins.reservable - 1);
/*    */         }
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       protected void add() {
/* 37 */         if (get() > 0) {
/* 38 */           Cage.this.ins.prisoners = (short)(Cage.this.ins.prisoners + 1);
/* 39 */           Cage.this.b.prisoners++;
/*    */         } 
/* 41 */         if (get() == 2) {
/* 42 */           Cage.this.ins.reservable = (short)(Cage.this.ins.reservable + 1);
/*    */         }
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   Cage(ROOM_CANNIBAL print) {
/* 49 */     this.b = print;
/*    */   }
/*    */ 
/*    */   
/*    */   Cage get(int tx, int ty) {
/* 54 */     this.ins = (CannibalInstance)this.b.get(tx, ty);
/* 55 */     if (this.ins != null && (SETT.ROOMS()).fData.tile.is(tx, ty, (this.ins.blueprintI()).constructor.cc)) {
/* 56 */       this.coo.set(tx, ty);
/* 57 */       return this;
/*    */     } 
/* 59 */     return null;
/*    */   }
/*    */   
/*    */   public boolean available() {
/* 63 */     return (this.state.get() == 0);
/*    */   }
/*    */   
/*    */   public void prisonerReserve() {
/* 67 */     this.state.set((ROOMA)this.ins, 1);
/*    */   }
/*    */   
/*    */   public void prisonerArrive() {
/* 71 */     this.state.set((ROOMA)this.ins, 2);
/*    */   }
/*    */   
/*    */   public boolean prisonerOk() {
/* 75 */     return (this.state.get() != 0);
/*    */   }
/*    */   
/*    */   public void prisonerCancel() {
/* 79 */     this.state.set((ROOMA)this.ins, 0);
/*    */   }
/*    */   
/*    */   public boolean canGrab() {
/* 83 */     return (this.state.get() == 2);
/*    */   }
/*    */   
/*    */   public void grab() {
/* 87 */     this.state.set((ROOMA)this.ins, 3);
/*    */   }
/*    */   
/*    */   public void grabCancel() {
/* 91 */     if (this.state.get() == 3)
/* 92 */       this.state.set((ROOMA)this.ins, 2); 
/*    */   }
/*    */   
/*    */   public COORDINATE coo() {
/* 96 */     return (COORDINATE)this.coo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\cannibal\Cage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */