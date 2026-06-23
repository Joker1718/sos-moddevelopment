/*     */ package init.value;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.RegionInfo;
/*     */ 
/*     */ class GValuesInit {
/*  29 */   private static CharSequence ¤¤roySucc = "Succession Order";
/*  30 */   private static CharSequence ¤¤regFactionNo = "Free Lands";
/*     */   
/*     */   static {
/*  33 */     D.ts(GValuesInit.class);
/*     */   }
/*     */   
/*     */   public static void init() {
/*  37 */     faction();
/*  38 */     royalty();
/*  39 */     region();
/*     */   }
/*     */   
/*     */   private static void royalty() {
/*  43 */     GValueCat<Royalty> V = GVALUES.ROYALTY;
/*     */     
/*  45 */     for (Value<Faction> v : (Iterable<Value<Faction>>)GVALUES.FACTION.map().allSorted()) {
/*     */       
/*  47 */       DOUBLE_O<Royalty> va = new DOUBLE_O<Royalty>()
/*     */         {
/*     */           public double getD(Royalty t)
/*     */           {
/*  51 */             return v.d.getD(t.court.faction);
/*     */           }
/*     */         };
/*     */       
/*  55 */       Value<Royalty> roy = new Value<>("FACTION_" + v.key, v.icon, v.name, va, v.percentage, v.isBool);
/*  56 */       V.push(roy);
/*     */     } 
/*     */     
/*  59 */     for (Value<Induvidual> v : (Iterable<Value<Induvidual>>)GVALUES.INDU.map().allSorted()) {
/*     */       
/*  61 */       DOUBLE_O<Royalty> va = new DOUBLE_O<Royalty>()
/*     */         {
/*     */           public double getD(Royalty t)
/*     */           {
/*  65 */             return v.d.getD(t.induvidual);
/*     */           }
/*     */         };
/*     */       
/*  69 */       Value<Royalty> roy = new Value<>("INDUVIDUAL_" + v.key, v.icon, v.name, va, v.percentage, v.isBool);
/*  70 */       V.push(roy);
/*     */     } 
/*     */     
/*  73 */     for (int i = 0; i < 4; i++) {
/*  74 */       final int k = i;
/*  75 */       V.push("SUCCESSION_ORDER_" + i, ¤¤roySucc, (SPRITE)(UI.icons()).s.noble, new BOOLEANO<Royalty>()
/*     */           {
/*     */             public boolean is(Royalty t) {
/*  78 */               return (t.successionI() == k);
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void region() {
/*  87 */     GValueCat<Region> V = GVALUES.REGION;
/*     */     
/*  89 */     for (Value<Faction> value : (Iterable<Value<Faction>>)GVALUES.FACTION.map().allSorted()) {
/*     */       
/*  91 */       DOUBLE_O<Region> va = new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region t)
/*     */           {
/*  95 */             return (t.faction() == null) ? 0.0D : v.d.getD(t.faction());
/*     */           }
/*     */         };
/*     */       
/*  99 */       Value<Region> roy = new Value<>("FACTION_" + value.key, value.icon, value.name, va, value.percentage, value.isBool);
/* 100 */       V.push(roy);
/*     */     } 
/*     */     
/* 103 */     V.push("FACTION_NONE", ¤¤regFactionNo, (SPRITE)(UI.icons()).s.flag, new BOOLEANO<Region>()
/*     */         {
/*     */           public boolean is(Region t) {
/* 106 */             return (t.faction() == null);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 111 */     V.push("HAS_BOOST_PERM", "Has Boost", (SPRITE)(UI.icons()).s.question, new BOOLEANO<Region>()
/*     */         {
/*     */           public boolean is(Region t) {
/* 114 */             return (GAME.BOOST()).regions.any((INDEXED)t);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 119 */     V.push("IS_CAPITAL", Dic.¤¤Capitol, (SPRITE)(UI.icons()).s.question, new BOOLEANO<Region>()
/*     */         {
/*     */           public boolean is(Region t) {
/* 122 */             return t.capitol();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 128 */     DOUBLE_O<Region> v = new DOUBLE_O<Region>()
/*     */       {
/*     */         public double getD(Region t)
/*     */         {
/* 132 */           return RegionInfo.vFer().get(t);
/*     */         }
/*     */       };
/*     */     
/* 136 */     GVALUES.REGION.push("PROP_FERTILTIY", Dic.¤¤Fertility, (SPRITE)(UI.icons()).s.sprout, v);
/*     */ 
/*     */     
/* 139 */     v = new DOUBLE_O<Region>()
/*     */       {
/*     */         public double getD(Region t)
/*     */         {
/* 143 */           return RegionInfo.vArea().get(t);
/*     */         }
/*     */       };
/*     */     
/* 147 */     GVALUES.REGION.push("PROP_AREA", Dic.¤¤Area, (SPRITE)(UI.icons()).s.expand, v);
/*     */     
/* 149 */     for (TERRAIN t : TERRAINS.ALL()) {
/* 150 */       DOUBLE_O<Region> dOUBLE_O = new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region r)
/*     */           {
/* 154 */             return RegionInfo.vTerrain(t).get(r);
/*     */           }
/*     */         };
/*     */       
/* 158 */       GVALUES.REGION.push("PROP_TERRAIN_" + t.key, t.name, t.icon(), dOUBLE_O);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 163 */     v = new DOUBLE_O<Region>()
/*     */       {
/*     */         public double getD(Region t)
/*     */         {
/* 167 */           return Math.max(RegionInfo.vTerrain(TERRAINS.WET()).get(t), RegionInfo.vTerrain(TERRAINS.OCEAN()).get(t));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 172 */     GVALUES.REGION.push("PROP_TERRAIN_WATER", Dic.¤¤Water, (SPRITE)(UI.icons()).s.drop, v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void faction() {
/* 178 */     GValueCat<Faction> V = GVALUES.FACTION;
/*     */     
/* 180 */     for (Boostable b : BOOSTING.ALL()) {
/* 181 */       V.push("BOOST_" + b.key, b.name, (SPRITE)b.icon, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction t) {
/* 184 */               return b.get((BOOSTABLE_O)t);
/*     */             }
/* 186 */           },  false);
/*     */     } 
/*     */     
/* 189 */     V.push("HAS_BOOST_PERM", "Has Boost", (SPRITE)(UI.icons()).s.question, new BOOLEANO<Faction>()
/*     */         {
/*     */           public boolean is(Faction t) {
/* 192 */             return (GAME.BOOST()).factions.any((INDEXED)t);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 197 */     V.push("IS_PLAYER", "Is Player", (SPRITE)(UI.icons()).s.question, new BOOLEANO<Faction>()
/*     */         {
/*     */           public boolean is(Faction t) {
/* 200 */             return (t == FACTIONS.player());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 205 */     dip(DIP.ALLY());
/* 206 */     dip(DIP.NEUTRAL());
/* 207 */     dip(DIP.OVERLORD());
/* 208 */     dip(DIP.PACT());
/* 209 */     dip(DIP.TRADE());
/* 210 */     dip(DIP.VASSAL());
/* 211 */     dip((DipStance)DIP.WAR());
/*     */     
/* 213 */     V.push("STACE_IS_TRADING", "Trading", (SPRITE)(UI.icons()).s.question, new BOOLEANO<Faction>()
/*     */         {
/*     */           public boolean is(Faction t) {
/* 216 */             if (t instanceof FactionNPC) {
/* 217 */               return (DIP.get((FactionNPC)t)).trades;
/*     */             }
/* 219 */             return false;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 224 */     V.push("STACE_IS_ALLY", "Trading", (SPRITE)(UI.icons()).s.question, new BOOLEANO<Faction>()
/*     */         {
/*     */           public boolean is(Faction t) {
/* 227 */             if (t instanceof FactionNPC) {
/* 228 */               return (DIP.get((FactionNPC)t)).ally;
/*     */             }
/* 230 */             return false;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 235 */     V.push("OPINION_ABS", "Opinion", (SPRITE)(UI.icons()).s.question, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/* 239 */             if (t instanceof FactionNPC) {
/* 240 */               Royalty roy = ((FactionNPC)t).court().king().roy();
/* 241 */               return ROPINION.BOOST().get((SuperBoostableObj)roy);
/*     */             } 
/* 243 */             return 0.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 248 */     V.push("OPINION_REL", "Opinion", (SPRITE)(UI.icons()).s.question, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/* 252 */             if (t instanceof FactionNPC) {
/* 253 */               return ROPINION.get((FactionNPC)t);
/*     */             }
/* 255 */             return 0.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 260 */     for (FResources.RTYPE t : FResources.RTYPE.all) {
/* 261 */       V.push("RESOURCE_ALL_PRODUCED_" + t.name(), "resources " + t.name(), (SPRITE)(UI.icons()).s.storage, (DOUBLE_O<Faction>)new INT_O<Faction>()
/*     */           {
/*     */             public int get(Faction f)
/*     */             {
/* 265 */               int am = Math.max(f.res().in(t).total().get(), f.res().in(t).total().get(1));
/* 266 */               am -= Math.max(f.res().out(t).total().get(), f.res().out(t).total().get(1));
/* 267 */               return am;
/*     */             }
/*     */ 
/*     */             
/*     */             public int min(Faction t) {
/* 272 */               return -2147483647;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Faction t) {
/* 277 */               return Integer.MAX_VALUE;
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void dip(final DipStance dip) {
/* 286 */     GVALUES.FACTION.push("STANCE_" + dip.key(), dip.name, dip.icon, new BOOLEANO<Faction>()
/*     */         {
/*     */           public boolean is(Faction t) {
/* 289 */             if (t instanceof FactionNPC) {
/* 290 */               return dip.is((FactionNPC)t);
/*     */             }
/* 292 */             return false;
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\GValuesInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */