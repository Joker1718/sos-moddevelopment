/*    */ package game.tourism;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.HTYPES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.rnd.RND;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 89 */     Induvidual i = new Induvidual(HTYPES.TOURIST(), (Race)RACES.playable().rnd());
/* 90 */     TOURISM.service(i).cheatSetTotal(i, RND.rFloat());
/* 91 */     RoomInstance ii = ((SETT.ROOMS()).INN.instancesSize() > 0) ? (SETT.ROOMS()).INN.getInstance(RND.rInt((SETT.ROOMS()).INN.instancesSize())) : null;
/* 92 */     TOURISM.touristFinish(i, (ii != null) ? (COORDINATE)new Coo(ii.mX(), ii.mY()) : (COORDINATE)new Coo(-1.0D, -1.0D));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\TOURISM$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */