/*    */ package view.sett.ui.minimap;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.stats.STATS;
/*    */ import util.data.BOOLEANO;
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
/*    */   implements BOOLEANO<Humanoid>
/*    */ {
/*    */   public boolean is(Humanoid t) {
/* 74 */     if (UIMinimapSettConfigExt.this.bitsHType.get(t.indu().hType().index()) && UIMinimapSettConfigExt.this.bRaces.get(t.race().index())) {
/* 75 */       RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(t);
/* 76 */       if (ins == null)
/* 77 */         return UIMinimapSettConfigExt.this.bitUnemployed; 
/* 78 */       return UIMinimapSettConfigExt.this.bitsEmployed.get(ins.blueprint().index());
/*    */     } 
/* 80 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapSettConfigExt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */