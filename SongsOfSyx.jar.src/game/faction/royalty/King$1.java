/*    */ package game.faction.royalty;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.player.PLevels;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import snake2d.util.sprite.text.StrInserter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends StrInserter<Faction>
/*    */ {
/*    */   null(String $anonymous0) {
/* 28 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void set(Faction t, Str str) {
/* 32 */     double d = t.realm().regions() / 20.0D;
/* 33 */     int i = (int)(d * FACTIONS.player().level().all().size());
/* 34 */     i = CLAMP.i(i, 0, FACTIONS.player().level().all().size() - 1);
/* 35 */     str.add(((PLevels.Level)FACTIONS.player().level().all().get(i)).male);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\King$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */