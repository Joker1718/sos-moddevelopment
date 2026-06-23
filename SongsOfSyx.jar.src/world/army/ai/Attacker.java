/*     */ package world.army.ai;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.entity.army.WArmyState;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ final class Attacker
/*     */ {
/*  26 */   private final Bitmap1D check = new Bitmap1D(1023, false);
/*     */   
/*     */   Attacker() {
/*  29 */     IDebugPanelWorld.add((PLACABLE)new PlacableSimpleTile("army debug")
/*     */         {
/*     */           public void place(int tx, int ty)
/*     */           {
/*  33 */             LOG.ln("test " + tx + " " + ty);
/*  34 */             LIST<WRegFinder.RegDist> ds = (WORLD.PATH()).regFinder.all(tx, ty, WRegFinder.Treaty.FACTION_BORDERS, WRegSel.ENEMY(((Region)(WORLD.REGIONS()).map.get(tx, ty)).faction()));
/*     */             
/*  36 */             for (WRegFinder.RegDist d : ds) {
/*  37 */               LOG.ln(String.valueOf(d.reg) + " " + String.valueOf(d.reg));
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty) {
/*  43 */             if ((WORLD.PATH()).map.is.is(tx, ty) && (WORLD.REGIONS()).map.get(tx, ty) != null && ((Region)(WORLD.REGIONS()).map.get(tx, ty)).faction() != null) {
/*  44 */               return null;
/*     */             }
/*  46 */             return E;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void attack(Faction f, ArrayList<WArmy> armies) {
/*  53 */     if (armies.size() == 0) {
/*     */       return;
/*     */     }
/*  56 */     this.check.clear();
/*     */     
/*  58 */     double enemyPower = 0.0D;
/*     */     
/*  60 */     for (Faction e : DIP.WAR().all(f)) {
/*  61 */       enemyPower += AD.power().get(e);
/*     */     }
/*     */     
/*  64 */     double power = 0.0D;
/*     */     
/*  66 */     for (WArmy a : armies) {
/*  67 */       power += AD.power().get(a);
/*     */     }
/*     */ 
/*     */     
/*  71 */     power -= enemyPower;
/*  72 */     if (War.logging) {
/*  73 */       War.log(f, "" + power);
/*     */     }
/*     */     
/*  76 */     while (power > 0.0D && armies.size() > 0) {
/*  77 */       WArmy a = (WArmy)armies.removeLast();
/*  78 */       power -= AD.power().get(a);
/*  79 */       attack(a);
/*     */     } 
/*     */     
/*  82 */     while (armies.size() > 0) {
/*  83 */       WArmy a = (WArmy)armies.removeLast();
/*  84 */       guard(a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void guard(WArmy a) {
/*  92 */     if (a.faction() == null)
/*     */       return; 
/*  94 */     if (DIP.WAR().all(a.faction()).size() > 0) {
/*  95 */       if (a.region() == a.faction().capitolRegion())
/*     */         return; 
/*  97 */       if (a.state() == WArmyState.moving && (WORLD.REGIONS()).map.get(a.path().destX(), a.path().destY()) == a.faction().capitolRegion())
/*     */         return; 
/*  99 */       COORDINATE c = WORLD.PATH().rnd(a.faction().capitolRegion());
/* 100 */       if (c != null) {
/* 101 */         a.setDestination(c.x(), c.y());
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void attack(WArmy a) {
/* 116 */     if (a.region() != null && a.region().faction() == a.faction() && AD.supplies().health(a) < 1.0D) {
/* 117 */       a.stop();
/* 118 */       if (War.logging) {
/* 119 */         War.log(a, "stop");
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 125 */     LIST<WRegFinder.RegDist> ds = (WORLD.PATH()).regFinder.all(a.ctx(), a.cty(), WRegFinder.Treaty.FACTION_BORDERS, WRegSel.ENEMY(a.faction()));
/* 126 */     Region best = null;
/* 127 */     double bestValue = 0.0D;
/* 128 */     double pow = AD.power().get(a);
/*     */     
/* 130 */     for (WRegFinder.RegDist d : ds) {
/* 131 */       DIP.WAR().is(a.faction(), (Faction)FACTIONS.player());
/*     */ 
/*     */       
/* 134 */       double v = pow / ((RD.MILITARY()).power.getD(d.reg) + 100.0D);
/* 135 */       if (v > 1.0D) {
/* 136 */         v /= d.distance;
/* 137 */         if (v > bestValue) {
/* 138 */           best = d.reg;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 144 */     if (War.logging) {
/* 145 */       War.log(a, " " + String.valueOf(best));
/*     */     }
/*     */     
/* 148 */     if (best != null) {
/*     */       
/* 150 */       if (a.state() != WArmyState.besieging || a.region() != best)
/* 151 */         a.besiege(best); 
/*     */     } else {
/* 153 */       guard(a);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Attacker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */