/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.water.pool.ROOM_POOL;
/*    */ import settlement.stats.stat.STAT;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
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
/*    */   extends StatRow
/*    */ {
/*    */   null(STAT $anonymous0, HCLASS $anonymous1, GETTER<Race> $anonymous2) {
/* 62 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 67 */     super.hoverInfoGet(text);
/* 68 */     if (race.get() != null) {
/* 69 */       GBox b = (GBox)text;
/* 70 */       b.NL(8);
/* 71 */       for (ROOM_POOL p : (SETT.ROOMS()).POOLS) {
/* 72 */         b.add((SPRITE)p.icon);
/* 73 */         b.add((SPRITE)GFORMAT.perc(b.text(), ((Race)race.get()).pref().pool(p)));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatEnv$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */