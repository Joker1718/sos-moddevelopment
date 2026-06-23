/*     */ package game.faction.npc;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.stockpile.NPCRes;
/*     */ import game.faction.npc.stockpile.NPCStockpile;
/*     */ import game.faction.royalty.NPCCourt;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.faction.trade.FBUYER;
/*     */ import game.faction.trade.FSELLER;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.Debugger;
/*     */ import util.data.DOUBLE;
/*     */ import world.army.AD;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public final class FactionNPC
/*     */   extends Faction implements BOOSTABLE_O {
/*  39 */   private final ArrayListGrower<NPCResource> res = new ArrayListGrower();
/*     */   
/*  41 */   public final Str nameIntro = new Str(64);
/*  42 */   private final NPCCourt court = new NPCCourt(this, (LISTE)this.res);
/*  43 */   private final FBanner banner = new FBanner(this);
/*  44 */   private final FResources stats = new FResources(4, (TIMECYCLE)TIME.years())
/*     */     {
/*     */       public int getAvailable(TRADABLE t)
/*     */       {
/*  48 */         return (int)FactionNPC.this.stockpile.res(t).amount();
/*     */       }
/*     */     };
/*     */   
/*  52 */   private final FCredits credits = new FCredits(4, (TIMECYCLE)TIME.years());
/*  53 */   public final NPCBonus bonus = new NPCBonus(this, (LISTE<NPCResource>)this.res);
/*  54 */   public final NPCStockpile stockpile = new NPCStockpile(this, (LISTE)this.res, (DOUBLE)this.credits);
/*  55 */   public final NPCRequest request = new NPCRequest(this);
/*     */   private int iteration;
/*     */   public boolean sanctified = false;
/*     */   
/*     */   public FactionNPC(LISTE<Faction> all, UpdaterNPC up) {
/*  60 */     super(all);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generate(RDRace pref, boolean init) {
/*  65 */     this.court.init();
/*  66 */     this.sanctified = false;
/*  67 */     if (pref == null) {
/*  68 */       pref = (RDRace)(RD.RACES()).all.rnd();
/*  69 */       if (capitolRegion() != null) {
/*  70 */         double pop = 0.0D;
/*  71 */         for (RDRace r : (RD.RACES()).all)
/*  72 */           pop += r.pop.growth(capitolRegion()) / (r.race.population()).max; 
/*  73 */         pop *= RND.rFloat();
/*  74 */         for (RDRace r : (RD.RACES()).all) {
/*  75 */           pop -= r.pop.growth(capitolRegion()) / (r.race.population()).max;
/*  76 */           if (pop <= 0.0D) {
/*  77 */             pref = r;
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     this.nameIntro.clear().add(pref.names.intros.next());
/*  87 */     this.name.clear().add(pref.names.fNames.next());
/*  88 */     nameFix(pref);
/*  89 */     this.event = false;
/*     */ 
/*     */     
/*  92 */     if (realm().capitol() != null) {
/*  93 */       (realm().capitol()).info.name().clear().add((CharSequence)this.name);
/*  94 */       this.iteration++;
/*     */       
/*  96 */       this.credits.inc(-this.credits.getD(), FCredits.CTYPE.DIPLOMACY);
/*     */       
/*  98 */       for (NPCResource r : this.res) {
/*  99 */         r.generate(pref, this, init);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void nameFix(RDRace pref) {
/* 106 */     for (int d = 0; d < 100; d++) {
/* 107 */       for (int i = 0; i < FACTIONS.NPCs().size(); i++) {
/* 108 */         FactionNPC fo = (FactionNPC)FACTIONS.NPCs().get(i);
/* 109 */         if (fo.isActive() && fo != this && fo.name.equals(this.name)) {
/* 110 */           this.name.clear().add(pref.names.fNames.next());
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 119 */     return this.court.race();
/*     */   }
/*     */ 
/*     */   
/*     */   public FBUYER buyer(TRADABLE t) {
/* 124 */     return (this.stockpile.res(t)).buyer;
/*     */   }
/*     */ 
/*     */   
/*     */   public FSELLER seller(TRADABLE t) {
/* 129 */     return (this.stockpile.res(t)).seller;
/*     */   }
/*     */   
/*     */   public NPCRes res(TRADABLE t) {
/* 133 */     return this.stockpile.res(t);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 138 */     this.nameIntro.save(file);
/* 139 */     for (NPCResource r : this.res) {
/* 140 */       SAVABLE s = r.saver();
/* 141 */       if (s != null)
/* 142 */         s.save(file); 
/*     */     } 
/* 144 */     file.i(this.iteration);
/* 145 */     this.request.save(file);
/* 146 */     file.bool(this.sanctified);
/* 147 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 152 */     this.nameIntro.load(file);
/* 153 */     for (NPCResource r : this.res) {
/*     */       
/* 155 */       SAVABLE s = r.saver();
/* 156 */       if (s != null)
/* 157 */         s.load(file); 
/*     */     } 
/* 159 */     this.iteration = file.i();
/* 160 */     this.request.load(file);
/* 161 */     this.sanctified = file.bool();
/* 162 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 167 */     for (NPCResource r : this.res) {
/* 168 */       SAVABLE s = r.saver();
/* 169 */       if (s != null)
/* 170 */         s.clear(); 
/*     */     } 
/* 172 */     this.iteration = 0;
/* 173 */     this.request.clear();
/* 174 */     this.sanctified = false;
/* 175 */     super.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 180 */     for (NPCResource r : this.res) {
/* 181 */       r.update(this, ds);
/*     */     }
/* 183 */     this.request.update();
/* 184 */     super.update(ds);
/*     */   }
/*     */   
/*     */   public int getWorkers(RESOURCE res) {
/* 188 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FBanner banner() {
/* 195 */     return this.banner;
/*     */   }
/*     */ 
/*     */   
/*     */   public FCredits credits() {
/* 200 */     return this.credits;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence rulerName() {
/* 205 */     return (CharSequence)(this.court.king()).name;
/*     */   }
/*     */   
/*     */   public NPCCourt court() {
/* 209 */     return this.court;
/*     */   }
/*     */   
/*     */   public int iteration() {
/* 213 */     return this.iteration;
/*     */   }
/*     */ 
/*     */   
/*     */   public FResources res() {
/* 218 */     return this.stats;
/*     */   }
/*     */   
/*     */   public Royalty king() {
/* 222 */     return this.court.king().roy();
/*     */   }
/*     */ 
/*     */   
/*     */   public double boostableValue(BValue v) {
/* 227 */     return v.vGet(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public double offensivePower() {
/* 232 */     return AD.power().get(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int citizens(Race race) {
/* 237 */     if (capitolRegion() == null)
/* 238 */       return 0; 
/* 239 */     if (race == null) {
/* 240 */       return (RD.RACES()).population.get(capitolRegion());
/*     */     }
/* 242 */     RDRace r = RD.RACES().get(race);
/* 243 */     if (r == null)
/* 244 */       return 0; 
/* 245 */     return r.pop.get(capitolRegion());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Debugger d) {
/* 251 */     (GAME.events()).world.dip.debug(d, this);
/* 252 */     d.debugObject(this.request);
/* 253 */     race().kingMessage().debug(d, this);
/* 254 */     DIP.debug(d, this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\FactionNPC.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */