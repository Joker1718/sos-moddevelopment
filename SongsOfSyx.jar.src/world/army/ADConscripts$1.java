/*    */ package world.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import init.race.Race;
/*    */ import util.data.DataO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends DataO<Faction>.DataInt
/*    */ {
/*    */   null(DataO paramDataO, String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2) {
/* 71 */     super(paramDataO, $anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public int get(Faction t) {
/* 75 */     if ((r.population()).max <= 0.0D && 
/* 76 */       t == FACTIONS.player()) {
/* 77 */       return 0;
/*    */     }
/*    */     
/* 80 */     return super.get(t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADConscripts$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */