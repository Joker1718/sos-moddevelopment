/*     */ package world.army;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoosterAbs;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.battle.BattleListener;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ public final class ADStats
/*     */ {
/*  26 */   private static CharSequence ¤¤Wins = "Victories";
/*  27 */   private static CharSequence ¤¤Defeats = "Defeats";
/*  28 */   private static CharSequence ¤¤kills = "Enemies Killed";
/*  29 */   private static CharSequence ¤¤losses = "Casualties";
/*  30 */   private static CharSequence ¤¤SiegeWon = "Sieges Won";
/*  31 */   private static CharSequence ¤¤WinsD = "Total amount of victories.";
/*  32 */   private static CharSequence ¤¤DefeatsD = "Total amount of defeats.";
/*  33 */   private static CharSequence ¤¤killsD = "Total amount of enemies killed.";
/*  34 */   private static CharSequence ¤¤lossesD = "Total amount of casualties sustained.";
/*  35 */   private static CharSequence ¤¤SiegeWonD = "Total amount of sieges won.";
/*  36 */   private static CharSequence ¤¤reputation = "Reputation";
/*  37 */   private static CharSequence ¤¤reputationD = "Based on previous and recent victories and defeats. Affects morale on the battlefield.";
/*  38 */   private static CharSequence ¤¤mercy = "Mercy";
/*  39 */   private static CharSequence ¤¤cruelty = "Cruelty";
/*     */   static {
/*  41 */     D.ts(ADStats.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ADStat wins;
/*     */   
/*     */   public final ADStat defeats;
/*     */   public final ADStat kills;
/*     */   public final ADStat losses;
/*     */   public final ADStat siegeWon;
/*     */   private final DOUBLE_O.DOUBLE_OE<WArmy> scoreA;
/*     */   private final DOUBLE_O.DOUBLE_OE<Faction> scoreF;
/*     */   private final DOUBLE_O.DOUBLE_OE<Faction> mercy;
/*     */   private final DOUBLE_O<Faction> cruelty;
/*     */   
/*     */   ADStats(ADInit init) {
/*  57 */     init.dataA.getClass(); this.scoreA = (DOUBLE_O.DOUBLE_OE<WArmy>)new DataO.DataDouble(init.dataA, "STATS_MORALE", new INFO(¤¤reputation, ¤¤reputationD));
/*  58 */     init.dataT.getClass(); this.scoreF = (DOUBLE_O.DOUBLE_OE<Faction>)new DataO.DataDouble(init.dataT, "STATS_MORALE", new INFO(¤¤reputation, ¤¤reputationD));
/*  59 */     init.dataT.getClass(); this.mercy = (DOUBLE_O.DOUBLE_OE<Faction>)new DataO<Faction>.DataDouble(init.dataT, "BATTLE_MERCY", new INFO(¤¤mercy, ¤¤mercy))
/*     */       {
/*     */         public DOUBLE_O.DOUBLE_OE<Faction> setD(Faction t, double d) {
/*  62 */           d = CLAMP.d(d, -1.0D, 1.0D);
/*  63 */           return super.setD(t, d);
/*     */         }
/*     */       };
/*     */     
/*  67 */     GVALUES.FACTION.push("BATTLES_MERCY", (this.mercy.info()).name, (SPRITE)(UI.icons()).s.heart, (DOUBLE_O)this.mercy);
/*     */     
/*  69 */     this.cruelty = new DOUBLE_O<Faction>()
/*     */       {
/*  71 */         INFO info = new INFO(ADStats.¤¤cruelty, ADStats.¤¤cruelty);
/*     */ 
/*     */         
/*     */         public double getD(Faction t) {
/*  75 */           return CLAMP.d(-ADStats.this.mercy.getD(t), 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/*  80 */           return this.info;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  85 */     GVALUES.FACTION.push("BATTLES_REPUTATION", ¤¤reputation, (SPRITE)(UI.icons()).s.arrowUp, (DOUBLE_O)this.scoreF);
/*     */     
/*  87 */     this.wins = new ADStat(init, "BATTLES_WON", ¤¤Wins, ¤¤WinsD);
/*  88 */     this.defeats = new ADStat(init, "BATTLES_LOST", ¤¤Defeats, ¤¤DefeatsD);
/*  89 */     this.kills = new ADStat(init, "BATTLES_ENEMIES_KILLED", ¤¤kills, ¤¤killsD);
/*  90 */     this.losses = new ADStat(init, "BATTLES_CASUALTIES", ¤¤losses, ¤¤lossesD);
/*  91 */     this.siegeWon = new ADStat(init, "BATTLES_SIEGES_WON", ¤¤SiegeWon, ¤¤SiegeWonD);
/*     */     
/*  93 */     AD.moraleFactors().add(new BoosterAbs<WArmy>(new BSourceInfo(¤¤reputation, (SPRITE)(UI.icons()).s.crown), false)
/*     */         {
/*     */           public double to()
/*     */           {
/*  97 */             return 1.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           protected double pget(WArmy o) {
/* 102 */             return ADStats.this.rep().getD(o);
/*     */           }
/*     */ 
/*     */           
/*     */           public double from() {
/* 107 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double getValue(double input) {
/* 112 */             return input;
/*     */           }
/*     */         });
/*     */     
/* 116 */     AD.moraleFactors().add(new BoosterAbs<WArmy>(new BSourceInfo(¤¤reputation, Dic.¤¤global, (SPRITE)(UI.icons()).s.crown), false)
/*     */         {
/*     */           public double to()
/*     */           {
/* 120 */             return 1.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           protected double pget(WArmy o) {
/* 125 */             return ADStats.this.repF().getD(o.faction());
/*     */           }
/*     */ 
/*     */           
/*     */           public double getValue(double input) {
/* 130 */             return input;
/*     */           }
/*     */ 
/*     */           
/*     */           public double from() {
/* 135 */             return 0.0D;
/*     */           }
/*     */         });
/*     */     
/* 139 */     init.updaters.add(new ADInit.Updater()
/*     */         {
/*     */           public void update(Faction f, double ds)
/*     */           {
/* 143 */             double d = ADStats.this.scoreF.getD(f);
/* 144 */             if (d < 0.0D) {
/* 145 */               d += ds / TIME.secondsPerDay() * 10.0D;
/* 146 */               d = CLAMP.d(d, d, 0.0D);
/* 147 */             } else if (d > 1.0D) {
/* 148 */               d -= ds / (TIME.secondsPerDay() * 20);
/* 149 */               d = CLAMP.d(d, 0.0D, d);
/*     */             } 
/* 151 */             ADStats.this.scoreF.setD(f, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public void update(WArmy a, double ds) {
/* 156 */             double d = ADStats.this.scoreA.getD(a);
/* 157 */             if (d < 0.0D) {
/* 158 */               d += ds / TIME.secondsPerDay() * 5.0D;
/* 159 */               d = CLAMP.d(d, d, 0.0D);
/* 160 */             } else if (d > 1.0D) {
/* 161 */               d -= ds / (TIME.secondsPerDay() * 10);
/* 162 */               d = CLAMP.d(d, 0.0D, d);
/*     */             } 
/* 164 */             ADStats.this.scoreA.setD(a, d);
/*     */           }
/*     */         });
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
/*     */   public void report(Faction a, boolean victory, int losses, int kills) {
/* 210 */     this.kills.f.inc(a, kills);
/* 211 */     this.losses.f.inc(a, losses);
/* 212 */     double men = (1 + AD.men(null).faction(a) + losses);
/* 213 */     if (a == FACTIONS.player()) {
/* 214 */       men += (STATS.BATTLE()).DIV.stat().data().get(null);
/*     */     }
/* 216 */     if (victory) {
/* 217 */       double d = 0.25D * kills / men;
/* 218 */       double s = this.scoreF.getD(a);
/* 219 */       s += d;
/* 220 */       s = CLAMP.d(s, -1.0D, 1.0D);
/* 221 */       this.scoreF.setD(a, s);
/* 222 */       this.wins.f.inc(a, 1);
/*     */     } else {
/* 224 */       double d = losses / men;
/* 225 */       double s = this.scoreF.getD(a);
/* 226 */       s -= d;
/* 227 */       s = CLAMP.d(s, -1.0D, 1.0D);
/* 228 */       this.scoreF.setD(a, s);
/* 229 */       this.defeats.f.inc(a, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public DOUBLE_O.DOUBLE_OE<WArmy> rep() {
/* 234 */     return this.scoreA;
/*     */   }
/*     */   
/*     */   public DOUBLE_O.DOUBLE_OE<Faction> repF() {
/* 238 */     return this.scoreF;
/*     */   }
/*     */   
/*     */   public DOUBLE_O.DOUBLE_OE<Faction> mercy() {
/* 242 */     return this.mercy;
/*     */   }
/*     */   
/*     */   public DOUBLE_O<Faction> cruelty() {
/* 246 */     return this.cruelty;
/*     */   }
/*     */   
/*     */   public static class ADStat
/*     */     extends INFO {
/*     */     private INT_O.INT_OE<WArmy> a;
/*     */     private INT_O.INT_OE<Faction> f;
/*     */     
/*     */     ADStat(ADInit init, String key, CharSequence name, CharSequence desc) {
/* 255 */       super(name, desc);
/* 256 */       init.dataA.getClass(); this.a = (INT_O.INT_OE<WArmy>)new DataO.DataInt(init.dataA, key, null, 10000);
/* 257 */       init.dataT.getClass(); this.f = (INT_O.INT_OE<Faction>)new DataO.DataInt(init.dataT, key);
/* 258 */       GVALUES.FACTION.pushI(key, name, (SPRITE)(UI.icons()).s.sword, (INT_O)this.f);
/*     */     }
/*     */     
/*     */     public INT_O<WArmy> a() {
/* 262 */       return (INT_O<WArmy>)this.a;
/*     */     }
/*     */     
/*     */     public INT_O<Faction> f() {
/* 266 */       return (INT_O<Faction>)this.f;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADStats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */