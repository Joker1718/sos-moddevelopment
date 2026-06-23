/*    */ package init.race.appearence;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.tilemap.floor.Floors;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ public final class RFloors {
/* 11 */   private final LL[] override = new LL[(SETT.ROOMS()).AMOUNT_OF_BLUEPRINTS];
/*    */ 
/*    */   
/*    */   RFloors(Json json) {
/* 15 */     (SETT.ROOMS()).collection.getClass();
/*    */   }
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
/*    */   public Floors.Floor get(RoomBlueprint b, int i, Floors.Floor backup) {
/* 30 */     LL li = this.override[b.index()];
/* 31 */     if (li == null)
/* 32 */       return backup; 
/* 33 */     if (i >= li.size())
/* 34 */       return backup; 
/* 35 */     return (Floors.Floor)li.get(i);
/*    */   }
/*    */   
/*    */   private static class LL extends ArrayListGrower<Floors.Floor> {
/*    */     private static final long serialVersionUID = 1L;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RFloors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */