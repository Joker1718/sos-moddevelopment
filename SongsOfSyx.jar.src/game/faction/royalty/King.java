/*     */ package game.faction.royalty;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.player.PLevels;
/*     */ import init.race.Race;
/*     */ import init.religion.Religion;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StrInserter;
/*     */ import util.info.GFORMAT;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ import world.region.updating.RealmBuilder;
/*     */ 
/*     */ public class King {
/*  26 */   public Str name = new Str(64);
/*  27 */   private final Str intro = new Str(64);
/*  28 */   private static final StrInserter<Faction> iins = new StrInserter<Faction>("TITLE")
/*     */     {
/*     */       protected void set(Faction t, Str str)
/*     */       {
/*  32 */         double d = t.realm().regions() / 20.0D;
/*  33 */         int i = (int)(d * FACTIONS.player().level().all().size());
/*  34 */         i = CLAMP.i(i, 0, FACTIONS.player().level().all().size() - 1);
/*  35 */         str.add(((PLevels.Level)FACTIONS.player().level().all().get(i)).male);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private final NPCCourt court;
/*     */   
/*     */   public final RealmBuilder builder;
/*     */ 
/*     */   
/*     */   void init() {
/*  46 */     Royalty roy = (Royalty)this.court.all().get(0);
/*  47 */     RDRace.RDNames nn = (RD.RACES().get(roy.induvidual.race())).names;
/*  48 */     this.name.clear().add(nn.rNames.next());
/*  49 */     this.name.s();
/*  50 */     GFORMAT.toNumeral(this.name, RND.rInt(16));
/*  51 */     this.intro.clear().add(nn.rIntro.next());
/*     */   }
/*     */ 
/*     */   
/*     */   void save(FilePutter file) {
/*  56 */     this.name.save(file);
/*  57 */     this.intro.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(NPCCourt c, FileGetter file) throws IOException {
/*  62 */     this.name.load(file);
/*  63 */     this.intro.load(file);
/*     */   }
/*     */   
/*     */   public Royalty roy() {
/*  67 */     return (Royalty)this.court.all().get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Str intro(Str str) {
/*  72 */     str.add((CharSequence)this.intro);
/*  73 */     iins.insert(this.court.faction, str);
/*  74 */     return str;
/*     */   }
/*     */   
/*     */   public double garrison() {
/*  78 */     return 0.5D + (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)(roy()).induvidual) * 0.5D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double size() {
/*  83 */     double c = 0.75D * (BOOSTABLES.NOBLE()).COMPETANCE.get((BOOSTABLE_O)(roy()).induvidual);
/*  84 */     return CLAMP.d(c, 0.0D, 1.0D);
/*     */   }
/*     */   King(NPCCourt court) {
/*  87 */     this.builder = new RealmBuilder()
/*     */       {
/*     */         public double priority(Religion religion, Region reg)
/*     */         {
/*  91 */           if (((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get((King.this.roy()).induvidual)).religion == religion)
/*  92 */             return 1.0D; 
/*  93 */           return (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)(King.this.roy()).induvidual);
/*     */         }
/*     */ 
/*     */         
/*     */         public double priority(TRADABLE res, Region reg) {
/*  98 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double policy(Race race, Region reg) {
/* 103 */           double add = (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)(King.this.roy()).induvidual) - 1.0D;
/* 104 */           if (race == (King.this.roy()).induvidual.race())
/* 105 */             return (4 * (RD.RACES()).all.size()) - add * (RD.RACES()).all.size(); 
/* 106 */           return -1.0D + (King.this.roy()).induvidual.race().pref().race(race) + add;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double military(Region reg) {
/* 114 */           double ran = RD.RAN().get(reg, 9, 8) / 255.0D;
/* 115 */           double v = 0.75D + (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)(King.this.roy()).induvidual) * 0.25D;
/* 116 */           ran = 0.5D + ran * 0.5D;
/* 117 */           v *= ran;
/* 118 */           return v;
/*     */         }
/*     */ 
/*     */         
/*     */         public double size() {
/* 123 */           double c = 0.125D * (BOOSTABLES.NOBLE()).COMPETANCE.get((BOOSTABLE_O)(King.this.roy()).induvidual);
/* 124 */           return CLAMP.d(c, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     this.court = court;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\King.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */