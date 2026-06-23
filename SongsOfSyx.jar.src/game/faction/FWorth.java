/*     */ package game.faction;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BUtil;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.RegionInfo;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ public final class FWorth
/*     */ {
/*  34 */   private static CharSequence ¤¤resD = "Worth of stored resources";
/*  35 */   private static CharSequence ¤¤popD = "Worth of population";
/*  36 */   private static CharSequence ¤¤regionD = "Worth of your regions";
/*  37 */   private static CharSequence ¤¤vassals = "Vassals";
/*  38 */   private static CharSequence ¤¤vassalsD = "Worth of your vassals";
/*  39 */   private static CharSequence ¤¤slaves = "Slaves";
/*  40 */   private static CharSequence ¤¤slavesD = "Worth of your slaves";
/*     */   
/*     */   static {
/*  43 */     D.ts(FWorth.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   public final WINT resources = new WINT(Dic.¤¤Resources, ¤¤resD, (SPRITE)(UI.icons()).s.storage)
/*     */     {
/*     */       public int pget(Faction f)
/*     */       {
/*  54 */         double cache = 0.0D;
/*  55 */         for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/*  56 */           RESOURCE res = (RESOURCE)RESOURCES.ALL().get(ri);
/*  57 */           cache += FWorth.worthResource((TRADABLE)TR.get(res), f.res().getAvailable((TRADABLE)TR.get(res)));
/*     */         } 
/*  59 */         for (int ei = 0; ei < STATS.EQUIP().BATTLE_ALL().size(); ei++) {
/*  60 */           EquipBattle e = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(ei);
/*  61 */           int am = 0;
/*  62 */           for (int di = 0; di < GAME.ARMIES().player().divisions().size(); di++) {
/*  63 */             Div d = (Div)GAME.ARMIES().player().divisions().get(di);
/*  64 */             am += d.info.equipI(e) * d.menNrOf();
/*     */           } 
/*  66 */           if (am > f.res().getAvailable((TRADABLE)TR.get(e.resource)))
/*  67 */             am = f.res().getAvailable((TRADABLE)TR.get(e.resource)); 
/*  68 */           cache -= FWorth.worthResource((TRADABLE)TR.get(e.resource), am);
/*     */         } 
/*     */         
/*  71 */         return (int)cache;
/*     */       }
/*     */     };
/*     */   
/*     */   public static double worthResource(TRADABLE res, int amount) {
/*  76 */     return (amount * FACTIONS.PRICE().get(res));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public final WINT population = new WINT(Dic.¤¤Population, ¤¤popD, (SPRITE)(UI.icons()).s.human)
/*     */     {
/*     */       public int pget(Faction f) {
/*  84 */         double cache = 0.0D;
/*  85 */         for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/*  86 */           Race res = ((RDRace)(RD.RACES()).all.get(ri)).race;
/*  87 */           cache += (f.citizens(res) * 400) * 5.0D / (res.population()).max;
/*     */         } 
/*  89 */         return (int)cache;
/*     */       }
/*     */     };
/*     */   
/*  93 */   public final WINT slaves = new WINT(¤¤slaves, ¤¤slavesD, (SPRITE)(UI.icons()).s.slave)
/*     */     {
/*     */       public int pget(Faction f) {
/*  96 */         double cache = 0.0D;
/*  97 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  98 */           Race res = (Race)RACES.all().get(ri);
/*  99 */           cache += FACTIONS.PRICE().get((TRADABLE)TR.get(res)) * 0.25D * f.seller((TRADABLE)TR.get(res)).removeMax();
/*     */         } 
/* 101 */         return (int)cache;
/*     */       }
/*     */     };
/*     */   
/*     */   public static double pop(Race race, int amount) {
/* 106 */     return (amount * FACTIONS.PRICE().get((TRADABLE)TR.get(race))) * 0.25D;
/*     */   }
/*     */   
/* 109 */   public final WINT regions = new WINT(Dic.¤¤Regions, ¤¤regionD, (SPRITE)(UI.icons()).s.world)
/*     */     {
/*     */       public int pget(Faction f) {
/* 112 */         double cache = 0.0D;
/* 113 */         for (int i = 0; i < f.realm().regions(); i++) {
/* 114 */           Region reg = f.realm().region(i);
/* 115 */           if (!reg.capitol())
/*     */           {
/* 117 */             cache += FWorth.region(reg); } 
/*     */         } 
/* 119 */         return (int)cache;
/*     */       }
/*     */     };
/*     */   
/*     */   public static double region(Region reg) {
/* 124 */     double v = -1.0D;
/* 125 */     for (int bi = 0; bi < (RD.BUILDINGS()).all.size(); bi++) {
/* 126 */       RDBuilding b = (RDBuilding)(RD.BUILDINGS()).all.get(bi);
/* 127 */       double a = BUtil.value((LIST)b.baseFactors, reg);
/* 128 */       v = Math.max(a, v);
/*     */     } 
/* 130 */     v *= 400.0D;
/*     */     
/* 132 */     v += (RegionInfo.vFer().getAi(reg) + RegionInfo.vArea().getAi(reg)) * FACTIONS.PRICE().edible();
/* 133 */     return v * 0.25D * (RD.RACES()).population.get(reg);
/*     */   }
/*     */   
/* 136 */   public final WINT worthVassals = new WINT(¤¤vassals, ¤¤vassalsD, (SPRITE)(UI.icons()).s.noble)
/*     */     {
/*     */       
/*     */       public int pget(Faction f)
/*     */       {
/* 141 */         double c = 0.0D;
/* 142 */         for (Faction f2 : DIP.VASSAL().all(f)) {
/* 143 */           c += FWorth.vassal(f2);
/*     */         }
/* 145 */         return (int)c;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public static double vassal(Faction fa) {
/* 151 */     if (fa instanceof FactionNPC) {
/* 152 */       FactionNPC f = (FactionNPC)fa;
/* 153 */       DIP.TMP().setFactionAndClear(f);
/* 154 */       return (int)Math.ceil((DIP.TMP()).npc.offerableWorth() * 0.05D);
/*     */     } 
/* 156 */     return 0.0D;
/*     */   }
/*     */   
/* 159 */   public final WINT cash = new WINT(Dic.¤¤Currs, Dic.¤¤Currs, (SPRITE)(UI.icons()).s.money)
/*     */     {
/*     */       public int pget(Faction f)
/*     */       {
/* 163 */         return (int)f.credits().getD();
/*     */       }
/*     */     };
/*     */   
/* 167 */   public final LIST<WINT> raider = (LIST<WINT>)new ArrayList((Object[])new WINT[] { this.cash, this.resources, this.slaves });
/* 168 */   public final LIST<WINT> faction = (LIST<WINT>)new ArrayList((Object[])new WINT[] { this.cash, this.resources, this.population, this.slaves, this.regions, this.worthVassals });
/*     */   
/*     */   public double raider() {
/* 171 */     return get(this.raider, (Faction)FACTIONS.player());
/*     */   }
/*     */   
/*     */   public double faction() {
/* 175 */     return get(this.faction, (Faction)FACTIONS.player());
/*     */   }
/*     */   
/*     */   public double raider(Faction f) {
/* 179 */     return get(this.raider, f);
/*     */   }
/*     */   
/*     */   public double faction(Faction f) {
/* 183 */     return get(this.faction, f);
/*     */   }
/*     */   
/*     */   private double get(LIST<WINT> li, Faction f) {
/* 187 */     double am = 0.0D;
/* 188 */     for (WINT d : li)
/* 189 */       am += d.get(f); 
/* 190 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class WINT
/*     */   {
/* 196 */     private int[] upI = Alloc.ii(FACTIONS.MAX());
/* 197 */     private int[] cache = Alloc.ii(FACTIONS.MAX());
/*     */     public final INFO info;
/*     */     public SPRITE icon;
/*     */     
/*     */     WINT(CharSequence name, CharSequence desc, SPRITE icon) {
/* 202 */       this.info = new INFO(name, desc);
/* 203 */       this.icon = icon;
/* 204 */       Arrays.fill(this.upI, -1);
/*     */     }
/*     */     
/*     */     public int player() {
/* 208 */       return get((Faction)FACTIONS.player());
/*     */     }
/*     */     
/*     */     public final int get(Faction f) {
/* 212 */       if (f == null)
/* 213 */         return 0; 
/* 214 */       if (this.upI[f.index()] != GAME.updateI()) {
/* 215 */         this.upI[f.index()] = GAME.updateI();
/* 216 */         this.cache[f.index()] = pget(f);
/*     */       } 
/* 218 */       return this.cache[f.index()];
/*     */     }
/*     */     
/*     */     protected abstract int pget(Faction param1Faction);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FWorth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */