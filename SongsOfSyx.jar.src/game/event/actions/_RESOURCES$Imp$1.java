/*    */ package game.event.actions;
/*    */ 
/*    */ import init.trade.TRADABLE;
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
/*    */ class null
/*    */   extends RMAP<TRADABLE>.KJson
/*    */ {
/*    */   null(RMAP paramRMAP, String $anonymous0, Json $anonymous1) {
/* 47 */     super(paramRMAP, $anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void process(TRADABLE s, Json j, String key, boolean isWeak) {
/* 52 */     _RESOURCES.RAmount d = new _RESOURCES.RAmount(s, new EventAction.CInt(_RESOURCES.Imp.this, s.key()));
/* 53 */     d.read(j.json(key), -2147483648);
/* 54 */     _RESOURCES.Imp.this.datas.add(d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_RESOURCES$Imp$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */