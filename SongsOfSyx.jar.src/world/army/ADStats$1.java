/*    */ package world.army;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.data.DOUBLE_O;
/*    */ import util.data.DataO;
/*    */ import util.info.INFO;
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
/*    */   extends DataO<Faction>.DataDouble
/*    */ {
/*    */   null(DataO paramDataO, String $anonymous0, INFO $anonymous1) {
/* 59 */     super(paramDataO, $anonymous0, $anonymous1);
/*    */   }
/*    */   public DOUBLE_O.DOUBLE_OE<Faction> setD(Faction t, double d) {
/* 62 */     d = CLAMP.d(d, -1.0D, 1.0D);
/* 63 */     return super.setD(t, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADStats$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */