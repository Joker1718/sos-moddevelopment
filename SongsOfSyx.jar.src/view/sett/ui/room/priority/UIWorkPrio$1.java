/*    */ package view.sett.ui.room.priority;
/*    */ 
/*    */ import init.type.HTYPE_RACE;
/*    */ import init.type.WGROUP;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends Filter.FilterEntry<WGROUP>
/*    */ {
/*    */   null(CharSequence $anonymous0, SPRITE $anonymous1, WGROUP $anonymous2) {
/* 53 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public boolean isRelavant() {
/* 57 */     return ((STATS.POP()).POP.type().get(HTYPE_RACE.get(g.race, g.type)) > 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\UIWorkPrio$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */