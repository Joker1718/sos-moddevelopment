/*    */ package world.army.ai;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import snake2d.PathTile;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import world.WORLD;
/*    */ import world.entity.army.WArmy;
/*    */ import world.entity.army.WArmyState;
/*    */ import world.map.pathing.WRegFinder;
/*    */ import world.map.pathing.WRegSel;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Chiller
/*    */ {
/*    */   public void chill(Faction f, ArrayList<WArmy> armies) {
/* 25 */     if (armies.size() > 0 && RND.oneIn(2) && RD.DIST().factionHasRegionBorderingPlayer(f)) {
/*    */       
/* 27 */       WArmy a = (WArmy)armies.rnd();
/*    */       
/* 29 */       if (a.state() == WArmyState.fortified) {
/* 30 */         LIST<WRegFinder.RegDist> l = (WORLD.PATH()).regFinder.all(a.ctx(), a.cty(), WRegFinder.Treaty.FACTION_BORDERS, WRegSel.FACTION((Faction)FACTIONS.player()));
/* 31 */         if (l.size() == 0)
/*    */           return; 
/* 33 */         WRegFinder.RegDist d = (WRegFinder.RegDist)l.rnd();
/* 34 */         PathTile t = WORLD.PATH().path(a.ctx(), a.cty(), d.reg.cx(), d.reg.cy(), WRegFinder.Treaty.FACTION_BORDERS);
/* 35 */         if (t != null) {
/* 36 */           PathTile ok = null;
/* 37 */           while (t != null) {
/* 38 */             if ((WORLD.REGIONS()).faction.get((COORDINATE)t) != a.faction()) {
/* 39 */               ok = null;
/* 40 */             } else if (ok == null) {
/* 41 */               ok = t;
/* 42 */             }  t = t.getParent();
/*    */           } 
/* 44 */           if (ok != null)
/* 45 */             a.setDestination(ok.x(), ok.y()); 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Chiller.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */