/*     */ package world.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.Dic;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.entity.army.WArmy;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ADConscripts
/*     */ {
/*  26 */   final ArrayList<INT_O.INT_OE<Faction>> total = new ArrayList(RACES.all().size());
/*     */   private final INT_O<Faction> totalAll;
/*  28 */   private final ArrayList<INT_O<Faction>> available = new ArrayList(RACES.all().size());
/*     */   private final INT_O<Faction> availableAll;
/*  30 */   final ArrayList<INT_O.INT_OE<Faction>> used = new ArrayList(RACES.all().size());
/*     */   
/*     */   private final INT_O<Faction> usedAll;
/*     */   
/*     */   public INT_O<Faction> total(Race race) {
/*  35 */     if (race == null)
/*  36 */       return this.totalAll; 
/*  37 */     return (INT_O<Faction>)this.total.get(race.index);
/*     */   }
/*     */   
/*     */   public INT_O<Faction> available(Race race) {
/*  41 */     if (race == null)
/*  42 */       return this.availableAll; 
/*  43 */     return (INT_O<Faction>)this.available.get(race.index);
/*     */   }
/*     */   
/*     */   public INT_O<Faction> used(Race race) {
/*  47 */     if (race == null)
/*  48 */       return this.usedAll; 
/*  49 */     return (INT_O<Faction>)this.used.get(race.index);
/*     */   }
/*     */   
/*     */   public boolean canTrain(Race race, Faction f) {
/*  53 */     if (f == null)
/*  54 */       return true; 
/*  55 */     return (AD.men(race).faction(f) - AD.cityDivs().total(race) < total(race).get(f));
/*     */   }
/*     */   
/*     */   public int canTrainI(Race race, Faction f) {
/*  59 */     if (f == null)
/*  60 */       return 100000; 
/*  61 */     return total(race).get(f) - AD.men(race).faction(f) + AD.cityDivs().total(race);
/*     */   }
/*     */   
/*     */   public void kill(Race race, Faction f, int men) {
/*  65 */     if (f != null)
/*  66 */       ((INT_O.INT_OE)this.total.get(race.index)).inc(f, -men); 
/*     */   }
/*     */   
/*     */   ADConscripts(ADInit init) {
/*  70 */     for (Race r : RACES.all()) {
/*  71 */       this.total.add(new DataO<Faction>.DataInt(init.dataT, "CONSCRIPTABLE_" + r.key, Dic.¤¤Conscriptable, Dic.¤¤ConscriptsD)
/*     */           {
/*     */             public int get(Faction t)
/*     */             {
/*  75 */               if ((r.population()).max <= 0.0D && 
/*  76 */                 t == FACTIONS.player()) {
/*  77 */                 return 0;
/*     */               }
/*     */               
/*  80 */               return super.get(t);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/*  86 */       this.available.add(new INT_O<Faction>()
/*     */           {
/*     */             public int get(Faction t)
/*     */             {
/*  90 */               return ((INT_O.INT_OE)ADConscripts.this.total.get(r.index)).get(t) - ((INT_O.INT_OE)ADConscripts.this.used.get(r.index)).get(t);
/*     */             }
/*     */ 
/*     */             
/*     */             public int min(Faction t) {
/*  95 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Faction t) {
/* 100 */               return Integer.MAX_VALUE;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 105 */       this.used.add(new DataO.DataInt(init.dataT, "CONSCRIPTABLE_USED_" + r.key, Dic.¤¤Conscriptable, Dic.¤¤ConscriptsD));
/*     */     } 
/*     */     
/* 108 */     this.totalAll = tot((LIST)this.total);
/* 109 */     this.availableAll = tot((LIST<? extends INT_O<Faction>>)this.available);
/* 110 */     this.usedAll = tot((LIST)this.used);
/* 111 */     IDebugPanelWorld.add("Conscripts 1000", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 115 */             for (RDRace rr : (RD.RACES()).all) {
/* 116 */               ((INT_O.INT_OE)ADConscripts.this.total.get(rr.race.index)).inc(FACTIONS.player(), 1000);
/*     */             }
/*     */           }
/*     */         });
/* 120 */     init.inits.add(new ACTION.ACTION_O<Faction>()
/*     */         {
/*     */           public void exe(Faction t)
/*     */           {
/* 124 */             for (Race r : RACES.all()) {
/* 125 */               ((INT_O.INT_OE)ADConscripts.this.total.get(r.index())).set(t, RD.MILITARY().conscripts(r, t));
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 130 */     init.registers.add(new ADInit.Register()
/*     */         {
/*     */           public void register(ADDiv div, int d)
/*     */           {
/* 134 */             if (div.needConscripts()) {
/* 135 */               ((INT_O.INT_OE)ADConscripts.this.used.get((div.race()).index)).inc(div.faction(), d * div.menTarget());
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 141 */     init.updaters.add(new ADInit.Updater()
/*     */         {
/*     */           public void update(Faction f, double timeSinceLast)
/*     */           {
/* 145 */             if (f == null || !f.isActive()) {
/*     */               return;
/*     */             }
/* 148 */             for (Race r : RACES.all()) {
/* 149 */               int n = ADConscripts.this.total(r).get(f);
/* 150 */               int t = RD.MILITARY().conscripts(r, f);
/* 151 */               if (t < n) {
/* 152 */                 ((INT_O.INT_OE)(AD.conscripts()).total.get(r.index())).set(f, t);
/*     */                 continue;
/*     */               } 
/* 155 */               double d = (t - n);
/*     */               
/* 157 */               if (d > 0.0D) {
/*     */                 
/* 159 */                 d *= TIME.secondsPerDayI() * timeSinceLast / 8.0D;
/* 160 */                 n += (int)d;
/* 161 */                 if (RND.rFloat() < d - (int)d)
/* 162 */                   n++; 
/* 163 */               } else if (d < 0.0D) {
/* 164 */                 n = t;
/*     */               } 
/*     */               
/* 167 */               n = CLAMP.i(n, 0, t);
/*     */               
/* 169 */               ((INT_O.INT_OE)(AD.conscripts()).total.get(r.index())).set(f, n);
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void update(WArmy a, double timeSinceLast) {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static INT_O<Faction> tot(final LIST<? extends INT_O<Faction>> li) {
/* 186 */     return new INT_O<Faction>()
/*     */       {
/*     */         public int get(Faction t)
/*     */         {
/* 190 */           int am = 0;
/* 191 */           for (INT_O<Faction> f : (Iterable<INT_O<Faction>>)li)
/* 192 */             am += f.get(t); 
/* 193 */           return am;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Faction t) {
/* 198 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Faction t) {
/* 203 */           return Integer.MAX_VALUE;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADConscripts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */