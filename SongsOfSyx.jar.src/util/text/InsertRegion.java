/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER_TRANS;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class InsertRegion
/*    */   extends Inserter<Region>
/*    */ {
/*    */   public InsertRegion() {
/* 26 */     join(new Inserter(new InsertFaction(), "FACTION_"), new GETTER_TRANS<Region, Faction>()
/*    */         {
/*    */ 
/*    */           
/*    */           public Faction get(Region f)
/*    */           {
/* 32 */             if (f.faction() == null)
/* 33 */               return (Faction)FACTIONS.player(); 
/* 34 */             return f.faction();
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertRegion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */