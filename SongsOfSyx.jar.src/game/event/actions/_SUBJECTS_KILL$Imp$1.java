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
/* 63 */     super(paramRMAP, $anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void process(Race s, Json j, String key, boolean isWeak) {
/* 67 */     _SUBJECTS_KILL.RAmount d = new _SUBJECTS_KILL.RAmount(s, new EventAction.CInt(_SUBJECTS_KILL.Imp.this, s.key + "_AMOUNTS"));
/* 68 */     d.read(j.json(key), 0);
/* 69 */     _SUBJECTS_KILL.Imp.this.datas.add(d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_SUBJECTS_KILL$Imp$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */