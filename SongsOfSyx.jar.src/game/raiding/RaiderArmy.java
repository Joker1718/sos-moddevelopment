/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.Serializable;
/*     */ import settlement.battle.invasion.InvasionSpec;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.army.WDivRegional;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RaiderArmy
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public final int men;
/*  37 */   public final ArrayListGrower<RaidDiv> sdivs = new ArrayListGrower();
/*  38 */   public int[] artillery = Alloc.ii((SETT.ROOMS()).ARTILLERY.size());
/*     */   
/*     */   public final int power;
/*     */   
/*     */   public RaiderArmy(Race race, double totPower, double quality) {
/*  43 */     int menTot = 0;
/*  44 */     int divMenTarget = 1;
/*     */     
/*  46 */     double powChunk = totPower / 8.0D;
/*     */ 
/*     */     
/*  49 */     RaidDiv stat = new RaidDiv();
/*  50 */     double training = CLAMP.d(quality / 2.0D + RND.rFloat() * quality, 0.0D, 1.0D);
/*  51 */     double equip = CLAMP.d(quality / 2.0D + RND.rFloat() * quality, 0.0D, 1.0D);
/*     */     
/*  53 */     stat.race = race.index();
/*  54 */     stat.men = 1;
/*  55 */     stat.ex = CLAMP.d(RND.rFloat() * quality, 0.0D, 1.0D);
/*  56 */     stat.name = (String)(stat.race()).info.armyNames.rnd();
/*  57 */     stat.bannerI = RND.rInt((GAME.ARMIES()).banners.size());
/*  58 */     stat.copySettings((DIV_SETTING)(GAME.battle()).types.rnd(stat.race(), (Faction)FACTIONS.player(), RND.rFloat()), 1, training, equip);
/*     */     
/*  60 */     double p = (GAME.battle()).power.get(stat);
/*     */     
/*  62 */     double men = totPower / p;
/*  63 */     men /= 2.0D;
/*  64 */     men /= 5.0D;
/*  65 */     men = (5 * (int)Math.ceil(men));
/*  66 */     men = CLAMP.d(men, 5.0D, (Config.battle()).MEN_PER_DIVISION);
/*  67 */     divMenTarget = (int)men;
/*     */     
/*  69 */     stat.men = (int)men;
/*  70 */     totPower -= (GAME.battle()).power.get(stat);
/*  71 */     this.sdivs.add(stat);
/*     */ 
/*     */     
/*  74 */     double raceMax = 0.0D;
/*  75 */     for (Race r : RACES.all()) {
/*  76 */       raceMax += race(race, r, totPower);
/*     */     }
/*     */ 
/*     */     
/*  80 */     while (totPower > 0.0D && this.sdivs.size() < (Config.battle()).DIVISIONS_PER_ARMY) {
/*     */       
/*  82 */       RaidDiv raidDiv = new RaidDiv();
/*  83 */       double d1 = CLAMP.d(quality * 0.25D + RND.rFloat() * quality * 0.75D, 0.0D, 1.0D);
/*  84 */       double d2 = CLAMP.d(quality * 0.25D + RND.rFloat() * quality * 0.75D, 0.0D, 1.0D);
/*     */       
/*  86 */       raidDiv.race = (race(race, raceMax, totPower)).index;
/*  87 */       raidDiv.men = 1;
/*  88 */       raidDiv.ex = CLAMP.d(RND.rFloat() * quality, 0.0D, 1.0D);
/*  89 */       raidDiv.name = (String)(raidDiv.race()).info.armyNames.rnd();
/*  90 */       raidDiv.bannerI = RND.rInt((GAME.ARMIES()).banners.size());
/*  91 */       raidDiv.copySettings((DIV_SETTING)(GAME.battle()).types.rnd(raidDiv.race(), (Faction)FACTIONS.player(), RND.rFloat()), 1, d1, d2);
/*     */       
/*  93 */       double d3 = (GAME.battle()).power.get(raidDiv);
/*  94 */       double d4 = totPower / d3;
/*  95 */       if (d4 > 1.0D) {
/*  96 */         raidDiv.men = (int)(raidDiv.men * d4);
/*  97 */         raidDiv.men = CLAMP.i(raidDiv.men, 5, divMenTarget);
/*     */       } 
/*  99 */       d3 = (GAME.battle()).power.get(raidDiv);
/* 100 */       this.sdivs.add(raidDiv);
/* 101 */       totPower -= d3;
/* 102 */       int am = (int)((0.5D + (RND.rFloat() * 3.0F)) * powChunk / d3);
/* 103 */       while (am >= 0 && totPower > 0.0D && this.sdivs.size() < (Config.battle()).DIVISIONS_PER_ARMY) {
/* 104 */         this.sdivs.add(new RaidDiv(raidDiv));
/* 105 */         raidDiv.name = (String)(raidDiv.race()).info.armyNames.rnd();
/* 106 */         totPower -= d3;
/* 107 */         am--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     double dd = 0.0D;
/* 116 */     for (RaidDiv d : this.sdivs) {
/* 117 */       dd += (GAME.battle()).power.get(d);
/* 118 */       menTot += d.men();
/*     */     } 
/* 120 */     this.power = (int)dd;
/*     */ 
/*     */     
/* 123 */     this.men = menTot;
/*     */     
/* 125 */     int art = 40 * menTot / (Config.battle()).MEN_PER_ARMY;
/* 126 */     while (art-- > 0) {
/* 127 */       ADSupplies.ADArtillery a = (ADSupplies.ADArtillery)AD.supplies().arts().rnd();
/* 128 */       this.artillery[a.index()] = this.artillery[a.index()] + 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public WArmy spawn(int wx, int wy, CharSequence name) {
/* 134 */     Region reg = (Region)(WORLD.REGIONS()).map.get(wx, wy);
/* 135 */     if (reg != null && !isGoodTile(wx, wy, DIR.C, (Region)(WORLD.REGIONS()).map.get(wx, wy))) {
/* 136 */       for (DIR d : DIR.ALL) {
/* 137 */         if ((WORLD.PATH()).map.can(wx, wy, d) && isGoodTile(wx, wy, d, reg)) {
/* 138 */           wx += d.x();
/* 139 */           wy += d.y();
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 145 */     for (int i = 0; i < 10 && 
/* 146 */       removeArmies(wx, wy); i++);
/*     */ 
/*     */ 
/*     */     
/* 150 */     WArmy a = (WORLD.ENTITIES()).armies.create(wx, wy, null);
/*     */     
/* 152 */     for (RaidDiv div : this.sdivs) {
/* 153 */       WDivRegional d = AD.regional().create(div.race(), div.men / (Config.battle()).MEN_PER_DIVISION, a);
/* 154 */       d.copyFrom(div);
/* 155 */       d.menSet(d.menTarget());
/*     */     } 
/* 157 */     a.name.clear().add(name);
/* 158 */     AD.supplies().fillAll(a);
/* 159 */     AD.updateArmy(a);
/* 160 */     return a;
/*     */   }
/*     */   
/*     */   public int invade(int wx, int wy, Induvidual raider) {
/* 164 */     InvasionSpec sp = new InvasionSpec();
/* 165 */     boolean first = true;
/* 166 */     for (DIV_SPEC stat : this.sdivs) {
/* 167 */       DivGeneration g = new DivGeneration(stat, (DIV_SETTING)stat);
/* 168 */       if (first) {
/* 169 */         first = false;
/* 170 */         g.indus[0].copyFrom(raider);
/*     */       } 
/* 172 */       sp.add(g);
/*     */     } 
/* 174 */     for (int i = 0; i < this.artillery.length; i++) {
/* 175 */       sp.artillery[i] = this.artillery[i];
/*     */     }
/* 177 */     sp.wx = wx;
/* 178 */     sp.wy = wy;
/* 179 */     return SETT.INVADOR().invade(sp, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isGoodTile(int tx, int ty, DIR d, Region home) {
/* 184 */     tx += d.x();
/* 185 */     ty += d.y();
/*     */     
/* 187 */     if (!home.is(tx, ty)) {
/* 188 */       return false;
/*     */     }
/* 190 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 191 */       d = (DIR)DIR.ALL.get(di);
/* 192 */       if ((WORLD.PATH()).map.can(tx, ty, d)) {
/* 193 */         Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty, d);
/* 194 */         if (reg != null && reg != home && reg.faction() != null && reg.faction() != FACTIONS.player()) {
/* 195 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 199 */     return true;
/*     */   }
/*     */   
/*     */   private boolean removeArmies(int wx, int wy) {
/* 203 */     for (int di = 0; di < DIR.ALLC.size(); di++) {
/* 204 */       DIR d = (DIR)DIR.ALLC.get(di);
/* 205 */       if (d == DIR.C || (WORLD.PATH()).map.can(wx, wy, d)) {
/*     */         
/* 207 */         int dx = wx + d.x();
/* 208 */         int dy = wy + d.y();
/*     */         
/* 210 */         for (WArmy a2 : (WORLD.ENTITIES()).armies.fillTile(dx, dy)) {
/* 211 */           if (a2.ctx() == dx && a2.cty() == dy && 
/* 212 */             a2.faction() != FACTIONS.player() && a2.faction() != null) {
/* 213 */             if (a2.region() != null && a2.region().faction() == a2.faction()) {
/* 214 */               a2.teleport(a2.region().cx(), a2.region().cy());
/*     */             } else {
/* 216 */               a2.disband();
/* 217 */             }  return true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 223 */     return false;
/*     */   }
/*     */   
/*     */   private double race(Race leader, Race r, double totPower) {
/* 227 */     double d = leader.pref().race(r);
/* 228 */     if (leader == r) {
/* 229 */       d *= 4.0D;
/* 230 */     } else if (!r.playable) {
/* 231 */       d *= 0.2D;
/* 232 */     }  return d;
/*     */   }
/*     */ 
/*     */   
/*     */   private Race race(Race leader, double tot, double totPower) {
/* 237 */     tot *= RND.rFloat();
/* 238 */     for (Race r : RACES.all()) {
/* 239 */       tot -= race(leader, r, totPower);
/* 240 */       if (tot <= 0.0D)
/* 241 */         return r; 
/*     */     } 
/* 243 */     return leader;
/*     */   }
/*     */ 
/*     */   
/*     */   static class RaidDiv
/*     */     extends DIV_SETTING.DIV_SETTINGImp
/*     */     implements DIV_SPEC, Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     int race;
/*     */     
/*     */     double ex;
/*     */     private String name;
/*     */     private int bannerI;
/*     */     
/*     */     RaidDiv() {}
/*     */     
/*     */     RaidDiv(RaidDiv o) {
/* 262 */       this.race = o.race;
/* 263 */       this.ex = o.ex;
/* 264 */       this.name = o.name;
/* 265 */       this.bannerI = o.bannerI;
/* 266 */       copySettings((DIV_SETTING)o);
/*     */     }
/*     */ 
/*     */     
/*     */     public Race race() {
/* 271 */       return (Race)RACES.all().getC(this.race);
/*     */     }
/*     */ 
/*     */     
/*     */     public Faction faction() {
/* 276 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double experience() {
/* 281 */       return this.ex;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 286 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int bannerI() {
/* 291 */       return this.bannerI;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaiderArmy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */