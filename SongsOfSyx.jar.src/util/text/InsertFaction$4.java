/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Inserter<Faction>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 58 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Faction f, Str str) {
/* 62 */     if (f == FACTIONS.player()) {
/* 63 */       str.add((RD.RACE(f.race())).names.rIntro.get(0));
/*    */     } else {
/* 65 */       str.add((CharSequence)((FactionNPC)f).nameIntro);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertFaction$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */