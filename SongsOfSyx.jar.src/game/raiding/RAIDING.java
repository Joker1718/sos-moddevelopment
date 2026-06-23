/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RAIDING
/*     */   extends GAME.GameResource
/*     */ {
/*  32 */   public final int AMOUNT = 100;
/*     */   
/*  34 */   private final ArrayList<Raider> all = new ArrayList(100);
/*  35 */   public final RaidingCurrent current = new RaidingCurrent();
/*  36 */   public final RaidingUtil util = new RaidingUtil(100);
/*     */   
/*  38 */   private final Updater updater = new Updater(this);
/*  39 */   private final UpdaterRegions updaterRegs = new UpdaterRegions();
/*     */   
/*  41 */   public final RaidingMap entry = new RaidingMap();
/*     */   
/*  43 */   private final ACTION init = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  47 */         RAIDING.this.all.clearSloppy();
/*     */         
/*  49 */         double w = (Config.sett()).POP_RAIDER_WORTH * 40000.0D + 2.5E7D / (Config.sett()).POP_RAIDER_WORTH;
/*     */         
/*  51 */         for (int i = 0; i < RAIDING.this.all.max(); i++) {
/*     */           
/*  53 */           double d = i / RAIDING.this.all.max();
/*  54 */           double wealth = 300.0D * (Config.sett()).POP_RAIDER_WORTH + Math.pow(d, 2.1D) * w;
/*  55 */           (GAME.battle()).power.getClass(); double power = 5.0D + (Config.battle()).MEN_PER_ARMY * (1.0D + (5.0D - 1.0D) / 2.0D) * Math.pow(d, 2.75D);
/*     */           
/*  57 */           Raider r = new Raider(wealth, power, CLAMP.d(i / 10.0D, 0.0D, 1.0D));
/*  58 */           RAIDING.this.all.add(r);
/*     */         } 
/*  60 */         RAIDING.this.current.clear();
/*  61 */         RAIDING.this.updater.clear();
/*     */       }
/*     */     };
/*     */   
/*     */   public RAIDING() {
/*  66 */     super("RAIDING", false);
/*     */     
/*  68 */     IDebugPanel.add("RAIDER event", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  72 */             if (RAIDING.this.util.active().size() > 0) {
/*  73 */               Raider r = (Raider)RAIDING.this.util.active().rnd();
/*  74 */               RAIDING.this.current.appear(r);
/*     */             } else {
/*  76 */               LOG.ln("nope");
/*     */             } 
/*     */           }
/*     */         });
/*  80 */     IDebugPanel.add("RAIDER spawn", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  84 */             LIST<RaidingMap.RaidRegion> rr = RAIDING.this.entry.entryRegions();
/*  85 */             if (rr.size() == 0) {
/*     */               return;
/*     */             }
/*  88 */             Region reg = ((RaidingMap.RaidRegion)rr.rnd()).r();
/*  89 */             double power = RAIDING.this.util.defences(reg);
/*  90 */             power *= (1.0F + RND.rFloat(1.0D));
/*  91 */             Raider raider = new Raider(FACTIONS.WORTH().raider(), power, RND.rFloat());
/*  92 */             raider.text.set(raider, true);
/*  93 */             RAIDING.this.current.raid(raider);
/*     */           }
/*     */         });
/*     */     
/*  97 */     IDebugPanel.add("RAIDER appear", new ACTION()
/*     */         {
/*     */           
/*     */           public void exe()
/*     */           {
/* 102 */             LIST<RaidingMap.RaidRegion> rr = RAIDING.this.entry.entryRegions();
/* 103 */             if (rr.size() == 0) {
/*     */               return;
/*     */             }
/* 106 */             Region reg = ((RaidingMap.RaidRegion)rr.rnd()).r();
/* 107 */             double power = RAIDING.this.util.defences(reg);
/* 108 */             power *= (1.0F + RND.rFloat(0.5D));
/* 109 */             Raider raider = new Raider(FACTIONS.WORTH().raider(), power, RND.rFloat());
/* 110 */             raider.text.set(raider, true);
/* 111 */             if (!RAIDING.this.current.appear(raider)) {
/* 112 */               LOG.ln("nope");
/*     */             }
/*     */           }
/*     */         });
/* 116 */     IDebugPanel.add("RAIDER appear cap", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 120 */             Raider raider = new Raider(FACTIONS.WORTH().raider(), (RAIDING.this.util.defences(FACTIONS.player().capitolRegion()) * (1.0F + RND.rFloat(0.5D))), RND.rFloat());
/* 121 */             raider.text.set(raider, true);
/* 122 */             RAIDING.this.current.appear(raider, FACTIONS.player().cx(), FACTIONS.player().cy());
/*     */           }
/*     */         });
/*     */     
/* 126 */     IDebugPanel.add("RAIDER clear", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 130 */             RAIDING.this.current.clear();
/*     */           }
/*     */         });
/*     */     
/* 134 */     IDebugPanel.add("RAIDER mess", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 138 */             Raider raider = new Raider(FACTIONS.WORTH().raider(), (RAIDING.this.util.defences(FACTIONS.player().capitolRegion()) * (1.0F + RND.rFloat(0.5D))), RND.rFloat());
/* 139 */             raider.text.set(raider, RND.rBoolean());
/* 140 */             (new MessArmyAppear(raider, RND.rInt0(100), RND.rInt0(100))).send();
/* 141 */             (new MessCustom(raider, "hello")).send();
/* 142 */             (new MessDefeated(raider)).send();
/* 143 */             (new MessDemand(raider)).send();
/* 144 */             (new MessDemandRejected(raider)).send();
/* 145 */             (new MessDemandTY(raider)).send();
/* 146 */             (new MessGoingAway(raider)).send();
/* 147 */             (new MessVictory(raider)).send();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     IDebugPanel.add("RAIDERS reset", this.init);
/*     */     
/* 156 */     GAME.addOnInit(new ACTION()
/*     */         {
/*     */           
/*     */           public void exe()
/*     */           {
/* 161 */             BValue.BValueAll vv = new BValue.BValueAll()
/*     */               {
/*     */                 public double get()
/*     */                 {
/* 165 */                   if (DIP.overlord((Faction)FACTIONS.player()) != null)
/* 166 */                     return 1.0D; 
/* 167 */                   return 0.0D;
/*     */                 }
/*     */               };
/* 170 */             BSourceInfo s = new BSourceInfo((DIP.VASSAL()).name, (DIP.VASSAL()).icon);
/* 171 */             (new BoosterValue((BValue)vv, s, 0.0D, 4.0D, false)).add((BOOSTABLES.CIVICS()).RAID_SECURITY);
/*     */           }
/*     */         });
/* 174 */     GAME.addOnInit(this.init);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 181 */     for (Raider r : this.all) {
/* 182 */       file.object(r);
/*     */     }
/* 184 */     this.current.save(file);
/* 185 */     this.updater.save(file);
/* 186 */     this.updaterRegs.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 191 */     this.all.clearSloppy();
/* 192 */     boolean fucked = false;
/* 193 */     for (int i = 0; i < 100; i++) {
/* 194 */       Raider r = (Raider)file.object(true);
/* 195 */       if (r == null) {
/* 196 */         fucked = true;
/*     */       } else {
/* 198 */         this.all.add(r);
/*     */       } 
/*     */     } 
/* 201 */     this.current.load(file);
/* 202 */     this.util.clear();
/* 203 */     this.updater.load(file);
/*     */     
/* 205 */     if (fucked) {
/* 206 */       this.init.exe();
/*     */     }
/*     */     
/* 209 */     this.updaterRegs.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void loadFix() {
/* 214 */     int powMax = 0;
/* 215 */     int pp = 0;
/* 216 */     for (Raider r : this.all) {
/* 217 */       if (r.defeated) {
/* 218 */         defeat(r);
/* 219 */         powMax = Math.max(powMax, r.army.power);
/*     */       } 
/* 221 */       if (r.raids > 0)
/* 222 */         pp = Math.max(powMax, pp); 
/*     */     } 
/* 224 */     this.init.exe();
/* 225 */     for (Raider r : ALL()) {
/* 226 */       if (r.army.power <= powMax) {
/* 227 */         r.defeated = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 233 */     prof.logStart(this);
/* 234 */     this.current.update(ds, prof);
/* 235 */     this.updater.update(ds);
/* 236 */     this.updaterRegs.update(ds);
/* 237 */     prof.logEnd(this);
/*     */   }
/*     */   
/*     */   public LIST<Raider> ALL() {
/* 241 */     return (LIST<Raider>)this.all;
/*     */   }
/*     */   
/*     */   void defeat(Raider raider) {
/* 245 */     raider.defeated = true;
/* 246 */     raider.secondDefeated = TIME.currentSecond();
/*     */   }
/*     */   
/*     */   public LIST<Raider> active() {
/* 250 */     return this.util.active();
/*     */   }
/*     */   
/*     */   public void reset() {
/* 254 */     this.init.exe();
/*     */   }
/*     */   
/*     */   public void raid() {
/* 258 */     if (active().size() > 0) {
/* 259 */       Raider r = (Raider)active().rnd();
/* 260 */       r.text.set(r, (r.raids == 0));
/* 261 */       (GAME.raiders()).current.raid(r);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RAIDING.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */