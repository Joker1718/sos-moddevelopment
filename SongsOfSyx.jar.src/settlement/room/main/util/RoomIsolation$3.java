/*    */ package settlement.room.main.util;
/*    */ 
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.path.AvailabilityListener;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends AvailabilityListener
/*    */ {
/*    */   protected void changed(int tx, int ty, AVAILABILITY a, AVAILABILITY old, boolean playerChange) {
/* 56 */     RoomIsolation.this.setChanged(tx, ty, a, old);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomIsolation$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */