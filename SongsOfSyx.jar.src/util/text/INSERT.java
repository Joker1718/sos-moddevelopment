/*    */ package util.text;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.royalty.Royalty;
/*    */ import init.race.Race;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.Induvidual;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public final class INSERT
/*    */ {
/* 12 */   public static final Inserter<Induvidual> indu = new InsertIndu();
/* 13 */   public static final Inserter<Race> race = new InsertRace();
/* 14 */   public static final Inserter<Humanoid> human = new InsertHuman();
/* 15 */   public static final Inserter<Faction> faction = new InsertFaction();
/* 16 */   public static final Inserter<Integer> player = new InsertPlayer();
/* 17 */   public static final Inserter<Region> reg = new InsertRegion();
/* 18 */   public static final Inserter<Royalty> royalty = new InsertRoyalty();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\INSERT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */