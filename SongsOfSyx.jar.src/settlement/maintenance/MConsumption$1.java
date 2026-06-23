/*    */ package settlement.maintenance;
/*    */ 
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.path.AvailabilityListener;
/*    */ import snake2d.util.map.AbsGrid;
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
/* 33 */     if (m.disabled.is(tx, ty))
/*    */       return; 
/* 35 */     int in = ((AbsGrid.GridTile)MConsumption.this.grid.map.get(tx, ty)).index;
/* 36 */     (MConsumption.this.datas[in]).changed = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\MConsumption$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */