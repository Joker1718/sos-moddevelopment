/*    */ package init.race.appearence;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.tilemap.floor.Floors;
/*    */ import snake2d.util.file.Json;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RMAP<RoomBlueprint>.KJson
/*    */ {
/*    */   null(RMAP paramRMAP, String $anonymous0, Json $anonymous1) {
/* 15 */     super(paramRMAP, $anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void process(RoomBlueprint s, Json j, String key, boolean isWeak) {
/* 19 */     if (RFloors.this.override[s.index()] == null)
/* 20 */       RFloors.this.override[s.index()] = new RFloors.LL(); 
/* 21 */     for (Floors.Floor f : (SETT.FLOOR()).map.readMany(key, j))
/* 22 */       RFloors.this.override[s.index()].add(f); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RFloors$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */