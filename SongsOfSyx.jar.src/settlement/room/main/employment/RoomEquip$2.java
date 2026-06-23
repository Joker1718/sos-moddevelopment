/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.file.Json;
/*     */ import util.keymap.RMAP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RMAP<RoomBlueprint>.KJson
/*     */ {
/*     */   null(RMAP paramRMAP, String $anonymous0, Json $anonymous1) {
/* 125 */     super(paramRMAP, $anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void process(RoomBlueprint bp, Json j, String key, boolean isWeak) {
/* 129 */     if (bp instanceof RoomBlueprintImp) {
/* 130 */       RoomBlueprintImp room = (RoomBlueprintImp)bp;
/* 131 */       if (room.bonus() == null || room.employment() == null) {
/* 132 */         GAME.WarnLight(data.errorGet("Not a valid boostable room " + key, key));
/*     */         return;
/*     */       } 
/* 135 */       int am = j.i(key, 0, 100);
/* 136 */       ams[room.employment().eindex()] = am;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEquip$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */