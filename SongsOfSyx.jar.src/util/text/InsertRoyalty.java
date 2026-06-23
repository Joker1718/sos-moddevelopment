/*    */ package util.text;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.royalty.Royalty;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER_TRANS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class InsertRoyalty
/*    */   extends Inserter<Royalty>
/*    */ {
/*    */   public InsertRoyalty() {
/* 39 */     join(new Inserter(new InsertIndu(), "INDUVIDUAL_"), new GETTER_TRANS<Royalty, Induvidual>()
/*    */         {
/*    */           public Induvidual get(Royalty f)
/*    */           {
/* 43 */             if (f == null)
/* 44 */               return null; 
/* 45 */             return f.induvidual;
/*    */           }
/*    */         });
/*    */     
/* 49 */     join(new Inserter(new InsertFaction(), "FACTION_"), new GETTER_TRANS<Royalty, Faction>()
/*    */         {
/*    */           public Faction get(Royalty f)
/*    */           {
/* 53 */             if (f == null)
/* 54 */               return null; 
/* 55 */             return (Faction)f.court.faction;
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertRoyalty.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */