/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.BUILDING_PREF;
/*    */ import init.type.BUILDING_PREFS;
/*    */ import init.type.HCLASS;
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
/*    */ class null
/*    */   extends StatRow
/*    */ {
/*    */   null(STAT $anonymous0, HCLASS $anonymous1, GETTER<Race> $anonymous2) {
/* 44 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 49 */     super.hoverInfoGet(text);
/* 50 */     if (race.get() != null) {
/* 51 */       GBox b = (GBox)text;
/* 52 */       b.NL(8);
/* 53 */       for (BUILDING_PREF p : BUILDING_PREFS.ALL()) {
/* 54 */         b.add(p.icon());
/* 55 */         b.add((SPRITE)GFORMAT.perc(b.text(), ((Race)race.get()).pref().structure(p)));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatEnv$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */