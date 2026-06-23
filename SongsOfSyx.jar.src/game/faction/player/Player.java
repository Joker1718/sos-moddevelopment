/*     */ package game.faction.player;
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.faction.player.emmi.Emissaries;
/*     */ import game.faction.trade.FBUYER;
/*     */ import game.faction.trade.FSELLER;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.trade.PBuyer;
/*     */ import settlement.trade.PSeller;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import world.army.AD;
/*     */ import world.army.WDivMercenary;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public final class Player extends Faction implements BOOSTABLE_O {
/*  40 */   public final PTech tech = new PTech();
/*  41 */   public final PTitles titles = new PTitles(); public final PlayerRaces races;
/*     */   
/*  43 */   private final FResources resources = new FResources(48, (TIMECYCLE)TIME.days())
/*     */     {
/*     */       public int getAvailable(TRADABLE t)
/*     */       {
/*  47 */         int a = t.ps().playerOwned();
/*  48 */         return (int)Math.ceil(a * 0.9D);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  53 */   private final FBanner banner = new FBanner(this);
/*  54 */   private final PLevels level = new PLevels();
/*  55 */   private final PCredits credits = new PCredits();
/*  56 */   public final Emissaries emissaries = new Emissaries();
/*     */   public final PBonusSetting bonusesCustom;
/*     */   private int ri;
/*  59 */   public final PTrade trade = new PTrade();
/*  60 */   public final Str rulerName = (new Str(24)).add("bob");
/*  61 */   public final Str desc = new Str(24);
/*     */   
/*     */   public Player(LISTE<Faction> all) throws IOException {
/*  64 */     super(all);
/*  65 */     this.races = new PlayerRaces();
/*  66 */     this.ri = this.races.get(0).index();
/*     */     
/*  68 */     IDebugPanel.add("add credits", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  72 */             Player.this.credits.inc(50.0D, FCredits.CTYPE.MISC);
/*     */           }
/*     */         });
/*     */     
/*  76 */     IDebugPanel.add("add credits+", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  80 */             Player.this.credits.inc(1.0E7D, FCredits.CTYPE.MISC);
/*     */           }
/*     */         });
/*     */     
/*  84 */     this.bonusesCustom = new PBonusSetting();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRace(Race race) {
/*  89 */     this.ri = race.index;
/*  90 */     this.races.set(race);
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/*  95 */     return (Race)RACES.all().get(this.ri);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 102 */     super.save(file);
/* 103 */     file.i(this.ri);
/* 104 */     this.tech.saver.save(file);
/* 105 */     this.titles.saver.save(file);
/* 106 */     this.level.saver.save(file);
/* 107 */     this.races.saver.save(file);
/* 108 */     this.emissaries.saver.save(file);
/* 109 */     this.bonusesCustom.save(file);
/* 110 */     this.trade.saver.save(file);
/* 111 */     this.rulerName.save(file);
/* 112 */     PlayerColors.saver.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 117 */     super.load(file);
/* 118 */     this.ri = file.i();
/* 119 */     this.ri %= RACES.all().size();
/* 120 */     this.tech.saver.load(file);
/* 121 */     this.titles.saver.load(file);
/* 122 */     this.level.saver.load(file);
/* 123 */     this.races.saver.load(file);
/* 124 */     this.emissaries.saver.load(file);
/* 125 */     this.bonusesCustom.load(file);
/* 126 */     this.trade.saver.load(file);
/* 127 */     this.rulerName.load(file);
/* 128 */     PlayerColors.saver.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 133 */     super.clear();
/* 134 */     this.tech.saver.clear();
/* 135 */     this.titles.saver.clear();
/* 136 */     this.level.saver.clear();
/* 137 */     this.races.saver.clear();
/* 138 */     this.emissaries.saver.clear();
/* 139 */     this.bonusesCustom.clear();
/* 140 */     this.trade.saver.clear();
/* 141 */     PlayerColors.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public PBuyer buyer(TRADABLE tr) {
/* 146 */     return SETT.TRADE().buyer(tr);
/*     */   }
/*     */ 
/*     */   
/*     */   public PSeller seller(TRADABLE t) {
/* 151 */     return SETT.TRADE().seller(t);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 156 */     super.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateSpecial(double ds, Profiler prof) {
/* 161 */     if (capitolRegion() != null) {
/* 162 */       int ex = 0;
/* 163 */       for (Race r : RACES.all()) {
/* 164 */         if (RD.RACES().get(r) == null) {
/* 165 */           ex += (STATS.POP()).POP.data(null).get(r, 0);
/*     */         }
/*     */       } 
/* 168 */       ex /= RACES.all().size() - (RD.RACES()).all.size() + 1;
/*     */       
/* 170 */       for (RDRace rr : (RD.RACES()).all) {
/* 171 */         rr.pop.set(capitolRegion(), (STATS.POP()).POP.data(null).get(rr.race, 0) + ex);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 176 */     prof.logStart(this.tech.getClass());
/* 177 */     this.tech.update(ds);
/* 178 */     prof.logEnd(this.tech.getClass());
/*     */     
/* 180 */     prof.logStart(this.titles.getClass());
/* 181 */     this.titles.update(ds);
/* 182 */     prof.logEnd(this.titles.getClass());
/*     */     
/* 184 */     prof.logStart(this.level.getClass());
/* 185 */     this.level.update(ds);
/* 186 */     prof.logEnd(this.level.getClass());
/*     */     
/* 188 */     prof.logStart(this.emissaries.getClass());
/* 189 */     this.emissaries.update(ds);
/* 190 */     prof.logEnd(this.emissaries.getClass());
/*     */     
/* 192 */     prof.logStart(this.trade.getClass());
/* 193 */     this.trade.update(ds);
/* 194 */     prof.logEnd(this.trade.getClass());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FResources res() {
/* 203 */     return this.resources;
/*     */   }
/*     */ 
/*     */   
/*     */   public FBanner banner() {
/* 208 */     return this.banner;
/*     */   }
/*     */ 
/*     */   
/*     */   public PCredits credits() {
/* 213 */     return this.credits;
/*     */   }
/*     */   
/*     */   public PLevels level() {
/* 217 */     return this.level;
/*     */   }
/*     */   
/*     */   public PTech tech() {
/* 221 */     return this.tech;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence rulerName() {
/* 226 */     return (CharSequence)this.rulerName;
/*     */   }
/*     */   
/*     */   public static final class PlayerRaces
/*     */   {
/* 231 */     private final int[] order = Alloc.ii(RACES.all().size());
/*     */     
/* 233 */     final SAVABLE saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 237 */           file.isE(Player.PlayerRaces.this.order);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 242 */           if (!file.isE(Player.PlayerRaces.this.order)) {
/* 243 */             Player.PlayerRaces.this.set(FACTIONS.player().race());
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void clear() {}
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*     */     void set(Race player) {
/* 255 */       this.order[0] = player.index;
/* 256 */       int playable = 1;
/*     */       
/* 258 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 259 */         Race r = (Race)RACES.all().get(ri);
/* 260 */         if (r != player && r.playable) {
/* 261 */           playable++;
/*     */         }
/*     */       } 
/* 264 */       int i = 1;
/* 265 */       for (int j = 0; j < RACES.all().size(); j++) {
/* 266 */         Race r = (Race)RACES.all().get(j);
/* 267 */         if (r != player && r.playable) {
/* 268 */           this.order[i++] = r.index;
/* 269 */         } else if (r != player) {
/* 270 */           this.order[playable++] = r.index;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     PlayerRaces() {
/* 278 */       int playable = 0;
/* 279 */       for (Race r : RACES.all()) {
/* 280 */         if (r.playable) {
/* 281 */           playable++;
/*     */         }
/*     */       } 
/* 284 */       int i = 0;
/* 285 */       for (Race r : RACES.all()) {
/* 286 */         if (r.playable) {
/* 287 */           this.order[i++] = r.index; continue;
/*     */         } 
/* 289 */         this.order[playable++] = r.index;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void order(Race r, int index) {
/* 297 */       int i = 0;
/* 298 */       for (; i < this.order.length && 
/* 299 */         this.order[i] != r.index; i++);
/*     */ 
/*     */ 
/*     */       
/* 303 */       for (; i < this.order.length - 1; i++) {
/* 304 */         this.order[i] = this.order[i + 1];
/*     */       }
/* 306 */       for (i = this.order.length - 1; i > index; i--) {
/* 307 */         this.order[i] = this.order[i - 1];
/*     */       }
/* 309 */       this.order[index] = r.index;
/*     */     }
/*     */ 
/*     */     
/*     */     public Race get(int index) {
/* 314 */       if (index < 0)
/* 315 */         return null; 
/* 316 */       return (Race)RACES.all().get(this.order[index]);
/*     */     }
/*     */     
/*     */     public int size() {
/* 320 */       return this.order.length;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double boostableValue(BValue v) {
/* 327 */     return v.vGet(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public double offensivePower() {
/* 332 */     double p = AD.power().get(this);
/* 333 */     int creds = (int)FACTIONS.player().credits().getD();
/* 334 */     for (int i = 0; i < AD.mercenaries().max() && creds > 0; i++) {
/* 335 */       WDivMercenary d = AD.mercenaries().get(i);
/* 336 */       if (d.army() == null && !d.disbanded()) {
/* 337 */         int c = AD.mercenaries().signingCost(i) + AD.mercenaries().upkeepCost(i) * 16;
/* 338 */         double dd = creds / c;
/* 339 */         dd = CLAMP.d(dd, 0.0D, 1.0D);
/* 340 */         p += (GAME.battle()).power.get((DIV_SPEC)d);
/* 341 */         creds = (int)(creds - Math.ceil(c * dd));
/*     */       } 
/*     */     } 
/*     */     
/* 345 */     p += (RD.MILITARY()).power.getD(capitolRegion()) - SETT.INVADOR().invadingPower();
/*     */     
/* 347 */     return Math.max(p, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public int citizens(Race race) {
/* 352 */     return (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(race);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\Player.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */