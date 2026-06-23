/*     */ package settlement.stats;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import init.value.GVALUES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class SValues
/*     */ {
/*  31 */   private static CharSequence ¤¤player = "Chosen Race";
/*  32 */   private static CharSequence ¤¤playerIs = "Faction is:";
/*     */   
/*  34 */   private static CharSequence ¤¤oddjobs = "Odd jobs exist";
/*     */   static {
/*  36 */     D.ts(SValues.class);
/*     */   }
/*     */   
/*     */   SValues() {
/*  40 */     for (STAT s : STATS.all()) {
/*  41 */       if (s.key() != null && s.indu() != null) {
/*  42 */         GVALUES.INDU.push(s.key() + "_F", (s.info()).name, ((s.info()).icon == null) ? (SPRITE)(UI.icons()).s.question : (s.info()).icon, (DOUBLE_O)s.indu());
/*  43 */         GVALUES.INDU.pushI(s.key() + "_I", (s.info()).name, ((s.info()).icon == null) ? (SPRITE)(UI.icons()).s.question : (s.info()).icon, (INT_O)s.indu());
/*     */       } 
/*  45 */       if (s.key() != null) {
/*     */         
/*  47 */         String k = s.key();
/*  48 */         if (s.info().isInt()) {
/*  49 */           GVALUES.FACTION.push(k, (s.info()).name, ((s.info()).icon == null) ? (SPRITE)(UI.icons()).s.question : (s.info()).icon, new DOUBLE_O<Faction>()
/*     */               {
/*     */                 public double getD(Faction t)
/*     */                 {
/*  53 */                   return s.data(HCLASSES.CITIZEN()).getD(null) * s.dataDivider();
/*     */                 }
/*     */               }, 
/*  56 */               false); continue;
/*     */         } 
/*  58 */         GVALUES.FACTION.push(k, (s.info()).name, ((s.info()).icon == null) ? (SPRITE)(UI.icons()).s.question : (s.info()).icon, new DOUBLE_O<Faction>()
/*     */             {
/*     */               public double getD(Faction t)
/*     */               {
/*  62 */                 return s.data(HCLASSES.CITIZEN()).getD(null);
/*     */               }
/*     */             }, 
/*  65 */             true);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     SPRITE[] ri = new SPRITE[RACES.all().size()];
/*  73 */     for (Race race : RACES.all()) {
/*  74 */       SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  78 */             (race.appearance()).iconBig.render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*  83 */       ri[race.index] = (SPRITE)imp;
/*     */     } 
/*     */     
/*  86 */     GVALUES.INDU.push("RACE_IS_PLAYER", ¤¤player, (SPRITE)(UI.icons()).s.human, new BOOLEANO<Induvidual>()
/*     */         {
/*     */           public boolean is(Induvidual t)
/*     */           {
/*  90 */             return (t.race() == FACTIONS.player().race());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  95 */     for (Race race : RACES.all()) {
/*  96 */       GVALUES.INDU.push("RACE_" + race.key, race.info.name, ri[race.index], new BOOLEANO<Induvidual>()
/*     */           {
/*     */             public boolean is(Induvidual t)
/*     */             {
/* 100 */               return (t.race() == race);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 106 */     for (HTYPE t : HTYPES.ALL()) {
/* 107 */       GVALUES.INDU.push("TYPE_" + t.key, t.name, (SPRITE)(UI.icons()).s.human, new BOOLEANO<Induvidual>()
/*     */           {
/*     */             public boolean is(Induvidual i)
/*     */             {
/* 111 */               return (i.hType() == t);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 117 */     for (HCLASS t : HCLASSES.ALL()) {
/* 118 */       GVALUES.INDU.push("CLASS_" + t.key, t.name, (SPRITE)(UI.icons()).s.human, new BOOLEANO<Induvidual>()
/*     */           {
/*     */             public boolean is(Induvidual i)
/*     */             {
/* 122 */               return (i.clas() == t);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     GVALUES.FACTION.push("POPULATION", Dic.¤¤Population, (SPRITE)(UI.icons()).s.human, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction o)
/*     */           {
/* 134 */             return POP.tot(null, null);
/*     */           }
/* 137 */         }false);
/*     */     
/* 139 */     GVALUES.FACTION.push("CREDITS", Dic.¤¤Currs, (SPRITE)(UI.icons()).s.money, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction o)
/*     */           {
/* 143 */             return (int)o.credits().getD();
/*     */           }
/*     */         }, 
/* 146 */         false);
/*     */     
/* 148 */     for (HCLASS cl : HCLASSES.ALL()) {
/* 149 */       String k = "POPULATION_" + cl.key;
/* 150 */       GVALUES.FACTION.push(k, cl.names, (SPRITE)cl.icon(), new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction o)
/*     */             {
/* 154 */               return POP.tot(cl, null);
/*     */             }
/* 157 */           }false);
/*     */     } 
/*     */     
/* 160 */     GVALUES.FACTION.push("WORKFORCE", Dic.¤¤Employees, (SPRITE)(UI.icons()).s.hammer, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction o)
/*     */           {
/* 164 */             return STATS.WORK().workforce();
/*     */           }
/*     */         }, 
/* 167 */         false);
/*     */     
/* 169 */     for (Race r : RACES.all()) {
/* 170 */       String k = "POPULATION_" + r.key + "_";
/* 171 */       GVALUES.FACTION.push(k + "_F", r.info.names, ri[r.index], new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction o)
/*     */             {
/* 175 */               double div = POP.tot(null, null);
/* 176 */               if (div == 0.0D)
/* 177 */                 return 0.0D; 
/* 178 */               return POP.tot(null, r) / div;
/*     */             }
/* 182 */           }true);
/* 183 */       GVALUES.FACTION.push(k + "_I", r.info.names, ri[r.index], new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction o)
/*     */             {
/* 187 */               return POP.tot(null, r);
/*     */             }
/* 190 */           }false);
/* 191 */       GVALUES.FACTION.push("FACTION_IS_" + r.key, String.valueOf(¤¤playerIs) + " " + String.valueOf(¤¤playerIs), ri[r.index], new BOOLEANO<Faction>()
/*     */           {
/*     */             public boolean is(Faction t)
/*     */             {
/* 195 */               return (t.race() == r);
/*     */             }
/*     */           });
/*     */       
/* 199 */       for (HCLASS cl : HCLASSES.ALL()) {
/* 200 */         if (!cl.player)
/*     */           continue; 
/* 202 */         GVALUES.FACTION.push(k + k + "_F", String.valueOf(cl.names) + ": " + String.valueOf(cl.names), ri[r.index], new DOUBLE_O<Faction>()
/*     */             {
/*     */               public double getD(Faction o)
/*     */               {
/* 206 */                 double div = POP.tot(null, null);
/* 207 */                 if (div == 0.0D)
/* 208 */                   return 0.0D; 
/* 209 */                 return POP.tot(cl, r) / div;
/*     */               }
/* 213 */             }true);
/* 214 */         GVALUES.FACTION.push(k + k + "_I", String.valueOf(cl.names) + ": " + String.valueOf(cl.names), ri[r.index], new DOUBLE_O<Faction>()
/*     */             {
/*     */               public double getD(Faction o)
/*     */               {
/* 218 */                 return POP.tot(cl, r);
/*     */               }
/* 221 */             }false);
/*     */       } 
/*     */       
/* 224 */       for (HTYPE t : HTYPES.ALL()) {
/* 225 */         GVALUES.FACTION.push(k + "TYPE_" + k + "_F", String.valueOf(t.names) + ": " + String.valueOf(t.names), ri[r.index], new DOUBLE_O<Faction>()
/*     */             {
/*     */               public double getD(Faction o)
/*     */               {
/* 229 */                 double div = (STATS.POP()).POP.data(null).get(null);
/* 230 */                 if (div == 0.0D)
/* 231 */                   return 0.0D; 
/* 232 */                 return (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, t)) / div;
/*     */               }
/* 236 */             }true);
/* 237 */         GVALUES.FACTION.push(k + "TYPE_" + k + "_I", String.valueOf(t.names) + ": " + String.valueOf(t.names), ri[r.index], new DOUBLE_O<Faction>()
/*     */             {
/*     */               public double getD(Faction o)
/*     */               {
/* 241 */                 return (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, t));
/*     */               }
/* 244 */             }false);
/*     */       } 
/*     */     } 
/*     */     
/* 248 */     for (HTYPE t : HTYPES.ALL()) {
/* 249 */       String k = "POPULATION_" + t.key;
/* 250 */       GVALUES.FACTION.push(k + "_I", t.names, (SPRITE)(UI.icons()).s.human, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction o)
/*     */             {
/* 254 */               return STATS.POP().pop(t);
/*     */             }
/*     */           }, 
/* 257 */           false);
/* 258 */       GVALUES.FACTION.push(k + "_F", t.names, (SPRITE)(UI.icons()).s.human, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction o)
/*     */             {
/* 262 */               double div = (STATS.POP()).POP.data(null).get(null);
/* 263 */               if (div == 0.0D)
/* 264 */                 return 0.0D; 
/* 265 */               return STATS.POP().pop(t) / div;
/*     */             }
/*     */           }, 
/* 268 */           true);
/*     */     } 
/*     */     
/* 271 */     for (StatsReligion.StatReligion r : (STATS.RELIGION()).ALL) {
/* 272 */       GVALUES.FACTION.push((STATS.RELIGION()).key + "_" + (STATS.RELIGION()).key + "_F", r.religion.info.name, (SPRITE)r.religion.icon, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction t)
/*     */             {
/* 276 */               return r.followers.data(HCLASSES.CITIZEN()).getD(null);
/*     */             }
/*     */           }, 
/* 279 */           true);
/* 280 */       GVALUES.FACTION.push((STATS.RELIGION()).key + "_" + (STATS.RELIGION()).key + "_I", r.religion.info.name, (SPRITE)r.religion.icon, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction t)
/*     */             {
/* 284 */               return r.followers.data(HCLASSES.CITIZEN()).get(null);
/*     */             }
/*     */           }, 
/* 287 */           false);
/* 288 */       GVALUES.INDU.push((STATS.RELIGION()).key + "_" + (STATS.RELIGION()).key, r.religion.info.name, (SPRITE)r.religion.icon, new DOUBLE_O<Induvidual>()
/*     */           {
/*     */             public double getD(Induvidual t)
/*     */             {
/* 292 */               return (((STATS.RELIGION()).getter.get(t) == r) ? true : false);
/*     */             }
/*     */           }, 
/* 295 */           false, true);
/*     */     } 
/*     */     
/* 298 */     for (HCLASS cl : HCLASSES.ALL()) {
/* 299 */       if (cl.player) {
/* 300 */         GVALUES.FACTION.push("LOYALTY_" + cl.key, String.valueOf(Dic.¤¤Happiness) + ": " + String.valueOf(Dic.¤¤Happiness), (SPRITE)(UI.icons()).s.heart, new DOUBLE_O<Faction>()
/*     */             {
/*     */               public double getD(Faction t)
/*     */               {
/* 304 */                 return STANDINGS.get(cl).current();
/*     */               }
/*     */             }, 
/* 307 */             true);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 313 */     GVALUES.FACTION.push("PLAYER_HAS_ODDJOBS", ¤¤oddjobs, (SPRITE)(UI.icons()).s.hammer, new BOOLEANO<Faction>()
/*     */         {
/*     */           public boolean is(Faction t)
/*     */           {
/* 317 */             return (SETT.PATH()).finders.job.hasAnyJobs(THRONE.coo().x(), THRONE.coo().y());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 322 */     for (RoomEmploymentSimple e : (SETT.ROOMS()).employment.ALLS()) {
/* 323 */       GVALUES.INDU.push("WORK_" + (e.blueprint()).key, e.title, (SPRITE)(e.blueprint()).icon, new BOOLEANO<Induvidual>()
/*     */           {
/*     */             public boolean is(Induvidual i)
/*     */             {
/* 327 */               RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(i);
/* 328 */               return (ins != null && ins.blueprint().employment() == e);
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\SValues.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */