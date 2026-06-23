/*    */ package game.event.actions;
/*    */ 
/*    */ import init.race.Race;
/*    */ import snake2d.util.file.Json;
/*    */ import util.keymap.RMAP;
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
/*    */   extends RMAP<Race>.KJson
/*    */ {
/*    */   null(RMAP paramRMAP, String $anonymous0, Json $anonymous1) {
/* 43 */     super(paramRMAP, $anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void process(Race s, Json j, String key, boolean isWeak) {
/* 47 */     _SUBJECTS_ADD.RAmount d = new _SUBJECTS_ADD.RAmount(s, new EventAction.CInt(_SUBJECTS_ADD.Imp.this, s.key + "_AMOUNT"));
/* 48 */     d.read(j.json(key), 0);
/* 49 */     _SUBJECTS_ADD.Imp.this.datas.add(d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_SUBJECTS_ADD$Imp$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */