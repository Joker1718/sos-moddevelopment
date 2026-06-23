/*    */ package world.entity.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import snake2d.util.rnd.RND;
/*    */ import view.tool.PlacableSingle;
/*    */ import world.WORLD;
/*    */ import world.army.AD;
/*    */ import world.army.WDivRegional;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends PlacableSingle
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 55 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void placeFirst(int tx, int ty) {
/* 59 */     WArmy e = WArmyConstructor.this.create(tx, ty, (Faction)FACTIONS.player());
/* 60 */     for (int i = 0; i <= 1; i++) {
/*    */ 
/*    */       
/* 63 */       WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/* 64 */       d.randomize(RND.rFloat(), RND.rFloat());
/* 65 */       d.menSet(d.menTarget());
/*    */     } 
/* 67 */     AD.supplies().fillAll(e);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 72 */     return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyConstructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */