/*     */ package world.entity.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
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
/* 119 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void placeFirst(int tx, int ty) {
/* 123 */     Faction f = (Faction)FACTIONS.NPCs().get(0);
/* 124 */     if (f.capitolRegion() == null)
/*     */       return; 
/* 126 */     WArmy e = WArmyConstructor.this.create(tx, ty, f);
/* 127 */     for (int i = 0; i <= 50; i++) {
/*     */ 
/*     */       
/* 130 */       WDivRegional d = AD.regional().create((Race)RACES.all().rnd(), 0.25D + 0.75D * (1.0D - (1.0F - RND.rFloatP(2.0F))), e);
/* 131 */       d.randomize(RND.rFloat(), RND.rFloat());
/* 132 */       d.menSet(d.menTarget());
/*     */     } 
/* 134 */     AD.supplies().fillAll(e);
/* 135 */     DIP.WAR().set(f, (Faction)FACTIONS.player());
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 140 */     return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyConstructor$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */