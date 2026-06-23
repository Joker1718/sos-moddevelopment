/*    */ package world.entity.army;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 76 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void placeFirst(int tx, int ty) {
/* 80 */     WArmy e = WArmyConstructor.this.create(tx, ty, null);
/* 81 */     AD.factionSet(e, null);
/* 82 */     for (int i = 0; i <= 100; i++) {
/*    */       
/* 84 */       WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/* 85 */       d.randomize(RND.rFloat(), RND.rFloat());
/* 86 */       d.menSet(d.menTarget());
/*    */     } 
/* 88 */     AD.supplies().fillAll(e);
/* 89 */     AD.updateArmy(e);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 94 */     return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyConstructor$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */