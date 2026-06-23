/*     */ package world.entity.army;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.util.rnd.RND;
/*     */ import view.tool.PlacableSingle;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.WDivRegional;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends PlacableSingle
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/*  98 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void placeFirst(int tx, int ty) {
/* 102 */     WArmy e = WArmyConstructor.this.create(tx, ty, null);
/*     */ 
/*     */ 
/*     */     
/* 106 */     WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/* 107 */     d.randomize(RND.rFloat(), RND.rFloat());
/* 108 */     d.menSet(d.menTarget());
/* 109 */     AD.supplies().fillAll(e);
/* 110 */     AD.updateArmy(e);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 115 */     return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyConstructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */